/**
 */
package edu.toronto.cs.se.nlsfung.gsn.util;

import edu.toronto.cs.se.nlsfung.gsn.*;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage
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
	public static final String DIAGNOSTIC_SOURCE = "edu.toronto.cs.se.nlsfung.gsn";

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
			case GSNPackage.BASIC_NODE:
				return validateBasicNode((BasicNode)value, diagnostics, context);
			case GSNPackage.BASIC_LINK:
				return validateBasicLink((BasicLink)value, diagnostics, context);
			case GSNPackage.GOAL:
				return validateGoal((Goal)value, diagnostics, context);
			case GSNPackage.STRATEGY:
				return validateStrategy((Strategy)value, diagnostics, context);
			case GSNPackage.EVIDENCE:
				return validateEvidence((Evidence)value, diagnostics, context);
			case GSNPackage.CONTEXT:
				return validateContext((Context)value, diagnostics, context);
			case GSNPackage.JUSTIFICATION:
				return validateJustification((Justification)value, diagnostics, context);
			case GSNPackage.ASSUMPTION:
				return validateAssumption((Assumption)value, diagnostics, context);
			case GSNPackage.IN_CONTEXT_OF:
				return validateInContextOf((InContextOf)value, diagnostics, context);
			case GSNPackage.SUPPORTED_BY:
				return validateSupportedBy((SupportedBy)value, diagnostics, context);
			case GSNPackage.RECOMMENDATION:
				return validateRecommendation((Recommendation)value, diagnostics, context);
			case GSNPackage.STRENGTH:
				return validateStrength((Strength)value, diagnostics, context);
			case GSNPackage.REQUIRED_ACTION:
				return validateRequiredAction((RequiredAction)value, diagnostics, context);
			case GSNPackage.WEAKNESS:
				return validateWeakness((Weakness)value, diagnostics, context);
			case GSNPackage.QUESTION:
				return validateQuestion((Question)value, diagnostics, context);
			case GSNPackage.ADDITIONAL_ELEMENT:
				return validateAdditionalElement((AdditionalElement)value, diagnostics, context);
			case GSNPackage.ADDITIONAL_LINK:
				return validateAdditionalLink((AdditionalLink)value, diagnostics, context);
			case GSNPackage.MODULE_ELEMENT:
				return validateModuleElement((ModuleElement)value, diagnostics, context);
			case GSNPackage.MODULE:
				return validateModule((Module)value, diagnostics, context);
			case GSNPackage.CONTRACT:
				return validateContract((Contract)value, diagnostics, context);
			case GSNPackage.ASSESS_STATUS:
				return validateAssessStatus((AssessStatus)value, diagnostics, context);
			case GSNPackage.LEVEL:
				return validateLevel((Level)value, diagnostics, context);
			case GSNPackage.BELIEF_DEGREE:
				return validatebeliefDegree((double[])value, diagnostics, context);
			case GSNPackage.PERCENTAGE:
				return validatepercentage((Integer)value, diagnostics, context);
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
		return validate_EveryDefaultConstraint(safetyCase, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicNode(BasicNode basicNode, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(basicNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBasicLink(BasicLink basicLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(basicLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGoal(Goal goal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(goal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStrategy(Strategy strategy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(strategy, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEvidence(Evidence evidence, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(evidence, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContext(Context context, DiagnosticChain diagnostics, Map<Object, Object> theContext) {
		return validate_EveryDefaultConstraint(context, diagnostics, theContext);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJustification(Justification justification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(justification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssumption(Assumption assumption, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(assumption, diagnostics, context);
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
	public boolean validateSupportedBy(SupportedBy supportedBy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(supportedBy, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRecommendation(Recommendation recommendation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(recommendation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStrength(Strength strength, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(strength, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRequiredAction(RequiredAction requiredAction, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(requiredAction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWeakness(Weakness weakness, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(weakness, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQuestion(Question question, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(question, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAdditionalElement(AdditionalElement additionalElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(additionalElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAdditionalLink(AdditionalLink additionalLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(additionalLink, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModuleElement(ModuleElement moduleElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(moduleElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModule(Module module, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(module, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContract(Contract contract, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(contract, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAssessStatus(AssessStatus assessStatus, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLevel(Level level, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatebeliefDegree(double[] beliefDegree, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatepercentage(Integer percentage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validatepercentage_Min(percentage, diagnostics, context);
		if (result || diagnostics != null) result &= validatepercentage_Max(percentage, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatepercentage_Min
	 */
	public static final Integer PERCENTAGE__MIN__VALUE = new Integer(0);

	/**
	 * Validates the Min constraint of '<em>percentage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatepercentage_Min(Integer percentage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = percentage.compareTo(PERCENTAGE__MIN__VALUE) >= 0;
		if (!result && diagnostics != null)
			reportMinViolation(GSNPackage.Literals.PERCENTAGE, percentage, PERCENTAGE__MIN__VALUE, true, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @see #validatepercentage_Max
	 */
	public static final Integer PERCENTAGE__MAX__VALUE = new Integer(100);

	/**
	 * Validates the Max constraint of '<em>percentage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatepercentage_Max(Integer percentage, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = percentage.compareTo(PERCENTAGE__MAX__VALUE) <= 0;
		if (!result && diagnostics != null)
			reportMaxViolation(GSNPackage.Literals.PERCENTAGE, percentage, PERCENTAGE__MAX__VALUE, true, diagnostics, context);
		return result;
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
