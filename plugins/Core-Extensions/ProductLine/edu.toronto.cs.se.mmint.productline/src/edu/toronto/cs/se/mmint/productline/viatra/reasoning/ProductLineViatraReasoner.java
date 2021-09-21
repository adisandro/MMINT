package edu.toronto.cs.se.mmint.productline.viatra.reasoning;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ClassType;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ClosureType;
import org.eclipse.viatra.query.patternlanguage.emf.vql.CompareConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Constraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Parameter;
import org.eclipse.viatra.query.patternlanguage.emf.vql.ParameterRef;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PathExpressionConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Pattern;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternBody;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternCompositionConstraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternLanguageFactory;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Type;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Variable;
import org.eclipse.viatra.query.patternlanguage.emf.vql.VariableReference;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.viatra.reasoning.ViatraReasoner;

@SuppressWarnings("restriction")
public class ProductLineViatraReasoner extends ViatraReasoner {

  private record LiftedConstraint(List<? extends Constraint> plConstraints, int addedVars) {}

  @Override
  public String getName() {
    return "Viatra for Product Lines";
  }

  private Type liftType(Type type) {
    var plType = (Type) PatternLanguageFactory.eINSTANCE.create(type.eClass());
    if (type instanceof ClassType classType) {
      ((ClassType) plType).setClassname(ProductLinePackage.eINSTANCE.getClass_());
    }

    return plType;
  }

  private Variable liftVariable(Variable variable, List<Variable> plParameters) {
    var plVariable = (Variable) PatternLanguageFactory.eINSTANCE.create(variable.eClass());
    plVariable.setName(variable.getName());
    if (variable instanceof Parameter parameter) {
      var plType = liftType(variable.getType());
      plVariable.setType(plType);
      ((Parameter) plVariable).setDirection(parameter.getDirection());
    }
    else if (variable instanceof ParameterRef parameterRef) {
      plParameters.stream()
        .filter(p -> p.getName().equals(parameterRef.getReferredParam().getName()))
        .findFirst()
        .ifPresent(p -> ((ParameterRef) plVariable).setReferredParam(p));
    }

    return plVariable;
  }

  private VariableReference createVariableReference(Variable plVar) {
    var plVarRef = PatternLanguageFactory.eINSTANCE.createVariableReference();
    plVarRef.setAggregator(false);
    plVarRef.setVar(plVar.getName());
    plVarRef.setVariable(plVar);

    return plVarRef;
  }

  private VariableReference liftVariableReference(VariableReference varRef, Map<Variable, Variable> varsMap)
                                                 throws MMINTException {
    var plVar = varsMap.get(varRef.getVariable());
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
  private List<PatternCompositionConstraint> liftPathExpressionConstraint(PathExpressionConstraint pathConstraint,
                                                                          EList<Variable> plVariables,
                                                                          Map<Variable, Variable> varsMap,
                                                                          Pattern libPattern, int addedVars)
                                                                         throws MMINTException {
    var plConstraints = new ArrayList<PatternCompositionConstraint>();
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
        var plSrc = liftVariableReference(pathConstraint.getSrc(), varsMap);
        plCall.getParameters().add(plSrc);
        var plSrcType = PatternLanguageFactory.eINSTANCE.createStringValue();
        plSrcType.setValue(pathConstraint.getSourceType().getClassname().getName());
        plCall.getParameters().add(plSrcType);
      }
      else {
      }
      if (edgeFeature instanceof EReference edgeReference) {
        // path destination
        var plDst = liftVariableReference((VariableReference) pathConstraint.getDst(), varsMap);
        plCall.getParameters().add(plDst);
        var plDstType = PatternLanguageFactory.eINSTANCE.createStringValue();
        plDstType.setValue(edgeReference.getEReferenceType().getName());
        plCall.getParameters().add(plDstType);
        // path edge (EReference)
        var plRefVar = PatternLanguageFactory.eINSTANCE.createVariable();
        plRefVar.setName("ref" + (i+addedVars));
        plVariables.add(plRefVar);
        var plRef = createVariableReference(plRefVar);
        plCall.getParameters().add(plRef);
        var plRefType = PatternLanguageFactory.eINSTANCE.createStringValue();
        plRefType.setValue(edgeReference.getName());
        plCall.getParameters().add(plRefType);
      }
      else {
        //TODO implement a library pattern to lift attribute constraints and use it here
      }
      plConstraints.add(plConstraint);
    }

    return plConstraints;
  }

  private CompareConstraint liftCompareConstraint(CompareConstraint compareConstraint,
                                                  Map<Variable, Variable> varsMap) throws MMINTException {
    var plConstraint = PatternLanguageFactory.eINSTANCE.createCompareConstraint();
    if (compareConstraint.getLeftOperand() instanceof VariableReference left) {
      var plLeft = liftVariableReference(left, varsMap);
      plConstraint.setLeftOperand(plLeft);
    }
    if (compareConstraint.getRightOperand() instanceof VariableReference right) {
      var plRight = liftVariableReference(right, varsMap);
      plConstraint.setRightOperand(plRight);
    }
    //TODO implement value comparison?
    plConstraint.setFeature(compareConstraint.getFeature());

    return plConstraint;
  }

  private LiftedConstraint liftConstraint(Constraint constraint, EList<Variable> plVariables,
                                          Map<Variable, Variable> varsMap, Pattern libPattern, int addedVars)
                                         throws MMINTException {
    if (constraint instanceof PathExpressionConstraint pathConstraint) {
      var plConstraints = liftPathExpressionConstraint(pathConstraint, plVariables, varsMap, libPattern, addedVars);
      return new LiftedConstraint(plConstraints, plConstraints.size());
    }
    else if (constraint instanceof CompareConstraint compareConstraint) {
      return new LiftedConstraint(List.of(liftCompareConstraint(compareConstraint, varsMap)), 0);
    }
    else {
      throw new MMINTException("Constraint type " + constraint.getClass().getName() + " not supported");
    }
  }

  private void addPresenceConditions() {
    
  }

  private PatternBody liftBody(PatternBody body, EList<Variable> plParameters, Pattern libPattern)
                              throws MMINTException {
    var plBody = PatternLanguageFactory.eINSTANCE.createPatternBody();
    var varsMap = new HashMap<Variable, Variable>();
    var plVariables = plBody.getVariables();
    for (var variable : body.getVariables()) {
      var plVariable = liftVariable(variable, plParameters);
      plVariables.add(plVariable);
      varsMap.put(variable, plVariable);
    }
    var addedVars = 0;
    for (var constraint : body.getConstraints()) {
      var plConstraints = liftConstraint(constraint, plVariables, varsMap, libPattern, addedVars);
      plBody.getConstraints().addAll(plConstraints.plConstraints());
      addedVars += plConstraints.addedVars();
    }
    addPresenceConditions();

    return plBody;
  }

  @Override
  protected Pattern getPattern(String queryFilePath, String queryName) throws Exception {
    var pattern = super.getPattern(queryFilePath, queryName);
    var libFilePath = Paths.get(queryFilePath).getParent().getParent().resolve("library/pl.vql").toString();
    var libPattern = super.getPattern(libFilePath, "connection");
    var plPattern = PatternLanguageFactory.eINSTANCE.createPattern();
    plPattern.setName(pattern.getName());
    // i/o parameters
    for (var parameter : pattern.getParameters()) {
      var plParameter = liftVariable(parameter, List.of());
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
}
