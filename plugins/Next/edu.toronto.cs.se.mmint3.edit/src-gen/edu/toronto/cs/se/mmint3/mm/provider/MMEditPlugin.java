/**
 */
package edu.toronto.cs.se.mmint3.mm.provider;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the MM edit plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public final class MMEditPlugin extends EMFPlugin {
  /**
   * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static final MMEditPlugin INSTANCE = new MMEditPlugin();

  /**
   * Keep track of the singleton. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  private static Implementation plugin;

  /**
   * Create the instance. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public MMEditPlugin() {
    super(new ResourceLocator[] {});
  }

  /**
   * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the singleton instance.
   * @generated
   */
  @Override
  public ResourceLocator getPluginResourceLocator() {
    return MMEditPlugin.plugin;
  }

  /**
   * Returns the singleton instance of the Eclipse plugin. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the singleton instance.
   * @generated
   */
  public static Implementation getPlugin() {
    return MMEditPlugin.plugin;
  }

  /**
   * The actual implementation of the Eclipse <b>Plugin</b>. <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated
   */
  public static class Implementation extends EclipsePlugin {
    /**
     * Creates an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Implementation() {
      super();

      // Remember the static instance.
      //
      MMEditPlugin.plugin = this;
    }
  }

}
