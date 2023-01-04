/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.prefs.BackingStoreException;

import edu.toronto.cs.se.mmint.extensions.ExtensionPointType;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoner;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDEcoreUtil;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;

/**
 * Model Management is the management of collections of related models. It
 * provides tools and techniques for dealing with large collections of models
 * (mega-modeling), defining relationships among models, automatically
 * manipulating models and relationships using operators (i.e.,
 * transformations).
 *
 * The Model Management Tool Framework (MMINT) is an Eclipse-based framework for
 * rapidly developing model management tools emphasizing graphical, interactive
 * model management with strong typing.
 *
 * MMINT facilitates interactive model management both at the type and instance
 * levels. It provides a graphical form of mega-model called a Model
 * Interconnection Diagram (MID) as the interface through which to perform
 * actions. The type MID allows the user to view and modify the
 * model/relationship/operator type hierarchy at runtime, while an instance MID
 * is used to interactively create instances of model/relationship types and to
 * apply operators to them.
 *
 * @author Alessio Di Sandro
 *
 */
public class MMINT implements MMINTConstants {

	/** The singleton instance. */
	static final MMINT INSTANCE = new MMINT();
	/** The default "heavy" type factory. */
	static MIDHeavyTypeFactory typeFactory;
	/** The Type MID in memory. */
	static MID cachedTypeMID;
	/**	The table for subtyping in the repository. */
	static Map<String, Set<String>> subtypes;
	/**	The table for model type conversion in the repository. */
	static Map<String, Map<String, Set<List<String>>>> conversions;
	/**	The table for subtyping in the Type MID. */
	static Map<String, Set<String>> subtypesMID;
	/**	The table for model type conversion in the Type MID. */
	static Map<String, Map<String, Set<List<String>>>> conversionsMID;
	/** The table to map type uris to their bundle name. */
	static Map<String, String> bundleTable;
  /** The reasoning traits **/
  static Map<String, Object> traits;
	/** The reasoners. */
	static Map<String, IReasoner> reasoners;
	/** The cache of runtime types. */
	static Map<ExtendibleElement, List<? extends ExtendibleElement>> cachedRuntimeTypes;
	/** The cached MID view provider */
	static IViewProvider cachedMIDViewProvider;
	/** The file containing the active instance MID (i.e. the one that triggered an operation) */
	static IFile activeInstanceMIDFile;
	/**
	 * The table to have some very poor sort of multiple inheritance,
	 * i.e. to have UML_MAVO properly recognized.
	 * TODO MMINT[MID] redo when needed!
	 */
	static Map<String, Set<String>> multipleInheritanceTable;
	/** The type MID filename. */
	public static final String TYPEMID_FILENAME = "types" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;

	/* TODO MMINT[IN PROGRESS WORKFLOW]
	 * - Add the ability to exclude arbitrary intermediate results from output (because they could be not used as inputs to subsequent operators)
	 * - Support conversions in workflows?
	 * - Create scripting language
	 * - Assumption that instance uris are unique is wrong?
	 * -- have multiple models point to same file and a way to count references for file deletion
	 * -- stop relying on gmf shortcuts
	 * -- find a way to formalize MIDRels (e.g. should act like a model rel and have endpoints for grabbing other mids)
	 */
	/* TODO MMINT[IN PROGRESS OPERATOR] Work on operators:
	 * - Add a polymorphism submenu for type substitutability (coercion)
	 * - Use multiple dispatch in workflows outside of Map, e.g. a slice(Model, Model) should adapt to the actual arguments
	 * - Don't create a root operator and root model type endpoints, that is not what happens in programming languages
	 * - Use apis that are aware of this difference, but still allow for inheritance, aka overloading/overriding
	 * - Add operator support in hierarchy tables and apis
	 * - Use output constraint to validate output in normal operators?
	 * - Rethink ConversionOperator to be a simple workflow
	 * - Rewrite ExperimentDriver to be a workflow
	 */
	/* TODO MMINT[PACKAGING]
	 * - Put generic enough models and operators into Types-style projects
	 * - Put things specific to papers/demos in other projects
	 * - Create features to pull all requirements for papers/demos + examples
	 */
	/* TODO MMINT[USABILITY]
	 * - Add an alternative way of having documentation for types, e.g. a description field or an acceleo-generated web page
	 * - Change uris into ids
	 * - There should be different classes rather than MID levels, e.g. Model <- ModelType, ModelInstance
	 * - Similarly, there should be a ModelRelModelEndpoint and an OperatorModelEndpoint
	 * - The root element should be called MIDObject and not ExtendibleElement
	 * - Simplify the type system of model rels
	 * - Handle optional uris/ids for subelements of model/modelrel/operator
	 * - Use defaults and optionals in extension points as much as possible
	 * - Move modelepedia types/operators into the examples directory together with papers + create appropriate features
	 * - Transform various labels into toString() functions (helps debug too)
	 * - Turn updateMID into global option and use it directly into apis
	 * - Address the issue of not inheriting Editor and Diagram types; this will fix a model type without editor, which is still able to use the reflective ecore
	 * - Review and unify all mid apis (e.g. add possibility to pass name)
	 * - Add createBinaryInstance/Subtype() to Mapping
	 * - Rethink link icons in mids with/without MAVO (problem is they're detached from the label)
	 * - Add documentation ->
	 *   a) Prerequisite: review apis for mid construction and destruction
	 *   b) Take every api function
	 *   c) Check usage and delete if unnecessary
	 *   d) Add @NonNull/@Nullable annotations + javadoc
	 *   e) Make a proper user guide online
	 * - Avoid drawing inheritance links for root elements? Tried, but does not improve things, this is how to do it in MIDCanonicalEditPolicy:
			IElementType elementType = (IElementType) nextLinkDescriptor.getSemanticAdapter().getAdapter(IElementType.class);
			String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
			int visualID = MIDVisualIDRegistry.getVisualID(elementTypeHint);
			if (visualID == ExtendibleElementSupertypeEditPart.VISUAL_ID) {
				if (MIDTypeHierarchy.isRootType((ExtendibleElement) nextLinkDescriptor.getDestination())) {
					continue;
				}
			}
	 */
	/* TODO MMINT[MATURITY]
	 * - Use workflows to create test cases, and run tests at every commit
	 * - Export an instance mid as workflow
	 * - Address todos
	 * - Resource change listeners to track changes in model elements
	 * - Formalize override semantics
	 * - Formalize type introspection
	 * - Introduce intermediate level between model element and model element reference, contained in model endpoints
	 * - Support standalone model rels (in their own file)
	 * - Can operators detect input/output by code inspection rather than plugin.xml?
	 * - Replace ocl constraints with java in gmfmap
	 * - Refactor functions in mid.ecore like getMetatype() using generics (and rename that to getType())
	 * - ExtendibleElementReference.containedObject is completely useless
	 * - Remove all operation implementations from mid.ecore
	 * - Simplify binary types xml config and support binary non-directional
	 */

