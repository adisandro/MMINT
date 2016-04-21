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
		super(eNS_URI, EditorFactory.eINSTANCE);
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
		if (isInited) return (EditorPackage)EPackage.Registry.INSTANCE.getEPackage(EditorPackage.eNS_URI);

		// Obtain or create and register package
		EditorPackageImpl theEditorPackage = (EditorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EditorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EditorPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		MIDPackageImpl theMIDPackage = (MIDPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI) instanceof MIDPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI) : MIDPackage.eINSTANCE);
		RelationshipPackageImpl theRelationshipPackage = (RelationshipPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI) instanceof RelationshipPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RelationshipPackage.eNS_URI) : RelationshipPackage.eINSTANCE);
		OperatorPackageImpl theOperatorPackage = (OperatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) instanceof OperatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI) : OperatorPackage.eINSTANCE);

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
	public EClass getEditor() {
		return editorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditor_ModelUri() {
		return (EAttribute)editorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditor_Id() {
		return (EAttribute)editorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditor_WizardId() {
		return (EAttribute)editorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditor_FileExtensions() {
		return (EAttribute)editorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEditor_WizardDialogClass() {
		return (EAttribute)editorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEditor__GetMetatype() {
		return editorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEditor__GetSupertype() {
		return editorEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEditor__CreateSubtype__String_String_String_String_String_String() {
		return editorEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEditor__DeleteType() {
		return editorEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEditor__CreateInstance__String_MID() {
		return editorEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEditor__InvokeInstanceWizard__IStructuredSelection() {
		return editorEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEditor__DeleteInstance() {
		return editorEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDiagram() {
		return diagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDiagram__CreateSubtype__String_String_String_String_String_String() {
		return diagramEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDiagram__CreateInstance__String_MID() {
		return diagramEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getDiagram__InvokeInstanceWizard__IStructuredSelection() {
		return diagramEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIStructuredSelection() {
		return iStructuredSelectionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getEditorCreationWizardDialog() {
		return editorCreationWizardDialogEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		editorEClass = createEClass(EDITOR);
		createEAttribute(editorEClass, EDITOR__MODEL_URI);
		createEAttribute(editorEClass, EDITOR__ID);
		createEAttribute(editorEClass, EDITOR__WIZARD_ID);
		createEAttribute(editorEClass, EDITOR__FILE_EXTENSIONS);
		createEAttribute(editorEClass, EDITOR__WIZARD_DIALOG_CLASS);
		createEOperation(editorEClass, EDITOR___GET_METATYPE);
		createEOperation(editorEClass, EDITOR___GET_SUPERTYPE);
		createEOperation(editorEClass, EDITOR___CREATE_SUBTYPE__STRING_STRING_STRING_STRING_STRING_STRING);
		createEOperation(editorEClass, EDITOR___DELETE_TYPE);
		createEOperation(editorEClass, EDITOR___CREATE_INSTANCE__STRING_MID);
		createEOperation(editorEClass, EDITOR___INVOKE_INSTANCE_WIZARD__ISTRUCTUREDSELECTION);
		createEOperation(editorEClass, EDITOR___DELETE_INSTANCE);

		diagramEClass = createEClass(DIAGRAM);
		createEOperation(diagramEClass, DIAGRAM___CREATE_SUBTYPE__STRING_STRING_STRING_STRING_STRING_STRING);
		createEOperation(diagramEClass, DIAGRAM___CREATE_INSTANCE__STRING_MID);
		createEOperation(diagramEClass, DIAGRAM___INVOKE_INSTANCE_WIZARD__ISTRUCTUREDSELECTION);

		// Create data types
		iStructuredSelectionEDataType = createEDataType(ISTRUCTURED_SELECTION);
		editorCreationWizardDialogEDataType = createEDataType(EDITOR_CREATION_WIZARD_DIALOG);
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
		editorEClass.getESuperTypes().add(theMIDPackage.getExtendibleElement());
		diagramEClass.getESuperTypes().add(this.getEditor());

		// Initialize classes, features, and operations; add parameters
		initEClass(editorEClass, Editor.class, "Editor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEditor_ModelUri(), ecorePackage.getEString(), "modelUri", null, 1, 1, Editor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditor_Id(), ecorePackage.getEString(), "id", null, 1, 1, Editor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditor_WizardId(), ecorePackage.getEString(), "wizardId", null, 1, 1, Editor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditor_FileExtensions(), ecorePackage.getEString(), "fileExtensions", null, 1, -1, Editor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEditor_WizardDialogClass(), ecorePackage.getEString(), "wizardDialogClass", null, 0, 1, Editor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEditor__GetMetatype(), this.getEditor(), "getMetatype", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getEditor__GetSupertype(), this.getEditor(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getEditor__CreateSubtype__String_String_String_String_String_String(), this.getEditor(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newEditorTypeFragmentUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newEditorTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "modelTypeUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "editorId", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "wizardId", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "wizardDialogClassName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getEditor__DeleteType(), null, "deleteType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getEditor__CreateInstance__String_MID(), this.getEditor(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "modelUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "instanceMID", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getEditor__InvokeInstanceWizard__IStructuredSelection(), this.getEditorCreationWizardDialog(), "invokeInstanceWizard", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIStructuredSelection(), "initialSelection", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getEditor__DeleteInstance(), null, "deleteInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		initEClass(diagramEClass, Diagram.class, "Diagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = initEOperation(getDiagram__CreateSubtype__String_String_String_String_String_String(), this.getEditor(), "createSubtype", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newEditorTypeFragmentUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "newEditorTypeName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "modelTypeUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "editorId", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "wizardId", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "wizardDialogClassName", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getDiagram__CreateInstance__String_MID(), this.getEditor(), "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "modelUri", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theMIDPackage.getMID(), "instanceMID", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		op = initEOperation(getDiagram__InvokeInstanceWizard__IStructuredSelection(), this.getEditorCreationWizardDialog(), "invokeInstanceWizard", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIStructuredSelection(), "initialSelection", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theMIDPackage.getMMINTException());

		// Initialize data types
		initEDataType(iStructuredSelectionEDataType, IStructuredSelection.class, "IStructuredSelection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(editorCreationWizardDialogEDataType, EditorCreationWizardDialog.class, "EditorCreationWizardDialog", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //EditorPackageImpl
