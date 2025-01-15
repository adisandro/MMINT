/**
 * 
 *   Copyright (c) 2022, 2025 Alessio Di Sandro.
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
package vamos23;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in example.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file example.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package vamos23, the group contains the definition of the following patterns: <ul>
 * <li>twoOutgoingTransitions</li>
 * <li>numOutgoingTransitions</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Example extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Example instance() {
    if (INSTANCE == null) {
        INSTANCE = new Example();
    }
    return INSTANCE;
  }

  private static Example INSTANCE;

  private Example() {
    querySpecifications.add(TwoOutgoingTransitions.instance());
    querySpecifications.add(NumOutgoingTransitions.instance());
  }

  public TwoOutgoingTransitions getTwoOutgoingTransitions() {
    return TwoOutgoingTransitions.instance();
  }

  public TwoOutgoingTransitions.Matcher getTwoOutgoingTransitions(final ViatraQueryEngine engine) {
    return TwoOutgoingTransitions.Matcher.on(engine);
  }

  public NumOutgoingTransitions getNumOutgoingTransitions() {
    return NumOutgoingTransitions.instance();
  }

  public NumOutgoingTransitions.Matcher getNumOutgoingTransitions(final ViatraQueryEngine engine) {
    return NumOutgoingTransitions.Matcher.on(engine);
  }
}
