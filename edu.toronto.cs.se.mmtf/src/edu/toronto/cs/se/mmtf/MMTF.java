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

import edu.toronto.cs.se.mmtf.mid.Editor;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.repository.EditorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.ModelsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryDialogLabelProvider;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryDialogSelectionValidator;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryDialogContentProvider;

/**
 * The Model Management Tool Framework adds the ability to create and manage
 * Model Interconnection Diagrams (MIDs). A MID is a diagram to represent a
 * collection of models (a multimodel) and the relationships among them at a
 * high level of abstraction. Multimodels can be used to support the
 * development, comprehension, consistency management and evolution of sets of
 * related models.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MMTF {

	/** The root model type's uri. */
	private final static String ROOT_MODEL_TYPE_URI = "http:///edu/toronto/cs/se/mmtf/Model";

	/** The Models extension point's id. */
	private final static String MODELS_EXT_POINT = "edu.toronto.cs.se.mmtf.models";
	/** The Models extension point's uri attribute. */
	private final static String MODELS_ATTR_URI = "uri";
	/** The Models extension point's supertypeUri attribute. */
	private final static String MODELS_ATTR_SUPERTYPE_URI = "supertypeUri";

	/** The Editors extension point's id. */
	private final static String EDITORS_EXT_POINT = "edu.toronto.cs.se.mmtf.editors";
	/** The Editors extension point's modelTypeUri attribute. */
	private final static String EDITORS_ATTR_MODEL_TYPE_URI = "modelTypeUri";
	/** The Editors extension point's isDiagram attribute. */
	private final static String EDITORS_ATTR_IS_DIAGRAM = "isDiagram";
	/** The Editors extension point's editorId attribute. */
	private final static String EDITORS_ATTR_EDITOR_ID = "editorId";
	/** The Editors extension point's wizardId attribute. */
	private final static String EDITORS_ATTR_WIZARD_ID = "wizardId";

	/** The Relationships extension point's id. */
	private final static String RELATIONSHIPS_EXT_POINT = "edu.toronto.cs.se.mmtf.relationships";
	/** The Relationships extension point's isNary attribute. */
	private final static String RELATIONSHIPS_ATTR_IS_NARY = "isNary";

	/** The Eclipse's Editors extension point's id. */
	private final static String ECLIPSE_EDITORS_EXT_POINT = "org.eclipse.ui.editors";
	/** The Eclipse's Editors extension's id attribute. */
	private final static String ECLIPSE_EDITORS_ATTR_ID = "id";
	/** The Eclipse's Editors extension's extensions attribute. */
	private final static String ECLIPSE_EDITORS_ATTR_EXTENSIONS = "extensions";

	/** The repository of registered extensions. */
	private static MultiModel repository;

	/**
	 * Creates and adds a model type to the repository. Requires the model
	 * package to be registered too through the
	 * org.eclipse.emf.ecore.generated_package extension point.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created model type.
	 */
	public Model createModelType(IConfigurationElement extensionConfig) {

		// create
		Model model = MidFactory.eINSTANCE.createModel();

		// set basic attributes
		String uri = extensionConfig.getAttribute(MODELS_ATTR_URI);
		model.setName(extensionConfig.getDeclaringExtension().getLabel());
		model.setType(null);
		model.setLevel(MidLevel.TYPES);
		model.setUri(uri);
		model.setOrigin(ModelOrigin.IMPORTED);

		// possibly set supertype
		String supertypeUri = extensionConfig.getAttribute(MODELS_ATTR_SUPERTYPE_URI);
		Model superModel = null;
		if (supertypeUri == null) {
			if (!uri.equals(ROOT_MODEL_TYPE_URI)) {
				superModel = MMTFRegistry.getModelType(ROOT_MODEL_TYPE_URI);
			}
		}
		else {
			superModel = MMTFRegistry.getModelType(supertypeUri);
		}
		model.setSupertype(superModel);

		// look for model package
		Map<String, Object> resourceMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		EPackage modelPackage = EPackage.Registry.INSTANCE.getEPackage(uri);
		if (modelPackage != null) {
			model.setRoot(modelPackage);
			String modelPackageName = modelPackage.getName();
			model.setFileExtension(modelPackageName);
			// possibly register file extension to load resources
			if (!resourceMap.containsKey(modelPackageName)) {
				resourceMap.put(modelPackageName, new XMIResourceFactoryImpl());
			}
		}

		// register model type
		repository.getModels().put(uri, model);

		return model;
	}

	/**
	 * Adds existing editors to a new model type.
	 * 
	 * @param model
	 *            The new model type.
	 */
	public void addModelTypeEditors(Model model) {

		Editor editor;
		for (Entry<String, Editor> entry : repository.getEditors().entrySet()) {
			editor = entry.getValue();
			if (editor.getModelUri().equals(model.getUri())) {
				model.getEditors().add(editor);
			}
		}
	}

	/**
	 * Removes a model type from the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 */
	public void removeModelType(IConfigurationElement extensionConfig) {

		String uri = extensionConfig.getAttribute(MODELS_ATTR_URI);
		Model model = repository.getModels().removeKey(uri);
		model.getEditors().clear();
	}

	/**
	 * Creates and adds an editor to the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created editor.
	 */
	public Editor createEditor(IConfigurationElement extensionConfig) {

		// create
		String isDiagram = extensionConfig.getAttribute(EDITORS_ATTR_IS_DIAGRAM);
		Editor editor;
		if (Boolean.parseBoolean(isDiagram)) {
			editor = MidFactory.eINSTANCE.createDiagram();
		}
		else {
			editor = MidFactory.eINSTANCE.createEditor();
		}

		// set basic attributes
		String modelUri = extensionConfig.getAttribute(EDITORS_ATTR_MODEL_TYPE_URI);
		String editorId = extensionConfig.getAttribute(EDITORS_ATTR_EDITOR_ID);
		String wizardId = extensionConfig.getAttribute(EDITORS_ATTR_WIZARD_ID);
		editor.setName(extensionConfig.getDeclaringExtension().getLabel());
		editor.setType(null);
		editor.setLevel(MidLevel.TYPES);
		editor.setModelUri(modelUri);
		editor.setId(editorId);
		editor.setWizardId(wizardId);

		// register editor
		repository.getEditors().put(editorId, editor);

		return editor;
	}
	
	/**
	 * Adds a new editor to an existing model type.
	 * 
	 * @param editor
	 *            The new editor.
	 */
	public void addModelTypeEditors(Editor editor) {

		Model model = repository.getModels().get(editor.getModelUri());
		if (model != null) {
			model.getEditors().add(editor);
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
			if (elem.getAttribute(ECLIPSE_EDITORS_ATTR_ID).equals(editor.getId())) {
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
				String extensions = elem.getAttribute(ECLIPSE_EDITORS_ATTR_EXTENSIONS);
				if (extensions == null) {
					extensions = repository.getModels().get(editor.getModelUri()).getFileExtension();
				}
				for (String fileExtension : extensions.split(",")) {
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
		Model model = repository.getModels().get(editor.getModelUri());
		if (model != null) {
			model.getEditors().remove(editor);
		}
	}

	/**
	 * Creates the repository from the registered extensions.
	 * 
	 * @param registry
	 *            The Eclipse extension registry.
	 */
	private void initRepository(IExtensionRegistry registry) {

		repository = MidFactory.eINSTANCE.createMultiModel();
		IConfigurationElement[] config;

		// model types
		config = registry.getConfigurationElementsFor(MODELS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			createModelType(elem);
		}

		// editors
		config = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		Editor editor;
		for (IConfigurationElement elem : config) {
			editor = createEditor(elem);
			addModelTypeEditors(editor);
		}		
		addEditorFileExtensions(registry);

		//TODO MMTF: relationships and operators
	}

	/**
	 * Constructor: initialises the repository and registers listeners for
	 * dynamic installation/unistallation of extensions.
	 */
	public MMTF() {

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry != null) {
			initRepository(registry);
			registry.addListener(new ModelsExtensionListener(this), MODELS_EXT_POINT);
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

		public static Model getModelType(String modelTypeUri) {

			return repository.getModels().get(modelTypeUri);
		}

		/**
		 * Gets the list of registered file extensions for all model types.
		 * 
		 * @return The list of registered file extensions.
		 */
		public static ArrayList<String> getModelTypeFileExtensions() {

			ArrayList<String> filenames = new ArrayList<String>();
			for (Entry<String, Model> entry : repository.getModels().entrySet()) {
				filenames.add(entry.getValue().getFileExtension());
			}

			return filenames;
		}

		/**
		 * Gets the list of registered editors for a model type (identified by
		 * its uri).
		 * 
		 * @param modelUri
		 *            The model type uri.
		 * @return The list of registered editors.
		 */
		public static EList<Editor> getEditorsForModelType(String modelUri) {

			return repository.getModels().get(modelUri).getEditors();
		}

		/**
		 * Gets the list of registered model types.
		 * 
		 * @return The list of registered model types.
		 */
		public static Collection<Model> getModelTypes() {

			return repository.getModels().values();
		}

		/**
		 * Gets a tree dialog to select among registered model types and their
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
