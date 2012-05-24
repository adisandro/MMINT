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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.EditorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.MMTFExtensionPoints;
import edu.toronto.cs.se.mmtf.repository.ModelsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.RelationshipsExtensionListener;
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
public class MMTF implements MMTFExtensionPoints {

	/** The repository of registered extensions. */
	private static MultiModel repository;

	/**
	 * Adds an extendible type to the repository.
	 * 
	 * @param type
	 *            The extendible type to add.
	 * @param name
	 *            The name of the extendible type.
	 * @param extensionConfig
	 *            The extension configuration.
	 * @throws MMTFException
	 *             If the extendible type's uri is already registered.
	 */
	private void addExtendibleType(ExtendibleElement type, String name, IConfigurationElement extensionConfig) throws MMTFException {

		// uri
		String uri = extensionConfig.getAttribute(EXTENDIBLEELEMENT_ATTR_URI);
		if (repository.getExtendibleTable().containsKey(uri)) {
			throw new MMTFException("Extendible type's URI " + uri + " is  already registered");
		}
		type.setUri(uri);

		// basic attributes
		type.setName(name);
		type.setLevel(MidLevel.TYPES);

		// supertype
		String supertypeUri = extensionConfig.getAttribute(EXTENDIBLEELEMENT_ATTR_SUPERTYPEURI);
		String rootUri = "";
		if (type instanceof ModelRel) {
			rootUri = ROOT_RELATIONSHIP_URI;
		}
		else if (type instanceof Model) {
			rootUri = ROOT_MODEL_URI;
		}
		else if (type instanceof ModelElement) {
			if (((ModelElement) type).getCategory() == ModelElementCategory.ENTITY) {
				rootUri = ROOT_MODEL_ELEMENT_ENTITY_URI;
			}
			else if (((ModelElement) type).getCategory() == ModelElementCategory.RELATIONSHIP) {
				rootUri = ROOT_MODEL_ELEMENT_RELATIONSHIP_URI;
			}
		}
		else if (type instanceof Link) {
			rootUri = ROOT_RELATIONSHIP_LINK_URI;
		}
		//TODO MMTF: root text editor?
		ExtendibleElement supertype = null;
		if (supertypeUri == null) {
			if (!uri.equals(rootUri)) {
				supertype = MMTFRegistry.getExtendibleType(rootUri);
			}
		}
		else {
			supertype = MMTFRegistry.getExtendibleType(supertypeUri);
		}
		type.setSupertype(supertype);

		repository.getExtendibleTable().put(uri, type);
	}

	/**
	 * Adds a model type to the repository. Requires the model package to be
	 * registered too through the org.eclipse.emf.ecore.generated_package
	 * extension point.
	 * 
	 * @param model
	 *            The model type to add.
	 * @param extensionConfig
	 *            The extension configuration.
	 * @throws MMTFException
	 *             If the model type's package is not registered, or if the
	 *             model type's uri is already registered.
	 */
	private void addModelType(Model model, IConfigurationElement extensionConfig) throws MMTFException {

		// look for model package
		Map<String, Object> resourceMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		String uri = extensionConfig.getAttribute(EXTENDIBLEELEMENT_ATTR_URI);
		EPackage modelPackage = EPackage.Registry.INSTANCE.getEPackage(uri);
		if (modelPackage == null) {
			throw new MMTFException("EPackage for URI " + uri + " is not registered");
		}

		// set attributes
		addExtendibleType(model, extensionConfig.getDeclaringExtension().getLabel(), extensionConfig);
		model.setOrigin(ModelOrigin.IMPORTED);
		model.setRoot(modelPackage);
		String modelPackageName = modelPackage.getName();
		model.setFileExtension(modelPackageName);
		// possibly register file extension to load resources
		if (!resourceMap.containsKey(modelPackageName)) {
			resourceMap.put(modelPackageName, new XMIResourceFactoryImpl());
		}

		// register model type
		repository.getModels().add(model);
	}

	/**
	 * Creates and adds a model type to the repository. Requires the model
	 * package to be registered too through the
	 * org.eclipse.emf.ecore.generated_package extension point.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created model type, null if the model type can't be
	 *         registered.
	 */
	public Model createModelType(IConfigurationElement extensionConfig) {

		// create and add
		Model model = MidFactory.eINSTANCE.createModel();
		try {
			addModelType(model, extensionConfig);
		}
		catch (MMTFException e) {
			MMTFException.print(Type.WARNING, "Model type can't be registered", e);
			model = null;
		}

		return model;
	}

