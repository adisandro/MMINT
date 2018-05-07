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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content Validity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ContentValidity#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getContentValidity()
 * @model
 * @generated
 */
public interface ContentValidity extends ElementValidity {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getContentValidity <em>Content Validity</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' container reference.
	 * @see #setTarget(ArgumentElement)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getContentValidity_Target()
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement#getContentValidity
	 * @model opposite="contentValidity" required="true" transient="false"
	 * @generated
	 */
	ArgumentElement getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ContentValidity#getTarget <em>Target</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' container reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ArgumentElement value);

} // ContentValidity
