/*******************************************************************************
 * Copyright (c) 2020, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.lts.impl;

import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmint.types.lts.InitialState;
import edu.toronto.cs.se.mmint.types.lts.LTSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Initial State</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class InitialStateImpl extends StateImpl implements InitialState {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InitialStateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return LTSPackage.Literals.INITIAL_STATE;
  }

} //InitialStateImpl
