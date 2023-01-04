/*******************************************************************************
 * Copyright (c) 2021, 2023 Alessio Di Sandro.
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

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Reference#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Reference#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Reference#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#getReference()
 * @model
 * @generated
 */
public interface Reference extends PLElement {
  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.productline.Class#getReferencesAsSource <em>References As Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(edu.toronto.cs.se.mmint.productline.Class)
   * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#getReference_Source()
   * @see edu.toronto.cs.se.mmint.productline.Class#getReferencesAsSource
   * @model opposite="referencesAsSource" required="true"
   * @generated
   */
  edu.toronto.cs.se.mmint.productline.Class getSource();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.productline.Reference#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(edu.toronto.cs.se.mmint.productline.Class value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.productline.Class#getReferencesAsTarget <em>References As Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' reference.
   * @see #setTarget(edu.toronto.cs.se.mmint.productline.Class)
   * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#getReference_Target()
   * @see edu.toronto.cs.se.mmint.productline.Class#getReferencesAsTarget
   * @model opposite="referencesAsTarget" required="true"
   * @generated
   */
  edu.toronto.cs.se.mmint.productline.Class getTarget();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.productline.Reference#getTarget <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(edu.toronto.cs.se.mmint.productline.Class value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EReference)
   * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#getReference_Type()
   * @model required="true"
   * @generated
   */
  EReference getType();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.productline.Reference#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EReference value);

} // Reference
