/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.jase20.paper/src/jase20/iso26262.vql
 */
package jase20;

import jase20.A1;
import jase20.A2;
import jase20.B;
import jase20.C;
import jase20.C_rulesASILA;
import jase20.C_rulesASILB;
import jase20.C_rulesASILC;
import jase20.C_rulesASILD;
import jase20.C_rulesASILQM;
import jase20.D;
import jase20.E;
import jase20.E_eventASIL;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in iso26262.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file iso26262.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package jase20, the group contains the definition of the following patterns: <ul>
 * <li>a1</li>
 * <li>a2</li>
 * <li>b</li>
 * <li>c_rulesASILQM</li>
 * <li>c_rulesASILA</li>
 * <li>c_rulesASILB</li>
 * <li>c_rulesASILC</li>
 * <li>c_rulesASILD</li>
 * <li>c</li>
 * <li>d</li>
 * <li>e_eventASIL</li>
 * <li>e</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Iso26262 extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Iso26262 instance() {
    if (INSTANCE == null) {
        INSTANCE = new Iso26262();
    }
    return INSTANCE;
  }
  
  private static Iso26262 INSTANCE;
  
  private Iso26262() {
    querySpecifications.add(A1.instance());
    querySpecifications.add(A2.instance());
    querySpecifications.add(B.instance());
    querySpecifications.add(C_rulesASILQM.instance());
    querySpecifications.add(C_rulesASILA.instance());
    querySpecifications.add(C_rulesASILB.instance());
    querySpecifications.add(C_rulesASILC.instance());
    querySpecifications.add(C_rulesASILD.instance());
    querySpecifications.add(C.instance());
    querySpecifications.add(D.instance());
    querySpecifications.add(E_eventASIL.instance());
    querySpecifications.add(E.instance());
  }
  
  public A1 getA1() {
    return A1.instance();
  }
  
  public A1.Matcher getA1(final ViatraQueryEngine engine) {
    return A1.Matcher.on(engine);
  }
  
  public A2 getA2() {
    return A2.instance();
  }
  
  public A2.Matcher getA2(final ViatraQueryEngine engine) {
    return A2.Matcher.on(engine);
  }
  
  public B getB() {
    return B.instance();
  }
  
  public B.Matcher getB(final ViatraQueryEngine engine) {
    return B.Matcher.on(engine);
  }
  
  public C_rulesASILQM getC_rulesASILQM() {
    return C_rulesASILQM.instance();
  }
  
  public C_rulesASILQM.Matcher getC_rulesASILQM(final ViatraQueryEngine engine) {
    return C_rulesASILQM.Matcher.on(engine);
  }
  
  public C_rulesASILA getC_rulesASILA() {
    return C_rulesASILA.instance();
  }
  
  public C_rulesASILA.Matcher getC_rulesASILA(final ViatraQueryEngine engine) {
    return C_rulesASILA.Matcher.on(engine);
  }
  
  public C_rulesASILB getC_rulesASILB() {
    return C_rulesASILB.instance();
  }
  
  public C_rulesASILB.Matcher getC_rulesASILB(final ViatraQueryEngine engine) {
    return C_rulesASILB.Matcher.on(engine);
  }
  
  public C_rulesASILC getC_rulesASILC() {
    return C_rulesASILC.instance();
  }
  
  public C_rulesASILC.Matcher getC_rulesASILC(final ViatraQueryEngine engine) {
    return C_rulesASILC.Matcher.on(engine);
  }
  
  public C_rulesASILD getC_rulesASILD() {
    return C_rulesASILD.instance();
  }
  
  public C_rulesASILD.Matcher getC_rulesASILD(final ViatraQueryEngine engine) {
    return C_rulesASILD.Matcher.on(engine);
  }
  
  public C getC() {
    return C.instance();
  }
  
  public C.Matcher getC(final ViatraQueryEngine engine) {
    return C.Matcher.on(engine);
  }
  
  public D getD() {
    return D.instance();
  }
  
  public D.Matcher getD(final ViatraQueryEngine engine) {
    return D.Matcher.on(engine);
  }
  
  public E_eventASIL getE_eventASIL() {
    return E_eventASIL.instance();
  }
  
  public E_eventASIL.Matcher getE_eventASIL(final ViatraQueryEngine engine) {
    return E_eventASIL.Matcher.on(engine);
  }
  
  public E getE() {
    return E.instance();
  }
  
  public E.Matcher getE(final ViatraQueryEngine engine) {
    return E.Matcher.on(engine);
  }
}
