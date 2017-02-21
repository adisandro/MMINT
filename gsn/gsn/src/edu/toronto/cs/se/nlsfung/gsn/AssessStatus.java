/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Assess Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getAssessStatus()
 * @model
 * @generated
 */
public enum AssessStatus implements Enumerator {
	/**
	 * The '<em><b>Not Reviewed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_REVIEWED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_REVIEWED(0, "NotReviewed", "NotReviewed"),

	/**
	 * The '<em><b>Accepted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCEPTED_VALUE
	 * @generated
	 * @ordered
	 */
	ACCEPTED(1, "Accepted", "Accepted"),

	/**
	 * The '<em><b>Incorrect</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INCORRECT_VALUE
	 * @generated
	 * @ordered
	 */
	INCORRECT(2, "Incorrect", "Incorrect"),

	/**
	 * The '<em><b>Weak</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEAK_VALUE
	 * @generated
	 * @ordered
	 */
	WEAK(3, "Weak", "Weak"),

	/**
	 * The '<em><b>Review Later</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REVIEW_LATER_VALUE
	 * @generated
	 * @ordered
	 */
	REVIEW_LATER(4, "ReviewLater", "ReviewLater");

	/**
	 * The '<em><b>Not Reviewed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Not Reviewed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_REVIEWED
	 * @model name="NotReviewed"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_REVIEWED_VALUE = 0;

	/**
	 * The '<em><b>Accepted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Accepted</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCEPTED
	 * @model name="Accepted"
	 * @generated
	 * @ordered
	 */
	public static final int ACCEPTED_VALUE = 1;

	/**
	 * The '<em><b>Incorrect</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Incorrect</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INCORRECT
	 * @model name="Incorrect"
	 * @generated
	 * @ordered
	 */
	public static final int INCORRECT_VALUE = 2;

	/**
	 * The '<em><b>Weak</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Weak</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WEAK
	 * @model name="Weak"
	 * @generated
	 * @ordered
	 */
	public static final int WEAK_VALUE = 3;

	/**
	 * The '<em><b>Review Later</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Review Later</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REVIEW_LATER
	 * @model name="ReviewLater"
	 * @generated
	 * @ordered
	 */
	public static final int REVIEW_LATER_VALUE = 4;

	/**
	 * An array of all the '<em><b>Assess Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AssessStatus[] VALUES_ARRAY =
		new AssessStatus[] {
			NOT_REVIEWED,
			ACCEPTED,
			INCORRECT,
			WEAK,
			REVIEW_LATER,
		};

	/**
	 * A public read-only list of all the '<em><b>Assess Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AssessStatus> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Assess Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssessStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssessStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assess Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssessStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AssessStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Assess Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AssessStatus get(int value) {
		switch (value) {
			case NOT_REVIEWED_VALUE: return NOT_REVIEWED;
			case ACCEPTED_VALUE: return ACCEPTED;
			case INCORRECT_VALUE: return INCORRECT;
			case WEAK_VALUE: return WEAK;
			case REVIEW_LATER_VALUE: return REVIEW_LATER;
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
	private AssessStatus(int value, String name, String literal) {
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
	
} //AssessStatus
