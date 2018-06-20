/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.sequencediagram;

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
     * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.NamedElementImpl
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getNamedElement()
     * @generated
     */
    int NAMED_ELEMENT = 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT__NAME = 0;

    /**
     * The number of structural features of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>Named Element</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NAMED_ELEMENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ObjectImpl <em>Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ObjectImpl
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getObject()
     * @generated
     */
    int OBJECT = 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OBJECT__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Lifeline</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OBJECT__LIFELINE = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OBJECT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Object</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int OBJECT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl <em>Lifeline</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getLifeline()
     * @generated
     */
    int LIFELINE = 3;

    /**
     * The feature id for the '<em><b>Object</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIFELINE__OBJECT = 0;

    /**
     * The feature id for the '<em><b>Messages As Source</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIFELINE__MESSAGES_AS_SOURCE = 1;

    /**
     * The feature id for the '<em><b>Messages As Target</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIFELINE__MESSAGES_AS_TARGET = 2;

    /**
     * The number of structural features of the '<em>Lifeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIFELINE_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Lifeline</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIFELINE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl <em>Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getMessage()
     * @generated
     */
    int MESSAGE = 4;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE__NAME = NAMED_ELEMENT__NAME;

    /**
     * The feature id for the '<em><b>Source Lifeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE__SOURCE_LIFELINE = NAMED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Target Lifeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE__TARGET_LIFELINE = NAMED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Message</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Message</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int MESSAGE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.SynchronousMessageImpl <em>Synchronous Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SynchronousMessageImpl
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getSynchronousMessage()
     * @generated
     */
    int SYNCHRONOUS_MESSAGE = 5;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYNCHRONOUS_MESSAGE__NAME = MESSAGE__NAME;

    /**
     * The feature id for the '<em><b>Source Lifeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYNCHRONOUS_MESSAGE__SOURCE_LIFELINE = MESSAGE__SOURCE_LIFELINE;

    /**
     * The feature id for the '<em><b>Target Lifeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYNCHRONOUS_MESSAGE__TARGET_LIFELINE = MESSAGE__TARGET_LIFELINE;

    /**
     * The number of structural features of the '<em>Synchronous Message</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYNCHRONOUS_MESSAGE_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Synchronous Message</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYNCHRONOUS_MESSAGE_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.AsynchronousMessageImpl <em>Asynchronous Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.AsynchronousMessageImpl
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getAsynchronousMessage()
     * @generated
     */
    int ASYNCHRONOUS_MESSAGE = 6;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASYNCHRONOUS_MESSAGE__NAME = MESSAGE__NAME;

    /**
     * The feature id for the '<em><b>Source Lifeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASYNCHRONOUS_MESSAGE__SOURCE_LIFELINE = MESSAGE__SOURCE_LIFELINE;

    /**
     * The feature id for the '<em><b>Target Lifeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASYNCHRONOUS_MESSAGE__TARGET_LIFELINE = MESSAGE__TARGET_LIFELINE;

    /**
     * The number of structural features of the '<em>Asynchronous Message</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASYNCHRONOUS_MESSAGE_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Asynchronous Message</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ASYNCHRONOUS_MESSAGE_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ReturnMessageImpl <em>Return Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ReturnMessageImpl
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getReturnMessage()
     * @generated
     */
    int RETURN_MESSAGE = 7;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RETURN_MESSAGE__NAME = MESSAGE__NAME;

    /**
     * The feature id for the '<em><b>Source Lifeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RETURN_MESSAGE__SOURCE_LIFELINE = MESSAGE__SOURCE_LIFELINE;

    /**
     * The feature id for the '<em><b>Target Lifeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RETURN_MESSAGE__TARGET_LIFELINE = MESSAGE__TARGET_LIFELINE;

    /**
     * The number of structural features of the '<em>Return Message</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RETURN_MESSAGE_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

    /**
     * The number of operations of the '<em>Return Message</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RETURN_MESSAGE_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;


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
     * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.NamedElement <em>Named Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Named Element</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.NamedElement
     * @generated
     */
    EClass getNamedElement();

    /**
     * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.sequencediagram.NamedElement#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.NamedElement#getName()
     * @see #getNamedElement()
     * @generated
     */
    EAttribute getNamedElement_Name();

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
     * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline <em>Lifeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Lifeline</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline
     * @generated
     */
    EClass getLifeline();

    /**
     * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getObject <em>Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Object</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getObject()
     * @see #getLifeline()
     * @generated
     */
    EReference getLifeline_Object();

    /**
     * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsSource <em>Messages As Source</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Messages As Source</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsSource()
     * @see #getLifeline()
     * @generated
     */
    EReference getLifeline_MessagesAsSource();

    /**
     * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsTarget <em>Messages As Target</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Messages As Target</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsTarget()
     * @see #getLifeline()
     * @generated
     */
    EReference getLifeline_MessagesAsTarget();

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
     * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSourceLifeline <em>Source Lifeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source Lifeline</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSourceLifeline()
     * @see #getMessage()
     * @generated
     */
    EReference getMessage_SourceLifeline();

    /**
     * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTargetLifeline <em>Target Lifeline</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target Lifeline</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTargetLifeline()
     * @see #getMessage()
     * @generated
     */
    EReference getMessage_TargetLifeline();

    /**
     * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.SynchronousMessage <em>Synchronous Message</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Synchronous Message</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.SynchronousMessage
     * @generated
     */
    EClass getSynchronousMessage();

    /**
     * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.AsynchronousMessage <em>Asynchronous Message</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Asynchronous Message</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.AsynchronousMessage
     * @generated
     */
    EClass getAsynchronousMessage();

    /**
     * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.sequencediagram.ReturnMessage <em>Return Message</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Return Message</em>'.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.ReturnMessage
     * @generated
     */
    EClass getReturnMessage();

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
         * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.NamedElementImpl <em>Named Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.NamedElementImpl
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getNamedElement()
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
         * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ObjectImpl <em>Object</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ObjectImpl
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getObject()
         * @generated
         */
        EClass OBJECT = eINSTANCE.getObject();

        /**
         * The meta object literal for the '<em><b>Lifeline</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference OBJECT__LIFELINE = eINSTANCE.getObject_Lifeline();

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
         * The meta object literal for the '<em><b>Object</b></em>' container reference feature.
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
         * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl <em>Message</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getMessage()
         * @generated
         */
        EClass MESSAGE = eINSTANCE.getMessage();

        /**
         * The meta object literal for the '<em><b>Source Lifeline</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MESSAGE__SOURCE_LIFELINE = eINSTANCE.getMessage_SourceLifeline();

        /**
         * The meta object literal for the '<em><b>Target Lifeline</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference MESSAGE__TARGET_LIFELINE = eINSTANCE.getMessage_TargetLifeline();

        /**
         * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.SynchronousMessageImpl <em>Synchronous Message</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SynchronousMessageImpl
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getSynchronousMessage()
         * @generated
         */
        EClass SYNCHRONOUS_MESSAGE = eINSTANCE.getSynchronousMessage();

        /**
         * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.AsynchronousMessageImpl <em>Asynchronous Message</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.AsynchronousMessageImpl
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getAsynchronousMessage()
         * @generated
         */
        EClass ASYNCHRONOUS_MESSAGE = eINSTANCE.getAsynchronousMessage();

        /**
         * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ReturnMessageImpl <em>Return Message</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.ReturnMessageImpl
         * @see edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramPackageImpl#getReturnMessage()
         * @generated
         */
        EClass RETURN_MESSAGE = eINSTANCE.getReturnMessage();

    }

} //SequenceDiagramPackage
