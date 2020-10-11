/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.ASILLevel;
import edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement;
import edu.toronto.cs.se.modelepedia.safetycase.AndSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.Assumption;
import edu.toronto.cs.se.modelepedia.safetycase.BasicGoal;
import edu.toronto.cs.se.modelepedia.safetycase.BasicStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactType;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.IndependenceGoal;
import edu.toronto.cs.se.modelepedia.safetycase.Justification;
import edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.OrSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCaseFactory;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.StatefulElement;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;
import edu.toronto.cs.se.modelepedia.safetycase.ValidityValue;

import edu.toronto.cs.se.modelepedia.safetycase.XorSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.util.SafetyCaseValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	private EClass statefulElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asiLfulElementEClass = null;

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
	private EClass basicGoalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass independenceGoalEClass = null;

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
	private EClass basicStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asilDecompositionStrategyEClass = null;

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
	private EClass asilEClass = null;

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
	private EClass supportableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supporterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass supportConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andSupporterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orSupporterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xorSupporterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mofNSupporterEClass = null;

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
	private EEnum validityValueEEnum = null;

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
		Object registeredSafetyCasePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SafetyCasePackageImpl theSafetyCasePackage = registeredSafetyCasePackage instanceof SafetyCasePackageImpl ? (SafetyCasePackageImpl)registeredSafetyCasePackage : new SafetyCasePackageImpl();

		isInited = true;

		// Create package meta-data objects
		theSafetyCasePackage.createPackageContents();

		// Initialize created meta-data
		theSafetyCasePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theSafetyCasePackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return SafetyCaseValidator.INSTANCE;
				 }
			 });

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
	@Override
	public EClass getSafetyCase() {
		return safetyCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSafetyCase_Goals() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSafetyCase_Strategies() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSafetyCase_Solutions() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSafetyCase_Contexts() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSafetyCase_Justifications() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSafetyCase_Assumptions() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSafetyCase_Connectors() {
		return (EReference)safetyCaseEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getArgumentElement() {
		return argumentElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArgumentElement_Id() {
		return (EAttribute)argumentElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArgumentElement_Description() {
		return (EAttribute)argumentElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getArgumentElement_ContentValidity() {
		return (EAttribute)argumentElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getArgumentElement_Status() {
		return (EReference)argumentElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatefulElement() {
		return statefulElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStatefulElement_StateValidity() {
		return (EAttribute)statefulElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getASILfulElement() {
		return asiLfulElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getASILfulElement_Asil() {
		return (EReference)asiLfulElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCoreElement() {
		return coreElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDecomposableCoreElement() {
		return decomposableCoreElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDecomposableCoreElement_InContextOf() {
		return (EReference)decomposableCoreElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContextualElement() {
		return contextualElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContextualElement_ContextOf() {
		return (EReference)contextualElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSupportedBy() {
		return supportedByEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSupportedBy_Source() {
		return (EReference)supportedByEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSupportedBy_Target() {
		return (EReference)supportedByEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInContextOf() {
		return inContextOfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInContextOf_Context() {
		return (EReference)inContextOfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInContextOf_ContextOf() {
		return (EReference)inContextOfEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getGoal() {
		return goalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBasicGoal() {
		return basicGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIndependenceGoal() {
		return independenceGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStrategy() {
		return strategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBasicStrategy() {
		return basicStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getASILDecompositionStrategy() {
		return asilDecompositionStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSolution() {
		return solutionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJustification() {
		return justificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssumption() {
		return assumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getASIL() {
		return asilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getASIL_Value() {
		return (EAttribute)asilEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getASIL_Target() {
		return (EReference)asilEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getASIL_Status() {
		return (EReference)asilEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImpactAnnotation() {
		return impactAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImpactAnnotation_Type() {
		return (EAttribute)impactAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImpactAnnotation_Source() {
		return (EAttribute)impactAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSupportable() {
		return supportableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSupportable_SupportedBy() {
		return (EReference)supportableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSupporter() {
		return supporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSupporter_Supports() {
		return (EReference)supporterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSupportConnector() {
		return supportConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAndSupporter() {
		return andSupporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOrSupporter() {
		return orSupporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getXorSupporter() {
		return xorSupporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMofNSupporter() {
		return mofNSupporterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMofNSupporter_Target() {
		return (EAttribute)mofNSupporterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getASILLevel() {
		return asilLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getValidityValue() {
		return validityValueEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getImpactType() {
		return impactTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
		createEReference(safetyCaseEClass, SAFETY_CASE__JUSTIFICATIONS);
		createEReference(safetyCaseEClass, SAFETY_CASE__ASSUMPTIONS);
		createEReference(safetyCaseEClass, SAFETY_CASE__CONNECTORS);

		argumentElementEClass = createEClass(ARGUMENT_ELEMENT);
		createEAttribute(argumentElementEClass, ARGUMENT_ELEMENT__ID);
		createEAttribute(argumentElementEClass, ARGUMENT_ELEMENT__DESCRIPTION);
		createEAttribute(argumentElementEClass, ARGUMENT_ELEMENT__CONTENT_VALIDITY);
		createEReference(argumentElementEClass, ARGUMENT_ELEMENT__STATUS);

		statefulElementEClass = createEClass(STATEFUL_ELEMENT);
		createEAttribute(statefulElementEClass, STATEFUL_ELEMENT__STATE_VALIDITY);

		asiLfulElementEClass = createEClass(ASI_LFUL_ELEMENT);
		createEReference(asiLfulElementEClass, ASI_LFUL_ELEMENT__ASIL);

		coreElementEClass = createEClass(CORE_ELEMENT);

		decomposableCoreElementEClass = createEClass(DECOMPOSABLE_CORE_ELEMENT);
		createEReference(decomposableCoreElementEClass, DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF);

		contextualElementEClass = createEClass(CONTEXTUAL_ELEMENT);
		createEReference(contextualElementEClass, CONTEXTUAL_ELEMENT__CONTEXT_OF);

		supportedByEClass = createEClass(SUPPORTED_BY);
		createEReference(supportedByEClass, SUPPORTED_BY__SOURCE);
		createEReference(supportedByEClass, SUPPORTED_BY__TARGET);

		inContextOfEClass = createEClass(IN_CONTEXT_OF);
		createEReference(inContextOfEClass, IN_CONTEXT_OF__CONTEXT);
		createEReference(inContextOfEClass, IN_CONTEXT_OF__CONTEXT_OF);

		goalEClass = createEClass(GOAL);

		basicGoalEClass = createEClass(BASIC_GOAL);

		independenceGoalEClass = createEClass(INDEPENDENCE_GOAL);

		strategyEClass = createEClass(STRATEGY);

		basicStrategyEClass = createEClass(BASIC_STRATEGY);

		asilDecompositionStrategyEClass = createEClass(ASIL_DECOMPOSITION_STRATEGY);

		solutionEClass = createEClass(SOLUTION);

		contextEClass = createEClass(CONTEXT);

		justificationEClass = createEClass(JUSTIFICATION);

		assumptionEClass = createEClass(ASSUMPTION);

		asilEClass = createEClass(ASIL);
		createEAttribute(asilEClass, ASIL__VALUE);
		createEReference(asilEClass, ASIL__TARGET);
		createEReference(asilEClass, ASIL__STATUS);

		impactAnnotationEClass = createEClass(IMPACT_ANNOTATION);
		createEAttribute(impactAnnotationEClass, IMPACT_ANNOTATION__TYPE);
		createEAttribute(impactAnnotationEClass, IMPACT_ANNOTATION__SOURCE);

		supportableEClass = createEClass(SUPPORTABLE);
		createEReference(supportableEClass, SUPPORTABLE__SUPPORTED_BY);

		supporterEClass = createEClass(SUPPORTER);
		createEReference(supporterEClass, SUPPORTER__SUPPORTS);

		supportConnectorEClass = createEClass(SUPPORT_CONNECTOR);

		andSupporterEClass = createEClass(AND_SUPPORTER);

		orSupporterEClass = createEClass(OR_SUPPORTER);

		xorSupporterEClass = createEClass(XOR_SUPPORTER);

		mofNSupporterEClass = createEClass(MOF_NSUPPORTER);
		createEAttribute(mofNSupporterEClass, MOF_NSUPPORTER__TARGET);

		// Create enums
		asilLevelEEnum = createEEnum(ASIL_LEVEL);
		validityValueEEnum = createEEnum(VALIDITY_VALUE);
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
		coreElementEClass.getESuperTypes().add(this.getSupporter());
		decomposableCoreElementEClass.getESuperTypes().add(this.getSupportable());
		decomposableCoreElementEClass.getESuperTypes().add(this.getCoreElement());
		contextualElementEClass.getESuperTypes().add(this.getArgumentElement());
		goalEClass.getESuperTypes().add(this.getDecomposableCoreElement());
		goalEClass.getESuperTypes().add(this.getStatefulElement());
		goalEClass.getESuperTypes().add(this.getASILfulElement());
		basicGoalEClass.getESuperTypes().add(this.getGoal());
		independenceGoalEClass.getESuperTypes().add(this.getGoal());
		strategyEClass.getESuperTypes().add(this.getDecomposableCoreElement());
		basicStrategyEClass.getESuperTypes().add(this.getStrategy());
		asilDecompositionStrategyEClass.getESuperTypes().add(this.getStrategy());
		solutionEClass.getESuperTypes().add(this.getCoreElement());
		solutionEClass.getESuperTypes().add(this.getStatefulElement());
		contextEClass.getESuperTypes().add(this.getContextualElement());
		justificationEClass.getESuperTypes().add(this.getContextualElement());
		assumptionEClass.getESuperTypes().add(this.getContextualElement());
		supportableEClass.getESuperTypes().add(this.getSupporter());
		supportConnectorEClass.getESuperTypes().add(this.getSupportable());
		andSupporterEClass.getESuperTypes().add(this.getSupportConnector());
		orSupporterEClass.getESuperTypes().add(this.getSupportConnector());
		xorSupporterEClass.getESuperTypes().add(this.getSupportConnector());
		mofNSupporterEClass.getESuperTypes().add(this.getSupportConnector());

		// Initialize classes, features, and operations; add parameters
		initEClass(safetyCaseEClass, SafetyCase.class, "SafetyCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSafetyCase_Goals(), this.getGoal(), null, "goals", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_Strategies(), this.getStrategy(), null, "strategies", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_Solutions(), this.getSolution(), null, "solutions", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_Contexts(), this.getContext(), null, "contexts", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_Justifications(), this.getJustification(), null, "justifications", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_Assumptions(), this.getAssumption(), null, "assumptions", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafetyCase_Connectors(), this.getSupportConnector(), null, "connectors", null, 0, -1, SafetyCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(argumentElementEClass, ArgumentElement.class, "ArgumentElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArgumentElement_Id(), ecorePackage.getEString(), "id", null, 1, 1, ArgumentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArgumentElement_Description(), ecorePackage.getEString(), "description", null, 0, 1, ArgumentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArgumentElement_ContentValidity(), this.getValidityValue(), "contentValidity", null, 0, 1, ArgumentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArgumentElement_Status(), this.getImpactAnnotation(), null, "status", null, 0, 1, ArgumentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statefulElementEClass, StatefulElement.class, "StatefulElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatefulElement_StateValidity(), this.getValidityValue(), "stateValidity", null, 0, 1, StatefulElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(asiLfulElementEClass, ASILfulElement.class, "ASILfulElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getASILfulElement_Asil(), this.getASIL(), this.getASIL_Target(), "asil", null, 0, 1, ASILfulElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coreElementEClass, CoreElement.class, "CoreElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(decomposableCoreElementEClass, DecomposableCoreElement.class, "DecomposableCoreElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDecomposableCoreElement_InContextOf(), this.getInContextOf(), this.getInContextOf_ContextOf(), "inContextOf", null, 0, -1, DecomposableCoreElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextualElementEClass, ContextualElement.class, "ContextualElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextualElement_ContextOf(), this.getInContextOf(), this.getInContextOf_Context(), "contextOf", null, 1, -1, ContextualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(supportedByEClass, SupportedBy.class, "SupportedBy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSupportedBy_Source(), this.getSupportable(), this.getSupportable_SupportedBy(), "source", null, 1, 1, SupportedBy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSupportedBy_Target(), this.getSupporter(), this.getSupporter_Supports(), "target", null, 1, 1, SupportedBy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inContextOfEClass, InContextOf.class, "InContextOf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInContextOf_Context(), this.getContextualElement(), this.getContextualElement_ContextOf(), "context", null, 1, 1, InContextOf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInContextOf_ContextOf(), this.getDecomposableCoreElement(), this.getDecomposableCoreElement_InContextOf(), "contextOf", null, 1, 1, InContextOf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(goalEClass, Goal.class, "Goal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(basicGoalEClass, BasicGoal.class, "BasicGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(independenceGoalEClass, IndependenceGoal.class, "IndependenceGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strategyEClass, Strategy.class, "Strategy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(basicStrategyEClass, BasicStrategy.class, "BasicStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(asilDecompositionStrategyEClass, ASILDecompositionStrategy.class, "ASILDecompositionStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(solutionEClass, Solution.class, "Solution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(justificationEClass, Justification.class, "Justification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assumptionEClass, Assumption.class, "Assumption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(asilEClass, edu.toronto.cs.se.modelepedia.safetycase.ASIL.class, "ASIL", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getASIL_Value(), this.getASILLevel(), "value", null, 1, 1, edu.toronto.cs.se.modelepedia.safetycase.ASIL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getASIL_Target(), this.getASILfulElement(), this.getASILfulElement_Asil(), "target", null, 1, 1, edu.toronto.cs.se.modelepedia.safetycase.ASIL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getASIL_Status(), this.getImpactAnnotation(), null, "status", null, 0, 1, edu.toronto.cs.se.modelepedia.safetycase.ASIL.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(impactAnnotationEClass, ImpactAnnotation.class, "ImpactAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImpactAnnotation_Type(), this.getImpactType(), "type", null, 1, 1, ImpactAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getImpactAnnotation_Source(), ecorePackage.getEString(), "source", null, 0, 1, ImpactAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(supportableEClass, Supportable.class, "Supportable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSupportable_SupportedBy(), this.getSupportedBy(), this.getSupportedBy_Source(), "supportedBy", null, 1, -1, Supportable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(supporterEClass, Supporter.class, "Supporter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSupporter_Supports(), this.getSupportedBy(), this.getSupportedBy_Target(), "supports", null, 0, -1, Supporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(supportConnectorEClass, SupportConnector.class, "SupportConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(andSupporterEClass, AndSupporter.class, "AndSupporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orSupporterEClass, OrSupporter.class, "OrSupporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xorSupporterEClass, XorSupporter.class, "XorSupporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mofNSupporterEClass, MofNSupporter.class, "MofNSupporter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMofNSupporter_Target(), ecorePackage.getELong(), "target", "1", 1, 1, MofNSupporter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(asilLevelEEnum, ASILLevel.class, "ASILLevel");
		addEEnumLiteral(asilLevelEEnum, ASILLevel.D);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.C);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.B);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.A);
		addEEnumLiteral(asilLevelEEnum, ASILLevel.QM);

		initEEnum(validityValueEEnum, ValidityValue.class, "ValidityValue");
		addEEnumLiteral(validityValueEEnum, ValidityValue.INVALID);
		addEEnumLiteral(validityValueEEnum, ValidityValue.VALID);
		addEEnumLiteral(validityValueEEnum, ValidityValue.UNDETERMINED);

		initEEnum(impactTypeEEnum, ImpactType.class, "ImpactType");
		addEEnumLiteral(impactTypeEEnum, ImpactType.REVISE);
		addEEnumLiteral(impactTypeEEnum, ImpactType.RECHECK_CONTENT);
		addEEnumLiteral(impactTypeEEnum, ImpactType.RECHECK_STATE);
		addEEnumLiteral(impactTypeEEnum, ImpactType.REUSE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
		// gmf.label
		createGmfAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
			   "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
		   });
		addAnnotation
		  (safetyCaseEClass,
		   source,
		   new String[] {
			   "constraints", "SingleRoot"
		   });
		addAnnotation
		  (contextualElementEClass,
		   source,
		   new String[] {
			   "constraints", "ContextualElementSupporter ContextualElementContext"
		   });
		addAnnotation
		  (goalEClass,
		   source,
		   new String[] {
			   "constraints", "GoalSupporter GoalContext ASILInheritance"
		   });
		addAnnotation
		  (strategyEClass,
		   source,
		   new String[] {
			   "constraints", "StrategySupporter StrategyContext"
		   });
		addAnnotation
		  (asilDecompositionStrategyEClass,
		   source,
		   new String[] {
			   "constraints", "ASILDecompositionIndependence ASILDecompositionComponents ASILDescendants"
		   });
		addAnnotation
		  (solutionEClass,
		   source,
		   new String[] {
			   "constraints", "SolutionSupporter SolutionContext"
		   });
		addAnnotation
		  (supportableEClass,
		   source,
		   new String[] {
			   "constraints", "SupportCycle NonSupportableLeaves"
		   });
		addAnnotation
		  (supporterEClass,
		   source,
		   new String[] {
			   "constraints", "GoalRoot"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (safetyCaseEClass,
		   source,
		   new String[] {
			   "SingleRoot", "Supporter.allInstances() -> \n\t\t\tselect(d | d.supports.source -> isEmpty()) -> size() = 1"
		   });
		addAnnotation
		  (contextualElementEClass,
		   source,
		   new String[] {
			   "ContextualElementSupporter", "self.oclAsType(DecomposableCoreElement).oclIsInvalid()",
			   "ContextualElementContext", "self.oclAsType(DecomposableCoreElement).oclIsInvalid()"
		   });
		addAnnotation
		  (goalEClass,
		   source,
		   new String[] {
			   "GoalSupporter", "\n\t\t\tlet children : Set(Supporter) = self.supportedBy.target -> closure(p | if p.oclIsKindOf(CoreElement) then p.oclAsSet() else p.oclAsType(Supportable).supportedBy.target endif) -> asSet()\n\t\t\tin children -> selectByKind(CoreElement) -> forAll(s | s.oclIsKindOf(Goal) or s.oclIsKindOf(Strategy) or s.oclIsKindOf(Solution))",
			   "GoalContext", "self.inContextOf.context -> forAll(c | c.oclIsKindOf(Context) or c.oclIsKindOf(Assumption) or c.oclIsKindOf(Justification))",
			   "ASILInheritance", "\n\t\t\tlet parents : Set(Goal) = self.supports.source -> closure(c | if c.oclIsKindOf(Goal) or c.oclIsKindOf(ASILDecompositionStrategy) then c.oclAsSet() else c.supports.source endif) -> selectByKind(Goal) -> asSet()\n\t\t\tin parents -> forAll(g | if g.asil = null then true else if self.asil = null then false else g.asil.value = ASILLevel::QM or (g.asil.value.toString() <= self.asil.value.toString() and self.asil.value <> ASILLevel::QM) endif endif)"
		   });
		addAnnotation
		  (strategyEClass,
		   source,
		   new String[] {
			   "StrategySupporter", "\n\t\t\tlet children : Set(Supporter) = self.supportedBy.target -> closure(p | if p.oclIsKindOf(CoreElement) then p.oclAsSet() else p.oclAsType(Supportable).supportedBy.target endif) -> asSet() \n\t\t\tin children -> selectByKind(CoreElement) -> forAll(s | s.oclIsKindOf(Goal) or s.oclIsKindOf(Solution))",
			   "StrategyContext", "self.inContextOf.context -> forAll(c | c.oclIsKindOf(Context) or c.oclIsKindOf(Assumption) or c.oclIsKindOf(Justification))"
		   });
		addAnnotation
		  (asilDecompositionStrategyEClass,
		   source,
		   new String[] {
			   "ASILDecompositionIndependence", "\n\t\t\tlet children = self.supportedBy.target -> closure(s | if s.oclIsKindOf(SupportConnector) then s.oclAsType(SupportConnector).supportedBy.target else s.oclAsSet() endif)\n\t\t\tin children -> selectByType(IndependenceGoal) -> size() = 1",
			   "ASILDecompositionComponents", " \n\t\t\tlet children = self.supportedBy.target -> closure(s | if s.oclIsKindOf(SupportConnector) then s.oclAsType(SupportConnector).supportedBy.target else s.oclAsSet() endif)\n\t\t\tin children -> selectByType(BasicGoal) -> size() = 2",
			   "ASILDescendants", "\n\t\t\tlet goalSeq = self.supportedBy.target -> closure(s | if s.oclIsKindOf(SupportConnector) then s.oclAsType(SupportConnector).supportedBy.target else s.oclAsSet() endif) -> select(p | p.oclIsTypeOf(BasicGoal)), \n\t\t\tg1Descendants : Set(Supporter) = goalSeq -> at(1) -> closure(c | \n\t\t\t\t\tif c.oclIsKindOf(Supportable) then c.oclAsType(Supportable).supportedBy.target else null endif),\n\t\t\tg2Descendants : Set(Supporter) = goalSeq -> at(2) -> closure(c | \n\t\t\t\t\tif c.oclIsKindOf(Supportable) then c.oclAsType(Supportable).supportedBy.target else null endif) \n\t\t\tin g1Descendants -> intersection(g2Descendants) = Set{}"
		   });
		addAnnotation
		  (solutionEClass,
		   source,
		   new String[] {
			   "SolutionSupporter", "self.oclAsType(DecomposableCoreElement).oclIsInvalid()",
			   "SolutionContext", "self.oclAsType(DecomposableCoreElement).oclIsInvalid()"
		   });
		addAnnotation
		  (supportableEClass,
		   source,
		   new String[] {
			   "SupportCycle", "self.supportedBy.target -> closure(p | if p.oclIsKindOf(Supportable) then \n\t\t\tp.oclAsType(Supportable).supportedBy.target else \n\t\t\tp.oclAsSet() endif) -> excludes(self)",
			   "NonSupportableLeaves", "self.supportedBy.target -> size() > 0 and self.supportedBy.target -> excludes(null)"
		   });
		addAnnotation
		  (supporterEClass,
		   source,
		   new String[] {
			   "GoalRoot", "self.supports.source -> isEmpty() implies self.oclIsTypeOf(BasicGoal)"
		   });
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
