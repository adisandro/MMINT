/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.jase20.paper/src/jase20/iso26262.vql
 */
package jase20;

import jase20.B;
import jase20.C;
import jase20.D;
import jase20.E;
import jase20.E_asil;
import jase20.QueryC_A;
import jase20.QueryC_B;
import jase20.QueryC_C;
import jase20.QueryC_D;
import jase20.QueryC_QM;
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
 * <li>b</li>
 * <li>queryC_QM</li>
 * <li>queryC_A</li>
 * <li>queryC_B</li>
 * <li>queryC_C</li>
 * <li>queryC_D</li>
 * <li>c</li>
 * <li>d</li>
 * <li>e_asil</li>
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
    querySpecifications.add(B.instance());
    querySpecifications.add(QueryC_QM.instance());
    querySpecifications.add(QueryC_A.instance());
    querySpecifications.add(QueryC_B.instance());
    querySpecifications.add(QueryC_C.instance());
    querySpecifications.add(QueryC_D.instance());
    querySpecifications.add(C.instance());
    querySpecifications.add(D.instance());
    querySpecifications.add(E_asil.instance());
    querySpecifications.add(E.instance());
  }
  
  public B getB() {
    return B.instance();
  }
  
  public B.Matcher getB(final ViatraQueryEngine engine) {
    return B.Matcher.on(engine);
  }
  
  public QueryC_QM getQueryC_QM() {
    return QueryC_QM.instance();
  }
  
  public QueryC_QM.Matcher getQueryC_QM(final ViatraQueryEngine engine) {
    return QueryC_QM.Matcher.on(engine);
  }
  
  public QueryC_A getQueryC_A() {
    return QueryC_A.instance();
  }
  
  public QueryC_A.Matcher getQueryC_A(final ViatraQueryEngine engine) {
    return QueryC_A.Matcher.on(engine);
  }
  
  public QueryC_B getQueryC_B() {
    return QueryC_B.instance();
  }
  
  public QueryC_B.Matcher getQueryC_B(final ViatraQueryEngine engine) {
    return QueryC_B.Matcher.on(engine);
  }
  
  public QueryC_C getQueryC_C() {
    return QueryC_C.instance();
  }
  
  public QueryC_C.Matcher getQueryC_C(final ViatraQueryEngine engine) {
    return QueryC_C.Matcher.on(engine);
  }
  
  public QueryC_D getQueryC_D() {
    return QueryC_D.instance();
  }
  
  public QueryC_D.Matcher getQueryC_D(final ViatraQueryEngine engine) {
    return QueryC_D.Matcher.on(engine);
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
  
  public E_asil getE_asil() {
    return E_asil.instance();
  }
  
  public E_asil.Matcher getE_asil(final ViatraQueryEngine engine) {
    return E_asil.Matcher.on(engine);
  }
  
  public E getE() {
    return E.instance();
  }
  
  public E.Matcher getE(final ViatraQueryEngine engine) {
    return E.Matcher.on(engine);
  }
}
