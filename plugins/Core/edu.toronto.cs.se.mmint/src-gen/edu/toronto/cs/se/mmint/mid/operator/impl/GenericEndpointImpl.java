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
package edu.toronto.cs.se.mmint.mid.operator.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.impl.ExtendibleElementEndpointImpl;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Endpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.mid.operator.impl.GenericEndpointImpl#getMetatargetUri <em>Metatarget Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenericEndpointImpl extends ExtendibleElementEndpointImpl implements GenericEndpoint {
    /**
   * The default value of the '{@link #getMetatargetUri() <em>Metatarget Uri</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getMetatargetUri()
   * @generated
   * @ordered
   */
    protected static final String METATARGET_URI_EDEFAULT = null;
    /**
   * The cached value of the '{@link #getMetatargetUri() <em>Metatarget Uri</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getMetatargetUri()
   * @generated
   * @ordered
   */
    protected String metatargetUri = GenericEndpointImpl.METATARGET_URI_EDEFAULT;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected GenericEndpointImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return OperatorPackage.Literals.GENERIC_ENDPOINT;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getMetatargetUri() {
    return this.metatargetUri;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setMetatargetUri(String newMetatargetUri) {
    var oldMetatargetUri = this.metatargetUri;
    this.metatargetUri = newMetatargetUri;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, OperatorPackage.GENERIC_ENDPOINT__METATARGET_URI, oldMetatargetUri, this.metatargetUri));
    }
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public GenericEndpoint getSupertype() {
    var supertype = super.getSupertype();
    return (supertype == null) ? null : (GenericEndpoint) supertype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public GenericElement getTarget() {
    GenericElement target = MIDTypeRegistry.getType(getMetatargetUri());
    return target;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setTarget(final ExtendibleElement newTarget) {
    setMetatargetUri(newTarget.getUri());
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public GenericEndpoint getMetatype() {
    var metatype = super.getMetatype();
    return (metatype == null) ? null : (GenericEndpoint) metatype;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == ExtendibleElement.class) {
      return switch (baseOperationID) {
      case MIDPackage.EXTENDIBLE_ELEMENT___GET_METATYPE -> OperatorPackage.GENERIC_ENDPOINT___GET_METATYPE;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
    }
    if (baseClass == ExtendibleElementEndpoint.class) {
      return switch (baseOperationID) {
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_METATYPE -> OperatorPackage.GENERIC_ENDPOINT___GET_METATYPE;
      case MIDPackage.EXTENDIBLE_ELEMENT_ENDPOINT___GET_SUPERTYPE -> OperatorPackage.GENERIC_ENDPOINT___GET_SUPERTYPE;
      default -> super.eDerivedOperationID(baseOperationID, baseClass);
      };
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
      case OperatorPackage.GENERIC_ENDPOINT___GET_SUPERTYPE:
        return getSupertype();
      case OperatorPackage.GENERIC_ENDPOINT___GET_TARGET:
        return getTarget();
      case OperatorPackage.GENERIC_ENDPOINT___SET_TARGET__EXTENDIBLEELEMENT:
        setTarget((ExtendibleElement)arguments.get(0));
        return null;
      case OperatorPackage.GENERIC_ENDPOINT___GET_METATYPE:
        return getMetatype();
      case OperatorPackage.GENERIC_ENDPOINT___CREATE_INSTANCE__GENERICELEMENT_OPERATOR:
        try {
          return createInstance((GenericElement)arguments.get(0), (Operator)arguments.get(1));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case OperatorPackage.GENERIC_ENDPOINT___CREATE_WORKFLOW_INSTANCE__GENERICELEMENT_OPERATOR:
        try {
          return createWorkflowInstance((GenericElement)arguments.get(0), (Operator)arguments.get(1));
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
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
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (metatargetUri: ");
    result.append(this.metatargetUri);
    result.append(')');
    return result.toString();
  }

    /**
     * @generated NOT
     */
    @Override
    public String toString() {

        return (this.getName() == null) ? "" : this.getName();
    }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case OperatorPackage.GENERIC_ENDPOINT__METATARGET_URI:
        return getMetatargetUri();
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
      case OperatorPackage.GENERIC_ENDPOINT__METATARGET_URI:
        setMetatargetUri((String)newValue);
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
      case OperatorPackage.GENERIC_ENDPOINT__METATARGET_URI:
        setMetatargetUri(GenericEndpointImpl.METATARGET_URI_EDEFAULT);
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
      case OperatorPackage.GENERIC_ENDPOINT__METATARGET_URI:
        return GenericEndpointImpl.METATARGET_URI_EDEFAULT == null ? this.metatargetUri != null : !GenericEndpointImpl.METATARGET_URI_EDEFAULT.equals(this.metatargetUri);
    }
    return super.eIsSet(featureID);
  }

    /**
     * Adds a generic instance endpoint of this generic type endpoint to an Instance or Workflow MID.
     *
     * @param newGenericEndpoint
     *            The new generic instance endpoint to be added.
     * @param targetGenericType
     *            The generic that is the target of the new generic endpoint.
     * @param containerOperator
     *            The operator that will contain the new generic endpoint.
     * @generated NOT
     */
    protected void addInstance(GenericEndpoint newGenericEndpoint, GenericElement targetGenericType, Operator containerOperator) {

        super.addBasicInstance(newGenericEndpoint, null, targetGenericType.getName(), containerOperator.getLevel());
        super.addInstanceEndpoint(newGenericEndpoint, targetGenericType);
        containerOperator.getGenerics().add(newGenericEndpoint);
    }

    /**
     * @generated NOT
     */
    @Override
    public GenericEndpoint createInstance(GenericElement targetGeneric, Operator containerOperator) throws MMINTException {

        MMINTException.mustBeType(this);

        var newGenericEndpoint = super.<GenericEndpoint>createThisEClass();
        this.addInstance(newGenericEndpoint, targetGeneric, containerOperator);

        return newGenericEndpoint;
    }

    /**
     * @generated NOT
     */
    @Override
    public GenericEndpoint createWorkflowInstance(GenericElement targetGeneric, Operator containerOperator) throws MMINTException {

        MMINTException.mustBeType(this);

        var newGenericEndpoint = super.<GenericEndpoint>createThisEClass();
        this.addInstance(newGenericEndpoint, targetGeneric, containerOperator);

        return newGenericEndpoint;
    }

} //GenericEndpointImpl
