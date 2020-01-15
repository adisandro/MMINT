/**
 */
package edu.toronto.cs.se.mmint3.mm;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.Model#getEditors <em>Editors</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModel()
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class Model extends MinimalEObjectImpl.Container implements EObject {
  /**
   * The cached value of the '{@link #getEditors() <em>Editors</em>}' containment reference list. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see #getEditors()
   * @generated
   * @ordered
   */
  protected EList<Editor> editors;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected Model() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MODEL;
  }

  /**
   * Returns the value of the '<em><b>Editors</b></em>' containment reference list. The list contents are of type
   * {@link edu.toronto.cs.se.mmint3.mm.Editor}. It is bidirectional and its opposite is
   * '{@link edu.toronto.cs.se.mmint3.mm.Editor#getModel <em>Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Editors</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModel_Editors()
   * @see edu.toronto.cs.se.mmint3.mm.Editor#getModel
   * @model opposite="model" containment="true"
   * @generated
   */
  public EList<Editor> getEditors() {
    if (this.editors == null) {
      this.editors = new EObjectContainmentWithInverseEList<>(Editor.class, this, MMPackage.MODEL__EDITORS,
                                                               MMPackage.EDITOR__MODEL);
    }
    return this.editors;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.MODEL__EDITORS:
      return ((InternalEList<InternalEObject>) (InternalEList<?>) getEditors()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.MODEL__EDITORS:
      return ((InternalEList<?>) getEditors()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MMPackage.MODEL__EDITORS:
      return getEditors();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MMPackage.MODEL__EDITORS:
      getEditors().clear();
      getEditors().addAll((Collection<? extends Editor>) newValue);
      return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
    case MMPackage.MODEL__EDITORS:
      getEditors().clear();
      return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MMPackage.MODEL__EDITORS:
      return this.editors != null && !this.editors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} // Model
