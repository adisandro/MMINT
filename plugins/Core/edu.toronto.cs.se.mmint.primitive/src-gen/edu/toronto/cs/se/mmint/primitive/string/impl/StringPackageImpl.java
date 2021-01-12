/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.primitive.string.impl;

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.primitive.boolean_.BooleanPackage;
import edu.toronto.cs.se.mmint.primitive.boolean_.impl.BooleanPackageImpl;
import edu.toronto.cs.se.mmint.primitive.file.FilePackage;
import edu.toronto.cs.se.mmint.primitive.file.impl.FilePackageImpl;
import edu.toronto.cs.se.mmint.primitive.int_.IntPackage;
import edu.toronto.cs.se.mmint.primitive.int_.impl.IntPackageImpl;
import edu.toronto.cs.se.mmint.primitive.string.StringFactory;
import edu.toronto.cs.se.mmint.primitive.string.StringPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StringPackageImpl extends EPackageImpl implements StringPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass stringEClass = null;

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
   * @see edu.toronto.cs.se.mmint.primitive.string.StringPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private StringPackageImpl() {
    super(eNS_URI, StringFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link StringPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static StringPackage init() {
    if (isInited) return (StringPackage)EPackage.Registry.INSTANCE.getEPackage(StringPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredStringPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    StringPackageImpl theStringPackage = registeredStringPackage instanceof StringPackageImpl ? (StringPackageImpl)registeredStringPackage : new StringPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    MIDPackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(IntPackage.eNS_URI);
    IntPackageImpl theIntPackage = (IntPackageImpl)(registeredPackage instanceof IntPackageImpl ? registeredPackage : IntPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(FilePackage.eNS_URI);
    FilePackageImpl theFilePackage = (FilePackageImpl)(registeredPackage instanceof FilePackageImpl ? registeredPackage : FilePackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BooleanPackage.eNS_URI);
    BooleanPackageImpl theBooleanPackage = (BooleanPackageImpl)(registeredPackage instanceof BooleanPackageImpl ? registeredPackage : BooleanPackage.eINSTANCE);

    // Create package meta-data objects
    theStringPackage.createPackageContents();
    theIntPackage.createPackageContents();
    theFilePackage.createPackageContents();
    theBooleanPackage.createPackageContents();

    // Initialize created meta-data
    theStringPackage.initializePackageContents();
    theIntPackage.initializePackageContents();
    theFilePackage.initializePackageContents();
    theBooleanPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theStringPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(StringPackage.eNS_URI, theStringPackage);
    return theStringPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getString() {
    return stringEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getString_Value() {
    return (EAttribute)stringEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public StringFactory getStringFactory() {
    return (StringFactory)getEFactoryInstance();
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
    stringEClass = createEClass(STRING);
    createEAttribute(stringEClass, STRING__VALUE);
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

    // Initialize classes, features, and operations; add parameters
    initEClass(stringEClass, edu.toronto.cs.se.mmint.primitive.string.String.class, "String", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getString_Value(), ecorePackage.getEString(), "value", null, 1, 1, edu.toronto.cs.se.mmint.primitive.string.String.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //StringPackageImpl
