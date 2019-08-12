/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.sequencediagram.impl;

import edu.toronto.cs.se.modelepedia.sequencediagram.ActivationBox;
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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Activation Box</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActivationBoxImpl#getActivationBoxes <em>Activation Boxes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActivationBoxImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActivationBoxImpl#getMessagesAsSource <em>Messages As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActivationBoxImpl#getMessagesAsTarget <em>Messages As Target</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.ActivationBoxImpl#getOwnerActivationBox <em>Owner Activation Box</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActivationBoxImpl extends MinimalEObjectImpl.Container implements ActivationBox {
	/**
	 * The cached value of the '{@link #getActivationBoxes() <em>Activation Boxes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivationBoxes()
	 * @generated
	 * @ordered
	 */
	protected EList<ActivationBox> activationBoxes;

	/**
	 * The default value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected String condition = CONDITION_EDEFAULT;

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
	protected ActivationBoxImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequenceDiagramPackage.Literals.ACTIVATION_BOX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActivationBox> getActivationBoxes() {
		if (activationBoxes == null) {
			activationBoxes = new EObjectContainmentWithInverseEList<ActivationBox>(ActivationBox.class, this, SequenceDiagramPackage.ACTIVATION_BOX__ACTIVATION_BOXES, SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX);
		}
		return activationBoxes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(String newCondition) {
		String oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequenceDiagramPackage.ACTIVATION_BOX__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getMessagesAsSource() {
		if (messagesAsSource == null) {
			messagesAsSource = new EObjectWithInverseResolvingEList<Message>(Message.class, this, SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_SOURCE, SequenceDiagramPackage.MESSAGE__SOURCE);
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
			messagesAsTarget = new EObjectWithInverseResolvingEList<Message>(Message.class, this, SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_TARGET, SequenceDiagramPackage.MESSAGE__TARGET);
		}
		return messagesAsTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivationBox getOwnerActivationBox() {
		if (eContainerFeatureID() != SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX) return null;
		return (ActivationBox)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnerActivationBox(ActivationBox newOwnerActivationBox, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwnerActivationBox, SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerActivationBox(ActivationBox newOwnerActivationBox) {
		if (newOwnerActivationBox != eInternalContainer() || (eContainerFeatureID() != SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX && newOwnerActivationBox != null)) {
			if (EcoreUtil.isAncestor(this, newOwnerActivationBox))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwnerActivationBox != null)
				msgs = ((InternalEObject)newOwnerActivationBox).eInverseAdd(this, SequenceDiagramPackage.ACTIVATION_BOX__ACTIVATION_BOXES, ActivationBox.class, msgs);
			msgs = basicSetOwnerActivationBox(newOwnerActivationBox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX, newOwnerActivationBox, newOwnerActivationBox));
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
			case SequenceDiagramPackage.ACTIVATION_BOX__ACTIVATION_BOXES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getActivationBoxes()).basicAdd(otherEnd, msgs);
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMessagesAsSource()).basicAdd(otherEnd, msgs);
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_TARGET:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMessagesAsTarget()).basicAdd(otherEnd, msgs);
			case SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwnerActivationBox((ActivationBox)otherEnd, msgs);
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
			case SequenceDiagramPackage.ACTIVATION_BOX__ACTIVATION_BOXES:
				return ((InternalEList<?>)getActivationBoxes()).basicRemove(otherEnd, msgs);
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_SOURCE:
				return ((InternalEList<?>)getMessagesAsSource()).basicRemove(otherEnd, msgs);
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_TARGET:
				return ((InternalEList<?>)getMessagesAsTarget()).basicRemove(otherEnd, msgs);
			case SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX:
				return basicSetOwnerActivationBox(null, msgs);
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
			case SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX:
				return eInternalContainer().eInverseRemove(this, SequenceDiagramPackage.ACTIVATION_BOX__ACTIVATION_BOXES, ActivationBox.class, msgs);
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
			case SequenceDiagramPackage.ACTIVATION_BOX__ACTIVATION_BOXES:
				return getActivationBoxes();
			case SequenceDiagramPackage.ACTIVATION_BOX__CONDITION:
				return getCondition();
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_SOURCE:
				return getMessagesAsSource();
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_TARGET:
				return getMessagesAsTarget();
			case SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX:
				return getOwnerActivationBox();
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
			case SequenceDiagramPackage.ACTIVATION_BOX__ACTIVATION_BOXES:
				getActivationBoxes().clear();
				getActivationBoxes().addAll((Collection<? extends ActivationBox>)newValue);
				return;
			case SequenceDiagramPackage.ACTIVATION_BOX__CONDITION:
				setCondition((String)newValue);
				return;
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_SOURCE:
				getMessagesAsSource().clear();
				getMessagesAsSource().addAll((Collection<? extends Message>)newValue);
				return;
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_TARGET:
				getMessagesAsTarget().clear();
				getMessagesAsTarget().addAll((Collection<? extends Message>)newValue);
				return;
			case SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX:
				setOwnerActivationBox((ActivationBox)newValue);
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
			case SequenceDiagramPackage.ACTIVATION_BOX__ACTIVATION_BOXES:
				getActivationBoxes().clear();
				return;
			case SequenceDiagramPackage.ACTIVATION_BOX__CONDITION:
				setCondition(CONDITION_EDEFAULT);
				return;
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_SOURCE:
				getMessagesAsSource().clear();
				return;
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_TARGET:
				getMessagesAsTarget().clear();
				return;
			case SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX:
				setOwnerActivationBox((ActivationBox)null);
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
			case SequenceDiagramPackage.ACTIVATION_BOX__ACTIVATION_BOXES:
				return activationBoxes != null && !activationBoxes.isEmpty();
			case SequenceDiagramPackage.ACTIVATION_BOX__CONDITION:
				return CONDITION_EDEFAULT == null ? condition != null : !CONDITION_EDEFAULT.equals(condition);
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_SOURCE:
				return messagesAsSource != null && !messagesAsSource.isEmpty();
			case SequenceDiagramPackage.ACTIVATION_BOX__MESSAGES_AS_TARGET:
				return messagesAsTarget != null && !messagesAsTarget.isEmpty();
			case SequenceDiagramPackage.ACTIVATION_BOX__OWNER_ACTIVATION_BOX:
				return getOwnerActivationBox() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (condition: ");
		result.append(condition);
		result.append(')');
		return result.toString();
	}

} //ActivationBoxImpl
