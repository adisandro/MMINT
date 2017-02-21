/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.AdditionalElement;
import edu.toronto.cs.se.nlsfung.gsn.AdditionalLink;
import edu.toronto.cs.se.nlsfung.gsn.AssessStatus;
import edu.toronto.cs.se.nlsfung.gsn.Assumption;
import edu.toronto.cs.se.nlsfung.gsn.BasicLink;
import edu.toronto.cs.se.nlsfung.gsn.BasicNode;
import edu.toronto.cs.se.nlsfung.gsn.Context;
import edu.toronto.cs.se.nlsfung.gsn.Contract;
import edu.toronto.cs.se.nlsfung.gsn.Evidence;
import edu.toronto.cs.se.nlsfung.gsn.GSNFactory;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.Goal;
import edu.toronto.cs.se.nlsfung.gsn.InContextOf;
import edu.toronto.cs.se.nlsfung.gsn.Justification;
import edu.toronto.cs.se.nlsfung.gsn.Level;
import edu.toronto.cs.se.nlsfung.gsn.Module;
import edu.toronto.cs.se.nlsfung.gsn.ModuleElement;
import edu.toronto.cs.se.nlsfung.gsn.Question;
import edu.toronto.cs.se.nlsfung.gsn.Recommendation;
import edu.toronto.cs.se.nlsfung.gsn.RequiredAction;
import edu.toronto.cs.se.nlsfung.gsn.SafetyCase;
import edu.toronto.cs.se.nlsfung.gsn.Strategy;
import edu.toronto.cs.se.nlsfung.gsn.Strength;
import edu.toronto.cs.se.nlsfung.gsn.SupportedBy;
import edu.toronto.cs.se.nlsfung.gsn.Weakness;

