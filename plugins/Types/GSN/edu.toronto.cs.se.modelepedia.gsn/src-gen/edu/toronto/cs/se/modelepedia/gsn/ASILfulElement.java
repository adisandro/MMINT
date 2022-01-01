/**
 * Copyright (c) 2012-2022 Alessio Di Sandro, Marsha Chechik, Nick Fung.
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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ASI Lful Element</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.ASILfulElement#getAsil <em>Asil</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getASILfulElement()
 * @model abstract="true"
 * @generated
 */
public interface ASILfulElement extends EObject {
  /**
   * Returns the value of the '<em><b>Asil</b></em>' containment reference. It is bidirectional and its opposite is
   * '{@link edu.toronto.cs.se.modelepedia.gsn.ASIL#getTarget <em>Target</em>}'. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @return the value of the '<em>Asil</em>' containment reference.
   * @see #setAsil(ASIL)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getASILfulElement_Asil()
   * @see edu.toronto.cs.se.modelepedia.gsn.ASIL#getTarget
   * @model opposite="target" containment="true"
   * @generated
   */
  ASIL getAsil();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ASILfulElement#getAsil <em>Asil</em>}' containment
   * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Asil</em>' containment reference.
   * @see #getAsil()
   * @generated
   */
  void setAsil(ASIL value);

} // ASILfulElement
