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
 * A representation of the model object '<em><b>In Context Of</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContext <em>Context</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContextOf <em>Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getInContextOf()
 * @model
 * @generated
 */
public interface InContextOf extends EObject {
  /**
   * Returns the value of the '<em><b>Context</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.gsn.ContextualElement#getContextOf <em>Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context</em>' reference.
   * @see #setContext(ContextualElement)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getInContextOf_Context()
   * @see edu.toronto.cs.se.modelepedia.gsn.ContextualElement#getContextOf
   * @model opposite="contextOf" required="true"
   * @generated
   */
  ContextualElement getContext();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContext <em>Context</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context</em>' reference.
   * @see #getContext()
   * @generated
   */
  void setContext(ContextualElement value);

  /**
   * Returns the value of the '<em><b>Context Of</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement#getInContextOf <em>In Context Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context Of</em>' container reference.
   * @see #setContextOf(DecomposableCoreElement)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getInContextOf_ContextOf()
   * @see edu.toronto.cs.se.modelepedia.gsn.DecomposableCoreElement#getInContextOf
   * @model opposite="inContextOf" required="true" transient="false"
   * @generated
   */
  DecomposableCoreElement getContextOf();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.InContextOf#getContextOf <em>Context Of</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context Of</em>' container reference.
   * @see #getContextOf()
   * @generated
   */
  void setContextOf(DecomposableCoreElement value);

} // InContextOf
