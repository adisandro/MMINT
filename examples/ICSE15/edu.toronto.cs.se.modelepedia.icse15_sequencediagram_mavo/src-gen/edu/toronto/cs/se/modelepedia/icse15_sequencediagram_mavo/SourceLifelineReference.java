/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mavo.MAVOReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source Lifeline Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getSourceLifelineReference()
 * @model annotation="gmf.link source='source' target='target' target.decoration='arrow' label.icon='true'"
 * @generated
 */
public interface SourceLifelineReference extends MAVOReference {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getSourceLifeline <em>Source Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Message)
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getSourceLifelineReference_Source()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getSourceLifeline
	 * @model opposite="sourceLifeline" required="true" transient="false"
	 * @generated
	 */
	Message getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Message value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getMessagesAsSource <em>Messages As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Lifeline)
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getSourceLifelineReference_Target()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getMessagesAsSource
	 * @model opposite="messagesAsSource" required="true"
	 * @generated
	 */
	Lifeline getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Lifeline value);

} // SourceLifelineReference
