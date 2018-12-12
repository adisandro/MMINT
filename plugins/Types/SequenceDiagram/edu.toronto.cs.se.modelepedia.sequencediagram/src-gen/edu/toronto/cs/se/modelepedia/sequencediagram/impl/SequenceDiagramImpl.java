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

import edu.toronto.cs.se.modelepedia.sequencediagram.Message;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagram;
import edu.toronto.cs.se.modelepedia.sequencediagram.SequenceDiagramPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sequence Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramImpl#getObjects <em>Objects</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.SequenceDiagramImpl#getMessages <em>Messages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceDiagramImpl extends MinimalEObjectImpl.Container implements SequenceDiagram {
	/**
	 * The cached value of the '{@link #getObjects() <em>Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<edu.toronto.cs.se.modelepedia.sequencediagram.Object> objects;

	/**
	 * The cached value of the '{@link #getMessages() <em>Messages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessages()
	 * @generated
	 * @ordered
	 */
	protected EList<Message> messages;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SequenceDiagramPackage.Literals.SEQUENCE_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<edu.toronto.cs.se.modelepedia.sequencediagram.Object> getObjects() {
		if (objects == null) {
			objects = new EObjectContainmentEList<edu.toronto.cs.se.modelepedia.sequencediagram.Object>(edu.toronto.cs.se.modelepedia.sequencediagram.Object.class, this, SequenceDiagramPackage.SEQUENCE_DIAGRAM__OBJECTS);
		}
		return objects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentEList<Message>(Message.class, this, SequenceDiagramPackage.SEQUENCE_DIAGRAM__MESSAGES);
		}
		return messages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__OBJECTS:
				return ((InternalEList<?>)getObjects()).basicRemove(otherEnd, msgs);
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__MESSAGES:
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
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__OBJECTS:
				return getObjects();
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__MESSAGES:
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
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__OBJECTS:
				getObjects().clear();
				getObjects().addAll((Collection<? extends edu.toronto.cs.se.modelepedia.sequencediagram.Object>)newValue);
				return;
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__MESSAGES:
				getMessages().clear();
				getMessages().addAll((Collection<? extends Message>)newValue);
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
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__OBJECTS:
				getObjects().clear();
				return;
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__MESSAGES:
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
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__OBJECTS:
				return objects != null && !objects.isEmpty();
			case SequenceDiagramPackage.SEQUENCE_DIAGRAM__MESSAGES:
				return messages != null && !messages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SequenceDiagramImpl
