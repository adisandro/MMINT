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
import org.eclipse.emf.common.util.URI;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFActivator;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

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
		MultiModel root = null;
		try {			
			String path = MMTFActivator.getDefault().getStateLocation().toOSString();
			URI uri = URI.createFileURI(path+"/types.mid");
			root = (MultiModel) MultiModelTypeIntrospection.getRoot(uri);
		}
		catch (Exception e) {
			return;
		}
		
		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				String uri = elem.getAttribute(MMTF.EXTENDIBLEELEMENT_ATTR_URI);
				MMTFRegistry.removeModelType((Model)root.getExtendibleTable().get(uri));
				MMTFRegistry.updateRepository(root);
			}
		}
	}

}
