/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getTable <em>Table</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getTableAsPrimaryKey <em>Table As Primary Key</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsColumn <em>Foreign Keys As Column</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsForeignColumn <em>Foreign Keys As Foreign Column</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage#getColumn()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Column extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' container reference.
	 * @see #setTable(Table)
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage#getColumn_Table()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getColumns
	 * @model opposite="columns" required="true" transient="false"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getTable <em>Table</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' container reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Table As Primary Key</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table As Primary Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table As Primary Key</em>' reference.
	 * @see #setTableAsPrimaryKey(Table)
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage#getColumn_TableAsPrimaryKey()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getPrimaryKey
	 * @model opposite="primaryKey"
	 * @generated
	 */
	Table getTableAsPrimaryKey();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getTableAsPrimaryKey <em>Table As Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table As Primary Key</em>' reference.
	 * @see #getTableAsPrimaryKey()
	 * @generated
	 */
	void setTableAsPrimaryKey(Table value);

	/**
	 * Returns the value of the '<em><b>Foreign Keys As Column</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTableColumn <em>Table Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Keys As Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys As Column</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage#getColumn_ForeignKeysAsColumn()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTableColumn
	 * @model opposite="tableColumn"
	 * @generated
	 */
	EList<ForeignKey> getForeignKeysAsColumn();

	/**
	 * Returns the value of the '<em><b>Foreign Keys As Foreign Column</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getForeignColumn <em>Foreign Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Keys As Foreign Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys As Foreign Column</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabasePackage#getColumn_ForeignKeysAsForeignColumn()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getForeignColumn
	 * @model opposite="foreignColumn"
	 * @generated
	 */
	EList<ForeignKey> getForeignKeysAsForeignColumn();

} // Column
