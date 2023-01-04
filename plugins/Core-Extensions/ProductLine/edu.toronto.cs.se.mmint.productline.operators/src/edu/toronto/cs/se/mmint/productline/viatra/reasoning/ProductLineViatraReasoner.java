/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.viatra.query.patternlanguage.emf.vql.AggregatedValue;
import org.eclipse.viatra.query.patternlanguage.emf.vql.BoolValue;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ClassType;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ClosureType;
import org.eclipse.viatra.query.patternlanguage.emf.vql.CompareConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Constraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.EnumValue;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Parameter;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ParameterDirection;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ParameterRef;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PathExpressionConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Pattern;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternBody;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternCall;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternCompositionConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternLanguageFactory;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternLanguagePackage;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternModel;
import org.eclipse.viatra.query.patternlanguage.emf.vql.StringValue;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ValueReference;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Variable;
import org.eclipse.viatra.query.patternlanguage.emf.vql.VariableReference;
import org.eclipse.viatra.query.runtime.api.GenericPatternMatch;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeaturesTrait.Aggregator;
import edu.toronto.cs.se.mmint.productline.reasoning.PLPipeline;
import edu.toronto.cs.se.mmint.viatra.reasoning.ViatraReasoner;

public class ProductLineViatraReasoner extends ViatraReasoner {

  public final static String VIATRA_LIB_PATH = "edu/toronto/cs/se/mmint/productline/viatra/pl.vql";
  public final static String LIB_REFERENCE_PATTERN = "reference";
  public final static String LIB_ATTRIBUTE_PATTERN = "attribute";
  public final static String LIB_CLASSTYPE_PATTERN = "classType";
  public final static String EXTRA_VAR_NAME = "extra";
  public final static String DONTCARE_VAR_NAME = "_";
  public final static Set<String> MID_LIB_PATTERNS_NOCHANGES =
    Set.of("connectedModelElementsWithMapping", "connectedEMFObjectsWithMapping");
  public final static Map<String, String> MID_LIB_PATTERNS_TOCHANGE =
    Map.of("connectedModelElements", "connectedModelElementsWithMapping",
           "connectedEMFObjects",    "connectedEMFObjectsWithMapping");

  private Pattern libRefPattern, libAttrPattern, libClassPattern;
  private Set<String> origParameters;
  private int extraVariables;
  private @Nullable String aggregatedVarName;
  private @Nullable Aggregator aggregator;
  private Set<String> aggregatedGroupBy;
  private @Nullable IProductLineFeaturesTrait featureReasoner;
  private String featuresConstraint;

  public ProductLineViatraReasoner() throws Exception {
    var plModelRelType = MIDTypeRegistry.<ModelRel>getType(ProductLineMIDPackage.eNS_URI);
    var libFilePath = MIDTypeRegistry.getBundlePath(plModelRelType, ProductLineViatraReasoner.VIATRA_LIB_PATH);
    var libVqlRoot = getVQLRoot(libFilePath, false);
    this.libRefPattern = super.getPattern(libVqlRoot, ProductLineViatraReasoner.LIB_REFERENCE_PATTERN);
    this.libAttrPattern = super.getPattern(libVqlRoot, ProductLineViatraReasoner.LIB_ATTRIBUTE_PATTERN);
    this.libClassPattern = super.getPattern(libVqlRoot, ProductLineViatraReasoner.LIB_CLASSTYPE_PATTERN);
    reset();
  }

  private void reset() {
    this.origParameters = new HashSet<>();
    this.extraVariables = 0;
    this.aggregator = null;
    this.aggregatedVarName = null;
    this.aggregatedGroupBy = new HashSet<>();
    this.featureReasoner = null;
    this.featuresConstraint = "";
  }

  private String getNextExtraVariableName() {
    return ProductLineViatraReasoner.EXTRA_VAR_NAME + this.extraVariables++;
  }

  @Override
  public String getName() {
    return "Viatra for Product Lines";
  }

