package edu.toronto.cs.se.mmint3;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class for the main MMINT plugin.
 * @author Alessio Di Sandro
 */
public class MMINTActivator extends AbstractUIPlugin {

  /** The plugin ID. */
  public static final String PLUGIN_ID = "edu.toronto.cs.se.mmint"; //$NON-NLS-1$
  /** A reference to this plugin, to extract info from it. */
  private static MMINTActivator plugin;


  /**
   * Starts this plugin, stores a reference to it, initializes MMINT and works around bug 467000.
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    MMINTActivator.plugin = this;
    @SuppressWarnings("unused")
    var mmint = MMINT.INSTANCE; // invokes MMINT's constructor
    //TODO MMINT[MISC] Remove when fixed upstream
    System.setProperty("eclipse.workaround.bug467000", "true");
  }

  /**
   * Stops this plugin and removes the reference to it.
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    super.stop(context);
    MMINTActivator.plugin = null;
  }

  /**
   * Gets the reference to this plugin, to extract info from it.
   * @return The reference to this plugin.
   */
  public static MMINTActivator getDefault() {
    return MMINTActivator.plugin;
  }
}
