/*******************************************************************************
 * Copyright (c) 2021, 2025 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.productline;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.productline.reasoning.IPLFeaturesTrait;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Product Line</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.ProductLine#getFeaturesConstraint <em>Features Constraint</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.ProductLine#getReasonerName <em>Reasoner Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.ProductLine#getClasses <em>Classes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.ProductLine#getMetamodel <em>Metamodel</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.productline.PLPackage#getProductLine()
 * @model
 * @generated
 */
public interface ProductLine extends EObject {
  /**
   * Returns the value of the '<em><b>Features Constraint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Features Constraint</em>' attribute.
   * @see #setFeaturesConstraint(String)
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#getProductLine_FeaturesConstraint()
   * @model required="true"
   * @generated
   */
  String getFeaturesConstraint();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.productline.ProductLine#getFeaturesConstraint <em>Features Constraint</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Features Constraint</em>' attribute.
   * @see #getFeaturesConstraint()
   * @generated
   */
  void setFeaturesConstraint(String value);

  /**
   * Returns the value of the '<em><b>Reasoner Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reasoner Name</em>' attribute.
   * @see #setReasonerName(String)
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#getProductLine_ReasonerName()
   * @model required="true"
   * @generated
   */
  String getReasonerName();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.productline.ProductLine#getReasonerName <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reasoner Name</em>' attribute.
   * @see #getReasonerName()
   * @generated
   */
  void setReasonerName(String value);

  /**
   * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.productline.Class}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Classes</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#getProductLine_Classes()
   * @model containment="true"
   * @generated
   */
  EList<edu.toronto.cs.se.mmint.productline.Class> getClasses();

  /**
   * Returns the value of the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel</em>' reference.
   * @see #setMetamodel(EPackage)
   * @see edu.toronto.cs.se.mmint.productline.PLPackage#getProductLine_Metamodel()
   * @model required="true"
   * @generated
   */
  EPackage getMetamodel();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.productline.ProductLine#getMetamodel <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel</em>' reference.
   * @see #getMetamodel()
   * @generated
   */
  void setMetamodel(EPackage value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" dataType="edu.toronto.cs.se.mmint.productline.IPLFeaturesTrait" required="true" exceptions="edu.toronto.cs.se.mmint.productline.MMINTException"
   * @generated
   */
  IPLFeaturesTrait getReasoner() throws MMINTException;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true" rootTypeRequired="true"
   * @generated
   */
  edu.toronto.cs.se.mmint.productline.Class getRoot(EClass rootType);

} // ProductLine
