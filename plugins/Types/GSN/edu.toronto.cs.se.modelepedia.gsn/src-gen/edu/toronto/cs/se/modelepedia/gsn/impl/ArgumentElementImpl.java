/*******************************************************************************
 * Copyright (c) 2017, 2025 Alessio Di Sandro, Nick Fung.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

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
   * The cached value of the '{@link #getTemplate() <em>Template</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplate()
   * @generated
   * @ordered
   */
  protected Template template;

  /**
   * The default value of the '{@link #getTemplateId() <em>Template Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateId()
   * @generated
   * @ordered
   */
  protected static final String TEMPLATE_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTemplateId() <em>Template Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemplateId()
   * @generated
   * @ordered
   */
  protected String templateId = ArgumentElementImpl.TEMPLATE_ID_EDEFAULT;

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
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__ID, oldId, this.id));
    }
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
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__DESCRIPTION, oldDescription, this.description));
    }
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
      if (msgs == null) {
        msgs = notification;
      }
      else {
        msgs.add(notification);
      }
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
      if (this.status != null) {
        msgs = ((InternalEObject)this.status).eInverseRemove(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.ARGUMENT_ELEMENT__STATUS, null, msgs);
      }
      if (newStatus != null) {
        msgs = ((InternalEObject)newStatus).eInverseAdd(this, InternalEObject.EOPPOSITE_FEATURE_BASE - GSNPackage.ARGUMENT_ELEMENT__STATUS, null, msgs);
      }
      msgs = basicSetStatus(newStatus, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__STATUS, newStatus, newStatus));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Template getTemplate() {
    if (this.template != null && this.template.eIsProxy()) {
      var oldTemplate = (InternalEObject)this.template;
      this.template = (Template)eResolveProxy(oldTemplate);
      if (this.template != oldTemplate) {
        if (eNotificationRequired()) {
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GSNPackage.ARGUMENT_ELEMENT__TEMPLATE, oldTemplate, this.template));
        }
      }
    }
    return this.template;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Template basicGetTemplate() {
    return this.template;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTemplate(Template newTemplate, NotificationChain msgs) {
    var oldTemplate = this.template;
    this.template = newTemplate;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__TEMPLATE, oldTemplate, newTemplate);
      if (msgs == null) {
        msgs = notification;
      }
      else {
        msgs.add(notification);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTemplate(Template newTemplate) {
    if (newTemplate != this.template) {
      NotificationChain msgs = null;
      if (this.template != null) {
        msgs = ((InternalEObject)this.template).eInverseRemove(this, GSNPackage.TEMPLATE__ELEMENTS, Template.class, msgs);
      }
      if (newTemplate != null) {
        msgs = ((InternalEObject)newTemplate).eInverseAdd(this, GSNPackage.TEMPLATE__ELEMENTS, Template.class, msgs);
      }
      msgs = basicSetTemplate(newTemplate, msgs);
      if (msgs != null) {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__TEMPLATE, newTemplate, newTemplate));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getTemplateId() {
    return this.templateId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTemplateId(String newTemplateId) {
    var oldTemplateId = this.templateId;
    this.templateId = newTemplateId;
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__TEMPLATE_ID, oldTemplateId, this.templateId));
    }
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
    if (eNotificationRequired()) {
      eNotify(new ENotificationImpl(this, Notification.SET, GSNPackage.ARGUMENT_ELEMENT__VALID, oldValid, this.valid));
    }
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
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE:
        if (this.template != null) {
          msgs = ((InternalEObject)this.template).eInverseRemove(this, GSNPackage.TEMPLATE__ELEMENTS, Template.class, msgs);
        }
        return basicSetTemplate((Template)otherEnd, msgs);
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
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE:
        return basicSetTemplate(null, msgs);
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
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE:
        if (resolve) {
          return getTemplate();
        }
        return basicGetTemplate();
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE_ID:
        return getTemplateId();
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
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE:
        setTemplate((Template)newValue);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE_ID:
        setTemplateId((String)newValue);
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
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE:
        setTemplate((Template)null);
        return;
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE_ID:
        setTemplateId(ArgumentElementImpl.TEMPLATE_ID_EDEFAULT);
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
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE:
        return this.template != null;
      case GSNPackage.ARGUMENT_ELEMENT__TEMPLATE_ID:
        return ArgumentElementImpl.TEMPLATE_ID_EDEFAULT == null ? this.templateId != null : !ArgumentElementImpl.TEMPLATE_ID_EDEFAULT.equals(this.templateId);
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
    if (eIsProxy()) {
      return super.toString();
    }

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (id: ");
    result.append(this.id);
    result.append(", description: ");
    result.append(this.description);
    result.append(", templateId: ");
    result.append(this.templateId);
    result.append(", valid: ");
    result.append(this.valid);
    result.append(')');
    return result.toString();
  }

  /**
   * @generated NOT
   */
  @Override
  public void instantiate() throws Exception {
    var title = "Instantiate placeholder text";
    var node = eClass().getName() + " " + getId();
    while (true) {
      var desc = getDescription();
      var placeholder = GSNBuilder.findPlaceholder(desc);
      if (placeholder.isEmpty()) {
        break;
      }
      var toReplace = placeholder.get();
      var msg = "Replace '" + toReplace + "' in " + node + " with:";
      var replacement = MIDDialogs.getStringInput(title, msg, null);
      setDescription(desc.replace(GSNBuilder.placeholder(toReplace), replacement));
    }
  }

  /**
   * @generated NOT
   */
  @Override
  public void validate() throws Exception {
    if (GSNBuilder.findPlaceholder(getDescription()).isPresent()) {
      setValid(false);
      throw new MMINTException(eClass().getName() + " " + getId() +
                               " description contains placeholder text to be instantiated");
    }
    setValid(true);
  }

} // ArgumentElementImpl
