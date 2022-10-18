/*******************************************************************************
 * Copyright (c) 2021, 2022 Alessio Di Sandro.
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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Class#getReferencesAsSource <em>References As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Class#getReferencesAsTarget <em>References As Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Class#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.productline.Class#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends PLElement {
  /**
   * Returns the value of the '<em><b>References As Source</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.productline.Reference}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.productline.Reference#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>References As Source</em>' reference list.
   * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#getClass_ReferencesAsSource()
   * @see edu.toronto.cs.se.mmint.productline.Reference#getSource
   * @model opposite="source"
   * @generated
   */
  EList<Reference> getReferencesAsSource();

  /**
   * Returns the value of the '<em><b>References As Target</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.productline.Reference}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint.productline.Reference#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>References As Target</em>' reference list.
   * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#getClass_ReferencesAsTarget()
   * @see edu.toronto.cs.se.mmint.productline.Reference#getTarget
   * @model opposite="target"
   * @generated
   */
  EList<Reference> getReferencesAsTarget();

  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.productline.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#getClass_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClass)
   * @see edu.toronto.cs.se.mmint.productline.ProductLinePackage#getClass_Type()
   * @model required="true"
   * @generated
   */
  EClass getType();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.productline.Class#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClass value);

} // Class
