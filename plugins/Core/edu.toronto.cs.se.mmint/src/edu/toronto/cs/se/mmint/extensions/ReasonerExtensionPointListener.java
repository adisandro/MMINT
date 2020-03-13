/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;

/**
 * A listener for dynamic installation/unistallation of extensions to the
 * Reasoners extension point.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ReasonerExtensionPointListener extends MMINTExtensionPointListener {

	/**
	 * {@inheritDoc}
	 * Installs a new Reasoners extension.
	 */
	@Override
	public void added(IExtension[] extensions) {

		IConfigurationElement[] configs;
		for (IExtension extension : extensions) {
			configs = extension.getConfigurationElements();
			for (IConfigurationElement config : configs) {
				try {
					MMINT.createReasoner(config);
				}
				catch (CoreException e) {
					MMINTException.print(IStatus.ERROR, "Reasoner can't be created in " + config.getContributor().getName(), e);
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * Uninstalls a Reasoners extension.
	 */
	@Override
	public void removed(IExtension[] extensions) {

		IConfigurationElement[] configs;
		for (IExtension extension : extensions) {
			configs = extension.getConfigurationElements();
			for (IConfigurationElement config : configs) {
				String reasonerName = config.getAttribute(MMINT.REASONERS_REASONER_ATTR_NAME);
				IConfigurationElement[] languageConfigs = config.getChildren(MMINT.REASONERS_REASONER_CHILD_FILE);
				for (IConfigurationElement languageConfig : languageConfigs) {
					String languageId = languageConfig.getAttribute(MMINT.REASONERS_REASONER_FILE_ATTR_EXTENSION);
					MMINT.getReasoners(languageId).remove(reasonerName);
				}
			}
		}
	}

}
