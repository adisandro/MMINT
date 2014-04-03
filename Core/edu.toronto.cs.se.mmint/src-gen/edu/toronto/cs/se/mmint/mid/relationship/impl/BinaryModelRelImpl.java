/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Model Rel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryModelRelImpl#getSourceModel <em>Source Model</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryModelRelImpl#getTargetModel <em>Target Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryModelRelImpl extends ModelRelImpl implements BinaryModelRel {
	/**
	 * The cached value of the '{@link #getSourceModel() <em>Source Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceModel()
	 * @generated
	 * @ordered
	 */
	protected Model sourceModel;
	/**
	 * The cached value of the '{@link #getTargetModel() <em>Target Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetModel()
	 * @generated
	 * @ordered
	 */
	protected Model targetModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryModelRelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.BINARY_MODEL_REL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getSourceModel() {
		if (sourceModel != null && sourceModel.eIsProxy()) {
			InternalEObject oldSourceModel = (InternalEObject)sourceModel;
			sourceModel = (Model)eResolveProxy(oldSourceModel);
			if (sourceModel != oldSourceModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL, oldSourceModel, sourceModel));
			}
		}
		return sourceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetSourceModel() {
		return sourceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceModel(Model newSourceModel) {
		Model oldSourceModel = sourceModel;
		sourceModel = newSourceModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL, oldSourceModel, sourceModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model getTargetModel() {
		if (targetModel != null && targetModel.eIsProxy()) {
			InternalEObject oldTargetModel = (InternalEObject)targetModel;
			targetModel = (Model)eResolveProxy(oldTargetModel);
			if (targetModel != oldTargetModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL, oldTargetModel, targetModel));
			}
		}
		return targetModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model basicGetTargetModel() {
		return targetModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetModel(Model newTargetModel) {
		Model oldTargetModel = targetModel;
		targetModel = newTargetModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL, oldTargetModel, targetModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL:
				if (resolve) return getSourceModel();
				return basicGetSourceModel();
			case RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL:
				if (resolve) return getTargetModel();
				return basicGetTargetModel();
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
			case RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL:
				setSourceModel((Model)newValue);
				return;
			case RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL:
				setTargetModel((Model)newValue);
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
			case RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL:
				setSourceModel((Model)null);
				return;
			case RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL:
				setTargetModel((Model)null);
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
			case RelationshipPackage.BINARY_MODEL_REL__SOURCE_MODEL:
				return sourceModel != null;
			case RelationshipPackage.BINARY_MODEL_REL__TARGET_MODEL:
				return targetModel != null;
		}
		return super.eIsSet(featureID);
	}

} //BinaryModelRelImpl
