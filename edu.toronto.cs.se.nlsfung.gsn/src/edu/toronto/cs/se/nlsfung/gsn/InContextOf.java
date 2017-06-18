/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Context Of</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContexts <em>Contexts</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContextOf <em>Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getInContextOf()
 * @model
 * @generated
 */
public interface InContextOf extends EObject {
	/**
	 * Returns the value of the '<em><b>Contexts</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.ContextualElement}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.nlsfung.gsn.ContextualElement#getContextOf <em>Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contexts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contexts</em>' reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getInContextOf_Contexts()
	 * @see edu.toronto.cs.se.nlsfung.gsn.ContextualElement#getContextOf
	 * @model opposite="contextOf" required="true"
	 * @generated
	 */
	EList<ContextualElement> getContexts();

	/**
	 * Returns the value of the '<em><b>Context Of</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getInContextOf <em>In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Of</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Of</em>' container reference.
	 * @see #setContextOf(DecomposableCoreElement)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getInContextOf_ContextOf()
	 * @see edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getInContextOf
	 * @model opposite="inContextOf" required="true" transient="false"
	 * @generated
	 */
	DecomposableCoreElement getContextOf();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContextOf <em>Context Of</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Of</em>' container reference.
	 * @see #getContextOf()
	 * @generated
	 */
	void setContextOf(DecomposableCoreElement value);

} // InContextOf
