/**
 */
package edu.toronto.cs.se.mmint3.mm;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMFactory
 * @model kind="package"
 * @generated
 */
public class MMPackage extends EPackageImpl {
  /**
   * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String eNAME = "mm";

  /**
   * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String eNS_URI = "edu.toronto.cs.se.mmint.mm";

  /**
   * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final String eNS_PREFIX = "mm";

  /**
   * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final MMPackage eINSTANCE = edu.toronto.cs.se.mmint3.mm.MMPackage.init();

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.MegaModel <em>Mega Model</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.MegaModel
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMegaModel()
   * @generated
   */
  public static final int MEGA_MODEL = 0;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MEGA_MODEL__MODELS = 0;

  /**
   * The number of structural features of the '<em>Mega Model</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MEGA_MODEL_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Mega Model</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MEGA_MODEL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.Element <em>Element</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.Element
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getElement()
   * @generated
   */
  public static final int ELEMENT = 10;

  /**
   * The number of structural features of the '<em>Element</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int ELEMENT_FEATURE_COUNT = 0;

  /**
   * The operation id for the '<em>Get Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int ELEMENT___GET_ID = 0;

  /**
   * The operation id for the '<em>Set Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int ELEMENT___SET_ID__STRING = 1;

  /**
   * The operation id for the '<em>Get Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int ELEMENT___GET_NAME = 2;

  /**
   * The operation id for the '<em>Set Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int ELEMENT___SET_NAME__STRING = 3;

  /**
   * The number of operations of the '<em>Element</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int ELEMENT_OPERATION_COUNT = 4;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.MMElement <em>Element</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.MMElement
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMElement()
   * @generated
   */
  public static final int MM_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_ELEMENT__ID = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_ELEMENT__NAME = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Element</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_ELEMENT___GET_ID = ELEMENT___GET_ID;

  /**
   * The operation id for the '<em>Set Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_ELEMENT___SET_ID__STRING = ELEMENT___SET_ID__STRING;

  /**
   * The operation id for the '<em>Get Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_ELEMENT___GET_NAME = ELEMENT___GET_NAME;

  /**
   * The operation id for the '<em>Set Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_ELEMENT___SET_NAME__STRING = ELEMENT___SET_NAME__STRING;

  /**
   * The number of operations of the '<em>Element</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.TypeMegaModel <em>Type Mega Model</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.TypeMegaModel
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getTypeMegaModel()
   * @generated
   */
  public static final int TYPE_MEGA_MODEL = 2;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE_MEGA_MODEL__MODELS = MEGA_MODEL__MODELS;

  /**
   * The number of structural features of the '<em>Type Mega Model</em>' class. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE_MEGA_MODEL_FEATURE_COUNT = MEGA_MODEL_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Type Mega Model</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE_MEGA_MODEL_OPERATION_COUNT = MEGA_MODEL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.InstanceMegaModel <em>Instance Mega Model</em>}'
   * class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.InstanceMegaModel
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getInstanceMegaModel()
   * @generated
   */
  public static final int INSTANCE_MEGA_MODEL = 3;

  /**
   * The feature id for the '<em><b>Models</b></em>' containment reference list. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE_MEGA_MODEL__MODELS = MEGA_MODEL__MODELS;

  /**
   * The number of structural features of the '<em>Instance Mega Model</em>' class. <!-- begin-user-doc --> <!--
   * end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE_MEGA_MODEL_FEATURE_COUNT = MEGA_MODEL_FEATURE_COUNT + 0;

  /**
   * The number of operations of the '<em>Instance Mega Model</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE_MEGA_MODEL_OPERATION_COUNT = MEGA_MODEL_OPERATION_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.Model <em>Model</em>}' class. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.Model
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModel()
   * @generated
   */
  public static final int MODEL = 4;

  /**
   * The number of structural features of the '<em>Model</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_FEATURE_COUNT = 0;

  /**
   * The number of operations of the '<em>Model</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.ModelType <em>Model Type</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.ModelType
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelType()
   * @generated
   */
  public static final int MODEL_TYPE = 5;

