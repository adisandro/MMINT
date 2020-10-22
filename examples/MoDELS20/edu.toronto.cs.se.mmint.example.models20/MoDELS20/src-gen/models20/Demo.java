/**
 * Generated from platform:/resource/MoDELS20/src/models20/demo.vql
 */
package models20;

import models20.Alarms;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in demo.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file demo.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package models20, the group contains the definition of the following patterns: <ul>
 * <li>alarms</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Demo extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Demo instance() {
    if (INSTANCE == null) {
        INSTANCE = new Demo();
    }
    return INSTANCE;
  }
  
  private static Demo INSTANCE;
  
  private Demo() {
    querySpecifications.add(Alarms.instance());
  }
  
  public Alarms getAlarms() {
    return Alarms.instance();
  }
  
  public Alarms.Matcher getAlarms(final ViatraQueryEngine engine) {
    return Alarms.Matcher.on(engine);
  }
}
