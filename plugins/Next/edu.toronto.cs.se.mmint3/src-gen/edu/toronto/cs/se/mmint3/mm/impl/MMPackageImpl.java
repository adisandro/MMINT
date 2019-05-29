/**
 */
package edu.toronto.cs.se.mmint3.mm.impl;

import edu.toronto.cs.se.mmint3.mm.Instance;
import edu.toronto.cs.se.mmint3.mm.InstanceMegaModel;
import edu.toronto.cs.se.mmint3.mm.MMElement;
import edu.toronto.cs.se.mmint3.mm.MMFactory;
import edu.toronto.cs.se.mmint3.mm.MMInstance;
import edu.toronto.cs.se.mmint3.mm.MMPackage;
import edu.toronto.cs.se.mmint3.mm.MMType;
import edu.toronto.cs.se.mmint3.mm.MegaModel;
import edu.toronto.cs.se.mmint3.mm.Model;
import edu.toronto.cs.se.mmint3.mm.ModelInstance;
import edu.toronto.cs.se.mmint3.mm.ModelType;
import edu.toronto.cs.se.mmint3.mm.Type;
import edu.toronto.cs.se.mmint3.mm.TypeMegaModel;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MMPackageImpl extends EPackageImpl implements MMPackage {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass megaModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mmElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeMegaModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceMegaModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelInstanceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass instanceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mmInstanceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mmTypeEClass = null;

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
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MMPackageImpl() {
    super(eNS_URI, MMFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link MMPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static MMPackage init() {
    if (isInited)
      return (MMPackage) EPackage.Registry.INSTANCE.getEPackage(MMPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredMMPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    MMPackageImpl theMMPackage = registeredMMPackage instanceof MMPackageImpl ? (MMPackageImpl) registeredMMPackage
      : new MMPackageImpl();

    isInited = true;

    // Create package meta-data objects
    theMMPackage.createPackageContents();

    // Initialize created meta-data
    theMMPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theMMPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(MMPackage.eNS_URI, theMMPackage);
    return theMMPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMegaModel() {
    return megaModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMegaModel_Models() {
    return (EReference) megaModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMMElement() {
    return mmElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMMElement_Id() {
    return (EAttribute) mmElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMMElement_Name() {
    return (EAttribute) mmElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getTypeMegaModel() {
    return typeMegaModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getInstanceMegaModel() {
    return instanceMegaModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModel() {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModelType() {
    return modelTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelType_T() {
    return (EReference) modelTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getModelType__GetPackage() {
    return modelTypeEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getModelType__CreateInstance__EObject_String_boolean_InstanceMegaModel() {
    return modelTypeEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getModelInstance() {
    return modelInstanceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelInstance_I() {
    return (EReference) modelInstanceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getModelInstance_Root() {
    return (EReference) modelInstanceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getInstance() {
    return instanceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getInstance__GetType() {
    return instanceEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getType() {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getType__IsDynamic() {
    return typeEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EOperation getType__IsAbstract() {
    return typeEClass.getEOperations().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMMInstance() {
    return mmInstanceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMMInstance_TypeId() {
    return (EAttribute) mmInstanceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMMType() {
    return mmTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMMType_Dynamic() {
    return (EAttribute) mmTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMMType_Supertype() {
    return (EReference) mmTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getMMType_Subtypes() {
    return (EReference) mmTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getMMType_Abstract() {
    return (EAttribute) mmTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MMFactory getMMFactory() {
    return (MMFactory) getEFactoryInstance();
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
    if (isCreated)
      return;
    isCreated = true;

    // Create classes and their features
    megaModelEClass = createEClass(MEGA_MODEL);
    createEReference(megaModelEClass, MEGA_MODEL__MODELS);

    mmElementEClass = createEClass(MM_ELEMENT);
    createEAttribute(mmElementEClass, MM_ELEMENT__ID);
    createEAttribute(mmElementEClass, MM_ELEMENT__NAME);

    typeMegaModelEClass = createEClass(TYPE_MEGA_MODEL);

    instanceMegaModelEClass = createEClass(INSTANCE_MEGA_MODEL);

    modelEClass = createEClass(MODEL);

    modelTypeEClass = createEClass(MODEL_TYPE);
    createEReference(modelTypeEClass, MODEL_TYPE__T);
    createEOperation(modelTypeEClass, MODEL_TYPE___GET_PACKAGE);
    createEOperation(modelTypeEClass, MODEL_TYPE___CREATE_INSTANCE__EOBJECT_STRING_BOOLEAN_INSTANCEMEGAMODEL);

    modelInstanceEClass = createEClass(MODEL_INSTANCE);
    createEReference(modelInstanceEClass, MODEL_INSTANCE__I);
    createEReference(modelInstanceEClass, MODEL_INSTANCE__ROOT);

    instanceEClass = createEClass(INSTANCE);
    createEOperation(instanceEClass, INSTANCE___GET_TYPE);

    typeEClass = createEClass(TYPE);
    createEOperation(typeEClass, TYPE___IS_DYNAMIC);
    createEOperation(typeEClass, TYPE___IS_ABSTRACT);

    mmInstanceEClass = createEClass(MM_INSTANCE);
    createEAttribute(mmInstanceEClass, MM_INSTANCE__TYPE_ID);

    mmTypeEClass = createEClass(MM_TYPE);
    createEAttribute(mmTypeEClass, MM_TYPE__DYNAMIC);
    createEReference(mmTypeEClass, MM_TYPE__SUPERTYPE);
    createEReference(mmTypeEClass, MM_TYPE__SUBTYPES);
    createEAttribute(mmTypeEClass, MM_TYPE__ABSTRACT);
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
    if (isInitialized)
      return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    typeMegaModelEClass.getESuperTypes().add(this.getMegaModel());
    instanceMegaModelEClass.getESuperTypes().add(this.getMegaModel());
    modelTypeEClass.getESuperTypes().add(this.getModel());
    modelTypeEClass.getESuperTypes().add(this.getType());
    modelInstanceEClass.getESuperTypes().add(this.getModel());
    modelInstanceEClass.getESuperTypes().add(this.getInstance());
    mmInstanceEClass.getESuperTypes().add(this.getMMElement());
    mmInstanceEClass.getESuperTypes().add(this.getInstance());
    mmTypeEClass.getESuperTypes().add(this.getMMElement());
    mmTypeEClass.getESuperTypes().add(this.getType());

    // Initialize classes, features, and operations; add parameters
    initEClass(megaModelEClass, MegaModel.class, "MegaModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMegaModel_Models(), this.getModel(), null, "models", null, 0, -1, MegaModel.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                   !IS_DERIVED, IS_ORDERED);

    initEClass(mmElementEClass, MMElement.class, "MMElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMMElement_Id(), ecorePackage.getEString(), "id", null, 1, 1, MMElement.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, MMElement.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeMegaModelEClass, TypeMegaModel.class, "TypeMegaModel", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);

    initEClass(instanceMegaModelEClass, InstanceMegaModel.class, "InstanceMegaModel", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);

    initEClass(modelEClass, Model.class, "Model", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(modelTypeEClass, ModelType.class, "ModelType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelType_T(), this.getMMType(), null, "t", null, 1, 1, ModelType.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                   !IS_DERIVED, IS_ORDERED);

    initEOperation(getModelType__GetPackage(), ecorePackage.getEPackage(), "getPackage", 1, 1, IS_UNIQUE, IS_ORDERED);

    EOperation op = initEOperation(getModelType__CreateInstance__EObject_String_boolean_InstanceMegaModel(), this
                                                                                                                 .getModelInstance(),
                                   "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEObject(), "root", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "path", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEBoolean(), "serialize", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getInstanceMegaModel(), "mm", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(modelInstanceEClass, ModelInstance.class, "ModelInstance", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelInstance_I(), this.getMMInstance(), null, "i", null, 1, 1, ModelInstance.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                   IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelInstance_Root(), ecorePackage.getEObject(), null, "root", null, 0, 1, ModelInstance.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                   IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(instanceEClass, Instance.class, "Instance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getInstance__GetType(), this.getType(), "getType", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getType__IsDynamic(), ecorePackage.getEBoolean(), "isDynamic", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getType__IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(mmInstanceEClass, MMInstance.class, "MMInstance", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMMInstance_TypeId(), ecorePackage.getEString(), "typeId", null, 1, 1, MMInstance.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                   IS_ORDERED);

    initEClass(mmTypeEClass, MMType.class, "MMType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMMType_Dynamic(), ecorePackage.getEBoolean(), "dynamic", null, 1, 1, MMType.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMMType_Supertype(), this.getMMType(), this.getMMType_Subtypes(), "supertype", null, 0, 1,
                   MMType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                   !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMMType_Subtypes(), this.getMMType(), this.getMMType_Supertype(), "subtypes", null, 0, -1,
                   MMType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                   !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMType_Abstract(), ecorePackage.getEBoolean(), "abstract", null, 1, 1, MMType.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                   IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //MMPackageImpl
