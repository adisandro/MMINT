/**
 * 
 *   Copyright (c) 2021, 2021 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.viatra;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in pl.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file pl.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package edu.toronto.cs.se.mmint.productline.viatra, the group contains the definition of the following patterns: <ul>
 * <li>classType</li>
 * <li>reference</li>
 * <li>attribute</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Pl extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Pl instance() {
    if (INSTANCE == null) {
        INSTANCE = new Pl();
    }
    return INSTANCE;
  }
  
  private static Pl INSTANCE;
  
  private Pl() {
    querySpecifications.add(ClassType.instance());
    querySpecifications.add(Reference.instance());
    querySpecifications.add(Attribute.instance());
  }
  
  public ClassType getClassType() {
    return ClassType.instance();
  }
  
  public ClassType.Matcher getClassType(final ViatraQueryEngine engine) {
    return ClassType.Matcher.on(engine);
  }
  
  public Reference getReference() {
    return Reference.instance();
  }
  
  public Reference.Matcher getReference(final ViatraQueryEngine engine) {
    return Reference.Matcher.on(engine);
  }
  
  public Attribute getAttribute() {
    return Attribute.instance();
  }
  
  public Attribute.Matcher getAttribute(final ViatraQueryEngine engine) {
    return Attribute.Matcher.on(engine);
  }
}
