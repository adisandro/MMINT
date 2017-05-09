/**
 */
package edu.toronto.cs.nlsfung.gsn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.Goal#getState <em>State</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getGoal()
 * @model
 * @generated
 */
public interface Goal extends BasicNode {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.nlsfung.gsn.TruthState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.gsn.TruthState
	 * @see #setState(TruthState)
	 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getGoal_State()
	 * @model
	 * @generated
	 */
	TruthState getState();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.Goal#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.gsn.TruthState
	 * @see #getState()
	 * @generated
	 */
	void setState(TruthState value);

} // Goal
