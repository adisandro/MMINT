/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.ModelType#getT <em>T</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelType()
 * @model
 * @generated
 */
public interface ModelType extends Model, Type {
  /**
   * Returns the value of the '<em><b>T</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>T</em>' containment reference.
   * @see #setT(MMType)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelType_T()
   * @model containment="true" required="true"
   * @generated
   */
  MMType getT();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.ModelType#getT <em>T</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>T</em>' containment reference.
   * @see #getT()
   * @generated
   */
  void setT(MMType value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" required="true"
   * @generated
   */
  EPackage getPackage();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true"
   * @generated
   */
  ModelInstance createInstance(EObject root, String path, boolean serialize, InstanceMegaModel mm);

} // ModelType
