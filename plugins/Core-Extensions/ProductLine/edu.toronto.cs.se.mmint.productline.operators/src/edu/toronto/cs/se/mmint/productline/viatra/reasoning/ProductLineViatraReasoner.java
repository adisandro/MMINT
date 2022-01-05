/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.viatra.query.patternlanguage.emf.vql.AggregatedValue;
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
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineFeatureConstraintTrait;
import edu.toronto.cs.se.mmint.productline.reasoning.IProductLineQueryTrait;
import edu.toronto.cs.se.mmint.viatra.reasoning.ViatraReasoner;

@SuppressWarnings("restriction")
public class ProductLineViatraReasoner extends ViatraReasoner implements IProductLineQueryTrait {
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
  private @Nullable String aggregatorName, aggregatedVarName;
  private Set<String> aggregatedGroupBy;
  private @Nullable IProductLineFeatureConstraintTrait featureReasoner;
  private String featuresConstraint;

  public ProductLineViatraReasoner() throws Exception {
    var plModelType = MIDTypeRegistry.<Model>getType(ProductLinePackage.eNS_URI);
    var libFilePath = MIDTypeRegistry.getBundlePath(plModelType, ProductLineViatraReasoner.VIATRA_LIB_PATH);
    var libVqlRoot = getVQLRoot(libFilePath, false);
    this.libRefPattern = super.getPattern(libVqlRoot, ProductLineViatraReasoner.LIB_REFERENCE_PATTERN);
    this.libAttrPattern = super.getPattern(libVqlRoot, ProductLineViatraReasoner.LIB_ATTRIBUTE_PATTERN);
    this.libClassPattern = super.getPattern(libVqlRoot, ProductLineViatraReasoner.LIB_CLASSTYPE_PATTERN);
    reset();
  }

  private void reset() {
    this.origParameters = new HashSet<>();
    this.extraVariables = 0;
    this.aggregatorName = null;
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
    if (!(data instanceof MID mid)) {
      return false;
    }
    return mid.getModels().stream()
      .filter(m -> !(m instanceof ModelRel))
      .anyMatch(m -> MIDTypeHierarchy.instanceOf(m, ProductLinePackage.eNS_URI, false));
  }

