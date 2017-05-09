/**
 */
package edu.toronto.cs.nlsfung.impact;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.nlsfung.impact.ImpactAssessmentPackage
 * @generated
 */
public interface ImpactAssessmentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImpactAssessmentFactory eINSTANCE = edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Impact Assessment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Impact Assessment</em>'.
	 * @generated
	 */
	ImpactAssessment createImpactAssessment();

	/**
	 * Returns a new object of class '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation</em>'.
	 * @generated
	 */
	Annotation createAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImpactAssessmentPackage getImpactAssessmentPackage();

} //ImpactAssessmentFactory
