/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.MMElement#getId <em>Id</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.MMElement#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMElement()
 * @model abstract="true"
 * @generated
 */
public interface MMElement extends EObject {
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMElement_Id()
   * @model id="true" required="true"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMElement#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMElement_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMElement#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // MMElement
