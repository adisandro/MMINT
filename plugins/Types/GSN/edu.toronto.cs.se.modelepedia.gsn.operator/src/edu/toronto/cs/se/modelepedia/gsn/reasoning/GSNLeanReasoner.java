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
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.lean.operators.ToLean;
import edu.toronto.cs.se.mmint.lean.reasoning.LeanReasoner;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.ContextualElement;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.Property;
import edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNLeanEncoder.PropertyTemplate;
import edu.toronto.cs.se.modelepedia.gsn.util.PropertyBuilder;

public class GSNLeanReasoner extends LeanReasoner implements IGSNDecompositionTrait {

  private final static String FEEDBACK_PROPERTY_HINT = "HINT";

  @Override
  public String getName() {
    return "Lean/GSN";
  }

  @Override
  public Map<String, List<PropertyTemplate>> getTemplateProperties(Model model) throws MMINTException {
    var templates = new LinkedHashMap<String, List<PropertyTemplate>>();
    var encoder = MIDTypeHierarchy.<ToLean>getPolyOperator(LeanReasoner.ENCODER_ID, ECollections.newBasicEList(model));
    if (encoder.operator() instanceof IGSNLeanEncoder gsnEncoder) {
      gsnEncoder.getTemplateProperties()
        .forEach(t -> templates.computeIfAbsent(t.category, k -> new ArrayList<>()).add(t));
    }
    templates.computeIfAbsent(PropertyTemplate.CUSTOM.category, k -> new ArrayList<>()).add(PropertyTemplate.CUSTOM);

    return templates;
  }

  private List<String> getSubProperties(PropertyDecompositionStrategy strategy) throws MMINTException {
    var subProperties = strategy.getSupportedBy().stream()
      .map(SupportedBy::getTarget)
      .filter(g -> g instanceof PropertyGoal)
      .filter(g -> ((PropertyGoal) g).getReasonerName().equals(getName()))
      .map(g -> ((PropertyGoal) g).getProperty().getFormal())
      .filter(p -> p != null)
      .collect(Collectors.toList());
    if (subProperties.size() == 0) {
      throw new MMINTException("A property must be decomposed into sub-properties");
    }

    return subProperties;
  }

  private String getRelatedModelPath(PropertyDecompositionStrategy strategy) throws MMINTException {
    var relatedModelPath = strategy.getInContextOf().stream()
      .map(InContextOf::getContext)
      .filter(c -> c instanceof Context)
      .map(ContextualElement::getDescription)
      .findAny()
      .orElseThrow(() ->
        new MMINTException("The property decomposition strategy is missing a context pointing to the related model"));
    if (!FileUtils.isFile(relatedModelPath, true)) {
      throw new MMINTException("The context description is not a path to a valid file");
    }

    return relatedModelPath;
  }

  @Override
  public void validatePropertyDecomposition(PropertyDecompositionStrategy strategy) throws Exception {
    var property = strategy.getProperty().getFormal();
    var subProperties = getSubProperties(strategy);
    var relatedModelPath = getRelatedModelPath(strategy);
    var gsnModel = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(strategy);
    var instanceMID = gsnModel.getMIDContainer();
    var relatedModel = instanceMID.<Model>getExtendibleElement(relatedModelPath);
    var invalidMsg = "The property decomposition is not valid";
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
      var encoder = MIDTypeHierarchy.<ToLean>getPolyOperator(LeanReasoner.ENCODER_ID,
                                                             ECollections.newBasicEList(relatedModel));
      var propEncoding = (encoder.operator() instanceof IGSNLeanEncoder gsnEncoder) ?
        gsnEncoder.encodePropertyDecomposition(relatedModel, property, subProperties) :
        new IGSNLeanEncoder(){}.encodePropertyDecomposition(relatedModel, property, subProperties);
      var timestampPath = new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis()) +
                          "_" + LeanReasoner.LEAN_DIR;
      var workingPath = FileUtils.replaceLastSegmentInPath(relatedModel.getUri(), timestampPath);
      var workingPath2 = Path.of(FileUtils.prependWorkspacePath(workingPath));
      Files.createDirectory(workingPath2);
      // run lean
      valid = checkProperty(encoder, propEncoding, workingPath);
      var outputFile = encoder.operator().getOutputFileName().filter(f -> FileUtils.isFile(workingPath + f, true));
      justDesc = (outputFile.isPresent()) ?
        "see output file '" + timestampPath + outputFile.get() + "'" :
        "see directory '" + timestampPath + "'";
      if (!valid && outputFile.isPresent()) {
        // parse failed proof to find the bad sub-properties
        var outputPath = workingPath2.resolve(outputFile.get());
        var feedbackLines = Files.lines(outputPath)
          .map(l -> l.strip())
          .filter(l -> l.startsWith(LeanReasoner.LEAN_COMMENT))
          .map(l -> l.substring(LeanReasoner.LEAN_COMMENT.length()).stripLeading())
          .collect(Collectors.toList());
        var badProperties = new ArrayList<String>();
        var hintProperties = new ArrayList<String>();
        List<String> properties;
        for (var feedback : feedbackLines) {
          if (feedback.startsWith(GSNLeanReasoner.FEEDBACK_PROPERTY_HINT)) {
            properties = hintProperties;
            feedback = feedback.substring(GSNLeanReasoner.FEEDBACK_PROPERTY_HINT.length()).stripLeading();
          }
          else {
            properties = badProperties;
          }
          feedback = feedback.substring(0, feedback.indexOf(" "));
          properties.add(feedback);
        }
        if (!badProperties.isEmpty()) {
          var badInformals = strategy.getSupportedBy().stream()
            .map(SupportedBy::getTarget)
            .filter(g -> g instanceof PropertyGoal)
            .map(g -> ((PropertyGoal) g).getProperty())
            .filter(p -> badProperties.stream().anyMatch(bp -> p.getFormal().startsWith(bp)))
            .map(Property::getInformal)
            .collect(Collectors.toList());
          if (!badInformals.isEmpty()) {
            var propertyWord = (badInformals.size() > 1) ? "properties" : "property";
            var objWord = (badInformals.size() > 1) ? "them" : "it";
            invalidMsg += " because of the " + propertyWord + " '" + String.join(", ", badInformals) +
                          "'. Consider changing " + objWord + " and validating the decomposition again.";
            if (!hintProperties.isEmpty()) {
              invalidMsg += "\n(hint: using '" + String.join(", ", hintProperties) + "' instead may work)";
            }
          }
        }
      }
    }
    // create justification
    var proof = (valid) ? "proven" : "disproven";
    var builder = new PropertyBuilder((SafetyCase) strategy.eContainer());
    var justId = "J-" + strategy.getId();
    justDesc = "Decomposition validity " + proof + " in " + getName() + ": " + justDesc;
    builder.createJustification(strategy, justId, justDesc);
    builder.commitChanges();
    if (!valid) {
      throw new MMINTException(invalidMsg);
    }
  }
}
