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
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Argument Element</b></em>'. <!-- end-user-doc
 * -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getId <em>Id</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getDescription <em>Description</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getContentValidity <em>Content Validity</em>}</li>
 * <li>{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getArgumentElement()
 * @model abstract="true"
 * @generated
 */
public interface ArgumentElement extends EObject {
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getArgumentElement_Id()
   * @model required="true"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getId <em>Id</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @param value
   *          the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' attribute.
   * @see #setDescription(String)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getArgumentElement_Description()
   * @model annotation="gmf.label label='description'"
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * Returns the value of the '<em><b>Status</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @return the value of the '<em>Status</em>' containment reference.
   * @see #setStatus(ImpactAnnotation)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getArgumentElement_Status()
   * @model containment="true"
   * @generated
   */
  ImpactAnnotation getStatus();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getStatus <em>Status</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Status</em>' containment reference.
   * @see #getStatus()
   * @generated
   */
  void setStatus(ImpactAnnotation value);

  /**
   * Returns the value of the '<em><b>Template</b></em>' reference.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.gsn.Template#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template</em>' reference.
   * @see #setTemplate(Template)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getArgumentElement_Template()
   * @see edu.toronto.cs.se.modelepedia.gsn.Template#getElements
   * @model opposite="elements"
   * @generated
   */
  Template getTemplate();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getTemplate <em>Template</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Template</em>' reference.
   * @see #getTemplate()
   * @generated
   */
  void setTemplate(Template value);

  /**
   * Returns the value of the '<em><b>Template Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Id</em>' attribute.
   * @see #setTemplateId(String)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getArgumentElement_TemplateId()
   * @model
   * @generated
   */
  String getTemplateId();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getTemplateId <em>Template Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Template Id</em>' attribute.
   * @see #getTemplateId()
   * @generated
   */
  void setTemplateId(String value);

  /**
   * Returns the value of the '<em><b>Valid</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Valid</em>' attribute.
   * @see #setValid(boolean)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getArgumentElement_Valid()
   * @model default="true" required="true"
   * @generated
   */
  boolean isValid();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#isValid <em>Valid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Valid</em>' attribute.
   * @see #isValid()
   * @generated
   */
  void setValid(boolean value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void validate() throws Exception;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void instantiate() throws Exception;

} // ArgumentElement
