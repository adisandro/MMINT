/**
 */
package edu.toronto.cs.se.nlsfung.gsn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decomposable Core Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getSupportedBy <em>Supported By</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getInContextOf <em>In Context Of</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getDecomposableCoreElement()
 * @model abstract="true"
 * @generated
 */
public interface DecomposableCoreElement extends CoreElement {
	/**
	 * Returns the value of the '<em><b>Supported By</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getConclusion <em>Conclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Supported By</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Supported By</em>' containment reference.
	 * @see #setSupportedBy(SupportedBy)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getDecomposableCoreElement_SupportedBy()
	 * @see edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getConclusion
	 * @model opposite="conclusion" containment="true"
	 * @generated
	 */
	SupportedBy getSupportedBy();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getSupportedBy <em>Supported By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Supported By</em>' containment reference.
	 * @see #getSupportedBy()
	 * @generated
	 */
	void setSupportedBy(SupportedBy value);

	/**
	 * Returns the value of the '<em><b>In Context Of</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContextOf <em>Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Context Of</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Context Of</em>' containment reference.
	 * @see #setInContextOf(InContextOf)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getDecomposableCoreElement_InContextOf()
	 * @see edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContextOf
	 * @model opposite="contextOf" containment="true"
	 * @generated
	 */
	InContextOf getInContextOf();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getInContextOf <em>In Context Of</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Context Of</em>' containment reference.
	 * @see #getInContextOf()
	 * @generated
	 */
	void setInContextOf(InContextOf value);

} // DecomposableCoreElement
