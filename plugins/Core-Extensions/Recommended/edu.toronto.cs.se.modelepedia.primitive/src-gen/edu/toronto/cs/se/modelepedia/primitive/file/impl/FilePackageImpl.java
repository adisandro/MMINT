/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.primitive.file.impl;

import edu.toronto.cs.se.mmint.mid.MIDPackage;

import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;

import edu.toronto.cs.se.modelepedia.primitive.boolean_.BooleanPackage;
import edu.toronto.cs.se.modelepedia.primitive.boolean_.impl.BooleanPackageImpl;
import edu.toronto.cs.se.modelepedia.primitive.file.FileFactory;
import edu.toronto.cs.se.modelepedia.primitive.file.FileModel;
import edu.toronto.cs.se.modelepedia.primitive.file.FilePackage;

import edu.toronto.cs.se.modelepedia.primitive.int_.IntPackage;

import edu.toronto.cs.se.modelepedia.primitive.int_.impl.IntPackageImpl;

import edu.toronto.cs.se.modelepedia.primitive.string.StringPackage;

import edu.toronto.cs.se.modelepedia.primitive.string.impl.StringPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FilePackageImpl extends EPackageImpl implements FilePackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass fileModelEClass = null;

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
     * @see edu.toronto.cs.se.modelepedia.primitive.file.FilePackage#eNS_URI
     * @see #init()
     * @generated
     */
	private FilePackageImpl() {
        super(eNS_URI, FileFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link FilePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static FilePackage init() {
        if (isInited) return (FilePackage)EPackage.Registry.INSTANCE.getEPackage(FilePackage.eNS_URI);

        // Obtain or create and register package
        FilePackageImpl theFilePackage = (FilePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FilePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FilePackageImpl());

        isInited = true;

        // Initialize simple dependencies
        MIDPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        IntPackageImpl theIntPackage = (IntPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(IntPackage.eNS_URI) instanceof IntPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(IntPackage.eNS_URI) : IntPackage.eINSTANCE);
        StringPackageImpl theStringPackage = (StringPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StringPackage.eNS_URI) instanceof StringPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StringPackage.eNS_URI) : StringPackage.eINSTANCE);
        BooleanPackageImpl theBooleanPackage = (BooleanPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BooleanPackage.eNS_URI) instanceof BooleanPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BooleanPackage.eNS_URI) : BooleanPackage.eINSTANCE);

        // Create package meta-data objects
        theFilePackage.createPackageContents();
        theIntPackage.createPackageContents();
        theStringPackage.createPackageContents();
        theBooleanPackage.createPackageContents();

        // Initialize created meta-data
        theFilePackage.initializePackageContents();
        theIntPackage.initializePackageContents();
        theStringPackage.initializePackageContents();
        theBooleanPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theFilePackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(FilePackage.eNS_URI, theFilePackage);
        return theFilePackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFileModel() {
        return fileModelEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EOperation getFileModel__OpenInstance() {
        return fileModelEClass.getEOperations().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FileFactory getFileFactory() {
        return (FileFactory)getEFactoryInstance();
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
        fileModelEClass = createEClass(FILE_MODEL);
        createEOperation(fileModelEClass, FILE_MODEL___OPEN_INSTANCE);
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

        // Obtain other dependent packages
        MIDPackage theMIDPackage = (MIDPackage)EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);
        OperatorPackage theOperatorPackage = (OperatorPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        fileModelEClass.getESuperTypes().add(theMIDPackage.getModel());

        // Initialize classes, features, and operations; add parameters
        initEClass(fileModelEClass, FileModel.class, "FileModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        EOperation op = initEOperation(getFileModel__OpenInstance(), null, "openInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEException(op, theOperatorPackage.getException());

        // Create resource
        createResource(eNS_URI);
    }

} //FilePackageImpl
