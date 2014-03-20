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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelHeavyTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;

/**
 * A listener for dynamic installation/unistallation of extensions to the
 * Models extension point.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelsExtensionListener extends MMINTExtensionListener {

	/**
	 * {@inheritDoc}
	 * Installs a new Models extension.
	 */
	@Override
	public void added(IExtension[] extensions) {

		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				Model modelType = MMINT.createModelType(elem);
				MultiModelHeavyTypeFactory.createHeavyModelTypeEditors(modelType);
			}
		}
		MMINT.storeRepository();
	}

	/**
	 * {@inheritDoc}
	 * Uninstalls a Models extension.
	 */
	@Override
	public void removed(IExtension[] extensions) {

		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				String uri = elem.getAttribute(MMINT.TYPE_ATTR_URI);
				Model modelType = MultiModelTypeRegistry.getType(uri);
				if (modelType != null) {
					try {
						modelType.deleteType();
					}
					catch (MMINTException e) {
						// never happens by construction
					}
				}
			}
		}
		MMINT.storeRepository();
	}

}
