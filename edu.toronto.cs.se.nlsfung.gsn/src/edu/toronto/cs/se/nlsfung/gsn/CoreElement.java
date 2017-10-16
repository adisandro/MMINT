/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Core Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.CoreElement#getSupports <em>Supports</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getCoreElement()
 * @model abstract="true"
 * @generated
 */
public interface CoreElement extends ArgumentElement {
	/**
	 * Returns the value of the '<em><b>Supports</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getPremise <em>Premise</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supports</em>' reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getCoreElement_Supports()
	 * @see edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getPremise
	 * @model opposite="premise"
	 * @generated
	 */
	EList<SupportedBy> getSupports();

} // CoreElement
