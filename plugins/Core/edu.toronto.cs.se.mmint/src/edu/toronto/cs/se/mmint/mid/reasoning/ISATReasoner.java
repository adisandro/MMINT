/*******************************************************************************
 * Copyright (c) 2022, 2023 Alessio Di Sandro.
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
   * Statistics to keep track of SAT calls and time.
   */
  public record SATStats(long time, int numCalls) {
    public SATStats(long time, int numCalls) {
      this.time = Objects.requireNonNull(time);
      this.numCalls = Objects.requireNonNull(numCalls);
    }
  }

  /**
   * Enables or disables the SAT statistics, resetting them in both cases.
   */
  default void toggleStats(boolean enable) {}

  /**
   * Retrieves the SAT statistics.
   *
   * @return The SAT statistics.
   */
  default SATStats getStats() {
    return new SATStats(0, 0);
  }

  /**
   * Gets the TRUE literal.
   *
   * @return The TRUE literal.
   */
  String getTrueLiteral();

  /**
   * Gets the FALSE literal.
   *
   * @return The FALSE literal.
   */
  String getFalseLiteral();

  /**
   * Gets the syntax of the OR operator, using $1 and $2 as placeholders for the two operands.
   *
   * @return The OR syntax.
   */
  String getORSyntax();

  /**
   * Simplifies a boolean formula.
   *
   * @param formula
   *          The boolean formula to be simplified.
   * @return The simplified formula.
   */
  default String simplify(String formula) {
    return formula;
  }
}
