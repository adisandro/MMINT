/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.mavomid.impl;

import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDFactory;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.impl.ModelImpl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAVO Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelImpl#isInc <em>Inc</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelImpl#getDecisions <em>Decisions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MAVOModelImpl extends ModelImpl implements MAVOModel {
	/**
	 * The default value of the '{@link #isInc() <em>Inc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInc()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INC_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isInc() <em>Inc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInc()
	 * @generated
	 * @ordered
	 */
	protected boolean inc = INC_EDEFAULT;
	/**
	 * The cached value of the '{@link #getDecisions() <em>Decisions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDecisions()
	 * @generated
	 * @ordered
	 */
	protected EList<MAVODecision> decisions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAVOModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MAVOMIDPackage.Literals.MAVO_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInc() {
		return inc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInc(boolean newInc) {
		boolean oldInc = inc;
		inc = newInc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.MAVO_MODEL__INC, oldInc, inc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MAVODecision> getDecisions() {
		if (decisions == null) {
			decisions = new EObjectContainmentEList<MAVODecision>(MAVODecision.class, this, MAVOMIDPackage.MAVO_MODEL__DECISIONS);
		}
		return decisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
				return ((InternalEList<?>)getDecisions()).basicRemove(otherEnd, msgs);
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
			case MAVOMIDPackage.MAVO_MODEL__INC:
				return isInc();
			case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
				return getDecisions();
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
			case MAVOMIDPackage.MAVO_MODEL__INC:
				setInc((Boolean)newValue);
				return;
			case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
				getDecisions().clear();
				getDecisions().addAll((Collection<? extends MAVODecision>)newValue);
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
			case MAVOMIDPackage.MAVO_MODEL__INC:
				setInc(INC_EDEFAULT);
				return;
			case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
				getDecisions().clear();
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
			case MAVOMIDPackage.MAVO_MODEL__INC:
				return inc != INC_EDEFAULT;
			case MAVOMIDPackage.MAVO_MODEL__DECISIONS:
				return decisions != null && !decisions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == MAVORoot.class) {
			switch (derivedFeatureID) {
				case MAVOMIDPackage.MAVO_MODEL__INC: return MAVOPackage.MAVO_ROOT__INC;
				case MAVOMIDPackage.MAVO_MODEL__DECISIONS: return MAVOPackage.MAVO_ROOT__DECISIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == MAVORoot.class) {
			switch (baseFeatureID) {
				case MAVOPackage.MAVO_ROOT__INC: return MAVOMIDPackage.MAVO_MODEL__INC;
				case MAVOPackage.MAVO_ROOT__DECISIONS: return MAVOMIDPackage.MAVO_MODEL__DECISIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (inc: ");
		result.append(inc);
		result.append(')');
		return result.toString();
	}

	/**
	 * @generated NOT
	 */
	public Model createSubtype(String newModelTypeName, String constraintLanguage, String constraintImplementation, boolean isMetamodelExtension) throws MMINTException {

		MMINTException.mustBeType(this);

		MAVOModel newMAVOModelType = MAVOMIDFactory.eINSTANCE.createMAVOModel();
		super.addSubtype(newMAVOModelType, newModelTypeName, constraintLanguage, constraintImplementation, isMetamodelExtension);

		return newMAVOModelType;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Model createInstance(String newModelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		MAVOModel newMAVOModel = MAVOMIDFactory.eINSTANCE.createMAVOModel();
		super.addInstance(newMAVOModel, newModelUri, ModelOrigin.CREATED, instanceMID);
		MAVOUtils.initializeMAVOModel(newMAVOModel.getEMFInstanceRoot(), newMAVOModel);

		return newMAVOModel;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public Model createInstanceAndEditor(String newModelUri, MID instanceMID) throws MMINTException {

		MAVOModel newMAVOModel = (MAVOModel) this.createInstance(newModelUri, instanceMID);
		if (instanceMID != null) {
			newMAVOModel.createInstanceEditor();
		}

		return newMAVOModel;
	}

	/**
	 * @generated NOT
	 */
	public Model importInstance(String modelUri, MID instanceMID) throws MMINTException {

		MMINTException.mustBeType(this);

		MAVOModel newMAVOModel = MAVOMIDFactory.eINSTANCE.createMAVOModel();
		super.addInstance(newMAVOModel, modelUri, ModelOrigin.IMPORTED, instanceMID);
		MAVOUtils.initializeMAVOModel(newMAVOModel.getEMFInstanceRoot(), newMAVOModel);

		return newMAVOModel;
	}

	/**
	 * @generated NOT
	 */
	public Model importInstanceAndEditor(String modelUri, MID instanceMID) throws MMINTException {

		MAVOModel newMAVOModel = (MAVOModel) this.importInstance(modelUri, instanceMID);
		if (instanceMID != null) {
			newMAVOModel.createInstanceEditor();
		}

		return newMAVOModel;
	}

} //MAVOModelImpl
