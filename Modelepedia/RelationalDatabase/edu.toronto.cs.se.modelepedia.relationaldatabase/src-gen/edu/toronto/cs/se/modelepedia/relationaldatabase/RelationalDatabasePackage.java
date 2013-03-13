/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabaseFactory
 * @model kind="package"
 * @generated
 */
public interface RelationalDatabasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "relationaldatabase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://se.cs.toronto.edu/modelepedia/RelationalDatabase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "relationaldatabase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RelationalDatabasePackage eINSTANCE = edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabaseImpl <em>Relational Database</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabaseImpl
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getRelationalDatabase()
	 * @generated
	 */
	int RELATIONAL_DATABASE = 0;

	/**
	 * The feature id for the '<em><b>Tables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_DATABASE__TABLES = 0;

	/**
	 * The number of structural features of the '<em>Relational Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_DATABASE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Relational Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_DATABASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.NamedElementImpl
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.TableImpl
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLUMNS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__PRIMARY_KEY = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Foreign Keys</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__FOREIGN_KEYS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ColumnImpl
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getColumn()
	 * @generated
	 */
	int COLUMN = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Table</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__TABLE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Table As Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__TABLE_AS_PRIMARY_KEY = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Foreign Keys As Column</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__FOREIGN_KEYS_AS_COLUMN = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Foreign Keys As Foreign Column</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ForeignKeyImpl <em>Foreign Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ForeignKeyImpl
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getForeignKey()
	 * @generated
	 */
	int FOREIGN_KEY = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Table Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__TABLE_COLUMN = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Foreign Column</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__FOREIGN_COLUMN = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Table</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY__TABLE = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Foreign Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Foreign Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOREIGN_KEY_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabase <em>Relational Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Database</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabase
	 * @generated
	 */
	EClass getRelationalDatabase();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabase#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tables</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.RelationalDatabase#getTables()
	 * @see #getRelationalDatabase()
	 * @generated
	 */
	EReference getRelationalDatabase_Tables();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getColumns()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Columns();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Key</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getPrimaryKey()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_PrimaryKey();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getForeignKeys <em>Foreign Keys</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Foreign Keys</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Table#getForeignKeys()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_ForeignKeys();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Column
	 * @generated
	 */
	EClass getColumn();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Table</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getTable()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_Table();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getTableAsPrimaryKey <em>Table As Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table As Primary Key</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getTableAsPrimaryKey()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_TableAsPrimaryKey();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsColumn <em>Foreign Keys As Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Foreign Keys As Column</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsColumn()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_ForeignKeysAsColumn();

	/**
	 * Returns the meta object for the reference list '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsForeignColumn <em>Foreign Keys As Foreign Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Foreign Keys As Foreign Column</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.Column#getForeignKeysAsForeignColumn()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_ForeignKeysAsForeignColumn();

	/**
	 * Returns the meta object for class '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey <em>Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Foreign Key</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey
	 * @generated
	 */
	EClass getForeignKey();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTableColumn <em>Table Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Table Column</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTableColumn()
	 * @see #getForeignKey()
	 * @generated
	 */
	EReference getForeignKey_TableColumn();

	/**
	 * Returns the meta object for the reference '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getForeignColumn <em>Foreign Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Foreign Column</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getForeignColumn()
	 * @see #getForeignKey()
	 * @generated
	 */
	EReference getForeignKey_ForeignColumn();

	/**
	 * Returns the meta object for the container reference '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTable <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Table</em>'.
	 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.ForeignKey#getTable()
	 * @see #getForeignKey()
	 * @generated
	 */
	EReference getForeignKey_Table();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RelationalDatabaseFactory getRelationalDatabaseFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabaseImpl <em>Relational Database</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabaseImpl
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getRelationalDatabase()
		 * @generated
		 */
		EClass RELATIONAL_DATABASE = eINSTANCE.getRelationalDatabase();

		/**
		 * The meta object literal for the '<em><b>Tables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_DATABASE__TABLES = eINSTANCE.getRelationalDatabase_Tables();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.NamedElementImpl
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.TableImpl
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLUMNS = eINSTANCE.getTable_Columns();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__PRIMARY_KEY = eINSTANCE.getTable_PrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Foreign Keys</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__FOREIGN_KEYS = eINSTANCE.getTable_ForeignKeys();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ColumnImpl
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__TABLE = eINSTANCE.getColumn_Table();

		/**
		 * The meta object literal for the '<em><b>Table As Primary Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__TABLE_AS_PRIMARY_KEY = eINSTANCE.getColumn_TableAsPrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Foreign Keys As Column</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__FOREIGN_KEYS_AS_COLUMN = eINSTANCE.getColumn_ForeignKeysAsColumn();

		/**
		 * The meta object literal for the '<em><b>Foreign Keys As Foreign Column</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__FOREIGN_KEYS_AS_FOREIGN_COLUMN = eINSTANCE.getColumn_ForeignKeysAsForeignColumn();

		/**
		 * The meta object literal for the '{@link edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ForeignKeyImpl <em>Foreign Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.ForeignKeyImpl
		 * @see edu.toronto.cs.se.modelepedia.relationaldatabase.impl.RelationalDatabasePackageImpl#getForeignKey()
		 * @generated
		 */
		EClass FOREIGN_KEY = eINSTANCE.getForeignKey();

		/**
		 * The meta object literal for the '<em><b>Table Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREIGN_KEY__TABLE_COLUMN = eINSTANCE.getForeignKey_TableColumn();

		/**
		 * The meta object literal for the '<em><b>Foreign Column</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREIGN_KEY__FOREIGN_COLUMN = eINSTANCE.getForeignKey_ForeignColumn();

		/**
		 * The meta object literal for the '<em><b>Table</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOREIGN_KEY__TABLE = eINSTANCE.getForeignKey_Table();

	}

} //RelationalDatabasePackage
