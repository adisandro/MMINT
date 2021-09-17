package edu.toronto.cs.se.mmint.productline.viatra;

import java.nio.file.Paths;
import java.util.List;

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

import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.viatra.reasoning.ViatraReasoner;

@SuppressWarnings("restriction")
public class ProductLineViatraReasoner extends ViatraReasoner {

  private Type createType(Type type) {
    var plType = (Type) PatternLanguageFactory.eINSTANCE.create(type.eClass());
    if (type instanceof ClassType classType) {
      ((ClassType) plType).setClassname(ProductLinePackage.eINSTANCE.getClass_());
    }

    return plType;
  }

  private Variable createVariable(Variable variable, List<Variable> plParameters) {
    var plVariable = (Variable) PatternLanguageFactory.eINSTANCE.create(variable.eClass());
    plVariable.setName(variable.getName());
    if (variable instanceof Parameter parameter) {
      var plType = createType(variable.getType());
      plVariable.setType(plType);
      ((Parameter) plVariable).setDirection(parameter.getDirection());
    }
    if (variable instanceof ParameterRef parameterRef) {
      plParameters.stream()
        .filter(p -> p.getName().equals(parameterRef.getReferredParam().getName()))
        .findFirst()
        .ifPresent(p -> ((ParameterRef) plVariable).setReferredParam(p));
    }

    return plVariable;
  }

  private Constraint createConstraint(Constraint constraint) {
    var plConstraint = (Constraint) PatternLanguageFactory.eINSTANCE.create(constraint.eClass());
    if (constraint instanceof PathExpressionConstraint pathConstraint) {
      ((PathExpressionConstraint) plConstraint).setSrc(null);// var ref child
      ((PathExpressionConstraint) plConstraint).setDst(null);// var ref parent1
      ((PathExpressionConstraint) plConstraint).setSourceType(null);// class type classdiagram.Class
      ((PathExpressionConstraint) plConstraint).setTransitive(pathConstraint.getTransitive());
      plConstraint = PatternLanguageFactory.eINSTANCE.createPatternCompositionConstraint();
      ((PatternCompositionConstraint) plConstraint).setNegative(false);
      var plCall = PatternLanguageFactory.eINSTANCE.createPatternCall();
      ((PatternCompositionConstraint) plConstraint).setCall(plCall);
      plCall.setPatternRef(null);// pattern connection
      plCall.getParameters();// 3 var ref, 3 string value
      plCall.setTransitive(ClosureType.ORIGINAL);
    }
    if (constraint instanceof CompareConstraint compareConstraint) {
      ((CompareConstraint) plConstraint).setLeftOperand(null);// var ref parent1
      ((CompareConstraint) plConstraint).setRightOperand(null);// var ref parent2
      ((CompareConstraint) plConstraint).setFeature(compareConstraint.getFeature());
    }

    return plConstraint;
  }

  private PatternBody createBody(PatternBody body) {
    var plBody = PatternLanguageFactory.eINSTANCE.createPatternBody();
    var plParameters = ((Pattern) plBody.eContainer()).getParameters();
    var plVariables = plBody.getVariables();
    for (var variable : body.getVariables()) {
      var plVariable = createVariable(variable, plParameters);
      plVariables.add(plVariable);
    }
    var plConstraints = plBody.getConstraints();
    for (var constraint : body.getConstraints()) {
      var plConstraint = createConstraint(constraint);
      plConstraints.add(plConstraint);
    }

    return plBody;
  }

  @Override
  protected Pattern getPattern(String queryFilePath, String queryName) throws Exception {
    var pattern = super.getPattern(queryFilePath, queryName);
    var libFilePath = Paths.get(queryFilePath).getParent().getParent().resolve("pl.vql").toString();
    var connectionPattern = super.getPattern(libFilePath, "connection");
    var plPattern = PatternLanguageFactory.eINSTANCE.createPattern();
    // i/o parameters
    var plParameters = plPattern.getParameters();
    for (var parameter : pattern.getParameters()) {
      var plParameter = createVariable(parameter, List.of());
      plParameters.add(plParameter);
    }
    // body variables and constraints
    var plBodies = plPattern.getBodies();
    for (var body : pattern.getBodies()) {
      var plBody = createBody(body);
      plBodies.add(plBody);
    }

    return plPattern;
  }
}
