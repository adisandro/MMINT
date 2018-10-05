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
package edu.toronto.cs.se.modelepedia.safetycase;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ASI Lful Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement#getAsil <em>Asil</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getASILfulElement()
 * @model abstract="true"
 * @generated
 */
public interface ASILfulElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Asil</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asil</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asil</em>' containment reference.
	 * @see #setAsil(ASIL)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getASILfulElement_Asil()
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASIL#getTarget
	 * @model opposite="target" containment="true"
	 * @generated
	 */
	ASIL getAsil();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement#getAsil <em>Asil</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asil</em>' containment reference.
	 * @see #getAsil()
	 * @generated
	 */
	void setAsil(ASIL value);

} // ASILfulElement
