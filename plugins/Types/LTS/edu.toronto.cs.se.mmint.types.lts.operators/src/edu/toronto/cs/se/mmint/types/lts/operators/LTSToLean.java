/*******************************************************************************
 * Copyright (c) 2020, 2025 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.types.lts.operators;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNLeanEncoder;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNLeanEncoder.PropertyVariable.VariableEncoder;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNLeanEncoder.PropertyVariable.VariableEncoding;
import edu.toronto.cs.se.mmint.types.lts.LTSPackage;
import edu.toronto.cs.se.mmint.types.lts.LabeledElement;
import edu.toronto.cs.se.mmint.types.lts.State;

public class LTSToLean extends ToLean implements IGSNLeanEncoder {

  private final static String LEAN_AUX_FILE = "auxi" + ToLean.LEAN_EXT;
  private final static int GROUP_THRESHOLD = 100;

  @Override
  public List<String> getImportPaths() {
    return List.of("LTS", "property_catalogue");
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) throws Exception {
    super.init(inputsByName, outputMIDsByName);
    this.leanGenerator = new LTSToLeanAcceleo(this.input.model.getEMFInstanceRoot(), this.output.leanFolder,
                                              List.of(this.input.model.getName(), ToLean.LEAN_SANITIZE_REGEXP,
                                                      LTSToLean.GROUP_THRESHOLD));
    // auxiliary declarations
    //TODO MMINT[LEAN] Split model+property into model+libs+property, where libs is gsn stuff and aux belongs there
    var auxPath = FileUtils.replaceLastSegmentInPath(this.input.model.getUri(), LTSToLean.LEAN_AUX_FILE);
    if (FileUtils.isFile(auxPath, true)) {
      Files.move(Path.of(FileUtils.prependWorkspacePath(auxPath)),
                 Path.of(FileUtils.prependWorkspacePath(getWorkingPath()) + IPath.SEPARATOR + LTSToLean.LEAN_AUX_FILE),
                 StandardCopyOption.REPLACE_EXISTING);
    }
  }

  public static int getIndex(LabeledElement labeled) {
    var emfUri = EcoreUtil.getURI(labeled).toString();
    return Integer.valueOf(emfUri.substring(emfUri.lastIndexOf('.') + 1));
  }

  @Override
  public List<PropertyTemplate> getPropertyTemplates(Model model) {
    final VariableEncoder encoder = (modelObjs) -> {
      var formals = new ArrayList<List<String>>();
      var informals = new ArrayList<String>();
      List<String> currFormals = null;
      for (var i = 0; i < modelObjs.size(); i++) {
        var modelObj = modelObjs.get(i);
        if (i % LTSToLean.GROUP_THRESHOLD == 0) {
          currFormals = new ArrayList<>();
          formals.add(currFormals);
        }
        var sanitizedLabel = ((LabeledElement) modelObj).getLabel().replaceAll(ToLean.LEAN_SANITIZE_REGEXP, "_");
        var j = getIndex((LabeledElement) modelObj) / LTSToLean.GROUP_THRESHOLD;
        var formal = (modelObj instanceof State) ?
          "(S.cons" + j + " state" + j + "." + sanitizedLabel + ")" :
          "(A.cons" + j + " action" + j + "." + sanitizedLabel + ")";
        currFormals.add(formal);
        informals.add(sanitizedLabel);
      }
      var useAux = modelObjs.size() > LTSToLean.GROUP_THRESHOLD;
      if (useAux) {
        var modelName = model.getName();
        var auxType = (modelObjs.get(0) instanceof State) ? "S" : "Act";
        var aux = "import " + modelName;
        var auxSets = new ArrayList<String>();
        for (var i = 0; i < formals.size(); i++) {
          var auxSet = "aux_set" + (i+1);
          auxSets.add(auxSet);
          aux += "\n\ndef " + auxSet + " : set " + modelName + "." + auxType + " := {\n" + String.join(",\n", formals.get(i)) + "}";
        }
        aux += "\n\ndef aux_set : set " + modelName + "." + auxType + " := " + String.join(" ∪ ", auxSets);
        var modelPath = MIDRegistry.getModelUri(modelObjs.get(0));
        var auxPath = FileUtils.replaceLastSegmentInPath(modelPath, LTSToLean.LEAN_AUX_FILE);
        try {
          Files.writeString(Path.of(FileUtils.prependWorkspacePath(auxPath)), aux, StandardOpenOption.CREATE);
        }
        catch (IOException e) {
          useAux = false;
          for (var i = 1; i < formals.size(); i++) {
            formals.get(0).addAll(formals.get(i));
          }
        }
      }
      var type = (modelObjs.get(0) instanceof State) ? "states" : "acts";
      var formula = (useAux) ? "aux_set" : "{" + String.join(", ", formals.get(0)) + "}";
      return new VariableEncoding("(formula." + type + " " + formula + ")", String.join(", ", informals));
    };
    var validTypes = Set.<EClass>of(LTSPackage.eINSTANCE.getLabeledElement());
    var x = new PropertyVariable("$X", validTypes, encoder);
    var y = new PropertyVariable("$Y", validTypes, encoder);
    var a = new PropertyVariable("$A", validTypes, encoder);
    var b = new PropertyVariable("$B", validTypes, encoder);
    var absent1 = new PropertyTemplate("absent.globally $X",
                                       "$X is not reached",
                                       "Absence", List.of(x));
    var absent2 = new PropertyTemplate("absent.before $X $A",
                                       "$X is not reached before $A",
                                       "Absence", List.of(x, a));
    var absent3 = new PropertyTemplate("absent.after $X $B",
                                       "$X is not reached after $B",
                                       "Absence", List.of(x, b));
    var absent4 = new PropertyTemplate("absent.between $X $A $B",
                                       "$X is not reached between $A and $B",
                                       "Absence", List.of(x, a, b));
    var absent5 = new PropertyTemplate("absent.after_until $X $A $B",
                                       "$X is not reached after $A and until $B",
                                       "Absence", List.of(x, a, b));
    var exist1  = new PropertyTemplate("exist.globally $X",
                                       "$X is reached",
                                       "Existence", List.of(x));
    var exist2  = new PropertyTemplate("exist.before $X $A",
                                       "$X is reached before$A",
                                       "Existence", List.of(x, a));
    var exist3  = new PropertyTemplate("exist.after $X $B",
                                       "$X is reached after $B",
                                       "Existence", List.of(x, b));
    var exist4  = new PropertyTemplate("exist.between $X $A $B",
                                       "$X is reached between $A and $B",
                                       "Existence", List.of(x, a, b));
    var exist5  = new PropertyTemplate("exist.after_until $X $A $B",
                                       "$X is reached after $A and until $B",
                                       "Existence", List.of(x, a, b));
    var univ1   = new PropertyTemplate("universal.globally $X",
                                       "$X and only $X is reached",
                                       "Universal", List.of(x));
    var univ2   = new PropertyTemplate("universal.before $X $A",
                                       "$X and only $X is reached before $A",
                                       "Universal", List.of(x, a));
    var univ3   = new PropertyTemplate("universal.after $X $B",
                                       "$X and only $X is reached after $B",
                                       "Universal", List.of(x, b));
    var univ4   = new PropertyTemplate("universal.between $X $A $B",
                                       "$X and only $X is reached between $A and $B",
                                       "Universal", List.of(x, a, b));
    var univ5   = new PropertyTemplate("universal.after_until $X $A $B",
                                       "$X and only $X is reached after $A and until $B",
                                       "Universal", List.of(x, a, b));
    var prec1   = new PropertyTemplate("precedes.globally $X $Y",
                                       "If $Y is reached, $X must precede $Y",
                                       "Precedence", List.of(x, y));
    var prec2   = new PropertyTemplate("precedes.before $X $Y $A",
                                       "If $Y is reached before $A, $X must precede $Y",
                                       "Precedence", List.of(x, y, a));
    var prec3   = new PropertyTemplate("precedes.after $X $Y $B",
                                       "If $Y is reached after $B, $X must precede $Y",
                                       "Precedence", List.of(x, y, b));
    var prec4   = new PropertyTemplate("precedes.between $X $Y $A $B",
                                       "If $Y is reached between $A and $B, $X must precede $Y",
                                       "Precedence", List.of(x, y, a, b));
    var prec5   = new PropertyTemplate("precedes.after_until $X $Y $A $B",
                                       "If $Y is reached between $A and until $B, $X must precede $Y",
                                       "Precedence", List.of(x, y, a, b));
    var resp1   = new PropertyTemplate("responds.globally $X $Y",
                                       "If $X is reached, $Y must follow $X",
                                       "Response", List.of(x, y));
    var resp2   = new PropertyTemplate("responds.before $X $Y $A",
                                       "If $X is reached before $A, $Y must follow $X",
                                       "Response", List.of(x, y, a));
    var resp3   = new PropertyTemplate("responds.after $X $Y $B",
                                       "If $X is reached after $B, $Y must follow $X",
                                       "Response", List.of(x, y, b));
    var resp4   = new PropertyTemplate("responds.between $X $Y $A $B",
                                       "If $X is reached between $A and $B, $Y must follow $X",
                                       "Response", List.of(x, y, a, b));
    var resp5   = new PropertyTemplate("responds.after_until $X $Y $A $B",
                                       "If $X is reached between $A and until $B, $Y must follow $X",
                                       "Response", List.of(x, y, a, b));
    var misc1   = new PropertyTemplate("init_state $X",
                                       "Begin from $X",
                                       "Transitions", List.of(x));
    var misc2   = new PropertyTemplate("not_init $X",
                                       "Do not begin from $X",
                                       "Transitions", List.of(x));
    var misc3   = new PropertyTemplate("holds_over_transition $X",
                                       "Never transition out of $X",
                                       "Transitions", List.of(x));
    var misc4   = new PropertyTemplate("transitions_safe $X",
                                       "Never transition into $X",
                                       "Transitions", List.of(x));

    return List.of(absent1, absent2, absent3, absent4, absent5,
                   exist1,  exist2,  exist3,  exist4,  exist5,
                   univ1,   univ2,   univ3,   univ4,   univ5,
                   prec1,   prec2,   prec3,   prec4,   prec5,
                   resp1,   resp2,   resp3,   resp4,   resp5,
                   misc1,   misc2,   misc3,   misc4);
  }

  private String encodeProperty(String property) {
    return "(λ π, π ⊨ " + property + ")";
  }

  @Override
  public String encodePropertyDecomposition(Model model, String property, List<String> subProperties) {
    var modelName = model.getName();
    var encoding =
      "property.input.mk\n" +
      "(Claim.make\n" +
        "{x : path " + modelName + " | true}\n" +
        encodeProperty(property) + "\n" +
      ")\n" +
      "([\n";
    encoding += subProperties.stream()
      .map(p -> encodeProperty(p))
      .collect(Collectors.joining(",\n"));
    encoding += "\n])\n";

    return encoding;
  }
}
