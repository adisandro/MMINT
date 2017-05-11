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
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.GoalSupport <em>Goal Support</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.GoalSupport
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalSupport()
	 * @generated
	 */
	int GOAL_SUPPORT = 2;

	/**
	 * The number of structural features of the '<em>Goal Support</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Goal Support</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_SUPPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.StrategySupport <em>Strategy Support</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.StrategySupport
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategySupport()
	 * @generated
	 */
	int STRATEGY_SUPPORT = 3;

	/**
	 * The number of structural features of the '<em>Strategy Support</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Strategy Support</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_SUPPORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GoalImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 4;

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
	 * The feature id for the '<em><b>Supported By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__SUPPORTED_BY = GSN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__IN_CONTEXT_OF = GSN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = GSN_ELEMENT_FEATURE_COUNT + 3;

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
	int STRATEGY = 5;

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
	 * The feature id for the '<em><b>Supported By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__SUPPORTED_BY = GSN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>In Context Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__IN_CONTEXT_OF = GSN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_FEATURE_COUNT = GSN_ELEMENT_FEATURE_COUNT + 3;

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
	int SOLUTION = 6;

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
	int CONTEXT = 7;

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
	int ASIL = 8;

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
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.TruthState <em>Truth State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.TruthState
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getTruthState()
	 * @generated
	 */
	int TRUTH_STATE = 9;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.ASILLevel
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getASILLevel()
	 * @generated
	 */
	int ASIL_LEVEL = 10;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.ValidityState <em>Validity State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getValidityState()
	 * @generated
	 */
	int VALIDITY_STATE = 11;


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
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.GoalSupport <em>Goal Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Support</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.GoalSupport
	 * @generated
	 */
	EClass getGoalSupport();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.StrategySupport <em>Strategy Support</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strategy Support</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.StrategySupport
	 * @generated
	 */
	EClass getStrategySupport();

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
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.Goal#getSupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supported By</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Goal#getSupportedBy()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_SupportedBy();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.nlsfung.gsn.Goal#getInContextOf <em>In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Context Of</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Goal#getInContextOf()
	 * @see #getGoal()
	 * @generated
	 */
	EReference getGoal_InContextOf();

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
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.nlsfung.gsn.Strategy#getSupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supported By</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Strategy#getSupportedBy()
	 * @see #getStrategy()
	 * @generated
	 */
	EReference getStrategy_SupportedBy();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.nlsfung.gsn.Strategy#getInContextOf <em>In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>In Context Of</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Strategy#getInContextOf()
	 * @see #getStrategy()
	 * @generated
	 */
	EReference getStrategy_InContextOf();

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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.GoalSupport <em>Goal Support</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.GoalSupport
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getGoalSupport()
		 * @generated
		 */
		EClass GOAL_SUPPORT = eINSTANCE.getGoalSupport();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.StrategySupport <em>Strategy Support</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.StrategySupport
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GSNPackageImpl#getStrategySupport()
		 * @generated
		 */
		EClass STRATEGY_SUPPORT = eINSTANCE.getStrategySupport();

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
