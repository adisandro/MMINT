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
package edu.toronto.cs.se.modelepedia.gsn;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.gsn.util.GSNBuilder;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.Template#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.toronto.cs.se.modelepedia.gsn.Template#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getTemplate()
 * @model
 * @generated
 */
public interface Template extends EObject {
  /**
   * Returns the value of the '<em><b>Elements</b></em>' reference list.
   * The list contents are of type {@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement}.
   * It is bidirectional and its opposite is '{@link edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getTemplates <em>Templates</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elements</em>' reference list.
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getTemplate_Elements()
   * @see edu.toronto.cs.se.modelepedia.gsn.ArgumentElement#getTemplates
   * @model opposite="templates" required="true"
   * @generated
   */
  EList<ArgumentElement> getElements();

  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see #setId(String)
   * @see edu.toronto.cs.se.modelepedia.gsn.GSNPackage#getTemplate_Id()
   * @model required="true"
   * @generated
   */
  String getId();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.modelepedia.gsn.Template#getId <em>Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Id</em>' attribute.
   * @see #getId()
   * @generated
   */
  void setId(String value);

  /**
   * <!-- begin-user-doc -->Validates the correctness of this instantiated template. The base implementation does
   * nothing.
   *
   * @throws Exception
   *           If this template has not been instantiated correctly. <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  void validate() throws Exception;

  /**
   * <!-- begin-user-doc --> Instantiates this template into a safety case. Instantiation should not make changes
   * directly to the safety case but through a GSN builder, which must be created and returned to commit them later
   * within an EMF write command. The base implementation copies all the GSN template elements into the builder.
   *
   * @param safetyCase
   *          The safety case in which to instantiate the template.
   * @param selection
   *          The selected elements in the safety case where the template instantiation starts.
   * @return The GSN builder used as a facade to store changes to the safety case.
   * @throws Exception
   *           If this template can not be instantiated. <!-- end-user-doc -->
   * @model dataType="edu.toronto.cs.se.modelepedia.gsn.GSNBuilder" required="true" exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" safetyCaseRequired="true" selectionMany="true"
   * @generated
   */
  GSNBuilder instantiate(SafetyCase safetyCase, EList<EObject> selection) throws Exception;

} // Template
