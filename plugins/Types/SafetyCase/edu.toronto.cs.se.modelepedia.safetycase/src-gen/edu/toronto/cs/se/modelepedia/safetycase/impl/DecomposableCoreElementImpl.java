/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 * 
 */
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.GSNPackage;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.ValidityValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decomposable Core Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl#getContentValidity <em>Content Validity</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl#getInContextOf <em>In Context Of</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DecomposableCoreElementImpl extends SupportableImpl implements DecomposableCoreElement {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ID_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The default value of the '{@link #getContentValidity() <em>Content Validity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContentValidity()
   * @generated
   * @ordered
   */
  protected static final ValidityValue CONTENT_VALIDITY_EDEFAULT = ValidityValue.INVALID;

  /**
   * The cached value of the '{@link #getContentValidity() <em>Content Validity</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContentValidity()
   * @generated
   * @ordered
   */
  protected ValidityValue contentValidity = CONTENT_VALIDITY_EDEFAULT;

  /**
   * The cached value of the '{@link #getStatus() <em>Status</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected ImpactAnnotation status;

  /**
   * The cached value of the '{@link #getInContextOf() <em>In Context Of</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInContextOf()
   * @generated
   * @ordered
   */
  protected EList<InContextOf> inContextOf;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DecomposableCoreElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.DECOMPOSABLE_CORE_ELEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setId(String newId) {
    String oldId = id;
    id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__ID, oldId, id));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValidityValue getContentValidity() {
    return contentValidity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setContentValidity(ValidityValue newContentValidity) {
    ValidityValue oldContentValidity = contentValidity;
    contentValidity = newContentValidity == null ? CONTENT_VALIDITY_EDEFAULT : newContentValidity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY, oldContentValidity, contentValidity));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImpactAnnotation getStatus() {
    return status;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatus(ImpactAnnotation newStatus, NotificationChain msgs) {
    ImpactAnnotation oldStatus = status;
    status = newStatus;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS, oldStatus, newStatus);
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
  public void setStatus(ImpactAnnotation newStatus) {
    if (newStatus != status) {
      NotificationChain msgs = null;
      if (status != null)
        msgs = ((InternalEObject)status).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS, null, msgs);
      if (newStatus != null)
        msgs = ((InternalEObject)newStatus).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS, null, msgs);
      msgs = basicSetStatus(newStatus, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS, newStatus, newStatus));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<InContextOf> getInContextOf() {
    if (inContextOf == null) {
      inContextOf = new EObjectContainmentWithInverseEList<InContextOf>(InContextOf.class, this, GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF, GSNPackage.IN_CONTEXT_OF__CONTEXT_OF);
    }
    return inContextOf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getInContextOf()).basicAdd(otherEnd, msgs);
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
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS:
        return basicSetStatus(null, msgs);
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
        return ((InternalEList<?>)getInContextOf()).basicRemove(otherEnd, msgs);
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
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__ID:
        return getId();
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION:
        return getDescription();
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY:
        return getContentValidity();
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS:
        return getStatus();
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
        return getInContextOf();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__ID:
        setId((String)newValue);
        return;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY:
        setContentValidity((ValidityValue)newValue);
        return;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS:
        setStatus((ImpactAnnotation)newValue);
        return;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
        getInContextOf().clear();
        getInContextOf().addAll((Collection<? extends InContextOf>)newValue);
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
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__ID:
        setId(ID_EDEFAULT);
        return;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY:
        setContentValidity(CONTENT_VALIDITY_EDEFAULT);
        return;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS:
        setStatus((ImpactAnnotation)null);
        return;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
        getInContextOf().clear();
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
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__ID:
        return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY:
        return contentValidity != CONTENT_VALIDITY_EDEFAULT;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS:
        return status != null;
      case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
        return inContextOf != null && !inContextOf.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == ArgumentElement.class) {
      switch (derivedFeatureID) {
        case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__ID: return GSNPackage.ARGUMENT_ELEMENT__ID;
        case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION: return GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION;
        case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY: return GSNPackage.ARGUMENT_ELEMENT__CONTENT_VALIDITY;
        case GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS: return GSNPackage.ARGUMENT_ELEMENT__STATUS;
        default: return -1;
      }
    }
    if (baseClass == CoreElement.class) {
      switch (derivedFeatureID) {
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == ArgumentElement.class) {
      switch (baseFeatureID) {
        case GSNPackage.ARGUMENT_ELEMENT__ID: return GSNPackage.DECOMPOSABLE_CORE_ELEMENT__ID;
        case GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION: return GSNPackage.DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION;
        case GSNPackage.ARGUMENT_ELEMENT__CONTENT_VALIDITY: return GSNPackage.DECOMPOSABLE_CORE_ELEMENT__CONTENT_VALIDITY;
        case GSNPackage.ARGUMENT_ELEMENT__STATUS: return GSNPackage.DECOMPOSABLE_CORE_ELEMENT__STATUS;
        default: return -1;
      }
    }
    if (baseClass == CoreElement.class) {
      switch (baseFeatureID) {
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (id: ");
    result.append(id);
    result.append(", description: ");
    result.append(description);
    result.append(", contentValidity: ");
    result.append(contentValidity);
    result.append(')');
    return result.toString();
  }

} //DecomposableCoreElementImpl
