/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramFactory;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.classdiagram.Composition;
import edu.toronto.cs.se.modelepedia.classdiagram.DataType;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.NamedElement;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;
import edu.toronto.cs.se.modelepedia.classdiagram.Typeable;
import edu.toronto.cs.se.modelepedia.classdiagram.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassDiagramPackageImpl extends EPackageImpl implements ClassDiagramPackage {
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
	private EClass typeableEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass dataTypeEClass = null;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass compositionEClass = null;

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
   * @see edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private ClassDiagramPackageImpl() {
    super(ClassDiagramPackage.eNS_URI, ClassDiagramFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ClassDiagramPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static ClassDiagramPackage init() {
    if (ClassDiagramPackageImpl.isInited) return (ClassDiagramPackage)EPackage.Registry.INSTANCE.getEPackage(ClassDiagramPackage.eNS_URI);

    // Obtain or create and register package
    var registeredClassDiagramPackage = EPackage.Registry.INSTANCE.get(ClassDiagramPackage.eNS_URI);
    var theClassDiagramPackage = registeredClassDiagramPackage instanceof ClassDiagramPackageImpl ? (ClassDiagramPackageImpl)registeredClassDiagramPackage : new ClassDiagramPackageImpl();

    ClassDiagramPackageImpl.isInited = true;

    // Create package meta-data objects
    theClassDiagramPackage.createPackageContents();

    // Initialize created meta-data
    theClassDiagramPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theClassDiagramPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ClassDiagramPackage.eNS_URI, theClassDiagramPackage);
    return theClassDiagramPackage;
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
  public EReference getClassDiagram_Datatypes() {
    return (EReference)this.classDiagramEClass.getEStructuralFeatures().get(3);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClassDiagram_Compositions() {
    return (EReference)this.classDiagramEClass.getEStructuralFeatures().get(4);
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
  public EReference getClass_CompositionsAsConstituent() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(10);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getClass_CompositionsAsComposite() {
    return (EReference)this.classEClass.getEStructuralFeatures().get(11);
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
  public EReference getOperation_ParameterTypes() {
    return (EReference)this.operationEClass.getEStructuralFeatures().get(0);
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
  public EReference getDependency_Dependee() {
    return (EReference)this.dependencyEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getDependency_Depender() {
    return (EReference)this.dependencyEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getDependency_Name() {
    return (EAttribute)this.dependencyEClass.getEStructuralFeatures().get(2);
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
  public EReference getTypedElement_Type() {
    return (EReference)this.typedElementEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getTypedElement_Public() {
    return (EAttribute)this.typedElementEClass.getEStructuralFeatures().get(1);
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
  public EAttribute getAssociation_Multiplicity() {
    return (EAttribute)this.associationEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getTypeable() {
    return this.typeableEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getDataType() {
    return this.dataTypeEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getComposition() {
    return this.compositionEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getComposition_Constituent() {
    return (EReference)this.compositionEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EReference getComposition_Composite() {
    return (EReference)this.compositionEClass.getEStructuralFeatures().get(1);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getComposition_Multiplicity() {
    return (EAttribute)this.compositionEClass.getEStructuralFeatures().get(2);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public ClassDiagramFactory getClassDiagramFactory() {
    return (ClassDiagramFactory)getEFactoryInstance();
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
    this.classDiagramEClass = createEClass(ClassDiagramPackage.CLASS_DIAGRAM);
    createEReference(this.classDiagramEClass, ClassDiagramPackage.CLASS_DIAGRAM__CLASSES);
    createEReference(this.classDiagramEClass, ClassDiagramPackage.CLASS_DIAGRAM__DEPENDENCIES);
    createEReference(this.classDiagramEClass, ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS);
    createEReference(this.classDiagramEClass, ClassDiagramPackage.CLASS_DIAGRAM__DATATYPES);
    createEReference(this.classDiagramEClass, ClassDiagramPackage.CLASS_DIAGRAM__COMPOSITIONS);

    this.classEClass = createEClass(ClassDiagramPackage.CLASS);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__OWNED_ATTRIBUTES);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__OWNED_OPERATIONS);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__NESTED_IN);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__NESTED);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__SUPERCLASS);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__SUBCLASSES);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_SOURCE);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__ASSOCIATIONS_AS_TARGET);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT);
    createEReference(this.classEClass, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE);

    this.attributeEClass = createEClass(ClassDiagramPackage.ATTRIBUTE);

    this.namedElementEClass = createEClass(ClassDiagramPackage.NAMED_ELEMENT);
    createEAttribute(this.namedElementEClass, ClassDiagramPackage.NAMED_ELEMENT__NAME);

    this.operationEClass = createEClass(ClassDiagramPackage.OPERATION);
    createEReference(this.operationEClass, ClassDiagramPackage.OPERATION__PARAMETER_TYPES);

    this.dependencyEClass = createEClass(ClassDiagramPackage.DEPENDENCY);
    createEReference(this.dependencyEClass, ClassDiagramPackage.DEPENDENCY__DEPENDEE);
    createEReference(this.dependencyEClass, ClassDiagramPackage.DEPENDENCY__DEPENDER);
    createEAttribute(this.dependencyEClass, ClassDiagramPackage.DEPENDENCY__NAME);

    this.typedElementEClass = createEClass(ClassDiagramPackage.TYPED_ELEMENT);
    createEReference(this.typedElementEClass, ClassDiagramPackage.TYPED_ELEMENT__TYPE);
    createEAttribute(this.typedElementEClass, ClassDiagramPackage.TYPED_ELEMENT__PUBLIC);

    this.associationEClass = createEClass(ClassDiagramPackage.ASSOCIATION);
    createEReference(this.associationEClass, ClassDiagramPackage.ASSOCIATION__SOURCE);
    createEReference(this.associationEClass, ClassDiagramPackage.ASSOCIATION__TARGET);
    createEAttribute(this.associationEClass, ClassDiagramPackage.ASSOCIATION__MULTIPLICITY);

    this.typeableEClass = createEClass(ClassDiagramPackage.TYPEABLE);

    this.dataTypeEClass = createEClass(ClassDiagramPackage.DATA_TYPE);

    this.compositionEClass = createEClass(ClassDiagramPackage.COMPOSITION);
    createEReference(this.compositionEClass, ClassDiagramPackage.COMPOSITION__CONSTITUENT);
    createEReference(this.compositionEClass, ClassDiagramPackage.COMPOSITION__COMPOSITE);
    createEAttribute(this.compositionEClass, ClassDiagramPackage.COMPOSITION__MULTIPLICITY);
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
    setName(ClassDiagramPackage.eNAME);
    setNsPrefix(ClassDiagramPackage.eNS_PREFIX);
    setNsURI(ClassDiagramPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.classEClass.getESuperTypes().add(this.getTypeable());
    this.attributeEClass.getESuperTypes().add(this.getTypedElement());
    this.operationEClass.getESuperTypes().add(this.getTypedElement());
    this.typedElementEClass.getESuperTypes().add(this.getNamedElement());
    this.associationEClass.getESuperTypes().add(this.getNamedElement());
    this.typeableEClass.getESuperTypes().add(this.getNamedElement());
    this.dataTypeEClass.getESuperTypes().add(this.getTypeable());
    this.compositionEClass.getESuperTypes().add(this.getNamedElement());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.classDiagramEClass, ClassDiagram.class, "ClassDiagram", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClassDiagram_Classes(), this.getClass_(), null, "classes", null, 0, -1, ClassDiagram.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClassDiagram_Dependencies(), this.getDependency(), null, "dependencies", null, 0, -1, ClassDiagram.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClassDiagram_Associations(), this.getAssociation(), null, "associations", null, 0, -1, ClassDiagram.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClassDiagram_Datatypes(), this.getDataType(), null, "datatypes", null, 0, -1, ClassDiagram.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClassDiagram_Compositions(), this.getComposition(), null, "compositions", null, 0, -1, ClassDiagram.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.classEClass, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, "Class", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClass_OwnedAttributes(), this.getAttribute(), null, "ownedAttributes", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_OwnedOperations(), this.getOperation(), null, "ownedOperations", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_DependenciesAsDependee(), this.getDependency(), this.getDependency_Dependee(), "dependenciesAsDependee", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_DependenciesAsDepender(), this.getDependency(), this.getDependency_Depender(), "dependenciesAsDepender", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_NestedIn(), this.getClass_(), this.getClass_Nested(), "nestedIn", null, 0, 1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_Nested(), this.getClass_(), this.getClass_NestedIn(), "nested", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_Superclass(), this.getClass_(), this.getClass_Subclasses(), "superclass", null, 0, 1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_Subclasses(), this.getClass_(), this.getClass_Superclass(), "subclasses", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_AssociationsAsSource(), this.getAssociation(), this.getAssociation_Source(), "associationsAsSource", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_AssociationsAsTarget(), this.getAssociation(), this.getAssociation_Target(), "associationsAsTarget", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_CompositionsAsConstituent(), this.getComposition(), this.getComposition_Constituent(), "compositionsAsConstituent", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getClass_CompositionsAsComposite(), this.getComposition(), this.getComposition_Composite(), "compositionsAsComposite", null, 0, -1, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.attributeEClass, Attribute.class, "Attribute", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.namedElementEClass, NamedElement.class, "NamedElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedElement_Name(), this.ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.operationEClass, Operation.class, "Operation", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperation_ParameterTypes(), this.getTypeable(), null, "parameterTypes", null, 0, -1, Operation.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.dependencyEClass, Dependency.class, "Dependency", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDependency_Dependee(), this.getClass_(), this.getClass_DependenciesAsDependee(), "dependee", null, 1, 1, Dependency.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getDependency_Depender(), this.getClass_(), this.getClass_DependenciesAsDepender(), "depender", null, 1, 1, Dependency.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getDependency_Name(), this.ecorePackage.getEString(), "name", null, 1, 1, Dependency.class, EPackageImpl.IS_TRANSIENT, EPackageImpl.IS_VOLATILE, !EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.typedElementEClass, TypedElement.class, "TypedElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypedElement_Type(), this.getTypeable(), null, "type", null, 0, 1, TypedElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getTypedElement_Public(), this.ecorePackage.getEBoolean(), "public", null, 1, 1, TypedElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.associationEClass, Association.class, "Association", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssociation_Source(), this.getClass_(), this.getClass_AssociationsAsSource(), "source", null, 1, 1, Association.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getAssociation_Target(), this.getClass_(), this.getClass_AssociationsAsTarget(), "target", null, 1, 1, Association.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getAssociation_Multiplicity(), this.ecorePackage.getEString(), "multiplicity", "", 0, 1, Association.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.typeableEClass, Typeable.class, "Typeable", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.dataTypeEClass, DataType.class, "DataType", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.compositionEClass, Composition.class, "Composition", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComposition_Constituent(), this.getClass_(), this.getClass_CompositionsAsConstituent(), "constituent", null, 1, 1, Composition.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getComposition_Composite(), this.getClass_(), this.getClass_CompositionsAsComposite(), "composite", null, 1, 1, Composition.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getComposition_Multiplicity(), this.ecorePackage.getEString(), "multiplicity", "", 0, 1, Composition.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    // Create resource
    createResource(ClassDiagramPackage.eNS_URI);

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
      (getClass_NestedIn(),
       source,
       new String[] {
         "target.decoration", "square"
       });
    addAnnotation
      (getClass_Superclass(),
       source,
       new String[] {
         "target.decoration", "closedarrow"
       });
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

} //ClassDiagramPackageImpl
