/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.repository;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.reasoning.IReasoningEngine;

/**
 * A listener for dynamic installation/unistallation of extensions to the
 * Reasoners extension point.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ReasonersExtensionListener extends MMINTExtensionListener {

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
					MMINTException.print(Type.ERROR, "Reasoner can't be created in " + config.getContributor().getName(), e);
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
				String reasonerClass = config.getAttribute(MMINT.REASONERS_REASONER_ATTR_CLASS);
				IConfigurationElement[] languageConfigs = config.getChildren(MMINT.REASONERS_REASONER_CHILD_LANGUAGE);
				for (IConfigurationElement languageConfig : languageConfigs) {
					String languageId = languageConfig.getAttribute(MMINT.REASONERS_REASONER_LANGUAGE_ATTR_ID);
					IReasoningEngine reasonerToRemove = null;
					for (IReasoningEngine reasoner : MMINT.getLanguageReasoners(languageId)) {
						if (reasonerClass.equals(reasoner.getClass().getName())) {
							reasonerToRemove = reasoner;
							break;
						}
					}
					MMINT.getLanguageReasoners(languageId).remove(reasonerToRemove);
				}
			}
		}
	}

}
