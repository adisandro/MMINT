/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.Context#getState <em>State</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.Context#getContextOf <em>Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getContext()
 * @model
 * @generated
 */
public interface Context extends GsnElement {
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
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getContext_State()
	 * @model
	 * @generated
	 */
	ValidityState getState();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.Context#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ValidityState
	 * @see #getState()
	 * @generated
	 */
	void setState(ValidityState value);

	/**
	 * Returns the value of the '<em><b>Context Of</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.ContextualElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Of</em>' reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getContext_ContextOf()
	 * @model
	 * @generated
	 */
	EList<ContextualElement> getContextOf();

} // Context
