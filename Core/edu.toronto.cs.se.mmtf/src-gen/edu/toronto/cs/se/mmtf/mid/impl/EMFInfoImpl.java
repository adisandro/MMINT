/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.impl;

import edu.toronto.cs.se.mmtf.mid.EMFInfo;
import edu.toronto.cs.se.mmtf.mid.MidPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMF Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.EMFInfoImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.EMFInfoImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.EMFInfoImpl#isReference <em>Reference</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.EMFInfoImpl#getContainerClassName <em>Container Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMFInfoImpl extends EObjectImpl implements EMFInfo {
	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReference()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFERENCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReference() <em>Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReference()
	 * @generated
	 * @ordered
	 */
	protected boolean reference = REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getContainerClassName() <em>Container Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTAINER_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContainerClassName() <em>Container Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainerClassName()
	 * @generated
	 * @ordered
	 */
	protected String containerClassName = CONTAINER_CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMFInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidPackage.Literals.EMF_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EMF_INFO__CLASS_NAME, oldClassName, className));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		String oldFeatureName = featureName;
		featureName = newFeatureName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EMF_INFO__FEATURE_NAME, oldFeatureName, featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(boolean newReference) {
		boolean oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EMF_INFO__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContainerClassName() {
		return containerClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContainerClassName(String newContainerClassName) {
		String oldContainerClassName = containerClassName;
		containerClassName = newContainerClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.EMF_INFO__CONTAINER_CLASS_NAME, oldContainerClassName, containerClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidPackage.EMF_INFO__CLASS_NAME:
				return getClassName();
			case MidPackage.EMF_INFO__FEATURE_NAME:
				return getFeatureName();
			case MidPackage.EMF_INFO__REFERENCE:
				return isReference();
			case MidPackage.EMF_INFO__CONTAINER_CLASS_NAME:
				return getContainerClassName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MidPackage.EMF_INFO__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case MidPackage.EMF_INFO__FEATURE_NAME:
				setFeatureName((String)newValue);
				return;
			case MidPackage.EMF_INFO__REFERENCE:
				setReference((Boolean)newValue);
				return;
			case MidPackage.EMF_INFO__CONTAINER_CLASS_NAME:
				setContainerClassName((String)newValue);
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
			case MidPackage.EMF_INFO__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case MidPackage.EMF_INFO__FEATURE_NAME:
				setFeatureName(FEATURE_NAME_EDEFAULT);
				return;
			case MidPackage.EMF_INFO__REFERENCE:
				setReference(REFERENCE_EDEFAULT);
				return;
			case MidPackage.EMF_INFO__CONTAINER_CLASS_NAME:
				setContainerClassName(CONTAINER_CLASS_NAME_EDEFAULT);
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
			case MidPackage.EMF_INFO__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case MidPackage.EMF_INFO__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
			case MidPackage.EMF_INFO__REFERENCE:
				return reference != REFERENCE_EDEFAULT;
			case MidPackage.EMF_INFO__CONTAINER_CLASS_NAME:
				return CONTAINER_CLASS_NAME_EDEFAULT == null ? containerClassName != null : !CONTAINER_CLASS_NAME_EDEFAULT.equals(containerClassName);
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
		result.append(" (className: ");
		result.append(className);
		result.append(", featureName: ");
		result.append(featureName);
		result.append(", reference: ");
		result.append(reference);
		result.append(", containerClassName: ");
		result.append(containerClassName);
		result.append(')');
		return result.toString();
	}

} //EMFInfoImpl
