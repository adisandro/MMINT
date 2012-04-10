/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;

import edu.toronto.cs.se.mmtf.MMTF;

/**
 * A listener for dynamic installation/unistallation of extensions to the
 * Editors extension point.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class EditorsExtensionListener extends MMTFExtensionListener {

	/**
	 * Constructor: initializes the MMTF instance.
	 * 
	 * @param mmtf
	 *            The MMTF instance.
	 */
	public EditorsExtensionListener(MMTF mmtf) {

		super(mmtf);
	}

	/**
	 * {@inheritDoc}
	 * Installs a new Editors extension.
	 */
	@Override
	public void added(IExtension[] extensions) {

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry == null) {
			return;
		}

		IConfigurationElement[] config;
		Editor editor;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				editor = mmtf.addEditor(elem);
				mmtf.addMetamodelEditors(editor);
				mmtf.addEditorFilenames(registry, editor);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * Uninstalls a Editors extension.
	 */
	@Override
	public void removed(IExtension[] extensions) {

		IConfigurationElement[] config;
		for (IExtension extension : extensions) {
			config = extension.getConfigurationElements();
			for (IConfigurationElement elem : config) {
				mmtf.removeEditor(elem);
			}
		}
	}

}
