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
package edu.toronto.cs.se.modelepedia.graph_mavo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.graph_mavo.Node#getEdgesAsSource <em>Edges As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.graph_mavo.Node#getEdgesAsTarget <em>Edges As Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage#getNode()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Node extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Edges As Source</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.graph_mavo.Edge}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.graph_mavo.Edge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges As Source</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges As Source</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage#getNode_EdgesAsSource()
	 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Edge#getSource
	 * @model opposite="source"
	 * @generated
	 */
	EList<Edge> getEdgesAsSource();

	/**
	 * Returns the value of the '<em><b>Edges As Target</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.graph_mavo.Edge}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.graph_mavo.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges As Target</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges As Target</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage#getNode_EdgesAsTarget()
	 * @see edu.toronto.cs.se.modelepedia.graph_mavo.Edge#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<Edge> getEdgesAsTarget();

} // Node
