/*******************************************************************************
 * Copyright (c) 2023, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Template;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.TemplateImpl#getId <em>Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TemplateImpl extends MinimalEObjectImpl.Container implements Template {
  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<ArgumentElement> elements;

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = TemplateImpl.ID_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TemplateImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.TEMPLATE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ArgumentElement> getElements() {
    if (this.elements == null) {
      this.elements = new EObjectWithInverseResolvingEList.ManyInverse<>(ArgumentElement.class, this, GSNPackage.TEMPLATE__ELEMENTS, GSNPackage.ARGUMENT_ELEMENT__TEMPLATES);
    }
    return this.elements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getId() {
    return this.id;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setId(String newId) {
    var oldId = this.id;
    this.id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.TEMPLATE__ID, oldId, this.id));
  }

  /**
   * @generated NOT
   */
  @Override
  public void import_(SafetyCase safetyCase) throws Exception {
    var builder = new GSNBuilder(safetyCase);
    var templateSC = (SafetyCase) eContainer();
    builder.addExistingElements(templateSC.getGoals());
    builder.addExistingElements(templateSC.getStrategies());
    builder.addExistingElements(templateSC.getSolutions());
    builder.addExistingElements(templateSC.getContexts());
    builder.addExistingElements(templateSC.getJustifications());
    builder.addExistingElements(templateSC.getAssumptions());
    builder.addExistingTemplate(this);
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    for (var elem : getElements()) {
      if (elem.isValid()) {
        continue;
      }
      elem.instantiate();
    }
  }

  /**
   * @generated NOT
   */
  protected void validate(List<ArgumentElement> elements) throws Exception {
    for (var element : elements) {
      element.validate();
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    // copy to avoid concurrent modifications: template element validation may modify the template
    validate(List.copyOf(getElements()));
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
      case GSNPackage.TEMPLATE__ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
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
      case GSNPackage.TEMPLATE__ELEMENTS:
        return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
      case GSNPackage.TEMPLATE__ELEMENTS:
        return getElements();
      case GSNPackage.TEMPLATE__ID:
        return getId();
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
      case GSNPackage.TEMPLATE__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends ArgumentElement>)newValue);
        return;
      case GSNPackage.TEMPLATE__ID:
        setId((String)newValue);
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
      case GSNPackage.TEMPLATE__ELEMENTS:
        getElements().clear();
        return;
      case GSNPackage.TEMPLATE__ID:
        setId(TemplateImpl.ID_EDEFAULT);
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
      case GSNPackage.TEMPLATE__ELEMENTS:
        return this.elements != null && !this.elements.isEmpty();
      case GSNPackage.TEMPLATE__ID:
        return TemplateImpl.ID_EDEFAULT == null ? this.id != null : !TemplateImpl.ID_EDEFAULT.equals(this.id);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  @SuppressWarnings("unchecked")
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case GSNPackage.TEMPLATE___VALIDATE:
        try {
          validate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNPackage.TEMPLATE___IMPORT____SAFETYCASE:
        try {
          import_((SafetyCase)arguments.get(0));
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNPackage.TEMPLATE___INSTANTIATE:
        try {
          instantiate();
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
    result.append(" (id: ");
    result.append(this.id);
    result.append(')');
    return result.toString();
  }

} //TemplateImpl
