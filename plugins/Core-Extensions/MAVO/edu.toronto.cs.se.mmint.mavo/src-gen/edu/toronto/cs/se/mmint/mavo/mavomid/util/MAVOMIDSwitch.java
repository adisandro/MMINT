/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid.util;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVORoot;

import edu.toronto.cs.se.mmint.mavo.mavomid.*;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;

import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMapping;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
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
 * @see edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage
 * @generated
 */
public class MAVOMIDSwitch<T> extends Switch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static MAVOMIDPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public MAVOMIDSwitch() {
        if (modelPackage == null) {
            modelPackage = MAVOMIDPackage.eINSTANCE;
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
            case MAVOMIDPackage.MAVO_MODEL: {
                MAVOModel mavoModel = (MAVOModel)theEObject;
                T result = caseMAVOModel(mavoModel);
                if (result == null) result = caseModel(mavoModel);
                if (result == null) result = caseMAVORoot(mavoModel);
                if (result == null) result = caseGenericElement(mavoModel);
                if (result == null) result = caseExtendibleElement(mavoModel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.MAVO_MODEL_ELEMENT: {
                MAVOModelElement mavoModelElement = (MAVOModelElement)theEObject;
                T result = caseMAVOModelElement(mavoModelElement);
                if (result == null) result = caseModelElement(mavoModelElement);
                if (result == null) result = caseMAVOElement(mavoModelElement);
                if (result == null) result = caseExtendibleElement(mavoModelElement);
                if (result == null) result = caseLogicElement(mavoModelElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.MAVO_MODEL_REL: {
                MAVOModelRel mavoModelRel = (MAVOModelRel)theEObject;
                T result = caseMAVOModelRel(mavoModelRel);
                if (result == null) result = caseModelRel(mavoModelRel);
                if (result == null) result = caseModel(mavoModelRel);
                if (result == null) result = caseGenericElement(mavoModelRel);
                if (result == null) result = caseExtendibleElement(mavoModelRel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.BINARY_MAVO_MODEL_REL: {
                BinaryMAVOModelRel binaryMAVOModelRel = (BinaryMAVOModelRel)theEObject;
                T result = caseBinaryMAVOModelRel(binaryMAVOModelRel);
                if (result == null) result = caseBinaryModelRel(binaryMAVOModelRel);
                if (result == null) result = caseMAVOModelRel(binaryMAVOModelRel);
                if (result == null) result = caseModelRel(binaryMAVOModelRel);
                if (result == null) result = caseModel(binaryMAVOModelRel);
                if (result == null) result = caseGenericElement(binaryMAVOModelRel);
                if (result == null) result = caseExtendibleElement(binaryMAVOModelRel);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.MAVO_MODEL_ENDPOINT: {
                MAVOModelEndpoint mavoModelEndpoint = (MAVOModelEndpoint)theEObject;
                T result = caseMAVOModelEndpoint(mavoModelEndpoint);
                if (result == null) result = caseModelEndpoint(mavoModelEndpoint);
                if (result == null) result = caseExtendibleElementEndpoint(mavoModelEndpoint);
                if (result == null) result = caseExtendibleElement(mavoModelEndpoint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.MAVO_MAPPING: {
                MAVOMapping mavoMapping = (MAVOMapping)theEObject;
                T result = caseMAVOMapping(mavoMapping);
                if (result == null) result = caseMapping(mavoMapping);
                if (result == null) result = caseMAVOElement(mavoMapping);
                if (result == null) result = caseExtendibleElement(mavoMapping);
                if (result == null) result = caseLogicElement(mavoMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.BINARY_MAVO_MAPPING: {
                BinaryMAVOMapping binaryMAVOMapping = (BinaryMAVOMapping)theEObject;
                T result = caseBinaryMAVOMapping(binaryMAVOMapping);
                if (result == null) result = caseBinaryMapping(binaryMAVOMapping);
                if (result == null) result = caseMAVOMapping(binaryMAVOMapping);
                if (result == null) result = caseMapping(binaryMAVOMapping);
                if (result == null) result = caseMAVOElement(binaryMAVOMapping);
                if (result == null) result = caseExtendibleElement(binaryMAVOMapping);
                if (result == null) result = caseLogicElement(binaryMAVOMapping);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.MAVO_MODEL_ELEMENT_REFERENCE: {
                MAVOModelElementReference mavoModelElementReference = (MAVOModelElementReference)theEObject;
                T result = caseMAVOModelElementReference(mavoModelElementReference);
                if (result == null) result = caseModelElementReference(mavoModelElementReference);
                if (result == null) result = caseExtendibleElementReference(mavoModelElementReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.MAVO_MODEL_ENDPOINT_REFERENCE: {
                MAVOModelEndpointReference mavoModelEndpointReference = (MAVOModelEndpointReference)theEObject;
                T result = caseMAVOModelEndpointReference(mavoModelEndpointReference);
                if (result == null) result = caseModelEndpointReference(mavoModelEndpointReference);
                if (result == null) result = caseExtendibleElementEndpointReference(mavoModelEndpointReference);
                if (result == null) result = caseExtendibleElementReference(mavoModelEndpointReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.MAVO_MAPPING_REFERENCE: {
                MAVOMappingReference mavoMappingReference = (MAVOMappingReference)theEObject;
                T result = caseMAVOMappingReference(mavoMappingReference);
                if (result == null) result = caseMappingReference(mavoMappingReference);
                if (result == null) result = caseExtendibleElementReference(mavoMappingReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MAVOMIDPackage.BINARY_MAVO_MAPPING_REFERENCE: {
                BinaryMAVOMappingReference binaryMAVOMappingReference = (BinaryMAVOMappingReference)theEObject;
                T result = caseBinaryMAVOMappingReference(binaryMAVOMappingReference);
                if (result == null) result = caseBinaryMappingReference(binaryMAVOMappingReference);
                if (result == null) result = caseMAVOMappingReference(binaryMAVOMappingReference);
                if (result == null) result = caseMappingReference(binaryMAVOMappingReference);
                if (result == null) result = caseExtendibleElementReference(binaryMAVOMappingReference);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>MAVO Model</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MAVO Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMAVOModel(MAVOModel object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>MAVO Model Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MAVO Model Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMAVOModelElement(MAVOModelElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>MAVO Model Rel</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MAVO Model Rel</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMAVOModelRel(MAVOModelRel object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Binary MAVO Model Rel</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Binary MAVO Model Rel</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBinaryMAVOModelRel(BinaryMAVOModelRel object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>MAVO Model Endpoint</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MAVO Model Endpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMAVOModelEndpoint(MAVOModelEndpoint object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>MAVO Model Endpoint Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MAVO Model Endpoint Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMAVOModelEndpointReference(MAVOModelEndpointReference object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>MAVO Mapping Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MAVO Mapping Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMAVOMappingReference(MAVOMappingReference object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Binary MAVO Mapping Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Binary MAVO Mapping Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBinaryMAVOMappingReference(BinaryMAVOMappingReference object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>MAVO Mapping</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MAVO Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMAVOMapping(MAVOMapping object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Binary MAVO Mapping</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Binary MAVO Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBinaryMAVOMapping(BinaryMAVOMapping object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>MAVO Model Element Reference</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MAVO Model Element Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMAVOModelElementReference(MAVOModelElementReference object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseMAVORoot(MAVORoot object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Logic Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Logic Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseLogicElement(LogicElement object) {
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
	public T caseMAVOElement(MAVOElement object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Model Endpoint</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Model Endpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseModelEndpoint(ModelEndpoint object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Model Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Model Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseModelElement(ModelElement object) {
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

} //MAVOMIDSwitch
