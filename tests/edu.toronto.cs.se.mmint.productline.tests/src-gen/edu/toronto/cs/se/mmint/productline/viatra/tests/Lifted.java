/**
 * 
 *   Copyright (c) 2022, 2024 Alessio Di Sandro.
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
package edu.toronto.cs.se.mmint.productline.viatra.tests;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in lifted.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file lifted.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package edu.toronto.cs.se.mmint.productline.viatra.tests, the group contains the definition of the following patterns: <ul>
 * <li>multipleInheritancePL</li>
 * <li>testAttributePL</li>
 * <li>testAttribute2PL</li>
 * <li>testMultipleEdgesPL</li>
 * <li>asilBConnectedClassesPL</li>
 * <li>highlyConnectedModelObjsPL</li>
 * <li>testMinPL</li>
 * <li>testMaxPL</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Lifted extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Lifted instance() {
    if (INSTANCE == null) {
        INSTANCE = new Lifted();
    }
    return INSTANCE;
  }

  private static Lifted INSTANCE;

  private Lifted() {
    querySpecifications.add(MultipleInheritancePL.instance());
    querySpecifications.add(TestAttributePL.instance());
    querySpecifications.add(TestAttribute2PL.instance());
    querySpecifications.add(TestMultipleEdgesPL.instance());
    querySpecifications.add(AsilBConnectedClassesPL.instance());
    querySpecifications.add(HighlyConnectedModelObjsPL.instance());
    querySpecifications.add(TestMinPL.instance());
    querySpecifications.add(TestMaxPL.instance());
  }

  public MultipleInheritancePL getMultipleInheritancePL() {
    return MultipleInheritancePL.instance();
  }

  public MultipleInheritancePL.Matcher getMultipleInheritancePL(final ViatraQueryEngine engine) {
    return MultipleInheritancePL.Matcher.on(engine);
  }

  public TestAttributePL getTestAttributePL() {
    return TestAttributePL.instance();
  }

  public TestAttributePL.Matcher getTestAttributePL(final ViatraQueryEngine engine) {
    return TestAttributePL.Matcher.on(engine);
  }

  public TestAttribute2PL getTestAttribute2PL() {
    return TestAttribute2PL.instance();
  }

  public TestAttribute2PL.Matcher getTestAttribute2PL(final ViatraQueryEngine engine) {
    return TestAttribute2PL.Matcher.on(engine);
  }

  public TestMultipleEdgesPL getTestMultipleEdgesPL() {
    return TestMultipleEdgesPL.instance();
  }

  public TestMultipleEdgesPL.Matcher getTestMultipleEdgesPL(final ViatraQueryEngine engine) {
    return TestMultipleEdgesPL.Matcher.on(engine);
  }

  public AsilBConnectedClassesPL getAsilBConnectedClassesPL() {
    return AsilBConnectedClassesPL.instance();
  }

  public AsilBConnectedClassesPL.Matcher getAsilBConnectedClassesPL(final ViatraQueryEngine engine) {
    return AsilBConnectedClassesPL.Matcher.on(engine);
  }

  public HighlyConnectedModelObjsPL getHighlyConnectedModelObjsPL() {
    return HighlyConnectedModelObjsPL.instance();
  }

  public HighlyConnectedModelObjsPL.Matcher getHighlyConnectedModelObjsPL(final ViatraQueryEngine engine) {
    return HighlyConnectedModelObjsPL.Matcher.on(engine);
  }

  public TestMinPL getTestMinPL() {
    return TestMinPL.instance();
  }

  public TestMinPL.Matcher getTestMinPL(final ViatraQueryEngine engine) {
    return TestMinPL.Matcher.on(engine);
  }

  public TestMaxPL getTestMaxPL() {
    return TestMaxPL.instance();
  }

  public TestMaxPL.Matcher getTestMaxPL(final ViatraQueryEngine engine) {
    return TestMaxPL.Matcher.on(engine);
  }
}
