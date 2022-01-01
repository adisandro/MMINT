/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * A representation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getOperation <em>Operation</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getSourceLifeline <em>Source Lifeline</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message#getTargetLifeline <em>Target Lifeline</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getMessage()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Message extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getMessage_Attributes()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<AttributeReference> getAttributes();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getMessage_Operation()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference#getSource
	 * @model opposite="source" containment="true" required="true"
	 * @generated
	 */
	EList<OperationReference> getOperation();

	/**
	 * Returns the value of the '<em><b>Source Lifeline</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Lifeline</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Lifeline</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getMessage_SourceLifeline()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference#getSource
	 * @model opposite="source" containment="true" required="true"
	 * @generated
	 */
	EList<SourceLifelineReference> getSourceLifeline();

	/**
	 * Returns the value of the '<em><b>Target Lifeline</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Lifeline</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Lifeline</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage#getMessage_TargetLifeline()
	 * @see edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference#getSource
	 * @model opposite="source" containment="true" required="true"
	 * @generated
	 */
	EList<TargetLifelineReference> getTargetLifeline();

} // Message
