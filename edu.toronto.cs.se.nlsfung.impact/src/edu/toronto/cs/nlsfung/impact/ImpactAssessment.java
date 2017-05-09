/**
 */
package edu.toronto.cs.nlsfung.impact;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Impact Assessment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.nlsfung.impact.ImpactAssessment#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.nlsfung.impact.ImpactAssessmentPackage#getImpactAssessment()
 * @model
 * @generated
 */
public interface ImpactAssessment extends EObject {
	/**
	 * Returns the value of the '<em><b>Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.nlsfung.impact.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotations</em>' containment reference list.
	 * @see edu.toronto.cs.nlsfung.impact.ImpactAssessmentPackage#getImpactAssessment_Annotations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Annotation> getAnnotations();

} // ImpactAssessment
