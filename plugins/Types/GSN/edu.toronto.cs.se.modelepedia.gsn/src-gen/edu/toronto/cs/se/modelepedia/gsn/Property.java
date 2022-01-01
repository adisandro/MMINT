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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Property</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.Property#getFormal <em>Formal</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.Property#getInformal <em>Informal</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends EObject {
  /**
   * Returns the value of the '<em><b>Informal</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Informal</em>' attribute.
   * @see #setInformal(String)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getProperty_Informal()
   * @model required="true"
   * @generated
   */
  String getInformal();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.Property#getInformal <em>Informal</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Informal</em>' attribute.
   * @see #getInformal()
   * @generated
   */
  void setInformal(String value);

  /**
   * Returns the value of the '<em><b>Formal</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return the value of the '<em>Formal</em>' attribute.
   * @see #setFormal(String)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getProperty_Formal()
   * @model required="true"
   * @generated
   */
  String getFormal();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.Property#getFormal <em>Formal</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param value
   *          the new value of the '<em>Formal</em>' attribute.
   * @see #getFormal()
   * @generated
   */
  void setFormal(String value);

} // Property
