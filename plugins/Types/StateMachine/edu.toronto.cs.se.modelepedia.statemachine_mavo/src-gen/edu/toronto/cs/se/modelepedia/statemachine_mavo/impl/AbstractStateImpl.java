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
package edu.toronto.cs.se.modelepedia.statemachine_mavo.impl;

import edu.toronto.cs.se.modelepedia.statemachine_mavo.AbstractState;
import edu.toronto.cs.se.modelepedia.statemachine_mavo.StateMachine_MAVOPackage;
import edu.toronto.cs.se.modelepedia.statemachine_mavo.Transition;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine_mavo.impl.AbstractStateImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine_mavo.impl.AbstractStateImpl#getTransitionsAsSource <em>Transitions As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.statemachine_mavo.impl.AbstractStateImpl#getTransitionsAsTarget <em>Transitions As Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractStateImpl extends MinimalEObjectImpl.Container implements AbstractState {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransitionsAsSource() <em>Transitions As Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionsAsSource()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitionsAsSource;

	/**
	 * The cached value of the '{@link #getTransitionsAsTarget() <em>Transitions As Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionsAsTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transitionsAsTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractStateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StateMachine_MAVOPackage.Literals.ABSTRACT_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StateMachine_MAVOPackage.ABSTRACT_STATE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getTransitionsAsSource() {
		if (transitionsAsSource == null) {
			transitionsAsSource = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_SOURCE, StateMachine_MAVOPackage.TRANSITION__SOURCE);
		}
		return transitionsAsSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getTransitionsAsTarget() {
		if (transitionsAsTarget == null) {
			transitionsAsTarget = new EObjectWithInverseResolvingEList<Transition>(Transition.class, this, StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_TARGET, StateMachine_MAVOPackage.TRANSITION__TARGET);
		}
		return transitionsAsTarget;
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
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTransitionsAsSource()).basicAdd(otherEnd, msgs);
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_TARGET:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTransitionsAsTarget()).basicAdd(otherEnd, msgs);
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
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_SOURCE:
				return ((InternalEList<?>)getTransitionsAsSource()).basicRemove(otherEnd, msgs);
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_TARGET:
				return ((InternalEList<?>)getTransitionsAsTarget()).basicRemove(otherEnd, msgs);
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
			case StateMachine_MAVOPackage.ABSTRACT_STATE__NAME:
				return getName();
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_SOURCE:
				return getTransitionsAsSource();
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_TARGET:
				return getTransitionsAsTarget();
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
			case StateMachine_MAVOPackage.ABSTRACT_STATE__NAME:
				setName((String)newValue);
				return;
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_SOURCE:
				getTransitionsAsSource().clear();
				getTransitionsAsSource().addAll((Collection<? extends Transition>)newValue);
				return;
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_TARGET:
				getTransitionsAsTarget().clear();
				getTransitionsAsTarget().addAll((Collection<? extends Transition>)newValue);
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
			case StateMachine_MAVOPackage.ABSTRACT_STATE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_SOURCE:
				getTransitionsAsSource().clear();
				return;
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_TARGET:
				getTransitionsAsTarget().clear();
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
			case StateMachine_MAVOPackage.ABSTRACT_STATE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_SOURCE:
				return transitionsAsSource != null && !transitionsAsSource.isEmpty();
			case StateMachine_MAVOPackage.ABSTRACT_STATE__TRANSITIONS_AS_TARGET:
				return transitionsAsTarget != null && !transitionsAsTarget.isEmpty();
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //AbstractStateImpl
