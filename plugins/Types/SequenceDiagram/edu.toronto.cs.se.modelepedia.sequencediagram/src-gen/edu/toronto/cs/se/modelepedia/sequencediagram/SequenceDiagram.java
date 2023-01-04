/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram#getObjects <em>Objects</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram#getMessages <em>Messages</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getSequenceDiagram()
 * @model
 * @generated
 */
public interface SequenceDiagram extends EObject {
	/**
	 * Returns the value of the '<em><b>Objects</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.sequencediagram.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Objects</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getSequenceDiagram_Objects()
	 * @model containment="true"
	 * @generated
	 */
	EList<edu.toronto.cs.se.modelepedia.sequencediagram.Object> getObjects();

	/**
	 * Returns the value of the '<em><b>Messages</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.sequencediagram.Message}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getSequenceDiagram_Messages()
	 * @model containment="true"
	 * @generated
	 */
	EList<Message> getMessages();

} // SequenceDiagram
