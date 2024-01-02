/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOFactory;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.NamedElement;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.NestedInReference;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Operation;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.SuperclassReference;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassDiagram_MAVOPackageImpl extends EPackageImpl implements ClassDiagram_MAVOPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass classDiagramEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass classEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass attributeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass namedElementEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass operationEClass = null;

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
	private EClass typedElementEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass associationEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass nestedInReferenceEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass superclassReferenceEClass = null;

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
   * @see edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private ClassDiagram_MAVOPackageImpl() {
    super(ClassDiagram_MAVOPackage.eNS_URI, ClassDiagram_MAVOFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ClassDiagram_MAVOPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static ClassDiagram_MAVOPackage init() {
    if (ClassDiagram_MAVOPackageImpl.isInited) return (ClassDiagram_MAVOPackage)EPackage.Registry.INSTANCE.getEPackage(ClassDiagram_MAVOPackage.eNS_URI);

    // Obtain or create and register package
    var registeredClassDiagram_MAVOPackage = EPackage.Registry.INSTANCE.get(ClassDiagram_MAVOPackage.eNS_URI);
    var theClassDiagram_MAVOPackage = registeredClassDiagram_MAVOPackage instanceof ClassDiagram_MAVOPackageImpl ? (ClassDiagram_MAVOPackageImpl)registeredClassDiagram_MAVOPackage : new ClassDiagram_MAVOPackageImpl();

    ClassDiagram_MAVOPackageImpl.isInited = true;

    // Initialize simple dependencies
    MAVOPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theClassDiagram_MAVOPackage.createPackageContents();

    // Initialize created meta-data
    theClassDiagram_MAVOPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theClassDiagram_MAVOPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ClassDiagram_MAVOPackage.eNS_URI, theClassDiagram_MAVOPackage);
    return theClassDiagram_MAVOPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getClassDiagram() {
    return this.classDiagramEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClassDiagram_Classes() {
    return (EReference)this.classDiagramEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClassDiagram_Dependencies() {
    return (EReference)this.classDiagramEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClassDiagram_Associations() {
    return (EReference)this.classDiagramEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getClass_() {
    return this.classEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_OwnedAttributes() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_OwnedOperations() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_DependenciesAsDependee() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_DependenciesAsDepender() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_NestedIn() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(4);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_Nested() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(5);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_Superclass() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(6);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_Subclasses() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(7);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_AssociationsAsSource() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(8);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_AssociationsAsTarget() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(9);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getAttribute() {
    return this.attributeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getNamedElement() {
    return this.namedElementEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getNamedElement_Name() {
    return (EAttribute)this.namedElementEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getOperation() {
    return this.operationEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getDependency() {
    return this.dependencyEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getDependency_Name() {
    return (EAttribute)this.dependencyEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getDependency_Dependee() {
    return (EReference)this.dependencyEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getDependency_Depender() {
    return (EReference)this.dependencyEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getTypedElement() {
    return this.typedElementEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getTypedElement_Public() {
    return (EAttribute)this.typedElementEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getTypedElement_Type() {
    return (EReference)this.typedElementEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getAssociation() {
    return this.associationEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getAssociation_Source() {
    return (EReference)this.associationEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getAssociation_Target() {
    return (EReference)this.associationEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getNestedInReference() {
    return this.nestedInReferenceEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getNestedInReference_Source() {
    return (EReference)this.nestedInReferenceEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getNestedInReference_Target() {
    return (EReference)this.nestedInReferenceEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getSuperclassReference() {
    return this.superclassReferenceEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getSuperclassReference_Source() {
    return (EReference)this.superclassReferenceEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getSuperclassReference_Target() {
    return (EReference)this.superclassReferenceEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public ClassDiagram_MAVOFactory getClassDiagram_MAVOFactory() {
    return (ClassDiagram_MAVOFactory)getEFactoryInstance();
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
    if (this.isCreated) return;
    this.isCreated = true;

    // Create classes and their features
    this.classDiagramEClass = createEClass(ClassDiagram_MAVOPackage.CLASS_DIAGRAM);
    createEReference(this.classDiagramEClass, ClassDiagram_MAVOPackage.CLASS_DIAGRAM__CLASSES);
    createEReference(this.classDiagramEClass, ClassDiagram_MAVOPackage.CLASS_DIAGRAM__DEPENDENCIES);
    createEReference(this.classDiagramEClass, ClassDiagram_MAVOPackage.CLASS_DIAGRAM__ASSOCIATIONS);

    this.classEClass = createEClass(ClassDiagram_MAVOPackage.CLASS);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__OWNED_ATTRIBUTES);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__OWNED_OPERATIONS);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__NESTED_IN);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__NESTED);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__SUPERCLASS);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__SUBCLASSES);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE);
    createEReference(this.classEClass, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET);

    this.attributeEClass = createEClass(ClassDiagram_MAVOPackage.ATTRIBUTE);

    this.namedElementEClass = createEClass(ClassDiagram_MAVOPackage.NAMED_ELEMENT);
    createEAttribute(this.namedElementEClass, ClassDiagram_MAVOPackage.NAMED_ELEMENT__NAME);

    this.operationEClass = createEClass(ClassDiagram_MAVOPackage.OPERATION);

    this.dependencyEClass = createEClass(ClassDiagram_MAVOPackage.DEPENDENCY);
    createEAttribute(this.dependencyEClass, ClassDiagram_MAVOPackage.DEPENDENCY__NAME);
    createEReference(this.dependencyEClass, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE);
    createEReference(this.dependencyEClass, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER);

    this.typedElementEClass = createEClass(ClassDiagram_MAVOPackage.TYPED_ELEMENT);
    createEAttribute(this.typedElementEClass, ClassDiagram_MAVOPackage.TYPED_ELEMENT__PUBLIC);
    createEReference(this.typedElementEClass, ClassDiagram_MAVOPackage.TYPED_ELEMENT__TYPE);

    this.associationEClass = createEClass(ClassDiagram_MAVOPackage.ASSOCIATION);
    createEReference(this.associationEClass, ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE);
    createEReference(this.associationEClass, ClassDiagram_MAVOPackage.ASSOCIATION__TARGET);

    this.nestedInReferenceEClass = createEClass(ClassDiagram_MAVOPackage.NESTED_IN_REFERENCE);
    createEReference(this.nestedInReferenceEClass, ClassDiagram_MAVOPackage.NESTED_IN_REFERENCE__SOURCE);
    createEReference(this.nestedInReferenceEClass, ClassDiagram_MAVOPackage.NESTED_IN_REFERENCE__TARGET);

    this.superclassReferenceEClass = createEClass(ClassDiagram_MAVOPackage.SUPERCLASS_REFERENCE);
    createEReference(this.superclassReferenceEClass, ClassDiagram_MAVOPackage.SUPERCLASS_REFERENCE__SOURCE);
    createEReference(this.superclassReferenceEClass, ClassDiagram_MAVOPackage.SUPERCLASS_REFERENCE__TARGET);
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
    if (this.isInitialized) return;
    this.isInitialized = true;

    // Initialize package
    setName(ClassDiagram_MAVOPackage.eNAME);
    setNsPrefix(ClassDiagram_MAVOPackage.eNS_PREFIX);
    setNsURI(ClassDiagram_MAVOPackage.eNS_URI);

    // Obtain other dependent packages
    var theMAVOPackage = (MAVOPackage)EPackage.Registry.INSTANCE.getEPackage(MAVOPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.classDiagramEClass.getESuperTypes().add(theMAVOPackage.getMAVORoot());
    this.classEClass.getESuperTypes().add(this.getNamedElement());
    this.attributeEClass.getESuperTypes().add(this.getTypedElement());
    this.namedElementEClass.getESuperTypes().add(theMAVOPackage.getMAVOElement());
    this.operationEClass.getESuperTypes().add(this.getTypedElement());
    this.dependencyEClass.getESuperTypes().add(theMAVOPackage.getMAVOElement());
    this.typedElementEClass.getESuperTypes().add(this.getNamedElement());
    this.associationEClass.getESuperTypes().add(this.getNamedElement());
    this.nestedInReferenceEClass.getESuperTypes().add(theMAVOPackage.getMAVOReference());
    this.superclassReferenceEClass.getESuperTypes().add(theMAVOPackage.getMAVOReference());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.classDiagramEClass, ClassDiagram.class, "ClassDiagram", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassDiagram_Classes(), this.getClass_(), null, "classes", null, 0, -1, ClassDiagram.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClassDiagram_Dependencies(), this.getDependency(), null, "dependencies", null, 0, -1, ClassDiagram.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClassDiagram_Associations(), this.getAssociation(), null, "associations", null, 0, -1, ClassDiagram.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.classEClass, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, "Class", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClass_OwnedAttributes(), this.getAttribute(), null, "ownedAttributes", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_OwnedOperations(), this.getOperation(), null, "ownedOperations", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_DependenciesAsDependee(), this.getDependency(), this.getDependency_Dependee(), "dependenciesAsDependee", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_DependenciesAsDepender(), this.getDependency(), this.getDependency_Depender(), "dependenciesAsDepender", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_NestedIn(), this.getNestedInReference(), this.getNestedInReference_Source(), "nestedIn", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_Nested(), this.getNestedInReference(), this.getNestedInReference_Target(), "nested", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_Superclass(), this.getSuperclassReference(), this.getSuperclassReference_Source(), "superclass", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_Subclasses(), this.getSuperclassReference(), this.getSuperclassReference_Target(), "subclasses", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_AssociationsAsSource(), this.getAssociation(), this.getAssociation_Source(), "associationsAsSource", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_AssociationsAsTarget(), this.getAssociation(), this.getAssociation_Target(), "associationsAsTarget", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.attributeEClass, Attribute.class, "Attribute", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.namedElementEClass, NamedElement.class, "NamedElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedElement_Name(), this.ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.operationEClass, Operation.class, "Operation", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.dependencyEClass, Dependency.class, "Dependency", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDependency_Name(), this.ecorePackage.getEString(), "name", null, 1, 1, Dependency.class, EPackageImpl.IS_TRANSIENT, EPackageImpl.IS_VOLATILE, !EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getDependency_Dependee(), this.getClass_(), this.getClass_DependenciesAsDependee(), "dependee", null, 1, 1, Dependency.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getDependency_Depender(), this.getClass_(), this.getClass_DependenciesAsDepender(), "depender", null, 1, 1, Dependency.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.typedElementEClass, TypedElement.class, "TypedElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypedElement_Public(), this.ecorePackage.getEBoolean(), "public", null, 1, 1, TypedElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getTypedElement_Type(), this.getClass_(), null, "type", null, 1, 1, TypedElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.associationEClass, Association.class, "Association", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssociation_Source(), this.getClass_(), this.getClass_AssociationsAsSource(), "source", null, 1, 1, Association.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getAssociation_Target(), this.getClass_(), this.getClass_AssociationsAsTarget(), "target", null, 1, 1, Association.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.nestedInReferenceEClass, NestedInReference.class, "NestedInReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNestedInReference_Source(), this.getClass_(), this.getClass_NestedIn(), "source", null, 1, 1, NestedInReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getNestedInReference_Target(), this.getClass_(), this.getClass_Nested(), "target", null, 1, 1, NestedInReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.superclassReferenceEClass, SuperclassReference.class, "SuperclassReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuperclassReference_Source(), this.getClass_(), this.getClass_Superclass(), "source", null, 1, 1, SuperclassReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getSuperclassReference_Target(), this.getClass_(), this.getClass_Subclasses(), "target", null, 1, 1, SuperclassReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    // Create resource
    createResource(ClassDiagram_MAVOPackage.eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
    // gmf.diagram
    createGmfAnnotations();
    // gmf.node
    createGmf_1Annotations();
    // gmf.compartment
    createGmf_2Annotations();
    // gmf.link
    createGmf_3Annotations();
    // http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
    createPivotAnnotations();
  }

	/**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void createEcoreAnnotations() {
    var source = "http://www.eclipse.org/emf/2002/Ecore";
    addAnnotation
      (this,
       source,
       new String[] {
         "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
         "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
       });
  }

	/**
   * Initializes the annotations for <b>gmf.diagram</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void createGmfAnnotations() {
    var source = "gmf.diagram";
    addAnnotation
      (this.classDiagramEClass,
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
    var source = "gmf.node";
    addAnnotation
      (this.classEClass,
       source,
       new String[] {
         "label", "name"
       });
    addAnnotation
      (this.attributeEClass,
       source,
       new String[] {
         "label", "name"
       });
    addAnnotation
      (this.operationEClass,
       source,
       new String[] {
         "label", "name"
       });
  }

	/**
   * Initializes the annotations for <b>gmf.compartment</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void createGmf_2Annotations() {
    var source = "gmf.compartment";
    addAnnotation
      (getClass_OwnedAttributes(),
       source,
       new String[] {
         "layout", "list"
       });
    addAnnotation
      (getClass_OwnedOperations(),
       source,
       new String[] {
         "layout", "list"
       });
  }

	/**
   * Initializes the annotations for <b>gmf.link</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void createGmf_3Annotations() {
    var source = "gmf.link";
    addAnnotation
      (this.dependencyEClass,
       source,
       new String[] {
         "source", "dependee",
         "target", "depender",
         "target.decoration", "arrow",
         "style", "dash"
       });
    addAnnotation
      (this.associationEClass,
       source,
       new String[] {
         "label", "name",
         "label.icon", "true",
         "source", "source",
         "target", "target",
         "target.decoration", "arrow"
       });
    addAnnotation
      (this.nestedInReferenceEClass,
       source,
       new String[] {
         "target.decoration", "square",
         "source", "source",
         "target", "target"
       });
    addAnnotation
      (this.superclassReferenceEClass,
       source,
       new String[] {
         "target.decoration", "closedarrow",
         "source", "source",
         "target", "target"
       });
  }

	/**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected void createPivotAnnotations() {
    var source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
    addAnnotation
      (getDependency_Name(),
       source,
       new String[] {
         "derivation", "if depender.oclIsUndefined() or dependee.oclIsUndefined() then \'\' else depender.name.concat(\' 2 \').concat(dependee.name) endif"
       });
  }

} //ClassDiagram_MAVOPackageImpl
