/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.impl.ModelImpl;

import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

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
 * An implementation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl#getModelEndpoints <em>Model Endpoints</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl#getModelEndpointRefs <em>Model Endpoint Refs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl#getLinkRefs <em>Link Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelRelImpl extends ModelImpl implements ModelRel {
	/**
	 * The cached value of the '{@link #getModelEndpoints() <em>Model Endpoints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelEndpoints()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelEndpoint> modelEndpoints;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<Link> links;

	/**
	 * The cached value of the '{@link #getModelEndpointRefs() <em>Model Endpoint Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelEndpointRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelEndpointReference> modelEndpointRefs;

	/**
	 * The cached value of the '{@link #getLinkRefs() <em>Link Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<LinkReference> linkRefs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelRelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.MODEL_REL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelEndpoint> getModelEndpoints() {
		if (modelEndpoints == null) {
			modelEndpoints = new EObjectContainmentEList<ModelEndpoint>(ModelEndpoint.class, this, RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS);
		}
		return modelEndpoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Link> getLinks() {
		if (links == null) {
			links = new EObjectContainmentEList<Link>(Link.class, this, RelationshipPackage.MODEL_REL__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelEndpointReference> getModelEndpointRefs() {
		if (modelEndpointRefs == null) {
			modelEndpointRefs = new EObjectContainmentEList<ModelEndpointReference>(ModelEndpointReference.class, this, RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS);
		}
		return modelEndpointRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LinkReference> getLinkRefs() {
		if (linkRefs == null) {
			linkRefs = new EObjectContainmentEList<LinkReference>(LinkReference.class, this, RelationshipPackage.MODEL_REL__LINK_REFS);
		}
		return linkRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelRel getMetatype() {
		ExtendibleElement metatype = super.getMetatype();
		return (metatype == null) ? null : (ModelRel) metatype;
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
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
				return ((InternalEList<?>)getModelEndpoints()).basicRemove(otherEnd, msgs);
			case RelationshipPackage.MODEL_REL__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				return ((InternalEList<?>)getModelEndpointRefs()).basicRemove(otherEnd, msgs);
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				return ((InternalEList<?>)getLinkRefs()).basicRemove(otherEnd, msgs);
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
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
				return getModelEndpoints();
			case RelationshipPackage.MODEL_REL__LINKS:
				return getLinks();
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				return getModelEndpointRefs();
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				return getLinkRefs();
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
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
				getModelEndpoints().clear();
				getModelEndpoints().addAll((Collection<? extends ModelEndpoint>)newValue);
				return;
			case RelationshipPackage.MODEL_REL__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				getModelEndpointRefs().clear();
				getModelEndpointRefs().addAll((Collection<? extends ModelEndpointReference>)newValue);
				return;
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				getLinkRefs().clear();
				getLinkRefs().addAll((Collection<? extends LinkReference>)newValue);
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
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
				getModelEndpoints().clear();
				return;
			case RelationshipPackage.MODEL_REL__LINKS:
				getLinks().clear();
				return;
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				getModelEndpointRefs().clear();
				return;
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				getLinkRefs().clear();
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
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINTS:
				return modelEndpoints != null && !modelEndpoints.isEmpty();
			case RelationshipPackage.MODEL_REL__LINKS:
				return links != null && !links.isEmpty();
			case RelationshipPackage.MODEL_REL__MODEL_ENDPOINT_REFS:
				return modelEndpointRefs != null && !modelEndpointRefs.isEmpty();
			case RelationshipPackage.MODEL_REL__LINK_REFS:
				return linkRefs != null && !linkRefs.isEmpty();
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
		if (baseClass == Model.class) {
			switch (baseOperationID) {
				case MidPackage.MODEL___GET_METATYPE: return RelationshipPackage.MODEL_REL___GET_METATYPE;
				case MidPackage.MODEL___GET_SUPERTYPE: return RelationshipPackage.MODEL_REL___GET_SUPERTYPE;
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
			case RelationshipPackage.MODEL_REL___GET_METATYPE:
				return getMetatype();
			case RelationshipPackage.MODEL_REL___GET_SUPERTYPE:
				return getSupertype();
		}
		return super.eInvoke(operationID, arguments);
	}

} //ModelRelImpl
