/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 * 
 */
package edu.toronto.cs.se.modelepedia.safetycase.util;

import edu.toronto.cs.se.modelepedia.safetycase.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.safetycase.GSNPackage
 * @generated
 */
public class GSNValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final GSNValidator INSTANCE = new GSNValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.modelepedia.safetycase";

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GSNValidator() {
    super();
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EPackage getEPackage() {
    return GSNPackage.eINSTANCE;
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
    switch (classifierID) {
      case GSNPackage.SAFETY_CASE:
        return validateSafetyCase((SafetyCase)value, diagnostics, context);
      case GSNPackage.ARGUMENT_ELEMENT:
        return validateArgumentElement((ArgumentElement)value, diagnostics, context);
      case GSNPackage.STATEFUL_ELEMENT:
        return validateStatefulElement((StatefulElement)value, diagnostics, context);
      case GSNPackage.ASI_LFUL_ELEMENT:
        return validateASILfulElement((ASILfulElement)value, diagnostics, context);
      case GSNPackage.CORE_ELEMENT:
        return validateCoreElement((CoreElement)value, diagnostics, context);
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT:
        return validateDecomposableCoreElement((DecomposableCoreElement)value, diagnostics, context);
      case GSNPackage.CONTEXTUAL_ELEMENT:
        return validateContextualElement((ContextualElement)value, diagnostics, context);
      case GSNPackage.SUPPORTED_BY:
        return validateSupportedBy((SupportedBy)value, diagnostics, context);
      case GSNPackage.IN_CONTEXT_OF:
        return validateInContextOf((InContextOf)value, diagnostics, context);
      case GSNPackage.GOAL:
        return validateGoal((Goal)value, diagnostics, context);
      case GSNPackage.BASIC_GOAL:
        return validateBasicGoal((BasicGoal)value, diagnostics, context);
      case GSNPackage.INDEPENDENCE_GOAL:
        return validateIndependenceGoal((IndependenceGoal)value, diagnostics, context);
      case GSNPackage.DOMAIN_GOAL:
        return validateDomainGoal((DomainGoal)value, diagnostics, context);
      case GSNPackage.STRATEGY:
        return validateStrategy((Strategy)value, diagnostics, context);
      case GSNPackage.BASIC_STRATEGY:
        return validateBasicStrategy((BasicStrategy)value, diagnostics, context);
      case GSNPackage.ASIL_DECOMPOSITION_STRATEGY:
        return validateASILDecompositionStrategy((ASILDecompositionStrategy)value, diagnostics, context);
      case GSNPackage.SOLUTION:
        return validateSolution((Solution)value, diagnostics, context);
      case GSNPackage.CONTEXT:
        return validateContext((Context)value, diagnostics, context);
      case GSNPackage.JUSTIFICATION:
        return validateJustification((Justification)value, diagnostics, context);
      case GSNPackage.ASSUMPTION:
        return validateAssumption((Assumption)value, diagnostics, context);
      case GSNPackage.ASIL:
        return validateASIL((ASIL)value, diagnostics, context);
      case GSNPackage.IMPACT_ANNOTATION:
        return validateImpactAnnotation((ImpactAnnotation)value, diagnostics, context);
      case GSNPackage.SUPPORTABLE:
        return validateSupportable((Supportable)value, diagnostics, context);
      case GSNPackage.SUPPORTER:
        return validateSupporter((Supporter)value, diagnostics, context);
      case GSNPackage.SUPPORT_CONNECTOR:
        return validateSupportConnector((SupportConnector)value, diagnostics, context);
      case GSNPackage.AND_SUPPORTER:
        return validateAndSupporter((AndSupporter)value, diagnostics, context);
      case GSNPackage.OR_SUPPORTER:
        return validateOrSupporter((OrSupporter)value, diagnostics, context);
      case GSNPackage.XOR_SUPPORTER:
        return validateXorSupporter((XorSupporter)value, diagnostics, context);
      case GSNPackage.MOF_NSUPPORTER:
        return validateMofNSupporter((MofNSupporter)value, diagnostics, context);
      case GSNPackage.ASIL_LEVEL:
        return validateASILLevel((ASILLevel)value, diagnostics, context);
      case GSNPackage.VALIDITY_VALUE:
        return validateValidityValue((ValidityValue)value, diagnostics, context);
      case GSNPackage.IMPACT_TYPE:
        return validateImpactType((ImpactType)value, diagnostics, context);
      default:
        return true;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSafetyCase(SafetyCase safetyCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(safetyCase, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(safetyCase, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(safetyCase, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(safetyCase, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(safetyCase, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(safetyCase, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(safetyCase, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(safetyCase, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(safetyCase, diagnostics, context);
    if (result || diagnostics != null) result &= validateSafetyCase_SingleRoot(safetyCase, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the SingleRoot constraint of '<em>Safety Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String SAFETY_CASE__SINGLE_ROOT__EEXPRESSION = "Supporter.allInstances() -> \n" +
    "\t\t\tselect(d | d.supports.source -> isEmpty()) -> size() = 1";

  /**
   * Validates the SingleRoot constraint of '<em>Safety Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSafetyCase_SingleRoot(SafetyCase safetyCase, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.SAFETY_CASE,
         safetyCase,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "SingleRoot",
         SAFETY_CASE__SINGLE_ROOT__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateArgumentElement(ArgumentElement argumentElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(argumentElement, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateStatefulElement(StatefulElement statefulElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(statefulElement, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASILfulElement(ASILfulElement asiLfulElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(asiLfulElement, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCoreElement(CoreElement coreElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(coreElement, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(coreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(coreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(coreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(coreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(coreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(coreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(coreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(coreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(coreElement, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateDecomposableCoreElement(DecomposableCoreElement decomposableCoreElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(decomposableCoreElement, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(decomposableCoreElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(decomposableCoreElement, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContextualElement(ContextualElement contextualElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(contextualElement, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(contextualElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(contextualElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(contextualElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(contextualElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(contextualElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(contextualElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(contextualElement, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(contextualElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateContextualElement_ContextualElementSupporter(contextualElement, diagnostics, context);
    if (result || diagnostics != null) result &= validateContextualElement_ContextualElementContext(contextualElement, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the ContextualElementSupporter constraint of '<em>Contextual Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_SUPPORTER__EEXPRESSION = "self.oclAsType(DecomposableCoreElement).oclIsInvalid()";

  /**
   * Validates the ContextualElementSupporter constraint of '<em>Contextual Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContextualElement_ContextualElementSupporter(ContextualElement contextualElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.CONTEXTUAL_ELEMENT,
         contextualElement,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "ContextualElementSupporter",
         CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_SUPPORTER__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * The cached validation expression for the ContextualElementContext constraint of '<em>Contextual Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONTEXT__EEXPRESSION = "self.oclAsType(DecomposableCoreElement).oclIsInvalid()";

  /**
   * Validates the ContextualElementContext constraint of '<em>Contextual Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContextualElement_ContextualElementContext(ContextualElement contextualElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.CONTEXTUAL_ELEMENT,
         contextualElement,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "ContextualElementContext",
         CONTEXTUAL_ELEMENT__CONTEXTUAL_ELEMENT_CONTEXT__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupportedBy(SupportedBy supportedBy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(supportedBy, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateInContextOf(InContextOf inContextOf, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(inContextOf, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateGoal(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(goal, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_GoalSupporter(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_GoalContext(goal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_ASILInheritance(goal, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the GoalSupporter constraint of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String GOAL__GOAL_SUPPORTER__EEXPRESSION = "\n" +
    "\t\t\tlet children : Set(Supporter) = self.supportedBy.target -> closure(p | if p.oclIsKindOf(CoreElement) then p.oclAsSet() else p.oclAsType(Supportable).supportedBy.target endif) -> asSet()\n" +
    "\t\t\tin children -> selectByKind(CoreElement) -> forAll(s | s.oclIsKindOf(Goal) or s.oclIsKindOf(Strategy) or s.oclIsKindOf(Solution))";

  /**
   * Validates the GoalSupporter constraint of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateGoal_GoalSupporter(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.GOAL,
         goal,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "GoalSupporter",
         GOAL__GOAL_SUPPORTER__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * The cached validation expression for the GoalContext constraint of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String GOAL__GOAL_CONTEXT__EEXPRESSION = "self.inContextOf.context -> forAll(c | c.oclIsKindOf(Context) or c.oclIsKindOf(Assumption) or c.oclIsKindOf(Justification))";

  /**
   * Validates the GoalContext constraint of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateGoal_GoalContext(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.GOAL,
         goal,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "GoalContext",
         GOAL__GOAL_CONTEXT__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * The cached validation expression for the ASILInheritance constraint of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String GOAL__ASIL_INHERITANCE__EEXPRESSION = "\n" +
    "\t\t\tlet parents : Set(Goal) = self.supports.source -> closure(c | if c.oclIsKindOf(Goal) or c.oclIsKindOf(ASILDecompositionStrategy) then c.oclAsSet() else c.supports.source endif) -> selectByKind(Goal) -> asSet()\n" +
    "\t\t\tin parents -> forAll(g | if g.asil = null then true else if self.asil = null then false else g.asil.value = ASILLevel::QM or (g.asil.value.toString() <= self.asil.value.toString() and self.asil.value <> ASILLevel::QM) endif endif)";

  /**
   * Validates the ASILInheritance constraint of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
         GOAL__ASIL_INHERITANCE__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateBasicGoal(BasicGoal basicGoal, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(basicGoal, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_GoalSupporter(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_GoalContext(basicGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_ASILInheritance(basicGoal, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateIndependenceGoal(IndependenceGoal independenceGoal, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(independenceGoal, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_GoalSupporter(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_GoalContext(independenceGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_ASILInheritance(independenceGoal, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateDomainGoal(DomainGoal domainGoal, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(domainGoal, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_GoalSupporter(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_GoalContext(domainGoal, diagnostics, context);
    if (result || diagnostics != null) result &= validateGoal_ASILInheritance(domainGoal, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateStrategy(Strategy strategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(strategy, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateStrategy_StrategySupporter(strategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateStrategy_StrategyContext(strategy, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the StrategySupporter constraint of '<em>Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String STRATEGY__STRATEGY_SUPPORTER__EEXPRESSION = "\n" +
    "\t\t\tlet children : Set(Supporter) = self.supportedBy.target -> closure(p | if p.oclIsKindOf(CoreElement) then p.oclAsSet() else p.oclAsType(Supportable).supportedBy.target endif) -> asSet() \n" +
    "\t\t\tin children -> selectByKind(CoreElement) -> forAll(s | s.oclIsKindOf(Goal) or s.oclIsKindOf(Solution))";

  /**
   * Validates the StrategySupporter constraint of '<em>Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateStrategy_StrategySupporter(Strategy strategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.STRATEGY,
         strategy,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "StrategySupporter",
         STRATEGY__STRATEGY_SUPPORTER__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * The cached validation expression for the StrategyContext constraint of '<em>Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String STRATEGY__STRATEGY_CONTEXT__EEXPRESSION = "self.inContextOf.context -> forAll(c | c.oclIsKindOf(Context) or c.oclIsKindOf(Assumption) or c.oclIsKindOf(Justification))";

  /**
   * Validates the StrategyContext constraint of '<em>Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateStrategy_StrategyContext(Strategy strategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.STRATEGY,
         strategy,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "StrategyContext",
         STRATEGY__STRATEGY_CONTEXT__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateBasicStrategy(BasicStrategy basicStrategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(basicStrategy, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateStrategy_StrategySupporter(basicStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateStrategy_StrategyContext(basicStrategy, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASILDecompositionStrategy(ASILDecompositionStrategy asilDecompositionStrategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(asilDecompositionStrategy, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateStrategy_StrategySupporter(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateStrategy_StrategyContext(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateASILDecompositionStrategy_ASILDecompositionIndependence(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateASILDecompositionStrategy_ASILDecompositionComponents(asilDecompositionStrategy, diagnostics, context);
    if (result || diagnostics != null) result &= validateASILDecompositionStrategy_ASILDescendants(asilDecompositionStrategy, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the ASILDecompositionIndependence constraint of '<em>ASIL Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String ASIL_DECOMPOSITION_STRATEGY__ASIL_DECOMPOSITION_INDEPENDENCE__EEXPRESSION = "\n" +
    "\t\t\tlet children = self.supportedBy.target -> closure(s | if s.oclIsKindOf(SupportConnector) then s.oclAsType(SupportConnector).supportedBy.target else s.oclAsSet() endif)\n" +
    "\t\t\tin children -> selectByType(IndependenceGoal) -> size() = 1";

  /**
   * Validates the ASILDecompositionIndependence constraint of '<em>ASIL Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASILDecompositionStrategy_ASILDecompositionIndependence(ASILDecompositionStrategy asilDecompositionStrategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.ASIL_DECOMPOSITION_STRATEGY,
         asilDecompositionStrategy,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "ASILDecompositionIndependence",
         ASIL_DECOMPOSITION_STRATEGY__ASIL_DECOMPOSITION_INDEPENDENCE__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * The cached validation expression for the ASILDecompositionComponents constraint of '<em>ASIL Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String ASIL_DECOMPOSITION_STRATEGY__ASIL_DECOMPOSITION_COMPONENTS__EEXPRESSION = " \n" +
    "\t\t\tlet children = self.supportedBy.target -> closure(s | if s.oclIsKindOf(SupportConnector) then s.oclAsType(SupportConnector).supportedBy.target else s.oclAsSet() endif)\n" +
    "\t\t\tin children -> selectByType(BasicGoal) -> size() = 2";

  /**
   * Validates the ASILDecompositionComponents constraint of '<em>ASIL Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASILDecompositionStrategy_ASILDecompositionComponents(ASILDecompositionStrategy asilDecompositionStrategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.ASIL_DECOMPOSITION_STRATEGY,
         asilDecompositionStrategy,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "ASILDecompositionComponents",
         ASIL_DECOMPOSITION_STRATEGY__ASIL_DECOMPOSITION_COMPONENTS__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * The cached validation expression for the ASILDescendants constraint of '<em>ASIL Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String ASIL_DECOMPOSITION_STRATEGY__ASIL_DESCENDANTS__EEXPRESSION = "\n" +
    "\t\t\tlet goalSeq = self.supportedBy.target -> closure(s | if s.oclIsKindOf(SupportConnector) then s.oclAsType(SupportConnector).supportedBy.target else s.oclAsSet() endif) -> select(p | p.oclIsTypeOf(BasicGoal)), \n" +
    "\t\t\tg1Descendants : Set(Supporter) = goalSeq -> at(1) -> closure(c | \n" +
    "\t\t\t\t\tif c.oclIsKindOf(Supportable) then c.oclAsType(Supportable).supportedBy.target else null endif),\n" +
    "\t\t\tg2Descendants : Set(Supporter) = goalSeq -> at(2) -> closure(c | \n" +
    "\t\t\t\t\tif c.oclIsKindOf(Supportable) then c.oclAsType(Supportable).supportedBy.target else null endif) \n" +
    "\t\t\tin g1Descendants -> intersection(g2Descendants) = Set{}";

  /**
   * Validates the ASILDescendants constraint of '<em>ASIL Decomposition Strategy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASILDecompositionStrategy_ASILDescendants(ASILDecompositionStrategy asilDecompositionStrategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.ASIL_DECOMPOSITION_STRATEGY,
         asilDecompositionStrategy,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "ASILDescendants",
         ASIL_DECOMPOSITION_STRATEGY__ASIL_DESCENDANTS__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSolution(Solution solution, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(solution, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validateSolution_SolutionSupporter(solution, diagnostics, context);
    if (result || diagnostics != null) result &= validateSolution_SolutionContext(solution, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the SolutionSupporter constraint of '<em>Solution</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String SOLUTION__SOLUTION_SUPPORTER__EEXPRESSION = "self.oclAsType(DecomposableCoreElement).oclIsInvalid()";

  /**
   * Validates the SolutionSupporter constraint of '<em>Solution</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSolution_SolutionSupporter(Solution solution, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.SOLUTION,
         solution,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "SolutionSupporter",
         SOLUTION__SOLUTION_SUPPORTER__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * The cached validation expression for the SolutionContext constraint of '<em>Solution</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String SOLUTION__SOLUTION_CONTEXT__EEXPRESSION = "self.oclAsType(DecomposableCoreElement).oclIsInvalid()";

  /**
   * Validates the SolutionContext constraint of '<em>Solution</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSolution_SolutionContext(Solution solution, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.SOLUTION,
         solution,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "SolutionContext",
         SOLUTION__SOLUTION_CONTEXT__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
    if (!validate_NoCircularContainment(context, diagnostics, theContext)) return false;
    boolean result = validate_EveryMultiplicityConforms(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_UniqueID(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validateContextualElement_ContextualElementSupporter(context, diagnostics, theContext);
    if (result || diagnostics != null) result &= validateContextualElement_ContextualElementContext(context, diagnostics, theContext);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateJustification(Justification justification, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(justification, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(justification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(justification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(justification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(justification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(justification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(justification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(justification, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(justification, diagnostics, context);
    if (result || diagnostics != null) result &= validateContextualElement_ContextualElementSupporter(justification, diagnostics, context);
    if (result || diagnostics != null) result &= validateContextualElement_ContextualElementContext(justification, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAssumption(Assumption assumption, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(assumption, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(assumption, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(assumption, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(assumption, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(assumption, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(assumption, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(assumption, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(assumption, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(assumption, diagnostics, context);
    if (result || diagnostics != null) result &= validateContextualElement_ContextualElementSupporter(assumption, diagnostics, context);
    if (result || diagnostics != null) result &= validateContextualElement_ContextualElementContext(assumption, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASIL(ASIL asil, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(asil, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateImpactAnnotation(ImpactAnnotation impactAnnotation, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(impactAnnotation, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupportable(Supportable supportable, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(supportable, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(supportable, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(supportable, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the SupportCycle constraint of '<em>Supportable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String SUPPORTABLE__SUPPORT_CYCLE__EEXPRESSION = "self.supportedBy.target -> closure(p | if p.oclIsKindOf(Supportable) then \n" +
    "\t\t\tp.oclAsType(Supportable).supportedBy.target else \n" +
    "\t\t\tp.oclAsSet() endif) -> excludes(self)";

  /**
   * Validates the SupportCycle constraint of '<em>Supportable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupportable_SupportCycle(Supportable supportable, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.SUPPORTABLE,
         supportable,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "SupportCycle",
         SUPPORTABLE__SUPPORT_CYCLE__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * The cached validation expression for the NonSupportableLeaves constraint of '<em>Supportable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String SUPPORTABLE__NON_SUPPORTABLE_LEAVES__EEXPRESSION = "self.supportedBy.target -> size() > 0 and self.supportedBy.target -> excludes(null)";

  /**
   * Validates the NonSupportableLeaves constraint of '<em>Supportable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupportable_NonSupportableLeaves(Supportable supportable, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.SUPPORTABLE,
         supportable,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "NonSupportableLeaves",
         SUPPORTABLE__NON_SUPPORTABLE_LEAVES__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupporter(Supporter supporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(supporter, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(supporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(supporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(supporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(supporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(supporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(supporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(supporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(supporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(supporter, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the GoalRoot constraint of '<em>Supporter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String SUPPORTER__GOAL_ROOT__EEXPRESSION = "self.supports.source -> isEmpty() implies self.oclIsTypeOf(BasicGoal)";

  /**
   * Validates the GoalRoot constraint of '<em>Supporter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupporter_GoalRoot(Supporter supporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (GSNPackage.Literals.SUPPORTER,
         supporter,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "GoalRoot",
         SUPPORTER__GOAL_ROOT__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateSupportConnector(SupportConnector supportConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(supportConnector, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(supportConnector, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(supportConnector, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAndSupporter(AndSupporter andSupporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(andSupporter, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(andSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(andSupporter, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateOrSupporter(OrSupporter orSupporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(orSupporter, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(orSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(orSupporter, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateXorSupporter(XorSupporter xorSupporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(xorSupporter, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(xorSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(xorSupporter, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateMofNSupporter(MofNSupporter mofNSupporter, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(mofNSupporter, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupporter_GoalRoot(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_SupportCycle(mofNSupporter, diagnostics, context);
    if (result || diagnostics != null) result &= validateSupportable_NonSupportableLeaves(mofNSupporter, diagnostics, context);
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateASILLevel(ASILLevel asilLevel, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateValidityValue(ValidityValue validityValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateImpactType(ImpactType impactType, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return true;
  }

  /**
   * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator() {
    // TODO
    // Specialize this to return a resource locator for messages specific to this validator.
    // Ensure that you remove @generated or mark it @generated NOT
    return super.getResourceLocator();
  }

} //GSNValidator
