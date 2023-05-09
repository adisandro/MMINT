/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.types.gsn.templates.Domain;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.TemplateElement;
import edu.toronto.cs.se.modelepedia.gsn.impl.GoalImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainGoalImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainGoalImpl#isValid <em>Valid</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainGoalImpl extends GoalImpl implements DomainGoal {
  /**
   * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDomain()
   * @generated
   * @ordered
   */
  protected Domain domain;

  /**
   * The default value of the '{@link #isValid() <em>Valid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isValid()
   * @generated
   * @ordered
   */
  protected static final boolean VALID_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isValid() <em>Valid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isValid()
   * @generated
   * @ordered
   */
  protected boolean valid = DomainGoalImpl.VALID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DomainGoalImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.DOMAIN_GOAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Domain getDomain() {
    return this.domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDomain(Domain newDomain, NotificationChain msgs) {
    var oldDomain = this.domain;
    this.domain = newDomain;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN, oldDomain, newDomain);
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
  public void setDomain(Domain newDomain) {
    if (newDomain != this.domain) {
      NotificationChain msgs = null;
      if (this.domain != null)
        msgs = ((InternalEObject)this.domain).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN, null, msgs);
      if (newDomain != null)
        msgs = ((InternalEObject)newDomain).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN, null, msgs);
      msgs = basicSetDomain(newDomain, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN, newDomain, newDomain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isValid() {
    return this.valid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setValid(boolean newValid) {
    var oldValid = this.valid;
    this.valid = newValid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.DOMAIN_GOAL__VALID, oldValid, this.valid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void validate() throws Exception {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void repair() throws Exception {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN:
        return basicSetDomain(null, msgs);
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
      case GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN:
        return getDomain();
      case GSNTemplatesPackage.DOMAIN_GOAL__VALID:
        return isValid();
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
      case GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN:
        setDomain((Domain)newValue);
        return;
      case GSNTemplatesPackage.DOMAIN_GOAL__VALID:
        setValid((Boolean)newValue);
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
      case GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN:
        setDomain((Domain)null);
        return;
      case GSNTemplatesPackage.DOMAIN_GOAL__VALID:
        setValid(DomainGoalImpl.VALID_EDEFAULT);
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
      case GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN:
        return this.domain != null;
      case GSNTemplatesPackage.DOMAIN_GOAL__VALID:
        return this.valid != DomainGoalImpl.VALID_EDEFAULT;
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
    if (baseClass == DomainDecompositionElement.class) {
      return switch (derivedFeatureID) {
      case GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN -> GSNTemplatesPackage.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN;
      default -> -1;
      };
    }
    if (baseClass == TemplateElement.class) {
      return switch (derivedFeatureID) {
      case GSNTemplatesPackage.DOMAIN_GOAL__VALID -> GSNPackage.TEMPLATE_ELEMENT__VALID;
      default -> -1;
      };
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
    if (baseClass == DomainDecompositionElement.class) {
      return switch (baseFeatureID) {
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN -> GSNTemplatesPackage.DOMAIN_GOAL__DOMAIN;
      default -> -1;
      };
    }
    if (baseClass == TemplateElement.class) {
      return switch (baseFeatureID) {
      case GSNPackage.TEMPLATE_ELEMENT__VALID -> GSNTemplatesPackage.DOMAIN_GOAL__VALID;
      default -> -1;
      };
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == DomainDecompositionElement.class) {
      return switch (baseOperationID) {
      default -> -1;
      };
    }
    if (baseClass == TemplateElement.class) {
      return switch (baseOperationID) {
      case GSNPackage.TEMPLATE_ELEMENT___VALIDATE -> GSNTemplatesPackage.DOMAIN_GOAL___VALIDATE;
      case GSNPackage.TEMPLATE_ELEMENT___REPAIR -> GSNTemplatesPackage.DOMAIN_GOAL___REPAIR;
      default -> -1;
      };
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case GSNTemplatesPackage.DOMAIN_GOAL___VALIDATE:
        try {
          validate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNTemplatesPackage.DOMAIN_GOAL___REPAIR:
        try {
          repair();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
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
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (valid: ");
    result.append(this.valid);
    result.append(')');
    return result.toString();
  }

} //DomainGoalImpl
