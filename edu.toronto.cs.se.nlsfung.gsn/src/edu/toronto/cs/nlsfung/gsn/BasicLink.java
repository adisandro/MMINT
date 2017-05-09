/**
 */
package edu.toronto.cs.nlsfung.gsn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Basic Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.BasicLink#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.BasicLink#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.BasicLink#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getBasicLink()
 * @model abstract="true"
 * @generated
 */
public interface BasicLink extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(BasicNode)
	 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getBasicLink_Source()
	 * @model
	 * @generated
	 */
	BasicNode getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.BasicLink#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(BasicNode value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(BasicNode)
	 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getBasicLink_Target()
	 * @model
	 * @generated
	 */
	BasicNode getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.BasicLink#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(BasicNode value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getBasicLink_Id()
	 * @model id="true" ordered="false"
	 *        extendedMetaData="name='id' namespace='http://sdq.ipd.uka.de/Identifier/1.0'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.gsn.BasicLink#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // BasicLink
