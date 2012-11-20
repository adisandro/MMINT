/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.randommodel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsSrc <em>Edges As Src</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsTgt <em>Edges As Tgt</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Edges As Src</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.randommodel.Edge}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.randommodel.Edge#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges As Src</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges As Src</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getNode_EdgesAsSrc()
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Edge#getSrc
	 * @model opposite="src"
	 * @generated
	 */
	EList<Edge> getEdgesAsSrc();

	/**
	 * Returns the value of the '<em><b>Edges As Tgt</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.randommodel.Edge}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.randommodel.Edge#getTgt <em>Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges As Tgt</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges As Tgt</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getNode_EdgesAsTgt()
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Edge#getTgt
	 * @model opposite="tgt"
	 * @generated
	 */
	EList<Edge> getEdgesAsTgt();
} // Node
