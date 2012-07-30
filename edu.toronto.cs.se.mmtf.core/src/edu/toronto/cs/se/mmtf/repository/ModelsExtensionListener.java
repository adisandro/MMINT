/**
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeRegistry;

/**
 * A listener for dynamic installation/unistallation of extensions to the
 * Models extension point.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelsExtensionListener extends MMTFExtensionListener {

	/**
	 * Constructor: initializes the MMTF instance.
	 * 
	 * @param mmtf
	 *            The MMTF instance.
	 */
	public ModelsExtensionListener(MMTF mmtf) {

		super(mmtf);
	}

	/**
	 * {@inheritDoc}
	 * Installs a new Models extension.
	 */
	@Override
	public void added(IExtension[] extensions) {

		IConfigurationElement[] config;
		Model model;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				model = mmtf.createModelType(elem);
				mmtf.addModelTypeEditors(model);
				mmtf.setSupertypes();
				MMTF.initTypeHierarchy();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * Uninstalls a Models extension.
	 */
	@Override
	public void removed(IExtension[] extensions) {

		MultiModel multiModel;
		try {
			multiModel = MultiModelTypeRegistry.getTypeMidRepository();
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Could not locate Type MID", e);
			return;
		}

		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				String uri = elem.getAttribute(MMTF.EXTENDIBLEELEMENT_ATTR_URI);
				Model modelType = MultiModelTypeRegistry.getModelType(multiModel, uri);
				if (modelType != null) {
					MultiModelTypeFactory.removeModelType(modelType);
					MultiModelTypeFactory.syncRepository(multiModel);
				}
			}
		}
	}

}
