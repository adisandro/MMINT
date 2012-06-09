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
package edu.toronto.cs.se.mmtf.mid.impl;

import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.ModelElementEntityWildcard;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element Entity Wildcard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementEntityWildcardImpl#getModelElementRelationshipWildcard <em>Model Element Relationship Wildcard</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementEntityWildcardImpl extends EObjectImpl implements ModelElementEntityWildcard {
	/**
	 * The cached value of the '{@link #getModelElementRelationshipWildcard() <em>Model Element Relationship Wildcard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElementRelationshipWildcard()
	 * @generated
	 * @ordered
	 */
	protected ModelElementEntityWildcard modelElementRelationshipWildcard;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementEntityWildcardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidPackage.Literals.MODEL_ELEMENT_ENTITY_WILDCARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEntityWildcard getModelElementRelationshipWildcard() {
		if (modelElementRelationshipWildcard != null && modelElementRelationshipWildcard.eIsProxy()) {
			InternalEObject oldModelElementRelationshipWildcard = (InternalEObject)modelElementRelationshipWildcard;
			modelElementRelationshipWildcard = (ModelElementEntityWildcard)eResolveProxy(oldModelElementRelationshipWildcard);
			if (modelElementRelationshipWildcard != oldModelElementRelationshipWildcard) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MidPackage.MODEL_ELEMENT_ENTITY_WILDCARD__MODEL_ELEMENT_RELATIONSHIP_WILDCARD, oldModelElementRelationshipWildcard, modelElementRelationshipWildcard));
			}
		}
		return modelElementRelationshipWildcard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementEntityWildcard basicGetModelElementRelationshipWildcard() {
		return modelElementRelationshipWildcard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelElementRelationshipWildcard(ModelElementEntityWildcard newModelElementRelationshipWildcard) {
		ModelElementEntityWildcard oldModelElementRelationshipWildcard = modelElementRelationshipWildcard;
		modelElementRelationshipWildcard = newModelElementRelationshipWildcard;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.MODEL_ELEMENT_ENTITY_WILDCARD__MODEL_ELEMENT_RELATIONSHIP_WILDCARD, oldModelElementRelationshipWildcard, modelElementRelationshipWildcard));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidPackage.MODEL_ELEMENT_ENTITY_WILDCARD__MODEL_ELEMENT_RELATIONSHIP_WILDCARD:
				if (resolve) return getModelElementRelationshipWildcard();
				return basicGetModelElementRelationshipWildcard();
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
			case MidPackage.MODEL_ELEMENT_ENTITY_WILDCARD__MODEL_ELEMENT_RELATIONSHIP_WILDCARD:
				setModelElementRelationshipWildcard((ModelElementEntityWildcard)newValue);
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
			case MidPackage.MODEL_ELEMENT_ENTITY_WILDCARD__MODEL_ELEMENT_RELATIONSHIP_WILDCARD:
				setModelElementRelationshipWildcard((ModelElementEntityWildcard)null);
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
			case MidPackage.MODEL_ELEMENT_ENTITY_WILDCARD__MODEL_ELEMENT_RELATIONSHIP_WILDCARD:
				return modelElementRelationshipWildcard != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelElementEntityWildcardImpl
