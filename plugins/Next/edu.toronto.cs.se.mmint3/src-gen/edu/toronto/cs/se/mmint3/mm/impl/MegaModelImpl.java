/**
 */
package edu.toronto.cs.se.mmint3.mm.impl;

import edu.toronto.cs.se.mmint3.mm.MMPackage;
import edu.toronto.cs.se.mmint3.mm.MegaModel;
import edu.toronto.cs.se.mmint3.mm.Model;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mega Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.impl.MegaModelImpl#getModels <em>Models</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MegaModelImpl extends MinimalEObjectImpl.Container implements MegaModel {
  /**
   * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModels()
   * @generated
   * @ordered
   */
  protected EList<Model> models;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MegaModelImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MEGA_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Model> getModels() {
    if (models == null) {
      models = new EObjectContainmentEList<Model>(Model.class, this, MMPackage.MEGA_MODEL__MODELS);
    }
    return models;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.MEGA_MODEL__MODELS:
      return ((InternalEList<?>) getModels()).basicRemove(otherEnd, msgs);
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
    case MMPackage.MEGA_MODEL__MODELS:
      return getModels();
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
    case MMPackage.MEGA_MODEL__MODELS:
      getModels().clear();
      getModels().addAll((Collection<? extends Model>) newValue);
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
    case MMPackage.MEGA_MODEL__MODELS:
      getModels().clear();
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
    case MMPackage.MEGA_MODEL__MODELS:
      return models != null && !models.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MegaModelImpl
