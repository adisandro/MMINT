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
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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
    super(RelationshipPackage.eNS_URI, RelationshipFactory.eINSTANCE);
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
    if (RelationshipPackageImpl.isInited) {
      return (RelationshipPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredRelationshipPackage = EPackage.Registry.INSTANCE.get(RelationshipPackage.eNS_URI);
    var theRelationshipPackage = registeredRelationshipPackage instanceof RelationshipPackageImpl r ? r : new RelationshipPackageImpl();

    RelationshipPackageImpl.isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);
    var theMIDPackage = (MIDPackageImpl)(registeredPackage instanceof MIDPackageImpl ? registeredPackage : MIDPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);
    var theEditorPackage = (EditorPackageImpl)(registeredPackage instanceof EditorPackageImpl ? registeredPackage : EditorPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);
    var theOperatorPackage = (OperatorPackageImpl)(registeredPackage instanceof OperatorPackageImpl ? registeredPackage : OperatorPackage.eINSTANCE);

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
    @Override
    public EClass getModelRel() {
    return this.modelRelEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModelRel_ModelEndpoints() {
    return (EReference)this.modelRelEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModelRel_Mappings() {
    return (EReference)this.modelRelEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModelRel_ModelEndpointRefs() {
    return (EReference)this.modelRelEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModelRel_MappingRefs() {
    return (EReference)this.modelRelEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__GetMetatype() {
    return this.modelRelEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__GetSupertype() {
    return this.modelRelEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__GetMIDContainer() {
    return this.modelRelEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__CreateBinarySubtype__String_boolean() {
    return this.modelRelEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__CopySubtype__ModelRel() {
    return this.modelRelEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__GetOutlineResourceTypes() {
    return this.modelRelEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__CreateInstanceAndEndpoints__EObject_String_EList_MID() {
    return this.modelRelEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__CreateBinaryInstance__EObject_String_MID() {
    return this.modelRelEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__CreateBinaryInstanceAndEndpoints__EObject_String_Model_Model_MID() {
    return this.modelRelEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__GetOutlineResourceInstances() {
    return this.modelRelEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__CreateWorkflowInstanceAndEndpoints__String_EList_MID() {
    return this.modelRelEClass.getEOperations().get(10);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__CreateWorkflowBinaryInstance__String_MID() {
    return this.modelRelEClass.getEOperations().get(11);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelRel__CreateWorkflowBinaryInstanceAndEndpoints__String_Model_Model_MID() {
    return this.modelRelEClass.getEOperations().get(12);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getBinaryModelRel() {
    return this.binaryModelRelEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getBinaryModelRel_SourceModel() {
    return (EReference)this.binaryModelRelEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getBinaryModelRel_TargetModel() {
    return (EReference)this.binaryModelRelEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getBinaryModelRel__AddModelType__Model_boolean() {
    return this.binaryModelRelEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModelEndpointReference() {
    return this.modelEndpointReferenceEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModelEndpointReference_ModelElemRefs() {
    return (EReference)this.modelEndpointReferenceEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpointReference__GetObject() {
    return this.modelEndpointReferenceEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpointReference__GetSupertypeRef() {
    return this.modelEndpointReferenceEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpointReference__AcceptModelElementType__EObject() {
    return this.modelEndpointReferenceEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpointReference__DeleteTypeReference__boolean() {
    return this.modelEndpointReferenceEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpointReference__AcceptModelElementInstance__EObject() {
    return this.modelEndpointReferenceEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String() {
    return this.modelEndpointReferenceEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModelElementReference() {
    return this.modelElementReferenceEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModelElementReference_ModelElemEndpointRefs() {
    return (EReference)this.modelElementReferenceEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementReference__GetObject() {
    return this.modelElementReferenceEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementReference__GetSupertypeRef() {
    return this.modelElementReferenceEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementReference__DeleteTypeReference() {
    return this.modelElementReferenceEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementReference__DeleteInstanceReference() {
    return this.modelElementReferenceEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getMapping() {
    return this.mappingEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMapping_ModelElemEndpoints() {
    return (EReference)this.mappingEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMapping_ModelElemEndpointRefs() {
    return (EReference)this.mappingEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__GetMetatype() {
    return this.mappingEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__GetSupertype() {
    return this.mappingEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__GetMIDContainer() {
    return this.mappingEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__CreateTypeReference__MappingReference_boolean_ModelRel() {
    return this.mappingEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__CreateSubtypeAndReference__MappingReference_String_boolean_ModelRel() {
    return this.mappingEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__DeleteType() {
    return this.mappingEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__CreateInstanceReference__ModelRel() {
    return this.mappingEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__CreateInstanceAndReference__boolean_ModelRel() {
    return this.mappingEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__CreateInstanceAndReferenceAndEndpointsAndReferences__boolean_EList() {
    return this.mappingEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMapping__DeleteInstance() {
    return this.mappingEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getBinaryMapping() {
    return this.binaryMappingEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModelElementEndpoint() {
    return this.modelElementEndpointEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__GetSupertype() {
    return this.modelElementEndpointEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__GetMIDContainer() {
    return this.modelElementEndpointEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__GetTarget() {
    return this.modelElementEndpointEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__GetMetatype() {
    return this.modelElementEndpointEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__CreateTypeReference__ModelElementEndpointReference_ModelElementReference_boolean_boolean_MappingReference() {
    return this.modelElementEndpointEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__CreateSubtypeAndReference__String_ModelElementReference_boolean_MappingReference() {
    return this.modelElementEndpointEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__ReplaceSubtypeAndReference__ModelElementEndpointReference_String_ModelElementReference() {
    return this.modelElementEndpointEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__DeleteType__boolean() {
    return this.modelElementEndpointEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__CreateInstanceReference__ModelElementReference_MappingReference() {
    return this.modelElementEndpointEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__CreateInstanceAndReference__ModelElementReference_MappingReference() {
    return this.modelElementEndpointEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpoint__ReplaceInstanceAndReference__ModelElementEndpointReference_ModelElementReference() {
    return this.modelElementEndpointEClass.getEOperations().get(10);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getMappingReference() {
    return this.mappingReferenceEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMappingReference_ModelElemEndpointRefs() {
    return (EReference)this.mappingReferenceEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMappingReference__GetObject() {
    return this.mappingReferenceEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMappingReference__GetSupertypeRef() {
    return this.mappingReferenceEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMappingReference__DeleteTypeReference() {
    return this.mappingReferenceEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMappingReference__DeleteTypeAndReference() {
    return this.mappingReferenceEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMappingReference__DeleteInstanceReference() {
    return this.mappingReferenceEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMappingReference__DeleteInstanceAndReference() {
    return this.mappingReferenceEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getBinaryMappingReference() {
    return this.binaryMappingReferenceEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getBinaryMappingReference_SourceModelElemRef() {
    return (EReference)this.binaryMappingReferenceEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getBinaryMappingReference_TargetModelElemRef() {
    return (EReference)this.binaryMappingReferenceEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getBinaryMappingReference__GetObject() {
    return this.binaryMappingReferenceEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getBinaryMappingReference__AddModelElementTypeReference__ModelElementReference_boolean() {
    return this.binaryMappingReferenceEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getExtendibleElementReference() {
    return this.extendibleElementReferenceEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getExtendibleElementReference_ReferencedObject() {
    return (EReference)this.extendibleElementReferenceEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getExtendibleElementReference_ContainedObject() {
    return (EReference)this.extendibleElementReferenceEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getExtendibleElementReference_SupertypeRef() {
    return (EReference)this.extendibleElementReferenceEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElementReference_Modifiable() {
    return (EAttribute)this.extendibleElementReferenceEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementReference__GetUri() {
    return this.extendibleElementReferenceEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementReference__GetObject() {
    return this.extendibleElementReferenceEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementReference__GetMIDContainer() {
    return this.extendibleElementReferenceEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementReference__IsTypesLevel() {
    return this.extendibleElementReferenceEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementReference__IsInstancesLevel() {
    return this.extendibleElementReferenceEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementReference__IsWorkflowsLevel() {
    return this.extendibleElementReferenceEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getExtendibleElementEndpointReference() {
    return this.extendibleElementEndpointReferenceEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementEndpointReference__GetObject() {
    return this.extendibleElementEndpointReferenceEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementEndpointReference__GetSupertypeRef() {
    return this.extendibleElementEndpointReferenceEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementEndpointReference__GetTargetUri() {
    return this.extendibleElementEndpointReferenceEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModelElementEndpointReference() {
    return this.modelElementEndpointReferenceEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModelElementEndpointReference_ModelElemRef() {
    return (EReference)this.modelElementEndpointReferenceEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpointReference__GetObject() {
    return this.modelElementEndpointReferenceEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpointReference__GetSupertypeRef() {
    return this.modelElementEndpointReferenceEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpointReference__DeleteTypeReference__boolean() {
    return this.modelElementEndpointReferenceEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpointReference__DeleteTypeAndReference__boolean() {
    return this.modelElementEndpointReferenceEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElementEndpointReference__DeleteInstanceAndReference__boolean() {
    return this.modelElementEndpointReferenceEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
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
    if (this.isCreated) {
      return;
    }
    this.isCreated = true;

    // Create classes and their features
    this.modelRelEClass = createEClass(RelationshipPackage.MODEL_REL);
    createEReference(this.modelRelEClass, RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS);
    createEReference(this.modelRelEClass, RelationshipPackage.MODEL_REL__MAPPINGS);
    createEReference(this.modelRelEClass, RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS);
    createEReference(this.modelRelEClass, RelationshipPackage.MODEL_REL__MAPPING_REFS);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___GET_METATYPE);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___GET_SUPERTYPE);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___GET_MID_CONTAINER);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___CREATE_BINARY_SUBTYPE__STRING_BOOLEAN);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___COPY_SUBTYPE__MODELREL);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___GET_OUTLINE_RESOURCE_TYPES);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___CREATE_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_ELIST_MID);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE__EOBJECT_STRING_MID);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___CREATE_BINARY_INSTANCE_AND_ENDPOINTS__EOBJECT_STRING_MODEL_MODEL_MID);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___GET_OUTLINE_RESOURCE_INSTANCES);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_INSTANCE_AND_ENDPOINTS__STRING_ELIST_MID);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE__STRING_MID);
    createEOperation(this.modelRelEClass, RelationshipPackage.MODEL_REL___CREATE_WORKFLOW_BINARY_INSTANCE_AND_ENDPOINTS__STRING_MODEL_MODEL_MID);

    this.binaryModelRelEClass = createEClass(RelationshipPackage.BINARY_MODEL_REL);
    createEReference(this.binaryModelRelEClass, RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL);
    createEReference(this.binaryModelRelEClass, RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL);
    createEOperation(this.binaryModelRelEClass, RelationshipPackage.BINARY_MODEL_REL___ADD_MODEL_TYPE__MODEL_BOOLEAN);

    this.extendibleElementReferenceEClass = createEClass(RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE);
    createEReference(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__REFERENCED_OBJECT);
    createEReference(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__CONTAINED_OBJECT);
    createEReference(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__SUPERTYPE_REF);
    createEAttribute(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE__MODIFIABLE);
    createEOperation(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_URI);
    createEOperation(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT);
    createEOperation(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_MID_CONTAINER);
    createEOperation(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___IS_TYPES_LEVEL);
    createEOperation(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___IS_INSTANCES_LEVEL);
    createEOperation(this.extendibleElementReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___IS_WORKFLOWS_LEVEL);

    this.extendibleElementEndpointReferenceEClass = createEClass(RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE);
    createEOperation(this.extendibleElementEndpointReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT);
    createEOperation(this.extendibleElementEndpointReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF);
    createEOperation(this.extendibleElementEndpointReferenceEClass, RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_TARGET_URI);

    this.modelEndpointReferenceEClass = createEClass(RelationshipPackage.MODEL_ENDPOINT_REFERENCE);
    createEReference(this.modelEndpointReferenceEClass, RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS);
    createEOperation(this.modelEndpointReferenceEClass, RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_OBJECT);
    createEOperation(this.modelEndpointReferenceEClass, RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF);
    createEOperation(this.modelEndpointReferenceEClass, RelationshipPackage.MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT);
    createEOperation(this.modelEndpointReferenceEClass, RelationshipPackage.MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN);
    createEOperation(this.modelEndpointReferenceEClass, RelationshipPackage.MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT);
    createEOperation(this.modelEndpointReferenceEClass, RelationshipPackage.MODEL_ENDPOINT_REFERENCE___CREATE_MODEL_ELEMENT_INSTANCE_AND_REFERENCE__EOBJECT_STRING);

    this.modelElementReferenceEClass = createEClass(RelationshipPackage.MODEL_ELEMENT_REFERENCE);
    createEReference(this.modelElementReferenceEClass, RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS);
    createEOperation(this.modelElementReferenceEClass, RelationshipPackage.MODEL_ELEMENT_REFERENCE___GET_OBJECT);
    createEOperation(this.modelElementReferenceEClass, RelationshipPackage.MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF);
    createEOperation(this.modelElementReferenceEClass, RelationshipPackage.MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE);
    createEOperation(this.modelElementReferenceEClass, RelationshipPackage.MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE);

    this.mappingEClass = createEClass(RelationshipPackage.MAPPING);
    createEReference(this.mappingEClass, RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINTS);
    createEReference(this.mappingEClass, RelationshipPackage.MAPPING__MODEL_ELEM_ENDPOINT_REFS);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___GET_METATYPE);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___GET_SUPERTYPE);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___GET_MID_CONTAINER);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___CREATE_TYPE_REFERENCE__MAPPINGREFERENCE_BOOLEAN_MODELREL);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___CREATE_SUBTYPE_AND_REFERENCE__MAPPINGREFERENCE_STRING_BOOLEAN_MODELREL);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___DELETE_TYPE);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___CREATE_INSTANCE_REFERENCE__MODELREL);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___CREATE_INSTANCE_AND_REFERENCE__BOOLEAN_MODELREL);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___CREATE_INSTANCE_AND_REFERENCE_AND_ENDPOINTS_AND_REFERENCES__BOOLEAN_ELIST);
    createEOperation(this.mappingEClass, RelationshipPackage.MAPPING___DELETE_INSTANCE);

    this.binaryMappingEClass = createEClass(RelationshipPackage.BINARY_MAPPING);

    this.modelElementEndpointEClass = createEClass(RelationshipPackage.MODEL_ELEMENT_ENDPOINT);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_METATYPE);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_SUPERTYPE);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_MID_CONTAINER);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___GET_TARGET);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_TYPE_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE_BOOLEAN_BOOLEAN_MAPPINGREFERENCE);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_SUBTYPE_AND_REFERENCE__STRING_MODELELEMENTREFERENCE_BOOLEAN_MAPPINGREFERENCE);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___REPLACE_SUBTYPE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_STRING_MODELELEMENTREFERENCE);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___DELETE_TYPE__BOOLEAN);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___CREATE_INSTANCE_AND_REFERENCE__MODELELEMENTREFERENCE_MAPPINGREFERENCE);
    createEOperation(this.modelElementEndpointEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT___REPLACE_INSTANCE_AND_REFERENCE__MODELELEMENTENDPOINTREFERENCE_MODELELEMENTREFERENCE);

    this.mappingReferenceEClass = createEClass(RelationshipPackage.MAPPING_REFERENCE);
    createEReference(this.mappingReferenceEClass, RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS);
    createEOperation(this.mappingReferenceEClass, RelationshipPackage.MAPPING_REFERENCE___GET_OBJECT);
    createEOperation(this.mappingReferenceEClass, RelationshipPackage.MAPPING_REFERENCE___GET_SUPERTYPE_REF);
    createEOperation(this.mappingReferenceEClass, RelationshipPackage.MAPPING_REFERENCE___DELETE_TYPE_REFERENCE);
    createEOperation(this.mappingReferenceEClass, RelationshipPackage.MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE);
    createEOperation(this.mappingReferenceEClass, RelationshipPackage.MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE);
    createEOperation(this.mappingReferenceEClass, RelationshipPackage.MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE);

    this.binaryMappingReferenceEClass = createEClass(RelationshipPackage.BINARY_MAPPING_REFERENCE);
    createEReference(this.binaryMappingReferenceEClass, RelationshipPackage.BINARY_MAPPING_REFERENCE__SOURCE_MODEL_ELEM_REF);
    createEReference(this.binaryMappingReferenceEClass, RelationshipPackage.BINARY_MAPPING_REFERENCE__TARGET_MODEL_ELEM_REF);
    createEOperation(this.binaryMappingReferenceEClass, RelationshipPackage.BINARY_MAPPING_REFERENCE___GET_OBJECT);
    createEOperation(this.binaryMappingReferenceEClass, RelationshipPackage.BINARY_MAPPING_REFERENCE___ADD_MODEL_ELEMENT_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN);

    this.modelElementEndpointReferenceEClass = createEClass(RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE);
    createEReference(this.modelElementEndpointReferenceEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF);
    createEOperation(this.modelElementEndpointReferenceEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT);
    createEOperation(this.modelElementEndpointReferenceEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF);
    createEOperation(this.modelElementEndpointReferenceEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN);
    createEOperation(this.modelElementEndpointReferenceEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_AND_REFERENCE__BOOLEAN);
    createEOperation(this.modelElementEndpointReferenceEClass, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN);
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
    if (this.isInitialized) {
      return;
    }
    this.isInitialized = true;

    // Initialize package
    setName(RelationshipPackage.eNAME);
    setNsPrefix(RelationshipPackage.eNS_PREFIX);
    setNsURI(RelationshipPackage.eNS_URI);

    // Obtain other dependent packages
    var theMIDPackage = (MIDPackage)EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.modelRelEClass.getESuperTypes().add(theMIDPackage.getModel());
    this.binaryModelRelEClass.getESuperTypes().add(this.getModelRel());
    this.extendibleElementEndpointReferenceEClass.getESuperTypes().add(this.getExtendibleElementReference());
    this.modelEndpointReferenceEClass.getESuperTypes().add(this.getExtendibleElementEndpointReference());
    this.modelElementReferenceEClass.getESuperTypes().add(this.getExtendibleElementReference());
    this.mappingEClass.getESuperTypes().add(theMIDPackage.getExtendibleElement());
    this.binaryMappingEClass.getESuperTypes().add(this.getMapping());
    this.modelElementEndpointEClass.getESuperTypes().add(theMIDPackage.getExtendibleElementEndpoint());
    this.mappingReferenceEClass.getESuperTypes().add(this.getExtendibleElementReference());
    this.binaryMappingReferenceEClass.getESuperTypes().add(this.getMappingReference());
    this.modelElementEndpointReferenceEClass.getESuperTypes().add(this.getExtendibleElementEndpointReference());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.modelRelEClass, ModelRel.class, "ModelRel", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelRel_ModelEndpoints(), theMIDPackage.getModelEndpoint(), null, "modelEndpoints", null, 0, -1, ModelRel.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getModelRel_Mappings(), this.getMapping(), null, "mappings", null, 0, -1, ModelRel.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getModelRel_ModelEndpointRefs(), this.getModelEndpointReference(), null, "modelEndpointRefs", null, 0, -1, ModelRel.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getModelRel_MappingRefs(), this.getMappingReference(), null, "mappingRefs", null, 0, -1, ModelRel.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getModelRel__GetMetatype(), this.getModelRel(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelRel__GetSupertype(), theMIDPackage.getModel(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelRel__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    var op = initEOperation(getModelRel__CreateBinarySubtype__String_boolean(), this.getBinaryModelRel(), "createBinarySubtype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelRelTypeName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isMetamodelExtension", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelRel__CopySubtype__ModelRel(), this.getModelRel(), "copySubtype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelRel(), "origModelRelType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelRel__GetOutlineResourceTypes(), this.ecorePackage.getEResourceSet(), "getOutlineResourceTypes", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelRel__CreateInstanceAndEndpoints__EObject_String_EList_MID(), this.getModelRel(), "createInstanceAndEndpoints", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEObject(), "rootModelRelObj", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelRelName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "endpointModels", 1, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelRel__CreateBinaryInstance__EObject_String_MID(), this.getBinaryModelRel(), "createBinaryInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEObject(), "rootModelRelObj", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelRelName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelRel__CreateBinaryInstanceAndEndpoints__EObject_String_Model_Model_MID(), this.getBinaryModelRel(), "createBinaryInstanceAndEndpoints", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEObject(), "rootModelRelObj", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelRelName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "endpointSourceModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "endpointTargetModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "instanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelRel__GetOutlineResourceInstances(), this.ecorePackage.getEResourceSet(), "getOutlineResourceInstances", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelRel__CreateWorkflowInstanceAndEndpoints__String_EList_MID(), this.getModelRel(), "createWorkflowInstanceAndEndpoints", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelRelId", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "endpointModels", 1, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelRel__CreateWorkflowBinaryInstance__String_MID(), this.getBinaryModelRel(), "createWorkflowBinaryInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelRelId", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelRel__CreateWorkflowBinaryInstanceAndEndpoints__String_Model_Model_MID(), this.getBinaryModelRel(), "createWorkflowBinaryInstanceAndEndpoints", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelRelId", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "endpointSourceModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "endpointTargetModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "workflowMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.binaryModelRelEClass, BinaryModelRel.class, "BinaryModelRel", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinaryModelRel_SourceModel(), theMIDPackage.getModel(), null, "sourceModel", null, 1, 1, BinaryModelRel.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getBinaryModelRel_TargetModel(), theMIDPackage.getModel(), null, "targetModel", null, 1, 1, BinaryModelRel.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    op = initEOperation(getBinaryModelRel__AddModelType__Model_boolean(), null, "addModelType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getModel(), "modelType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.extendibleElementReferenceEClass, ExtendibleElementReference.class, "ExtendibleElementReference", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExtendibleElementReference_ReferencedObject(), theMIDPackage.getExtendibleElement(), null, "referencedObject", null, 0, 1, ExtendibleElementReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getExtendibleElementReference_ContainedObject(), theMIDPackage.getExtendibleElement(), null, "containedObject", null, 0, 1, ExtendibleElementReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getExtendibleElementReference_SupertypeRef(), this.getExtendibleElementReference(), null, "supertypeRef", null, 0, 1, ExtendibleElementReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getExtendibleElementReference_Modifiable(), this.ecorePackage.getEBoolean(), "modifiable", null, 1, 1, ExtendibleElementReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementReference__GetUri(), this.ecorePackage.getEString(), "getUri", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementReference__GetObject(), theMIDPackage.getExtendibleElement(), "getObject", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementReference__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementReference__IsTypesLevel(), this.ecorePackage.getEBoolean(), "isTypesLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementReference__IsInstancesLevel(), this.ecorePackage.getEBoolean(), "isInstancesLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementReference__IsWorkflowsLevel(), this.ecorePackage.getEBoolean(), "isWorkflowsLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.extendibleElementEndpointReferenceEClass, ExtendibleElementEndpointReference.class, "ExtendibleElementEndpointReference", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getExtendibleElementEndpointReference__GetObject(), theMIDPackage.getExtendibleElementEndpoint(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementEndpointReference__GetSupertypeRef(), this.getExtendibleElementEndpointReference(), "getSupertypeRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementEndpointReference__GetTargetUri(), this.ecorePackage.getEString(), "getTargetUri", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.modelEndpointReferenceEClass, ModelEndpointReference.class, "ModelEndpointReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelEndpointReference_ModelElemRefs(), this.getModelElementReference(), null, "modelElemRefs", null, 0, -1, ModelEndpointReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getModelEndpointReference__GetObject(), theMIDPackage.getModelEndpoint(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelEndpointReference__GetSupertypeRef(), this.getModelEndpointReference(), "getSupertypeRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getModelEndpointReference__AcceptModelElementType__EObject(), this.ecorePackage.getEBoolean(), "acceptModelElementType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEObject(), "metamodelObj", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelEndpointReference__DeleteTypeReference__boolean(), null, "deleteTypeReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isFullDelete", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelEndpointReference__AcceptModelElementInstance__EObject(), theMIDPackage.getModelElement(), "acceptModelElementInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEObject(), "modelObj", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelEndpointReference__CreateModelElementInstanceAndReference__EObject_String(), this.getModelElementReference(), "createModelElementInstanceAndReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEObject(), "modelObj", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelElemName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.modelElementReferenceEClass, ModelElementReference.class, "ModelElementReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelElementReference_ModelElemEndpointRefs(), this.getModelElementEndpointReference(), this.getModelElementEndpointReference_ModelElemRef(), "modelElemEndpointRefs", null, 0, -1, ModelElementReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElementReference__GetObject(), theMIDPackage.getModelElement(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElementReference__GetSupertypeRef(), this.getModelElementReference(), "getSupertypeRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getModelElementReference__DeleteTypeReference(), null, "deleteTypeReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelElementReference__DeleteInstanceReference(), null, "deleteInstanceReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.mappingEClass, Mapping.class, "Mapping", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMapping_ModelElemEndpoints(), this.getModelElementEndpoint(), null, "modelElemEndpoints", null, 0, -1, Mapping.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getMapping_ModelElemEndpointRefs(), this.getModelElementEndpointReference(), null, "modelElemEndpointRefs", null, 0, -1, Mapping.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getMapping__GetMetatype(), this.getMapping(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getMapping__GetSupertype(), this.getMapping(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getMapping__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getMapping__CreateTypeReference__MappingReference_boolean_ModelRel(), this.getMappingReference(), "createTypeReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMappingReference(), "mappingTypeRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isModifiable", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelRel(), "containerModelRelType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMapping__CreateSubtypeAndReference__MappingReference_String_boolean_ModelRel(), this.getMappingReference(), "createSubtypeAndReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMappingReference(), "mappingTypeRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newMappingTypeName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isBinary", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelRel(), "containerModelRelType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMapping__DeleteType(), null, "deleteType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMapping__CreateInstanceReference__ModelRel(), this.getMappingReference(), "createInstanceReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelRel(), "containerModelRel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMapping__CreateInstanceAndReference__boolean_ModelRel(), this.getMappingReference(), "createInstanceAndReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isBinary", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelRel(), "containerModelRel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMapping__CreateInstanceAndReferenceAndEndpointsAndReferences__boolean_EList(), this.getMappingReference(), "createInstanceAndReferenceAndEndpointsAndReferences", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isBinary", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementReference(), "targetModelElemRefs", 1, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMapping__DeleteInstance(), null, "deleteInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.binaryMappingEClass, BinaryMapping.class, "BinaryMapping", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.modelElementEndpointEClass, ModelElementEndpoint.class, "ModelElementEndpoint", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getModelElementEndpoint__GetMetatype(), this.getModelElementEndpoint(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElementEndpoint__GetSupertype(), this.getModelElementEndpoint(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElementEndpoint__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElementEndpoint__GetTarget(), theMIDPackage.getModelElement(), "getTarget", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getModelElementEndpoint__CreateTypeReference__ModelElementEndpointReference_ModelElementReference_boolean_boolean_MappingReference(), this.getModelElementEndpointReference(), "createTypeReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementEndpointReference(), "modelElemTypeEndpointRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementReference(), "targetModelElemTypeRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isModifiable", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMappingReference(), "containerMappingTypeRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelElementEndpoint__CreateSubtypeAndReference__String_ModelElementReference_boolean_MappingReference(), this.getModelElementEndpointReference(), "createSubtypeAndReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelElemTypeEndpointName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementReference(), "targetModelElemTypeRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMappingReference(), "containerMappingTypeRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelElementEndpoint__ReplaceSubtypeAndReference__ModelElementEndpointReference_String_ModelElementReference(), null, "replaceSubtypeAndReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementEndpointReference(), "oldModelElemTypeEndpointRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelElemTypeEndpointName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementReference(), "targetModelElemTypeRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelElementEndpoint__DeleteType__boolean(), null, "deleteType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isFullDelete", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelElementEndpoint__CreateInstanceReference__ModelElementReference_MappingReference(), this.getModelElementEndpointReference(), "createInstanceReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementReference(), "targetModelElemRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMappingReference(), "containerMappingRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelElementEndpoint__CreateInstanceAndReference__ModelElementReference_MappingReference(), this.getModelElementEndpointReference(), "createInstanceAndReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementReference(), "targetModelElemRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMappingReference(), "containerMappingRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelElementEndpoint__ReplaceInstanceAndReference__ModelElementEndpointReference_ModelElementReference(), null, "replaceInstanceAndReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementEndpointReference(), "oldModelElemEndpointRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementReference(), "targetModelElemRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.mappingReferenceEClass, MappingReference.class, "MappingReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMappingReference_ModelElemEndpointRefs(), this.getModelElementEndpointReference(), null, "modelElemEndpointRefs", null, 0, -1, MappingReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getMappingReference__GetObject(), this.getMapping(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getMappingReference__GetSupertypeRef(), this.getMappingReference(), "getSupertypeRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getMappingReference__DeleteTypeReference(), null, "deleteTypeReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMappingReference__DeleteTypeAndReference(), null, "deleteTypeAndReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMappingReference__DeleteInstanceReference(), null, "deleteInstanceReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getMappingReference__DeleteInstanceAndReference(), null, "deleteInstanceAndReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.binaryMappingReferenceEClass, BinaryMappingReference.class, "BinaryMappingReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinaryMappingReference_SourceModelElemRef(), this.getModelElementReference(), null, "sourceModelElemRef", null, 1, 1, BinaryMappingReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getBinaryMappingReference_TargetModelElemRef(), this.getModelElementReference(), null, "targetModelElemRef", null, 1, 1, BinaryMappingReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getBinaryMappingReference__GetObject(), this.getBinaryMapping(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getBinaryMappingReference__AddModelElementTypeReference__ModelElementReference_boolean(), null, "addModelElementTypeReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelElementReference(), "modelElemTypeRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.modelElementEndpointReferenceEClass, ModelElementEndpointReference.class, "ModelElementEndpointReference", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelElementEndpointReference_ModelElemRef(), this.getModelElementReference(), this.getModelElementReference_ModelElemEndpointRefs(), "modelElemRef", null, 1, 1, ModelElementEndpointReference.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElementEndpointReference__GetObject(), this.getModelElementEndpoint(), "getObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElementEndpointReference__GetSupertypeRef(), this.getModelElementEndpointReference(), "getSupertypeRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getModelElementEndpointReference__DeleteTypeReference__boolean(), null, "deleteTypeReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isFullDelete", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelElementEndpointReference__DeleteTypeAndReference__boolean(), null, "deleteTypeAndReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isFullDelete", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getModelElementEndpointReference__DeleteInstanceAndReference__boolean(), null, "deleteInstanceAndReference", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isFullDelete", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());
  }

} //RelationshipPackageImpl
