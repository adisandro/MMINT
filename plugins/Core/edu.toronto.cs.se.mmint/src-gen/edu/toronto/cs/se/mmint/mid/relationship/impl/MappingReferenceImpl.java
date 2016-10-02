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
package edu.toronto.cs.se.mmint.mid.relationship.impl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

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
 * An implementation of the model object '<em><b>Mapping Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.MappingReferenceImpl#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingReferenceImpl extends ExtendibleElementReferenceImpl implements MappingReference {
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
	protected MappingReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.MAPPING_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementEndpointReference> getModelElemEndpointRefs() {
		if (modelElemEndpointRefs == null) {
			modelElemEndpointRefs = new EObjectContainmentEList<ModelElementEndpointReference>(ModelElementEndpointReference.class, this, RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS);
		}
		return modelElemEndpointRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getObject() {
		ExtendibleElement object = super.getObject();
		return (object == null) ? null : (Mapping) object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingReference getSupertypeRef() {
		ExtendibleElementReference supertypeRef = super.getSupertypeRef();
		return (supertypeRef == null) ? null : (MappingReference) supertypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.MAPPING_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == ExtendibleElementReference.class) {
			switch (baseOperationID) {
				case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT: return RelationshipPackage.MAPPING_REFERENCE___GET_OBJECT;
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
			case RelationshipPackage.MAPPING_REFERENCE___GET_OBJECT:
				return getObject();
			case RelationshipPackage.MAPPING_REFERENCE___GET_SUPERTYPE_REF:
				return getSupertypeRef();
			case RelationshipPackage.MAPPING_REFERENCE___DELETE_TYPE_REFERENCE:
				try {
					deleteTypeReference();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MAPPING_REFERENCE___DELETE_TYPE_AND_REFERENCE:
				try {
					deleteTypeAndReference();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MAPPING_REFERENCE___DELETE_INSTANCE_REFERENCE:
				try {
					deleteInstanceReference();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MAPPING_REFERENCE___DELETE_INSTANCE_AND_REFERENCE:
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

		MMINTException.mustBeType(this);

		for (ModelElementEndpointReference modelElemTypeEndpointRef : getModelElemEndpointRefs()) {
			modelElemTypeEndpointRef.setModelElemRef(null);
		}
		ModelRel modelRelType = (ModelRel) eContainer();
		modelRelType.getMappingRefs().remove(this);
	}

	/**
	 * @generated NOT
	 */
	public void deleteTypeAndReference() throws MMINTException {

		MMINTException.mustBeType(this);

		MID typeMID = this.getMIDContainer();
		ModelRel modelRelType = (ModelRel) eContainer();
		// delete the "thing" and the corresponding reference
		getObject().deleteType();
		deleteTypeReference();
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(modelRelType, typeMID)) {
			MappingReference mappingSubtypeRef = MIDRegistry.getReference(this, modelRelSubtype.getMappingRefs());
			mappingSubtypeRef.deleteTypeReference();
		}
		// delete the subtypes of the "thing"
		for (Mapping mappingSubtype : MIDTypeHierarchy.getDirectSubtypes(getObject(), typeMID)) {
			ModelRel modelRelTypeOrSubtype = (ModelRel) mappingSubtype.eContainer();
			MappingReference mappingSubtypeRef = MIDRegistry.getReference(mappingSubtype.getUri(), modelRelTypeOrSubtype.getMappingRefs());
			mappingSubtypeRef.deleteTypeAndReference();
		}
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstanceReference() throws MMINTException {

		MMINTException.mustBeInstance(this);

		for (ModelElementEndpointReference modelElemEndpointRef : getModelElemEndpointRefs()) {
			modelElemEndpointRef.setModelElemRef(null);
		}
		ModelRel modelRel = (ModelRel) eContainer();
		modelRel.getMappingRefs().remove(this);
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstanceAndReference() throws MMINTException {

		MMINTException.mustBeInstance(this);

		this.getObject().deleteInstance();
		this.deleteInstanceReference();
	}

} //MappingReferenceImpl
