/**
 */
package edu.toronto.cs.nlsfung.gsn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASIL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.ASIL#getLevel <em>Level</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getASIL()
 * @model
 * @generated
 */
public interface ASIL extends Context {
	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.nlsfung.gsn.ASILLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.gsn.ASILLevel
	 * @see #setLevel(ASILLevel)
	 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getASIL_Level()
	 * @model
	 * @generated
	 */
	ASILLevel getLevel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.ASIL#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.gsn.ASILLevel
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(ASILLevel value);

} // ASIL
