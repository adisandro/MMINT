/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.impl;

import edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationalDatabase_MAVOFactoryImpl extends EFactoryImpl implements RelationalDatabase_MAVOFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelationalDatabase_MAVOFactory init() {
		try {
			RelationalDatabase_MAVOFactory theRelationalDatabase_MAVOFactory = (RelationalDatabase_MAVOFactory)EPackage.Registry.INSTANCE.getEFactory(RelationalDatabase_MAVOPackage.eNS_URI);
			if (theRelationalDatabase_MAVOFactory != null) {
				return theRelationalDatabase_MAVOFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RelationalDatabase_MAVOFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalDatabase_MAVOFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case RelationalDatabase_MAVOPackage.RELATIONAL_DATABASE: return createRelationalDatabase();
			case RelationalDatabase_MAVOPackage.TABLE: return createTable();
			case RelationalDatabase_MAVOPackage.COLUMN: return createColumn();
			case RelationalDatabase_MAVOPackage.FOREIGN_KEY: return createForeignKey();
			case RelationalDatabase_MAVOPackage.TABLE_COLUMN_REFERENCE: return createTableColumnReference();
			case RelationalDatabase_MAVOPackage.FOREIGN_COLUMN_REFERENCE: return createForeignColumnReference();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalDatabase createRelationalDatabase() {
		RelationalDatabaseImpl relationalDatabase = new RelationalDatabaseImpl();
		return relationalDatabase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table createTable() {
		TableImpl table = new TableImpl();
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Column createColumn() {
		ColumnImpl column = new ColumnImpl();
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeignKey createForeignKey() {
		ForeignKeyImpl foreignKey = new ForeignKeyImpl();
		return foreignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TableColumnReference createTableColumnReference() {
		TableColumnReferenceImpl tableColumnReference = new TableColumnReferenceImpl();
		return tableColumnReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeignColumnReference createForeignColumnReference() {
		ForeignColumnReferenceImpl foreignColumnReference = new ForeignColumnReferenceImpl();
		return foreignColumnReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalDatabase_MAVOPackage getRelationalDatabase_MAVOPackage() {
		return (RelationalDatabase_MAVOPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RelationalDatabase_MAVOPackage getPackage() {
		return RelationalDatabase_MAVOPackage.eINSTANCE;
	}

} //RelationalDatabase_MAVOFactoryImpl