	/**
	 * Creates and adds a model relationship type to the repository. Requires
	 * the model package to be registered too through the
	 * org.eclipse.emf.ecore.generated_package extension point.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created model type relationship, null if the relationship
	 *         can't be registered.
	 */
	public ModelRel createModelRelType(IConfigurationElement extensionConfig) {

		//TODO MMTF: simplify everything with subfunctions and make it safer
		//TODO MMTF: review relationship semantics, I feel we need to change something in the extension schema
		//TODO MMTF: then, we don't care about the meaning of inheritance here, we just trust it has been set up properly
		//TODO MMTF: a pluggable checker, following some reasoning, should enforce that
		// create and add
		boolean unbounded = Boolean.parseBoolean(extensionConfig.getAttribute(RELATIONSHIPS_ATTR_ISNARY));
		IConfigurationElement extendibleConfig = extensionConfig.getChildren(CHILD_EXTENDIBLEELEMENT)[0];
		IConfigurationElement[] modelConfig = extensionConfig.getChildren(RELATIONSHIPS_CHILD_MODEL);
		ModelRel modelRel = (!unbounded && modelConfig.length == 2) ? // unbounded with any two model types is a ModelRel
			RelationshipFactory.eINSTANCE.createBinaryModelRel() :
			RelationshipFactory.eINSTANCE.createModelRel();
		try {
			addModelType(modelRel, extendibleConfig);
		}
		catch (MMTFException e) {
			MMTFException.print(Type.WARNING, "Model relationship type can't be registered", e);
			return null;
		}
		modelRel.setUnbounded(unbounded);

		// handle relationship structure:
		// models and containers
		for (IConfigurationElement modelConfigElem : modelConfig) {
			String modelUri = modelConfigElem.getAttribute(RELATIONSHIPS_MODEL_ATTR_MODELTYPEURI);
			ExtendibleElement model = MMTFRegistry.getExtendibleType(modelUri);
			if (model != null && model instanceof Model) {
				modelRel.getModels().add((Model) model);
				ModelReference modelRef = RelationshipFactory.eINSTANCE.createModelReference();
				modelRef.setReferencedObject(model);
				modelRel.getModelRefs().add(modelRef);
				// model elements
				IConfigurationElement[] modelElementConfig = modelConfigElem.getChildren(RELATIONSHIPS_MODEL_CHILD_MODELELEMENT);
				for (IConfigurationElement modelElementConfigElem : modelElementConfig) {
					String modelElementUri = modelElementConfigElem.getAttribute(EXTENDIBLEELEMENT_ATTR_URI);
					ExtendibleElement element = repository.getExtendibleTable().get(modelElementUri);
					if (element == null) { // create new model element
						element = MidFactory.eINSTANCE.createModelElement();
						((ModelElement) element).setCategory(
							ModelElementCategory.get(
								modelElementConfigElem.getAttribute(RELATIONSHIPS_MODEL_MODELELEMENT_ATTR_CATEGORY)
							)
						);
						// get feature from model
						//TODO MMTF: useful? if yes, make it safe
						String[] elemLiterals = modelElementConfigElem.getAttribute(RELATIONSHIPS_MODEL_MODELELEMENT_ATTR_CLASSLITERAL).split("\\.");
						EObject elemPointer = ((EPackage) ((Model) model).getRoot()).getEClassifier(elemLiterals[0]);
						if (elemLiterals.length > 1) {
							elemPointer = ((EClass) elemPointer).getEStructuralFeature(elemLiterals[1]);
						}
						((ModelElement) element).setPointer(elemPointer);
						try {
							addExtendibleType(element, modelElementConfigElem.getAttribute(RELATIONSHIPS_MODEL_MODELELEMENT_ATTR_NAME), modelElementConfigElem);
						}
						catch (MMTFException e) {
							MMTFException.print(Type.WARNING, "Model element can't be registered", e);
							removeModelType(modelRel.getUri());
							return null;
						}
						((Model) model).getElements().add((ModelElement) element);
					}
					if (element instanceof ModelElement) { // reference model element
						ModelElementReference elementRef = RelationshipFactory.eINSTANCE.createModelElementReference();
						elementRef.setReferencedObject(element);
						modelRef.getElementRefs().add(elementRef);
					}
				}
			}
		}
		// links
		IConfigurationElement[] linkConfig = extensionConfig.getChildren(RELATIONSHIPS_CHILD_LINK);
		for (IConfigurationElement linkConfigElem : linkConfig) {
			boolean linkUnbounded = Boolean.parseBoolean(extensionConfig.getAttribute(RELATIONSHIPS_LINK_ATTR_ISNARY));
			IConfigurationElement[] linkElementConfig = linkConfigElem.getChildren(RELATIONSHIPS_LINK_CHILD_LINKELEMENT);
			Link link = (!linkUnbounded && linkElementConfig.length == 2) ? // unbounded with any two link elements is a Link
				RelationshipFactory.eINSTANCE.createBinaryLink() :
				RelationshipFactory.eINSTANCE.createLink();
			try {
				addExtendibleType(link, linkConfigElem.getAttribute(RELATIONSHIPS_LINK_ATTR_NAME), linkConfigElem);
			}
			catch (MMTFException e) {
				MMTFException.print(Type.WARNING, "Link can't be registered", e);
				removeModelType(modelRel.getUri());
				return null;
			}
			link.setUnbounded(linkUnbounded);
			modelRel.getLinks().add(link);
			// link elements
			for (IConfigurationElement linkElementConfigElem : linkElementConfig) {
				String linkElementName = linkElementConfigElem.getAttribute(RELATIONSHIPS_LINK_LINKELEMENT_ATTR_ELEMENTNAME);
modelRef:		for (ModelReference modelRef : modelRel.getModelRefs()) {
					for (ModelElementReference elementRef : modelRef.getElementRefs()) {
						if (elementRef.getName().equals(linkElementName)) {
							link.getElementRefs().add(elementRef);
							break modelRef;
						}
					}
				}
			}
		}

		return modelRel;
	}

