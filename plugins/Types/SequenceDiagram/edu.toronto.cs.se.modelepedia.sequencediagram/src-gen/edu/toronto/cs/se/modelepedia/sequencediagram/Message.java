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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSourceLifeline <em>Source Lifeline</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTargetLifeline <em>Target Lifeline</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getMessage()
 * @model abstract="true"
 * @generated
 */
public interface Message extends NamedElement {
    /**
     * Returns the value of the '<em><b>Source Lifeline</b></em>' reference.
     * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsSource <em>Messages As Source</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Lifeline</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Lifeline</em>' reference.
     * @see #setSourceLifeline(Lifeline)
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getMessage_SourceLifeline()
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsSource
     * @model opposite="messagesAsSource" required="true"
     * @generated
     */
    Lifeline getSourceLifeline();

    /**
     * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSourceLifeline <em>Source Lifeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Lifeline</em>' reference.
     * @see #getSourceLifeline()
     * @generated
     */
    void setSourceLifeline(Lifeline value);

    /**
     * Returns the value of the '<em><b>Target Lifeline</b></em>' reference.
     * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsTarget <em>Messages As Target</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Lifeline</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Lifeline</em>' reference.
     * @see #setTargetLifeline(Lifeline)
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getMessage_TargetLifeline()
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getMessagesAsTarget
     * @model opposite="messagesAsTarget" required="true"
     * @generated
     */
    Lifeline getTargetLifeline();

    /**
     * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTargetLifeline <em>Target Lifeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Lifeline</em>' reference.
     * @see #getTargetLifeline()
     * @generated
     */
    void setTargetLifeline(Lifeline value);

} // Message
