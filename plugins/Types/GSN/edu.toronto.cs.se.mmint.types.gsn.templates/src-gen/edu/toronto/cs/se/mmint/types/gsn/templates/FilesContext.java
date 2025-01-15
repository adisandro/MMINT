/*******************************************************************************
 * Copyright (c) 2023, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.types.gsn.templates;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.modelepedia.gsn.Context;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Files Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.FilesContext#getPaths <em>Paths</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getFilesContext()
 * @model
 * @generated
 */
public interface FilesContext extends Context {
  /**
   * Returns the value of the '<em><b>Paths</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Paths</em>' attribute list.
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getFilesContext_Paths()
   * @model required="true"
   * @generated
   */
  EList<String> getPaths();

} // FilesContext
