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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

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
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeFactory;
import edu.toronto.cs.se.mmtf.repository.EditorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.MMTFExtensionPoints;
import edu.toronto.cs.se.mmtf.repository.ModelsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.OperatorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.RelationshipsExtensionListener;

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

	/** The singleton instance. */
	static final MMTF INSTANCE = new MMTF();

	/** The repository of registered extensions. */
	static MultiModel repository;

	/**	The table for model types substitutability. */
	static HashMap<String, HashSet<String>> substitutabilityTable;

	/**	The table for model types conversion. */
	static HashMap<String, HashMap<String, EList<ConversionOperator>>> conversionTable;

	/** A temporary map for the subtypes to be assigned a supertype. */
	private static HashMap<ExtendibleElement, String> tempSubtypes;

	public static final String TYPE_MID_FILENAME = "types.mid";

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
	private static void addExtendibleType(MultiModel multiModel, ExtendibleElement type, String name, IConfigurationElement extensionConfig) throws MMTFException {

		// uri
		String uri = extensionConfig.getAttribute(EXTENDIBLEELEMENT_ATTR_URI);
		if (multiModel.getExtendibleTable().containsKey(uri)) {
			throw new MMTFException("Extendible type's URI " + uri + " is  already registered");
		}
		type.setUri(uri);

		// basic attributes
		type.setName(name);
		type.setLevel(MidLevel.TYPES);
		type.setDynamic(false);

		// supertype
		String supertypeUri = extensionConfig.getAttribute(EXTENDIBLEELEMENT_ATTR_SUPERTYPEURI);
		String rootUri = MultiModelTypeRegistry.getRootTypeUri(type);
		if (supertypeUri == null) {
			if (!uri.equals(rootUri)) {
				tempSubtypes.put(type, rootUri);
			}
		}
		else {
			tempSubtypes.put(type, supertypeUri);
		}

		multiModel.getExtendibleTable().put(uri, type);
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
	private static void addModelType(MultiModel multiModel, Model model, IConfigurationElement extensionConfig) throws MMTFException {

		// look for model package
		Map<String, Object> resourceMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		String uri = extensionConfig.getAttribute(EXTENDIBLEELEMENT_ATTR_URI);
		EPackage modelPackage = EPackage.Registry.INSTANCE.getEPackage(uri);
		if (modelPackage == null) {
			throw new MMTFException("EPackage for URI " + uri + " is not registered");
		}

		// set attributes
		addExtendibleType(multiModel, model, extensionConfig.getDeclaringExtension().getLabel(), extensionConfig);
		model.setOrigin(ModelOrigin.IMPORTED);
		String modelPackageName = modelPackage.getName();
		model.setFileExtension(modelPackageName);
		// possibly register file extension to load resources
		if (!resourceMap.containsKey(modelPackageName)) {
			resourceMap.put(modelPackageName, new XMIResourceFactoryImpl());
		}

		// register model type
		multiModel.getModels().add(model);
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
	public static Model createModelType(MultiModel multiModel, IConfigurationElement extensionConfig) {

		// create and add
		Model model = MidFactory.eINSTANCE.createModel();
		try {
			addModelType(multiModel, model, extensionConfig);
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
	public static ModelRel createModelRelType(MultiModel multiModel, IConfigurationElement extensionConfig) {

		// create and add
		boolean unbounded = Boolean.parseBoolean(extensionConfig.getAttribute(MODELRELS_ATTR_ISNARY));
		IConfigurationElement extendibleConfig = extensionConfig.getChildren(CHILD_EXTENDIBLEELEMENT)[0];
		IConfigurationElement[] modelConfig = extensionConfig.getChildren(MODELRELS_CHILD_MODEL);
		ModelRel modelRel = (!unbounded && modelConfig.length == 2) ? // unbounded with any two model types is a ModelRel
			RelationshipFactory.eINSTANCE.createBinaryModelRel() :
			RelationshipFactory.eINSTANCE.createModelRel();
		try {
			addModelType(multiModel, modelRel, extendibleConfig);
		}
		catch (MMTFException e) {
			MMTFException.print(Type.WARNING, "Model relationship type can't be registered", e);
			return null;
		}
		modelRel.setUnbounded(unbounded);

		// handle relationship structure:
		// models and containers
		for (IConfigurationElement modelConfigElem : modelConfig) {
			String modelUri = modelConfigElem.getAttribute(MODELRELS_MODEL_ATTR_MODELTYPEURI);
			Model model = MultiModelTypeRegistry.getModelType(multiModel, modelUri);
			if (model != null) {
				modelRel.getModels().add(model);
				ModelReference modelRef = RelationshipFactory.eINSTANCE.createModelReference();
				modelRef.setReferencedObject(model);
				modelRel.getModelRefs().add(modelRef);
				// model elements
				IConfigurationElement[] modelElementConfig = modelConfigElem.getChildren(MODELRELS_MODEL_CHILD_MODELELEMENT);
				for (IConfigurationElement modelElementConfigElem : modelElementConfig) {
					String modelElementUri = modelElementConfigElem.getAttribute(EXTENDIBLEELEMENT_ATTR_URI);
					ModelElement element = MultiModelTypeRegistry.getModelElementType(multiModel, modelElementUri);
					if (element == null) { // create new model element
						element = MidFactory.eINSTANCE.createModelElement();
						element.setCategory(
							ModelElementCategory.get(
								modelElementConfigElem.getAttribute(MODELRELS_MODEL_MODELELEMENT_ATTR_CATEGORY)
							)
						);
						element.setClassLiteral(modelElementConfigElem.getAttribute(MODELRELS_MODEL_MODELELEMENT_ATTR_CLASSLITERAL));
						try {
							addExtendibleType(multiModel, element, modelElementConfigElem.getAttribute(MODELRELS_MODEL_MODELELEMENT_ATTR_NAME), modelElementConfigElem);
						}
						catch (MMTFException e) {
							MMTFException.print(Type.WARNING, "Model element can't be registered", e);
							MultiModelTypeFactory.removeModelType(modelRel);
							return null;
						}
						model.getElements().add(element);
					}
					// reference model element
					ModelElementReference elementRef = RelationshipFactory.eINSTANCE.createModelElementReference();
					elementRef.setReferencedObject(element);
					modelRef.getElementRefs().add(elementRef);
				}
			}
		}
		// links
		IConfigurationElement[] linkConfig = extensionConfig.getChildren(MODELRELS_CHILD_LINK);
		for (IConfigurationElement linkConfigElem : linkConfig) {
			boolean linkUnbounded = Boolean.parseBoolean(extensionConfig.getAttribute(MODELRELS_LINK_ATTR_ISNARY));
			IConfigurationElement[] linkElementConfig = linkConfigElem.getChildren(MODELRELS_LINK_CHILD_LINKELEMENT);
			Link link = (!linkUnbounded && linkElementConfig.length == 2) ? // unbounded with any two link elements is a Link
				RelationshipFactory.eINSTANCE.createBinaryLink() :
				RelationshipFactory.eINSTANCE.createLink();
			try {
				addExtendibleType(multiModel, link, linkConfigElem.getAttribute(MODELRELS_LINK_ATTR_NAME), linkConfigElem);
			}
			catch (MMTFException e) {
				MMTFException.print(Type.WARNING, "Link can't be registered", e);
				MultiModelTypeFactory.removeModelType(modelRel);
				return null;
			}
			link.setUnbounded(linkUnbounded);
			modelRel.getLinks().add(link);
			// link elements
			for (IConfigurationElement linkElementConfigElem : linkElementConfig) {
				String linkElementName = linkElementConfigElem.getAttribute(MODELRELS_LINK_LINKELEMENT_ATTR_ELEMENTNAME);
modelRef:
				for (ModelReference modelRef : modelRel.getModelRefs()) {
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
	 * Creates and adds an editor type to the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created editor type.
	 */
	public static Editor createEditorType(MultiModel multiModel, IConfigurationElement extensionConfig) {

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
			addExtendibleType(multiModel, editor, extensionConfig.getDeclaringExtension().getLabel(), extendibleConfig);
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
		multiModel.getEditors().add(editor);

		return editor;
	}

	/**
	 * Creates and adds an operator to the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created operator.
	 * @throws MMTFException
	 *             If there exists a vararg parameter which is not the last
	 *             parameter.
	 */
	private static void addOperatorParameters(MultiModel multiModel, Operator operator, EList<Parameter> parameterList, IConfigurationElement parameterConfig) throws MMTFException {

		IConfigurationElement[] parameterElems = parameterConfig.getChildren(OPERATORS_INPUTOUTPUT_CHILD_PARAMETER);
		int i = 0;
		for (IConfigurationElement parameterElem : parameterElems) {
			// read configuration
			String name = parameterElem.getAttribute(OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_NAME);
			boolean vararg = Boolean.parseBoolean(parameterElem.getAttribute(OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_ISVARARG));
			if (vararg && i != (parameterElems.length-1)) { // only last parameter can be vararg
				throw new MMTFException("Only last parameter can be a vararg parameter");
			}
			String modelTypeUri = parameterElem.getAttribute(OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_MODELTYPEURI);
			// create parameter
			Model model = MultiModelTypeRegistry.getModelType(multiModel, modelTypeUri);
			if (model == null) {
				throw new MMTFException("Model type " + modelTypeUri + " is not registered");
			}
			Parameter parameter = OperatorFactory.eINSTANCE.createParameter();
			parameter.setModel(model);
			// set attributes
			parameter.setName(name);
			parameter.setVararg(vararg);
			parameterList.add(parameter);
			operator.getSignatureTable().put(name, parameter);
			i++;
		}
	}

	/**
	 * Creates and adds an operator to the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created operator.
	 */
	public static Operator createOperatorType(MultiModel multiModel, IConfigurationElement extensionConfig) {

		// create and set basic attributes
		boolean conversion = Boolean.parseBoolean(extensionConfig.getAttribute(OPERATORS_ATTR_ISCONVERSION));
		IConfigurationElement extendibleConfig = extensionConfig.getChildren(CHILD_EXTENDIBLEELEMENT)[0];
		Operator operatorType = (conversion) ?
			OperatorFactory.eINSTANCE.createConversionOperator() :
			OperatorFactory.eINSTANCE.createOperator();
		try {
			addExtendibleType(multiModel, operatorType, extensionConfig.getDeclaringExtension().getLabel(), extendibleConfig);
		} catch (MMTFException e) {
			MMTFException.print(Type.WARNING, "Operator type can't be registered", e);
			return null;
		}

		try {
			// java implementation
			Object executable;
			executable = extensionConfig.createExecutableExtension(OPERATORS_ATTR_CLASS);
			if (!(executable instanceof OperatorExecutable)) {
				throw new MMTFException("Operator type's executable doesn't extend OperatorExecutable interface");
			}
			operatorType.setExecutable((OperatorExecutable) executable);

			// handle operator structure
			IConfigurationElement inputConfig = extensionConfig.getChildren(OPERATORS_CHILD_INPUT)[0];
			addOperatorParameters(multiModel, operatorType, operatorType.getInputs(), inputConfig);
			IConfigurationElement outputConfig = extensionConfig.getChildren(OPERATORS_CHILD_OUTPUT)[0];
			addOperatorParameters(multiModel, operatorType, operatorType.getOutputs(), outputConfig);
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Operator type can't be registered", e);
			return null;
		}

		// conversion operator
		if (operatorType instanceof ConversionOperator) {
			operatorType.getInputs().get(0).getModel().getConversionOperators().add((ConversionOperator) operatorType);
		}

		multiModel.getOperators().add(operatorType);

		return operatorType;
	}

	/**
	 * Adds a new editor type to an existing model type.
	 * 
	 * @param editorType
	 *            The new editor.
	 */
	public static void addModelTypeEditor(Editor editorType) {

		MultiModel multiModel = (MultiModel) editorType.eContainer();
		Model modelType = MultiModelTypeRegistry.getModelType(multiModel, editorType.getModelUri());
		if (modelType != null) {
			modelType.getEditors().add(editorType);
		}
	}

	/**
	 * Adds existing editor types to a new model type.
	 * 
	 * @param modelType
	 *            The new model type.
	 */
	public static void addModelTypeEditors(Model modelType) {

		if (modelType == null) {
			return;
		}

		MultiModel multiModel = (MultiModel) modelType.eContainer();
		for (Editor editorType : multiModel.getEditors()) {
			if (editorType.getModelUri().equals(modelType.getUri())) {
				modelType.getEditors().add(editorType);
			}
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
	public static void addEditorTypeFileExtensions(IExtensionRegistry registry, Editor editor) {

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
	 * Set all the supertypes at once, to decouple from the order in which
	 * extensions are read.
	 */
	public static void setSupertypes() {

		//TODO MMTF: verify if this works when you write on diagram first
		for (Entry<ExtendibleElement, String> entry : tempSubtypes.entrySet()) {
			ExtendibleElement subtype = entry.getKey();
			String supertypeUri = entry.getValue();
			ExtendibleElement supertype = MultiModelTypeRegistry.getExtendibleType(supertypeUri);
			subtype.setSupertype(supertype);
		}
		tempSubtypes.clear();
	}

	private static void addTypeHierarchy(ExtendibleElement type, HashSet<String> substitutableTypes, HashMap<String, EList<ConversionOperator>> conversionTypes) {

		// previous conversions
		EList<ConversionOperator> previousConversions = conversionTypes.get(type.getUri());

		// add supertypes
		ExtendibleElement supertype = type.getSupertype();
		if (supertype != null) {
			String supertypeUri = supertype.getUri();
			if (!substitutableTypes.contains(supertypeUri)) {
				substitutableTypes.add(supertypeUri);
				// keep track of conversion operators used
				EList<ConversionOperator> conversions = (previousConversions == null) ?
					new BasicEList<ConversionOperator>() :
					new BasicEList<ConversionOperator>(previousConversions);
				conversionTypes.put(supertypeUri, conversions);
				// recursion
				addTypeHierarchy(supertype, substitutableTypes, conversionTypes);
			}
		}

		// add conversions
		if (type instanceof Model) {
			for (ConversionOperator operator : ((Model) type).getConversionOperators()) {
				Model conversionModel = operator.getOutputs().get(0).getModel();
				String conversionUri = conversionModel.getUri();
				if (!substitutableTypes.contains(conversionUri)) { // coherence of multiple paths is assumed
					substitutableTypes.add(conversionUri);
					// keep track of conversion operators used
					EList<ConversionOperator> conversions = (previousConversions == null) ?
						new BasicEList<ConversionOperator>() :
						new BasicEList<ConversionOperator>(previousConversions);
					conversions.add(operator); // add new operator to use
					conversionTypes.put(conversionUri, conversions);
					// recursion
					addTypeHierarchy(conversionModel, substitutableTypes, conversionTypes);
				}
			}
		}
	}

	public static void initTypeHierarchy() {

		substitutabilityTable.clear();
		conversionTable.clear();
		for (ExtendibleElement type : repository.getExtendibleTable().values()) {
			HashSet<String> substitutableTypes = new HashSet<String>();
			HashMap<String, EList<ConversionOperator>> conversionTypes = new HashMap<String, EList<ConversionOperator>>();
			addTypeHierarchy(type, substitutableTypes, conversionTypes);
			substitutabilityTable.put(type.getUri(), substitutableTypes);
			conversionTable.put(type.getUri(), conversionTypes);
		}
	}

	private Model addDynamicType(Model dynamicModelType) {

		Model modelSupertype = MultiModelTypeRegistry.getModelType(dynamicModelType.getSupertype().getUri());
		if (modelSupertype == null && dynamicModelType.getSupertype().isDynamic()) {
			modelSupertype = addDynamicType(dynamicModelType.getSupertype());
		}
		if (modelSupertype == null) {
			return null;
		}

		Model modelType = null;
		//TODO MMTF: Copy the contents of relationships as well
		if (dynamicModelType instanceof ModelRel) {
			Model srcModelType = null;
			Model tgtModelType = null;
			EClass modelRelTypeClass;
			if (dynamicModelType instanceof BinaryModelRel) {
				srcModelType = ((BinaryModelRel) dynamicModelType).getModels().get(0);
				tgtModelType = ((BinaryModelRel) dynamicModelType).getModels().get(1);
				modelRelTypeClass = RelationshipPackage.eINSTANCE.getBinaryModelRel();
			}
			else {
				modelRelTypeClass = RelationshipPackage.eINSTANCE.getModelRel();
			}
			try {
				modelType = MultiModelTypeFactory.createLightModelRelType(
					(ModelRel) modelSupertype,
					srcModelType,
					tgtModelType,
					dynamicModelType.getName(),
					dynamicModelType.getConstraint().getBody(),
					modelRelTypeClass
				);
			}
			catch (MMTFException e) {
				MMTFException.print(MMTFException.Type.WARNING, "Dynamic model relationship type " + dynamicModelType.getName() + " could not be recreated", e);
			}
		}
		else {
			try {
				modelType = MultiModelTypeFactory.createLightModelType(
					modelSupertype, 
					dynamicModelType.getName(),
					dynamicModelType.getConstraint().getBody()
				);
			}
			catch (MMTFException e) {
				MMTFException.print(MMTFException.Type.WARNING, "Dynamic model type " + dynamicModelType.getName() + " could not be recreated", e);
			}
		}

		return modelType;
	}

	/**
	 * Initializes dynamic types.
	 */
	private void initDynamicTypes() {

		MultiModel multiModel;
		try {
			multiModel = MultiModelTypeRegistry.getTypeMidRepository();
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Skipping dynamic types, no previous Type MID found", e);
			return;
		}

		// do model types first
		for (Model modelType : multiModel.getModels()) {
			if (!(modelType instanceof ModelRel) &&
				modelType.isDynamic() &&
				MultiModelTypeRegistry.getExtendibleType(modelType.getUri()) == null
			) {
				addDynamicType(modelType);
			}
		}
		for (Model modelType : multiModel.getModels()) {
			if (modelType instanceof ModelRel
				&& modelType.isDynamic() &&
				MultiModelTypeRegistry.getExtendibleType(modelType.getUri()) == null
			) {
				addDynamicType(modelType);
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
		substitutabilityTable = new HashMap<String, HashSet<String>>();
		conversionTable = new HashMap<String, HashMap<String, EList<ConversionOperator>>>();
		tempSubtypes = new HashMap<ExtendibleElement, String>();
		IConfigurationElement[] config;

		// model types
		config = registry.getConfigurationElementsFor(MODELS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			createModelType(repository, elem);
		}

		// model relationship types
		config = registry.getConfigurationElementsFor(MODELRELS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			createModelRelType(repository, elem);
		}

		// editor types
		config = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			Editor editor = createEditorType(repository, elem);
			addModelTypeEditor(editor);
		}		
		addEditorTypesFileExtensions(registry);

		// operator types
		config = registry.getConfigurationElementsFor(OPERATORS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			createOperatorType(repository, elem);
		}
		
		// type hierarchy
		setSupertypes();
		initDynamicTypes();
		initTypeHierarchy();

		String path = MMTFActivator.getDefault().getStateLocation().toOSString();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(
			URI.createFileURI(path + IPath.SEPARATOR + TYPE_MID_FILENAME)
		);
		resource.getContents().add(repository);
		try {
			resource.save(Collections.EMPTY_MAP);
		}
		catch (IOException e) {
			MMTFException.print(Type.ERROR, "Error creating types mid", e);
		}
	}

	public static void syncRepository(MultiModel multiModel) {

		//TODO MMTF: Encapsulate updateRepository in a command and chain
		//TODO MMTF: with other commands that modify the repository
		//TODO MMTF: so that undos are also reflected in the repository as
		//TODO MMTF: well as the diagram
		EList<OperatorExecutable> executables = new BasicEList<OperatorExecutable>();
		for (Operator operator : repository.getOperators()) {
			executables.add(operator.getExecutable());
		}
		repository = EcoreUtil.copy(multiModel);
		for (int i = 0; i < repository.getOperators().size(); i++) {
			Operator operator = repository.getOperators().get(i);
			operator.setExecutable(executables.get(i));
		}
		initTypeHierarchy();
	}

	/**
	 * Constructor: initialises the repository and registers listeners for
	 * dynamic installation/unistallation of extensions.
	 */
	private MMTF() {

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry != null) {
			initRepository(registry);
			registry.addListener(new ModelsExtensionListener(), MODELS_EXT_POINT);
			registry.addListener(new RelationshipsExtensionListener(), MODELRELS_EXT_POINT);
			registry.addListener(new EditorsExtensionListener(), EDITORS_EXT_POINT);
			registry.addListener(new OperatorsExtensionListener(), OPERATORS_EXT_POINT);
		}
	}

}
