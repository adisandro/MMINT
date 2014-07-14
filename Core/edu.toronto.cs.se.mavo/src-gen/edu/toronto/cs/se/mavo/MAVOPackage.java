/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mavo;

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
 * @see edu.toronto.cs.se.mavo.MAVOFactory
 * @model kind="package"
 * @generated
 */
public interface MAVOPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mavo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/MAVO";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mavo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MAVOPackage eINSTANCE = edu.toronto.cs.se.mavo.impl.MAVOPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.impl.LogicElementImpl <em>Logic Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.impl.LogicElementImpl
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getLogicElement()
	 * @generated
	 */
	int LOGIC_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_ELEMENT__FORMULA_VARIABLE = 0;

	/**
	 * The number of structural features of the '<em>Logic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Logic Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGIC_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.impl.DecisionElementImpl <em>Decision Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.impl.DecisionElementImpl
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getDecisionElement()
	 * @generated
	 */
	int DECISION_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_ELEMENT__FORMULA_VARIABLE = LOGIC_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_ELEMENT__DESCRIPTION = LOGIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decision Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_ELEMENT_FEATURE_COUNT = LOGIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Decision Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECISION_ELEMENT_OPERATION_COUNT = LOGIC_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.impl.MAVOModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.impl.MAVOModelImpl
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVOModel()
	 * @generated
	 */
	int MAVO_MODEL = 2;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_MODEL__INC = 0;

	/**
	 * The feature id for the '<em><b>Decisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_MODEL__DECISIONS = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_MODEL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.impl.MAVOElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.impl.MAVOElementImpl
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVOElement()
	 * @generated
	 */
	int MAVO_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT__FORMULA_VARIABLE = LOGIC_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT__MAY = LOGIC_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT__SET = LOGIC_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT__VAR = LOGIC_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT__ALTERNATIVES = LOGIC_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT_FEATURE_COUNT = LOGIC_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ELEMENT_OPERATION_COUNT = LOGIC_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.impl.MAVOReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.impl.MAVOReferenceImpl
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVOReference()
	 * @generated
	 */
	int MAVO_REFERENCE = 4;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE__FORMULA_VARIABLE = MAVO_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE__MAY = MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE__SET = MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE__VAR = MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE__ALTERNATIVES = MAVO_ELEMENT__ALTERNATIVES;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE_FEATURE_COUNT = MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_REFERENCE_OPERATION_COUNT = MAVO_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.impl.MAVODecisionImpl <em>Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.impl.MAVODecisionImpl
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVODecision()
	 * @generated
	 */
	int MAVO_DECISION = 5;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_DECISION__FORMULA_VARIABLE = DECISION_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_DECISION__DESCRIPTION = DECISION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Required Decisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_DECISION__REQUIRED_DECISIONS = DECISION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_DECISION_FEATURE_COUNT = DECISION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_DECISION_OPERATION_COUNT = DECISION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.impl.MAVOAlternativeImpl <em>Alternative</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.impl.MAVOAlternativeImpl
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVOAlternative()
	 * @generated
	 */
	int MAVO_ALTERNATIVE = 6;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ALTERNATIVE__FORMULA_VARIABLE = DECISION_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ALTERNATIVE__DESCRIPTION = DECISION_ELEMENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Mavo Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ALTERNATIVE__MAVO_ELEMENTS = DECISION_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Alternative</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ALTERNATIVE_FEATURE_COUNT = DECISION_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Alternative</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVO_ALTERNATIVE_OPERATION_COUNT = DECISION_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.impl.MayDecisionImpl <em>May Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.impl.MayDecisionImpl
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMayDecision()
	 * @generated
	 */
	int MAY_DECISION = 7;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAY_DECISION__FORMULA_VARIABLE = MAVO_DECISION__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAY_DECISION__DESCRIPTION = MAVO_DECISION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Required Decisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAY_DECISION__REQUIRED_DECISIONS = MAVO_DECISION__REQUIRED_DECISIONS;

	/**
	 * The feature id for the '<em><b>Logic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAY_DECISION__LOGIC = MAVO_DECISION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAY_DECISION__ALTERNATIVES = MAVO_DECISION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>May Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAY_DECISION_FEATURE_COUNT = MAVO_DECISION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>May Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAY_DECISION_OPERATION_COUNT = MAVO_DECISION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.impl.VarDecisionImpl <em>Var Decision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.impl.VarDecisionImpl
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getVarDecision()
	 * @generated
	 */
	int VAR_DECISION = 8;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECISION__FORMULA_VARIABLE = MAVO_DECISION__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECISION__DESCRIPTION = MAVO_DECISION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Required Decisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECISION__REQUIRED_DECISIONS = MAVO_DECISION__REQUIRED_DECISIONS;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECISION__DOMAIN = MAVO_DECISION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Var Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECISION_FEATURE_COUNT = MAVO_DECISION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Var Decision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_DECISION_OPERATION_COUNT = MAVO_DECISION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.mavo.MayDecisionLogic <em>May Decision Logic</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.mavo.MayDecisionLogic
	 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMayDecisionLogic()
	 * @generated
	 */
	int MAY_DECISION_LOGIC = 9;

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mavo.LogicElement <em>Logic Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logic Element</em>'.
	 * @see edu.toronto.cs.se.mavo.LogicElement
	 * @generated
	 */
	EClass getLogicElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mavo.LogicElement#getFormulaVariable <em>Formula Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Formula Variable</em>'.
	 * @see edu.toronto.cs.se.mavo.LogicElement#getFormulaVariable()
	 * @see #getLogicElement()
	 * @generated
	 */
	EAttribute getLogicElement_FormulaVariable();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mavo.DecisionElement <em>Decision Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision Element</em>'.
	 * @see edu.toronto.cs.se.mavo.DecisionElement
	 * @generated
	 */
	EClass getDecisionElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mavo.DecisionElement#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see edu.toronto.cs.se.mavo.DecisionElement#getDescription()
	 * @see #getDecisionElement()
	 * @generated
	 */
	EAttribute getDecisionElement_Description();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mavo.MAVOModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOModel
	 * @generated
	 */
	EClass getMAVOModel();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mavo.MAVOModel#isInc <em>Inc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Inc</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOModel#isInc()
	 * @see #getMAVOModel()
	 * @generated
	 */
	EAttribute getMAVOModel_Inc();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mavo.MAVOModel#getDecisions <em>Decisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Decisions</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOModel#getDecisions()
	 * @see #getMAVOModel()
	 * @generated
	 */
	EReference getMAVOModel_Decisions();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mavo.MAVOElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOElement
	 * @generated
	 */
	EClass getMAVOElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mavo.MAVOElement#isMay <em>May</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>May</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOElement#isMay()
	 * @see #getMAVOElement()
	 * @generated
	 */
	EAttribute getMAVOElement_May();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mavo.MAVOElement#isSet <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOElement#isSet()
	 * @see #getMAVOElement()
	 * @generated
	 */
	EAttribute getMAVOElement_Set();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mavo.MAVOElement#isVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOElement#isVar()
	 * @see #getMAVOElement()
	 * @generated
	 */
	EAttribute getMAVOElement_Var();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mavo.MAVOElement#getAlternatives <em>Alternatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Alternatives</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOElement#getAlternatives()
	 * @see #getMAVOElement()
	 * @generated
	 */
	EReference getMAVOElement_Alternatives();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mavo.MAVOReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOReference
	 * @generated
	 */
	EClass getMAVOReference();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mavo.MAVODecision <em>Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Decision</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVODecision
	 * @generated
	 */
	EClass getMAVODecision();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mavo.MAVODecision#getRequiredDecisions <em>Required Decisions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Decisions</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVODecision#getRequiredDecisions()
	 * @see #getMAVODecision()
	 * @generated
	 */
	EReference getMAVODecision_RequiredDecisions();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mavo.MAVOAlternative <em>Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alternative</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOAlternative
	 * @generated
	 */
	EClass getMAVOAlternative();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mavo.MAVOAlternative#getMavoElements <em>Mavo Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mavo Elements</em>'.
	 * @see edu.toronto.cs.se.mavo.MAVOAlternative#getMavoElements()
	 * @see #getMAVOAlternative()
	 * @generated
	 */
	EReference getMAVOAlternative_MavoElements();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mavo.MayDecision <em>May Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>May Decision</em>'.
	 * @see edu.toronto.cs.se.mavo.MayDecision
	 * @generated
	 */
	EClass getMayDecision();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mavo.MayDecision#getLogic <em>Logic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logic</em>'.
	 * @see edu.toronto.cs.se.mavo.MayDecision#getLogic()
	 * @see #getMayDecision()
	 * @generated
	 */
	EAttribute getMayDecision_Logic();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mavo.MayDecision#getAlternatives <em>Alternatives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Alternatives</em>'.
	 * @see edu.toronto.cs.se.mavo.MayDecision#getAlternatives()
	 * @see #getMayDecision()
	 * @generated
	 */
	EReference getMayDecision_Alternatives();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.mavo.VarDecision <em>Var Decision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Decision</em>'.
	 * @see edu.toronto.cs.se.mavo.VarDecision
	 * @generated
	 */
	EClass getVarDecision();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mavo.VarDecision#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Domain</em>'.
	 * @see edu.toronto.cs.se.mavo.VarDecision#getDomain()
	 * @see #getVarDecision()
	 * @generated
	 */
	EReference getVarDecision_Domain();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.mavo.MayDecisionLogic <em>May Decision Logic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>May Decision Logic</em>'.
	 * @see edu.toronto.cs.se.mavo.MayDecisionLogic
	 * @generated
	 */
	EEnum getMayDecisionLogic();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MAVOFactory getMAVOFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.impl.LogicElementImpl <em>Logic Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.impl.LogicElementImpl
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getLogicElement()
		 * @generated
		 */
		EClass LOGIC_ELEMENT = eINSTANCE.getLogicElement();

		/**
		 * The meta object literal for the '<em><b>Formula Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGIC_ELEMENT__FORMULA_VARIABLE = eINSTANCE.getLogicElement_FormulaVariable();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.impl.DecisionElementImpl <em>Decision Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.impl.DecisionElementImpl
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getDecisionElement()
		 * @generated
		 */
		EClass DECISION_ELEMENT = eINSTANCE.getDecisionElement();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECISION_ELEMENT__DESCRIPTION = eINSTANCE.getDecisionElement_Description();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.impl.MAVOModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.impl.MAVOModelImpl
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVOModel()
		 * @generated
		 */
		EClass MAVO_MODEL = eINSTANCE.getMAVOModel();

		/**
		 * The meta object literal for the '<em><b>Inc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVO_MODEL__INC = eINSTANCE.getMAVOModel_Inc();

		/**
		 * The meta object literal for the '<em><b>Decisions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAVO_MODEL__DECISIONS = eINSTANCE.getMAVOModel_Decisions();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.impl.MAVOElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.impl.MAVOElementImpl
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVOElement()
		 * @generated
		 */
		EClass MAVO_ELEMENT = eINSTANCE.getMAVOElement();

		/**
		 * The meta object literal for the '<em><b>May</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVO_ELEMENT__MAY = eINSTANCE.getMAVOElement_May();

		/**
		 * The meta object literal for the '<em><b>Set</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVO_ELEMENT__SET = eINSTANCE.getMAVOElement_Set();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVO_ELEMENT__VAR = eINSTANCE.getMAVOElement_Var();

		/**
		 * The meta object literal for the '<em><b>Alternatives</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAVO_ELEMENT__ALTERNATIVES = eINSTANCE.getMAVOElement_Alternatives();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.impl.MAVOReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.impl.MAVOReferenceImpl
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVOReference()
		 * @generated
		 */
		EClass MAVO_REFERENCE = eINSTANCE.getMAVOReference();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.impl.MAVODecisionImpl <em>Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.impl.MAVODecisionImpl
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVODecision()
		 * @generated
		 */
		EClass MAVO_DECISION = eINSTANCE.getMAVODecision();

		/**
		 * The meta object literal for the '<em><b>Required Decisions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAVO_DECISION__REQUIRED_DECISIONS = eINSTANCE.getMAVODecision_RequiredDecisions();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.impl.MAVOAlternativeImpl <em>Alternative</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.impl.MAVOAlternativeImpl
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMAVOAlternative()
		 * @generated
		 */
		EClass MAVO_ALTERNATIVE = eINSTANCE.getMAVOAlternative();

		/**
		 * The meta object literal for the '<em><b>Mavo Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAVO_ALTERNATIVE__MAVO_ELEMENTS = eINSTANCE.getMAVOAlternative_MavoElements();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.impl.MayDecisionImpl <em>May Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.impl.MayDecisionImpl
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMayDecision()
		 * @generated
		 */
		EClass MAY_DECISION = eINSTANCE.getMayDecision();

		/**
		 * The meta object literal for the '<em><b>Logic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAY_DECISION__LOGIC = eINSTANCE.getMayDecision_Logic();

		/**
		 * The meta object literal for the '<em><b>Alternatives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAY_DECISION__ALTERNATIVES = eINSTANCE.getMayDecision_Alternatives();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.impl.VarDecisionImpl <em>Var Decision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.impl.VarDecisionImpl
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getVarDecision()
		 * @generated
		 */
		EClass VAR_DECISION = eINSTANCE.getVarDecision();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VAR_DECISION__DOMAIN = eINSTANCE.getVarDecision_Domain();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.mavo.MayDecisionLogic <em>May Decision Logic</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.mavo.MayDecisionLogic
		 * @see edu.toronto.cs.se.mavo.impl.MAVOPackageImpl#getMayDecisionLogic()
		 * @generated
		 */
		EEnum MAY_DECISION_LOGIC = eINSTANCE.getMayDecisionLogic();

	}

} //MAVOPackage
