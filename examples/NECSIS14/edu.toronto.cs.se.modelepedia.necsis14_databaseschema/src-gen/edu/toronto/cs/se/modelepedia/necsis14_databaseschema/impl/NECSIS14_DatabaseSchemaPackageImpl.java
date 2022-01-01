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
package edu.toronto.cs.se.modelepedia.necsis14_databaseschema.impl;

import edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Column;
import edu.toronto.cs.se.modelepedia.necsis14_databaseschema.DatabaseSchema;
import edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NECSIS14_DatabaseSchemaFactory;
import edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NECSIS14_DatabaseSchemaPackage;
import edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NamedElement;
import edu.toronto.cs.se.modelepedia.necsis14_databaseschema.Table;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NECSIS14_DatabaseSchemaPackageImpl extends EPackageImpl implements NECSIS14_DatabaseSchemaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass databaseSchemaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass columnEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.toronto.cs.se.modelepedia.necsis14_databaseschema.NECSIS14_DatabaseSchemaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private NECSIS14_DatabaseSchemaPackageImpl() {
		super(eNS_URI, NECSIS14_DatabaseSchemaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link NECSIS14_DatabaseSchemaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static NECSIS14_DatabaseSchemaPackage init() {
		if (isInited) return (NECSIS14_DatabaseSchemaPackage)EPackage.Registry.INSTANCE.getEPackage(NECSIS14_DatabaseSchemaPackage.eNS_URI);

		// Obtain or create and register package
		NECSIS14_DatabaseSchemaPackageImpl theNECSIS14_DatabaseSchemaPackage = (NECSIS14_DatabaseSchemaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof NECSIS14_DatabaseSchemaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new NECSIS14_DatabaseSchemaPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theNECSIS14_DatabaseSchemaPackage.createPackageContents();

		// Initialize created meta-data
		theNECSIS14_DatabaseSchemaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theNECSIS14_DatabaseSchemaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(NECSIS14_DatabaseSchemaPackage.eNS_URI, theNECSIS14_DatabaseSchemaPackage);
		return theNECSIS14_DatabaseSchemaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDatabaseSchema() {
		return databaseSchemaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDatabaseSchema_Tables() {
		return (EReference)databaseSchemaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTable() {
		return tableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_Columns() {
		return (EReference)tableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTable_PrimaryKeys() {
		return (EReference)tableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColumn() {
		return columnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NECSIS14_DatabaseSchemaFactory getNECSIS14_DatabaseSchemaFactory() {
		return (NECSIS14_DatabaseSchemaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		databaseSchemaEClass = createEClass(DATABASE_SCHEMA);
		createEReference(databaseSchemaEClass, DATABASE_SCHEMA__TABLES);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		tableEClass = createEClass(TABLE);
		createEReference(tableEClass, TABLE__COLUMNS);
		createEReference(tableEClass, TABLE__PRIMARY_KEYS);

		columnEClass = createEClass(COLUMN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tableEClass.getESuperTypes().add(this.getNamedElement());
		columnEClass.getESuperTypes().add(this.getNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(databaseSchemaEClass, DatabaseSchema.class, "DatabaseSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDatabaseSchema_Tables(), this.getTable(), null, "tables", null, 0, -1, DatabaseSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableEClass, Table.class, "Table", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTable_Columns(), this.getColumn(), null, "columns", null, 1, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTable_PrimaryKeys(), this.getColumn(), null, "primaryKeys", null, 1, -1, Table.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(columnEClass, Column.class, "Column", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// gmf.diagram
		createGmfAnnotations();
		// gmf.node
		createGmf_1Annotations();
		// gmf.compartment
		createGmf_2Annotations();
	}

	/**
	 * Initializes the annotations for <b>gmf.diagram</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmfAnnotations() {
		String source = "gmf.diagram";		
		addAnnotation
		  (databaseSchemaEClass, 
		   source, 
		   new String[] {
		   });			
	}

	/**
	 * Initializes the annotations for <b>gmf.node</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_1Annotations() {
		String source = "gmf.node";			
		addAnnotation
		  (tableEClass, 
		   source, 
		   new String[] {
			 "label", "name"
		   });			
		addAnnotation
		  (columnEClass, 
		   source, 
		   new String[] {
			 "label", "name"
		   });
	}

	/**
	 * Initializes the annotations for <b>gmf.compartment</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createGmf_2Annotations() {
		String source = "gmf.compartment";				
		addAnnotation
		  (getTable_Columns(), 
		   source, 
		   new String[] {
			 "layout", "list"
		   });	
	}

} //NECSIS14_DatabaseSchemaPackageImpl
