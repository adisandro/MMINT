/*******************************************************************************
 * Copyright (c) 2023, 2023 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.mmint.types.gsn.templates.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.mmint.types.gsn.templates.Property;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionElement;
import edu.toronto.cs.se.mmint.types.gsn.templates.PropertyDecompositionStrategy;
import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IGSNDecompositionTrait;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.TemplateElement;
import edu.toronto.cs.se.modelepedia.gsn.impl.StrategyImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Decomposition Strategy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionStrategyImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionStrategyImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.PropertyDecompositionStrategyImpl#getReasonerName <em>Reasoner Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDecompositionStrategyImpl extends StrategyImpl implements PropertyDecompositionStrategy {
  /**
   * The default value of the '{@link #isValid() <em>Valid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isValid()
   * @generated
   * @ordered
   */
  protected static final boolean VALID_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isValid() <em>Valid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isValid()
   * @generated
   * @ordered
   */
  protected boolean valid = PropertyDecompositionStrategyImpl.VALID_EDEFAULT;

  /**
   * The cached value of the '{@link #getProperty() <em>Property</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperty()
   * @generated
   * @ordered
   */
  protected Property property;

  /**
   * The default value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected static final String REASONER_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getReasonerName() <em>Reasoner Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReasonerName()
   * @generated
   * @ordered
   */
  protected String reasonerName = PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PropertyDecompositionStrategyImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.PROPERTY_DECOMPOSITION_STRATEGY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isValid() {
    return this.valid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setValid(boolean newValid) {
    var oldValid = this.valid;
    this.valid = newValid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__VALID, oldValid, this.valid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Property getProperty() {
    return this.property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProperty(Property newProperty, NotificationChain msgs) {
    var oldProperty = this.property;
    this.property = newProperty;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY, oldProperty, newProperty);
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
  public void setProperty(Property newProperty) {
    if (newProperty != this.property) {
      NotificationChain msgs = null;
      if (this.property != null)
        msgs = ((InternalEObject)this.property).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY, null, msgs);
      if (newProperty != null)
        msgs = ((InternalEObject)newProperty).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY, null, msgs);
      msgs = basicSetProperty(newProperty, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY, newProperty, newProperty));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getReasonerName() {
    return this.reasonerName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReasonerName(String newReasonerName) {
    var oldReasonerName = this.reasonerName;
    this.reasonerName = newReasonerName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME, oldReasonerName, this.reasonerName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        return basicSetProperty(null, msgs);
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
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__VALID:
        return isValid();
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        return getProperty();
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        return getReasonerName();
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
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__VALID:
        setValid((Boolean)newValue);
        return;
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        setProperty((Property)newValue);
        return;
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        setReasonerName((String)newValue);
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
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__VALID:
        setValid(PropertyDecompositionStrategyImpl.VALID_EDEFAULT);
        return;
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        setProperty((Property)null);
        return;
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        setReasonerName(PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT);
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
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__VALID:
        return this.valid != PropertyDecompositionStrategyImpl.VALID_EDEFAULT;
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY:
        return this.property != null;
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__REASONER_NAME:
        return PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT == null ? this.reasonerName != null : !PropertyDecompositionStrategyImpl.REASONER_NAME_EDEFAULT.equals(this.reasonerName);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == TemplateElement.class) {
      return switch (derivedFeatureID) {
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__VALID -> GSNPackage.TEMPLATE_ELEMENT__VALID;
      default -> -1;
      };
    }
    if (baseClass == PropertyDecompositionElement.class) {
      return switch (derivedFeatureID) {
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY -> GSNTemplatesPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY;
      default -> -1;
      };
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == TemplateElement.class) {
      return switch (baseFeatureID) {
      case GSNPackage.TEMPLATE_ELEMENT__VALID -> GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__VALID;
      default -> -1;
      };
    }
    if (baseClass == PropertyDecompositionElement.class) {
      return switch (baseFeatureID) {
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_ELEMENT__PROPERTY -> GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY__PROPERTY;
      default -> -1;
      };
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedOperationID(int baseOperationID, Class<?> baseClass) {
    if (baseClass == TemplateElement.class) {
      return switch (baseOperationID) {
      case GSNPackage.TEMPLATE_ELEMENT___VALIDATE -> GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY___VALIDATE;
      case GSNPackage.TEMPLATE_ELEMENT___REPAIR -> GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY___REPAIR;
      default -> -1;
      };
    }
    if (baseClass == PropertyDecompositionElement.class) {
      return switch (baseOperationID) {
      default -> -1;
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
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY___VALIDATE:
        try {
          validate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNTemplatesPackage.PROPERTY_DECOMPOSITION_STRATEGY___REPAIR:
        try {
          repair();
          return null;
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
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (valid: ");
    result.append(this.valid);
    result.append(", reasonerName: ");
    result.append(this.reasonerName);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    var reasonerName = Objects.requireNonNull(getReasonerName(), "Reasoner not specified");
    var reasoner = Objects.requireNonNull(MMINT.getReasoner(reasonerName),
                                          "The reasoner '" + reasonerName + "' is not installed");
    if (!(reasoner instanceof IGSNDecompositionTrait gsnReasoner)) {
      throw new MMINTException("The reasoner '" + reasonerName + "' does not support GSN property decompositions");
    }
    Objects.requireNonNull(getProperty(), "Property not specified");
    gsnReasoner.validatePropertyDecomposition(this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void repair() throws Exception {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

} //PropertyDecompositionStrategyImpl
