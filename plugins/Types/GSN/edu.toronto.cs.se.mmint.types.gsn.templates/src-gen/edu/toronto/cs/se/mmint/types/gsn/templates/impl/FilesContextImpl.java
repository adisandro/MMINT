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
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext;
import edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.TemplateElement;
import edu.toronto.cs.se.modelepedia.gsn.impl.ContextImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Files Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.FilesContextImpl#isValid <em>Valid</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.impl.FilesContextImpl#getPaths <em>Paths</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FilesContextImpl extends ContextImpl implements FilesContext {
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
  protected boolean valid = FilesContextImpl.VALID_EDEFAULT;

  /**
   * The cached value of the '{@link #getPaths() <em>Paths</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPaths()
   * @generated
   * @ordered
   */
  protected EList<String> paths;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FilesContextImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNTemplatesPackage.Literals.FILES_CONTEXT;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GSNTemplatesPackage.FILES_CONTEXT__VALID, oldValid, this.valid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getPaths() {
    if (this.paths == null) {
      this.paths = new EDataTypeUniqueEList<>(String.class, this, GSNTemplatesPackage.FILES_CONTEXT__PATHS);
    }
    return this.paths;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void validate() throws Exception {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
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

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNTemplatesPackage.FILES_CONTEXT__VALID:
        return isValid();
      case GSNTemplatesPackage.FILES_CONTEXT__PATHS:
        return getPaths();
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
      case GSNTemplatesPackage.FILES_CONTEXT__VALID:
        setValid((Boolean)newValue);
        return;
      case GSNTemplatesPackage.FILES_CONTEXT__PATHS:
        getPaths().clear();
        getPaths().addAll((Collection<? extends String>)newValue);
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
      case GSNTemplatesPackage.FILES_CONTEXT__VALID:
        setValid(FilesContextImpl.VALID_EDEFAULT);
        return;
      case GSNTemplatesPackage.FILES_CONTEXT__PATHS:
        getPaths().clear();
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
      case GSNTemplatesPackage.FILES_CONTEXT__VALID:
        return this.valid != FilesContextImpl.VALID_EDEFAULT;
      case GSNTemplatesPackage.FILES_CONTEXT__PATHS:
        return this.paths != null && !this.paths.isEmpty();
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
      case GSNTemplatesPackage.FILES_CONTEXT__VALID -> GSNPackage.TEMPLATE_ELEMENT__VALID;
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
      case GSNPackage.TEMPLATE_ELEMENT__VALID -> GSNTemplatesPackage.FILES_CONTEXT__VALID;
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
      case GSNPackage.TEMPLATE_ELEMENT___VALIDATE -> GSNTemplatesPackage.FILES_CONTEXT___VALIDATE;
      case GSNPackage.TEMPLATE_ELEMENT___REPAIR -> GSNTemplatesPackage.FILES_CONTEXT___REPAIR;
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
      case GSNTemplatesPackage.FILES_CONTEXT___VALIDATE:
        try {
          validate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNTemplatesPackage.FILES_CONTEXT___REPAIR:
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
    result.append(", paths: ");
    result.append(this.paths);
    result.append(')');
    return result.toString();
  }

} //FilesContextImpl