	/**
	 * Adds existing editor types to a new model type.
	 * 
	 * @param model
	 *            The new model type.
	 */
	public void addModelTypeEditors(Model model) {

		if (model == null) {
			return;
		}

		for (Editor editor : repository.getEditors()) {
			if (editor.getModelUri().equals(model.getUri())) {
				model.getEditors().add(editor);
			}
		}
	}

	/**
	 * Removes a model type from the repository.
	 * 
	 * @param uri
	 *            The model type uri.
	 */
	public void removeModelType(String uri) {

		ExtendibleElement model = repository.getExtendibleTable().removeKey(uri);
		if (model != null && model instanceof Model) {
			repository.getModels().remove(model);
			// remove model elements, if any
			for (ModelElement element : ((Model) model).getElements()) {
				repository.getExtendibleTable().removeKey(element.getUri());
			}
			// remove model relationship specific structures
			if (model instanceof ModelRel) {
				for (Link link : ((ModelRel) model).getLinks()) {
					repository.getExtendibleTable().removeKey(link.getUri());
				}
			}
			// remove model relationships that use this model, and subtypes
			for (ExtendibleElement extendible : repository.getExtendibleTable().values()) {
				// model relationships
				if (model instanceof Model && extendible instanceof ModelRel) {
					if (((ModelRel) extendible).getModels().contains(model)) {
						removeModelType(extendible.getUri());
					}
				}
				// subtypes
				if (extendible instanceof Model && ((Model) model).getSupertype().getUri().equals(uri)) {
					removeModelType(extendible.getUri());
				}
			}
		}
	}

	/**
	 * Creates and adds an editor type to the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created editor type.
	 */
	public Editor createEditorType(IConfigurationElement extensionConfig) {

		// create
		String isDiagram = extensionConfig.getAttribute(EDITORS_ATTR_ISDIAGRAM);
		IConfigurationElement extendibleConfig = extensionConfig.getChildren(CHILD_EXTENDIBLEELEMENT)[0];
		Editor editor;
		if (Boolean.parseBoolean(isDiagram)) {
			editor = EditorFactory.eINSTANCE.createDiagram();
		}
		else {
			editor = EditorFactory.eINSTANCE.createEditor();
		}

		try {
			addExtendibleType(editor, extensionConfig.getDeclaringExtension().getLabel(), extendibleConfig);
		}
		catch (MMTFException e) {
			MMTFException.print(Type.WARNING, "Editor type can't be registered", e);
			return null;
		}

		// set basic attributes
		String modelUri = extensionConfig.getAttribute(EDITORS_ATTR_MODELTYPEURI);
		String editorId = extensionConfig.getAttribute(EDITORS_ATTR_ID);
		String wizardId = extensionConfig.getAttribute(EDITORS_ATTR_WIZARDID);
		editor.setModelUri(modelUri);
		editor.setId(editorId);
		editor.setWizardId(wizardId);

		// register editor
		repository.getEditors().add(editor);

		return editor;
	}
	
