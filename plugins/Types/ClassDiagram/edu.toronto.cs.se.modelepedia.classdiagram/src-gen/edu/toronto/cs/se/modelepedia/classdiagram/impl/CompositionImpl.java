/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.classdiagram.Composition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.CompositionImpl#getConstituent <em>Constituent</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.CompositionImpl#getComposite <em>Composite</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram.impl.CompositionImpl#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositionImpl extends NamedElementImpl implements Composition {
	/**
   * The cached value of the '{@link #getConstituent() <em>Constituent</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getConstituent()
   * @generated
   * @ordered
   */
	protected edu.toronto.cs.se.modelepedia.classdiagram.Class constituent;

	/**
   * The cached value of the '{@link #getComposite() <em>Composite</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getComposite()
   * @generated
   * @ordered
   */
	protected edu.toronto.cs.se.modelepedia.classdiagram.Class composite;

	/**
   * The default value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
	protected static final String MULTIPLICITY_EDEFAULT = "";

	/**
   * The cached value of the '{@link #getMultiplicity() <em>Multiplicity</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMultiplicity()
   * @generated
   * @ordered
   */
	protected String multiplicity = CompositionImpl.MULTIPLICITY_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected CompositionImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ClassDiagramPackage.Literals.COMPOSITION;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public edu.toronto.cs.se.modelepedia.classdiagram.Class getConstituent() {
    if (this.constituent != null && this.constituent.eIsProxy()) {
      var oldConstituent = (InternalEObject)this.constituent;
      this.constituent = (edu.toronto.cs.se.modelepedia.classdiagram.Class)eResolveProxy(oldConstituent);
      if (this.constituent != oldConstituent) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagramPackage.COMPOSITION__CONSTITUENT, oldConstituent, this.constituent));
      }
    }
    return this.constituent;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public edu.toronto.cs.se.modelepedia.classdiagram.Class basicGetConstituent() {
    return this.constituent;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetConstituent(edu.toronto.cs.se.modelepedia.classdiagram.Class newConstituent, NotificationChain msgs) {
    var oldConstituent = this.constituent;
    this.constituent = newConstituent;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.COMPOSITION__CONSTITUENT, oldConstituent, newConstituent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public void setConstituent(edu.toronto.cs.se.modelepedia.classdiagram.Class newConstituent) {
    if (newConstituent != this.constituent) {
      NotificationChain msgs = null;
      if (this.constituent != null)
        msgs = ((InternalEObject)this.constituent).eInverseRemove(this, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
      if (newConstituent != null)
        msgs = ((InternalEObject)newConstituent).eInverseAdd(this, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
      msgs = basicSetConstituent(newConstituent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.COMPOSITION__CONSTITUENT, newConstituent, newConstituent));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public edu.toronto.cs.se.modelepedia.classdiagram.Class getComposite() {
    if (this.composite != null && this.composite.eIsProxy()) {
      var oldComposite = (InternalEObject)this.composite;
      this.composite = (edu.toronto.cs.se.modelepedia.classdiagram.Class)eResolveProxy(oldComposite);
      if (this.composite != oldComposite) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagramPackage.COMPOSITION__COMPOSITE, oldComposite, this.composite));
      }
    }
    return this.composite;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public edu.toronto.cs.se.modelepedia.classdiagram.Class basicGetComposite() {
    return this.composite;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public NotificationChain basicSetComposite(edu.toronto.cs.se.modelepedia.classdiagram.Class newComposite, NotificationChain msgs) {
    var oldComposite = this.composite;
    this.composite = newComposite;
    if (eNotificationRequired()) {
      var notification = new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.COMPOSITION__COMPOSITE, oldComposite, newComposite);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public void setComposite(edu.toronto.cs.se.modelepedia.classdiagram.Class newComposite) {
    if (newComposite != this.composite) {
      NotificationChain msgs = null;
      if (this.composite != null)
        msgs = ((InternalEObject)this.composite).eInverseRemove(this, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
      if (newComposite != null)
        msgs = ((InternalEObject)newComposite).eInverseAdd(this, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
      msgs = basicSetComposite(newComposite, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.COMPOSITION__COMPOSITE, newComposite, newComposite));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public String getMultiplicity() {
    return this.multiplicity;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public void setMultiplicity(String newMultiplicity) {
    var oldMultiplicity = this.multiplicity;
    this.multiplicity = newMultiplicity;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagramPackage.COMPOSITION__MULTIPLICITY, oldMultiplicity, this.multiplicity));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ClassDiagramPackage.COMPOSITION__CONSTITUENT:
        if (this.constituent != null)
          msgs = ((InternalEObject)this.constituent).eInverseRemove(this, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_CONSTITUENT, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
        return basicSetConstituent((edu.toronto.cs.se.modelepedia.classdiagram.Class)otherEnd, msgs);
      case ClassDiagramPackage.COMPOSITION__COMPOSITE:
        if (this.composite != null)
          msgs = ((InternalEObject)this.composite).eInverseRemove(this, ClassDiagramPackage.CLASS__COMPOSITIONS_AS_COMPOSITE, edu.toronto.cs.se.modelepedia.classdiagram.Class.class, msgs);
        return basicSetComposite((edu.toronto.cs.se.modelepedia.classdiagram.Class)otherEnd, msgs);
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
      case ClassDiagramPackage.COMPOSITION__CONSTITUENT:
        return basicSetConstituent(null, msgs);
      case ClassDiagramPackage.COMPOSITION__COMPOSITE:
        return basicSetComposite(null, msgs);
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
      case ClassDiagramPackage.COMPOSITION__CONSTITUENT:
        if (resolve) return getConstituent();
        return basicGetConstituent();
      case ClassDiagramPackage.COMPOSITION__COMPOSITE:
        if (resolve) return getComposite();
        return basicGetComposite();
      case ClassDiagramPackage.COMPOSITION__MULTIPLICITY:
        return getMultiplicity();
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
      case ClassDiagramPackage.COMPOSITION__CONSTITUENT:
        setConstituent((edu.toronto.cs.se.modelepedia.classdiagram.Class)newValue);
        return;
      case ClassDiagramPackage.COMPOSITION__COMPOSITE:
        setComposite((edu.toronto.cs.se.modelepedia.classdiagram.Class)newValue);
        return;
      case ClassDiagramPackage.COMPOSITION__MULTIPLICITY:
        setMultiplicity((String)newValue);
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
      case ClassDiagramPackage.COMPOSITION__CONSTITUENT:
        setConstituent((edu.toronto.cs.se.modelepedia.classdiagram.Class)null);
        return;
      case ClassDiagramPackage.COMPOSITION__COMPOSITE:
        setComposite((edu.toronto.cs.se.modelepedia.classdiagram.Class)null);
        return;
      case ClassDiagramPackage.COMPOSITION__MULTIPLICITY:
        setMultiplicity(CompositionImpl.MULTIPLICITY_EDEFAULT);
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
      case ClassDiagramPackage.COMPOSITION__CONSTITUENT:
        return this.constituent != null;
      case ClassDiagramPackage.COMPOSITION__COMPOSITE:
        return this.composite != null;
      case ClassDiagramPackage.COMPOSITION__MULTIPLICITY:
        return CompositionImpl.MULTIPLICITY_EDEFAULT == null ? this.multiplicity != null : !CompositionImpl.MULTIPLICITY_EDEFAULT.equals(this.multiplicity);
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

    var result = new StringBuilder(super.toString());
    result.append(" (multiplicity: ");
    result.append(this.multiplicity);
    result.append(')');
    return result.toString();
  }

} //CompositionImpl
