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
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.LinkReferenceImpl#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkReferenceImpl extends ExtendibleElementReferenceImpl implements LinkReference {
	/**
	 * The cached value of the '{@link #getModelElemEndpointRefs() <em>Model Elem Endpoint Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElemEndpointRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementEndpointReference> modelElemEndpointRefs;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.LINK_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementEndpointReference> getModelElemEndpointRefs() {
		if (modelElemEndpointRefs == null) {
			modelElemEndpointRefs = new EObjectContainmentEList<ModelElementEndpointReference>(ModelElementEndpointReference.class, this, RelationshipPackage.LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS);
		}
		return modelElemEndpointRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link getObject() {
		ExtendibleElement object = super.getObject();
		return (object == null) ? null : (Link) object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkReference getSupertypeRef() {
		ExtendibleElementReference supertypeRef = super.getSupertypeRef();
		return (supertypeRef == null) ? null : (LinkReference) supertypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
				return ((InternalEList<?>)getModelElemEndpointRefs()).basicRemove(otherEnd, msgs);
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
			case RelationshipPackage.LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
				return getModelElemEndpointRefs();
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
			case RelationshipPackage.LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
				getModelElemEndpointRefs().clear();
				getModelElemEndpointRefs().addAll((Collection<? extends ModelElementEndpointReference>)newValue);
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
			case RelationshipPackage.LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
				getModelElemEndpointRefs().clear();
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
			case RelationshipPackage.LINK_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
				return modelElemEndpointRefs != null && !modelElemEndpointRefs.isEmpty();
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
			case RelationshipPackage.LINK_REFERENCE___GET_OBJECT:
				return getObject();
			case RelationshipPackage.LINK_REFERENCE___GET_SUPERTYPE_REF:
				return getSupertypeRef();
			case RelationshipPackage.LINK_REFERENCE___DELETE_TYPE_REFERENCE:
				try {
					deleteTypeReference();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.LINK_REFERENCE___DELETE_TYPE_AND_REFERENCE:
				try {
					deleteTypeAndReference();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.LINK_REFERENCE___DELETE_INSTANCE_REFERENCE:
				try {
					deleteInstanceReference();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.LINK_REFERENCE___DELETE_INSTANCE_AND_REFERENCE:
				try {
					deleteInstanceAndReference();
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
	public void deleteTypeReference() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		for (ModelElementEndpointReference modelElemTypeEndpointRef : getModelElemEndpointRefs()) {
			modelElemTypeEndpointRef.setModelElemRef(null);
		}
		ModelRel modelRelType = (ModelRel) eContainer();
		modelRelType.getLinkRefs().remove(this);
	}

	/**
	 * @generated NOT
	 */
	public void deleteTypeAndReference() throws MMINTException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		ModelRel modelRelType = (ModelRel) eContainer();
		// delete the "thing" and the corresponding reference
		getObject().deleteType();
		deleteTypeReference();
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(this, modelRelSubtype.getLinkRefs());
			linkSubtypeRef.deleteTypeReference();
		}
		// delete the subtypes of the "thing"
		for (Link linkSubtype : MultiModelTypeHierarchy.getDirectSubtypes(getObject(), multiModel)) {
			ModelRel modelRelTypeOrSubtype = (ModelRel) linkSubtype.eContainer();
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(linkSubtype.getUri(), modelRelTypeOrSubtype.getLinkRefs());
			linkSubtypeRef.deleteTypeAndReference();
		}
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstanceReference() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		for (ModelElementEndpointReference modelElemEndpointRef : getModelElemEndpointRefs()) {
			modelElemEndpointRef.setModelElemRef(null);
		}
		ModelRel modelRel = (ModelRel) eContainer();
		modelRel.getLinkRefs().remove(this);
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstanceAndReference() throws MMINTException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMINTException("Can't execute INSTANCES level operation on TYPES level element");
		}

		getObject().deleteInstance();
		deleteInstanceReference();
	}

} //LinkReferenceImpl
