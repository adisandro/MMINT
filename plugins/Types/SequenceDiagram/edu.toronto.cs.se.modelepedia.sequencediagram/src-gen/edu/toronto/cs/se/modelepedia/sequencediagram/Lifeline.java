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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lifeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getObject <em>Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsSource <em>Messages As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsTarget <em>Messages As Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getLifeline()
 * @model
 * @generated
 */
public interface Lifeline extends EObject {
    /**
     * Returns the value of the '<em><b>Object</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Object#getLifeline <em>Lifeline</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Object</em>' container reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Object</em>' container reference.
     * @see #setObject(edu.toronto.cs.se.modelepedia.sequencediagram.Object)
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getLifeline_Object()
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Object#getLifeline
     * @model opposite="lifeline" required="true" transient="false"
     * @generated
     */
    edu.toronto.cs.se.modelepedia.sequencediagram.Object getObject();

    /**
     * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getObject <em>Object</em>}' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Object</em>' container reference.
     * @see #getObject()
     * @generated
     */
    void setObject(edu.toronto.cs.se.modelepedia.sequencediagram.Object value);

    /**
     * Returns the value of the '<em><b>Messages As Source</b></em>' reference list.
     * The list contents are of type {@link edu.toronto.cs.se.modelepedia.sequencediagram.Message}.
     * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSourceLifeline <em>Source Lifeline</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Messages As Source</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Messages As Source</em>' reference list.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getLifeline_MessagesAsSource()
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSourceLifeline
     * @model opposite="sourceLifeline"
     * @generated
     */
    EList<Message> getMessagesAsSource();

    /**
     * Returns the value of the '<em><b>Messages As Target</b></em>' reference list.
     * The list contents are of type {@link edu.toronto.cs.se.modelepedia.sequencediagram.Message}.
     * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTargetLifeline <em>Target Lifeline</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Messages As Target</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Messages As Target</em>' reference list.
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getLifeline_MessagesAsTarget()
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTargetLifeline
     * @model opposite="targetLifeline"
     * @generated
     */
    EList<Message> getMessagesAsTarget();

} // Lifeline