  @Override
  public boolean areInAProduct(Set<PLElement> plElements) throws MMINTException {
    if (plElements.isEmpty()) {
      return false;
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

  private ParameterRef createParameterAndRef(String name, EClass typeClass, ParameterDirection direction,
                                             EList<Variable> plParameters, EList<Variable> plVariables,
                                             Map<String, Variable> plVarsMap) {
    var plParameterRef = createParameterAndRef(name, typeClass, direction);
    plVarsMap.put(name, plParameterRef);
    plVariables.add(plParameterRef);
    plParameters.add(plParameterRef.getReferredParam());

    return plParameterRef;
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

  // converts don't care var to extra par
  private void liftDontCareVar(String varName, EList<Variable> plParameters, EList<Variable> plVariables,
                               Map<String, Variable> plVarsMap) {
    var plDontCareVar = plVarsMap.remove(varName);
    plVariables.remove(plDontCareVar);
    varName = getNextExtraVariableName();
    createParameterAndRef(varName, ProductLinePackage.eINSTANCE.getClass_(), ParameterDirection.OUT, plParameters,
                          plVariables, plVarsMap);
  }

  /**
   * Lifts a path constraint, i.e.:
   * Class.superclass(child, parent);
   * into:
   * reference(child, "Class", parent, "Class", ref, "superclass");
   */
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
      var plSrcVar = plVarsMap.get(srcName);
      if (plSrcVar == null) {
        plSrcVar = createParameterAndRef(srcName, plElemType, ParameterDirection.OUT, plParameters, plVariables,
                                         plVarsMap);
      }
      var plSrc = createVariableReference(plSrcVar);
      plCall.getParameters().add(plSrc);
      plCall.getParameters().add(createStringValue(srcType));
      // reference destination
      if (edgeFeature instanceof EReference edgeReference) {
        var dstName = (i == (pathConstraint.getEdgeTypes().size()-1)) ?
          ((VariableReference) pathConstraint.getDst()).getVariable().getName() :
          getNextExtraVariableName();
        var plDstVar = plVarsMap.get(dstName);
        if (plDstVar == null) {
          plDstVar = createParameterAndRef(dstName, plElemType, ParameterDirection.OUT, plParameters, plVariables,
                                           plVarsMap);
        }
        var plDst = createVariableReference(plDstVar);
        plCall.getParameters().add(plDst);
        plCall.getParameters().add(createStringValue(edgeReference.getEReferenceType().getName()));
      }
      // path edge
      var edgeName = getNextExtraVariableName();
      var plEdgeVar = createParameterAndRef(edgeName, plElemType, ParameterDirection.OUT, plParameters, plVariables,
                                            plVarsMap);
      plCall.getParameters().add(createVariableReference(plEdgeVar));
      plCall.getParameters().add(createStringValue(edgeFeature.getName()));
      // attribute value
      if (edgeFeature instanceof EAttribute edgeAttribute) {
        var dst = pathConstraint.getDst();
        ValueReference plValue;
        //TODO MMINT[JAVA19] Convert to switch with pattern matching
        if (dst instanceof StringValue strDst) {
          plValue = createStringValue(strDst.getValue());
        }
        else if (dst instanceof EnumValue enumDst) {
          plValue = createStringValue(enumDst.getLiteral().getLiteral());
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
        if (varName.startsWith(ProductLineViatraReasoner.DONTCARE_VAR_NAME)) {
          liftDontCareVar(varName, plParameters, plVariables, plVarsMap);
        }
        plPar = createVariableReference(plVarsMap.get(varName));
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
      var plMappingVar = createParameterAndRef(getNextExtraVariableName(), RelationshipPackage.eINSTANCE.getMapping(),
                                               ParameterDirection.OUT, plParameters, plVariables, plVarsMap);
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
    //TODO MMINT[JAVA19] Convert to switch with pattern matching
    var left = compareConstraint.getLeftOperand();
    if (!(left instanceof VariableReference leftVarRef)) {
      throw new MMINTException("Left operand type " + left.getClass().getName() + " not supported");
    }
    var right = compareConstraint.getRightOperand();
    // special case: aggregation
    if (right instanceof AggregatedValue rightAgg) {
      if (leftVarRef.getVariable() instanceof ParameterRef leftParRef) {
        this.aggregatorName = rightAgg.getAggregator().getSimpleName();
        this.aggregatedVarName = leftParRef.getReferredParam().getName();
        if (this.aggregatorName.equals("count")) { // remove from parameters
          var plAggVar = plVarsMap.remove(this.aggregatedVarName);
          plVariables.remove(plAggVar);
          plParameters.remove(((ParameterRef) plAggVar).getReferredParam());
        }
      }
      var aggCall = rightAgg.getCall();
      // aggregation with pattern call
      if (aggCall instanceof PatternCall aggPatternCall) {
        if (leftVarRef.getVariable() instanceof ParameterRef leftParRef) {
          this.aggregatedGroupBy = aggPatternCall.getParameters().stream()
            .filter(p -> p instanceof VariableReference)
            .map(p -> ((VariableReference) p).getVariable().getName())
            .filter(n -> !n.startsWith(ProductLineViatraReasoner.DONTCARE_VAR_NAME))
            .collect(Collectors.toSet());
        }
        return createPatternCompositionConstraint(aggPatternCall, false, plParameters, plVariables, plVarsMap);
      }
      // aggregation with path expression
      else if (aggCall instanceof PathExpressionConstraint aggPathExpr) {
        this.aggregatedGroupBy = Set.of(((VariableReference) aggPathExpr.getDst()).getVariable().getName());
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
      if (constraint instanceof CompareConstraint compareConstraint) {
        plConstraints.addAll(liftCompareConstraint(compareConstraint, plParameters, plVariables, plVarsMap));
      }
      else if (constraint instanceof PatternCompositionConstraint patternConstraint) {
        plConstraints.addAll(liftPatternCompositionConstraint(patternConstraint, plParameters, plVariables, plVarsMap));
      }
      else {
        throw new MMINTException("Constraint type " + constraint.getClass().getName() + " not supported");
      }
    }

    return plBody;
  }

  @Override
  public List<Object> evaluateQuery(String queryFilePath, String queryName, EObject context,
                                    List<? extends EObject> queryArgs) throws Exception {
    reset();
    return super.evaluateQuery(queryFilePath, queryName, context, queryArgs);
  }

  @Override
  protected Pattern getPattern(String queryFilePath, String queryName) throws Exception {
    var pattern = super.getPattern(queryFilePath, queryName);
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
      var plBody = liftBody(body, plPattern.getParameters());
      plBodies.add(plBody);
    }

    return plPattern;
  }

  private List<Object> getAggregatedMatches(Collection<GenericPatternMatch> vMatches) throws Exception {
    // first pass:
    var aggregations = Map.<String, Map<Set<Object>, Integer>>of();
     for (var vMatch : vMatches) {
      var matchAsList = new ArrayList<>();
      var plElements = new HashSet<PLElement>();
      var aggregationGroup = new HashSet<>();
      for (var parameterName : vMatch.parameterNames()) {
        var parameter = vMatch.get(parameterName);
        matchAsList.add(parameter);
        if (this.aggregatedGroupBy.contains(parameterName)) {
          aggregationGroup.add(parameter);
        }
        if (parameter instanceof PLElement plElement) {
          plElements.add(plElement);
          if (this.featureReasoner == null) {
            var pl = plElement.getProductLine();
            this.featureReasoner = pl.getReasoner();
            this.featuresConstraint = pl.getFeaturesConstraint();
          }
        }
      }
      if (!areInAProduct(plElements)) {
        continue;
      }
      var aggregator = switch(this.aggregatorName) {
        case "count" -> new Aggregator(0, (a, b) -> a + b);
        case "sum"   -> new Aggregator(0, (a, b) -> a + b);
        case "min"   -> new Aggregator(Integer.MIN_VALUE, (a, b) -> (a <= b) ? a : b);
        case "max"   -> new Aggregator(Integer.MAX_VALUE, (a, b) -> (a >= b) ? a : b);
        default      -> throw new MMINTException("Unsupported aggregator '" + this.aggregatorName + "'");
      };
      var aggregatedValue = 1;//TODO Fetch from the matches
      var presenceConditions = getPresenceConditions(plElements);//TODO What happens if it's a true?
      aggregations = this.featureReasoner.aggregate(presenceConditions, this.featuresConstraint, aggregationGroup,
                                                    aggregatedValue, aggregator, aggregations);
    }

    // second pass:
    var matches = new ArrayList<>();
    for (var aggregationEntry : aggregations.entrySet()) {
      var formulaList = new ArrayList<>();
      formulaList.add(aggregationEntry.getKey()); // [formula, [match1, aggrValue1], ..., [matchN, aggrValueN]]
      for (var matchEntry : aggregationEntry.getValue().entrySet()) {
        var matchList = new ArrayList<>();
//        var aggregatedValue = matchEntry.getValue();
//        if (aggregatedValue == 0) {
//          continue;
//        }
        matchList.addAll(matchEntry.getKey()); // match
        matchList.add(matchEntry.getValue()); // aggregated value
        formulaList.add(matchList);
      }
//      if (formulaList.size() == 1) { // no matches for this formula
//        continue;
//      }
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
        var parameter = vMatch.get(parameterName);
        // the match only contains the parameters of the original query..
        if (this.origParameters.contains(parameterName)) {
          matchList.add(parameter);
        }
        // ..but extra lifting parameters must still be considered for compatible presence conditions later
        if (parameter instanceof PLElement plElement) {
          plElements.add(plElement);
          if (this.featureReasoner == null) {
            var pl = plElement.getProductLine();
            this.featureReasoner = pl.getReasoner();
            this.featuresConstraint = pl.getFeaturesConstraint();
          }
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
  protected List<Object> getMatches(Collection<GenericPatternMatch> vMatches) throws Exception {
    return (this.aggregatorName != null) ? getAggregatedMatches(vMatches) : getStandardMatches(vMatches);
  }
}
