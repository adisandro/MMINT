/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.graph_mavo.impl;

import edu.toronto.cs.se.modelepedia.graph_mavo.Edge;
import edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage;
import edu.toronto.cs.se.modelepedia.graph_mavo.Node;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.graph_mavo.impl.NodeImpl#getEdgesAsSource <em>Edges As Source</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.graph_mavo.impl.NodeImpl#getEdgesAsTarget <em>Edges As Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends NamedElementImpl implements Node {
	/**
	 * The cached value of the '{@link #getEdgesAsSource() <em>Edges As Source</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgesAsSource()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edgesAsSource;

	/**
	 * The cached value of the '{@link #getEdgesAsTarget() <em>Edges As Target</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgesAsTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edgesAsTarget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Graph_MAVOPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdgesAsSource() {
		if (edgesAsSource == null) {
			edgesAsSource = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, Graph_MAVOPackage.NODE__EDGES_AS_SOURCE, Graph_MAVOPackage.EDGE__SOURCE);
		}
		return edgesAsSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdgesAsTarget() {
		if (edgesAsTarget == null) {
			edgesAsTarget = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, Graph_MAVOPackage.NODE__EDGES_AS_TARGET, Graph_MAVOPackage.EDGE__TARGET);
		}
		return edgesAsTarget;
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
			case Graph_MAVOPackage.NODE__EDGES_AS_SOURCE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdgesAsSource()).basicAdd(otherEnd, msgs);
			case Graph_MAVOPackage.NODE__EDGES_AS_TARGET:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdgesAsTarget()).basicAdd(otherEnd, msgs);
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
			case Graph_MAVOPackage.NODE__EDGES_AS_SOURCE:
				return ((InternalEList<?>)getEdgesAsSource()).basicRemove(otherEnd, msgs);
			case Graph_MAVOPackage.NODE__EDGES_AS_TARGET:
				return ((InternalEList<?>)getEdgesAsTarget()).basicRemove(otherEnd, msgs);
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
			case Graph_MAVOPackage.NODE__EDGES_AS_SOURCE:
				return getEdgesAsSource();
			case Graph_MAVOPackage.NODE__EDGES_AS_TARGET:
				return getEdgesAsTarget();
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
			case Graph_MAVOPackage.NODE__EDGES_AS_SOURCE:
				getEdgesAsSource().clear();
				getEdgesAsSource().addAll((Collection<? extends Edge>)newValue);
				return;
			case Graph_MAVOPackage.NODE__EDGES_AS_TARGET:
				getEdgesAsTarget().clear();
				getEdgesAsTarget().addAll((Collection<? extends Edge>)newValue);
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
			case Graph_MAVOPackage.NODE__EDGES_AS_SOURCE:
				getEdgesAsSource().clear();
				return;
			case Graph_MAVOPackage.NODE__EDGES_AS_TARGET:
				getEdgesAsTarget().clear();
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
			case Graph_MAVOPackage.NODE__EDGES_AS_SOURCE:
				return edgesAsSource != null && !edgesAsSource.isEmpty();
			case Graph_MAVOPackage.NODE__EDGES_AS_TARGET:
				return edgesAsTarget != null && !edgesAsTarget.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeImpl
