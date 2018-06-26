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
package edu.toronto.cs.se.mmint.mid.util;

import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import edu.toronto.cs.se.mmint.mid.*;

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
 * @see edu.toronto.cs.se.mmint.mid.MIDPackage
 * @generated
 */
public class MIDSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MIDPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MIDSwitch() {
        if (modelPackage == null) {
            modelPackage = MIDPackage.eINSTANCE;
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
            case MIDPackage.MID: {
                MID mid = (MID)theEObject;
                T result = caseMID(mid);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MIDPackage.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP: {
                @SuppressWarnings("unchecked") Map.Entry<String, ExtendibleElement> eStringToExtendibleElementMap = (Map.Entry<String, ExtendibleElement>)theEObject;
                T result = caseEStringToExtendibleElementMap(eStringToExtendibleElementMap);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MIDPackage.EXTENDIBLE_ELEMENT: {
                ExtendibleElement extendibleElement = (ExtendibleElement)theEObject;
                T result = caseExtendibleElement(extendibleElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT: {
                ExtendibleElementEndpoint extendibleElementEndpoint = (ExtendibleElementEndpoint)theEObject;
                T result = caseExtendibleElementEndpoint(extendibleElementEndpoint);
                if (result == null) result = caseExtendibleElement(extendibleElementEndpoint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MIDPackage.MODEL: {
                Model model = (Model)theEObject;
                T result = caseModel(model);
                if (result == null) result = caseGenericElement(model);
                if (result == null) result = caseExtendibleElement(model);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MIDPackage.EXTENDIBLE_ELEMENT_CONSTRAINT: {
                ExtendibleElementConstraint extendibleElementConstraint = (ExtendibleElementConstraint)theEObject;
                T result = caseExtendibleElementConstraint(extendibleElementConstraint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MIDPackage.MODEL_ELEMENT: {
                ModelElement modelElement = (ModelElement)theEObject;
                T result = caseModelElement(modelElement);
                if (result == null) result = caseExtendibleElement(modelElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MIDPackage.MODEL_ENDPOINT: {
                ModelEndpoint modelEndpoint = (ModelEndpoint)theEObject;
                T result = caseModelEndpoint(modelEndpoint);
                if (result == null) result = caseExtendibleElementEndpoint(modelEndpoint);
                if (result == null) result = caseExtendibleElement(modelEndpoint);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MIDPackage.EMF_INFO: {
                EMFInfo emfInfo = (EMFInfo)theEObject;
                T result = caseEMFInfo(emfInfo);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case MIDPackage.GENERIC_ELEMENT: {
                GenericElement genericElement = (GenericElement)theEObject;
                T result = caseGenericElement(genericElement);
                if (result == null) result = caseExtendibleElement(genericElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>MID</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>MID</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMID(MID object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EString To Extendible Element Map</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EString To Extendible Element Map</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEStringToExtendibleElementMap(Map.Entry<String, ExtendibleElement> object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Extendible Element Constraint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Extendible Element Constraint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExtendibleElementConstraint(ExtendibleElementConstraint object) {
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
     * Returns the result of interpreting the object as an instance of '<em>EMF Info</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EMF Info</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEMFInfo(EMFInfo object) {
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

} //MIDSwitch
