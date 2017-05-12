/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

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
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getState <em>State</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getInContextOf <em>In Context Of</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getSupports <em>Supports</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getGoal()
 * @model
 * @generated
 */
public interface Goal extends StrategySupporter {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.nlsfung.gsn.TruthState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.TruthState
	 * @see #setState(TruthState)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getGoal_State()
	 * @model
	 * @generated
	 */
	TruthState getState();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.TruthState
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
	 * @see #setSupportedBy(GoalSupporter)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getGoal_SupportedBy()
	 * @model required="true"
	 * @generated
	 */
	GoalSupporter getSupportedBy();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getSupportedBy <em>Supported By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supported By</em>' reference.
	 * @see #getSupportedBy()
	 * @generated
	 */
	void setSupportedBy(GoalSupporter value);

	/**
	 * Returns the value of the '<em><b>In Context Of</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.ContextualElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Context Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Context Of</em>' reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getGoal_InContextOf()
	 * @model
	 * @generated
	 */
	EList<ContextualElement> getInContextOf();

	/**
	 * Returns the value of the '<em><b>Supports</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supports</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supports</em>' reference.
	 * @see #setSupports(Strategy)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getGoal_Supports()
	 * @model
	 * @generated
	 */
	Strategy getSupports();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getSupports <em>Supports</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supports</em>' reference.
	 * @see #getSupports()
	 * @generated
	 */
	void setSupports(Strategy value);

} // Goal
