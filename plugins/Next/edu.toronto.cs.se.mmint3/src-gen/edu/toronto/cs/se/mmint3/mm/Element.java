/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.BasicEObjectImpl;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Element</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getElement()
 * @model kind="class" interface="true" abstract="true"
 * @generated
 */
public interface Element extends EObject {

  /**
   *
   * @param <T>
   * @return
   * @generated NOT
   */
  default <T> T getAttribute(int featureID) {
    var feature = eClass().getEStructuralFeature("i");
    if (feature == null) {
      feature = eClass().getEStructuralFeature("t");
    }
    if (feature == null) {
      return null;
    }
    return (T) ((BasicEObjectImpl) eGet(feature)).eGet(featureID, true, true);
    // TODO use reflection to do getI/T().eGet(featureID)
  }

  /**
   *
   * @param <T>
   * @param value
   * @generated NOT
   */
  default <T> void setAttribute(int featureID, T value) {
    var feature = eClass().getEStructuralFeature("i");
    if (feature == null) {
      feature = eClass().getEStructuralFeature("t");
    }
    if (feature == null) {
      return;
    }
    ((BasicEObjectImpl) eGet(feature)).eSet(featureID, value);
    // TODO use reflection to do getI/T().sSet(featureID, value)
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation" required="true"
   * @generated NOT
   */
  default String getId() {
    return getAttribute(MMPackage.MM_ELEMENT__ID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model
   * @generated NOT
   */
  default void setId(String value) {
    setAttribute(MMPackage.MM_ELEMENT__ID, value);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation" required="true"
   * @generated NOT
   */
  default String getName() {
    return getAttribute(MMPackage.MM_ELEMENT__NAME);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model
   * @generated NOT
   */
  default void setName(String value) {
    setAttribute(MMPackage.MM_ELEMENT__NAME, value);
  }

} // Element
