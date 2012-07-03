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
package edu.toronto.cs.se.mmtf.mid.impl;

import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.TypedElement;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl#getMetatype <em>Metatype</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl#getRuntimeMetatypes <em>Runtime Metatypes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.TypedElementImpl#getMetatypeUri <em>Metatype Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TypedElementImpl extends EObjectImpl implements TypedElement {
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
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final MidLevel LEVEL_EDEFAULT = MidLevel.INSTANCES;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected MidLevel level = LEVEL_EDEFAULT;

	/**
	 * The cached setting delegate for the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate TYPE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)MidPackage.Literals.TYPED_ELEMENT__TYPE).getSettingDelegate();

	/**
	 * The default value of the '{@link #getMetatypeUri() <em>Metatype Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetatypeUri()
	 * @generated
	 * @ordered
	 */
	protected static final String METATYPE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMetatypeUri() <em>Metatype Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetatypeUri()
	 * @generated
	 * @ordered
	 */
	protected String metatypeUri = METATYPE_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidPackage.Literals.TYPED_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.TYPED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement getMetatype() {
		TypedElement metatype = basicGetMetatype();
		return metatype != null && metatype.eIsProxy() ? (TypedElement)eResolveProxy((InternalEObject)metatype) : metatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement basicGetMetatypeGen() {
		// TODO: implement this method to return the 'Metatype' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * Uses metatype uri to get static metatype.
	 * 
	 * @generated NOT
	 */
	public TypedElement basicGetMetatype() {

		return MultiModelTypeIntrospection.getType(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MidLevel getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(MidLevel newLevel) {
		MidLevel oldLevel = level;
		level = newLevel == null ? LEVEL_EDEFAULT : newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.TYPED_ELEMENT__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return (String)TYPE__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypedElement> getRuntimeMetatypesGen() {
		// TODO: implement this method to return the 'Runtime Metatypes' reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * Uses type introspection to get runtime metatypes.
	 * 
	 * @generated NOT
	 */
	public EList<TypedElement> getRuntimeMetatypes() {

		return MultiModelTypeIntrospection.getRuntimeTypes(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetatypeUri() {
		return metatypeUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetatypeUri(String newMetatypeUri) {
		String oldMetatypeUri = metatypeUri;
		metatypeUri = newMetatypeUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.TYPED_ELEMENT__METATYPE_URI, oldMetatypeUri, metatypeUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidPackage.TYPED_ELEMENT__NAME:
				return getName();
			case MidPackage.TYPED_ELEMENT__METATYPE:
				if (resolve) return getMetatype();
				return basicGetMetatype();
			case MidPackage.TYPED_ELEMENT__LEVEL:
				return getLevel();
			case MidPackage.TYPED_ELEMENT__TYPE:
				return getType();
			case MidPackage.TYPED_ELEMENT__RUNTIME_METATYPES:
				return getRuntimeMetatypes();
			case MidPackage.TYPED_ELEMENT__METATYPE_URI:
				return getMetatypeUri();
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
			case MidPackage.TYPED_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case MidPackage.TYPED_ELEMENT__LEVEL:
				setLevel((MidLevel)newValue);
				return;
			case MidPackage.TYPED_ELEMENT__METATYPE_URI:
				setMetatypeUri((String)newValue);
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
			case MidPackage.TYPED_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MidPackage.TYPED_ELEMENT__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case MidPackage.TYPED_ELEMENT__METATYPE_URI:
				setMetatypeUri(METATYPE_URI_EDEFAULT);
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
			case MidPackage.TYPED_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MidPackage.TYPED_ELEMENT__METATYPE:
				return basicGetMetatype() != null;
			case MidPackage.TYPED_ELEMENT__LEVEL:
				return level != LEVEL_EDEFAULT;
			case MidPackage.TYPED_ELEMENT__TYPE:
				return TYPE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case MidPackage.TYPED_ELEMENT__RUNTIME_METATYPES:
				return !getRuntimeMetatypes().isEmpty();
			case MidPackage.TYPED_ELEMENT__METATYPE_URI:
				return METATYPE_URI_EDEFAULT == null ? metatypeUri != null : !METATYPE_URI_EDEFAULT.equals(metatypeUri);
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
		result.append(", level: ");
		result.append(level);
		result.append(", metatypeUri: ");
		result.append(metatypeUri);
		result.append(')');
		return result.toString();
	}

} //TypedElementImpl
