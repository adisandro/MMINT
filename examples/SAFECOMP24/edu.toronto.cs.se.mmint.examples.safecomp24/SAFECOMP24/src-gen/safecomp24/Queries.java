/**
 * 
 *   Copyright (c) 2024, 2024 Alessio Di Sandro.
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
package safecomp24;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in queries.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file queries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package safecomp24, the group contains the definition of the following patterns: <ul>
 * <li>numInvalidElems</li>
 * <li>invalidElems</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Queries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Queries instance() {
    if (INSTANCE == null) {
        INSTANCE = new Queries();
    }
    return INSTANCE;
  }

  private static Queries INSTANCE;

  private Queries() {
    querySpecifications.add(NumInvalidElems.instance());
    querySpecifications.add(InvalidElems.instance());
  }

  public NumInvalidElems getNumInvalidElems() {
    return NumInvalidElems.instance();
  }

  public NumInvalidElems.Matcher getNumInvalidElems(final ViatraQueryEngine engine) {
    return NumInvalidElems.Matcher.on(engine);
  }

  public InvalidElems getInvalidElems() {
    return InvalidElems.instance();
  }

  public InvalidElems.Matcher getInvalidElems(final ViatraQueryEngine engine) {
    return InvalidElems.Matcher.on(engine);
  }
}
