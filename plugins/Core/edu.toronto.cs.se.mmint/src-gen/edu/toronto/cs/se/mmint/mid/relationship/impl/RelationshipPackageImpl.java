/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmint.mid.editor.impl.EditorPackageImpl;
import edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.util.RelationshipValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationshipPackageImpl extends EPackageImpl implements RelationshipPackage {
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
	private EClass modelEndpointReferenceEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementEndpointEClass = null;

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
	private EClass extendibleElementReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendibleElementEndpointReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementEndpointReferenceEClass = null;

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
	 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RelationshipPackageImpl() {
		super(eNS_URI, RelationshipFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RelationshipPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RelationshipPackage init() {
		if (isInited) return (RelationshipPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);

		// Obtain or create and register package
		RelationshipPackageImpl theRelationshipPackage = (RelationshipPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RelationshipPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RelationshipPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MIDPackageImpl theMIDPackage = (MIDPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI) instanceof MIDPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI) : MIDPackage.eINSTANCE);
		EditorPackageImpl theEditorPackage = (EditorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) instanceof EditorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) : EditorPackage.eINSTANCE);
		OperatorPackageImpl theOperatorPackage = (OperatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) instanceof OperatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) : OperatorPackage.eINSTANCE);

		// Create package meta-data objects
		theRelationshipPackage.createPackageContents();
		theMIDPackage.createPackageContents();
		theEditorPackage.createPackageContents();
		theOperatorPackage.createPackageContents();

		// Initialize created meta-data
		theRelationshipPackage.initializePackageContents();
		theMIDPackage.initializePackageContents();
		theEditorPackage.initializePackageContents();
		theOperatorPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theRelationshipPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return RelationshipValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theRelationshipPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RelationshipPackage.eNS_URI, theRelationshipPackage);
		return theRelationshipPackage;
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
	public EReference getModelRel_ModelEndpoints() {
		return (EReference)modelRelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRel_Mappings() {
		return (EReference)modelRelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRel_ModelEndpointRefs() {
		return (EReference)modelRelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelRel_MappingRefs() {
		return (EReference)modelRelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__GetMetatype() {
		return modelRelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__GetSupertype() {
		return modelRelEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__GetMIDContainer() {
		return modelRelEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CreateBinarySubtype__String_String_String_boolean() {
		return modelRelEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CopySubtype__ModelRel() {
		return modelRelEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__DeleteType() {
		return modelRelEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CreateInstanceAndEndpoints__String_EList_MID() {
		return modelRelEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CreateBinaryInstance__String_MID() {
		return modelRelEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CreateBinaryInstanceAndEndpoints__String_Model_Model_MID() {
		return modelRelEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__GetOutlineResourceTypes() {
		return modelRelEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__GetOutlineResourceInstances() {
		return modelRelEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CreateWorkflowInstanceAndEndpoints__String_EList_MID() {
		return modelRelEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CreateWorkflowBinaryInstance__String_MID() {
		return modelRelEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CreateWorkflowBinaryInstanceAndEndpoints__String_Model_Model_MID() {
		return modelRelEClass.getEOperations().get(13);
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
	public EReference getBinaryModelRel_SourceModel() {
		return (EReference)binaryModelRelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryModelRel_TargetModel() {
		return (EReference)binaryModelRelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryModelRel__AddModelType__Model_boolean() {
		return binaryModelRelEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelEndpointReference() {
		return modelEndpointReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelEndpointReference_ModelElemRefs() {
		return (EReference)modelEndpointReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpointReference__GetObject() {
		return modelEndpointReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpointReference__GetSupertypeRef() {
		return modelEndpointReferenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpointReference__AcceptModelElementType__EObject() {
		return modelEndpointReferenceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpointReference__DeleteTypeReference__boolean() {
		return modelEndpointReferenceEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpointReference__AcceptModelElementInstance__EObject() {
		return modelEndpointReferenceEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String() {
		return modelEndpointReferenceEClass.getEOperations().get(5);
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
	public EReference getModelElementReference_ModelElemEndpointRefs() {
		return (EReference)modelElementReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementReference__GetObject() {
		return modelElementReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementReference__GetSupertypeRef() {
		return modelElementReferenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementReference__DeleteTypeReference() {
		return modelElementReferenceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementReference__DeleteInstanceReference() {
		return modelElementReferenceEClass.getEOperations().get(3);
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
	public EReference getMapping_ModelElemEndpoints() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMapping_ModelElemEndpointRefs() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__GetMetatype() {
		return mappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__GetSupertype() {
		return mappingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__GetMIDContainer() {
		return mappingEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__CreateTypeReference__MappingReference_boolean_ModelRel() {
		return mappingEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__CreateSubtypeAndReference__MappingReference_String_boolean_ModelRel() {
		return mappingEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__DeleteType() {
		return mappingEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__CreateInstanceReference__ModelRel() {
		return mappingEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__CreateInstanceAndReference__boolean_ModelRel() {
		return mappingEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__CreateInstanceAndReferenceAndEndpointsAndReferences__boolean_EList() {
		return mappingEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMapping__DeleteInstance() {
		return mappingEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryMapping() {
		return binaryMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryMapping__CreateTypeReference__MappingReference_boolean_ModelRel() {
		return binaryMappingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryMapping__CreateInstanceReference__ModelRel() {
		return binaryMappingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementEndpoint() {
		return modelElementEndpointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__GetSupertype() {
		return modelElementEndpointEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__GetMIDContainer() {
		return modelElementEndpointEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__GetTarget() {
		return modelElementEndpointEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__GetMetatype() {
		return modelElementEndpointEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__CreateTypeReference__ModelElementEndpointReference_ModelElementReference_boolean_boolean_MappingReference() {
		return modelElementEndpointEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__CreateSubtypeAndReference__String_ModelElementReference_boolean_MappingReference() {
		return modelElementEndpointEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__ReplaceSubtypeAndReference__ModelElementEndpointReference_String_ModelElementReference() {
		return modelElementEndpointEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__DeleteType__boolean() {
		return modelElementEndpointEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__CreateInstanceReference__ModelElementReference_MappingReference() {
		return modelElementEndpointEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__CreateInstanceAndReference__ModelElementReference_MappingReference() {
		return modelElementEndpointEClass.getEOperations().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__ReplaceInstanceAndReference__ModelElementEndpointReference_ModelElementReference() {
		return modelElementEndpointEClass.getEOperations().get(10);
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
	public EReference getMappingReference_ModelElemEndpointRefs() {
		return (EReference)mappingReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingReference__GetObject() {
		return mappingReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingReference__GetSupertypeRef() {
		return mappingReferenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingReference__DeleteTypeReference() {
		return mappingReferenceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingReference__DeleteTypeAndReference() {
		return mappingReferenceEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingReference__DeleteInstanceReference() {
		return mappingReferenceEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getMappingReference__DeleteInstanceAndReference() {
		return mappingReferenceEClass.getEOperations().get(5);
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
	public EReference getBinaryMappingReference_SourceModelElemRef() {
		return (EReference)binaryMappingReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryMappingReference_TargetModelElemRef() {
		return (EReference)binaryMappingReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryMappingReference__GetObject() {
		return binaryMappingReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryMappingReference__AddModelElementTypeReference__ModelElementReference_boolean() {
		return binaryMappingReferenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendibleElementReference() {
		return extendibleElementReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendibleElementReference_ReferencedObject() {
		return (EReference)extendibleElementReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendibleElementReference_ContainedObject() {
		return (EReference)extendibleElementReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendibleElementReference_Object() {
		return (EReference)extendibleElementReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendibleElementReference_SupertypeRef() {
		return (EReference)extendibleElementReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElementReference_Modifiable() {
		return (EAttribute)extendibleElementReferenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElementReference_Uri() {
		return (EAttribute)extendibleElementReferenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtendibleElementReference__GetMIDContainer() {
		return extendibleElementReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtendibleElementReference__IsTypesLevel() {
		return extendibleElementReferenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtendibleElementReference__IsInstancesLevel() {
		return extendibleElementReferenceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtendibleElementReference__IsWorkflowsLevel() {
		return extendibleElementReferenceEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendibleElementEndpointReference() {
		return extendibleElementEndpointReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendibleElementEndpointReference_TargetUri() {
		return (EAttribute)extendibleElementEndpointReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtendibleElementEndpointReference__GetObject() {
		return extendibleElementEndpointReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getExtendibleElementEndpointReference__GetSupertypeRef() {
		return extendibleElementEndpointReferenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementEndpointReference() {
		return modelElementEndpointReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementEndpointReference_ModelElemRef() {
		return (EReference)modelElementEndpointReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpointReference__GetObject() {
		return modelElementEndpointReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpointReference__GetSupertypeRef() {
		return modelElementEndpointReferenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpointReference__DeleteTypeReference__boolean() {
		return modelElementEndpointReferenceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpointReference__DeleteTypeAndReference__boolean() {
		return modelElementEndpointReferenceEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpointReference__DeleteInstanceAndReference__boolean() {
		return modelElementEndpointReferenceEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipFactory getRelationshipFactory() {
		return (RelationshipFactory)getEFactoryInstance();
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
		createEReference(modelRelEClass, MODEL_REL__MODEL_ENDPOINTS);
		createEReference(modelRelEClass, MODEL_REL__MAPPINGS);
		createEReference(modelRelEClass, MODEL_REL__MODEL_ENDPOINT_REFS);
		createEReference(modelRelEClass, MODEL_REL__MAPPING_REFS);
		createEOperation(modelRelEClass, MODEL_REL___GET_METATYPE);
		createEOperation(modelRelEClass, MODEL_REL___GET_SUPERTYPE);
		createEOperation(modelRelEClass, MODEL_REL___GET_MID_CONTAINER);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_STRING_STRING_BOOLEAN);
		createEOperation(modelRelEClass, MODEL_REL___COPY_SUBTYPE__MODELREL);
		createEOperation(modelRelEClass, MODEL_REL___GET_OUTLINE_RESOURCE_TYPES);
		createEOperation(modelRelEClass, MODEL_REL___DELETE_TYPE);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_BINARY_INSTANCE__STRING_MID);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID);
		createEOperation(modelRelEClass, MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID);

		binaryModelRelEClass = createEClass(BINARY_MODEL_REL);
		createEReference(binaryModelRelEClass, BINARY_MODEL_REL__SOURCE_MODEL);
		createEReference(binaryModelRelEClass, BINARY_MODEL_REL__TARGET_MODEL);
		createEOperation(binaryModelRelEClass, BINARY_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN);

		extendibleElementReferenceEClass = createEClass(EXTENDIBLE_ELEMENT_REFERENCE);
		createEReference(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT);
		createEReference(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT);
		createEReference(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE__OBJECT);
		createEReference(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF);
		createEAttribute(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE);
		createEAttribute(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE__URI);
		createEOperation(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE___GET_MID_CONTAINER);
		createEOperation(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE___IS_TYPES_LEVEL);
		createEOperation(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL);
		createEOperation(extendibleElementReferenceEClass, EXTENDIBLE_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL);

		extendibleElementEndpointReferenceEClass = createEClass(EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE);
		createEAttribute(extendibleElementEndpointReferenceEClass, EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE__TARGET_URI);
		createEOperation(extendibleElementEndpointReferenceEClass, EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT);
		createEOperation(extendibleElementEndpointReferenceEClass, EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF);

		modelEndpointReferenceEClass = createEClass(MODEL_ENDPOINT_REFERENCE);
		createEReference(modelEndpointReferenceEClass, MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS);
		createEOperation(modelEndpointReferenceEClass, MODEL_ENDPOINT_REFERENCE___GET_OBJECT);
		createEOperation(modelEndpointReferenceEClass, MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF);
		createEOperation(modelEndpointReferenceEClass, MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT);
		createEOperation(modelEndpointReferenceEClass, MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN);
		createEOperation(modelEndpointReferenceEClass, MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT);
		createEOperation(modelEndpointReferenceEClass, MODEL_ENDPOINT_REFERENCE___CREATE_MODEL_ELEMENT_INSTANCE_AND_REFERENCE__EOBJECT_STRING);

		modelElementReferenceEClass = createEClass(MODEL_ELEMENT_REFERENCE);
		createEReference(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS);
		createEOperation(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE___GET_OBJECT);
		createEOperation(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF);
		createEOperation(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE);
		createEOperation(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__MODEL_ELEM_ENDPOINTS);
		createEReference(mappingEClass, MAPPING__MODEL_ELEM_ENDPOINT_REFS);
		createEOperation(mappingEClass, MAPPING___GET_METATYPE);
		createEOperation(mappingEClass, MAPPING___GET_SUPERTYPE);
		createEOperation(mappingEClass, MAPPING___GET_MID_CONTAINER);
		createEOperation(mappingEClass, MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL);
		createEOperation(mappingEClass, MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL);
		createEOperation(mappingEClass, MAPPING___DELETE_TYPE);
		createEOperation(mappingEClass, MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL);
		createEOperation(mappingEClass, MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL);
		createEOperation(mappingEClass, MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST);
		createEOperation(mappingEClass, MAPPING___DELETE_INSTANCE);

		binaryMappingEClass = createEClass(BINARY_MAPPING);
		createEOperation(binaryMappingEClass, BINARY_MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL);
		createEOperation(binaryMappingEClass, BINARY_MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL);

		modelElementEndpointEClass = createEClass(MODEL_ELEMENT_ENDPOINT);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___GET_METATYPE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___GET_MID_CONTAINER);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___GET_TARGET);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___CREATE_TYPE_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE_BOOLEAN_BOOLEAN_MAPPINGREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODELELEMENTREFERENCE_BOOLEAN_MAPPINGREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_STRING_MODELELEMENTREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___DELETE_TYPE__BOOLEAN);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE);

		mappingReferenceEClass = createEClass(MAPPING_REFERENCE);
		createEReference(mappingReferenceEClass, MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS);
		createEOperation(mappingReferenceEClass, MAPPING_REFERENCE___GET_OBJECT);
		createEOperation(mappingReferenceEClass, MAPPING_REFERENCE___GET_SUPERTYPE_REF);
		createEOperation(mappingReferenceEClass, MAPPING_REFERENCE___DELETE_TYPE_REFERENCE);
		createEOperation(mappingReferenceEClass, MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE);
		createEOperation(mappingReferenceEClass, MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE);
		createEOperation(mappingReferenceEClass, MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE);

		binaryMappingReferenceEClass = createEClass(BINARY_MAPPING_REFERENCE);
		createEReference(binaryMappingReferenceEClass, BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF);
		createEReference(binaryMappingReferenceEClass, BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF);
		createEOperation(binaryMappingReferenceEClass, BINARY_MAPPING_REFERENCE___GET_OBJECT);
		createEOperation(binaryMappingReferenceEClass, BINARY_MAPPING_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN);

		modelElementEndpointReferenceEClass = createEClass(MODEL_ELEMENT_ENDPOINT_REFERENCE);
		createEReference(modelElementEndpointReferenceEClass, MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF);
		createEOperation(modelElementEndpointReferenceEClass, MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT);
		createEOperation(modelElementEndpointReferenceEClass, MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF);
		createEOperation(modelElementEndpointReferenceEClass, MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN);
		createEOperation(modelElementEndpointReferenceEClass, MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_AND_REFERENCE__BOOLEAN);
		createEOperation(modelElementEndpointReferenceEClass, MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN);
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
		MIDPackage theMIDPackage = (MIDPackage)EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modelRelEClass.getESuperTypes().add(theMIDPackage.getModel());
		binaryModelRelEClass.getESuperTypes().add(this.getModelRel());
		extendibleElementEndpointReferenceEClass.getESuperTypes().add(this.getExtendibleElementReference());
		modelEndpointReferenceEClass.getESuperTypes().add(this.getExtendibleElementEndpointReference());
		modelElementReferenceEClass.getESuperTypes().add(this.getExtendibleElementReference());
		mappingEClass.getESuperTypes().add(theMIDPackage.getExtendibleElement());
		binaryMappingEClass.getESuperTypes().add(this.getMapping());
		modelElementEndpointEClass.getESuperTypes().add(theMIDPackage.getExtendibleElementEndpoint());
		mappingReferenceEClass.getESuperTypes().add(this.getExtendibleElementReference());
		binaryMappingReferenceEClass.getESuperTypes().add(this.getMappingReference());
		modelElementEndpointReferenceEClass.getESuperTypes().add(this.getExtendibleElementEndpointReference());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelRelEClass, ModelRel.class, "ModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelRel_ModelEndpoints(), theMIDPackage.getModelEndpoint(), null, "modelEndpoints", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_Mappings(), this.getMapping(), null, "mappings", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_ModelEndpointRefs(), this.getModelEndpointReference(), null, "modelEndpointRefs", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_MappingRefs(), this.getMappingReference(), null, "mappingRefs", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelRel__GetMetatype(), this.getModelRel(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelRel__GetSupertype(), theMIDPackage.getModel(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelRel__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getModelRel__CreateBinarySubtype__String_String_String_boolean(), this.getBinaryModelRel(), "createBinarySubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintImplementation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isMetamodelExtension", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__CopySubtype__ModelRel(), this.getModelRel(), "copySubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "origModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__GetOutlineResourceTypes(), ecorePackage.getEResourceSet(), "getOutlineResourceTypes", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__CreateInstanceAndEndpoints__String_EList_MID(), this.getModelRel(), "createInstanceAndEndpoints", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getModel(), "endpointModels", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__CreateBinaryInstance__String_MID(), this.getBinaryModelRel(), "createBinaryInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__CreateBinaryInstanceAndEndpoints__String_Model_Model_MID(), this.getBinaryModelRel(), "createBinaryInstanceAndEndpoints", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getModel(), "endpointSourceModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getModel(), "endpointTargetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__GetOutlineResourceInstances(), ecorePackage.getEResourceSet(), "getOutlineResourceInstances", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__CreateWorkflowInstanceAndEndpoints__String_EList_MID(), this.getModelRel(), "createWorkflowInstanceAndEndpoints", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelId", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getModel(), "endpointModels", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__CreateWorkflowBinaryInstance__String_MID(), this.getBinaryModelRel(), "createWorkflowBinaryInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelId", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelRel__CreateWorkflowBinaryInstanceAndEndpoints__String_Model_Model_MID(), this.getBinaryModelRel(), "createWorkflowBinaryInstanceAndEndpoints", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelId", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getModel(), "endpointSourceModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getModel(), "endpointTargetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(binaryModelRelEClass, BinaryModelRel.class, "BinaryModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryModelRel_SourceModel(), theMIDPackage.getModel(), null, "sourceModel", null, 1, 1, BinaryModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryModelRel_TargetModel(), theMIDPackage.getModel(), null, "targetModel", null, 1, 1, BinaryModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getBinaryModelRel__AddModelType__Model_boolean(), null, "addModelType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getModel(), "modelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(extendibleElementReferenceEClass, ExtendibleElementReference.class, "ExtendibleElementReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendibleElementReference_ReferencedObject(), theMIDPackage.getExtendibleElement(), null, "referencedObject", null, 0, 1, ExtendibleElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendibleElementReference_ContainedObject(), theMIDPackage.getExtendibleElement(), null, "containedObject", null, 0, 1, ExtendibleElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendibleElementReference_Object(), theMIDPackage.getExtendibleElement(), null, "object", null, 1, 1, ExtendibleElementReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExtendibleElementReference_SupertypeRef(), this.getExtendibleElementReference(), null, "supertypeRef", null, 0, 1, ExtendibleElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElementReference_Modifiable(), ecorePackage.getEBoolean(), "modifiable", null, 1, 1, ExtendibleElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElementReference_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, ExtendibleElementReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getExtendibleElementReference__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getExtendibleElementReference__IsTypesLevel(), ecorePackage.getEBoolean(), "isTypesLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getExtendibleElementReference__IsInstancesLevel(), ecorePackage.getEBoolean(), "isInstancesLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getExtendibleElementReference__IsWorkflowsLevel(), ecorePackage.getEBoolean(), "isWorkflowsLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(extendibleElementEndpointReferenceEClass, ExtendibleElementEndpointReference.class, "ExtendibleElementEndpointReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendibleElementEndpointReference_TargetUri(), ecorePackage.getEString(), "targetUri", null, 1, 1, ExtendibleElementEndpointReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getExtendibleElementEndpointReference__GetObject(), theMIDPackage.getExtendibleElementEndpoint(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getExtendibleElementEndpointReference__GetSupertypeRef(), this.getExtendibleElementEndpointReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelEndpointReferenceEClass, ModelEndpointReference.class, "ModelEndpointReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelEndpointReference_ModelElemRefs(), this.getModelElementReference(), null, "modelElemRefs", null, 0, -1, ModelEndpointReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelEndpointReference__GetObject(), theMIDPackage.getModelEndpoint(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelEndpointReference__GetSupertypeRef(), this.getModelEndpointReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelEndpointReference__AcceptModelElementType__EObject(), ecorePackage.getEBoolean(), "acceptModelElementType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "metamodelObj", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelEndpointReference__DeleteTypeReference__boolean(), null, "deleteTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelEndpointReference__AcceptModelElementInstance__EObject(), theMIDPackage.getModelElement(), "acceptModelElementInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "modelObj", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String(), this.getModelElementReference(), "createModelElementInstanceAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "modelObj", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelElemName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(modelElementReferenceEClass, ModelElementReference.class, "ModelElementReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementReference_ModelElemEndpointRefs(), this.getModelElementEndpointReference(), this.getModelElementEndpointReference_ModelElemRef(), "modelElemEndpointRefs", null, 0, -1, ModelElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelElementReference__GetObject(), theMIDPackage.getModelElement(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElementReference__GetSupertypeRef(), this.getModelElementReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelElementReference__DeleteTypeReference(), null, "deleteTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelElementReference__DeleteInstanceReference(), null, "deleteInstanceReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_ModelElemEndpoints(), this.getModelElementEndpoint(), null, "modelElemEndpoints", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_ModelElemEndpointRefs(), this.getModelElementEndpointReference(), null, "modelElemEndpointRefs", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMapping__GetMetatype(), this.getMapping(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMapping__GetSupertype(), this.getMapping(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMapping__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMapping__CreateTypeReference__MappingReference_boolean_ModelRel(), this.getMappingReference(), "createTypeReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingReference(), "mappingTypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isModifiable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMapping__CreateSubtypeAndReference__MappingReference_String_boolean_ModelRel(), this.getMappingReference(), "createSubtypeAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingReference(), "mappingTypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newMappingTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMapping__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMapping__CreateInstanceReference__ModelRel(), this.getMappingReference(), "createInstanceReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMapping__CreateInstanceAndReference__boolean_ModelRel(), this.getMappingReference(), "createInstanceAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMapping__CreateInstanceAndReferenceAndEndpointsAndReferences__boolean_EList(), this.getMappingReference(), "createInstanceAndReferenceAndEndpointsAndReferences", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemRefs", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMapping__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(binaryMappingEClass, BinaryMapping.class, "BinaryMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getBinaryMapping__CreateTypeReference__MappingReference_boolean_ModelRel(), this.getMappingReference(), "createTypeReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingReference(), "mappingTypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isModifiable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getBinaryMapping__CreateInstanceReference__ModelRel(), this.getMappingReference(), "createInstanceReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(modelElementEndpointEClass, ModelElementEndpoint.class, "ModelElementEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getModelElementEndpoint__GetMetatype(), this.getModelElementEndpoint(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElementEndpoint__GetSupertype(), this.getModelElementEndpoint(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElementEndpoint__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElementEndpoint__GetTarget(), theMIDPackage.getModelElement(), "getTarget", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelElementEndpoint__CreateTypeReference__ModelElementEndpointReference_ModelElementReference_boolean_boolean_MappingReference(), this.getModelElementEndpointReference(), "createTypeReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementEndpointReference(), "modelElemTypeEndpointRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isModifiable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingReference(), "containerMappingTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__CreateSubtypeAndReference__String_ModelElementReference_boolean_MappingReference(), this.getModelElementEndpointReference(), "createSubtypeAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelElemTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingReference(), "containerMappingTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__ReplaceSubtypeAndReference__ModelElementEndpointReference_String_ModelElementReference(), null, "replaceSubtypeAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementEndpointReference(), "oldModelElemTypeEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelElemTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__DeleteType__boolean(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__CreateInstanceReference__ModelElementReference_MappingReference(), this.getModelElementEndpointReference(), "createInstanceReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingReference(), "containerMappingRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__CreateInstanceAndReference__ModelElementReference_MappingReference(), this.getModelElementEndpointReference(), "createInstanceAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingReference(), "containerMappingRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__ReplaceInstanceAndReference__ModelElementEndpointReference_ModelElementReference(), null, "replaceInstanceAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementEndpointReference(), "oldModelElemEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(mappingReferenceEClass, MappingReference.class, "MappingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingReference_ModelElemEndpointRefs(), this.getModelElementEndpointReference(), null, "modelElemEndpointRefs", null, 0, -1, MappingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getMappingReference__GetObject(), this.getMapping(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getMappingReference__GetSupertypeRef(), this.getMappingReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getMappingReference__DeleteTypeReference(), null, "deleteTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMappingReference__DeleteTypeAndReference(), null, "deleteTypeAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMappingReference__DeleteInstanceReference(), null, "deleteInstanceReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getMappingReference__DeleteInstanceAndReference(), null, "deleteInstanceAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(binaryMappingReferenceEClass, BinaryMappingReference.class, "BinaryMappingReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryMappingReference_SourceModelElemRef(), this.getModelElementReference(), null, "sourceModelElemRef", null, 1, 1, BinaryMappingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryMappingReference_TargetModelElemRef(), this.getModelElementReference(), null, "targetModelElemRef", null, 1, 1, BinaryMappingReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBinaryMappingReference__GetObject(), this.getBinaryMapping(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBinaryMappingReference__AddModelElementTypeReference__ModelElementReference_boolean(), null, "addModelElementTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "modelElemTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(modelElementEndpointReferenceEClass, ModelElementEndpointReference.class, "ModelElementEndpointReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementEndpointReference_ModelElemRef(), this.getModelElementReference(), this.getModelElementReference_ModelElemEndpointRefs(), "modelElemRef", null, 1, 1, ModelElementEndpointReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelElementEndpointReference__GetObject(), this.getModelElementEndpoint(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElementEndpointReference__GetSupertypeRef(), this.getModelElementEndpointReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelElementEndpointReference__DeleteTypeReference__boolean(), null, "deleteTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelElementEndpointReference__DeleteTypeAndReference__boolean(), null, "deleteTypeAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getModelElementEndpointReference__DeleteInstanceAndReference__boolean(), null, "deleteInstanceAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

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
		  (binaryModelRelEClass, 
		   source, 
		   new String[] {
			 "constraints", "isBinaryModelRel"
		   });	
		addAnnotation
		  (extendibleElementReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "oneObject"
		   });	
		addAnnotation
		  (modelEndpointReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "modelEndpointType"
		   });	
		addAnnotation
		  (binaryMappingEClass, 
		   source, 
		   new String[] {
			 "constraints", "isBinaryMapping"
		   });	
		addAnnotation
		  (mappingReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "mappingType"
		   });	
		addAnnotation
		  (binaryMappingReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "isBinaryMappingRef binaryMappingType"
		   });	
		addAnnotation
		  (modelElementEndpointReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "modelElemEndpointType"
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
		  (binaryModelRelEClass, 
		   source, 
		   new String[] {
			 "isBinaryModelRel", "modelEndpoints->size() = 2"
		   });	
		addAnnotation
		  (extendibleElementReferenceEClass, 
		   source, 
		   new String[] {
			 "oneObject", "referencedObject.oclIsUndefined() xor containedObject.oclIsUndefined()"
		   });	
		addAnnotation
		  (getExtendibleElementReference_Object(), 
		   source, 
		   new String[] {
			 "derivation", "if containedObject.oclIsUndefined() then referencedObject else containedObject endif"
		   });	
		addAnnotation
		  (getExtendibleElementReference_Uri(), 
		   source, 
		   new String[] {
			 "derivation", "if object.oclIsUndefined() then null else object.uri endif"
		   });	
		addAnnotation
		  (getExtendibleElementEndpointReference_TargetUri(), 
		   source, 
		   new String[] {
			 "derivation", "object.oclAsType(mid::ExtendibleElementEndpoint).targetUri"
		   });	
		addAnnotation
		  (modelEndpointReferenceEClass, 
		   source, 
		   new String[] {
			 "modelEndpointType", "object.oclIsKindOf(mid::ModelEndpoint)"
		   });	
		addAnnotation
		  (binaryMappingEClass, 
		   source, 
		   new String[] {
			 "isBinaryMapping", "modelElemEndpoints->size() = 2"
		   });	
		addAnnotation
		  (mappingReferenceEClass, 
		   source, 
		   new String[] {
			 "mappingType", "object.oclIsKindOf(Mapping)"
		   });	
		addAnnotation
		  (binaryMappingReferenceEClass, 
		   source, 
		   new String[] {
			 "isBinaryMappingRef", "modelElemEndpointRefs->size() = 2",
			 "binaryMappingType", "object.oclIsKindOf(BinaryMapping)"
		   });	
		addAnnotation
		  (modelElementEndpointReferenceEClass, 
		   source, 
		   new String[] {
			 "modelElemEndpointType", "object.oclIsKindOf(ModelElementEndpoint)"
		   });
	}

} //RelationshipPackageImpl
