/**
 */
package edu.toronto.cs.se.mmint3.mm;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 *
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage
 * @generated
 */
public class MMFactory extends EFactoryImpl {
  /**
   * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final MMFactory eINSTANCE = init();

  /**
   * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static MMFactory init() {
    try {
      MMFactory theMMFactory = (MMFactory) EPackage.Registry.INSTANCE.getEFactory(MMPackage.eNS_URI);
      if (theMMFactory != null) {
        return theMMFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MMFactory();
  }

  /**
   * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public MMFactory() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case MMPackage.TYPE_MEGA_MODEL:
      return createTypeMegaModel();
    case MMPackage.INSTANCE_MEGA_MODEL:
      return createInstanceMegaModel();
    case MMPackage.MODEL_TYPE:
      return createModelType();
    case MMPackage.MODEL_INSTANCE:
      return createModelInstance();
    case MMPackage.MM_INSTANCE:
      return createMMInstance();
    case MMPackage.MM_TYPE:
      return createMMType();
    case MMPackage.ESTRING_TO_ELEMENT_MAP:
      return (EObject) createEStringToElementMap();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public TypeMegaModel createTypeMegaModel() {
    TypeMegaModel typeMegaModel = new TypeMegaModel();
    return typeMegaModel;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public InstanceMegaModel createInstanceMegaModel() {
    InstanceMegaModel instanceMegaModel = new InstanceMegaModel();
    return instanceMegaModel;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public ModelType createModelType() {
    ModelType modelType = new ModelType();
    return modelType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public ModelInstance createModelInstance() {
    ModelInstance modelInstance = new ModelInstance();
    return modelInstance;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public MMInstance createMMInstance() {
    MMInstance mmInstance = new MMInstance();
    return mmInstance;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public MMType createMMType() {
    MMType mmType = new MMType();
    return mmType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public Map.Entry<String, Element> createEStringToElementMap() {
    EStringToElementMap eStringToElementMap = new EStringToElementMap();
    return eStringToElementMap;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public MMPackage getMMPackage() {
    return (MMPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MMPackage getPackage() {
    return MMPackage.eINSTANCE;
  }

} // MMFactory
