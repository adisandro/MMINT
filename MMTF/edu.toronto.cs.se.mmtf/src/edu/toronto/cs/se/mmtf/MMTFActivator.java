/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class that controls the plug-in life cycle.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MMTFActivator extends AbstractUIPlugin {

	/** The plug-in ID. */
	public static final String PLUGIN_ID = "edu.toronto.cs.se.mmtf"; //$NON-NLS-1$

	/** The shared instance. */
	private static MMTFActivator plugin;

	/**
	 * The constructor.
	 */
	public MMTFActivator() {
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		@SuppressWarnings("unused")
		MMTF mmtf = MMTF.INSTANCE;
	}

	/**
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 *
	 * @return The shared instance.
	 */
	public static MMTFActivator getDefault() {
		return plugin;
	}

}
