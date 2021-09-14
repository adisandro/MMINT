package edu.toronto.cs.se.mmint.productline.viatra;

import org.eclipse.viatra.query.patternlanguage.emf.vql.ClassType;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Constraint;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Parameter;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Pattern;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternBody;
import org.eclipse.viatra.query.patternlanguage.emf.vql.PatternLanguageFactory;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Type;
import org.eclipse.viatra.query.patternlanguage.emf.vql.Variable;

import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.viatra.reasoning.ViatraReasoner;

public class ProductLineViatraReasoner extends ViatraReasoner {

  private Type createType(Type type) {
    var plType = (Type) PatternLanguageFactory.eINSTANCE.create(type.eClass());
    if (type instanceof ClassType classType) {
      ((ClassType) plType).setClassname(ProductLinePackage.eINSTANCE.getClass_());
    }

    return plType;
  }

  private Variable createVariable(Variable variable) {
    var plVariable = (Variable) PatternLanguageFactory.eINSTANCE.create(variable.eClass());
    plVariable.setName(variable.getName());
    var plType = createType(variable.getType());
    plVariable.setType(plType);
    if (variable instanceof Parameter parameter) {
      ((Parameter) plVariable).setDirection(parameter.getDirection());
    }

    return plVariable;
  }

  private Constraint createConstraint(Constraint constraint) {
    var plConstraint = (Constraint) PatternLanguageFactory.eINSTANCE.create(constraint.eClass());

    return plConstraint;
  }

  private PatternBody createBody(PatternBody body) {
    var plBody = PatternLanguageFactory.eINSTANCE.createPatternBody();
    var plVariables = plBody.getVariables();
    for (var variable : body.getVariables()) {
      var plVariable = createVariable(variable);
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
    var plPattern = PatternLanguageFactory.eINSTANCE.createPattern();
    // i/o parameters
    var plParameters = plPattern.getParameters();
    for (var parameter : pattern.getParameters()) {
      var plParameter = createVariable(parameter);
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
