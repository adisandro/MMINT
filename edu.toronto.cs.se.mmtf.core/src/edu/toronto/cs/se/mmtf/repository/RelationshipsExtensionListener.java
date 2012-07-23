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
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;

/**
 * A listener for dynamic installation/unistallation of extensions to the
 * Relationships extension point.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipsExtensionListener extends MMTFExtensionListener {

	/**
	 * Constructor: initializes the MMTF instance.
	 * 
	 * @param mmtf
	 *            The MMTF instance.
	 */
	public RelationshipsExtensionListener(MMTF mmtf) {

		super(mmtf);
	}

	/**
	 * {@inheritDoc}
	 * Installs a new Relationships extension.
	 */
	@Override
	public void added(IExtension[] extensions) {

		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				mmtf.createModelRelType(elem);
				mmtf.setSupertypes();
				MMTF.initTypeHierarchy();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * Uninstalls a Relationships extension.
	 */
	@Override
	public void removed(IExtension[] extensions) {

		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				String uri = elem.getAttribute(MMTF.EXTENDIBLEELEMENT_ATTR_URI);
				MMTFRegistry.removeModelType(uri);
				MMTF.initTypeHierarchy();
			}
		}
	}

}
