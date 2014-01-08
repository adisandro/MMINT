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

import edu.toronto.cs.se.modelepedia.randommodel.Edge;
import edu.toronto.cs.se.modelepedia.randommodel.Node;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;

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
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NodeImpl#getEdgesAsSrc <em>Edges As Src</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.randommodel.impl.NodeImpl#getEdgesAsTgt <em>Edges As Tgt</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends NamedElementImpl implements Node {
	/**
	 * The cached value of the '{@link #getEdgesAsSrc() <em>Edges As Src</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgesAsSrc()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edgesAsSrc;
	/**
	 * The cached value of the '{@link #getEdgesAsTgt() <em>Edges As Tgt</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgesAsTgt()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edgesAsTgt;

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
		return RandomModelPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdgesAsSrc() {
		if (edgesAsSrc == null) {
			edgesAsSrc = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, RandomModelPackage.NODE__EDGES_AS_SRC, RandomModelPackage.EDGE__SRC);
		}
		return edgesAsSrc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdgesAsTgt() {
		if (edgesAsTgt == null) {
			edgesAsTgt = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, RandomModelPackage.NODE__EDGES_AS_TGT, RandomModelPackage.EDGE__TGT);
		}
		return edgesAsTgt;
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
			case RandomModelPackage.NODE__EDGES_AS_SRC:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdgesAsSrc()).basicAdd(otherEnd, msgs);
			case RandomModelPackage.NODE__EDGES_AS_TGT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdgesAsTgt()).basicAdd(otherEnd, msgs);
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
			case RandomModelPackage.NODE__EDGES_AS_SRC:
				return ((InternalEList<?>)getEdgesAsSrc()).basicRemove(otherEnd, msgs);
			case RandomModelPackage.NODE__EDGES_AS_TGT:
				return ((InternalEList<?>)getEdgesAsTgt()).basicRemove(otherEnd, msgs);
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
			case RandomModelPackage.NODE__EDGES_AS_SRC:
				return getEdgesAsSrc();
			case RandomModelPackage.NODE__EDGES_AS_TGT:
				return getEdgesAsTgt();
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
			case RandomModelPackage.NODE__EDGES_AS_SRC:
				getEdgesAsSrc().clear();
				getEdgesAsSrc().addAll((Collection<? extends Edge>)newValue);
				return;
			case RandomModelPackage.NODE__EDGES_AS_TGT:
				getEdgesAsTgt().clear();
				getEdgesAsTgt().addAll((Collection<? extends Edge>)newValue);
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
			case RandomModelPackage.NODE__EDGES_AS_SRC:
				getEdgesAsSrc().clear();
				return;
			case RandomModelPackage.NODE__EDGES_AS_TGT:
				getEdgesAsTgt().clear();
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
			case RandomModelPackage.NODE__EDGES_AS_SRC:
				return edgesAsSrc != null && !edgesAsSrc.isEmpty();
			case RandomModelPackage.NODE__EDGES_AS_TGT:
				return edgesAsTgt != null && !edgesAsTgt.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeImpl
