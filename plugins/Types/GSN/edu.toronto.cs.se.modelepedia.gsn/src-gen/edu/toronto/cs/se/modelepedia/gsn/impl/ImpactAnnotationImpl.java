/*******************************************************************************
 * Copyright (c) 2017, 2023 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Impact Annotation</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ImpactAnnotationImpl#getType <em>Type</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ImpactAnnotationImpl#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImpactAnnotationImpl extends MinimalEObjectImpl.Container implements ImpactAnnotation {
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final ImpactType TYPE_EDEFAULT = ImpactType.REVISE;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ImpactType type = ImpactAnnotationImpl.TYPE_EDEFAULT;

  /**
   * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected static final String SOURCE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSource() <em>Source</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see #getSource()
   * @generated
   * @ordered
   */
  protected String source = ImpactAnnotationImpl.SOURCE_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ImpactAnnotationImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.IMPACT_ANNOTATION;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImpactType getType() {
    return this.type;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setType(ImpactType newType) {
    var oldType = this.type;
    this.type = newType == null ? ImpactAnnotationImpl.TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.IMPACT_ANNOTATION__TYPE, oldType, this.type));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getSource() {
    return this.source;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSource(String newSource) {
    var oldSource = this.source;
    this.source = newSource;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.IMPACT_ANNOTATION__SOURCE, oldSource, this.source));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.IMPACT_ANNOTATION__TYPE:
        return getType();
      case GSNPackage.IMPACT_ANNOTATION__SOURCE:
        return getSource();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case GSNPackage.IMPACT_ANNOTATION__TYPE:
        setType((ImpactType)newValue);
        return;
      case GSNPackage.IMPACT_ANNOTATION__SOURCE:
        setSource((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case GSNPackage.IMPACT_ANNOTATION__TYPE:
        setType(ImpactAnnotationImpl.TYPE_EDEFAULT);
        return;
      case GSNPackage.IMPACT_ANNOTATION__SOURCE:
        setSource(ImpactAnnotationImpl.SOURCE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case GSNPackage.IMPACT_ANNOTATION__TYPE:
        return this.type != ImpactAnnotationImpl.TYPE_EDEFAULT;
      case GSNPackage.IMPACT_ANNOTATION__SOURCE:
        return ImpactAnnotationImpl.SOURCE_EDEFAULT == null ? this.source != null : !ImpactAnnotationImpl.SOURCE_EDEFAULT.equals(this.source);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (type: ");
    result.append(this.type);
    result.append(", source: ");
    result.append(this.source);
    result.append(')');
    return result.toString();
  }

} // ImpactAnnotationImpl
