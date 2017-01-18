/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.ModelElementReferenceImpl#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelElementReferenceImpl extends ExtendibleElementReferenceImpl implements ModelElementReference {
	/**
	 * The cached value of the '{@link #getModelElemEndpointRefs() <em>Model Elem Endpoint Refs</em>}' reference list.
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
	protected ModelElementReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.MODEL_ELEMENT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementEndpointReference> getModelElemEndpointRefs() {
		if (modelElemEndpointRefs == null) {
			modelElemEndpointRefs = new EObjectWithInverseResolvingEList<ModelElementEndpointReference>(ModelElementEndpointReference.class, this, RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS, RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE__MODEL_ELEM_REF);
		}
		return modelElemEndpointRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getObject() {
		ExtendibleElement object = super.getObject();
		return (object == null) ? null : (ModelElement) object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference getSupertypeRef() {
		ExtendibleElementReference supertypeRef = super.getSupertypeRef();
		return (supertypeRef == null) ? null : (ModelElementReference) supertypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getModelElemEndpointRefs()).basicAdd(otherEnd, msgs);
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
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE__MODEL_ELEM_ENDPOINT_REFS:
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
				case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE___GET_OBJECT: return RelationshipPackage.MODEL_ELEMENT_REFERENCE___GET_OBJECT;
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
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE___GET_OBJECT:
				return getObject();
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE___GET_SUPERTYPE_REF:
				return getSupertypeRef();
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE___DELETE_TYPE_REFERENCE:
				try {
					deleteTypeReference();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ELEMENT_REFERENCE___DELETE_INSTANCE_REFERENCE:
				try {
					deleteInstanceReference();
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * Removes a reference to a model element type from the MID that
	 * contains it.
	 * 
	 * @param modelElemTypeRef
	 *            The reference to be removed to a model element type.
	 * @param modelTypeEndpointRef
	 *            The model type endpoint that contains the reference to a model
	 *            element type.
	 */
	protected static void deleteTypeReference(ModelElementReference modelElemTypeRef, ModelEndpointReference modelTypeEndpointRef) {

		modelTypeEndpointRef.getModelElemRefs().remove(modelElemTypeRef);
	}

	/**
	 * @generated NOT
	 */
	public void deleteTypeReference() throws MMINTException {

		MMINTException.mustBeType(this);

		ModelRel modelRelType = (ModelRel) eContainer().eContainer();
		MID typeMID = modelRelType.getMIDContainer();
		// delete the corresponding reference
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) this.eContainer();
		List<BinaryMappingReference> delMappingTypeRefs = new ArrayList<>();
		List<ModelElementEndpointReference> delModelElemTypeEndpointRefs = new ArrayList<ModelElementEndpointReference>();
		for (ModelElementEndpointReference modelElemTypeEndpointRef : getModelElemEndpointRefs()) {
			MappingReference mappingTypeRef = (MappingReference) modelElemTypeEndpointRef.eContainer();
			// avoid iterating over the list
			if (mappingTypeRef instanceof BinaryMappingReference) {
				if (!delMappingTypeRefs.contains(mappingTypeRef)) {
					delMappingTypeRefs.add((BinaryMappingReference) mappingTypeRef);
				}
			}
			else {
				if (!delModelElemTypeEndpointRefs.contains(modelElemTypeEndpointRef)) {
					delModelElemTypeEndpointRefs.add(modelElemTypeEndpointRef);
				}
			}
		}
		for (BinaryMappingReference mappingTypeRef : delMappingTypeRefs) {
			mappingTypeRef.deleteTypeAndReference();
		}
		for (ModelElementEndpointReference modelElemTypeEndpointRef : delModelElemTypeEndpointRefs) {
			modelElemTypeEndpointRef.deleteTypeAndReference(true);
		}
		deleteTypeReference(this, modelTypeEndpointRef);
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MIDTypeHierarchy.getSubtypes(modelRelType, typeMID)) {
			ModelEndpointReference modelSubtypeEndpointRef = MIDRegistry.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference modelElemSubtypeRef = MIDRegistry.getReference(this, modelSubtypeEndpointRef.getModelElemRefs());
			if (modelElemSubtypeRef.getModelElemEndpointRefs().size() == 0) {
				deleteTypeReference(modelElemSubtypeRef, modelSubtypeEndpointRef);
			}
			else {
				boolean newModifiable = true;
				for (ModelElementEndpointReference modelElemTypeEndpointRef : modelElemSubtypeRef.getModelElemEndpointRefs()) {
					MappingReference mappingSubtypeRef = (MappingReference) modelElemTypeEndpointRef.eContainer();
					if (!mappingSubtypeRef.isModifiable()) {
						newModifiable = false;
						break;
					}
				}
				modelElemSubtypeRef.setModifiable(newModifiable);
			}
		}
		// don't delete the subtypes of the "thing", the model element is not deleted from its metamodel
	}

	/**
	 * @generated NOT
	 */
	public void deleteInstanceReference() throws MMINTException {

		MMINTException.mustBeInstance(this);

		List<MappingReference> delMappingRefs = new ArrayList<>();
		List<ModelElementEndpointReference> delModelElemEndpointRefs = new ArrayList<ModelElementEndpointReference>();
		for (ModelElementEndpointReference modelElemEndpointRef : getModelElemEndpointRefs()) {
			MappingReference mappingRef = (MappingReference) modelElemEndpointRef.eContainer();
			if (mappingRef instanceof BinaryMappingReference) {
				if (!delMappingRefs.contains(mappingRef)) {
					delMappingRefs.add(mappingRef);
				}
			}
			else {
				if (!delModelElemEndpointRefs.contains(modelElemEndpointRef)) {
					delModelElemEndpointRefs.add(modelElemEndpointRef);
				}
			}
		}
		for (MappingReference delMappingRef : delMappingRefs) {
			delMappingRef.deleteInstanceAndReference();
		}
		for (ModelElementEndpointReference delModelElemEndpointRef : delModelElemEndpointRefs) {
			delModelElemEndpointRef.deleteInstanceAndReference(true);
		}

		((ModelEndpointReference) eContainer()).getModelElemRefs().remove(this);
	}

} //ModelElementReferenceImpl
