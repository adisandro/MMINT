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
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelElementReferenceImpl#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 * </p>
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
	 * Removes a reference to a model element type from the multimodel that
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
	public void deleteTypeReference() throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		ModelRel modelRelType = (ModelRel) eContainer().eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		// delete the corresponding reference
		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) eContainer();
		List<BinaryLinkReference> delLinkTypeRefs = new ArrayList<BinaryLinkReference>();
		List<ModelElementEndpointReference> delModelElemTypeEndpointRefs = new ArrayList<ModelElementEndpointReference>();
		for (ModelElementEndpointReference modelElemTypeEndpointRef : getModelElemEndpointRefs()) {
			LinkReference linkTypeRef = (LinkReference) modelElemTypeEndpointRef.eContainer();
			// avoid iterating over the list
			if (linkTypeRef instanceof BinaryLinkReference) {
				if (!delLinkTypeRefs.contains(linkTypeRef)) {
					delLinkTypeRefs.add((BinaryLinkReference) linkTypeRef);
				}
			}
			else {
				if (!delModelElemTypeEndpointRefs.contains(modelElemTypeEndpointRef)) {
					delModelElemTypeEndpointRefs.add(modelElemTypeEndpointRef);
				}
			}
		}
		for (BinaryLinkReference linkTypeRef : delLinkTypeRefs) {
			linkTypeRef.deleteTypeAndReference();
		}
		for (ModelElementEndpointReference modelElemTypeEndpointRef : delModelElemTypeEndpointRefs) {
			modelElemTypeEndpointRef.deleteTypeAndReference(true);
		}
		deleteTypeReference(this, modelTypeEndpointRef);
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference modelElemSubtypeRef = MultiModelTypeHierarchy.getReference(this, modelSubtypeEndpointRef.getModelElemRefs());
			if (modelElemSubtypeRef.getModelElemEndpointRefs().size() == 0) {
				deleteTypeReference(modelElemSubtypeRef, modelSubtypeEndpointRef);
			}
			else {
				boolean newModifiable = true;
				for (ModelElementEndpointReference modelElemTypeEndpointRef : modelElemSubtypeRef.getModelElemEndpointRefs()) {
					LinkReference linkSubtypeRef = (LinkReference) modelElemTypeEndpointRef.eContainer();
					if (!linkSubtypeRef.isModifiable()) {
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
	public void deleteInstanceReference() throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		List<LinkReference> delLinkRefs = new ArrayList<LinkReference>();
		List<ModelElementEndpointReference> delModelElemEndpointRefs = new ArrayList<ModelElementEndpointReference>();
		for (ModelElementEndpointReference modelElemEndpointRef : getModelElemEndpointRefs()) {
			LinkReference linkRef = (LinkReference) modelElemEndpointRef.eContainer();
			if (linkRef instanceof BinaryLinkReference) {
				if (!delLinkRefs.contains(linkRef)) {
					delLinkRefs.add(linkRef);
				}
			}
			else {
				if (!delModelElemEndpointRefs.contains(modelElemEndpointRef)) {
					delModelElemEndpointRefs.add(modelElemEndpointRef);
				}
			}
		}
		for (LinkReference linkRef : delLinkRefs) {
			linkRef.deleteInstanceAndReference();
		}
		for (ModelElementEndpointReference modelElemEndpointRef : delModelElemEndpointRefs) {
			modelElemEndpointRef.deleteInstanceAndReference(true);
		}

		((ModelEndpointReference) eContainer()).getModelElemRefs().remove(this);
	}

} //ModelElementReferenceImpl
