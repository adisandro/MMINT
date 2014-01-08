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
package edu.toronto.cs.se.mmtf.mid.relationship.impl;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementEndpointReferenceImpl#getModelElemRef <em>Model Elem Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementEndpointReferenceImpl extends ExtendibleElementEndpointReferenceImpl implements ModelElementEndpointReference {
	/**
	 * The cached value of the '{@link #getModelElemRef() <em>Model Elem Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElemRef()
	 * @generated
	 * @ordered
	 */
	protected ModelElementReference modelElemRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementEndpointReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.MODEL_ELEMENT_ENDPOINT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference getModelElemRef() {
		if (modelElemRef != null && modelElemRef.eIsProxy()) {
			InternalEObject oldModelElemRef = (InternalEObject)modelElemRef;
			modelElemRef = (ModelElementReference)eResolveProxy(oldModelElemRef);
			if (modelElemRef != oldModelElemRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF, oldModelElemRef, modelElemRef));
			}
		}
		return modelElemRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference basicGetModelElemRef() {
		return modelElemRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModelElemRef(ModelElementReference newModelElemRef, NotificationChain msgs) {
		ModelElementReference oldModelElemRef = modelElemRef;
		modelElemRef = newModelElemRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF, oldModelElemRef, newModelElemRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElemRef(ModelElementReference newModelElemRef) {
		if (newModelElemRef != modelElemRef) {
			NotificationChain msgs = null;
			if (modelElemRef != null)
				msgs = ((InternalEObject)modelElemRef).eInverseRemove(this, RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS, ModelElementReference.class, msgs);
			if (newModelElemRef != null)
				msgs = ((InternalEObject)newModelElemRef).eInverseAdd(this, RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS, ModelElementReference.class, msgs);
			msgs = basicSetModelElemRef(newModelElemRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF, newModelElemRef, newModelElemRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEndpoint getObject() {
		ExtendibleElementEndpoint object = super.getObject();
		return (object == null) ? null : (ModelElementEndpoint) object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEndpointReference getSupertypeRef() {
		ExtendibleElementEndpointReference supertypeRef = super.getSupertypeRef();
		return (supertypeRef == null) ? null : (ModelElementEndpointReference) supertypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
				if (modelElemRef != null)
					msgs = ((InternalEObject)modelElemRef).eInverseRemove(this, RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS, ModelElementReference.class, msgs);
				return basicSetModelElemRef((ModelElementReference)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
				return basicSetModelElemRef(null, msgs);
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
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
				if (resolve) return getModelElemRef();
				return basicGetModelElemRef();
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
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
				setModelElemRef((ModelElementReference)newValue);
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
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
				setModelElemRef((ModelElementReference)null);
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
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF:
				return modelElemRef != null;
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
		if (baseClass == ExtendibleElementEndpointReference.class) {
			switch (baseOperationID) {
				case RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT;
				case RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF: return RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF;
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
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT:
				return getObject();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF:
				return getSupertypeRef();
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN:
				try {
					deleteTypeReference((Boolean)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_TYPE_AND_REFERENCE__BOOLEAN:
				try {
					deleteTypeAndReference((Boolean)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE___DELETE_INSTANCE_AND_REFERENCE__BOOLEAN:
				try {
					deleteInstanceAndReference((Boolean)arguments.get(0));
					return null;
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
	public void deleteTypeReference(boolean isFullDelete) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		if (isFullDelete) {
			setModelElemRef(null);
			((LinkReference) eContainer()).getModelElemEndpointRefs().remove(this);
		}
	}

	/**
	 * @generated NOT
	 */
	public void deleteTypeAndReference(boolean isFullDelete) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		LinkReference linkTypeRef = (LinkReference) eContainer();
		ModelRel modelRelType = (ModelRel) linkTypeRef.eContainer();
		// delete the "thing" and the corresponding reference
		getObject().deleteType(isFullDelete);
		if (isFullDelete) {
			linkTypeRef.getObject().getModelElemEndpointRefs().remove(this);
		}
		deleteTypeReference(isFullDelete);
		// delete references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(this, linkSubtypeRef.getModelElemEndpointRefs());
			modelElemSubtypeEndpointRef.deleteTypeReference(isFullDelete);
		}
		// delete references of the "thing" in subtypes of the container
		for (Link linkSubtype : MultiModelTypeHierarchy.getSubtypes(linkTypeRef.getObject(), multiModel)) {
			if (isFullDelete) {
				linkSubtype.getModelElemEndpointRefs().remove(this);
			}
		}
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstanceAndReference(boolean isFullDelete) throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		LinkReference linkRef = (LinkReference) eContainer();
		Link link = linkRef.getObject();
		if (isFullDelete) {
			link.getModelElemEndpoints().remove(getObject());
			linkRef.getModelElemEndpointRefs().remove(this);
			link.getModelElemEndpointRefs().remove(this);
			setModelElemRef(null);
		}
	}

} //ModelElementEndpointReferenceImpl
