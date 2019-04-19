/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.viatra/src/edu/toronto/cs/se/mmint/viatra/mid/mid.vql
 */
package edu.toronto.cs.se.mmint.viatra.mid;

import edu.toronto.cs.se.mmint.viatra.mid.ConnectedModelElements;
import edu.toronto.cs.se.mmint.viatra.mid.ConnectedModels;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in mid.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file mid.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package edu.toronto.cs.se.mmint.viatra.mid, the group contains the definition of the following patterns: <ul>
 * <li>connectedModels</li>
 * <li>connectedModelElements</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Mid extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Mid instance() {
    if (INSTANCE == null) {
        INSTANCE = new Mid();
    }
    return INSTANCE;
  }
  
  private static Mid INSTANCE;
  
  private Mid() {
    querySpecifications.add(ConnectedModels.instance());
    querySpecifications.add(ConnectedModelElements.instance());
  }
  
  public ConnectedModels getConnectedModels() {
    return ConnectedModels.instance();
  }
  
  public ConnectedModels.Matcher getConnectedModels(final ViatraQueryEngine engine) {
    return ConnectedModels.Matcher.on(engine);
  }
  
  public ConnectedModelElements getConnectedModelElements() {
    return ConnectedModelElements.instance();
  }
  
  public ConnectedModelElements.Matcher getConnectedModelElements(final ViatraQueryEngine engine) {
    return ConnectedModelElements.Matcher.on(engine);
  }
}
