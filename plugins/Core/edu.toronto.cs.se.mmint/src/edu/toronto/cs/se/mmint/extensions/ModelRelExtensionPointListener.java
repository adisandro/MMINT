/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.extensions;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * A listener for dynamic installation/unistallation of extensions to the
 * Relationships extension point.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelRelExtensionPointListener extends MMINTExtensionPointListener {

	/**
	 * {@inheritDoc}
	 * Installs a new Relationships extension.
	 */
	@Override
	public void added(IExtension[] extensions) {

		IConfigurationElement[] configs;
		for (IExtension extension : extensions) {
			configs = extension.getConfigurationElements();
			for (IConfigurationElement config : configs) {
				try {
					MMINT.createModelRelType(config);
				}
				catch (Exception e) {
					MMINTException.print(IStatus.ERROR, "Model relationship type can't be created in " + config.getContributor().getName(), e);
				}
			}
		}
		MMINT.writeTypeMID();
	}

	/**
	 * {@inheritDoc}
	 * Uninstalls a Relationships extension.
	 */
	@Override
	public void removed(IExtension[] extensions) {

		IConfigurationElement[] configs;
		for (IExtension extension : extensions) {
			configs = extension.getConfigurationElements();
			for (IConfigurationElement config : configs) {
				String uri = config.getAttribute(MMINT.TYPE_ATTR_URI);
				ModelRel modelRelType = MIDTypeRegistry.getType(uri);
				if (modelRelType != null) {
					try {
						modelRelType.deleteType();
					}
					catch (MMINTException e) {
						// never happens by construction
					}
				}
			}
		}
		MMINT.writeTypeMID();
	}

}
