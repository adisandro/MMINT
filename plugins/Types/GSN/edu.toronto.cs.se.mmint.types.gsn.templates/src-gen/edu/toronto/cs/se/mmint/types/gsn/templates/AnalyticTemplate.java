/*******************************************************************************
 * Copyright (c) 2024, 2025 Alessio Di Sandro.
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

import edu.toronto.cs.se.mmint.types.gsn.templates.reasoning.IAnalysis;
import edu.toronto.cs.se.modelepedia.gsn.Template;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Analytic Template</b></em>'. A template can be
 * extended in two ways: a) with a custom class that extends the base {@link edu.toronto.cs.se.modelepedia.gsn.Template}
 * class; b) with an analysis class attached to an instance of this AnalyticTemplate class. The first option requires a
 * plugin with an emf model to be created and deployed but allows greater customization, while the second option can be
 * created directly at runtime at the expense of less customization. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getAnalysisPath <em>Analysis Path</em>}</li>
 *   <li>{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getLoaderBundleName <em>Loader Bundle Name</em>}</li>
 * </ul>
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getAnalyticTemplate()
 * @model
 * @generated
 */
public interface AnalyticTemplate extends Template {
  /**
   * Returns the value of the '<em><b>Analysis Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Analysis Path</em>' attribute.
   * @see #setAnalysisPath(String)
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getAnalyticTemplate_AnalysisPath()
   * @model
   * @generated
   */
  String getAnalysisPath();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getAnalysisPath <em>Analysis Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Analysis Path</em>' attribute.
   * @see #getAnalysisPath()
   * @generated
   */
  void setAnalysisPath(String value);

  /**
   * Returns the value of the '<em><b>Loader Bundle Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Loader Bundle Name</em>' attribute.
   * @see #setLoaderBundleName(String)
   * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getAnalyticTemplate_LoaderBundleName()
   * @model
   * @generated
   */
  String getLoaderBundleName();

  /**
   * Sets the value of the '{@link edu.toronto.cs.se.mmint.types.gsn.templates.AnalyticTemplate#getLoaderBundleName <em>Loader Bundle Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Loader Bundle Name</em>' attribute.
   * @see #getLoaderBundleName()
   * @generated
   */
  void setLoaderBundleName(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model kind="operation" dataType="edu.toronto.cs.se.mmint.types.gsn.templates.IAnalysis" exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception"
   * @generated
   */
  IAnalysis getAnalysis() throws Exception;

} // AnalysisTemplate
