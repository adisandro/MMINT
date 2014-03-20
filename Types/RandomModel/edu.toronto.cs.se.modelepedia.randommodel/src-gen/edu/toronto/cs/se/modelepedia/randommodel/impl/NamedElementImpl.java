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
package edu.toronto.cs.se.modelepedia.randommodel.impl;

import edu.toronto.cs.se.mmint.mavo.impl.MAVOElementImpl;
import edu.toronto.cs.se.modelepedia.randommodel.NamedElement;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Named Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NamedElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NamedElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NamedElementImpl#getMinimumNumberOfInstances <em>Minimum Number Of Instances</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NamedElementImpl#getMaximumNumberOfInstances <em>Maximum Number Of Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamedElementImpl extends MAVOElementImpl implements NamedElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinimumNumberOfInstances() <em>Minimum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumNumberOfInstances()
	 * @generated
	 * @ordered
	 */
	protected static final int MINIMUM_NUMBER_OF_INSTANCES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinimumNumberOfInstances() <em>Minimum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumNumberOfInstances()
	 * @generated
	 * @ordered
	 */
	protected int minimumNumberOfInstances = MINIMUM_NUMBER_OF_INSTANCES_EDEFAULT;

	/**
	 * This is true if the Minimum Number Of Instances attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean minimumNumberOfInstancesESet;

	/**
	 * The default value of the '{@link #getMaximumNumberOfInstances() <em>Maximum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfInstances()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMUM_NUMBER_OF_INSTANCES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaximumNumberOfInstances() <em>Maximum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumNumberOfInstances()
	 * @generated
	 * @ordered
	 */
	protected int maximumNumberOfInstances = MAXIMUM_NUMBER_OF_INSTANCES_EDEFAULT;

	/**
	 * This is true if the Maximum Number Of Instances attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maximumNumberOfInstancesESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RandomModelPackage.Literals.NAMED_ELEMENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelPackage.NAMED_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelPackage.NAMED_ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinimumNumberOfInstances() {
		return minimumNumberOfInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumNumberOfInstances(int newMinimumNumberOfInstances) {
		int oldMinimumNumberOfInstances = minimumNumberOfInstances;
		minimumNumberOfInstances = newMinimumNumberOfInstances;
		boolean oldMinimumNumberOfInstancesESet = minimumNumberOfInstancesESet;
		minimumNumberOfInstancesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelPackage.NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES, oldMinimumNumberOfInstances, minimumNumberOfInstances, !oldMinimumNumberOfInstancesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMinimumNumberOfInstances() {
		int oldMinimumNumberOfInstances = minimumNumberOfInstances;
		boolean oldMinimumNumberOfInstancesESet = minimumNumberOfInstancesESet;
		minimumNumberOfInstances = MINIMUM_NUMBER_OF_INSTANCES_EDEFAULT;
		minimumNumberOfInstancesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RandomModelPackage.NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES, oldMinimumNumberOfInstances, MINIMUM_NUMBER_OF_INSTANCES_EDEFAULT, oldMinimumNumberOfInstancesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMinimumNumberOfInstances() {
		return minimumNumberOfInstancesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaximumNumberOfInstances() {
		return maximumNumberOfInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumNumberOfInstances(int newMaximumNumberOfInstances) {
		int oldMaximumNumberOfInstances = maximumNumberOfInstances;
		maximumNumberOfInstances = newMaximumNumberOfInstances;
		boolean oldMaximumNumberOfInstancesESet = maximumNumberOfInstancesESet;
		maximumNumberOfInstancesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelPackage.NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES, oldMaximumNumberOfInstances, maximumNumberOfInstances, !oldMaximumNumberOfInstancesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumNumberOfInstances() {
		int oldMaximumNumberOfInstances = maximumNumberOfInstances;
		boolean oldMaximumNumberOfInstancesESet = maximumNumberOfInstancesESet;
		maximumNumberOfInstances = MAXIMUM_NUMBER_OF_INSTANCES_EDEFAULT;
		maximumNumberOfInstancesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, RandomModelPackage.NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES, oldMaximumNumberOfInstances, MAXIMUM_NUMBER_OF_INSTANCES_EDEFAULT, oldMaximumNumberOfInstancesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumNumberOfInstances() {
		return maximumNumberOfInstancesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RandomModelPackage.NAMED_ELEMENT__NAME:
				return getName();
			case RandomModelPackage.NAMED_ELEMENT__TYPE:
				return getType();
			case RandomModelPackage.NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES:
				return getMinimumNumberOfInstances();
			case RandomModelPackage.NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES:
				return getMaximumNumberOfInstances();
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
			case RandomModelPackage.NAMED_ELEMENT__NAME:
				setName((String)newValue);
				return;
			case RandomModelPackage.NAMED_ELEMENT__TYPE:
				setType((String)newValue);
				return;
			case RandomModelPackage.NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES:
				setMinimumNumberOfInstances((Integer)newValue);
				return;
			case RandomModelPackage.NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES:
				setMaximumNumberOfInstances((Integer)newValue);
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
			case RandomModelPackage.NAMED_ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RandomModelPackage.NAMED_ELEMENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case RandomModelPackage.NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES:
				unsetMinimumNumberOfInstances();
				return;
			case RandomModelPackage.NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES:
				unsetMaximumNumberOfInstances();
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
			case RandomModelPackage.NAMED_ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RandomModelPackage.NAMED_ELEMENT__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case RandomModelPackage.NAMED_ELEMENT__MINIMUM_NUMBER_OF_INSTANCES:
				return isSetMinimumNumberOfInstances();
			case RandomModelPackage.NAMED_ELEMENT__MAXIMUM_NUMBER_OF_INSTANCES:
				return isSetMaximumNumberOfInstances();
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
		result.append(", type: ");
		result.append(type);
		result.append(", minimumNumberOfInstances: ");
		if (minimumNumberOfInstancesESet) result.append(minimumNumberOfInstances); else result.append("<unset>");
		result.append(", maximumNumberOfInstances: ");
		if (maximumNumberOfInstancesESet) result.append(maximumNumberOfInstances); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //NamedElementImpl
