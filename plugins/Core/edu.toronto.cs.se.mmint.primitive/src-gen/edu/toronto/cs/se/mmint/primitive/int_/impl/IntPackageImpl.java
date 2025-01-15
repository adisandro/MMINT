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
package edu.toronto.cs.se.mmint.primitive.int_.impl;

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.primitive.boolean_.BooleanPackage;
import edu.toronto.cs.se.mmint.primitive.boolean_.impl.BooleanPackageImpl;
import edu.toronto.cs.se.mmint.primitive.file.FilePackage;
import edu.toronto.cs.se.mmint.primitive.file.impl.FilePackageImpl;
import edu.toronto.cs.se.mmint.primitive.int_.Int;
import edu.toronto.cs.se.mmint.primitive.int_.IntFactory;
import edu.toronto.cs.se.mmint.primitive.int_.IntPackage;
import edu.toronto.cs.se.mmint.primitive.string.StringPackage;
import edu.toronto.cs.se.mmint.primitive.string.impl.StringPackageImpl;

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
public class IntPackageImpl extends EPackageImpl implements IntPackage {
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	private EClass intEClass = null;

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
   * @see edu.toronto.cs.se.mmint.primitive.int_.IntPackage#eNS_URI
   * @see #init()
   * @generated
   */
	private IntPackageImpl() {
    super(eNS_URI, IntFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link IntPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
	public static IntPackage init() {
    if (isInited) return (IntPackage)EPackage.Registry.INSTANCE.getEPackage(IntPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredIntPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    IntPackageImpl theIntPackage = registeredIntPackage instanceof IntPackageImpl ? (IntPackageImpl)registeredIntPackage : new IntPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    MIDPackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(StringPackage.eNS_URI);
    StringPackageImpl theStringPackage = (StringPackageImpl)(registeredPackage instanceof StringPackageImpl ? registeredPackage : StringPackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(FilePackage.eNS_URI);
    FilePackageImpl theFilePackage = (FilePackageImpl)(registeredPackage instanceof FilePackageImpl ? registeredPackage : FilePackage.eINSTANCE);
    registeredPackage = EPackage.Registry.INSTANCE.getEPackage(BooleanPackage.eNS_URI);
    BooleanPackageImpl theBooleanPackage = (BooleanPackageImpl)(registeredPackage instanceof BooleanPackageImpl ? registeredPackage : BooleanPackage.eINSTANCE);

    // Create package meta-data objects
    theIntPackage.createPackageContents();
    theStringPackage.createPackageContents();
    theFilePackage.createPackageContents();
    theBooleanPackage.createPackageContents();

    // Initialize created meta-data
    theIntPackage.initializePackageContents();
    theStringPackage.initializePackageContents();
    theFilePackage.initializePackageContents();
    theBooleanPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theIntPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(IntPackage.eNS_URI, theIntPackage);
    return theIntPackage;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EClass getInt() {
    return intEClass;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EAttribute getInt_Value() {
    return (EAttribute)intEClass.getEStructuralFeatures().get(0);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public IntFactory getIntFactory() {
    return (IntFactory)getEFactoryInstance();
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
    intEClass = createEClass(INT);
    createEAttribute(intEClass, INT__VALUE);
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
    initEClass(intEClass, Int.class, "Int", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInt_Value(), ecorePackage.getEInt(), "value", null, 1, 1, Int.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //IntPackageImpl
