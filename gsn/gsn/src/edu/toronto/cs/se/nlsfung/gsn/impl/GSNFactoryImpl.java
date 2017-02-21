/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GSNFactoryImpl extends EFactoryImpl implements GSNFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GSNFactory init() {
		try {
			GSNFactory theGSNFactory = (GSNFactory)EPackage.Registry.INSTANCE.getEFactory(GSNPackage.eNS_URI);
			if (theGSNFactory != null) {
				return theGSNFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GSNFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GSNFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GSNPackage.SAFETY_CASE: return createSafetyCase();
			case GSNPackage.GOAL: return createGoal();
			case GSNPackage.STRATEGY: return createStrategy();
			case GSNPackage.EVIDENCE: return createEvidence();
			case GSNPackage.CONTEXT: return createContext();
			case GSNPackage.JUSTIFICATION: return createJustification();
			case GSNPackage.ASSUMPTION: return createAssumption();
			case GSNPackage.IN_CONTEXT_OF: return createInContextOf();
			case GSNPackage.SUPPORTED_BY: return createSupportedBy();
			case GSNPackage.RECOMMENDATION: return createRecommendation();
			case GSNPackage.STRENGTH: return createStrength();
			case GSNPackage.REQUIRED_ACTION: return createRequiredAction();
			case GSNPackage.WEAKNESS: return createWeakness();
			case GSNPackage.QUESTION: return createQuestion();
			case GSNPackage.ADDITIONAL_ELEMENT: return createAdditionalElement();
			case GSNPackage.ADDITIONAL_LINK: return createAdditionalLink();
			case GSNPackage.MODULE_ELEMENT: return createModuleElement();
			case GSNPackage.MODULE: return createModule();
			case GSNPackage.CONTRACT: return createContract();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GSNPackage.ASSESS_STATUS:
				return createAssessStatusFromString(eDataType, initialValue);
			case GSNPackage.LEVEL:
				return createLevelFromString(eDataType, initialValue);
			case GSNPackage.BELIEF_DEGREE:
				return createbeliefDegreeFromString(eDataType, initialValue);
			case GSNPackage.PERCENTAGE:
				return createpercentageFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GSNPackage.ASSESS_STATUS:
				return convertAssessStatusToString(eDataType, instanceValue);
			case GSNPackage.LEVEL:
				return convertLevelToString(eDataType, instanceValue);
			case GSNPackage.BELIEF_DEGREE:
				return convertbeliefDegreeToString(eDataType, instanceValue);
			case GSNPackage.PERCENTAGE:
				return convertpercentageToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCase createSafetyCase() {
		SafetyCaseImpl safetyCase = new SafetyCaseImpl();
		return safetyCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Goal createGoal() {
		GoalImpl goal = new GoalImpl();
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strategy createStrategy() {
		StrategyImpl strategy = new StrategyImpl();
		return strategy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Evidence createEvidence() {
		EvidenceImpl evidence = new EvidenceImpl();
		return evidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Context createContext() {
		ContextImpl context = new ContextImpl();
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Justification createJustification() {
		JustificationImpl justification = new JustificationImpl();
		return justification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assumption createAssumption() {
		AssumptionImpl assumption = new AssumptionImpl();
		return assumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InContextOf createInContextOf() {
		InContextOfImpl inContextOf = new InContextOfImpl();
		return inContextOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SupportedBy createSupportedBy() {
		SupportedByImpl supportedBy = new SupportedByImpl();
		return supportedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Recommendation createRecommendation() {
		RecommendationImpl recommendation = new RecommendationImpl();
		return recommendation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Strength createStrength() {
		StrengthImpl strength = new StrengthImpl();
		return strength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredAction createRequiredAction() {
		RequiredActionImpl requiredAction = new RequiredActionImpl();
		return requiredAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Weakness createWeakness() {
		WeaknessImpl weakness = new WeaknessImpl();
		return weakness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Question createQuestion() {
		QuestionImpl question = new QuestionImpl();
		return question;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditionalElement createAdditionalElement() {
		AdditionalElementImpl additionalElement = new AdditionalElementImpl();
		return additionalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditionalLink createAdditionalLink() {
		AdditionalLinkImpl additionalLink = new AdditionalLinkImpl();
		return additionalLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModuleElement createModuleElement() {
		ModuleElementImpl moduleElement = new ModuleElementImpl();
		return moduleElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contract createContract() {
		ContractImpl contract = new ContractImpl();
		return contract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssessStatus createAssessStatusFromString(EDataType eDataType, String initialValue) {
		AssessStatus result = AssessStatus.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssessStatusToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level createLevelFromString(EDataType eDataType, String initialValue) {
		Level result = Level.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double[] createbeliefDegreeFromString(EDataType eDataType, String initialValue) {
		return (double[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertbeliefDegreeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer createpercentageFromString(EDataType eDataType, String initialValue) {
		return (Integer)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertpercentageToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GSNPackage getGSNPackage() {
		return (GSNPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GSNPackage getPackage() {
		return GSNPackage.eINSTANCE;
	}

} //GSNFactoryImpl
