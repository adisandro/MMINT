package edu.toronto.cs.se.mmint.productline.viatra.reasoning;

import java.nio.file.Paths;
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ClosureType;
import org.eclipse.viatra.query.patternlanguage.emf.vql.CompareConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Constraint;
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

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.viatra.reasoning.ViatraReasoner;

@SuppressWarnings("restriction")
public class ProductLineViatraReasoner extends ViatraReasoner {
  public final static String EXTRA_VAR_NAME = "ref";
  public final static String PC_VAR_SUFFIX = "PC";
  public final static String FEATURES_VAR_NAME = "features";
  private record LiftedConstraint(List<? extends Constraint> plConstraints, Set<Variable> pcVars, int extraVars) {}
  private Set<String> liftedPCParameters;

  @Override
  public String getName() {
    return "Viatra for Product Lines";
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

  private StringValue createStringValue(String value) {
    var plStringValue = PatternLanguageFactory.eINSTANCE.createStringValue();
    plStringValue.setValue(value);

    return plStringValue;
  }

  private PathExpressionConstraint createPathExpressionConstraint(EClass srcType, Variable srcVar,
                                                                  EStructuralFeature dstType, Variable dstVar) {
    var plPathConstraint = PatternLanguageFactory.eINSTANCE.createPathExpressionConstraint();
    plPathConstraint.setTransitive(ClosureType.ORIGINAL);
    var plType = PatternLanguageFactory.eINSTANCE.createClassType();
    plType.setClassname(srcType);
    plPathConstraint.setSourceType(plType);
    plPathConstraint.setSrc(createVariableReference(srcVar));
    plPathConstraint.setDst(createVariableReference(dstVar));
    var plEdge = PatternLanguageFactory.eINSTANCE.createReferenceType();
    plEdge.setRefname(dstType);
    plPathConstraint.getEdgeTypes().add(plEdge);

    return plPathConstraint;
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
  private LiftedConstraint liftPathExpressionConstraint(PathExpressionConstraint pathConstraint,
                                                        EList<Variable> plVariables, Map<String, Variable> plVarsMap,
                                                        Pattern libPattern, int extraVars) throws MMINTException {
    var plConstraints = new ArrayList<PatternCompositionConstraint>();
    var pcVars = new HashSet<Variable>();
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
        var plSrc = liftVariableReference(pathConstraint.getSrc(), plVarsMap);
        plCall.getParameters().add(plSrc);
        plCall.getParameters().add(createStringValue(pathConstraint.getSourceType().getClassname().getName()));
        pcVars.add(plSrc.getVariable());
      }
      else {
        //TODO handle multiple edges
      }
      if (edgeFeature instanceof EReference edgeReference) {
        // path destination
        var plDst = liftVariableReference((VariableReference) pathConstraint.getDst(), plVarsMap);
        plCall.getParameters().add(plDst);
        plCall.getParameters().add(createStringValue(edgeReference.getEReferenceType().getName()));
        pcVars.add(plDst.getVariable());
        // path edge (EReference)
        var plEdgeVar = createVariable(PatternLanguagePackage.eINSTANCE.getVariable(),
                                       ProductLineViatraReasoner.EXTRA_VAR_NAME + (i+extraVars));
        plVariables.add(plEdgeVar);
        plCall.getParameters().add(createVariableReference(plEdgeVar));
        plCall.getParameters().add(createStringValue(edgeReference.getName()));
        pcVars.add(plEdgeVar);
      }
      else {
        //TODO implement a library pattern to lift attribute constraints and use it here
      }
      plConstraints.add(plConstraint);
    }

    return new LiftedConstraint(plConstraints, pcVars, plConstraints.size());
  }

  private LiftedConstraint liftCompareConstraint(CompareConstraint compareConstraint, Map<String, Variable> plVarsMap)
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

