/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getI <em>I</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelInstance()
 * @model
 * @generated
 */
public interface ModelInstance extends Model, Instance {
  /**
   * Returns the value of the '<em><b>I</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>I</em>' containment reference.
   * @see #setI(MMInstance)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelInstance_I()
   * @model containment="true" required="true"
   * @generated
   */
  MMInstance getI();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getI <em>I</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>I</em>' containment reference.
   * @see #getI()
   * @generated
   */
  void setI(MMInstance value);

  /**
   * Returns the value of the '<em><b>Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' reference.
   * @see #setRoot(EObject)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelInstance_Root()
   * @model
   * @generated
   */
  EObject getRoot();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getRoot <em>Root</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Root</em>' reference.
   * @see #getRoot()
   * @generated
   */
  void setRoot(EObject value);

} // ModelInstance
