/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl#getModelElems <em>Model Elems</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ModelImpl#getConversionOperators <em>Conversion Operators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelImpl extends GenericElementImpl implements Model {
	/**
	 * The default value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected static final ModelOrigin ORIGIN_EDEFAULT = ModelOrigin.IMPORTED;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected ModelOrigin origin = ORIGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getFileExtension() <em>File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileExtension()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_EXTENSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFileExtension() <em>File Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileExtension()
	 * @generated
	 * @ordered
	 */
	protected String fileExtension = FILE_EXTENSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<Editor> editors;

	/**
	 * The cached value of the '{@link #getModelElems() <em>Model Elems</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElems()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElement> modelElems;

	/**
	 * The cached value of the '{@link #getConversionOperators() <em>Conversion Operators</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConversionOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<ConversionOperator> conversionOperators;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MIDPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelOrigin getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(ModelOrigin newOrigin) {
		ModelOrigin oldOrigin = origin;
		origin = newOrigin == null ? ORIGIN_EDEFAULT : newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.MODEL__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFileExtension() {
		return fileExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileExtension(String newFileExtension) {
		String oldFileExtension = fileExtension;
		fileExtension = newFileExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.MODEL__FILE_EXTENSION, oldFileExtension, fileExtension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Editor> getEditors() {
		if (editors == null) {
			editors = new EObjectResolvingEList<Editor>(Editor.class, this, MIDPackage.MODEL__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> getModelElems() {
		if (modelElems == null) {
			modelElems = new EObjectContainmentEList<ModelElement>(ModelElement.class, this, MIDPackage.MODEL__MODEL_ELEMS);
		}
		return modelElems;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConversionOperator> getConversionOperators() {
		if (conversionOperators == null) {
			conversionOperators = new EObjectResolvingEList<ConversionOperator>(ConversionOperator.class, this, MIDPackage.MODEL__CONVERSION_OPERATORS);
		}
		return conversionOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (Model) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getSupertype() {
		ExtendibleElement supertype = super.getSupertype();
		return (supertype == null) ? null : (Model) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MIDPackage.MODEL__MODEL_ELEMS:
				return ((InternalEList<?>)getModelElems()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MIDPackage.MODEL__ORIGIN:
				return getOrigin();
			case MIDPackage.MODEL__FILE_EXTENSION:
				return getFileExtension();
			case MIDPackage.MODEL__EDITORS:
				return getEditors();
			case MIDPackage.MODEL__MODEL_ELEMS:
				return getModelElems();
			case MIDPackage.MODEL__CONVERSION_OPERATORS:
				return getConversionOperators();
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
			case MIDPackage.MODEL__ORIGIN:
				setOrigin((ModelOrigin)newValue);
				return;
			case MIDPackage.MODEL__FILE_EXTENSION:
				setFileExtension((String)newValue);
				return;
			case MIDPackage.MODEL__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends Editor>)newValue);
				return;
			case MIDPackage.MODEL__MODEL_ELEMS:
				getModelElems().clear();
				getModelElems().addAll((Collection<? extends ModelElement>)newValue);
				return;
			case MIDPackage.MODEL__CONVERSION_OPERATORS:
				getConversionOperators().clear();
				getConversionOperators().addAll((Collection<? extends ConversionOperator>)newValue);
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
			case MIDPackage.MODEL__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case MIDPackage.MODEL__FILE_EXTENSION:
				setFileExtension(FILE_EXTENSION_EDEFAULT);
				return;
			case MIDPackage.MODEL__EDITORS:
				getEditors().clear();
				return;
			case MIDPackage.MODEL__MODEL_ELEMS:
				getModelElems().clear();
				return;
			case MIDPackage.MODEL__CONVERSION_OPERATORS:
				getConversionOperators().clear();
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
			case MIDPackage.MODEL__ORIGIN:
				return origin != ORIGIN_EDEFAULT;
			case MIDPackage.MODEL__FILE_EXTENSION:
				return FILE_EXTENSION_EDEFAULT == null ? fileExtension != null : !FILE_EXTENSION_EDEFAULT.equals(fileExtension);
			case MIDPackage.MODEL__EDITORS:
				return editors != null && !editors.isEmpty();
			case MIDPackage.MODEL__MODEL_ELEMS:
				return modelElems != null && !modelElems.isEmpty();
			case MIDPackage.MODEL__CONVERSION_OPERATORS:
				return conversionOperators != null && !conversionOperators.isEmpty();
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
			switch (baseOperationID) {
				case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE: return MIDPackage.MODEL___GET_METATYPE;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
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
			case MIDPackage.MODEL___GET_METATYPE:
				return getMetatype();
			case MIDPackage.MODEL___GET_SUPERTYPE:
				return getSupertype();
			case MIDPackage.MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN:
				try {
					return createSubtype((String)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (Boolean)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___DELETE_TYPE:
				try {
					deleteType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___GET_EMF_TYPE_ROOT:
				try {
					return getEMFTypeRoot();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___OPEN_TYPE:
				try {
					openType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___CREATE_INSTANCE__STRING_MID:
				try {
					return createInstance((String)arguments.get(0), (MID)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___CREATE_INSTANCE_EDITOR:
				try {
					return createInstanceEditor();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MID:
				try {
					return createInstanceAndEditor((String)arguments.get(0), (MID)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___IMPORT_INSTANCE__STRING_MID:
				try {
					return importInstance((String)arguments.get(0), (MID)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___IMPORT_INSTANCE_AND_EDITOR__STRING_MID:
				try {
					return importInstanceAndEditor((String)arguments.get(0), (MID)arguments.get(1));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___COPY_INSTANCE__MODEL_STRING_MID:
				try {
					return copyInstance((Model)arguments.get(0), (String)arguments.get(1), (MID)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___COPY_INSTANCE_AND_EDITOR__MODEL_STRING_BOOLEAN_MID:
				try {
					return copyInstanceAndEditor((Model)arguments.get(0), (String)arguments.get(1), (Boolean)arguments.get(2), (MID)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___DELETE_INSTANCE:
				try {
					deleteInstance();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___GET_EMF_INSTANCE_ROOT:
				try {
					return getEMFInstanceRoot();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL___OPEN_INSTANCE:
				try {
					openInstance();
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
		result.append(" (origin: ");
		result.append(origin);
		result.append(", fileExtension: ");
		result.append(fileExtension);
		result.append(')');
		return result.toString();
	}

	/**
	 * Adds a subtype of this model type to the Type MID, together with an
	 * editor type for it.
	 * 
	 * @param newModelType
	 *            The new model type to be added.
	 * @param newModelTypeName
	 *            The name of the new model type.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model type, null if no constraint is associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model type, null if no constraint is associated.
	 * @param isMetamodelExtension
	 *            True if the new model type is extending the supertype's
	 *            metamodel, false otherwise.
	 * @throws MMINTException
	 *             If the uri of the new model type is already registered in the
	 *             Type MID.
	 * @generated NOT
	 */
	protected void addSubtype(Model newModelType, String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException {

		MID typeMID = MultiModelRegistry.getMultiModel(this);
		super.addSubtype(newModelType, this, null, newModelTypeName);
		MultiModelTypeFactory.addModelType(newModelType, constraintLanguage, constraintImplementation, typeMID);
		newModelType.setOrigin(ModelOrigin.CREATED);

		if (isMetamodelExtension) {
			try {
				String newMetamodelUri = MultiModelTypeRegistry.getExtendedMetamodelUri(newModelType);
				if (newMetamodelUri == null) { // create new metamodel file
					EPackage newEPackage = EcoreFactory.eINSTANCE.createEPackage();
					newEPackage.setName(newModelTypeName.toLowerCase());
					newEPackage.setNsPrefix(newModelTypeName.toLowerCase());
					newEPackage.setNsURI(newModelType.getUri());
					EAnnotation newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
					newEAnnotation.setSource(EcorePackage.eNS_URI);
					EMap<String, String> newEAnnotationDetails = newEAnnotation.getDetails();
					newEAnnotationDetails.put(MultiModelTypeFactory.ECORE_INVOCATION_DELEGATE, MultiModelTypeFactory.ECORE_PIVOT_URI);
					newEAnnotationDetails.put(MultiModelTypeFactory.ECORE_SETTING_DELEGATE, MultiModelTypeFactory.ECORE_PIVOT_URI);
					newEAnnotationDetails.put(MultiModelTypeFactory.ECORE_VALIDATION_DELEGATE, MultiModelTypeFactory.ECORE_PIVOT_URI);
					newEPackage.getEAnnotations().add(newEAnnotation);
					EClass newRootEClass = EcoreFactory.eINSTANCE.createEClass();
					newRootEClass.setName(newModelTypeName);
					if (!MultiModelTypeHierarchy.isRootType(this)) {
						EClass rootEClass = (EClass) getEMFTypeRoot().getEClassifiers().get(0);
						newRootEClass.getESuperTypes().add(rootEClass);
					}
					newEPackage.getEClassifiers().add(newRootEClass);
					newMetamodelUri = newModelTypeName + "." + EcorePackage.eNAME;
					MultiModelUtils.createModelFileInState(newEPackage, newMetamodelUri);
				}
				newModelType.setFileExtension(MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Error creating extended metamodel file, fallback to no extension", e);
				newModelType.setFileExtension(getFileExtension());
				isMetamodelExtension = false;
			}
		}
		else {
			newModelType.setFileExtension(getFileExtension());
		}

		// create editors
		String newEditorTypeFragmentUri = newModelType.getName(), newEditorTypeName, newModelTypeUri = newModelType.getUri(), editorId, wizardId, wizardDialogClassName;
		for (Editor editorType : getEditors()) {
			if (isMetamodelExtension) {
				if (editorType instanceof Diagram) {
					continue;
				}
				newEditorTypeName = MMINT.ROOT_EDITOR_NAME;
				editorId = MMINT.ROOT_EDITOR_ID;
				wizardId = null;
				wizardDialogClassName = null;
			}
			else {
				newEditorTypeName = editorType.getName();
				editorId = editorType.getId();
				wizardId = editorType.getWizardId();
				wizardDialogClassName = editorType.getWizardDialogClass();
			}
			try {
				//TODO MMINT[EDITOR] a new editor is created instead of attaching existing ones
				//TODO MMINT[EDITOR] because I couldn't find a way then from an editor to understand which model was being created
				Editor newEditorType = editorType.createSubtype(newEditorTypeFragmentUri, newEditorTypeName, newModelTypeUri, editorId, wizardId, wizardDialogClassName);
				MultiModelTypeFactory.addModelTypeEditor(newEditorType, newModelType);
				if (isMetamodelExtension) { // reflective editor only
					newEditorType.getFileExtensions().clear();
					newEditorType.getFileExtensions().add(MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION);
					break;
				}
			}
			catch (MMINTException e) {
				// models created through this editor will have the supermodel as static type
				MultiModelTypeFactory.addModelTypeEditor(editorType, newModelType);
			}
		}
	}

	/**
	 * @generated NOT
	 */
	public Model createSubtype(String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException {

		MMINTException.mustBeType(this);

		Model newModelType = MIDFactory.eINSTANCE.createModel();
		this.addSubtype(newModelType, newModelTypeName, constraintLanguage, constraintImplementation, isMetamodelExtension);

		return newModelType;
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMINTException {

		MMINTException.mustBeType(this);

		MID typeMID = MultiModelRegistry.getMultiModel(this);
		// delete the "thing"
		for (ModelElement modelElemType : getModelElems()) {
			super.delete(modelElemType.getUri(), typeMID);
		}
		List<Editor> delEditorTypes = new ArrayList<Editor>(getEditors());
		for (Editor delEditorType : delEditorTypes) {
			delEditorType.deleteType();
		}
		super.deleteType();
		typeMID.getModels().remove(this);
		String metamodelUri = MultiModelTypeRegistry.getExtendedMetamodelUri(this);
		if (metamodelUri != null) {
			MultiModelUtils.deleteFile(metamodelUri, false);
		}
		// delete operator types that use this model type
		List<Operator> delOperatorTypes = new ArrayList<>();
		for (Operator operatorType : MultiModelRegistry.getOperators(typeMID)) {
			for (ModelEndpoint inputModelTypeEndpoint : operatorType.getInputs()) {
				if (inputModelTypeEndpoint.getTargetUri().equals(getUri()) && !delOperatorTypes.contains(operatorType)) {
					delOperatorTypes.add(operatorType);
				}
			}
			for (ModelEndpoint outputModelTypeEndpoint : operatorType.getOutputs()) {
				if (outputModelTypeEndpoint.getTargetUri().equals(getUri()) && !delOperatorTypes.contains(operatorType)) {
					delOperatorTypes.add(operatorType);
				}
			}
		}
		for (Operator operatorType : delOperatorTypes) {
			operatorType.deleteType();
		}
		// delete model relationship types that use this model type
		List<ModelRel> delModelRelTypes = new ArrayList<>();
		List<ModelEndpoint> delModelTypeEndpoints = new ArrayList<>();
		for (ModelRel modelRelType : MultiModelRegistry.getModelRels(typeMID)) {
			for (ModelEndpoint modelTypeEndpoint : modelRelType.getModelEndpoints()) {
				if (modelTypeEndpoint.getTargetUri().equals(getUri())) {
					if (modelRelType instanceof BinaryModelRel) {
						if (!delModelRelTypes.contains(modelRelType)) {
							delModelRelTypes.add(modelRelType);
						}
					}
					else {
						delModelTypeEndpoints.add(modelTypeEndpoint);
					}
				}
			}
		}
		for (ModelEndpoint modelTypeEndpoint : delModelTypeEndpoints) {
			modelTypeEndpoint.deleteTypeAndReference(true);
		}
		for (ModelRel modelRelType : delModelRelTypes) {
			modelRelType.deleteType();
		}
		// delete the subtypes of the "thing"
		for (Model modelSubtype : MultiModelTypeHierarchy.getDirectSubtypes(this, typeMID)) {
			modelSubtype.deleteType();
		}
	}

	/**
	 * @generated NOT
	 */
	public EPackage getEMFTypeRoot() throws MMINTException {

		MMINTException.mustBeType(this);

		EPackage rootModelTypeObj;
		if (!isDynamic()) { // get package from registry
			rootModelTypeObj = EPackage.Registry.INSTANCE.getEPackage(getUri());
		}
		else {
			String metamodelUri = MultiModelTypeRegistry.getExtendedMetamodelUri(this);
			if (metamodelUri != null) { // get package from metamodel file
				try {
					rootModelTypeObj = (EPackage) MultiModelUtils.getModelFile(metamodelUri, false);
				}
				catch (Exception e) {
					throw new MMINTException("Error accessing the metamodel file for model type" + getUri(), e);
				}
			}
			else { // climb up light types
				rootModelTypeObj = getSupertype().getEMFTypeRoot();
			}
		}

		return rootModelTypeObj;
	}

	/**
	 * @generated NOT
	 */
	public void openType() throws Exception {

		MMINTException.mustBeType(this);

		Model modelType = this;
		List<URI> metamodelUris = new ArrayList<>();
		//TODO MMINT[EDITOR] fix a) references to inherited metamodels not good in runtime eclipse b) open UML
		while (true) {
			if (modelType.isDynamic()) {
				String metamodelUri = MultiModelTypeRegistry.getExtendedMetamodelUri(modelType);
				if (metamodelUri != null) { // get metamodel file from mmint state area
					metamodelUris.add(URI.createFileURI(metamodelUri));
					break;
				}
			}
			else { // get metamodel files from bundle
				Bundle bundle = MultiModelTypeRegistry.getTypeBundle(modelType.getUri());
				Enumeration<URL> metamodels = bundle.findEntries("/", "*." + EcorePackage.eNAME, true);
				while (metamodels.hasMoreElements()) {
					metamodelUris.add(URI.createURI(FileLocator.toFileURL(metamodels.nextElement()).toString()));
				}
				break;
			}
			// climb up light types
			modelType = modelType.getSupertype();
		}

		// open editors
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		Model ecoreModelType = MultiModelTypeRegistry.getType(EcorePackage.eNS_URI);
		Editor ecoreEditorType = ecoreModelType.getEditors().get(0);
		for (URI metamodelUri : metamodelUris) {
			activePage.openEditor(new URIEditorInput(metamodelUri), ecoreEditorType.getId());
			//TODO MMINT[ECORE] Try to open ecore diagram
			//String metamodelDiagramUri = metamodelUri.toFileString() + GMFDiagramUtils.DIAGRAM_SUFFIX;
		}
	}

	/**
	 * Adds a model instance of this model type to an Instance MID, or simply
	 * adds additional info to the model instance.
	 * 
	 * @param newModel
	 *            The new model to be added.
	 * @param newModelUri
	 *            The uri of the new model, null if the new model is not in a
	 *            separate file; e.g. a model and a standalone model
	 *            relationship are in their own files, a plain model
	 *            relationship is not.
	 * @param origin
	 *            The origin of the new model.
	 * @param instanceMID
	 *            An Instance MID, null if the model isn't going to be added to
	 *            it.
	 * @throws MMINTException
	 *             If the uri of the new model is already registered in the
	 *             Instance MID.
	 * @generated NOT
	 */
	protected void addInstance(Model newModel, String newModelUri, ModelOrigin origin, MID instanceMID) throws MMINTException {

		boolean externalElement = newModelUri != null;
		boolean updateMID = instanceMID != null;
		boolean basicElement = !updateMID || !externalElement;

		String newModelName = null;
		String fileExtension = MMINT.EMPTY_MODEL_FILE_EXTENSION;
		if (externalElement) {
			newModelName = MultiModelUtils.getFileNameFromUri(newModelUri);
			fileExtension = MultiModelUtils.getFileExtensionFromUri(newModelUri);
		}
		if (basicElement) {
			super.addBasicInstance(newModel, newModelUri, newModelName);
		}
		else {
			super.addInstance(newModel, newModelUri, newModelName, instanceMID);
		}
		if (updateMID) {
			instanceMID.getModels().add(newModel);
		}
		newModel.setOrigin(origin);
		newModel.setFileExtension(fileExtension);
	}

	/**
	 * @generated NOT
	 */
	public Model createInstance(String newModelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		Model newModel = MIDFactory.eINSTANCE.createModel();
		this.addInstance(newModel, newModelUri, ModelOrigin.CREATED, instanceMID);

		return newModel;
	}

	/**
	 * @generated NOT
	 */
	public Editor createInstanceEditor() throws MMINTException {

		MMINTException.mustBeInstance(this);

		MID instanceMID = MultiModelRegistry.getMultiModel(this);
		Editor newEditor = null;
		//TODO MMINT[EDITOR] prioritize editors list instead of running twice?
		// all diagrams are tried..
		for (Editor diagramType : MultiModelTypeRegistry.getModelTypeEditors(getMetatypeUri())) {
			if (!(diagramType instanceof Diagram)) {
				continue;
			}
			try {
				newEditor = diagramType.createInstance(getUri(), instanceMID);
				break;
			}
			catch (MMINTException e) {
				continue;
			}
		}
		// ..or first editor is used
		if (newEditor == null) {
			for (Editor editorType : MultiModelTypeRegistry.getModelTypeEditors(getMetatypeUri())) {
				if (editorType instanceof Diagram) {
					continue;
				}
				newEditor = editorType.createInstance(getUri(), instanceMID);
				break;
			}
		}
		if (newEditor == null) {
			throw new MMINTException("No editor type found");
		}
		getEditors().add(newEditor);

		return newEditor;
	}

	/**
	 * @generated NOT
	 */
	public Model createInstanceAndEditor(String newModelUri, MID instanceMID) throws MMINTException {

		Model newModel = this.createInstance(newModelUri, instanceMID);
		if (instanceMID != null) {
			newModel.createInstanceEditor();
		}

		return newModel;
	}

	/**
	 * @generated NOT
	 */
	public Model importInstance(String modelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		Model newModel = MIDFactory.eINSTANCE.createModel();
		this.addInstance(newModel, modelUri, ModelOrigin.IMPORTED, instanceMID);

		return newModel;
	}

	/**
	 * @generated NOT
	 */
	public Model importInstanceAndEditor(String modelUri, MID instanceMID) throws MMINTException {

		Model newModel = importInstance(modelUri, instanceMID);
		if (instanceMID != null) {
			newModel.createInstanceEditor();
		}

		return newModel;
	}

	/**
	 * @generated NOT
	 */
	public Model copyInstance(Model origModel, String newModelName, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		// copy model
		String newModelUri = MultiModelUtils.replaceFileNameInUri(origModel.getUri(), newModelName);
		try {
			MultiModelUtils.copyTextFileAndReplaceText(
				origModel.getUri(),
				newModelUri,
				origModel.getName() + MMINT.MODEL_FILEEXTENSION_SEPARATOR,
				newModelName + MMINT.MODEL_FILEEXTENSION_SEPARATOR,
				true);
		} catch (Exception e) {
			throw new MMINTException("Error copying model file");
		}
		Model newModel = createInstance(newModelUri, instanceMID);

		return newModel;
	}

	/**
	 * @generated NOT
	 */
	public Model copyInstanceAndEditor(Model origModel, String newModelName, boolean copyDiagram, MID instanceMID) throws MMINTException {

		Model newModel = copyInstance(origModel, newModelName, instanceMID);
		// copy diagrams
		if (copyDiagram) {
			for (Editor oldEditor : origModel.getEditors()) {
				if (oldEditor.getUri().equals(origModel.getUri())) {
					continue;
				}
				try {
					MultiModelUtils.copyTextFileAndReplaceText(
						oldEditor.getUri(),
						MultiModelUtils.replaceFileNameInUri(oldEditor.getUri(), newModelName),
						origModel.getName() + MMINT.MODEL_FILEEXTENSION_SEPARATOR,
						newModelName + MMINT.MODEL_FILEEXTENSION_SEPARATOR,
						true);
				} catch (Exception e) {
					MMINTException.print(IStatus.WARNING, "Error copying diagram file, skipping it", e);
					continue;
				}
				//TODO MMINT[UML] add support for notation extra file (e.g. in UML)
			}
		}
		newModel.createInstanceEditor();

		return newModel;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean validateInstanceType(ExtendibleElement type) throws MMINTException {

		MMINTException.mustBeInstance(this);
		MMINTException.mustBeType(type);

		return MultiModelConstraintChecker.checkConstraint(this, type.getConstraint());
	}

	/**
	 * @generated NOT
	 */
	@Override
	public boolean validateInstance() throws MMINTException {

		MMINTException.mustBeInstance(this);

		boolean validates = MultiModelConstraintChecker.checkConstraint(this, this.getConstraint());

		return validates && this.validateInstanceType(this.getMetatype());
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstance() throws MMINTException {

		MMINTException.mustBeInstance(this);

		MID instanceMID = MultiModelRegistry.getMultiModel(this);
		for (ModelElement modelElem : getModelElems()) {
			super.delete(modelElem.getUri(), instanceMID);
		}
		super.deleteInstance();
		instanceMID.getModels().remove(this);
		// delete editors for this model
		for (Editor editor : getEditors()) {
			editor.deleteInstance();
		}
		// delete operators that use this model type
		List<Operator> delOperators = new ArrayList<>();
		for (Operator operator : MultiModelRegistry.getOperators(instanceMID)) {
			for (ModelEndpoint inputModelEndpoint : operator.getInputs()) {
				if (inputModelEndpoint.getTargetUri().equals(getUri()) && !delOperators.contains(operator)) {
					delOperators.add(operator);
				}
			}
			for (ModelEndpoint outputModelEndpoint : operator.getOutputs()) {
				if (outputModelEndpoint.getTargetUri().equals(getUri()) && !delOperators.contains(operator)) {
					delOperators.add(operator);
				}
			}
		}
		for (Operator operatorType : delOperators) {
			operatorType.deleteInstance();
		}
		// delete model relationships that use this model
		List<ModelRel> delModelRels = new ArrayList<>();
		List<ModelEndpoint> delModelEndpoints = new ArrayList<>();
		for (ModelRel modelRel : MultiModelRegistry.getModelRels(instanceMID)) {
			for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
				if (modelEndpoint.getTargetUri().equals(getUri())) {
					if (modelRel instanceof BinaryModelRel) {
						if (!delModelRels.contains(modelRel)) {
							delModelRels.add(modelRel);
						}
					}
					else {
						delModelEndpoints.add(modelEndpoint);
					}
				}
			}
		}
		for (ModelEndpoint modelEndpoint : delModelEndpoints) {
			modelEndpoint.deleteInstanceAndReference(true);
		}
		for (ModelRel modelRel : delModelRels) {
			modelRel.deleteInstance();
		}
	}

	/**
	 * @generated NOT
	 */
	public EObject getEMFInstanceRoot() throws MMINTException {

		MMINTException.mustBeInstance(this);

		EObject rootModelObj;
		try {
			rootModelObj = MultiModelUtils.getModelFile(getUri(), true);
		}
		catch (Exception e) {
			throw new MMINTException("Error accessing the model file for model " + getUri(), e);
		}

		return rootModelObj;
	}

	/**
	 * @generated NOT
	 */
	public void openInstance() throws Exception {

		MMINTException.mustBeInstance(this);

		Editor editor = this.getEditors().get(0);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
			new URIEditorInput(
				URI.createPlatformResourceURI(editor.getUri(), true)
			),
			editor.getId()
		);
	}

} //ModelImpl
