/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.impl;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.ui.IEditorPart;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmint.mid.editor.impl.EditorPackageImpl;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MIDPackageImpl extends EPackageImpl implements MIDPackage {
    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass midEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass eStringToExtendibleElementMapEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass extendibleElementEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass extendibleElementEndpointEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass modelEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass extendibleElementConstraintEClass = null;

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
    private EClass modelEndpointEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass emfInfoEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass genericElementEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EEnum midLevelEEnum = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EEnum modelOriginEEnum = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EDataType mmintExceptionEDataType = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EDataType ioExceptionEDataType = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EDataType iStatusEDataType = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EDataType iValidationContextEDataType = null;

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType iEditorPartEDataType = null;

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
   * @see edu.toronto.cs.se.mmint.mid.MIDPackage#eNS_URI
   * @see #init()
   * @generated
   */
    private MIDPackageImpl() {
    super(MIDPackage.eNS_URI, MIDFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link MIDPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
    public static MIDPackage init() {
    if (MIDPackageImpl.isInited) return (MIDPackage)EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);

    // Obtain or create and register package
    var registeredMIDPackage = EPackage.Registry.INSTANCE.get(MIDPackage.eNS_URI);
    var theMIDPackage = registeredMIDPackage instanceof MIDPackageImpl ? (MIDPackageImpl)registeredMIDPackage : new MIDPackageImpl();

    MIDPackageImpl.isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    var theRelationshipPackage = (RelationshipPackageImpl)(registeredPackage instanceof RelationshipPackageImpl ? registeredPackage : RelationshipPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);
    var theEditorPackage = (EditorPackageImpl)(registeredPackage instanceof EditorPackageImpl ? registeredPackage : EditorPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);
    var theOperatorPackage = (OperatorPackageImpl)(registeredPackage instanceof OperatorPackageImpl ? registeredPackage : OperatorPackage.eINSTANCE);

    // Create package meta-data objects
    theMIDPackage.createPackageContents();
    theRelationshipPackage.createPackageContents();
    theEditorPackage.createPackageContents();
    theOperatorPackage.createPackageContents();

    // Initialize created meta-data
    theMIDPackage.initializePackageContents();
    theRelationshipPackage.initializePackageContents();
    theEditorPackage.initializePackageContents();
    theOperatorPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMIDPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MIDPackage.eNS_URI, theMIDPackage);
    return theMIDPackage;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getMID() {
    return this.midEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMID_Models() {
    return (EReference)this.midEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMID_Editors() {
    return (EReference)this.midEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMID_Operators() {
    return (EReference)this.midEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMID_ExtendibleTable() {
    return (EReference)this.midEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getMID_Level() {
    return (EAttribute)this.midEClass.getEStructuralFeatures().get(4);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMID_EMFInstanceResourceSet() {
    return (EAttribute)this.midEClass.getEStructuralFeatures().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__IsTypesLevel() {
    return this.midEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__IsInstancesLevel() {
    return this.midEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__IsWorkflowsLevel() {
    return this.midEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__GetExtendibleElement__String() {
    return this.midEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__GetModelRels() {
    return this.midEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getEStringToExtendibleElementMap() {
    return this.eStringToExtendibleElementMapEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEStringToExtendibleElementMap_Key() {
    return (EAttribute)this.eStringToExtendibleElementMapEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getEStringToExtendibleElementMap_Value() {
    return (EReference)this.eStringToExtendibleElementMapEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getExtendibleElement() {
    return this.extendibleElementEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getExtendibleElement_Supertype() {
    return (EReference)this.extendibleElementEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_Uri() {
    return (EAttribute)this.extendibleElementEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_Name() {
    return (EAttribute)this.extendibleElementEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_Level() {
    return (EAttribute)this.extendibleElementEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_MetatypeUri() {
    return (EAttribute)this.extendibleElementEClass.getEStructuralFeatures().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_Dynamic() {
    return (EAttribute)this.extendibleElementEClass.getEStructuralFeatures().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getExtendibleElement_Constraint() {
    return (EReference)this.extendibleElementEClass.getEStructuralFeatures().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__GetMetatype() {
    return this.extendibleElementEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__GetMIDContainer() {
    return this.extendibleElementEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__IsLevel__MIDLevel() {
    return this.extendibleElementEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__IsTypesLevel() {
    return this.extendibleElementEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__GetRuntimeTypes() {
    return this.extendibleElementEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__GetClosestTypeConstraint() {
    return this.extendibleElementEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ValidateInstanceType__ExtendibleElement() {
    return this.extendibleElementEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ValidateInstance() {
    return this.extendibleElementEClass.getEOperations().get(10);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ValidateInstanceInEditor__IValidationContext() {
    return this.extendibleElementEClass.getEOperations().get(11);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__IsWorkflowsLevel() {
    return this.extendibleElementEClass.getEOperations().get(12);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__UpdateWorkflowInstanceId__String() {
    return this.extendibleElementEClass.getEOperations().get(13);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ToMIDCustomPrintLabel() {
    return this.extendibleElementEClass.getEOperations().get(14);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ToMIDCustomEditLabel() {
    return this.extendibleElementEClass.getEOperations().get(15);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__UpdateMIDCustomLabel__String() {
    return this.extendibleElementEClass.getEOperations().get(16);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__CreateSubtypeUri__String_String() {
    return this.extendibleElementEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__AddTypeConstraint__String_String() {
    return this.extendibleElementEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__IsInstancesLevel() {
    return this.extendibleElementEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getExtendibleElementEndpoint() {
    return this.extendibleElementEndpointEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElementEndpoint_LowerBound() {
    return (EAttribute)this.extendibleElementEndpointEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElementEndpoint_UpperBound() {
    return (EAttribute)this.extendibleElementEndpointEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getExtendibleElementEndpoint_Target() {
    return (EReference)this.extendibleElementEndpointEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementEndpoint__GetMetatype() {
    return this.extendibleElementEndpointEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementEndpoint__GetSupertype() {
    return this.extendibleElementEndpointEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementEndpoint__GetTargetUri() {
    return this.extendibleElementEndpointEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModel() {
    return this.modelEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getModel_Origin() {
    return (EAttribute)this.modelEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getModel_FileExtension() {
    return (EAttribute)this.modelEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModel_Editors() {
    return (EReference)this.modelEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModel_ModelElems() {
    return (EReference)this.modelEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModel_ConversionOperators() {
    return (EReference)this.modelEClass.getEStructuralFeatures().get(4);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getModel_EMFInstanceResource() {
    return (EAttribute)this.modelEClass.getEStructuralFeatures().get(5);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModel_EMFInstanceRoot() {
    return (EReference)this.modelEClass.getEStructuralFeatures().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__GetMetatype() {
    return this.modelEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__GetSupertype() {
    return this.modelEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__GetMIDContainer() {
    return this.modelEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateSubtype__String_boolean() {
    return this.modelEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__DeleteType() {
    return this.modelEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__GetEMFTypeRoot() {
    return this.modelEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateInstance__EObject_String_MID() {
    return this.modelEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateInstanceEditor__boolean() {
    return this.modelEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateInstanceAndEditor__EObject_String_MID() {
    return this.modelEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__ImportInstance__String_MID() {
    return this.modelEClass.getEOperations().get(10);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__ImportInstanceAndEditor__String_MID() {
    return this.modelEClass.getEOperations().get(11);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CopyInstance__Model_String_MID() {
    return this.modelEClass.getEOperations().get(12);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CopyInstanceAndEditor__Model_String_boolean_MID() {
    return this.modelEClass.getEOperations().get(13);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__DeleteInstance() {
    return this.modelEClass.getEOperations().get(14);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__DeleteInstanceAndFile() {
    return this.modelEClass.getEOperations().get(15);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__OpenType() {
    return this.modelEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__OpenInstance() {
    return this.modelEClass.getEOperations().get(16);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateWorkflowInstance__String_MID() {
    return this.modelEClass.getEOperations().get(17);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__DeleteWorkflowInstance() {
    return this.modelEClass.getEOperations().get(18);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getExtendibleElementConstraint() {
    return this.extendibleElementConstraintEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElementConstraint_Implementation() {
    return (EAttribute)this.extendibleElementConstraintEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElementConstraint_Language() {
    return (EAttribute)this.extendibleElementConstraintEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModelElement() {
    return this.modelElementEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModelElement_EInfo() {
    return (EReference)this.modelElementEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelElement_EMFInstanceObject() {
    return (EReference)this.modelElementEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__GetMetatype() {
    return this.modelElementEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__GetSupertype() {
    return this.modelElementEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__GetMIDContainer() {
    return this.modelElementEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__CreateTypeReference__ModelElementReference_boolean_ModelEndpointReference() {
    return this.modelElementEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__CreateSubtypeAndReference__ModelElementReference_String_String_EMFInfo_ModelEndpointReference() {
    return this.modelElementEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__DeleteType() {
    return this.modelElementEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__GetEMFTypeObject() {
    return this.modelElementEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__CreateInstanceReference__ModelEndpointReference() {
    return this.modelElementEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__CreateInstanceAndReference__String_String_EMFInfo_ModelEndpointReference() {
    return this.modelElementEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__DeleteInstance() {
    return this.modelElementEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModelEndpoint() {
    return this.modelEndpointEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__GetSupertype() {
    return this.modelEndpointEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__GetMIDContainer() {
    return this.modelEndpointEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__GetTarget() {
    return this.modelEndpointEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__GetMetatype() {
    return this.modelEndpointEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateTypeReference__boolean_ModelRel() {
    return this.modelEndpointEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateSubtype__String_Model_boolean_ModelRel() {
    return this.modelEndpointEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__ReplaceSubtype__ModelEndpoint_String_Model() {
    return this.modelEndpointEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__DeleteType__boolean() {
    return this.modelEndpointEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateInstanceReference__ModelRel() {
    return this.modelEndpointEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateInstance__Model_ModelRel() {
    return this.modelEndpointEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateInstance__Model_Operator_String() {
    return this.modelEndpointEClass.getEOperations().get(10);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__ReplaceInstance__ModelEndpoint_Model() {
    return this.modelEndpointEClass.getEOperations().get(11);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__DeleteInstance__boolean() {
    return this.modelEndpointEClass.getEOperations().get(12);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateWorkflowInstance__Model_ModelRel() {
    return this.modelEndpointEClass.getEOperations().get(13);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateWorkflowInstance__Model_Operator_String() {
    return this.modelEndpointEClass.getEOperations().get(14);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__ReplaceWorkflowInstance__ModelEndpoint_Model() {
    return this.modelEndpointEClass.getEOperations().get(15);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__DeleteWorkflowInstance() {
    return this.modelEndpointEClass.getEOperations().get(16);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getEMFInfo() {
    return this.emfInfoEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEMFInfo_ClassName() {
    return (EAttribute)this.emfInfoEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEMFInfo_FeatureName() {
    return (EAttribute)this.emfInfoEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEMFInfo_Attribute() {
    return (EAttribute)this.emfInfoEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEMFInfo_RelatedClassName() {
    return (EAttribute)this.emfInfoEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEMFInfo__ToTypeString() {
    return this.emfInfoEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEMFInfo__ToInstanceString() {
    return this.emfInfoEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getGenericElement() {
    return this.genericElementEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getGenericElement_Abstract() {
    return (EAttribute)this.genericElementEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EEnum getMIDLevel() {
    return this.midLevelEEnum;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EEnum getModelOrigin() {
    return this.modelOriginEEnum;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getMMINTException() {
    return this.mmintExceptionEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getIOException() {
    return this.ioExceptionEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getIStatus() {
    return this.iStatusEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getIValidationContext() {
    return this.iValidationContextEDataType;
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDataType getIEditorPart() {
    return this.iEditorPartEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public MIDFactory getMIDFactory() {
    return (MIDFactory)getEFactoryInstance();
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
    this.midEClass = createEClass(MIDPackage.MID);
    createEReference(this.midEClass, MIDPackage.MID__MODELS);
    createEReference(this.midEClass, MIDPackage.MID__EDITORS);
    createEReference(this.midEClass, MIDPackage.MID__OPERATORS);
    createEReference(this.midEClass, MIDPackage.MID__EXTENDIBLE_TABLE);
    createEAttribute(this.midEClass, MIDPackage.MID__LEVEL);
    createEAttribute(this.midEClass, MIDPackage.MID__EMF_INSTANCE_RESOURCE_SET);
    createEOperation(this.midEClass, MIDPackage.MID___IS_TYPES_LEVEL);
    createEOperation(this.midEClass, MIDPackage.MID___IS_INSTANCES_LEVEL);
    createEOperation(this.midEClass, MIDPackage.MID___IS_WORKFLOWS_LEVEL);
    createEOperation(this.midEClass, MIDPackage.MID___GET_EXTENDIBLE_ELEMENT__STRING);
    createEOperation(this.midEClass, MIDPackage.MID___GET_MODEL_RELS);

    this.eStringToExtendibleElementMapEClass = createEClass(MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP);
    createEAttribute(this.eStringToExtendibleElementMapEClass, MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY);
    createEReference(this.eStringToExtendibleElementMapEClass, MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE);

    this.extendibleElementEClass = createEClass(MIDPackage.EXTENDIBLE_ELEMENT);
    createEReference(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT__SUPERTYPE);
    createEAttribute(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT__URI);
    createEAttribute(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT__NAME);
    createEAttribute(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT__LEVEL);
    createEAttribute(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT__METATYPE_URI);
    createEAttribute(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT__DYNAMIC);
    createEReference(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT__CONSTRAINT);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___GET_MID_CONTAINER);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___IS_LEVEL__MIDLEVEL);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___IS_TYPES_LEVEL);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___ADD_TYPE_CONSTRAINT__STRING_STRING);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___IS_INSTANCES_LEVEL);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___GET_RUNTIME_TYPES);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___GET_CLOSEST_TYPE_CONSTRAINT);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___IS_WORKFLOWS_LEVEL);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___UPDATE_WORKFLOW_INSTANCE_ID__STRING);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL);
    createEOperation(this.extendibleElementEClass, MIDPackage.EXTENDIBLE_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING);

    this.extendibleElementEndpointEClass = createEClass(MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT);
    createEAttribute(this.extendibleElementEndpointEClass, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND);
    createEAttribute(this.extendibleElementEndpointEClass, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND);
    createEReference(this.extendibleElementEndpointEClass, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET);
    createEOperation(this.extendibleElementEndpointEClass, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE);
    createEOperation(this.extendibleElementEndpointEClass, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE);
    createEOperation(this.extendibleElementEndpointEClass, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_TARGET_URI);

    this.modelEClass = createEClass(MIDPackage.MODEL);
    createEAttribute(this.modelEClass, MIDPackage.MODEL__ORIGIN);
    createEAttribute(this.modelEClass, MIDPackage.MODEL__FILE_EXTENSION);
    createEReference(this.modelEClass, MIDPackage.MODEL__EDITORS);
    createEReference(this.modelEClass, MIDPackage.MODEL__MODEL_ELEMS);
    createEReference(this.modelEClass, MIDPackage.MODEL__CONVERSION_OPERATORS);
    createEAttribute(this.modelEClass, MIDPackage.MODEL__EMF_INSTANCE_RESOURCE);
    createEReference(this.modelEClass, MIDPackage.MODEL__EMF_INSTANCE_ROOT);
    createEOperation(this.modelEClass, MIDPackage.MODEL___GET_METATYPE);
    createEOperation(this.modelEClass, MIDPackage.MODEL___GET_SUPERTYPE);
    createEOperation(this.modelEClass, MIDPackage.MODEL___GET_MID_CONTAINER);
    createEOperation(this.modelEClass, MIDPackage.MODEL___CREATE_SUBTYPE__STRING_BOOLEAN);
    createEOperation(this.modelEClass, MIDPackage.MODEL___DELETE_TYPE);
    createEOperation(this.modelEClass, MIDPackage.MODEL___GET_EMF_TYPE_ROOT);
    createEOperation(this.modelEClass, MIDPackage.MODEL___OPEN_TYPE);
    createEOperation(this.modelEClass, MIDPackage.MODEL___CREATE_INSTANCE__EOBJECT_STRING_MID);
    createEOperation(this.modelEClass, MIDPackage.MODEL___CREATE_INSTANCE_EDITOR__BOOLEAN);
    createEOperation(this.modelEClass, MIDPackage.MODEL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID);
    createEOperation(this.modelEClass, MIDPackage.MODEL___IMPORT_INSTANCE__STRING_MID);
    createEOperation(this.modelEClass, MIDPackage.MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID);
    createEOperation(this.modelEClass, MIDPackage.MODEL___COPY_INSTANCE__MODEL_STRING_MID);
    createEOperation(this.modelEClass, MIDPackage.MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID);
    createEOperation(this.modelEClass, MIDPackage.MODEL___DELETE_INSTANCE);
    createEOperation(this.modelEClass, MIDPackage.MODEL___DELETE_INSTANCE_AND_FILE);
    createEOperation(this.modelEClass, MIDPackage.MODEL___OPEN_INSTANCE);
    createEOperation(this.modelEClass, MIDPackage.MODEL___CREATE_WORKFLOW_INSTANCE__STRING_MID);
    createEOperation(this.modelEClass, MIDPackage.MODEL___DELETE_WORKFLOW_INSTANCE);

    this.extendibleElementConstraintEClass = createEClass(MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT);
    createEAttribute(this.extendibleElementConstraintEClass, MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION);
    createEAttribute(this.extendibleElementConstraintEClass, MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE);

    this.modelElementEClass = createEClass(MIDPackage.MODEL_ELEMENT);
    createEReference(this.modelElementEClass, MIDPackage.MODEL_ELEMENT__EINFO);
    createEReference(this.modelElementEClass, MIDPackage.MODEL_ELEMENT__EMF_INSTANCE_OBJECT);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___GET_METATYPE);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___GET_SUPERTYPE);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___GET_MID_CONTAINER);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___CREATE_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_MODELENDPOINTREFERENCE);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___DELETE_TYPE);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___GET_EMF_TYPE_OBJECT);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___CREATE_INSTANCE_REFERENCE__MODELENDPOINTREFERENCE);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE);
    createEOperation(this.modelElementEClass, MIDPackage.MODEL_ELEMENT___DELETE_INSTANCE);

    this.modelEndpointEClass = createEClass(MIDPackage.MODEL_ENDPOINT);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___GET_METATYPE);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___GET_SUPERTYPE);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___GET_MID_CONTAINER);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___GET_TARGET);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___CREATE_SUBTYPE__STRING_MODEL_BOOLEAN_MODELREL);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___REPLACE_SUBTYPE__MODELENDPOINT_STRING_MODEL);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___DELETE_TYPE__BOOLEAN);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_MODELREL);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_OPERATOR_STRING);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___REPLACE_INSTANCE__MODELENDPOINT_MODEL);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___DELETE_INSTANCE__BOOLEAN);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_MODELREL);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_OPERATOR_STRING);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___REPLACE_WORKFLOW_INSTANCE__MODELENDPOINT_MODEL);
    createEOperation(this.modelEndpointEClass, MIDPackage.MODEL_ENDPOINT___DELETE_WORKFLOW_INSTANCE);

    this.emfInfoEClass = createEClass(MIDPackage.EMF_INFO);
    createEAttribute(this.emfInfoEClass, MIDPackage.EMF_INFO__CLASS_NAME);
    createEAttribute(this.emfInfoEClass, MIDPackage.EMF_INFO__FEATURE_NAME);
    createEAttribute(this.emfInfoEClass, MIDPackage.EMF_INFO__ATTRIBUTE);
    createEAttribute(this.emfInfoEClass, MIDPackage.EMF_INFO__RELATED_CLASS_NAME);
    createEOperation(this.emfInfoEClass, MIDPackage.EMF_INFO___TO_TYPE_STRING);
    createEOperation(this.emfInfoEClass, MIDPackage.EMF_INFO___TO_INSTANCE_STRING);

    this.genericElementEClass = createEClass(MIDPackage.GENERIC_ELEMENT);
    createEAttribute(this.genericElementEClass, MIDPackage.GENERIC_ELEMENT__ABSTRACT);

    // Create enums
    this.midLevelEEnum = createEEnum(MIDPackage.MID_LEVEL);
    this.modelOriginEEnum = createEEnum(MIDPackage.MODEL_ORIGIN);

    // Create data types
    this.mmintExceptionEDataType = createEDataType(MIDPackage.MMINT_EXCEPTION);
    this.ioExceptionEDataType = createEDataType(MIDPackage.IO_EXCEPTION);
    this.iStatusEDataType = createEDataType(MIDPackage.ISTATUS);
    this.iValidationContextEDataType = createEDataType(MIDPackage.IVALIDATION_CONTEXT);
    this.iEditorPartEDataType = createEDataType(MIDPackage.IEDITOR_PART);
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
    setName(MIDPackage.eNAME);
    setNsPrefix(MIDPackage.eNS_PREFIX);
    setNsURI(MIDPackage.eNS_URI);

    // Obtain other dependent packages
    var theRelationshipPackage = (RelationshipPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    var theEditorPackage = (EditorPackage)EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);
    var theOperatorPackage = (OperatorPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);

    // Add subpackages
    getESubpackages().add(theRelationshipPackage);
    getESubpackages().add(theEditorPackage);
    getESubpackages().add(theOperatorPackage);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.extendibleElementEndpointEClass.getESuperTypes().add(this.getExtendibleElement());
    this.modelEClass.getESuperTypes().add(this.getGenericElement());
    this.modelElementEClass.getESuperTypes().add(this.getExtendibleElement());
    this.modelEndpointEClass.getESuperTypes().add(this.getExtendibleElementEndpoint());
    this.genericElementEClass.getESuperTypes().add(this.getExtendibleElement());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.midEClass, edu.toronto.cs.se.mmint.mid.MID.class, "MID", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMID_Models(), this.getModel(), null, "models", null, 0, -1, edu.toronto.cs.se.mmint.mid.MID.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getMID_Editors(), theEditorPackage.getEditor(), null, "editors", null, 0, -1, edu.toronto.cs.se.mmint.mid.MID.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getMID_Operators(), theOperatorPackage.getOperator(), null, "operators", null, 0, -1, edu.toronto.cs.se.mmint.mid.MID.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getMID_ExtendibleTable(), this.getEStringToExtendibleElementMap(), null, "extendibleTable", null, 0, -1, edu.toronto.cs.se.mmint.mid.MID.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getMID_Level(), this.getMIDLevel(), "level", null, 1, 1, edu.toronto.cs.se.mmint.mid.MID.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getMID_EMFInstanceResourceSet(), this.ecorePackage.getEResourceSet(), "EMFInstanceResourceSet", null, 0, 1, edu.toronto.cs.se.mmint.mid.MID.class, EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getMID__IsTypesLevel(), this.ecorePackage.getEBoolean(), "isTypesLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getMID__IsInstancesLevel(), this.ecorePackage.getEBoolean(), "isInstancesLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getMID__IsWorkflowsLevel(), this.ecorePackage.getEBoolean(), "isWorkflowsLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    var op = initEOperation(getMID__GetExtendibleElement__String(), null, "getExtendibleElement", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    var t1 = addETypeParameter(op, "T");
    var g1 = createEGenericType(this.getExtendibleElement());
    t1.getEBounds().add(g1);
    addEParameter(op, this.ecorePackage.getEString(), "uri", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    initEOperation(getMID__GetModelRels(), theRelationshipPackage.getModelRel(), "getModelRels", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.eStringToExtendibleElementMapEClass, Map.Entry.class, "EStringToExtendibleElementMap", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEStringToExtendibleElementMap_Key(), this.ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getEStringToExtendibleElementMap_Value(), this.getExtendibleElement(), null, "value", null, 1, 1, Map.Entry.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.extendibleElementEClass, ExtendibleElement.class, "ExtendibleElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExtendibleElement_Supertype(), this.getExtendibleElement(), null, "supertype", null, 0, 1, ExtendibleElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getExtendibleElement_Uri(), this.ecorePackage.getEString(), "uri", null, 1, 1, ExtendibleElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getExtendibleElement_Name(), this.ecorePackage.getEString(), "name", null, 1, 1, ExtendibleElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getExtendibleElement_Level(), this.getMIDLevel(), "level", null, 1, 1, ExtendibleElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getExtendibleElement_MetatypeUri(), this.ecorePackage.getEString(), "metatypeUri", null, 0, 1, ExtendibleElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getExtendibleElement_Dynamic(), this.ecorePackage.getEBoolean(), "dynamic", null, 1, 1, ExtendibleElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getExtendibleElement_Constraint(), this.getExtendibleElementConstraint(), null, "constraint", null, 0, 1, ExtendibleElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElement__GetMetatype(), this.getExtendibleElement(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElement__GetMIDContainer(), this.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getExtendibleElement__IsLevel__MIDLevel(), this.ecorePackage.getEBoolean(), "isLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMIDLevel(), "midLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElement__IsTypesLevel(), this.ecorePackage.getEBoolean(), "isTypesLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getExtendibleElement__CreateSubtypeUri__String_String(), this.ecorePackage.getEString(), "createSubtypeUri", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newTypeFragmentUri", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newTypeName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getExtendibleElement__AddTypeConstraint__String_String(), null, "addTypeConstraint", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "language", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "implementation", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEOperation(getExtendibleElement__IsInstancesLevel(), this.ecorePackage.getEBoolean(), "isInstancesLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getExtendibleElement__GetRuntimeTypes(), null, "getRuntimeTypes", 0, -1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    t1 = addETypeParameter(op, "T");
    g1 = createEGenericType(this.getExtendibleElement());
    t1.getEBounds().add(g1);
    addEException(op, this.getMMINTException());
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    op = initEOperation(getExtendibleElement__GetClosestTypeConstraint(), this.getExtendibleElementConstraint(), "getClosestTypeConstraint", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getExtendibleElement__ValidateInstanceType__ExtendibleElement(), this.ecorePackage.getEBoolean(), "validateInstanceType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getExtendibleElement(), "type", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theOperatorPackage.getException());

    op = initEOperation(getExtendibleElement__ValidateInstance(), this.ecorePackage.getEBoolean(), "validateInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theOperatorPackage.getException());

    op = initEOperation(getExtendibleElement__ValidateInstanceInEditor__IValidationContext(), this.getIStatus(), "validateInstanceInEditor", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getIValidationContext(), "context", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theOperatorPackage.getException());

    initEOperation(getExtendibleElement__IsWorkflowsLevel(), this.ecorePackage.getEBoolean(), "isWorkflowsLevel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getExtendibleElement__UpdateWorkflowInstanceId__String(), null, "updateWorkflowInstanceId", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newInstanceId", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEOperation(getExtendibleElement__ToMIDCustomPrintLabel(), this.ecorePackage.getEString(), "toMIDCustomPrintLabel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElement__ToMIDCustomEditLabel(), this.ecorePackage.getEString(), "toMIDCustomEditLabel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getExtendibleElement__UpdateMIDCustomLabel__String(), null, "updateMIDCustomLabel", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newLabel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.extendibleElementEndpointEClass, ExtendibleElementEndpoint.class, "ExtendibleElementEndpoint", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExtendibleElementEndpoint_LowerBound(), this.ecorePackage.getEInt(), "lowerBound", null, 1, 1, ExtendibleElementEndpoint.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getExtendibleElementEndpoint_UpperBound(), this.ecorePackage.getEInt(), "upperBound", null, 1, 1, ExtendibleElementEndpoint.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getExtendibleElementEndpoint_Target(), this.getExtendibleElement(), null, "target", null, 1, 1, ExtendibleElementEndpoint.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementEndpoint__GetMetatype(), this.getExtendibleElementEndpoint(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementEndpoint__GetSupertype(), this.getExtendibleElementEndpoint(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getExtendibleElementEndpoint__GetTargetUri(), this.ecorePackage.getEString(), "getTargetUri", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.modelEClass, Model.class, "Model", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModel_Origin(), this.getModelOrigin(), "origin", null, 1, 1, Model.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getModel_FileExtension(), this.ecorePackage.getEString(), "fileExtension", null, 1, 1, Model.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getModel_Editors(), theEditorPackage.getEditor(), null, "editors", null, 0, -1, Model.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getModel_ModelElems(), this.getModelElement(), null, "modelElems", null, 0, -1, Model.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getModel_ConversionOperators(), theOperatorPackage.getConversionOperator(), null, "conversionOperators", null, 0, -1, Model.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getModel_EMFInstanceResource(), this.ecorePackage.getEResource(), "EMFInstanceResource", null, 0, 1, Model.class, EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getModel_EMFInstanceRoot(), this.ecorePackage.getEObject(), null, "EMFInstanceRoot", null, 0, 1, Model.class, EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getModel__GetMetatype(), this.getModel(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModel__GetSupertype(), this.getModel(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModel__GetMIDContainer(), this.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getModel__CreateSubtype__String_boolean(), this.getModel(), "createSubtype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelTypeName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isMetamodelExtension", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__DeleteType(), null, "deleteType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__GetEMFTypeRoot(), this.ecorePackage.getEPackage(), "getEMFTypeRoot", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__OpenType(), null, "openType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theOperatorPackage.getException());

    op = initEOperation(getModel__CreateInstance__EObject_String_MID(), this.getModel(), "createInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEObject(), "rootModelObj", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelPath", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());
    addEException(op, this.getIOException());

    op = initEOperation(getModel__CreateInstanceEditor__boolean(), theEditorPackage.getEditor(), "createInstanceEditor", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "createEditorFile", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__CreateInstanceAndEditor__EObject_String_MID(), this.getModel(), "createInstanceAndEditor", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEObject(), "rootModelObj", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelPath", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());
    addEException(op, this.getIOException());

    op = initEOperation(getModel__ImportInstance__String_MID(), this.getModel(), "importInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "modelPath", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__ImportInstanceAndEditor__String_MID(), this.getModel(), "importInstanceAndEditor", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "modelPath", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__CopyInstance__Model_String_MID(), this.getModel(), "copyInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "origModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());
    addEException(op, this.getIOException());

    op = initEOperation(getModel__CopyInstanceAndEditor__Model_String_boolean_MID(), this.getModel(), "copyInstanceAndEditor", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "origModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "copyDiagram", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());
    addEException(op, this.getIOException());

    op = initEOperation(getModel__DeleteInstance(), null, "deleteInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__DeleteInstanceAndFile(), null, "deleteInstanceAndFile", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__OpenInstance(), this.getIEditorPart(), "openInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theOperatorPackage.getException());

    op = initEOperation(getModel__CreateWorkflowInstance__String_MID(), this.getModel(), "createWorkflowInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelId", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getMID(), "workflowMID", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__DeleteWorkflowInstance(), null, "deleteWorkflowInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEClass(this.extendibleElementConstraintEClass, ExtendibleElementConstraint.class, "ExtendibleElementConstraint", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExtendibleElementConstraint_Implementation(), this.ecorePackage.getEString(), "implementation", null, 1, 1, ExtendibleElementConstraint.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getExtendibleElementConstraint_Language(), this.ecorePackage.getEString(), "language", null, 1, 1, ExtendibleElementConstraint.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEClass(this.modelElementEClass, ModelElement.class, "ModelElement", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelElement_EInfo(), this.getEMFInfo(), null, "eInfo", null, 1, 1, ModelElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, EPackageImpl.IS_COMPOSITE, !EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEReference(getModelElement_EMFInstanceObject(), this.ecorePackage.getEObject(), null, "EMFInstanceObject", null, 0, 1, ModelElement.class, EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_COMPOSITE, EPackageImpl.IS_RESOLVE_PROXIES, !EPackageImpl.IS_UNSETTABLE, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElement__GetMetatype(), this.getModelElement(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElement__GetSupertype(), this.getModelElement(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelElement__GetMIDContainer(), this.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getModelElement__CreateTypeReference__ModelElementReference_boolean_ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createTypeReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelElementReference(), "modelElemTypeRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isModifiable", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelTypeEndpointRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__CreateSubtypeAndReference__ModelElementReference_String_String_EMFInfo_ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createSubtypeAndReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelElementReference(), "modelElemTypeRef", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelElemTypeUri", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelElemTypeName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getEMFInfo(), "eInfo", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelTypeEndpointRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__DeleteType(), null, "deleteType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__GetEMFTypeObject(), this.ecorePackage.getENamedElement(), "getEMFTypeObject", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__CreateInstanceReference__ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createInstanceReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelEndpointRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__CreateInstanceAndReference__String_String_EMFInfo_ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createInstanceAndReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelElemUri", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelElemName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getEMFInfo(), "eInfo", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelEndpointRef", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__DeleteInstance(), null, "deleteInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEClass(this.modelEndpointEClass, ModelEndpoint.class, "ModelEndpoint", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getModelEndpoint__GetMetatype(), this.getModelEndpoint(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelEndpoint__GetSupertype(), this.getModelEndpoint(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelEndpoint__GetMIDContainer(), this.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getModelEndpoint__GetTarget(), this.getModel(), "getTarget", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    op = initEOperation(getModelEndpoint__CreateTypeReference__boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createTypeReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isModifiable", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRelType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateSubtype__String_Model_boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createSubtype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelTypeEndpointName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModelType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRelType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__ReplaceSubtype__ModelEndpoint_String_Model(), null, "replaceSubtype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelEndpoint(), "oldModelTypeEndpoint", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newModelTypeEndpointName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModelType", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__DeleteType__boolean(), null, "deleteType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isFullDelete", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateInstanceReference__ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createInstanceReference", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateInstance__Model_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateInstance__Model_Operator_String(), this.getModelEndpoint(), "createInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theOperatorPackage.getOperator(), "containerOperator", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "containerFeatureName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__ReplaceInstance__ModelEndpoint_Model(), null, "replaceInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelEndpoint(), "oldModelEndpoint", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__DeleteInstance__boolean(), null, "deleteInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "isFullDelete", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateWorkflowInstance__Model_ModelRel(), this.getModelEndpoint(), "createWorkflowInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateWorkflowInstance__Model_Operator_String(), this.getModelEndpoint(), "createWorkflowInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theOperatorPackage.getOperator(), "containerOperator", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "containerFeatureName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__ReplaceWorkflowInstance__ModelEndpoint_Model(), null, "replaceWorkflowInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModelEndpoint(), "oldModelEndpoint", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__DeleteWorkflowInstance(), null, "deleteWorkflowInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEClass(this.emfInfoEClass, EMFInfo.class, "EMFInfo", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEMFInfo_ClassName(), this.ecorePackage.getEString(), "className", null, 1, 1, EMFInfo.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getEMFInfo_FeatureName(), this.ecorePackage.getEString(), "featureName", null, 0, 1, EMFInfo.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getEMFInfo_Attribute(), this.ecorePackage.getEBoolean(), "attribute", null, 0, 1, EMFInfo.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getEMFInfo_RelatedClassName(), this.ecorePackage.getEString(), "relatedClassName", null, 0, 1, EMFInfo.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getEMFInfo__ToTypeString(), this.ecorePackage.getEString(), "toTypeString", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getEMFInfo__ToInstanceString(), this.ecorePackage.getEString(), "toInstanceString", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEClass(this.genericElementEClass, GenericElement.class, "GenericElement", EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGenericElement_Abstract(), this.ecorePackage.getEBoolean(), "abstract", null, 1, 1, GenericElement.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(this.midLevelEEnum, MIDLevel.class, "MIDLevel");
    addEEnumLiteral(this.midLevelEEnum, MIDLevel.INSTANCES);
    addEEnumLiteral(this.midLevelEEnum, MIDLevel.TYPES);
    addEEnumLiteral(this.midLevelEEnum, MIDLevel.WORKFLOWS);

    initEEnum(this.modelOriginEEnum, ModelOrigin.class, "ModelOrigin");
    addEEnumLiteral(this.modelOriginEEnum, ModelOrigin.IMPORTED);
    addEEnumLiteral(this.modelOriginEEnum, ModelOrigin.CREATED);

    // Initialize data types
    initEDataType(this.mmintExceptionEDataType, MMINTException.class, "MMINTException", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.ioExceptionEDataType, IOException.class, "IOException", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.iStatusEDataType, IStatus.class, "IStatus", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.iValidationContextEDataType, IValidationContext.class, "IValidationContext", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.iEditorPartEDataType, IEditorPart.class, "IEditorPart", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(MIDPackage.eNS_URI);
  }

} //MIDPackageImpl
