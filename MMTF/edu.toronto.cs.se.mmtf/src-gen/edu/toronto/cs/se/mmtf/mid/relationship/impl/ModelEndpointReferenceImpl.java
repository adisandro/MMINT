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
import edu.toronto.cs.se.mmtf.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Endpoint Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelEndpointReferenceImpl#getModelElemRefs <em>Model Elem Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelEndpointReferenceImpl extends ExtendibleElementEndpointReferenceImpl implements ModelEndpointReference {
	/**
	 * The cached value of the '{@link #getModelElemRefs() <em>Model Elem Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElemRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementReference> modelElemRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelEndpointReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.MODEL_ENDPOINT_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementReference> getModelElemRefs() {
		if (modelElemRefs == null) {
			modelElemRefs = new EObjectContainmentEList<ModelElementReference>(ModelElementReference.class, this, RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS);
		}
		return modelElemRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelEndpoint getObject() {
		ExtendibleElementEndpoint object = super.getObject();
		return (object == null) ? null : (ModelEndpoint) object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelEndpointReference getSupertypeRef() {
		ExtendibleElementEndpointReference supertypeRef = super.getSupertypeRef();
		return (supertypeRef == null) ? null : (ModelEndpointReference) supertypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS:
				return ((InternalEList<?>)getModelElemRefs()).basicRemove(otherEnd, msgs);
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
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS:
				return getModelElemRefs();
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
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS:
				getModelElemRefs().clear();
				getModelElemRefs().addAll((Collection<? extends ModelElementReference>)newValue);
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
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS:
				getModelElemRefs().clear();
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
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS:
				return modelElemRefs != null && !modelElemRefs.isEmpty();
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
				case RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_OBJECT: return RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_OBJECT;
				case RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF: return RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF;
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
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_OBJECT:
				return getObject();
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE___GET_SUPERTYPE_REF:
				return getSupertypeRef();
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_TYPE__EOBJECT:
				try {
					return acceptModelElementType((EObject)arguments.get(0));
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE___DELETE_TYPE_REFERENCE__BOOLEAN:
				try {
					deleteTypeReference((Boolean)arguments.get(0));
					return null;
				}
				catch (Throwable throwable) {
					throw new InvocationTargetException(throwable);
				}
			case RelationshipPackage.MODEL_ENDPOINT_REFERENCE___ACCEPT_MODEL_ELEMENT_INSTANCE__EOBJECT:
				try {
					return acceptModelElementInstance((EObject)arguments.get(0));
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
	public boolean acceptModelElementType(EObject metamodelObj) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		MultiModel multiModel = MultiModelRegistry.getMultiModel(this);
		String modelTypeUri = MultiModelRegistry.getModelAndModelElementUris(metamodelObj, false)[0];
		if (
			!modelTypeUri.equals(getTargetUri()) && // different model type
			!MultiModelTypeHierarchy.isSubtypeOf(getTargetUri(), modelTypeUri, multiModel) // different light model type with no metamodel extension
		) {
			return false;
		}
		// filter duplicates
		for (ModelElementReference modelElemTypeRef : getModelElemRefs()) {
			//TODO MMTF[MODELELEMENT] replace with something simpler once model element changes are in place, like:
//				if (elementRef.getUri().equals(modelUri + MMTF.URI_SEPARATOR + modelElemUri)) {
//					continue modelEndpointRef;
//				}
			if (EcoreUtil.equals(MultiModelTypeIntrospection.getPointer(modelElemTypeRef.getObject()), metamodelObj)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * @generated NOT
	 */
	public void deleteTypeReference(boolean isFullDelete) throws MMTFException {

		if (MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute TYPES level operation on INSTANCES level element");
		}

		// avoid iterating over the list
		while (getModelElemRefs().size() > 0) {
			//TODO[OO] do this when all other pieces fall into place
			MultiModelTypeFactory.removeModelElementTypeReference(getModelElemRefs().get(0));
		}
		if (isFullDelete) {
			ModelRel modelRelType = (ModelRel) eContainer();
			modelRelType.getModelEndpointRefs().remove(this);
		}
	}

	/**
	 * @generated NOT
	 */
	public ModelElement acceptModelElementInstance(EObject modelObj) throws MMTFException {

		if (!MultiModelConstraintChecker.isInstancesLevel(this)) {
			throw new MMTFException("Can't execute INSTANCES level operation on TYPES level element");
		}

		String modelUri = MultiModelRegistry.getModelAndModelElementUris(modelObj, true)[0];
		if (!modelUri.equals(getTargetUri())) { // different model
			return null;
		}
		// filter unallowed model element types
		ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(this, modelObj);
		if (modelElemType == null) {
			return null;
		}
		// filter duplicates
		if (MultiModelRegistry.getModelElementReference(this, modelElemType, modelObj) != null) {
			return null;
		}

		return modelElemType;
	}

} //ModelEndpointReferenceImpl
