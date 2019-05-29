/**
 */
package edu.toronto.cs.se.mmint3.mm;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.MMInstance#getTypeId <em>Type Id</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMInstance()
 * @model
 * @generated
 */
public interface MMInstance extends MMElement, Instance {
  /**
   * Returns the value of the '<em><b>Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Id</em>' attribute.
   * @see #setTypeId(String)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMInstance_TypeId()
   * @model required="true"
   * @generated
   */
  String getTypeId();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMInstance#getTypeId <em>Type Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Id</em>' attribute.
   * @see #getTypeId()
   * @generated
   */
  void setTypeId(String value);

} // MMInstance
