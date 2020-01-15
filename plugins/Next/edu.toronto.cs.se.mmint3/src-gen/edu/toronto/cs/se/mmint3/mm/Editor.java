/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Editor</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.Editor#getModel <em>Model</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEditor()
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class Editor extends MinimalEObjectImpl.Container implements EObject {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected Editor() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.EDITOR;
  }

  /**
   * Returns the value of the '<em><b>Model</b></em>' container reference. It is bidirectional and its opposite is
   * '{@link edu.toronto.cs.se.mmint3.mm.Model#getEditors <em>Editors</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @return the value of the '<em>Model</em>' container reference.
   * @see #setModel(Model)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEditor_Model()
   * @see edu.toronto.cs.se.mmint3.mm.Model#getEditors
   * @model opposite="editors" required="true" transient="false"
   * @generated
   */
  public Model getModel() {
    if (eContainerFeatureID() != MMPackage.EDITOR__MODEL)
      return null;
    return (Model) eInternalContainer();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public NotificationChain basicSetModel(Model newModel, NotificationChain msgs) {
    msgs = eBasicSetContainer(newModel, MMPackage.EDITOR__MODEL, msgs);
    return msgs;
  }

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.Editor#getModel <em>Model</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param newModel
   *          the new value of the '<em>Model</em>' container reference.
   * @see #getModel()
   * @generated
   */
  public void setModel(Model newModel) {
    if (newModel != eInternalContainer() || (eContainerFeatureID() != MMPackage.EDITOR__MODEL && newModel != null)) {
      if (EcoreUtil.isAncestor(this, newModel))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newModel != null)
        msgs = newModel.eInverseAdd(this, MMPackage.MODEL__EDITORS, Model.class, msgs);
      msgs = basicSetModel(newModel, msgs);
      if (msgs != null)
        msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MMPackage.EDITOR__MODEL, newModel, newModel));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.EDITOR__MODEL:
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      return basicSetModel((Model) otherEnd, msgs);
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
    case MMPackage.EDITOR__MODEL:
      return basicSetModel(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID()) {
    case MMPackage.EDITOR__MODEL:
      return eInternalContainer().eInverseRemove(this, MMPackage.MODEL__EDITORS, Model.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MMPackage.EDITOR__MODEL:
      return getModel();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MMPackage.EDITOR__MODEL:
      setModel((Model) newValue);
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
    case MMPackage.EDITOR__MODEL:
      setModel((Model) null);
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
    case MMPackage.EDITOR__MODEL:
      return getModel() != null;
    }
    return super.eIsSet(featureID);
  }

} // Editor
