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
package edu.toronto.cs.se.mmint.mid.impl;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMF Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl#getFeatureName <em>Feature Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl#isAttribute <em>Attribute</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.EMFInfoImpl#getRelatedClassName <em>Related Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EMFInfoImpl extends MinimalEObjectImpl.Container implements EMFInfo {
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
	 * The default value of the '{@link #isAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ATTRIBUTE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttribute()
	 * @generated
	 * @ordered
	 */
	protected boolean attribute = ATTRIBUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelatedClassName() <em>Related Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATED_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelatedClassName() <em>Related Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelatedClassName()
	 * @generated
	 * @ordered
	 */
	protected String relatedClassName = RELATED_CLASS_NAME_EDEFAULT;

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
		return MIDPackage.Literals.EMF_INFO;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EMF_INFO__CLASS_NAME, oldClassName, className));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EMF_INFO__FEATURE_NAME, oldFeatureName, featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAttribute() {
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute(boolean newAttribute) {
		boolean oldAttribute = attribute;
		attribute = newAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EMF_INFO__ATTRIBUTE, oldAttribute, attribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRelatedClassName() {
		return relatedClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelatedClassName(String newRelatedClassName) {
		String oldRelatedClassName = relatedClassName;
		relatedClassName = newRelatedClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EMF_INFO__RELATED_CLASS_NAME, oldRelatedClassName, relatedClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MIDPackage.EMF_INFO__CLASS_NAME:
				return getClassName();
			case MIDPackage.EMF_INFO__FEATURE_NAME:
				return getFeatureName();
			case MIDPackage.EMF_INFO__ATTRIBUTE:
				return isAttribute();
			case MIDPackage.EMF_INFO__RELATED_CLASS_NAME:
				return getRelatedClassName();
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
			case MIDPackage.EMF_INFO__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case MIDPackage.EMF_INFO__FEATURE_NAME:
				setFeatureName((String)newValue);
				return;
			case MIDPackage.EMF_INFO__ATTRIBUTE:
				setAttribute((Boolean)newValue);
				return;
			case MIDPackage.EMF_INFO__RELATED_CLASS_NAME:
				setRelatedClassName((String)newValue);
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
			case MIDPackage.EMF_INFO__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case MIDPackage.EMF_INFO__FEATURE_NAME:
				setFeatureName(FEATURE_NAME_EDEFAULT);
				return;
			case MIDPackage.EMF_INFO__ATTRIBUTE:
				setAttribute(ATTRIBUTE_EDEFAULT);
				return;
			case MIDPackage.EMF_INFO__RELATED_CLASS_NAME:
				setRelatedClassName(RELATED_CLASS_NAME_EDEFAULT);
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
			case MIDPackage.EMF_INFO__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case MIDPackage.EMF_INFO__FEATURE_NAME:
				return FEATURE_NAME_EDEFAULT == null ? featureName != null : !FEATURE_NAME_EDEFAULT.equals(featureName);
			case MIDPackage.EMF_INFO__ATTRIBUTE:
				return attribute != ATTRIBUTE_EDEFAULT;
			case MIDPackage.EMF_INFO__RELATED_CLASS_NAME:
				return RELATED_CLASS_NAME_EDEFAULT == null ? relatedClassName != null : !RELATED_CLASS_NAME_EDEFAULT.equals(relatedClassName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case MIDPackage.EMF_INFO___TO_TYPE_STRING:
				return toTypeString();
			case MIDPackage.EMF_INFO___TO_INSTANCE_STRING:
				return toInstanceString();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(", attribute: ");
		result.append(attribute);
		result.append(", relatedClassName: ");
		result.append(relatedClassName);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	public String toTypeString() {

		String typeString = getClassName();
		if (getFeatureName() != null) {
			typeString += MMINT.MODELELEMENT_FEATURE_SEPARATOR1 + getFeatureName();
			if (!isAttribute()) {
				typeString += MMINT.MODELELEMENT_REFERENCE_SEPARATOR;
			}
			typeString += MMINT.MODELELEMENT_FEATURE_SEPARATOR2;
		}

		return typeString;
	}

	/**
	 * @generated NOT
	 */
	public String toInstanceString() {

		String instanceString = (isAttribute()) ?
			MMINT.MODELELEMENT_EMFVALUE_PLACEHOLDER + MMINT.MODELELEMENT_FEATURE_SEPARATOR1 + getFeatureName() + MMINT.MODELELEMENT_FEATURE_SEPARATOR2 + " " + MMINT.MODELELEMENT_PRIMITIVEVALUE_PLACEHOLDER:
			MMINT.MODELELEMENT_FEATURE_SEPARATOR1 + getFeatureName() + MMINT.MODELELEMENT_REFERENCE_SEPARATOR + MMINT.MODELELEMENT_FEATURE_SEPARATOR2 + " " + MMINT.MODELELEMENT_EMFVALUE_PLACEHOLDER;

		return instanceString;
	}

} //EMFInfoImpl
