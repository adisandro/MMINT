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
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Table#getColumns <em>Columns</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Table#getPrimaryKeys <em>Primary Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NECSIS14_DatabaseSchemaPackage#getTable()
 * @model annotation="gmf.node label='name'"
 * @generated
 */
public interface Table extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Columns</b></em>' containment reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Columns</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Columns</em>' containment reference list.
	 * @see edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NECSIS14_DatabaseSchemaPackage#getTable_Columns()
	 * @model containment="true" required="true"
	 *        annotation="gmf.compartment layout='list'"
	 * @generated
	 */
	EList<Column> getColumns();

	/**
	 * Returns the value of the '<em><b>Primary Keys</b></em>' reference list.
	 * The list contents are of type {@link edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Column}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Keys</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Keys</em>' reference list.
	 * @see edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NECSIS14_DatabaseSchemaPackage#getTable_PrimaryKeys()
	 * @model required="true"
	 * @generated
	 */
	EList<Column> getPrimaryKeys();

} // Table
