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
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.SafetyCase#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.gsn.SafetyCase#getRelationships <em>Relationships</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getSafetyCase()
 * @model
 * @generated
 */
public interface SafetyCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.nlsfung.gsn.GsnElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getSafetyCase_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<GsnElement> getElements();

	/**
	 * Returns the value of the '<em><b>Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.nlsfung.gsn.GsnRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationships</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationships</em>' containment reference list.
	 * @see edu.toronto.cs.nlsfung.gsn.GSNPackage#getSafetyCase_Relationships()
	 * @model containment="true"
	 * @generated
	 */
	EList<GsnRelationship> getRelationships();

} // SafetyCase
