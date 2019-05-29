/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage
 * @generated
 */
public interface MMFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MMFactory eINSTANCE = edu.toronto.cs.se.mmint3.mm.impl.MMFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Type Mega Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Mega Model</em>'.
   * @generated
   */
  TypeMegaModel createTypeMegaModel();

  /**
   * Returns a new object of class '<em>Instance Mega Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance Mega Model</em>'.
   * @generated
   */
  InstanceMegaModel createInstanceMegaModel();

  /**
   * Returns a new object of class '<em>Model Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Type</em>'.
   * @generated
   */
  ModelType createModelType();

  /**
   * Returns a new object of class '<em>Model Instance</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Instance</em>'.
   * @generated
   */
  ModelInstance createModelInstance();

  /**
   * Returns a new object of class '<em>Instance</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Instance</em>'.
   * @generated
   */
  MMInstance createMMInstance();

  /**
   * Returns a new object of class '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type</em>'.
   * @generated
   */
  MMType createMMType();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MMPackage getMMPackage();

} //MMFactory
