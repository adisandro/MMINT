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
package edu.toronto.cs.se.mmtf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import edu.toronto.cs.se.mmtf.repository.EcoreExtension;
import edu.toronto.cs.se.mmtf.repository.Editor;
import edu.toronto.cs.se.mmtf.repository.EditorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.Metamodel;
import edu.toronto.cs.se.mmtf.repository.MetamodelsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.Repository;
import edu.toronto.cs.se.mmtf.repository.RepositoryFactory;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryDialogLabelProvider;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryDialogSelectionValidator;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryDialogContentProvider;

/**
 * The Model Management Tool Framework adds the ability to create and manage
 * Model Interconnection Diagrams (MIDs). A MID is a diagram to represent a
 * collection of models (a multimodel) and the relationships among them at a
 * high level of abstraction (mappings). Multimodels can be used to support the
 * development, comprehension, consistency management and evolution of sets of
 * related models
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MMTF {

	/** The Metamodels extension point id. */
	private final static String METAMODELS_EXT_POINT = "edu.toronto.cs.se.mmtf.metamodels";
	/** The Metamodels extension point uri attribute. */
	private final static String METAMODELS_ATTR_URI = "uri";
	/** The Editors extension point id. */
	private final static String EDITORS_EXT_POINT = "edu.toronto.cs.se.mmtf.editors";
	/** The Editors extension point metamodelUri attribute. */
	private final static String EDITORS_ATTR_METAMODEL_URI = "metamodelUri";
	/** The Editors extension point isDiagram attribute. */
	private final static String EDITORS_ATTR_IS_DIAGRAM = "isDiagram";
	/** The Editors extension point editorId attribute. */
	private final static String EDITORS_ATTR_EDITOR_ID = "editorId";
	/** The Editors extension point wizardId attribute. */
	private final static String EDITORS_ATTR_WIZARD_ID = "wizardId";

	/** The Eclipse's Editors extension point id. */
	private final static String ECLIPSE_EDITORS_EXT_POINT = "org.eclipse.ui.editors";
	/** The Eclipse's Editors extension id attribute. */
	private final static String ECLIPSE_EDITORS_ATTR_ID = "id";
	/** The Eclipse's Editors extension extensions attribute. */
	private final static String ECLIPSE_EDITORS_ATTR_EXTENSIONS = "extensions";

	/** The repository of registered extensions. */
	private static Repository repository;

	/**
	 * Adds a metamodel to the repository. Requires the metamodel package to be
	 * registered too through the org.eclipse.emf.ecore.generated_package
	 * extension point.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created metamodel.
	 */
	public Metamodel addMetamodel(IConfigurationElement extensionConfig) {

		Map<String, Object> resourceMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		String uri = extensionConfig.getAttribute(METAMODELS_ATTR_URI);
		Metamodel metamodel = RepositoryFactory.eINSTANCE.createMetamodel();
		EPackage metamodelPackage = EPackage.Registry.INSTANCE.getEPackage(uri);

		metamodel.setName(extensionConfig.getDeclaringExtension().getLabel());
		metamodel.setUri(uri);
		if (metamodelPackage != null) {
			String metamodelPackageName = metamodelPackage.getName();
			metamodel.setFileExtension(metamodelPackageName);
			// possibly register file extension to load resources
			if (!resourceMap.containsKey(metamodelPackageName)) {
				resourceMap.put(metamodelPackageName, new XMIResourceFactoryImpl());
			}
		}
		repository.getMetamodels().put(uri, metamodel);

		return metamodel;
	}
	
	/**
	 * Adds existing editors to a new metamodel.
	 * 
	 * @param metamodel
	 *            The new metamodel.
	 */
	public void addMetamodelEditors(Metamodel metamodel) {

		Editor editor;
		for (Entry<String, Editor> entry : repository.getEditors().entrySet()) {
			editor = entry.getValue();
			if (editor.getMetamodelUri().equals(metamodel.getUri())) {
				metamodel.getEditors().add(editor);
			}
		}
	}

	/**
	 * Removes a metamodel from the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 */
	public void removeMetamodel(IConfigurationElement extensionConfig) {

		String uri = extensionConfig.getAttribute(METAMODELS_ATTR_URI);
		Metamodel metamodel = repository.getMetamodels().removeKey(uri);
		metamodel.getEditors().clear();
	}

	/**
	 * Adds an editor to the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created editor.
	 */
	public Editor addEditor(IConfigurationElement extensionConfig) {

		String metamodelUri = extensionConfig.getAttribute(EDITORS_ATTR_METAMODEL_URI);
		String isDiagram = extensionConfig.getAttribute(EDITORS_ATTR_IS_DIAGRAM);
		String editorId = extensionConfig.getAttribute(EDITORS_ATTR_EDITOR_ID);
		String wizardId = extensionConfig.getAttribute(EDITORS_ATTR_WIZARD_ID);
		Editor editor;

		if (Boolean.parseBoolean(isDiagram)) {
			editor = RepositoryFactory.eINSTANCE.createDiagram();
		}
		else {
			editor = RepositoryFactory.eINSTANCE.createEditor();
		}
		editor.setName(extensionConfig.getDeclaringExtension().getLabel());
		editor.setMetamodelUri(metamodelUri);
		editor.setEditorId(editorId);
		editor.setWizardId(wizardId);
		repository.getEditors().put(editorId, editor);

		return editor;
	}
	
	/**
	 * Adds a new editor to an existing metamodel.
	 * 
	 * @param editor
	 *            The new editor.
	 */
	public void addMetamodelEditors(Editor editor) {

		Metamodel metamodel = repository.getMetamodels().get(editor.getMetamodelUri());
		if (metamodel != null) {
			metamodel.getEditors().add(editor);
		}
	}

	/**
	 * Adds file extensions to a new editor. Requires the editor to be
	 * registered too through the org.eclipse.ui.editors extension point.
	 * 
	 * @param registry
	 *            The Eclipse extension registry.
	 * @param editor
	 *            The new editor.
	 */
	public void addEditorFileExtensions(IExtensionRegistry registry, Editor editor) {

		IConfigurationElement[] config = registry.getConfigurationElementsFor(ECLIPSE_EDITORS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			if (elem.getAttribute(ECLIPSE_EDITORS_ATTR_ID).equals(editor.getEditorId())) {
				for (String fileExtension : elem.getAttribute(ECLIPSE_EDITORS_ATTR_EXTENSIONS).split(",")) {
					editor.getFileExtensions().add(fileExtension);
				}
				break;
			}
		}
	}

	/**
	 * Adds file extensions to all initial editors at once. Requires the editors
	 * to be registered too through the org.eclipse.ui.editors extension point.
	 * 
	 * @param registry
	 *            The Eclipse extension registry.
	 */
	public void addEditorFileExtensions(IExtensionRegistry registry) {

		IConfigurationElement[] config = registry.getConfigurationElementsFor(ECLIPSE_EDITORS_EXT_POINT);
		Editor editor;
		for (IConfigurationElement elem : config) {
			editor = repository.getEditors().get(elem.getAttribute(ECLIPSE_EDITORS_ATTR_ID));
			if (editor != null) {
				for (String fileExtension : elem.getAttribute(ECLIPSE_EDITORS_ATTR_EXTENSIONS).split(",")) {
					editor.getFileExtensions().add(fileExtension);
				}
			}
		}
	}

	/**
	 * Removes an editor from the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 */
	public void removeEditor(IConfigurationElement extensionConfig) {

		String editorId = extensionConfig.getAttribute(EDITORS_ATTR_EDITOR_ID);
		Editor editor = repository.getEditors().removeKey(editorId);
		Metamodel metamodel = repository.getMetamodels().get(editor.getMetamodelUri());
		if (metamodel != null) {
			metamodel.getEditors().remove(editor);
		}
	}

	/**
	 * Creates the repository from the registered extensions.
	 * 
	 * @param registry
	 *            The Eclipse extension registry.
	 */
	private void initRepository(IExtensionRegistry registry) {

		repository = RepositoryFactory.eINSTANCE.createRepository();
		IConfigurationElement[] config;

		// metamodels
		config = registry.getConfigurationElementsFor(METAMODELS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			addMetamodel(elem);
		}

		// editors
		config = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		Editor editor;
		for (IConfigurationElement elem : config) {
			editor = addEditor(elem);
			addMetamodelEditors(editor);
		}		
		addEditorFileExtensions(registry);

		// built-in ecore extension
		EcoreExtension ecore = new EcoreExtension(repository);
		ecore.addToRepository();
	}

	/**
	 * Constructor: initialises the repository and registers listeners for
	 * dynamic installation/unistallation of extensions.
	 */
	public MMTF() {

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry != null) {
			initRepository(registry);
			registry.addListener(new MetamodelsExtensionListener(this), METAMODELS_EXT_POINT);
			registry.addListener(new EditorsExtensionListener(this), EDITORS_EXT_POINT);
		}
	}

	/**
	 * The MMTF registry, to be queried by extensions to get info about the
	 * repository.
	 * 
	 * @author Alessio Di Sandro
	 * 
	 */
	public static class MMTFRegistry {

		/**
		 * Gets the list of registered file extensions for metamodels.
		 * 
		 * @return The list of registered file extensions.
		 */
		public static ArrayList<String> getMetamodelFileExtensions() {

			ArrayList<String> filenames = new ArrayList<String>();
			for (Entry<String, Metamodel> entry : repository.getMetamodels().entrySet()) {
				filenames.add(entry.getValue().getFileExtension());
			}

			return filenames;
		}

		/**
		 * Gets the list of registered editors for a metamodel (identified by
		 * its uri).
		 * 
		 * @param metamodelUri
		 *            The metamodel uri.
		 * @return The list of registered editors
		 */
		public static EList<Editor> getEditorsForMetamodel(String metamodelUri) {

			return repository.getMetamodels().get(metamodelUri).getEditors();
		}

		/**
		 * Gets the list of registered metamodels.
		 * 
		 * @return The list of registered metamodels.
		 */
		public static Collection<Metamodel> getMetamodels() {

			return repository.getMetamodels().values();
		}

		/**
		 * Gets a tree dialog to select among registered metamodels and their
		 * editors.
		 * 
		 * @return The tree dialog.
		 */
		public static ElementTreeSelectionDialog getRepositoryAsDialog() {

			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell,
				new RepositoryDialogLabelProvider(),
				new RepositoryDialogContentProvider(repository)
			);
			dialog.setValidator(new RepositoryDialogSelectionValidator());
			dialog.setInput(repository);

			return dialog;
		}
	}

}
