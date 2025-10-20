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
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EString To Extendible Element Map</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EStringToExtendibleElementMapImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EStringToExtendibleElementMapImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EStringToExtendibleElementMapImpl extends MinimalEObjectImpl.Container implements BasicEMap.Entry<String,ExtendibleElement> {
    /**
   * The default value of the '{@link #getTypedKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getTypedKey()
   * @generated
   * @ordered
   */
    protected static final String KEY_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getTypedKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getTypedKey()
   * @generated
   * @ordered
   */
    protected String key = EStringToExtendibleElementMapImpl.KEY_EDEFAULT;

    /**
   * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getTypedValue()
   * @generated
   * @ordered
   */
    protected ExtendibleElement value;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected EStringToExtendibleElementMapImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return MIDPackage.Literals.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public String getTypedKey() {
    return this.key;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public void setTypedKey(String newKey) {
    var oldKey = this.key;
    this.key = newKey;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY, oldKey, this.key));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ExtendibleElement getTypedValue() {
    if (this.value != null && this.value.eIsProxy()) {
      var oldValue = (InternalEObject)this.value;
      this.value = (ExtendibleElement)eResolveProxy(oldValue);
      if (this.value != oldValue) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE, oldValue, this.value));
        }
      }
    }
    return this.value;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ExtendibleElement basicGetTypedValue() {
    return this.value;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public void setTypedValue(ExtendibleElement newValue) {
    var oldValue = this.value;
    this.value = newValue;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE, oldValue, this.value));
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
      case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY:
        return getTypedKey();
      case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE:
        if (resolve) {
          return getTypedValue();
        }
        return basicGetTypedValue();
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
      case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY:
        setTypedKey((String)newValue);
        return;
      case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE:
        setTypedValue((ExtendibleElement)newValue);
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
      case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY:
        setTypedKey(EStringToExtendibleElementMapImpl.KEY_EDEFAULT);
        return;
      case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE:
        setTypedValue((ExtendibleElement)null);
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
      case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__KEY:
        return EStringToExtendibleElementMapImpl.KEY_EDEFAULT == null ? this.key != null : !EStringToExtendibleElementMapImpl.KEY_EDEFAULT.equals(this.key);
      case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP__VALUE:
        return this.value != null;
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
    result.append(" (key: ");
    result.append(this.key);
    result.append(')');
    return result.toString();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected int hash = -1;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public int getHash() {
    if (this.hash == -1) {
      Object theKey = getKey();
      this.hash = (theKey == null ? 0 : theKey.hashCode());
    }
    return this.hash;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setHash(int hash) {
    this.hash = hash;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getKey() {
    return getTypedKey();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setKey(String key) {
    setTypedKey(key);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ExtendibleElement getValue() {
    return getTypedValue();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ExtendibleElement setValue(ExtendibleElement value) {
    var oldValue = getValue();
    setTypedValue(value);
    return oldValue;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @SuppressWarnings("unchecked")
    public EMap<String, ExtendibleElement> getEMap() {
    var container = eContainer();
    return container == null ? null : (EMap<String, ExtendibleElement>)container.eGet(eContainmentFeature());
  }

} //EStringToExtendibleElementMapImpl
