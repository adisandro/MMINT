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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Impact Type</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getImpactType()
 * @model
 * @generated
 */
public enum ImpactType implements Enumerator {
  /**
   * The '<em><b>REUSE</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #REUSE_VALUE
   * @generated
   * @ordered
   */
  REUSE(1, "REUSE", "REUSE"), /**
   * The '<em><b>RECHECK</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RECHECK_VALUE
   * @generated
   * @ordered
   */
  RECHECK(2, "RECHECK", "RECHECK"), /**
   * The '<em><b>REVISE</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #REVISE_VALUE
   * @generated
   * @ordered
   */
  REVISE(3, "REVISE", "REVISE");

  /**
   * The '<em><b>REUSE</b></em>' literal value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #REUSE
   * @model
   * @generated
   * @ordered
   */
  public static final int REUSE_VALUE = 1;

  /**
   * The '<em><b>RECHECK</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #RECHECK
   * @model
   * @generated
   * @ordered
   */
  public static final int RECHECK_VALUE = 2;

  /**
   * The '<em><b>REVISE</b></em>' literal value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #REVISE
   * @model
   * @generated
   * @ordered
   */
  public static final int REVISE_VALUE = 3;

  /**
   * An array of all the '<em><b>Impact Type</b></em>' enumerators.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private static final ImpactType[] VALUES_ARRAY = new ImpactType[] {
      REUSE,
      RECHECK,
      REVISE,
    };

  /**
   * A public read-only list of all the '<em><b>Impact Type</b></em>' enumerators.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  public static final List<ImpactType> VALUES = Collections.unmodifiableList(Arrays.asList(ImpactType.VALUES_ARRAY));

  /**
   * Returns the '<em><b>Impact Type</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ImpactType get(String literal) {
    for (var i = 0; i < ImpactType.VALUES_ARRAY.length; ++i) {
      var result = ImpactType.VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Impact Type</b></em>' literal with the specified name.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ImpactType getByName(String name) {
    for (var i = 0; i < ImpactType.VALUES_ARRAY.length; ++i) {
      var result = ImpactType.VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Impact Type</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ImpactType get(int value) {
    switch (value) {
      case REUSE_VALUE: return REUSE;
      case RECHECK_VALUE: return RECHECK;
      case REVISE_VALUE: return REVISE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private ImpactType(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue() {
    return this.value;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral() {
    return this.literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return this.literal;
  }

} // ImpactType
