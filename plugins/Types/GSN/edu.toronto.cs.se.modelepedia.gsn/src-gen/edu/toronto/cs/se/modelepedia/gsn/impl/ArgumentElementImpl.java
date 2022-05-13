/*******************************************************************************
 * Copyright (c) 2017, 2022 Alessio Di Sandro, Nick Fung.
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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.ValidityValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Argument Element</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl#getId <em>Id</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl#getDescription <em>Description</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl#getContentValidity <em>Content
 * Validity</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ArgumentElementImpl extends MinimalEObjectImpl.Container implements ArgumentElement {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ArgumentElementImpl.ID_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = ArgumentElementImpl.DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getContentValidity() <em>Content Validity</em>}' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getContentValidity()
   * @generated
   * @ordered
   */
  protected static final ValidityValue CONTENT_VALIDITY_EDEFAULT = ValidityValue.INVALID;

  /**
   * The cached value of the '{@link #getContentValidity() <em>Content Validity</em>}' attribute.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getContentValidity()
   * @generated
   * @ordered
   */
  protected ValidityValue contentValidity = ArgumentElementImpl.CONTENT_VALIDITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getStatus() <em>Status</em>}' containment reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected ImpactAnnotation status;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ArgumentElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.ARGUMENT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getId() {
    return this.id;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setId(String newId) {
    var oldId = this.id;
    this.id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__ID, oldId, this.id));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDescription() {
    return this.description;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDescription(String newDescription) {
    var oldDescription = this.description;
    this.description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION, oldDescription, this.description));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValidityValue getContentValidity() {
    return this.contentValidity;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setContentValidity(ValidityValue newContentValidity) {
    var oldContentValidity = this.contentValidity;
    this.contentValidity = newContentValidity == null ? ArgumentElementImpl.CONTENT_VALIDITY_EDEFAULT : newContentValidity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__CONTENT_VALIDITY, oldContentValidity, this.contentValidity));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImpactAnnotation getStatus() {
    return this.status;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatus(ImpactAnnotation newStatus, NotificationChain msgs) {
    var oldStatus = this.status;
    this.status = newStatus;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__STATUS, oldStatus, newStatus);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStatus(ImpactAnnotation newStatus) {
    if (newStatus != this.status) {
      NotificationChain msgs = null;
      if (this.status != null)
        msgs = ((InternalEObject)this.status).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.ARGUMENT_ELEMENT__STATUS, null, msgs);
      if (newStatus != null)
        msgs = ((InternalEObject)newStatus).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.ARGUMENT_ELEMENT__STATUS, null, msgs);
      msgs = basicSetStatus(newStatus, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__STATUS, newStatus, newStatus));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        return basicSetStatus(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.ARGUMENT_ELEMENT__ID:
        return getId();
      case GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION:
        return getDescription();
      case GSNPackage.ARGUMENT_ELEMENT__CONTENT_VALIDITY:
        return getContentValidity();
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        return getStatus();
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
      case GSNPackage.ARGUMENT_ELEMENT__ID:
        setId((String)newValue);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__CONTENT_VALIDITY:
        setContentValidity((ValidityValue)newValue);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        setStatus((ImpactAnnotation)newValue);
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
      case GSNPackage.ARGUMENT_ELEMENT__ID:
        setId(ArgumentElementImpl.ID_EDEFAULT);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION:
        setDescription(ArgumentElementImpl.DESCRIPTION_EDEFAULT);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__CONTENT_VALIDITY:
        setContentValidity(ArgumentElementImpl.CONTENT_VALIDITY_EDEFAULT);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        setStatus((ImpactAnnotation)null);
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
      case GSNPackage.ARGUMENT_ELEMENT__ID:
        return ArgumentElementImpl.ID_EDEFAULT == null ? this.id != null : !ArgumentElementImpl.ID_EDEFAULT.equals(this.id);
      case GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION:
        return ArgumentElementImpl.DESCRIPTION_EDEFAULT == null ? this.description != null : !ArgumentElementImpl.DESCRIPTION_EDEFAULT.equals(this.description);
      case GSNPackage.ARGUMENT_ELEMENT__CONTENT_VALIDITY:
        return this.contentValidity != ArgumentElementImpl.CONTENT_VALIDITY_EDEFAULT;
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        return this.status != null;
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
    result.append(" (id: ");
    result.append(this.id);
    result.append(", description: ");
    result.append(this.description);
    result.append(", contentValidity: ");
    result.append(this.contentValidity);
    result.append(')');
    return result.toString();
  }

} // ArgumentElementImpl
