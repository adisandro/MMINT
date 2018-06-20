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

import edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline;
import edu.toronto.cs.se.modelepedia.sequencediagram.Message;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lifeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl#getObject <em>Object</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl#getMessagesAsSource <em>Messages As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl#getMessagesAsTarget <em>Messages As Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LifelineImpl extends MinimalEObjectImpl.Container implements Lifeline {
    /**
     * The cached value of the '{@link #getMessagesAsSource() <em>Messages As Source</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessagesAsSource()
     * @generated
     * @ordered
     */
    protected EList<Message> messagesAsSource;

    /**
     * The cached value of the '{@link #getMessagesAsTarget() <em>Messages As Target</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessagesAsTarget()
     * @generated
     * @ordered
     */
    protected EList<Message> messagesAsTarget;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LifelineImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SequenceDiagramPackage.Literals.LIFELINE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public edu.toronto.cs.se.modelepedia.sequencediagram.Object getObject() {
        if (eContainerFeatureID() != SequenceDiagramPackage.LIFELINE__OBJECT) return null;
        return (edu.toronto.cs.se.modelepedia.sequencediagram.Object)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetObject(edu.toronto.cs.se.modelepedia.sequencediagram.Object newObject, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newObject, SequenceDiagramPackage.LIFELINE__OBJECT, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setObject(edu.toronto.cs.se.modelepedia.sequencediagram.Object newObject) {
        if (newObject != eInternalContainer() || (eContainerFeatureID() != SequenceDiagramPackage.LIFELINE__OBJECT && newObject != null)) {
            if (EcoreUtil.isAncestor(this, newObject))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newObject != null)
                msgs = ((InternalEObject)newObject).eInverseAdd(this, SequenceDiagramPackage.OBJECT__LIFELINE, edu.toronto.cs.se.modelepedia.sequencediagram.Object.class, msgs);
            msgs = basicSetObject(newObject, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SequenceDiagramPackage.LIFELINE__OBJECT, newObject, newObject));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Message> getMessagesAsSource() {
        if (messagesAsSource == null) {
            messagesAsSource = new EObjectWithInverseResolvingEList<Message>(Message.class, this, SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE, SequenceDiagramPackage.MESSAGE__SOURCE_LIFELINE);
        }
        return messagesAsSource;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Message> getMessagesAsTarget() {
        if (messagesAsTarget == null) {
            messagesAsTarget = new EObjectWithInverseResolvingEList<Message>(Message.class, this, SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET, SequenceDiagramPackage.MESSAGE__TARGET_LIFELINE);
        }
        return messagesAsTarget;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SequenceDiagramPackage.LIFELINE__OBJECT:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetObject((edu.toronto.cs.se.modelepedia.sequencediagram.Object)otherEnd, msgs);
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMessagesAsSource()).basicAdd(otherEnd, msgs);
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getMessagesAsTarget()).basicAdd(otherEnd, msgs);
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
            case SequenceDiagramPackage.LIFELINE__OBJECT:
                return basicSetObject(null, msgs);
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE:
                return ((InternalEList<?>)getMessagesAsSource()).basicRemove(otherEnd, msgs);
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET:
                return ((InternalEList<?>)getMessagesAsTarget()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case SequenceDiagramPackage.LIFELINE__OBJECT:
                return eInternalContainer().eInverseRemove(this, SequenceDiagramPackage.OBJECT__LIFELINE, edu.toronto.cs.se.modelepedia.sequencediagram.Object.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case SequenceDiagramPackage.LIFELINE__OBJECT:
                return getObject();
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE:
                return getMessagesAsSource();
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET:
                return getMessagesAsTarget();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case SequenceDiagramPackage.LIFELINE__OBJECT:
                setObject((edu.toronto.cs.se.modelepedia.sequencediagram.Object)newValue);
                return;
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE:
                getMessagesAsSource().clear();
                getMessagesAsSource().addAll((Collection<? extends Message>)newValue);
                return;
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET:
                getMessagesAsTarget().clear();
                getMessagesAsTarget().addAll((Collection<? extends Message>)newValue);
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
            case SequenceDiagramPackage.LIFELINE__OBJECT:
                setObject((edu.toronto.cs.se.modelepedia.sequencediagram.Object)null);
                return;
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE:
                getMessagesAsSource().clear();
                return;
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET:
                getMessagesAsTarget().clear();
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
            case SequenceDiagramPackage.LIFELINE__OBJECT:
                return getObject() != null;
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_SOURCE:
                return messagesAsSource != null && !messagesAsSource.isEmpty();
            case SequenceDiagramPackage.LIFELINE__MESSAGES_AS_TARGET:
                return messagesAsTarget != null && !messagesAsTarget.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} //LifelineImpl
