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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activation Box</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getActivationBoxes <em>Activation Boxes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getMessagesAsSource <em>Messages As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getMessagesAsTarget <em>Messages As Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getOwnerActivationBox <em>Owner Activation Box</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getActivationBox()
 * @model
 * @generated
 */
public interface ActivationBox extends EObject {
	/**
	 * Returns the value of the '<em><b>Activation Boxes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getOwnerActivationBox <em>Owner Activation Box</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activation Boxes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activation Boxes</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getActivationBox_ActivationBoxes()
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getOwnerActivationBox
	 * @model opposite="ownerActivationBox" containment="true"
	 * @generated
	 */
	EList<ActivationBox> getActivationBoxes();

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' attribute.
	 * @see #setCondition(String)
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getActivationBox_Condition()
	 * @model
	 * @generated
	 */
	String getCondition();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getCondition <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' attribute.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(String value);

	/**
	 * Returns the value of the '<em><b>Messages As Source</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.sequencediagram.Message}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages As Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages As Source</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getActivationBox_MessagesAsSource()
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Message> getMessagesAsSource();

	/**
	 * Returns the value of the '<em><b>Messages As Target</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.sequencediagram.Message}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Messages As Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Messages As Target</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getActivationBox_MessagesAsTarget()
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.Message#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Message> getMessagesAsTarget();

	/**
	 * Returns the value of the '<em><b>Owner Activation Box</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getActivationBoxes <em>Activation Boxes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Activation Box</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Activation Box</em>' container reference.
	 * @see #setOwnerActivationBox(ActivationBox)
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getActivationBox_OwnerActivationBox()
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getActivationBoxes
	 * @model opposite="activationBoxes" transient="false"
	 * @generated
	 */
	ActivationBox getOwnerActivationBox();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox#getOwnerActivationBox <em>Owner Activation Box</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Activation Box</em>' container reference.
	 * @see #getOwnerActivationBox()
	 * @generated
	 */
	void setOwnerActivationBox(ActivationBox value);

} // ActivationBox
