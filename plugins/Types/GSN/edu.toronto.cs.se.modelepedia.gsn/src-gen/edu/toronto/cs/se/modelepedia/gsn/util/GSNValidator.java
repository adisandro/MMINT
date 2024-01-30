/*******************************************************************************
 * Copyright (c) 2017, 2024 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import edu.toronto.cs.se.modelepedia.gsn.ASIL;
import edu.toronto.cs.se.modelepedia.gsn.ASILLevel;
import edu.toronto.cs.se.modelepedia.gsn.ASILfulElement;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.Assumption;
import edu.toronto.cs.se.modelepedia.gsn.Context;
import edu.toronto.cs.se.modelepedia.gsn.Contextual;
import edu.toronto.cs.se.modelepedia.gsn.Contextualizable;
import edu.toronto.cs.se.modelepedia.gsn.Decoratable;
import edu.toronto.cs.se.modelepedia.gsn.DecoratorType;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.InContextOf;
import edu.toronto.cs.se.modelepedia.gsn.Justification;
import edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Solution;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;
import edu.toronto.cs.se.modelepedia.gsn.Template;
import edu.toronto.cs.se.modelepedia.gsn.Undeveloped;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage
 * @generated
 */
public class GSNValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static final GSNValidator INSTANCE = new GSNValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.modelepedia.gsn";

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = GSNValidator.GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public GSNValidator() {
    super();
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EPackage getEPackage() {
    return GSNPackage.eINSTANCE;
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the model.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return switch (classifierID) {
    case GSNPackage.SAFETY_CASE -> validateSafetyCase((SafetyCase)value, diagnostics, context);
    case GSNPackage.ARGUMENT_ELEMENT -> validateArgumentElement((ArgumentElement)value, diagnostics, context);
    case GSNPackage.DECORATABLE -> validateDecoratable((Decoratable)value, diagnostics, context);
    case GSNPackage.SUPPORTABLE -> validateSupportable((Supportable)value, diagnostics, context);
    case GSNPackage.SUPPORTER -> validateSupporter((Supporter)value, diagnostics, context);
    case GSNPackage.SUPPORTED_BY -> validateSupportedBy((SupportedBy)value, diagnostics, context);
    case GSNPackage.CONTEXTUALIZABLE -> validateContextualizable((Contextualizable)value, diagnostics, context);
    case GSNPackage.CONTEXTUAL -> validateContextual((Contextual)value, diagnostics, context);
    case GSNPackage.IN_CONTEXT_OF -> validateInContextOf((InContextOf)value, diagnostics, context);
    case GSNPackage.ASI_LFUL_ELEMENT -> validateASILfulElement((ASILfulElement)value, diagnostics, context);
    case GSNPackage.GOAL -> validateGoal((Goal)value, diagnostics, context);
    case GSNPackage.STRATEGY -> validateStrategy((Strategy)value, diagnostics, context);
    case GSNPackage.SOLUTION -> validateSolution((Solution)value, diagnostics, context);
    case GSNPackage.CONTEXT -> validateContext((Context)value, diagnostics, context);
    case GSNPackage.JUSTIFICATION -> validateJustification((Justification)value, diagnostics, context);
    case GSNPackage.ASSUMPTION -> validateAssumption((Assumption)value, diagnostics, context);
    case GSNPackage.UNDEVELOPED -> validateUndeveloped((Undeveloped)value, diagnostics, context);
    case GSNPackage.ASIL -> validateASIL((ASIL)value, diagnostics, context);
    case GSNPackage.IMPACT_ANNOTATION -> validateImpactAnnotation((ImpactAnnotation)value, diagnostics, context);
    case GSNPackage.TEMPLATE -> validateTemplate((Template)value, diagnostics, context);
    case GSNPackage.RELATIONSHIP_DECORATOR -> validateRelationshipDecorator((RelationshipDecorator)value, diagnostics, context);
    case GSNPackage.ASIL_LEVEL -> validateASILLevel((ASILLevel)value, diagnostics, context);
    case GSNPackage.IMPACT_TYPE -> validateImpactType((ImpactType)value, diagnostics, context);
    case GSNPackage.DECORATOR_TYPE -> validateDecoratorType((DecoratorType)value, diagnostics, context);
    case GSNPackage.EXCEPTION -> validateException((Exception)value, diagnostics, context);
    case GSNPackage.GSN_BUILDER -> validateGSNBuilder((GSNBuilder)value, diagnostics, context);
    default -> true;
    };
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSafetyCase(SafetyCase safetyCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(safetyCase, diagnostics, context)) {
      return false;
    }
    var result = validate_EveryMultiplicityConforms(safetyCase, diagnostics, context);
    if (result || diagnostics != null) {
      result &= validate_EveryDataValueConforms(safetyCase, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryReferenceIsContained(safetyCase, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryBidirectionalReferenceIsPaired(safetyCase, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryProxyResolves(safetyCase, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_UniqueID(safetyCase, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryKeyUnique(safetyCase, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryMapEntryUnique(safetyCase, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateSafetyCase_SingleGoalRoot(safetyCase, diagnostics, context);
    }
    return result;
  }

  /**
   * The cached validation expression for the SingleGoalRoot constraint of '<em>Safety Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String SAFETY_CASE__SINGLE_GOAL_ROOT__EEXPRESSION = "let root : Set(OclAny) = Supporter.allInstances()->select(s | s.supports->isEmpty()) in\n" +
    "  root->size() = 1 and root->forAll(g | g.oclIsKindOf(gsn::Goal))";

  /**
   * Validates the SingleGoalRoot constraint of '<em>Safety Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSafetyCase_SingleGoalRoot(SafetyCase safetyCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.SAFETY_CASE,
         safetyCase,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "SingleGoalRoot",
         GSNValidator.SAFETY_CASE__SINGLE_GOAL_ROOT__EEXPRESSION,
         Diagnostic.ERROR,
         GSNValidator.DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateArgumentElement(ArgumentElement argumentElement, DiagnosticChain diagnostics,
                                         Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(argumentElement, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateDecoratable(Decoratable decoratable, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(decoratable, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASILfulElement(ASILfulElement asiLfulElement, DiagnosticChain diagnostics,
                                        Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(asiLfulElement, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupportedBy(SupportedBy supportedBy, DiagnosticChain diagnostics,
                                     Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(supportedBy, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContextualizable(Contextualizable contextualizable, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(contextualizable, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContextual(Contextual contextual, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(contextual, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateInContextOf(InContextOf inContextOf, DiagnosticChain diagnostics,
                                     Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(inContextOf, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateGoal(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(goal, diagnostics, context)) {
      return false;
    }
    var result = validate_EveryMultiplicityConforms(goal, diagnostics, context);
    if (result || diagnostics != null) {
      result &= validate_EveryDataValueConforms(goal, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryReferenceIsContained(goal, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryBidirectionalReferenceIsPaired(goal, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryProxyResolves(goal, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_UniqueID(goal, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryKeyUnique(goal, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryMapEntryUnique(goal, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateSupportable_SupportCycle(goal, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateSupportable_StrategySupportsGoals(goal, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateGoal_ASILInheritance(goal, diagnostics, context);
    }
    return result;
  }

  /**
   * The cached validation expression for the ASILInheritance constraint of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String GOAL__ASIL_INHERITANCE__EEXPRESSION = "let parents : Set(Goal) = self.supports.source -> closure(c | if c.oclIsKindOf(Goal) then c.oclAsSet() else c.oclAsType(gsn::Supporter).supports.source endif) -> selectByKind(Goal) -> asSet() in\n" +
    "  parents -> forAll(g | if g.asil = null then true else if self.asil = null then false else g.asil.value = ASILLevel::QM or (g.asil.value.toString() <= self.asil.value.toString() and self.asil.value <> ASILLevel::QM) endif endif)";

  /**
   * Validates the ASILInheritance constraint of '<em>Goal</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateGoal_ASILInheritance(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.GOAL,
         goal,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "ASILInheritance",
         GSNValidator.GOAL__ASIL_INHERITANCE__EEXPRESSION,
         Diagnostic.ERROR,
         GSNValidator.DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateStrategy(Strategy strategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(strategy, diagnostics, context)) {
      return false;
    }
    var result = validate_EveryMultiplicityConforms(strategy, diagnostics, context);
    if (result || diagnostics != null) {
      result &= validate_EveryDataValueConforms(strategy, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryReferenceIsContained(strategy, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryBidirectionalReferenceIsPaired(strategy, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryProxyResolves(strategy, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_UniqueID(strategy, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryKeyUnique(strategy, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryMapEntryUnique(strategy, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateSupportable_SupportCycle(strategy, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateSupportable_StrategySupportsGoals(strategy, diagnostics, context);
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSolution(Solution solution, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(solution, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
    return validate_EveryDefaultConstraint(context, diagnostics, theContext);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateJustification(Justification justification, DiagnosticChain diagnostics,
                                       Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(justification, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAssumption(Assumption assumption, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(assumption, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASIL(ASIL asil, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(asil, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateImpactAnnotation(ImpactAnnotation impactAnnotation, DiagnosticChain diagnostics,
                                          Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(impactAnnotation, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupportable(Supportable supportable, DiagnosticChain diagnostics,
                                     Map<Object, Object> context) {
    if (!validate_NoCircularContainment(supportable, diagnostics, context)) {
      return false;
    }
    var result = validate_EveryMultiplicityConforms(supportable, diagnostics, context);
    if (result || diagnostics != null) {
      result &= validate_EveryDataValueConforms(supportable, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryReferenceIsContained(supportable, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryBidirectionalReferenceIsPaired(supportable, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryProxyResolves(supportable, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_UniqueID(supportable, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryKeyUnique(supportable, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryMapEntryUnique(supportable, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateSupportable_SupportCycle(supportable, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateSupportable_StrategySupportsGoals(supportable, diagnostics, context);
    }
    return result;
  }

  /**
   * The cached validation expression for the SupportCycle constraint of '<em>Supportable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String SUPPORTABLE__SUPPORT_CYCLE__EEXPRESSION = "self.supportedBy.target->closure(p | if p.oclIsKindOf(Supportable) then p.oclAsType(Supportable).supportedBy.target else p.oclAsSet() endif)->excludes(self)";

  /**
   * Validates the SupportCycle constraint of '<em>Supportable</em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupportable_SupportCycle(Supportable supportable, DiagnosticChain diagnostics,
                                                  Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.SUPPORTABLE,
         supportable,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "SupportCycle",
         GSNValidator.SUPPORTABLE__SUPPORT_CYCLE__EEXPRESSION,
         Diagnostic.ERROR,
         GSNValidator.DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * The cached validation expression for the StrategySupportsGoals constraint of '<em>Supportable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String SUPPORTABLE__STRATEGY_SUPPORTS_GOALS__EEXPRESSION = "if self.oclIsKindOf(gsn::Strategy) then self.supportedBy->forAll(sb | sb.target.oclIsKindOf(gsn::Goal)) else true endif";

  /**
   * Validates the StrategySupportsGoals constraint of '<em>Supportable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupportable_StrategySupportsGoals(Supportable supportable, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.SUPPORTABLE,
         supportable,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "StrategySupportsGoals",
         GSNValidator.SUPPORTABLE__STRATEGY_SUPPORTS_GOALS__EEXPRESSION,
         Diagnostic.ERROR,
         GSNValidator.DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupporter(Supporter supporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(supporter, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateTemplate(Template template, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(template, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateRelationshipDecorator(RelationshipDecorator relationshipDecorator, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(relationshipDecorator, diagnostics, context)) {
      return false;
    }
    var result = validate_EveryMultiplicityConforms(relationshipDecorator, diagnostics, context);
    if (result || diagnostics != null) {
      result &= validate_EveryDataValueConforms(relationshipDecorator, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryReferenceIsContained(relationshipDecorator, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryBidirectionalReferenceIsPaired(relationshipDecorator, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryProxyResolves(relationshipDecorator, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_UniqueID(relationshipDecorator, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryKeyUnique(relationshipDecorator, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validate_EveryMapEntryUnique(relationshipDecorator, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateSupportable_SupportCycle(relationshipDecorator, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateSupportable_StrategySupportsGoals(relationshipDecorator, diagnostics, context);
    }
    if (result || diagnostics != null) {
      result &= validateRelationshipDecorator_OneRelationship(relationshipDecorator, diagnostics, context);
    }
    return result;
  }

  /**
   * The cached validation expression for the OneRelationship constraint of '<em>Relationship Decorator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String RELATIONSHIP_DECORATOR__ONE_RELATIONSHIP__EEXPRESSION = "self.supportedBy->isEmpty() or self.inContextOf->isEmpty()";

  /**
   * Validates the OneRelationship constraint of '<em>Relationship Decorator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateRelationshipDecorator_OneRelationship(RelationshipDecorator relationshipDecorator, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.RELATIONSHIP_DECORATOR,
         relationshipDecorator,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "OneRelationship",
         GSNValidator.RELATIONSHIP_DECORATOR__ONE_RELATIONSHIP__EEXPRESSION,
         Diagnostic.ERROR,
         GSNValidator.DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateUndeveloped(Undeveloped undeveloped, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(undeveloped, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASILLevel(ASILLevel asilLevel, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateImpactType(ImpactType impactType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateDecoratorType(DecoratorType decoratorType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public boolean validateException(Exception exception, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateGSNBuilder(GSNBuilder gsnBuilder, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * Returns the resource locator that will be used to fetch messages for this validator's diagnostics. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    // TODO
    // Specialize this to return a resource locator for messages specific to this validator.
    // Ensure that you remove @generated or mark it @generated NOT
    return super.getResourceLocator();
  }

} // GSNValidator
