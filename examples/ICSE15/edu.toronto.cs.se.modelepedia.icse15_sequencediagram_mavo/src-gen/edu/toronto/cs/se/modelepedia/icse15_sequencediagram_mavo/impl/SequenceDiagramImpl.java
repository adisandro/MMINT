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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl;

import edu.toronto.cs.se.mavo.impl.MAVORootImpl;

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

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
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SequenceDiagramImpl#getLifelines <em>Lifelines</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SequenceDiagramImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.SequenceDiagramImpl#getMessages <em>Messages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SequenceDiagramImpl extends MAVORootImpl implements SequenceDiagram {
	/**
	 * The cached value of the '{@link #getLifelines() <em>Lifelines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifelines()
	 * @generated
	 * @ordered
	 */
	protected EList<Lifeline> lifelines;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class> classes;

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
		return ICSE15_SequenceDiagram_MAVOPackage.Literals.SEQUENCE_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Lifeline> getLifelines() {
		if (lifelines == null) {
			lifelines = new EObjectContainmentEList<Lifeline>(Lifeline.class, this, ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__LIFELINES);
		}
		return lifelines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class>(edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class.class, this, ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Message> getMessages() {
		if (messages == null) {
			messages = new EObjectContainmentEList<Message>(Message.class, this, ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__MESSAGES);
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
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__LIFELINES:
				return ((InternalEList<?>)getLifelines()).basicRemove(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__MESSAGES:
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
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__LIFELINES:
				return getLifelines();
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__CLASSES:
				return getClasses();
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__MESSAGES:
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
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__LIFELINES:
				getLifelines().clear();
				getLifelines().addAll((Collection<? extends Lifeline>)newValue);
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class>)newValue);
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__MESSAGES:
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
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__LIFELINES:
				getLifelines().clear();
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__CLASSES:
				getClasses().clear();
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__MESSAGES:
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
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__LIFELINES:
				return lifelines != null && !lifelines.isEmpty();
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__CLASSES:
				return classes != null && !classes.isEmpty();
			case ICSE15_SequenceDiagram_MAVOPackage.SEQUENCE_DIAGRAM__MESSAGES:
				return messages != null && !messages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SequenceDiagramImpl
