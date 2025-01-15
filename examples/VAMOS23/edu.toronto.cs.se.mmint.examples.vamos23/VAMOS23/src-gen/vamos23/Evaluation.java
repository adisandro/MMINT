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
 * A pattern group formed of all public patterns defined in evaluation.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file evaluation.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package vamos23, the group contains the definition of the following patterns: <ul>
 * <li>publicAttributes</li>
 * <li>subAttributes</li>
 * <li>superAssociations</li>
 * <li>classAssociations</li>
 * <li>leximaxName</li>
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
    querySpecifications.add(PublicAttributes.instance());
    querySpecifications.add(SubAttributes.instance());
    querySpecifications.add(SuperAssociations.instance());
    querySpecifications.add(ClassAssociations.instance());
    querySpecifications.add(LeximaxName.instance());
  }

  public PublicAttributes getPublicAttributes() {
    return PublicAttributes.instance();
  }

  public PublicAttributes.Matcher getPublicAttributes(final ViatraQueryEngine engine) {
    return PublicAttributes.Matcher.on(engine);
  }

  public SubAttributes getSubAttributes() {
    return SubAttributes.instance();
  }

  public SubAttributes.Matcher getSubAttributes(final ViatraQueryEngine engine) {
    return SubAttributes.Matcher.on(engine);
  }

  public SuperAssociations getSuperAssociations() {
    return SuperAssociations.instance();
  }

  public SuperAssociations.Matcher getSuperAssociations(final ViatraQueryEngine engine) {
    return SuperAssociations.Matcher.on(engine);
  }

  public ClassAssociations getClassAssociations() {
    return ClassAssociations.instance();
  }

  public ClassAssociations.Matcher getClassAssociations(final ViatraQueryEngine engine) {
    return ClassAssociations.Matcher.on(engine);
  }

  public LeximaxName getLeximaxName() {
    return LeximaxName.instance();
  }

  public LeximaxName.Matcher getLeximaxName(final ViatraQueryEngine engine) {
    return LeximaxName.Matcher.on(engine);
  }
}
