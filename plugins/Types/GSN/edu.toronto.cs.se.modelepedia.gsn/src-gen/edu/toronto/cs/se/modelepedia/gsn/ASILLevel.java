/*******************************************************************************
 * Copyright (c) 2017, 2022 Alessio Di Sandro, Nick Fung.
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
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>ASIL Level</b></em>', and utility
 * methods for working with them. <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getASILLevel()
 * @model
 * @generated
 */
public enum ASILLevel implements Enumerator {
  /**
   * The '<em><b>D</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #D_VALUE
   * @generated
   * @ordered
   */
  D(0, "D", "D"),

  /**
   * The '<em><b>C</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #C_VALUE
   * @generated
   * @ordered
   */
  C(1, "C", "C"),

  /**
   * The '<em><b>B</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #B_VALUE
   * @generated
   * @ordered
   */
  B(2, "B", "B"),

  /**
   * The '<em><b>A</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #A_VALUE
   * @generated
   * @ordered
   */
  A(3, "A", "A"),

  /**
   * The '<em><b>QM</b></em>' literal object.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #QM_VALUE
   * @generated
   * @ordered
   */
  QM(4, "QM", "QM");

  /**
   * The '<em><b>D</b></em>' literal value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #D
   * @model
   * @generated
   * @ordered
   */
  public static final int D_VALUE = 0;

  /**
   * The '<em><b>C</b></em>' literal value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #C
   * @model
   * @generated
   * @ordered
   */
  public static final int C_VALUE = 1;

  /**
   * The '<em><b>B</b></em>' literal value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #B
   * @model
   * @generated
   * @ordered
   */
  public static final int B_VALUE = 2;

  /**
   * The '<em><b>A</b></em>' literal value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #A
   * @model
   * @generated
   * @ordered
   */
  public static final int A_VALUE = 3;

  /**
   * The '<em><b>QM</b></em>' literal value.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #QM
   * @model
   * @generated
   * @ordered
   */
  public static final int QM_VALUE = 4;

  /**
   * An array of all the '<em><b>ASIL Level</b></em>' enumerators.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  private static final ASILLevel[] VALUES_ARRAY = new ASILLevel[] {
      D,
      C,
      B,
      A,
      QM,
    };

  /**
   * A public read-only list of all the '<em><b>ASIL Level</b></em>' enumerators.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  public static final List<ASILLevel> VALUES = Collections.unmodifiableList(Arrays.asList(ASILLevel.VALUES_ARRAY));

  /**
   * Returns the '<em><b>ASIL Level</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ASILLevel get(String literal) {
    for (var i = 0; i < ASILLevel.VALUES_ARRAY.length; ++i) {
      var result = ASILLevel.VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>ASIL Level</b></em>' literal with the specified name. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @param name
   *          the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ASILLevel getByName(String name) {
    for (var i = 0; i < ASILLevel.VALUES_ARRAY.length; ++i) {
      var result = ASILLevel.VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>ASIL Level</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ASILLevel get(int value) {
    switch (value) {
      case D_VALUE: return D;
      case C_VALUE: return C;
      case B_VALUE: return B;
      case A_VALUE: return A;
      case QM_VALUE: return QM;
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
  private ASILLevel(int value, String name, String literal) {
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

} // ASILLevel
