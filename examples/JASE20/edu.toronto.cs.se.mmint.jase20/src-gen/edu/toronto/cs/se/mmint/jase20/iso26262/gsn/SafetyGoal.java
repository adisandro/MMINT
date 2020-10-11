/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Rick Salay, Sahar Kokaly.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.jase20.iso26262.gsn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal#getASIL <em>ASIL</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.GSNPackage#getSafetyGoal()
 * @model
 * @generated
 */
public interface SafetyGoal extends EObject {
  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.GSNPackage#getSafetyGoal_Description()
   * @model required="true"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>ASIL</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>ASIL</em>' attribute.
   * @see #setASIL(String)
   * @see edu.toronto.cs.se.mmint.jase20.iso26262.gsn.GSNPackage#getSafetyGoal_ASIL()
   * @model required="true"
   * @generated
   */
  String getASIL();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.jase20.iso26262.gsn.SafetyGoal#getASIL <em>ASIL</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>ASIL</em>' attribute.
   * @see #getASIL()
   * @generated
   */
  void setASIL(String value);

} // SafetyGoal
