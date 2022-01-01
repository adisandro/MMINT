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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Impact Type</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getImpactType()
 * @model
 * @generated
 */
public enum ImpactType implements Enumerator {
  /**
   * The '<em><b>Revise</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #REVISE_VALUE
   * @generated
   * @ordered
   */
  REVISE(1, "Revise", "Revise"),

  /**
   * The '<em><b>Recheck Content</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #RECHECK_CONTENT_VALUE
   * @generated
   * @ordered
   */
  RECHECK_CONTENT(2, "RecheckContent", "RecheckContent"),

  /**
   * The '<em><b>Recheck State</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #RECHECK_STATE_VALUE
   * @generated
   * @ordered
   */
  RECHECK_STATE(3, "RecheckState", "RecheckState"),

  /**
   * The '<em><b>Reuse</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #REUSE_VALUE
   * @generated
   * @ordered
   */
  REUSE(4, "Reuse", "Reuse");

  /**
   * The '<em><b>Revise</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #REVISE
   * @model name="Revise"
   * @generated
   * @ordered
   */
  public static final int REVISE_VALUE = 1;

  /**
   * The '<em><b>Recheck Content</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #RECHECK_CONTENT
   * @model name="RecheckContent"
   * @generated
   * @ordered
   */
  public static final int RECHECK_CONTENT_VALUE = 2;

  /**
   * The '<em><b>Recheck State</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #RECHECK_STATE
   * @model name="RecheckState"
   * @generated
   * @ordered
   */
  public static final int RECHECK_STATE_VALUE = 3;

  /**
   * The '<em><b>Reuse</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #REUSE
   * @model name="Reuse"
   * @generated
   * @ordered
   */
  public static final int REUSE_VALUE = 4;

  /**
   * An array of all the '<em><b>Impact Type</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private static final ImpactType[] VALUES_ARRAY = new ImpactType[] { REVISE, RECHECK_CONTENT, RECHECK_STATE, REUSE, };

  /**
   * A public read-only list of all the '<em><b>Impact Type</b></em>' enumerators. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  public static final List<ImpactType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Impact Type</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @param literal
   *          the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ImpactType get(String literal) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ImpactType result = VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Impact Type</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @param name
   *          the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ImpactType getByName(String name) {
    for (int i = 0; i < VALUES_ARRAY.length; ++i) {
      ImpactType result = VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Impact Type</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @param value
   *          the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static ImpactType get(int value) {
    switch (value) {
    case REVISE_VALUE:
      return REVISE;
    case RECHECK_CONTENT_VALUE:
      return RECHECK_CONTENT;
    case RECHECK_STATE_VALUE:
      return RECHECK_STATE;
    case REUSE_VALUE:
      return REUSE;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  private ImpactType(int value, String name, String literal) {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public int getValue() {
    return value;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String getLiteral() {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    return literal;
  }

} // ImpactType
