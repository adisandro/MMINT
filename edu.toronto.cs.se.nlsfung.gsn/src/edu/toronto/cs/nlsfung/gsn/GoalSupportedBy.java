/**
 */
package edu.toronto.cs.nlsfung.gsn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal Supported By</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.GoalSupportedBy#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.GoalSupportedBy#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getGoalSupportedBy()
 * @model
 * @generated
 */
public interface GoalSupportedBy extends SupportedBy {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Goal)
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getGoalSupportedBy_Source()
	 * @model
	 * @generated
	 */
	Goal getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.GoalSupportedBy#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Goal value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(GoalSupporter)
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getGoalSupportedBy_Target()
	 * @model
	 * @generated
	 */
	GoalSupporter getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.GoalSupportedBy#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(GoalSupporter value);

} // GoalSupportedBy
