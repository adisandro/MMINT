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
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl;

import edu.toronto.cs.se.mavo.impl.MAVOReferenceImpl;
import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column;
import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference;
import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey;
import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreign Column Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl.ForeignColumnReferenceImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl.ForeignColumnReferenceImpl#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeignColumnReferenceImpl extends MAVOReferenceImpl implements ForeignColumnReference {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Column target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForeignColumnReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationalDatabase_MAVOPackage.Literals.FOREIGN_COLUMN_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeignKey getSource() {
		if (eContainerFeatureID() != RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE) return null;
		return (ForeignKey)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(ForeignKey newSource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSource, RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ForeignKey newSource) {
		if (newSource != eInternalContainer() || (eContainerFeatureID() != RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE && newSource != null)) {
			if (EcoreUtil.isAncestor(this, newSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, RelationalDatabase_MAVOPackage.FOREIGN_KEY__FOREIGN_COLUMN, ForeignKey.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Column)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Column newTarget, NotificationChain msgs) {
		Column oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Column newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN, Column.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN, Column.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSource((ForeignKey)otherEnd, msgs);
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, RelationalDatabase_MAVOPackage.COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN, Column.class, msgs);
				return basicSetTarget((Column)otherEnd, msgs);
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
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE:
				return basicSetSource(null, msgs);
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET:
				return basicSetTarget(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE:
				return eInternalContainer().eInverseRemove(this, RelationalDatabase_MAVOPackage.FOREIGN_KEY__FOREIGN_COLUMN, ForeignKey.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE:
				return getSource();
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE:
				setSource((ForeignKey)newValue);
				return;
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET:
				setTarget((Column)newValue);
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
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE:
				setSource((ForeignKey)null);
				return;
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET:
				setTarget((Column)null);
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
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__SOURCE:
				return getSource() != null;
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //ForeignColumnReferenceImpl
