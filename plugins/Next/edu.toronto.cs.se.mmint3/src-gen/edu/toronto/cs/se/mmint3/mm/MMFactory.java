/**
 */
package edu.toronto.cs.se.mmint3.mm;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
    case MMPackage.EDITOR_TYPE:
      return createEditorType();
    case MMPackage.EDITOR_INSTANCE:
      return createEditorInstance();
    case MMPackage.EMF_TREE:
      return createEMFTree();
    case MMPackage.GMF_DIAGRAM:
      return createGMFDiagram();
    case MMPackage.SIRIUS_REPRESENTATION:
      return createSiriusRepresentation();
    default:
      throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
    case MMPackage.EDITOR_KIND:
      return createEditorKindFromString(eDataType, initialValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
    case MMPackage.EDITOR_KIND:
      return convertEditorKindToString(eDataType, instanceValue);
    default:
      throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
  public EditorType createEditorType() {
    EditorType editorType = new EditorType();
    return editorType;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public EditorInstance createEditorInstance() {
    EditorInstance editorInstance = new EditorInstance();
    return editorInstance;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public EMFTree createEMFTree() {
    EMFTree emfTree = new EMFTree();
    return emfTree;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public GMFDiagram createGMFDiagram() {
    GMFDiagram gmfDiagram = new GMFDiagram();
    return gmfDiagram;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public SiriusRepresentation createSiriusRepresentation() {
    SiriusRepresentation siriusRepresentation = new SiriusRepresentation();
    return siriusRepresentation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public EditorKind createEditorKindFromString(EDataType eDataType, String initialValue) {
    EditorKind result = EditorKind.get(initialValue);
    if (result == null)
      throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType
                                                                                                                      .getName()
        + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public String convertEditorKindToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
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
