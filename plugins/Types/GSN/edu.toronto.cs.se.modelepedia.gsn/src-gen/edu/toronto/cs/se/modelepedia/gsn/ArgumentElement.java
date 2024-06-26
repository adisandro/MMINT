/*******************************************************************************
 * Copyright (c) 2017, 2024 Alessio Di Sandro, Nick Fung.
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

import org.eclipse.emf.common.util.EList;
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
   * Returns the value of the '<em><b>Templates</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.Template}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.gsn.Template#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Templates</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getArgumentElement_Templates()
   * @see edu.toronto.cs.se.modelepedia.gsn.Template#getElements
   * @model opposite="elements"
   * @generated
   */
  EList<Template> getTemplates();

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
   * <!-- begin-user-doc --> Instantiates this template element. The base implementation searches and replaces
   * placeholder text formatted like {placeholder} in the description.
   *
   * @param template
   *          The template that contains this template element.
   *
   * @throws Exception
   *           If this template element can not be instantiated. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" templateRequired="true"
   * @generated
   */
  void instantiate(Template template) throws Exception;

  /**
   * <!-- begin-user-doc --> Validates the correctness of this instantiated template element. The base implementation
   * checks that no placeholder text formatted like {placeholder} is present in the description.
   *
   * @param template
   *          The template that contains this template element.
   *
   * @throws Exception
   *           If this template element has not been instantiated correctly. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" templateRequired="true"
   * @generated
   */
  void validate(Template template) throws Exception;

} // ArgumentElement
