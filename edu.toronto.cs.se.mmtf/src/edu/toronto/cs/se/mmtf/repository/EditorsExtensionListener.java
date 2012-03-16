package edu.toronto.cs.se.mmtf.repository;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;

import edu.toronto.cs.se.mmtf.MMTF;

public class EditorsExtensionListener extends MMTFExtensionListener {

	public EditorsExtensionListener(MMTF mmtf) {

		super(mmtf);
	}

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
