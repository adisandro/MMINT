/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Contribution Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.istar.IStarPackage#getContributionType()
 * @model
 * @generated
 */
public enum ContributionType implements Enumerator {
	/**
	 * The '<em><b>MAKE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAKE_VALUE
	 * @generated
	 * @ordered
	 */
	MAKE(0, "MAKE", "MAKE"),

	/**
	 * The '<em><b>HELP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HELP_VALUE
	 * @generated
	 * @ordered
	 */
	HELP(1, "HELP", "HELP"),

	/**
	 * The '<em><b>SOMEPLUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOMEPLUS_VALUE
	 * @generated
	 * @ordered
	 */
	SOMEPLUS(2, "SOMEPLUS", "SOMEPLUS"),

	/**
	 * The '<em><b>BREAK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BREAK_VALUE
	 * @generated
	 * @ordered
	 */
	BREAK(3, "BREAK", "BREAK"),

	/**
	 * The '<em><b>HURT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HURT_VALUE
	 * @generated
	 * @ordered
	 */
	HURT(4, "HURT", "HURT"),

	/**
	 * The '<em><b>SOMEMINUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOMEMINUS_VALUE
	 * @generated
	 * @ordered
	 */
	SOMEMINUS(5, "SOMEMINUS", "SOMEMINUS"),

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN_VALUE
	 * @generated
	 * @ordered
	 */
	UNKNOWN(6, "UNKNOWN", "UNKNOWN");

	/**
	 * The '<em><b>MAKE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MAKE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAKE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int MAKE_VALUE = 0;

	/**
	 * The '<em><b>HELP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HELP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HELP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HELP_VALUE = 1;

	/**
	 * The '<em><b>SOMEPLUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOMEPLUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOMEPLUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOMEPLUS_VALUE = 2;

	/**
	 * The '<em><b>BREAK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BREAK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BREAK
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BREAK_VALUE = 3;

	/**
	 * The '<em><b>HURT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HURT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HURT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HURT_VALUE = 4;

	/**
	 * The '<em><b>SOMEMINUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOMEMINUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOMEMINUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOMEMINUS_VALUE = 5;

	/**
	 * The '<em><b>UNKNOWN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNKNOWN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNKNOWN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNKNOWN_VALUE = 6;

	/**
	 * An array of all the '<em><b>Contribution Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ContributionType[] VALUES_ARRAY =
		new ContributionType[] {
			MAKE,
			HELP,
			SOMEPLUS,
			BREAK,
			HURT,
			SOMEMINUS,
			UNKNOWN,
		};

	/**
	 * A public read-only list of all the '<em><b>Contribution Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ContributionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Contribution Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContributionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContributionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Contribution Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContributionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ContributionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Contribution Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContributionType get(int value) {
		switch (value) {
			case MAKE_VALUE: return MAKE;
			case HELP_VALUE: return HELP;
			case SOMEPLUS_VALUE: return SOMEPLUS;
			case BREAK_VALUE: return BREAK;
			case HURT_VALUE: return HURT;
			case SOMEMINUS_VALUE: return SOMEMINUS;
			case UNKNOWN_VALUE: return UNKNOWN;
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
	private ContributionType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ContributionType