	private static void createTypeConstraint(IConfigurationElement extensionConfig, ExtendibleElement constrainedType, MIDHeavyTypeFactory typeFactory) {

		var constraintConfig = extensionConfig.getChildren(MMINTConstants.CHILD_CONSTRAINT);
		var constraintLanguage = (constraintConfig.length == 0) ?
			null :
			constraintConfig[0].getAttribute(MMINTConstants.CONSTRAINT_ATTR_LANGUAGE);
		var constraintImplementation = (constraintConfig.length == 0) ?
			null :
			constraintConfig[0].getAttribute(MMINTConstants.CONSTRAINT_ATTR_IMPLEMENTATION);
		if (constraintLanguage != null && constraintImplementation != null) {
			typeFactory.createHeavyTypeConstraint(constraintLanguage, constraintImplementation, constrainedType);
		}
	}

	/**
	 * Creates and adds a model type to the repository from a registered
	 * edu.toronto.cs.se.mmint.models extension. Requires the model type package
	 * to be registered through a org.eclipse.emf.ecore.generated_package
	 * extension.
	 *
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmint.models extension configuration.
	 * @return The created model type, null if the model type can't be created.
	 * @throws MMINTException
	 *             If the model type can't be created.
	 */
	public static Model createModelType(IConfigurationElement extensionConfig) throws MMINTException {

		var extensionType = new ExtensionPointType(extensionConfig, MMINT.multipleInheritanceTable, MMINT.typeFactory);
		if (extensionType.getUri() == null) {
			throw new MMINTException("Model type " + extensionType.getName() + " must have a uri");
		}
		var newModelType = extensionType.getFactory().createHeavyModelType(extensionType);
		createTypeConstraint(extensionConfig, newModelType, extensionType.getFactory());

		return newModelType;
	}

