/*******************************************************************************
 * Copyright (c) 2020, 2020 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.reasoning;

import java.util.List;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoner;

/**
 * The specification of a reasoning trait to decompose GSN goals.
 *
 * @author Alessio Di Sandro
 */
public interface IDecompositionTrait extends IReasoner {

  /**
   * Validates the correctness of a GSN property decomposition.
   *
   * @param model
   *          The model the property refers to.
   * @param property
   *          The main property that is being decomposed.
   * @param subProperties
   *          The sub-properties that the main property is being decomposed into.
   * @throws Exception
   *           If the validation fails.
   */
  void validatePropertyDecomposition(Model model, String property, List<String> subProperties) throws Exception;
}
