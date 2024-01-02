/*******************************************************************************
 * Copyright (c) 2017, 2024 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ASIL</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getValue <em>Value</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getASIL()
 * @model
 * @generated
 */
public interface ASIL extends EObject {
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.gsn.ASILLevel}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILLevel
   * @see #setValue(ASILLevel)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getASIL_Value()
   * @model required="true"
   * @generated
   */
  ASILLevel getValue();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getValue <em>Value</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Value</em>' attribute.
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILLevel
   * @see #getValue()
   * @generated
   */
  void setValue(ASILLevel value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.gsn.ASILfulElement#getAsil <em>Asil</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the value of the '<em>Target</em>' container reference.
   * @see #setTarget(ASILfulElement)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getASIL_Target()
   * @see edu.toronto.cs.se.modelepedia.gsn.ASILfulElement#getAsil
   * @model opposite="asil" required="true" transient="false"
   * @generated
   */
  ASILfulElement getTarget();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getTarget <em>Target</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' container reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(ASILfulElement value);

  /**
   * Returns the value of the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @return the value of the '<em>Status</em>' containment reference.
   * @see #setStatus(ImpactAnnotation)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getASIL_Status()
   * @model containment="true"
   * @generated
   */
  ImpactAnnotation getStatus();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getStatus <em>Status</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' containment reference.
   * @see #getStatus()
   * @generated
   */
  void setStatus(ImpactAnnotation value);

} // ASIL
