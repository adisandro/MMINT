/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.ocl.reasoning;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.OCLHelper;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoningEngine;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class OCLReasoningEngine implements IReasoningEngine {

  protected final static String OCL_MODELENDPOINT_VARIABLE = "$ENDPOINT_";
  protected final static char OCL_VARIABLE_SEPARATOR = '.';

  protected EObject getConstraintContext(Model model, String oclConstraint, MIDLevel constraintLevel) throws MMINTException {

    //TODO MMINT[CONSTRAINT] find language to express more complex contraints on model rels
    boolean isInstancesLevel = model.isInstancesLevel();
    EObject modelObj = null;
    if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
      String modelEndpointConstraintName = oclConstraint.substring(OCL_MODELENDPOINT_VARIABLE.length(), oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR));
      for (ModelEndpointReference modelEndpointRef : ((ModelRel) model).getModelEndpointRefs()) {
        //TODO MMINT[ENDPOINT] consider overridden endpoints here
        String modelEndpointName = (isInstancesLevel && constraintLevel != MIDLevel.INSTANCES) ?
          modelEndpointRef.getObject().getMetatype().getName() :
          modelEndpointRef.getObject().getName();
        if (modelEndpointConstraintName.equals(modelEndpointName)) {
          modelObj = (isInstancesLevel) ?
            modelEndpointRef.getObject().getTarget().getEMFInstanceRoot() :
            modelEndpointRef.getObject().getTarget().getEMFTypeRoot();
          break;
        }
      }
      if (modelObj == null) {
        throw new MMINTException("Can't find model endpoint " + modelEndpointConstraintName + " used in model relationship constraint");
      }
    }
    else {
      modelObj = (isInstancesLevel) ?
        model.getEMFInstanceRoot() :
        model.getEMFTypeRoot();
    }

    return modelObj;
  }

  @Override
  public boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel) {

    String oclConstraint = constraint.getImplementation();
    try {
      EObject modelObj = getConstraintContext(model, oclConstraint, constraintLevel);
      if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
        oclConstraint = oclConstraint.substring(oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR) + 1, oclConstraint.length());
      }
      return checkConstraint(modelObj, oclConstraint);
    }
    catch (MMINTException e) {
      MMINTException.print(IStatus.ERROR, "Can't get context for OCL constraint \"" + constraint + "\" applied to model " + model + " , evaluating to false", e);
      return false;
    }
  }

  public boolean checkConstraint(EObject modelObj, String oclConstraint) {

    OCL ocl = OCL.newInstance();

    try {
      OCLHelper helper = ocl.createOCLHelper(modelObj.eClass());
      ExpressionInOCL expression = helper.createInvariant(oclConstraint);
      return ocl.check(modelObj, expression);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, "Error in OCL constraint \"" + oclConstraint + "\" applied to model object " + modelObj + ", evaluating to false", e);
      return false;
    }
    finally {
      ocl.dispose();
    }
  }

  private @Nullable Object evaluateOCLExpression(OCL ocl, ExpressionInOCL expression, EObject context,
                                                 List<? extends EObject> args) {
    Object evaluation;
    if (expression.getOwnedParameters().size() > 0) {
      var visitor = ocl.createEvaluationVisitor(context, expression);
      var env = visitor.getEvaluationEnvironment();
      for (var i = 0; i < expression.getOwnedParameters().size(); i++) {
        env.replace(expression.getOwnedParameters().get(i), args.get(i));
      }
      evaluation = expression.accept(visitor);
    }
    else {
      evaluation = ocl.evaluate(context, expression);
    }
    if (evaluation instanceof CollectionValue.Accumulator) {
      evaluation = ((CollectionValue.Accumulator) evaluation).getElements();
    }
    if (evaluation instanceof SetValue) {
      evaluation = ((SetValue) evaluation).getElements();
    }
    if (evaluation instanceof OrderedSetValue) {
      evaluation = ((OrderedSetValue) evaluation).getElements();
    }
    return evaluation;
  }

  public @Nullable Object evaluateQuery(String oclQuery, EObject context) {
    OCL ocl = OCL.newInstance();
    try {
      OCLHelper helper = ocl.createOCLHelper(context.eClass());
      ExpressionInOCL expression = helper.createQuery(oclQuery);
      return evaluateOCLExpression(ocl, expression, context, List.of());
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR, "OCL query error: " + oclQuery, e);
      return null;
    }
    finally {
      ocl.dispose();
    }
  }

  @Override
  public List<Object> evaluateQuery(String queryFilePath, @Nullable String queryName, EObject context,
                                    List<? extends EObject> queryArgs) {
    OCL ocl = OCL.newInstance();
    try {
      // get model representation of query
      URI queryFileUri = FileUtils.createEMFUri(queryFilePath, true);
      var queryRoot = ocl.parse(queryFileUri).getContents().get(0);
      if (!(queryRoot instanceof org.eclipse.ocl.pivot.Model)) {
        throw new MMINTException("Bad query file");
      }
      // find named query
      var feat = ((org.eclipse.ocl.pivot.Model) queryRoot).getOwnedPackages().stream()
        .flatMap(p -> p.getOwnedClasses().stream())
        .flatMap(c -> Stream.concat(c.getOwnedProperties().stream(), c.getOwnedOperations().stream()))
        .filter(p -> p.getName().equals(queryName))
        .findFirst()
        .orElseThrow(() -> new MMINTException(MessageFormat.format("Def {0} not found", queryName)));
      // handle query arguments
      var featExpression = (feat instanceof Property) ?
        (ExpressionInOCL) ((Property) feat).getOwnedExpression() :
        (ExpressionInOCL) ((Operation) feat).getBodyExpression();
      var numFormal = featExpression.getOwnedParameters().size();
      var numActual = queryArgs.size();
      var diffArgs = numFormal - numActual;
      if (diffArgs < 0) { // too many actual
        throw new MMINTException(MessageFormat.format("Def {0} has {1} parameters but {2} were passed", queryName,
                                                      numFormal, numActual));
      }
      // find query matches within context
      var matches = new ArrayList<>();
      var formalContext = ((org.eclipse.ocl.pivot.Class) feat.eContainer()).getName();
      var actualContext = context.eClass().getName();
      if (!formalContext.equals(actualContext)) {
        throw new MMINTException(MessageFormat.format("Def {0} is defined in a {1} context, but a {2} was used instead",
                                                      queryName, formalContext, actualContext));
      }
      if (diffArgs > 0) { // partially bound, find unbound arguments within the context
        //TODO MMINT[QUERY] Do cartesian product properly
        for (var i = numActual; i < numFormal; i++) {
          var formalArgClassName = featExpression.getOwnedParameters().get(i).getType().getName();
          for (var iter = context.eAllContents(); iter.hasNext();) {
            var actualArg = iter.next();
            //TODO MMINT[QUERY] Inheritance?
            if (!formalArgClassName.equals(actualArg.eClass().getName())) {
              continue;
            }
            var allQueryArgs = new ArrayList<EObject>(queryArgs);
            allQueryArgs.add(actualArg);
            var evaluation = evaluateOCLExpression(ocl, featExpression, context, allQueryArgs);
            if (evaluation != null) {
              matches.add(evaluation);
            }
          }
        }
      }
      else {
        var evaluation = evaluateOCLExpression(ocl, featExpression, context, queryArgs);
        if (evaluation != null) {
          matches.add(evaluation);
        }
      }
      return matches;
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR,
                           MessageFormat.format("OCL file {0}, def {1} error: ", queryFilePath, queryName), e);
      return List.of();
    }
    finally {
      ocl.dispose();
    }
  }

}
