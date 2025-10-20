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
package edu.toronto.cs.se.mmint.mid.relationship.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;

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
 * @see edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage
 * @generated
 */
public class RelationshipSwitch<T> extends Switch<T> {
    /**
   * The cached model package
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected static RelationshipPackage modelPackage;

    /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public RelationshipSwitch() {
    if (RelationshipSwitch.modelPackage == null) {
      RelationshipSwitch.modelPackage = RelationshipPackage.eINSTANCE;
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
    return ePackage == RelationshipSwitch.modelPackage;
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
      case RelationshipPackage.MODEL_REL: {
        var modelRel = (ModelRel)theEObject;
        var result = caseModelRel(modelRel);
        if (result == null) {
          result = caseModel(modelRel);
        }
        if (result == null) {
          result = caseGenericElement(modelRel);
        }
        if (result == null) {
          result = caseExtendibleElement(modelRel);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.BINARY_MODEL_REL: {
        var binaryModelRel = (BinaryModelRel)theEObject;
        var result = caseBinaryModelRel(binaryModelRel);
        if (result == null) {
          result = caseModelRel(binaryModelRel);
        }
        if (result == null) {
          result = caseModel(binaryModelRel);
        }
        if (result == null) {
          result = caseGenericElement(binaryModelRel);
        }
        if (result == null) {
          result = caseExtendibleElement(binaryModelRel);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.EXTENDIBLE_ELEMENT_REFERENCE: {
        var extendibleElementReference = (ExtendibleElementReference)theEObject;
        var result = caseExtendibleElementReference(extendibleElementReference);
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.EXTENDIBLE_ELEMENT_ENDPOINT_REFERENCE: {
        var extendibleElementEndpointReference = (ExtendibleElementEndpointReference)theEObject;
        var result = caseExtendibleElementEndpointReference(extendibleElementEndpointReference);
        if (result == null) {
          result = caseExtendibleElementReference(extendibleElementEndpointReference);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.MODEL_ENDPOINT_REFERENCE: {
        var modelEndpointReference = (ModelEndpointReference)theEObject;
        var result = caseModelEndpointReference(modelEndpointReference);
        if (result == null) {
          result = caseExtendibleElementEndpointReference(modelEndpointReference);
        }
        if (result == null) {
          result = caseExtendibleElementReference(modelEndpointReference);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.MODEL_ELEMENT_REFERENCE: {
        var modelElementReference = (ModelElementReference)theEObject;
        var result = caseModelElementReference(modelElementReference);
        if (result == null) {
          result = caseExtendibleElementReference(modelElementReference);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.MAPPING: {
        var mapping = (Mapping)theEObject;
        var result = caseMapping(mapping);
        if (result == null) {
          result = caseExtendibleElement(mapping);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.BINARY_MAPPING: {
        var binaryMapping = (BinaryMapping)theEObject;
        var result = caseBinaryMapping(binaryMapping);
        if (result == null) {
          result = caseMapping(binaryMapping);
        }
        if (result == null) {
          result = caseExtendibleElement(binaryMapping);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT: {
        var modelElementEndpoint = (ModelElementEndpoint)theEObject;
        var result = caseModelElementEndpoint(modelElementEndpoint);
        if (result == null) {
          result = caseExtendibleElementEndpoint(modelElementEndpoint);
        }
        if (result == null) {
          result = caseExtendibleElement(modelElementEndpoint);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.MAPPING_REFERENCE: {
        var mappingReference = (MappingReference)theEObject;
        var result = caseMappingReference(mappingReference);
        if (result == null) {
          result = caseExtendibleElementReference(mappingReference);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.BINARY_MAPPING_REFERENCE: {
        var binaryMappingReference = (BinaryMappingReference)theEObject;
        var result = caseBinaryMappingReference(binaryMappingReference);
        if (result == null) {
          result = caseMappingReference(binaryMappingReference);
        }
        if (result == null) {
          result = caseExtendibleElementReference(binaryMappingReference);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      case RelationshipPackage.MODEL_ELEMENT_ENDPOINT_REFERENCE: {
        var modelElementEndpointReference = (ModelElementEndpointReference)theEObject;
        var result = caseModelElementEndpointReference(modelElementEndpointReference);
        if (result == null) {
          result = caseExtendibleElementEndpointReference(modelElementEndpointReference);
        }
        if (result == null) {
          result = caseExtendibleElementReference(modelElementEndpointReference);
        }
        if (result == null) {
          result = defaultCase(theEObject);
        }
        return result;
      }
      default: return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>Model Endpoint Reference</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Endpoint Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseModelEndpointReference(ModelEndpointReference object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Model Element Reference</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseModelElementReference(ModelElementReference object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Model Element Endpoint</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element Endpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseModelElementEndpoint(ModelElementEndpoint object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Extendible Element Endpoint Reference</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extendible Element Endpoint Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseExtendibleElementEndpointReference(ExtendibleElementEndpointReference object) {
    return null;
  }

    /**
   * Returns the result of interpreting the object as an instance of '<em>Model Element Endpoint Reference</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model Element Endpoint Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseModelElementEndpointReference(ModelElementEndpointReference object) {
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
   * Returns the result of interpreting the object as an instance of '<em>Extendible Element Endpoint</em>'.
   * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Extendible Element Endpoint</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
    public T caseExtendibleElementEndpoint(ExtendibleElementEndpoint object) {
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

} //RelationshipSwitch
