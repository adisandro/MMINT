/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.sequencediagram;

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
 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramFactory
 * @model kind="package"
 * @generated
 */
public interface SequenceDiagramPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sequencediagram";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/SequenceDiagram";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sequencediagram";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SequenceDiagramPackage eINSTANCE = edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramImpl <em>Sequence Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramImpl
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getSequenceDiagram()
	 * @generated
	 */
	int SEQUENCE_DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM__OBJECTS = 0;

	/**
	 * The feature id for the '<em><b>Messages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM__MESSAGES = 1;

	/**
	 * The number of structural features of the '<em>Sequence Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Sequence Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_DIAGRAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ObjectImpl
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__LIFELINE = 1;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActorImpl
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__LIFELINE = OBJECT__LIFELINE;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_OPERATION_COUNT = OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ComponentImpl
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Lifeline</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__LIFELINE = OBJECT__LIFELINE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__TYPE = OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl <em>Lifeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getLifeline()
	 * @generated
	 */
	int LIFELINE = 4;

	/**
	 * The feature id for the '<em><b>Activation Boxes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE__ACTIVATION_BOXES = 0;

	/**
	 * The number of structural features of the '<em>Lifeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Lifeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIFELINE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActivationBoxImpl <em>Activation Box</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActivationBoxImpl
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getActivationBox()
	 * @generated
	 */
	int ACTIVATION_BOX = 5;

	/**
	 * The feature id for the '<em><b>Activation Boxes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION_BOX__ACTIVATION_BOXES = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION_BOX__CONDITION = 1;

	/**
	 * The number of structural features of the '<em>Activation Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION_BOX_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Activation Box</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVATION_BOX_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__TARGET = 2;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__GUARD = 3;

	/**
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__CONTENT = 4;

	/**
	 * The feature id for the '<em><b>Predecessor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__PREDECESSOR = 5;

	/**
	 * The feature id for the '<em><b>Successor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SUCCESSOR = 6;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.MessageType <em>Message Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.MessageType
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getMessageType()
	 * @generated
	 */
	int MESSAGE_TYPE = 7;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram <em>Sequence Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Diagram</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram
	 * @generated
	 */
	EClass getSequenceDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram#getObjects <em>Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Objects</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram#getObjects()
	 * @see #getSequenceDiagram()
	 * @generated
	 */
	EReference getSequenceDiagram_Objects();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram#getMessages <em>Messages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Messages</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram#getMessages()
	 * @see #getSequenceDiagram()
	 * @generated
	 */
	EReference getSequenceDiagram_Messages();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Object
	 * @generated
	 */
	EClass getObject();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Object#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Object#getName()
	 * @see #getObject()
	 * @generated
	 */
	EAttribute getObject_Name();

	/**
	 * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Object#getLifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Lifeline</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Object#getLifeline()
	 * @see #getObject()
	 * @generated
	 */
	EReference getObject_Lifeline();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Component#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Component#getType()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Type();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline <em>Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lifeline</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline
	 * @generated
	 */
	EClass getLifeline();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getActivationBoxes <em>Activation Boxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Activation Boxes</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getActivationBoxes()
	 * @see #getLifeline()
	 * @generated
	 */
	EReference getLifeline_ActivationBoxes();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox <em>Activation Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activation Box</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox
	 * @generated
	 */
	EClass getActivationBox();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getActivationBoxes <em>Activation Boxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Activation Boxes</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getActivationBoxes()
	 * @see #getActivationBox()
	 * @generated
	 */
	EReference getActivationBox_ActivationBoxes();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getCondition()
	 * @see #getActivationBox()
	 * @generated
	 */
	EAttribute getActivationBox_Condition();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getType()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Type();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSource()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Source();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTarget()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Target();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Guard</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getGuard()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Guard();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getContent()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_Content();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getPredecessor <em>Predecessor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predecessor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getPredecessor()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Predecessor();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSuccessor <em>Successor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Successor</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSuccessor()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Successor();

	/**
	 * Returns the meta object for enum '{@link edu.toronto.cs.se.modelepedia.sequencediagram.MessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Message Type</em>'.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.MessageType
	 * @generated
	 */
	EEnum getMessageType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SequenceDiagramFactory getSequenceDiagramFactory();

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
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramImpl <em>Sequence Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramImpl
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getSequenceDiagram()
		 * @generated
		 */
		EClass SEQUENCE_DIAGRAM = eINSTANCE.getSequenceDiagram();

		/**
		 * The meta object literal for the '<em><b>Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_DIAGRAM__OBJECTS = eINSTANCE.getSequenceDiagram_Objects();

		/**
		 * The meta object literal for the '<em><b>Messages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_DIAGRAM__MESSAGES = eINSTANCE.getSequenceDiagram_Messages();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ObjectImpl
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getObject()
		 * @generated
		 */
		EClass OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OBJECT__NAME = eINSTANCE.getObject_Name();

		/**
		 * The meta object literal for the '<em><b>Lifeline</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT__LIFELINE = eINSTANCE.getObject_Lifeline();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActorImpl
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ComponentImpl
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__TYPE = eINSTANCE.getComponent_Type();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl <em>Lifeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getLifeline()
		 * @generated
		 */
		EClass LIFELINE = eINSTANCE.getLifeline();

		/**
		 * The meta object literal for the '<em><b>Activation Boxes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIFELINE__ACTIVATION_BOXES = eINSTANCE.getLifeline_ActivationBoxes();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActivationBoxImpl <em>Activation Box</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActivationBoxImpl
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getActivationBox()
		 * @generated
		 */
		EClass ACTIVATION_BOX = eINSTANCE.getActivationBox();

		/**
		 * The meta object literal for the '<em><b>Activation Boxes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVATION_BOX__ACTIVATION_BOXES = eINSTANCE.getActivationBox_ActivationBoxes();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVATION_BOX__CONDITION = eINSTANCE.getActivationBox_Condition();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__TYPE = eINSTANCE.getMessage_Type();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__SOURCE = eINSTANCE.getMessage_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__TARGET = eINSTANCE.getMessage_Target();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__GUARD = eINSTANCE.getMessage_Guard();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__CONTENT = eINSTANCE.getMessage_Content();

		/**
		 * The meta object literal for the '<em><b>Predecessor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__PREDECESSOR = eINSTANCE.getMessage_Predecessor();

		/**
		 * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__SUCCESSOR = eINSTANCE.getMessage_Successor();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.MessageType <em>Message Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.MessageType
		 * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getMessageType()
		 * @generated
		 */
		EEnum MESSAGE_TYPE = eINSTANCE.getMessageType();

	}

} //SequenceDiagramPackage
