/*******************************************************************************
 * Copyright (c) 2025, 2025 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint;

import java.util.List;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;

/**
 * An input for an operator instance.
 */
public record OperatorInput(
  Model model, // The input actual parameter.
  List<ConversionOperator> conversions, // The list of conversions to be executed on the input actual parameter.
  ModelEndpoint modelTypeEndpoint // The input formal parameter.
) {}
