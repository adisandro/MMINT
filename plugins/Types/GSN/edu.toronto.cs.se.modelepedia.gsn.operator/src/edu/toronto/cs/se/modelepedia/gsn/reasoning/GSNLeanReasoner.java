/*******************************************************************************
 * Copyright (c) 2020, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.reasoning;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.lean.reasoning.LeanReasoner;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNLeanEncoder.PropertyTemplate;
import edu.toronto.cs.se.modelepedia.gsn.util.PropertyBuilder;

public class GSNLeanReasoner extends LeanReasoner implements IGSNDecompositionTrait {

  @Override
  public String getName() {
    return "Lean/GSN";
  }

  @Override
  public Map<String, List<PropertyTemplate>> getTemplateProperties(Model model) throws MMINTException {
    var templates = new LinkedHashMap<String, List<PropertyTemplate>>();
    var encoder = (ToLean) MIDTypeHierarchy.getPolyOperator(LeanReasoner.ENCODER_ID, ECollections.newBasicEList(model));
    if (encoder instanceof IGSNLeanEncoder) {
      ((IGSNLeanEncoder) encoder).getTemplateProperties()
        .forEach(t -> templates.computeIfAbsent(t.category, k -> new ArrayList<>()).add(t));
    }
    templates.computeIfAbsent(PropertyTemplate.CUSTOM.category, k -> new ArrayList<>()).add(PropertyTemplate.CUSTOM);

    return templates;
  }

  @Override
  public void validatePropertyDecomposition(PropertyDecompositionStrategy strategy, String relatedModelPath,
                                            String property, List<String> subProperties) throws Exception {
    var gsnModel = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(strategy);
    var instanceMID = gsnModel.getMIDContainer();
    var relatedModel = instanceMID.<Model>getExtendibleElement(relatedModelPath);
    boolean valid;
    String justDesc;
    if (relatedModel == null) { // custom Lean encoding file
      // run lean as-is
      var workingPath = FileUtils.getAllButLastSegmentFromPath(relatedModelPath);
      var encodingFileName = FileUtils.getLastSegmentFromPath(relatedModelPath);
      var propEncoding = new IGSNLeanEncoder(){}.encodePropertyDecomposition(null, property, subProperties);
      valid = checkProperty(encodingFileName, propEncoding, workingPath);
      justDesc = "see file '" + relatedModelPath + "'";
    }
    else { // use ToLean encoder
      // set up working directory to store encoding
      var encoder = (ToLean) MIDTypeHierarchy.getPolyOperator(LeanReasoner.ENCODER_ID,
                                                              ECollections.newBasicEList(relatedModel));
      var gsnEncoder = (encoder instanceof IGSNLeanEncoder) ? (IGSNLeanEncoder) encoder : new IGSNLeanEncoder(){};
      var propEncoding = gsnEncoder.encodePropertyDecomposition(relatedModel, property, subProperties);
      var timestampPath = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis()) +
                          "_" + LeanReasoner.LEAN_DIR;
      var workingPath = FileUtils.replaceLastSegmentInPath(relatedModel.getUri(), timestampPath);
      Files.createDirectory(Path.of(FileUtils.prependWorkspacePath(workingPath)));
      // run lean
      valid = checkProperty(relatedModel, propEncoding, workingPath);
      var outputPath = encoder.getOutputFileName();
      justDesc = (outputPath.isPresent()) ?
        "see output file '" + timestampPath + outputPath.get() + "'" :
        "see directory '" + timestampPath + "'";
    }
    // create justification
    var proof = (valid) ? "proven" : "disproven";
    var builder = new PropertyBuilder((SafetyCase) strategy.eContainer());
    var justId = "J-" + strategy.getId();
    justDesc = "Decomposition validity " + proof + " in " + getName() + ": " + justDesc;
    builder.createJustification(strategy, justId, justDesc);
    builder.commitChanges();
    if (!valid) {
      throw new MMINTException("The property decomposition is not valid");
    }
  }
}
