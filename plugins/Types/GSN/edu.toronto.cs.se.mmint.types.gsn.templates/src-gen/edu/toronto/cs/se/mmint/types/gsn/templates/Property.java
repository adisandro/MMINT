/*******************************************************************************
 * Copyright (c) 2023, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.Property#getFormal <em>Formal</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.Property#getInformal <em>Informal</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends EObject {
  /**
   * Returns the value of the '<em><b>Formal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formal</em>' attribute.
   * @see #setFormal(String)
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getProperty_Formal()
   * @model required="true"
   * @generated
   */
  String getFormal();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.Property#getFormal <em>Formal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Formal</em>' attribute.
   * @see #getFormal()
   * @generated
   */
  void setFormal(String value);

  /**
   * Returns the value of the '<em><b>Informal</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Informal</em>' attribute.
   * @see #setInformal(String)
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getProperty_Informal()
   * @model required="true"
   * @generated
   */
  String getInformal();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.Property#getInformal <em>Informal</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Informal</em>' attribute.
   * @see #getInformal()
   * @generated
   */
  void setInformal(String value);

} // Property
