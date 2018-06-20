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
package edu.toronto.cs.se.modelepedia.sequencediagram.impl;

import edu.toronto.cs.se.modelepedia.sequencediagram.AsynchronousMessage;
import edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline;
import edu.toronto.cs.se.modelepedia.sequencediagram.NamedElement;
import edu.toronto.cs.se.modelepedia.sequencediagram.ReturnMessage;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramFactory;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage;
import edu.toronto.cs.se.modelepedia.sequencediagram.SynchronousMessage;

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
public class SequenceDiagramFactoryImpl extends EFactoryImpl implements SequenceDiagramFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static SequenceDiagramFactory init() {
        try {
            SequenceDiagramFactory theSequenceDiagramFactory = (SequenceDiagramFactory)EPackage.Registry.INSTANCE.getEFactory(SequenceDiagramPackage.eNS_URI);
            if (theSequenceDiagramFactory != null) {
                return theSequenceDiagramFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SequenceDiagramFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SequenceDiagramFactoryImpl() {
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
            case SequenceDiagramPackage.SEQUENCE_DIAGRAM: return createSequenceDiagram();
            case SequenceDiagramPackage.NAMED_ELEMENT: return createNamedElement();
            case SequenceDiagramPackage.OBJECT: return createObject();
            case SequenceDiagramPackage.LIFELINE: return createLifeline();
            case SequenceDiagramPackage.SYNCHRONOUS_MESSAGE: return createSynchronousMessage();
            case SequenceDiagramPackage.ASYNCHRONOUS_MESSAGE: return createAsynchronousMessage();
            case SequenceDiagramPackage.RETURN_MESSAGE: return createReturnMessage();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SequenceDiagram createSequenceDiagram() {
        SequenceDiagramImpl sequenceDiagram = new SequenceDiagramImpl();
        return sequenceDiagram;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NamedElement createNamedElement() {
        NamedElementImpl namedElement = new NamedElementImpl();
        return namedElement;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public edu.toronto.cs.se.modelepedia.sequencediagram.Object createObject() {
        ObjectImpl object = new ObjectImpl();
        return object;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Lifeline createLifeline() {
        LifelineImpl lifeline = new LifelineImpl();
        return lifeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SynchronousMessage createSynchronousMessage() {
        SynchronousMessageImpl synchronousMessage = new SynchronousMessageImpl();
        return synchronousMessage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AsynchronousMessage createAsynchronousMessage() {
        AsynchronousMessageImpl asynchronousMessage = new AsynchronousMessageImpl();
        return asynchronousMessage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReturnMessage createReturnMessage() {
        ReturnMessageImpl returnMessage = new ReturnMessageImpl();
        return returnMessage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SequenceDiagramPackage getSequenceDiagramPackage() {
        return (SequenceDiagramPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SequenceDiagramPackage getPackage() {
        return SequenceDiagramPackage.eINSTANCE;
    }

} //SequenceDiagramFactoryImpl
