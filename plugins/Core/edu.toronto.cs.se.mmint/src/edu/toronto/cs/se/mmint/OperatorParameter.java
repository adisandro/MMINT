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

import java.util.Objects;
import java.util.Optional;

import org.eclipse.jdt.annotation.Nullable;

/**
 * A parameter for an operator type.
 */
public record OperatorParameter(
  String name, String type, int lower, int upper, Optional<String> ext, Optional<String> suffix) {

  public OperatorParameter {
    Objects.requireNonNull(name);
    Objects.requireNonNull(type);
  }

  public OperatorParameter(String name, String type) {
    this(name, type, 1, 1, Optional.empty(), Optional.empty());
  }

  public OperatorParameter(String name, String type, int lower, int upper) {
    this(name, type, lower, upper, Optional.empty(), Optional.empty());
  }

  public OperatorParameter(String name, String type, @Nullable String ext, @Nullable String suffix) {
    this(name, type, 1, 1, Optional.ofNullable(ext), Optional.ofNullable(suffix));
  }

  public OperatorParameter specialize(String type) {
    return new OperatorParameter(name(), type, lower(), upper(), ext(), suffix());
  }
}
