/*******************************************************************************
 * Copyright (c) 2022, 2022 Alessio Di Sandro.
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

import java.util.Objects;

/**
 * The basic specification of a SAT reasoner engine.
 *
 * @author Alessio Di Sandro
 */
public interface ISATReasoner extends IReasoner {

  /**
   * Counters to keep track of SAT calls and time.
   */
  public record SATCounters(long time, int numCalls) {
    public SATCounters(long time, int numCalls) {
      this.time = Objects.requireNonNull(time);
      this.numCalls = Objects.requireNonNull(numCalls);
    }
  }

  /**
   * Enables or disables the SAT counters, resetting them in both cases.
   */
  default void toggleCounters(boolean enable) {}

  /**
   * Retrieves the SAT counters.
   *
   * @return The SAT counters.
   */
  default SATCounters getCounters() {
    return new SATCounters(0, 0);
  }
}
