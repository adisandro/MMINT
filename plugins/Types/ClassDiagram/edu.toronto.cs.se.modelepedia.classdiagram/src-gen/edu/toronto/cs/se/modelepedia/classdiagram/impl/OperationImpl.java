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
package edu.toronto.cs.se.modelepedia.classdiagram.impl;

import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;

import edu.toronto.cs.se.modelepedia.classdiagram.Typeable;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl#getParameterTypes <em>Parameter Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationImpl extends TypedElementImpl implements Operation {
	/**
	 * The cached value of the '{@link #getParameterTypes() <em>Parameter Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Typeable> parameterTypes;

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
		return ClassDiagramPackage.Literals.OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public edu.toronto.cs.se.modelepedia.classdiagram.Class getOwner() {
		if (eContainerFeatureID() != ClassDiagramPackage.OPERATION__OWNER) return null;
		return (edu.toronto.cs.se.modelepedia.classdiagram.Class)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(edu.toronto.cs.se.modelepedia.classdiagram.Class newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, ClassDiagramPackage.OPERATION__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(edu.toronto.cs.se.modelepedia.classdiagram.Class newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != ClassDiagramPackage.OPERATION__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, ClassDiagramPackage.CLASS__OWNED_OPERATIONS, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.OPERATION__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Typeable> getParameterTypes() {
		if (parameterTypes == null) {
			parameterTypes = new EObjectResolvingEList<Typeable>(Typeable.class, this, ClassDiagramPackage.OPERATION__PARAMETER_TYPES);
		}
		return parameterTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassDiagramPackage.OPERATION__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((edu.toronto.cs.se.modelepedia.classdiagram.Class)otherEnd, msgs);
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
			case ClassDiagramPackage.OPERATION__OWNER:
				return basicSetOwner(null, msgs);
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
			case ClassDiagramPackage.OPERATION__OWNER:
				return eInternalContainer().eInverseRemove(this, ClassDiagramPackage.CLASS__OWNED_OPERATIONS, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
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
			case ClassDiagramPackage.OPERATION__OWNER:
				return getOwner();
			case ClassDiagramPackage.OPERATION__PARAMETER_TYPES:
				return getParameterTypes();
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
			case ClassDiagramPackage.OPERATION__OWNER:
				setOwner((edu.toronto.cs.se.modelepedia.classdiagram.Class)newValue);
				return;
			case ClassDiagramPackage.OPERATION__PARAMETER_TYPES:
				getParameterTypes().clear();
				getParameterTypes().addAll((Collection<? extends Typeable>)newValue);
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
			case ClassDiagramPackage.OPERATION__OWNER:
				setOwner((edu.toronto.cs.se.modelepedia.classdiagram.Class)null);
				return;
			case ClassDiagramPackage.OPERATION__PARAMETER_TYPES:
				getParameterTypes().clear();
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
			case ClassDiagramPackage.OPERATION__OWNER:
				return getOwner() != null;
			case ClassDiagramPackage.OPERATION__PARAMETER_TYPES:
				return parameterTypes != null && !parameterTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationImpl
