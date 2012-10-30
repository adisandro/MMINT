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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Random Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getNodes <em>Nodes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getEdges <em>Edges</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getDefaultMinimumNumberOfInstances <em>Default Minimum Number Of Instances</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getDefaultMaximumNumberOfInstances <em>Default Maximum Number Of Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getRandomModel()
 * @model
 * @generated
 */
public interface RandomModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.randommodel.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getRandomModel_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.randommodel.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getRandomModel_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

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
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getRandomModel_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getRandomModel_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Default Minimum Number Of Instances</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Minimum Number Of Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Minimum Number Of Instances</em>' attribute.
	 * @see #setDefaultMinimumNumberOfInstances(int)
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getRandomModel_DefaultMinimumNumberOfInstances()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getDefaultMinimumNumberOfInstances();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getDefaultMinimumNumberOfInstances <em>Default Minimum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Minimum Number Of Instances</em>' attribute.
	 * @see #getDefaultMinimumNumberOfInstances()
	 * @generated
	 */
	void setDefaultMinimumNumberOfInstances(int value);

	/**
	 * Returns the value of the '<em><b>Default Maximum Number Of Instances</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Maximum Number Of Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Maximum Number Of Instances</em>' attribute.
	 * @see #setDefaultMaximumNumberOfInstances(int)
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getRandomModel_DefaultMaximumNumberOfInstances()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getDefaultMaximumNumberOfInstances();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.RandomModel#getDefaultMaximumNumberOfInstances <em>Default Maximum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Maximum Number Of Instances</em>' attribute.
	 * @see #getDefaultMaximumNumberOfInstances()
	 * @generated
	 */
	void setDefaultMaximumNumberOfInstances(int value);

} // RandomModel
