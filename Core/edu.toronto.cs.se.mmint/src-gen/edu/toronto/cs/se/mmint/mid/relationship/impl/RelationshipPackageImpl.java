/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mavo.MavoPackage;
import edu.toronto.cs.se.mmint.mavo.impl.MavoPackageImpl;
import edu.toronto.cs.se.mmint.mid.MidPackage;
import edu.toronto.cs.se.mmint.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmint.mid.editor.impl.EditorPackageImpl;
import edu.toronto.cs.se.mmint.mid.impl.MidPackageImpl;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.util.RelationshipValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
	private EClass modelElementEndpointEClass = null;

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
	private EClass linkReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryLinkReferenceEClass = null;

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
		MidPackageImpl theMidPackage = (MidPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MidPackage.eNS_URI) instanceof MidPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MidPackage.eNS_URI) : MidPackage.eINSTANCE);
		EditorPackageImpl theEditorPackage = (EditorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) instanceof EditorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI) : EditorPackage.eINSTANCE);
		OperatorPackageImpl theOperatorPackage = (OperatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) instanceof OperatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) : OperatorPackage.eINSTANCE);
		MavoPackageImpl theMavoPackage = (MavoPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MavoPackage.eNS_URI) instanceof MavoPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MavoPackage.eNS_URI) : MavoPackage.eINSTANCE);

		// Create package meta-data objects
		theRelationshipPackage.createPackageContents();
		theMidPackage.createPackageContents();
		theEditorPackage.createPackageContents();
		theOperatorPackage.createPackageContents();
		theMavoPackage.createPackageContents();

		// Initialize created meta-data
		theRelationshipPackage.initializePackageContents();
		theMidPackage.initializePackageContents();
		theEditorPackage.initializePackageContents();
		theOperatorPackage.initializePackageContents();
		theMavoPackage.initializePackageContents();

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
	public EReference getModelRel_Links() {
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
	public EReference getModelRel_LinkRefs() {
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
	public EOperation getModelRel__CreateSubtype__String_boolean_String_String() {
		return modelRelEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CopySubtype__ModelRel() {
		return modelRelEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__DeleteType() {
		return modelRelEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CreateInstance__String_boolean_ModelOrigin_MultiModel() {
		return modelRelEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CreateInstanceAndEndpointsAndReferences__String_ModelOrigin_EList() {
		return modelRelEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__CopyMAVOInstance__ModelRel_MultiModel() {
		return modelRelEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__DeleteInstance() {
		return modelRelEClass.getEOperations().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__OpenType() {
		return modelRelEClass.getEOperations().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__OpenInstance() {
		return modelRelEClass.getEOperations().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__GetOutlineResourceTypes() {
		return modelRelEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelRel__GetOutlineResourceInstances() {
		return modelRelEClass.getEOperations().get(9);
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
	public EClass getLink() {
		return linkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_ModelElemEndpoints() {
		return (EReference)linkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLink_ModelElemEndpointRefs() {
		return (EReference)linkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLink__GetMetatype() {
		return linkEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLink__GetSupertype() {
		return linkEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLink__CreateTypeReference__LinkReference_boolean_ModelRel() {
		return linkEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLink__CreateSubtypeAndReference__LinkReference_String_boolean_ModelRel() {
		return linkEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLink__DeleteType() {
		return linkEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLink__CreateInstanceReference__ModelRel() {
		return linkEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLink__CreateInstanceAndReference__boolean_ModelRel() {
		return linkEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLink__CreateInstanceAndReferenceAndEndpointsAndReferences__boolean_EList() {
		return linkEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLink__DeleteInstance() {
		return linkEClass.getEOperations().get(8);
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
	public EOperation getBinaryLink__CreateTypeReference__LinkReference_boolean_ModelRel() {
		return binaryLinkEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryLink__CreateInstanceReference__ModelRel() {
		return binaryLinkEClass.getEOperations().get(1);
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
		return modelElementEndpointEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__GetTarget() {
		return modelElementEndpointEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__GetMetatype() {
		return modelElementEndpointEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__CreateTypeReference__ModelElementEndpointReference_ModelElementReference_boolean_boolean_LinkReference() {
		return modelElementEndpointEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__CreateSubtypeAndReference__String_ModelElementReference_boolean_LinkReference() {
		return modelElementEndpointEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__ReplaceSubtypeAndReference__ModelElementEndpointReference_ModelElementEndpointReference_String_ModelElementReference_LinkReference() {
		return modelElementEndpointEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__DeleteType__boolean() {
		return modelElementEndpointEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__CreateInstanceReference__ModelElementReference_boolean_LinkReference() {
		return modelElementEndpointEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__CreateInstanceAndReference__ModelElementReference_boolean_LinkReference() {
		return modelElementEndpointEClass.getEOperations().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getModelElementEndpoint__ReplaceInstanceAndReference__ModelElementEndpointReference_ModelElementReference() {
		return modelElementEndpointEClass.getEOperations().get(9);
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
	public EClass getLinkReference() {
		return linkReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkReference_ModelElemEndpointRefs() {
		return (EReference)linkReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkReference__GetObject() {
		return linkReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkReference__GetSupertypeRef() {
		return linkReferenceEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkReference__DeleteTypeReference() {
		return linkReferenceEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkReference__DeleteTypeAndReference() {
		return linkReferenceEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkReference__DeleteInstanceReference() {
		return linkReferenceEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getLinkReference__DeleteInstanceAndReference() {
		return linkReferenceEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryLinkReference() {
		return binaryLinkReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryLinkReference_SourceModelElemRef() {
		return (EReference)binaryLinkReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryLinkReference_TargetModelElemRef() {
		return (EReference)binaryLinkReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryLinkReference__GetObject() {
		return binaryLinkReferenceEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBinaryLinkReference__AddModelElementTypeReference__ModelElementReference_boolean() {
		return binaryLinkReferenceEClass.getEOperations().get(1);
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
		createEReference(modelRelEClass, MODEL_REL__LINKS);
		createEReference(modelRelEClass, MODEL_REL__MODEL_ENDPOINT_REFS);
		createEReference(modelRelEClass, MODEL_REL__LINK_REFS);
		createEOperation(modelRelEClass, MODEL_REL___GET_METATYPE);
		createEOperation(modelRelEClass, MODEL_REL___GET_SUPERTYPE);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_SUBTYPE__STRING_BOOLEAN_STRING_STRING);
		createEOperation(modelRelEClass, MODEL_REL___COPY_SUBTYPE__MODELREL);
		createEOperation(modelRelEClass, MODEL_REL___GET_OUTLINE_RESOURCE_TYPES);
		createEOperation(modelRelEClass, MODEL_REL___DELETE_TYPE);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_INSTANCE__STRING_BOOLEAN_MODELORIGIN_MULTIMODEL);
		createEOperation(modelRelEClass, MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS_AND_REFERENCES__STRING_MODELORIGIN_ELIST);
		createEOperation(modelRelEClass, MODEL_REL___COPY_MAVO_INSTANCE__MODELREL_MULTIMODEL);
		createEOperation(modelRelEClass, MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES);
		createEOperation(modelRelEClass, MODEL_REL___DELETE_INSTANCE);
		createEOperation(modelRelEClass, MODEL_REL___OPEN_TYPE);
		createEOperation(modelRelEClass, MODEL_REL___OPEN_INSTANCE);

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

		modelElementReferenceEClass = createEClass(MODEL_ELEMENT_REFERENCE);
		createEReference(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS);
		createEOperation(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE___GET_OBJECT);
		createEOperation(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF);
		createEOperation(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE);
		createEOperation(modelElementReferenceEClass, MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE);

		linkEClass = createEClass(LINK);
		createEReference(linkEClass, LINK__MODEL_ELEM_ENDPOINTS);
		createEReference(linkEClass, LINK__MODEL_ELEM_ENDPOINT_REFS);
		createEOperation(linkEClass, LINK___GET_METATYPE);
		createEOperation(linkEClass, LINK___GET_SUPERTYPE);
		createEOperation(linkEClass, LINK___CREATE_TYPE_REFERENCE__LINKREFERENCE_BOOLEAN_MODELREL);
		createEOperation(linkEClass, LINK___CREATE_SUBTYPE_AND_REFERENCE__LINKREFERENCE_STRING_BOOLEAN_MODELREL);
		createEOperation(linkEClass, LINK___DELETE_TYPE);
		createEOperation(linkEClass, LINK___CREATE_INSTANCE_REFERENCE__MODELREL);
		createEOperation(linkEClass, LINK___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL);
		createEOperation(linkEClass, LINK___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST);
		createEOperation(linkEClass, LINK___DELETE_INSTANCE);

		binaryLinkEClass = createEClass(BINARY_LINK);
		createEOperation(binaryLinkEClass, BINARY_LINK___CREATE_TYPE_REFERENCE__LINKREFERENCE_BOOLEAN_MODELREL);
		createEOperation(binaryLinkEClass, BINARY_LINK___CREATE_INSTANCE_REFERENCE__MODELREL);

		modelElementEndpointEClass = createEClass(MODEL_ELEMENT_ENDPOINT);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___GET_TARGET);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___GET_METATYPE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___CREATE_TYPE_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE_BOOLEAN_BOOLEAN_LINKREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODELELEMENTREFERENCE_BOOLEAN_LINKREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTENDPOINTREFERENCE_STRING_MODELELEMENTREFERENCE_LINKREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___DELETE_TYPE__BOOLEAN);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_LINKREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_LINKREFERENCE);
		createEOperation(modelElementEndpointEClass, MODEL_ELEMENT_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE);

		linkReferenceEClass = createEClass(LINK_REFERENCE);
		createEReference(linkReferenceEClass, LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS);
		createEOperation(linkReferenceEClass, LINK_REFERENCE___GET_OBJECT);
		createEOperation(linkReferenceEClass, LINK_REFERENCE___GET_SUPERTYPE_REF);
		createEOperation(linkReferenceEClass, LINK_REFERENCE___DELETE_TYPE_REFERENCE);
		createEOperation(linkReferenceEClass, LINK_REFERENCE___DELETE_TYPE_AND_REFERENCE);
		createEOperation(linkReferenceEClass, LINK_REFERENCE___DELETE_INSTANCE_REFERENCE);
		createEOperation(linkReferenceEClass, LINK_REFERENCE___DELETE_INSTANCE_AND_REFERENCE);

		binaryLinkReferenceEClass = createEClass(BINARY_LINK_REFERENCE);
		createEReference(binaryLinkReferenceEClass, BINARY_LINK_REFERENCE__SOURCE_MODEL_ELEM_REF);
		createEReference(binaryLinkReferenceEClass, BINARY_LINK_REFERENCE__TARGET_MODEL_ELEM_REF);
		createEOperation(binaryLinkReferenceEClass, BINARY_LINK_REFERENCE___GET_OBJECT);
		createEOperation(binaryLinkReferenceEClass, BINARY_LINK_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN);

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
		MidPackage theMidPackage = (MidPackage)EPackage.Registry.INSTANCE.getEPackage(MidPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		modelRelEClass.getESuperTypes().add(theMidPackage.getModel());
		binaryModelRelEClass.getESuperTypes().add(this.getModelRel());
		extendibleElementEndpointReferenceEClass.getESuperTypes().add(this.getExtendibleElementReference());
		modelEndpointReferenceEClass.getESuperTypes().add(this.getExtendibleElementEndpointReference());
		modelElementReferenceEClass.getESuperTypes().add(this.getExtendibleElementReference());
		linkEClass.getESuperTypes().add(theMidPackage.getExtendibleElement());
		binaryLinkEClass.getESuperTypes().add(this.getLink());
		modelElementEndpointEClass.getESuperTypes().add(theMidPackage.getExtendibleElementEndpoint());
		linkReferenceEClass.getESuperTypes().add(this.getExtendibleElementReference());
		binaryLinkReferenceEClass.getESuperTypes().add(this.getLinkReference());
		modelElementEndpointReferenceEClass.getESuperTypes().add(this.getExtendibleElementEndpointReference());

		// Initialize classes, features, and operations; add parameters
		initEClass(modelRelEClass, ModelRel.class, "ModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelRel_ModelEndpoints(), theMidPackage.getModelEndpoint(), null, "modelEndpoints", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_Links(), this.getLink(), null, "links", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_ModelEndpointRefs(), this.getModelEndpointReference(), null, "modelEndpointRefs", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModelRel_LinkRefs(), this.getLinkReference(), null, "linkRefs", null, 0, -1, ModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelRel__GetMetatype(), this.getModelRel(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelRel__GetSupertype(), theMidPackage.getModel(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getModelRel__CreateSubtype__String_boolean_String_String(), this.getModelRel(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "constraintImplementation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__CopySubtype__ModelRel(), this.getModelRel(), "copySubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "origModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__GetOutlineResourceTypes(), ecorePackage.getEResourceSet(), "getOutlineResourceTypes", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__CreateInstance__String_boolean_ModelOrigin_MultiModel(), this.getModelRel(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMidPackage.getModelOrigin(), "origin", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMidPackage.getMultiModel(), "containerMultiModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__CreateInstanceAndEndpointsAndReferences__String_ModelOrigin_EList(), this.getModelRel(), "createInstanceAndEndpointsAndReferences", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelRelUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMidPackage.getModelOrigin(), "origin", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMidPackage.getModel(), "targetModels", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__CopyMAVOInstance__ModelRel_MultiModel(), this.getModelRel(), "copyMAVOInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "origModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMidPackage.getMultiModel(), "containerMultiModel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__GetOutlineResourceInstances(), ecorePackage.getEResourceSet(), "getOutlineResourceInstances", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__OpenType(), null, "openType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelRel__OpenInstance(), null, "openInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		initEClass(binaryModelRelEClass, BinaryModelRel.class, "BinaryModelRel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryModelRel_SourceModel(), theMidPackage.getModel(), null, "sourceModel", null, 1, 1, BinaryModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryModelRel_TargetModel(), theMidPackage.getModel(), null, "targetModel", null, 1, 1, BinaryModelRel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getBinaryModelRel__AddModelType__Model_boolean(), null, "addModelType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMidPackage.getModel(), "modelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		initEClass(extendibleElementReferenceEClass, ExtendibleElementReference.class, "ExtendibleElementReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendibleElementReference_ReferencedObject(), theMidPackage.getExtendibleElement(), null, "referencedObject", null, 0, 1, ExtendibleElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendibleElementReference_ContainedObject(), theMidPackage.getExtendibleElement(), null, "containedObject", null, 0, 1, ExtendibleElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExtendibleElementReference_Object(), theMidPackage.getExtendibleElement(), null, "object", null, 1, 1, ExtendibleElementReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getExtendibleElementReference_SupertypeRef(), this.getExtendibleElementReference(), null, "supertypeRef", null, 0, 1, ExtendibleElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElementReference_Modifiable(), ecorePackage.getEBoolean(), "modifiable", null, 1, 1, ExtendibleElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendibleElementReference_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, ExtendibleElementReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(extendibleElementEndpointReferenceEClass, ExtendibleElementEndpointReference.class, "ExtendibleElementEndpointReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendibleElementEndpointReference_TargetUri(), ecorePackage.getEString(), "targetUri", null, 1, 1, ExtendibleElementEndpointReference.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEOperation(getExtendibleElementEndpointReference__GetObject(), theMidPackage.getExtendibleElementEndpoint(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getExtendibleElementEndpointReference__GetSupertypeRef(), this.getExtendibleElementEndpointReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelEndpointReferenceEClass, ModelEndpointReference.class, "ModelEndpointReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelEndpointReference_ModelElemRefs(), this.getModelElementReference(), null, "modelElemRefs", null, 0, -1, ModelEndpointReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelEndpointReference__GetObject(), theMidPackage.getModelEndpoint(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelEndpointReference__GetSupertypeRef(), this.getModelEndpointReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelEndpointReference__AcceptModelElementType__EObject(), ecorePackage.getEBoolean(), "acceptModelElementType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "metamodelObj", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelEndpointReference__DeleteTypeReference__boolean(), null, "deleteTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelEndpointReference__AcceptModelElementInstance__EObject(), theMidPackage.getModelElement(), "acceptModelElementInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "modelObj", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		initEClass(modelElementReferenceEClass, ModelElementReference.class, "ModelElementReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementReference_ModelElemEndpointRefs(), this.getModelElementEndpointReference(), this.getModelElementEndpointReference_ModelElemRef(), "modelElemEndpointRefs", null, 0, -1, ModelElementReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelElementReference__GetObject(), theMidPackage.getModelElement(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElementReference__GetSupertypeRef(), this.getModelElementReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelElementReference__DeleteTypeReference(), null, "deleteTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelElementReference__DeleteInstanceReference(), null, "deleteInstanceReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		initEClass(linkEClass, Link.class, "Link", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLink_ModelElemEndpoints(), this.getModelElementEndpoint(), null, "modelElemEndpoints", null, 0, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLink_ModelElemEndpointRefs(), this.getModelElementEndpointReference(), null, "modelElemEndpointRefs", null, 0, -1, Link.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getLink__GetMetatype(), this.getLink(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getLink__GetSupertype(), this.getLink(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getLink__CreateTypeReference__LinkReference_boolean_ModelRel(), this.getLinkReference(), "createTypeReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLinkReference(), "linkTypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isModifiable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getLink__CreateSubtypeAndReference__LinkReference_String_boolean_ModelRel(), this.getLinkReference(), "createSubtypeAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLinkReference(), "linkTypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newLinkTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getLink__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getLink__CreateInstanceReference__ModelRel(), this.getLinkReference(), "createInstanceReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getLink__CreateInstanceAndReference__boolean_ModelRel(), this.getLinkReference(), "createInstanceAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getLink__CreateInstanceAndReferenceAndEndpointsAndReferences__boolean_EList(), this.getLinkReference(), "createInstanceAndReferenceAndEndpointsAndReferences", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinary", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemRefs", 1, -1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getLink__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		initEClass(binaryLinkEClass, BinaryLink.class, "BinaryLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getBinaryLink__CreateTypeReference__LinkReference_boolean_ModelRel(), this.getLinkReference(), "createTypeReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLinkReference(), "linkTypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isModifiable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getBinaryLink__CreateInstanceReference__ModelRel(), this.getLinkReference(), "createInstanceReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		initEClass(modelElementEndpointEClass, ModelElementEndpoint.class, "ModelElementEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEOperation(getModelElementEndpoint__GetSupertype(), this.getModelElementEndpoint(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElementEndpoint__GetTarget(), theMidPackage.getModelElement(), "getTarget", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElementEndpoint__GetMetatype(), this.getModelElementEndpoint(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelElementEndpoint__CreateTypeReference__ModelElementEndpointReference_ModelElementReference_boolean_boolean_LinkReference(), this.getModelElementEndpointReference(), "createTypeReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementEndpointReference(), "modelElemTypeEndpointRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isModifiable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLinkReference(), "containerLinkTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__CreateSubtypeAndReference__String_ModelElementReference_boolean_LinkReference(), this.getModelElementEndpointReference(), "createSubtypeAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelElemTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLinkReference(), "containerLinkTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__ReplaceSubtypeAndReference__ModelElementEndpointReference_ModelElementEndpointReference_String_ModelElementReference_LinkReference(), null, "replaceSubtypeAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementEndpointReference(), "oldModelElemTypeEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementEndpointReference(), "modelElemTypeEndpointRef", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newModelElemTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLinkReference(), "containerLinkTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__DeleteType__boolean(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__CreateInstanceReference__ModelElementReference_boolean_LinkReference(), this.getModelElementEndpointReference(), "createInstanceReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLinkReference(), "containerLinkRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__CreateInstanceAndReference__ModelElementReference_boolean_LinkReference(), this.getModelElementEndpointReference(), "createInstanceAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getLinkReference(), "containerLinkRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelElementEndpoint__ReplaceInstanceAndReference__ModelElementEndpointReference_ModelElementReference(), null, "replaceInstanceAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementEndpointReference(), "oldModelElemEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "targetModelElemRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		initEClass(linkReferenceEClass, LinkReference.class, "LinkReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkReference_ModelElemEndpointRefs(), this.getModelElementEndpointReference(), null, "modelElemEndpointRefs", null, 0, -1, LinkReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getLinkReference__GetObject(), this.getLink(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getLinkReference__GetSupertypeRef(), this.getLinkReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getLinkReference__DeleteTypeReference(), null, "deleteTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getLinkReference__DeleteTypeAndReference(), null, "deleteTypeAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getLinkReference__DeleteInstanceReference(), null, "deleteInstanceReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getLinkReference__DeleteInstanceAndReference(), null, "deleteInstanceAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		initEClass(binaryLinkReferenceEClass, BinaryLinkReference.class, "BinaryLinkReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryLinkReference_SourceModelElemRef(), this.getModelElementReference(), null, "sourceModelElemRef", null, 1, 1, BinaryLinkReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryLinkReference_TargetModelElemRef(), this.getModelElementReference(), null, "targetModelElemRef", null, 1, 1, BinaryLinkReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBinaryLinkReference__GetObject(), this.getBinaryLink(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getBinaryLinkReference__AddModelElementTypeReference__ModelElementReference_boolean(), null, "addModelElementTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getModelElementReference(), "modelElemTypeRef", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		initEClass(modelElementEndpointReferenceEClass, ModelElementEndpointReference.class, "ModelElementEndpointReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementEndpointReference_ModelElemRef(), this.getModelElementReference(), this.getModelElementReference_ModelElemEndpointRefs(), "modelElemRef", null, 1, 1, ModelElementEndpointReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getModelElementEndpointReference__GetObject(), this.getModelElementEndpoint(), "getObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getModelElementEndpointReference__GetSupertypeRef(), this.getModelElementEndpointReference(), "getSupertypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getModelElementEndpointReference__DeleteTypeReference__boolean(), null, "deleteTypeReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelElementEndpointReference__DeleteTypeAndReference__boolean(), null, "deleteTypeAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

		op = initEOperation(getModelElementEndpointReference__DeleteInstanceAndReference__boolean(), null, "deleteInstanceAndReference", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMidPackage.getMMINTException());

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
		  (modelElementReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "modelElementType"
		   });													
		addAnnotation
		  (binaryLinkEClass, 
		   source, 
		   new String[] {
			 "constraints", "isBinaryLink"
		   });							
		addAnnotation
		  (linkReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "linkType"
		   });							
		addAnnotation
		  (binaryLinkReferenceEClass, 
		   source, 
		   new String[] {
			 "constraints", "isBinaryLinkRef binaryLinkType"
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
		  (modelElementReferenceEClass, 
		   source, 
		   new String[] {
			 "modelElementType", "object.oclIsKindOf(mid::ModelElement)"
		   });												
		addAnnotation
		  (binaryLinkEClass, 
		   source, 
		   new String[] {
			 "isBinaryLink", "modelElemEndpoints->size() = 2"
		   });								
		addAnnotation
		  (linkReferenceEClass, 
		   source, 
		   new String[] {
			 "linkType", "object.oclIsKindOf(Link)"
		   });							
		addAnnotation
		  (binaryLinkReferenceEClass, 
		   source, 
		   new String[] {
			 "isBinaryLinkRef", "modelElemEndpointRefs->size() = 2",
			 "binaryLinkType", "object.oclIsKindOf(BinaryLink)"
		   });							
		addAnnotation
		  (modelElementEndpointReferenceEClass, 
		   source, 
		   new String[] {
			 "modelElemEndpointType", "object.oclIsKindOf(ModelElementEndpoint)"
		   });			
	}

} //RelationshipPackageImpl
