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
package edu.toronto.cs.se.mmtf.mid.impl;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mavo.MAVOModel;
import edu.toronto.cs.se.mmtf.mavo.MavoPackage;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.editor.Diagram;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl#isInc <em>Inc</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl#getFileExtension <em>File Extension</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl#getModelElems <em>Model Elems</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl#getConversionOperators <em>Conversion Operators</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelImpl extends ExtendibleElementImpl implements Model {
	/**
	 * The default value of the '{@link #isInc() <em>Inc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInc()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInc() <em>Inc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInc()
	 * @generated
	 * @ordered
	 */
	protected boolean inc = INC_EDEFAULT;

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
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

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
		return MidPackage.Literals.MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInc() {
		return inc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInc(boolean newInc) {
		boolean oldInc = inc;
		inc = newInc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.MODEL__INC, oldInc, inc));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.MODEL__ORIGIN, oldOrigin, origin));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.MODEL__FILE_EXTENSION, oldFileExtension, fileExtension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Editor> getEditors() {
		if (editors == null) {
			editors = new EObjectResolvingEList<Editor>(Editor.class, this, MidPackage.MODEL__EDITORS);
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
			modelElems = new EObjectContainmentEList<ModelElement>(ModelElement.class, this, MidPackage.MODEL__MODEL_ELEMS);
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
			conversionOperators = new EObjectResolvingEList<ConversionOperator>(ConversionOperator.class, this, MidPackage.MODEL__CONVERSION_OPERATORS);
		}
		return conversionOperators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.MODEL__ABSTRACT, oldAbstract, abstract_));
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
			case MidPackage.MODEL__MODEL_ELEMS:
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
			case MidPackage.MODEL__INC:
				return isInc();
			case MidPackage.MODEL__ORIGIN:
				return getOrigin();
			case MidPackage.MODEL__FILE_EXTENSION:
				return getFileExtension();
			case MidPackage.MODEL__EDITORS:
				return getEditors();
			case MidPackage.MODEL__MODEL_ELEMS:
				return getModelElems();
			case MidPackage.MODEL__CONVERSION_OPERATORS:
				return getConversionOperators();
			case MidPackage.MODEL__ABSTRACT:
				return isAbstract();
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
			case MidPackage.MODEL__INC:
				setInc((Boolean)newValue);
				return;
			case MidPackage.MODEL__ORIGIN:
				setOrigin((ModelOrigin)newValue);
				return;
			case MidPackage.MODEL__FILE_EXTENSION:
				setFileExtension((String)newValue);
				return;
			case MidPackage.MODEL__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends Editor>)newValue);
				return;
			case MidPackage.MODEL__MODEL_ELEMS:
				getModelElems().clear();
				getModelElems().addAll((Collection<? extends ModelElement>)newValue);
				return;
			case MidPackage.MODEL__CONVERSION_OPERATORS:
				getConversionOperators().clear();
				getConversionOperators().addAll((Collection<? extends ConversionOperator>)newValue);
				return;
			case MidPackage.MODEL__ABSTRACT:
				setAbstract((Boolean)newValue);
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
			case MidPackage.MODEL__INC:
				setInc(INC_EDEFAULT);
				return;
			case MidPackage.MODEL__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case MidPackage.MODEL__FILE_EXTENSION:
				setFileExtension(FILE_EXTENSION_EDEFAULT);
				return;
			case MidPackage.MODEL__EDITORS:
				getEditors().clear();
				return;
			case MidPackage.MODEL__MODEL_ELEMS:
				getModelElems().clear();
				return;
			case MidPackage.MODEL__CONVERSION_OPERATORS:
				getConversionOperators().clear();
				return;
			case MidPackage.MODEL__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
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
			case MidPackage.MODEL__INC:
				return inc != INC_EDEFAULT;
			case MidPackage.MODEL__ORIGIN:
				return origin != ORIGIN_EDEFAULT;
			case MidPackage.MODEL__FILE_EXTENSION:
				return FILE_EXTENSION_EDEFAULT == null ? fileExtension != null : !FILE_EXTENSION_EDEFAULT.equals(fileExtension);
			case MidPackage.MODEL__EDITORS:
				return editors != null && !editors.isEmpty();
			case MidPackage.MODEL__MODEL_ELEMS:
				return modelElems != null && !modelElems.isEmpty();
			case MidPackage.MODEL__CONVERSION_OPERATORS:
				return conversionOperators != null && !conversionOperators.isEmpty();
			case MidPackage.MODEL__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MAVOModel.class) {
			switch (derivedFeatureID) {
				case MidPackage.MODEL__INC: return MavoPackage.MAVO_MODEL__INC;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MAVOModel.class) {
			switch (baseFeatureID) {
				case MavoPackage.MAVO_MODEL__INC: return MidPackage.MODEL__INC;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MidPackage.MODEL___GET_METATYPE:
				return getMetatype();
			case MidPackage.MODEL___GET_SUPERTYPE:
				return getSupertype();
			case MidPackage.MODEL___CREATE_SUBTYPE__STRING_STRING_STRING_BOOLEAN:
				try {
					return createSubtype((String)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (Boolean)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL___DELETE_TYPE:
				try {
					deleteType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL___CREATE_INSTANCE__STRING_MODELORIGIN_MULTIMODEL:
				try {
					return createInstance((String)arguments.get(0), (ModelOrigin)arguments.get(1), (MultiModel)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL___CREATE_INSTANCE_AND_EDITOR__STRING_MODELORIGIN_MULTIMODEL:
				try {
					return createInstanceAndEditor((String)arguments.get(0), (ModelOrigin)arguments.get(1), (MultiModel)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MidPackage.MODEL___DELETE_INSTANCE:
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
		result.append(" (inc: ");
		result.append(inc);
		result.append(", origin: ");
		result.append(origin);
		result.append(", fileExtension: ");
		result.append(fileExtension);
		result.append(", abstract: ");
		result.append(abstract_);
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
	 * @throws MMTFException
	 *             If the uri of the new model type is already registered in the
	 *             Type MID.
	 * @generated NOT
	 */
	protected void addSubtype(Model newModelType, String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMTFException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		super.addSubtype(newModelType, this, null, newModelTypeName);
		MultiModelTypeFactory.addModelType(newModelType, false, constraintLanguage, constraintImplementation, multiModel);
		newModelType.setOrigin(ModelOrigin.CREATED);
		newModelType.setFileExtension(getFileExtension());

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
						EClass rootEClass = (EClass) ((EPackage) MultiModelTypeIntrospection.getRoot(this)).getEClassifiers().get(0);
						newRootEClass.getESuperTypes().add(rootEClass);
					}
					newEPackage.getEClassifiers().add(newRootEClass);
					newMetamodelUri = newModelTypeName + "." + EcorePackage.eNAME;
					MultiModelUtils.createModelFileInState(newEPackage, newMetamodelUri);
				}
				newModelType.setFileExtension(MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION);
			}
			catch (Exception e) {
				MMTFException.print(Type.WARNING, "Error creating extended metamodel file, fallback to no extension", e);
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
				newEditorTypeName = MMTF.ROOT_EDITOR_NAME;
				editorId = MMTF.ROOT_EDITOR_ID;
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
				//TODO MMTF: a new editor is created instead of attaching existing ones
				//TODO MMTF: because I couldn't find a way then from an editor to understand which model was being created
				Editor newEditorType = editorType.createSubtype(newEditorTypeFragmentUri, newEditorTypeName, newModelTypeUri, editorId, wizardId, wizardDialogClassName);
				MultiModelTypeFactory.addModelTypeEditor(newEditorType, newModelType);
				if (isMetamodelExtension) { // reflective editor only
					newEditorType.getFileExtensions().clear();
					newEditorType.getFileExtensions().add(MultiModelTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION);
					break;
				}
			}
			catch (MMTFException e) {
				// models created through this editor will have the supermodel as static type
				MultiModelTypeFactory.addModelTypeEditor(editorType, newModelType);
			}
		}
	}

	/**
	 * @generated NOT
	 */
	public Model createSubtype(String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Model newModelType = MidFactory.eINSTANCE.createModel();
		addSubtype(newModelType, newModelTypeName, constraintLanguage, constraintImplementation, isMetamodelExtension);

		return newModelType;
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		// delete the "thing"
		for (ModelElement modelElemType : getModelElems()) {
			super.delete(modelElemType.getUri(), multiModel);
		}
		List<Editor> delEditorTypes = new ArrayList<Editor>(getEditors());
		for (Editor delEditorType : delEditorTypes) {
			delEditorType.deleteType();
		}
		super.deleteType();
		multiModel.getModels().remove(this);
		String metamodelUri = MultiModelTypeRegistry.getExtendedMetamodelUri(this);
		if (metamodelUri != null) {
			MultiModelUtils.deleteFile(metamodelUri, false);
		}
		// delete operator types that use this model type
		List<String> delOperatorTypeUris = new ArrayList<String>();
		for (Operator operatorType : multiModel.getOperators()) {
			for (Parameter par : operatorType.getInputs()) {
				if (par.getModel().getUri().equals(getUri()) && !delOperatorTypeUris.contains(operatorType.getUri())) {
					delOperatorTypeUris.add(operatorType.getUri());
				}
			}
			for (Parameter par : operatorType.getOutputs()) {
				if (par.getModel().getUri().equals(getUri()) && !delOperatorTypeUris.contains(operatorType.getUri())) {
					delOperatorTypeUris.add(operatorType.getUri());
				}
			}
		}
		for (String operatorTypeUri : delOperatorTypeUris) {
			Operator operatorType = MultiModelRegistry.getExtendibleElement(operatorTypeUri, multiModel);
			operatorType.deleteType();
		}
		// delete model relationship types and endpoints that use this model type
		List<ModelRel> delModelRelTypes = new ArrayList<ModelRel>();
		List<ModelEndpoint> delModelTypeEndpoints = new ArrayList<ModelEndpoint>();
		for (ModelRel modelRelType : MultiModelRegistry.getModelRels(multiModel)) {
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
		for (Model modelSubtype : MultiModelTypeHierarchy.getDirectSubtypes(this, multiModel)) {
			modelSubtype.deleteType();
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
	 * @param containerMultiModel
	 *            An Instance MID, null if the model isn't going to be added to
	 *            it.
	 * @throws MMTFException
	 *             If the uri of the new model is already registered in the
	 *             Instance MID.
	 * @generated NOT
	 */
	protected void addInstance(Model newModel, String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMTFException {

		boolean externalElement = newModelUri != null;
		boolean updateMid = containerMultiModel != null;
		boolean basicElement = !updateMid || !externalElement;

		String newModelName = null;
		String fileExtension = MultiModelInstanceFactory.EMPTY_MODEL_FILE_EXTENSION;
		if (externalElement) {
			newModelName = MultiModelUtils.getFileNameFromUri(newModelUri);
			fileExtension = MultiModelUtils.getFileExtensionFromUri(newModelUri);
		}
		if (basicElement) {
			super.addBasicInstance(newModel, newModelUri, newModelName);
		}
		else {
			super.addInstance(newModel, newModelUri, newModelName, containerMultiModel);
		}
		if (updateMid) {
			containerMultiModel.getModels().add(newModel);
		}
		newModel.setOrigin(origin);
		newModel.setFileExtension(fileExtension);
	}

	/**
	 * @generated NOT
	 */
	public Model createInstance(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		Model newModel = MidFactory.eINSTANCE.createModel();
		addInstance(newModel, newModelUri, origin, containerMultiModel);

		return newModel;
	}

	/**
	 * @generated NOT
	 */
	public Model createInstanceAndEditor(String newModelUri, ModelOrigin origin, MultiModel containerMultiModel) throws MMTFException {

		Model newModel = createInstance(newModelUri, origin, containerMultiModel);
		Editor newEditor = null;
		//TODO MMTF[EDITOR] prioritize editors list instead of running twice?
		// all diagrams are tried..
		for (Editor diagramType : MultiModelTypeRegistry.getModelTypeEditors(getUri())) {
			if (!(diagramType instanceof Diagram)) {
				continue;
			}
			try {
				newEditor = diagramType.createInstance(newModel.getUri(), containerMultiModel);
			}
			catch (MMTFException e) {
				continue;
			}
		}
		// ..or first editor is used
		for (Editor editorType : MultiModelTypeRegistry.getModelTypeEditors(getUri())) {
			if (editorType instanceof Diagram) {
				continue;
			}
			newEditor = editorType.createInstance(newModel.getUri(), containerMultiModel);
		}
		if (newEditor != null) {
			newModel.getEditors().add(newEditor);
		}

		return newModel;
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstance() throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		for (ModelElement modelElem : getModelElems()) {
			super.delete(modelElem.getUri(), multiModel);
		}
		super.deleteInstance();
		multiModel.getModels().remove(this);
		// delete editors for this model
		for (Editor editor : getEditors()) {
			editor.deleteInstance();
		}
		// delete model relationships and endpoints that use this model
		List<ModelRel> delModelRels = new ArrayList<ModelRel>();
		List<ModelEndpoint> delModelEndpoints = new ArrayList<ModelEndpoint>();
		for (ModelRel modelRel : MultiModelRegistry.getModelRels(multiModel)) {
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

} //ModelImpl
