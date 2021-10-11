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
package edu.toronto.cs.se.mmint.productline.mid.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.productline.PLElement;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryMapping;
import edu.toronto.cs.se.mmint.productline.mid.PLBinaryMappingReference;
import edu.toronto.cs.se.mmint.productline.mid.PLMapping;
import edu.toronto.cs.se.mmint.productline.mid.PLMappingReference;
import edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage;

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
 * @see edu.toronto.cs.se.mmint.productline.mid.ProductLineMIDPackage
 * @generated
 */
public class ProductLineMIDSwitch<T> extends Switch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ProductLineMIDPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProductLineMIDSwitch() {
    if (ProductLineMIDSwitch.modelPackage == null) {
      ProductLineMIDSwitch.modelPackage = ProductLineMIDPackage.eINSTANCE;
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
    return ePackage == ProductLineMIDSwitch.modelPackage;
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
    case ProductLineMIDPackage.PL_MAPPING: {
      var plMapping = (PLMapping) theEObject;
      var result = casePLMapping(plMapping);
      if (result == null)
        result = caseMapping(plMapping);
      if (result == null)
        result = casePLElement(plMapping);
      if (result == null)
        result = caseExtendibleElement(plMapping);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductLineMIDPackage.PL_BINARY_MAPPING: {
      var plBinaryMapping = (PLBinaryMapping) theEObject;
      var result = casePLBinaryMapping(plBinaryMapping);
      if (result == null)
        result = caseBinaryMapping(plBinaryMapping);
      if (result == null)
        result = casePLMapping(plBinaryMapping);
      if (result == null)
        result = caseMapping(plBinaryMapping);
      if (result == null)
        result = casePLElement(plBinaryMapping);
      if (result == null)
        result = caseExtendibleElement(plBinaryMapping);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductLineMIDPackage.PL_MAPPING_REFERENCE: {
      var plMappingReference = (PLMappingReference) theEObject;
      var result = casePLMappingReference(plMappingReference);
      if (result == null)
        result = caseMappingReference(plMappingReference);
      if (result == null)
        result = caseExtendibleElementReference(plMappingReference);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    case ProductLineMIDPackage.PL_BINARY_MAPPING_REFERENCE: {
      var plBinaryMappingReference = (PLBinaryMappingReference) theEObject;
      var result = casePLBinaryMappingReference(plBinaryMappingReference);
      if (result == null)
        result = caseBinaryMappingReference(plBinaryMappingReference);
      if (result == null)
        result = casePLMappingReference(plBinaryMappingReference);
      if (result == null)
        result = caseMappingReference(plBinaryMappingReference);
      if (result == null)
        result = caseExtendibleElementReference(plBinaryMappingReference);
      if (result == null)
        result = defaultCase(theEObject);
      return result;
    }
    default:
      return defaultCase(theEObject);
    }
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
   * Returns the result of interpreting the object as an instance of '<em>PL Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>PL Element</em>'.
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

} //ProductLineMIDSwitch
