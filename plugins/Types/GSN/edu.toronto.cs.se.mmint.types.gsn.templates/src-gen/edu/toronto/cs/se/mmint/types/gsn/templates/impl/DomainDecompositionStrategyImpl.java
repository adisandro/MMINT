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

import java.util.Objects;
import java.util.stream.Collectors;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.types.gsn.templates.Domain;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.DomainGoal;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Decomposition Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.DomainDecompositionStrategyImpl#getDomain <em>Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainDecompositionStrategyImpl extends StrategyImpl implements DomainDecompositionStrategy {
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DomainDecompositionStrategyImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.DOMAIN_DECOMPOSITION_STRATEGY;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN, oldDomain, newDomain);
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
        msgs = ((InternalEObject)this.domain).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN, null, msgs);
      if (newDomain != null)
        msgs = ((InternalEObject)newDomain).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN, null, msgs);
      msgs = basicSetDomain(newDomain, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN, newDomain, newDomain));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN:
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
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN:
        return getDomain();
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
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN:
        setDomain((Domain)newValue);
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
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN:
        setDomain((Domain)null);
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
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN:
        return this.domain != null;
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
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN -> GSNTemplatesPackage.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN;
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
      case GSNTemplatesPackage.DOMAIN_DECOMPOSITION_ELEMENT__DOMAIN -> GSNTemplatesPackage.DOMAIN_DECOMPOSITION_STRATEGY__DOMAIN;
      default -> -1;
      };
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    getTemplates().get(0).instantiate();
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    try {
      var domain = Objects.requireNonNull(getDomain(), "Domain not specified");
      var subGoals = getSupportedBy().stream()
        .map(SupportedBy::getTarget)
        .filter(DomainGoal.class::isInstance)
        .map(DomainGoal.class::cast)
        .collect(Collectors.toList());
      if (subGoals.size() == 0) {
        throw new MMINTException("A domain must be decomposed into sub-domains");
      }
      var subDomains = subGoals.stream().map(DomainGoal::getDomain).collect(Collectors.toList());
      domain.validateDecomposition(ECollections.toEList(subDomains));
      setValid(true);
      subGoals.forEach(g -> g.setValid(true));
    }
    catch (Exception e) {
      setValid(false);
      throw e;
    }
  }

} //DomainDecompositionStrategyImpl
