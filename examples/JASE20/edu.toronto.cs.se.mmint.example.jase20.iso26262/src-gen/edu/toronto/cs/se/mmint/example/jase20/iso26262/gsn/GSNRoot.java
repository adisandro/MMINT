/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik, Rick Salay, Sahar Kokaly.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.GSNRoot#getGoals <em>Goals</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.GSNPackage#getGSNRoot()
 * @model
 * @generated
 */
public interface GSNRoot extends EObject {
  /**
   * Returns the value of the '<em><b>Goals</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.SafetyGoal}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Goals</em>' containment reference list.
   * @see edu.toronto.cs.se.mmint.example.jase20.iso26262.gsn.GSNPackage#getGSNRoot_Goals()
   * @model containment="true"
   * @generated
   */
  EList<SafetyGoal> getGoals();

} // GSNRoot
