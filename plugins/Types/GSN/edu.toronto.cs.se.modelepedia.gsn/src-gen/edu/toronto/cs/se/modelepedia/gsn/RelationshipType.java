/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Relationship Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getRelationshipType()
 * @model
 * @generated
 */
public enum RelationshipType implements Enumerator {
  /**
   * The '<em><b>STANDARD</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STANDARD_VALUE
   * @generated
   * @ordered
   */
  STANDARD(0, "STANDARD", "STANDARD"),

  /**
   * The '<em><b>MULTIPLE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIPLE_VALUE
   * @generated
   * @ordered
   */
  MULTIPLE(1, "MULTIPLE", "MULTIPLE"),

  /**
   * The '<em><b>OPTIONAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OPTIONAL_VALUE
   * @generated
   * @ordered
   */
  OPTIONAL(2, "OPTIONAL", "OPTIONAL"),

  /**
   * The '<em><b>CHOICE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CHOICE_VALUE
   * @generated
   * @ordered
   */
  CHOICE(3, "CHOICE", "CHOICE");

  /**
   * The '<em><b>STANDARD</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STANDARD
   * @model
   * @generated
   * @ordered
   */
  public static final int STANDARD_VALUE = 0;

  /**
   * The '<em><b>MULTIPLE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #MULTIPLE
   * @model
   * @generated
   * @ordered
   */
  public static final int MULTIPLE_VALUE = 1;

  /**
   * The '<em><b>OPTIONAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #OPTIONAL
   * @model
   * @generated
   * @ordered
   */
  public static final int OPTIONAL_VALUE = 2;

  /**
   * The '<em><b>CHOICE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #CHOICE
   * @model
   * @generated
   * @ordered
   */
  public static final int CHOICE_VALUE = 3;

  /**
   * An array of all the '<em><b>Relationship Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final RelationshipType[] VALUES_ARRAY =
    new RelationshipType[] {
      STANDARD,
      MULTIPLE,
      OPTIONAL,
      CHOICE,
    };

  /**
   * A public read-only list of all the '<em><b>Relationship Type</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<RelationshipType> VALUES = Collections.unmodifiableList(Arrays.asList(RelationshipType.VALUES_ARRAY));

  /**
   * Returns the '<em><b>Relationship Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static RelationshipType get(String literal) {
    for (var i = 0; i < RelationshipType.VALUES_ARRAY.length; ++i) {
      var result = RelationshipType.VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Relationship Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static RelationshipType getByName(String name) {
    for (var i = 0; i < RelationshipType.VALUES_ARRAY.length; ++i) {
      var result = RelationshipType.VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Relationship Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static RelationshipType get(int value) {
    switch (value) {
      case STANDARD_VALUE: return STANDARD;
      case MULTIPLE_VALUE: return MULTIPLE;
      case OPTIONAL_VALUE: return OPTIONAL;
      case CHOICE_VALUE: return CHOICE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private RelationshipType(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue() {
    return this.value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral() {
    return this.literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return this.literal;
  }

} //RelationshipType
