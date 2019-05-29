/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see edu.toronto.cs.se.mmint3.mm.MMFactory
 * @model kind="package"
 * @generated
 */
public interface MMPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mm";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "edu.toronto.cs.se.mmint.mm";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mm";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MMPackage eINSTANCE = edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.impl.MegaModelImpl <em>Mega Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.impl.MegaModelImpl
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getMegaModel()
   * @generated
   */
  int MEGA_MODEL = 0;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEGA_MODEL__MODELS = 0;

  /**
   * The number of structural features of the '<em>Mega Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEGA_MODEL_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Mega Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MEGA_MODEL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.impl.MMElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMElementImpl
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getMMElement()
   * @generated
   */
  int MM_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_ELEMENT__ID = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_ELEMENT__NAME = 1;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_ELEMENT_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.impl.TypeMegaModelImpl <em>Type Mega Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.impl.TypeMegaModelImpl
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getTypeMegaModel()
   * @generated
   */
  int TYPE_MEGA_MODEL = 2;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_MEGA_MODEL__MODELS = MEGA_MODEL__MODELS;

  /**
   * The number of structural features of the '<em>Type Mega Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_MEGA_MODEL_FEATURE_COUNT = MEGA_MODEL_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Type Mega Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_MEGA_MODEL_OPERATION_COUNT = MEGA_MODEL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.impl.InstanceMegaModelImpl <em>Instance Mega Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.impl.InstanceMegaModelImpl
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getInstanceMegaModel()
   * @generated
   */
  int INSTANCE_MEGA_MODEL = 3;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_MEGA_MODEL__MODELS = MEGA_MODEL__MODELS;

  /**
   * The number of structural features of the '<em>Instance Mega Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_MEGA_MODEL_FEATURE_COUNT = MEGA_MODEL_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Instance Mega Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_MEGA_MODEL_OPERATION_COUNT = MEGA_MODEL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.impl.ModelImpl
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getModel()
   * @generated
   */
  int MODEL = 4;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 0;

  /**
   * The number of operations of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.impl.ModelTypeImpl <em>Model Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.impl.ModelTypeImpl
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getModelType()
   * @generated
   */
  int MODEL_TYPE = 5;

  /**
   * The feature id for the '<em><b>T</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_TYPE__T = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Model Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_TYPE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Is Dynamic</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_TYPE___IS_DYNAMIC = MODEL_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Is Abstract</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_TYPE___IS_ABSTRACT = MODEL_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Package</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_TYPE___GET_PACKAGE = MODEL_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Create Instance</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_TYPE___CREATE_INSTANCE__EOBJECT_STRING_BOOLEAN_INSTANCEMEGAMODEL = MODEL_OPERATION_COUNT + 3;

  /**
   * The number of operations of the '<em>Model Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_TYPE_OPERATION_COUNT = MODEL_OPERATION_COUNT + 4;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.impl.ModelInstanceImpl <em>Model Instance</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.impl.ModelInstanceImpl
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getModelInstance()
   * @generated
   */
  int MODEL_INSTANCE = 6;

  /**
   * The feature id for the '<em><b>I</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_INSTANCE__I = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Root</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_INSTANCE__ROOT = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Model Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_INSTANCE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_INSTANCE___GET_TYPE = MODEL_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Model Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_INSTANCE_OPERATION_COUNT = MODEL_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.Instance <em>Instance</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.Instance
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getInstance()
   * @generated
   */
  int INSTANCE = 7;

  /**
   * The number of structural features of the '<em>Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_FEATURE_COUNT = 0;

  /**
   * The operation id for the '<em>Get Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE___GET_TYPE = 0;

  /**
   * The number of operations of the '<em>Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_OPERATION_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.Type <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.Type
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getType()
   * @generated
   */
  int TYPE = 8;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The operation id for the '<em>Is Dynamic</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE___IS_DYNAMIC = 0;

  /**
   * The operation id for the '<em>Is Abstract</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE___IS_ABSTRACT = 1;

  /**
   * The number of operations of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_OPERATION_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.impl.MMInstanceImpl <em>Instance</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMInstanceImpl
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getMMInstance()
   * @generated
   */
  int MM_INSTANCE = 9;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_INSTANCE__ID = MM_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_INSTANCE__NAME = MM_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Type Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_INSTANCE__TYPE_ID = MM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_INSTANCE_FEATURE_COUNT = MM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Type</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_INSTANCE___GET_TYPE = MM_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The number of operations of the '<em>Instance</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_INSTANCE_OPERATION_COUNT = MM_ELEMENT_OPERATION_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.impl.MMTypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMTypeImpl
   * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getMMType()
   * @generated
   */
  int MM_TYPE = 10;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE__ID = MM_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE__NAME = MM_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE__DYNAMIC = MM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE__SUPERTYPE = MM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Subtypes</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE__SUBTYPES = MM_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE__ABSTRACT = MM_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE_FEATURE_COUNT = MM_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Is Dynamic</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE___IS_DYNAMIC = MM_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Is Abstract</em>' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE___IS_ABSTRACT = MM_ELEMENT_OPERATION_COUNT + 1;

  /**
   * The number of operations of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MM_TYPE_OPERATION_COUNT = MM_ELEMENT_OPERATION_COUNT + 2;

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.MegaModel <em>Mega Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mega Model</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MegaModel
   * @generated
   */
  EClass getMegaModel();

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint3.mm.MegaModel#getModels <em>Models</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Models</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MegaModel#getModels()
   * @see #getMegaModel()
   * @generated
   */
  EReference getMegaModel_Models();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.MMElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMElement
   * @generated
   */
  EClass getMMElement();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMElement#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMElement#getId()
   * @see #getMMElement()
   * @generated
   */
  EAttribute getMMElement_Id();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMElement#getName()
   * @see #getMMElement()
   * @generated
   */
  EAttribute getMMElement_Name();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.TypeMegaModel <em>Type Mega Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Mega Model</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.TypeMegaModel
   * @generated
   */
  EClass getTypeMegaModel();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.InstanceMegaModel <em>Instance Mega Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Mega Model</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.InstanceMegaModel
   * @generated
   */
  EClass getInstanceMegaModel();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.ModelType <em>Model Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Type</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelType
   * @generated
   */
  EClass getModelType();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint3.mm.ModelType#getT <em>T</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>T</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelType#getT()
   * @see #getModelType()
   * @generated
   */
  EReference getModelType_T();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.ModelType#getPackage() <em>Get Package</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Package</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.ModelType#getPackage()
   * @generated
   */
  EOperation getModelType__GetPackage();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.ModelType#createInstance(org.eclipse.emf.ecore.EObject, java.lang.String, boolean, edu.toronto.cs.se.mmint3.mm.InstanceMegaModel) <em>Create Instance</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Create Instance</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.ModelType#createInstance(org.eclipse.emf.ecore.EObject, java.lang.String, boolean, edu.toronto.cs.se.mmint3.mm.InstanceMegaModel)
   * @generated
   */
  EOperation getModelType__CreateInstance__EObject_String_boolean_InstanceMegaModel();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance <em>Model Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Instance</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelInstance
   * @generated
   */
  EClass getModelInstance();

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getI <em>I</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>I</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelInstance#getI()
   * @see #getModelInstance()
   * @generated
   */
  EReference getModelInstance_I();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getRoot <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Root</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelInstance#getRoot()
   * @see #getModelInstance()
   * @generated
   */
  EReference getModelInstance_Root();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.Instance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.Instance
   * @generated
   */
  EClass getInstance();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Instance#getType() <em>Get Type</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Get Type</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Instance#getType()
   * @generated
   */
  EOperation getInstance__GetType();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Type#isDynamic() <em>Is Dynamic</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Dynamic</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Type#isDynamic()
   * @generated
   */
  EOperation getType__IsDynamic();

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Type#isAbstract() <em>Is Abstract</em>}' operation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the '<em>Is Abstract</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Type#isAbstract()
   * @generated
   */
  EOperation getType__IsAbstract();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.MMInstance <em>Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMInstance
   * @generated
   */
  EClass getMMInstance();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMInstance#getTypeId <em>Type Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Id</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMInstance#getTypeId()
   * @see #getMMInstance()
   * @generated
   */
  EAttribute getMMInstance_TypeId();

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.MMType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType
   * @generated
   */
  EClass getMMType();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMType#isDynamic <em>Dynamic</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dynamic</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType#isDynamic()
   * @see #getMMType()
   * @generated
   */
  EAttribute getMMType_Dynamic();

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSupertype <em>Supertype</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Supertype</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType#getSupertype()
   * @see #getMMType()
   * @generated
   */
  EReference getMMType_Supertype();

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes <em>Subtypes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Subtypes</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes()
   * @see #getMMType()
   * @generated
   */
  EReference getMMType_Subtypes();

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMType#isAbstract <em>Abstract</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType#isAbstract()
   * @see #getMMType()
   * @generated
   */
  EAttribute getMMType_Abstract();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MMFactory getMMFactory();

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
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.impl.MegaModelImpl <em>Mega Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.impl.MegaModelImpl
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getMegaModel()
     * @generated
     */
    EClass MEGA_MODEL = eINSTANCE.getMegaModel();

    /**
     * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MEGA_MODEL__MODELS = eINSTANCE.getMegaModel_Models();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.impl.MMElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMElementImpl
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getMMElement()
     * @generated
     */
    EClass MM_ELEMENT = eINSTANCE.getMMElement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MM_ELEMENT__ID = eINSTANCE.getMMElement_Id();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MM_ELEMENT__NAME = eINSTANCE.getMMElement_Name();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.impl.TypeMegaModelImpl <em>Type Mega Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.impl.TypeMegaModelImpl
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getTypeMegaModel()
     * @generated
     */
    EClass TYPE_MEGA_MODEL = eINSTANCE.getTypeMegaModel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.impl.InstanceMegaModelImpl <em>Instance Mega Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.impl.InstanceMegaModelImpl
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getInstanceMegaModel()
     * @generated
     */
    EClass INSTANCE_MEGA_MODEL = eINSTANCE.getInstanceMegaModel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.impl.ModelImpl
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.impl.ModelTypeImpl <em>Model Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.impl.ModelTypeImpl
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getModelType()
     * @generated
     */
    EClass MODEL_TYPE = eINSTANCE.getModelType();

    /**
     * The meta object literal for the '<em><b>T</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_TYPE__T = eINSTANCE.getModelType_T();

    /**
     * The meta object literal for the '<em><b>Get Package</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation MODEL_TYPE___GET_PACKAGE = eINSTANCE.getModelType__GetPackage();

    /**
     * The meta object literal for the '<em><b>Create Instance</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation MODEL_TYPE___CREATE_INSTANCE__EOBJECT_STRING_BOOLEAN_INSTANCEMEGAMODEL = eINSTANCE.getModelType__CreateInstance__EObject_String_boolean_InstanceMegaModel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.impl.ModelInstanceImpl <em>Model Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.impl.ModelInstanceImpl
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getModelInstance()
     * @generated
     */
    EClass MODEL_INSTANCE = eINSTANCE.getModelInstance();

    /**
     * The meta object literal for the '<em><b>I</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_INSTANCE__I = eINSTANCE.getModelInstance_I();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_INSTANCE__ROOT = eINSTANCE.getModelInstance_Root();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.Instance <em>Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.Instance
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getInstance()
     * @generated
     */
    EClass INSTANCE = eINSTANCE.getInstance();

    /**
     * The meta object literal for the '<em><b>Get Type</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation INSTANCE___GET_TYPE = eINSTANCE.getInstance__GetType();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.Type <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.Type
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Is Dynamic</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation TYPE___IS_DYNAMIC = eINSTANCE.getType__IsDynamic();

    /**
     * The meta object literal for the '<em><b>Is Abstract</b></em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EOperation TYPE___IS_ABSTRACT = eINSTANCE.getType__IsAbstract();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.impl.MMInstanceImpl <em>Instance</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMInstanceImpl
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getMMInstance()
     * @generated
     */
    EClass MM_INSTANCE = eINSTANCE.getMMInstance();

    /**
     * The meta object literal for the '<em><b>Type Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MM_INSTANCE__TYPE_ID = eINSTANCE.getMMInstance_TypeId();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.impl.MMTypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMTypeImpl
     * @see edu.toronto.cs.se.mmint3.mm.impl.MMPackageImpl#getMMType()
     * @generated
     */
    EClass MM_TYPE = eINSTANCE.getMMType();

    /**
     * The meta object literal for the '<em><b>Dynamic</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MM_TYPE__DYNAMIC = eINSTANCE.getMMType_Dynamic();

    /**
     * The meta object literal for the '<em><b>Supertype</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MM_TYPE__SUPERTYPE = eINSTANCE.getMMType_Supertype();

    /**
     * The meta object literal for the '<em><b>Subtypes</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MM_TYPE__SUBTYPES = eINSTANCE.getMMType_Subtypes();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MM_TYPE__ABSTRACT = eINSTANCE.getMMType_Abstract();

  }

} //MMPackage
