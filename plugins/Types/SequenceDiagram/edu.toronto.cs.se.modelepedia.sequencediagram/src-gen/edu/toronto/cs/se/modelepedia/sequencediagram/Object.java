/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.Object#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.Object#getLifeline <em>Lifeline</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getObject()
 * @model abstract="true"
 * @generated
 */
public interface Object extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getObject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.sequencediagram.Object#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Lifeline</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lifeline</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lifeline</em>' containment reference.
	 * @see #setLifeline(Lifeline)
	 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage#getObject_Lifeline()
	 * @model containment="true"
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
