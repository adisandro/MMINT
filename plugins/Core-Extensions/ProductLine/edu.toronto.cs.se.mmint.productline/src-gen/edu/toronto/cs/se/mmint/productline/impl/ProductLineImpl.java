/**
 */
package edu.toronto.cs.se.mmint.productline.impl;

import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.productline.ProductLinePackage;
import edu.toronto.cs.se.mmint.productline.Reference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
  protected String features = FEATURES_EDEFAULT;

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
    return features;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFeatures(String newFeatures) {
    String oldFeatures = features;
    features = newFeatures;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ProductLinePackage.PRODUCT_LINE__FEATURES, oldFeatures,
                                    features));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<edu.toronto.cs.se.mmint.productline.Class> getClasses() {
    if (classes == null) {
      classes = new EObjectContainmentEList<edu.toronto.cs.se.mmint.productline.Class>(edu.toronto.cs.se.mmint.productline.Class.class,
                                                                                       this,
                                                                                       ProductLinePackage.PRODUCT_LINE__CLASSES);
    }
    return classes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Reference> getReferences() {
    if (references == null) {
      references = new EObjectContainmentEList<Reference>(Reference.class, this,
                                                          ProductLinePackage.PRODUCT_LINE__REFERENCES);
    }
    return references;
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
      setFeatures(FEATURES_EDEFAULT);
      return;
    case ProductLinePackage.PRODUCT_LINE__CLASSES:
      getClasses().clear();
      return;
    case ProductLinePackage.PRODUCT_LINE__REFERENCES:
      getReferences().clear();
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
      return FEATURES_EDEFAULT == null ? features != null : !FEATURES_EDEFAULT.equals(features);
    case ProductLinePackage.PRODUCT_LINE__CLASSES:
      return classes != null && !classes.isEmpty();
    case ProductLinePackage.PRODUCT_LINE__REFERENCES:
      return references != null && !references.isEmpty();
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (features: ");
    result.append(features);
    result.append(')');
    return result.toString();
  }

} //ProductLineImpl
