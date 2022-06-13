/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.productline.tests/src/edu/toronto/cs/se/mmint/productline/viatra/tests/orig.vql
 */
package edu.toronto.cs.se.mmint.productline.viatra.tests;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in orig.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file orig.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package edu.toronto.cs.se.mmint.productline.viatra.tests, the group contains the definition of the following patterns: <ul>
 * <li>multipleInheritanceCD</li>
 * <li>testAttributeCD</li>
 * <li>testAttribute2CD</li>
 * <li>testMultipleEdgesCD</li>
 * <li>asilBConnectedClassesCD</li>
 * <li>highlyConnectedModelObjsCD</li>
 * <li>testMinCD</li>
 * <li>testMaxCD</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Orig extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Orig instance() {
    if (INSTANCE == null) {
        INSTANCE = new Orig();
    }
    return INSTANCE;
  }

  private static Orig INSTANCE;

  private Orig() {
    querySpecifications.add(MultipleInheritanceCD.instance());
    querySpecifications.add(TestAttributeCD.instance());
    querySpecifications.add(TestAttribute2CD.instance());
    querySpecifications.add(TestMultipleEdgesCD.instance());
    querySpecifications.add(AsilBConnectedClassesCD.instance());
    querySpecifications.add(HighlyConnectedModelObjsCD.instance());
    querySpecifications.add(TestMinCD.instance());
    querySpecifications.add(TestMaxCD.instance());
  }

  public MultipleInheritanceCD getMultipleInheritanceCD() {
    return MultipleInheritanceCD.instance();
  }

  public MultipleInheritanceCD.Matcher getMultipleInheritanceCD(final ViatraQueryEngine engine) {
    return MultipleInheritanceCD.Matcher.on(engine);
  }

  public TestAttributeCD getTestAttributeCD() {
    return TestAttributeCD.instance();
  }

  public TestAttributeCD.Matcher getTestAttributeCD(final ViatraQueryEngine engine) {
    return TestAttributeCD.Matcher.on(engine);
  }

  public TestAttribute2CD getTestAttribute2CD() {
    return TestAttribute2CD.instance();
  }

  public TestAttribute2CD.Matcher getTestAttribute2CD(final ViatraQueryEngine engine) {
    return TestAttribute2CD.Matcher.on(engine);
  }

  public TestMultipleEdgesCD getTestMultipleEdgesCD() {
    return TestMultipleEdgesCD.instance();
  }

  public TestMultipleEdgesCD.Matcher getTestMultipleEdgesCD(final ViatraQueryEngine engine) {
    return TestMultipleEdgesCD.Matcher.on(engine);
  }

  public AsilBConnectedClassesCD getAsilBConnectedClassesCD() {
    return AsilBConnectedClassesCD.instance();
  }

  public AsilBConnectedClassesCD.Matcher getAsilBConnectedClassesCD(final ViatraQueryEngine engine) {
    return AsilBConnectedClassesCD.Matcher.on(engine);
  }

  public HighlyConnectedModelObjsCD getHighlyConnectedModelObjsCD() {
    return HighlyConnectedModelObjsCD.instance();
  }

  public HighlyConnectedModelObjsCD.Matcher getHighlyConnectedModelObjsCD(final ViatraQueryEngine engine) {
    return HighlyConnectedModelObjsCD.Matcher.on(engine);
  }

  public TestMinCD getTestMinCD() {
    return TestMinCD.instance();
  }

  public TestMinCD.Matcher getTestMinCD(final ViatraQueryEngine engine) {
    return TestMinCD.Matcher.on(engine);
  }

  public TestMaxCD getTestMaxCD() {
    return TestMaxCD.instance();
  }

  public TestMaxCD.Matcher getTestMaxCD(final ViatraQueryEngine engine) {
    return TestMaxCD.Matcher.on(engine);
  }
}
