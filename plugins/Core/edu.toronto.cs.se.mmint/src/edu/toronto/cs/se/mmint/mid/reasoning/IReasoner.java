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
package edu.toronto.cs.se.mmint.mid.reasoning;

/**
 * The basic specification of a reasoner engine.
 *
 * @author Alessio Di Sandro
 */
public interface IReasoner {

  /**
   * Gets the name to identify this reasoner by users.
   *
   * @return The reasoner name.
   */
  public String getName();
}
