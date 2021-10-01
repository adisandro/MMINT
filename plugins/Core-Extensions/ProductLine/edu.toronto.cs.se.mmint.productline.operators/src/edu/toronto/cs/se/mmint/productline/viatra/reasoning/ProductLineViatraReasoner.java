/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.viatra.reasoning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ClosureType;
import org.eclipse.viatra.query.patternlanguage.emf.vql.CompareConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Parameter;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ParameterDirection;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ParameterRef;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PathExpressionConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Pattern;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternBody;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternCompositionConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternLanguageFactory;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternLanguagePackage;
import org.eclipse.viatra.query.patternlanguage.emf.vql.StringValue;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Variable;
import org.eclipse.viatra.query.patternlanguage.emf.vql.VariableReference;
import org.eclipse.viatra.query.runtime.api.GenericPatternMatch;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.productline.Attribute;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineQueryTrait;
import edu.toronto.cs.se.mmint.viatra.reasoning.ViatraReasoner;
import edu.toronto.cs.se.modelepedia.z3.Z3Solver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;

@SuppressWarnings("restriction")
public class ProductLineViatraReasoner extends ViatraReasoner implements IProductLineQueryTrait {
  public final static String VIATTRA_LIB_PATH = "edu/toronto/cs/se/mmint/productline/viatra/pl.vql";
  public final static String EXTRA_VAR_NAME = "ref";
  private Set<String> origParameters;

  @Override
  public String getName() {
    return "Viatra for Product Lines";
  }

  public static Set<String> getVariables(String formula) {
    if (formula.isBlank()) {
      return Set.of();
    }
    return Arrays.stream(formula.strip().split("[\\s\\(\\){or}{and}{not}{true}{false}]"))
      .filter(v -> !v.isBlank())
      .collect(Collectors.toSet());
  }

  @Override
  public boolean areInAProduct(Set<PLElement> plElements) {
    if (plElements.isEmpty()) {
      return false;
    }

    //TODO MMINT[REASONER] Make it independent from the Z3 solver
    var anyPLElem = plElements.stream().findAny().get();
    var pl = (ProductLine) ((anyPLElem instanceof Attribute) ?
      anyPLElem.eContainer().eContainer() :
      anyPLElem.eContainer());
    var features = pl.getFeatures();
    var presenceConditions = plElements.stream()
      .map(e -> e.getPresenceCondition())
      .filter(pc -> pc != null)
      .collect(Collectors.toList());
    var smtEncoding = "";
    var variables = getVariables(features);
    var smtBody = features + " ";
    var allVariables = new HashSet<>(variables);
    for (var variable : variables) {
      smtEncoding += Z3Utils.constant(variable, Z3Utils.SMTLIB_TYPE_BOOL);
    }
    for (var presenceCondition : presenceConditions) {
      smtBody += presenceCondition + " ";
      variables = getVariables(presenceCondition);
      for (var variable : variables) {
        if (allVariables.contains(variable)) {
          continue;
        }
        smtEncoding += Z3Utils.constant(variable, Z3Utils.SMTLIB_TYPE_BOOL);
        allVariables.add(variable);
      }
    }
    smtEncoding += Z3Utils.assertion(Z3Utils.and(smtBody));

    return new Z3Solver().checkSat(smtEncoding).isSAT();
  }

  private Variable createVariable(EClass varClass, String name) {
    var plVariable = (Variable) PatternLanguageFactory.eINSTANCE.create(varClass);
    plVariable.setName(name);

    return plVariable;
  }

  private Parameter createParameter(String name, EClassifier typeClass, ParameterDirection direction) {
    var plParameter = (Parameter) createVariable(PatternLanguagePackage.eINSTANCE.getParameter(), name);
    var plType = PatternLanguageFactory.eINSTANCE.createClassType();
    plType.setClassname(typeClass);
    plParameter.setType(plType);
    plParameter.setDirection(direction);

    return plParameter;
  }

  private ParameterRef createParameterRef(String name, Parameter plParameter) {
    var plParameterRef = (ParameterRef) createVariable(PatternLanguagePackage.eINSTANCE.getParameterRef(), name);
    plParameterRef.setReferredParam(plParameter);

    return plParameterRef;
  }

  private ParameterRef createParameterAndRef(String name, EClassifier typeClass, ParameterDirection direction) {
    var plParameter = createParameter(name, typeClass, direction);

    return createParameterRef(name, plParameter);
  }

  private StringValue createStringValue(String value) {
    var plStringValue = PatternLanguageFactory.eINSTANCE.createStringValue();
    plStringValue.setValue(value);

    return plStringValue;
  }

