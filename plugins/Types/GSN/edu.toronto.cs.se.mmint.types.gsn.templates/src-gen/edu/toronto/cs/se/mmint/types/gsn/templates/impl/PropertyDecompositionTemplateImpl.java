/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.FileExtensionsDialogFilter;
import edu.toronto.cs.se.mmint.mid.ui.FilesOnlyDialogSelectionValidator;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDTreeSelectionDialog;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.Property;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNDecompositionTrait;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNLeanEncoder.PropertyTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.DecompositionUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PropertyDecompositionTemplateImpl extends DecompositionTemplateImpl implements PropertyDecompositionTemplate {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyDecompositionTemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.PROPERTY_DECOMPOSITION_TEMPLATE;
  }

  /**
   * @generated NOT
   */
  private String getEncodingFile(String title, String message) throws MIDDialogCancellation {
    var dialog = new MIDTreeSelectionDialog(new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider(),
                                            ResourcesPlugin.getWorkspace().getRoot());
    dialog.addFilter(new FileExtensionsDialogFilter(Set.of("lean")));
    dialog.setValidator(new FilesOnlyDialogSelectionValidator("Lean file selected", "Please select a Lean file"));
    var encodingFile = (IFile) MIDDialogs.openTreeDialog(dialog, title, message);

    return encodingFile.getFullPath().toString();
  }

  /**
   * @generated NOT
   */
  private void createQueryContext(DecomposableCoreElement contextualized, String query, String id, int numCtx,
                                  Map<String, Context> contexts, EList<ArgumentElement> templateElements,
                                  GSNTemplatesBuilder builder) {
    var context = contexts.get(query);
    if (context == null) {
      var desc = "Query '" + query + "'";
      try {
        var message = "You may enter a description for query '" + query + "' for documentation purposes";
        desc += ": " + MIDDialogs.getStringInput("Property Decomposition", message, null);
      }
      catch (MIDDialogCancellation e) {
        // continue without user description
      }
      context = builder.createContext("Ctx" + (numCtx+1+contexts.size()) + "." + id, desc);
      templateElements.add(context);
      contexts.put(query, context);
    }
    builder.addInContextOf(contextualized, context);
  }

  /**
   * @generated NOT
   */
  @Override
  public void decompose(Goal decomposed, GSNTemplatesBuilder builder) throws Exception {
    // ask for input
    var title = "Property Decomposition";
    var customMsg = "Insert a description for the custom property";
    var reasoner = MIDDialogs.selectReasoner(IGSNDecompositionTrait.class, "GSN property decomposition", null);
    var reasonerName = reasoner.getName();
    var relatedModelOpt = DecompositionUtils.getRelatedModel(decomposed);
    var propTemplates = Map.<String, List<PropertyTemplate>>of();
    var modelObjs = Map.<EClass, List<EObject>>of();
    var queryCache = new HashMap<String, List<Object>>();
    var queryContexts = new HashMap<String, Context>();
    String relatedModelPath;
    Property property;
    List<String> propQueries = List.of();
    var encodingMsg = ", please manually select a " + reasonerName + " file";
    if (relatedModelOpt.isEmpty()) { // no related model: ask to manually provide an encoding
      relatedModelPath = getEncodingFile(title, "No related model found" + encodingMsg);
    }
    else {
      var relatedModel = relatedModelOpt.get();
      try {
        propTemplates = reasoner.getPropertyTemplates(relatedModel);
        modelObjs = DecompositionUtils.categorizeModelObjects(relatedModel, propTemplates);
        relatedModelPath = relatedModel.getUri();
      }
      catch (MMINTException e) { // no model encoder: ask to manually provide an encoding
        relatedModelPath = getEncodingFile(title, "Related model does not have a " + reasonerName + " encoder" +
                                           encodingMsg);
      }
    }
    if (decomposed instanceof PropertyGoal propDecomposed) { // decomposition chain, parent property exists
      property = propDecomposed.getProperty();
    }
    else {
      var propTemplate = DecompositionUtils.selectPropertyTemplate(title, "Select the property to be decomposed",
                                                                   propTemplates);
      if (propTemplate == PropertyTemplate.CUSTOM) {
        property = builder.createProperty(title, "Insert the " + reasonerName + " property to be decomposed",
                                          customMsg);
      }
      else {
        var result = propTemplate.bindVariables(title, modelObjs, queryCache);
        property = result.property();
        propQueries = result.queries();
      }
    }
    // customize decomposition
    var templateSC = (SafetyCase) eContainer();
    var safetyGoal = templateSC.getGoals().get(0);
    var propGoal = templateSC.getGoals().get(1);
    var formalGoal = templateSC.getGoals().get(2);
    var modelGoal = templateSC.getGoals().get(3);
    var subPropGoalN = (PropertyGoal) templateSC.getGoals().get(4);
    var formalStrategy = templateSC.getStrategies().get(0);
    var propStrategy = (PropertyDecompositionStrategy) templateSC.getStrategies().get(1);
    var propCtx = templateSC.getContexts().get(0);
    var modelCtx = templateSC.getContexts().get(1);
    var formalJust = templateSC.getJustifications().get(0);
    propStrategy.getSupportedBy().clear(); // the real subPropGoals will be added later
    propStrategy.getInContextOf().remove(1); // the real formalJust will be added by the validation
    var templateElements = getElements();
    templateElements.remove(safetyGoal);
    templateElements.remove(formalJust);
    templateElements.remove(subPropGoalN);
    var placeholderId = "CX";
    var decomposedId = decomposed.getId();
    Strategy chainedStrategy;
    int numCtx;
    int numGoals;
    if (decomposed instanceof PropertyGoal) { // decomposition chain, do not use formal argument level
      templateElements.remove(formalStrategy);
      templateElements.remove(propCtx);
      templateElements.remove(propGoal);
      templateElements.remove(formalGoal);
      templateElements.remove(modelGoal);
      propStrategy.setId(formalStrategy.getId().replace(placeholderId, decomposedId));
      propStrategy.setDescription(
        propStrategy.getDescription().replace("in Ctx1.CX", "'" + property.getInformal() + "'"));
      modelCtx.setId(propCtx.getId().replace(placeholderId, decomposedId));
      chainedStrategy = propStrategy;
      numCtx = 1;
      numGoals = 0;
    }
    else {
      formalStrategy.setId(formalStrategy.getId().replace(placeholderId, decomposedId));
      formalStrategy.setDescription(formalStrategy.getDescription().replace("REASONER", reasonerName));
      builder.addExistingElement(formalStrategy);
      propCtx.setId(propCtx.getId().replace(placeholderId, decomposedId));
      propCtx.setDescription(propCtx.getDescription().replace("SAFETY_PROPERTY", property.getInformal()));
      builder.addExistingElement(propCtx);
      propGoal.setId(propGoal.getId().replace(placeholderId, decomposedId));
      propGoal.setDescription(propGoal.getDescription().replace(placeholderId, decomposedId));
      builder.addExistingElement(propGoal);
      formalGoal.setId(formalGoal.getId().replace(placeholderId, decomposedId));
      formalGoal.setDescription(formalGoal.getDescription().replace(placeholderId, decomposedId));
      builder.addExistingElement(formalGoal);
      modelGoal.setId(modelGoal.getId().replace(placeholderId, decomposedId));
      modelGoal.setDescription(modelGoal.getDescription().replace(placeholderId, decomposedId));
      builder.addExistingElement(modelGoal);
      propStrategy.setId(propStrategy.getId().replace(placeholderId, decomposedId));
      propStrategy.setDescription(propStrategy.getDescription().replace(placeholderId, decomposedId));
      modelCtx.setId(modelCtx.getId().replace(placeholderId, decomposedId));
      chainedStrategy = formalStrategy;
      numCtx = 2;
      numGoals = 3;
    }
    propStrategy.setReasonerName(reasonerName);
    propStrategy.setProperty(property);
    builder.addExistingElement(propStrategy);
    modelCtx.setDescription(modelCtx.getDescription().replace("MODEL_PATH", relatedModelPath));
    builder.addExistingElement(modelCtx);
    for (var propQuery : propQueries) {
      createQueryContext(propStrategy, propQuery, decomposedId, numCtx, queryContexts, templateElements, builder);
    }
    var numProperties = Integer.parseInt(
      MIDDialogs.getStringInput(title, "Insert the number of sub-properties (>= 2)", null).strip());
    if (numProperties < 2) {
      throw new MMINTException("Sub-properties must be >= 2");
    }

    var subPropGoalId = subPropGoalN.getId().replace(placeholderId, decomposedId);
    for (var i = 0; i < numProperties; i++) {
      var subPropTemplate = DecompositionUtils.selectPropertyTemplate(title, "Select the sub-property #" + (i+1),
                                                                      propTemplates);
      Property subProperty;
      List<String> subPropQueries = List.of();
      if (subPropTemplate == PropertyTemplate.CUSTOM) {
        subProperty = builder.createProperty(title, "Insert the sub-property #" + (i+1), customMsg);
      }
      else {
        var subResult = subPropTemplate.bindVariables(title, modelObjs, queryCache);
        subProperty = subResult.property();
        subPropQueries = subResult.queries();
      }
      var subPropGoal = builder.createPropertyGoal(subPropGoalId.replace("N", String.valueOf(i+1+numGoals)),
                                                   subProperty.getInformal(), subProperty);
      templateElements.add(subPropGoal);
      builder.addSupporter(propStrategy, subPropGoal);
      for (var subPropQuery : subPropQueries) {
        createQueryContext(subPropGoal, subPropQuery, decomposedId, numCtx, queryContexts, templateElements, builder);
      }
    }
    templateElements.add(decomposed);
    chainedStrategy.getSupports().get(0).setSource(decomposed);
  }

} //PropertyTemplateImpl