    return new LiftedConstraint(List.of(plConstraint), Set.of(), 0);
  }

  private LiftedConstraint liftConstraint(Constraint constraint, EList<Variable> plVariables,
                                          Map<String, Variable> plVarsMap, Pattern libPattern, int extraVars)
                                         throws MMINTException {
    if (constraint instanceof PathExpressionConstraint pathConstraint) {
      return liftPathExpressionConstraint(pathConstraint, plVariables, plVarsMap, libPattern, extraVars);
    }
    else if (constraint instanceof CompareConstraint compareConstraint) {
      return liftCompareConstraint(compareConstraint, plVarsMap);
    }
    else {
      throw new MMINTException("Constraint type " + constraint.getClass().getName() + " not supported");
    }
  }

  private List<Constraint> addPresenceConditions(EList<Variable> plParameters, EList<Variable> plVariables,
                                                 Set<Variable> pcVariables) {
    var plConstraints = new ArrayList<Constraint>();
    // feature model
    var varType = PatternLanguagePackage.eINSTANCE.getVariable();
    var plRootType = ProductLinePackage.eINSTANCE.getProductLine();
    var plRootVar = createVariable(varType, "pl");
    plVariables.add(plRootVar);
    var plAnyClassVar = pcVariables.stream()
      .filter(v -> !v.getName().contains(ProductLineViatraReasoner.EXTRA_VAR_NAME))
      .findAny()
      .get();
    var plConstraint1 = createPathExpressionConstraint(plRootType, plRootVar,
                                                       ProductLinePackage.eINSTANCE.getProductLine_Classes(),
                                                       plAnyClassVar);
    plConstraints.add(plConstraint1);
    var pcFeaturesPar = createParameter(ProductLineViatraReasoner.FEATURES_VAR_NAME,
                                        EcorePackage.eINSTANCE.getEString(), ParameterDirection.OUT);
    plParameters.add(pcFeaturesPar);
    var plFeaturesVar = createParameterRef(ProductLineViatraReasoner.FEATURES_VAR_NAME, pcFeaturesPar);
    plVariables.add(plFeaturesVar);
    var plConstraint2 = createPathExpressionConstraint(plRootType, plRootVar,
                                                       ProductLinePackage.eINSTANCE.getProductLine_Features(),
                                                       plFeaturesVar);
    plConstraints.add(plConstraint2);
    // presence conditions
    var plElemType = ProductLinePackage.eINSTANCE.getPLElement();
    var plPCType = ProductLinePackage.eINSTANCE.getPLElement_PresenceCondition();
    for (var pcVar : pcVariables) {
      var pcName = pcVar.getName() + ProductLineViatraReasoner.PC_VAR_SUFFIX;
      var pcValuePar = createParameter(pcName, EcorePackage.eINSTANCE.getEString(), ParameterDirection.OUT);
      plParameters.add(pcValuePar);
      var pcValueVar = createParameterRef(pcName, pcValuePar);
      plVariables.add(pcValueVar);
      this.liftedPCParameters.add(pcValueVar.getName());
      plConstraints.add(createPathExpressionConstraint(plElemType, pcVar, plPCType, pcValueVar));
    }

    return plConstraints;
  }

  private PatternBody liftBody(PatternBody body, EList<Variable> plParameters, Pattern libPattern)
                              throws MMINTException {
    var plBody = PatternLanguageFactory.eINSTANCE.createPatternBody();
    var plVarsMap = new HashMap<String, Variable>();
    var plVariables = plBody.getVariables();
    for (var variable : body.getVariables()) {
      var plVariable = liftVariable(variable, plParameters);
      plVariables.add(plVariable);
      plVarsMap.put(variable.getName(), plVariable);
    }
    var extraVariables = 0;
    var plConstraints = plBody.getConstraints();
    var pcVariables = new HashSet<Variable>();
    for (var constraint : body.getConstraints()) {
      var plConstraint = liftConstraint(constraint, plVariables, plVarsMap, libPattern, extraVariables);
      plConstraints.addAll(plConstraint.plConstraints());
      extraVariables += plConstraint.extraVars();
      pcVariables.addAll(plConstraint.pcVars());
    }
    plConstraints.addAll(addPresenceConditions(plParameters, plVariables, pcVariables));

    return plBody;
  }

  @Override
  protected Pattern getPattern(String queryFilePath, String queryName) throws Exception {
    var pattern = super.getPattern(queryFilePath, queryName);
    this.liftedPCParameters = new HashSet<>();
    var libFilePath = Paths.get(queryFilePath).getParent().getParent().resolve("library/pl.vql").toString();
    var libPattern = super.getPattern(libFilePath, "connection");
    var plPattern = PatternLanguageFactory.eINSTANCE.createPattern();
    plPattern.setName(pattern.getName());
    // i/o parameters
    for (var parameter : pattern.getParameters()) {
      var plParameter = liftParameter((Parameter) parameter);
      plPattern.getParameters().add(plParameter);
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
    // preserve order and remove duplicates:
    // adding the presence conditions as query parameters may create spurious extra results
    // that differ only in the order of presence conditions returned
    var matches = new LinkedHashSet<>();
    for (var vMatch : vMatches) {
      var features = (String) vMatch.get(ProductLineViatraReasoner.FEATURES_VAR_NAME);
      var presenceConditions = vMatch.parameterNames().stream()
        .filter(p -> this.liftedPCParameters.contains(p))
        .map(p -> (String) vMatch.get(p))
        .collect(Collectors.toList());
      if (!ProductLine.isQueryPattern(features, presenceConditions.toArray(new String[0]))) {
        continue;
      }
      var match = (vMatch.parameterNames().size() == (this.liftedPCParameters.size() + 2)) ?
        vMatch.get(0) :
        vMatch.parameterNames().stream()
          .filter(p -> !this.liftedPCParameters.contains(p) && !p.equals(ProductLineViatraReasoner.FEATURES_VAR_NAME))
          .map(p -> vMatch.get(p))
          .collect(Collectors.toList());
      matches.add(match);
    }
    this.liftedPCParameters = null;

    return new ArrayList<>(matches);
  }
}