  private Variable liftVariable(Variable variable, List<Variable> plParameters) {
    Variable plVariable;
    if (variable instanceof ParameterRef parameterRef) {
      var plParameter = plParameters.stream()
        .filter(p -> p.getName().equals(parameterRef.getReferredParam().getName()))
        .findFirst()
        .get();
      plVariable = createParameterRef(variable.getName(), (Parameter) plParameter);
    }
    else {
      plVariable = createVariable(variable.eClass(), variable.getName());
    }

    return plVariable;
  }

  private Parameter liftParameter(Parameter parameter) {
    return createParameter(parameter.getName(), ProductLinePackage.eINSTANCE.getClass_(), parameter.getDirection());
  }

  private VariableReference createVariableReference(Variable plVar) {
    var plVarRef = PatternLanguageFactory.eINSTANCE.createVariableReference();
    plVarRef.setAggregator(false);
    plVarRef.setVar(plVar.getName());
    plVarRef.setVariable(plVar);

    return plVarRef;
  }

  private VariableReference liftVariableReference(VariableReference varRef, Map<String, Variable> plVarsMap)
                                                 throws MMINTException {
    var plVar = plVarsMap.get(varRef.getVar());
    if (plVar == null) {
      throw new MMINTException("Variable " + varRef.getVar() + " not found");
    }

    return createVariableReference(plVar);
  }

  /**
   * Lifts a path constraint, i.e.:
   * Class.superclass(child, parent);
   * into:
   * connection(child, "Class", parent, "Class", ref, "superclass");
   */
  private List<PatternCompositionConstraint> liftPathExpressionConstraint(
                                               PathExpressionConstraint pathConstraint, EList<Variable> plParameters,
                                               EList<Variable> plVariables, Map<String, Variable> plVarsMap,
                                               Pattern libPattern, int extraVars) throws MMINTException {
    var plConstraints = new ArrayList<PatternCompositionConstraint>();
    var plElemType = ProductLinePackage.eINSTANCE.getPLElement();
    for (var i = 0; i < pathConstraint.getEdgeTypes().size(); i++) {
      var edgeFeature = pathConstraint.getEdgeTypes().get(i).getRefname();
      // PL library call
      var plConstraint = PatternLanguageFactory.eINSTANCE.createPatternCompositionConstraint();
      plConstraint.setNegative(false);
      var plCall = PatternLanguageFactory.eINSTANCE.createPatternCall();
      plConstraint.setCall(plCall);
      plCall.setPatternRef(libPattern);
      plCall.setTransitive(ClosureType.ORIGINAL);
      if (i == 0) {
        // path source
        var srcName = pathConstraint.getSrc().getVariable().getName();
        var plSrcVar = plVarsMap.get(srcName);
        if (plSrcVar == null) {
          plSrcVar = createParameterAndRef(srcName, plElemType, ParameterDirection.OUT);
          plVarsMap.put(srcName, plSrcVar);
          plVariables.add(plSrcVar);
          plParameters.add(((ParameterRef) plSrcVar).getReferredParam());
        }
        var plSrc = createVariableReference(plSrcVar);
        plCall.getParameters().add(plSrc);
        plCall.getParameters().add(createStringValue(pathConstraint.getSourceType().getClassname().getName()));
      }
      else {
        //TODO handle multiple edges
      }
      if (edgeFeature instanceof EReference edgeReference) {
        // path destination
        var dstName = ((VariableReference) pathConstraint.getDst()).getVariable().getName();
        var plDstVar = plVarsMap.get(dstName);
        if (plDstVar == null) {
          plDstVar = createParameterAndRef(dstName, plElemType, ParameterDirection.OUT);
          plVarsMap.put(dstName, plDstVar);
          plVariables.add(plDstVar);
          plParameters.add(((ParameterRef) plDstVar).getReferredParam());
        }
        var plDst = createVariableReference(plDstVar);
        plCall.getParameters().add(plDst);
        plCall.getParameters().add(createStringValue(edgeReference.getEReferenceType().getName()));
        // path edge (EReference)
        var edgeName = ProductLineViatraReasoner.EXTRA_VAR_NAME + (i+extraVars);
        var plEdgeVar = createParameterAndRef(edgeName, plElemType, ParameterDirection.OUT);
        plVariables.add(plEdgeVar);
        plParameters.add(plEdgeVar.getReferredParam());
        plCall.getParameters().add(createVariableReference(plEdgeVar));
        plCall.getParameters().add(createStringValue(edgeReference.getName()));
      }
      else {
        //TODO implement a library pattern to lift attribute constraints and use it here
      }
      plConstraints.add(plConstraint);
    }

    return plConstraints;
  }

