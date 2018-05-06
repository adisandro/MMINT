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
 * A representation of the model object '<em><b>Strategy Supported By</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.StrategySupportedBy#getConclusion <em>Conclusion</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.StrategySupportedBy#getPremise <em>Premise</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getStrategySupportedBy()
 * @model
 * @generated
 */
public interface StrategySupportedBy extends SupportedBy {
	/**
	 * Returns the value of the '<em><b>Conclusion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conclusion</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conclusion</em>' reference.
	 * @see #setConclusion(Strategy)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getStrategySupportedBy_Conclusion()
	 * @model required="true"
	 * @generated
	 */
	Strategy getConclusion();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.StrategySupportedBy#getConclusion <em>Conclusion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conclusion</em>' reference.
	 * @see #getConclusion()
	 * @generated
	 */
	void setConclusion(Strategy value);

	/**
	 * Returns the value of the '<em><b>Premise</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Premise</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Premise</em>' reference.
	 * @see #setPremise(CoreElement)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getStrategySupportedBy_Premise()
	 * @model required="true"
	 * @generated
	 */
	CoreElement getPremise();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.StrategySupportedBy#getPremise <em>Premise</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Premise</em>' reference.
	 * @see #getPremise()
	 * @generated
	 */
	void setPremise(CoreElement value);

} // StrategySupportedBy
