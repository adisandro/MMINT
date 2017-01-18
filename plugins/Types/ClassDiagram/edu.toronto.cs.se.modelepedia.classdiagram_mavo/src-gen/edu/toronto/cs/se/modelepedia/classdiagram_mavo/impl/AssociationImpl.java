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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl;

import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AssociationImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.AssociationImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssociationImpl extends NamedElementImpl implements Association {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagram_MAVOPackage.Literals.ASSOCIATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newSource, NotificationChain msgs) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagram_MAVOPackage.ASSOCIATION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newTarget, NotificationChain msgs) {
		edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.ASSOCIATION__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.ASSOCIATION__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
				return basicSetSource((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)otherEnd, msgs);
			case ClassDiagram_MAVOPackage.ASSOCIATION__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
				return basicSetTarget((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)otherEnd, msgs);
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
			case ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE:
				return basicSetSource(null, msgs);
			case ClassDiagram_MAVOPackage.ASSOCIATION__TARGET:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case ClassDiagram_MAVOPackage.ASSOCIATION__TARGET:
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
			case ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE:
				setSource((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)newValue);
				return;
			case ClassDiagram_MAVOPackage.ASSOCIATION__TARGET:
				setTarget((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)newValue);
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
			case ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE:
				setSource((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)null);
				return;
			case ClassDiagram_MAVOPackage.ASSOCIATION__TARGET:
				setTarget((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)null);
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
			case ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE:
				return source != null;
			case ClassDiagram_MAVOPackage.ASSOCIATION__TARGET:
				return target != null;
		}
		return super.eIsSet(featureID);
	}

} //AssociationImpl
