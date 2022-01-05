/**
 * Generated from platform:/resource/edu.toronto.cs.se.mmint.productline.tests/src/edu/toronto/cs/se/mmint/viatra/mid/mid.vql
 */
package edu.toronto.cs.se.mmint.viatra.mid;

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
 * <li>connectedModelElementsWithMapping</li>
 * <li>connectedModelElements</li>
 * <li>connectedEMFObjectsWithMapping</li>
 * <li>connectedEMFObjects</li>
 * <li>allConnectedModels</li>
 * <li>allConnectedModelElements</li>
 * <li>allConnectedEMFObjects</li>
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
    querySpecifications.add(ConnectedModelElementsWithMapping.instance());
    querySpecifications.add(ConnectedModelElements.instance());
    querySpecifications.add(ConnectedEMFObjectsWithMapping.instance());
    querySpecifications.add(ConnectedEMFObjects.instance());
    querySpecifications.add(AllConnectedModels.instance());
    querySpecifications.add(AllConnectedModelElements.instance());
    querySpecifications.add(AllConnectedEMFObjects.instance());
  }
  
  public ConnectedModels getConnectedModels() {
    return ConnectedModels.instance();
  }
  
  public ConnectedModels.Matcher getConnectedModels(final ViatraQueryEngine engine) {
    return ConnectedModels.Matcher.on(engine);
  }
  
  public ConnectedModelElementsWithMapping getConnectedModelElementsWithMapping() {
    return ConnectedModelElementsWithMapping.instance();
  }
  
  public ConnectedModelElementsWithMapping.Matcher getConnectedModelElementsWithMapping(final ViatraQueryEngine engine) {
    return ConnectedModelElementsWithMapping.Matcher.on(engine);
  }
  
  public ConnectedModelElements getConnectedModelElements() {
    return ConnectedModelElements.instance();
  }
  
  public ConnectedModelElements.Matcher getConnectedModelElements(final ViatraQueryEngine engine) {
    return ConnectedModelElements.Matcher.on(engine);
  }
  
  public ConnectedEMFObjectsWithMapping getConnectedEMFObjectsWithMapping() {
    return ConnectedEMFObjectsWithMapping.instance();
  }
  
  public ConnectedEMFObjectsWithMapping.Matcher getConnectedEMFObjectsWithMapping(final ViatraQueryEngine engine) {
    return ConnectedEMFObjectsWithMapping.Matcher.on(engine);
  }
  
  public ConnectedEMFObjects getConnectedEMFObjects() {
    return ConnectedEMFObjects.instance();
  }
  
  public ConnectedEMFObjects.Matcher getConnectedEMFObjects(final ViatraQueryEngine engine) {
    return ConnectedEMFObjects.Matcher.on(engine);
  }
  
  public AllConnectedModels getAllConnectedModels() {
    return AllConnectedModels.instance();
  }
  
  public AllConnectedModels.Matcher getAllConnectedModels(final ViatraQueryEngine engine) {
    return AllConnectedModels.Matcher.on(engine);
  }
  
  public AllConnectedModelElements getAllConnectedModelElements() {
    return AllConnectedModelElements.instance();
  }
  
  public AllConnectedModelElements.Matcher getAllConnectedModelElements(final ViatraQueryEngine engine) {
    return AllConnectedModelElements.Matcher.on(engine);
  }
  
  public AllConnectedEMFObjects getAllConnectedEMFObjects() {
    return AllConnectedEMFObjects.instance();
  }
  
  public AllConnectedEMFObjects.Matcher getAllConnectedEMFObjects(final ViatraQueryEngine engine) {
    return AllConnectedEMFObjects.Matcher.on(engine);
  }
}
