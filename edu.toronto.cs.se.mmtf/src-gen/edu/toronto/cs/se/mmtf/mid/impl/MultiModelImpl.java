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

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidPackage;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmtf.mid.editor.impl.EStringToEditorMapImpl;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl#getModels <em>Models</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmtf.mid.impl.MultiModelImpl#getExtendibles <em>Extendibles</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiModelImpl extends EObjectImpl implements MultiModel {
	/**
	 * The cached value of the '{@link #getModels() <em>Models</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModels()
	 * @generated
	 * @ordered
	 */
	protected EList<Model> models;

	/**
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Editor> editors;

	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<Operator> operators;

	/**
	 * The cached value of the '{@link #getExtendibles() <em>Extendibles</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtendibles()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, ExtendibleElement> extendibles;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MidPackage.Literals.MULTI_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Model> getModels() {
		if (models == null) {
			models = new EObjectContainmentEList<Model>(Model.class, this, MidPackage.MULTI_MODEL__MODELS);
		}
		return models;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, Editor> getEditors() {
		if (editors == null) {
			editors = new EcoreEMap<String,Editor>(EditorPackage.Literals.ESTRING_TO_EDITOR_MAP, EStringToEditorMapImpl.class, this, MidPackage.MULTI_MODEL__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operator> getOperators() {
		if (operators == null) {
			operators = new EObjectContainmentEList<Operator>(Operator.class, this, MidPackage.MULTI_MODEL__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, ExtendibleElement> getExtendibles() {
		if (extendibles == null) {
			extendibles = new EcoreEMap<String,ExtendibleElement>(MidPackage.Literals.ESTRING_TO_EXTENDIBLE_ELEMENT_MAP, EStringToExtendibleElementMapImpl.class, this, MidPackage.MULTI_MODEL__EXTENDIBLES);
		}
		return extendibles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MidPackage.MULTI_MODEL__MODELS:
				return ((InternalEList<?>)getModels()).basicRemove(otherEnd, msgs);
			case MidPackage.MULTI_MODEL__EDITORS:
				return ((InternalEList<?>)getEditors()).basicRemove(otherEnd, msgs);
			case MidPackage.MULTI_MODEL__OPERATORS:
				return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
			case MidPackage.MULTI_MODEL__EXTENDIBLES:
				return ((InternalEList<?>)getExtendibles()).basicRemove(otherEnd, msgs);
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
			case MidPackage.MULTI_MODEL__MODELS:
				return getModels();
			case MidPackage.MULTI_MODEL__EDITORS:
				if (coreType) return getEditors();
				else return getEditors().map();
			case MidPackage.MULTI_MODEL__OPERATORS:
				return getOperators();
			case MidPackage.MULTI_MODEL__EXTENDIBLES:
				if (coreType) return getExtendibles();
				else return getExtendibles().map();
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
			case MidPackage.MULTI_MODEL__MODELS:
				getModels().clear();
				getModels().addAll((Collection<? extends Model>)newValue);
				return;
			case MidPackage.MULTI_MODEL__EDITORS:
				((EStructuralFeature.Setting)getEditors()).set(newValue);
				return;
			case MidPackage.MULTI_MODEL__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends Operator>)newValue);
				return;
			case MidPackage.MULTI_MODEL__EXTENDIBLES:
				((EStructuralFeature.Setting)getExtendibles()).set(newValue);
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
			case MidPackage.MULTI_MODEL__MODELS:
				getModels().clear();
				return;
			case MidPackage.MULTI_MODEL__EDITORS:
				getEditors().clear();
				return;
			case MidPackage.MULTI_MODEL__OPERATORS:
				getOperators().clear();
				return;
			case MidPackage.MULTI_MODEL__EXTENDIBLES:
				getExtendibles().clear();
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
			case MidPackage.MULTI_MODEL__MODELS:
				return models != null && !models.isEmpty();
			case MidPackage.MULTI_MODEL__EDITORS:
				return editors != null && !editors.isEmpty();
			case MidPackage.MULTI_MODEL__OPERATORS:
				return operators != null && !operators.isEmpty();
			case MidPackage.MULTI_MODEL__EXTENDIBLES:
				return extendibles != null && !extendibles.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MultiModelImpl
