/**
 * 
 *   Copyright (c) 2022, 2023 Alessio Di Sandro.
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
package sosym22;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in query.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file query.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package sosym22, the group contains the definition of the following patterns: <ul>
 * <li>dbLockStates</li>
 * <li>damaged</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Query extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Query instance() {
    if (INSTANCE == null) {
        INSTANCE = new Query();
    }
    return INSTANCE;
  }

  private static Query INSTANCE;

  private Query() {
    querySpecifications.add(DbLockStates.instance());
    querySpecifications.add(Damaged.instance());
  }

  public DbLockStates getDbLockStates() {
    return DbLockStates.instance();
  }

  public DbLockStates.Matcher getDbLockStates(final ViatraQueryEngine engine) {
    return DbLockStates.Matcher.on(engine);
  }

  public Damaged getDamaged() {
    return Damaged.instance();
  }

  public Damaged.Matcher getDamaged(final ViatraQueryEngine engine) {
    return Damaged.Matcher.on(engine);
  }
}
