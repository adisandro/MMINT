/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.Object#getLifeline <em>Lifeline</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getObject()
 * @model
 * @generated
 */
public interface Object extends NamedElement {
    /**
     * Returns the value of the '<em><b>Lifeline</b></em>' containment reference.
     * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getObject <em>Object</em>}'.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Lifeline</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Lifeline</em>' containment reference.
     * @see #setLifeline(Lifeline)
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getObject_Lifeline()
     * @see edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline#getObject
     * @model opposite="object" containment="true"
     * @generated
     */
    Lifeline getLifeline();

    /**
     * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Object#getLifeline <em>Lifeline</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Lifeline</em>' containment reference.
     * @see #getLifeline()
     * @generated
     */
    void setLifeline(Lifeline value);

} // Object
