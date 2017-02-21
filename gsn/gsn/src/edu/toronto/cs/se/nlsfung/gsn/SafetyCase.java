/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safety Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getRootBasicNode <em>Root Basic Node</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getRootBasicLink <em>Root Basic Link</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getRootCommendation <em>Root Commendation</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getDescription <em>Description</em>}</li>
 *   <li>{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase()
 * @model
 * @generated
 */
public interface SafetyCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Root Basic Node</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.BasicNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Basic Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Basic Node</em>' containment reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_RootBasicNode()
	 * @model containment="true"
	 * @generated
	 */
	EList<BasicNode> getRootBasicNode();

	/**
	 * Returns the value of the '<em><b>Root Basic Link</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.BasicLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Basic Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Basic Link</em>' containment reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_RootBasicLink()
	 * @model containment="true"
	 * @generated
	 */
	EList<BasicLink> getRootBasicLink();

	/**
	 * Returns the value of the '<em><b>Root Commendation</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.nlsfung.gsn.Recommendation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Commendation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Commendation</em>' containment reference list.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_RootCommendation()
	 * @model containment="true"
	 * @generated
	 */
	EList<Recommendation> getRootCommendation();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

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
	 * @see edu.toronto.cs.se.nlsfung.gsn.GSNPackage#getSafetyCase_Id()
	 * @model id="true" ordered="false"
	 *        extendedMetaData="name='id' namespace='http://sdq.ipd.uka.de/Identifier/1.0'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // SafetyCase
