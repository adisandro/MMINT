/*******************************************************************************
 * Copyright (c) 2020, 2021 Alessio Di Sandro.
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
/**
 */
package edu.toronto.cs.se.mmint.types.lts.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import edu.toronto.cs.se.mmint.types.lts.InitialState;
import edu.toronto.cs.se.mmint.types.lts.LTS;
import edu.toronto.cs.se.mmint.types.lts.LTSPackage;
import edu.toronto.cs.se.mmint.types.lts.LabeledElement;
import edu.toronto.cs.se.mmint.types.lts.State;
import edu.toronto.cs.se.mmint.types.lts.Transition;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint.types.lts.LTSPackage
 * @generated
 */
public class LTSValidator extends EObjectValidator {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final LTSValidator INSTANCE = new LTSValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.mmint.types.lts";

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
  protected static final int DIAGNOSTIC_CODE_COUNT = LTSValidator.GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LTSValidator() {
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
    return LTSPackage.eINSTANCE;
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
      case LTSPackage.LTS:
        return validateLTS((LTS)value, diagnostics, context);
      case LTSPackage.LABELED_ELEMENT:
        return validateLabeledElement((LabeledElement)value, diagnostics, context);
      case LTSPackage.STATE:
        return validateState((State)value, diagnostics, context);
      case LTSPackage.INITIAL_STATE:
        return validateInitialState((InitialState)value, diagnostics, context);
      case LTSPackage.TRANSITION:
        return validateTransition((Transition)value, diagnostics, context);
      default:
        return true;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateLTS(LTS lts, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(lts, diagnostics, context)) return false;
    var result = validate_EveryMultiplicityConforms(lts, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(lts, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(lts, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(lts, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(lts, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(lts, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(lts, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(lts, diagnostics, context);
    if (result || diagnostics != null) result &= validateLTS_oneInitial(lts, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the oneInitial constraint of '<em>LTS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String LTS__ONE_INITIAL__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'There must be one and only one initial state',\n" +
    "\tstatus : Boolean = \n" +
    "      states->select(oclIsKindOf(InitialState))->size() = 1\n" +
    "}.status";

  /**
   * Validates the oneInitial constraint of '<em>LTS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateLTS_oneInitial(LTS lts, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (LTSPackage.Literals.LTS,
         lts,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "oneInitial",
         LTSValidator.LTS__ONE_INITIAL__EEXPRESSION,
         Diagnostic.ERROR,
         LTSValidator.DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateLabeledElement(LabeledElement labeledElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(labeledElement, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateState(State state, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(state, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateInitialState(InitialState initialState, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(initialState, diagnostics, context)) return false;
    var result = validate_EveryMultiplicityConforms(initialState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(initialState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(initialState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(initialState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(initialState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(initialState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(initialState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(initialState, diagnostics, context);
    if (result || diagnostics != null) result &= validateInitialState_atLeastOneOutgoing(initialState, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the atLeastOneOutgoing constraint of '<em>Initial State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String INITIAL_STATE__AT_LEAST_ONE_OUTGOING__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'There must be at least one outgoing transition from the initial state',\n" +
    "\tstatus : Boolean = \n" +
    "      outgoing->size() >= 1\n" +
    "}.status";

  /**
   * Validates the atLeastOneOutgoing constraint of '<em>Initial State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateInitialState_atLeastOneOutgoing(InitialState initialState, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (LTSPackage.Literals.INITIAL_STATE,
         initialState,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "atLeastOneOutgoing",
         LTSValidator.INITIAL_STATE__AT_LEAST_ONE_OUTGOING__EEXPRESSION,
         Diagnostic.ERROR,
         LTSValidator.DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateTransition(Transition transition, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return validate_EveryDefaultConstraint(transition, diagnostics, context);
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

} //LTSValidator
