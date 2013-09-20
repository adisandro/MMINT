/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmtf.mavo.impl.MAVOModelImpl;
import edu.toronto.cs.se.modelepedia.randommodel.Edge;
import edu.toronto.cs.se.modelepedia.randommodel.Node;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModel;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;

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
 * An implementation of the model object '<em><b>Random Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl#getDefaultMinimumNumberOfInstances <em>Default Minimum Number Of Instances</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.RandomModelImpl#getDefaultMaximumNumberOfInstances <em>Default Maximum Number Of Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RandomModelImpl extends MAVOModelImpl implements RandomModel {
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edges;

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
	 * The default value of the '{@link #getDefaultMinimumNumberOfInstances() <em>Default Minimum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultMinimumNumberOfInstances()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_MINIMUM_NUMBER_OF_INSTANCES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultMinimumNumberOfInstances() <em>Default Minimum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultMinimumNumberOfInstances()
	 * @generated
	 * @ordered
	 */
	protected int defaultMinimumNumberOfInstances = DEFAULT_MINIMUM_NUMBER_OF_INSTANCES_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultMaximumNumberOfInstances() <em>Default Maximum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultMaximumNumberOfInstances()
	 * @generated
	 * @ordered
	 */
	protected static final int DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDefaultMaximumNumberOfInstances() <em>Default Maximum Number Of Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultMaximumNumberOfInstances()
	 * @generated
	 * @ordered
	 */
	protected int defaultMaximumNumberOfInstances = DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RandomModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RandomModelPackage.Literals.RANDOM_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<Node>(Node.class, this, RandomModelPackage.RANDOM_MODEL__NODES);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdges() {
		if (edges == null) {
			edges = new EObjectContainmentEList<Edge>(Edge.class, this, RandomModelPackage.RANDOM_MODEL__EDGES);
		}
		return edges;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelPackage.RANDOM_MODEL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelPackage.RANDOM_MODEL__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultMinimumNumberOfInstances() {
		return defaultMinimumNumberOfInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultMinimumNumberOfInstances(int newDefaultMinimumNumberOfInstances) {
		int oldDefaultMinimumNumberOfInstances = defaultMinimumNumberOfInstances;
		defaultMinimumNumberOfInstances = newDefaultMinimumNumberOfInstances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelPackage.RANDOM_MODEL__DEFAULT_MINIMUM_NUMBER_OF_INSTANCES, oldDefaultMinimumNumberOfInstances, defaultMinimumNumberOfInstances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDefaultMaximumNumberOfInstances() {
		return defaultMaximumNumberOfInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultMaximumNumberOfInstances(int newDefaultMaximumNumberOfInstances) {
		int oldDefaultMaximumNumberOfInstances = defaultMaximumNumberOfInstances;
		defaultMaximumNumberOfInstances = newDefaultMaximumNumberOfInstances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RandomModelPackage.RANDOM_MODEL__DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES, oldDefaultMaximumNumberOfInstances, defaultMaximumNumberOfInstances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RandomModelPackage.RANDOM_MODEL__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case RandomModelPackage.RANDOM_MODEL__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
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
			case RandomModelPackage.RANDOM_MODEL__NODES:
				return getNodes();
			case RandomModelPackage.RANDOM_MODEL__EDGES:
				return getEdges();
			case RandomModelPackage.RANDOM_MODEL__NAME:
				return getName();
			case RandomModelPackage.RANDOM_MODEL__TYPE:
				return getType();
			case RandomModelPackage.RANDOM_MODEL__DEFAULT_MINIMUM_NUMBER_OF_INSTANCES:
				return getDefaultMinimumNumberOfInstances();
			case RandomModelPackage.RANDOM_MODEL__DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES:
				return getDefaultMaximumNumberOfInstances();
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
			case RandomModelPackage.RANDOM_MODEL__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case RandomModelPackage.RANDOM_MODEL__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case RandomModelPackage.RANDOM_MODEL__NAME:
				setName((String)newValue);
				return;
			case RandomModelPackage.RANDOM_MODEL__TYPE:
				setType((String)newValue);
				return;
			case RandomModelPackage.RANDOM_MODEL__DEFAULT_MINIMUM_NUMBER_OF_INSTANCES:
				setDefaultMinimumNumberOfInstances((Integer)newValue);
				return;
			case RandomModelPackage.RANDOM_MODEL__DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES:
				setDefaultMaximumNumberOfInstances((Integer)newValue);
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
			case RandomModelPackage.RANDOM_MODEL__NODES:
				getNodes().clear();
				return;
			case RandomModelPackage.RANDOM_MODEL__EDGES:
				getEdges().clear();
				return;
			case RandomModelPackage.RANDOM_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case RandomModelPackage.RANDOM_MODEL__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case RandomModelPackage.RANDOM_MODEL__DEFAULT_MINIMUM_NUMBER_OF_INSTANCES:
				setDefaultMinimumNumberOfInstances(DEFAULT_MINIMUM_NUMBER_OF_INSTANCES_EDEFAULT);
				return;
			case RandomModelPackage.RANDOM_MODEL__DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES:
				setDefaultMaximumNumberOfInstances(DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES_EDEFAULT);
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
			case RandomModelPackage.RANDOM_MODEL__NODES:
				return nodes != null && !nodes.isEmpty();
			case RandomModelPackage.RANDOM_MODEL__EDGES:
				return edges != null && !edges.isEmpty();
			case RandomModelPackage.RANDOM_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case RandomModelPackage.RANDOM_MODEL__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case RandomModelPackage.RANDOM_MODEL__DEFAULT_MINIMUM_NUMBER_OF_INSTANCES:
				return defaultMinimumNumberOfInstances != DEFAULT_MINIMUM_NUMBER_OF_INSTANCES_EDEFAULT;
			case RandomModelPackage.RANDOM_MODEL__DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES:
				return defaultMaximumNumberOfInstances != DEFAULT_MAXIMUM_NUMBER_OF_INSTANCES_EDEFAULT;
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
		result.append(", defaultMinimumNumberOfInstances: ");
		result.append(defaultMinimumNumberOfInstances);
		result.append(", defaultMaximumNumberOfInstances: ");
		result.append(defaultMaximumNumberOfInstances);
		result.append(')');
		return result.toString();
	}

} //RandomModelImpl
