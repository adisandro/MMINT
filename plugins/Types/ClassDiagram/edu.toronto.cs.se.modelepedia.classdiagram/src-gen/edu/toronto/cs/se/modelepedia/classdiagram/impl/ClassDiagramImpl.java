/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram.impl;

import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.classdiagram.Composition;
import edu.toronto.cs.se.modelepedia.classdiagram.DataType;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl#getDatatypes <em>Datatypes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassDiagramImpl#getCompositions <em>Compositions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDiagramImpl extends EObjectImpl implements ClassDiagram {
	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<edu.toronto.cs.se.modelepedia.classdiagram.Class> classes;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<Dependency> dependencies;

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
	 * The cached value of the '{@link #getDatatypes() <em>Datatypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatatypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> datatypes;

	/**
	 * The cached value of the '{@link #getCompositions() <em>Compositions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompositions()
	 * @generated
	 * @ordered
	 */
	protected EList<Composition> compositions;

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
		return ClassDiagramPackage.Literals.CLASS_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<edu.toronto.cs.se.modelepedia.classdiagram.Class> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<edu.toronto.cs.se.modelepedia.classdiagram.Class>(edu.toronto.cs.se.modelepedia.classdiagram.Class.class, this, ClassDiagramPackage.CLASS_DIAGRAM__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Dependency> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<Dependency>(Dependency.class, this, ClassDiagramPackage.CLASS_DIAGRAM__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getAssociations() {
		if (associations == null) {
			associations = new EObjectContainmentEList<Association>(Association.class, this, ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getDatatypes() {
		if (datatypes == null) {
			datatypes = new EObjectContainmentEList<DataType>(DataType.class, this, ClassDiagramPackage.CLASS_DIAGRAM__DATATYPES);
		}
		return datatypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Composition> getCompositions() {
		if (compositions == null) {
			compositions = new EObjectContainmentEList<Composition>(Composition.class, this, ClassDiagramPackage.CLASS_DIAGRAM__COMPOSITIONS);
		}
		return compositions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
			case ClassDiagramPackage.CLASS_DIAGRAM__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
			case ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				return ((InternalEList<?>)getAssociations()).basicRemove(otherEnd, msgs);
			case ClassDiagramPackage.CLASS_DIAGRAM__DATATYPES:
				return ((InternalEList<?>)getDatatypes()).basicRemove(otherEnd, msgs);
			case ClassDiagramPackage.CLASS_DIAGRAM__COMPOSITIONS:
				return ((InternalEList<?>)getCompositions()).basicRemove(otherEnd, msgs);
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
			case ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				return getClasses();
			case ClassDiagramPackage.CLASS_DIAGRAM__DEPENDENCIES:
				return getDependencies();
			case ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				return getAssociations();
			case ClassDiagramPackage.CLASS_DIAGRAM__DATATYPES:
				return getDatatypes();
			case ClassDiagramPackage.CLASS_DIAGRAM__COMPOSITIONS:
				return getCompositions();
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
			case ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends edu.toronto.cs.se.modelepedia.classdiagram.Class>)newValue);
				return;
			case ClassDiagramPackage.CLASS_DIAGRAM__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends Dependency>)newValue);
				return;
			case ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				getAssociations().clear();
				getAssociations().addAll((Collection<? extends Association>)newValue);
				return;
			case ClassDiagramPackage.CLASS_DIAGRAM__DATATYPES:
				getDatatypes().clear();
				getDatatypes().addAll((Collection<? extends DataType>)newValue);
				return;
			case ClassDiagramPackage.CLASS_DIAGRAM__COMPOSITIONS:
				getCompositions().clear();
				getCompositions().addAll((Collection<? extends Composition>)newValue);
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
			case ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				getClasses().clear();
				return;
			case ClassDiagramPackage.CLASS_DIAGRAM__DEPENDENCIES:
				getDependencies().clear();
				return;
			case ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				getAssociations().clear();
				return;
			case ClassDiagramPackage.CLASS_DIAGRAM__DATATYPES:
				getDatatypes().clear();
				return;
			case ClassDiagramPackage.CLASS_DIAGRAM__COMPOSITIONS:
				getCompositions().clear();
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
			case ClassDiagramPackage.CLASS_DIAGRAM__CLASSES:
				return classes != null && !classes.isEmpty();
			case ClassDiagramPackage.CLASS_DIAGRAM__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
			case ClassDiagramPackage.CLASS_DIAGRAM__ASSOCIATIONS:
				return associations != null && !associations.isEmpty();
			case ClassDiagramPackage.CLASS_DIAGRAM__DATATYPES:
				return datatypes != null && !datatypes.isEmpty();
			case ClassDiagramPackage.CLASS_DIAGRAM__COMPOSITIONS:
				return compositions != null && !compositions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassDiagramImpl
