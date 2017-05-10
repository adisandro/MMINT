/**
 */
package edu.toronto.cs.nlsfung.gsn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Strategy In Context Of</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.StrategyInContextOf#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.StrategyInContextOf#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getStrategyInContextOf()
 * @model
 * @generated
 */
public interface StrategyInContextOf extends InContextOf {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Strategy)
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getStrategyInContextOf_Source()
	 * @model
	 * @generated
	 */
	Strategy getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.StrategyInContextOf#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Strategy value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(StrategyContext)
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getStrategyInContextOf_Target()
	 * @model
	 * @generated
	 */
	StrategyContext getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.StrategyInContextOf#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(StrategyContext value);

} // StrategyInContextOf
