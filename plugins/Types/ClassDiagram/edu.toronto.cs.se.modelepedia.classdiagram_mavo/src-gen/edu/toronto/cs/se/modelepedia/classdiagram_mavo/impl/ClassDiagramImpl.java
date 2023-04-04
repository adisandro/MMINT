/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mavo.impl.MAVORootImpl;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Association;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.Dependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagramImpl#getClasses <em>Classes</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagramImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.ClassDiagramImpl#getAssociations <em>Associations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDiagramImpl extends MAVORootImpl implements ClassDiagram {
	/**
   * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getClasses()
   * @generated
   * @ordered
   */
	protected EList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class> classes;

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
    return ClassDiagram_MAVOPackage.Literals.CLASS_DIAGRAM;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class> getClasses() {
    if (this.classes == null) {
      this.classes = new EObjectContainmentEList<>(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class.class, this, ClassDiagram_MAVOPackage.CLASS_DIAGRAM__CLASSES);
    }
    return this.classes;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Dependency> getDependencies() {
    if (this.dependencies == null) {
      this.dependencies = new EObjectContainmentEList<>(Dependency.class, this, ClassDiagram_MAVOPackage.CLASS_DIAGRAM__DEPENDENCIES);
    }
    return this.dependencies;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public EList<Association> getAssociations() {
    if (this.associations == null) {
      this.associations = new EObjectContainmentEList<>(Association.class, this, ClassDiagram_MAVOPackage.CLASS_DIAGRAM__ASSOCIATIONS);
    }
    return this.associations;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__CLASSES:
        return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__DEPENDENCIES:
        return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__ASSOCIATIONS:
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
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__CLASSES:
        return getClasses();
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__DEPENDENCIES:
        return getDependencies();
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__ASSOCIATIONS:
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
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__CLASSES:
        getClasses().clear();
        getClasses().addAll((Collection<? extends edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class>)newValue);
        return;
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__DEPENDENCIES:
        getDependencies().clear();
        getDependencies().addAll((Collection<? extends Dependency>)newValue);
        return;
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__ASSOCIATIONS:
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
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__CLASSES:
        getClasses().clear();
        return;
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__DEPENDENCIES:
        getDependencies().clear();
        return;
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__ASSOCIATIONS:
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
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__CLASSES:
        return this.classes != null && !this.classes.isEmpty();
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__DEPENDENCIES:
        return this.dependencies != null && !this.dependencies.isEmpty();
      case ClassDiagram_MAVOPackage.CLASS_DIAGRAM__ASSOCIATIONS:
        return this.associations != null && !this.associations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ClassDiagramImpl
