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
package edu.toronto.cs.se.modelepedia.randommodel.impl;

import edu.toronto.cs.se.mmtf.mavo.MavoPackage;
import edu.toronto.cs.se.modelepedia.randommodel.Edge;
import edu.toronto.cs.se.modelepedia.randommodel.NamedElement;
import edu.toronto.cs.se.modelepedia.randommodel.Node;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModel;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelFactory;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;

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
public class RandomModelPackageImpl extends EPackageImpl implements RandomModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

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
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RandomModelPackageImpl() {
		super(eNS_URI, RandomModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RandomModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RandomModelPackage init() {
		if (isInited) return (RandomModelPackage)EPackage.Registry.INSTANCE.getEPackage(RandomModelPackage.eNS_URI);

		// Obtain or create and register package
		RandomModelPackageImpl theRandomModelPackage = (RandomModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RandomModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RandomModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		MavoPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theRandomModelPackage.createPackageContents();

		// Initialize created meta-data
		theRandomModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRandomModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RandomModelPackage.eNS_URI, theRandomModelPackage);
		return theRandomModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomModel() {
		return randomModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRandomModel_Nodes() {
		return (EReference)randomModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRandomModel_Edges() {
		return (EReference)randomModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomModel_Name() {
		return (EAttribute)randomModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomModel_Type() {
		return (EAttribute)randomModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomModel_DefaultMinimumNumberOfInstances() {
		return (EAttribute)randomModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomModel_DefaultMaximumNumberOfInstances() {
		return (EAttribute)randomModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Src() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Tgt() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Type() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_MinimumNumberOfInstances() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_MaximumNumberOfInstances() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomModelFactory getRandomModelFactory() {
		return (RandomModelFactory)getEFactoryInstance();
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
		randomModelEClass = createEClass(RANDOM_MODEL);
		createEReference(randomModelEClass, RANDOM_MODEL__NODES);
		createEReference(randomModelEClass, RANDOM_MODEL__EDGES);
		createEAttribute(randomModelEClass, RANDOM_MODEL__NAME);
		createEAttribute(randomModelEClass, RANDOM_MODEL__TYPE);
		createEAttribute(randomModelEClass, RANDOM_MODEL__DEFAULT_MINIMUM_NUMBER_OF_INSTANCES);
		createEAttribute(randomModelEClass, RANDOM_MODEL__DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES);

		nodeEClass = createEClass(NODE);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__SRC);
		createEReference(edgeEClass, EDGE__TGT);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__TYPE);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES);
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
		randomModelEClass.getESuperTypes().add(theMavoPackage.getMAVOModel());
		nodeEClass.getESuperTypes().add(this.getNamedElement());
		edgeEClass.getESuperTypes().add(this.getNamedElement());
		namedElementEClass.getESuperTypes().add(theMavoPackage.getMAVOElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(randomModelEClass, RandomModel.class, "RandomModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRandomModel_Nodes(), this.getNode(), null, "nodes", null, 0, -1, RandomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRandomModel_Edges(), this.getEdge(), null, "edges", null, 0, -1, RandomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomModel_Name(), ecorePackage.getEString(), "name", null, 1, 1, RandomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomModel_Type(), ecorePackage.getEString(), "type", null, 1, 1, RandomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomModel_DefaultMinimumNumberOfInstances(), ecorePackage.getEInt(), "defaultMinimumNumberOfInstances", "0", 1, 1, RandomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomModel_DefaultMaximumNumberOfInstances(), ecorePackage.getEInt(), "defaultMaximumNumberOfInstances", "0", 1, 1, RandomModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_Src(), this.getNode(), null, "src", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_Tgt(), this.getNode(), null, "tgt", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", "", 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Type(), ecorePackage.getEString(), "type", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_MinimumNumberOfInstances(), ecorePackage.getEInt(), "minimumNumberOfInstances", "0", 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_MaximumNumberOfInstances(), ecorePackage.getEInt(), "maximumNumberOfInstances", "0", 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RandomModelPackageImpl