	/**
	 * Adds a new editor type to an existing model type.
	 * 
	 * @param editor
	 *            The new editor.
	 */
	public void addModelTypeEditor(Editor editor) {

		ExtendibleElement model = repository.getExtendibleTable().get(editor.getModelUri());
		if (model != null && model instanceof Model) {
			((Model) model).getEditors().add(editor);
		}
	}

	/**
	 * Adds file extensions to a new editor type. Requires the editor type to be
	 * registered too through the org.eclipse.ui.editors extension point.
	 * 
	 * @param registry
	 *            The Eclipse extension registry.
	 * @param editor
	 *            The new editor type.
	 */
	public void addEditorTypeFileExtensions(IExtensionRegistry registry, Editor editor) {

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
	 * Adds file extensions to all initial editor types at once. Requires the
	 * editor types to be registered too through the org.eclipse.ui.editors
	 * extension point.
	 * 
	 * @param registry
	 *            The Eclipse extension registry.
	 */
	public void addEditorTypesFileExtensions(IExtensionRegistry registry) {

		// create temp editor table using ids
		HashMap<String, Editor> tempEditorTable = new HashMap<String, Editor>();
		for (Editor editor : repository.getEditors()) {
			tempEditorTable.put(editor.getId(), editor);
		}

		// loop through eclipse editors
		IConfigurationElement[] config = registry.getConfigurationElementsFor(ECLIPSE_EDITORS_EXT_POINT);
		Editor editor;
		for (IConfigurationElement elem : config) {
			editor = tempEditorTable.get(elem.getAttribute(ECLIPSE_EDITORS_ATTR_ID));
			if (editor != null) {
				String extensions = elem.getAttribute(ECLIPSE_EDITORS_ATTR_EXTENSIONS);
				if (extensions == null) {
					ExtendibleElement model = repository.getExtendibleTable().get(editor.getModelUri());
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
	 * Removes an editor type from the repository.
	 * 
	 * @param uri
	 *            The editor type uri.
	 */
	public void removeEditorType(String uri) {

		ExtendibleElement editor = repository.getExtendibleTable().removeKey(uri);
		if (editor != null && editor instanceof Editor) {
			repository.getEditors().remove(editor);
			ExtendibleElement model = repository.getExtendibleTable().get(((Editor) editor).getModelUri());
			if (model != null && model instanceof Model) {
				((Model) model).getEditors().remove(editor);
			}
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
		repository.setLevel(MidLevel.TYPES);
		IConfigurationElement[] config;

		// model types
		config = registry.getConfigurationElementsFor(MODELS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			createModelType(elem);
		}

		// model type relationships
		config = registry.getConfigurationElementsFor(RELATIONSHIPS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			createModelRelType(elem);
		}

		// editors
		config = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		Editor editor;
		for (IConfigurationElement elem : config) {
			editor = createEditorType(elem);
			addModelTypeEditor(editor);
		}		
		addEditorTypesFileExtensions(registry);

		//TODO MMTF: operators

		//TODO MMTF: do this on demand, with a button somewhere
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(
			URI.createPlatformResourceURI("/try/demo/types.mid", true)
		);
		resource.getContents().add(repository);
		try {
			resource.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
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
			registry.addListener(new RelationshipsExtensionListener(this), RELATIONSHIPS_EXT_POINT);
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
		 * Gets an extendible type.
		 * 
		 * @param uri
		 *            The uri of the extendible type.
		 * @return The extendible type, or null if uri is not found.
		 */
		public static ExtendibleElement getExtendibleType(String uri) {

			return repository.getExtendibleTable().get(uri);
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
		 * @param modelTypeUri
		 *            The model type uri.
		 * @return The list of registered editors.
		 */
		public static EList<Editor> getEditorsForModelType(String modelTypeUri) {

			ExtendibleElement model = getExtendibleType(modelTypeUri);
			if (model != null && model instanceof Model) {
				return ((Model) model).getEditors();
			}
			else {
				return ECollections.emptyEList();
			}
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
