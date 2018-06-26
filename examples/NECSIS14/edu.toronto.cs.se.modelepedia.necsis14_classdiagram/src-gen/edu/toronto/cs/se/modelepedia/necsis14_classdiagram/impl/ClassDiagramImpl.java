/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.necsis14_classdiagram.impl;

import edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Association;
import edu.toronto.cs.se.modelepedia.necsis14_classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.necsis14_classdiagram.NECSIS14_ClassDiagramPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.necsis14_classdiagram.impl.ClassDiagramImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.necsis14_classdiagram.impl.ClassDiagramImpl#getAssociations <em>Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassDiagramImpl extends MinimalEObjectImpl.Container implements ClassDiagram {
	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class> classes;

	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> associations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NECSIS14_ClassDiagramPackage.Literals.CLASS_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class>(edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class.class, this, NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList<Association>(Association.class, this, NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
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
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				return getClasses();
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				return getAssociations();
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
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends edu.toronto.cs.se.modelepedia.necsis14_classdiagram.Class>)newValue);
				return;
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends Association>)newValue);
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
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				getClasses().clear();
				return;
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				getAssociations().clear();
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
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				return classes != null && !classes.isEmpty();
			case NECSIS14_ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassDiagramImpl
