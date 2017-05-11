/**
 */
package edu.toronto.cs.nlsfung.gsn;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.Goal#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.Goal#getInContextOf <em>In Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getGoal()
 * @model
 * @generated
 */
public interface Goal extends GsnElement, StrategySupport {
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
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getGoal_State()
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

	/**
	 * Returns the value of the '<em><b>Supported By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported By</em>' reference.
	 * @see #setSupportedBy(GoalSupport)
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getGoal_SupportedBy()
	 * @model required="true"
	 * @generated
	 */
	GoalSupport getSupportedBy();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.Goal#getSupportedBy <em>Supported By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supported By</em>' reference.
	 * @see #getSupportedBy()
	 * @generated
	 */
	void setSupportedBy(GoalSupport value);

	/**
	 * Returns the value of the '<em><b>In Context Of</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.nlsfung.gsn.Context}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Context Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Context Of</em>' reference list.
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getGoal_InContextOf()
	 * @model
	 * @generated
	 */
	EList<Context> getInContextOf();

} // Goal
