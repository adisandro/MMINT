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
package edu.toronto.cs.se.modelepedia.sequencediagram.util;

import edu.toronto.cs.se.modelepedia.sequencediagram.AsynchronousMessage;
import edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline;
import edu.toronto.cs.se.modelepedia.sequencediagram.Message;
import edu.toronto.cs.se.modelepedia.sequencediagram.NamedElement;
import edu.toronto.cs.se.modelepedia.sequencediagram.ReturnMessage;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage;
import edu.toronto.cs.se.modelepedia.sequencediagram.SynchronousMessage;

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
 * @see edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage
 * @generated
 */
public class SequenceDiagramSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static SequenceDiagramPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SequenceDiagramSwitch() {
        if (modelPackage == null) {
            modelPackage = SequenceDiagramPackage.eINSTANCE;
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
            case SequenceDiagramPackage.SEQUENCE_DIAGRAM: {
                SequenceDiagram sequenceDiagram = (SequenceDiagram)theEObject;
                T result = caseSequenceDiagram(sequenceDiagram);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SequenceDiagramPackage.NAMED_ELEMENT: {
                NamedElement namedElement = (NamedElement)theEObject;
                T result = caseNamedElement(namedElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SequenceDiagramPackage.OBJECT: {
                edu.toronto.cs.se.modelepedia.sequencediagram.Object object = (edu.toronto.cs.se.modelepedia.sequencediagram.Object)theEObject;
                T result = caseObject(object);
                if (result == null) result = caseNamedElement(object);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SequenceDiagramPackage.LIFELINE: {
                Lifeline lifeline = (Lifeline)theEObject;
                T result = caseLifeline(lifeline);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SequenceDiagramPackage.MESSAGE: {
                Message message = (Message)theEObject;
                T result = caseMessage(message);
                if (result == null) result = caseNamedElement(message);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SequenceDiagramPackage.SYNCHRONOUS_MESSAGE: {
                SynchronousMessage synchronousMessage = (SynchronousMessage)theEObject;
                T result = caseSynchronousMessage(synchronousMessage);
                if (result == null) result = caseMessage(synchronousMessage);
                if (result == null) result = caseNamedElement(synchronousMessage);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SequenceDiagramPackage.ASYNCHRONOUS_MESSAGE: {
                AsynchronousMessage asynchronousMessage = (AsynchronousMessage)theEObject;
                T result = caseAsynchronousMessage(asynchronousMessage);
                if (result == null) result = caseMessage(asynchronousMessage);
                if (result == null) result = caseNamedElement(asynchronousMessage);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case SequenceDiagramPackage.RETURN_MESSAGE: {
                ReturnMessage returnMessage = (ReturnMessage)theEObject;
                T result = caseReturnMessage(returnMessage);
                if (result == null) result = caseMessage(returnMessage);
                if (result == null) result = caseNamedElement(returnMessage);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Sequence Diagram</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sequence Diagram</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSequenceDiagram(SequenceDiagram object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedElement(NamedElement object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Object</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseObject(edu.toronto.cs.se.modelepedia.sequencediagram.Object object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Lifeline</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Lifeline</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLifeline(Lifeline object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Message</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Message</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMessage(Message object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Synchronous Message</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Synchronous Message</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSynchronousMessage(SynchronousMessage object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Asynchronous Message</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Asynchronous Message</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAsynchronousMessage(AsynchronousMessage object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Return Message</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Return Message</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseReturnMessage(ReturnMessage object) {
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

} //SequenceDiagramSwitch
