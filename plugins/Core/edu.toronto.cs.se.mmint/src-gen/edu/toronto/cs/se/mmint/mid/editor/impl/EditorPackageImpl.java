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
package edu.toronto.cs.se.mmint.mid.editor.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.jface.viewers.IStructuredSelection;

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmint.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmint.mid.impl.MIDPackageImpl;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorPackageImpl;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.impl.RelationshipPackageImpl;
import edu.toronto.cs.se.mmint.mid.ui.EditorCreationWizardDialog;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EditorPackageImpl extends EPackageImpl implements EditorPackage {
    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass editorEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EClass diagramEClass = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EDataType iStructuredSelectionEDataType = null;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    private EDataType editorCreationWizardDialogEDataType = null;

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
   * @see edu.toronto.cs.se.mmint.mid.editor.EditorPackage#eNS_URI
   * @see #init()
   * @generated
   */
    private EditorPackageImpl() {
    super(EditorPackage.eNS_URI, EditorFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link EditorPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
    public static EditorPackage init() {
    if (EditorPackageImpl.isInited) {
      return (EditorPackage)EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);
    }

    // Obtain or create and register package
    var registeredEditorPackage = EPackage.Registry.INSTANCE.get(EditorPackage.eNS_URI);
    var theEditorPackage = registeredEditorPackage instanceof EditorPackageImpl e ? e : new EditorPackageImpl();

    EditorPackageImpl.isInited = true;

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);
    var theMIDPackage = (MIDPackageImpl)(registeredPackage instanceof MIDPackageImpl ? registeredPackage : MIDPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI);
    var theRelationshipPackage = (RelationshipPackageImpl)(registeredPackage instanceof RelationshipPackageImpl ? registeredPackage : RelationshipPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);
    var theOperatorPackage = (OperatorPackageImpl)(registeredPackage instanceof OperatorPackageImpl ? registeredPackage : OperatorPackage.eINSTANCE);

    // Create package meta-data objects
    theEditorPackage.createPackageContents();
    theMIDPackage.createPackageContents();
    theRelationshipPackage.createPackageContents();
    theOperatorPackage.createPackageContents();

    // Initialize created meta-data
    theEditorPackage.initializePackageContents();
    theMIDPackage.initializePackageContents();
    theRelationshipPackage.initializePackageContents();
    theOperatorPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theEditorPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(EditorPackage.eNS_URI, theEditorPackage);
    return theEditorPackage;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getEditor() {
    return this.editorEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEditor_ModelUri() {
    return (EAttribute)this.editorEClass.getEStructuralFeatures().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEditor_Id() {
    return (EAttribute)this.editorEClass.getEStructuralFeatures().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEditor_WizardId() {
    return (EAttribute)this.editorEClass.getEStructuralFeatures().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEditor_FileExtensions() {
    return (EAttribute)this.editorEClass.getEStructuralFeatures().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EAttribute getEditor_WizardDialogClass() {
    return (EAttribute)this.editorEClass.getEStructuralFeatures().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEditor__GetMetatype() {
    return this.editorEClass.getEOperations().get(0);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEditor__GetSupertype() {
    return this.editorEClass.getEOperations().get(1);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEditor__GetMIDContainer() {
    return this.editorEClass.getEOperations().get(2);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEditor__CreateSubtype__String_String_String_String_String_String() {
    return this.editorEClass.getEOperations().get(3);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEditor__DeleteType() {
    return this.editorEClass.getEOperations().get(4);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEditor__CreateInstance__String_boolean_MID() {
    return this.editorEClass.getEOperations().get(5);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEditor__InvokeInstanceWizard__IStructuredSelection() {
    return this.editorEClass.getEOperations().get(6);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EOperation getEditor__DeleteInstance() {
    return this.editorEClass.getEOperations().get(7);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EClass getDiagram() {
    return this.diagramEClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getIStructuredSelection() {
    return this.iStructuredSelectionEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EDataType getEditorCreationWizardDialog() {
    return this.editorCreationWizardDialogEDataType;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EditorFactory getEditorFactory() {
    return (EditorFactory)getEFactoryInstance();
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
    this.editorEClass = createEClass(EditorPackage.EDITOR);
    createEAttribute(this.editorEClass, EditorPackage.EDITOR__MODEL_URI);
    createEAttribute(this.editorEClass, EditorPackage.EDITOR__ID);
    createEAttribute(this.editorEClass, EditorPackage.EDITOR__WIZARD_ID);
    createEAttribute(this.editorEClass, EditorPackage.EDITOR__FILE_EXTENSIONS);
    createEAttribute(this.editorEClass, EditorPackage.EDITOR__WIZARD_DIALOG_CLASS);
    createEOperation(this.editorEClass, EditorPackage.EDITOR___GET_METATYPE);
    createEOperation(this.editorEClass, EditorPackage.EDITOR___GET_SUPERTYPE);
    createEOperation(this.editorEClass, EditorPackage.EDITOR___GET_MID_CONTAINER);
    createEOperation(this.editorEClass, EditorPackage.EDITOR___CREATE_SUBTYPE__STRING_STRING_STRING_STRING_STRING_STRING);
    createEOperation(this.editorEClass, EditorPackage.EDITOR___DELETE_TYPE);
    createEOperation(this.editorEClass, EditorPackage.EDITOR___CREATE_INSTANCE__STRING_BOOLEAN_MID);
    createEOperation(this.editorEClass, EditorPackage.EDITOR___INVOKE_INSTANCE_WIZARD__ISTRUCTUREDSELECTION);
    createEOperation(this.editorEClass, EditorPackage.EDITOR___DELETE_INSTANCE);

    this.diagramEClass = createEClass(EditorPackage.DIAGRAM);

    // Create data types
    this.iStructuredSelectionEDataType = createEDataType(EditorPackage.ISTRUCTURED_SELECTION);
    this.editorCreationWizardDialogEDataType = createEDataType(EditorPackage.EDITOR_CREATION_WIZARD_DIALOG);
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
    setName(EditorPackage.eNAME);
    setNsPrefix(EditorPackage.eNS_PREFIX);
    setNsURI(EditorPackage.eNS_URI);

    // Obtain other dependent packages
    var theMIDPackage = (MIDPackage)EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.editorEClass.getESuperTypes().add(theMIDPackage.getExtendibleElement());
    this.diagramEClass.getESuperTypes().add(this.getEditor());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.editorEClass, Editor.class, "Editor", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEditor_ModelUri(), this.ecorePackage.getEString(), "modelUri", null, 1, 1, Editor.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getEditor_Id(), this.ecorePackage.getEString(), "id", null, 1, 1, Editor.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getEditor_WizardId(), this.ecorePackage.getEString(), "wizardId", null, 1, 1, Editor.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getEditor_FileExtensions(), this.ecorePackage.getEString(), "fileExtensions", null, 1, -1, Editor.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);
    initEAttribute(getEditor_WizardDialogClass(), this.ecorePackage.getEString(), "wizardDialogClass", null, 0, 1, Editor.class, !EPackageImpl.IS_TRANSIENT, !EPackageImpl.IS_VOLATILE, EPackageImpl.IS_CHANGEABLE, !EPackageImpl.IS_UNSETTABLE, !EPackageImpl.IS_ID, EPackageImpl.IS_UNIQUE, !EPackageImpl.IS_DERIVED, EPackageImpl.IS_ORDERED);

    initEOperation(getEditor__GetMetatype(), this.getEditor(), "getMetatype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getEditor__GetSupertype(), this.getEditor(), "getSupertype", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    initEOperation(getEditor__GetMIDContainer(), theMIDPackage.getMID(), "getMIDContainer", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);

    var op = initEOperation(getEditor__CreateSubtype__String_String_String_String_String_String(), this.getEditor(), "createSubtype", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newEditorTypeFragmentUri", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "newEditorTypeName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "modelTypeUri", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "editorId", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "wizardId", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "wizardDialogClassName", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getEditor__DeleteType(), null, "deleteType", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getEditor__CreateInstance__String_boolean_MID(), this.getEditor(), "createInstance", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "modelPath", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "createEditorFile", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, theMIDPackage.getMID(), "instanceMID", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getEditor__InvokeInstanceWizard__IStructuredSelection(), this.getEditorCreationWizardDialog(), "invokeInstanceWizard", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEParameter(op, this.getIStructuredSelection(), "initialSelection", 1, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    op = initEOperation(getEditor__DeleteInstance(), null, "deleteInstance", 0, 1, EPackageImpl.IS_UNIQUE, EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    initEClass(this.diagramEClass, Diagram.class, "Diagram", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    // Initialize data types
    initEDataType(this.iStructuredSelectionEDataType, IStructuredSelection.class, "IStructuredSelection", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
    initEDataType(this.editorCreationWizardDialogEDataType, EditorCreationWizardDialog.class, "EditorCreationWizardDialog", !EPackageImpl.IS_SERIALIZABLE, !EPackageImpl.IS_GENERATED_INSTANCE_CLASS);
  }

} //EditorPackageImpl
