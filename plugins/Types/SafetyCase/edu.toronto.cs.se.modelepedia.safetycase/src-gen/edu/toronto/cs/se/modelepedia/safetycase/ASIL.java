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
 * A representation of the model object '<em><b>ASIL</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getOwner <em>Owner</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getLevel <em>Level</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getASIL()
 * @model
 * @generated
 */
public interface ASIL extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.safetycase.Goal#getAsil <em>Asil</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Goal)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getASIL_Owner()
	 * @see edu.toronto.cs.se.modelepedia.safetycase.Goal#getAsil
	 * @model opposite="asil" required="true" transient="false"
	 * @generated
	 */
	Goal getOwner();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Goal value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.safetycase.ASILLevel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Level</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILLevel
	 * @see #setLevel(ASILLevel)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getASIL_Level()
	 * @model required="true"
	 * @generated
	 */
	ASILLevel getLevel();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.safetycase.ASILLevel
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(ASILLevel value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' containment reference.
	 * @see #setStatus(ImpactAnnotation)
	 * @see edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage#getASIL_Status()
	 * @model containment="true"
	 * @generated
	 */
	ImpactAnnotation getStatus();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.safetycase.ASIL#getStatus <em>Status</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' containment reference.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(ImpactAnnotation value);

} // ASIL
