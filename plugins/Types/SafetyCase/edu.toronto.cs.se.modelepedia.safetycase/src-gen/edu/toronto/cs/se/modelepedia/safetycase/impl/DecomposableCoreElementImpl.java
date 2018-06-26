/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
package edu.toronto.cs.se.modelepedia.safetycase.impl;

import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCasePackage;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decomposable Core Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl#getInContextOf <em>In Context Of</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.safetycase.impl.DecomposableCoreElementImpl#getSupportedBy <em>Supported By</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DecomposableCoreElementImpl extends CoreElementImpl implements DecomposableCoreElement {
	/**
	 * The cached value of the '{@link #getInContextOf() <em>In Context Of</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInContextOf()
	 * @generated
	 * @ordered
	 */
	protected EList<InContextOf> inContextOf;

	/**
	 * The cached value of the '{@link #getSupportedBy() <em>Supported By</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupportedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<SupportedBy> supportedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DecomposableCoreElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SafetyCasePackage.Literals.DECOMPOSABLE_CORE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InContextOf> getInContextOf() {
		if (inContextOf == null) {
			inContextOf = new EObjectContainmentWithInverseEList<InContextOf>(InContextOf.class, this, SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF, SafetyCasePackage.IN_CONTEXT_OF__CONTEXT_OF);
		}
		return inContextOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SupportedBy> getSupportedBy() {
		if (supportedBy == null) {
			supportedBy = new EObjectContainmentWithInverseEList<SupportedBy>(SupportedBy.class, this, SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY, SafetyCasePackage.SUPPORTED_BY__CONCLUSION);
		}
		return supportedBy;
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
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getInContextOf()).basicAdd(otherEnd, msgs);
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSupportedBy()).basicAdd(otherEnd, msgs);
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
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				return ((InternalEList<?>)getInContextOf()).basicRemove(otherEnd, msgs);
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				return ((InternalEList<?>)getSupportedBy()).basicRemove(otherEnd, msgs);
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
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				return getInContextOf();
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				return getSupportedBy();
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
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				getInContextOf().clear();
				getInContextOf().addAll((Collection<? extends InContextOf>)newValue);
				return;
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				getSupportedBy().clear();
				getSupportedBy().addAll((Collection<? extends SupportedBy>)newValue);
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
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				getInContextOf().clear();
				return;
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				getSupportedBy().clear();
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
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__IN_CONTEXT_OF:
				return inContextOf != null && !inContextOf.isEmpty();
			case SafetyCasePackage.DECOMPOSABLE_CORE_ELEMENT__SUPPORTED_BY:
				return supportedBy != null && !supportedBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //DecomposableCoreElementImpl
