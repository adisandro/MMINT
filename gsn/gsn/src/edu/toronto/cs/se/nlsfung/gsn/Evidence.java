/**
 */
package edu.toronto.cs.se.nlsfung.gsn;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Evidence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.Evidence#getAttachment <em>Attachment</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getEvidence()
 * @model annotation="gmf.node label='name' label.icon='false' label.pattern='Evidence: {0}' figure='gsnfigures.GSNSolution' size='80,80' color='255,255,255'"
 * @generated
 */
public interface Evidence extends BasicNode {
	/**
	 * Returns the value of the '<em><b>Attachment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attachment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attachment</em>' attribute.
	 * @see #setAttachment(String)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getEvidence_Attachment()
	 * @model
	 * @generated
	 */
	String getAttachment();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.Evidence#getAttachment <em>Attachment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attachment</em>' attribute.
	 * @see #getAttachment()
	 * @generated
	 */
	void setAttachment(String value);

} // Evidence
