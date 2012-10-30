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
package edu.toronto.cs.se.mmtf.mid.relationship.impl;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Binary Link Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkReferenceImpl#getSourceModelElemRef <em>Source Model Elem Ref</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.relationship.impl.BinaryLinkReferenceImpl#getTargetModelElemRef <em>Target Model Elem Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BinaryLinkReferenceImpl extends LinkReferenceImpl implements BinaryLinkReference {
	/**
	 * The cached setting delegate for the '{@link #getSourceModelElemRef() <em>Source Model Elem Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceModelElemRef()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate SOURCE_MODEL_ELEM_REF__ESETTING_DELEGATE = ((EStructuralFeature.Internal)RelationshipPackage.Literals.BINARY_LINK_REFERENCE__SOURCE_MODEL_ELEM_REF).getSettingDelegate();
	/**
	 * The cached setting delegate for the '{@link #getTargetModelElemRef() <em>Target Model Elem Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetModelElemRef()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate TARGET_MODEL_ELEM_REF__ESETTING_DELEGATE = ((EStructuralFeature.Internal)RelationshipPackage.Literals.BINARY_LINK_REFERENCE__TARGET_MODEL_ELEM_REF).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BinaryLinkReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RelationshipPackage.Literals.BINARY_LINK_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference getSourceModelElemRef() {
		return (ModelElementReference)SOURCE_MODEL_ELEM_REF__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference basicGetSourceModelElemRef() {
		return (ModelElementReference)SOURCE_MODEL_ELEM_REF__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceModelElemRef(ModelElementReference newSourceModelElemRef) {
		SOURCE_MODEL_ELEM_REF__ESETTING_DELEGATE.dynamicSet(this, null, 0, newSourceModelElemRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference getTargetModelElemRef() {
		return (ModelElementReference)TARGET_MODEL_ELEM_REF__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelElementReference basicGetTargetModelElemRef() {
		return (ModelElementReference)TARGET_MODEL_ELEM_REF__ESETTING_DELEGATE.dynamicGet(this, null, 0, false, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetModelElemRef(ModelElementReference newTargetModelElemRef) {
		TARGET_MODEL_ELEM_REF__ESETTING_DELEGATE.dynamicSet(this, null, 0, newTargetModelElemRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryLink getObject() {
		ExtendibleElement object = super.getObject();
		return (object == null) ? null : (BinaryLink) object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RelationshipPackage.BINARY_LINK_REFERENCE__SOURCE_MODEL_ELEM_REF:
				if (resolve) return getSourceModelElemRef();
				return basicGetSourceModelElemRef();
			case RelationshipPackage.BINARY_LINK_REFERENCE__TARGET_MODEL_ELEM_REF:
				if (resolve) return getTargetModelElemRef();
				return basicGetTargetModelElemRef();
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
			case RelationshipPackage.BINARY_LINK_REFERENCE__SOURCE_MODEL_ELEM_REF:
				setSourceModelElemRef((ModelElementReference)newValue);
				return;
			case RelationshipPackage.BINARY_LINK_REFERENCE__TARGET_MODEL_ELEM_REF:
				setTargetModelElemRef((ModelElementReference)newValue);
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
			case RelationshipPackage.BINARY_LINK_REFERENCE__SOURCE_MODEL_ELEM_REF:
				setSourceModelElemRef((ModelElementReference)null);
				return;
			case RelationshipPackage.BINARY_LINK_REFERENCE__TARGET_MODEL_ELEM_REF:
				setTargetModelElemRef((ModelElementReference)null);
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
			case RelationshipPackage.BINARY_LINK_REFERENCE__SOURCE_MODEL_ELEM_REF:
				return SOURCE_MODEL_ELEM_REF__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case RelationshipPackage.BINARY_LINK_REFERENCE__TARGET_MODEL_ELEM_REF:
				return TARGET_MODEL_ELEM_REF__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
		if (baseClass == LinkReference.class) {
			switch (baseOperationID) {
				case RelationshipPackage.LINK_REFERENCE___GET_OBJECT: return RelationshipPackage.BINARY_LINK_REFERENCE___GET_OBJECT;
				default: return super.eDerivedOperationID(baseOperationID, baseClass);
			}
		}
		return super.eDerivedOperationID(baseOperationID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case RelationshipPackage.BINARY_LINK_REFERENCE___GET_OBJECT:
				return getObject();
		}
		return super.eInvoke(operationID, arguments);
	}

} //BinaryLinkReferenceImpl
