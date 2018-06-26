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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lifeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getClass_ <em>Class</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getMessagesAsSource <em>Messages As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline#getMessagesAsTarget <em>Messages As Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getLifeline()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Lifeline extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getLifeline_Class()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference#getSource
	 * @model opposite="source" containment="true" required="true"
	 * @generated
	 */
	EList<ClassReference> getClass_();

	/**
	 * Returns the value of the '<em><b>Messages As Source</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages As Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages As Source</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getLifeline_MessagesAsSource()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<SourceLifelineReference> getMessagesAsSource();

	/**
	 * Returns the value of the '<em><b>Messages As Target</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages As Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages As Target</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getLifeline_MessagesAsTarget()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<TargetLifelineReference> getMessagesAsTarget();

} // Lifeline
