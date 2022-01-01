/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl;

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationImpl#getMessages <em>Messages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends NamedElementImpl implements Operation {
	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationReference> messages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICSE15_SequenceDiagram_MAVOPackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OperationReference> getMessages() {
		if (messages == null) {
			messages = new EObjectWithInverseResolvingEList<OperationReference>(OperationReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.OPERATION__MESSAGES, ICSE15_SequenceDiagram_MAVOPackage.OPERATION_REFERENCE__TARGET);
		}
		return messages;
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
			case ICSE15_SequenceDiagram_MAVOPackage.OPERATION__MESSAGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMessages()).basicAdd(otherEnd, msgs);
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
			case ICSE15_SequenceDiagram_MAVOPackage.OPERATION__MESSAGES:
				return ((InternalEList<?>)getMessages()).basicRemove(otherEnd, msgs);
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
			case ICSE15_SequenceDiagram_MAVOPackage.OPERATION__MESSAGES:
				return getMessages();
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
			case ICSE15_SequenceDiagram_MAVOPackage.OPERATION__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends OperationReference>)newValue);
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
			case ICSE15_SequenceDiagram_MAVOPackage.OPERATION__MESSAGES:
				getMessages().clear();
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
			case ICSE15_SequenceDiagram_MAVOPackage.OPERATION__MESSAGES:
				return messages != null && !messages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationImpl
