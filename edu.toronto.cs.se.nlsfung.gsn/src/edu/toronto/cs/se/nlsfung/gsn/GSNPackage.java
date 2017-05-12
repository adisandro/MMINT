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
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__ELEMENTS = 0;

	/**
	 * The number of structural features of the '<em>Safety Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Safety Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.GsnElementImpl <em>Gsn Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GsnElementImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getGsnElement()
	 * @generated
	 */
	int GSN_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSN_ELEMENT__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSN_ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSN_ELEMENT__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Gsn Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSN_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Gsn Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSN_ELEMENT_OPERATION_COUNT = 0;

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
	int CORE_ELEMENT__ID = GSN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT__NAME = GSN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT__DESCRIPTION = GSN_ELEMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Core Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT_FEATURE_COUNT = GSN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Core Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_ELEMENT_OPERATION_COUNT = GSN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.GoalSupporterImpl <em>Goal Supporter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GoalSupporterImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getGoalSupporter()
	 * @generated
	 */
	int GOAL_SUPPORTER = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTER__ID = CORE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTER__NAME = CORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTER__DESCRIPTION = CORE_ELEMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Goal Supporter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTER_FEATURE_COUNT = CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Goal Supporter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTER_OPERATION_COUNT = CORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.StrategySupporterImpl <em>Strategy Supporter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.StrategySupporterImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getStrategySupporter()
	 * @generated
	 */
	int STRATEGY_SUPPORTER = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTER__ID = CORE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTER__NAME = CORE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTER__DESCRIPTION = CORE_ELEMENT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Strategy Supporter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTER_FEATURE_COUNT = CORE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Strategy Supporter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTER_OPERATION_COUNT = CORE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GoalImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ID = STRATEGY_SUPPORTER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NAME = STRATEGY_SUPPORTER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DESCRIPTION = STRATEGY_SUPPORTER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__STATE = STRATEGY_SUPPORTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SUPPORTED_BY = STRATEGY_SUPPORTER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__IN_CONTEXT_OF = STRATEGY_SUPPORTER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SUPPORTS = STRATEGY_SUPPORTER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = STRATEGY_SUPPORTER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = STRATEGY_SUPPORTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.StrategyImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getStrategy()
	 * @generated
	 */
	int STRATEGY = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__ID = GOAL_SUPPORTER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__NAME = GOAL_SUPPORTER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__DESCRIPTION = GOAL_SUPPORTER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__STATE = GOAL_SUPPORTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Supported By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__SUPPORTED_BY = GOAL_SUPPORTER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__IN_CONTEXT_OF = GOAL_SUPPORTER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__SUPPORTS = GOAL_SUPPORTER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_FEATURE_COUNT = GOAL_SUPPORTER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_OPERATION_COUNT = GOAL_SUPPORTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.SolutionImpl <em>Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.SolutionImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ID = GOAL_SUPPORTER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__NAME = GOAL_SUPPORTER__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__DESCRIPTION = GOAL_SUPPORTER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__STATE = GOAL_SUPPORTER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Supports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__SUPPORTS = GOAL_SUPPORTER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = GOAL_SUPPORTER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_OPERATION_COUNT = GOAL_SUPPORTER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ContextualElementImpl <em>Contextual Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ContextualElementImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getContextualElement()
	 * @generated
	 */
	int CONTEXTUAL_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__ID = GSN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__NAME = GSN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__DESCRIPTION = GSN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__STATE = GSN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT__CONTEXT_OF = GSN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Contextual Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT_FEATURE_COUNT = GSN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Contextual Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXTUAL_ELEMENT_OPERATION_COUNT = GSN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.ContextImpl
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 9;

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
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__STATE = CONTEXTUAL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__CONTEXT_OF = CONTEXTUAL_ELEMENT__CONTEXT_OF;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

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
	int ASIL = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__ID = CONTEXTUAL_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__NAME = CONTEXTUAL_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__DESCRIPTION = CONTEXTUAL_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__STATE = CONTEXTUAL_ELEMENT__STATE;

	/**
	 * The feature id for the '<em><b>Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__CONTEXT_OF = CONTEXTUAL_ELEMENT__CONTEXT_OF;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL__LEVEL = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ASIL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_FEATURE_COUNT = CONTEXTUAL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>ASIL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASIL_OPERATION_COUNT = CONTEXTUAL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.TruthState <em>Truth State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.TruthState
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getTruthState()
	 * @generated
	 */
	int TRUTH_STATE = 11;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.ASILLevel
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getASILLevel()
	 * @generated
	 */
	int ASIL_LEVEL = 12;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.nlsfung.gsn.ValidityState <em>Validity State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.nlsfung.gsn.ValidityState
	 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getValidityState()
	 * @generated
	 */
	int VALIDITY_STATE = 13;


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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.SafetyCase#getElements()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_Elements();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.GsnElement <em>Gsn Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gsn Element</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GsnElement
	 * @generated
	 */
	EClass getGsnElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.GsnElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GsnElement#getId()
	 * @see #getGsnElement()
	 * @generated
	 */
	EAttribute getGsnElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.GsnElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GsnElement#getName()
	 * @see #getGsnElement()
	 * @generated
	 */
	EAttribute getGsnElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.GsnElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GsnElement#getDescription()
	 * @see #getGsnElement()
	 * @generated
	 */
	EAttribute getGsnElement_Description();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.GoalSupporter <em>Goal Supporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Supporter</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.GoalSupporter
	 * @generated
	 */
	EClass getGoalSupporter();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.StrategySupporter <em>Strategy Supporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy Supporter</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.StrategySupporter
	 * @generated
	 */
	EClass getStrategySupporter();

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
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getSupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supported By</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Goal#getSupportedBy()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_SupportedBy();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getInContextOf <em>In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Context Of</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Goal#getInContextOf()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_InContextOf();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.nlsfung.gsn.Goal#getSupports <em>Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supports</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Goal#getSupports()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_Supports();

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
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.nlsfung.gsn.Strategy#getSupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supported By</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Strategy#getSupportedBy()
	 * @see #getStrategy()
	 * @generated
	 */
	EReference getStrategy_SupportedBy();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.nlsfung.gsn.Strategy#getInContextOf <em>In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Context Of</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Strategy#getInContextOf()
	 * @see #getStrategy()
	 * @generated
	 */
	EReference getStrategy_InContextOf();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.nlsfung.gsn.Strategy#getSupports <em>Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supports</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Strategy#getSupports()
	 * @see #getStrategy()
	 * @generated
	 */
	EReference getStrategy_Supports();

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
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.nlsfung.gsn.Solution#getSupports <em>Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supports</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Solution#getSupports()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_Supports();

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
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.nlsfung.gsn.ContextualElement#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.ContextualElement#getState()
	 * @see #getContextualElement()
	 * @generated
	 */
	EAttribute getContextualElement_State();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.se.nlsfung.gsn.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see edu.toronto.cs.se.nlsfung.gsn.Context
	 * @generated
	 */
	EClass getContext();

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
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__ELEMENTS = eINSTANCE.getSafetyCase_Elements();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.GsnElementImpl <em>Gsn Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GsnElementImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getGsnElement()
		 * @generated
		 */
		EClass GSN_ELEMENT = eINSTANCE.getGsnElement();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GSN_ELEMENT__ID = eINSTANCE.getGsnElement_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GSN_ELEMENT__NAME = eINSTANCE.getGsnElement_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GSN_ELEMENT__DESCRIPTION = eINSTANCE.getGsnElement_Description();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.GoalSupporterImpl <em>Goal Supporter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GoalSupporterImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getGoalSupporter()
		 * @generated
		 */
		EClass GOAL_SUPPORTER = eINSTANCE.getGoalSupporter();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.nlsfung.gsn.impl.StrategySupporterImpl <em>Strategy Supporter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.StrategySupporterImpl
		 * @see edu.toronto.cs.se.nlsfung.gsn.impl.GSNPackageImpl#getStrategySupporter()
		 * @generated
		 */
		EClass STRATEGY_SUPPORTER = eINSTANCE.getStrategySupporter();

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
		 * The meta object literal for the '<em><b>Supported By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL__SUPPORTED_BY = eINSTANCE.getGoal_SupportedBy();

		/**
		 * The meta object literal for the '<em><b>In Context Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL__IN_CONTEXT_OF = eINSTANCE.getGoal_InContextOf();

		/**
		 * The meta object literal for the '<em><b>Supports</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL__SUPPORTS = eINSTANCE.getGoal_Supports();

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
		 * The meta object literal for the '<em><b>Supported By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRATEGY__SUPPORTED_BY = eINSTANCE.getStrategy_SupportedBy();

		/**
		 * The meta object literal for the '<em><b>In Context Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRATEGY__IN_CONTEXT_OF = eINSTANCE.getStrategy_InContextOf();

		/**
		 * The meta object literal for the '<em><b>Supports</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRATEGY__SUPPORTS = eINSTANCE.getStrategy_Supports();

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
		 * The meta object literal for the '<em><b>Supports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__SUPPORTS = eINSTANCE.getSolution_Supports();

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
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXTUAL_ELEMENT__STATE = eINSTANCE.getContextualElement_State();

		/**
		 * The meta object literal for the '<em><b>Context Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTEXTUAL_ELEMENT__CONTEXT_OF = eINSTANCE.getContextualElement_ContextOf();

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
