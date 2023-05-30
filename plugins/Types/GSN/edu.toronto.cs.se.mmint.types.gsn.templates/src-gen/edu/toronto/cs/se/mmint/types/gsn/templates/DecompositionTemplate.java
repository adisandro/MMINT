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
package edu.toronto.cs.se.mmint.types.gsn.templates;

import edu.toronto.cs.se.mmint.types.gsn.templates.util.GSNTemplatesBuilder;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.Template;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decomposition Template</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesPackage#getDecompositionTemplate()
 * @model abstract="true"
 * @generated
 */
public interface DecompositionTemplate extends Template {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="edu.toronto.cs.se.modelepedia.gsn.Exception" decomposedRequired="true" builderDataType="edu.toronto.cs.se.mmint.types.gsn.templates.GSNTemplatesBuilder" builderRequired="true"
   * @generated
   */
  void decompose(Goal decomposed, GSNTemplatesBuilder builder) throws Exception;

} // DecompositionTemplate
