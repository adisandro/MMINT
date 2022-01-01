/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.GenericElementImpl#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class GenericElementImpl extends ExtendibleElementImpl implements GenericElement {
    /**
   * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
    protected static final boolean ABSTRACT_EDEFAULT = false;
    /**
   * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #isAbstract()
   * @generated
   * @ordered
   */
    protected boolean abstract_ = ABSTRACT_EDEFAULT;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected GenericElementImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return MIDPackage.Literals.GENERIC_ELEMENT;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean isAbstract() {
    return abstract_;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setAbstract(boolean newAbstract) {
    boolean oldAbstract = abstract_;
    abstract_ = newAbstract;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.GENERIC_ELEMENT__ABSTRACT, oldAbstract, abstract_));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case MIDPackage.GENERIC_ELEMENT__ABSTRACT:
        return isAbstract();
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
      case MIDPackage.GENERIC_ELEMENT__ABSTRACT:
        setAbstract((Boolean)newValue);
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
      case MIDPackage.GENERIC_ELEMENT__ABSTRACT:
        setAbstract(ABSTRACT_EDEFAULT);
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
      case MIDPackage.GENERIC_ELEMENT__ABSTRACT:
        return abstract_ != ABSTRACT_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (abstract: ");
    result.append(abstract_);
    result.append(')');
    return result.toString();
  }

} //GenericElementImpl
