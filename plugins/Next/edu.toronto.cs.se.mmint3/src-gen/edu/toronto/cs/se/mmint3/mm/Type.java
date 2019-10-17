/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Type</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getType()
 * @model kind="class" interface="true" abstract="true"
 * @generated
 */
public interface Type extends Element {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation" required="true"
   * @generated NOT
   */
  default boolean isDynamic() {
    return getAttribute(MMPackage.MM_TYPE__DYNAMIC);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model
   * @generated NOT
   */
  default void setDynamic(boolean value) {
    setAttribute(MMPackage.MM_TYPE__DYNAMIC, value);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation" required="true"
   * @generated NOT
   */
  default boolean isAbstract() {
    return getAttribute(MMPackage.MM_TYPE__ABSTRACT);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model
   * @generated NOT
   */
  default void setAbstract(boolean value) {
    setAttribute(MMPackage.MM_TYPE__ABSTRACT, value);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation"
   * @generated NOT
   */
  default MMType getSupertype() {
    return getAttribute(MMPackage.MM_TYPE__SUPERTYPE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model
   * @generated NOT
   */
  default void setSupertype(MMType value) {
    setAttribute(MMPackage.MM_TYPE__SUPERTYPE, value);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation"
   * @generated NOT
   */
  default EList<MMType> getSubtypes() {
    return getAttribute(MMPackage.MM_TYPE__SUBTYPES);
  }

} // Type