  /**
   * The feature id for the '<em><b>T</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE__T = MODEL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Model Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 1;

  /**
   * The operation id for the '<em>Get Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___GET_ID = MODEL_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Set Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___SET_ID__STRING = MODEL_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___GET_NAME = MODEL_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Set Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___SET_NAME__STRING = MODEL_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Is Dynamic</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___IS_DYNAMIC = MODEL_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Set Dynamic</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___SET_DYNAMIC__BOOLEAN = MODEL_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Is Abstract</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___IS_ABSTRACT = MODEL_OPERATION_COUNT + 6;

  /**
   * The operation id for the '<em>Set Abstract</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___SET_ABSTRACT__BOOLEAN = MODEL_OPERATION_COUNT + 7;

  /**
   * The operation id for the '<em>Get Supertype</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___GET_SUPERTYPE = MODEL_OPERATION_COUNT + 8;

  /**
   * The operation id for the '<em>Set Supertype</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___SET_SUPERTYPE__MMTYPE = MODEL_OPERATION_COUNT + 9;

  /**
   * The operation id for the '<em>Get Subtypes</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___GET_SUBTYPES = MODEL_OPERATION_COUNT + 10;

  /**
   * The operation id for the '<em>Get Package</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___GET_PACKAGE = MODEL_OPERATION_COUNT + 11;

  /**
   * The operation id for the '<em>Create Instance</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE___CREATE_INSTANCE__EOBJECT_STRING_BOOLEAN_INSTANCEMEGAMODEL = MODEL_OPERATION_COUNT
    + 12;

  /**
   * The number of operations of the '<em>Model Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_TYPE_OPERATION_COUNT = MODEL_OPERATION_COUNT + 13;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance <em>Model Instance</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.ModelInstance
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelInstance()
   * @generated
   */
  public static final int MODEL_INSTANCE = 6;

  /**
   * The feature id for the '<em><b>I</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE__I = MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Root</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE__ROOT = MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Model Instance</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE_FEATURE_COUNT = MODEL_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE___GET_ID = MODEL_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Set Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE___SET_ID__STRING = MODEL_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE___GET_NAME = MODEL_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Set Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE___SET_NAME__STRING = MODEL_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Type Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE___GET_TYPE_ID = MODEL_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Set Type Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE___SET_TYPE_ID__STRING = MODEL_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get Type</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE___GET_TYPE = MODEL_OPERATION_COUNT + 6;

  /**
   * The number of operations of the '<em>Model Instance</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MODEL_INSTANCE_OPERATION_COUNT = MODEL_OPERATION_COUNT + 7;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.MMInstance <em>Instance</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.MMInstance
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMInstance()
   * @generated
   */
  public static final int MM_INSTANCE = 7;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE__ID = MM_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE__NAME = MM_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Type Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE__TYPE_ID = MM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE__TYPE = MM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Instance</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE_FEATURE_COUNT = MM_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The operation id for the '<em>Get Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE___GET_ID = MM_ELEMENT___GET_ID;

  /**
   * The operation id for the '<em>Set Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE___SET_ID__STRING = MM_ELEMENT___SET_ID__STRING;

  /**
   * The operation id for the '<em>Get Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE___GET_NAME = MM_ELEMENT___GET_NAME;

  /**
   * The operation id for the '<em>Set Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE___SET_NAME__STRING = MM_ELEMENT___SET_NAME__STRING;

  /**
   * The operation id for the '<em>Get Type Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE___GET_TYPE_ID = MM_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Set Type Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE___SET_TYPE_ID__STRING = MM_ELEMENT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Type</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE___GET_TYPE = MM_ELEMENT_OPERATION_COUNT + 2;

  /**
   * The number of operations of the '<em>Instance</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_INSTANCE_OPERATION_COUNT = MM_ELEMENT_OPERATION_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.MMType <em>Type</em>}' class. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.MMType
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType()
   * @generated
   */
  public static final int MM_TYPE = 8;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE__ID = MM_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE__NAME = MM_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Dynamic</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE__DYNAMIC = MM_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Abstract</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE__ABSTRACT = MM_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Subtypes</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE__SUBTYPES = MM_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Supertype</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE__SUPERTYPE = MM_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE_FEATURE_COUNT = MM_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The operation id for the '<em>Get Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___GET_ID = MM_ELEMENT___GET_ID;

  /**
   * The operation id for the '<em>Set Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___SET_ID__STRING = MM_ELEMENT___SET_ID__STRING;

  /**
   * The operation id for the '<em>Get Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___GET_NAME = MM_ELEMENT___GET_NAME;

  /**
   * The operation id for the '<em>Set Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___SET_NAME__STRING = MM_ELEMENT___SET_NAME__STRING;

  /**
   * The operation id for the '<em>Is Dynamic</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___IS_DYNAMIC = MM_ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Set Dynamic</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___SET_DYNAMIC__BOOLEAN = MM_ELEMENT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Is Abstract</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___IS_ABSTRACT = MM_ELEMENT_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Set Abstract</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___SET_ABSTRACT__BOOLEAN = MM_ELEMENT_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Supertype</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___GET_SUPERTYPE = MM_ELEMENT_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Set Supertype</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___SET_SUPERTYPE__MMTYPE = MM_ELEMENT_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get Subtypes</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE___GET_SUBTYPES = MM_ELEMENT_OPERATION_COUNT + 6;

  /**
   * The number of operations of the '<em>Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int MM_TYPE_OPERATION_COUNT = MM_ELEMENT_OPERATION_COUNT + 7;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.Instance <em>Instance</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.Instance
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getInstance()
   * @generated
   */
  public static final int INSTANCE = 9;

