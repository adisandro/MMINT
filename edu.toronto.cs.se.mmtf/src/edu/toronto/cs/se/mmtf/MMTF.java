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
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingFactory;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelRel;
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

	/** The uri of the root model type. */
	private final static String ROOT_MODEL_URI = "http:///edu/toronto/cs/se/mmtf/Model";
	/** The uri of the root model relationship. */
	private final static String ROOT_RELATIONSHIP_URI = "http:///edu/toronto/cs/se/mmtf/ModelRel";
	/** The uri of the root model element of category entity. */
	private final static String ROOT_MODEL_ELEMENT_ENTITY_URI = "http:///edu/toronto/cs/se/mmtf/ModelRel/ModelElement/ENTITY";
	/** The uri of the root model element of category relationship. */
	private final static String ROOT_MODEL_ELEMENT_RELATIONSHIP_URI = "http:///edu/toronto/cs/se/mmtf/ModelRel/ModelElement/RELATIONSHIP";
	/** The uri of the root link among model elements. */
	private final static String ROOT_RELATIONSHIP_LINK_URI = "http:///edu/toronto/cs/se/mmtf/ModelRel/Link";

	/** The Models extension point's id. */
	private final static String MODELS_EXT_POINT = "edu.toronto.cs.se.mmtf.models";
	/** The Models extension point's uri attribute. */
	private final static String MODELS_ATTR_URI = "uri";
	/** The Models extension point's supertypeUri attribute. */
	private final static String MODELS_ATTR_SUPERTYPEURI = "supertypeUri";

	/** The Editors extension point's id. */
	private final static String EDITORS_EXT_POINT = "edu.toronto.cs.se.mmtf.editors";
	/** The Editors extension point's modelTypeUri attribute. */
	private final static String EDITORS_ATTR_MODELTYPEURI = "modelTypeUri";
	/** The Editors extension point's isDiagram attribute. */
	private final static String EDITORS_ATTR_ISDIAGRAM = "isDiagram";
	/** The Editors extension point's editorId attribute. */
	private final static String EDITORS_ATTR_EDITORID = "editorId";
	/** The Editors extension point's wizardId attribute. */
	private final static String EDITORS_ATTR_WIZARDID = "wizardId";

	/** The Relationships extension point's id. */
	private final static String RELATIONSHIPS_EXT_POINT = "edu.toronto.cs.se.mmtf.relationships";
	/** The Relationships extension point's isNary attribute. */
	private final static String RELATIONSHIPS_ATTR_ISNARY = "isNary";
	/** The Relationships extension point's model child. */
	private final static String RELATIONSHIPS_CHILD_MODEL = "model";
	/** The Relationships extension point's model child's modelTypeUri attribute. */
	private final static String RELATIONSHIPS_MODEL_ATTR_MODELTYPEURI = "modelTypeUri";
	/** The Relationships extension point's model's modelElement child. */
	private final static String RELATIONSHIPS_MODEL_CHILD_MODELELEMENT = "modelElement";
	/** The Relationships extension point's model's modelElement child's uri attribute. */
	private final static String RELATIONSHIPS_MODEL_MODELELEMENT_ATTR_URI = "uri";
	/** The Relationships extension point's model's modelElement child's supertypeUri attribute. */
	private final static String RELATIONSHIPS_MODEL_MODELELEMENT_ATTR_SUPERTYPEURI = "supertypeUri";
	/** The Relationships extension point's model's modelElement child's name attribute. */
	private final static String RELATIONSHIPS_MODEL_MODELELEMENT_ATTR_NAME = "name";
	/** The Relationships extension point's model's modelElement child's category attribute. */
	private final static String RELATIONSHIPS_MODEL_MODELELEMENT_ATTR_CATEGORY = "category";
	/** The Relationships extension point's model's modelElement child's classLiteral attribute. */
	private final static String RELATIONSHIPS_MODEL_MODELELEMENT_ATTR_CLASSLITERAL = "classLiteral";

	/** The Eclipse's Editors extension point's id. */
	private final static String ECLIPSE_EDITORS_EXT_POINT = "org.eclipse.ui.editors";
	/** The Eclipse's Editors extension's id attribute. */
	private final static String ECLIPSE_EDITORS_ATTR_ID = "id";
	/** The Eclipse's Editors extension's extensions attribute. */
	private final static String ECLIPSE_EDITORS_ATTR_EXTENSIONS = "extensions";

	/** The repository of registered extensions. */
	private static MultiModel repository;

	/**
	 * Adds a model type to the repository. Requires the model package to be
	 * registered too through the org.eclipse.emf.ecore.generated_package
	 * extension point.
	 * 
	 * @param model
	 *            The model type to add.
	 * @param extensionConfig
	 *            The extension configuration.
	 */
	private void addModelType(Model model, IConfigurationElement extensionConfig) {

		// set basic attributes
		String uri = extensionConfig.getAttribute(MODELS_ATTR_URI);
		model.setName(extensionConfig.getDeclaringExtension().getLabel());
		model.setLevel(MidLevel.TYPES);
		model.setUri(uri);
		model.setOrigin(ModelOrigin.IMPORTED);

		// possibly set supertype
		String supertypeUri = extensionConfig.getAttribute(MODELS_ATTR_SUPERTYPEURI);
		String rootUri = (model instanceof ModelRel) ? ROOT_RELATIONSHIP_URI : ROOT_MODEL_URI;
		ExtendibleElement superModel = null;
		if (supertypeUri == null) {
			if (!uri.equals(rootUri)) {
				superModel = MMTFRegistry.getExtendibleElement(rootUri);
			}
		}
		else {
			superModel = MMTFRegistry.getExtendibleElement(supertypeUri);
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
		repository.getModels().add(model);
		repository.getExtendibles().put(uri, model);
	}

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

		// create and add
		Model model = MidFactory.eINSTANCE.createModel();
		addModelType(model, extensionConfig);

		return model;
	}

	/**
	 * Creates and adds a model type relationship to the repository. Requires
	 * the model package to be registered too through the
	 * org.eclipse.emf.ecore.generated_package extension point.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created model type relationship.
	 */
	public ModelRel createModelTypeRel(IConfigurationElement extensionConfig) {

		// create and add
		boolean unbounded = Boolean.parseBoolean(extensionConfig.getAttribute(RELATIONSHIPS_ATTR_ISNARY));
		IConfigurationElement[] modelConfig = extensionConfig.getChildren(RELATIONSHIPS_CHILD_MODEL);
		ModelRel modelRel = (!unbounded && modelConfig.length == 2) ? // unbounded with any two model types is a ModelRel
			MappingFactory.eINSTANCE.createBinaryModelRel() :
			MappingFactory.eINSTANCE.createModelRel();
		addModelType(modelRel, extensionConfig);

		// handle relationship structure
		modelRel.setUnbounded(unbounded);
		//TODO MMTF: well, we don't care about the meaning of inheritance here, we just trust it has been set up properly
		//TODO MMTF: a pluggable checker, following some reasoning, should enforce that
		for (IConfigurationElement modelConfigElem : modelConfig) {
			// models and containers
			String modelUri = modelConfigElem.getAttribute(RELATIONSHIPS_MODEL_ATTR_MODELTYPEURI);
			ExtendibleElement model = MMTFRegistry.getExtendibleElement(modelUri);
			if (model != null && model instanceof Model) {
				modelRel.getModels().add((Model) model);
				ModelReference modelRef = MappingFactory.eINSTANCE.createModelReference();
				modelRef.setReferencedObject(model);
				// model elements
				IConfigurationElement[] modelElementConfig = extensionConfig.getChildren(RELATIONSHIPS_MODEL_CHILD_MODELELEMENT);
				for (IConfigurationElement modelElementConfigElem : modelElementConfig) {
					String modelElementUri = modelElementConfigElem.getAttribute(RELATIONSHIPS_MODEL_MODELELEMENT_ATTR_URI);

					//ExtendibleElement modelElement = repository.getExtendibles().get(modelElementUri);
					//if (modelElement == null || true){}
					//modelElement = MappingFactory.eINSTANCE.createModelElement();
					//container.getElements().add(modelElement);
				}
				//TODO MMTF: check for model elements with same uri before creating a new one? think about how to let them be unique
			}
		}

		return modelRel;
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
		ExtendibleElement model = repository.getExtendibles().removeKey(uri);
		if (model != null && model instanceof Model) {
			repository.getModels().remove(model);
			((Model) model).getEditors().clear();
		}
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
		String isDiagram = extensionConfig.getAttribute(EDITORS_ATTR_ISDIAGRAM);
		Editor editor;
		if (Boolean.parseBoolean(isDiagram)) {
			editor = EditorFactory.eINSTANCE.createDiagram();
		}
		else {
			editor = EditorFactory.eINSTANCE.createEditor();
		}

		// set basic attributes
		String modelUri = extensionConfig.getAttribute(EDITORS_ATTR_MODELTYPEURI);
		String editorId = extensionConfig.getAttribute(EDITORS_ATTR_EDITORID);
		String wizardId = extensionConfig.getAttribute(EDITORS_ATTR_WIZARDID);
		editor.setName(extensionConfig.getDeclaringExtension().getLabel());
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

		ExtendibleElement model = repository.getExtendibles().get(editor.getModelUri());
		if (model != null && model instanceof Model) {
			((Model) model).getEditors().add(editor);
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
					ExtendibleElement model = repository.getExtendibles().get(editor.getModelUri());
					extensions = (model != null && model instanceof Model) ?
						((Model) model).getFileExtension() :
						"";
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

		String editorId = extensionConfig.getAttribute(EDITORS_ATTR_EDITORID);
		Editor editor = repository.getEditors().removeKey(editorId);
		ExtendibleElement model = repository.getExtendibles().get(editor.getModelUri());
		if (model != null && model instanceof Model) {
			((Model) model).getEditors().remove(editor);
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

		// model type relationships
		config = registry.getConfigurationElementsFor(RELATIONSHIPS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			createModelTypeRel(elem);
		}

		// editors
		config = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		Editor editor;
		for (IConfigurationElement elem : config) {
			editor = createEditor(elem);
			addModelTypeEditors(editor);
		}		
		addEditorFileExtensions(registry);

		//TODO MMTF: operators
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

		/**
		 * Gets an extendible element.
		 * 
		 * @param uri
		 *            The uri of the extendible element.
		 * @return The extendible element, or null if uri is not found.
		 */
		public static ExtendibleElement getExtendibleElement(String uri) {

			return repository.getExtendibles().get(uri);
		}

		/**
		 * Gets the list of registered file extensions for all model types.
		 * 
		 * @return The list of registered file extensions.
		 */
		public static ArrayList<String> getModelTypeFileExtensions() {

			ArrayList<String> filenames = new ArrayList<String>();
			for (Model model : repository.getModels()) {
				filenames.add(model.getFileExtension());
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

			ExtendibleElement model = repository.getExtendibles().get(modelUri);
			if (model != null && model instanceof Model) {
				return ((Model) model).getEditors();
			}
			else {
				return ECollections.emptyEList();
			}
		}

		/**
		 * Gets the list of registered model types.
		 * 
		 * @return The list of registered model types.
		 */
		public static EList<Model> getModelTypes() {

			return repository.getModels();
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
