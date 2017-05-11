/**
 */
package edu.toronto.cs.nlsfung.gsn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Strategy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.Strategy#getState <em>State</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.Strategy#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.Strategy#getInContextOf <em>In Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getStrategy()
 * @model
 * @generated
 */
public interface Strategy extends GsnElement, GoalSupport {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.nlsfung.gsn.ValidityState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
	 * @see #setState(ValidityState)
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getStrategy_State()
	 * @model
	 * @generated
	 */
	ValidityState getState();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.Strategy#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
	 * @see #getState()
	 * @generated
	 */
	void setState(ValidityState value);

	/**
	 * Returns the value of the '<em><b>Supported By</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.nlsfung.gsn.StrategySupport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported By</em>' reference list.
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getStrategy_SupportedBy()
	 * @model required="true"
	 * @generated
	 */
	EList<StrategySupport> getSupportedBy();

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
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getStrategy_InContextOf()
	 * @model
	 * @generated
	 */
	EList<Context> getInContextOf();

} // Strategy
