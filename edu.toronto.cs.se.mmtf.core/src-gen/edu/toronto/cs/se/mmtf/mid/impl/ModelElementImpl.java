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

import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import java.lang.reflect.InvocationTargetException;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl#getPointer <em>Pointer</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.ModelElementImpl#getClassLiteral <em>Class Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModelElementImpl extends ExtendibleElementImpl implements ModelElement {
	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final ModelElementCategory CATEGORY_EDEFAULT = ModelElementCategory.ENTITY;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected ModelElementCategory category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassLiteral() <em>Class Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassLiteral()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_LITERAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassLiteral() <em>Class Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassLiteral()
	 * @generated
	 * @ordered
	 */
	protected String classLiteral = CLASS_LITERAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidPackage.Literals.MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementCategory getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(ModelElementCategory newCategory) {
		ModelElementCategory oldCategory = category;
		category = newCategory == null ? CATEGORY_EDEFAULT : newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.MODEL_ELEMENT__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getPointer() {
		EObject pointer = basicGetPointer();
		return pointer != null && pointer.eIsProxy() ? eResolveProxy((InternalEObject)pointer) : pointer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetPointerGen() {
		// TODO: implement this method to return the 'Pointer' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * Gets the element pointer at runtime, storing it has no meaning
	 * (especially when serializing/deserializing), thus preventing us from
	 * using it in a proper way.
	 * 
	 * @generated NOT
	 */
	public EObject basicGetPointer() {

		return MultiModelTypeIntrospection.getPointer(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassLiteral() {
		return classLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassLiteral(String newClassLiteral) {
		String oldClassLiteral = classLiteral;
		classLiteral = newClassLiteral;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MidPackage.MODEL_ELEMENT__CLASS_LITERAL, oldClassLiteral, classLiteral));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getMetatype() {
		return (ModelElement) super.getMetatype();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElement getSupertype() {
		return (ModelElement) super.getSupertype();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MidPackage.MODEL_ELEMENT__CATEGORY:
				return getCategory();
			case MidPackage.MODEL_ELEMENT__POINTER:
				if (resolve) return getPointer();
				return basicGetPointer();
			case MidPackage.MODEL_ELEMENT__CLASS_LITERAL:
				return getClassLiteral();
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
			case MidPackage.MODEL_ELEMENT__CATEGORY:
				setCategory((ModelElementCategory)newValue);
				return;
			case MidPackage.MODEL_ELEMENT__CLASS_LITERAL:
				setClassLiteral((String)newValue);
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
			case MidPackage.MODEL_ELEMENT__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case MidPackage.MODEL_ELEMENT__CLASS_LITERAL:
				setClassLiteral(CLASS_LITERAL_EDEFAULT);
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
			case MidPackage.MODEL_ELEMENT__CATEGORY:
				return category != CATEGORY_EDEFAULT;
			case MidPackage.MODEL_ELEMENT__POINTER:
				return basicGetPointer() != null;
			case MidPackage.MODEL_ELEMENT__CLASS_LITERAL:
				return CLASS_LITERAL_EDEFAULT == null ? classLiteral != null : !CLASS_LITERAL_EDEFAULT.equals(classLiteral);
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
			case MidPackage.MODEL_ELEMENT___GET_METATYPE:
				return getMetatype();
			case MidPackage.MODEL_ELEMENT___GET_SUPERTYPE:
				return getSupertype();
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
		result.append(" (category: ");
		result.append(category);
		result.append(", classLiteral: ");
		result.append(classLiteral);
		result.append(')');
		return result.toString();
	}

} //ModelElementImpl
