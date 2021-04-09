/*******************************************************************************
 * Copyright (c) 2021, 2021 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.papyrus.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.papyrus.PapyrusFactory;
import edu.toronto.cs.se.mmint.papyrus.PapyrusPackage;
import edu.toronto.cs.se.mmint.papyrus.UMLModel;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class PapyrusPackageImpl extends EPackageImpl implements PapyrusPackage {
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass umlModelEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
   * EPackage.Registry} by the package package URI value.
   * <p>
   * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
   * performs initialization of the package, or returns the registered package, if one already exists. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see edu.toronto.cs.se.mmint.papyrus.PapyrusPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private PapyrusPackageImpl() {
    super(PapyrusPackage.eNS_URI, PapyrusFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>
   * This method is used to initialize {@link PapyrusPackage#eINSTANCE} when that field is accessed. Clients should not
   * invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static PapyrusPackage init() {
    if (PapyrusPackageImpl.isInited)
      return (PapyrusPackage) EPackage.Registry.INSTANCE.getEPackage(PapyrusPackage.eNS_URI);

    // Obtain or create and register package
    var registeredPapyrusPackage = EPackage.Registry.INSTANCE.get(PapyrusPackage.eNS_URI);
    var thePapyrusPackage = registeredPapyrusPackage instanceof PapyrusPackageImpl
      ? (PapyrusPackageImpl) registeredPapyrusPackage
      : new PapyrusPackageImpl();

    PapyrusPackageImpl.isInited = true;

    // Initialize simple dependencies
    MIDPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    thePapyrusPackage.createPackageContents();

    // Initialize created meta-data
    thePapyrusPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePapyrusPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PapyrusPackage.eNS_URI, thePapyrusPackage);
    return thePapyrusPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EClass getUMLModel() {
    return this.umlModelEClass;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EOperation getUMLModel__DeleteInstanceAndFile() {
    return this.umlModelEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public PapyrusFactory getPapyrusFactory() {
    return (PapyrusFactory) getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but its
   * first. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public void createPackageContents() {
    if (this.isCreated)
      return;
    this.isCreated = true;

    // Create classes and their features
    this.umlModelEClass = createEClass(PapyrusPackage.UML_MODEL);
    createEOperation(this.umlModelEClass, PapyrusPackage.UML_MODEL___DELETE_INSTANCE_AND_FILE);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
   * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public void initializePackageContents() {
    if (this.isInitialized)
      return;
    this.isInitialized = true;

    // Initialize package
    setName(PapyrusPackage.eNAME);
    setNsPrefix(PapyrusPackage.eNS_PREFIX);
    setNsURI(PapyrusPackage.eNS_URI);

    // Obtain other dependent packages
    var theMIDPackage = (MIDPackage) EPackage.Registry.INSTANCE.getEPackage(MIDPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.umlModelEClass.getESuperTypes().add(theMIDPackage.getModel());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.umlModelEClass, UMLModel.class, "UMLModel", !EPackageImpl.IS_ABSTRACT, !EPackageImpl.IS_INTERFACE, EPackageImpl.IS_GENERATED_INSTANCE_CLASS);

    var op = initEOperation(getUMLModel__DeleteInstanceAndFile(), null, "deleteInstanceAndFile", 0, 1, EPackageImpl.IS_UNIQUE,
                                   EPackageImpl.IS_ORDERED);
    addEException(op, theMIDPackage.getMMINTException());

    // Create resource
    createResource(PapyrusPackage.eNS_URI);
  }

} // PapyrusPackageImpl
