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
package edu.toronto.cs.se.mmint.mid.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.MIDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extendible Element Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ExtendibleElementEndpointImpl extends ExtendibleElementImpl implements ExtendibleElementEndpoint {
    /**
   * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
    protected static final int LOWER_BOUND_EDEFAULT = 0;

    /**
   * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
    protected int lowerBound = LOWER_BOUND_EDEFAULT;

    /**
   * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
    protected static final int UPPER_BOUND_EDEFAULT = 0;

    /**
   * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
    protected int upperBound = UPPER_BOUND_EDEFAULT;

    /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
    protected ExtendibleElement target;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected ExtendibleElementEndpointImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return MIDPackage.Literals.EXTENDIBLE_ELEMENT_ENDPOINT;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public int getLowerBound() {
    return lowerBound;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setLowerBound(int newLowerBound) {
    int oldLowerBound = lowerBound;
    lowerBound = newLowerBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND, oldLowerBound, lowerBound));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public int getUpperBound() {
    return upperBound;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setUpperBound(int newUpperBound) {
    int oldUpperBound = upperBound;
    upperBound = newUpperBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND, oldUpperBound, upperBound));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ExtendibleElement getTarget() {
    if (target != null && target.eIsProxy()) {
      InternalEObject oldTarget = (InternalEObject)target;
      target = (ExtendibleElement)eResolveProxy(oldTarget);
      if (target != oldTarget) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET, oldTarget, target));
      }
    }
    return target;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    public ExtendibleElement basicGetTarget() {
    return target;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setTarget(ExtendibleElement newTarget) {
    ExtendibleElement oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET, oldTarget, target));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getTargetUri() {
    ExtendibleElement target = this.getTarget();
    return (target == null) ? null : target.getUri();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ExtendibleElementEndpoint getMetatype() {
    ExtendibleElement metatype = super.getMetatype();
    return (metatype == null) ? null : (ExtendibleElementEndpoint) metatype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ExtendibleElementEndpoint getSupertype() {
    ExtendibleElement supertype = super.getSupertype();
    return (supertype == null) ? null : (ExtendibleElementEndpoint) supertype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND:
        return getLowerBound();
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND:
        return getUpperBound();
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET:
        if (resolve) return getTarget();
        return basicGetTarget();
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
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND:
        setLowerBound((Integer)newValue);
        return;
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND:
        setUpperBound((Integer)newValue);
        return;
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET:
        setTarget((ExtendibleElement)newValue);
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
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND:
        setLowerBound(LOWER_BOUND_EDEFAULT);
        return;
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND:
        setUpperBound(UPPER_BOUND_EDEFAULT);
        return;
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET:
        setTarget((ExtendibleElement)null);
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
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__LOWER_BOUND:
        return lowerBound != LOWER_BOUND_EDEFAULT;
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__UPPER_BOUND:
        return upperBound != UPPER_BOUND_EDEFAULT;
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT__TARGET:
        return target != null;
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == ExtendibleElement.class) {
      switch (baseOperationID) {
        case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE: return MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE;
        default: return super.eDerivedOperationID(baseOperationID, baseClass);
      }
    }
    return super.eDerivedOperationID(baseOperationID, baseClass);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE:
        return getMetatype();
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE:
        return getSupertype();
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_TARGET_URI:
        return getTargetUri();
    }
    return super.eInvoke(operationID, arguments);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String toStringGen() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (lowerBound: ");
    result.append(lowerBound);
    result.append(", upperBound: ");
    result.append(upperBound);
    result.append(')');
    return result.toString();
  }

    /**
     * Adds the target to an instance endpoint of this type.
     * 
     * @param newInstanceEndpoint
     *            The new instance endpoint.
     * @param targetInstance
     *            The instance that is the target of the new instance endpoint.
     * @generated NOT
     */
    protected void addInstanceEndpoint(ExtendibleElementEndpoint newInstanceEndpoint, ExtendibleElement targetInstance) {

        newInstanceEndpoint.setTarget(targetInstance);
        newInstanceEndpoint.setLowerBound(1);
        newInstanceEndpoint.setUpperBound(1);
    }

} //ExtendibleElementEndpointImpl
