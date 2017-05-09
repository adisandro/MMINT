/**
 */
package edu.toronto.cs.nlsfung.impact;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.impact.Annotation#getElement <em>Element</em>}</li>
 *   <li>{@link edu.toronto.cs.nlsfung.impact.Annotation#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.impact.ImpactAssessmentPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends EObject {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' attribute.
	 * @see #setElement(String)
	 * @see edu.toronto.cs.nlsfung.impact.ImpactAssessmentPackage#getAnnotation_Element()
	 * @model id="true" ordered="false"
	 * @generated
	 */
	String getElement();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.impact.Annotation#getElement <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' attribute.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(String value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.nlsfung.impact.Status}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.impact.Status
	 * @see #setStatus(Status)
	 * @see edu.toronto.cs.nlsfung.impact.ImpactAssessmentPackage#getAnnotation_Status()
	 * @model
	 * @generated
	 */
	Status getStatus();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.nlsfung.impact.Annotation#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see edu.toronto.cs.nlsfung.impact.Status
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Status value);

} // Annotation
