/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar.impl;

import edu.toronto.cs.se.modelepedia.istar.Actor;
import edu.toronto.cs.se.modelepedia.istar.Contribution;
import edu.toronto.cs.se.modelepedia.istar.ContributionType;
import edu.toronto.cs.se.modelepedia.istar.Decomposition;
import edu.toronto.cs.se.modelepedia.istar.DependeeLink;
import edu.toronto.cs.se.modelepedia.istar.DependencyEndpoint;
import edu.toronto.cs.se.modelepedia.istar.DependerLink;
import edu.toronto.cs.se.modelepedia.istar.Goal;
import edu.toronto.cs.se.modelepedia.istar.IStar;
import edu.toronto.cs.se.modelepedia.istar.IStarFactory;
import edu.toronto.cs.se.modelepedia.istar.IStarPackage;
import edu.toronto.cs.se.modelepedia.istar.Intention;
import edu.toronto.cs.se.modelepedia.istar.IntentionLink;
import edu.toronto.cs.se.modelepedia.istar.MeansEnd;
import edu.toronto.cs.se.modelepedia.istar.Resource;
import edu.toronto.cs.se.modelepedia.istar.SoftGoal;
import edu.toronto.cs.se.modelepedia.istar.Task;

import edu.toronto.cs.se.modelepedia.istar.util.IStarValidator;

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
public class IStarPackageImpl extends EPackageImpl implements IStarPackage {
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
	private EClass intentionEClass = null;

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
	private EClass dependencyEndpointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intentionLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass meansEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass decompositionEClass = null;

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
	private EClass dependerLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependeeLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum contributionTypeEEnum = null;

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
	 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IStarPackageImpl() {
		super(eNS_URI, IStarFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link IStarPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IStarPackage init() {
		if (isInited) return (IStarPackage)EPackage.Registry.INSTANCE.getEPackage(IStarPackage.eNS_URI);

		// Obtain or create and register package
		IStarPackageImpl theIStarPackage = (IStarPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IStarPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IStarPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theIStarPackage.createPackageContents();

		// Initialize created meta-data
		theIStarPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theIStarPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return IStarValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theIStarPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IStarPackage.eNS_URI, theIStarPackage);
		return theIStarPackage;
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
	public EReference getIStar_Dependums() {
		return (EReference)iStarEClass.getEStructuralFeatures().get(1);
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
	public EReference getActor_Intentions() {
		return (EReference)actorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntention() {
		return intentionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntention_FullySatisfied() {
		return (EAttribute)intentionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntention_PartiallySatisfied() {
		return (EAttribute)intentionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntention_Unknown() {
		return (EAttribute)intentionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntention_Conflict() {
		return (EAttribute)intentionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntention_PartiallyDenied() {
		return (EAttribute)intentionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntention_FullyDenied() {
		return (EAttribute)intentionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntention_NoLabel() {
		return (EAttribute)intentionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntention_LinksAsSrc() {
		return (EReference)intentionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntention_LinksAsTgt() {
		return (EReference)intentionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntention_DependerLinks() {
		return (EReference)intentionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntention_DependeeLinks() {
		return (EReference)intentionEClass.getEStructuralFeatures().get(10);
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
	public EClass getSoftGoal() {
		return softGoalEClass;
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
	public EClass getIntentionLink() {
		return intentionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntentionLink_Name() {
		return (EAttribute)intentionLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentionLink_Src() {
		return (EReference)intentionLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntentionLink_Tgt() {
		return (EReference)intentionLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeansEnd() {
		return meansEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDecomposition() {
		return decompositionEClass;
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
	public EClass getDependerLink() {
		return dependerLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependerLink_Name() {
		return (EAttribute)dependerLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependerLink_Depender() {
		return (EReference)dependerLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependerLink_Dependum() {
		return (EReference)dependerLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependeeLink() {
		return dependeeLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependeeLink_Name() {
		return (EAttribute)dependeeLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependeeLink_Dependum() {
		return (EReference)dependeeLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDependeeLink_Dependee() {
		return (EReference)dependeeLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getContributionType() {
		return contributionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IStarFactory getIStarFactory() {
		return (IStarFactory)getEFactoryInstance();
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
		createEReference(iStarEClass, ISTAR__DEPENDUMS);

		actorEClass = createEClass(ACTOR);
		createEReference(actorEClass, ACTOR__INTENTIONS);

		intentionEClass = createEClass(INTENTION);
		createEAttribute(intentionEClass, INTENTION__FULLY_SATISFIED);
		createEAttribute(intentionEClass, INTENTION__PARTIALLY_SATISFIED);
		createEAttribute(intentionEClass, INTENTION__UNKNOWN);
		createEAttribute(intentionEClass, INTENTION__CONFLICT);
		createEAttribute(intentionEClass, INTENTION__PARTIALLY_DENIED);
		createEAttribute(intentionEClass, INTENTION__FULLY_DENIED);
		createEAttribute(intentionEClass, INTENTION__NO_LABEL);
		createEReference(intentionEClass, INTENTION__LINKS_AS_SRC);
		createEReference(intentionEClass, INTENTION__LINKS_AS_TGT);
		createEReference(intentionEClass, INTENTION__DEPENDER_LINKS);
		createEReference(intentionEClass, INTENTION__DEPENDEE_LINKS);

		taskEClass = createEClass(TASK);

		resourceEClass = createEClass(RESOURCE);

		goalEClass = createEClass(GOAL);

		softGoalEClass = createEClass(SOFT_GOAL);

		dependencyEndpointEClass = createEClass(DEPENDENCY_ENDPOINT);
		createEReference(dependencyEndpointEClass, DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDER);
		createEReference(dependencyEndpointEClass, DEPENDENCY_ENDPOINT__DEPENDENCIES_AS_DEPENDEE);
		createEAttribute(dependencyEndpointEClass, DEPENDENCY_ENDPOINT__NAME);

		intentionLinkEClass = createEClass(INTENTION_LINK);
		createEAttribute(intentionLinkEClass, INTENTION_LINK__NAME);
		createEReference(intentionLinkEClass, INTENTION_LINK__SRC);
		createEReference(intentionLinkEClass, INTENTION_LINK__TGT);

		meansEndEClass = createEClass(MEANS_END);

		decompositionEClass = createEClass(DECOMPOSITION);

		contributionEClass = createEClass(CONTRIBUTION);
		createEAttribute(contributionEClass, CONTRIBUTION__TYPE);

		dependerLinkEClass = createEClass(DEPENDER_LINK);
		createEAttribute(dependerLinkEClass, DEPENDER_LINK__NAME);
		createEReference(dependerLinkEClass, DEPENDER_LINK__DEPENDER);
		createEReference(dependerLinkEClass, DEPENDER_LINK__DEPENDUM);

		dependeeLinkEClass = createEClass(DEPENDEE_LINK);
		createEAttribute(dependeeLinkEClass, DEPENDEE_LINK__NAME);
		createEReference(dependeeLinkEClass, DEPENDEE_LINK__DEPENDUM);
		createEReference(dependeeLinkEClass, DEPENDEE_LINK__DEPENDEE);

		// Create enums
		contributionTypeEEnum = createEEnum(CONTRIBUTION_TYPE);
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
		actorEClass.getESuperTypes().add(this.getDependencyEndpoint());
		intentionEClass.getESuperTypes().add(this.getDependencyEndpoint());
		taskEClass.getESuperTypes().add(this.getIntention());
		resourceEClass.getESuperTypes().add(this.getIntention());
		goalEClass.getESuperTypes().add(this.getIntention());
		softGoalEClass.getESuperTypes().add(this.getGoal());
		meansEndEClass.getESuperTypes().add(this.getIntentionLink());
		decompositionEClass.getESuperTypes().add(this.getIntentionLink());
		contributionEClass.getESuperTypes().add(this.getIntentionLink());

		// Initialize classes, features, and operations; add parameters
		initEClass(iStarEClass, IStar.class, "IStar", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIStar_Actors(), this.getActor(), null, "actors", null, 0, -1, IStar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIStar_Dependums(), this.getIntention(), null, "dependums", null, 0, -1, IStar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actorEClass, Actor.class, "Actor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActor_Intentions(), this.getIntention(), null, "intentions", null, 0, -1, Actor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intentionEClass, Intention.class, "Intention", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntention_FullySatisfied(), ecorePackage.getEBoolean(), "fullySatisfied", null, 0, 1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntention_PartiallySatisfied(), ecorePackage.getEBoolean(), "partiallySatisfied", null, 0, 1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntention_Unknown(), ecorePackage.getEBoolean(), "unknown", null, 0, 1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntention_Conflict(), ecorePackage.getEBoolean(), "conflict", null, 0, 1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntention_PartiallyDenied(), ecorePackage.getEBoolean(), "partiallyDenied", null, 0, 1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntention_FullyDenied(), ecorePackage.getEBoolean(), "fullyDenied", null, 0, 1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntention_NoLabel(), ecorePackage.getEBoolean(), "noLabel", null, 0, 1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntention_LinksAsSrc(), this.getIntentionLink(), this.getIntentionLink_Src(), "linksAsSrc", null, 0, -1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntention_LinksAsTgt(), this.getIntentionLink(), this.getIntentionLink_Tgt(), "linksAsTgt", null, 0, -1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntention_DependerLinks(), this.getDependerLink(), this.getDependerLink_Dependum(), "dependerLinks", null, 0, -1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntention_DependeeLinks(), this.getDependeeLink(), this.getDependeeLink_Dependum(), "dependeeLinks", null, 0, -1, Intention.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(softGoalEClass, SoftGoal.class, "SoftGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dependencyEndpointEClass, DependencyEndpoint.class, "DependencyEndpoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDependencyEndpoint_DependenciesAsDepender(), this.getDependerLink(), this.getDependerLink_Depender(), "dependenciesAsDepender", null, 0, -1, DependencyEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependencyEndpoint_DependenciesAsDependee(), this.getDependeeLink(), this.getDependeeLink_Dependee(), "dependenciesAsDependee", null, 0, -1, DependencyEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDependencyEndpoint_Name(), ecorePackage.getEString(), "name", null, 1, 1, DependencyEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intentionLinkEClass, IntentionLink.class, "IntentionLink", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntentionLink_Name(), ecorePackage.getEString(), "name", null, 1, 1, IntentionLink.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getIntentionLink_Src(), this.getIntention(), this.getIntention_LinksAsSrc(), "src", null, 1, 1, IntentionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntentionLink_Tgt(), this.getIntention(), this.getIntention_LinksAsTgt(), "tgt", null, 1, 1, IntentionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(meansEndEClass, MeansEnd.class, "MeansEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(decompositionEClass, Decomposition.class, "Decomposition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(contributionEClass, Contribution.class, "Contribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContribution_Type(), this.getContributionType(), "type", null, 1, 1, Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependerLinkEClass, DependerLink.class, "DependerLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDependerLink_Name(), ecorePackage.getEString(), "name", null, 1, 1, DependerLink.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDependerLink_Depender(), this.getDependencyEndpoint(), this.getDependencyEndpoint_DependenciesAsDepender(), "depender", null, 1, 1, DependerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependerLink_Dependum(), this.getIntention(), this.getIntention_DependerLinks(), "dependum", null, 1, 1, DependerLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependeeLinkEClass, DependeeLink.class, "DependeeLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDependeeLink_Name(), ecorePackage.getEString(), "name", null, 1, 1, DependeeLink.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getDependeeLink_Dependum(), this.getIntention(), this.getIntention_DependeeLinks(), "dependum", null, 1, 1, DependeeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDependeeLink_Dependee(), this.getDependencyEndpoint(), this.getDependencyEndpoint_DependenciesAsDependee(), "dependee", null, 1, 1, DependeeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(contributionTypeEEnum, ContributionType.class, "ContributionType");
		addEEnumLiteral(contributionTypeEEnum, ContributionType.MAKE);
		addEEnumLiteral(contributionTypeEEnum, ContributionType.HELP);
		addEEnumLiteral(contributionTypeEEnum, ContributionType.SOMEPLUS);
		addEEnumLiteral(contributionTypeEEnum, ContributionType.BREAK);
		addEEnumLiteral(contributionTypeEEnum, ContributionType.HURT);
		addEEnumLiteral(contributionTypeEEnum, ContributionType.SOMEMINUS);
		addEEnumLiteral(contributionTypeEEnum, ContributionType.UNKNOWN);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
		// gmf.diagram
		createGmfAnnotations();
		// gmf.node
		createGmf_1Annotations();
		// gmf.compartment
		createGmf_2Annotations();
		// gmf.link
		createGmf_3Annotations();
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
		  (iStarEClass, 
		   source, 
		   new String[] {
			 "constraints", "onlyDependums"
		   });				
		addAnnotation
		  (actorEClass, 
		   source, 
		   new String[] {
			 "constraints", "noDependums"
		   });												
		addAnnotation
		  (meansEndEClass, 
		   source, 
		   new String[] {
			 "constraints", "srcTask tgtGoal"
		   });				
		addAnnotation
		  (decompositionEClass, 
		   source, 
		   new String[] {
			 "constraints", "tgtTask"
		   });				
		addAnnotation
		  (contributionEClass, 
		   source, 
		   new String[] {
			 "constraints", "tgtSoftgoal"
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
		  (iStarEClass, 
		   source, 
		   new String[] {
			 "onlyDependums", "dependums->forAll(linksAsSrc->isEmpty() and linksAsTgt->isEmpty())"
		   });				
		addAnnotation
		  (actorEClass, 
		   source, 
		   new String[] {
			 "noDependums", "intentions->forAll(dependerLinks->isEmpty() and dependeeLinks->isEmpty())"
		   });										
		addAnnotation
		  (getIntentionLink_Name(), 
		   source, 
		   new String[] {
			 "derivation", "if src.oclIsUndefined() or tgt.oclIsUndefined() then \'\' else src.name.concat(\' 2 \').concat(tgt.name) endif"
		   });			
		addAnnotation
		  (meansEndEClass, 
		   source, 
		   new String[] {
			 "srcTask", "src.oclIsTypeOf(Task)",
			 "tgtGoal", "tgt.oclIsTypeOf(Goal)"
		   });				
		addAnnotation
		  (decompositionEClass, 
		   source, 
		   new String[] {
			 "tgtTask", "tgt.oclIsTypeOf(Task)"
		   });				
		addAnnotation
		  (contributionEClass, 
		   source, 
		   new String[] {
			 "tgtSoftgoal", "tgt.oclIsTypeOf(SoftGoal)"
		   });				
		addAnnotation
		  (getDependerLink_Name(), 
		   source, 
		   new String[] {
			 "derivation", "if depender.oclIsUndefined() or dependum.oclIsUndefined() then \'\' else depender.name.concat(\' 2 \').concat(dependum.name) endif"
		   });			
		addAnnotation
		  (getDependeeLink_Name(), 
		   source, 
		   new String[] {
			 "derivation", "if dependum.oclIsUndefined() or dependee.oclIsUndefined() then \'\' else dependum.name.concat(\' 2 \').concat(dependee.name) endif"
		   });
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
		  (iStarEClass, 
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
	protected void createGmf_1Annotations() {
		String source = "gmf.node";								
		addAnnotation
		  (actorEClass, 
		   source, 
		   new String[] {
			 "figure", "ellipse",
			 "border.style", "dash",
			 "border.width", "2"
		   });			
		addAnnotation
		  (taskEClass, 
		   source, 
		   new String[] {
			 "figure", "edu.toronto.cs.se.modelepedia.istar.diagram.figures.TaskFigure"
		   });		
		addAnnotation
		  (resourceEClass, 
		   source, 
		   new String[] {
			 "figure", "rectangle",
			 "border.width", "5"
		   });		
		addAnnotation
		  (goalEClass, 
		   source, 
		   new String[] {
			 "figure", "edu.toronto.cs.se.modelepedia.istar.diagram.figures.GoalFigure"
		   });		
		addAnnotation
		  (softGoalEClass, 
		   source, 
		   new String[] {
			 "figure", "edu.toronto.cs.se.modelepedia.istar.diagram.figures.SoftGoalFigure"
		   });		
		addAnnotation
		  (dependencyEndpointEClass, 
		   source, 
		   new String[] {
			 "label", "name",
			 "label.icon", "false"
		   });															
	}

	/**
	 * Initializes the annotations for <b>gmf.compartment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.compartment";									
		addAnnotation
		  (getActor_Intentions(), 
		   source, 
		   new String[] {
			 "layout", "free"
		   });																				
	}

	/**
	 * Initializes the annotations for <b>gmf.link</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_3Annotations() {
		String source = "gmf.link";															
		addAnnotation
		  (intentionLinkEClass, 
		   source, 
		   new String[] {
			 "source", "src",
			 "target", "tgt"
		   });					
		addAnnotation
		  (meansEndEClass, 
		   source, 
		   new String[] {
			 "target.decoration", "closedarrow"
		   });				
		addAnnotation
		  (decompositionEClass, 
		   source, 
		   new String[] {
			 "target.decoration", "filledrhomb"
		   });				
		addAnnotation
		  (contributionEClass, 
		   source, 
		   new String[] {
			 "target.decoration", "arrow"
		   });		
		addAnnotation
		  (dependerLinkEClass, 
		   source, 
		   new String[] {
			 "target.decoration", "arrow",
			 "source", "depender",
			 "target", "dependum"
		   });			
		addAnnotation
		  (dependeeLinkEClass, 
		   source, 
		   new String[] {
			 "target.decoration", "arrow",
			 "source", "dependum",
			 "target", "dependee"
		   });	
	}

} //IStarPackageImpl
