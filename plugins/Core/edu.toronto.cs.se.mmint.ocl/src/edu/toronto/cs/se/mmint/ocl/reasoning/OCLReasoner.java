/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.ocl.reasoning;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.core.runtime.IStatus;
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
import org.eclipse.ocl.pivot.values.TupleValue;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.reasoning.IConstraintTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoningEngine;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class OCLReasoner implements IReasoningEngine, IQueryTrait, IConstraintTrait {

  protected final static String OCL_MODELENDPOINT_VARIABLE = "$ENDPOINT_";
  protected final static char OCL_VARIABLE_SEPARATOR = '.';

  protected EObject getConstraintContext(Model model, String oclConstraint, MIDLevel constraintLevel) throws MMINTException {

    //TODO MMINT[CONSTRAINT] find language to express more complex contraints on model rels
    var isInstancesLevel = model.isInstancesLevel();
    EObject modelObj = null;
    if (model instanceof ModelRel && oclConstraint.startsWith(OCLReasoner.OCL_MODELENDPOINT_VARIABLE)) {
      var modelEndpointConstraintName = oclConstraint.substring(OCLReasoner.OCL_MODELENDPOINT_VARIABLE.length(), oclConstraint.indexOf(OCLReasoner.OCL_VARIABLE_SEPARATOR));
      for (ModelEndpointReference modelEndpointRef : ((ModelRel) model).getModelEndpointRefs()) {
        //TODO MMINT[ENDPOINT] consider overridden endpoints here
        var modelEndpointName = (isInstancesLevel && constraintLevel != MIDLevel.INSTANCES) ?
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
    var oclConstraint = constraint.getImplementation();
    var modelObj = getConstraintContext(model, oclConstraint, constraintLevel);
    if (model instanceof ModelRel && oclConstraint.startsWith(OCLReasoner.OCL_MODELENDPOINT_VARIABLE)) {
      oclConstraint = oclConstraint.substring(oclConstraint.indexOf(OCLReasoner.OCL_VARIABLE_SEPARATOR) + 1, oclConstraint.length());
    }

    return checkConstraint(modelObj, oclConstraint);
  }

  public boolean checkConstraint(EObject modelObj, String oclConstraint) {
    var ocl = OCL.newInstance();

    try {
      var helper = ocl.createOCLHelper(modelObj.eClass());
      var expression = helper.createInvariant(oclConstraint);
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

  private List<Object> evaluateOCLExpression2(OCL ocl, ExpressionInOCL expression, EObject context,
                                              List<? extends EObject> args) {
    var result = new ArrayList<>();
    var evaluation = evaluateOCLExpression(ocl, expression, context, args);
    if (evaluation != null) {
      if (evaluation instanceof Collection<?>) {
        for (var iter = ((Collection<?>) evaluation).iterator(); iter.hasNext();) {
          var allQueryArgs = new ArrayList<Object>(args);
          var obj = iter.next();
          if (obj instanceof TupleValue) {
            for (var i = 0;; i++) {
              try {
                allQueryArgs.add(((TupleValue) obj).getValue(i));
              }
              catch (ArrayIndexOutOfBoundsException e) {
                break;
              }
            }
          }
          else {
            allQueryArgs.add(obj);
          }
          result.add(allQueryArgs);
        }
      }
      else {
        var allQueryArgs = new ArrayList<Object>(args);
        allQueryArgs.add(evaluation);
        result.add(allQueryArgs);
      }
    }
    return result;
  }

  @Override
  public Set<String> getQueryFileExtensions() {
    return Set.of("ocl");
  }

  @Override
  public List<Object> evaluateQuery(String queryFilePath, String queryName, EObject context,
                                    List<? extends EObject> queryArgs) throws Exception {
    var ocl = OCL.newInstance();
    try {
      // get model representation of query
      var queryFileUri = FileUtils.createEMFUri(queryFilePath, true);
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
      if (diffArgs != 0) { // actuals not matching formals
        throw new MMINTException(MessageFormat.format("Def {0} has {1} parameters but {2} were passed", queryName,
                                                      numFormal, numActual));
      }
      // find query matches within context
      var formalContext = ((org.eclipse.ocl.pivot.Class) feat.eContainer()).getName();
      var actualContext = context.eClass().getName();
      if (!formalContext.equals(actualContext)) {
        throw new MMINTException(MessageFormat.format("Def {0} is defined in a {1} context, but a {2} was used instead",
                                                      queryName, formalContext, actualContext));
      }
      return evaluateOCLExpression2(ocl, featExpression, context, queryArgs);
    }
    finally {
      ocl.dispose();
    }
  }

}
