/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.impl;

import edu.toronto.cs.se.mmtf.mavo.MavoPackage;

import edu.toronto.cs.se.modelepedia.istar_mavo.Actor;
import edu.toronto.cs.se.modelepedia.istar_mavo.ComponentsReference;
import edu.toronto.cs.se.modelepedia.istar_mavo.Contribution;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference;
import edu.toronto.cs.se.modelepedia.istar_mavo.Dependency;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference;
import edu.toronto.cs.se.modelepedia.istar_mavo.EndReference;
import edu.toronto.cs.se.modelepedia.istar_mavo.Goal;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOFactory;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement;
import edu.toronto.cs.se.modelepedia.istar_mavo.Resource;
import edu.toronto.cs.se.modelepedia.istar_mavo.SoftGoal;
import edu.toronto.cs.se.modelepedia.istar_mavo.Task;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IStar_MAVOPackageImpl extends EPackageImpl implements IStar_MAVOPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iStarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intentionalElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

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
	private EClass softGoalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentsReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependerReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependeeReferenceEClass = null;

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
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IStar_MAVOPackageImpl() {
		super(eNS_URI, IStar_MAVOFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link IStar_MAVOPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IStar_MAVOPackage init() {
		if (isInited) return (IStar_MAVOPackage)EPackage.Registry.INSTANCE.getEPackage(IStar_MAVOPackage.eNS_URI);

		// Obtain or create and register package
		IStar_MAVOPackageImpl theIStar_MAVOPackage = (IStar_MAVOPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IStar_MAVOPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IStar_MAVOPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MavoPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theIStar_MAVOPackage.createPackageContents();

		// Initialize created meta-data
		theIStar_MAVOPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIStar_MAVOPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IStar_MAVOPackage.eNS_URI, theIStar_MAVOPackage);
		return theIStar_MAVOPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIStar() {
		return iStarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStar_Actors() {
		return (EReference)iStarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStar_Dependencies() {
		return (EReference)iStarEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIStar_Dependums() {
		return (EReference)iStarEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActor() {
		return actorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_IntentionalElements() {
		return (EReference)actorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActor_Contributions() {
		return (EReference)actorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependency() {
		return dependencyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependency_Depender() {
		return (EReference)dependencyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependency_Dependee() {
		return (EReference)dependencyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependency_Dependum() {
		return (EReference)dependencyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntentionalElement() {
		return intentionalElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentionalElement_Dependencies() {
		return (EReference)intentionalElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentionalElement_Composite() {
		return (EReference)intentionalElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentionalElement_ContributionsAsContributor() {
		return (EReference)intentionalElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentionalElement_FullySatisfied() {
		return (EAttribute)intentionalElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentionalElement_PartiallySatisfied() {
		return (EAttribute)intentionalElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentionalElement_Unknown() {
		return (EAttribute)intentionalElementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentionalElement_Conflict() {
		return (EAttribute)intentionalElementEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentionalElement_PartiallyDenied() {
		return (EAttribute)intentionalElementEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentionalElement_FullyDenied() {
		return (EAttribute)intentionalElementEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentionalElement_Nothing() {
		return (EAttribute)intentionalElementEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTask() {
		return taskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_Components() {
		return (EReference)taskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTask_End() {
		return (EReference)taskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
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
	public EReference getGoal_Means() {
		return (EReference)goalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSoftGoal() {
		return softGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSoftGoal_ContributionsAsContributee() {
		return (EReference)softGoalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContribution() {
		return contributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContribution_Type() {
		return (EAttribute)contributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContribution_Contributor() {
		return (EReference)contributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContribution_Contributee() {
		return (EReference)contributionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndReference() {
		return endReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndReference_Src() {
		return (EReference)endReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndReference_Tgt() {
		return (EReference)endReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentsReference() {
		return componentsReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentsReference_Src() {
		return (EReference)componentsReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentsReference_Tgt() {
		return (EReference)componentsReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyEndpoint() {
		return dependencyEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyEndpoint_DependenciesAsDepender() {
		return (EReference)dependencyEndpointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependencyEndpoint_DependenciesAsDependee() {
		return (EReference)dependencyEndpointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependencyEndpoint_Name() {
		return (EAttribute)dependencyEndpointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependerReference() {
		return dependerReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependerReference_Tgt() {
		return (EReference)dependerReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependerReference_Src() {
		return (EReference)dependerReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependeeReference() {
		return dependeeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependeeReference_Tgt() {
		return (EReference)dependeeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependeeReference_Src() {
		return (EReference)dependeeReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStar_MAVOFactory getIStar_MAVOFactory() {
		return (IStar_MAVOFactory)getEFactoryInstance();
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
		iStarEClass = createEClass(ISTAR);
		createEReference(iStarEClass, ISTAR__ACTORS);
		createEReference(iStarEClass, ISTAR__DEPENDENCIES);
		createEReference(iStarEClass, ISTAR__DEPENDUMS);

		actorEClass = createEClass(ACTOR);
		createEReference(actorEClass, ACTOR__INTENTIONAL_ELEMENTS);
		createEReference(actorEClass, ACTOR__CONTRIBUTIONS);

		dependencyEClass = createEClass(DEPENDENCY);
		createEReference(dependencyEClass, DEPENDENCY__DEPENDER);
		createEReference(dependencyEClass, DEPENDENCY__DEPENDEE);
		createEReference(dependencyEClass, DEPENDENCY__DEPENDUM);

		intentionalElementEClass = createEClass(INTENTIONAL_ELEMENT);
		createEReference(intentionalElementEClass, INTENTIONAL_ELEMENT__DEPENDENCIES);
		createEReference(intentionalElementEClass, INTENTIONAL_ELEMENT__COMPOSITE);
		createEReference(intentionalElementEClass, INTENTIONAL_ELEMENT__CONTRIBUTIONS_AS_CONTRIBUTOR);
		createEAttribute(intentionalElementEClass, INTENTIONAL_ELEMENT__FULLY_SATISFIED);
		createEAttribute(intentionalElementEClass, INTENTIONAL_ELEMENT__PARTIALLY_SATISFIED);
		createEAttribute(intentionalElementEClass, INTENTIONAL_ELEMENT__UNKNOWN);
		createEAttribute(intentionalElementEClass, INTENTIONAL_ELEMENT__CONFLICT);
		createEAttribute(intentionalElementEClass, INTENTIONAL_ELEMENT__PARTIALLY_DENIED);
		createEAttribute(intentionalElementEClass, INTENTIONAL_ELEMENT__FULLY_DENIED);
		createEAttribute(intentionalElementEClass, INTENTIONAL_ELEMENT__NOTHING);

		taskEClass = createEClass(TASK);
		createEReference(taskEClass, TASK__COMPONENTS);
		createEReference(taskEClass, TASK__END);

		resourceEClass = createEClass(RESOURCE);

		goalEClass = createEClass(GOAL);
		createEReference(goalEClass, GOAL__MEANS);

		softGoalEClass = createEClass(SOFT_GOAL);
		createEReference(softGoalEClass, SOFT_GOAL__CONTRIBUTIONS_AS_CONTRIBUTEE);

		contributionEClass = createEClass(CONTRIBUTION);
		createEAttribute(contributionEClass, CONTRIBUTION__TYPE);
		createEReference(contributionEClass, CONTRIBUTION__CONTRIBUTOR);
		createEReference(contributionEClass, CONTRIBUTION__CONTRIBUTEE);

		endReferenceEClass = createEClass(END_REFERENCE);
		createEReference(endReferenceEClass, END_REFERENCE__SRC);
		createEReference(endReferenceEClass, END_REFERENCE__TGT);

		componentsReferenceEClass = createEClass(COMPONENTS_REFERENCE);
		createEReference(componentsReferenceEClass, COMPONENTS_REFERENCE__SRC);
		createEReference(componentsReferenceEClass, COMPONENTS_REFERENCE__TGT);

		dependencyEndpointEClass = createEClass(DEPENDENCY_ENDPOINT);
		createEReference(dependencyEndpointEClass, DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER);
		createEReference(dependencyEndpointEClass, DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE);
		createEAttribute(dependencyEndpointEClass, DEPENDENCY_ENDPOINT__NAME);

		dependerReferenceEClass = createEClass(DEPENDER_REFERENCE);
		createEReference(dependerReferenceEClass, DEPENDER_REFERENCE__TGT);
		createEReference(dependerReferenceEClass, DEPENDER_REFERENCE__SRC);

		dependeeReferenceEClass = createEClass(DEPENDEE_REFERENCE);
		createEReference(dependeeReferenceEClass, DEPENDEE_REFERENCE__TGT);
		createEReference(dependeeReferenceEClass, DEPENDEE_REFERENCE__SRC);
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

		// Obtain other dependent packages
		MavoPackage theMavoPackage = (MavoPackage)EPackage.Registry.INSTANCE.getEPackage(MavoPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		iStarEClass.getESuperTypes().add(theMavoPackage.getMAVOModel());
		actorEClass.getESuperTypes().add(this.getDependencyEndpoint());
		dependencyEClass.getESuperTypes().add(theMavoPackage.getMAVOElement());
		intentionalElementEClass.getESuperTypes().add(this.getDependencyEndpoint());
		taskEClass.getESuperTypes().add(this.getIntentionalElement());
		resourceEClass.getESuperTypes().add(this.getIntentionalElement());
		goalEClass.getESuperTypes().add(this.getIntentionalElement());
		softGoalEClass.getESuperTypes().add(this.getGoal());
		contributionEClass.getESuperTypes().add(theMavoPackage.getMAVOElement());
		endReferenceEClass.getESuperTypes().add(theMavoPackage.getMAVOReference());
		componentsReferenceEClass.getESuperTypes().add(theMavoPackage.getMAVOReference());
		dependencyEndpointEClass.getESuperTypes().add(theMavoPackage.getMAVOElement());
		dependerReferenceEClass.getESuperTypes().add(theMavoPackage.getMAVOReference());
		dependeeReferenceEClass.getESuperTypes().add(theMavoPackage.getMAVOReference());

		// Initialize classes, features, and operations; add parameters
		initEClass(iStarEClass, IStar.class, "IStar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIStar_Actors(), this.getActor(), null, "actors", null, 0, -1, IStar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIStar_Dependencies(), this.getDependency(), null, "dependencies", null, 0, -1, IStar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIStar_Dependums(), this.getIntentionalElement(), null, "dependums", null, 0, -1, IStar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorEClass, Actor.class, "Actor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActor_IntentionalElements(), this.getIntentionalElement(), null, "intentionalElements", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActor_Contributions(), this.getContribution(), null, "contributions", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyEClass, Dependency.class, "Dependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependency_Depender(), this.getDependerReference(), this.getDependerReference_Src(), "depender", null, 1, -1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependency_Dependee(), this.getDependeeReference(), this.getDependeeReference_Src(), "dependee", null, 1, -1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependency_Dependum(), this.getIntentionalElement(), this.getIntentionalElement_Dependencies(), "dependum", null, 1, 1, Dependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intentionalElementEClass, IntentionalElement.class, "IntentionalElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntentionalElement_Dependencies(), this.getDependency(), this.getDependency_Dependum(), "dependencies", null, 0, -1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentionalElement_Composite(), this.getComponentsReference(), this.getComponentsReference_Tgt(), "composite", null, 0, -1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentionalElement_ContributionsAsContributor(), this.getContribution(), this.getContribution_Contributor(), "contributionsAsContributor", null, 0, -1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentionalElement_FullySatisfied(), ecorePackage.getEBoolean(), "fullySatisfied", null, 0, 1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentionalElement_PartiallySatisfied(), ecorePackage.getEBoolean(), "partiallySatisfied", null, 0, 1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentionalElement_Unknown(), ecorePackage.getEBoolean(), "unknown", null, 0, 1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentionalElement_Conflict(), ecorePackage.getEBoolean(), "conflict", null, 0, 1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentionalElement_PartiallyDenied(), ecorePackage.getEBoolean(), "partiallyDenied", null, 0, 1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentionalElement_FullyDenied(), ecorePackage.getEBoolean(), "fullyDenied", null, 0, 1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntentionalElement_Nothing(), ecorePackage.getEBoolean(), "nothing", null, 0, 1, IntentionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTask_Components(), this.getComponentsReference(), this.getComponentsReference_Src(), "components", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTask_End(), this.getEndReference(), this.getEndReference_Src(), "end", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGoal_Means(), this.getEndReference(), this.getEndReference_Tgt(), "means", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(softGoalEClass, SoftGoal.class, "SoftGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSoftGoal_ContributionsAsContributee(), this.getContribution(), this.getContribution_Contributee(), "contributionsAsContributee", null, 0, -1, SoftGoal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contributionEClass, Contribution.class, "Contribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContribution_Type(), ecorePackage.getEString(), "type", null, 1, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_Contributor(), this.getIntentionalElement(), this.getIntentionalElement_ContributionsAsContributor(), "contributor", null, 1, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_Contributee(), this.getSoftGoal(), this.getSoftGoal_ContributionsAsContributee(), "contributee", null, 1, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endReferenceEClass, EndReference.class, "EndReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndReference_Src(), this.getTask(), this.getTask_End(), "src", null, 1, 1, EndReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndReference_Tgt(), this.getGoal(), this.getGoal_Means(), "tgt", null, 1, 1, EndReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentsReferenceEClass, ComponentsReference.class, "ComponentsReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentsReference_Src(), this.getTask(), this.getTask_Components(), "src", null, 1, 1, ComponentsReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentsReference_Tgt(), this.getIntentionalElement(), this.getIntentionalElement_Composite(), "tgt", null, 1, 1, ComponentsReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyEndpointEClass, DependencyEndpoint.class, "DependencyEndpoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependencyEndpoint_DependenciesAsDepender(), this.getDependerReference(), this.getDependerReference_Tgt(), "dependenciesAsDepender", null, 0, -1, DependencyEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyEndpoint_DependenciesAsDependee(), this.getDependeeReference(), this.getDependeeReference_Tgt(), "dependenciesAsDependee", null, 0, -1, DependencyEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependencyEndpoint_Name(), ecorePackage.getEString(), "name", null, 1, 1, DependencyEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependerReferenceEClass, DependerReference.class, "DependerReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependerReference_Tgt(), this.getDependencyEndpoint(), this.getDependencyEndpoint_DependenciesAsDepender(), "tgt", null, 1, 1, DependerReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependerReference_Src(), this.getDependency(), this.getDependency_Depender(), "src", null, 1, 1, DependerReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependeeReferenceEClass, DependeeReference.class, "DependeeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependeeReference_Tgt(), this.getDependencyEndpoint(), this.getDependencyEndpoint_DependenciesAsDependee(), "tgt", null, 1, 1, DependeeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependeeReference_Src(), this.getDependency(), this.getDependency_Dependee(), "src", null, 1, 1, DependeeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //IStar_MAVOPackageImpl
