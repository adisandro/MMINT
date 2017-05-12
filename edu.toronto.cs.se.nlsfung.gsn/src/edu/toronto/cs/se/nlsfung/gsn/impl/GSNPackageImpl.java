/**
 */
package edu.toronto.cs.se.nlsfung.gsn.impl;

import edu.toronto.cs.se.nlsfung.gsn.ASILLevel;
import edu.toronto.cs.se.nlsfung.gsn.Context;
import edu.toronto.cs.se.nlsfung.gsn.ContextualElement;
import edu.toronto.cs.se.nlsfung.gsn.GSNFactory;
import edu.toronto.cs.se.nlsfung.gsn.GSNPackage;
import edu.toronto.cs.se.nlsfung.gsn.Goal;
import edu.toronto.cs.se.nlsfung.gsn.GoalSupporter;
import edu.toronto.cs.se.nlsfung.gsn.GsnElement;
import edu.toronto.cs.se.nlsfung.gsn.SafetyCase;
import edu.toronto.cs.se.nlsfung.gsn.Solution;
import edu.toronto.cs.se.nlsfung.gsn.Strategy;
import edu.toronto.cs.se.nlsfung.gsn.StrategySupporter;
import edu.toronto.cs.se.nlsfung.gsn.TruthState;
import edu.toronto.cs.se.nlsfung.gsn.ValidityState;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
	private EClass gsnElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalSupporterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strategySupporterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextualElementEClass = null;

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
	private EClass solutionEClass = null;

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
	private EClass asilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum truthStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum asilLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum validityStateEEnum = null;

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
	public EReference getSafetyCase_Elements() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGsnElement() {
		return gsnElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGsnElement_Id() {
		return (EAttribute)gsnElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGsnElement_Name() {
		return (EAttribute)gsnElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGsnElement_Description() {
		return (EAttribute)gsnElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoalSupporter() {
		return goalSupporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrategySupporter() {
		return strategySupporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextualElement() {
		return contextualElementEClass;
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
	public EAttribute getGoal_State() {
		return (EAttribute)goalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGoal_SupportedBy() {
		return (EReference)goalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGoal_InContextOf() {
		return (EReference)goalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGoal_Supports() {
		return (EReference)goalEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getStrategy_State() {
		return (EAttribute)strategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStrategy_SupportedBy() {
		return (EReference)strategyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStrategy_InContextOf() {
		return (EReference)strategyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStrategy_Supports() {
		return (EReference)strategyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolution() {
		return solutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSolution_State() {
		return (EAttribute)solutionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolution_Supports() {
		return (EReference)solutionEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getContext_State() {
		return (EAttribute)contextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContext_ContextOf() {
		return (EReference)contextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getASIL() {
		return asilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getASIL_Level() {
		return (EAttribute)asilEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTruthState() {
		return truthStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getASILLevel() {
		return asilLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getValidityState() {
		return validityStateEEnum;
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
		createEReference(safetyCaseEClass, SAFETY_CASE__ELEMENTS);

		gsnElementEClass = createEClass(GSN_ELEMENT);
		createEAttribute(gsnElementEClass, GSN_ELEMENT__ID);
		createEAttribute(gsnElementEClass, GSN_ELEMENT__NAME);
		createEAttribute(gsnElementEClass, GSN_ELEMENT__DESCRIPTION);

		goalSupporterEClass = createEClass(GOAL_SUPPORTER);

		strategySupporterEClass = createEClass(STRATEGY_SUPPORTER);

		contextualElementEClass = createEClass(CONTEXTUAL_ELEMENT);

		goalEClass = createEClass(GOAL);
		createEAttribute(goalEClass, GOAL__STATE);
		createEReference(goalEClass, GOAL__SUPPORTED_BY);
		createEReference(goalEClass, GOAL__IN_CONTEXT_OF);
		createEReference(goalEClass, GOAL__SUPPORTS);

		strategyEClass = createEClass(STRATEGY);
		createEAttribute(strategyEClass, STRATEGY__STATE);
		createEReference(strategyEClass, STRATEGY__SUPPORTED_BY);
		createEReference(strategyEClass, STRATEGY__IN_CONTEXT_OF);
		createEReference(strategyEClass, STRATEGY__SUPPORTS);

		solutionEClass = createEClass(SOLUTION);
		createEAttribute(solutionEClass, SOLUTION__STATE);
		createEReference(solutionEClass, SOLUTION__SUPPORTS);

		contextEClass = createEClass(CONTEXT);
		createEAttribute(contextEClass, CONTEXT__STATE);
		createEReference(contextEClass, CONTEXT__CONTEXT_OF);

		asilEClass = createEClass(ASIL);
		createEAttribute(asilEClass, ASIL__LEVEL);

		// Create enums
		truthStateEEnum = createEEnum(TRUTH_STATE);
		asilLevelEEnum = createEEnum(ASIL_LEVEL);
		validityStateEEnum = createEEnum(VALIDITY_STATE);
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
		goalEClass.getESuperTypes().add(this.getGsnElement());
		goalEClass.getESuperTypes().add(this.getStrategySupporter());
		goalEClass.getESuperTypes().add(this.getContextualElement());
		strategyEClass.getESuperTypes().add(this.getGsnElement());
		strategyEClass.getESuperTypes().add(this.getGoalSupporter());
		strategyEClass.getESuperTypes().add(this.getContextualElement());
		solutionEClass.getESuperTypes().add(this.getGsnElement());
		solutionEClass.getESuperTypes().add(this.getGoalSupporter());
		contextEClass.getESuperTypes().add(this.getGsnElement());
		asilEClass.getESuperTypes().add(this.getContext());

		// Initialize classes, features, and operations; add parameters
		initEClass(safetyCaseEClass, SafetyCase.class, "SafetyCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSafetyCase_Elements(), this.getGsnElement(), null, "elements", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gsnElementEClass, GsnElement.class, "GsnElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGsnElement_Id(), ecorePackage.getEString(), "id", null, 0, 1, GsnElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGsnElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, GsnElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGsnElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, GsnElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goalSupporterEClass, GoalSupporter.class, "GoalSupporter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strategySupporterEClass, StrategySupporter.class, "StrategySupporter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contextualElementEClass, ContextualElement.class, "ContextualElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoal_State(), this.getTruthState(), "state", null, 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoal_SupportedBy(), this.getGoalSupporter(), null, "supportedBy", null, 1, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoal_InContextOf(), this.getContext(), null, "inContextOf", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGoal_Supports(), this.getStrategy(), null, "supports", null, 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(strategyEClass, Strategy.class, "Strategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStrategy_State(), this.getValidityState(), "state", null, 0, 1, Strategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStrategy_SupportedBy(), this.getStrategySupporter(), null, "supportedBy", null, 1, -1, Strategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStrategy_InContextOf(), this.getContext(), null, "inContextOf", null, 0, -1, Strategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStrategy_Supports(), this.getGoal(), null, "supports", null, 1, 1, Strategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solutionEClass, Solution.class, "Solution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSolution_State(), this.getValidityState(), "state", null, 0, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolution_Supports(), this.getGoal(), null, "supports", null, 1, -1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContext_State(), this.getValidityState(), "state", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_ContextOf(), this.getContextualElement(), null, "contextOf", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(asilEClass, edu.toronto.cs.se.nlsfung.gsn.ASIL.class, "ASIL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getASIL_Level(), this.getASILLevel(), "level", null, 0, 1, edu.toronto.cs.se.nlsfung.gsn.ASIL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(truthStateEEnum, TruthState.class, "TruthState");
		addEEnumLiteral(truthStateEEnum, TruthState.FALSE);
		addEEnumLiteral(truthStateEEnum, TruthState.TRUE);

		initEEnum(asilLevelEEnum, ASILLevel.class, "ASILLevel");
		addEEnumLiteral(asilLevelEEnum, ASILLevel.D);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.C);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.B);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.A);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.QM);

		initEEnum(validityStateEEnum, ValidityState.class, "ValidityState");
		addEEnumLiteral(validityStateEEnum, ValidityState.INVALID);
		addEEnumLiteral(validityStateEEnum, ValidityState.VALID);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
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
		  (getGsnElement_Id(), 
		   source, 
		   new String[] {
			 "name", "id",
			 "namespace", "http://sdq.ipd.uka.de/Identifier/1.0"
		   });
	}

} //GSNPackageImpl