	/**
	 * Creates and adds a model relationship type to the repository from a
	 * registered edu.toronto.cs.se.mmint.relationships extension. Requires the
	 * model relationship type package to be registered through a
	 * org.eclipse.emf.ecore.generated_package extension.
	 *
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmint.relationships extension
	 *            configuration.
	 * @return The created model relationship type, null if the model
	 *         relationship type can't be created.
	 * @throws Exception
	 *             If the model relationship type can't be created.
	 */
	public static ModelRel createModelRelType(IConfigurationElement extensionConfig) throws Exception {

		var modelTypeConfig = extensionConfig.getChildren(MMINTConstants.MODELS_CHILD_MODELTYPE)[0];
		var modelRelExtensionType = new ExtensionPointType(modelTypeConfig, MMINT.typeFactory);
		ExtensionPointType extensionType;
		if (modelRelExtensionType.getUri() == null) {
			throw new MMINTException("Model relationship type " + modelRelExtensionType.getName() + " must have a uri");
		}
		var binaryTypeConfigs = extensionConfig.getChildren(MMINTConstants.CHILD_BINARYTYPE);
		var isBinary = (binaryTypeConfigs.length == 0) ? false : true;
		var newModelRelType = modelRelExtensionType.getFactory().createHeavyModelRelType(
			modelRelExtensionType,
			isBinary
		);
		createTypeConstraint(modelTypeConfig, newModelRelType, modelRelExtensionType.getFactory());
    // binary model rel type
		String srcModelTypeUri = null, tgtModelTypeUri = null;
    if (isBinary) {
      srcModelTypeUri = binaryTypeConfigs[0].getAttribute(MMINTConstants.BINARYTYPE_ATTR_SOURCETYPEURI);
      tgtModelTypeUri = binaryTypeConfigs[0].getAttribute(MMINTConstants.BINARYTYPE_ATTR_TARGETTYPEURI);
    }
		// model type endpoints
    var newModelElemTypeRefs = new HashMap<String, ModelElementReference>();
		var modelTypeEndpointConfigs = extensionConfig.getChildren(MMINTConstants.MODELRELS_CHILD_MODELTYPEENDPOINT);
		for (var i = 0; i < modelTypeEndpointConfigs.length; i++) {
		  var modelTypeEndpointConfig = modelTypeEndpointConfigs[i];
			extensionType = new ExtensionPointType(modelTypeEndpointConfig, MMINT.typeFactory);
			var modelTypeEndpointSubconfig = modelTypeEndpointConfig.getChildren(MMINTConstants.CHILD_TYPEENDPOINT)[0];
			var targetModelTypeUri = modelTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_TARGETTYPEURI);
			var targetModelType = MIDTypeRegistry.<Model>getType(targetModelTypeUri);
			if (targetModelType == null) {
				MMINTException.print(IStatus.WARNING, "Target model type " + targetModelTypeUri + " can't be found, skipping it", null);
				continue;
			}
      var isBinarySrc = isBinary && ( // required
                          (srcModelTypeUri.equals(tgtModelTypeUri) && i == 0) || // same-type endpoints
                          srcModelTypeUri.equals(targetModelTypeUri)); // "normal" case
			var newModelTypeEndpointRef = modelRelExtensionType.getFactory().createHeavyModelTypeEndpointAndModelTypeEndpointReference(
				extensionType,
				targetModelType,
				isBinarySrc,
				newModelRelType
			);
			var lowerBoundString = modelTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_LOWERBOUND);
			var lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
			var upperBoundString = modelTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_UPPERBOUND);
			var upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
			MIDTypeFactory.addTypeEndpointCardinality(
				newModelTypeEndpointRef.getObject(),
				lowerBound,
				upperBound
			);
			var rootModelTypeObj = newModelTypeEndpointRef.getObject().getTarget().getEMFTypeRoot();
			// model element types
			var modelElemTypeConfigs = modelTypeEndpointConfig.getChildren(MMINTConstants.MODELRELS_MODELTYPEENDPOINT_CHILD_MODELELEMTYPE);
			for (var modelElemTypeConfig : modelElemTypeConfigs) {
				extensionType = new ExtensionPointType(modelElemTypeConfig, MMINT.typeFactory);
				var newModelElemType = MIDTypeRegistry.<ModelElement>getType(extensionType.getUri());
				if (newModelElemType == null) { // create new model element type
					var modelElemTypeObj = FileUtils.readModelObject(extensionType.getUri(), rootModelTypeObj.eResource());
					var eInfo = MIDRegistry.getModelElementEMFInfo(modelElemTypeObj, MIDLevel.TYPES);
					try {
						newModelElemType = modelRelExtensionType.getFactory().createHeavyModelElementType(
							extensionType,
							eInfo,
							targetModelType
						);
					}
					catch (Exception e) {
						MMINTException.print(IStatus.WARNING, "Model element type " + extensionType.getUri() + " can't be created, skipping it", e);
						continue;
					}
				}
				var modelElemTypeRef = (extensionType.getSupertypeUri() == null) ?
					null :
					MIDRegistry.getReference(extensionType.getSupertypeUri(), newModelTypeEndpointRef.getModelElemRefs());
				var newModelElemTypeRef = newModelElemType.createTypeReference(modelElemTypeRef, true, newModelTypeEndpointRef);
        newModelElemTypeRefs.put(newModelElemType.getUri(), newModelElemTypeRef);
			}
		}
		// mapping types
		var mappingTypeConfigs = extensionConfig.getChildren(MMINTConstants.MODELRELS_CHILD_MAPPINGTYPE);
		for (var mappingTypeConfig : mappingTypeConfigs) {
			binaryTypeConfigs = mappingTypeConfig.getChildren(MMINTConstants.CHILD_BINARYTYPE);
			isBinary = (binaryTypeConfigs.length == 0) ? false : true;
			extensionType = new ExtensionPointType(mappingTypeConfig, MMINT.typeFactory);
			MappingReference newMappingTypeRef;
			try {
				newMappingTypeRef = modelRelExtensionType.getFactory().createHeavyMappingTypeAndMappingTypeReference(
					extensionType,
					isBinary,
					newModelRelType
				);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Link type " + extensionType.getUri() + " can't be created, skipping it", e);
				continue;
			}
			// binary mapping type
			String srcModelElemTypeUri = null, tgtModelElemTypeUri = null;
			if (isBinary) {
				srcModelElemTypeUri = binaryTypeConfigs[0].getAttribute(MMINTConstants.BINARYTYPE_ATTR_SOURCETYPEURI);
				tgtModelElemTypeUri = binaryTypeConfigs[0].getAttribute(MMINTConstants.BINARYTYPE_ATTR_TARGETTYPEURI);
			}
			// model element type endpoints
			var modelElemTypeEndpointConfigs = mappingTypeConfig.getChildren(MMINTConstants.MODELRELS_MAPPINGTYPE_CHILD_MODELELEMTYPEENDPOINT);
			for (var i = 0; i < modelElemTypeEndpointConfigs.length; i++) {
			  var modelElemTypeEndpointConfig = modelElemTypeEndpointConfigs[i];
				extensionType = new ExtensionPointType(modelElemTypeEndpointConfig, MMINT.typeFactory);
				var modelElemTypeEndpointSubconfig = modelElemTypeEndpointConfig.getChildren(MMINTConstants.CHILD_TYPEENDPOINT)[0];
				var targetModelElemTypeUri = modelElemTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_TARGETTYPEURI);
				var newModelElemTypeRef = newModelElemTypeRefs.get(targetModelElemTypeUri);
				if (newModelElemTypeRef == null) {
					MMINTException.print(IStatus.WARNING, "Target model element type " + targetModelElemTypeUri + " can't be found, skipping it", null);
					continue;
				}
				//TODO MMINT[MODELENDPOINT] well model elements should *really* be contained in the model endpoint now that they exist
				var isBinarySrc = isBinary && ( // required
				                    (srcModelElemTypeUri.equals(tgtModelElemTypeUri) && i == 0) || // same-type endpoints
				                    srcModelElemTypeUri.equals(targetModelElemTypeUri)); // "normal" case
				var newModelElemTypeEndpointRef = modelRelExtensionType.getFactory().createHeavyModelElementTypeEndpointAndModelElementTypeEndpointReference(
					extensionType,
					newModelElemTypeRef,
					isBinarySrc,
					newMappingTypeRef
				);
				var lowerBoundString = modelElemTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_LOWERBOUND);
				var lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
				var upperBoundString = modelElemTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_UPPERBOUND);
				var upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
				MIDTypeFactory.addTypeEndpointCardinality(
					newModelElemTypeEndpointRef.getObject(),
					lowerBound,
					upperBound
				);
			}
		}

		return newModelRelType;
	}

	/**
	 * Creates and adds an editor type to the repository from a registered
	 * edu.toronto.cs.se.mmint.editors extension. Requires the corresponding
	 * Eclipse editor to be registered through a org.eclipse.ui.editors
	 * extension.
	 *
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmint.editors extension configuration.
	 * @return The created editor type, null if the editor type can't be
	 *         created.
	 * @throws MMINTException
	 *             If the editor type can't be created.
	 */
	public static Editor createEditorType(IConfigurationElement extensionConfig) throws MMINTException {

		var extensionType = new ExtensionPointType(extensionConfig, MMINT.typeFactory);
		var modelTypeUri = extensionConfig.getAttribute(MMINTConstants.EDITORS_ATTR_MODELTYPEURI);
		var editorId = extensionConfig.getAttribute(MMINTConstants.EDITORS_ATTR_ID);
		var wizardId = extensionConfig.getAttribute(MMINTConstants.EDITORS_ATTR_WIZARDID);
		var wizardDialogClassName = extensionConfig.getAttribute(MMINTConstants.EDITORS_ATTR_WIZARDDIALOGCLASS);
		var newEditorType = extensionType.getFactory().createHeavyEditorType(
			extensionType,
			modelTypeUri,
			editorId,
			wizardId,
			wizardDialogClassName,
			Boolean.parseBoolean(extensionConfig.getAttribute(MMINTConstants.EDITORS_ATTR_ISDIAGRAM))
		);

		return newEditorType;
	}

	/**
	 * Creates and adds parameter types to an operator type.
	 *
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmint.operators extension subconfiguration for the parameter types.
	 * @param containerOperatorType
	 *            The operator type that will contain the new parameter types.
	 * @param containerFeatureName
	 *            The name of the feature in the operator type that will contain the new parameter types.
	 * @throws MMINTException
	 *             If the parameter types can't be created.
	 */
	private static void createOperatorTypeParameters(IConfigurationElement extensionConfig, Operator containerOperatorType, String containerFeatureName) throws MMINTException {

		var paramTypeConfigs = extensionConfig.getChildren(MMINTConstants.OPERATORS_GENINOUT_CHILD_PARAMETER);
		for (var i = 0; i < paramTypeConfigs.length; i++) {
			var paramTypeConfig = paramTypeConfigs[i];
			var extensionType = new ExtensionPointType(paramTypeConfig, MMINT.typeFactory);
			var modelTypeEndpointSubconfig = paramTypeConfig.getChildren(MMINTConstants.CHILD_TYPEENDPOINT)[0];
			var targetModelTypeUri = modelTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_TARGETTYPEURI);
			Model targetModelType = MIDTypeRegistry.getType(targetModelTypeUri);
			if (targetModelType == null) {
				throw new MMINTException("Target model type " + targetModelTypeUri + " can't be found");
			}
			//TODO MMINT[OPERATOR] Should check that if there is a supertype, the endpoint name can't be changed
			ModelEndpoint newModelTypeEndpoint = extensionType.getFactory().createHeavyModelTypeEndpoint(
				extensionType,
				targetModelType,
				containerOperatorType,
				containerFeatureName
			);
			var lowerBoundString = modelTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_LOWERBOUND);
			var lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
			var upperBoundString = modelTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_UPPERBOUND);
			var upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
			if (upperBound > 1 && i != paramTypeConfigs.length-1) {
				MMINTException.print(IStatus.WARNING, "Only the last input parameter can have an upper bound > 1, setting it to 1", null);
				upperBound = 1;
			}
			MIDTypeFactory.addTypeEndpointCardinality(
				newModelTypeEndpoint,
				lowerBound,
				upperBound
			);
		}
	}

	/**
	 * Creates and adds generic types to an operator type.
	 *
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmint.operators extension subconfiguration for the generic types.
	 * @param containerOperatorType
	 *            The operator type that will contain the new generic types.
	 * @throws MMINTException
	 *             If the generic types can't be created.
	 */
	private static void createOperatorTypeGenerics(IConfigurationElement extensionConfig, Operator containerOperatorType) throws MMINTException {

		var paramTypeConfigs = extensionConfig.getChildren(MMINTConstants.OPERATORS_GENINOUT_CHILD_PARAMETER);
		for (IConfigurationElement paramTypeConfig : paramTypeConfigs) {
			var extensionType = new ExtensionPointType(paramTypeConfig, MMINT.typeFactory);
			var genericTypeEndpointSubconfig = paramTypeConfig.getChildren(MMINTConstants.CHILD_TYPEENDPOINT)[0];
			var targetGenericTypeUri = genericTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_TARGETTYPEURI);
			GenericElement targetGenericType = MIDTypeRegistry.getType(targetGenericTypeUri);
			if (targetGenericType == null) {
				throw new MMINTException("Target generic type " + targetGenericTypeUri + " can't be found");
			}
			GenericEndpoint newGenericTypeEndpoint = extensionType.getFactory().createHeavyGenericTypeEndpoint(
				extensionType,
				targetGenericType,
				containerOperatorType
			);
			var lowerBoundString = genericTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_LOWERBOUND);
			var lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
			var upperBoundString = genericTypeEndpointSubconfig.getAttribute(MMINTConstants.TYPEENDPOINT_ATTR_UPPERBOUND);
			var upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
			MIDTypeFactory.addTypeEndpointCardinality(
				newGenericTypeEndpoint,
				lowerBound,
				upperBound
			);
		}
	}

	public static void createOperatorTypeGenerics(IConfigurationElement extensionConfig) throws MMINTException {

		var genericsParamTypeConfigs = extensionConfig.getChildren(MMINTConstants.OPERATORS_CHILD_GENERICS);
		if (genericsParamTypeConfigs.length > 0) {
			var operatorUri = extensionConfig.getChildren(MMINTConstants.CHILD_TYPE)[0].getAttribute(MMINTConstants.TYPE_ATTR_URI);
			Operator operatorType = MIDTypeRegistry.getType(operatorUri);
			MMINT.createOperatorTypeGenerics(genericsParamTypeConfigs[0], operatorType);
		}
	}

	/**
	 * Creates and adds an editor type to the repository from a registered
	 * edu.toronto.cs.se.mmint.operators extension.
	 *
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmint.operators extension configuration.
	 * @return The created operator type, null if the operator type can't be
	 *         created.
	 * @throws MMINTException
	 *             If the operator type can't be created.
	 */
	public static Operator createOperatorType(IConfigurationElement extensionConfig) throws MMINTException {

	  //TODO MMINT[OPERATOR] Allow abstract operator to have no implementation
		var extensionType = new ExtensionPointType(extensionConfig, MMINT.typeFactory);
		if (extensionType.getUri() == null) {
			throw new MMINTException("Operator type " + extensionType.getName() + " must have a uri");
		}
		Operator newOperatorType = extensionType.getFactory().createHeavyOperatorType(extensionType);
		MMINT.createTypeConstraint(extensionConfig, newOperatorType, extensionType.getFactory());
		var inputsParamTypeConfigs = extensionConfig.getChildren(MMINTConstants.OPERATORS_CHILD_INPUTS);
		if (inputsParamTypeConfigs.length > 0) {
			MMINT.createOperatorTypeParameters(inputsParamTypeConfigs[0], newOperatorType, OperatorPackage.eINSTANCE.getOperator_Inputs().getName());
		}
		var outputsParamTypeConfigs = extensionConfig.getChildren(MMINTConstants.OPERATORS_CHILD_OUTPUTS);
		if (outputsParamTypeConfigs.length > 0) {
			MMINT.createOperatorTypeParameters(outputsParamTypeConfigs[0], newOperatorType, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
		}
		if (newOperatorType instanceof ConversionOperator) {
			MIDTypeFactory.addOperatorTypeConversion((ConversionOperator) newOperatorType);
		}

		return newOperatorType;
	}

	/**
	 * Creates the necessary structures to support subtyping for a type.
	 *
	 * @param type
	 *            The type being evaluated.
	 * @param subtype
	 *            The subtype that is being added in the subtyping table for the
	 *            supertypes of the type.
	 * @param subtypeTable
	 *            The table for subtyping.
	 */
	private static void createSubtypeHierarchy(ExtendibleElement type, ExtendibleElement subtype, Map<String, Set<String>> subtypeTable) {

		// add subtype to supertypes
		var subtypeUri = subtype.getUri();
		var supertype = type.getSupertype();
		if (supertype != null) {
			var supertypeUri = supertype.getUri();
			var subtypes = subtypeTable.get(supertypeUri);
			if (!subtypes.contains(subtypeUri)) {
				subtypes.add(subtypeUri);
				// recursion
				createSubtypeHierarchy(supertype, subtype, subtypeTable);
			}
		}
	}

	/**
	 * Creates the necessary structures to support type conversion for a type.
	 *
	 * @param type
	 *            The type being evaluated.
	 * @param conversionTypes
	 *            The subtable for type conversion.
	 */
	private static void createConversionHierarchy(ExtendibleElement currentType, List<String> prevConversionPath, Map<String, Set<List<String>>> conversionsTo) {

		// add conversions
		for (ConversionOperator conversionOperatorType : ((Model) currentType).getConversionOperators()) {
			if (prevConversionPath.contains(conversionOperatorType.getUri())) { // cycle
				continue;
			}
			var conversionType = conversionOperatorType.getOutputs().get(0).getTarget();
			var conversionPaths = conversionsTo.get(conversionType.getUri()); // handles multiple paths
			if (conversionPaths == null) {
				conversionPaths = new HashSet<>();
				conversionsTo.put(conversionType.getUri(), conversionPaths);
			}
			// keep track of conversion operator used
			List<String> conversionPath = new ArrayList<>(prevConversionPath);
			conversionPath.add(conversionOperatorType.getUri());
			conversionPaths.add(conversionPath);
			// recursion
			createConversionHierarchy(conversionType, conversionPath, conversionsTo);
		}
	}

	/**
	 * Creates the necessary structures to support the type hierarchy for the Type MID.
	 *
	 * @param typeMID
	 *            The Type MID from which to extract the type hierarchy.
	 * @param subtypeTable
	 *            The table for subtyping in the multimodel.
	 * @param conversionTable
	 *            The table for model type conversion in the multimodel.
	 */
	private static void createTypeHierarchy(MID typeMID, Map<String, Set<String>> subtypeTable, Map<String, Map<String, Set<List<String>>>> conversionTable) {

		//TODO MMINT[OO] this should be called directly by the various createSubtype(), when the mechanism will be less expensive
		subtypeTable.clear();
		conversionTable.clear();
		for (ExtendibleElement type : typeMID.getExtendibleTable().values()) {
			subtypeTable.put(type.getUri(), new HashSet<>());
			if (!(type instanceof Model)) {
				continue;
			}
			conversionTable.put(type.getUri(), new HashMap<>());
		}
		for (ExtendibleElement type : typeMID.getExtendibleTable().values()) {
			createSubtypeHierarchy(type, type, subtypeTable);
		}
		for (Model modelType : typeMID.getModels()) {
			createConversionHierarchy(modelType, new ArrayList<String>(), conversionTable.get(modelType.getUri()));
			for (Model modelSubtype : MIDTypeHierarchy.getSubtypes(modelType, typeMID)) {
				createConversionHierarchy(modelType, new ArrayList<String>(), conversionTable.get(modelSubtype.getUri()));
			}
		}
	}

	/**
	 * Creates the necessary structures to support the type hierarchy of the repository.
	 */
	public static void createTypeHierarchy() {

		createTypeHierarchy(MMINT.cachedTypeMID, MMINT.subtypes, MMINT.conversions);
	}

	/**
	 * Creates the necessary structures to support the type hierarchy of the Type MID.
	 *
	 * @param typeMID
	 *            The Type MID.
	 */
	public static void createTypeHierarchy(MID typeMID) {

		if (typeMID == MMINT.cachedTypeMID) {
			createTypeHierarchy();
		}
		else {
			createTypeHierarchy(typeMID, MMINT.subtypesMID, MMINT.conversionsMID);
		}
	}

	/**
	 * Creates and adds a model type to the repository from a dynamic ("light")
	 * model type created at runtime before the last shutdown.
	 *
	 * @param dynamicType
	 *            The dynamic model type from the last shutdown.
	 * @return The created model type, null if the model type can't be created.
	 */
	private @Nullable ExtendibleElement createDynamicType(ExtendibleElement dynamicType) {

		ExtendibleElement type = MIDTypeRegistry.getType(dynamicType.getSupertype().getUri());
		if (type == null && dynamicType.getSupertype().isDynamic()) {
			type = this.createDynamicType(dynamicType.getSupertype());
		}
		if (type == null) {
			return null;
		}

		ExtendibleElement newType = null;
		try {
			if (dynamicType instanceof ModelRel) {
				newType = ((ModelRel) type).copySubtype((ModelRel) dynamicType);
			}
			else if (dynamicType instanceof Model) {
				newType = ((Model) type).createSubtype(
					dynamicType.getName(),
					(MIDTypeRegistry.getExtendedMetamodelPath((Model) dynamicType) != null)
				);
				newType.addTypeConstraint(dynamicType.getConstraint().getLanguage(), dynamicType.getConstraint().getImplementation());
			}
			else if (dynamicType instanceof WorkflowOperator) {
				newType = ((Operator) type).createSubtype(dynamicType.getName(), ((WorkflowOperator) dynamicType).getNestedMIDPath());
			}
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Dynamic type " + dynamicType.getName() + " can't be recreated", e);
		}

		return newType;
	}

	public static Object createReasoner(IConfigurationElement extensionConfig) throws CoreException {
		var reasoner = (IReasoner) extensionConfig.createExecutableExtension(MMINTConstants.REASONERS_REASONER_ATTR_CLASS);
		MMINT.reasoners.put(reasoner.getName(), reasoner);

		return reasoner;
	}

	/**
	 * Initializes the Type MID from the registered extensions and the dynamic
	 * types created at runtime before the last shutdown, then stores it.
	 *
	 * @param registry
	 *            The Eclipse extension registry.
	 */
	private void initTypeMID(IExtensionRegistry registry) {

		MMINT.cachedTypeMID = MIDFactory.eINSTANCE.createMID();
		MMINT.cachedTypeMID.setLevel(MIDLevel.TYPES);
		MMINT.bundleTable = new HashMap<>();
		MMINT.multipleInheritanceTable = new HashMap<>();
		MMINT.typeFactory = new MIDHeavyTypeFactory();
    MMINT.traits = new HashMap<>();
		MMINT.reasoners = new HashMap<>();
		MMINT.activeInstanceMIDFile = null;
		MMINT.cachedMIDViewProvider = null;
		Iterator<IConfigurationElement> extensionsIter;
    MID typeMID = null;
    try {
      typeMID = (MID) FileUtils.readModelFileInState(MMINT.TYPEMID_FILENAME);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.WARNING, "No previous Type MID found, skipping dynamic types", e);
    }

		// model types
		var configs = registry.getConfigurationElementsFor(MMINTConstants.MODELS_EXT_POINT);
		extensionsIter = MIDTypeHierarchy.getExtensionHierarchyIterator(configs, null, MMINTConstants.ROOT_MODEL_URI);
		while (extensionsIter.hasNext()) {
			var config = extensionsIter.next();
			try {
				var modelType = createModelType(config);
				MMINT.bundleTable.put(modelType.getUri(), config.getContributor().getName());
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.ERROR, "Model type can't be created in " + config.getContributor().getName(), e);
			}
		}
    // editor types
    configs = registry.getConfigurationElementsFor(MMINTConstants.EDITORS_EXT_POINT);
    extensionsIter = MIDTypeHierarchy.getExtensionHierarchyIterator(configs, null, MMINTConstants.ROOT_EDITOR_URI);
    while (extensionsIter.hasNext()) {
      var config = extensionsIter.next();
      try {
        var editorType = createEditorType(config);
        MMINT.bundleTable.put(editorType.getUri(), config.getContributor().getName());
        MIDHeavyTypeFactory.addHeavyModelTypeEditor(editorType, editorType.getModelUri());
      }
      catch (MMINTException e) {
        MMINTException.print(IStatus.ERROR, "Editor type can't be created in " + config.getContributor().getName(), e);
      }
    }
    // dynamic model types
		if (typeMID != null) {
      typeMID.getModels().stream()
        .filter(modelType -> !(modelType instanceof ModelRel) &&
                             modelType.isDynamic() &&
                             MIDTypeRegistry.getType(modelType.getUri()) == null)
        .forEach(dynamicModelType -> this.createDynamicType(dynamicModelType));
		}
		// relationship types
		configs = registry.getConfigurationElementsFor(MMINTConstants.MODELRELS_EXT_POINT);
		extensionsIter = MIDTypeHierarchy.getExtensionHierarchyIterator(configs, MMINTConstants.MODELS_CHILD_MODELTYPE, MMINTConstants.ROOT_MODELREL_URI);
		while (extensionsIter.hasNext()) {
			var config = extensionsIter.next();
			try {
				var modelRelType = createModelRelType(config);
				MMINT.bundleTable.put(modelRelType.getUri(), config.getContributor().getName());
			}
			catch (Exception e) {
				MMINTException.print(IStatus.ERROR, "Model relationship type can't be created in " + config.getContributor().getName(), e);
			}
		}
    // dynamic relationship types
    if (typeMID != null) {
      typeMID.getModelRels().stream()
        .filter(modelRelType -> modelRelType.isDynamic() &&
                                MIDTypeRegistry.getType(modelRelType.getUri()) == null)
        .forEach(dynamicModelRelType -> this.createDynamicType(dynamicModelRelType));
    }
		// operator types
		configs = registry.getConfigurationElementsFor(MMINTConstants.OPERATORS_EXT_POINT);
		extensionsIter = MIDTypeHierarchy.getExtensionHierarchyIterator(configs, null, null);
		while (extensionsIter.hasNext()) {
			var config = extensionsIter.next();
			try {
				var operatorType = createOperatorType(config);
				MMINT.bundleTable.put(operatorType.getUri(), config.getContributor().getName());
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.ERROR, "Operator type can't be created in " + config.getContributor().getName(), e);
			}
		}
		for (var config : configs) { // second pass to add generics, which can be operator types and thus not created yet at first pass
			try {
				createOperatorTypeGenerics(config);
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.ERROR, "Generics can't be created for operator type in " + config.getContributor().getName(), e);
			}
		}
    // dynamic operator types
    if (typeMID != null) {
      typeMID.getOperators().stream()
        .filter(operatorType -> operatorType.isDynamic() &&
                                MIDTypeRegistry.getType(operatorType.getUri()) == null)
        .forEach(dynamicOperatorType -> this.createDynamicType(dynamicOperatorType));
    }
		// reasoning
		for (var config : registry.getConfigurationElementsFor(MMINTConstants.REASONERS_EXT_POINT)) {
			try {
				createReasoner(config);
			}
			catch (CoreException e) {
				MMINTException.print(IStatus.ERROR, "Reasoner can't be created in " + config.getContributor().getName(), e);
			}
		}

		// type hierarchy
		MMINT.subtypes = new HashMap<>();
		MMINT.conversions = new HashMap<>();
		MMINT.subtypesMID = new HashMap<>();
		MMINT.conversionsMID = new HashMap<>();
		MMINT.cachedRuntimeTypes = new HashMap<>();
		writeTypeMID();
	}

	/**
	 * Copies one subtype table into another (src -> tgt).
	 *
	 * @param srcTable
	 *            The source subtype table.
	 * @param tgtTable
	 *            The target subtype table.
	 */
	private static void copySubtypeTable(Map<String, Set<String>> srcTable, Map<String, Set<String>> tgtTable) {

		for (Map.Entry<String, Set<String>> entry : srcTable.entrySet()) {
			Set<String> newValue = new HashSet<>(entry.getValue());
			tgtTable.put(entry.getKey(), newValue);
		}
	}

	/**
	 * Copies one conversion table into another (src -> tgt).
	 *
	 * @param srcTable
	 *            The source conversion table.
	 * @param tgtTable
	 *            The target conversion table.
	 */
	private static void copyConversionTable(Map<String, Map<String, Set<List<String>>>> srcTable, Map<String, Map<String, Set<List<String>>>> tgtTable) {

		for (Map.Entry<String, Map<String, Set<List<String>>>> entry : srcTable.entrySet()) {
			Map<String, Set<List<String>>> newValue = new HashMap<>();
			tgtTable.put(entry.getKey(), newValue);
			for (Map.Entry<String, Set<List<String>>> nestedEntry : entry.getValue().entrySet()) {
				Set<List<String>> newNestedValue = new HashSet<>();
				newValue.put(nestedEntry.getKey(), newNestedValue);
				for (List<String> nestedNestedValue : nestedEntry.getValue()) {
					List<String> newNestedNestedValue = new ArrayList<>(nestedNestedValue);
					newNestedValue.add(newNestedNestedValue);
				}
			}
		}
	}

	/**
	 * Stores the repository into the Type MID file (repository -> Type MID).
	 */
	public static void writeTypeMID() {

		createTypeHierarchy();
		copySubtypeTable(MMINT.subtypes, MMINT.subtypesMID);
		copyConversionTable(MMINT.conversions, MMINT.conversionsMID);
		try {
			FileUtils.writeModelFileInState(MMINT.cachedTypeMID, MMINT.TYPEMID_FILENAME);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Error creating Type MID file", e);
		}
	}

	/**
	 * Syncs the Type MID with its cache in memory (TypeMID -> cache).
	 *
	 * @param typeMID
	 *            The Type MID.
	 */
	public static void syncTypeMID(MID typeMID) {

		//TODO MMINT[OO] review the copy-on-sync mechanism and find an alternative
		MMINT.cachedTypeMID = MIDEcoreUtil.copy(typeMID);
		copySubtypeTable(MMINT.subtypesMID, MMINT.subtypes);
		copyConversionTable(MMINT.conversionsMID, MMINT.conversions);
	}

	/**
	 * Initializes a preference.
	 *
	 * @param preferences
	 *            The preferences.
	 * @param preferenceName
	 *            The preference name.
	 * @param preferenceValue
	 *            The preferenceValue.
	 * @param override
	 *            True if the preference should always be initialized with its
	 *            value, false if it should be initialized only when not found.
	 */
	private void initPreference(IEclipsePreferences preferences, String preferenceName, String preferenceValue, boolean override) {

		if (override || preferences.get(preferenceName, null) == null) {
			preferences.put(preferenceName, preferenceValue);
		}
	}

	/**
	 * Initializes the preferences.
	 */
	private void initPreferences() {

		var preferences = InstanceScope.INSTANCE.getNode(MMINTActivator.PLUGIN_ID);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_TESTS_ENABLED, "false", true);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_ICONS_ENABLED, "true", false);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_MODELRELS_ENABLED, "true", false);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_MODELRELENDPOINTS_ENABLED, "false", false);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_OPERATORS_ENABLED, "true", false);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_OPERATORENDPOINTS_ENABLED, "false", false);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_OPENMODELEDITORS_ENABLED, "false", false);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_RUNTIMETYPING_ENABLED, "true", false);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_DELETEMODELFILE_ENABLED, "true", false);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_RUNTIMETYPING_ENABLED, "true", false);
		this.initPreference(preferences, MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_MULTIPLEDISPATCH_ENABLED, "true", false);
	}

	/**
	 * Gets a preference.
	 *
	 * @param preferenceName
	 *            The preference name.
	 * @return The preference value, null if the preference name could not be
	 *         found.
	 */
	public static @Nullable String getPreference(String preferenceName) {

		var preferences = InstanceScope.INSTANCE.getNode(MMINTActivator.PLUGIN_ID);

		return preferences.get(preferenceName, null);
	}

  /**
   * Sets a preference.
   *
   * @param preferenceName
   *          The preference name.
   * @param newValue
   *          The new preference value (can't be null).
   * @return The previous preference value, or null if the preference was not previously set.
   */
	public static @Nullable String setPreference(String preferenceName, String newValue) {

	  Objects.requireNonNull(newValue, "The value for preference '" + preferenceName + "' can't be null");
		var preferences = InstanceScope.INSTANCE.getNode(MMINTActivator.PLUGIN_ID);
		var oldValue = preferences.get(preferenceName, null);
		if (oldValue == null || !oldValue.equals(newValue)) {
	    preferences.put(preferenceName, newValue);
	    try {
	      preferences.flush();
	    }
	    catch (BackingStoreException e) {
	    }
		}
    return oldValue;
	}

	public static Set<String> getReasonerNames() {
		return MMINT.reasoners.keySet();
	}

  public static IReasoner getReasoner(String reasonerName) throws MMINTException {
    var reasoner = MMINT.reasoners.get(reasonerName);
    if (reasoner == null) {
      throw new MMINTException("Reasoner " + reasonerName + " not found");
    }
    return reasoner;
  }

  /**
   * Gets all reasoners that implement a trait.
   *
   * @param traitClass
   *          The trait class.
   * @return The set of reasoners that implement the trait.
   */
	@SuppressWarnings("unchecked")
  public static <T extends IReasoner> Set<? extends T> getReasonersForTrait(Class<T> traitClass,
                                                                            @Nullable Object traitData) {
	  var traitReasoners = MMINT.reasoners.values().stream().filter(r -> traitClass.isInstance(r));
	  if (traitData != null) {
	    traitReasoners = traitReasoners.filter(r -> r.canUse(traitData));
	  }
	  return traitReasoners.map(r -> (T) r).collect(Collectors.toSet());
	}

	public static boolean isInitialized() {

		return MMINT.INSTANCE != null;
	}

	public static @Nullable IFile getActiveInstanceMIDFile() {

		return MMINT.activeInstanceMIDFile;
	}

	public static void stashActiveInstanceMIDFile() {

		try {
			var instanceMIDFile = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
			MMINT.activeInstanceMIDFile = instanceMIDFile;
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "An instance MID is not active and can't be stored", e);
			MMINT.activeInstanceMIDFile = null;
		}
	}

	/**
	 * Constructor: initializes the settings and the repository.
	 */
	private MMINT() {

		var registry = RegistryFactory.getRegistry();
		if (registry != null) {
			this.initTypeMID(registry);
		}
		this.initPreferences();
	}

}
