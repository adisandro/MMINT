/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#isDynamic <em>Dynamic</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#getSupertype <em>Supertype</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes <em>Subtypes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint3.mm.MMType#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType()
 * @model
 * @generated
 */
public interface MMType extends MMElement, Type {
  /**
   * Returns the value of the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dynamic</em>' attribute.
   * @see #setDynamic(boolean)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType_Dynamic()
   * @model required="true"
   * @generated
   */
  boolean isDynamic();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMType#isDynamic <em>Dynamic</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dynamic</em>' attribute.
   * @see #isDynamic()
   * @generated
   */
  void setDynamic(boolean value);

  /**
   * Returns the value of the '<em><b>Supertype</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes <em>Subtypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Supertype</em>' reference.
   * @see #setSupertype(MMType)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType_Supertype()
   * @see edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes
   * @model opposite="subtypes"
   * @generated
   */
  MMType getSupertype();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSupertype <em>Supertype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Supertype</em>' reference.
   * @see #getSupertype()
   * @generated
   */
  void setSupertype(MMType value);

  /**
   * Returns the value of the '<em><b>Subtypes</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.mmint3.mm.MMType}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSupertype <em>Supertype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subtypes</em>' reference list.
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType_Subtypes()
   * @see edu.toronto.cs.se.mmint3.mm.MMType#getSupertype
   * @model opposite="supertype"
   * @generated
   */
  EList<MMType> getSubtypes();

  /**
   * Returns the value of the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abstract</em>' attribute.
   * @see #setAbstract(boolean)
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType_Abstract()
   * @model required="true"
   * @generated
   */
  boolean isAbstract();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint3.mm.MMType#isAbstract <em>Abstract</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abstract</em>' attribute.
   * @see #isAbstract()
   * @generated
   */
  void setAbstract(boolean value);

} // MMType
