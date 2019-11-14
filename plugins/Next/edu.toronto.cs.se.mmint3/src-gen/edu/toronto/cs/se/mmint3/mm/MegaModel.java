/**
 */
package edu.toronto.cs.se.mmint3.mm;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.Nullable;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Mega Model</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MegaModel#getModels <em>Models</em>}</li>
 * <li>{@link edu.toronto.cs.se.mmint3.mm.MegaModel#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMegaModel()
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class MegaModel extends MinimalEObjectImpl.Container implements EObject {
  /**
   * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #getModels()
   * @generated
   * @ordered
   */
  protected EList<Model> models;

  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' map. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EMap<String, Element> elements;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  protected MegaModel() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return MMPackage.Literals.MEGA_MODEL;
  }

  /**
   * Returns the value of the '<em><b>Models</b></em>' containment reference list. The list contents are of type
   * {@link edu.toronto.cs.se.mmint3.mm.Model}. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Models</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMegaModel_Models()
   * @model containment="true"
   * @generated
   */
  public EList<Model> getModels() {
    if (this.models == null) {
      this.models = new EObjectContainmentEList<>(Model.class, this, MMPackage.MEGA_MODEL__MODELS);
    }
    return this.models;
  }

  /**
   * Returns the value of the '<em><b>Elements</b></em>' map. The key is of type {@link java.lang.String}, and the value
   * is of type {@link edu.toronto.cs.se.mmint3.mm.Element}, <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the value of the '<em>Elements</em>' map.
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMegaModel_Elements()
   * @model mapType="edu.toronto.cs.se.mmint3.mm.EStringToElementMap&lt;org.eclipse.emf.ecore.EString,
   *        edu.toronto.cs.se.mmint3.mm.Element&gt;"
   * @generated
   */
  public EMap<String, Element> getElements() {
    if (this.elements == null) {
      this.elements = new EcoreEMap<>(MMPackage.Literals.ESTRING_TO_ELEMENT_MAP, EStringToElementMap.class,
                                                this, MMPackage.MEGA_MODEL__ELEMENTS);
    }
    return this.elements;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model idRequired="true"
   * @generated NOT
   */
  public <T extends Element> @Nullable T getElement(String id) {
    var elem = getElements().get(id);
    if (elem == null) {
      return null;
    }
    try {
      return (T) elem;
    }
    catch (ClassCastException e) {
      return null;
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
    case MMPackage.MEGA_MODEL__MODELS:
      return ((InternalEList<?>) getModels()).basicRemove(otherEnd, msgs);
    case MMPackage.MEGA_MODEL__ELEMENTS:
      return ((InternalEList<?>) getElements()).basicRemove(otherEnd, msgs);
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
    case MMPackage.MEGA_MODEL__MODELS:
      return getModels();
    case MMPackage.MEGA_MODEL__ELEMENTS:
      if (coreType)
        return getElements();
      else
        return getElements().map();
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
    case MMPackage.MEGA_MODEL__MODELS:
      getModels().clear();
      getModels().addAll((Collection<? extends Model>) newValue);
      return;
    case MMPackage.MEGA_MODEL__ELEMENTS:
      ((EStructuralFeature.Setting) getElements()).set(newValue);
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
    case MMPackage.MEGA_MODEL__MODELS:
      getModels().clear();
      return;
    case MMPackage.MEGA_MODEL__ELEMENTS:
      getElements().clear();
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
    case MMPackage.MEGA_MODEL__MODELS:
      return this.models != null && !this.models.isEmpty();
    case MMPackage.MEGA_MODEL__ELEMENTS:
      return this.elements != null && !this.elements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
    case MMPackage.MEGA_MODEL___GET_ELEMENT__STRING:
      return getElement((String) arguments.get(0));
    }
    return super.eInvoke(operationID, arguments);
  }

} // MegaModel
