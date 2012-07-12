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

import edu.toronto.cs.se.mmtf.mid.impl.ModelImpl;

import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl#getModels <em>Models</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl#getLinks <em>Links</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl#getModelRefs <em>Model Refs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.ModelRelImpl#isUnbounded <em>Unbounded</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelRelImpl extends ModelImpl implements ModelRel {
	/**
	 * The cached value of the '{@link #getModels() <em>Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModels()
	 * @generated
	 * @ordered
	 */
	protected EList<Model> models;

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
	 * The cached value of the '{@link #getModelRefs() <em>Model Refs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelReference> modelRefs;

	/**
	 * The default value of the '{@link #isUnbounded() <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnbounded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNBOUNDED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnbounded() <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnbounded()
	 * @generated
	 * @ordered
	 */
	protected boolean unbounded = UNBOUNDED_EDEFAULT;

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
	public EList<Model> getModels() {
		if (models == null) {
			models = new EObjectResolvingEList<Model>(Model.class, this, RelationshipPackage.MODEL_REL__MODELS);
		}
		return models;
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
	public EList<ModelReference> getModelRefs() {
		if (modelRefs == null) {
			modelRefs = new EObjectContainmentEList<ModelReference>(ModelReference.class, this, RelationshipPackage.MODEL_REL__MODEL_REFS);
		}
		return modelRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnbounded() {
		return unbounded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnbounded(boolean newUnbounded) {
		boolean oldUnbounded = unbounded;
		unbounded = newUnbounded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.MODEL_REL__UNBOUNDED, oldUnbounded, unbounded));
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
	public ModelRel getSupertype() {
		ExtendibleElement supertype = super.getSupertype();
		return (supertype == null) ? null : (ModelRel) supertype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationshipPackage.MODEL_REL__LINKS:
				return ((InternalEList<?>)getLinks()).basicRemove(otherEnd, msgs);
			case RelationshipPackage.MODEL_REL__MODEL_REFS:
				return ((InternalEList<?>)getModelRefs()).basicRemove(otherEnd, msgs);
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
			case RelationshipPackage.MODEL_REL__MODELS:
				return getModels();
			case RelationshipPackage.MODEL_REL__LINKS:
				return getLinks();
			case RelationshipPackage.MODEL_REL__MODEL_REFS:
				return getModelRefs();
			case RelationshipPackage.MODEL_REL__UNBOUNDED:
				return isUnbounded();
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
			case RelationshipPackage.MODEL_REL__MODELS:
				getModels().clear();
				getModels().addAll((Collection<? extends Model>)newValue);
				return;
			case RelationshipPackage.MODEL_REL__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends Link>)newValue);
				return;
			case RelationshipPackage.MODEL_REL__MODEL_REFS:
				getModelRefs().clear();
				getModelRefs().addAll((Collection<? extends ModelReference>)newValue);
				return;
			case RelationshipPackage.MODEL_REL__UNBOUNDED:
				setUnbounded((Boolean)newValue);
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
			case RelationshipPackage.MODEL_REL__MODELS:
				getModels().clear();
				return;
			case RelationshipPackage.MODEL_REL__LINKS:
				getLinks().clear();
				return;
			case RelationshipPackage.MODEL_REL__MODEL_REFS:
				getModelRefs().clear();
				return;
			case RelationshipPackage.MODEL_REL__UNBOUNDED:
				setUnbounded(UNBOUNDED_EDEFAULT);
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
			case RelationshipPackage.MODEL_REL__MODELS:
				return models != null && !models.isEmpty();
			case RelationshipPackage.MODEL_REL__LINKS:
				return links != null && !links.isEmpty();
			case RelationshipPackage.MODEL_REL__MODEL_REFS:
				return modelRefs != null && !modelRefs.isEmpty();
			case RelationshipPackage.MODEL_REL__UNBOUNDED:
				return unbounded != UNBOUNDED_EDEFAULT;
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (unbounded: ");
		result.append(unbounded);
		result.append(')');
		return result.toString();
	}

} //ModelRelImpl
