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
 * @see edu.toronto.cs.nlsfung.gsn.GsnFactory
 * @model kind="package"
 * @generated
 */
public interface GsnPackage extends EPackage {
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
	GsnPackage eINSTANCE = edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.SafetyCaseImpl <em>Safety Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.SafetyCaseImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getSafetyCase()
	 * @generated
	 */
	int SAFETY_CASE = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__NODES = 0;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAFETY_CASE__LINKS = 1;

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
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.BasicNodeImpl <em>Basic Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.BasicNodeImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getBasicNode()
	 * @generated
	 */
	int BASIC_NODE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_NODE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_NODE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_NODE__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Basic Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_NODE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Basic Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.BasicLinkImpl <em>Basic Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.BasicLinkImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getBasicLink()
	 * @generated
	 */
	int BASIC_LINK = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_LINK__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_LINK__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_LINK__ID = 2;

	/**
	 * The number of structural features of the '<em>Basic Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_LINK_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Basic Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_LINK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GoalImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__ID = BASIC_NODE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__NAME = BASIC_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__DESCRIPTION = BASIC_NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL__STATE = BASIC_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = BASIC_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = BASIC_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.StrategyImpl <em>Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.StrategyImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getStrategy()
	 * @generated
	 */
	int STRATEGY = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__ID = BASIC_NODE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__NAME = BASIC_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__DESCRIPTION = BASIC_NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY__STATE = BASIC_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_FEATURE_COUNT = BASIC_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRATEGY_OPERATION_COUNT = BASIC_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.EvidenceImpl <em>Evidence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.EvidenceImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getEvidence()
	 * @generated
	 */
	int EVIDENCE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIDENCE__ID = BASIC_NODE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIDENCE__NAME = BASIC_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIDENCE__DESCRIPTION = BASIC_NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIDENCE__STATE = BASIC_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Evidence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIDENCE_FEATURE_COUNT = BASIC_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Evidence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVIDENCE_OPERATION_COUNT = BASIC_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.ContextImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__ID = BASIC_NODE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__NAME = BASIC_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__DESCRIPTION = BASIC_NODE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__STATE = BASIC_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = BASIC_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = BASIC_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.ASILImpl <em>ASIL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.ASILImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getASIL()
	 * @generated
	 */
	int ASIL = 7;

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
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.InContextOfImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getInContextOf()
	 * @generated
	 */
	int IN_CONTEXT_OF = 8;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF__SOURCE = BASIC_LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF__TARGET = BASIC_LINK__TARGET;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF__ID = BASIC_LINK__ID;

	/**
	 * The number of structural features of the '<em>In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF_FEATURE_COUNT = BASIC_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>In Context Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONTEXT_OF_OPERATION_COUNT = BASIC_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.impl.IsSupportedByImpl <em>Is Supported By</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.impl.IsSupportedByImpl
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getIsSupportedBy()
	 * @generated
	 */
	int IS_SUPPORTED_BY = 9;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SUPPORTED_BY__SOURCE = BASIC_LINK__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SUPPORTED_BY__TARGET = BASIC_LINK__TARGET;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SUPPORTED_BY__ID = BASIC_LINK__ID;

