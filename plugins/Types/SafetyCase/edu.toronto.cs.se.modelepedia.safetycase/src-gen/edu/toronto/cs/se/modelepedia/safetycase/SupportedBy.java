/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
 * A representation of the model object '<em><b>Supported By</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSupportedBy()
 * @model
 * @generated
 */
public interface SupportedBy extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.Supportable#getSupportedBy <em>Supported By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Supportable)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSupportedBy_Source()
	 * @see edu.toronto.cs.se.modelepedia.safetycase.Supportable#getSupportedBy
	 * @model opposite="supportedBy" required="true" transient="false"
	 * @generated
	 */
	Supportable getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Supportable value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.Supporter#getSupports <em>Supports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Supporter)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getSupportedBy_Target()
	 * @see edu.toronto.cs.se.modelepedia.safetycase.Supporter#getSupports
	 * @model opposite="supports" required="true"
	 * @generated
	 */
	Supporter getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.SupportedBy#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Supporter value);

} // SupportedBy
