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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.MIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMF Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl#isAttribute <em>Attribute</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl#getRelatedClassName <em>Related Class Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EMFInfoImpl extends MinimalEObjectImpl.Container implements EMFInfo {
    /**
   * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getClassName()
   * @generated
   * @ordered
   */
    protected static final String CLASS_NAME_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getClassName()
   * @generated
   * @ordered
   */
    protected String className = EMFInfoImpl.CLASS_NAME_EDEFAULT;

    /**
   * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getFeatureName()
   * @generated
   * @ordered
   */
    protected static final String FEATURE_NAME_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getFeatureName()
   * @generated
   * @ordered
   */
    protected String featureName = EMFInfoImpl.FEATURE_NAME_EDEFAULT;

    /**
   * The default value of the '{@link #isAttribute() <em>Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #isAttribute()
   * @generated
   * @ordered
   */
    protected static final boolean ATTRIBUTE_EDEFAULT = false;

    /**
   * The cached value of the '{@link #isAttribute() <em>Attribute</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #isAttribute()
   * @generated
   * @ordered
   */
    protected boolean attribute = EMFInfoImpl.ATTRIBUTE_EDEFAULT;

    /**
   * The default value of the '{@link #getRelatedClassName() <em>Related Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getRelatedClassName()
   * @generated
   * @ordered
   */
    protected static final String RELATED_CLASS_NAME_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getRelatedClassName() <em>Related Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getRelatedClassName()
   * @generated
   * @ordered
   */
    protected String relatedClassName = EMFInfoImpl.RELATED_CLASS_NAME_EDEFAULT;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected EMFInfoImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return MIDPackage.Literals.EMF_INFO;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getClassName() {
    return this.className;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setClassName(String newClassName) {
    var oldClassName = this.className;
    this.className = newClassName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EMF_INFO__CLASS_NAME, oldClassName, this.className));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getFeatureName() {
    return this.featureName;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setFeatureName(String newFeatureName) {
    var oldFeatureName = this.featureName;
    this.featureName = newFeatureName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EMF_INFO__FEATURE_NAME, oldFeatureName, this.featureName));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean isAttribute() {
    return this.attribute;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setAttribute(boolean newAttribute) {
    var oldAttribute = this.attribute;
    this.attribute = newAttribute;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EMF_INFO__ATTRIBUTE, oldAttribute, this.attribute));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getRelatedClassName() {
    return this.relatedClassName;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setRelatedClassName(String newRelatedClassName) {
    var oldRelatedClassName = this.relatedClassName;
    this.relatedClassName = newRelatedClassName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EMF_INFO__RELATED_CLASS_NAME, oldRelatedClassName, this.relatedClassName));
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
      case MIDPackage.EMF_INFO__CLASS_NAME:
        return getClassName();
      case MIDPackage.EMF_INFO__FEATURE_NAME:
        return getFeatureName();
      case MIDPackage.EMF_INFO__ATTRIBUTE:
        return isAttribute();
      case MIDPackage.EMF_INFO__RELATED_CLASS_NAME:
        return getRelatedClassName();
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
      case MIDPackage.EMF_INFO__CLASS_NAME:
        setClassName((String)newValue);
        return;
      case MIDPackage.EMF_INFO__FEATURE_NAME:
        setFeatureName((String)newValue);
        return;
      case MIDPackage.EMF_INFO__ATTRIBUTE:
        setAttribute((Boolean)newValue);
        return;
      case MIDPackage.EMF_INFO__RELATED_CLASS_NAME:
        setRelatedClassName((String)newValue);
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
      case MIDPackage.EMF_INFO__CLASS_NAME:
        setClassName(EMFInfoImpl.CLASS_NAME_EDEFAULT);
        return;
      case MIDPackage.EMF_INFO__FEATURE_NAME:
        setFeatureName(EMFInfoImpl.FEATURE_NAME_EDEFAULT);
        return;
      case MIDPackage.EMF_INFO__ATTRIBUTE:
        setAttribute(EMFInfoImpl.ATTRIBUTE_EDEFAULT);
        return;
      case MIDPackage.EMF_INFO__RELATED_CLASS_NAME:
        setRelatedClassName(EMFInfoImpl.RELATED_CLASS_NAME_EDEFAULT);
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
      case MIDPackage.EMF_INFO__CLASS_NAME:
        return EMFInfoImpl.CLASS_NAME_EDEFAULT == null ? this.className != null : !EMFInfoImpl.CLASS_NAME_EDEFAULT.equals(this.className);
      case MIDPackage.EMF_INFO__FEATURE_NAME:
        return EMFInfoImpl.FEATURE_NAME_EDEFAULT == null ? this.featureName != null : !EMFInfoImpl.FEATURE_NAME_EDEFAULT.equals(this.featureName);
      case MIDPackage.EMF_INFO__ATTRIBUTE:
        return this.attribute != EMFInfoImpl.ATTRIBUTE_EDEFAULT;
      case MIDPackage.EMF_INFO__RELATED_CLASS_NAME:
        return EMFInfoImpl.RELATED_CLASS_NAME_EDEFAULT == null ? this.relatedClassName != null : !EMFInfoImpl.RELATED_CLASS_NAME_EDEFAULT.equals(this.relatedClassName);
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case MIDPackage.EMF_INFO___TO_TYPE_STRING:
        return toTypeString();
      case MIDPackage.EMF_INFO___TO_INSTANCE_STRING:
        return toInstanceString();
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
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (className: ");
    result.append(this.className);
    result.append(", featureName: ");
    result.append(this.featureName);
    result.append(", attribute: ");
    result.append(this.attribute);
    result.append(", relatedClassName: ");
    result.append(this.relatedClassName);
    result.append(')');
    return result.toString();
  }

    /**
     * @generated NOT
     */
    @Override
    public String toTypeString() {

        var typeString = getClassName();
        if (getFeatureName() != null) {
            typeString += MMINTConstants.MODELELEMENT_FEATURE_SEPARATOR1 + getFeatureName();
            if (!isAttribute()) {
                typeString += MMINTConstants.MODELELEMENT_REFERENCE_SEPARATOR;
            }
            typeString += MMINTConstants.MODELELEMENT_FEATURE_SEPARATOR2;
        }

        return typeString;
    }

    /**
     * @generated NOT
     */
    @Override
    public String toInstanceString() {

        var instanceString = (isAttribute()) ?
            MMINTConstants.MODELELEMENT_EMFVALUE_PLACEHOLDER + MMINTConstants.MODELELEMENT_FEATURE_SEPARATOR1 + getFeatureName() + MMINTConstants.MODELELEMENT_FEATURE_SEPARATOR2 + " " + MMINTConstants.MODELELEMENT_PRIMITIVEVALUE_PLACEHOLDER:
            MMINTConstants.MODELELEMENT_EMFVALUE_PLACEHOLDER;

        return instanceString;
    }

} //EMFInfoImpl
