/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.impl;

import edu.toronto.cs.se.mmtf.mid.impl.ExtendibleElementImpl;

import edu.toronto.cs.se.mmtf.mid.mapping.Link;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.LinkImpl#getElementRefs <em>Element Refs</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.mapping.impl.LinkImpl#isUnbounded <em>Unbounded</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkImpl extends ExtendibleElementImpl implements Link {
	/**
	 * The cached value of the '{@link #getElementRefs() <em>Element Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElementReference> elementRefs;

	/**
	 * The default value of the '{@link #isUnbounded() <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnbounded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNBOUNDED_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isUnbounded() <em>Unbounded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnbounded()
	 * @generated
	 * @ordered
	 */
	protected boolean unbounded = UNBOUNDED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MappingPackage.Literals.LINK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElementReference> getElementRefs() {
		if (elementRefs == null) {
			elementRefs = new EObjectWithInverseResolvingEList.ManyInverse<ModelElementReference>(ModelElementReference.class, this, MappingPackage.LINK__ELEMENT_REFS, MappingPackage.MODEL_ELEMENT_REFERENCE__LINKS);
		}
		return elementRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnbounded() {
		return unbounded;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnbounded(boolean newUnbounded) {
		boolean oldUnbounded = unbounded;
		unbounded = newUnbounded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingPackage.LINK__UNBOUNDED, oldUnbounded, unbounded));
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
			case MappingPackage.LINK__ELEMENT_REFS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElementRefs()).basicAdd(otherEnd, msgs);
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
			case MappingPackage.LINK__ELEMENT_REFS:
				return ((InternalEList<?>)getElementRefs()).basicRemove(otherEnd, msgs);
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
			case MappingPackage.LINK__ELEMENT_REFS:
				return getElementRefs();
			case MappingPackage.LINK__UNBOUNDED:
				return isUnbounded();
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
			case MappingPackage.LINK__ELEMENT_REFS:
				getElementRefs().clear();
				getElementRefs().addAll((Collection<? extends ModelElementReference>)newValue);
				return;
			case MappingPackage.LINK__UNBOUNDED:
				setUnbounded((Boolean)newValue);
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
			case MappingPackage.LINK__ELEMENT_REFS:
				getElementRefs().clear();
				return;
			case MappingPackage.LINK__UNBOUNDED:
				setUnbounded(UNBOUNDED_EDEFAULT);
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
			case MappingPackage.LINK__ELEMENT_REFS:
				return elementRefs != null && !elementRefs.isEmpty();
			case MappingPackage.LINK__UNBOUNDED:
				return unbounded != UNBOUNDED_EDEFAULT;
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
		result.append(" (unbounded: ");
		result.append(unbounded);
		result.append(')');
		return result.toString();
	}

} //LinkImpl