  private CompareConstraint liftCompareConstraint(CompareConstraint compareConstraint, Map<String, Variable> plVarsMap)
                                                 throws MMINTException {
    var plConstraint = PatternLanguageFactory.eINSTANCE.createCompareConstraint();
    if (compareConstraint.getLeftOperand() instanceof VariableReference left) {
      var plLeft = liftVariableReference(left, plVarsMap);
      plConstraint.setLeftOperand(plLeft);
    }
    if (compareConstraint.getRightOperand() instanceof VariableReference right) {
      var plRight = liftVariableReference(right, plVarsMap);
      plConstraint.setRightOperand(plRight);
    }
    //TODO implement value comparison?
    plConstraint.setFeature(compareConstraint.getFeature());

    return plConstraint;
  }

  private PatternBody liftBody(PatternBody body, EList<Variable> plParameters, Pattern libPattern)
                              throws MMINTException {
    var plBody = PatternLanguageFactory.eINSTANCE.createPatternBody();
    // variables pass #1: parameter references only
    var plVarsMap = new HashMap<String, Variable>();
    var plVariables = plBody.getVariables();
    for (var variable : body.getVariables()) {
      if (!(variable instanceof ParameterRef)) {
        continue;
      }
      var plVariable = liftVariable(variable, plParameters);
      plVariables.add(plVariable);
      plVarsMap.put(plVariable.getName(), plVariable);
    }
    // constraints pass #1: lift all the path expressions, which generate extra parameters and variables
    var extraVariables = 0;
    var plConstraints = plBody.getConstraints();
    for (var constraint : body.getConstraints()) {
      if (!(constraint instanceof PathExpressionConstraint pathConstraint)) {
        continue;
      }
      var liftedConstraints = liftPathExpressionConstraint(pathConstraint, plParameters, plVariables, plVarsMap,
                                                           libPattern, extraVariables);
      plConstraints.addAll(liftedConstraints);
      extraVariables += liftedConstraints.size();
    }
    // variables pass #2: all other variables
    for (var variable : body.getVariables()) {
      if (plVarsMap.containsKey(variable.getName())) {
        continue;
      }
      var plVariable = liftVariable(variable, List.of());
      plVariables.add(plVariable);
      plVarsMap.put(plVariable.getName(), plVariable);
    }
    // constraints pass #2: all other constraints
    for (var constraint : body.getConstraints()) {
      if (constraint instanceof PathExpressionConstraint) {
        continue;
      }
      if (!(constraint instanceof CompareConstraint compareConstraint)) {
        throw new MMINTException("Constraint type " + constraint.getClass().getName() + " not supported");
      }
      plConstraints.add(liftCompareConstraint(compareConstraint, plVarsMap));
    }

    return plBody;
  }

  @Override
  protected Pattern getPattern(String queryFilePath, String queryName, boolean isWorkspaceRelative) throws Exception {
    var pattern = super.getPattern(queryFilePath, queryName, true);
    this.origParameters = new HashSet<>();
    var plModelType = MIDTypeRegistry.<Model>getType(ProductLinePackage.eNS_URI);
    var libFilePath = MIDTypeRegistry.getBundlePath(plModelType, ProductLineViatraReasoner.VIATTRA_LIB_PATH);
    var libPattern = super.getPattern(libFilePath, "connection", false);
    var plPattern = PatternLanguageFactory.eINSTANCE.createPattern();
    plPattern.setName(pattern.getName());
    // i/o parameters
    for (var parameter : pattern.getParameters()) {
      var plParameter = liftParameter((Parameter) parameter);
      plPattern.getParameters().add(plParameter);
      this.origParameters.add(plParameter.getName());
    }
    // body variables and constraints
    var plBodies = plPattern.getBodies();
    for (var body : pattern.getBodies()) {
      var plBody = liftBody(body, plPattern.getParameters(), libPattern);
      plBodies.add(plBody);
    }

    return plPattern;
  }

  @Override
  protected List<Object> getMatches(Collection<GenericPatternMatch> vMatches) {
    var matches = new LinkedHashSet<>();
    for (var vMatch : vMatches) {
      var matchAsList = new ArrayList<>();
      var plElements = new HashSet<PLElement>();
      for (var parameterName : vMatch.parameterNames()) {
        var parameter = vMatch.get(parameterName);
        if (this.origParameters.contains(parameterName)) {
          matchAsList.add(parameter);
        }
        if (parameter instanceof PLElement plElement) {
          plElements.add(plElement);
        }
      }
      // the inner list is redundant for one element
      var match = (matchAsList.size() == 1) ? matchAsList.get(0) : matchAsList;
      // adding the product line elements as query parameters may create spurious extra results
      // that differ only in their parameter order
      // the real (expensive) check for compatible presence conditions is short-circuited in that case
      if (matches.contains(match) || !areInAProduct(plElements)) {
        continue;
      }
      matches.add(match);
    }
    this.origParameters = null;

    //TODO Figure out how to require the IProductLineQueryTrait capability to be present in a product line query
    return List.copyOf(matches);
  }
}
