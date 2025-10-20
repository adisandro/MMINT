/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extendible Element Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementConstraintImpl#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementConstraintImpl#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtendibleElementConstraintImpl extends MinimalEObjectImpl.Container implements ExtendibleElementConstraint {
    /**
   * The default value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getImplementation()
   * @generated
   * @ordered
   */
    protected static final String IMPLEMENTATION_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getImplementation() <em>Implementation</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getImplementation()
   * @generated
   * @ordered
   */
    protected String implementation = ExtendibleElementConstraintImpl.IMPLEMENTATION_EDEFAULT;

    /**
   * The default value of the '{@link #getLanguage() <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getLanguage()
   * @generated
   * @ordered
   */
    protected static final String LANGUAGE_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getLanguage()
   * @generated
   * @ordered
   */
    protected String language = ExtendibleElementConstraintImpl.LANGUAGE_EDEFAULT;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected ExtendibleElementConstraintImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return MIDPackage.Literals.EXTENDIBLE_ELEMENT_CONSTRAINT;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getImplementation() {
    return this.implementation;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setImplementation(String newImplementation) {
    var oldImplementation = this.implementation;
    this.implementation = newImplementation;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION, oldImplementation, this.implementation));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getLanguage() {
    return this.language;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setLanguage(String newLanguage) {
    var oldLanguage = this.language;
    this.language = newLanguage;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE, oldLanguage, this.language));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION:
        return getImplementation();
      case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE:
        return getLanguage();
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
      case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION:
        setImplementation((String)newValue);
        return;
      case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE:
        setLanguage((String)newValue);
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
      case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION:
        setImplementation(ExtendibleElementConstraintImpl.IMPLEMENTATION_EDEFAULT);
        return;
      case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE:
        setLanguage(ExtendibleElementConstraintImpl.LANGUAGE_EDEFAULT);
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
      case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__IMPLEMENTATION:
        return ExtendibleElementConstraintImpl.IMPLEMENTATION_EDEFAULT == null ? this.implementation != null : !ExtendibleElementConstraintImpl.IMPLEMENTATION_EDEFAULT.equals(this.implementation);
      case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT__LANGUAGE:
        return ExtendibleElementConstraintImpl.LANGUAGE_EDEFAULT == null ? this.language != null : !ExtendibleElementConstraintImpl.LANGUAGE_EDEFAULT.equals(this.language);
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
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (implementation: ");
    result.append(this.implementation);
    result.append(", language: ");
    result.append(this.language);
    result.append(')');
    return result.toString();
  }

} //ExtendibleElementConstraintImpl
