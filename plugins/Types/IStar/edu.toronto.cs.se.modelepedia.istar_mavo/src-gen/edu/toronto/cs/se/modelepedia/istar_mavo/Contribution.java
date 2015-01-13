/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.istar_mavo.Contribution#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getContribution()
 * @model annotation="gmf.link target.decoration='arrow'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='tgtSoftgoal'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot tgtSoftgoal='tgt.oclIsTypeOf(SoftGoal)'"
 * @generated
 */
public interface Contribution extends IntentionLink {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.istar_mavo.ContributionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.ContributionType
	 * @see #setType(ContributionType)
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage#getContribution_Type()
	 * @model required="true"
	 * @generated
	 */
	ContributionType getType();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.istar_mavo.Contribution#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.toronto.cs.se.modelepedia.istar_mavo.ContributionType
	 * @see #getType()
	 * @generated
	 */
	void setType(ContributionType value);

} // Contribution
