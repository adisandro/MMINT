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
    case PLPackage.PRODUCT_LINE___GET_ROOT__ECLASS:
      return getRoot((EClass) arguments.get(0));
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
  public edu.toronto.cs.se.mmint.productline.Class getRoot(EClass rootType) {
    return getClasses().stream().filter(c -> c.getType() == rootType).findFirst().get();
  }

} //ProductLineImpl
