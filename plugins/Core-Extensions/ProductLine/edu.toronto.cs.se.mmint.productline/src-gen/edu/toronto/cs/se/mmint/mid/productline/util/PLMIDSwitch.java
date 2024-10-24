/*******************************************************************************
 * Copyright (c) 2021, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.mid.productline.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.productline.PLBinaryModelRel;
import edu.toronto.cs.se.mmint.mid.productline.PLMIDPackage;
import edu.toronto.cs.se.mmint.mid.productline.PLMapping;
import edu.toronto.cs.se.mmint.mid.productline.PLMappingReference;
import edu.toronto.cs.se.mmint.mid.productline.PLModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.productline.PLElement;

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
 * @see edu.toronto.cs.se.mmint.mid.productline.PLMIDPackage
 * @generated
 */
public class PLMIDSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static PLMIDPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PLMIDSwitch() {
    if (PLMIDSwitch.modelPackage == null) {
      PLMIDSwitch.modelPackage = PLMIDPackage.eINSTANCE;
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
    return ePackage == PLMIDSwitch.modelPackage;
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
    case PLMIDPackage.PL_MODEL_REL: {
      var plModelRel = (PLModelRel) theEObject;
      var result = casePLModelRel(plModelRel);
      if (result == null) {
        result = caseModelRel(plModelRel);
      }
      if (result == null) {
        result = caseModel(plModelRel);
      }
      if (result == null) {
        result = caseGenericElement(plModelRel);
      }
      if (result == null) {
        result = caseExtendibleElement(plModelRel);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case PLMIDPackage.PL_BINARY_MODEL_REL: {
      var plBinaryModelRel = (PLBinaryModelRel) theEObject;
      var result = casePLBinaryModelRel(plBinaryModelRel);
      if (result == null) {
        result = caseBinaryModelRel(plBinaryModelRel);
      }
      if (result == null) {
        result = casePLModelRel(plBinaryModelRel);
      }
      if (result == null) {
        result = caseModelRel(plBinaryModelRel);
      }
      if (result == null) {
        result = caseModel(plBinaryModelRel);
      }
      if (result == null) {
        result = caseGenericElement(plBinaryModelRel);
      }
      if (result == null) {
        result = caseExtendibleElement(plBinaryModelRel);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case PLMIDPackage.PL_MAPPING: {
      var plMapping = (PLMapping) theEObject;
      var result = casePLMapping(plMapping);
      if (result == null) {
        result = caseMapping(plMapping);
      }
      if (result == null) {
        result = casePLElement(plMapping);
      }
      if (result == null) {
        result = caseExtendibleElement(plMapping);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case PLMIDPackage.PL_BINARY_MAPPING: {
      var plBinaryMapping = (PLBinaryMapping) theEObject;
      var result = casePLBinaryMapping(plBinaryMapping);
      if (result == null) {
        result = caseBinaryMapping(plBinaryMapping);
      }
      if (result == null) {
        result = casePLMapping(plBinaryMapping);
      }
      if (result == null) {
        result = caseMapping(plBinaryMapping);
      }
      if (result == null) {
        result = casePLElement(plBinaryMapping);
      }
      if (result == null) {
        result = caseExtendibleElement(plBinaryMapping);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case PLMIDPackage.PL_MAPPING_REFERENCE: {
      var plMappingReference = (PLMappingReference) theEObject;
      var result = casePLMappingReference(plMappingReference);
      if (result == null) {
        result = caseMappingReference(plMappingReference);
      }
      if (result == null) {
        result = caseExtendibleElementReference(plMappingReference);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    case PLMIDPackage.PL_BINARY_MAPPING_REFERENCE: {
      var plBinaryMappingReference = (PLBinaryMappingReference) theEObject;
      var result = casePLBinaryMappingReference(plBinaryMappingReference);
      if (result == null) {
        result = caseBinaryMappingReference(plBinaryMappingReference);
      }
      if (result == null) {
        result = casePLMappingReference(plBinaryMappingReference);
      }
      if (result == null) {
        result = caseMappingReference(plBinaryMappingReference);
      }
      if (result == null) {
        result = caseExtendibleElementReference(plBinaryMappingReference);
      }
      if (result == null) {
        result = defaultCase(theEObject);
      }
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>PL Model Rel</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PL Model Rel</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePLModelRel(PLModelRel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>PL Binary Model Rel</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PL Binary Model Rel</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePLBinaryModelRel(PLBinaryModelRel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>PL Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PL Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePLMapping(PLMapping object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>PL Binary Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PL Binary Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePLBinaryMapping(PLBinaryMapping object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>PL Mapping Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PL Mapping Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePLMappingReference(PLMappingReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>PL Binary Mapping Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PL Binary Mapping Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePLBinaryMappingReference(PLBinaryMappingReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extendible Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extendible Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtendibleElement(ExtendibleElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Generic Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Generic Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGenericElement(GenericElement object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Model Rel</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Rel</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModelRel(ModelRel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Model Rel</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Model Rel</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryModelRel(BinaryModelRel object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMapping(Mapping object) {
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
  public T casePLElement(PLElement object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryMapping(BinaryMapping object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Extendible Element Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extendible Element Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExtendibleElementReference(ExtendibleElementReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingReference(MappingReference object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Mapping Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Mapping Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryMappingReference(BinaryMappingReference object) {
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

} //PLMIDSwitch
