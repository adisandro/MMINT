/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.Reference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Product Line</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl#getReferences <em>References</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.impl.ProductLineImpl#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProductLineImpl extends MinimalEObjectImpl.Container implements ProductLine {
  /**
   * The default value of the '{@link #getFeatures() <em>Features</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected static final String FEATURES_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFeatures() <em>Features</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatures()
   * @generated
   * @ordered
   */
  protected String features = ProductLineImpl.FEATURES_EDEFAULT;

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
   * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReferences()
   * @generated
   * @ordered
   */
  protected EList<Reference> references;

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
    return ProductLinePackage.Literals.PRODUCT_LINE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getFeatures() {
    return this.features;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFeatures(String newFeatures) {
    var oldFeatures = this.features;
    this.features = newFeatures;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.PRODUCT_LINE__FEATURES, oldFeatures,
                                    this.features));
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
                                                                                       ProductLinePackage.PRODUCT_LINE__CLASSES);
    }
    return this.classes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Reference> getReferences() {
    if (this.references == null) {
      this.references = new EObjectContainmentEList<>(Reference.class, this,
                                                          ProductLinePackage.PRODUCT_LINE__REFERENCES);
    }
    return this.references;
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
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ProductLinePackage.PRODUCT_LINE__METAMODEL,
                                        oldMetamodel, this.metamodel));
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
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.PRODUCT_LINE__METAMODEL, oldMetamodel,
                                    this.metamodel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case ProductLinePackage.PRODUCT_LINE__CLASSES:
      return ((InternalEList<?>) getClasses()).basicRemove(otherEnd, msgs);
    case ProductLinePackage.PRODUCT_LINE__REFERENCES:
      return ((InternalEList<?>) getReferences()).basicRemove(otherEnd, msgs);
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
    case ProductLinePackage.PRODUCT_LINE__FEATURES:
      return getFeatures();
    case ProductLinePackage.PRODUCT_LINE__CLASSES:
      return getClasses();
    case ProductLinePackage.PRODUCT_LINE__REFERENCES:
      return getReferences();
    case ProductLinePackage.PRODUCT_LINE__METAMODEL:
      if (resolve)
        return getMetamodel();
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
    case ProductLinePackage.PRODUCT_LINE__FEATURES:
      setFeatures((String) newValue);
      return;
    case ProductLinePackage.PRODUCT_LINE__CLASSES:
      getClasses().clear();
      getClasses().addAll((Collection<? extends edu.toronto.cs.se.mmint.productline.Class>) newValue);
      return;
    case ProductLinePackage.PRODUCT_LINE__REFERENCES:
      getReferences().clear();
      getReferences().addAll((Collection<? extends Reference>) newValue);
      return;
    case ProductLinePackage.PRODUCT_LINE__METAMODEL:
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
    case ProductLinePackage.PRODUCT_LINE__FEATURES:
      setFeatures(ProductLineImpl.FEATURES_EDEFAULT);
      return;
    case ProductLinePackage.PRODUCT_LINE__CLASSES:
      getClasses().clear();
      return;
    case ProductLinePackage.PRODUCT_LINE__REFERENCES:
      getReferences().clear();
      return;
    case ProductLinePackage.PRODUCT_LINE__METAMODEL:
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
    case ProductLinePackage.PRODUCT_LINE__FEATURES:
      return ProductLineImpl.FEATURES_EDEFAULT == null ? this.features != null : !ProductLineImpl.FEATURES_EDEFAULT.equals(this.features);
    case ProductLinePackage.PRODUCT_LINE__CLASSES:
      return this.classes != null && !this.classes.isEmpty();
    case ProductLinePackage.PRODUCT_LINE__REFERENCES:
      return this.references != null && !this.references.isEmpty();
    case ProductLinePackage.PRODUCT_LINE__METAMODEL:
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
  public String toString() {
    if (eIsProxy())
      return super.toString();

    var result = new StringBuilder(super.toString());
    result.append(" (features: ");
    result.append(this.features);
    result.append(')');
    return result.toString();
  }

} //ProductLineImpl
