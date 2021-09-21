/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.productline/src/edu/toronto/cs/se/mmint/productline/viatra/pl.vql
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
 * <li>connection</li>
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
    querySpecifications.add(Connection.instance());
  }
  
  public ClassType getClassType() {
    return ClassType.instance();
  }
  
  public ClassType.Matcher getClassType(final ViatraQueryEngine engine) {
    return ClassType.Matcher.on(engine);
  }
  
  public Connection getConnection() {
    return Connection.instance();
  }
  
  public Connection.Matcher getConnection(final ViatraQueryEngine engine) {
    return Connection.Matcher.on(engine);
  }
}
