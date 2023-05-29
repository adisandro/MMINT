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
import edu.toronto.cs.se.mmint.types.gsn.templates.DecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.Property;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNDecompositionTrait;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNLeanEncoder.PropertyTemplate;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.DecompositionUtils;
import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PropertyDecompositionTemplateImpl extends TemplateImpl implements PropertyDecompositionTemplate {
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
  @Override
  public void validate() throws Exception {
    // do nothing
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
                                  Map<String, Context> contexts, GSNTemplatesBuilder builder) {
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
      contexts.put(query, context);
    }
    builder.addInContextOf(contextualized, context);
  }

  /**
   * @generated NOT
   */
  private DecompositionStrategy decompose(Goal decomposed, GSNBuilder gsnBuilder) throws Exception {
    var builder = (GSNTemplatesBuilder) gsnBuilder;
    // ask for input
    var title = "Property Decomposition";
    var customMsg = "Insert a description for the custom property";
    var reasoner = MIDDialogs.selectReasoner(IGSNDecompositionTrait.class, "GSN property decomposition", null);
    var reasonerName = reasoner.getName();
    var relatedModelOpt = DecompositionUtils.getRelatedModel(decomposed);
    var templates = Map.<String, List<PropertyTemplate>>of();
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
        templates = reasoner.getPropertyTemplates(relatedModel);
        modelObjs = DecompositionUtils.categorizeModelObjects(relatedModel, templates);
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
      var template = DecompositionUtils.selectTemplate(title, "Select the property to be decomposed", templates);
      if (template == PropertyTemplate.CUSTOM) {
        property = builder.createProperty(title, "Insert the " + reasonerName + " property to be decomposed",
                                          customMsg);
      }
      else {
        var result = template.bindVariables(title, modelObjs, queryCache);
        property = result.property();
        propQueries = result.queries();
      }
    }
    // create decomposition template
    var id = decomposed.getId();
    Strategy chainedStrategy = null;
    Goal chainedGoal = null;
    String propStrategyId;
    var propStrategyDesc = "Decomposition over property ";
    var numGoals = 1;
    var numCtx = 0;
    if (decomposed instanceof PropertyGoal) { // decomposition chain, do not create formal argument level
      propStrategyId = "S1." + id;
      propStrategyDesc += "'" + property.getInformal() + "'";
    }
    else {
      var formalStrategyId = "S1." + id;
      var formalStrategyDesc = "Argument by " + reasonerName + " formalization";
      var propContextId = "Ctx1." + id;
      var modelGoalId = id + ".1";
      var modelGoalDesc = "The related model correctly models all aspects of the system for the property in " +
                          propContextId;
      var propGoalId = id + ".2";
      var propGoalDesc = id + " asserts the property in " + propContextId;
      var formalGoalId = id + ".3";
      var formalGoalDesc = "The property in " + propContextId + " holds";
      chainedStrategy = builder.createBasicStrategy(formalStrategyId, formalStrategyDesc);
      var propContext = builder.createContext(propContextId, property.getInformal());
      builder.addInContextOf(chainedStrategy, propContext);
      var modelGoal = builder.createBasicGoal(modelGoalId, modelGoalDesc);
      builder.addSupporter(chainedStrategy, modelGoal);
      var propGoal = builder.createBasicGoal(propGoalId, propGoalDesc);
      builder.addSupporter(chainedStrategy, propGoal);
      chainedGoal = builder.createBasicGoal(formalGoalId, formalGoalDesc);
      builder.addSupporter(chainedStrategy, chainedGoal);
      propStrategyId = "S2." + id;
      propStrategyDesc += "in " + propContextId;
      numGoals = 4;
      numCtx = 1;
    }
    var modelContextId = "Ctx" + ++numCtx + "." + id;
    var subGoalId = id + ".";
    var propStrategy = builder.createPropertyStrategy(propStrategyId, propStrategyDesc, reasonerName, property);
    if (chainedGoal == null) {
      chainedStrategy = propStrategy;
    }
    else {
      builder.addSupporter(chainedGoal, propStrategy);
    }
    var modelContext = builder.createContext(modelContextId, relatedModelPath);
    builder.addInContextOf(propStrategy, modelContext);
    for (var propQuery : propQueries) {
      createQueryContext(propStrategy, propQuery, id, numCtx, queryContexts, builder);
    }
    var numProperties = Integer.parseInt(MIDDialogs.getStringInput(title, "Insert the number of sub-properties",
                                                                   null).strip());
    for (var i = 0; i < numProperties; i++) {
      var subTemplate = DecompositionUtils.selectTemplate(title, "Select the sub-property #" + (i+1), templates);
      Property subProperty;
      List<String> subPropQueries = List.of();
      if (subTemplate == PropertyTemplate.CUSTOM) {
        subProperty = builder.createProperty(title, "Insert the sub-property #" + (i+1), customMsg);
      }
      else {
        var subResult = subTemplate.bindVariables(title, modelObjs, queryCache);
        subProperty = subResult.property();
        subPropQueries = subResult.queries();
      }
      var subGoal = builder.createPropertyGoal(subGoalId + (i+numGoals), subProperty.getInformal(), subProperty);
      builder.addSupporter(propStrategy, subGoal);
      for (var subPropQuery : subPropQueries) {
        createQueryContext(subGoal, subPropQuery, id, numCtx, queryContexts, builder);
      }
    }
    builder.addSupporter(decomposed, chainedStrategy);

    return propStrategy;
  }

  /**
   * @generated NOT
   */
  @Override
  public GSNBuilder instantiate(SafetyCase safetyCase) throws Exception {
    var builder = new GSNTemplatesBuilder(safetyCase);
    decompose(null, builder);

    return builder;
  }

} //PropertyTemplateImpl
