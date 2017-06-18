/**
 */
package edu.toronto.cs.se.nlsfung.gsn;

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
 * @see edu.toronto.cs.se.nlsfung.gsn.GSNFactory
 * @model kind="package"
 * @generated
 */
public interface GSNPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "gsn";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.cs.toronto.edu/~nlsfung/gsn";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "gsn";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GSNPackage eINSTANCE = edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.SafetyCaseImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getSafetyCase()
	 * @generated
	 */
	int SAFETY_CASE = 0;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__GOALS = 0;

	/**
	 * The feature id for the '<em><b>Strategies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__STRATEGIES = 1;

	/**
	 * The feature id for the '<em><b>Solutions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__SOLUTIONS = 2;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__CONTEXTS = 3;

	/**
	 * The feature id for the '<em><b>ASIL Levels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__ASIL_LEVELS = 4;

	/**
	 * The number of structural features of the '<em>Safety Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Safety Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ArgumentElementImpl <em>Argument Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ArgumentElementImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getArgumentElement()
	 * @generated
	 */
	int ARGUMENT_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Argument Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Argument Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.CoreElementImpl <em>Core Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.CoreElementImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getCoreElement()
	 * @generated
	 */
	int CORE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT__ID = ARGUMENT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT__NAME = ARGUMENT_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT__DESCRIPTION = ARGUMENT_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT__SUPPORTS = ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT_FEATURE_COUNT = ARGUMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Core Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT_OPERATION_COUNT = ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.DecomposableCoreElementImpl <em>Decomposable Core Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.DecomposableCoreElementImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getDecomposableCoreElement()
	 * @generated
	 */
	int DECOMPOSABLE_CORE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__ID = CORE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__NAME = CORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION = CORE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__SUPPORTS = CORE_ELEMENT__SUPPORTS;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY = CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF = CORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Decomposable Core Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT = CORE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Decomposable Core Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT = CORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ContextualElementImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getContextualElement()
	 * @generated
	 */
	int CONTEXTUAL_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__ID = ARGUMENT_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__NAME = ARGUMENT_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__DESCRIPTION = ARGUMENT_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__CONTEXT_OF = ARGUMENT_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Contextual Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT_FEATURE_COUNT = ARGUMENT_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Contextual Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT_OPERATION_COUNT = ARGUMENT_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.SupportedByImpl <em>Supported By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.SupportedByImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getSupportedBy()
	 * @generated
	 */
	int SUPPORTED_BY = 5;

	/**
	 * The feature id for the '<em><b>Conclusion</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTED_BY__CONCLUSION = 0;

	/**
	 * The feature id for the '<em><b>Premises</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTED_BY__PREMISES = 1;

	/**
	 * The number of structural features of the '<em>Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTED_BY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTED_BY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.InContextOfImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getInContextOf()
	 * @generated
	 */
	int IN_CONTEXT_OF = 6;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF__CONTEXTS = 0;

	/**
	 * The feature id for the '<em><b>Context Of</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF__CONTEXT_OF = 1;

	/**
	 * The number of structural features of the '<em>In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ID = DECOMPOSABLE_CORE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NAME = DECOMPOSABLE_CORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DESCRIPTION = DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SUPPORTS = DECOMPOSABLE_CORE_ELEMENT__SUPPORTS;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SUPPORTED_BY = DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__IN_CONTEXT_OF = DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__STATE = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getStrategy()
	 * @generated
	 */
	int STRATEGY = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__ID = DECOMPOSABLE_CORE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__NAME = DECOMPOSABLE_CORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__DESCRIPTION = DECOMPOSABLE_CORE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__SUPPORTS = DECOMPOSABLE_CORE_ELEMENT__SUPPORTS;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__SUPPORTED_BY = DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__IN_CONTEXT_OF = DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__STATE = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_FEATURE_COUNT = DECOMPOSABLE_CORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_OPERATION_COUNT = DECOMPOSABLE_CORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.SolutionImpl <em>Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.SolutionImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ID = CORE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__NAME = CORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__DESCRIPTION = CORE_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__SUPPORTS = CORE_ELEMENT__SUPPORTS;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__STATE = CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = CORE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_OPERATION_COUNT = CORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ContextImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__ID = CONTEXTUAL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = CONTEXTUAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__DESCRIPTION = CONTEXTUAL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__CONTEXT_OF = CONTEXTUAL_ELEMENT__CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__STATE = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = CONTEXTUAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ASILImpl <em>ASIL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ASILImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getASIL()
	 * @generated
	 */
	int ASIL = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__ID = CONTEXT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__NAME = CONTEXT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__DESCRIPTION = CONTEXT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__CONTEXT_OF = CONTEXT__CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__STATE = CONTEXT__STATE;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__LEVEL = CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ASIL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_FEATURE_COUNT = CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>ASIL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_OPERATION_COUNT = CONTEXT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.TruthState <em>Truth State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.TruthState
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getTruthState()
	 * @generated
	 */
	int TRUTH_STATE = 12;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.ASILLevel
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getASILLevel()
	 * @generated
	 */
	int ASIL_LEVEL = 13;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.ValidityState <em>Validity State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.ValidityState
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getValidityState()
	 * @generated
	 */
	int VALIDITY_STATE = 14;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase <em>Safety Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Safety Case</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SafetyCase
	 * @generated
	 */
	EClass getSafetyCase();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goals</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getGoals()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_Goals();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getStrategies <em>Strategies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Strategies</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getStrategies()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_Strategies();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getSolutions <em>Solutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Solutions</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getSolutions()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_Solutions();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getContexts()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_Contexts();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getASILLevels <em>ASIL Levels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>ASIL Levels</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getASILLevels()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_ASILLevels();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement <em>Argument Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument Element</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ArgumentElement
	 * @generated
	 */
	EClass getArgumentElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getId()
	 * @see #getArgumentElement()
	 * @generated
	 */
	EAttribute getArgumentElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getName()
	 * @see #getArgumentElement()
	 * @generated
	 */
	EAttribute getArgumentElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ArgumentElement#getDescription()
	 * @see #getArgumentElement()
	 * @generated
	 */
	EAttribute getArgumentElement_Description();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.CoreElement <em>Core Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Element</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.CoreElement
	 * @generated
	 */
	EClass getCoreElement();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.nlsfung.gsn.CoreElement#getSupports <em>Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supports</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.CoreElement#getSupports()
	 * @see #getCoreElement()
	 * @generated
	 */
	EReference getCoreElement_Supports();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement <em>Decomposable Core Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decomposable Core Element</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement
	 * @generated
	 */
	EClass getDecomposableCoreElement();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getSupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Supported By</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getSupportedBy()
	 * @see #getDecomposableCoreElement()
	 * @generated
	 */
	EReference getDecomposableCoreElement_SupportedBy();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getInContextOf <em>In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>In Context Of</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.DecomposableCoreElement#getInContextOf()
	 * @see #getDecomposableCoreElement()
	 * @generated
	 */
	EReference getDecomposableCoreElement_InContextOf();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.ContextualElement <em>Contextual Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contextual Element</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ContextualElement
	 * @generated
	 */
	EClass getContextualElement();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.nlsfung.gsn.ContextualElement#getContextOf <em>Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Context Of</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ContextualElement#getContextOf()
	 * @see #getContextualElement()
	 * @generated
	 */
	EReference getContextualElement_ContextOf();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supported By</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SupportedBy
	 * @generated
	 */
	EClass getSupportedBy();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getConclusion <em>Conclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Conclusion</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getConclusion()
	 * @see #getSupportedBy()
	 * @generated
	 */
	EReference getSupportedBy_Conclusion();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getPremises <em>Premises</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Premises</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SupportedBy#getPremises()
	 * @see #getSupportedBy()
	 * @generated
	 */
	EReference getSupportedBy_Premises();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.InContextOf <em>In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Context Of</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.InContextOf
	 * @generated
	 */
	EClass getInContextOf();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contexts</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContexts()
	 * @see #getInContextOf()
	 * @generated
	 */
	EReference getInContextOf_Contexts();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContextOf <em>Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context Of</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.InContextOf#getContextOf()
	 * @see #getInContextOf()
	 * @generated
	 */
	EReference getInContextOf_ContextOf();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Goal#getState()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_State();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Strategy
	 * @generated
	 */
	EClass getStrategy();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.Strategy#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Strategy#getState()
	 * @see #getStrategy()
	 * @generated
	 */
	EAttribute getStrategy_State();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Solution
	 * @generated
	 */
	EClass getSolution();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.Solution#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Solution#getState()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_State();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.Context#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Context#getState()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_State();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.ASIL <em>ASIL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ASIL</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ASIL
	 * @generated
	 */
	EClass getASIL();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.ASIL#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ASIL#getLevel()
	 * @see #getASIL()
	 * @generated
	 */
	EAttribute getASIL_Level();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.nlsfung.gsn.TruthState <em>Truth State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Truth State</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.TruthState
	 * @generated
	 */
	EEnum getTruthState();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ASIL Level</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ASILLevel
	 * @generated
	 */
	EEnum getASILLevel();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.nlsfung.gsn.ValidityState <em>Validity State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Validity State</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ValidityState
	 * @generated
	 */
	EEnum getValidityState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GSNFactory getGSNFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.SafetyCaseImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getSafetyCase()
		 * @generated
		 */
		EClass SAFETY_CASE = eINSTANCE.getSafetyCase();

		/**
		 * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__GOALS = eINSTANCE.getSafetyCase_Goals();

		/**
		 * The meta object literal for the '<em><b>Strategies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__STRATEGIES = eINSTANCE.getSafetyCase_Strategies();

		/**
		 * The meta object literal for the '<em><b>Solutions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__SOLUTIONS = eINSTANCE.getSafetyCase_Solutions();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__CONTEXTS = eINSTANCE.getSafetyCase_Contexts();

		/**
		 * The meta object literal for the '<em><b>ASIL Levels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__ASIL_LEVELS = eINSTANCE.getSafetyCase_ASILLevels();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ArgumentElementImpl <em>Argument Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ArgumentElementImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getArgumentElement()
		 * @generated
		 */
		EClass ARGUMENT_ELEMENT = eINSTANCE.getArgumentElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT_ELEMENT__ID = eINSTANCE.getArgumentElement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT_ELEMENT__NAME = eINSTANCE.getArgumentElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARGUMENT_ELEMENT__DESCRIPTION = eINSTANCE.getArgumentElement_Description();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.CoreElementImpl <em>Core Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.CoreElementImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getCoreElement()
		 * @generated
		 */
		EClass CORE_ELEMENT = eINSTANCE.getCoreElement();

		/**
		 * The meta object literal for the '<em><b>Supports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_ELEMENT__SUPPORTS = eINSTANCE.getCoreElement_Supports();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.DecomposableCoreElementImpl <em>Decomposable Core Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.DecomposableCoreElementImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getDecomposableCoreElement()
		 * @generated
		 */
		EClass DECOMPOSABLE_CORE_ELEMENT = eINSTANCE.getDecomposableCoreElement();

		/**
		 * The meta object literal for the '<em><b>Supported By</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY = eINSTANCE.getDecomposableCoreElement_SupportedBy();

		/**
		 * The meta object literal for the '<em><b>In Context Of</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF = eINSTANCE.getDecomposableCoreElement_InContextOf();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ContextualElementImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getContextualElement()
		 * @generated
		 */
		EClass CONTEXTUAL_ELEMENT = eINSTANCE.getContextualElement();

		/**
		 * The meta object literal for the '<em><b>Context Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_ELEMENT__CONTEXT_OF = eINSTANCE.getContextualElement_ContextOf();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.SupportedByImpl <em>Supported By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.SupportedByImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getSupportedBy()
		 * @generated
		 */
		EClass SUPPORTED_BY = eINSTANCE.getSupportedBy();

		/**
		 * The meta object literal for the '<em><b>Conclusion</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPPORTED_BY__CONCLUSION = eINSTANCE.getSupportedBy_Conclusion();

		/**
		 * The meta object literal for the '<em><b>Premises</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUPPORTED_BY__PREMISES = eINSTANCE.getSupportedBy_Premises();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.InContextOfImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getInContextOf()
		 * @generated
		 */
		EClass IN_CONTEXT_OF = eINSTANCE.getInContextOf();

		/**
		 * The meta object literal for the '<em><b>Contexts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_CONTEXT_OF__CONTEXTS = eINSTANCE.getInContextOf_Contexts();

		/**
		 * The meta object literal for the '<em><b>Context Of</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_CONTEXT_OF__CONTEXT_OF = eINSTANCE.getInContextOf_ContextOf();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL__STATE = eINSTANCE.getGoal_State();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getStrategy()
		 * @generated
		 */
		EClass STRATEGY = eINSTANCE.getStrategy();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRATEGY__STATE = eINSTANCE.getStrategy_State();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.SolutionImpl <em>Solution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.SolutionImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getSolution()
		 * @generated
		 */
		EClass SOLUTION = eINSTANCE.getSolution();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__STATE = eINSTANCE.getSolution_State();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ContextImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT__STATE = eINSTANCE.getContext_State();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ASILImpl <em>ASIL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ASILImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getASIL()
		 * @generated
		 */
		EClass ASIL = eINSTANCE.getASIL();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASIL__LEVEL = eINSTANCE.getASIL_Level();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.TruthState <em>Truth State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.TruthState
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getTruthState()
		 * @generated
		 */
		EEnum TRUTH_STATE = eINSTANCE.getTruthState();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.ASILLevel
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getASILLevel()
		 * @generated
		 */
		EEnum ASIL_LEVEL = eINSTANCE.getASILLevel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.ValidityState <em>Validity State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.ValidityState
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getValidityState()
		 * @generated
		 */
		EEnum VALIDITY_STATE = eINSTANCE.getValidityState();

	}

} //GSNPackage
