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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo;

import edu.toronto.cs.se.mavo.MAVOPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOFactory
 * @model kind="package"
 * @generated
 */
public interface ICSE15_SequenceDiagram_MAVOPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "icse15_sequencediagram_mavo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/ICSE15_SequenceDiagram_MAVO";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "icse15_sequencediagram_mavo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ICSE15_SequenceDiagram_MAVOPackage eINSTANCE = edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SequenceDiagramImpl <em>Sequence Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SequenceDiagramImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getSequenceDiagram()
	 * @generated
	 */
	int SEQUENCE_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Inc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM__INC = MAVOPackage.MAVO_MODEL__INC;

	/**
	 * The feature id for the '<em><b>Decisions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM__DECISIONS = MAVOPackage.MAVO_MODEL__DECISIONS;

	/**
	 * The feature id for the '<em><b>Lifelines</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM__LIFELINES = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM__OBJECTS = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM__CLASSES = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM__MESSAGES = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sequence Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_FEATURE_COUNT = MAVOPackage.MAVO_MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Sequence Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_OPERATION_COUNT = MAVOPackage.MAVO_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.NamedElementImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__FORMULA_VARIABLE = MAVOPackage.MAVO_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__MAY = MAVOPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__SET = MAVOPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__VAR = MAVOPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ALTERNATIVES = MAVOPackage.MAVO_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = MAVOPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.LifelineImpl <em>Lifeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.LifelineImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getLifeline()
	 * @generated
	 */
	int LIFELINE = 2;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__FORMULA_VARIABLE = MAVOPackage.MAVO_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__MAY = MAVOPackage.MAVO_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__SET = MAVOPackage.MAVO_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__VAR = MAVOPackage.MAVO_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__ALTERNATIVES = MAVOPackage.MAVO_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__OBJECT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Messages As Source</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__MESSAGES_AS_SOURCE = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Messages As Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__MESSAGES_AS_TARGET = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Lifeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_FEATURE_COUNT = MAVOPackage.MAVO_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Lifeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_OPERATION_COUNT = MAVOPackage.MAVO_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 3;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__FORMULA_VARIABLE = NAMED_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__MAY = NAMED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__SET = NAMED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__VAR = NAMED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__ALTERNATIVES = NAMED_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Class</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__CLASS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Lifelines</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__LIFELINES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ClassImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 4;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__FORMULA_VARIABLE = NAMED_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__MAY = NAMED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SET = NAMED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__VAR = NAMED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ALTERNATIVES = NAMED_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OPERATIONS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OBJECTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 5;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__FORMULA_VARIABLE = NAMED_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__MAY = NAMED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__SET = NAMED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__VAR = NAMED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__ALTERNATIVES = NAMED_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__MESSAGES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.MessageImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 6;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__FORMULA_VARIABLE = NAMED_ELEMENT__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__MAY = NAMED_ELEMENT__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SET = NAMED_ELEMENT__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__VAR = NAMED_ELEMENT__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__ALTERNATIVES = NAMED_ELEMENT__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__OPERATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Lifeline</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SOURCE_LIFELINE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Lifeline</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TARGET_LIFELINE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getObjectReference()
	 * @generated
	 */
	int OBJECT_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__FORMULA_VARIABLE = MAVOPackage.MAVO_REFERENCE__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__MAY = MAVOPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__SET = MAVOPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__VAR = MAVOPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__ALTERNATIVES = MAVOPackage.MAVO_REFERENCE__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__SOURCE = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE__TARGET = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_FEATURE_COUNT = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Object Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_REFERENCE_OPERATION_COUNT = MAVOPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ClassReferenceImpl <em>Class Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ClassReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getClassReference()
	 * @generated
	 */
	int CLASS_REFERENCE = 8;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REFERENCE__FORMULA_VARIABLE = MAVOPackage.MAVO_REFERENCE__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REFERENCE__MAY = MAVOPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REFERENCE__SET = MAVOPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REFERENCE__VAR = MAVOPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REFERENCE__ALTERNATIVES = MAVOPackage.MAVO_REFERENCE__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REFERENCE__SOURCE = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REFERENCE__TARGET = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Class Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REFERENCE_FEATURE_COUNT = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Class Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_REFERENCE_OPERATION_COUNT = MAVOPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationReferenceImpl <em>Operation Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getOperationReference()
	 * @generated
	 */
	int OPERATION_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REFERENCE__FORMULA_VARIABLE = MAVOPackage.MAVO_REFERENCE__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REFERENCE__MAY = MAVOPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REFERENCE__SET = MAVOPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REFERENCE__VAR = MAVOPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REFERENCE__ALTERNATIVES = MAVOPackage.MAVO_REFERENCE__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REFERENCE__SOURCE = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REFERENCE__TARGET = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REFERENCE_FEATURE_COUNT = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operation Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REFERENCE_OPERATION_COUNT = MAVOPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SourceLifelineReferenceImpl <em>Source Lifeline Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SourceLifelineReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getSourceLifelineReference()
	 * @generated
	 */
	int SOURCE_LIFELINE_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LIFELINE_REFERENCE__FORMULA_VARIABLE = MAVOPackage.MAVO_REFERENCE__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LIFELINE_REFERENCE__MAY = MAVOPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LIFELINE_REFERENCE__SET = MAVOPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LIFELINE_REFERENCE__VAR = MAVOPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LIFELINE_REFERENCE__ALTERNATIVES = MAVOPackage.MAVO_REFERENCE__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LIFELINE_REFERENCE__SOURCE = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LIFELINE_REFERENCE__TARGET = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Source Lifeline Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LIFELINE_REFERENCE_FEATURE_COUNT = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Source Lifeline Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_LIFELINE_REFERENCE_OPERATION_COUNT = MAVOPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.TargetLifelineReferenceImpl <em>Target Lifeline Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.TargetLifelineReferenceImpl
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getTargetLifelineReference()
	 * @generated
	 */
	int TARGET_LIFELINE_REFERENCE = 11;

	/**
	 * The feature id for the '<em><b>Formula Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LIFELINE_REFERENCE__FORMULA_VARIABLE = MAVOPackage.MAVO_REFERENCE__FORMULA_VARIABLE;

	/**
	 * The feature id for the '<em><b>May</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LIFELINE_REFERENCE__MAY = MAVOPackage.MAVO_REFERENCE__MAY;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LIFELINE_REFERENCE__SET = MAVOPackage.MAVO_REFERENCE__SET;

	/**
	 * The feature id for the '<em><b>Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LIFELINE_REFERENCE__VAR = MAVOPackage.MAVO_REFERENCE__VAR;

	/**
	 * The feature id for the '<em><b>Alternatives</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LIFELINE_REFERENCE__ALTERNATIVES = MAVOPackage.MAVO_REFERENCE__ALTERNATIVES;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LIFELINE_REFERENCE__SOURCE = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LIFELINE_REFERENCE__TARGET = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Target Lifeline Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LIFELINE_REFERENCE_FEATURE_COUNT = MAVOPackage.MAVO_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Target Lifeline Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_LIFELINE_REFERENCE_OPERATION_COUNT = MAVOPackage.MAVO_REFERENCE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram <em>Sequence Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Diagram</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram
	 * @generated
	 */
	EClass getSequenceDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram#getLifelines <em>Lifelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lifelines</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram#getLifelines()
	 * @see #getSequenceDiagram()
	 * @generated
	 */
	EReference getSequenceDiagram_Lifelines();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Objects</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram#getObjects()
	 * @see #getSequenceDiagram()
	 * @generated
	 */
	EReference getSequenceDiagram_Objects();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram#getClasses()
	 * @see #getSequenceDiagram()
	 * @generated
	 */
	EReference getSequenceDiagram_Classes();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Messages</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram#getMessages()
	 * @see #getSequenceDiagram()
	 * @generated
	 */
	EReference getSequenceDiagram_Messages();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lifeline</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline
	 * @generated
	 */
	EClass getLifeline();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Object</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getObject()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_Object();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getMessagesAsSource <em>Messages As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Messages As Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getMessagesAsSource()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_MessagesAsSource();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getMessagesAsTarget <em>Messages As Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Messages As Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getMessagesAsTarget()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_MessagesAsTarget();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Object
	 * @generated
	 */
	EClass getObject();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Object#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Object#getClass_()
	 * @see #getObject()
	 * @generated
	 */
	EReference getObject_Class();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Object#getLifelines <em>Lifelines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Lifelines</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Object#getLifelines()
	 * @see #getObject()
	 * @generated
	 */
	EReference getObject_Lifelines();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class#getOperations()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Operations();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Objects</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class#getObjects()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Objects();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Messages</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation#getMessages()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Messages();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operation</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getOperation()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getSourceLifeline <em>Source Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source Lifeline</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getSourceLifeline()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_SourceLifeline();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getTargetLifeline <em>Target Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Lifeline</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getTargetLifeline()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_TargetLifeline();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ObjectReference <em>Object Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ObjectReference
	 * @generated
	 */
	EClass getObjectReference();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ObjectReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ObjectReference#getSource()
	 * @see #getObjectReference()
	 * @generated
	 */
	EReference getObjectReference_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ObjectReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ObjectReference#getTarget()
	 * @see #getObjectReference()
	 * @generated
	 */
	EReference getObjectReference_Target();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference <em>Class Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference
	 * @generated
	 */
	EClass getClassReference();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference#getSource()
	 * @see #getClassReference()
	 * @generated
	 */
	EReference getClassReference_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference#getTarget()
	 * @see #getClassReference()
	 * @generated
	 */
	EReference getClassReference_Target();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference <em>Operation Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference
	 * @generated
	 */
	EClass getOperationReference();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference#getSource()
	 * @see #getOperationReference()
	 * @generated
	 */
	EReference getOperationReference_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference#getTarget()
	 * @see #getOperationReference()
	 * @generated
	 */
	EReference getOperationReference_Target();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference <em>Source Lifeline Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Lifeline Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference
	 * @generated
	 */
	EClass getSourceLifelineReference();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getSource()
	 * @see #getSourceLifelineReference()
	 * @generated
	 */
	EReference getSourceLifelineReference_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getTarget()
	 * @see #getSourceLifelineReference()
	 * @generated
	 */
	EReference getSourceLifelineReference_Target();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference <em>Target Lifeline Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Lifeline Reference</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference
	 * @generated
	 */
	EClass getTargetLifelineReference();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference#getSource()
	 * @see #getTargetLifelineReference()
	 * @generated
	 */
	EReference getTargetLifelineReference_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference#getTarget()
	 * @see #getTargetLifelineReference()
	 * @generated
	 */
	EReference getTargetLifelineReference_Target();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ICSE15_SequenceDiagram_MAVOFactory getICSE15_SequenceDiagram_MAVOFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SequenceDiagramImpl <em>Sequence Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SequenceDiagramImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getSequenceDiagram()
		 * @generated
		 */
		EClass SEQUENCE_DIAGRAM = eINSTANCE.getSequenceDiagram();

		/**
		 * The meta object literal for the '<em><b>Lifelines</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_DIAGRAM__LIFELINES = eINSTANCE.getSequenceDiagram_Lifelines();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_DIAGRAM__OBJECTS = eINSTANCE.getSequenceDiagram_Objects();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_DIAGRAM__CLASSES = eINSTANCE.getSequenceDiagram_Classes();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_DIAGRAM__MESSAGES = eINSTANCE.getSequenceDiagram_Messages();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.NamedElementImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.LifelineImpl <em>Lifeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.LifelineImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getLifeline()
		 * @generated
		 */
		EClass LIFELINE = eINSTANCE.getLifeline();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__OBJECT = eINSTANCE.getLifeline_Object();

		/**
		 * The meta object literal for the '<em><b>Messages As Source</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__MESSAGES_AS_SOURCE = eINSTANCE.getLifeline_MessagesAsSource();

		/**
		 * The meta object literal for the '<em><b>Messages As Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__MESSAGES_AS_TARGET = eINSTANCE.getLifeline_MessagesAsTarget();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getObject()
		 * @generated
		 */
		EClass OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT__CLASS = eINSTANCE.getObject_Class();

		/**
		 * The meta object literal for the '<em><b>Lifelines</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT__LIFELINES = eINSTANCE.getObject_Lifelines();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ClassImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OPERATIONS = eINSTANCE.getClass_Operations();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OBJECTS = eINSTANCE.getClass_Objects();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__MESSAGES = eINSTANCE.getOperation_Messages();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.MessageImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__OPERATION = eINSTANCE.getMessage_Operation();

		/**
		 * The meta object literal for the '<em><b>Source Lifeline</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__SOURCE_LIFELINE = eINSTANCE.getMessage_SourceLifeline();

		/**
		 * The meta object literal for the '<em><b>Target Lifeline</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__TARGET_LIFELINE = eINSTANCE.getMessage_TargetLifeline();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectReferenceImpl <em>Object Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getObjectReference()
		 * @generated
		 */
		EClass OBJECT_REFERENCE = eINSTANCE.getObjectReference();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REFERENCE__SOURCE = eINSTANCE.getObjectReference_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_REFERENCE__TARGET = eINSTANCE.getObjectReference_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ClassReferenceImpl <em>Class Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ClassReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getClassReference()
		 * @generated
		 */
		EClass CLASS_REFERENCE = eINSTANCE.getClassReference();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_REFERENCE__SOURCE = eINSTANCE.getClassReference_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_REFERENCE__TARGET = eINSTANCE.getClassReference_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationReferenceImpl <em>Operation Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getOperationReference()
		 * @generated
		 */
		EClass OPERATION_REFERENCE = eINSTANCE.getOperationReference();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REFERENCE__SOURCE = eINSTANCE.getOperationReference_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REFERENCE__TARGET = eINSTANCE.getOperationReference_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SourceLifelineReferenceImpl <em>Source Lifeline Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SourceLifelineReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getSourceLifelineReference()
		 * @generated
		 */
		EClass SOURCE_LIFELINE_REFERENCE = eINSTANCE.getSourceLifelineReference();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_LIFELINE_REFERENCE__SOURCE = eINSTANCE.getSourceLifelineReference_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_LIFELINE_REFERENCE__TARGET = eINSTANCE.getSourceLifelineReference_Target();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.TargetLifelineReferenceImpl <em>Target Lifeline Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.TargetLifelineReferenceImpl
		 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ICSE15_SequenceDiagram_MAVOPackageImpl#getTargetLifelineReference()
		 * @generated
		 */
		EClass TARGET_LIFELINE_REFERENCE = eINSTANCE.getTargetLifelineReference();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_LIFELINE_REFERENCE__SOURCE = eINSTANCE.getTargetLifelineReference_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_LIFELINE_REFERENCE__TARGET = eINSTANCE.getTargetLifelineReference_Target();

	}

} //ICSE15_SequenceDiagram_MAVOPackage
