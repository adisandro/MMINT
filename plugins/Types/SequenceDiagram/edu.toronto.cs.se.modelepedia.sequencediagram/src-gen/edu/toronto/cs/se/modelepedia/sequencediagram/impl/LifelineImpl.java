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
import edu.toronto.cs.se.modelepedia.sequencediagram.Lifeline;
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
 * An implementation of the model object '<em><b>Lifeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.sequencediagram.impl.LifelineImpl#getActivationBoxes <em>Activation Boxes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LifelineImpl extends MinimalEObjectImpl.Container implements Lifeline {
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
	public EList<ActivationBox> getActivationBoxes() {
		if (activationBoxes == null) {
			activationBoxes = new EObjectContainmentEList<ActivationBox>(ActivationBox.class, this, SequenceDiagramPackage.LIFELINE__ACTIVATION_BOXES);
		}
		return activationBoxes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SequenceDiagramPackage.LIFELINE__ACTIVATION_BOXES:
				return ((InternalEList<?>)getActivationBoxes()).basicRemove(otherEnd, msgs);
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
			case SequenceDiagramPackage.LIFELINE__ACTIVATION_BOXES:
				return getActivationBoxes();
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
			case SequenceDiagramPackage.LIFELINE__ACTIVATION_BOXES:
				getActivationBoxes().clear();
				getActivationBoxes().addAll((Collection<? extends ActivationBox>)newValue);
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
			case SequenceDiagramPackage.LIFELINE__ACTIVATION_BOXES:
				getActivationBoxes().clear();
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
			case SequenceDiagramPackage.LIFELINE__ACTIVATION_BOXES:
				return activationBoxes != null && !activationBoxes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LifelineImpl
