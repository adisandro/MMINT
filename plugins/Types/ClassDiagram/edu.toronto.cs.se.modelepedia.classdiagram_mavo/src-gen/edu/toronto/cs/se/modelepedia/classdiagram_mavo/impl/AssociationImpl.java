/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;

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
	@Override
  public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class getSource() {
    if (this.source != null && this.source.eIsProxy()) {
      var oldSource = (InternalEObject)this.source;
      this.source = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)eResolveProxy(oldSource);
      if (this.source != oldSource) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE, oldSource, this.source));
      }
    }
    return this.source;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class basicGetSource() {
    return this.source;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetSource(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newSource, NotificationChain msgs) {
    var oldSource = this.source;
    this.source = newSource;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.ASSOCIATION__SOURCE, oldSource, newSource);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public void setSource(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newSource) {
    if (newSource != this.source) {
      NotificationChain msgs = null;
      if (this.source != null)
        msgs = ((InternalEObject)this.source).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
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
	@Override
  public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class getTarget() {
    if (this.target != null && this.target.eIsProxy()) {
      var oldTarget = (InternalEObject)this.target;
      this.target = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)eResolveProxy(oldTarget);
      if (this.target != oldTarget) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagram_MAVOPackage.ASSOCIATION__TARGET, oldTarget, this.target));
      }
    }
    return this.target;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class basicGetTarget() {
    return this.target;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetTarget(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newTarget, NotificationChain msgs) {
    var oldTarget = this.target;
    this.target = newTarget;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.ASSOCIATION__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public void setTarget(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newTarget) {
    if (newTarget != this.target) {
      NotificationChain msgs = null;
      if (this.target != null)
        msgs = ((InternalEObject)this.target).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
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
        if (this.source != null)
          msgs = ((InternalEObject)this.source).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_SOURCE, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
        return basicSetSource((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)otherEnd, msgs);
      case ClassDiagram_MAVOPackage.ASSOCIATION__TARGET:
        if (this.target != null)
          msgs = ((InternalEObject)this.target).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__ASSOCIATIONS_AS_TARGET, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
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
        return this.source != null;
      case ClassDiagram_MAVOPackage.ASSOCIATION__TARGET:
        return this.target != null;
    }
    return super.eIsSet(featureID);
  }

} //AssociationImpl
