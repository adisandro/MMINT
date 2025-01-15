/*******************************************************************************
 * Copyright (c) 2022, 2025 Alessio Di Sandro.
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
   * Gets the syntax of the AND operator, using $1 and $2 as placeholders for the two operands.
   *
   * @return The AND syntax.
   */
  String getANDSyntax();

  /**
   * Gets the syntax of the OR operator, using $1 and $2 as placeholders for the two operands.
   *
   * @return The OR syntax.
   */
  String getORSyntax();

  /**
   * Gets the syntax of the NOT operator, using $1 as placeholder for the operand.
   *
   * @return The NOT syntax.
   */
  String getNOTSyntax();

  /**
   * Gets the syntax of the Implication operator, using $1 and $2 as placeholders for the two operands.
   *
   * @return The Implication syntax.
   */
  String getIMPLYSyntax();

  /**
   * Gets the syntax of the Equivalence operator, using $1 and $2 as placeholders for the two operands.
   *
   * @return The Equivalence syntax.
   */
  String getEQUIVSyntax();

  /**
   * Creates a new formula by joining two formulas with some specified syntax.
   *
   * @param syntax
   *          The syntax to join the two formulas, using $1 and $2 as placeholders for the two operands.
   * @param formula1
   *          The first formula to be joined.
   * @param formula2
   *          The second formula to be joined.
   * @return The formula joined using the specified syntax.
   */
  private String join(String syntax, String formula1, String formula2) {
    return syntax.replace("$1", formula1).replace("$2", formula2);
  }

  /**
   * Creates a new formula by joining two formulas with the AND operator.
   *
   * @param formula1
   *          The first formula to be joined.
   * @param formula2
   *          The second formula to be joined.
   * @return The formula joined using the AND operator.
   */
  default String and(String formula1, String formula2) {
    return join(getANDSyntax(), formula1, formula2);
  }

  /**
   * Creates a new formula by joining two formulas with the OR operator.
   *
   * @param formula1
   *          The first formula to be joined.
   * @param formula2
   *          The second formula to be joined.
   * @return The formula joined using the OR operator.
   */
  default String or(String formula1, String formula2) {
    return join(getORSyntax(), formula1, formula2);
  }

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
