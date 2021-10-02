/*******************************************************************************
 * Copyright (c) 2020, 2021 Alessio Di Sandro.
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
  String getName();

  /**
   * Checks whether this reasoner can be used, based on application-specific data.
   *
   * @param data
   *          The relevant data.
   * @return True if this reasoner can be used, false otherwise.
   */
  default boolean canUse(Object data) {
    return true;
  }
}