  @Override
  public boolean canUse(Object data) {
    if (data instanceof ProductLine || data instanceof PLElement) {
      return true;
    }
    if (!(data instanceof MID mid)) {
      return false;
    }
    return mid.getModels().stream()
      .filter(m -> !(m instanceof ModelRel))
      .anyMatch(m -> MIDTypeHierarchy.instanceOf(m, ProductLinePackage.eNS_URI, false));
  }

  public Set<String> getPresenceConditions(Set<PLElement> plElements) {
    return plElements.stream()
      .map(e -> e.getPresenceCondition())
      .filter(pc -> pc != null && !pc.strip().equals("true"))
      .collect(Collectors.toSet());
  }

  /**
   * Checks whether a set of product line elements are in a same product, according to their presence conditions and the
   * product line feature model.
   *
   * @param plElements
   *          The set of product line elements, within the same product line.
   * @throws MMINTException
   *           If a reasoner to check product line feature constraints is not available.
   * @return True if all the elements are in a same product, false otherwise.
   */
  public boolean areInAProduct(Set<PLElement> plElements) throws MMINTException {
    if (plElements.isEmpty()) {
      return false;
    }
    if (this.featureReasoner == null) {
      var pl = plElements.iterator().next().getProductLine();
      this.featureReasoner = pl.getReasoner();
      this.featuresConstraint = pl.getFeaturesConstraint();
    }
    var presenceConditions = getPresenceConditions(plElements);
    return this.featureReasoner.checkConsistency(this.featuresConstraint, presenceConditions);
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

  private ParameterRef createParameterAndRef(String name, EClassifier typeClass, ParameterDirection direction,
                                             EList<Variable> plParameters, EList<Variable> plVariables,
                                             Map<String, Variable> plVarsMap) {
    var plParameterRef = createParameterAndRef(name, typeClass, direction);
    plVarsMap.put(name, plParameterRef);
    plVariables.add(plParameterRef);
    plParameters.add(plParameterRef.getReferredParam());

    return plParameterRef;
  }

  private ParameterRef createExtraParameterAndRef(EClass typeClass, EList<Variable> plParameters,
                                                  EList<Variable> plVariables, Map<String, Variable> plVarsMap) {
    return createParameterAndRef(getNextExtraVariableName(), typeClass, ParameterDirection.OUT, plParameters,
                                 plVariables, plVarsMap);
  }

  // converts don't care var to extra par
  private ParameterRef liftDontCareVariable(String name, EClass typeClass, EList<Variable> plParameters,
                                            EList<Variable> plVariables, Map<String, Variable> plVarsMap) {
    var plDontCareVar = plVarsMap.remove(name);
    if (plDontCareVar != null) {
      plVariables.remove(plDontCareVar);
    }

    return createExtraParameterAndRef(typeClass, plParameters, plVariables, plVarsMap);
  }

  private Variable liftVariable(String name, EClass typeClass, EList<Variable> plParameters,
                                EList<Variable> plVariables, Map<String, Variable> plVarsMap) {
    Variable plVar;
    if (name.startsWith(ProductLineViatraReasoner.DONTCARE_VAR_NAME)) {
      plVar = liftDontCareVariable(name, typeClass, plParameters, plVariables, plVarsMap);
    }
    else {
      plVar = plVarsMap.get(name);
      if (plVar == null) {
        plVar = createParameterAndRef(name, typeClass, ParameterDirection.OUT, plParameters, plVariables, plVarsMap);
      }
    }

    return plVar;
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
    var typeClass = ((ClassType) parameter.getType()).getClassname();
    if (!(typeClass instanceof EDataType)) {
      typeClass = ProductLinePackage.eINSTANCE.getClass_();
    }
    return createParameter(parameter.getName(), typeClass, parameter.getDirection());
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

  private List<PatternCompositionConstraint> createPathExpressionConstraint(
                                               PathExpressionConstraint pathConstraint, EList<Variable> plParameters,
                                               EList<Variable> plVariables, Map<String, Variable> plVarsMap)
                                                 throws MMINTException {
    var plConstraints = new ArrayList<PatternCompositionConstraint>();
    var plElemType = ProductLinePackage.eINSTANCE.getPLElement();
    for (var i = 0; i < pathConstraint.getEdgeTypes().size(); i++) {
      var edgeFeature = pathConstraint.getEdgeTypes().get(i).getRefname();
      // PL library call
      var plConstraint = PatternLanguageFactory.eINSTANCE.createPatternCompositionConstraint();
      plConstraint.setNegative(false);
      var plCall = PatternLanguageFactory.eINSTANCE.createPatternCall();
      plConstraint.setCall(plCall);
      plCall.setPatternRef((edgeFeature instanceof EReference) ? this.libRefPattern : this.libAttrPattern);
      plCall.setTransitive(ClosureType.ORIGINAL);
      // path source
      var srcName = (i == 0) ?
        pathConstraint.getSrc().getVariable().getName() :
        getNextExtraVariableName();
      var srcType = (i == 0) ?
        pathConstraint.getSourceType().getClassname().getName() :
        edgeFeature.getEContainingClass().getName();
      var plSrcVar = liftVariable(srcName, plElemType, plParameters, plVariables, plVarsMap);
      var plSrc = createVariableReference(plSrcVar);
      plCall.getParameters().add(plSrc);
      plCall.getParameters().add(createStringValue(srcType));
      // reference destination
      if (edgeFeature instanceof EReference edgeReference) {
        var dstName = (i == (pathConstraint.getEdgeTypes().size()-1)) ?
          ((VariableReference) pathConstraint.getDst()).getVariable().getName() :
          getNextExtraVariableName();
        var plDstVar = liftVariable(dstName, plElemType, plParameters, plVariables, plVarsMap);
        var plDst = createVariableReference(plDstVar);
        plCall.getParameters().add(plDst);
        plCall.getParameters().add(createStringValue(edgeReference.getEReferenceType().getName()));
      }
      // path edge
      var plEdgeVar = createExtraParameterAndRef(plElemType, plParameters, plVariables, plVarsMap);
      plCall.getParameters().add(createVariableReference(plEdgeVar));
      plCall.getParameters().add(createStringValue(edgeFeature.getName()));
      // attribute value
      if (edgeFeature instanceof EAttribute edgeAttribute) {
        var dst = pathConstraint.getDst();
        ValueReference plValue;
        //TODO MMINT[JAVA20] Convert to switch with pattern matching
        if (dst instanceof StringValue strDst) {
          plValue = createStringValue(strDst.getValue());
        }
        else if (dst instanceof EnumValue enumDst) {
          plValue = createStringValue(enumDst.getLiteral().getLiteral());
        }
        else if (dst instanceof BoolValue boolDst) {
          plValue = createStringValue(String.valueOf(boolDst.getValue().isIsTrue()));
        }
        else if (dst instanceof VariableReference varRefDst) {
          var varDst = varRefDst.getVariable();
          var valueName = varDst.getName();
          var plValueVar = plVarsMap.get(valueName);
          if (plValueVar == null) {
            // primitive type with no presence condition, no need to create a parameter
            plValueVar = createVariable(varDst.eClass(), valueName);
            plVarsMap.put(valueName, plValueVar);
            plVariables.add(plValueVar);
          }
          plValue = createVariableReference(plValueVar);
        }
        else {
          throw new MMINTException("Path constraint type " + dst.getClass().getName() + " not supported");
        }
        plCall.getParameters().add(plValue);
      }
      plConstraints.add(plConstraint);
    }

    return plConstraints;
  }

  /**
   * Lifts a path constraint, i.e.:
   * Class.superclass(child, parent);
   * into:
   * reference(child, "Class", parent, "Class", ref, "superclass");
   */
  private List<PatternCompositionConstraint> liftPathExpressionConstraint(
                                               PathExpressionConstraint pathConstraint, EList<Variable> plParameters,
                                               EList<Variable> plVariables, Map<String, Variable> plVarsMap)
                                                 throws MMINTException {
    return createPathExpressionConstraint(pathConstraint, plParameters, plVariables, plVarsMap);
  }

  private List<PatternCompositionConstraint> createPatternCompositionConstraint(
                                               PatternCall patternCall, boolean isNegative,
                                               EList<Variable> plParameters, EList<Variable> plVariables,
                                               Map<String, Variable> plVarsMap) throws Exception {
    // check for mid.vql calls
    var plPattern = patternCall.getPatternRef();
    if (!ProductLineViatraReasoner.MID_LIB_PATTERNS_NOCHANGES.contains(plPattern.getName()) &&
        !ProductLineViatraReasoner.MID_LIB_PATTERNS_TOCHANGE.containsKey(plPattern.getName())) {
      throw new MMINTException("Pattern call not supported");
    }
    var plConstraints = new ArrayList<PatternCompositionConstraint>();
    // convert pattern call to use lifted variables
    var plConstraint = PatternLanguageFactory.eINSTANCE.createPatternCompositionConstraint();
    plConstraint.setNegative(isNegative);
    var plCall = PatternLanguageFactory.eINSTANCE.createPatternCall();
    plConstraint.setCall(plCall);
    var plPatternName = ProductLineViatraReasoner.MID_LIB_PATTERNS_TOCHANGE.get(plPattern.getName());
    if (plPatternName != null) {
      plPattern = getPattern((PatternModel) plPattern.eContainer(), plPatternName);
    }
    plCall.setPatternRef(plPattern);
    plCall.setTransitive(patternCall.getTransitive());
    var classTypes = new ArrayList<Parameter>();
    for (var patternPar : patternCall.getParameters()) {
      ValueReference plPar;
      if (patternPar instanceof StringValue strPar) {
        plPar = createStringValue(strPar.getValue());
      }
      else if (patternPar instanceof VariableReference varPar) {
        var variable = varPar.getVariable();
        var varName = variable.getName();
        var plVar = (varName.startsWith(ProductLineViatraReasoner.DONTCARE_VAR_NAME)) ?
          liftDontCareVariable(varName, ProductLinePackage.eINSTANCE.getClass_(), plParameters, plVariables,
                               plVarsMap) :
          plVarsMap.get(varName);
        plPar = createVariableReference(plVar);
        if (variable instanceof ParameterRef parRef) {
          var classType = (Parameter) parRef.getReferredParam();
          if (!((ClassType) classType.getType()).getClassname().getName().equals("EObject")) {
            classTypes.add(classType);
          }
        }
      }
      else {
        throw new MMINTException("Pattern constraint type " + patternPar.getClass().getName() + " not supported");
      }
      plCall.getParameters().add(plPar);
    }
    if (plPatternName != null) {
      var plMappingVar = createExtraParameterAndRef(RelationshipPackage.eINSTANCE.getMapping(), plParameters,
                                                    plVariables, plVarsMap);
      plCall.getParameters().add(createVariableReference(plMappingVar));
    }
    plConstraints.add(plConstraint);
    // type constraints
    for (var classType : classTypes) {
      var plClassConstraint = PatternLanguageFactory.eINSTANCE.createPatternCompositionConstraint();
      plClassConstraint.setNegative(false);
      var plClassCall = PatternLanguageFactory.eINSTANCE.createPatternCall();
      plClassConstraint.setCall(plClassCall);
      plClassCall.setPatternRef(this.libClassPattern);
      plClassCall.setTransitive(ClosureType.ORIGINAL);
      plClassCall.getParameters().add(createVariableReference(plVarsMap.get(classType.getName())));
      plClassCall.getParameters().add(createStringValue(((ClassType) classType.getType()).getClassname().getName()));
      plConstraints.add(plClassConstraint);
    }

    return plConstraints;
  }

  private List<? extends Constraint> liftCompareConstraint(CompareConstraint compareConstraint,
                                                           EList<Variable> plParameters, EList<Variable> plVariables,
                                                           Map<String, Variable> plVarsMap) throws Exception {
    //TODO MMINT[JAVA20] Convert to switch with pattern matching
    var left = compareConstraint.getLeftOperand();
    if (!(left instanceof VariableReference leftVarRef)) {
      throw new MMINTException("Left operand type " + left.getClass().getName() + " not supported");
    }
    var right = compareConstraint.getRightOperand();
    // special case: aggregation
    if (right instanceof AggregatedValue rightAgg) {
      if (!(leftVarRef.getVariable() instanceof ParameterRef leftParRef)) {
        throw new MMINTException("Left operand type " + left.getClass().getName() + " not supported in aggregations");
      }
      this.aggregator = Aggregator.valueOf(rightAgg.getAggregator().getSimpleName().toUpperCase());
      this.aggregatedVarName = leftParRef.getReferredParam().getName();
      var aggCall = rightAgg.getCall();
      // aggregation with pattern call
      if (aggCall instanceof PatternCall aggPatternCall) {
        var aggVars = aggPatternCall.getParameters().stream()
          .filter(p -> p instanceof VariableReference);
        if (this.aggregator != Aggregator.COUNT) {
          aggVars = aggVars.filter(p -> ((VariableReference) p).isAggregator());
        }
        this.aggregatedGroupBy = aggVars
          .map(p -> ((VariableReference) p).getVariable().getName())
          .filter(n -> !n.startsWith(ProductLineViatraReasoner.DONTCARE_VAR_NAME))
          .collect(Collectors.toSet());
        return createPatternCompositionConstraint(aggPatternCall, false, plParameters, plVariables, plVarsMap);
      }
      // aggregation with path expression
      else if (aggCall instanceof PathExpressionConstraint aggPathExpr) {
        String aggName;
        if (this.aggregator == Aggregator.COUNT) {
          aggName = aggPathExpr.getSrc().getVariable().getName();
          if (aggName.startsWith(ProductLineViatraReasoner.DONTCARE_VAR_NAME)) {
            aggName = ((VariableReference) aggPathExpr.getDst()).getVariable().getName();
          }
        }
        else {
          aggName = ((VariableReference) aggPathExpr.getDst()).getVariable().getName();
          createParameterAndRef(aggName, aggPathExpr.getEdgeTypes().get(0).getRefname().getEType(),
                                ParameterDirection.OUT, plParameters, plVariables, plVarsMap);
        }
        this.aggregatedGroupBy = Set.of(aggName);
        return createPathExpressionConstraint(aggPathExpr, plParameters, plVariables, plVarsMap);
      }
    }
    // normal case: var comparison
    if (!(right instanceof VariableReference rightVarRef)) {
      throw new MMINTException("Right operand type " + right.getClass().getName() + " not supported");
    }
    var plConstraint = PatternLanguageFactory.eINSTANCE.createCompareConstraint();
    var plLeftVarRef = liftVariableReference(leftVarRef, plVarsMap);
    plConstraint.setLeftOperand(plLeftVarRef);
    var plRightVarRef = liftVariableReference(rightVarRef, plVarsMap);
    plConstraint.setRightOperand(plRightVarRef);
    plConstraint.setFeature(compareConstraint.getFeature());

    return List.of(plConstraint);
  }

  private List<PatternCompositionConstraint> liftPatternCompositionConstraint(
                                               PatternCompositionConstraint patternConstraint,
                                               EList<Variable> plParameters, EList<Variable> plVariables,
                                               Map<String, Variable> plVarsMap) throws Exception {
    return createPatternCompositionConstraint((PatternCall) patternConstraint.getCall(), patternConstraint.isNegative(),
                                              plParameters, plVariables, plVarsMap);
  }

  private PatternBody liftBody(PatternBody body, EList<Variable> plParameters) throws Exception {
    /**
     * TODO MMINT[PL]
     *   Lift pattern call (recursive)
     *   Lift or
     *   Figure out how to support transitive closures
     *   Support eopposites
     *   Automatically delete attached references when deleting a class (or better, let Class own Reference)
     */
    var plBody = PatternLanguageFactory.eINSTANCE.createPatternBody();
    // variables pass #1: parameter references only
    var plVarsMap = new HashMap<String, Variable>();
    var plVariables = plBody.getVariables();
    for (var variable : body.getVariables()) {
      if (!(variable instanceof ParameterRef parRef) || !(parRef.getReferredParam().getType() instanceof ClassType)) {
        continue;
      }
      var plVariable = liftVariable(variable, plParameters);
      plVariables.add(plVariable);
      plVarsMap.put(plVariable.getName(), plVariable);
    }
    // constraints pass #1: lift all the path expressions, which generate extra parameters and variables
    var plConstraints = plBody.getConstraints();
    for (var constraint : body.getConstraints()) {
      if (!(constraint instanceof PathExpressionConstraint pathConstraint)) {
        continue;
      }
      var liftedConstraints = liftPathExpressionConstraint(pathConstraint, plParameters, plVariables, plVarsMap);
      plConstraints.addAll(liftedConstraints);
    }
    // variables pass #2: all other variables
    for (var variable : body.getVariables()) {
      if (plVarsMap.containsKey(variable.getName()) || !(variable.getType() instanceof ClassType)) {
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
      if (constraint instanceof CompareConstraint compareConstraint) {
        plConstraints.addAll(liftCompareConstraint(compareConstraint, plParameters, plVariables, plVarsMap));
      }
      else if (constraint instanceof PatternCompositionConstraint patternConstraint) {
        if (patternConstraint.isNegative()) {
          throw new MMINTException("Negative PatternCompositionConstraint not supported");
        }
        plConstraints.addAll(liftPatternCompositionConstraint(patternConstraint, plParameters, plVariables, plVarsMap));
      }
      else {
        throw new MMINTException("Constraint type " + constraint.getClass().getName() + " not supported");
      }
    }

    return plBody;
  }

  @Override
  @PLPipeline.Intercept
  public List<Object> evaluateQuery(String filePath, Object queryObj, EObject context,
                                    List<? extends EObject> queryArgs) throws Exception {
    reset();
    if (context instanceof ProductLine plContext) {
      // reload the resource to pull in the related metamodel without including all the models in the MID
      var scopeRoot = new ResourceSetImpl();
      var resource = scopeRoot.createResource(plContext.eResource().getURI());
      resource.load(Map.of());
      return super.evaluateQuery(filePath, queryObj, scopeRoot, queryArgs);
    }
    else {
      return super.evaluateQuery(filePath, queryObj, context, queryArgs);
    }
  }

  @Override
  @PLPipeline.Modify
  protected Pattern getPattern(String queryFilePath, Object queryObj) throws Exception {
    var pattern = super.getPattern(queryFilePath, queryObj);
    var plPattern = PatternLanguageFactory.eINSTANCE.createPattern();
    plPattern.setName(pattern.getName());
    var plParameters = plPattern.getParameters();
    // i/o parameters
    for (var parameter : pattern.getParameters()) {
      this.origParameters.add(parameter.getName());
      if (parameter.getType() instanceof ClassType) { // exclude native java types
        plParameters.add(liftParameter((Parameter) parameter));
      }
    }
    // body variables and constraints
    var plBodies = plPattern.getBodies();
    for (var body : pattern.getBodies()) {
      var plBody = liftBody(body, plParameters);
      plBodies.add(plBody);
    }

    return plPattern;
  }

  private List<Object> getAggregatedMatches(Collection<GenericPatternMatch> vMatches) throws Exception {
    // collect raw results and aggregate them
    var aggregations = Map.<String, Map<Set<Object>, Object>>of();
    for (var vMatch : vMatches) {
      var plElements = new HashSet<PLElement>();
      Set<Object> aggregatedMatch = new LinkedHashSet<>();
      for (var parameterName : vMatch.parameterNames()) {
        var parameterValue = vMatch.get(parameterName);
        if (this.aggregatedGroupBy.contains(parameterName)) {
          aggregatedMatch.add(parameterValue);
        }
        if (parameterValue instanceof PLElement plElement) {
          plElements.add(plElement);
        }
      }
      if (!areInAProduct(plElements)) {
        continue;
      }
      // aggregatedMatch has 1 value for min/max/sum, 1+ for count
      Object aggregatedValue;
      if (this.aggregator == Aggregator.COUNT) {
        aggregatedValue = 1;
      }
      else {
        aggregatedValue = aggregatedMatch.iterator().next();
        aggregatedMatch = Set.of();
      }
      var presenceConditions = getPresenceConditions(plElements);
      aggregations = this.featureReasoner.aggregate(presenceConditions, this.featuresConstraint, aggregatedMatch,
                                                    aggregatedValue, this.aggregator, aggregations);
    }

    // compact aggregated results: there can be same aggregated values for which formulas can be or-ed
    if (!aggregations.isEmpty()) {
      var aggregationsByValue = new HashMap<Map<Set<Object>, Object>, Set<String>>();
      for (var aggregationEntry : aggregations.entrySet()) {
        var formula = aggregationEntry.getKey();
        var aggregated = aggregationEntry.getValue().entrySet().stream()
          .filter(e -> e.getValue() != null) // no matches for this formula if null
          .collect(Collectors.toUnmodifiableMap(Entry::getKey, Entry::getValue));
        aggregationsByValue.compute(aggregated, (k, formulas) -> (formulas == null) ? new HashSet<>() : formulas)
                           .add(formula);
      }
      aggregations = this.featureReasoner.aggregate(this.featuresConstraint, aggregationsByValue);
    }

    // rearrange results for printing
    var matches = new ArrayList<>();
    for (var aggregationEntry : aggregations.entrySet()) {
      var formulaList = new ArrayList<>();
      formulaList.add(aggregationEntry.getKey()); // [formula, [match1, aggrValue1], ..., [matchN, aggrValueN]]
      for (var matchEntry : aggregationEntry.getValue().entrySet()) {
        var matchList = new ArrayList<>();
        matchList.addAll(matchEntry.getKey()); // match (can be empty for min/max/sum)
        matchList.add(matchEntry.getValue()); // aggregated value
        formulaList.add(matchList);
      }
      matches.add(formulaList);
    }

    return matches;
  }

  private List<Object> getStandardMatches(Collection<GenericPatternMatch> vMatches) throws Exception {
    var matches = new LinkedHashSet<>();
    for (var vMatch : vMatches) {
      var matchList = new ArrayList<>();
      var plElements = new HashSet<PLElement>();
      for (var parameterName : vMatch.parameterNames()) {
        var parameterValue = vMatch.get(parameterName);
        // the match only contains the parameters of the original query..
        if (this.origParameters.contains(parameterName)) {
          matchList.add(parameterValue);
        }
        // ..but extra lifting parameters must still be considered for compatible presence conditions
        if (parameterValue instanceof PLElement plElement) {
          plElements.add(plElement);
        }
      }
      // the inner list is redundant for one element
      var match = (matchList.size() == 1) ? matchList.get(0) : matchList;
      // adding the product line elements as extra query parameters may create spurious extra results
      // that differ only in their parameter order
      // the real (expensive) check for compatible presence conditions is short-circuited in that case
      if (matches.contains(match) || !areInAProduct(plElements)) {
        continue;
      }
      matches.add(match);
    }

    return List.copyOf(matches);
  }

  @Override
  @PLPipeline.Filter
  protected List<Object> getMatches(Collection<GenericPatternMatch> vMatches) throws Exception {
    return (this.aggregator != null) ? getAggregatedMatches(vMatches) : getStandardMatches(vMatches);
  }
}
