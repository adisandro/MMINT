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
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column#getTable <em>Table</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column#getTableAsPrimaryKey <em>Table As Primary Key</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column#getForeignKeysAsColumn <em>Foreign Keys As Column</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column#getForeignKeysAsForeignColumn <em>Foreign Keys As Foreign Column</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getColumn()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Column extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Table</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table</em>' container reference.
	 * @see #setTable(Table)
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getColumn_Table()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table#getColumns
	 * @model opposite="columns" required="true" transient="false"
	 * @generated
	 */
	Table getTable();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column#getTable <em>Table</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table</em>' container reference.
	 * @see #getTable()
	 * @generated
	 */
	void setTable(Table value);

	/**
	 * Returns the value of the '<em><b>Table As Primary Key</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Table As Primary Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table As Primary Key</em>' reference.
	 * @see #setTableAsPrimaryKey(Table)
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getColumn_TableAsPrimaryKey()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Table#getPrimaryKey
	 * @model opposite="primaryKey"
	 * @generated
	 */
	Table getTableAsPrimaryKey();

	/**
	 * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.Column#getTableAsPrimaryKey <em>Table As Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table As Primary Key</em>' reference.
	 * @see #getTableAsPrimaryKey()
	 * @generated
	 */
	void setTableAsPrimaryKey(Table value);

	/**
	 * Returns the value of the '<em><b>Foreign Keys As Column</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Keys As Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys As Column</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getColumn_ForeignKeysAsColumn()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.TableColumnReference#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<TableColumnReference> getForeignKeysAsColumn();

	/**
	 * Returns the value of the '<em><b>Foreign Keys As Foreign Column</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference}.
	 * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreign Keys As Foreign Column</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreign Keys As Foreign Column</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.RelationalDatabase_MAVOPackage#getColumn_ForeignKeysAsForeignColumn()
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.ForeignColumnReference#getTarget
	 * @model opposite="target"
	 * @generated
	 */
	EList<ForeignColumnReference> getForeignKeysAsForeignColumn();

} // Column
