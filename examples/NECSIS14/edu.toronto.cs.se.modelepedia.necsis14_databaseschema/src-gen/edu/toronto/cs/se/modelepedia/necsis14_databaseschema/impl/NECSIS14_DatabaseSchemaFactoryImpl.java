/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema.impl;

import edu.toronto.cs.se.modelepedia.necsis14_databaseschema.*;

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
public class NECSIS14_DatabaseSchemaFactoryImpl extends EFactoryImpl implements NECSIS14_DatabaseSchemaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NECSIS14_DatabaseSchemaFactory init() {
		try {
			NECSIS14_DatabaseSchemaFactory theNECSIS14_DatabaseSchemaFactory = (NECSIS14_DatabaseSchemaFactory)EPackage.Registry.INSTANCE.getEFactory(NECSIS14_DatabaseSchemaPackage.eNS_URI);
			if (theNECSIS14_DatabaseSchemaFactory != null) {
				return theNECSIS14_DatabaseSchemaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NECSIS14_DatabaseSchemaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NECSIS14_DatabaseSchemaFactoryImpl() {
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
			case NECSIS14_DatabaseSchemaPackage.DATABASE_SCHEMA: return createDatabaseSchema();
			case NECSIS14_DatabaseSchemaPackage.TABLE: return createTable();
			case NECSIS14_DatabaseSchemaPackage.COLUMN: return createColumn();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseSchema createDatabaseSchema() {
		DatabaseSchemaImpl databaseSchema = new DatabaseSchemaImpl();
		return databaseSchema;
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
	public NECSIS14_DatabaseSchemaPackage getNECSIS14_DatabaseSchemaPackage() {
		return (NECSIS14_DatabaseSchemaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NECSIS14_DatabaseSchemaPackage getPackage() {
		return NECSIS14_DatabaseSchemaPackage.eINSTANCE;
	}

} //NECSIS14_DatabaseSchemaFactoryImpl
