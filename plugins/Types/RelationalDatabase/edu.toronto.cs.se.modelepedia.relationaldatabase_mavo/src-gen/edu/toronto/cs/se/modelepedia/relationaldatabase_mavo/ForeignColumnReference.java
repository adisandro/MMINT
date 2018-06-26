/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo;

import edu.toronto.cs.se.mavo.MAVOReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Column Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference#getSource <em>Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getForeignColumnReference()
 * @model annotation="gmf.link target.decoration='none' source='source' target='target'"
 * @generated
 */
public interface ForeignColumnReference extends MAVOReference {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey#getForeignColumn <em>Foreign Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(ForeignKey)
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getForeignColumnReference_Source()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignKey#getForeignColumn
	 * @model opposite="foreignColumn" required="true" transient="false"
	 * @generated
	 */
	ForeignKey getSource();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ForeignKey value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column#getForeignKeysAsForeignColumn <em>Foreign Keys As Foreign Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Column)
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getForeignColumnReference_Target()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column#getForeignKeysAsForeignColumn
	 * @model opposite="foreignKeysAsForeignColumn" required="true"
	 * @generated
	 */
	Column getTarget();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Column value);

} // ForeignColumnReference
