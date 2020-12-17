/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Nick Fung.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 *
 */
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Decomposition Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement#getReasonerName <em>Reasoner Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getPropertyDecompositionElement()
 * @model
 * @generated
 */
public interface PropertyDecompositionElement extends EObject {
  /**
   * Returns the value of the '<em><b>Reasoner Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reasoner Name</em>' attribute.
   * @see #setReasonerName(String)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getPropertyDecompositionElement_ReasonerName()
   * @model required="true"
   * @generated
   */
  String getReasonerName();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement#getReasonerName <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reasoner Name</em>' attribute.
   * @see #getReasonerName()
   * @generated
   */
  void setReasonerName(String value);

  /**
   * Returns the value of the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' attribute.
   * @see #setProperty(String)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getPropertyDecompositionElement_Property()
   * @model required="true"
   * @generated
   */
  String getProperty();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.PropertyDecompositionElement#getProperty <em>Property</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' attribute.
   * @see #getProperty()
   * @generated
   */
  void setProperty(String value);

} // PropertyDecompositionElement
