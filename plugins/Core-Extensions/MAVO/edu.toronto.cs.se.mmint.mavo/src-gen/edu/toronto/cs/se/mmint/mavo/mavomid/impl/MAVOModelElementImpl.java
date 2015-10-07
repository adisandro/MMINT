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

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement;

import edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>MAVO Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementImpl#getFormulaVariable <em>Formula Variable</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementImpl#isMay <em>May</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementImpl#isSet <em>Set</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementImpl#isVar <em>Var</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.MAVOModelElementImpl#getCollections <em>Collections</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MAVOModelElementImpl extends ModelElementImpl implements MAVOModelElement {
	/**
	 * The default value of the '{@link #getFormulaVariable() <em>Formula Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaVariable()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMULA_VARIABLE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getFormulaVariable() <em>Formula Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormulaVariable()
	 * @generated
	 * @ordered
	 */
	protected String formulaVariable = FORMULA_VARIABLE_EDEFAULT;
	/**
	 * The default value of the '{@link #isMay() <em>May</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMay()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAY_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isMay() <em>May</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMay()
	 * @generated
	 * @ordered
	 */
	protected boolean may = MAY_EDEFAULT;
	/**
	 * The default value of the '{@link #isSet() <em>Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSet()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SET_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isSet() <em>Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSet()
	 * @generated
	 * @ordered
	 */
	protected boolean set = SET_EDEFAULT;
	/**
	 * The default value of the '{@link #isVar() <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVar()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VAR_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isVar() <em>Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVar()
	 * @generated
	 * @ordered
	 */
	protected boolean var = VAR_EDEFAULT;
	/**
	 * The cached value of the '{@link #getCollections() <em>Collections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollections()
	 * @generated
	 * @ordered
	 */
	protected EList<MAVOCollection> collections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAVOModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MAVOMIDPackage.Literals.MAVO_MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormulaVariable() {
		return formulaVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormulaVariable(String newFormulaVariable) {
		String oldFormulaVariable = formulaVariable;
		formulaVariable = newFormulaVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.MAVO_MODEL_ELEMENT__FORMULA_VARIABLE, oldFormulaVariable, formulaVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMay() {
		return may;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMay(boolean newMay) {
		boolean oldMay = may;
		may = newMay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.MAVO_MODEL_ELEMENT__MAY, oldMay, may));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSet() {
		return set;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSet(boolean newSet) {
		boolean oldSet = set;
		set = newSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.MAVO_MODEL_ELEMENT__SET, oldSet, set));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVar() {
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVar(boolean newVar) {
		boolean oldVar = var;
		var = newVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.MAVO_MODEL_ELEMENT__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MAVOCollection> getCollections() {
		if (collections == null) {
			collections = new EObjectWithInverseResolvingEList.ManyInverse<MAVOCollection>(MAVOCollection.class, this, MAVOMIDPackage.MAVO_MODEL_ELEMENT__COLLECTIONS, MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS);
		}
		return collections;
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
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__COLLECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCollections()).basicAdd(otherEnd, msgs);
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
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__COLLECTIONS:
				return ((InternalEList<?>)getCollections()).basicRemove(otherEnd, msgs);
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
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__FORMULA_VARIABLE:
				return getFormulaVariable();
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__MAY:
				return isMay();
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__SET:
				return isSet();
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__VAR:
				return isVar();
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__COLLECTIONS:
				return getCollections();
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
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__FORMULA_VARIABLE:
				setFormulaVariable((String)newValue);
				return;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__MAY:
				setMay((Boolean)newValue);
				return;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__SET:
				setSet((Boolean)newValue);
				return;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__VAR:
				setVar((Boolean)newValue);
				return;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__COLLECTIONS:
				getCollections().clear();
				getCollections().addAll((Collection<? extends MAVOCollection>)newValue);
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
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__FORMULA_VARIABLE:
				setFormulaVariable(FORMULA_VARIABLE_EDEFAULT);
				return;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__MAY:
				setMay(MAY_EDEFAULT);
				return;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__SET:
				setSet(SET_EDEFAULT);
				return;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__VAR:
				setVar(VAR_EDEFAULT);
				return;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__COLLECTIONS:
				getCollections().clear();
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
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__FORMULA_VARIABLE:
				return FORMULA_VARIABLE_EDEFAULT == null ? formulaVariable != null : !FORMULA_VARIABLE_EDEFAULT.equals(formulaVariable);
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__MAY:
				return may != MAY_EDEFAULT;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__SET:
				return set != SET_EDEFAULT;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__VAR:
				return var != VAR_EDEFAULT;
			case MAVOMIDPackage.MAVO_MODEL_ELEMENT__COLLECTIONS:
				return collections != null && !collections.isEmpty();
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
		if (baseClass == LogicElement.class) {
			switch (derivedFeatureID) {
				case MAVOMIDPackage.MAVO_MODEL_ELEMENT__FORMULA_VARIABLE: return MAVOPackage.LOGIC_ELEMENT__FORMULA_VARIABLE;
				default: return -1;
			}
		}
		if (baseClass == MAVOElement.class) {
			switch (derivedFeatureID) {
				case MAVOMIDPackage.MAVO_MODEL_ELEMENT__MAY: return MAVOPackage.MAVO_ELEMENT__MAY;
				case MAVOMIDPackage.MAVO_MODEL_ELEMENT__SET: return MAVOPackage.MAVO_ELEMENT__SET;
				case MAVOMIDPackage.MAVO_MODEL_ELEMENT__VAR: return MAVOPackage.MAVO_ELEMENT__VAR;
				case MAVOMIDPackage.MAVO_MODEL_ELEMENT__COLLECTIONS: return MAVOPackage.MAVO_ELEMENT__COLLECTIONS;
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
		if (baseClass == LogicElement.class) {
			switch (baseFeatureID) {
				case MAVOPackage.LOGIC_ELEMENT__FORMULA_VARIABLE: return MAVOMIDPackage.MAVO_MODEL_ELEMENT__FORMULA_VARIABLE;
				default: return -1;
			}
		}
		if (baseClass == MAVOElement.class) {
			switch (baseFeatureID) {
				case MAVOPackage.MAVO_ELEMENT__MAY: return MAVOMIDPackage.MAVO_MODEL_ELEMENT__MAY;
				case MAVOPackage.MAVO_ELEMENT__SET: return MAVOMIDPackage.MAVO_MODEL_ELEMENT__SET;
				case MAVOPackage.MAVO_ELEMENT__VAR: return MAVOMIDPackage.MAVO_MODEL_ELEMENT__VAR;
				case MAVOPackage.MAVO_ELEMENT__COLLECTIONS: return MAVOMIDPackage.MAVO_MODEL_ELEMENT__COLLECTIONS;
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
		result.append(" (formulaVariable: ");
		result.append(formulaVariable);
		result.append(", may: ");
		result.append(may);
		result.append(", set: ");
		result.append(set);
		result.append(", var: ");
		result.append(var);
		result.append(')');
		return result.toString();
	}

	/**
	 * Creates and adds a model element instance of a type to be automatically
	 * detected and a reference to it to an Instance MID, initializing its MAVO
	 * may/set/var flags.
	 * 
	 * @param modelObj
	 *            The EMF model object to be wrapped by the MMINT new model
	 *            element.
	 * @param newModelElemName
	 *            The name of the new model element.
	 * @param containerModelEndpointRef
	 *            The reference to the model endpoint that will contain the new
	 *            reference to the new model element.
	 * @return The created reference to the new model element.
	 * @throws MMINTException
	 *             If the uri of the new model element is already registered in
	 *             the Instance MID.
	 * @generated NOT
	 */
	public static ModelElementReference createInstanceAndReference(EObject modelObj, String newModelElemName, ModelEndpointReference containerModelEndpointRef) throws MMINTException {

		//TODO MMINT[MAVO] This can't be static for polymorphism to work
		ModelElementReference newMAVOModelElemRef = ModelElementImpl.createInstanceAndReference(modelObj, newModelElemName, containerModelEndpointRef);
		MAVOUtils.initializeMAVOModelElementReference(modelObj, newMAVOModelElemRef);

		return newMAVOModelElemRef;
	}

} //MAVOModelElementImpl
