/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl;

import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.MavoPackage;

import edu.toronto.cs.se.modelepedia.mavo.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.mavo.classdiagram.ClassdiagramPackage;
import edu.toronto.cs.se.modelepedia.mavo.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.mavo.classdiagram.Operation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.ClassImpl#isMay <em>May</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.ClassImpl#isSet <em>Set</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.ClassImpl#isVar <em>Var</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.ClassImpl#getOwnedAttributes <em>Owned Attributes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.ClassImpl#getOwnedOperations <em>Owned Operations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.ClassImpl#getDependenciesAsDependee <em>Dependencies As Dependee</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.mavo.classdiagram.impl.ClassImpl#getDependenciesAsDepender <em>Dependencies As Depender</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends NamedElementImpl implements edu.toronto.cs.se.modelepedia.mavo.classdiagram.Class {
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
	 * The cached value of the '{@link #getOwnedAttributes() <em>Owned Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> ownedAttributes;

	/**
	 * The cached value of the '{@link #getOwnedOperations() <em>Owned Operations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperations()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> ownedOperations;

	/**
	 * The cached value of the '{@link #getDependenciesAsDependee() <em>Dependencies As Dependee</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependenciesAsDependee()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependenciesAsDependee;

	/**
	 * The cached value of the '{@link #getDependenciesAsDepender() <em>Dependencies As Depender</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependenciesAsDepender()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependenciesAsDepender;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramPackage.Literals.CLASS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASS__MAY, oldMay, may));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASS__SET, oldSet, set));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramPackage.CLASS__VAR, oldVar, var));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getOwnedAttributes() {
		if (ownedAttributes == null) {
			ownedAttributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, ClassdiagramPackage.CLASS__OWNED_ATTRIBUTES);
		}
		return ownedAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOwnedOperations() {
		if (ownedOperations == null) {
			ownedOperations = new EObjectContainmentEList<Operation>(Operation.class, this, ClassdiagramPackage.CLASS__OWNED_OPERATIONS);
		}
		return ownedOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependenciesAsDependee() {
		if (dependenciesAsDependee == null) {
			dependenciesAsDependee = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE, ClassdiagramPackage.DEPENDENCY__DEPENDEE);
		}
		return dependenciesAsDependee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependenciesAsDepender() {
		if (dependenciesAsDepender == null) {
			dependenciesAsDepender = new EObjectWithInverseResolvingEList<Dependency>(Dependency.class, this, ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER, ClassdiagramPackage.DEPENDENCY__DEPENDER);
		}
		return dependenciesAsDepender;
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
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDependee()).basicAdd(otherEnd, msgs);
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDependenciesAsDepender()).basicAdd(otherEnd, msgs);
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
			case ClassdiagramPackage.CLASS__OWNED_ATTRIBUTES:
				return ((InternalEList<?>)getOwnedAttributes()).basicRemove(otherEnd, msgs);
			case ClassdiagramPackage.CLASS__OWNED_OPERATIONS:
				return ((InternalEList<?>)getOwnedOperations()).basicRemove(otherEnd, msgs);
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return ((InternalEList<?>)getDependenciesAsDependee()).basicRemove(otherEnd, msgs);
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return ((InternalEList<?>)getDependenciesAsDepender()).basicRemove(otherEnd, msgs);
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
			case ClassdiagramPackage.CLASS__MAY:
				return isMay();
			case ClassdiagramPackage.CLASS__SET:
				return isSet();
			case ClassdiagramPackage.CLASS__VAR:
				return isVar();
			case ClassdiagramPackage.CLASS__OWNED_ATTRIBUTES:
				return getOwnedAttributes();
			case ClassdiagramPackage.CLASS__OWNED_OPERATIONS:
				return getOwnedOperations();
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return getDependenciesAsDependee();
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return getDependenciesAsDepender();
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
			case ClassdiagramPackage.CLASS__MAY:
				setMay((Boolean)newValue);
				return;
			case ClassdiagramPackage.CLASS__SET:
				setSet((Boolean)newValue);
				return;
			case ClassdiagramPackage.CLASS__VAR:
				setVar((Boolean)newValue);
				return;
			case ClassdiagramPackage.CLASS__OWNED_ATTRIBUTES:
				getOwnedAttributes().clear();
				getOwnedAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ClassdiagramPackage.CLASS__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				getOwnedOperations().addAll((Collection<? extends Operation>)newValue);
				return;
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				getDependenciesAsDependee().clear();
				getDependenciesAsDependee().addAll((Collection<? extends Dependency>)newValue);
				return;
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				getDependenciesAsDepender().clear();
				getDependenciesAsDepender().addAll((Collection<? extends Dependency>)newValue);
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
			case ClassdiagramPackage.CLASS__MAY:
				setMay(MAY_EDEFAULT);
				return;
			case ClassdiagramPackage.CLASS__SET:
				setSet(SET_EDEFAULT);
				return;
			case ClassdiagramPackage.CLASS__VAR:
				setVar(VAR_EDEFAULT);
				return;
			case ClassdiagramPackage.CLASS__OWNED_ATTRIBUTES:
				getOwnedAttributes().clear();
				return;
			case ClassdiagramPackage.CLASS__OWNED_OPERATIONS:
				getOwnedOperations().clear();
				return;
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				getDependenciesAsDependee().clear();
				return;
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				getDependenciesAsDepender().clear();
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
			case ClassdiagramPackage.CLASS__MAY:
				return may != MAY_EDEFAULT;
			case ClassdiagramPackage.CLASS__SET:
				return set != SET_EDEFAULT;
			case ClassdiagramPackage.CLASS__VAR:
				return var != VAR_EDEFAULT;
			case ClassdiagramPackage.CLASS__OWNED_ATTRIBUTES:
				return ownedAttributes != null && !ownedAttributes.isEmpty();
			case ClassdiagramPackage.CLASS__OWNED_OPERATIONS:
				return ownedOperations != null && !ownedOperations.isEmpty();
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDEE:
				return dependenciesAsDependee != null && !dependenciesAsDependee.isEmpty();
			case ClassdiagramPackage.CLASS__DEPENDENCIES_AS_DEPENDER:
				return dependenciesAsDepender != null && !dependenciesAsDepender.isEmpty();
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
		if (baseClass == MAVOElement.class) {
			switch (derivedFeatureID) {
				case ClassdiagramPackage.CLASS__MAY: return MavoPackage.MAVO_ELEMENT__MAY;
				case ClassdiagramPackage.CLASS__SET: return MavoPackage.MAVO_ELEMENT__SET;
				case ClassdiagramPackage.CLASS__VAR: return MavoPackage.MAVO_ELEMENT__VAR;
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
		if (baseClass == MAVOElement.class) {
			switch (baseFeatureID) {
				case MavoPackage.MAVO_ELEMENT__MAY: return ClassdiagramPackage.CLASS__MAY;
				case MavoPackage.MAVO_ELEMENT__SET: return ClassdiagramPackage.CLASS__SET;
				case MavoPackage.MAVO_ELEMENT__VAR: return ClassdiagramPackage.CLASS__VAR;
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
		result.append(" (may: ");
		result.append(may);
		result.append(", set: ");
		result.append(set);
		result.append(", var: ");
		result.append(var);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
