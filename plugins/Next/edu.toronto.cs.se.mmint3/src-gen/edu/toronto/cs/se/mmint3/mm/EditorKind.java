/**
 */
package edu.toronto.cs.se.mmint3.mm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Editor Kind</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getEditorKind()
 * @model
 * @generated
 */
public enum EditorKind implements Enumerator {
  /**
   * The '<em><b>EMF</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #EMF_VALUE
   * @generated
   * @ordered
   */
  EMF(0, "EMF", "EMF"),

  /**
   * The '<em><b>GMF</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #GMF_VALUE
   * @generated
   * @ordered
   */
  GMF(1, "GMF", "GMF"),

  /**
   * The '<em><b>SIRIUS</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #SIRIUS_VALUE
   * @generated
   * @ordered
   */
  SIRIUS(2, "SIRIUS", "SIRIUS");

  /**
   * The '<em><b>EMF</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #EMF
   * @model
   * @generated
   * @ordered
   */
  public static final int EMF_VALUE = 0;

  /**
   * The '<em><b>GMF</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #GMF
   * @model
   * @generated
   * @ordered
   */
  public static final int GMF_VALUE = 1;

  /**
   * The '<em><b>SIRIUS</b></em>' literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see #SIRIUS
   * @model
   * @generated
   * @ordered
   */
  public static final int SIRIUS_VALUE = 2;

  /**
   * An array of all the '<em><b>Editor Kind</b></em>' enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static final EditorKind[] VALUES_ARRAY = new EditorKind[] { EMF, GMF, SIRIUS, };

  /**
   * A public read-only list of all the '<em><b>Editor Kind</b></em>' enumerators. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  public static final List<EditorKind> VALUES = Collections.unmodifiableList(Arrays.asList(EditorKind.VALUES_ARRAY));

  /**
   * Returns the '<em><b>Editor Kind</b></em>' literal with the specified literal value. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @param literal
   *          the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static EditorKind get(String literal) {
    for (int i = 0; i < EditorKind.VALUES_ARRAY.length; ++i) {
      EditorKind result = EditorKind.VALUES_ARRAY[i];
      if (result.toString().equals(literal)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Editor Kind</b></em>' literal with the specified name. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @param name
   *          the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static EditorKind getByName(String name) {
    for (int i = 0; i < EditorKind.VALUES_ARRAY.length; ++i) {
      EditorKind result = EditorKind.VALUES_ARRAY[i];
      if (result.getName().equals(name)) {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Editor Kind</b></em>' literal with the specified integer value. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @param value
   *          the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static EditorKind get(int value) {
    switch (value) {
    case EMF_VALUE:
      return EMF;
    case GMF_VALUE:
      return GMF;
    case SIRIUS_VALUE:
      return SIRIUS;
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
  private EditorKind(int value, String name, String literal) {
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
    return this.value;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String getLiteral() {
    return this.literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   */
  @Override
  public String toString() {
    return this.literal;
  }

} // EditorKind
