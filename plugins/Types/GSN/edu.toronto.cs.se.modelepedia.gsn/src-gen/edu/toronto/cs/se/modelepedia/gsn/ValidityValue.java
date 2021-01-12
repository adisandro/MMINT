/**
 * Copyright (c) 2012-2021 Alessio Di Sandro, Marsha Chechik, Nick Fung.
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Validity Value</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getValidityValue()
 * @model
 * @generated
 */
public enum ValidityValue implements Enumerator {
  /**
   * The '<em><b>Invalid</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INVALID_VALUE
   * @generated
   * @ordered
   */
  INVALID(0, "Invalid", "Invalid"),

  /**
   * The '<em><b>Valid</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VALID_VALUE
   * @generated
   * @ordered
   */
  VALID(1, "Valid", "Valid"),

  /**
   * The '<em><b>Undetermined</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNDETERMINED_VALUE
   * @generated
   * @ordered
   */
  UNDETERMINED(2, "Undetermined", "Undetermined");

  /**
   * The '<em><b>Invalid</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INVALID
   * @model name="Invalid"
   * @generated
   * @ordered
   */
  public static final int INVALID_VALUE = 0;

  /**
   * The '<em><b>Valid</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #VALID
   * @model name="Valid"
   * @generated
   * @ordered
   */
  public static final int VALID_VALUE = 1;

  /**
   * The '<em><b>Undetermined</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #UNDETERMINED
   * @model name="Undetermined"
   * @generated
   * @ordered
   */
  public static final int UNDETERMINED_VALUE = 2;

  /**
   * An array of all the '<em><b>Validity Value</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final ValidityValue[] VALUES_ARRAY =
    new ValidityValue[] {
      INVALID,
      VALID,
      UNDETERMINED,
    };

  /**
   * A public read-only list of all the '<em><b>Validity Value</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<ValidityValue> VALUES = Collections.unmodifiableList(Arrays.asList(ValidityValue.VALUES_ARRAY));

  /**
   * Returns the '<em><b>Validity Value</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ValidityValue get(String literal) {
    for (var i = 0; i < ValidityValue.VALUES_ARRAY.length; ++i) {
      var result = ValidityValue.VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Validity Value</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ValidityValue getByName(String name) {
    for (var i = 0; i < ValidityValue.VALUES_ARRAY.length; ++i) {
      var result = ValidityValue.VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Validity Value</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ValidityValue get(int value) {
    switch (value) {
      case INVALID_VALUE: return INVALID;
      case VALID_VALUE: return VALID;
      case UNDETERMINED_VALUE: return UNDETERMINED;
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
  private ValidityValue(int value, String name, String literal) {
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

} //ValidityValue
