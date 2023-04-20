/**
 * 
 *   Copyright (c) 2023, 2023 Alessio Di Sandro.
 *  
 *   This program and the accompanying materials are made available under the
 *   terms of the Eclipse Public License 2.0 which is available at
 *   https://www.eclipse.org/legal/epl-2.0/
 *  
 *   SPDX-License-Identifier: EPL-2.0
 *  
 *   Contributors:
 *       Alessio Di Sandro - Implementation
 *  
 */
package splc23;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in evaluation.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file evaluation.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package splc23, the group contains the definition of the following patterns: <ul>
 * <li>numClasses</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Evaluation extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Evaluation instance() {
    if (INSTANCE == null) {
        INSTANCE = new Evaluation();
    }
    return INSTANCE;
  }

  private static Evaluation INSTANCE;

  private Evaluation() {
    querySpecifications.add(NumClasses.instance());
  }

  public NumClasses getNumClasses() {
    return NumClasses.instance();
  }

  public NumClasses.Matcher getNumClasses(final ViatraQueryEngine engine) {
    return NumClasses.Matcher.on(engine);
  }
}
