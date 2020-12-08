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
 * A representation of the model object '<em><b>Impact Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getImpactAnnotation()
 * @model
 * @generated
 */
public interface ImpactAnnotation extends EObject {
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.gsn.ImpactType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactType
   * @see #setType(ImpactType)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getImpactAnnotation_Type()
   * @model required="true"
   * @generated
   */
  ImpactType getType();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see edu.toronto.cs.se.modelepedia.gsn.ImpactType
   * @see #getType()
   * @generated
   */
  void setType(ImpactType value);

  /**
   * Returns the value of the '<em><b>Source</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' attribute.
   * @see #setSource(String)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getImpactAnnotation_Source()
   * @model
   * @generated
   */
  String getSource();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation#getSource <em>Source</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' attribute.
   * @see #getSource()
   * @generated
   */
  void setSource(String value);

} // ImpactAnnotation
