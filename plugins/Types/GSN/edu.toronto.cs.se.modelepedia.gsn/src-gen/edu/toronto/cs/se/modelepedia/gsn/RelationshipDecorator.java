/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship Decorator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator#getCardinality <em>Cardinality</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getRelationshipDecorator()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='OneRelationship'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot OneRelationship='self.supportedBy-&gt;isEmpty() or self.inContextOf-&gt;isEmpty()'"
 * @generated
 */
public interface RelationshipDecorator extends Supportable, Contextualizable {
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.gsn.DecoratorType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see edu.toronto.cs.se.modelepedia.gsn.DecoratorType
   * @see #setType(DecoratorType)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getRelationshipDecorator_Type()
   * @model required="true"
   * @generated
   */
  DecoratorType getType();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see edu.toronto.cs.se.modelepedia.gsn.DecoratorType
   * @see #getType()
   * @generated
   */
  void setType(DecoratorType value);

  /**
   * Returns the value of the '<em><b>Cardinality</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cardinality</em>' attribute.
   * @see #setCardinality(int)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getRelationshipDecorator_Cardinality()
   * @model default="-1"
   * @generated
   */
  int getCardinality();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator#getCardinality <em>Cardinality</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cardinality</em>' attribute.
   * @see #getCardinality()
   * @generated
   */
  void setCardinality(int value);

} // RelationshipDecorator
