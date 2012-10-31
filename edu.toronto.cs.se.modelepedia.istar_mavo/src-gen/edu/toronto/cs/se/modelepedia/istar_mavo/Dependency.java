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
package edu.toronto.cs.se.modelepedia.istar_mavo;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDepender <em>Depender</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDependee <em>Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDependum <em>Dependum</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getDependency()
 * @model
 * @generated
 */
public interface Dependency extends MAVOElement {
	/**
	 * Returns the value of the '<em><b>Depender</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depender</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depender</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getDependency_Depender()
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependerReference#getSrc
	 * @model opposite="src" containment="true" required="true"
	 * @generated
	 */
	EList<DependerReference> getDepender();

	/**
	 * Returns the value of the '<em><b>Dependee</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference#getSrc <em>Src</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependee</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependee</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getDependency_Dependee()
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.DependeeReference#getSrc
	 * @model opposite="src" containment="true" required="true"
	 * @generated
	 */
	EList<DependeeReference> getDependee();

	/**
	 * Returns the value of the '<em><b>Dependum</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement#getDependency <em>Dependency</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependum</em>' reference.
	 * @see #setDependum(IntentionalElement)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getDependency_Dependum()
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IntentionalElement#getDependency
	 * @model opposite="dependency" required="true"
	 * @generated
	 */
	IntentionalElement getDependum();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Dependency#getDependum <em>Dependum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependum</em>' reference.
	 * @see #getDependum()
	 * @generated
	 */
	void setDependum(IntentionalElement value);

} // Dependency
