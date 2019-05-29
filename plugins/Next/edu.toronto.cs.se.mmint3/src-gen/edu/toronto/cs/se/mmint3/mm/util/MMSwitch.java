/**
 */
package edu.toronto.cs.se.mmint3.mm.util;

import edu.toronto.cs.se.mmint3.mm.*;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.toronto.cs.se.mmint3.mm.MMPackage
 * @generated
 */
public class MMSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MMPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MMSwitch() {
    if (modelPackage == null) {
      modelPackage = MMPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage) {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID) {
    case MMPackage.MEGA_MODEL: {
      MegaModel megaModel = (MegaModel) theEObject;
      T result = caseMegaModel(megaModel);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.MM_ELEMENT: {
      MMElement mmElement = (MMElement) theEObject;
      T result = caseMMElement(mmElement);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.TYPE_MEGA_MODEL: {
      TypeMegaModel typeMegaModel = (TypeMegaModel) theEObject;
      T result = caseTypeMegaModel(typeMegaModel);
      if (result == null)
        result = caseMegaModel(typeMegaModel);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.INSTANCE_MEGA_MODEL: {
      InstanceMegaModel instanceMegaModel = (InstanceMegaModel) theEObject;
      T result = caseInstanceMegaModel(instanceMegaModel);
      if (result == null)
        result = caseMegaModel(instanceMegaModel);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.MODEL: {
      Model model = (Model) theEObject;
      T result = caseModel(model);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.MODEL_TYPE: {
      ModelType modelType = (ModelType) theEObject;
      T result = caseModelType(modelType);
      if (result == null)
        result = caseModel(modelType);
      if (result == null)
        result = caseType(modelType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.MODEL_INSTANCE: {
      ModelInstance modelInstance = (ModelInstance) theEObject;
      T result = caseModelInstance(modelInstance);
      if (result == null)
        result = caseModel(modelInstance);
      if (result == null)
        result = caseInstance(modelInstance);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.INSTANCE: {
      Instance instance = (Instance) theEObject;
      T result = caseInstance(instance);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.TYPE: {
      Type type = (Type) theEObject;
      T result = caseType(type);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.MM_INSTANCE: {
      MMInstance mmInstance = (MMInstance) theEObject;
      T result = caseMMInstance(mmInstance);
      if (result == null)
        result = caseMMElement(mmInstance);
      if (result == null)
        result = caseInstance(mmInstance);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case MMPackage.MM_TYPE: {
      MMType mmType = (MMType) theEObject;
      T result = caseMMType(mmType);
      if (result == null)
        result = caseMMElement(mmType);
      if (result == null)
        result = caseType(mmType);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mega Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mega Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMegaModel(MegaModel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMMElement(MMElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Mega Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Mega Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeMegaModel(TypeMegaModel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance Mega Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance Mega Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstanceMegaModel(InstanceMegaModel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelType(ModelType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model Instance</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelInstance(ModelInstance object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInstance(Instance object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Instance</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Instance</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMMInstance(MMInstance object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMMType(MMType object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object) {
    return null;
  }

} //MMSwitch
