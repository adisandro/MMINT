/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lifeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.LifelineImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.LifelineImpl#getMessagesAsSource <em>Messages As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.LifelineImpl#getMessagesAsTarget <em>Messages As Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LifelineImpl extends NamedElementImpl implements Lifeline {
	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassReference> class_;

	/**
	 * The cached value of the '{@link #getMessagesAsSource() <em>Messages As Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessagesAsSource()
	 * @generated
	 * @ordered
	 */
	protected EList<SourceLifelineReference> messagesAsSource;

	/**
	 * The cached value of the '{@link #getMessagesAsTarget() <em>Messages As Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessagesAsTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<TargetLifelineReference> messagesAsTarget;

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
		return ICSE15_SequenceDiagram_MAVOPackage.Literals.LIFELINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassReference> getClass_() {
		if (class_ == null) {
			class_ = new EObjectContainmentWithInverseEList<ClassReference>(ClassReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__CLASS, ICSE15_SequenceDiagram_MAVOPackage.CLASS_REFERENCE__SOURCE);
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SourceLifelineReference> getMessagesAsSource() {
		if (messagesAsSource == null) {
			messagesAsSource = new EObjectWithInverseResolvingEList<SourceLifelineReference>(SourceLifelineReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_SOURCE, ICSE15_SequenceDiagram_MAVOPackage.SOURCE_LIFELINE_REFERENCE__TARGET);
		}
		return messagesAsSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TargetLifelineReference> getMessagesAsTarget() {
		if (messagesAsTarget == null) {
			messagesAsTarget = new EObjectWithInverseResolvingEList<TargetLifelineReference>(TargetLifelineReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_TARGET, ICSE15_SequenceDiagram_MAVOPackage.TARGET_LIFELINE_REFERENCE__TARGET);
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
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__CLASS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClass_()).basicAdd(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMessagesAsSource()).basicAdd(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_TARGET:
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
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__CLASS:
				return ((InternalEList<?>)getClass_()).basicRemove(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_SOURCE:
				return ((InternalEList<?>)getMessagesAsSource()).basicRemove(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_TARGET:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__CLASS:
				return getClass_();
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_SOURCE:
				return getMessagesAsSource();
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_TARGET:
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
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__CLASS:
				getClass_().clear();
				getClass_().addAll((Collection<? extends ClassReference>)newValue);
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_SOURCE:
				getMessagesAsSource().clear();
				getMessagesAsSource().addAll((Collection<? extends SourceLifelineReference>)newValue);
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_TARGET:
				getMessagesAsTarget().clear();
				getMessagesAsTarget().addAll((Collection<? extends TargetLifelineReference>)newValue);
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
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__CLASS:
				getClass_().clear();
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_SOURCE:
				getMessagesAsSource().clear();
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_TARGET:
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
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__CLASS:
				return class_ != null && !class_.isEmpty();
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_SOURCE:
				return messagesAsSource != null && !messagesAsSource.isEmpty();
			case ICSE15_SequenceDiagram_MAVOPackage.LIFELINE__MESSAGES_AS_TARGET:
				return messagesAsTarget != null && !messagesAsTarget.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LifelineImpl
