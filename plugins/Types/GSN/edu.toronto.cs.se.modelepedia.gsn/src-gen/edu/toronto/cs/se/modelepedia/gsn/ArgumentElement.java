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
   * Returns the value of the '<em><b>Content Validity</b></em>' attribute.
   * The literals are from the enumeration {@link edu.toronto.cs.se.modelepedia.gsn.ValidityValue}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of the '<em>Content Validity</em>' attribute.
   * @see edu.toronto.cs.se.modelepedia.gsn.ValidityValue
   * @see #setContentValidity(ValidityValue)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getArgumentElement_ContentValidity()
   * @model
   * @generated
   */
  ValidityValue getContentValidity();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getContentValidity <em>Content Validity</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Content Validity</em>' attribute.
   * @see edu.toronto.cs.se.modelepedia.gsn.ValidityValue
   * @see #getContentValidity()
   * @generated
   */
  void setContentValidity(ValidityValue value);

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

} // ArgumentElement
