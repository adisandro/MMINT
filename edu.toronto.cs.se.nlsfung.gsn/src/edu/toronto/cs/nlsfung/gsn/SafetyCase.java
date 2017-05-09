/**
 */
package edu.toronto.cs.nlsfung.gsn;

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
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.SafetyCase#getNodes <em>Nodes</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.SafetyCase#getLinks <em>Links</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getSafetyCase()
 * @model
 * @generated
 */
public interface SafetyCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.nlsfung.gsn.BasicNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getSafetyCase_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<BasicNode> getNodes();

	/**
	 * Returns the value of the '<em><b>Links</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.nlsfung.gsn.BasicLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Links</em>' containment reference list.
	 * @see edu.toronto.cs.nlsfung.gsn.GsnPackage#getSafetyCase_Links()
	 * @model containment="true"
	 * @generated
	 */
	EList<BasicLink> getLinks();

} // SafetyCase
