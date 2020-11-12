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
package edu.toronto.cs.se.modelepedia.safetycase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decomposable Core Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement#getInContextOf <em>In Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.GSNPackage#getDecomposableCoreElement()
 * @model abstract="true"
 * @generated
 */
public interface DecomposableCoreElement extends Supportable, CoreElement {
  /**
   * Returns the value of the '<em><b>In Context Of</b></em>' containment reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.safetycase.InContextOf}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.InContextOf#getContextOf <em>Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>In Context Of</em>' containment reference list.
   * @see edu.toronto.cs.se.modelepedia.safetycase.GSNPackage#getDecomposableCoreElement_InContextOf()
   * @see edu.toronto.cs.se.modelepedia.safetycase.InContextOf#getContextOf
   * @model opposite="contextOf" containment="true"
   * @generated
   */
  EList<InContextOf> getInContextOf();

} // DecomposableCoreElement
