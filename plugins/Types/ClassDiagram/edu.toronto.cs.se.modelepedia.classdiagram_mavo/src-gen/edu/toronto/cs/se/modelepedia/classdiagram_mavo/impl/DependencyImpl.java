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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mavo.impl.MAVOElementImpl;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.DependencyImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.DependencyImpl#getDependee <em>Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.DependencyImpl#getDepender <em>Depender</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DependencyImpl extends MAVOElementImpl implements Dependency {
	/**
   * The cached setting delegate for the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
	protected EStructuralFeature.Internal.SettingDelegate NAME__ESETTING_DELEGATE = ((EStructuralFeature.Internal)ClassDiagram_MAVOPackage.Literals.DEPENDENCY__NAME).getSettingDelegate();

	/**
   * The cached value of the '{@link #getDependee() <em>Dependee</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDependee()
   * @generated
   * @ordered
   */
	protected edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class dependee;

	/**
   * The cached value of the '{@link #getDepender() <em>Depender</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getDepender()
   * @generated
   * @ordered
   */
	protected edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class depender;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected DependencyImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ClassDiagram_MAVOPackage.Literals.DEPENDENCY;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public String getName() {
    return (String)this.NAME__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class getDependee() {
    if (this.dependee != null && this.dependee.eIsProxy()) {
      var oldDependee = (InternalEObject)this.dependee;
      this.dependee = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)eResolveProxy(oldDependee);
      if (this.dependee != oldDependee) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE, oldDependee, this.dependee));
      }
    }
    return this.dependee;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class basicGetDependee() {
    return this.dependee;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetDependee(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newDependee, NotificationChain msgs) {
    var oldDependee = this.dependee;
    this.dependee = newDependee;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE, oldDependee, newDependee);
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
  public void setDependee(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newDependee) {
    if (newDependee != this.dependee) {
      NotificationChain msgs = null;
      if (this.dependee != null)
        msgs = ((InternalEObject)this.dependee).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
      if (newDependee != null)
        msgs = ((InternalEObject)newDependee).eInverseAdd(this, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
      msgs = basicSetDependee(newDependee, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE, newDependee, newDependee));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class getDepender() {
    if (this.depender != null && this.depender.eIsProxy()) {
      var oldDepender = (InternalEObject)this.depender;
      this.depender = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)eResolveProxy(oldDepender);
      if (this.depender != oldDepender) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER, oldDepender, this.depender));
      }
    }
    return this.depender;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class basicGetDepender() {
    return this.depender;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetDepender(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newDepender, NotificationChain msgs) {
    var oldDepender = this.depender;
    this.depender = newDepender;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER, oldDepender, newDepender);
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
  public void setDepender(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newDepender) {
    if (newDepender != this.depender) {
      NotificationChain msgs = null;
      if (this.depender != null)
        msgs = ((InternalEObject)this.depender).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
      if (newDepender != null)
        msgs = ((InternalEObject)newDepender).eInverseAdd(this, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
      msgs = basicSetDepender(newDepender, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER, newDepender, newDepender));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE:
        if (this.dependee != null)
          msgs = ((InternalEObject)this.dependee).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
        return basicSetDependee((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)otherEnd, msgs);
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER:
        if (this.depender != null)
          msgs = ((InternalEObject)this.depender).eInverseRemove(this, ClassDiagram_MAVOPackage.CLASS__DEPENDENCIES_AS_DEPENDER, edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, msgs);
        return basicSetDepender((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)otherEnd, msgs);
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
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE:
        return basicSetDependee(null, msgs);
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER:
        return basicSetDepender(null, msgs);
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
      case ClassDiagram_MAVOPackage.DEPENDENCY__NAME:
        return getName();
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE:
        if (resolve) return getDependee();
        return basicGetDependee();
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER:
        if (resolve) return getDepender();
        return basicGetDepender();
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
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE:
        setDependee((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)newValue);
        return;
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER:
        setDepender((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)newValue);
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
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE:
        setDependee((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)null);
        return;
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER:
        setDepender((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)null);
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
      case ClassDiagram_MAVOPackage.DEPENDENCY__NAME:
        return this.NAME__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDEE:
        return this.dependee != null;
      case ClassDiagram_MAVOPackage.DEPENDENCY__DEPENDER:
        return this.depender != null;
    }
    return super.eIsSet(featureID);
  }

} //DependencyImpl