import edu.toronto.cs.se.nlsfung.gsn.util.GSNValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GSNPackageImpl extends EPackageImpl implements GSNPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass safetyCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evidenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass justificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assumptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inContextOfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supportedByEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recommendationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strengthEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requiredActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass weaknessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass questionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additionalElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additionalLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contractEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum assessStatusEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum levelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType beliefDegreeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType percentageEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GSNPackageImpl() {
		super(eNS_URI, GSNFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GSNPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GSNPackage init() {
		if (isInited) return (GSNPackage)EPackage.Registry.INSTANCE.getEPackage(GSNPackage.eNS_URI);

		// Obtain or create and register package
		GSNPackageImpl theGSNPackage = (GSNPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GSNPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GSNPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGSNPackage.createPackageContents();

		// Initialize created meta-data
		theGSNPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theGSNPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return GSNValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theGSNPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GSNPackage.eNS_URI, theGSNPackage);
		return theGSNPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSafetyCase() {
		return safetyCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyCase_RootBasicNode() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyCase_RootBasicLink() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyCase_RootCommendation() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyCase_Description() {
		return (EAttribute)safetyCaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafetyCase_Id() {
		return (EAttribute)safetyCaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicNode() {
		return basicNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicNode_Id() {
		return (EAttribute)basicNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicNode_Name() {
		return (EAttribute)basicNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicNode_Assessstatus() {
		return (EAttribute)basicNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicNode_HasComment() {
		return (EReference)basicNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicNode_Description() {
		return (EAttribute)basicNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicNode_QualityLevel() {
		return (EAttribute)basicNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicNode_ConfidencePercentage() {
		return (EAttribute)basicNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicNode_Weight() {
		return (EAttribute)basicNodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicNode_BeliefDegree() {
		return (EAttribute)basicNodeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicLink() {
		return basicLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicLink_Source() {
		return (EReference)basicLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicLink_Target() {
		return (EReference)basicLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBasicLink_Id() {
		return (EAttribute)basicLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoal() {
		return goalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrategy() {
		return strategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvidence() {
		return evidenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvidence_Attachment() {
		return (EAttribute)evidenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJustification() {
		return justificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssumption() {
		return assumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInContextOf() {
		return inContextOfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSupportedBy() {
		return supportedByEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecommendation() {
		return recommendationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecommendation_ID() {
		return (EAttribute)recommendationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecommendation_Name() {
		return (EAttribute)recommendationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecommendation_Description() {
		return (EAttribute)recommendationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrength() {
		return strengthEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequiredAction() {
		return requiredActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWeakness() {
		return weaknessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuestion() {
		return questionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditionalElement() {
		return additionalElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdditionalElement_Attachment() {
		return (EAttribute)additionalElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditionalLink() {
		return additionalLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModuleElement() {
		return moduleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModuleElement_Attachment() {
		return (EAttribute)moduleElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContract() {
		return contractEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAssessStatus() {
		return assessStatusEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLevel() {
		return levelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getbeliefDegree() {
		return beliefDegreeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getpercentage() {
		return percentageEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GSNFactory getGSNFactory() {
		return (GSNFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		safetyCaseEClass = createEClass(SAFETY_CASE);
		createEReference(safetyCaseEClass, SAFETY_CASE__ROOT_BASIC_NODE);
		createEReference(safetyCaseEClass, SAFETY_CASE__ROOT_BASIC_LINK);
		createEReference(safetyCaseEClass, SAFETY_CASE__ROOT_COMMENDATION);
		createEAttribute(safetyCaseEClass, SAFETY_CASE__DESCRIPTION);
		createEAttribute(safetyCaseEClass, SAFETY_CASE__ID);

		basicNodeEClass = createEClass(BASIC_NODE);
		createEAttribute(basicNodeEClass, BASIC_NODE__ID);
		createEAttribute(basicNodeEClass, BASIC_NODE__NAME);
		createEAttribute(basicNodeEClass, BASIC_NODE__ASSESSSTATUS);
		createEReference(basicNodeEClass, BASIC_NODE__HAS_COMMENT);
		createEAttribute(basicNodeEClass, BASIC_NODE__DESCRIPTION);
		createEAttribute(basicNodeEClass, BASIC_NODE__QUALITY_LEVEL);
		createEAttribute(basicNodeEClass, BASIC_NODE__CONFIDENCE_PERCENTAGE);
		createEAttribute(basicNodeEClass, BASIC_NODE__WEIGHT);
		createEAttribute(basicNodeEClass, BASIC_NODE__BELIEF_DEGREE);

		basicLinkEClass = createEClass(BASIC_LINK);
		createEReference(basicLinkEClass, BASIC_LINK__SOURCE);
		createEReference(basicLinkEClass, BASIC_LINK__TARGET);
		createEAttribute(basicLinkEClass, BASIC_LINK__ID);

		goalEClass = createEClass(GOAL);

		strategyEClass = createEClass(STRATEGY);

		evidenceEClass = createEClass(EVIDENCE);
		createEAttribute(evidenceEClass, EVIDENCE__ATTACHMENT);

		contextEClass = createEClass(CONTEXT);

		justificationEClass = createEClass(JUSTIFICATION);

		assumptionEClass = createEClass(ASSUMPTION);

		inContextOfEClass = createEClass(IN_CONTEXT_OF);

		supportedByEClass = createEClass(SUPPORTED_BY);

		recommendationEClass = createEClass(RECOMMENDATION);
		createEAttribute(recommendationEClass, RECOMMENDATION__ID);
		createEAttribute(recommendationEClass, RECOMMENDATION__NAME);
		createEAttribute(recommendationEClass, RECOMMENDATION__DESCRIPTION);

		strengthEClass = createEClass(STRENGTH);

		requiredActionEClass = createEClass(REQUIRED_ACTION);

		weaknessEClass = createEClass(WEAKNESS);

		questionEClass = createEClass(QUESTION);

		additionalElementEClass = createEClass(ADDITIONAL_ELEMENT);
		createEAttribute(additionalElementEClass, ADDITIONAL_ELEMENT__ATTACHMENT);

		additionalLinkEClass = createEClass(ADDITIONAL_LINK);

		moduleElementEClass = createEClass(MODULE_ELEMENT);
		createEAttribute(moduleElementEClass, MODULE_ELEMENT__ATTACHMENT);

		moduleEClass = createEClass(MODULE);

		contractEClass = createEClass(CONTRACT);

		// Create enums
		assessStatusEEnum = createEEnum(ASSESS_STATUS);
		levelEEnum = createEEnum(LEVEL);

		// Create data types
		beliefDegreeEDataType = createEDataType(BELIEF_DEGREE);
		percentageEDataType = createEDataType(PERCENTAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		goalEClass.getESuperTypes().add(this.getBasicNode());
		strategyEClass.getESuperTypes().add(this.getBasicNode());
		evidenceEClass.getESuperTypes().add(this.getBasicNode());
		contextEClass.getESuperTypes().add(this.getBasicNode());
		justificationEClass.getESuperTypes().add(this.getBasicNode());
		assumptionEClass.getESuperTypes().add(this.getBasicNode());
		inContextOfEClass.getESuperTypes().add(this.getBasicLink());
		supportedByEClass.getESuperTypes().add(this.getBasicLink());
		strengthEClass.getESuperTypes().add(this.getRecommendation());
		requiredActionEClass.getESuperTypes().add(this.getRecommendation());
		weaknessEClass.getESuperTypes().add(this.getRecommendation());
		questionEClass.getESuperTypes().add(this.getRecommendation());
		additionalElementEClass.getESuperTypes().add(this.getBasicNode());
		additionalLinkEClass.getESuperTypes().add(this.getBasicLink());
		moduleElementEClass.getESuperTypes().add(this.getBasicNode());
		moduleEClass.getESuperTypes().add(this.getModuleElement());
		contractEClass.getESuperTypes().add(this.getModuleElement());

		// Initialize classes and features; add operations and parameters
		initEClass(safetyCaseEClass, SafetyCase.class, "SafetyCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSafetyCase_RootBasicNode(), this.getBasicNode(), null, "rootBasicNode", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_RootBasicLink(), this.getBasicLink(), null, "rootBasicLink", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_RootCommendation(), this.getRecommendation(), null, "rootCommendation", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafetyCase_Description(), ecorePackage.getEString(), "description", null, 0, 1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafetyCase_Id(), ecorePackage.getEString(), "id", null, 0, 1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(basicNodeEClass, BasicNode.class, "BasicNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBasicNode_Id(), ecorePackage.getEString(), "id", null, 0, 1, BasicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBasicNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, BasicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicNode_Assessstatus(), this.getAssessStatus(), "assessstatus", null, 0, 1, BasicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicNode_HasComment(), this.getRecommendation(), null, "hasComment", null, 0, 1, BasicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicNode_Description(), ecorePackage.getEString(), "description", null, 0, 1, BasicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicNode_QualityLevel(), this.getLevel(), "qualityLevel", null, 0, 1, BasicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicNode_ConfidencePercentage(), this.getpercentage(), "confidencePercentage", null, 0, 1, BasicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicNode_Weight(), ecorePackage.getEDouble(), "weight", null, 0, 1, BasicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicNode_BeliefDegree(), this.getbeliefDegree(), "beliefDegree", null, 0, 1, BasicNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicLinkEClass, BasicLink.class, "BasicLink", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicLink_Source(), this.getBasicNode(), null, "source", null, 0, 1, BasicLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicLink_Target(), this.getBasicNode(), null, "target", null, 0, 1, BasicLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBasicLink_Id(), ecorePackage.getEString(), "id", null, 0, 1, BasicLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strategyEClass, Strategy.class, "Strategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(evidenceEClass, Evidence.class, "Evidence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvidence_Attachment(), ecorePackage.getEString(), "attachment", null, 0, 1, Evidence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(justificationEClass, Justification.class, "Justification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assumptionEClass, Assumption.class, "Assumption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inContextOfEClass, InContextOf.class, "InContextOf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(supportedByEClass, SupportedBy.class, "SupportedBy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recommendationEClass, Recommendation.class, "Recommendation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecommendation_ID(), ecorePackage.getEString(), "ID", null, 0, 1, Recommendation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecommendation_Name(), ecorePackage.getEString(), "name", null, 0, 1, Recommendation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRecommendation_Description(), ecorePackage.getEString(), "description", null, 0, 1, Recommendation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(strengthEClass, Strength.class, "Strength", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(requiredActionEClass, RequiredAction.class, "RequiredAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(weaknessEClass, Weakness.class, "Weakness", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(questionEClass, Question.class, "Question", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(additionalElementEClass, AdditionalElement.class, "AdditionalElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdditionalElement_Attachment(), ecorePackage.getEString(), "attachment", null, 0, 1, AdditionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(additionalLinkEClass, AdditionalLink.class, "AdditionalLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moduleElementEClass, ModuleElement.class, "ModuleElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModuleElement_Attachment(), ecorePackage.getEString(), "attachment", null, 0, 1, ModuleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contractEClass, Contract.class, "Contract", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(assessStatusEEnum, AssessStatus.class, "AssessStatus");
		addEEnumLiteral(assessStatusEEnum, AssessStatus.NOT_REVIEWED);
		addEEnumLiteral(assessStatusEEnum, AssessStatus.ACCEPTED);
		addEEnumLiteral(assessStatusEEnum, AssessStatus.INCORRECT);
		addEEnumLiteral(assessStatusEEnum, AssessStatus.WEAK);
		addEEnumLiteral(assessStatusEEnum, AssessStatus.REVIEW_LATER);

		initEEnum(levelEEnum, Level.class, "Level");
		addEEnumLiteral(levelEEnum, Level.VERY_LOW);
		addEEnumLiteral(levelEEnum, Level.LOW);
		addEEnumLiteral(levelEEnum, Level.MEDIUM);
		addEEnumLiteral(levelEEnum, Level.HIGH);
		addEEnumLiteral(levelEEnum, Level.VERY_HIGH);

		// Initialize data types
		initEDataType(beliefDegreeEDataType, double[].class, "beliefDegree", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(percentageEDataType, Integer.class, "percentage", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// gmf.diagram
		createGmfAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
		// gmf.link
		createGmf_1Annotations();
		// gmf.label
		createGmf_2Annotations();
		// gmf.node
		createGmf_3Annotations();
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf.diagram";	
		addAnnotation
		  (safetyCaseEClass, 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";	
		addAnnotation
		  (getSafetyCase_Id(), 
		   source, 
		   new String[] {
			 "name", "id",
			 "namespace", "http://sdq.ipd.uka.de/Identifier/1.0"
		   });	
		addAnnotation
		  (getBasicNode_Id(), 
		   source, 
		   new String[] {
			 "name", "id",
			 "namespace", "http://sdq.ipd.uka.de/Identifier/1.0"
		   });	
		addAnnotation
		  (getBasicLink_Id(), 
		   source, 
		   new String[] {
			 "name", "id",
			 "namespace", "http://sdq.ipd.uka.de/Identifier/1.0"
		   });	
		addAnnotation
		  (percentageEDataType, 
		   source, 
		   new String[] {
			 "maxInclusive", "100",
			 "minInclusive", "0"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.link";	
		addAnnotation
		  (getBasicNode_HasComment(), 
		   source, 
		   new String[] {
			 "style", "solid",
			 "width", "1",
			 "tool.small.bundle", "AGSN.edit",
			 "tool.small.path", "icons/full/obj16/BasicNodeHasComment.gif"
		   });	
		addAnnotation
		  (inContextOfEClass, 
		   source, 
		   new String[] {
			 "source", "source",
			 "target", "target",
			 "style", "solid",
			 "target.decoration", "closedarrow",
			 "width", "1",
			 "color", "0,0,0"
		   });	
		addAnnotation
		  (supportedByEClass, 
		   source, 
		   new String[] {
			 "source", "source",
			 "target", "target",
			 "style", "solid",
			 "target.decoration", "filledclosedarrow",
			 "width", "1",
			 "color", "0,0,0"
		   });	
		addAnnotation
		  (additionalLinkEClass, 
		   source, 
		   new String[] {
			 "source", "source",
			 "target", "target",
			 "style", "dash",
			 "target.decoration", "filledclosedarrow",
			 "width", "1",
			 "color", "0,0,0"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.label</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.label";	
		addAnnotation
		  (getBasicNode_Description(), 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (getRecommendation_Description(), 
		   source, 
		   new String[] {
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.node";	
		addAnnotation
		  (goalEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.icon", "false",
			 "label.pattern", "Goal: {0}",
			 "figure", "gsnfigures.GSNGoal",
			 "size", "120,80",
			 "color", "255,255,255"
		   });	
		addAnnotation
		  (strategyEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.icon", "false",
			 "label.pattern", "Strategy: {0}",
			 "figure", "gsnfigures.GSNStrategy",
			 "size", "120,80",
			 "color", "255,255,255"
		   });	
		addAnnotation
		  (evidenceEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.icon", "false",
			 "label.pattern", "Evidence: {0}",
			 "figure", "gsnfigures.GSNSolution",
			 "size", "80,80",
			 "color", "255,255,255"
		   });	
		addAnnotation
		  (contextEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.icon", "false",
			 "label.pattern", "Context: {0}",
			 "figure", "gsnfigures.GSNContext",
			 "size", "120,80",
			 "color", "255,255,255"
		   });	
		addAnnotation
		  (justificationEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.icon", "false",
			 "label.pattern", "Justification: {0}",
			 "figure", "gsnfigures.GSNJustification",
			 "size", "120,80",
			 "color", "255,255,255"
		   });	
		addAnnotation
		  (assumptionEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.icon", "false",
			 "label.pattern", "Assumption: {0}",
			 "figure", "gsnfigures.GSNAssumption",
			 "size", "120,80",
			 "color", "255,255,255"
		   });	
		addAnnotation
		  (strengthEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.pattern", "Strength: {0}",
			 "figure", "rectangle",
			 "size", "120,80"
		   });	
		addAnnotation
		  (requiredActionEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.pattern", "Required Action: {0}",
			 "figure", "rectangle",
			 "size", "120,80"
		   });	
		addAnnotation
		  (weaknessEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.pattern", "Weakness: {0}",
			 "figure", "rectangle",
			 "size", "120,80"
		   });	
		addAnnotation
		  (questionEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.pattern", "Question: {0}",
			 "figure", "rectangle",
			 "size", "120,80"
		   });	
		addAnnotation
		  (additionalElementEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.pattern", "Additional Node: {0}",
			 "figure", "rectangle",
			 "size", "120,80",
			 "color", "255,255,255"
		   });	
		addAnnotation
		  (moduleEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.icon", "false",
			 "label.pattern", "Module: {0}",
			 "figure", "gsnfigures.GSNModule",
			 "size", "120,80",
			 "color", "255,255,255"
		   });	
		addAnnotation
		  (contractEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.icon", "false",
			 "label.pattern", "Contract: {0}",
			 "figure", "gsnfigures.GSNContract",
			 "size", "120,80",
			 "color", "255,255,255"
		   });
	}

} //GSNPackageImpl
