/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.PLPackage;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Product Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl#getFeaturesConstraint <em>Features Constraint</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl#getReasonerName <em>Reasoner Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProductLineImpl extends MinimalEObjectImpl.Container implements ProductLine {
  /**
   * The default value of the '{@link #getFeaturesConstraint() <em>Features Constraint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeaturesConstraint()
   * @generated
   * @ordered
   */
  protected static final String FEATURES_CONSTRAINT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFeaturesConstraint() <em>Features Constraint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeaturesConstraint()
   * @generated
   * @ordered
   */
  protected String featuresConstraint = ProductLineImpl.FEATURES_CONSTRAINT_EDEFAULT;

  /**
   * The default value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected static final String REASONER_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected String reasonerName = ProductLineImpl.REASONER_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getClasses()
   * @generated
   * @ordered
   */
  protected EList<edu.toronto.cs.se.mmint.productline.Class> classes;

  /**
   * The cached value of the '{@link #getMetamodel() <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMetamodel()
   * @generated
   * @ordered
   */
  protected EPackage metamodel;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ProductLineImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return PLPackage.Literals.PRODUCT_LINE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getFeaturesConstraint() {
    return this.featuresConstraint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFeaturesConstraint(String newFeaturesConstraint) {
    var oldFeaturesConstraint = this.featuresConstraint;
    this.featuresConstraint = newFeaturesConstraint;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, PLPackage.PRODUCT_LINE__FEATURES_CONSTRAINT,
                                    oldFeaturesConstraint, this.featuresConstraint));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getReasonerName() {
    return this.reasonerName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReasonerName(String newReasonerName) {
    var oldReasonerName = this.reasonerName;
    this.reasonerName = newReasonerName;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, PLPackage.PRODUCT_LINE__REASONER_NAME, oldReasonerName,
                                    this.reasonerName));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<edu.toronto.cs.se.mmint.productline.Class> getClasses() {
    if (this.classes == null) {
      this.classes = new EObjectContainmentEList<>(edu.toronto.cs.se.mmint.productline.Class.class,
                                                                                       this,
                                                                                       PLPackage.PRODUCT_LINE__CLASSES);
    }
    return this.classes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EPackage getMetamodel() {
    if (this.metamodel != null && this.metamodel.eIsProxy()) {
      var oldMetamodel = (InternalEObject) this.metamodel;
      this.metamodel = (EPackage) eResolveProxy(oldMetamodel);
      if (this.metamodel != oldMetamodel) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, PLPackage.PRODUCT_LINE__METAMODEL, oldMetamodel,
                                        this.metamodel));
        }
      }
    }
    return this.metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage basicGetMetamodel() {
    return this.metamodel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setMetamodel(EPackage newMetamodel) {
    var oldMetamodel = this.metamodel;
    this.metamodel = newMetamodel;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, PLPackage.PRODUCT_LINE__METAMODEL, oldMetamodel,
                                    this.metamodel));
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public IPLFeaturesTrait getReasoner() throws MMINTException {
    var reasonerName = getReasonerName();
    if (!(MMINT.getReasoner(reasonerName) instanceof IPLFeaturesTrait featureReasoner)) {
      throw new MMINTException(reasonerName + " is not able to check product line feature constraints");
    }
    return featureReasoner;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case PLPackage.PRODUCT_LINE__CLASSES:
      return ((InternalEList<?>) getClasses()).basicRemove(otherEnd, msgs);
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
    case PLPackage.PRODUCT_LINE__FEATURES_CONSTRAINT:
      return getFeaturesConstraint();
    case PLPackage.PRODUCT_LINE__REASONER_NAME:
      return getReasonerName();
    case PLPackage.PRODUCT_LINE__CLASSES:
      return getClasses();
    case PLPackage.PRODUCT_LINE__METAMODEL:
      if (resolve) {
        return getMetamodel();
      }
      return basicGetMetamodel();
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
    case PLPackage.PRODUCT_LINE__FEATURES_CONSTRAINT:
      setFeaturesConstraint((String) newValue);
      return;
    case PLPackage.PRODUCT_LINE__REASONER_NAME:
      setReasonerName((String) newValue);
      return;
    case PLPackage.PRODUCT_LINE__CLASSES:
      getClasses().clear();
      getClasses().addAll((Collection<? extends edu.toronto.cs.se.mmint.productline.Class>) newValue);
      return;
    case PLPackage.PRODUCT_LINE__METAMODEL:
      setMetamodel((EPackage) newValue);
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
    case PLPackage.PRODUCT_LINE__FEATURES_CONSTRAINT:
      setFeaturesConstraint(ProductLineImpl.FEATURES_CONSTRAINT_EDEFAULT);
      return;
    case PLPackage.PRODUCT_LINE__REASONER_NAME:
      setReasonerName(ProductLineImpl.REASONER_NAME_EDEFAULT);
      return;
    case PLPackage.PRODUCT_LINE__CLASSES:
      getClasses().clear();
      return;
    case PLPackage.PRODUCT_LINE__METAMODEL:
      setMetamodel((EPackage) null);
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
    case PLPackage.PRODUCT_LINE__FEATURES_CONSTRAINT:
      return ProductLineImpl.FEATURES_CONSTRAINT_EDEFAULT == null ? this.featuresConstraint != null
        : !ProductLineImpl.FEATURES_CONSTRAINT_EDEFAULT.equals(this.featuresConstraint);
    case PLPackage.PRODUCT_LINE__REASONER_NAME:
      return ProductLineImpl.REASONER_NAME_EDEFAULT == null ? this.reasonerName != null : !ProductLineImpl.REASONER_NAME_EDEFAULT.equals(this.reasonerName);
    case PLPackage.PRODUCT_LINE__CLASSES:
      return this.classes != null && !this.classes.isEmpty();
    case PLPackage.PRODUCT_LINE__METAMODEL:
      return this.metamodel != null;
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
    case PLPackage.PRODUCT_LINE___GET_REASONER:
      try {
        return getReasoner();
      }
      catch (Throwable throwable) {
        throw new InvocationTargetException(throwable);
      }
    case PLPackage.PRODUCT_LINE___GET_ROOT:
      return getRoot();
    case PLPackage.PRODUCT_LINE___GET_PRESENCE_CONDITION_OR_DEFAULT__STRING:
      return getPresenceConditionOrDefault((String) arguments.get(0));
    case PLPackage.PRODUCT_LINE___IS_IN_ALL_PRODUCTS__STRING:
      return isInAllProducts((String) arguments.get(0));
    case PLPackage.PRODUCT_LINE___GET_PRESENCE_CONDITION_LABEL__STRING_BOOLEAN:
      return getPresenceConditionLabel((String) arguments.get(0), (Boolean) arguments.get(1));
    case PLPackage.PRODUCT_LINE___MERGE_PRESENCE_CONDITIONS__STRING_STRING:
      return mergePresenceConditions((String) arguments.get(0), (String) arguments.get(1));
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
    result.append(" (featuresConstraint: ");
    result.append(this.featuresConstraint);
    result.append(", reasonerName: ");
    result.append(this.reasonerName);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public edu.toronto.cs.se.mmint.productline.Class getRoot() {
    var rootType = getMetamodel().getEClassifiers().get(0);
    return getClasses().stream().filter(c -> c.getType() == rootType).findFirst().get();
  }

  /**
   * @generated NOT
   */
  @Override
  public @Nullable String getPresenceConditionOrDefault(@Nullable String presenceCondition) {
    if (presenceCondition == null) {
      try {
        presenceCondition = getReasoner().getTrueLiteral();
      }
      catch (MMINTException e) {
        // fallback to null presence condition
      }
    }
    return presenceCondition;
  }

  /**
   * @generated NOT
   */
  @Override
  public boolean isInAllProducts(@Nullable String presenceCondition) {
    try {
      if (presenceCondition == null || presenceCondition.strip().equals(getReasoner().getTrueLiteral())) {
        return true;
      }
      return false;
    }
    catch (MMINTException e) {
      return false;
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public String getPresenceConditionLabel(@Nullable String presenceCondition, boolean withParenthesis) {
    if (isInAllProducts(presenceCondition)) {
      return "";
    }
    var pc = getPresenceConditionOrDefault(presenceCondition);
    if (withParenthesis) {
      pc = "(" + pc + ")";
    }
    return pc;
  }

  /**
   * @generated NOT
   */
  @Override
  public @Nullable String mergePresenceConditions(@Nullable String presenceCondition1,
                                                  @Nullable String presenceCondition2) {
    String pc = null;
    try {
      if (isInAllProducts(presenceCondition1)) {
        pc = presenceCondition2;
      }
      else if (isInAllProducts(presenceCondition2)) {
        pc = presenceCondition1;
      }
      else if (presenceCondition1.equals(presenceCondition2)) {
        pc = presenceCondition1;
      }
      else {
        var reasoner = getReasoner();
        pc = reasoner.simplify(reasoner.and(presenceCondition1, presenceCondition2));
      }
      if (pc == null) {
        pc = getReasoner().getTrueLiteral();
      }
    }
    catch (MMINTException e) {
      // fallback to null presence condition
    }
    return pc;
  }

} //ProductLineImpl
