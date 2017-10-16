/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contextual Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.ContextualElement#getContextOf <em>Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getContextualElement()
 * @model abstract="true"
 * @generated
 */
public interface ContextualElement extends ArgumentElement {
	/**
	 * Returns the value of the '<em><b>Context Of</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.InContextOf}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Of</em>' reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getContextualElement_ContextOf()
	 * @see edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContext
	 * @model opposite="context" required="true"
	 * @generated
	 */
	EList<InContextOf> getContextOf();

} // ContextualElement
