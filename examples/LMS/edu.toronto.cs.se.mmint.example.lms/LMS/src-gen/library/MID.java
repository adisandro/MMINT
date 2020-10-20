/**
 * Generated from platform:/resource/LMS/src/library/MID.vql
 */
package library;

import library.AllConnectedEMFObjects;
import library.AllConnectedModelElems;
import library.ConnectedEMFObjects;
import library.ConnectedModelElems;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in MID.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file MID.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package library, the group contains the definition of the following patterns: <ul>
 * <li>connectedModelElems</li>
 * <li>connectedEMFObjects</li>
 * <li>allConnectedModelElems</li>
 * <li>allConnectedEMFObjects</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class MID extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static MID instance() {
    if (INSTANCE == null) {
        INSTANCE = new MID();
    }
    return INSTANCE;
  }
  
  private static MID INSTANCE;
  
  private MID() {
    querySpecifications.add(ConnectedModelElems.instance());
    querySpecifications.add(ConnectedEMFObjects.instance());
    querySpecifications.add(AllConnectedModelElems.instance());
    querySpecifications.add(AllConnectedEMFObjects.instance());
  }
  
  public ConnectedModelElems getConnectedModelElems() {
    return ConnectedModelElems.instance();
  }
  
  public ConnectedModelElems.Matcher getConnectedModelElems(final ViatraQueryEngine engine) {
    return ConnectedModelElems.Matcher.on(engine);
  }
  
  public ConnectedEMFObjects getConnectedEMFObjects() {
    return ConnectedEMFObjects.instance();
  }
  
  public ConnectedEMFObjects.Matcher getConnectedEMFObjects(final ViatraQueryEngine engine) {
    return ConnectedEMFObjects.Matcher.on(engine);
  }
  
  public AllConnectedModelElems getAllConnectedModelElems() {
    return AllConnectedModelElems.instance();
  }
  
  public AllConnectedModelElems.Matcher getAllConnectedModelElems(final ViatraQueryEngine engine) {
    return AllConnectedModelElems.Matcher.on(engine);
  }
  
  public AllConnectedEMFObjects getAllConnectedEMFObjects() {
    return AllConnectedEMFObjects.instance();
  }
  
  public AllConnectedEMFObjects.Matcher getAllConnectedEMFObjects(final ViatraQueryEngine engine) {
    return AllConnectedEMFObjects.Matcher.on(engine);
  }
}
