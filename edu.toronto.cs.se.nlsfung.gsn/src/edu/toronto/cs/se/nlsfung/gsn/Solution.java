/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.Solution#getState <em>State</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.Solution#getSupports <em>Supports</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSolution()
 * @model
 * @generated
 */
public interface Solution extends GsnElement, GoalSupporter {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.nlsfung.gsn.ValidityState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ValidityState
	 * @see #setState(ValidityState)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSolution_State()
	 * @model
	 * @generated
	 */
	ValidityState getState();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.Solution#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ValidityState
	 * @see #getState()
	 * @generated
	 */
	void setState(ValidityState value);

	/**
	 * Returns the value of the '<em><b>Supports</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.Goal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supports</em>' reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSolution_Supports()
	 * @model required="true"
	 * @generated
	 */
	EList<Goal> getSupports();

} // Solution
