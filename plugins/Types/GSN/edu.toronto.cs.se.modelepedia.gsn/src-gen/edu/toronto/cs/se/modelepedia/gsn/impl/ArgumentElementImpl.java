/*******************************************************************************
 * Copyright (c) 2017, 2023 Alessio Di Sandro, Nick Fung.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *     Nick Fung - Implementation
 *******************************************************************************/
package edu.toronto.cs.se.modelepedia.gsn.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNPackage;
import edu.toronto.cs.se.modelepedia.gsn.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.gsn.Template;
import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Argument Element</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl#getId <em>Id</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl#getDescription <em>Description</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl#getContentValidity <em>Content
 * Validity</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.impl.ArgumentElementImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ArgumentElementImpl extends MinimalEObjectImpl.Container implements ArgumentElement {
  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final String ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected String id = ArgumentElementImpl.ID_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = ArgumentElementImpl.DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getStatus() <em>Status</em>}' containment reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getStatus()
   * @generated
   * @ordered
   */
  protected ImpactAnnotation status;

  /**
   * The cached value of the '{@link #getTemplates() <em>Templates</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplates()
   * @generated
   * @ordered
   */
  protected EList<Template> templates;

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
  protected boolean valid = ArgumentElementImpl.VALID_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ArgumentElementImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return GSNPackage.Literals.ARGUMENT_ELEMENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getId() {
    return this.id;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setId(String newId) {
    var oldId = this.id;
    this.id = newId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__ID, oldId, this.id));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDescription() {
    return this.description;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDescription(String newDescription) {
    var oldDescription = this.description;
    this.description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION, oldDescription, this.description));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImpactAnnotation getStatus() {
    return this.status;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetStatus(ImpactAnnotation newStatus, NotificationChain msgs) {
    var oldStatus = this.status;
    this.status = newStatus;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__STATUS, oldStatus, newStatus);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setStatus(ImpactAnnotation newStatus) {
    if (newStatus != this.status) {
      NotificationChain msgs = null;
      if (this.status != null)
        msgs = ((InternalEObject)this.status).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.ARGUMENT_ELEMENT__STATUS, null, msgs);
      if (newStatus != null)
        msgs = ((InternalEObject)newStatus).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.ARGUMENT_ELEMENT__STATUS, null, msgs);
      msgs = basicSetStatus(newStatus, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__STATUS, newStatus, newStatus));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Template> getTemplates() {
    if (this.templates == null) {
      this.templates = new EObjectWithInverseResolvingEList.ManyInverse<>(Template.class, this, GSNPackage.ARGUMENT_ELEMENT__TEMPLATES, GSNPackage.TEMPLATE__ELEMENTS);
    }
    return this.templates;
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
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__VALID, oldValid, this.valid));
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
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATES:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getTemplates()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        return basicSetStatus(null, msgs);
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATES:
        return ((InternalEList<?>)getTemplates()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case GSNPackage.ARGUMENT_ELEMENT__ID:
        return getId();
      case GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION:
        return getDescription();
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        return getStatus();
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATES:
        return getTemplates();
      case GSNPackage.ARGUMENT_ELEMENT__VALID:
        return isValid();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case GSNPackage.ARGUMENT_ELEMENT__ID:
        setId((String)newValue);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        setStatus((ImpactAnnotation)newValue);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATES:
        getTemplates().clear();
        getTemplates().addAll((Collection<? extends Template>)newValue);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__VALID:
        setValid((Boolean)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case GSNPackage.ARGUMENT_ELEMENT__ID:
        setId(ArgumentElementImpl.ID_EDEFAULT);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION:
        setDescription(ArgumentElementImpl.DESCRIPTION_EDEFAULT);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        setStatus((ImpactAnnotation)null);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATES:
        getTemplates().clear();
        return;
      case GSNPackage.ARGUMENT_ELEMENT__VALID:
        setValid(ArgumentElementImpl.VALID_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case GSNPackage.ARGUMENT_ELEMENT__ID:
        return ArgumentElementImpl.ID_EDEFAULT == null ? this.id != null : !ArgumentElementImpl.ID_EDEFAULT.equals(this.id);
      case GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION:
        return ArgumentElementImpl.DESCRIPTION_EDEFAULT == null ? this.description != null : !ArgumentElementImpl.DESCRIPTION_EDEFAULT.equals(this.description);
      case GSNPackage.ARGUMENT_ELEMENT__STATUS:
        return this.status != null;
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATES:
        return this.templates != null && !this.templates.isEmpty();
      case GSNPackage.ARGUMENT_ELEMENT__VALID:
        return this.valid != ArgumentElementImpl.VALID_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
    switch (operationID) {
      case GSNPackage.ARGUMENT_ELEMENT___VALIDATE:
        try {
          validate();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNPackage.ARGUMENT_ELEMENT___REPAIR:
        try {
          repair();
          return null;
        }
        catch (Throwable throwable) {
          throw new InvocationTargetException(throwable);
        }
      case GSNPackage.ARGUMENT_ELEMENT___INSTANTIATE:
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (id: ");
    result.append(this.id);
    result.append(", description: ");
    result.append(this.description);
    result.append(", valid: ");
    result.append(this.valid);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  private void replacePlaceholders(String title) throws Exception {
    while (true) {
      var desc = getDescription();
      var pattern = GSNBuilder.findPattern(desc);
      if (pattern.isEmpty()) {
        break;
      }
      var toReplace = pattern.get();
      var msg = "Replace '" + toReplace + "' in '" + desc + "' with:";
      var replacement = MIDDialogs.getStringInput(title, msg, null);
      setDescription(desc.replace(GSNBuilder.PATTERN1 + toReplace + GSNBuilder.PATTERN2, replacement));
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    replacePlaceholders("Instantiate Placeholder Text in " + eClass().getName() + " " + getId());
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    if (GSNBuilder.findPattern(getDescription()).isPresent()) {
      setValid(false);
      throw new MMINTException("Element " + getId() + " description contains placeholder text to be instantiated");
    }
    setValid(true);
  }

  /**
   * @generated NOT
   */
  @Override
  public void repair() throws Exception {
    replacePlaceholders("Repair Placeholder Text in " + eClass().getName() + " " + getId());
  }

} // ArgumentElementImpl
