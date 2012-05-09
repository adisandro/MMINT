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

import edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl;

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.mapping.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.mapping.HomomorphismLink;
import edu.toronto.cs.se.mmtf.mid.mapping.HomomorphismModelRel;
import edu.toronto.cs.se.mmtf.mid.mapping.Link;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElement;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelRel;

import edu.toronto.cs.se.mmtf.mid.mapping.util.MappingValidator;

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
	private EClass modelContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementEClass = null;

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
	private EEnum modelElementCategoryEEnum = null;

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

		// Create package meta-data objects
		theMappingPackage.createPackageContents();
		theMidPackage.createPackageContents();

		// Initialize created meta-data
		theMappingPackage.initializePackageContents();
		theMidPackage.initializePackageContents();

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
	public EReference getModelRel_Containers() {
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
	public EClass getModelContainer() {
		return modelContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelContainer_Name() {
		return (EAttribute)modelContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelContainer_Type() {
		return (EAttribute)modelContainerEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelContainer_ReferencedModel() {
		return (EReference)modelContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelContainer_ContainedModel() {
		return (EReference)modelContainerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelContainer_Model() {
		return (EReference)modelContainerEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelContainer_Elements() {
		return (EReference)modelContainerEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElement() {
		return modelElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElement_Category() {
		return (EAttribute)modelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_Pointer() {
		return (EReference)modelElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElement_Links() {
		return (EReference)modelElementEClass.getEStructuralFeatures().get(2);
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
	public EReference getLink_Elements() {
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
	public EEnum getModelElementCategory() {
		return modelElementCategoryEEnum;
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
		createEReference(modelRelEClass, MODEL_REL__CONTAINERS);
		createEAttribute(modelRelEClass, MODEL_REL__UNBOUNDED);

		binaryModelRelEClass = createEClass(BINARY_MODEL_REL);

		homomorphismModelRelEClass = createEClass(HOMOMORPHISM_MODEL_REL);

		modelContainerEClass = createEClass(MODEL_CONTAINER);
		createEAttribute(modelContainerEClass, MODEL_CONTAINER__NAME);
		createEReference(modelContainerEClass, MODEL_CONTAINER__REFERENCED_MODEL);
		createEReference(modelContainerEClass, MODEL_CONTAINER__CONTAINED_MODEL);
		createEReference(modelContainerEClass, MODEL_CONTAINER__MODEL);
		createEReference(modelContainerEClass, MODEL_CONTAINER__ELEMENTS);
		createEAttribute(modelContainerEClass, MODEL_CONTAINER__TYPE);

		modelElementEClass = createEClass(MODEL_ELEMENT);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__CATEGORY);
		createEReference(modelElementEClass, MODEL_ELEMENT__POINTER);
		createEReference(modelElementEClass, MODEL_ELEMENT__LINKS);

		linkEClass = createEClass(LINK);
		createEReference(linkEClass, LINK__ELEMENTS);
		createEAttribute(linkEClass, LINK__UNBOUNDED);

		binaryLinkEClass = createEClass(BINARY_LINK);

		homomorphismLinkEClass = createEClass(HOMOMORPHISM_LINK);

		// Create enums
		modelElementCategoryEEnum = createEEnum(MODEL_ELEMENT_CATEGORY);
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
		modelElementEClass.getESuperTypes().add(theMidPackage.getExtendibleElement());
		linkEClass.getESuperTypes().add(theMidPackage.getExtendibleElement());
		binaryLinkEClass.getESuperTypes().add(this.getLink());
		homomorphismLinkEClass.getESuperTypes().add(this.getBinaryLink());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelRelEClass, ModelRel.class, "ModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelRel_Models(), theMidPackage.getModel(), null, "models", null, 1, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_Links(), this.getLink(), null, "links", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_Containers(), this.getModelContainer(), null, "containers", null, 1, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelRel_Unbounded(), ecorePackage.getEBoolean(), "unbounded", null, 1, 1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryModelRelEClass, BinaryModelRel.class, "BinaryModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(homomorphismModelRelEClass, HomomorphismModelRel.class, "HomomorphismModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelContainerEClass, ModelContainer.class, "ModelContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelContainer_Name(), ecorePackage.getEString(), "name", null, 1, 1, ModelContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getModelContainer_ReferencedModel(), theMidPackage.getModel(), null, "referencedModel", null, 0, 1, ModelContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelContainer_ContainedModel(), theMidPackage.getModel(), null, "containedModel", null, 0, 1, ModelContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelContainer_Model(), theMidPackage.getModel(), null, "model", null, 1, 1, ModelContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getModelContainer_Elements(), this.getModelElement(), null, "elements", null, 0, -1, ModelContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelContainer_Type(), ecorePackage.getEString(), "type", null, 1, 1, ModelContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(modelElementEClass, ModelElement.class, "ModelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElement_Category(), this.getModelElementCategory(), "category", null, 1, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElement_Pointer(), ecorePackage.getEObject(), null, "pointer", null, 1, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElement_Links(), this.getLink(), this.getLink_Elements(), "links", null, 0, -1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLink_Elements(), this.getModelElement(), this.getModelElement_Links(), "elements", null, 0, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLink_Unbounded(), ecorePackage.getEBoolean(), "unbounded", null, 1, 1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryLinkEClass, BinaryLink.class, "BinaryLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(homomorphismLinkEClass, HomomorphismLink.class, "HomomorphismLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(modelElementCategoryEEnum, ModelElementCategory.class, "ModelElementCategory");
		addEEnumLiteral(modelElementCategoryEEnum, ModelElementCategory.ENTITY);
		addEEnumLiteral(modelElementCategoryEEnum, ModelElementCategory.RELATIONSHIP);

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
			 "constraints", "modelContainers unboundedLevel"
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
		  (modelContainerEClass, 
		   source, 
		   new String[] {
			 "constraints", "oneModel"
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
			 "modelContainers", "models->size() = containers->size()",
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
			 "sameModelTypes", "models->forAll(m1 : Model, m2 : Model | m1.root.oclType() = m2.root.oclType())"
		   });			
		addAnnotation
		  (modelContainerEClass, 
		   source, 
		   new String[] {
			 "oneModel", "referencedModel.oclIsUndefined() xor containedModel.oclIsUndefined()"
		   });		
		addAnnotation
		  (getModelContainer_Name(), 
		   source, 
		   new String[] {
			 "derivation", "if model.oclIsUndefined() then \'\' else model.name endif"
		   });		
		addAnnotation
		  (getModelContainer_Model(), 
		   source, 
		   new String[] {
			 "derivation", "if containedModel.oclIsUndefined() then referencedModel else containedModel endif"
		   });		
		addAnnotation
		  (getModelContainer_Type(), 
		   source, 
		   new String[] {
			 "derivation", "if model.oclIsUndefined() then \'\' else model.type endif"
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
			 "isBinaryLink", "elements->size() = 2"
		   });			
		addAnnotation
		  (homomorphismLinkEClass, 
		   source, 
		   new String[] {
			 "sameElementTypes", "invalid->forAll(e1 : ModelElement, e2 : ModelElement | e1.pointer.oclType() = e2.pointer.oclType())"
		   });
	}

} //MappingPackageImpl