  /**
   * The number of structural features of the '<em>Instance</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE___GET_ID = ELEMENT___GET_ID;

  /**
   * The operation id for the '<em>Set Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE___SET_ID__STRING = ELEMENT___SET_ID__STRING;

  /**
   * The operation id for the '<em>Get Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE___GET_NAME = ELEMENT___GET_NAME;

  /**
   * The operation id for the '<em>Set Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE___SET_NAME__STRING = ELEMENT___SET_NAME__STRING;

  /**
   * The operation id for the '<em>Get Type Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE___GET_TYPE_ID = ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Set Type Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE___SET_TYPE_ID__STRING = ELEMENT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Get Type</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE___GET_TYPE = ELEMENT_OPERATION_COUNT + 2;

  /**
   * The number of operations of the '<em>Instance</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int INSTANCE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 3;

  /**
   * The meta object id for the '{@link edu.toronto.cs.se.mmint3.mm.Type <em>Type</em>}' class. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @see edu.toronto.cs.se.mmint3.mm.Type
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getType()
   * @generated
   */
  public static final int TYPE = 11;

  /**
   * The number of structural features of the '<em>Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The operation id for the '<em>Get Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___GET_ID = ELEMENT___GET_ID;

  /**
   * The operation id for the '<em>Set Id</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___SET_ID__STRING = ELEMENT___SET_ID__STRING;

  /**
   * The operation id for the '<em>Get Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___GET_NAME = ELEMENT___GET_NAME;

  /**
   * The operation id for the '<em>Set Name</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___SET_NAME__STRING = ELEMENT___SET_NAME__STRING;

  /**
   * The operation id for the '<em>Is Dynamic</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___IS_DYNAMIC = ELEMENT_OPERATION_COUNT + 0;

  /**
   * The operation id for the '<em>Set Dynamic</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___SET_DYNAMIC__BOOLEAN = ELEMENT_OPERATION_COUNT + 1;

  /**
   * The operation id for the '<em>Is Abstract</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___IS_ABSTRACT = ELEMENT_OPERATION_COUNT + 2;

  /**
   * The operation id for the '<em>Set Abstract</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___SET_ABSTRACT__BOOLEAN = ELEMENT_OPERATION_COUNT + 3;

  /**
   * The operation id for the '<em>Get Supertype</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___GET_SUPERTYPE = ELEMENT_OPERATION_COUNT + 4;

  /**
   * The operation id for the '<em>Set Supertype</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___SET_SUPERTYPE__MMTYPE = ELEMENT_OPERATION_COUNT + 5;

  /**
   * The operation id for the '<em>Get Subtypes</em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE___GET_SUBTYPES = ELEMENT_OPERATION_COUNT + 6;

  /**
   * The number of operations of the '<em>Type</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   * @ordered
   */
  public static final int TYPE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 7;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass megaModelEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass mmElementEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass typeMegaModelEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass instanceMegaModelEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass modelTypeEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass modelInstanceEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass mmInstanceEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass mmTypeEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass instanceEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass elementEClass = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
   * EPackage.Registry} by the package package URI value.
   * <p>
   * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
   * performs initialization of the package, or returns the registered package, if one already exists. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see edu.toronto.cs.se.mmint3.mm.MMPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private MMPackage() {
    super(eNS_URI, MMFactory.eINSTANCE);
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
   * This method is used to initialize {@link MMPackage#eINSTANCE} when that field is accessed. Clients should not
   * invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
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
    MMPackage theMMPackage = registeredMMPackage instanceof MMPackage ? (MMPackage) registeredMMPackage
      : new MMPackage();

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
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.MegaModel <em>Mega Model</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Mega Model</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MegaModel
   * @generated
   */
  public EClass getMegaModel() {
    return this.megaModelEClass;
  }

  /**
   * Returns the meta object for the containment reference list '{@link edu.toronto.cs.se.mmint3.mm.MegaModel#getModels
   * <em>Models</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Models</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MegaModel#getModels()
   * @see #getMegaModel()
   * @generated
   */
  public EReference getMegaModel_Models() {
    return (EReference) this.megaModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.MMElement <em>Element</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Element</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMElement
   * @generated
   */
  public EClass getMMElement() {
    return this.mmElementEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMElement#getId <em>Id</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMElement#getId()
   * @see #getMMElement()
   * @generated
   */
  public EAttribute getMMElement_Id() {
    return (EAttribute) this.mmElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMElement#getName()
   * @see #getMMElement()
   * @generated
   */
  public EAttribute getMMElement_Name() {
    return (EAttribute) this.mmElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.TypeMegaModel <em>Type Mega Model</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Type Mega Model</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.TypeMegaModel
   * @generated
   */
  public EClass getTypeMegaModel() {
    return this.typeMegaModelEClass;
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.InstanceMegaModel <em>Instance Mega
   * Model</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Instance Mega Model</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.InstanceMegaModel
   * @generated
   */
  public EClass getInstanceMegaModel() {
    return this.instanceMegaModelEClass;
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.Model <em>Model</em>}'. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Model</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.Model
   * @generated
   */
  public EClass getModel() {
    return this.modelEClass;
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.ModelType <em>Model Type</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Model Type</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelType
   * @generated
   */
  public EClass getModelType() {
    return this.modelTypeEClass;
  }

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint3.mm.ModelType#getT
   * <em>T</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>T</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelType#getT()
   * @see #getModelType()
   * @generated
   */
  public EReference getModelType_T() {
    return (EReference) this.modelTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.ModelType#getPackage() <em>Get Package</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Get Package</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.ModelType#getPackage()
   * @generated
   */
  public EOperation getModelType__GetPackage() {
    return this.modelTypeEClass.getEOperations().get(0);
  }

  /**
   * Returns the meta object for the
   * '{@link edu.toronto.cs.se.mmint3.mm.ModelType#createInstance(org.eclipse.emf.ecore.EObject, java.lang.String, boolean, edu.toronto.cs.se.mmint3.mm.InstanceMegaModel)
   * <em>Create Instance</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Create Instance</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.ModelType#createInstance(org.eclipse.emf.ecore.EObject, java.lang.String, boolean,
   *      edu.toronto.cs.se.mmint3.mm.InstanceMegaModel)
   * @generated
   */
  public EOperation getModelType__CreateInstance__EObject_String_boolean_InstanceMegaModel() {
    return this.modelTypeEClass.getEOperations().get(1);
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance <em>Model Instance</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Model Instance</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelInstance
   * @generated
   */
  public EClass getModelInstance() {
    return this.modelInstanceEClass;
  }

  /**
   * Returns the meta object for the containment reference '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getI
   * <em>I</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference '<em>I</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelInstance#getI()
   * @see #getModelInstance()
   * @generated
   */
  public EReference getModelInstance_I() {
    return (EReference) this.modelInstanceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance#getRoot
   * <em>Root</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the reference '<em>Root</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.ModelInstance#getRoot()
   * @see #getModelInstance()
   * @generated
   */
  public EReference getModelInstance_Root() {
    return (EReference) this.modelInstanceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.MMInstance <em>Instance</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Instance</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMInstance
   * @generated
   */
  public EClass getMMInstance() {
    return this.mmInstanceEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMInstance#getTypeId <em>Type
   * Id</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Type Id</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMInstance#getTypeId()
   * @see #getMMInstance()
   * @generated
   */
  public EAttribute getMMInstance_TypeId() {
    return (EAttribute) this.mmInstanceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint3.mm.MMInstance#getType <em>Type</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the reference '<em>Type</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMInstance#getType()
   * @see #getMMInstance()
   * @generated
   */
  public EReference getMMInstance_Type() {
    return (EReference) this.mmInstanceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.MMType <em>Type</em>}'. <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Type</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType
   * @generated
   */
  public EClass getMMType() {
    return this.mmTypeEClass;
  }

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMType#isDynamic <em>Dynamic</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Dynamic</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType#isDynamic()
   * @see #getMMType()
   * @generated
   */
  public EAttribute getMMType_Dynamic() {
    return (EAttribute) this.mmTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * Returns the meta object for the attribute '{@link edu.toronto.cs.se.mmint3.mm.MMType#isAbstract
   * <em>Abstract</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Abstract</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType#isAbstract()
   * @see #getMMType()
   * @generated
   */
  public EAttribute getMMType_Abstract() {
    return (EAttribute) this.mmTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * Returns the meta object for the reference list '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes
   * <em>Subtypes</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the reference list '<em>Subtypes</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType#getSubtypes()
   * @see #getMMType()
   * @generated
   */
  public EReference getMMType_Subtypes() {
    return (EReference) this.mmTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * Returns the meta object for the reference '{@link edu.toronto.cs.se.mmint3.mm.MMType#getSupertype
   * <em>Supertype</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the reference '<em>Supertype</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.MMType#getSupertype()
   * @see #getMMType()
   * @generated
   */
  public EReference getMMType_Supertype() {
    return (EReference) this.mmTypeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.Instance <em>Instance</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Instance</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.Instance
   * @generated
   */
  public EClass getInstance() {
    return this.instanceEClass;
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Instance#getTypeId() <em>Get Type Id</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Get Type Id</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Instance#getTypeId()
   * @generated
   */
  public EOperation getInstance__GetTypeId() {
    return this.instanceEClass.getEOperations().get(0);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Instance#setTypeId(java.lang.String) <em>Set
   * Type Id</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Set Type Id</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Instance#setTypeId(java.lang.String)
   * @generated
   */
  public EOperation getInstance__SetTypeId__String() {
    return this.instanceEClass.getEOperations().get(1);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Instance#getType() <em>Get Type</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Get Type</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Instance#getType()
   * @generated
   */
  public EOperation getInstance__GetType() {
    return this.instanceEClass.getEOperations().get(2);
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.Element <em>Element</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Element</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.Element
   * @generated
   */
  public EClass getElement() {
    return this.elementEClass;
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Element#getId() <em>Get Id</em>}' operation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Get Id</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Element#getId()
   * @generated
   */
  public EOperation getElement__GetId() {
    return this.elementEClass.getEOperations().get(0);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Element#setId(java.lang.String) <em>Set
   * Id</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Set Id</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Element#setId(java.lang.String)
   * @generated
   */
  public EOperation getElement__SetId__String() {
    return this.elementEClass.getEOperations().get(1);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Element#getName() <em>Get Name</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Get Name</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Element#getName()
   * @generated
   */
  public EOperation getElement__GetName() {
    return this.elementEClass.getEOperations().get(2);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Element#setName(java.lang.String) <em>Set
   * Name</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Set Name</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Element#setName(java.lang.String)
   * @generated
   */
  public EOperation getElement__SetName__String() {
    return this.elementEClass.getEOperations().get(3);
  }

  /**
   * Returns the meta object for class '{@link edu.toronto.cs.se.mmint3.mm.Type <em>Type</em>}'. <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Type</em>'.
   * @see edu.toronto.cs.se.mmint3.mm.Type
   * @generated
   */
  public EClass getType() {
    return this.typeEClass;
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Type#isDynamic() <em>Is Dynamic</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Is Dynamic</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Type#isDynamic()
   * @generated
   */
  public EOperation getType__IsDynamic() {
    return this.typeEClass.getEOperations().get(0);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Type#setDynamic(boolean) <em>Set Dynamic</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Set Dynamic</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Type#setDynamic(boolean)
   * @generated
   */
  public EOperation getType__SetDynamic__boolean() {
    return this.typeEClass.getEOperations().get(1);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Type#isAbstract() <em>Is Abstract</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Is Abstract</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Type#isAbstract()
   * @generated
   */
  public EOperation getType__IsAbstract() {
    return this.typeEClass.getEOperations().get(2);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Type#setAbstract(boolean) <em>Set
   * Abstract</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Set Abstract</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Type#setAbstract(boolean)
   * @generated
   */
  public EOperation getType__SetAbstract__boolean() {
    return this.typeEClass.getEOperations().get(3);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Type#getSupertype() <em>Get Supertype</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Get Supertype</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Type#getSupertype()
   * @generated
   */
  public EOperation getType__GetSupertype() {
    return this.typeEClass.getEOperations().get(4);
  }

  /**
   * Returns the meta object for the
   * '{@link edu.toronto.cs.se.mmint3.mm.Type#setSupertype(edu.toronto.cs.se.mmint3.mm.MMType) <em>Set Supertype</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Set Supertype</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Type#setSupertype(edu.toronto.cs.se.mmint3.mm.MMType)
   * @generated
   */
  public EOperation getType__SetSupertype__MMType() {
    return this.typeEClass.getEOperations().get(5);
  }

  /**
   * Returns the meta object for the '{@link edu.toronto.cs.se.mmint3.mm.Type#getSubtypes() <em>Get Subtypes</em>}'
   * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the '<em>Get Subtypes</em>' operation.
   * @see edu.toronto.cs.se.mmint3.mm.Type#getSubtypes()
   * @generated
   */
  public EOperation getType__GetSubtypes() {
    return this.typeEClass.getEOperations().get(6);
  }

  /**
   * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the factory that creates the instances of the model.
   * @generated
   */
  public MMFactory getMMFactory() {
    return (MMFactory) getEFactoryInstance();
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
    this.megaModelEClass = createEClass(MEGA_MODEL);
    createEReference(this.megaModelEClass, MEGA_MODEL__MODELS);

    this.mmElementEClass = createEClass(MM_ELEMENT);
    createEAttribute(this.mmElementEClass, MM_ELEMENT__ID);
    createEAttribute(this.mmElementEClass, MM_ELEMENT__NAME);

    this.typeMegaModelEClass = createEClass(TYPE_MEGA_MODEL);

    this.instanceMegaModelEClass = createEClass(INSTANCE_MEGA_MODEL);

    this.modelEClass = createEClass(MODEL);

    this.modelTypeEClass = createEClass(MODEL_TYPE);
    createEReference(this.modelTypeEClass, MODEL_TYPE__T);
    createEOperation(this.modelTypeEClass, MODEL_TYPE___GET_PACKAGE);
    createEOperation(this.modelTypeEClass, MODEL_TYPE___CREATE_INSTANCE__EOBJECT_STRING_BOOLEAN_INSTANCEMEGAMODEL);

    this.modelInstanceEClass = createEClass(MODEL_INSTANCE);
    createEReference(this.modelInstanceEClass, MODEL_INSTANCE__I);
    createEReference(this.modelInstanceEClass, MODEL_INSTANCE__ROOT);

    this.mmInstanceEClass = createEClass(MM_INSTANCE);
    createEAttribute(this.mmInstanceEClass, MM_INSTANCE__TYPE_ID);
    createEReference(this.mmInstanceEClass, MM_INSTANCE__TYPE);

    this.mmTypeEClass = createEClass(MM_TYPE);
    createEAttribute(this.mmTypeEClass, MM_TYPE__DYNAMIC);
    createEAttribute(this.mmTypeEClass, MM_TYPE__ABSTRACT);
    createEReference(this.mmTypeEClass, MM_TYPE__SUBTYPES);
    createEReference(this.mmTypeEClass, MM_TYPE__SUPERTYPE);

    this.instanceEClass = createEClass(INSTANCE);
    createEOperation(this.instanceEClass, INSTANCE___GET_TYPE_ID);
    createEOperation(this.instanceEClass, INSTANCE___SET_TYPE_ID__STRING);
    createEOperation(this.instanceEClass, INSTANCE___GET_TYPE);

    this.elementEClass = createEClass(ELEMENT);
    createEOperation(this.elementEClass, ELEMENT___GET_ID);
    createEOperation(this.elementEClass, ELEMENT___SET_ID__STRING);
    createEOperation(this.elementEClass, ELEMENT___GET_NAME);
    createEOperation(this.elementEClass, ELEMENT___SET_NAME__STRING);

    this.typeEClass = createEClass(TYPE);
    createEOperation(this.typeEClass, TYPE___IS_DYNAMIC);
    createEOperation(this.typeEClass, TYPE___SET_DYNAMIC__BOOLEAN);
    createEOperation(this.typeEClass, TYPE___IS_ABSTRACT);
    createEOperation(this.typeEClass, TYPE___SET_ABSTRACT__BOOLEAN);
    createEOperation(this.typeEClass, TYPE___GET_SUPERTYPE);
    createEOperation(this.typeEClass, TYPE___SET_SUPERTYPE__MMTYPE);
    createEOperation(this.typeEClass, TYPE___GET_SUBTYPES);
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
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    this.mmElementEClass.getESuperTypes().add(this.getElement());
    this.typeMegaModelEClass.getESuperTypes().add(this.getMegaModel());
    this.instanceMegaModelEClass.getESuperTypes().add(this.getMegaModel());
    this.modelTypeEClass.getESuperTypes().add(this.getModel());
    this.modelTypeEClass.getESuperTypes().add(this.getType());
    this.modelInstanceEClass.getESuperTypes().add(this.getModel());
    this.modelInstanceEClass.getESuperTypes().add(this.getInstance());
    this.mmInstanceEClass.getESuperTypes().add(this.getMMElement());
    this.mmInstanceEClass.getESuperTypes().add(this.getInstance());
    this.mmTypeEClass.getESuperTypes().add(this.getMMElement());
    this.mmTypeEClass.getESuperTypes().add(this.getType());
    this.instanceEClass.getESuperTypes().add(this.getElement());
    this.typeEClass.getESuperTypes().add(this.getElement());

    // Initialize classes, features, and operations; add parameters
    initEClass(this.megaModelEClass, MegaModel.class, "MegaModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMegaModel_Models(), this.getModel(), null, "models", null, 0, -1, MegaModel.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                   !IS_DERIVED, IS_ORDERED);

    initEClass(this.mmElementEClass, MMElement.class, "MMElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMMElement_Id(), this.ecorePackage.getEString(), "id", null, 1, 1, MMElement.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMElement_Name(), this.ecorePackage.getEString(), "name", null, 1, 1, MMElement.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(this.typeMegaModelEClass, TypeMegaModel.class, "TypeMegaModel", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.instanceMegaModelEClass, InstanceMegaModel.class, "InstanceMegaModel", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.modelEClass, Model.class, "Model", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(this.modelTypeEClass, ModelType.class, "ModelType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelType_T(), this.getMMType(), null, "t", null, 1, 1, ModelType.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                   !IS_DERIVED, IS_ORDERED);

    initEOperation(getModelType__GetPackage(), this.ecorePackage.getEPackage(), "getPackage", 1, 1, IS_UNIQUE, IS_ORDERED);

    EOperation op = initEOperation(getModelType__CreateInstance__EObject_String_boolean_InstanceMegaModel(), this
                                                                                                                 .getModelInstance(),
                                   "createInstance", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEObject(), "root", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "path", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "serialize", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getInstanceMegaModel(), "mm", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(this.modelInstanceEClass, ModelInstance.class, "ModelInstance", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModelInstance_I(), this.getMMInstance(), null, "i", null, 1, 1, ModelInstance.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                   IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModelInstance_Root(), this.ecorePackage.getEObject(), null, "root", null, 0, 1, ModelInstance.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                   IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(this.mmInstanceEClass, MMInstance.class, "MMInstance", !IS_ABSTRACT, !IS_INTERFACE,
               IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMMInstance_TypeId(), this.ecorePackage.getEString(), "typeId", null, 1, 1, MMInstance.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                   IS_ORDERED);
    initEReference(getMMInstance_Type(), this.getMMType(), null, "type", null, 1, 1, MMInstance.class, IS_TRANSIENT,
                   IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                   IS_DERIVED, IS_ORDERED);

    initEClass(this.mmTypeEClass, MMType.class, "MMType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMMType_Dynamic(), this.ecorePackage.getEBoolean(), "dynamic", null, 1, 1, MMType.class, !IS_TRANSIENT,
                   !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMMType_Abstract(), this.ecorePackage.getEBoolean(), "abstract", null, 1, 1, MMType.class,
                   !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                   IS_ORDERED);
    initEReference(getMMType_Subtypes(), this.getMMType(), this.getMMType_Supertype(), "subtypes", null, 0, -1,
                   MMType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                   !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMMType_Supertype(), this.getMMType(), this.getMMType_Subtypes(), "supertype", null, 0, 1,
                   MMType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                   !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(this.instanceEClass, Instance.class, "Instance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getInstance__GetTypeId(), this.ecorePackage.getEString(), "getTypeId", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getInstance__SetTypeId__String(), null, "setTypeId", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getInstance__GetType(), this.getMMType(), "getType", 1, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(this.elementEClass, Element.class, "Element", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getElement__GetId(), this.ecorePackage.getEString(), "getId", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getElement__SetId__String(), null, "setId", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getElement__GetName(), this.ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getElement__SetName__String(), null, "setName", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(this.typeEClass, Type.class, "Type", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEOperation(getType__IsDynamic(), this.ecorePackage.getEBoolean(), "isDynamic", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getType__SetDynamic__boolean(), null, "setDynamic", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getType__IsAbstract(), this.ecorePackage.getEBoolean(), "isAbstract", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getType__SetAbstract__boolean(), null, "setAbstract", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.ecorePackage.getEBoolean(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getType__GetSupertype(), this.getMMType(), "getSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);

    op = initEOperation(getType__SetSupertype__MMType(), null, "setSupertype", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getMMType(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEOperation(getType__GetSubtypes(), this.getMMType(), "getSubtypes", 0, -1, IS_UNIQUE, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each operation of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   *
   * @generated
   */
  public interface Literals {
    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.MegaModel <em>Mega Model</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.MegaModel
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMegaModel()
     * @generated
     */
    public static final EClass MEGA_MODEL = eINSTANCE.getMegaModel();

    /**
     * The meta object literal for the '<em><b>Models</b></em>' containment reference list feature. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final EReference MEGA_MODEL__MODELS = eINSTANCE.getMegaModel_Models();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.MMElement <em>Element</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.MMElement
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMElement()
     * @generated
     */
    public static final EClass MM_ELEMENT = eINSTANCE.getMMElement();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    public static final EAttribute MM_ELEMENT__ID = eINSTANCE.getMMElement_Id();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EAttribute MM_ELEMENT__NAME = eINSTANCE.getMMElement_Name();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.TypeMegaModel <em>Type Mega Model</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.TypeMegaModel
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getTypeMegaModel()
     * @generated
     */
    public static final EClass TYPE_MEGA_MODEL = eINSTANCE.getTypeMegaModel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.InstanceMegaModel <em>Instance Mega
     * Model</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.InstanceMegaModel
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getInstanceMegaModel()
     * @generated
     */
    public static final EClass INSTANCE_MEGA_MODEL = eINSTANCE.getInstanceMegaModel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.Model <em>Model</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.Model
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModel()
     * @generated
     */
    public static final EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.ModelType <em>Model Type</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.ModelType
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelType()
     * @generated
     */
    public static final EClass MODEL_TYPE = eINSTANCE.getModelType();

    /**
     * The meta object literal for the '<em><b>T</b></em>' containment reference feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EReference MODEL_TYPE__T = eINSTANCE.getModelType_T();

    /**
     * The meta object literal for the '<em><b>Get Package</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation MODEL_TYPE___GET_PACKAGE = eINSTANCE.getModelType__GetPackage();

    /**
     * The meta object literal for the '<em><b>Create Instance</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation MODEL_TYPE___CREATE_INSTANCE__EOBJECT_STRING_BOOLEAN_INSTANCEMEGAMODEL = eINSTANCE.getModelType__CreateInstance__EObject_String_boolean_InstanceMegaModel();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.ModelInstance <em>Model Instance</em>}'
     * class. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.ModelInstance
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getModelInstance()
     * @generated
     */
    public static final EClass MODEL_INSTANCE = eINSTANCE.getModelInstance();

    /**
     * The meta object literal for the '<em><b>I</b></em>' containment reference feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EReference MODEL_INSTANCE__I = eINSTANCE.getModelInstance_I();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' reference feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EReference MODEL_INSTANCE__ROOT = eINSTANCE.getModelInstance_Root();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.MMInstance <em>Instance</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.MMInstance
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMInstance()
     * @generated
     */
    public static final EClass MM_INSTANCE = eINSTANCE.getMMInstance();

    /**
     * The meta object literal for the '<em><b>Type Id</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EAttribute MM_INSTANCE__TYPE_ID = eINSTANCE.getMMInstance_TypeId();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EReference MM_INSTANCE__TYPE = eINSTANCE.getMMInstance_Type();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.MMType <em>Type</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.MMType
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getMMType()
     * @generated
     */
    public static final EClass MM_TYPE = eINSTANCE.getMMType();

    /**
     * The meta object literal for the '<em><b>Dynamic</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EAttribute MM_TYPE__DYNAMIC = eINSTANCE.getMMType_Dynamic();

    /**
     * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EAttribute MM_TYPE__ABSTRACT = eINSTANCE.getMMType_Abstract();

    /**
     * The meta object literal for the '<em><b>Subtypes</b></em>' reference list feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EReference MM_TYPE__SUBTYPES = eINSTANCE.getMMType_Subtypes();

    /**
     * The meta object literal for the '<em><b>Supertype</b></em>' reference feature. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EReference MM_TYPE__SUPERTYPE = eINSTANCE.getMMType_Supertype();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.Instance <em>Instance</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.Instance
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getInstance()
     * @generated
     */
    public static final EClass INSTANCE = eINSTANCE.getInstance();

    /**
     * The meta object literal for the '<em><b>Get Type Id</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation INSTANCE___GET_TYPE_ID = eINSTANCE.getInstance__GetTypeId();

    /**
     * The meta object literal for the '<em><b>Set Type Id</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation INSTANCE___SET_TYPE_ID__STRING = eINSTANCE.getInstance__SetTypeId__String();

    /**
     * The meta object literal for the '<em><b>Get Type</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    public static final EOperation INSTANCE___GET_TYPE = eINSTANCE.getInstance__GetType();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.Element <em>Element</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.Element
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getElement()
     * @generated
     */
    public static final EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '<em><b>Get Id</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final EOperation ELEMENT___GET_ID = eINSTANCE.getElement__GetId();

    /**
     * The meta object literal for the '<em><b>Set Id</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final EOperation ELEMENT___SET_ID__STRING = eINSTANCE.getElement__SetId__String();

    /**
     * The meta object literal for the '<em><b>Get Name</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    public static final EOperation ELEMENT___GET_NAME = eINSTANCE.getElement__GetName();

    /**
     * The meta object literal for the '<em><b>Set Name</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    public static final EOperation ELEMENT___SET_NAME__STRING = eINSTANCE.getElement__SetName__String();

    /**
     * The meta object literal for the '{@link edu.toronto.cs.se.mmint3.mm.Type <em>Type</em>}' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see edu.toronto.cs.se.mmint3.mm.Type
     * @see edu.toronto.cs.se.mmint3.mm.MMPackage#getType()
     * @generated
     */
    public static final EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '<em><b>Is Dynamic</b></em>' operation. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    public static final EOperation TYPE___IS_DYNAMIC = eINSTANCE.getType__IsDynamic();

    /**
     * The meta object literal for the '<em><b>Set Dynamic</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation TYPE___SET_DYNAMIC__BOOLEAN = eINSTANCE.getType__SetDynamic__boolean();

    /**
     * The meta object literal for the '<em><b>Is Abstract</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation TYPE___IS_ABSTRACT = eINSTANCE.getType__IsAbstract();

    /**
     * The meta object literal for the '<em><b>Set Abstract</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation TYPE___SET_ABSTRACT__BOOLEAN = eINSTANCE.getType__SetAbstract__boolean();

    /**
     * The meta object literal for the '<em><b>Get Supertype</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation TYPE___GET_SUPERTYPE = eINSTANCE.getType__GetSupertype();

    /**
     * The meta object literal for the '<em><b>Set Supertype</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation TYPE___SET_SUPERTYPE__MMTYPE = eINSTANCE.getType__SetSupertype__MMType();

    /**
     * The meta object literal for the '<em><b>Get Subtypes</b></em>' operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    public static final EOperation TYPE___GET_SUBTYPES = eINSTANCE.getType__GetSubtypes();

  }

} // MMPackage
