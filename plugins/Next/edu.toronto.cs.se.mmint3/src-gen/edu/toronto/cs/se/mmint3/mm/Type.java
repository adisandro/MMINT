/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.Nullable;

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
   * @generated NOT
   */
  @Override
  default @Nullable EStructuralFeature getComposedFeature() {
    var feature = eClass().getEStructuralFeature("t");
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
  default boolean isDynamic() {
    return getComposedAttribute(MMPackage.MM_TYPE__DYNAMIC);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model
   * @generated NOT
   */
  default void setDynamic(boolean value) {
    setComposedAttribute(MMPackage.MM_TYPE__DYNAMIC, value);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation" required="true"
   * @generated NOT
   */
  default boolean isAbstract() {
    return getComposedAttribute(MMPackage.MM_TYPE__ABSTRACT);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model
   * @generated NOT
   */
  default void setAbstract(boolean value) {
    setComposedAttribute(MMPackage.MM_TYPE__ABSTRACT, value);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model kind="operation"
   * @generated NOT
   */
  default Type getSupertype() {
    return getComposedAttribute(MMPackage.MM_TYPE__SUPERTYPE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model
   * @generated NOT
   */
  default void setSupertype(Type value) {
    setComposedAttribute(MMPackage.MM_TYPE__SUPERTYPE, value);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @model required="true"
   * @generated NOT
   */
  default Instance createInstance(EClass instanceClass, String id, String name) {
    var obj = MMFactory.eINSTANCE.create(instanceClass);
    if (!(obj instanceof Instance)) {
      // TODO throw exception
    }
    var instance = (Instance) obj;
    var composed = MMFactory.eINSTANCE.createMMInstance();
    composed.setId(id);
    composed.setName(name);
    composed.setTypeId(getId());
    instance.eSet(instance.getComposedFeature(), composed);

    return instance;
  }

} // Type
