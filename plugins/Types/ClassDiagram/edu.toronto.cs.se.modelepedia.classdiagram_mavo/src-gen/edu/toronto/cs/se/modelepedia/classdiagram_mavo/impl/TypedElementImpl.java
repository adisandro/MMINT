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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.TypedElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.TypedElementImpl#isPublic <em>Public</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.classdiagram_mavo.impl.TypedElementImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TypedElementImpl extends NamedElementImpl implements TypedElement {
	/**
   * The default value of the '{@link #isPublic() <em>Public</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isPublic()
   * @generated
   * @ordered
   */
	protected static final boolean PUBLIC_EDEFAULT = false;

	/**
   * The cached value of the '{@link #isPublic() <em>Public</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isPublic()
   * @generated
   * @ordered
   */
	protected boolean public_ = TypedElementImpl.PUBLIC_EDEFAULT;

	/**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
	protected edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class type;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected TypedElementImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	protected EClass eStaticClass() {
    return ClassDiagram_MAVOPackage.Literals.TYPED_ELEMENT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public boolean isPublic() {
    return this.public_;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public void setPublic(boolean newPublic) {
    var oldPublic = this.public_;
    this.public_ = newPublic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.TYPED_ELEMENT__PUBLIC, oldPublic, this.public_));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class getType() {
    if (this.type != null && this.type.eIsProxy()) {
      var oldType = (InternalEObject)this.type;
      this.type = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)eResolveProxy(oldType);
      if (this.type != oldType) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassDiagram_MAVOPackage.TYPED_ELEMENT__TYPE, oldType, this.type));
      }
    }
    return this.type;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class basicGetType() {
    return this.type;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
  public void setType(edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class newType) {
    var oldType = this.type;
    this.type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ClassDiagram_MAVOPackage.TYPED_ELEMENT__TYPE, oldType, this.type));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ClassDiagram_MAVOPackage.TYPED_ELEMENT__PUBLIC:
        return isPublic();
      case ClassDiagram_MAVOPackage.TYPED_ELEMENT__TYPE:
        if (resolve) return getType();
        return basicGetType();
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
      case ClassDiagram_MAVOPackage.TYPED_ELEMENT__PUBLIC:
        setPublic((Boolean)newValue);
        return;
      case ClassDiagram_MAVOPackage.TYPED_ELEMENT__TYPE:
        setType((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)newValue);
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
      case ClassDiagram_MAVOPackage.TYPED_ELEMENT__PUBLIC:
        setPublic(TypedElementImpl.PUBLIC_EDEFAULT);
        return;
      case ClassDiagram_MAVOPackage.TYPED_ELEMENT__TYPE:
        setType((edu.toronto.cs.se.modelepedia.classdiagram_mavo.Class)null);
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
      case ClassDiagram_MAVOPackage.TYPED_ELEMENT__PUBLIC:
        return this.public_ != TypedElementImpl.PUBLIC_EDEFAULT;
      case ClassDiagram_MAVOPackage.TYPED_ELEMENT__TYPE:
        return this.type != null;
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
    result.append(" (public: ");
    result.append(this.public_);
    result.append(')');
    return result.toString();
  }

} //TypedElementImpl
