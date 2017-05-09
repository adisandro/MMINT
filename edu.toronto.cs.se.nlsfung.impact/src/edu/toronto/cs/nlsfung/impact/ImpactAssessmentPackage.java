/**
 */
package edu.toronto.cs.nlsfung.impact;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.nlsfung.impact.ImpactAssessmentFactory
 * @model kind="package"
 * @generated
 */
public interface ImpactAssessmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "impact";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.cs.toronto.edu/~nlsfung/impact";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "impact";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImpactAssessmentPackage eINSTANCE = edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentImpl <em>Impact Assessment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentImpl
	 * @see edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentPackageImpl#getImpactAssessment()
	 * @generated
	 */
	int IMPACT_ASSESSMENT = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ASSESSMENT__ANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>Impact Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ASSESSMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Impact Assessment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPACT_ASSESSMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.impact.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.impact.impl.AnnotationImpl
	 * @see edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 1;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__STATUS = 1;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.impact.Status <em>Status</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.impact.Status
	 * @see edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 2;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.impact.ImpactAssessment <em>Impact Assessment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Impact Assessment</em>'.
	 * @see edu.toronto.cs.nlsfung.impact.ImpactAssessment
	 * @generated
	 */
	EClass getImpactAssessment();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.nlsfung.impact.ImpactAssessment#getAnnotations <em>Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Annotations</em>'.
	 * @see edu.toronto.cs.nlsfung.impact.ImpactAssessment#getAnnotations()
	 * @see #getImpactAssessment()
	 * @generated
	 */
	EReference getImpactAssessment_Annotations();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.impact.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see edu.toronto.cs.nlsfung.impact.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.impact.Annotation#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see edu.toronto.cs.nlsfung.impact.Annotation#getElement()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Element();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.impact.Annotation#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status</em>'.
	 * @see edu.toronto.cs.nlsfung.impact.Annotation#getStatus()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_Status();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.nlsfung.impact.Status <em>Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status</em>'.
	 * @see edu.toronto.cs.nlsfung.impact.Status
	 * @generated
	 */
	EEnum getStatus();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImpactAssessmentFactory getImpactAssessmentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentImpl <em>Impact Assessment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentImpl
		 * @see edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentPackageImpl#getImpactAssessment()
		 * @generated
		 */
		EClass IMPACT_ASSESSMENT = eINSTANCE.getImpactAssessment();

		/**
		 * The meta object literal for the '<em><b>Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPACT_ASSESSMENT__ANNOTATIONS = eINSTANCE.getImpactAssessment_Annotations();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.impact.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.impact.impl.AnnotationImpl
		 * @see edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__ELEMENT = eINSTANCE.getAnnotation_Element();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__STATUS = eINSTANCE.getAnnotation_Status();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.impact.Status <em>Status</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.impact.Status
		 * @see edu.toronto.cs.nlsfung.impact.impl.ImpactAssessmentPackageImpl#getStatus()
		 * @generated
		 */
		EEnum STATUS = eINSTANCE.getStatus();

	}

} //ImpactAssessmentPackage
