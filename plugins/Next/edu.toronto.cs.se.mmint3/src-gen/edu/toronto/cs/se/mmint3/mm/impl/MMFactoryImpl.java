/**
 */
package edu.toronto.cs.se.mmint3.mm.impl;

import edu.toronto.cs.se.mmint3.mm.*;
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
public class MMFactoryImpl extends EFactoryImpl implements MMFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
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
    return new MMFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MMFactoryImpl() {
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
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TypeMegaModel createTypeMegaModel() {
    TypeMegaModelImpl typeMegaModel = new TypeMegaModelImpl();
    return typeMegaModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InstanceMegaModel createInstanceMegaModel() {
    InstanceMegaModelImpl instanceMegaModel = new InstanceMegaModelImpl();
    return instanceMegaModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModelType createModelType() {
    ModelTypeImpl modelType = new ModelTypeImpl();
    return modelType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ModelInstance createModelInstance() {
    ModelInstanceImpl modelInstance = new ModelInstanceImpl();
    return modelInstance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MMInstance createMMInstance() {
    MMInstanceImpl mmInstance = new MMInstanceImpl();
    return mmInstance;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MMType createMMType() {
    MMTypeImpl mmType = new MMTypeImpl();
    return mmType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MMPackage getMMPackage() {
    return (MMPackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MMPackage getPackage() {
    return MMPackage.eINSTANCE;
  }

} //MMFactoryImpl
