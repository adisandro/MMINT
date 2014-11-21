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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl;

import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ICSE15_SequenceDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ObjectReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ObjectImpl#getLifelines <em>Lifelines</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectImpl extends NamedElementImpl implements edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Object {
	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassReference> class_;

	/**
	 * The cached value of the '{@link #getLifelines() <em>Lifelines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifelines()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectReference> lifelines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ICSE15_SequenceDiagram_MAVOPackage.Literals.OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassReference> getClass_() {
		if (class_ == null) {
			class_ = new EObjectContainmentWithInverseEList<ClassReference>(ClassReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.OBJECT__CLASS, ICSE15_SequenceDiagram_MAVOPackage.CLASS_REFERENCE__SOURCE);
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectReference> getLifelines() {
		if (lifelines == null) {
			lifelines = new EObjectWithInverseResolvingEList<ObjectReference>(ObjectReference.class, this, ICSE15_SequenceDiagram_MAVOPackage.OBJECT__LIFELINES, ICSE15_SequenceDiagram_MAVOPackage.OBJECT_REFERENCE__TARGET);
		}
		return lifelines;
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
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__CLASS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClass_()).basicAdd(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__LIFELINES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLifelines()).basicAdd(otherEnd, msgs);
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
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__CLASS:
				return ((InternalEList<?>)getClass_()).basicRemove(otherEnd, msgs);
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__LIFELINES:
				return ((InternalEList<?>)getLifelines()).basicRemove(otherEnd, msgs);
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
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__CLASS:
				return getClass_();
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__LIFELINES:
				return getLifelines();
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
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__CLASS:
				getClass_().clear();
				getClass_().addAll((Collection<? extends ClassReference>)newValue);
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__LIFELINES:
				getLifelines().clear();
				getLifelines().addAll((Collection<? extends ObjectReference>)newValue);
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
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__CLASS:
				getClass_().clear();
				return;
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__LIFELINES:
				getLifelines().clear();
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
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__CLASS:
				return class_ != null && !class_.isEmpty();
			case ICSE15_SequenceDiagram_MAVOPackage.OBJECT__LIFELINES:
				return lifelines != null && !lifelines.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ObjectImpl
