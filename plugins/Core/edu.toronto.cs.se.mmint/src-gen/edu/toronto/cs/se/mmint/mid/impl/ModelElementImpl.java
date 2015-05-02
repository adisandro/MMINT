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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmint.mid.library.PrimitiveEObjectWrapper;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl#getEInfo <em>EInfo</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementImpl extends ExtendibleElementImpl implements ModelElement {
	/**
	 * The cached value of the '{@link #getEInfo() <em>EInfo</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEInfo()
	 * @generated
	 * @ordered
	 */
	protected EMFInfo eInfo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MIDPackage.Literals.MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMFInfo getEInfo() {
		return eInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEInfo(EMFInfo newEInfo, NotificationChain msgs) {
		EMFInfo oldEInfo = eInfo;
		eInfo = newEInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MIDPackage.MODEL_ELEMENT__EINFO, oldEInfo, newEInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEInfo(EMFInfo newEInfo) {
		if (newEInfo != eInfo) {
			NotificationChain msgs = null;
			if (eInfo != null)
				msgs = ((InternalEObject)eInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MIDPackage.MODEL_ELEMENT__EINFO, null, msgs);
			if (newEInfo != null)
				msgs = ((InternalEObject)newEInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MIDPackage.MODEL_ELEMENT__EINFO, null, msgs);
			msgs = basicSetEInfo(newEInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.MODEL_ELEMENT__EINFO, newEInfo, newEInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (ModelElement) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getSupertype() {
		ExtendibleElement supertype = super.getSupertype();
		return (supertype == null) ? null : (ModelElement) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MIDPackage.MODEL_ELEMENT__EINFO:
				return getEInfo();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MIDPackage.MODEL_ELEMENT__EINFO:
				setEInfo((EMFInfo)newValue);
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
			case MIDPackage.MODEL_ELEMENT__EINFO:
				setEInfo((EMFInfo)null);
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
			case MIDPackage.MODEL_ELEMENT__EINFO:
				return eInfo != null;
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
			case MIDPackage.MODEL_ELEMENT___GET_METATYPE:
				return getMetatype();
			case MIDPackage.MODEL_ELEMENT___GET_SUPERTYPE:
				return getSupertype();
			case MIDPackage.MODEL_ELEMENT___CREATE_TYPE_REFERENCE__MODELELEMENTREFERENCE_BOOLEAN_MODELENDPOINTREFERENCE:
				try {
					return createTypeReference((ModelElementReference)arguments.get(0), (Boolean)arguments.get(1), (ModelEndpointReference)arguments.get(2));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ELEMENT___CREATE_SUBTYPE_AND_REFERENCE__MODELELEMENTREFERENCE_STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE:
				try {
					return createSubtypeAndReference((ModelElementReference)arguments.get(0), (String)arguments.get(1), (String)arguments.get(2), (EMFInfo)arguments.get(3), (ModelEndpointReference)arguments.get(4));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ELEMENT___DELETE_TYPE:
				try {
					deleteType();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ELEMENT___GET_EMF_TYPE_OBJECT:
				try {
					return getEMFTypeObject();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ELEMENT___CREATE_INSTANCE_REFERENCE__MODELENDPOINTREFERENCE:
				try {
					return createInstanceReference((ModelEndpointReference)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ELEMENT___CREATE_INSTANCE_AND_REFERENCE__STRING_STRING_EMFINFO_MODELENDPOINTREFERENCE:
				try {
					return createInstanceAndReference((String)arguments.get(0), (String)arguments.get(1), (EMFInfo)arguments.get(2), (ModelEndpointReference)arguments.get(3));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ELEMENT___DELETE_INSTANCE:
				try {
					deleteInstance();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case MIDPackage.MODEL_ELEMENT___GET_EMF_INSTANCE_OBJECT:
				try {
					return getEMFInstanceObject();
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * @generated NOT
	 */
	public ModelElementReference createTypeReference(ModelElementReference modelElemTypeRef, boolean isModifiable, ModelEndpointReference containerModelTypeEndpointRef) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelElementReference newModelElemTypeRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		super.addTypeReference(newModelElemTypeRef, modelElemTypeRef, isModifiable, false);
		containerModelTypeEndpointRef.getModelElemRefs().add(newModelElemTypeRef);

		return newModelElemTypeRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementReference createSubtypeAndReference(ModelElementReference modelElemTypeRef, String newModelElemTypeUri, String newModelElemTypeName, EMFInfo eInfo, ModelEndpointReference containerModelTypeEndpointRef) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelRel modelRelType = (ModelRel) containerModelTypeEndpointRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		ModelElement newModelElemType = MultiModelRegistry.getExtendibleElement(newModelElemTypeUri, multiModel);
		if (newModelElemType == null) {
			// create the "thing"
			newModelElemType = MIDFactory.eINSTANCE.createModelElement();
			super.addSubtype(newModelElemType, newModelElemTypeUri, newModelElemTypeName);
			MultiModelTypeFactory.addModelElementType(newModelElemType, eInfo, containerModelTypeEndpointRef.getObject().getTarget());
		}
		// create the reference of the "thing"
		ModelElementReference newModelElemTypeRef = newModelElemType.createTypeReference(modelElemTypeRef, true, containerModelTypeEndpointRef);
		// create references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			ModelEndpointReference containerModelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(containerModelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference modelElemSubtypeRef = null;
			if (modelElemTypeRef != null) {
				ModelEndpointReference modelSubtypeRefSuper = MultiModelTypeHierarchy.getReference((ModelEndpointReference) modelElemTypeRef.eContainer(), modelRelSubtype.getModelEndpointRefs());
				modelElemSubtypeRef = MultiModelTypeHierarchy.getReference(modelElemTypeRef, modelSubtypeRefSuper.getModelElemRefs());
			}
			newModelElemType.createTypeReference(modelElemSubtypeRef, false, containerModelSubtypeEndpointRef);
		}

		return newModelElemTypeRef;
	}

	/**
	 * @generated NOT
	 */
	public void deleteType() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		super.deleteType();
		//TODO MMINT[OO] might need to implement full removal
	}

	/**
	 * @generated NOT
	 */
	public ENamedElement getEMFTypeObject() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ENamedElement modelTypeObj;
		try {
			modelTypeObj = (ENamedElement) MultiModelTypeIntrospection.getPointer(((Model) eContainer()).getEMFTypeRoot().eResource(), getUri());
		}
		catch (Exception e) {
			throw new MMINTException("Error accessing metamodel file", e);
		}

		return modelTypeObj;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementReference createInstanceReference(ModelEndpointReference containerModelEndpointRef) throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		ModelElementReference newModelElemRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		super.addInstanceReference(newModelElemRef, false);
		containerModelEndpointRef.getModelElemRefs().add(newModelElemRef);

		return newModelElemRef;
	}

	/**
	 * @generated NOT
	 */
	public ModelElementReference createInstanceAndReference(String newModelElemUri, String newModelElemName, EMFInfo eInfo, ModelEndpointReference containerModelEndpointRef) throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(containerModelEndpointRef);
		newModelElemUri += MMINT.ROLE_SEPARATOR + getUri();
		ModelElement newModelElem = MultiModelRegistry.getExtendibleElement(newModelElemUri, multiModel);
		if (newModelElem == null) {
			newModelElem = MIDFactory.eINSTANCE.createModelElement();
			//TODO MMINT[MAP] When input and output come from different mids, is it correct to store the extendible map entry in the output only?
			super.addInstance(newModelElem, newModelElemUri, newModelElemName, multiModel);
			newModelElem.setEInfo(eInfo);
			containerModelEndpointRef.getObject().getTarget().getModelElems().add(newModelElem);
		}
		ModelElementReference newModelElemRef = newModelElem.createInstanceReference(containerModelEndpointRef);

		return newModelElemRef;
	}

	/**
	 * Creates and adds a model element instance of a type to be automatically
	 * detected and a reference to it to an Instance MID.
	 * 
	 * @param modelObj
	 *            The EMF model object to be wrapped by the MMINT new model
	 *            element.
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param containerModelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the new model element.
	 * @return The created reference to the new model element.
	 * @throws MMINTException
	 *             If the uri of the new model element is already registered in
	 *             the Instance MID.
	 * @generated NOT
	 */
	public static ModelElementReference createInstanceAndReference(EObject modelObj, String newModelElemName, ModelEndpointReference containerModelEndpointRef) throws MMINTException {

		ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(containerModelEndpointRef, modelObj);
		String newModelElemUri = MultiModelRegistry.getModelAndModelElementUris(modelObj, MIDLevel.INSTANCES)[1];
		EMFInfo eInfo = MultiModelRegistry.getModelElementEMFInfo(modelObj, MIDLevel.INSTANCES);
		if (newModelElemName == null) {
			newModelElemName = MultiModelRegistry.getModelElementName(eInfo, modelObj, MIDLevel.INSTANCES);
		}
		ModelElementReference newModelElemRef = modelElemType.createInstanceAndReference(newModelElemUri, newModelElemName, eInfo, containerModelEndpointRef);

		return newModelElemRef;
	}

	/**
	 * Creates and adds a model element instance of a type to be automatically
	 * detected and a reference to it to an Instance MID, initializing its MAVO
	 * may/set/var flags.
	 * 
	 * @param modelObj
	 *            The EMF model object to be wrapped by the MMINT new model
	 *            element.
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param containerModelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the new model element.
	 * @return The created reference to the new model element.
	 * @throws MMINTException
	 *             If the uri of the new model element is already registered in
	 *             the Instance MID.
	 * @generated NOT
	 */
	public static ModelElementReference createMAVOInstanceAndReference(EObject modelObj, String newModelElemName, ModelEndpointReference containerModelEndpointRef) throws MMINTException {

		ModelElementReference newMAVOModelElemRef = createInstanceAndReference(modelObj, newModelElemName, containerModelEndpointRef);
		MAVOUtils.initializeMAVOModelElementReference(modelObj, newMAVOModelElemRef);

		return newMAVOModelElemRef;
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstance() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		super.deleteInstance();
		//TODO MMINT[OO] might need to implement full removal
	}

	/**
	 * @generated NOT
	 */
	public EObject getEMFInstanceObject() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		String modelElemUri = getUri().substring(0, getUri().indexOf(MMINT.ROLE_SEPARATOR));
		int lastSegmentIndex = modelElemUri.lastIndexOf(MMINT.URI_SEPARATOR);
		String lastSegment = modelElemUri.substring(lastSegmentIndex + 1, modelElemUri.length());
		boolean isPrimitive = !lastSegment.startsWith(MultiModelRegistry.ECORE_EREFERENCE_URI_PREFIX);
		if (isPrimitive) {
			modelElemUri = modelElemUri.substring(0, lastSegmentIndex);
		}
		EObject modelObj;
		try {
			modelObj = MultiModelTypeIntrospection.getPointer(modelElemUri);
		}
		catch (Exception e) {
			throw new MMINTException("Error accessing the model file for model element" + getUri(), e);
		}
		if (isPrimitive) {
			EObject modelObjOwner = modelObj;
			EStructuralFeature feature = modelObjOwner.eClass().getEStructuralFeature(lastSegment);
			modelObj = new PrimitiveEObjectWrapper(modelObjOwner, feature, modelObjOwner.eGet(feature));
		}

		return modelObj;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MIDPackage.MODEL_ELEMENT__EINFO:
				return basicSetEInfo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

} //ModelElementImpl
