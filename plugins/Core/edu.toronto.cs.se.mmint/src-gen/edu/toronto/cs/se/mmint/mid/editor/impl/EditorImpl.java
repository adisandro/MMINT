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
package edu.toronto.cs.se.mmint.mid.editor.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.presentation.DynamicModelWizard;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementImpl;
import edu.toronto.cs.se.mmint.mid.ui.EditorCreationWizardDialog;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Editor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.editor.impl.EditorImpl#getModelUri <em>Model Uri</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.editor.impl.EditorImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.editor.impl.EditorImpl#getWizardId <em>Wizard Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.editor.impl.EditorImpl#getFileExtensions <em>File Extensions</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.editor.impl.EditorImpl#getWizardDialogClass <em>Wizard Dialog Class</em>}</li>
 * </ul>
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
    protected String modelUri = EditorImpl.MODEL_URI_EDEFAULT;

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
    protected String id = EditorImpl.ID_EDEFAULT;

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
    protected String wizardId = EditorImpl.WIZARD_ID_EDEFAULT;

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
    protected String wizardDialogClass = EditorImpl.WIZARD_DIALOG_CLASS_EDEFAULT;

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
    @Override
    public String getModelUri() {
    return this.modelUri;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setModelUri(String newModelUri) {
    var oldModelUri = this.modelUri;
    this.modelUri = newModelUri;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__MODEL_URI, oldModelUri, this.modelUri));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getId() {
    return this.id;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setId(String newId) {
    var oldId = this.id;
    this.id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__ID, oldId, this.id));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getWizardId() {
    return this.wizardId;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setWizardId(String newWizardId) {
    var oldWizardId = this.wizardId;
    this.wizardId = newWizardId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__WIZARD_ID, oldWizardId, this.wizardId));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public EList<String> getFileExtensions() {
    if (this.fileExtensions == null) {
      this.fileExtensions = new EDataTypeUniqueEList<>(String.class, this, EditorPackage.EDITOR__FILE_EXTENSIONS);
    }
    return this.fileExtensions;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getWizardDialogClass() {
    return this.wizardDialogClass;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setWizardDialogClass(String newWizardDialogClass) {
    var oldWizardDialogClass = this.wizardDialogClass;
    this.wizardDialogClass = newWizardDialogClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EditorPackage.EDITOR__WIZARD_DIALOG_CLASS, oldWizardDialogClass, this.wizardDialogClass));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Editor getMetatype() {
    var metatype = super.getMetatype();
    return (metatype == null) ? null : (Editor) metatype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Editor getSupertype() {
    var supertype = super.getSupertype();
    return (supertype == null) ? null : (Editor) supertype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public MID getMIDContainer() {
    return (MID) this.eContainer();
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
        setModelUri(EditorImpl.MODEL_URI_EDEFAULT);
        return;
      case EditorPackage.EDITOR__ID:
        setId(EditorImpl.ID_EDEFAULT);
        return;
      case EditorPackage.EDITOR__WIZARD_ID:
        setWizardId(EditorImpl.WIZARD_ID_EDEFAULT);
        return;
      case EditorPackage.EDITOR__FILE_EXTENSIONS:
        getFileExtensions().clear();
        return;
      case EditorPackage.EDITOR__WIZARD_DIALOG_CLASS:
        setWizardDialogClass(EditorImpl.WIZARD_DIALOG_CLASS_EDEFAULT);
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
        return EditorImpl.MODEL_URI_EDEFAULT == null ? this.modelUri != null : !EditorImpl.MODEL_URI_EDEFAULT.equals(this.modelUri);
      case EditorPackage.EDITOR__ID:
        return EditorImpl.ID_EDEFAULT == null ? this.id != null : !EditorImpl.ID_EDEFAULT.equals(this.id);
      case EditorPackage.EDITOR__WIZARD_ID:
        return EditorImpl.WIZARD_ID_EDEFAULT == null ? this.wizardId != null : !EditorImpl.WIZARD_ID_EDEFAULT.equals(this.wizardId);
      case EditorPackage.EDITOR__FILE_EXTENSIONS:
        return this.fileExtensions != null && !this.fileExtensions.isEmpty();
      case EditorPackage.EDITOR__WIZARD_DIALOG_CLASS:
        return EditorImpl.WIZARD_DIALOG_CLASS_EDEFAULT == null ? this.wizardDialogClass != null : !EditorImpl.WIZARD_DIALOG_CLASS_EDEFAULT.equals(this.wizardDialogClass);
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == ExtendibleElement.class) {
      return switch (baseOperationID) {
      case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE -> EditorPackage.EDITOR___GET_METATYPE;
      case MIDPackage.EXTENDIBLE_ELEMENT___GET_MID_CONTAINER -> EditorPackage.EDITOR___GET_MID_CONTAINER;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
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
      case EditorPackage.EDITOR___GET_MID_CONTAINER:
        return getMIDContainer();
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
      case EditorPackage.EDITOR___CREATE_INSTANCE__STRING_BOOLEAN_MID:
        try {
          return createInstance((String)arguments.get(0), (Boolean)arguments.get(1), (MID)arguments.get(2));
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (modelUri: ");
    result.append(this.modelUri);
    result.append(", id: ");
    result.append(this.id);
    result.append(", wizardId: ");
    result.append(this.wizardId);
    result.append(", fileExtensions: ");
    result.append(this.fileExtensions);
    result.append(", wizardDialogClass: ");
    result.append(this.wizardDialogClass);
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
     * @throws MMINTException
     *             If the uri of the new editor type is already registered in
     *             the Type MID.
     * @generated NOT
     */
    protected void addSubtype(Editor newEditorType, String newEditorTypeFragmentUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName) throws MMINTException {

        var typeMID = this.getMIDContainer();
        super.addSubtype(newEditorType, this, newEditorTypeFragmentUri, newEditorTypeName);
        MIDTypeFactory.addEditorType(newEditorType, modelTypeUri, editorId, wizardId, wizardDialogClassName, typeMID);

        for (String fileExtension : this.getFileExtensions()) {
            newEditorType.getFileExtensions().add(fileExtension);
        }
    }

    /**
     * @generated NOT
     */
    @Override
    public Editor createSubtype(String newEditorTypeFragmentUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName) throws MMINTException {

        MMINTException.mustBeType(this);

        var newEditorType = super.<Editor>createThisEClass();
        this.addSubtype(newEditorType, newEditorTypeFragmentUri, newEditorTypeName, modelTypeUri, editorId, wizardId, wizardDialogClassName);

        return newEditorType;
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteType() throws MMINTException {

        MMINTException.mustBeType(this);

        var typeMID = this.getMIDContainer();
        super.delete();
        var modelType = typeMID.<Model>getExtendibleElement(this.getModelUri());
        if (modelType != null) {
            modelType.getEditors().remove(this);
        }
        typeMID.getEditors().remove(this);
        for (Editor editorSubtype : MIDTypeHierarchy.getDirectSubtypes(this, typeMID)) {
            editorSubtype.deleteType();
        }
    }

    /**
     * Adds an editor instance of this editor type to an Instance MID, or simply adds additional info to the editor
     * instance.
     *
     * @param newEditor
     *            The new editor to be added.
     * @param editorPath
     *            The uri of the new editor.
     * @param modelPath
     *            The uri of the model handled by the new editor.
     * @param instanceMID
     *            An Instance MID, null if the editor isn't going to be added to it.
     * @return The created editor.
     * @generated NOT
     */
    protected void addInstance(Editor newEditor, String editorPath, String modelPath, MID instanceMID) {

        var newEditorName = this.getName() + " for model " + modelPath;
        super.addBasicInstance(newEditor, editorPath, newEditorName, MIDLevel.INSTANCES);
        newEditor.setModelUri(modelPath);
        newEditor.setId(this.getId());
        newEditor.setWizardId(this.getWizardId());
        if (editorPath.contains(MMINTConstants.MODEL_URI_SEPARATOR)) { // Sirius
          editorPath = MIDRegistry.getModelUri(editorPath);
        }
        newEditor.getFileExtensions().add(FileUtils.getFileExtensionFromPath(editorPath));
        if (instanceMID != null) {
          instanceMID.getEditors().add(newEditor);
        }
    }

    /**
     * @generated NOT
     */
    @Override
    public Editor createInstance(String modelPath, boolean createEditorFile, MID instanceMID) throws MMINTException {

        MMINTException.mustBeType(this);

        var newEditor = super.<Editor>createThisEClass();
        this.addInstance(newEditor, modelPath, modelPath, instanceMID);
        // an editor is an EMF tree editor, so it never needs to create the editor file, which is the model itself

        return newEditor;
    }

    /**
     * Gets an editor instance creation wizard for this editor type.
     *
     * @param initialSelection
     *            The selection used to initialize the wizard.
     * @return The editor creation wizard.
     * @throws MMINTException
     *             if the editor creation wizard couln't be found or
     *             initialized.
     * @generated NOT
     */
    protected IWorkbenchWizard getInstanceWizard(IStructuredSelection initialSelection) throws MMINTException {

        Model modelType = MIDTypeRegistry.<Model>getType(this.getModelUri());
        IWorkbenchWizard wizard;
        if (this.getWizardId() == null) {
            var rootEClass = (EClass) modelType.getEMFTypeRoot().getEClassifiers().get(0);
            wizard = new DynamicModelWizard(rootEClass);
        }
        else {
            var descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(this.getWizardId());
            if (descriptor == null) {
                throw new MMINTException("Wizard " + this.getId() + " not found");
            }
            try {
                wizard = descriptor.createWizard();
            }
            catch (CoreException e) {
                throw new MMINTException("Error creating the wizard", e);
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
        var wizardDialogClassName = this.getWizardDialogClass();
        try {
            wizDialog = (EditorCreationWizardDialog)
                MIDTypeRegistry.getTypeBundle(this.getUri()).
                loadClass(wizardDialogClassName).
                getConstructor(IWizard.class).
                newInstance(wizard);
        }
        catch (Exception e) {
            MMINTException.print(IStatus.WARNING, "Custom editor creation wizard not found: " + wizardDialogClassName + " , using default as fallback", e);
            wizDialog = new EditorCreationWizardDialog(wizard);
        }

        return wizDialog;
    }

    /**
     * @generated NOT
     */
    @Override
    public EditorCreationWizardDialog invokeInstanceWizard(IStructuredSelection initialSelection) throws MMINTException {

        MMINTException.mustBeType(this);

        var wizard = this.getInstanceWizard(initialSelection);
        EditorCreationWizardDialog wizDialog;
        wizDialog = (this.getWizardDialogClass() == null) ?
            new EditorCreationWizardDialog(wizard) :
            this.createCustomInstanceWizard(wizard);
        wizDialog.setTitle(wizard.getWindowTitle());
        if (wizDialog.open() == Window.CANCEL) {
            return null;
        }

        return wizDialog;
    }

    /**
     * @generated NOT
     */
    @Override
    public void deleteInstance() throws MMINTException {

        MMINTException.mustBeInstance(this);

        this.getMIDContainer().getEditors().remove(this);
        // no need to super.delete()
    }

} //EditorImpl
