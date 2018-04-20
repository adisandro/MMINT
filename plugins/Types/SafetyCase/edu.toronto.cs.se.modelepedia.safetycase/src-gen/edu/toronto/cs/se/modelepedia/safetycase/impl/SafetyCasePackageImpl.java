/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import edu.toronto.cs.se.modelepedia.safetycase.ASILLevel;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactType;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCaseFactory;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.TruthState;
import edu.toronto.cs.se.modelepedia.safetycase.ValidityState;

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
public class SafetyCasePackageImpl extends EPackageImpl implements SafetyCasePackage {
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
	private EClass argumentElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coreElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decomposableCoreElementEClass = null;

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
	private EClass supportedByEClass = null;

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
	private EClass impactAnnotationEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum impactTypeEEnum = null;

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
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SafetyCasePackageImpl() {
		super(eNS_URI, SafetyCaseFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SafetyCasePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SafetyCasePackage init() {
		if (isInited) return (SafetyCasePackage)EPackage.Registry.INSTANCE.getEPackage(SafetyCasePackage.eNS_URI);

		// Obtain or create and register package
		SafetyCasePackageImpl theSafetyCasePackage = (SafetyCasePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SafetyCasePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SafetyCasePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSafetyCasePackage.createPackageContents();

		// Initialize created meta-data
		theSafetyCasePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSafetyCasePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SafetyCasePackage.eNS_URI, theSafetyCasePackage);
		return theSafetyCasePackage;
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
	public EReference getSafetyCase_Goals() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyCase_Strategies() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyCase_Solutions() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSafetyCase_Contexts() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArgumentElement() {
		return argumentElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArgumentElement_Id() {
		return (EAttribute)argumentElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArgumentElement_Description() {
		return (EAttribute)argumentElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArgumentElement_Status() {
		return (EReference)argumentElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoreElement() {
		return coreElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCoreElement_Supports() {
		return (EReference)coreElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecomposableCoreElement() {
		return decomposableCoreElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecomposableCoreElement_SupportedBy() {
		return (EReference)decomposableCoreElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDecomposableCoreElement_InContextOf() {
		return (EReference)decomposableCoreElementEClass.getEStructuralFeatures().get(1);
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
	public EReference getContextualElement_ContextOf() {
		return (EReference)contextualElementEClass.getEStructuralFeatures().get(0);
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
	public EReference getSupportedBy_Conclusion() {
		return (EReference)supportedByEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSupportedBy_Premise() {
		return (EReference)supportedByEClass.getEStructuralFeatures().get(1);
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
	public EReference getInContextOf_Context() {
		return (EReference)inContextOfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInContextOf_ContextOf() {
		return (EReference)inContextOfEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getGoal_Asil() {
		return (EAttribute)goalEClass.getEStructuralFeatures().get(1);
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
	public EClass getImpactAnnotation() {
		return impactAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImpactAnnotation_Type() {
		return (EAttribute)impactAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImpactAnnotation_Source() {
		return (EAttribute)impactAnnotationEClass.getEStructuralFeatures().get(1);
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
	public EEnum getImpactType() {
		return impactTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SafetyCaseFactory getSafetyCaseFactory() {
		return (SafetyCaseFactory)getEFactoryInstance();
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
		createEReference(safetyCaseEClass, SAFETY_CASE__GOALS);
		createEReference(safetyCaseEClass, SAFETY_CASE__STRATEGIES);
		createEReference(safetyCaseEClass, SAFETY_CASE__SOLUTIONS);
		createEReference(safetyCaseEClass, SAFETY_CASE__CONTEXTS);

		argumentElementEClass = createEClass(ARGUMENT_ELEMENT);
		createEAttribute(argumentElementEClass, ARGUMENT_ELEMENT__ID);
		createEAttribute(argumentElementEClass, ARGUMENT_ELEMENT__DESCRIPTION);
		createEReference(argumentElementEClass, ARGUMENT_ELEMENT__STATUS);

		coreElementEClass = createEClass(CORE_ELEMENT);
		createEReference(coreElementEClass, CORE_ELEMENT__SUPPORTS);

		decomposableCoreElementEClass = createEClass(DECOMPOSABLE_CORE_ELEMENT);
		createEReference(decomposableCoreElementEClass, DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY);
		createEReference(decomposableCoreElementEClass, DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF);

		contextualElementEClass = createEClass(CONTEXTUAL_ELEMENT);
		createEReference(contextualElementEClass, CONTEXTUAL_ELEMENT__CONTEXT_OF);

		supportedByEClass = createEClass(SUPPORTED_BY);
		createEReference(supportedByEClass, SUPPORTED_BY__CONCLUSION);
		createEReference(supportedByEClass, SUPPORTED_BY__PREMISE);

		inContextOfEClass = createEClass(IN_CONTEXT_OF);
		createEReference(inContextOfEClass, IN_CONTEXT_OF__CONTEXT);
		createEReference(inContextOfEClass, IN_CONTEXT_OF__CONTEXT_OF);

		goalEClass = createEClass(GOAL);
		createEAttribute(goalEClass, GOAL__STATE);
		createEAttribute(goalEClass, GOAL__ASIL);

		strategyEClass = createEClass(STRATEGY);
		createEAttribute(strategyEClass, STRATEGY__STATE);

		solutionEClass = createEClass(SOLUTION);
		createEAttribute(solutionEClass, SOLUTION__STATE);

		contextEClass = createEClass(CONTEXT);
		createEAttribute(contextEClass, CONTEXT__STATE);

		impactAnnotationEClass = createEClass(IMPACT_ANNOTATION);
		createEAttribute(impactAnnotationEClass, IMPACT_ANNOTATION__TYPE);
		createEAttribute(impactAnnotationEClass, IMPACT_ANNOTATION__SOURCE);

		// Create enums
		truthStateEEnum = createEEnum(TRUTH_STATE);
		asilLevelEEnum = createEEnum(ASIL_LEVEL);
		validityStateEEnum = createEEnum(VALIDITY_STATE);
		impactTypeEEnum = createEEnum(IMPACT_TYPE);
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
		coreElementEClass.getESuperTypes().add(this.getArgumentElement());
		decomposableCoreElementEClass.getESuperTypes().add(this.getCoreElement());
		contextualElementEClass.getESuperTypes().add(this.getArgumentElement());
		goalEClass.getESuperTypes().add(this.getDecomposableCoreElement());
		strategyEClass.getESuperTypes().add(this.getDecomposableCoreElement());
		solutionEClass.getESuperTypes().add(this.getCoreElement());
		contextEClass.getESuperTypes().add(this.getContextualElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(safetyCaseEClass, SafetyCase.class, "SafetyCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSafetyCase_Goals(), this.getGoal(), null, "goals", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_Strategies(), this.getStrategy(), null, "strategies", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_Solutions(), this.getSolution(), null, "solutions", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_Contexts(), this.getContext(), null, "contexts", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(argumentElementEClass, ArgumentElement.class, "ArgumentElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArgumentElement_Id(), ecorePackage.getEString(), "id", "", 1, 1, ArgumentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArgumentElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, ArgumentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArgumentElement_Status(), this.getImpactAnnotation(), null, "status", null, 0, 1, ArgumentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coreElementEClass, CoreElement.class, "CoreElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCoreElement_Supports(), this.getSupportedBy(), this.getSupportedBy_Premise(), "supports", null, 0, -1, CoreElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(decomposableCoreElementEClass, DecomposableCoreElement.class, "DecomposableCoreElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDecomposableCoreElement_SupportedBy(), this.getSupportedBy(), this.getSupportedBy_Conclusion(), "supportedBy", null, 0, -1, DecomposableCoreElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDecomposableCoreElement_InContextOf(), this.getInContextOf(), this.getInContextOf_ContextOf(), "inContextOf", null, 0, -1, DecomposableCoreElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextualElementEClass, ContextualElement.class, "ContextualElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextualElement_ContextOf(), this.getInContextOf(), this.getInContextOf_Context(), "contextOf", null, 1, -1, ContextualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(supportedByEClass, SupportedBy.class, "SupportedBy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSupportedBy_Conclusion(), this.getDecomposableCoreElement(), this.getDecomposableCoreElement_SupportedBy(), "conclusion", null, 1, 1, SupportedBy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSupportedBy_Premise(), this.getCoreElement(), this.getCoreElement_Supports(), "premise", null, 1, 1, SupportedBy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inContextOfEClass, InContextOf.class, "InContextOf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInContextOf_Context(), this.getContextualElement(), this.getContextualElement_ContextOf(), "context", null, 1, 1, InContextOf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInContextOf_ContextOf(), this.getDecomposableCoreElement(), this.getDecomposableCoreElement_InContextOf(), "contextOf", null, 1, 1, InContextOf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoal_State(), this.getTruthState(), "state", null, 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoal_Asil(), this.getASILLevel(), "asil", "D", 0, 1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(strategyEClass, Strategy.class, "Strategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStrategy_State(), this.getValidityState(), "state", null, 0, 1, Strategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solutionEClass, Solution.class, "Solution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSolution_State(), this.getValidityState(), "state", null, 0, 1, Solution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContext_State(), this.getValidityState(), "state", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(impactAnnotationEClass, ImpactAnnotation.class, "ImpactAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImpactAnnotation_Type(), this.getImpactType(), "type", null, 1, 1, ImpactAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImpactAnnotation_Source(), ecorePackage.getEString(), "source", null, 0, 1, ImpactAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		addEEnumLiteral(asilLevelEEnum, ASILLevel.NO_ASIL);

		initEEnum(validityStateEEnum, ValidityState.class, "ValidityState");
		addEEnumLiteral(validityStateEEnum, ValidityState.INVALID);
		addEEnumLiteral(validityStateEEnum, ValidityState.VALID);

		initEEnum(impactTypeEEnum, ImpactType.class, "ImpactType");
		addEEnumLiteral(impactTypeEEnum, ImpactType.REVISE);
		addEEnumLiteral(impactTypeEEnum, ImpactType.RECHECK);
		addEEnumLiteral(impactTypeEEnum, ImpactType.REUSE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// gmf.label
		createGmfAnnotations();
	}

	/**
	 * Initializes the annotations for <b>gmf.label</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf.label";	
		addAnnotation
		  (getArgumentElement_Description(), 
		   source, 
		   new String[] {
			 "label", "description"
		   });
	}

} //SafetyCasePackageImpl