	/**
	 * The number of structural features of the '<em>Is Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SUPPORTED_BY_FEATURE_COUNT = BASIC_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Is Supported By</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IS_SUPPORTED_BY_OPERATION_COUNT = BASIC_LINK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.TruthState <em>Truth State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.TruthState
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getTruthState()
	 * @generated
	 */
	int TRUTH_STATE = 10;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.ASILLevel
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getASILLevel()
	 * @generated
	 */
	int ASIL_LEVEL = 11;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.nlsfung.gsn.ValidityState <em>Validity State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
	 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getValidityState()
	 * @generated
	 */
	int VALIDITY_STATE = 12;


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
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.nlsfung.gsn.SafetyCase#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.SafetyCase#getNodes()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_Nodes();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.nlsfung.gsn.SafetyCase#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Links</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.SafetyCase#getLinks()
	 * @see #getSafetyCase()
	 * @generated
	 */
	EReference getSafetyCase_Links();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.BasicNode <em>Basic Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Node</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.BasicNode
	 * @generated
	 */
	EClass getBasicNode();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.BasicNode#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.BasicNode#getId()
	 * @see #getBasicNode()
	 * @generated
	 */
	EAttribute getBasicNode_Id();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.BasicNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.BasicNode#getName()
	 * @see #getBasicNode()
	 * @generated
	 */
	EAttribute getBasicNode_Name();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.BasicNode#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.BasicNode#getDescription()
	 * @see #getBasicNode()
	 * @generated
	 */
	EAttribute getBasicNode_Description();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.BasicLink <em>Basic Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Link</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.BasicLink
	 * @generated
	 */
	EClass getBasicLink();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.BasicLink#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.BasicLink#getSource()
	 * @see #getBasicLink()
	 * @generated
	 */
	EReference getBasicLink_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.nlsfung.gsn.BasicLink#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.BasicLink#getTarget()
	 * @see #getBasicLink()
	 * @generated
	 */
	EReference getBasicLink_Target();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.BasicLink#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.BasicLink#getId()
	 * @see #getBasicLink()
	 * @generated
	 */
	EAttribute getBasicLink_Id();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.Evidence <em>Evidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Evidence</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Evidence
	 * @generated
	 */
	EClass getEvidence();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.nlsfung.gsn.Evidence#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.Evidence#getState()
	 * @see #getEvidence()
	 * @generated
	 */
	EAttribute getEvidence_State();

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
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.InContextOf <em>In Context Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Context Of</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.InContextOf
	 * @generated
	 */
	EClass getInContextOf();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.nlsfung.gsn.IsSupportedBy <em>Is Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Is Supported By</em>'.
	 * @see edu.toronto.cs.nlsfung.gsn.IsSupportedBy
	 * @generated
	 */
	EClass getIsSupportedBy();

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
	GsnFactory getGsnFactory();

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
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getSafetyCase()
		 * @generated
		 */
		EClass SAFETY_CASE = eINSTANCE.getSafetyCase();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__NODES = eINSTANCE.getSafetyCase_Nodes();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAFETY_CASE__LINKS = eINSTANCE.getSafetyCase_Links();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.BasicNodeImpl <em>Basic Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.BasicNodeImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getBasicNode()
		 * @generated
		 */
		EClass BASIC_NODE = eINSTANCE.getBasicNode();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_NODE__ID = eINSTANCE.getBasicNode_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_NODE__NAME = eINSTANCE.getBasicNode_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_NODE__DESCRIPTION = eINSTANCE.getBasicNode_Description();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.BasicLinkImpl <em>Basic Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.BasicLinkImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getBasicLink()
		 * @generated
		 */
		EClass BASIC_LINK = eINSTANCE.getBasicLink();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_LINK__SOURCE = eINSTANCE.getBasicLink_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_LINK__TARGET = eINSTANCE.getBasicLink_Target();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_LINK__ID = eINSTANCE.getBasicLink_Id();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GoalImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getGoal()
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
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getStrategy()
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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.EvidenceImpl <em>Evidence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.EvidenceImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getEvidence()
		 * @generated
		 */
		EClass EVIDENCE = eINSTANCE.getEvidence();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVIDENCE__STATE = eINSTANCE.getEvidence_State();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.ContextImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getContext()
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
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getASIL()
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
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.InContextOfImpl <em>In Context Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.InContextOfImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getInContextOf()
		 * @generated
		 */
		EClass IN_CONTEXT_OF = eINSTANCE.getInContextOf();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.impl.IsSupportedByImpl <em>Is Supported By</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.impl.IsSupportedByImpl
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getIsSupportedBy()
		 * @generated
		 */
		EClass IS_SUPPORTED_BY = eINSTANCE.getIsSupportedBy();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.TruthState <em>Truth State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.TruthState
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getTruthState()
		 * @generated
		 */
		EEnum TRUTH_STATE = eINSTANCE.getTruthState();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.ASILLevel <em>ASIL Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.ASILLevel
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getASILLevel()
		 * @generated
		 */
		EEnum ASIL_LEVEL = eINSTANCE.getASILLevel();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.nlsfung.gsn.ValidityState <em>Validity State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.nlsfung.gsn.ValidityState
		 * @see edu.toronto.cs.nlsfung.gsn.impl.GsnPackageImpl#getValidityState()
		 * @generated
		 */
		EEnum VALIDITY_STATE = eINSTANCE.getValidityState();

	}

} //GsnPackage
