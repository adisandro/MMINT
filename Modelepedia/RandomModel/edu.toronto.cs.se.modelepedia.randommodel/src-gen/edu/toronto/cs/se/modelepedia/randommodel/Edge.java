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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.Edge#getSrc <em>Src</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.Edge#getTgt <em>Tgt</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getEdge()
 * @model
 * @generated
 */
public interface Edge extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Src</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsSrc <em>Edges As Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src</em>' reference.
	 * @see #setSrc(Node)
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getEdge_Src()
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsSrc
	 * @model opposite="edgesAsSrc" required="true"
	 * @generated
	 */
	Node getSrc();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.Edge#getSrc <em>Src</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src</em>' reference.
	 * @see #getSrc()
	 * @generated
	 */
	void setSrc(Node value);

	/**
	 * Returns the value of the '<em><b>Tgt</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsTgt <em>Edges As Tgt</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tgt</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tgt</em>' reference.
	 * @see #setTgt(Node)
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getEdge_Tgt()
	 * @see edu.toronto.cs.se.modelepedia.randommodel.Node#getEdgesAsTgt
	 * @model opposite="edgesAsTgt" required="true"
	 * @generated
	 */
	Node getTgt();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.Edge#getTgt <em>Tgt</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tgt</em>' reference.
	 * @see #getTgt()
	 * @generated
	 */
	void setTgt(Node value);

} // Edge
