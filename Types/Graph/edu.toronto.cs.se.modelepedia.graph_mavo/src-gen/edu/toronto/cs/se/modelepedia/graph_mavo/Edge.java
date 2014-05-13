/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.graph_mavo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.graph_mavo.Edge#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.graph_mavo.Edge#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.graph_mavo.Node#getEdgesAsSource <em>Edges As Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage#getEdge_Source()
	 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Node#getEdgesAsSource
	 * @model opposite="edgesAsSource" required="true"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.graph_mavo.Edge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.graph_mavo.Node#getEdgesAsTarget <em>Edges As Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage#getEdge_Target()
	 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Node#getEdgesAsTarget
	 * @model opposite="edgesAsTarget" required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.graph_mavo.Edge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

} // Edge
