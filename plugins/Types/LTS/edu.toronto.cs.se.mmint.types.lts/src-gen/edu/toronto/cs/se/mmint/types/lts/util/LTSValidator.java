/**
 */
package edu.toronto.cs.se.mmint.types.lts.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;

import edu.toronto.cs.se.mmint.types.lts.FinalState;
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
      case LTSPackage.FINAL_STATE:
        return validateFinalState((FinalState)value, diagnostics, context);
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
    if (result || diagnostics != null) result &= validateLTS_oneFinal(lts, diagnostics, context);
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
   * The cached validation expression for the oneFinal constraint of '<em>LTS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String LTS__ONE_FINAL__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'There must be one and only one final state',\n" +
    "\tstatus : Boolean = \n" +
    "      states->select(oclIsKindOf(FinalState))->size() = 1\n" +
    "}.status";

  /**
   * Validates the oneFinal constraint of '<em>LTS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateLTS_oneFinal(LTS lts, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (LTSPackage.Literals.LTS,
         lts,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "oneFinal",
         LTSValidator.LTS__ONE_FINAL__EEXPRESSION,
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
    if (result || diagnostics != null) result &= validateInitialState_noIncoming(initialState, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the noIncoming constraint of '<em>Initial State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String INITIAL_STATE__NO_INCOMING__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'An initial state can\\'t have incoming transitions',\n" +
    "\tstatus : Boolean = \n" +
    "      incoming->size() = 0\n" +
    "}.status";

  /**
   * Validates the noIncoming constraint of '<em>Initial State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateInitialState_noIncoming(InitialState initialState, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (LTSPackage.Literals.INITIAL_STATE,
         initialState,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "noIncoming",
         LTSValidator.INITIAL_STATE__NO_INCOMING__EEXPRESSION,
         Diagnostic.ERROR,
         LTSValidator.DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateFinalState(FinalState finalState, DiagnosticChain diagnostics, Map<Object, Object> context) {
    if (!validate_NoCircularContainment(finalState, diagnostics, context)) return false;
    var result = validate_EveryMultiplicityConforms(finalState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(finalState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(finalState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(finalState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(finalState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(finalState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(finalState, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(finalState, diagnostics, context);
    if (result || diagnostics != null) result &= validateFinalState_noOutgoing(finalState, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the noOutgoing constraint of '<em>Final State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String FINAL_STATE__NO_OUTGOING__EEXPRESSION = "Tuple {\n" +
    "\tmessage : String = 'A final state can\\'t have outgoing transitions',\n" +
    "\tstatus : Boolean = \n" +
    "      outgoing->size() = 0\n" +
    "}.status";

  /**
   * Validates the noOutgoing constraint of '<em>Final State</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateFinalState_noOutgoing(FinalState finalState, DiagnosticChain diagnostics, Map<Object, Object> context) {
    return
      validate
        (LTSPackage.Literals.FINAL_STATE,
         finalState,
         diagnostics,
         context,
         "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "noOutgoing",
         LTSValidator.FINAL_STATE__NO_OUTGOING__EEXPRESSION,
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
