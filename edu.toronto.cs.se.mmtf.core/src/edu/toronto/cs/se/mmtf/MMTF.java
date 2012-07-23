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
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;

import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelConstraint;
import edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine;
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
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.repository.EditorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.MMTFExtensionPoints;
import edu.toronto.cs.se.mmtf.repository.ModelsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.OperatorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.RelationshipsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.ui.RelationshipTypesDialogContentProvider;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryTypesDialogLabelProvider;
import edu.toronto.cs.se.mmtf.repository.ui.RepositoryDialogSelectionValidator;
import edu.toronto.cs.se.mmtf.repository.ui.MidTypesDialogContentProvider;

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

	/**	The table for model types substitutability. */
	public static HashMap<String, HashSet<String>> substitutabilityTable;

	/**	The table for model types conversion. */
	public static HashMap<String, HashMap<String, EList<ConversionOperator>>> conversionTable;

	/** A temporary map for the subtypes to be assigned a supertype. */
	private static HashMap<ExtendibleElement, String> tempSubtypes;

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
		type.setDynamic(false);

		// supertype
		String supertypeUri = extensionConfig.getAttribute(EXTENDIBLEELEMENT_ATTR_SUPERTYPEURI);
		String rootUri = MMTFRegistry.getRootTypeUri(type);
		if (supertypeUri == null) {
			if (!uri.equals(rootUri)) {
				tempSubtypes.put(type, rootUri);
			}
		}
		else {
			tempSubtypes.put(type, supertypeUri);
		}

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

		// create and add
		boolean unbounded = Boolean.parseBoolean(extensionConfig.getAttribute(MODELRELS_ATTR_ISNARY));
		IConfigurationElement extendibleConfig = extensionConfig.getChildren(CHILD_EXTENDIBLEELEMENT)[0];
		IConfigurationElement[] modelConfig = extensionConfig.getChildren(MODELRELS_CHILD_MODEL);
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
			String modelUri = modelConfigElem.getAttribute(MODELRELS_MODEL_ATTR_MODELTYPEURI);
			Model model = MMTFRegistry.getModelType(modelUri);
			if (model != null) {
				modelRel.getModels().add(model);
				ModelReference modelRef = RelationshipFactory.eINSTANCE.createModelReference();
				modelRef.setReferencedObject(model);
				modelRel.getModelRefs().add(modelRef);
				// model elements
				IConfigurationElement[] modelElementConfig = modelConfigElem.getChildren(MODELRELS_MODEL_CHILD_MODELELEMENT);
				for (IConfigurationElement modelElementConfigElem : modelElementConfig) {
					String modelElementUri = modelElementConfigElem.getAttribute(EXTENDIBLEELEMENT_ATTR_URI);
					ModelElement element = MMTFRegistry.getModelElementType(modelElementUri);
					if (element == null) { // create new model element
						element = MidFactory.eINSTANCE.createModelElement();
						element.setCategory(
							ModelElementCategory.get(
								modelElementConfigElem.getAttribute(MODELRELS_MODEL_MODELELEMENT_ATTR_CATEGORY)
							)
						);
						element.setClassLiteral(modelElementConfigElem.getAttribute(MODELRELS_MODEL_MODELELEMENT_ATTR_CLASSLITERAL));
						try {
							addExtendibleType(element, modelElementConfigElem.getAttribute(MODELRELS_MODEL_MODELELEMENT_ATTR_NAME), modelElementConfigElem);
						}
						catch (MMTFException e) {
							MMTFException.print(Type.WARNING, "Model element can't be registered", e);
							MMTFRegistry.removeModelType(modelRel);
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
				addExtendibleType(link, linkConfigElem.getAttribute(MODELRELS_LINK_ATTR_NAME), linkConfigElem);
			}
			catch (MMTFException e) {
				MMTFException.print(Type.WARNING, "Link can't be registered", e);
				MMTFRegistry.removeModelType(modelRel);
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
	 * Creates and adds an operator to the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created operator.
	 * @throws MMTFException
	 *             If there exists a vararg parameter which is not the last
	 *             parameter.
	 */
	private void addOperatorParameters(Operator operator, EList<Parameter> parameterList, IConfigurationElement parameterConfig) throws MMTFException {

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
			Model model = MMTFRegistry.getModelType(modelTypeUri);
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
	public Operator createOperatorType(IConfigurationElement extensionConfig) {

		// create and set basic attributes
		boolean conversion = Boolean.parseBoolean(extensionConfig.getAttribute(OPERATORS_ATTR_ISCONVERSION));
		IConfigurationElement extendibleConfig = extensionConfig.getChildren(CHILD_EXTENDIBLEELEMENT)[0];
		Operator operatorType = (conversion) ?
			OperatorFactory.eINSTANCE.createConversionOperator() :
			OperatorFactory.eINSTANCE.createOperator();
		try {
			addExtendibleType(operatorType, extensionConfig.getDeclaringExtension().getLabel(), extendibleConfig);
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
			addOperatorParameters(operatorType, operatorType.getInputs(), inputConfig);
			IConfigurationElement outputConfig = extensionConfig.getChildren(OPERATORS_CHILD_OUTPUT)[0];
			addOperatorParameters(operatorType, operatorType.getOutputs(), outputConfig);
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Operator type can't be registered", e);
			return null;
		}

		// conversion operator
		if (operatorType instanceof ConversionOperator) {
			operatorType.getInputs().get(0).getModel().getConversionOperators().add((ConversionOperator) operatorType);
		}

		repository.getOperators().add(operatorType);

		return operatorType;
	}

	/**
	 * Adds a new editor type to an existing model type.
	 * 
	 * @param editorType
	 *            The new editor.
	 */
	public void addModelTypeEditor(Editor editorType) {

		Model modelType = MMTFRegistry.getModelType(editorType.getModelUri());
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
	public void addModelTypeEditors(Model modelType) {

		if (modelType == null) {
			return;
		}

		for (Editor editorType : repository.getEditors()) {
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
	 * Removes an operator type from the repository.
	 * 
	 * @param uri
	 *            The operator type uri.
	 */
	public static Operator removeOperatorType(String uri) {

		ExtendibleElement elementType = repository.getExtendibleTable().removeKey(uri);
		Operator operatorType = null;

		if (elementType != null && elementType instanceof Operator) {
			operatorType = (Operator) elementType;
			repository.getOperators().remove(operatorType);
			// conversion operator
			if (operatorType instanceof ConversionOperator) {
				operatorType.getInputs().get(0).getModel().getConversionOperators().remove(operatorType);
			}
		}

		return operatorType;
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
	 * Set all the supertypes at once, to decouple from the order in which
	 * extensions are read.
	 */
	public void setSupertypes() {

		for (Entry<ExtendibleElement, String> entry : tempSubtypes.entrySet()) {
			ExtendibleElement subtype = entry.getKey();
			String supertypeUri = entry.getValue();
			ExtendibleElement supertype = MMTFRegistry.getExtendibleType(supertypeUri);
			subtype.setSupertype(supertype);
		}
		tempSubtypes.clear();
	}

	private static void addTypeHierarchy(ExtendibleElement element, HashSet<String> substitutableTypes, HashMap<String, EList<ConversionOperator>> conversionTypes) {

		// previous conversions
		EList<ConversionOperator> previousConversions = conversionTypes.get(element.getUri());

		// add supertypes
		ExtendibleElement supertype = element.getSupertype();
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
		if (element instanceof Model) {
			for (ConversionOperator operator : ((Model) element).getConversionOperators()) {
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
		for (Model model : repository.getModels()) {
			HashSet<String> substitutableTypes = new HashSet<String>();
			HashMap<String, EList<ConversionOperator>> conversionTypes = new HashMap<String, EList<ConversionOperator>>();
			addTypeHierarchy(model, substitutableTypes, conversionTypes);
			substitutabilityTable.put(model.getUri(), substitutableTypes);
			conversionTable.put(model.getUri(), conversionTypes);
		}
	}
	
	private void addDynamicType(ExtendibleElement element) {

		ExtendibleElement supertype = MMTFRegistry.getExtendibleType(element.getSupertype().getUri());
		
		if (supertype == null && element.getSupertype().isDynamic()) {
			addDynamicType(element.getSupertype());
		}
		
		supertype = MMTFRegistry.getExtendibleType(element.getSupertype().getUri());
		if (supertype == null) return;
		
		if (element instanceof Model && supertype instanceof Model) {				
			try {
				MMTFRegistry.createLightModelType(
					(Model) supertype, 
					element.getName(),
					((Model) element).getConstraint().getBody()
				);
			} catch (MMTFException e) {
				MMTFException.print(MMTFException.Type.WARNING, "No light model created", e);
			}
		}
		else if (element instanceof BinaryModelRel && supertype instanceof ModelRel) {
			Model source = ((BinaryModelRel) element).getModels().get(0);
			Model target = ((BinaryModelRel) element).getModels().get(1);
			try {
				MMTFRegistry.createLightModelRelType(
					(ModelRel) supertype, 
					source,
					target,
					element.getName(), 
					((ModelRel) element).getConstraint().getBody(),
					RelationshipPackage.eINSTANCE.getBinaryModelRel()
				);
			} catch (MMTFException e) {
				MMTFException.print(MMTFException.Type.WARNING, "No light binary model relationship created", e);
			}
		}
		else if (element instanceof ModelRel && supertype instanceof ModelRel) {
			try {
				MMTFRegistry.createLightModelRelType(
					(ModelRel) supertype, 
					null, 
					null,
					element.getName(), 
					((ModelRel) element).getConstraint().getBody(),
					RelationshipPackage.eINSTANCE.getModelRel()
				);
			} catch (MMTFException e) {
				MMTFException.print(MMTFException.Type.WARNING, "No light model relationship created created", e);
			}
		}
	}
	
	/**
	 * Initializes dynamic types
	 * 
	 */
	private void initDynamicTypes() {

		MultiModel root = null;
		try {			
			String path = MMTFActivator.getDefault().getStateLocation().toOSString();
			URI uri = URI.createFileURI(path+"/types.mid");
			root = (MultiModel) MultiModelTypeIntrospection.getRoot(uri);
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Could not locate types.mid", e);
			return;
		}
		
		for (ExtendibleElement entry : root.getExtendibleTable().values()) {
			if (entry instanceof Model && entry.isDynamic() && MMTFRegistry.getExtendibleType(entry.getUri()) == null) {
				addDynamicType(entry);
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
			createModelType(elem);
		}

		// model type relationships
		config = registry.getConfigurationElementsFor(MODELRELS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			createModelRelType(elem);
		}

		// editors
		config = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			Editor editor = createEditorType(elem);
			addModelTypeEditor(editor);
		}		
		addEditorTypesFileExtensions(registry);

		// operators
		config = registry.getConfigurationElementsFor(OPERATORS_EXT_POINT);
		for (IConfigurationElement elem : config) {
			createOperatorType(elem);
		}

		// type hierarchy
		setSupertypes();
		
		// initialize dynamic types
		initDynamicTypes();
		
		//TODO MMTF: rerun every time a model is added or removed
		initTypeHierarchy();

		//TODO MMTF: do this on demand, with a button somewhere
		String path = MMTFActivator.getDefault().getStateLocation().toOSString();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(
			URI.createFileURI(path+"/types.mid"));
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
			registry.addListener(new RelationshipsExtensionListener(this), MODELRELS_EXT_POINT);
			registry.addListener(new EditorsExtensionListener(this), EDITORS_EXT_POINT);
			registry.addListener(new OperatorsExtensionListener(this), OPERATORS_EXT_POINT);
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

		public static void updateRepository(MultiModel multiModel) {
			
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
			MMTF.initTypeHierarchy();
		}

		private static String getRootTypeUri(ExtendibleElement type) {

			String rootUri = "";
			if (type instanceof ModelRel) {
				rootUri = ROOT_MODELREL_URI;
			}
			else if (type instanceof Model) {
				rootUri = ROOT_MODEL_URI;
			}
			else if (type instanceof ModelElement) {
				if (((ModelElement) type).getCategory() == ModelElementCategory.ENTITY) {
					rootUri = ROOT_MODELELEMENT_ENTITY_URI;
				}
				else if (((ModelElement) type).getCategory() == ModelElementCategory.RELATIONSHIP) {
					rootUri = ROOT_MODELELEMENT_RELATIONSHIP_URI;
				}
			}
			else if (type instanceof Link) {
				rootUri = ROOT_MODELREL_LINK_URI;
			}
			//TODO MMTF: root text editor and operator?

			return rootUri;
		}

		private static void addLightExtendibleType(ExtendibleElement newType, ExtendibleElement type, String newTypeUriFragment, String newTypeName, MultiModel multiModel) throws MMTFException {

			// uri
			String uri = (type == null) ?
				getRootTypeUri(newType) :
				type.getUri();
			String newUri = uri + "/" + newTypeUriFragment;
			if (multiModel.getExtendibleTable().containsKey(newUri)) {
				throw new MMTFException("Extendible type's URI " + newUri + " is already registered");
			}
			newType.setUri(newUri);

			// basic attributes
			newType.setName(newTypeName);
			newType.setLevel(MidLevel.TYPES);
			newType.setDynamic(true);

			// supertype
			newType.setSupertype(type);

			multiModel.getExtendibleTable().put(newUri, newType);
		}

		private static void addLightModelType(Model newModelType, Model modelType, String newModelTypeName, String constraint) throws MMTFException {

			// create
			MultiModel multiModel = (MultiModel) modelType.eContainer();
			addLightExtendibleType(newModelType, modelType, newModelTypeName, newModelTypeName, multiModel);

			// set specific attributes
			newModelType.setOrigin(ModelOrigin.CREATED);
			ModelConstraint modelConstraint = MidFactory.eINSTANCE.createModelConstraint();
			modelConstraint.setBody(constraint);
			modelConstraint.setEngine(ModelConstraintEngine.OCL);
			newModelType.setConstraint(modelConstraint);

			// copy attributes from supertype
			newModelType.setFileExtension(modelType.getFileExtension());

			// create new editors
			for (Editor editorType : modelType.getEditors()) {
				Editor newEditorType = (Editor) EditorFactory.eINSTANCE.create(editorType.eClass());
				try {
					addLightExtendibleType(newEditorType, editorType, newModelTypeName, editorType.getName(), multiModel);
				}
				catch (MMTFException e) {
					// unfortunately models created through this editor will have the supermodel as static type
					newModelType.getEditors().add(editorType);
					continue;
				}
				newEditorType.setModelUri(newModelType.getUri());
				newEditorType.setId(editorType.getId());
				newEditorType.setWizardId(editorType.getWizardId());
				multiModel.getEditors().add(newEditorType);
				newModelType.getEditors().add(newEditorType);
				newEditorType.getFileExtensions().addAll(editorType.getFileExtensions());
			}

			// register light model type
			multiModel.getModels().add(newModelType);
		}

		public static Model createLightModelType(Model modelType, String newModelTypeName, String constraint) throws MMTFException {

			Model newModelType = MidFactory.eINSTANCE.createModel();
			addLightModelType(newModelType, modelType, newModelTypeName, constraint);

			return newModelType;
		}

		public static ModelReference createLightModelTypeRef(ModelRel modelRelType, Model modelType) {

			ModelReference newModelTypeRef = RelationshipFactory.eINSTANCE.createModelReference();
			newModelTypeRef.setReferencedObject(modelType);
			modelRelType.getModelRefs().add(newModelTypeRef);

			return newModelTypeRef;
		}

		public static ModelRel createLightModelRelType(ModelRel modelRelType, Model srcModelType, Model tgtModelType, String newModelRelTypeName, String constraint, EClass modelRelTypeClass) throws MMTFException {

			ModelRel newModelRelType = (ModelRel) RelationshipFactory.eINSTANCE.create(modelRelTypeClass);
			addLightModelType(newModelRelType, modelRelType, newModelRelTypeName, constraint);
			//TODO MMTF: how to make the user choose unbounded?
			newModelRelType.setUnbounded(modelRelType.isUnbounded());

			//TODO MMTF: decide what to do when inheriting here
			// models and containers
			if (srcModelType != null && tgtModelType != null) { // binary model relationship type
				newModelRelType.getModels().add(srcModelType);
				ModelReference newSrcModelTypeRef = createLightModelTypeRef(newModelRelType, srcModelType);
//				for (ModelReference modelTypeRef : modelRelType.getModelRefs()) {
//					if (isSubtypeOf(srcModelType.getUri(), ((Model) modelTypeRef.getObject()).getUri())) {
//						for (ModelElementReference modelElemTypeRef : modelTypeRef.getElementRefs()) {
//							ModelElement modelElemType = (ModelElement) modelElemTypeRef.getObject();
//							createLightModelElementType(newSrcModelTypeRef, "Src" + modelElemType.getName(), modelElemType.getPointer());
//						}
//						break;
//					}
//				}
				newModelRelType.getModels().add(tgtModelType);
				ModelReference newTgtModelTypeRef = createLightModelTypeRef(newModelRelType, tgtModelType);
//				for (ModelReference modelTypeRef : modelRelType.getModelRefs()) {
//					if (isSubtypeOf(tgtModelType.getUri(), ((Model) modelTypeRef.getObject()).getUri())) {
//						for (ModelElementReference modelElemTypeRef : modelTypeRef.getElementRefs()) {
//							ModelElement modelElemType = (ModelElement) modelElemTypeRef.getObject();
//							createLightModelElementType(newTgtModelTypeRef, "Tgt" + modelElemType.getName(), modelElemType.getPointer());
//						}
//						break;
//					}
//				}
			}
			else {
				for (ModelReference modelTypeRef : modelRelType.getModelRefs()) {
					Model modelType = (Model) modelTypeRef.getObject();
					newModelRelType.getModels().add(modelType);
					ModelReference newModelTypeRef = createLightModelTypeRef(newModelRelType, modelType);
					// model elements
//					for (ModelElementReference modelElemTypeRef : modelTypeRef.getElementRefs()) {
//						ModelElement modelElemType = (ModelElement) modelElemTypeRef.getObject();
//						createLightModelElementType(newModelTypeRef, modelElemType.getName(), modelElemType.getPointer());
//					}
				}
			}

			// links
//			for (Link linkType : modelRelType.getLinks()) {
//				Link newLinkType = createLightLinkType(newModelRelType, null, null, linkType.getName(), linkType.eClass());
//				newLinkType.setUnbounded(linkType.isUnbounded());
//				// link elements
//				for (ModelElementReference modelElemTypeRef : linkType.getElementRefs()) {
//					for (ModelReference newModelTypeRef : newModelRelType.getModelRefs()) {
//						for (ModelElementReference newModelElemTypeRef : newModelTypeRef.getElementRefs()) {
//							if (
//								newModelElemTypeRef.getName().equals(modelElemTypeRef.getName()) || (
//									(srcModelType != null && tgtModelType != null) && (
//										newModelElemTypeRef.getName().equals("Src" + modelElemTypeRef.getName()) ||
//										newModelElemTypeRef.getName().equals("Tgt" + modelElemTypeRef.getName())
//									)
//								)
//							) {
//								newLinkType.getElementRefs().add(newModelElemTypeRef);
//							}
//						}
//					}
//				}
//			}

			return newModelRelType;
		}

		public static ModelElementReference createLightModelElementType(ModelReference modelTypeRef, String newModelElemTypeName, EObject droppedElement) throws MMTFException {

			ModelRel modelRelType = (ModelRel) modelTypeRef.eContainer();
			MultiModel multiModel = (MultiModel) modelRelType.eContainer();
			Model modelType = (Model) modelTypeRef.getObject();

			// always create model element, it is specific of the model relationship type even if another one uses the same dropped element
			ModelElement newModelElemType = MidFactory.eINSTANCE.createModelElement();
			ModelElementCategory category = (droppedElement instanceof EReference) ?
				ModelElementCategory.RELATIONSHIP :
				ModelElementCategory.ENTITY;
			String classLiteral = getDroppedElementClassLiteral(MidLevel.TYPES, droppedElement);
			newModelElemType.setCategory(category);
			newModelElemType.setClassLiteral(classLiteral);
			//TODO MMTF: think about next assignment
			newModelElemTypeName = classLiteral;
			addLightExtendibleType(newModelElemType, null, modelRelType.getName() + "/" + newModelElemTypeName, newModelElemTypeName, multiModel);
			modelType.getElements().add(newModelElemType);

			// create model element reference
			ModelElementReference newModelElemTypeRef = RelationshipFactory.eINSTANCE.createModelElementReference();
			newModelElemTypeRef.setReferencedObject(newModelElemType); // standalone model relationship here don't exist
			modelTypeRef.getElementRefs().add(newModelElemTypeRef);

			return newModelElemTypeRef;
		}

		public static Link createLightLinkType(ModelRel modelRelType, ModelElementReference srcModelElemTypeRef, ModelElementReference tgtModelElemTypeRef, String newLinkTypeName, EClass newLinkTypeClass) throws MMTFException {

			MultiModel multiModel = (MultiModel) modelRelType.eContainer();
			Link newLinkType = (Link) RelationshipFactory.eINSTANCE.create(newLinkTypeClass);
			addLightExtendibleType(newLinkType, null, modelRelType.getName() + "/" + newLinkTypeName, newLinkTypeName, multiModel);
			//TODO MMTF: how to make the user choose unbounded?
			newLinkType.setUnbounded(true);
			modelRelType.getLinks().add(newLinkType);

			// binary link type
			if (srcModelElemTypeRef != null && tgtModelElemTypeRef != null) {
				newLinkType.getElementRefs().add(srcModelElemTypeRef);
				newLinkType.getElementRefs().add(tgtModelElemTypeRef);
			}

			return newLinkType;
		}

		/**
		 * Removes a model type from the repository.
		 * 
		 * @param modelType
		 *            The model type to be removed.
		 */
		public static void removeModelType(Model modelType) {
			String uri = modelType.getUri();
			MultiModel multiModel = (MultiModel) modelType.eContainer();
			
			ArrayList<String> delOperatorTypes = new ArrayList<String>();
			ArrayList<String> delModelTypes = new ArrayList<String>();
			
			ExtendibleElement removedElement = multiModel.getExtendibleTable().removeKey(uri);
			if (removedElement != null && removedElement instanceof Model) {
				Model model = (Model) removedElement;
				multiModel.getModels().remove(model);
				// remove operator types that use the model type
				for (Operator operatorType : multiModel.getOperators()) {
					for (Parameter par : operatorType.getInputs()) {
						if (par.getModel().getUri().equals(uri)) {
							delOperatorTypes.add(operatorType.getUri());
						}
					}
					for (Parameter par : operatorType.getOutputs()) {
						if (par.getModel().getUri().equals(uri)) {
							delOperatorTypes.add(operatorType.getUri());
						}
					}
				}
				for (String operatorType : delOperatorTypes) {
					removeOperatorType(operatorType);
				}
				// remove model elements, if any
				for (ModelElement element : model.getElements()) {
					multiModel.getExtendibleTable().removeKey(element.getUri());
				}
				// remove model relationship specific structures
				if (model instanceof ModelRel) {
					for (Link link : ((ModelRel) model).getLinks()) {
						multiModel.getExtendibleTable().removeKey(link.getUri());
					}
				}
				// remove model relationships that use this model, and subtypes
				for (Model relatedModel : MMTFRegistry.getModelTypes()) {
					// model relationships
					if (relatedModel instanceof ModelRel) {
						if (((ModelRel) relatedModel).getModels().contains(model)) {
							delModelTypes.add(relatedModel.getUri());
						}
					}
					// subtypes
					if (MMTFRegistry.isSubtypeOf(relatedModel.getUri(), uri)) {
						delModelTypes.add(relatedModel.getUri());
					}
				}
				for (String relatedModelType : delModelTypes) {
					Model relatedModel = (Model)multiModel.getExtendibleTable().get(relatedModelType);
					if (relatedModel != null) removeModelType(relatedModel);
				}
			}
		}
		
		public static void removeLightModelTypeRef(ModelRel modelRelType, Model modelType) {
			ArrayList<ModelReference> delModelRefs = new ArrayList<ModelReference>();
			MultiModel multiModel = (MultiModel) modelRelType.eContainer();
			//TODO MMTF: if I enable binary rels to self how can I distinguish the right model ref to delete (every ref must be bidirectional)
			for (ModelReference modelTypeRef : modelRelType.getModelRefs()) {
				if (modelTypeRef.getObject() == modelType) {
					delModelRefs.add(modelTypeRef);
					ArrayList<Link> delLinkTypes = new ArrayList<Link>();
					for (ModelElementReference modelElemTypeRef : modelTypeRef.getElementRefs()) {
						modelType.getElements().remove(modelElemTypeRef.getObject());
						multiModel.getExtendibleTable().removeKey(((ModelElement) modelElemTypeRef.getObject()).getUri());
						for (Link linkType : modelElemTypeRef.getLinks()) {
							// binary link types have no longer sense, delete them later to avoid concurrent modification problems
							if (linkType instanceof BinaryLink) {
								delLinkTypes.add(linkType);
							}
						}
						modelElemTypeRef.getLinks().clear();
					}
					for (Link delLinkType : delLinkTypes) {
						delLinkType.getElementRefs().clear();
						modelRelType.getLinks().remove(delLinkType);
						multiModel.getExtendibleTable().removeKey(delLinkType.getUri());
					}
					break;
				}
			}
			for (ModelReference modelTypeRef : delModelRefs) {
				modelRelType.getModelRefs().remove(modelTypeRef);
			}
		}

		public static void removeLightLinkType(Link linkType) {

			MultiModel multiModel = (MultiModel) linkType.eContainer().eContainer();
			multiModel.getExtendibleTable().removeKey(linkType.getUri());
		}

		public static void removeLightModelElementTypeRef(ModelElementReference modelElemTypeRef) {

			MultiModel multiModel = (MultiModel) modelElemTypeRef.eContainer().eContainer().eContainer();
			ModelElement modelElemType = (ModelElement) modelElemTypeRef.getObject();
			((Model) modelElemType.eContainer()).getElements().remove(modelElemType);
			multiModel.getExtendibleTable().removeKey(modelElemType.getUri());
			for (Link linkType : modelElemTypeRef.getLinks()) {
				// binary link types have no longer sense, delete them
				if (linkType instanceof BinaryLink) {
					linkType.getElementRefs().clear();
					((ModelRel) linkType.eContainer()).getLinks().remove(linkType);
					multiModel.getExtendibleTable().removeKey(linkType.getUri());
				}
			}
		}

		public static EList<String> getSupertypeUris(String subtypeUri) {

			EList<String> supertypeUris = new BasicEList<String>();
			for (String supertypeUri : substitutabilityTable.get(subtypeUri)) {
				if (conversionTable.get(subtypeUri).get(supertypeUri).isEmpty()) {
					supertypeUris.add(supertypeUri);
				}
			}

			return supertypeUris;
		}

		public static boolean isSubtypeOf(String subtypeUri, String supertypeUri) {

			return
				substitutabilityTable.get(subtypeUri).contains(supertypeUri) &&
				conversionTable.get(subtypeUri).get(supertypeUri).isEmpty();
		}

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
		 * Gets a model type.
		 * 
		 * @param modelTypeUri
		 *            The uri of the model type.
		 * @return The model type, or null if its uri is not found or found not
		 *         to be a model.
		 */
		public static Model getModelType(String modelTypeUri) {

			ExtendibleElement model = getExtendibleType(modelTypeUri);
			if (model instanceof Model) {
				return (Model) model;
			}
			return null;
		}

		/**
		 * Gets a model relationship type.
		 * 
		 * @param modelRelTypeUri
		 *            The uri of the model relationship type.
		 * @return The model relationship type, or null if its uri is not found
		 *         or found not to be a model relationship.
		 */
		public static ModelRel getModelRelType(String modelRelTypeUri) {

			ExtendibleElement modelRel = getExtendibleType(modelRelTypeUri);
			if (modelRel instanceof ModelRel) {
				return (ModelRel) modelRel;
			}
			return null;
		}

		/**
		 * Gets a model element type.
		 * 
		 * @param modelElemTypeUri
		 *            The uri of the model element type.
		 * @return The model element type, or null if its uri is not found or
		 *         found not to be a model element.
		 */
		public static ModelElement getModelElementType(String modelElemTypeUri) {

			ExtendibleElement element = getExtendibleType(modelElemTypeUri);
			if (element instanceof ModelElement) {
				return (ModelElement) element;
			}
			return null;
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
		 * Gets the list of registered model relationship types.
		 * 
		 * @return The list of registered model relationship types.
		 */
		public static EList<ModelRel> getModelRelTypes() {

			EList<ModelRel> modelRels = new BasicEList<ModelRel>();
			for (Model model : getModelTypes()) {
				if (model instanceof ModelRel) {
					modelRels.add((ModelRel) model);
				}
			}

			return modelRels;
		}

		/**
		 * Gets the list of registered link types for a model relationship type.
		 * 
		 * @param modelRelType
		 *            The model relationship type.
		 * 
		 * @return The list of registered link types for a model relationship
		 *         type.
		 */
		public static EList<Link> getLinkTypes(ModelRel modelRelType) {

			return modelRelType.getLinks();
		}

		/**
		 * Gets the list of registered model element types for a model type.
		 * 
		 * @param modelType
		 *            The model type.
		 * 
		 * @return The list of registered model element types for a model type.
		 */
		public static EList<ModelElement> getModelElementTypes(Model modelType) {

			return modelType.getElements();
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
		public static EList<Editor> getModelTypeEditors(String modelTypeUri) {

			Model model = getModelType(modelTypeUri);
			if (model != null) {
				return model.getEditors();
			}
			else {
				return ECollections.emptyEList();
			}
		}

		/**
		 * Gets a tree dialog to select among registered model types' editors.
		 * 
		 * @return The tree dialog.
		 */
		public static ElementTreeSelectionDialog getModelCreationDialog() {

			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell,
				new RepositoryTypesDialogLabelProvider(),
				new MidTypesDialogContentProvider(repository, null, false, true, false, true)
			);
			dialog.setValidator(new RepositoryDialogSelectionValidator());
			dialog.setInput(repository);

			return dialog;
		}

		/**
		 * Gets a tree dialog to select among registered model relationship
		 * types that can fit model source and target (are both null in case of
		 * nary model relationship).
		 * 
		 * @return The tree dialog.
		 */
		public static ElementTreeSelectionDialog getModelRelCreationDialog(Model source, Model target) {

			EList<String> modelRelTypeUris = null;

			if (source != null && target != null) {

				String sourceTypeUri = source.getMetatypeUri();
				EList<String> sourceSupertypeUris = getSupertypeUris(sourceTypeUri);
				String targetTypeUri = target.getMetatypeUri();
				EList<String> targetSupertypeUris = getSupertypeUris(targetTypeUri);
				modelRelTypeUris = new BasicEList<String>();

				for (ModelRel modelRelType : MMTFRegistry.getModelRelTypes()) {

					// check cardinality
					if (!(modelRelType.isUnbounded() || modelRelType instanceof BinaryModelRel)) {
						continue;
					}
					// check allowed model types
					boolean okSource = false;
					boolean okTarget = false;
					for (Model modelType : modelRelType.getModels()) {
						String modelTypeUri = modelType.getUri();
						if (!okSource && (modelTypeUri.equals(sourceTypeUri) || sourceSupertypeUris.contains(modelTypeUri))) {
							okSource = true;
						}
						if (!okTarget && (modelTypeUri.equals(targetTypeUri) || targetSupertypeUris.contains(modelTypeUri))) {
							okTarget = true;
						}
						if (okSource && okTarget) {
							modelRelTypeUris.add(modelRelType.getUri());
							break;
						}
					}
				}
			}

			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell,
				new RepositoryTypesDialogLabelProvider(),
				new MidTypesDialogContentProvider(repository, modelRelTypeUris, true, false, true, false)
			);
			dialog.setInput(repository);

			return dialog;
		}

		/**
		 * Gets a tree dialog to select among registered link types that can fit
		 * model element reference source and target (are both null in case of
		 * nary link).
		 * 
		 * @return The tree dialog.
		 */
		public static ElementTreeSelectionDialog getLinkCreationDialog(ModelRel modelRel, ModelElementReference source, ModelElementReference target) {

			EList<String> linkTypeUris = null;
			ModelRel modelRelType = modelRel.getMetatype();

			if (source != null && target != null) {

				//TODO MMTF: supertypes are not computed yet for model elements and links, do I really need them?
				String sourceTypeUri = source.getObject().getMetatypeUri();
				EList<String> sourceSupertypeUris = new BasicEList<String>();
				//EList<String> sourceSupertypeUris = getSupertypeUris(sourceTypeUri);
				String targetTypeUri = target.getObject().getMetatypeUri();
				EList<String> targetSupertypeUris = new BasicEList<String>();
				//EList<String> targetSupertypeUris = getSupertypeUris(targetTypeUri);
				linkTypeUris = new BasicEList<String>();

				for (Link linkType : MMTFRegistry.getLinkTypes(modelRelType)) {

					// check cardinality
					if (!(linkType.isUnbounded() || linkType instanceof BinaryLink)) {
						continue;
					}
					// check allowed model element types
					//TODO MMTF: here I shoud check direction and actual endpoint for binary differently than nary
					boolean okSource = false;
					boolean okTarget = false;
					for (ModelElementReference elementTypeRef : linkType.getElementRefs()) {
						String elementTypeUri = ((ModelElement) elementTypeRef.getObject()).getUri();
						if (!okSource && (elementTypeUri.equals(sourceTypeUri) || sourceSupertypeUris.contains(elementTypeUri))) {
							okSource = true;
						}
						if (!okTarget && (elementTypeUri.equals(targetTypeUri) || targetSupertypeUris.contains(elementTypeUri))) {
							okTarget = true;
						}
						if (okSource && okTarget) {
							linkTypeUris.add(linkType.getUri());
							break;
						}
					}
				}
			}

			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell,
				new RepositoryTypesDialogLabelProvider(),
				new RelationshipTypesDialogContentProvider(modelRelType, linkTypeUris, true)
			);
			dialog.setInput(modelRelType);

			return dialog;
		}

		/**
		 * Gets a tree dialog to select among registered model types.
		 * 
		 * @return The tree dialog.
		 */
		public static ElementTreeSelectionDialog getModelTypeCreationDialog(MultiModel multiModel) {

			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell,
				new RepositoryTypesDialogLabelProvider(),
				new MidTypesDialogContentProvider(multiModel, null, true, true, false, false)
			);
			dialog.setInput(multiModel);

			return dialog;
		}

		/**
		 * Gets a tree dialog to select among registered model relationship
		 * types.
		 * 
		 * @return The tree dialog.
		 */
		public static ElementTreeSelectionDialog getModelRelTypeCreationDialog(MultiModel multiModel, String srcModelTypeUri, String tgtModelTypeUri) {

			EList<String> modelRelTypeUris = null;

			if (srcModelTypeUri != null && tgtModelTypeUri != null) {

				EList<String> srcSupertypeUris = getSupertypeUris(srcModelTypeUri);
				EList<String> tgtSupertypeUris = getSupertypeUris(tgtModelTypeUri);
				modelRelTypeUris = new BasicEList<String>();

				for (ModelRel modelRelType : MMTFRegistry.getModelRelTypes()) {

					// check cardinality
					if (!(modelRelType.isUnbounded() || modelRelType instanceof BinaryModelRel)) {
						continue;
					}
					// check allowed model types
					boolean okSrc = false;
					boolean okTgt = false;
					for (Model modelType : modelRelType.getModels()) {
						String modelTypeUri = modelType.getUri();
						if (!okSrc && (modelTypeUri.equals(srcModelTypeUri) || srcSupertypeUris.contains(modelTypeUri))) {
							okSrc = true;
						}
						if (!okTgt && (modelTypeUri.equals(tgtModelTypeUri) || tgtSupertypeUris.contains(modelTypeUri))) {
							okTgt = true;
						}
						if (okSrc && okTgt) {
							modelRelTypeUris.add(modelRelType.getUri());
							break;
						}
					}
				}
			}

			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell,
				new RepositoryTypesDialogLabelProvider(),
				new MidTypesDialogContentProvider(multiModel, modelRelTypeUris, true, false, true, false)
			);
			dialog.setInput(multiModel);

			return dialog;
		}

		/**
		 * Gets a parameter's signature.
		 * 
		 * @param parameter
		 *            The parameter.
		 * @return The parameter's signature.
		 */
		private static String getParameterSignature(Parameter parameter) {

			String signature = parameter.getModel().getName();
			if (parameter.isVararg()) {
				signature += "...";
			}
			signature += " " + parameter.getName();

			return signature;
		}

		/**
		 * Gets an operator's signature.
		 * 
		 * @param operator
		 *            The operator.
		 * @return The operator's signature.
		 */
		public static String getOperatorSignature(Operator operator) {

			// output parameters
			String signature = "[";
			for (Parameter parameter : operator.getOutputs()) {
				signature += getParameterSignature(parameter) + ", ";
			}
			if (operator.getOutputs().size() > 0) {
				signature = signature.substring(0, signature.length() - 2);
			}
			signature += "] ";

			// operator name
			signature += operator.getName() + "(";

			// input parameters
			for (Parameter parameter : operator.getInputs()) {
				signature += getParameterSignature(parameter) + ", ";
			}
			if (operator.getInputs().size() > 0) {
				signature = signature.substring(0, signature.length() - 2);
			}
			signature += ")";

			return signature;
		}

		private static EList<ConversionOperator> isEligibleParameter(Model actualParameter, Model formalParameter) {

			EList<String> actualUris = new BasicEList<String>();
			for (int i = 0; i < actualParameter.getRuntimeMetatypes().size(); i++) {
				actualUris.add(
					((Model) actualParameter.getRuntimeMetatypes().get(i)).getUri()
				);
			}
			String formalUri = formalParameter.getUri();
			EList<ConversionOperator> result = null;

			// exact type
			if (actualUris.contains(formalUri)) {
				result = new BasicEList<ConversionOperator>();
			}
			// substitutable type
			else {
				for (String actualUri : actualUris) {
					if (substitutabilityTable.get(actualUri).contains(formalUri)) {
						// use first substitution found
						result = conversionTable.get(actualUri).get(formalUri);
						break;
					}
				}
			}

			return result;
		}

		public static EList<Operator> getExecutableOperators(EList<Model> actualParameters, EList<HashMap<Integer, EList<ConversionOperator>>> conversions) {

			EList<Operator> executableOperators = new BasicEList<Operator>();

nextOperator:
			for (Operator operator : repository.getOperators()) {
				int i = 0;
				HashMap<Integer, EList<ConversionOperator>> conversionMap = new HashMap<Integer, EList<ConversionOperator>>();
				for (Parameter parameter : operator.getInputs()) {
					// check 1: not enough actual parameters
					if (i >= actualParameters.size()) {
						continue nextOperator;
					}
					// check 2: type or substitutable types
					while (i < actualParameters.size()) {
						EList<ConversionOperator> conversionList = isEligibleParameter(actualParameters.get(i), parameter.getModel());
						if (conversionList == null) {
							continue nextOperator;
						}
						if (!conversionList.isEmpty()) {
							conversionMap.put(new Integer(i), conversionList);
						}
						i++;
						if (!parameter.isVararg()) {
							//TODO MMTF: introduce vararg with low multeplicity
							break;
						}
					}
				}
				// check 3: too many actual parameters
				if (i < actualParameters.size()) {
					continue nextOperator;
				}
				// checks passed
				executableOperators.add(operator);
				conversions.add(conversionMap);
			}

			return executableOperators;
		}

		public static EObject getModelTypeMetamodelElement(Model modelType, String metamodelFragment) {

			String[] literals = metamodelFragment.split("/");
			EObject elemPointer = ((EPackage) modelType.getRoot()).getEClassifier(literals[0]);
			if (literals.length > 1) {
				elemPointer = ((EClass) elemPointer).getEStructuralFeature(literals[1]);
			}

			return elemPointer;
		}

		public static String getDroppedElementClassLiteral(MidLevel level, EObject droppedElement) {

			String classLiteral;
			if (level == MidLevel.TYPES) {
				classLiteral = (droppedElement instanceof EReference) ?
					((EReference) droppedElement).getEContainingClass().getName() + "/" + ((EReference) droppedElement).getName() :
					((EClass) droppedElement).getName();
			}
			else {
				//TODO MMTF: EReference is probably wrong here, we should try
				classLiteral = (droppedElement instanceof EReference) ?
					((EReference) droppedElement).getEContainingClass().getName() + "/" + ((EReference) droppedElement).getName() :
					droppedElement.eClass().getName();
			}

			return classLiteral;
		}

	}

}
