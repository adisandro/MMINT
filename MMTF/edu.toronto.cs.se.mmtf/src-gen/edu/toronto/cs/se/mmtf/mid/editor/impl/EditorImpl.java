/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.editor.impl;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.ui.EditorCreationWizardDialog;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.presentation.DynamicModelWizard;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.IWizardDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Editor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.impl.EditorImpl#getModelUri <em>Model Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.impl.EditorImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.impl.EditorImpl#getWizardId <em>Wizard Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.impl.EditorImpl#getFileExtensions <em>File Extensions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.editor.impl.EditorImpl#getWizardDialogClass <em>Wizard Dialog Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EditorImpl extends ExtendibleElementImpl implements Editor {
	/**
	 * The default value of the '{@link #getModelUri() <em>Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelUri()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelUri() <em>Model Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelUri()
	 * @generated
	 * @ordered
	 */
	protected String modelUri = MODEL_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getWizardId() <em>Wizard Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardId()
	 * @generated
	 * @ordered
	 */
	protected static final String WIZARD_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWizardId() <em>Wizard Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardId()
	 * @generated
	 * @ordered
	 */
	protected String wizardId = WIZARD_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFileExtensions() <em>File Extensions</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<String> fileExtensions;

	/**
	 * The default value of the '{@link #getWizardDialogClass() <em>Wizard Dialog Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardDialogClass()
	 * @generated
	 * @ordered
	 */
	protected static final String WIZARD_DIALOG_CLASS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWizardDialogClass() <em>Wizard Dialog Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWizardDialogClass()
	 * @generated
	 * @ordered
	 */
	protected String wizardDialogClass = WIZARD_DIALOG_CLASS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EditorPackage.Literals.EDITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelUri() {
		return modelUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelUri(String newModelUri) {
		String oldModelUri = modelUri;
		modelUri = newModelUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__MODEL_URI, oldModelUri, modelUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWizardId() {
		return wizardId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWizardId(String newWizardId) {
		String oldWizardId = wizardId;
		wizardId = newWizardId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__WIZARD_ID, oldWizardId, wizardId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFileExtensions() {
		if (fileExtensions == null) {
			fileExtensions = new EDataTypeUniqueEList<String>(String.class, this, EditorPackage.EDITOR__FILE_EXTENSIONS);
		}
		return fileExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWizardDialogClass() {
		return wizardDialogClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWizardDialogClass(String newWizardDialogClass) {
		String oldWizardDialogClass = wizardDialogClass;
		wizardDialogClass = newWizardDialogClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__WIZARD_DIALOG_CLASS, oldWizardDialogClass, wizardDialogClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (Editor) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor getSupertype() {
		ExtendibleElement supertype = super.getSupertype();
		return (supertype == null) ? null : (Editor) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EditorPackage.EDITOR__MODEL_URI:
				return getModelUri();
			case EditorPackage.EDITOR__ID:
				return getId();
			case EditorPackage.EDITOR__WIZARD_ID:
				return getWizardId();
			case EditorPackage.EDITOR__FILE_EXTENSIONS:
				return getFileExtensions();
			case EditorPackage.EDITOR__WIZARD_DIALOG_CLASS:
				return getWizardDialogClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EditorPackage.EDITOR__MODEL_URI:
				setModelUri((String)newValue);
				return;
			case EditorPackage.EDITOR__ID:
				setId((String)newValue);
				return;
			case EditorPackage.EDITOR__WIZARD_ID:
				setWizardId((String)newValue);
				return;
			case EditorPackage.EDITOR__FILE_EXTENSIONS:
				getFileExtensions().clear();
				getFileExtensions().addAll((Collection<? extends String>)newValue);
				return;
			case EditorPackage.EDITOR__WIZARD_DIALOG_CLASS:
				setWizardDialogClass((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EditorPackage.EDITOR__MODEL_URI:
				setModelUri(MODEL_URI_EDEFAULT);
				return;
			case EditorPackage.EDITOR__ID:
				setId(ID_EDEFAULT);
				return;
			case EditorPackage.EDITOR__WIZARD_ID:
				setWizardId(WIZARD_ID_EDEFAULT);
				return;
			case EditorPackage.EDITOR__FILE_EXTENSIONS:
				getFileExtensions().clear();
				return;
			case EditorPackage.EDITOR__WIZARD_DIALOG_CLASS:
				setWizardDialogClass(WIZARD_DIALOG_CLASS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EditorPackage.EDITOR__MODEL_URI:
				return MODEL_URI_EDEFAULT == null ? modelUri != null : !MODEL_URI_EDEFAULT.equals(modelUri);
			case EditorPackage.EDITOR__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case EditorPackage.EDITOR__WIZARD_ID:
				return WIZARD_ID_EDEFAULT == null ? wizardId != null : !WIZARD_ID_EDEFAULT.equals(wizardId);
			case EditorPackage.EDITOR__FILE_EXTENSIONS:
				return fileExtensions != null && !fileExtensions.isEmpty();
			case EditorPackage.EDITOR__WIZARD_DIALOG_CLASS:
				return WIZARD_DIALOG_CLASS_EDEFAULT == null ? wizardDialogClass != null : !WIZARD_DIALOG_CLASS_EDEFAULT.equals(wizardDialogClass);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case EditorPackage.EDITOR___GET_METATYPE:
				return getMetatype();
			case EditorPackage.EDITOR___GET_SUPERTYPE:
				return getSupertype();
			case EditorPackage.EDITOR___CREATE_SUBTYPE__STRING_STRING_STRING_STRING_STRING_STRING:
				try {
					return createSubtype((String)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (String)arguments.get(3), (String)arguments.get(4), (String)arguments.get(5));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case EditorPackage.EDITOR___DELETE_TYPE:
				try {
					deleteType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case EditorPackage.EDITOR___CREATE_INSTANCE__STRING_MULTIMODEL:
				try {
					return createInstance((String)arguments.get(0), (MultiModel)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case EditorPackage.EDITOR___INVOKE_INSTANCE_WIZARD__ISTRUCTUREDSELECTION:
				try {
					return invokeInstanceWizard((IStructuredSelection)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case EditorPackage.EDITOR___DELETE_INSTANCE:
				try {
					deleteInstance();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (modelUri: ");
		result.append(modelUri);
		result.append(", id: ");
		result.append(id);
		result.append(", wizardId: ");
		result.append(wizardId);
		result.append(", fileExtensions: ");
		result.append(fileExtensions);
		result.append(", wizardDialogClass: ");
		result.append(wizardDialogClass);
		result.append(')');
		return result.toString();
	}

	/**
	 * Adds a subtype of this editor type to the Type MID.
	 * 
	 * @param newEditorType
	 *            The new editor type to be added.
	 * @param newEditorTypeFragmentUri
	 *            The uri fragment to be appended as part of the uri of the new
	 *            editor type.
	 * @param newEditorTypeName
	 *            The name of the new editor type.
	 * @param modelTypeUri
	 *            The uri of the model type handled by the new editor type.
	 * @param editorId
	 *            The id of the corresponding Eclipse editor.
	 * @param wizardId
	 *            The wizard id of the corresponding Eclipse editor.
	 * @param wizardDialogClassName
	 *            The fully qualified name of a Java class that handles the
	 *            creation of the model type through the new editor type.
	 * @return The created editor type.
	 * @throws MMTFException
	 *             If the uri of the new editor type is already registered in
	 *             the Type MID.
	 * @generated NOT
	 */
	protected void addSubtype(Editor newEditorType, String newEditorTypeFragmentUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName) throws MMTFException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		super.addSubtype(newEditorType, this, newEditorTypeFragmentUri, newEditorTypeName);
		MultiModelTypeFactory.addEditorType(newEditorType, modelTypeUri, editorId, wizardId, wizardDialogClassName, multiModel);

		for (String fileExtension : getFileExtensions()) {
			newEditorType.getFileExtensions().add(fileExtension);
		}
	}

	/**
	 * @generated NOT
	 */
	public Editor createSubtype(String newEditorTypeFragmentUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Editor newEditorType = EditorFactory.eINSTANCE.createEditor();
		addSubtype(newEditorType, newEditorTypeFragmentUri, newEditorTypeName, modelTypeUri, editorId, wizardId, wizardDialogClassName);

		return newEditorType;
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		super.deleteType(multiModel);
		Model modelType = MultiModelRegistry.getExtendibleElement(getModelUri(), multiModel);
		if (modelType != null) {
			modelType.getEditors().remove(this);
		}
		multiModel.getEditors().remove(this);
		for (Editor editorSubtype : MultiModelTypeHierarchy.getDirectSubtypes(this, multiModel)) {
			editorSubtype.deleteType();
		}
	}

	/**
	 * Adds an editor instance of this editor type to an Instance MID, or simply
	 * adds additional info to the editor instance.
	 * 
	 * @param newEditor
	 *            The new editor to be added.
	 * @param modelUri
	 *            The uri of the model handled by the new editor.
	 * @param containerMultiModel
	 *            An Instance MID, null if the editor isn't going to be added to
	 *            it.
	 * @return The created editor.
	 * @generated NOT
	 */
	protected void addInstance(Editor newEditor, String modelUri, MultiModel containerMultiModel) {

		String newEditorName = getName() + " for model " + modelUri;
		String newEditorUri = MultiModelUtils.replaceFileExtensionInUri(modelUri, getFileExtensions().get(0));
		super.addBasicInstance(newEditor, newEditorUri, newEditorName);
		newEditor.setModelUri(modelUri);
		newEditor.setId(getId());
		newEditor.setWizardId(getWizardId());
		newEditor.getFileExtensions().add(getFileExtensions().get(0));
		if (containerMultiModel != null) {
			containerMultiModel.getEditors().add(newEditor);
		}
	}

	/**
	 * @generated NOT
	 */
	public Editor createInstance(String modelUri, MultiModel containerMultiModel) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Editor newEditor = EditorFactory.eINSTANCE.createEditor();
		addInstance(newEditor, modelUri, containerMultiModel);

		return newEditor;
	}

	/**
	 * Gets an editor instance creation wizard for this editor type.
	 * 
	 * @param initialSelection
	 *            The selection used to initialize the wizard.
	 * @return The editor creation wizard.
	 * @throws MMTFException
	 *             if the editor creation wizard couln't be found or
	 *             initialized.
	 * @generated NOT
	 */
	protected IWorkbenchWizard getInstanceWizard(IStructuredSelection initialSelection) throws MMTFException {

		Model modelType = MultiModelTypeRegistry.<Model>getType(getModelUri());
		IWorkbenchWizard wizard;
		if (getWizardId() == null) {
			EClass rootEClass = (EClass) ((EPackage) MultiModelTypeIntrospection.getRoot(modelType)).getEClassifiers().get(0);
			wizard = new DynamicModelWizard(rootEClass);
		}
		else {
			IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(getWizardId());
			if (descriptor == null) {
				throw new MMTFException("Wizard " + getId() + " not found");
			}
			try {
				wizard = descriptor.createWizard();
			}
			catch (CoreException e) {
				throw new MMTFException("Error creating the wizard", e);
			}
		}
		wizard.init(PlatformUI.getWorkbench(), initialSelection);

		return wizard;
	}

	/**
	 * Creates a custom editor instance creation wizard dialog for this editor
	 * type.
	 * 
	 * @param wizard
	 *            The editor creation wizard.
	 * @return The editor creation wizard dialog.
	 * @generated NOT
	 */
	protected EditorCreationWizardDialog createCustomInstanceWizard(IWorkbenchWizard wizard) {

		EditorCreationWizardDialog wizDialog;
		String wizardDialogClassName = getWizardDialogClass();
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		try {
			wizDialog = (EditorCreationWizardDialog)
				MultiModelTypeRegistry.getTypeBundle(getUri()).
				loadClass(wizardDialogClassName).
				getConstructor(Shell.class, IWizard.class).
				newInstance(shell, wizard);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "Custom editor creation wizard not found: " + wizardDialogClassName + " , using default as fallback", e);
			wizDialog = new EditorCreationWizardDialog(shell, wizard);
		}

		return wizDialog;
	}

	/**
	 * @generated NOT
	 */
	public EditorCreationWizardDialog invokeInstanceWizard(IStructuredSelection initialSelection) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		IWorkbenchWizard wizard = getInstanceWizard(initialSelection);
		EditorCreationWizardDialog wizDialog;
		if (getWizardDialogClass() == null) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			wizDialog = new EditorCreationWizardDialog(shell, wizard);
		}
		else {
			wizDialog = createCustomInstanceWizard(wizard);
		}
		wizDialog.setTitle(wizard.getWindowTitle());
		if (wizDialog.open() == Window.CANCEL) {
			return null;
		}

		return wizDialog;
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstance() throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		multiModel.getEditors().remove(this);
		// no need to removeExtendibleElement
	}

} //EditorImpl
