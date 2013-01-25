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

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMinimumNumberOfInstances <em>Minimum Number Of Instances</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMaximumNumberOfInstances <em>Maximum Number Of Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getNamedElement()
 * @model abstract="true"
 * @generated
 */
public interface NamedElement extends MAVOElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getNamedElement_Name()
	 * @model default="" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getName <em>Name</em>}' attribute.
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
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getNamedElement_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Minimum Number Of Instances</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Number Of Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Number Of Instances</em>' attribute.
	 * @see #isSetMinimumNumberOfInstances()
	 * @see #unsetMinimumNumberOfInstances()
	 * @see #setMinimumNumberOfInstances(int)
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getNamedElement_MinimumNumberOfInstances()
	 * @model default="0" unsettable="true"
	 * @generated
	 */
	int getMinimumNumberOfInstances();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMinimumNumberOfInstances <em>Minimum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Number Of Instances</em>' attribute.
	 * @see #isSetMinimumNumberOfInstances()
	 * @see #unsetMinimumNumberOfInstances()
	 * @see #getMinimumNumberOfInstances()
	 * @generated
	 */
	void setMinimumNumberOfInstances(int value);

	/**
	 * Unsets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMinimumNumberOfInstances <em>Minimum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMinimumNumberOfInstances()
	 * @see #getMinimumNumberOfInstances()
	 * @see #setMinimumNumberOfInstances(int)
	 * @generated
	 */
	void unsetMinimumNumberOfInstances();

	/**
	 * Returns whether the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMinimumNumberOfInstances <em>Minimum Number Of Instances</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Minimum Number Of Instances</em>' attribute is set.
	 * @see #unsetMinimumNumberOfInstances()
	 * @see #getMinimumNumberOfInstances()
	 * @see #setMinimumNumberOfInstances(int)
	 * @generated
	 */
	boolean isSetMinimumNumberOfInstances();

	/**
	 * Returns the value of the '<em><b>Maximum Number Of Instances</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Number Of Instances</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Number Of Instances</em>' attribute.
	 * @see #isSetMaximumNumberOfInstances()
	 * @see #unsetMaximumNumberOfInstances()
	 * @see #setMaximumNumberOfInstances(int)
	 * @see edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage#getNamedElement_MaximumNumberOfInstances()
	 * @model default="0" unsettable="true"
	 * @generated
	 */
	int getMaximumNumberOfInstances();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMaximumNumberOfInstances <em>Maximum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Number Of Instances</em>' attribute.
	 * @see #isSetMaximumNumberOfInstances()
	 * @see #unsetMaximumNumberOfInstances()
	 * @see #getMaximumNumberOfInstances()
	 * @generated
	 */
	void setMaximumNumberOfInstances(int value);

	/**
	 * Unsets the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMaximumNumberOfInstances <em>Maximum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaximumNumberOfInstances()
	 * @see #getMaximumNumberOfInstances()
	 * @see #setMaximumNumberOfInstances(int)
	 * @generated
	 */
	void unsetMaximumNumberOfInstances();

	/**
	 * Returns whether the value of the '{@link edu.toronto.cs.se.modelepedia.randommodel.NamedElement#getMaximumNumberOfInstances <em>Maximum Number Of Instances</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Maximum Number Of Instances</em>' attribute is set.
	 * @see #unsetMaximumNumberOfInstances()
	 * @see #getMaximumNumberOfInstances()
	 * @see #setMaximumNumberOfInstances(int)
	 * @generated
	 */
	boolean isSetMaximumNumberOfInstances();

} // NamedElement
