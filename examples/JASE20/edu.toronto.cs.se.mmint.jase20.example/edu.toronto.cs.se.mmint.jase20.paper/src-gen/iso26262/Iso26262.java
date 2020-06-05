/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.jase20.paper/src/iso26262/iso26262.vql
 */
package iso26262;

import iso26262.QueryC;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in iso26262.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file iso26262.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package iso26262, the group contains the definition of the following patterns: <ul>
 * <li>queryC</li>
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
    querySpecifications.add(QueryC.instance());
  }
  
  public QueryC getQueryC() {
    return QueryC.instance();
  }
  
  public QueryC.Matcher getQueryC(final ViatraQueryEngine engine) {
    return QueryC.Matcher.on(engine);
  }
}
