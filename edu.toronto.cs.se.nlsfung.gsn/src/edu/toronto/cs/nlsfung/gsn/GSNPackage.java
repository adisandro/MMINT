/**
 */
package edu.toronto.cs.nlsfung.gsn;

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
 * @see edu.toronto.cs.nlsfung.gsn.GSNFactory
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
	GSNPackage eINSTANCE = edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.SafetyCaseImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getSafetyCase()
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
	 * The feature id for the '<em><b>Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__RELATIONSHIPS = 1;

	/**
	 * The number of structural features of the '<em>Safety Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Safety Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GsnElementImpl <em>Gsn Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnElementImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGsnElement()
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
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GsnRelationshipImpl <em>Gsn Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnRelationshipImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGsnRelationship()
	 * @generated
	 */
	int GSN_RELATIONSHIP = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSN_RELATIONSHIP__ID = 0;

	/**
	 * The number of structural features of the '<em>Gsn Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSN_RELATIONSHIP_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Gsn Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GSN_RELATIONSHIP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.GoalSupporter <em>Goal Supporter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.GoalSupporter
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalSupporter()
	 * @generated
	 */
	int GOAL_SUPPORTER = 3;

	/**
	 * The number of structural features of the '<em>Goal Supporter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Goal Supporter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.StrategySupporter <em>Strategy Supporter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.StrategySupporter
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategySupporter()
	 * @generated
	 */
	int STRATEGY_SUPPORTER = 4;

	/**
	 * The number of structural features of the '<em>Strategy Supporter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Strategy Supporter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.GoalContext <em>Goal Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.GoalContext
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalContext()
	 * @generated
	 */
	int GOAL_CONTEXT = 5;

	/**
	 * The number of structural features of the '<em>Goal Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_CONTEXT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Goal Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.StrategyContext <em>Strategy Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.StrategyContext
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategyContext()
	 * @generated
	 */
	int STRATEGY_CONTEXT = 6;

	/**
	 * The number of structural features of the '<em>Strategy Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_CONTEXT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Strategy Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GoalImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoal()
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
	int GOAL__ID = GSN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NAME = GSN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DESCRIPTION = GSN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__STATE = GSN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = GSN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = GSN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.StrategyImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategy()
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
	int STRATEGY__ID = GSN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__NAME = GSN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__DESCRIPTION = GSN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__STATE = GSN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_FEATURE_COUNT = GSN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_OPERATION_COUNT = GSN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.SolutionImpl <em>Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.SolutionImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getSolution()
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
	int SOLUTION__ID = GSN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__NAME = GSN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__DESCRIPTION = GSN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__STATE = GSN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = GSN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_OPERATION_COUNT = GSN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.ContextImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getContext()
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
	int CONTEXT__ID = GSN_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = GSN_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__DESCRIPTION = GSN_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__STATE = GSN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = GSN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = GSN_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.ASILImpl <em>ASIL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.ASILImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getASIL()
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
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.SupportedByImpl <em>Supported By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.SupportedByImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getSupportedBy()
	 * @generated
	 */
	int SUPPORTED_BY = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTED_BY__ID = GSN_RELATIONSHIP__ID;

	/**
	 * The number of structural features of the '<em>Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTED_BY_FEATURE_COUNT = GSN_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTED_BY_OPERATION_COUNT = GSN_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GoalSupportedByImpl <em>Goal Supported By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GoalSupportedByImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalSupportedBy()
	 * @generated
	 */
	int GOAL_SUPPORTED_BY = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTED_BY__ID = SUPPORTED_BY__ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTED_BY__SOURCE = SUPPORTED_BY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTED_BY__TARGET = SUPPORTED_BY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Goal Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTED_BY_FEATURE_COUNT = SUPPORTED_BY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Goal Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORTED_BY_OPERATION_COUNT = SUPPORTED_BY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.StrategySupportedByImpl <em>Strategy Supported By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.StrategySupportedByImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategySupportedBy()
	 * @generated
	 */
	int STRATEGY_SUPPORTED_BY = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTED_BY__ID = SUPPORTED_BY__ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTED_BY__SOURCE = SUPPORTED_BY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTED_BY__TARGET = SUPPORTED_BY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Strategy Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTED_BY_FEATURE_COUNT = SUPPORTED_BY_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Strategy Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORTED_BY_OPERATION_COUNT = SUPPORTED_BY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.InContextOfImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getInContextOf()
	 * @generated
	 */
	int IN_CONTEXT_OF = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF__ID = GSN_RELATIONSHIP__ID;

	/**
	 * The number of structural features of the '<em>In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF_FEATURE_COUNT = GSN_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF_OPERATION_COUNT = GSN_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GoalInContextOfImpl <em>Goal In Context Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GoalInContextOfImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalInContextOf()
	 * @generated
	 */
	int GOAL_IN_CONTEXT_OF = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_IN_CONTEXT_OF__ID = IN_CONTEXT_OF__ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_IN_CONTEXT_OF__SOURCE = IN_CONTEXT_OF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_IN_CONTEXT_OF__TARGET = IN_CONTEXT_OF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Goal In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_IN_CONTEXT_OF_FEATURE_COUNT = IN_CONTEXT_OF_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Goal In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_IN_CONTEXT_OF_OPERATION_COUNT = IN_CONTEXT_OF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.StrategyInContextOfImpl <em>Strategy In Context Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.StrategyInContextOfImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategyInContextOf()
	 * @generated
	 */
	int STRATEGY_IN_CONTEXT_OF = 17;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_IN_CONTEXT_OF__ID = IN_CONTEXT_OF__ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_IN_CONTEXT_OF__SOURCE = IN_CONTEXT_OF_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_IN_CONTEXT_OF__TARGET = IN_CONTEXT_OF_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Strategy In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_IN_CONTEXT_OF_FEATURE_COUNT = IN_CONTEXT_OF_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Strategy In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_IN_CONTEXT_OF_OPERATION_COUNT = IN_CONTEXT_OF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.TruthState <em>Truth State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.TruthState
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getTruthState()
	 * @generated
	 */
	int TRUTH_STATE = 18;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.ASILLevel
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getASILLevel()
	 * @generated
	 */
	int ASIL_LEVEL = 19;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.ValidityState <em>Validity State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getValidityState()
	 * @generated
	 */
	int VALIDITY_STATE = 20;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.SafetyCase <em>Safety Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Safety Case</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.SafetyCase
	 * @generated
	 */
	EClass getSafetyCase();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.nlsfung.gsn.SafetyCase#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.SafetyCase#getElements()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.nlsfung.gsn.SafetyCase#getRelationships <em>Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relationships</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.SafetyCase#getRelationships()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_Relationships();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.GsnElement <em>Gsn Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gsn Element</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GsnElement
	 * @generated
	 */
	EClass getGsnElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.GsnElement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GsnElement#getId()
	 * @see #getGsnElement()
	 * @generated
	 */
	EAttribute getGsnElement_Id();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.GsnElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GsnElement#getName()
	 * @see #getGsnElement()
	 * @generated
	 */
	EAttribute getGsnElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.GsnElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GsnElement#getDescription()
	 * @see #getGsnElement()
	 * @generated
	 */
	EAttribute getGsnElement_Description();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.GsnRelationship <em>Gsn Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gsn Relationship</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GsnRelationship
	 * @generated
	 */
	EClass getGsnRelationship();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.GsnRelationship#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GsnRelationship#getId()
	 * @see #getGsnRelationship()
	 * @generated
	 */
	EAttribute getGsnRelationship_Id();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.GoalSupporter <em>Goal Supporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Supporter</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GoalSupporter
	 * @generated
	 */
	EClass getGoalSupporter();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.StrategySupporter <em>Strategy Supporter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy Supporter</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.StrategySupporter
	 * @generated
	 */
	EClass getStrategySupporter();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.GoalContext <em>Goal Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Context</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GoalContext
	 * @generated
	 */
	EClass getGoalContext();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.StrategyContext <em>Strategy Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy Context</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.StrategyContext
	 * @generated
	 */
	EClass getStrategyContext();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.Goal#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Goal#getState()
	 * @see #getGoal()
	 * @generated
	 */
	EAttribute getGoal_State();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.Strategy <em>Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Strategy
	 * @generated
	 */
	EClass getStrategy();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.Strategy#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Strategy#getState()
	 * @see #getStrategy()
	 * @generated
	 */
	EAttribute getStrategy_State();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Solution
	 * @generated
	 */
	EClass getSolution();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.Solution#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Solution#getState()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_State();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.Context#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Context#getState()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_State();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.ASIL <em>ASIL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ASIL</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.ASIL
	 * @generated
	 */
	EClass getASIL();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.ASIL#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.ASIL#getLevel()
	 * @see #getASIL()
	 * @generated
	 */
	EAttribute getASIL_Level();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.SupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supported By</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.SupportedBy
	 * @generated
	 */
	EClass getSupportedBy();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.GoalSupportedBy <em>Goal Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Supported By</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GoalSupportedBy
	 * @generated
	 */
	EClass getGoalSupportedBy();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.GoalSupportedBy#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GoalSupportedBy#getSource()
	 * @see #getGoalSupportedBy()
	 * @generated
	 */
	EReference getGoalSupportedBy_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.GoalSupportedBy#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GoalSupportedBy#getTarget()
	 * @see #getGoalSupportedBy()
	 * @generated
	 */
	EReference getGoalSupportedBy_Target();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.StrategySupportedBy <em>Strategy Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy Supported By</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.StrategySupportedBy
	 * @generated
	 */
	EClass getStrategySupportedBy();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.StrategySupportedBy#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.StrategySupportedBy#getSource()
	 * @see #getStrategySupportedBy()
	 * @generated
	 */
	EReference getStrategySupportedBy_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.StrategySupportedBy#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.StrategySupportedBy#getTarget()
	 * @see #getStrategySupportedBy()
	 * @generated
	 */
	EReference getStrategySupportedBy_Target();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.InContextOf <em>In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Context Of</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.InContextOf
	 * @generated
	 */
	EClass getInContextOf();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.GoalInContextOf <em>Goal In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal In Context Of</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GoalInContextOf
	 * @generated
	 */
	EClass getGoalInContextOf();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.GoalInContextOf#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GoalInContextOf#getSource()
	 * @see #getGoalInContextOf()
	 * @generated
	 */
	EReference getGoalInContextOf_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.GoalInContextOf#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GoalInContextOf#getTarget()
	 * @see #getGoalInContextOf()
	 * @generated
	 */
	EReference getGoalInContextOf_Target();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.StrategyInContextOf <em>Strategy In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy In Context Of</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.StrategyInContextOf
	 * @generated
	 */
	EClass getStrategyInContextOf();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.StrategyInContextOf#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.StrategyInContextOf#getSource()
	 * @see #getStrategyInContextOf()
	 * @generated
	 */
	EReference getStrategyInContextOf_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.StrategyInContextOf#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.StrategyInContextOf#getTarget()
	 * @see #getStrategyInContextOf()
	 * @generated
	 */
	EReference getStrategyInContextOf_Target();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.nlsfung.gsn.TruthState <em>Truth State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Truth State</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.TruthState
	 * @generated
	 */
	EEnum getTruthState();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>ASIL Level</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.ASILLevel
	 * @generated
	 */
	EEnum getASILLevel();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.nlsfung.gsn.ValidityState <em>Validity State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Validity State</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.SafetyCaseImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getSafetyCase()
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
		 * The meta object literal for the '<em><b>Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__RELATIONSHIPS = eINSTANCE.getSafetyCase_Relationships();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GsnElementImpl <em>Gsn Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnElementImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGsnElement()
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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GsnRelationshipImpl <em>Gsn Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnRelationshipImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGsnRelationship()
		 * @generated
		 */
		EClass GSN_RELATIONSHIP = eINSTANCE.getGsnRelationship();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GSN_RELATIONSHIP__ID = eINSTANCE.getGsnRelationship_Id();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.GoalSupporter <em>Goal Supporter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.GoalSupporter
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalSupporter()
		 * @generated
		 */
		EClass GOAL_SUPPORTER = eINSTANCE.getGoalSupporter();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.StrategySupporter <em>Strategy Supporter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.StrategySupporter
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategySupporter()
		 * @generated
		 */
		EClass STRATEGY_SUPPORTER = eINSTANCE.getStrategySupporter();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.GoalContext <em>Goal Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.GoalContext
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalContext()
		 * @generated
		 */
		EClass GOAL_CONTEXT = eINSTANCE.getGoalContext();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.StrategyContext <em>Strategy Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.StrategyContext
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategyContext()
		 * @generated
		 */
		EClass STRATEGY_CONTEXT = eINSTANCE.getStrategyContext();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GoalImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoal()
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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.StrategyImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategy()
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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.SolutionImpl <em>Solution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.SolutionImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getSolution()
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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.ContextImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getContext()
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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.ASILImpl <em>ASIL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.ASILImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getASIL()
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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.SupportedByImpl <em>Supported By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.SupportedByImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getSupportedBy()
		 * @generated
		 */
		EClass SUPPORTED_BY = eINSTANCE.getSupportedBy();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GoalSupportedByImpl <em>Goal Supported By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GoalSupportedByImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalSupportedBy()
		 * @generated
		 */
		EClass GOAL_SUPPORTED_BY = eINSTANCE.getGoalSupportedBy();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL_SUPPORTED_BY__SOURCE = eINSTANCE.getGoalSupportedBy_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL_SUPPORTED_BY__TARGET = eINSTANCE.getGoalSupportedBy_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.StrategySupportedByImpl <em>Strategy Supported By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.StrategySupportedByImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategySupportedBy()
		 * @generated
		 */
		EClass STRATEGY_SUPPORTED_BY = eINSTANCE.getStrategySupportedBy();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRATEGY_SUPPORTED_BY__SOURCE = eINSTANCE.getStrategySupportedBy_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRATEGY_SUPPORTED_BY__TARGET = eINSTANCE.getStrategySupportedBy_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.InContextOfImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getInContextOf()
		 * @generated
		 */
		EClass IN_CONTEXT_OF = eINSTANCE.getInContextOf();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GoalInContextOfImpl <em>Goal In Context Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GoalInContextOfImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalInContextOf()
		 * @generated
		 */
		EClass GOAL_IN_CONTEXT_OF = eINSTANCE.getGoalInContextOf();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL_IN_CONTEXT_OF__SOURCE = eINSTANCE.getGoalInContextOf_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GOAL_IN_CONTEXT_OF__TARGET = eINSTANCE.getGoalInContextOf_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.StrategyInContextOfImpl <em>Strategy In Context Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.StrategyInContextOfImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategyInContextOf()
		 * @generated
		 */
		EClass STRATEGY_IN_CONTEXT_OF = eINSTANCE.getStrategyInContextOf();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRATEGY_IN_CONTEXT_OF__SOURCE = eINSTANCE.getStrategyInContextOf_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRATEGY_IN_CONTEXT_OF__TARGET = eINSTANCE.getStrategyInContextOf_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.TruthState <em>Truth State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.TruthState
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getTruthState()
		 * @generated
		 */
		EEnum TRUTH_STATE = eINSTANCE.getTruthState();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.ASILLevel
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getASILLevel()
		 * @generated
		 */
		EEnum ASIL_LEVEL = eINSTANCE.getASILLevel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.ValidityState <em>Validity State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getValidityState()
		 * @generated
		 */
		EEnum VALIDITY_STATE = eINSTANCE.getValidityState();

	}

} //GSNPackage
