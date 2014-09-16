/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreign Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTableColumn <em>Table Column</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getForeignColumn <em>Foreign Column</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTable <em>Table</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage#getForeignKey()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface ForeignKey extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Table Column</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsColumn <em>Foreign Keys As Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Column</em>' reference.
	 * @see #setTableColumn(Column)
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage#getForeignKey_TableColumn()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsColumn
	 * @model opposite="foreignKeysAsColumn" required="true"
	 *        annotation="gmf.link target.decoration='none'"
	 * @generated
	 */
	Column getTableColumn();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTableColumn <em>Table Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Column</em>' reference.
	 * @see #getTableColumn()
	 * @generated
	 */
	void setTableColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Foreign Column</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsForeignColumn <em>Foreign Keys As Foreign Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Column</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Column</em>' reference.
	 * @see #setForeignColumn(Column)
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage#getForeignKey_ForeignColumn()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsForeignColumn
	 * @model opposite="foreignKeysAsForeignColumn" required="true"
	 *        annotation="gmf.link target.decoration='none'"
	 * @generated
	 */
	Column getForeignColumn();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getForeignColumn <em>Foreign Column</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreign Column</em>' reference.
	 * @see #getForeignColumn()
	 * @generated
	 */
	void setForeignColumn(Column value);

	/**
	 * Returns the value of the '<em><b>Table</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getForeignKeys <em>Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' container reference.
	 * @see #setTable(Table)
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage#getForeignKey_Table()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getForeignKeys
	 * @model opposite="foreignKeys" required="true" transient="false"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTable <em>Table</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' container reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

} // ForeignKey
