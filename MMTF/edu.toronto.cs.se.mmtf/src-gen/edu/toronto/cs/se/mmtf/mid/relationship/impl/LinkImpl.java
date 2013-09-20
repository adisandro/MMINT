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

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl;

import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkImpl#getModelElemEndpoints <em>Model Elem Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.LinkImpl#getModelElemEndpointRefs <em>Model Elem Endpoint Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends ExtendibleElementImpl implements Link {
	/**
	 * The cached value of the '{@link #getModelElemEndpoints() <em>Model Elem Endpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElemEndpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementEndpoint> modelElemEndpoints;

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
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementEndpoint> getModelElemEndpoints() {
		if (modelElemEndpoints == null) {
			modelElemEndpoints = new EObjectContainmentEList<ModelElementEndpoint>(ModelElementEndpoint.class, this, RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS);
		}
		return modelElemEndpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementEndpointReference> getModelElemEndpointRefs() {
		if (modelElemEndpointRefs == null) {
			modelElemEndpointRefs = new EObjectResolvingEList<ModelElementEndpointReference>(ModelElementEndpointReference.class, this, RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS);
		}
		return modelElemEndpointRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (Link) metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Link getSupertype() {
		ExtendibleElement supertype = super.getSupertype();
		return (supertype == null) ? null : (Link) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
				return ((InternalEList<?>)getModelElemEndpoints()).basicRemove(otherEnd, msgs);
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
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
				return getModelElemEndpoints();
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
				getModelElemEndpoints().clear();
				getModelElemEndpoints().addAll((Collection<? extends ModelElementEndpoint>)newValue);
				return;
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
				getModelElemEndpoints().clear();
				return;
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINTS:
				return modelElemEndpoints != null && !modelElemEndpoints.isEmpty();
			case RelationshipPackage.LINK__MODEL_ELEM_ENDPOINT_REFS:
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
			case RelationshipPackage.LINK___GET_METATYPE:
				return getMetatype();
			case RelationshipPackage.LINK___GET_SUPERTYPE:
				return getSupertype();
		}
		return super.eInvoke(operationID, arguments);
	}

} //LinkImpl
