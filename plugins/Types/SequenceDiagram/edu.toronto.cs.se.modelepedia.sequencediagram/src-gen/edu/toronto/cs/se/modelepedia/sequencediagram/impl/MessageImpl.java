/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline;
import edu.toronto.cs.se.modelepedia.sequencediagram.Message;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl#getSourceLifeline <em>Source Lifeline</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.MessageImpl#getTargetLifeline <em>Target Lifeline</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MessageImpl extends NamedElementImpl implements Message {
    /**
     * The cached value of the '{@link #getSourceLifeline() <em>Source Lifeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceLifeline()
     * @generated
     * @ordered
     */
    protected Lifeline sourceLifeline;

    /**
     * The cached value of the '{@link #getTargetLifeline() <em>Target Lifeline</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetLifeline()
     * @generated
     * @ordered
     */
    protected Lifeline targetLifeline;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MessageImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SequenceDiagramPackage.Literals.MESSAGE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Lifeline getSourceLifeline() {
        if (sourceLifeline != null && sourceLifeline.eIsProxy()) {
            InternalEObject oldSourceLifeline = (InternalEObject)sourceLifeline;
            sourceLifeline = (Lifeline)eResolveProxy(oldSourceLifeline);
            if (sourceLifeline != oldSourceLifeline) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE, oldSourceLifeline, sourceLifeline));
            }
        }
        return sourceLifeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Lifeline basicGetSourceLifeline() {
        return sourceLifeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSourceLifeline(Lifeline newSourceLifeline, NotificationChain msgs) {
        Lifeline oldSourceLifeline = sourceLifeline;
        sourceLifeline = newSourceLifeline;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE, oldSourceLifeline, newSourceLifeline);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSourceLifeline(Lifeline newSourceLifeline) {
        if (newSourceLifeline != sourceLifeline) {
            NotificationChain msgs = null;
            if (sourceLifeline != null)
                msgs = ((InternalEObject)sourceLifeline).eInverseRemove(this, SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE, Lifeline.class, msgs);
            if (newSourceLifeline != null)
                msgs = ((InternalEObject)newSourceLifeline).eInverseAdd(this, SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE, Lifeline.class, msgs);
            msgs = basicSetSourceLifeline(newSourceLifeline, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE, newSourceLifeline, newSourceLifeline));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Lifeline getTargetLifeline() {
        if (targetLifeline != null && targetLifeline.eIsProxy()) {
            InternalEObject oldTargetLifeline = (InternalEObject)targetLifeline;
            targetLifeline = (Lifeline)eResolveProxy(oldTargetLifeline);
            if (targetLifeline != oldTargetLifeline) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE, oldTargetLifeline, targetLifeline));
            }
        }
        return targetLifeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Lifeline basicGetTargetLifeline() {
        return targetLifeline;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTargetLifeline(Lifeline newTargetLifeline, NotificationChain msgs) {
        Lifeline oldTargetLifeline = targetLifeline;
        targetLifeline = newTargetLifeline;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE, oldTargetLifeline, newTargetLifeline);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTargetLifeline(Lifeline newTargetLifeline) {
        if (newTargetLifeline != targetLifeline) {
            NotificationChain msgs = null;
            if (targetLifeline != null)
                msgs = ((InternalEObject)targetLifeline).eInverseRemove(this, SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET, Lifeline.class, msgs);
            if (newTargetLifeline != null)
                msgs = ((InternalEObject)newTargetLifeline).eInverseAdd(this, SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET, Lifeline.class, msgs);
            msgs = basicSetTargetLifeline(newTargetLifeline, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE, newTargetLifeline, newTargetLifeline));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE:
                if (sourceLifeline != null)
                    msgs = ((InternalEObject)sourceLifeline).eInverseRemove(this, SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE, Lifeline.class, msgs);
                return basicSetSourceLifeline((Lifeline)otherEnd, msgs);
            case SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE:
                if (targetLifeline != null)
                    msgs = ((InternalEObject)targetLifeline).eInverseRemove(this, SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET, Lifeline.class, msgs);
                return basicSetTargetLifeline((Lifeline)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE:
                return basicSetSourceLifeline(null, msgs);
            case SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE:
                return basicSetTargetLifeline(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE:
                if (resolve) return getSourceLifeline();
                return basicGetSourceLifeline();
            case SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE:
                if (resolve) return getTargetLifeline();
                return basicGetTargetLifeline();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE:
                setSourceLifeline((Lifeline)newValue);
                return;
            case SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE:
                setTargetLifeline((Lifeline)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE:
                setSourceLifeline((Lifeline)null);
                return;
            case SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE:
                setTargetLifeline((Lifeline)null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE:
                return sourceLifeline != null;
            case SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE:
                return targetLifeline != null;
        }
        return super.eIsSet(featureID);
    }

} //MessageImpl
