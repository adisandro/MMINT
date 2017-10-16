/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Supported By</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getConclusion <em>Conclusion</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getPremise <em>Premise</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSupportedBy()
 * @model
 * @generated
 */
public interface SupportedBy extends EObject {
	/**
	 * Returns the value of the '<em><b>Conclusion</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getSupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conclusion</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conclusion</em>' container reference.
	 * @see #setConclusion(DecomposableCoreElement)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSupportedBy_Conclusion()
	 * @see edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getSupportedBy
	 * @model opposite="supportedBy" required="true" transient="false"
	 * @generated
	 */
	DecomposableCoreElement getConclusion();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getConclusion <em>Conclusion</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conclusion</em>' container reference.
	 * @see #getConclusion()
	 * @generated
	 */
	void setConclusion(DecomposableCoreElement value);

	/**
	 * Returns the value of the '<em><b>Premise</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.nlsfung.gsn.CoreElement#getSupports <em>Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Premise</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Premise</em>' reference.
	 * @see #setPremise(CoreElement)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSupportedBy_Premise()
	 * @see edu.toronto.cs.se.nlsfung.gsn.CoreElement#getSupports
	 * @model opposite="supports" required="true"
	 * @generated
	 */
	CoreElement getPremise();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getPremise <em>Premise</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise</em>' reference.
	 * @see #getPremise()
	 * @generated
	 */
	void setPremise(CoreElement value);

} // SupportedBy
