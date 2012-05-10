/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.impl;

import edu.toronto.cs.se.mmtf.mid.MidPackage;

import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmtf.mid.editor.impl.EditorPackageImpl;
import edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl;

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.mapping.HomomorphismLink;
import edu.toronto.cs.se.mmtf.mid.mapping.HomomorphismModelRel;
import edu.toronto.cs.se.mmtf.mid.mapping.Link;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelRel;

import edu.toronto.cs.se.mmtf.mid.mapping.TypedElementReference;
import edu.toronto.cs.se.mmtf.mid.mapping.util.MappingValidator;

import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
public class MappingPackageImpl extends EPackageImpl implements MappingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelRelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryModelRelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass homomorphismModelRelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass homomorphismLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementReferenceEClass = null;

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
	 * @see edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MappingPackageImpl() {
		super(eNS_URI, MappingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MappingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MappingPackage init() {
		if (isInited) return (MappingPackage)EPackage.Registry.INSTANCE.getEPackage(MappingPackage.eNS_URI);

		// Obtain or create and register package
		MappingPackageImpl theMappingPackage = (MappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MappingPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MidPackageImpl theMidPackage = (MidPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MidPackage.eNS_URI) instanceof MidPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MidPackage.eNS_URI) : MidPackage.eINSTANCE);
		EditorPackageImpl theEditorPackage = (EditorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) instanceof EditorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) : EditorPackage.eINSTANCE);
		OperatorPackageImpl theOperatorPackage = (OperatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) instanceof OperatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) : OperatorPackage.eINSTANCE);

		// Create package meta-data objects
		theMappingPackage.createPackageContents();
		theMidPackage.createPackageContents();
		theEditorPackage.createPackageContents();
		theOperatorPackage.createPackageContents();

		// Initialize created meta-data
		theMappingPackage.initializePackageContents();
		theMidPackage.initializePackageContents();
		theEditorPackage.initializePackageContents();
		theOperatorPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMappingPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MappingValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMappingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MappingPackage.eNS_URI, theMappingPackage);
		return theMappingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelRel() {
		return modelRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRel_Models() {
		return (EReference)modelRelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRel_Links() {
		return (EReference)modelRelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRel_ModelRefs() {
		return (EReference)modelRelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelRel_Unbounded() {
		return (EAttribute)modelRelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryModelRel() {
		return binaryModelRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHomomorphismModelRel() {
		return homomorphismModelRelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelReference() {
		return modelReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelReference_ElementRefs() {
		return (EReference)modelReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementReference() {
		return modelElementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementReference_Links() {
		return (EReference)modelElementReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_ElementRefs() {
		return (EReference)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLink_Unbounded() {
		return (EAttribute)linkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryLink() {
		return binaryLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHomomorphismLink() {
		return homomorphismLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElementReference() {
		return typedElementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElementReference_ReferencedObject() {
		return (EReference)typedElementReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElementReference_ContainedObject() {
		return (EReference)typedElementReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElementReference_Object() {
		return (EReference)typedElementReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementReference_Name() {
		return (EAttribute)typedElementReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementReference_Type() {
		return (EAttribute)typedElementReferenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingFactory getMappingFactory() {
		return (MappingFactory)getEFactoryInstance();
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
		modelRelEClass = createEClass(MODEL_REL);
		createEReference(modelRelEClass, MODEL_REL__MODELS);
		createEReference(modelRelEClass, MODEL_REL__LINKS);
		createEReference(modelRelEClass, MODEL_REL__MODEL_REFS);
		createEAttribute(modelRelEClass, MODEL_REL__UNBOUNDED);

		binaryModelRelEClass = createEClass(BINARY_MODEL_REL);

		homomorphismModelRelEClass = createEClass(HOMOMORPHISM_MODEL_REL);

		modelReferenceEClass = createEClass(MODEL_REFERENCE);
		createEReference(modelReferenceEClass, MODEL_REFERENCE__ELEMENT_REFS);

		modelElementReferenceEClass = createEClass(MODEL_ELEMENT_REFERENCE);
		createEReference(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE__LINKS);

		linkEClass = createEClass(LINK);
		createEReference(linkEClass, LINK__ELEMENT_REFS);
		createEAttribute(linkEClass, LINK__UNBOUNDED);

		binaryLinkEClass = createEClass(BINARY_LINK);

		homomorphismLinkEClass = createEClass(HOMOMORPHISM_LINK);

		typedElementReferenceEClass = createEClass(TYPED_ELEMENT_REFERENCE);
		createEReference(typedElementReferenceEClass, TYPED_ELEMENT_REFERENCE__REFERENCED_OBJECT);
		createEReference(typedElementReferenceEClass, TYPED_ELEMENT_REFERENCE__CONTAINED_OBJECT);
		createEReference(typedElementReferenceEClass, TYPED_ELEMENT_REFERENCE__OBJECT);
		createEAttribute(typedElementReferenceEClass, TYPED_ELEMENT_REFERENCE__NAME);
		createEAttribute(typedElementReferenceEClass, TYPED_ELEMENT_REFERENCE__TYPE);
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
		MidPackage theMidPackage = (MidPackage)EPackage.Registry.INSTANCE.getEPackage(MidPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modelRelEClass.getESuperTypes().add(theMidPackage.getModel());
		binaryModelRelEClass.getESuperTypes().add(this.getModelRel());
		homomorphismModelRelEClass.getESuperTypes().add(this.getBinaryModelRel());
		modelReferenceEClass.getESuperTypes().add(this.getTypedElementReference());
		modelElementReferenceEClass.getESuperTypes().add(this.getTypedElementReference());
		linkEClass.getESuperTypes().add(theMidPackage.getExtendibleElement());
		binaryLinkEClass.getESuperTypes().add(this.getLink());
		homomorphismLinkEClass.getESuperTypes().add(this.getBinaryLink());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelRelEClass, ModelRel.class, "ModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelRel_Models(), theMidPackage.getModel(), null, "models", null, 1, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_Links(), this.getLink(), null, "links", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_ModelRefs(), this.getModelReference(), null, "modelRefs", null, 1, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelRel_Unbounded(), ecorePackage.getEBoolean(), "unbounded", null, 1, 1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryModelRelEClass, BinaryModelRel.class, "BinaryModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(homomorphismModelRelEClass, HomomorphismModelRel.class, "HomomorphismModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelReferenceEClass, ModelReference.class, "ModelReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelReference_ElementRefs(), this.getModelElementReference(), null, "elementRefs", null, 0, -1, ModelReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementReferenceEClass, ModelElementReference.class, "ModelElementReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementReference_Links(), this.getLink(), this.getLink_ElementRefs(), "links", null, 0, -1, ModelElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLink_ElementRefs(), this.getModelElementReference(), this.getModelElementReference_Links(), "elementRefs", null, 0, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Unbounded(), ecorePackage.getEBoolean(), "unbounded", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryLinkEClass, BinaryLink.class, "BinaryLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(homomorphismLinkEClass, HomomorphismLink.class, "HomomorphismLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typedElementReferenceEClass, TypedElementReference.class, "TypedElementReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedElementReference_ReferencedObject(), theMidPackage.getTypedElement(), null, "referencedObject", null, 0, 1, TypedElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedElementReference_ContainedObject(), theMidPackage.getTypedElement(), null, "containedObject", null, 0, 1, TypedElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedElementReference_Object(), theMidPackage.getTypedElement(), null, "object", null, 1, 1, TypedElementReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedElementReference_Name(), ecorePackage.getEString(), "name", null, 1, 1, TypedElementReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedElementReference_Type(), ecorePackage.getEString(), "type", null, 1, 1, TypedElementReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
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
		  (modelRelEClass, 
		   source, 
		   new String[] {
			 "constraints", "modelRefs unboundedLevel"
		   });			
		addAnnotation
		  (binaryModelRelEClass, 
		   source, 
		   new String[] {
			 "constraints", "isBinaryRel"
		   });			
		addAnnotation
		  (homomorphismModelRelEClass, 
		   source, 
		   new String[] {
			 "constraints", "sameModelTypes"
		   });			
		addAnnotation
		  (linkEClass, 
		   source, 
		   new String[] {
			 "constraints", "unboundedLevel"
		   });			
		addAnnotation
		  (binaryLinkEClass, 
		   source, 
		   new String[] {
			 "constraints", "isBinaryLink"
		   });			
		addAnnotation
		  (homomorphismLinkEClass, 
		   source, 
		   new String[] {
			 "constraints", "sameElementTypes"
		   });			
		addAnnotation
		  (typedElementReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "oneObject"
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
		  (modelRelEClass, 
		   source, 
		   new String[] {
			 "modelRefs", "models->size() = modelRefs->size()",
			 "unboundedLevel", "unbounded = true implies level = MidLevel::TYPES"
		   });			
		addAnnotation
		  (binaryModelRelEClass, 
		   source, 
		   new String[] {
			 "isBinaryRel", "models->size() = 2"
		   });			
		addAnnotation
		  (homomorphismModelRelEClass, 
		   source, 
		   new String[] {
			 "sameModelTypes", "models->forAll(m1 : Model, m2 : Model | m1.type = m2.type)"
		   });			
		addAnnotation
		  (linkEClass, 
		   source, 
		   new String[] {
			 "unboundedLevel", "unbounded = true implies level = MidLevel::TYPES"
		   });			
		addAnnotation
		  (binaryLinkEClass, 
		   source, 
		   new String[] {
			 "isBinaryLink", "elementRefs->size() = 2"
		   });			
		addAnnotation
		  (homomorphismLinkEClass, 
		   source, 
		   new String[] {
			 "sameElementTypes", "invalid->forAll(e1 : ModelElement, e2 : ModelElement | e1.pointer.oclType() = e2.pointer.oclType())"
		   });			
		addAnnotation
		  (typedElementReferenceEClass, 
		   source, 
		   new String[] {
			 "oneObject", "referencedObject.oclIsUndefined() xor containedObject.oclIsUndefined()"
		   });		
		addAnnotation
		  (getTypedElementReference_Object(), 
		   source, 
		   new String[] {
			 "derivation", "if containedObject.oclIsUndefined() then referencedObject else containedObject endif"
		   });		
		addAnnotation
		  (getTypedElementReference_Name(), 
		   source, 
		   new String[] {
			 "derivation", "if object.oclIsUndefined() then \'\' else object.name endif"
		   });		
		addAnnotation
		  (getTypedElementReference_Type(), 
		   source, 
		   new String[] {
			 "derivation", "if object.oclIsUndefined() then \'\' else object.type endif"
		   });
	}

} //MappingPackageImpl
