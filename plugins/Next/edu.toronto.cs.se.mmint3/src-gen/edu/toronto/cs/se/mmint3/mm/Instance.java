/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint3.MMINT;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Instance</b></em>'. <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getInstance()
 * @model kind="class" interface="true" abstract="true"
 * @generated
 */
public interface Instance extends Element {

  /**
   * @generated NOT
   */
  @Override
  default @Nullable EStructuralFeature getComposedFeature() {
    var feature = eClass().getEStructuralFeature("i");
    if (feature == null) {
      return null;
    }
    return feature;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation" required="true"
   * @generated NOT
   */
  default String getTypeId() {
    return getAttribute(MMPackage.MM_INSTANCE__TYPE_ID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model
   * @generated NOT
   */
  default void setTypeId(String value) {
    setAttribute(MMPackage.MM_INSTANCE__TYPE_ID, value);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation" required="true"
   * @generated NOT
   */
  default Type getType() {
    var type = basicGetType();
    return type != null && type.eIsProxy() ? (Type) EcoreUtil.resolve(type, this) : type;
  }

  /**
   * @generated NOT
   */
  default Type basicGetType() {
    return MMINT.I.getType(getTypeId());
  }

} // Instance
