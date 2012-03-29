/**
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.impl;

import edu.toronto.cs.se.mmtf.mid.MidPackage;

import edu.toronto.cs.se.mmtf.mid.impl.MidPackageImpl;

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.Mapping;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

import edu.toronto.cs.se.mmtf.mid.mapping.util.MappingValidator;

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
	private EClass mappingReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryMappingReferenceEClass = null;

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
	private EClass modelElementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

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
	public EClass getMappingReference() {
		return mappingReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingReference_Models() {
		return (EReference)mappingReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingReference_Mappings() {
		return (EReference)mappingReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingReference_Containers() {
		return (EReference)mappingReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryMappingReference() {
		return binaryMappingReferenceEClass;
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
	public EReference getModelContainer_Elements() {
		return (EReference)modelContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelContainer_Name() {
		return (EAttribute)modelContainerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelContainer_Model() {
		return (EReference)modelContainerEClass.getEStructuralFeatures().get(2);
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
	public EReference getModelElementReference_Pointer() {
		return (EReference)modelElementReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementReference_Mappings() {
		return (EReference)modelElementReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_Elements() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
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
		mappingReferenceEClass = createEClass(MAPPING_REFERENCE);
		createEReference(mappingReferenceEClass, MAPPING_REFERENCE__MODELS);
		createEReference(mappingReferenceEClass, MAPPING_REFERENCE__MAPPINGS);
		createEReference(mappingReferenceEClass, MAPPING_REFERENCE__CONTAINERS);

		binaryMappingReferenceEClass = createEClass(BINARY_MAPPING_REFERENCE);

		modelContainerEClass = createEClass(MODEL_CONTAINER);
		createEReference(modelContainerEClass, MODEL_CONTAINER__ELEMENTS);
		createEAttribute(modelContainerEClass, MODEL_CONTAINER__NAME);
		createEReference(modelContainerEClass, MODEL_CONTAINER__MODEL);

		modelElementReferenceEClass = createEClass(MODEL_ELEMENT_REFERENCE);
		createEReference(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE__POINTER);
		createEReference(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE__MAPPINGS);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__ELEMENTS);
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
		mappingReferenceEClass.getESuperTypes().add(theMidPackage.getModelReference());
		binaryMappingReferenceEClass.getESuperTypes().add(this.getMappingReference());
		modelElementReferenceEClass.getESuperTypes().add(theMidPackage.getNamedElement());
		mappingEClass.getESuperTypes().add(theMidPackage.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(mappingReferenceEClass, MappingReference.class, "MappingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingReference_Models(), theMidPackage.getModelReference(), null, "models", null, 1, -1, MappingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingReference_Mappings(), this.getMapping(), null, "mappings", null, 0, -1, MappingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingReference_Containers(), this.getModelContainer(), null, "containers", null, 1, -1, MappingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryMappingReferenceEClass, BinaryMappingReference.class, "BinaryMappingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelContainerEClass, ModelContainer.class, "ModelContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelContainer_Elements(), this.getModelElementReference(), null, "elements", null, 0, -1, ModelContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getModelContainer_Name(), ecorePackage.getEString(), "name", null, 1, 1, ModelContainer.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getModelContainer_Model(), theMidPackage.getModelReference(), null, "model", null, 1, 1, ModelContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementReferenceEClass, ModelElementReference.class, "ModelElementReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementReference_Pointer(), ecorePackage.getEObject(), null, "pointer", null, 1, 1, ModelElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelElementReference_Mappings(), this.getMapping(), this.getMapping_Elements(), "mappings", null, 0, -1, ModelElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_Elements(), this.getModelElementReference(), this.getModelElementReference_Mappings(), "elements", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		  (mappingReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "modelContainers"
		   });			
		addAnnotation
		  (binaryMappingReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "isBinary"
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
		  (mappingReferenceEClass, 
		   source, 
		   new String[] {
			 "modelContainers", "models->size() = containers->size()"
		   });			
		addAnnotation
		  (binaryMappingReferenceEClass, 
		   source, 
		   new String[] {
			 "isBinary", "models->size() = 2"
		   });		
		addAnnotation
		  (getModelContainer_Name(), 
		   source, 
		   new String[] {
			 "derivation", "model.name"
		   });
	}

} //MappingPackageImpl
