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
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;

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
				editor = mmtf.createEditorType(elem);
				mmtf.setSupertypes();
				mmtf.addModelTypeEditor(editor);
				mmtf.addEditorTypeFileExtensions(registry, editor);
				MMTF.initTypeHierarchy();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * Uninstalls a Editors extension.
	 */
	@Override
	public void removed(IExtension[] extensions) {

		MultiModel multiModel;
		try {
			multiModel = MMTFRegistry.getTypeMidRepository();
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
				Editor editorType = MMTFRegistry.getEditorType(uri);
				if (editorType != null) {
					MMTFRegistry.removeEditorType(editorType);
					MMTFRegistry.syncRepository(multiModel);
				}
			}
		}
	}

}
