/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.validation.IValidationContext;
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
import java.io.IOException;

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
    super(eNS_URI, MIDFactory.eINSTANCE);
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
    if (isInited) return (MIDPackage)EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredMIDPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    MIDPackageImpl theMIDPackage = registeredMIDPackage instanceof MIDPackageImpl ? (MIDPackageImpl)registeredMIDPackage : new MIDPackageImpl();

    isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    RelationshipPackageImpl theRelationshipPackage = (RelationshipPackageImpl)(registeredPackage instanceof RelationshipPackageImpl ? registeredPackage : RelationshipPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);
    EditorPackageImpl theEditorPackage = (EditorPackageImpl)(registeredPackage instanceof EditorPackageImpl ? registeredPackage : EditorPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);
    OperatorPackageImpl theOperatorPackage = (OperatorPackageImpl)(registeredPackage instanceof OperatorPackageImpl ? registeredPackage : OperatorPackage.eINSTANCE);

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
    return midEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMID_Models() {
    return (EReference)midEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMID_Editors() {
    return (EReference)midEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMID_Operators() {
    return (EReference)midEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getMID_ExtendibleTable() {
    return (EReference)midEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getMID_Level() {
    return (EAttribute)midEClass.getEStructuralFeatures().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__IsTypesLevel() {
    return midEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__IsInstancesLevel() {
    return midEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__IsWorkflowsLevel() {
    return midEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__GetExtendibleElement__String() {
    return midEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getMID__GetModelRels() {
    return midEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getEStringToExtendibleElementMap() {
    return eStringToExtendibleElementMapEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEStringToExtendibleElementMap_Key() {
    return (EAttribute)eStringToExtendibleElementMapEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getEStringToExtendibleElementMap_Value() {
    return (EReference)eStringToExtendibleElementMapEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getExtendibleElement() {
    return extendibleElementEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getExtendibleElement_Supertype() {
    return (EReference)extendibleElementEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_Uri() {
    return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_Name() {
    return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_Level() {
    return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_MetatypeUri() {
    return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElement_Dynamic() {
    return (EAttribute)extendibleElementEClass.getEStructuralFeatures().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getExtendibleElement_Constraint() {
    return (EReference)extendibleElementEClass.getEStructuralFeatures().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__GetMetatype() {
    return extendibleElementEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__GetMIDContainer() {
    return extendibleElementEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__IsLevel__MIDLevel() {
    return extendibleElementEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__IsTypesLevel() {
    return extendibleElementEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__GetRuntimeTypes() {
    return extendibleElementEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__GetClosestTypeConstraint() {
    return extendibleElementEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ValidateInstanceType__ExtendibleElement() {
    return extendibleElementEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ValidateInstance() {
    return extendibleElementEClass.getEOperations().get(10);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ValidateInstanceInEditor__IValidationContext() {
    return extendibleElementEClass.getEOperations().get(11);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__IsWorkflowsLevel() {
    return extendibleElementEClass.getEOperations().get(12);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__UpdateWorkflowInstanceId__String() {
    return extendibleElementEClass.getEOperations().get(13);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ToMIDCustomPrintLabel() {
    return extendibleElementEClass.getEOperations().get(14);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__ToMIDCustomEditLabel() {
    return extendibleElementEClass.getEOperations().get(15);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__UpdateMIDCustomLabel__String() {
    return extendibleElementEClass.getEOperations().get(16);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__CreateSubtypeUri__String_String() {
    return extendibleElementEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__AddTypeConstraint__String_String() {
    return extendibleElementEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElement__IsInstancesLevel() {
    return extendibleElementEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getExtendibleElementEndpoint() {
    return extendibleElementEndpointEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElementEndpoint_LowerBound() {
    return (EAttribute)extendibleElementEndpointEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElementEndpoint_UpperBound() {
    return (EAttribute)extendibleElementEndpointEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getExtendibleElementEndpoint_Target() {
    return (EReference)extendibleElementEndpointEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementEndpoint__GetMetatype() {
    return extendibleElementEndpointEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementEndpoint__GetSupertype() {
    return extendibleElementEndpointEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getExtendibleElementEndpoint__GetTargetUri() {
    return extendibleElementEndpointEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModel() {
    return modelEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getModel_Origin() {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getModel_FileExtension() {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModel_Editors() {
    return (EReference)modelEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModel_ModelElems() {
    return (EReference)modelEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModel_ConversionOperators() {
    return (EReference)modelEClass.getEStructuralFeatures().get(4);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getModel_EMFInstanceResource() {
    return (EAttribute)modelEClass.getEStructuralFeatures().get(5);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModel_EMFInstanceRoot() {
    return (EReference)modelEClass.getEStructuralFeatures().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__GetMetatype() {
    return modelEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__GetSupertype() {
    return modelEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__GetMIDContainer() {
    return modelEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateSubtype__String_boolean() {
    return modelEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__DeleteType() {
    return modelEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__GetEMFTypeRoot() {
    return modelEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateInstance__EObject_String_MID() {
    return modelEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateInstanceEditor__boolean() {
    return modelEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateInstanceAndEditor__EObject_String_MID() {
    return modelEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__ImportInstance__String_MID() {
    return modelEClass.getEOperations().get(10);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__ImportInstanceAndEditor__String_MID() {
    return modelEClass.getEOperations().get(11);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CopyInstance__Model_String_MID() {
    return modelEClass.getEOperations().get(12);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CopyInstanceAndEditor__Model_String_boolean_MID() {
    return modelEClass.getEOperations().get(13);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__DeleteInstance() {
    return modelEClass.getEOperations().get(14);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__DeleteInstanceAndFile() {
    return modelEClass.getEOperations().get(15);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__OpenType() {
    return modelEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__OpenInstance() {
    return modelEClass.getEOperations().get(16);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__CreateWorkflowInstance__String_MID() {
    return modelEClass.getEOperations().get(17);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModel__DeleteWorkflowInstance() {
    return modelEClass.getEOperations().get(18);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getExtendibleElementConstraint() {
    return extendibleElementConstraintEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElementConstraint_Implementation() {
    return (EAttribute)extendibleElementConstraintEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getExtendibleElementConstraint_Language() {
    return (EAttribute)extendibleElementConstraintEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModelElement() {
    return modelElementEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EReference getModelElement_EInfo() {
    return (EReference)modelElementEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelElement_EMFInstanceObject() {
    return (EReference)modelElementEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__GetMetatype() {
    return modelElementEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__GetSupertype() {
    return modelElementEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__GetMIDContainer() {
    return modelElementEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__CreateTypeReference__ModelElementReference_boolean_ModelEndpointReference() {
    return modelElementEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__CreateSubtypeAndReference__ModelElementReference_String_String_EMFInfo_ModelEndpointReference() {
    return modelElementEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__DeleteType() {
    return modelElementEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__GetEMFTypeObject() {
    return modelElementEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__CreateInstanceReference__ModelEndpointReference() {
    return modelElementEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__CreateInstanceAndReference__String_String_EMFInfo_ModelEndpointReference() {
    return modelElementEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelElement__DeleteInstance() {
    return modelElementEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getModelEndpoint() {
    return modelEndpointEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__GetSupertype() {
    return modelEndpointEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__GetMIDContainer() {
    return modelEndpointEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__GetTarget() {
    return modelEndpointEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__GetMetatype() {
    return modelEndpointEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateTypeReference__boolean_ModelRel() {
    return modelEndpointEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateSubtype__String_Model_boolean_ModelRel() {
    return modelEndpointEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__ReplaceSubtype__ModelEndpoint_String_Model() {
    return modelEndpointEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__DeleteType__boolean() {
    return modelEndpointEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateInstanceReference__ModelRel() {
    return modelEndpointEClass.getEOperations().get(8);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateInstance__Model_ModelRel() {
    return modelEndpointEClass.getEOperations().get(9);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateInstance__Model_Operator_String() {
    return modelEndpointEClass.getEOperations().get(10);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__ReplaceInstance__ModelEndpoint_Model() {
    return modelEndpointEClass.getEOperations().get(11);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__DeleteInstance__boolean() {
    return modelEndpointEClass.getEOperations().get(12);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateWorkflowInstance__Model_ModelRel() {
    return modelEndpointEClass.getEOperations().get(13);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__CreateWorkflowInstance__Model_Operator_String() {
    return modelEndpointEClass.getEOperations().get(14);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__ReplaceWorkflowInstance__ModelEndpoint_Model() {
    return modelEndpointEClass.getEOperations().get(15);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getModelEndpoint__DeleteWorkflowInstance() {
    return modelEndpointEClass.getEOperations().get(16);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getEMFInfo() {
    return emfInfoEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEMFInfo_ClassName() {
    return (EAttribute)emfInfoEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEMFInfo_FeatureName() {
    return (EAttribute)emfInfoEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEMFInfo_Attribute() {
    return (EAttribute)emfInfoEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEMFInfo_RelatedClassName() {
    return (EAttribute)emfInfoEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEMFInfo__ToTypeString() {
    return emfInfoEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEMFInfo__ToInstanceString() {
    return emfInfoEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getGenericElement() {
    return genericElementEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getGenericElement_Abstract() {
    return (EAttribute)genericElementEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EEnum getMIDLevel() {
    return midLevelEEnum;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EEnum getModelOrigin() {
    return modelOriginEEnum;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getMMINTException() {
    return mmintExceptionEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getIOException() {
    return ioExceptionEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getIStatus() {
    return iStatusEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getIValidationContext() {
    return iValidationContextEDataType;
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
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    midEClass = createEClass(MID);
    createEReference(midEClass, MID__MODELS);
    createEReference(midEClass, MID__EDITORS);
    createEReference(midEClass, MID__OPERATORS);
    createEReference(midEClass, MID__EXTENDIBLE_TABLE);
    createEAttribute(midEClass, MID__LEVEL);
    createEOperation(midEClass, MID___IS_TYPES_LEVEL);
    createEOperation(midEClass, MID___IS_INSTANCES_LEVEL);
    createEOperation(midEClass, MID___IS_WORKFLOWS_LEVEL);
    createEOperation(midEClass, MID___GET_EXTENDIBLE_ELEMENT__STRING);
    createEOperation(midEClass, MID___GET_MODEL_RELS);

    eStringToExtendibleElementMapEClass = createEClass(ESTRING_TO_EXTENDIBLE_ELEMENT_MAP);
    createEAttribute(eStringToExtendibleElementMapEClass, ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY);
    createEReference(eStringToExtendibleElementMapEClass, ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE);

    extendibleElementEClass = createEClass(EXTENDIBLE_ELEMENT);
    createEReference(extendibleElementEClass, EXTENDIBLE_ELEMENT__SUPERTYPE);
    createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__URI);
    createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__NAME);
    createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__LEVEL);
    createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__METATYPE_URI);
    createEAttribute(extendibleElementEClass, EXTENDIBLE_ELEMENT__DYNAMIC);
    createEReference(extendibleElementEClass, EXTENDIBLE_ELEMENT__CONSTRAINT);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___GET_METATYPE);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___GET_MID_CONTAINER);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___IS_LEVEL__MIDLEVEL);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___IS_TYPES_LEVEL);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___CREATE_SUBTYPE_URI__STRING_STRING);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___ADD_TYPE_CONSTRAINT__STRING_STRING);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___IS_INSTANCES_LEVEL);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___GET_RUNTIME_TYPES);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___GET_CLOSEST_TYPE_CONSTRAINT);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_TYPE__EXTENDIBLEELEMENT);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___VALIDATE_INSTANCE_IN_EDITOR__IVALIDATIONCONTEXT);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___IS_WORKFLOWS_LEVEL);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___UPDATE_WORKFLOW_INSTANCE_ID__STRING);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_PRINT_LABEL);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___TO_MID_CUSTOM_EDIT_LABEL);
    createEOperation(extendibleElementEClass, EXTENDIBLE_ELEMENT___UPDATE_MID_CUSTOM_LABEL__STRING);

    extendibleElementEndpointEClass = createEClass(EXTENDIBLE_ELEMENT_ENDPOINT);
    createEAttribute(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND);
    createEAttribute(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND);
    createEReference(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT__TARGET);
    createEOperation(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE);
    createEOperation(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE);
    createEOperation(extendibleElementEndpointEClass, EXTENDIBLE_ELEMENT_ENDPOINT___GET_TARGET_URI);

    modelEClass = createEClass(MODEL);
    createEAttribute(modelEClass, MODEL__ORIGIN);
    createEAttribute(modelEClass, MODEL__FILE_EXTENSION);
    createEReference(modelEClass, MODEL__EDITORS);
    createEReference(modelEClass, MODEL__MODEL_ELEMS);
    createEReference(modelEClass, MODEL__CONVERSION_OPERATORS);
    createEAttribute(modelEClass, MODEL__EMF_INSTANCE_RESOURCE);
    createEReference(modelEClass, MODEL__EMF_INSTANCE_ROOT);
    createEOperation(modelEClass, MODEL___GET_METATYPE);
    createEOperation(modelEClass, MODEL___GET_SUPERTYPE);
    createEOperation(modelEClass, MODEL___GET_MID_CONTAINER);
    createEOperation(modelEClass, MODEL___CREATE_SUBTYPE__STRING_BOOLEAN);
    createEOperation(modelEClass, MODEL___DELETE_TYPE);
    createEOperation(modelEClass, MODEL___GET_EMF_TYPE_ROOT);
    createEOperation(modelEClass, MODEL___OPEN_TYPE);
    createEOperation(modelEClass, MODEL___CREATE_INSTANCE__EOBJECT_STRING_MID);
    createEOperation(modelEClass, MODEL___CREATE_INSTANCE_EDITOR__BOOLEAN);
    createEOperation(modelEClass, MODEL___CREATE_INSTANCE_AND_EDITOR__EOBJECT_STRING_MID);
    createEOperation(modelEClass, MODEL___IMPORT_INSTANCE__STRING_MID);
    createEOperation(modelEClass, MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID);
    createEOperation(modelEClass, MODEL___COPY_INSTANCE__MODEL_STRING_MID);
    createEOperation(modelEClass, MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID);
    createEOperation(modelEClass, MODEL___DELETE_INSTANCE);
    createEOperation(modelEClass, MODEL___DELETE_INSTANCE_AND_FILE);
    createEOperation(modelEClass, MODEL___OPEN_INSTANCE);
    createEOperation(modelEClass, MODEL___CREATE_WORKFLOW_INSTANCE__STRING_MID);
    createEOperation(modelEClass, MODEL___DELETE_WORKFLOW_INSTANCE);

    extendibleElementConstraintEClass = createEClass(EXTENDIBLE_ELEMENT_CONSTRAINT);
    createEAttribute(extendibleElementConstraintEClass, EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION);
    createEAttribute(extendibleElementConstraintEClass, EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE);

    modelElementEClass = createEClass(MODEL_ELEMENT);
    createEReference(modelElementEClass, MODEL_ELEMENT__EINFO);
    createEReference(modelElementEClass, MODEL_ELEMENT__EMF_INSTANCE_OBJECT);
    createEOperation(modelElementEClass, MODEL_ELEMENT___GET_METATYPE);
    createEOperation(modelElementEClass, MODEL_ELEMENT___GET_SUPERTYPE);
    createEOperation(modelElementEClass, MODEL_ELEMENT___GET_MID_CONTAINER);
    createEOperation(modelElementEClass, MODEL_ELEMENT___CREATE_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_MODELENDPOINTREFERENCE);
    createEOperation(modelElementEClass, MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE);
    createEOperation(modelElementEClass, MODEL_ELEMENT___DELETE_TYPE);
    createEOperation(modelElementEClass, MODEL_ELEMENT___GET_EMF_TYPE_OBJECT);
    createEOperation(modelElementEClass, MODEL_ELEMENT___CREATE_INSTANCE_REFERENCE__MODELENDPOINTREFERENCE);
    createEOperation(modelElementEClass, MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE);
    createEOperation(modelElementEClass, MODEL_ELEMENT___DELETE_INSTANCE);

    modelEndpointEClass = createEClass(MODEL_ENDPOINT);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___GET_METATYPE);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___GET_SUPERTYPE);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___GET_MID_CONTAINER);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___GET_TARGET);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_TYPE_REFERENCE__BOOLEAN_MODELREL);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_SUBTYPE__STRING_MODEL_BOOLEAN_MODELREL);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___REPLACE_SUBTYPE__MODELENDPOINT_STRING_MODEL);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___DELETE_TYPE__BOOLEAN);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_INSTANCE_REFERENCE__MODELREL);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_MODELREL);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_INSTANCE__MODEL_OPERATOR_STRING);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___REPLACE_INSTANCE__MODELENDPOINT_MODEL);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___DELETE_INSTANCE__BOOLEAN);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_MODELREL);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___CREATE_WORKFLOW_INSTANCE__MODEL_OPERATOR_STRING);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___REPLACE_WORKFLOW_INSTANCE__MODELENDPOINT_MODEL);
    createEOperation(modelEndpointEClass, MODEL_ENDPOINT___DELETE_WORKFLOW_INSTANCE);

    emfInfoEClass = createEClass(EMF_INFO);
    createEAttribute(emfInfoEClass, EMF_INFO__CLASS_NAME);
    createEAttribute(emfInfoEClass, EMF_INFO__FEATURE_NAME);
    createEAttribute(emfInfoEClass, EMF_INFO__ATTRIBUTE);
    createEAttribute(emfInfoEClass, EMF_INFO__RELATED_CLASS_NAME);
    createEOperation(emfInfoEClass, EMF_INFO___TO_TYPE_STRING);
    createEOperation(emfInfoEClass, EMF_INFO___TO_INSTANCE_STRING);

    genericElementEClass = createEClass(GENERIC_ELEMENT);
    createEAttribute(genericElementEClass, GENERIC_ELEMENT__ABSTRACT);

    // Create enums
    midLevelEEnum = createEEnum(MID_LEVEL);
    modelOriginEEnum = createEEnum(MODEL_ORIGIN);

    // Create data types
    mmintExceptionEDataType = createEDataType(MMINT_EXCEPTION);
    ioExceptionEDataType = createEDataType(IO_EXCEPTION);
    iStatusEDataType = createEDataType(ISTATUS);
    iValidationContextEDataType = createEDataType(IVALIDATION_CONTEXT);
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
    RelationshipPackage theRelationshipPackage = (RelationshipPackage)EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    EditorPackage theEditorPackage = (EditorPackage)EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);
    OperatorPackage theOperatorPackage = (OperatorPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);

    // Add subpackages
    getESubpackages().add(theRelationshipPackage);
    getESubpackages().add(theEditorPackage);
    getESubpackages().add(theOperatorPackage);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    extendibleElementEndpointEClass.getESuperTypes().add(this.getExtendibleElement());
    modelEClass.getESuperTypes().add(this.getGenericElement());
    modelElementEClass.getESuperTypes().add(this.getExtendibleElement());
    modelEndpointEClass.getESuperTypes().add(this.getExtendibleElementEndpoint());
    genericElementEClass.getESuperTypes().add(this.getExtendibleElement());

    // Initialize classes, features, and operations; add parameters
    initEClass(midEClass, edu.toronto.cs.se.mmint.mid.MID.class, "MID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMID_Models(), this.getModel(), null, "models", null, 0, -1, edu.toronto.cs.se.mmint.mid.MID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMID_Editors(), theEditorPackage.getEditor(), null, "editors", null, 0, -1, edu.toronto.cs.se.mmint.mid.MID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMID_Operators(), theOperatorPackage.getOperator(), null, "operators", null, 0, -1, edu.toronto.cs.se.mmint.mid.MID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMID_ExtendibleTable(), this.getEStringToExtendibleElementMap(), null, "extendibleTable", null, 0, -1, edu.toronto.cs.se.mmint.mid.MID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMID_Level(), this.getMIDLevel(), "level", null, 1, 1, edu.toronto.cs.se.mmint.mid.MID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getMID__IsTypesLevel(), ecorePackage.getEBoolean(), "isTypesLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getMID__IsInstancesLevel(), ecorePackage.getEBoolean(), "isInstancesLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getMID__IsWorkflowsLevel(), ecorePackage.getEBoolean(), "isWorkflowsLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

    EOperation op = initEOperation(getMID__GetExtendibleElement__String(), null, "getExtendibleElement", 0, 1, IS_UNIQUE, IS_ORDERED);
    ETypeParameter t1 = addETypeParameter(op, "T");
    EGenericType g1 = createEGenericType(this.getExtendibleElement());
    t1.getEBounds().add(g1);
    addEParameter(op, ecorePackage.getEString(), "uri", 1, 1, IS_UNIQUE, IS_ORDERED);
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    initEOperation(getMID__GetModelRels(), theRelationshipPackage.getModelRel(), "getModelRels", 0, -1, IS_UNIQUE, IS_ORDERED);

    initEClass(eStringToExtendibleElementMapEClass, Map.Entry.class, "EStringToExtendibleElementMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEStringToExtendibleElementMap_Key(), ecorePackage.getEString(), "key", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEStringToExtendibleElementMap_Value(), this.getExtendibleElement(), null, "value", null, 1, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(extendibleElementEClass, ExtendibleElement.class, "ExtendibleElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExtendibleElement_Supertype(), this.getExtendibleElement(), null, "supertype", null, 0, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExtendibleElement_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExtendibleElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExtendibleElement_Level(), this.getMIDLevel(), "level", null, 1, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExtendibleElement_MetatypeUri(), ecorePackage.getEString(), "metatypeUri", null, 0, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExtendibleElement_Dynamic(), ecorePackage.getEBoolean(), "dynamic", null, 1, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExtendibleElement_Constraint(), this.getExtendibleElementConstraint(), null, "constraint", null, 0, 1, ExtendibleElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getExtendibleElement__GetMetatype(), this.getExtendibleElement(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getExtendibleElement__GetMIDContainer(), this.getMID(), "getMIDContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getExtendibleElement__IsLevel__MIDLevel(), ecorePackage.getEBoolean(), "isLevel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getMIDLevel(), "midLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getExtendibleElement__IsTypesLevel(), ecorePackage.getEBoolean(), "isTypesLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getExtendibleElement__CreateSubtypeUri__String_String(), ecorePackage.getEString(), "createSubtypeUri", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newTypeFragmentUri", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getExtendibleElement__AddTypeConstraint__String_String(), null, "addTypeConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "language", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "implementation", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEOperation(getExtendibleElement__IsInstancesLevel(), ecorePackage.getEBoolean(), "isInstancesLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getExtendibleElement__GetRuntimeTypes(), null, "getRuntimeTypes", 0, -1, IS_UNIQUE, IS_ORDERED);
    t1 = addETypeParameter(op, "T");
    g1 = createEGenericType(this.getExtendibleElement());
    t1.getEBounds().add(g1);
    addEException(op, this.getMMINTException());
    g1 = createEGenericType(t1);
    initEOperation(op, g1);

    op = initEOperation(getExtendibleElement__GetClosestTypeConstraint(), this.getExtendibleElementConstraint(), "getClosestTypeConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getExtendibleElement__ValidateInstanceType__ExtendibleElement(), ecorePackage.getEBoolean(), "validateInstanceType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getExtendibleElement(), "type", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getExtendibleElement__ValidateInstance(), ecorePackage.getEBoolean(), "validateInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getExtendibleElement__ValidateInstanceInEditor__IValidationContext(), this.getIStatus(), "validateInstanceInEditor", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getIValidationContext(), "context", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEOperation(getExtendibleElement__IsWorkflowsLevel(), ecorePackage.getEBoolean(), "isWorkflowsLevel", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getExtendibleElement__UpdateWorkflowInstanceId__String(), null, "updateWorkflowInstanceId", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newInstanceId", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEOperation(getExtendibleElement__ToMIDCustomPrintLabel(), ecorePackage.getEString(), "toMIDCustomPrintLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getExtendibleElement__ToMIDCustomEditLabel(), ecorePackage.getEString(), "toMIDCustomEditLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getExtendibleElement__UpdateMIDCustomLabel__String(), null, "updateMIDCustomLabel", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newLabel", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(extendibleElementEndpointEClass, ExtendibleElementEndpoint.class, "ExtendibleElementEndpoint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExtendibleElementEndpoint_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, ExtendibleElementEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExtendibleElementEndpoint_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 1, 1, ExtendibleElementEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExtendibleElementEndpoint_Target(), this.getExtendibleElement(), null, "target", null, 1, 1, ExtendibleElementEndpoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getExtendibleElementEndpoint__GetMetatype(), this.getExtendibleElementEndpoint(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getExtendibleElementEndpoint__GetSupertype(), this.getExtendibleElementEndpoint(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getExtendibleElementEndpoint__GetTargetUri(), ecorePackage.getEString(), "getTargetUri", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModel_Origin(), this.getModelOrigin(), "origin", null, 1, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_FileExtension(), ecorePackage.getEString(), "fileExtension", null, 1, 1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Editors(), theEditorPackage.getEditor(), null, "editors", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_ModelElems(), this.getModelElement(), null, "modelElems", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_ConversionOperators(), theOperatorPackage.getConversionOperator(), null, "conversionOperators", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModel_EMFInstanceResource(), ecorePackage.getEResource(), "EMFInstanceResource", null, 0, 1, Model.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_EMFInstanceRoot(), ecorePackage.getEObject(), null, "EMFInstanceRoot", null, 0, 1, Model.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getModel__GetMetatype(), this.getModel(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getModel__GetSupertype(), this.getModel(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getModel__GetMIDContainer(), this.getMID(), "getMIDContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getModel__CreateSubtype__String_boolean(), this.getModel(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "isMetamodelExtension", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__GetEMFTypeRoot(), ecorePackage.getEPackage(), "getEMFTypeRoot", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__OpenType(), null, "openType", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theOperatorPackage.getException());

    op = initEOperation(getModel__CreateInstance__EObject_String_MID(), this.getModel(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEObject(), "rootModelObj", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelPath", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());
    addEException(op, this.getIOException());

    op = initEOperation(getModel__CreateInstanceEditor__boolean(), theEditorPackage.getEditor(), "createInstanceEditor", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "createEditorFile", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__CreateInstanceAndEditor__EObject_String_MID(), this.getModel(), "createInstanceAndEditor", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEObject(), "rootModelObj", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelPath", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());
    addEException(op, this.getIOException());

    op = initEOperation(getModel__ImportInstance__String_MID(), this.getModel(), "importInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "modelPath", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__ImportInstanceAndEditor__String_MID(), this.getModel(), "importInstanceAndEditor", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "modelPath", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__CopyInstance__Model_String_MID(), this.getModel(), "copyInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "origModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());
    addEException(op, this.getIOException());

    op = initEOperation(getModel__CopyInstanceAndEditor__Model_String_boolean_MID(), this.getModel(), "copyInstanceAndEditor", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "origModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "copyDiagram", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getMID(), "instanceMID", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());
    addEException(op, this.getIOException());

    op = initEOperation(getModel__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__DeleteInstanceAndFile(), null, "deleteInstanceAndFile", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__OpenInstance(), null, "openInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, theOperatorPackage.getException());

    op = initEOperation(getModel__CreateWorkflowInstance__String_MID(), this.getModel(), "createWorkflowInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelId", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getMID(), "workflowMID", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModel__DeleteWorkflowInstance(), null, "deleteWorkflowInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEClass(extendibleElementConstraintEClass, ExtendibleElementConstraint.class, "ExtendibleElementConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExtendibleElementConstraint_Implementation(), ecorePackage.getEString(), "implementation", null, 1, 1, ExtendibleElementConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExtendibleElementConstraint_Language(), ecorePackage.getEString(), "language", null, 1, 1, ExtendibleElementConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modelElementEClass, ModelElement.class, "ModelElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelElement_EInfo(), this.getEMFInfo(), null, "eInfo", null, 1, 1, ModelElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelElement_EMFInstanceObject(), ecorePackage.getEObject(), null, "EMFInstanceObject", null, 0, 1, ModelElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getModelElement__GetMetatype(), this.getModelElement(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getModelElement__GetSupertype(), this.getModelElement(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getModelElement__GetMIDContainer(), this.getMID(), "getMIDContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getModelElement__CreateTypeReference__ModelElementReference_boolean_ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createTypeReference", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelElementReference(), "modelElemTypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "isModifiable", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelTypeEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__CreateSubtypeAndReference__ModelElementReference_String_String_EMFInfo_ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createSubtypeAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelElementReference(), "modelElemTypeRef", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelElemTypeUri", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelElemTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getEMFInfo(), "eInfo", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelTypeEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__GetEMFTypeObject(), ecorePackage.getENamedElement(), "getEMFTypeObject", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__CreateInstanceReference__ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createInstanceReference", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__CreateInstanceAndReference__String_String_EMFInfo_ModelEndpointReference(), theRelationshipPackage.getModelElementReference(), "createInstanceAndReference", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelElemUri", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelElemName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getEMFInfo(), "eInfo", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelEndpointReference(), "containerModelEndpointRef", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelElement__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEClass(modelEndpointEClass, ModelEndpoint.class, "ModelEndpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getModelEndpoint__GetMetatype(), this.getModelEndpoint(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getModelEndpoint__GetSupertype(), this.getModelEndpoint(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getModelEndpoint__GetMIDContainer(), this.getMID(), "getMIDContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getModelEndpoint__GetTarget(), this.getModel(), "getTarget", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getModelEndpoint__CreateTypeReference__boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createTypeReference", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "isModifiable", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateSubtype__String_Model_boolean_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModelType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "isBinarySrc", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRelType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__ReplaceSubtype__ModelEndpoint_String_Model(), null, "replaceSubtype", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModelEndpoint(), "oldModelTypeEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "newModelTypeEndpointName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModelType", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__DeleteType__boolean(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateInstanceReference__ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createInstanceReference", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateInstance__Model_ModelRel(), theRelationshipPackage.getModelEndpointReference(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateInstance__Model_Operator_String(), this.getModelEndpoint(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theOperatorPackage.getOperator(), "containerOperator", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "containerFeatureName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__ReplaceInstance__ModelEndpoint_Model(), null, "replaceInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModelEndpoint(), "oldModelEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__DeleteInstance__boolean(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "isFullDelete", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateWorkflowInstance__Model_ModelRel(), this.getModelEndpoint(), "createWorkflowInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theRelationshipPackage.getModelRel(), "containerModelRel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__CreateWorkflowInstance__Model_Operator_String(), this.getModelEndpoint(), "createWorkflowInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theOperatorPackage.getOperator(), "containerOperator", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "containerFeatureName", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__ReplaceWorkflowInstance__ModelEndpoint_Model(), null, "replaceWorkflowInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModelEndpoint(), "oldModelEndpoint", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getModel(), "targetModel", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    op = initEOperation(getModelEndpoint__DeleteWorkflowInstance(), null, "deleteWorkflowInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEException(op, this.getMMINTException());

    initEClass(emfInfoEClass, EMFInfo.class, "EMFInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEMFInfo_ClassName(), ecorePackage.getEString(), "className", null, 1, 1, EMFInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEMFInfo_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, EMFInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEMFInfo_Attribute(), ecorePackage.getEBoolean(), "attribute", null, 0, 1, EMFInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEMFInfo_RelatedClassName(), ecorePackage.getEString(), "relatedClassName", null, 0, 1, EMFInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEOperation(getEMFInfo__ToTypeString(), ecorePackage.getEString(), "toTypeString", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getEMFInfo__ToInstanceString(), ecorePackage.getEString(), "toInstanceString", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(genericElementEClass, GenericElement.class, "GenericElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGenericElement_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 1, 1, GenericElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(midLevelEEnum, MIDLevel.class, "MIDLevel");
    addEEnumLiteral(midLevelEEnum, MIDLevel.INSTANCES);
    addEEnumLiteral(midLevelEEnum, MIDLevel.TYPES);
    addEEnumLiteral(midLevelEEnum, MIDLevel.WORKFLOWS);

    initEEnum(modelOriginEEnum, ModelOrigin.class, "ModelOrigin");
    addEEnumLiteral(modelOriginEEnum, ModelOrigin.IMPORTED);
    addEEnumLiteral(modelOriginEEnum, ModelOrigin.CREATED);

    // Initialize data types
    initEDataType(mmintExceptionEDataType, MMINTException.class, "MMINTException", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(ioExceptionEDataType, IOException.class, "IOException", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iStatusEDataType, IStatus.class, "IStatus", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
    initEDataType(iValidationContextEDataType, IValidationContext.class, "IValidationContext", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //MIDPackageImpl
