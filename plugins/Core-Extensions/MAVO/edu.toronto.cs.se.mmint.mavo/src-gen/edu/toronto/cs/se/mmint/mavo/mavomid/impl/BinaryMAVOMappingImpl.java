/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMapping;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMIDPackage;

import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping;
import edu.toronto.cs.se.mmint.mid.relationship.impl.BinaryMappingImpl;
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
 * An implementation of the model object '<em><b>MAVO Binary Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingImpl#getFormulaVariable <em>Formula Variable</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingImpl#isMay <em>May</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingImpl#isSet <em>Set</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingImpl#isVar <em>Var</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mavo.mavomid.impl.BinaryMAVOMappingImpl#getCollections <em>Collections</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BinaryMAVOMappingImpl extends BinaryMappingImpl implements BinaryMAVOMapping {
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
	protected BinaryMAVOMappingImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected EClass eStaticClass() {
        return MAVOMIDPackage.Literals.BINARY_MAVO_MAPPING;
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
            eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.BINARY_MAVO_MAPPING__FORMULA_VARIABLE, oldFormulaVariable, formulaVariable));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.BINARY_MAVO_MAPPING__MAY, oldMay, may));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.BINARY_MAVO_MAPPING__SET, oldSet, set));
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
            eNotify(new ENotificationImpl(this, Notification.SET, MAVOMIDPackage.BINARY_MAVO_MAPPING__VAR, oldVar, var));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<MAVOCollection> getCollections() {
        if (collections == null) {
            collections = new EObjectWithInverseResolvingEList.ManyInverse<MAVOCollection>(MAVOCollection.class, this, MAVOMIDPackage.BINARY_MAVO_MAPPING__COLLECTIONS, MAVOPackage.MAVO_COLLECTION__MAVO_ELEMENTS);
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
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__COLLECTIONS:
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
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__COLLECTIONS:
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
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__FORMULA_VARIABLE:
                return getFormulaVariable();
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__MAY:
                return isMay();
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__SET:
                return isSet();
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__VAR:
                return isVar();
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__COLLECTIONS:
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
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__FORMULA_VARIABLE:
                setFormulaVariable((String)newValue);
                return;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__MAY:
                setMay((Boolean)newValue);
                return;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__SET:
                setSet((Boolean)newValue);
                return;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__VAR:
                setVar((Boolean)newValue);
                return;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__COLLECTIONS:
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
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__FORMULA_VARIABLE:
                setFormulaVariable(FORMULA_VARIABLE_EDEFAULT);
                return;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__MAY:
                setMay(MAY_EDEFAULT);
                return;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__SET:
                setSet(SET_EDEFAULT);
                return;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__VAR:
                setVar(VAR_EDEFAULT);
                return;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__COLLECTIONS:
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
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__FORMULA_VARIABLE:
                return FORMULA_VARIABLE_EDEFAULT == null ? formulaVariable != null : !FORMULA_VARIABLE_EDEFAULT.equals(formulaVariable);
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__MAY:
                return may != MAY_EDEFAULT;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__SET:
                return set != SET_EDEFAULT;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__VAR:
                return var != VAR_EDEFAULT;
            case MAVOMIDPackage.BINARY_MAVO_MAPPING__COLLECTIONS:
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
                case MAVOMIDPackage.BINARY_MAVO_MAPPING__FORMULA_VARIABLE: return MAVOPackage.LOGIC_ELEMENT__FORMULA_VARIABLE;
                default: return -1;
            }
        }
        if (baseClass == MAVOElement.class) {
            switch (derivedFeatureID) {
                case MAVOMIDPackage.BINARY_MAVO_MAPPING__MAY: return MAVOPackage.MAVO_ELEMENT__MAY;
                case MAVOMIDPackage.BINARY_MAVO_MAPPING__SET: return MAVOPackage.MAVO_ELEMENT__SET;
                case MAVOMIDPackage.BINARY_MAVO_MAPPING__VAR: return MAVOPackage.MAVO_ELEMENT__VAR;
                case MAVOMIDPackage.BINARY_MAVO_MAPPING__COLLECTIONS: return MAVOPackage.MAVO_ELEMENT__COLLECTIONS;
                default: return -1;
            }
        }
        if (baseClass == MAVOMapping.class) {
            switch (derivedFeatureID) {
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
                case MAVOPackage.LOGIC_ELEMENT__FORMULA_VARIABLE: return MAVOMIDPackage.BINARY_MAVO_MAPPING__FORMULA_VARIABLE;
                default: return -1;
            }
        }
        if (baseClass == MAVOElement.class) {
            switch (baseFeatureID) {
                case MAVOPackage.MAVO_ELEMENT__MAY: return MAVOMIDPackage.BINARY_MAVO_MAPPING__MAY;
                case MAVOPackage.MAVO_ELEMENT__SET: return MAVOMIDPackage.BINARY_MAVO_MAPPING__SET;
                case MAVOPackage.MAVO_ELEMENT__VAR: return MAVOMIDPackage.BINARY_MAVO_MAPPING__VAR;
                case MAVOPackage.MAVO_ELEMENT__COLLECTIONS: return MAVOMIDPackage.BINARY_MAVO_MAPPING__COLLECTIONS;
                default: return -1;
            }
        }
        if (baseClass == MAVOMapping.class) {
            switch (baseFeatureID) {
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

} //MAVOBinaryMappingImpl
