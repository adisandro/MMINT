/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ui.PlatformUI;
import org.osgi.service.prefs.BackingStoreException;

import edu.toronto.cs.se.mmint.extensions.EditorExtensionPointListener;
import edu.toronto.cs.se.mmint.extensions.ExtensionPointType;
import edu.toronto.cs.se.mmint.extensions.ModelExtensionPointListener;
import edu.toronto.cs.se.mmint.extensions.ModelRelExtensionPointListener;
import edu.toronto.cs.se.mmint.extensions.OperatorExtensionPointListener;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
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
import edu.toronto.cs.se.mmint.mid.operator.OperatorConstraint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorConstraintRule;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoningEngine;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
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
	/** The reasoners table. */
	static Map<String, Map<String, IReasoningEngine>> languageReasoners;
	/** The cache of runtime types. */
	static Map<ExtendibleElement, List<? extends ExtendibleElement>> cachedRuntimeTypes;
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
	 * - Add control flow operators: If and Loop
	 * - Support conversions in workflows?
	 * - Export an instance mid as workflow?
	 * - Create scripting language
	 */
	/* TODO MMINT[IN PROGRESS OPERATOR] Unify operator type behavior with other types:
	 * - Set root Operator as supertype and add filter in gmfmap to avoid drawing the inheritance link (for root Model and ModelRel too)
	 * - Add 2 model type endpoints for operators to Model with cardinality 0..n, and the corresponding operator api
	 * - Add operator support in hierarchy tables and apis
	 * - Review operator constraint heavy apis
	 * - Differentiate between input and output constraints, use output constraint to validate output in normal operators, convert all operators to use them
	 * - Add various apis: createOutputsByName() + make a workflow version for all apis used in startInstance
	 * - Rethink ConversionOperator to be a simple workflow
	 * - Rewrite ExperimentDriver to be a workflow
	 * - Review and rationalize MIDOper and MIDRel, introduce MIDWorkflow?
	 */
	/* TODO MMINT[USABILITY]
	 * - Change uris into ids
	 * - There should be different classes rather than MID levels, e.g. Model <- ModelType, ModelInstance (although it brings heaps of gmf complexity if we want customized parts as well)
	 * - Similarly, there should be a ModelRelModelEndpoint and an OperatorModelEndpoint
	 * - Simplify the type system of model rels
	 * - Handle optional uris/ids for subelements of model/modelrel/operator
	 * - Use defaults and optionals in extension points as much as possible
	 * - Move modelepedia types/operators into the examples directory together with papers + create appropriate features
	 * - Transform various labels into toString() functions (helps debug too)
	 * - Turn updateMID into global option and use it directly into apis
	 * - Address the issue of not inheriting Editor and Diagram types; this will fix a model type without editor, which is still able to use the reflective ecore
	 * - Review and unify all mid apis (e.g. add possibility to pass name)
	 * - Create apis to create model and file (createInstance() + createModelFile())
	 * - Add createBinaryInstance/Subtype() to Mapping
	 * - Rethink link icons in mids with/without MAVO (problem is they're detached from the label)
	 * - Add documentation ->
	 *   a) Prerequisite: review apis for mid construction and destruction
	 *   b) Take every api function
	 *   c) Check usage and delete if unnecessary
	 *   d) Add @NonNull/@Nullable annotations + javadoc
	 *   e) Make a proper user guide online
	 */
	/* TODO MMINT[MATURITY]
	 * - Use workflows to create test cases, and run tests at every commit
	 * - Address todos
	 * - Resource change listeners to track changes in model elements
	 * - Formalize override semantics
	 * - Formalize type introspection
	 * - Unify libz3java if library load problems are fixed (z3java vs libz3java)
	 * - Separate libz3java into own repo?
	 * - Introduce intermediate level between model element and model element reference, contained in model endpoints
	 * - Support standalone model rels (in their own file)
	 * - Can operators detect input/output by code inspection rather than plugin.xml?
	 * - Replace ocl constraints with java in gmfmap
	 * - Refactor functions in mid.ecore like getMetatype() using generics (and rename that to getType())
	 * - ExtendibleElementReference.containedObject is completely useless
	 */

	private static void createTypeConstraint(IConfigurationElement extensionConfig, ExtendibleElement constrainedType, MIDHeavyTypeFactory typeFactory) {

		IConfigurationElement[] constraintConfig = extensionConfig.getChildren(CHILD_CONSTRAINT);
		String constraintLanguage = (constraintConfig.length == 0) ?
			null :
			constraintConfig[0].getAttribute(CONSTRAINT_ATTR_LANGUAGE);
		String constraintImplementation = (constraintConfig.length == 0) ?
			null :
			constraintConfig[0].getAttribute(CONSTRAINT_ATTR_IMPLEMENTATION);
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

		ExtensionPointType extensionType = new ExtensionPointType(extensionConfig, multipleInheritanceTable, typeFactory);
		if (extensionType.getUri() == null) {
			throw new MMINTException("Model type " + extensionType.getName() + " must have a uri");
		}
		Model newModelType = extensionType.getFactory().createHeavyModelType(extensionType);
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

		IConfigurationElement modelTypeConfig = extensionConfig.getChildren(MODELS_CHILD_MODELTYPE)[0];
		ExtensionPointType modelRelExtensionType = new ExtensionPointType(modelTypeConfig, typeFactory);
		ExtensionPointType extensionType;
		if (modelRelExtensionType.getUri() == null) {
			throw new MMINTException("Model relationship type " + modelRelExtensionType.getName() + " must have a uri");
		}
		IConfigurationElement[] binaryTypeConfigs = extensionConfig.getChildren(CHILD_BINARYTYPE);
		boolean isBinary = (binaryTypeConfigs.length == 0) ? false : true;
		ModelRel newModelRelType = modelRelExtensionType.getFactory().createHeavyModelRelType(
			modelRelExtensionType,
			isBinary
		);
		createTypeConstraint(modelTypeConfig, newModelRelType, modelRelExtensionType.getFactory());
		// binary model rel type
		String srcModelTypeUri = null, tgtModelTypeUri = null;
		if (isBinary) {
			srcModelTypeUri = binaryTypeConfigs[0].getAttribute(BINARYTYPE_ATTR_SOURCETYPEURI);
			((BinaryModelRel) newModelRelType).addModelType(MIDTypeRegistry.<Model>getType(srcModelTypeUri), true);
			tgtModelTypeUri = binaryTypeConfigs[0].getAttribute(BINARYTYPE_ATTR_TARGETTYPEURI);
			((BinaryModelRel) newModelRelType).addModelType(MIDTypeRegistry.<Model>getType(tgtModelTypeUri), false);
		}
		// model type endpoints
		IConfigurationElement[] modelTypeEndpointConfigs = extensionConfig.getChildren(MODELRELS_CHILD_MODELTYPEENDPOINT);
		for (IConfigurationElement modelTypeEndpointConfig : modelTypeEndpointConfigs) {
			extensionType = new ExtensionPointType(modelTypeEndpointConfig, typeFactory);
			IConfigurationElement modelTypeEndpointSubconfig = modelTypeEndpointConfig.getChildren(CHILD_TYPEENDPOINT)[0];
			String targetModelTypeUri = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
			Model targetModelType = MIDTypeRegistry.getType(targetModelTypeUri);
			if (targetModelType == null) {
				MMINTException.print(IStatus.WARNING, "Target model type " + targetModelTypeUri + " can't be found, skipping it", null);
				continue;
			}
			boolean isBinarySrc = (isBinary && srcModelTypeUri.equals(targetModelTypeUri));
			ModelEndpointReference newModelTypeEndpointRef = modelRelExtensionType.getFactory().createHeavyModelTypeEndpointAndModelTypeEndpointReference(
				extensionType,
				targetModelType,
				isBinarySrc,
				newModelRelType
			);
			String lowerBoundString = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND);
			int lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
			String upperBoundString = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND);
			int upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
			MIDTypeFactory.addTypeEndpointCardinality(
				newModelTypeEndpointRef.getObject(),
				lowerBound,
				upperBound
			);
			EPackage rootModelTypeObj = newModelTypeEndpointRef.getObject().getTarget().getEMFTypeRoot();
			// model element types
			IConfigurationElement[] modelElemTypeConfigs = modelTypeEndpointConfig.getChildren(MODELRELS_MODELTYPEENDPOINT_CHILD_MODELELEMTYPE);
			for (IConfigurationElement modelElemTypeConfig : modelElemTypeConfigs) {
				extensionType = new ExtensionPointType(modelElemTypeConfig, typeFactory);
				ModelElement newModelElemType = MIDTypeRegistry.getType(extensionType.getUri());
				if (newModelElemType == null) { // create new model element type
					EObject modelElemTypeObj = FileUtils.readModelObject(extensionType.getUri(), rootModelTypeObj.eResource());
					EMFInfo eInfo = MIDRegistry.getModelElementEMFInfo(modelElemTypeObj, MIDLevel.TYPES);
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
				ModelElementReference modelElemTypeRef = (extensionType.getSupertypeUri() == null) ?
					null :
					MIDRegistry.getReference(extensionType.getSupertypeUri(), newModelTypeEndpointRef.getModelElemRefs());
				newModelElemType.createTypeReference(modelElemTypeRef, true, newModelTypeEndpointRef);
			}
		}
		// link types
		IConfigurationElement[] mappingTypeConfigs = extensionConfig.getChildren(MODELRELS_CHILD_MAPPINGTYPE);
		for (IConfigurationElement mappingTypeConfig : mappingTypeConfigs) {
			binaryTypeConfigs = mappingTypeConfig.getChildren(CHILD_BINARYTYPE);
			isBinary = (binaryTypeConfigs.length == 0) ? false : true;
			extensionType = new ExtensionPointType(mappingTypeConfig, typeFactory);
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
			// binary link type
			String srcModelElemTypeUri = null, tgtModelElemTypeUri = null;
			if (isBinary) {
				srcModelElemTypeUri = binaryTypeConfigs[0].getAttribute(BINARYTYPE_ATTR_SOURCETYPEURI);
				ModelEndpointReference containerModelTypeEndpointRef = MIDRegistry.getEndpointReferences(
					((Model) MIDTypeRegistry.<ModelElement>getType(srcModelElemTypeUri).eContainer()).getUri(),
					newModelRelType.getModelEndpointRefs()
				).get(0);
				((BinaryMappingReference) newMappingTypeRef).addModelElementTypeReference(MIDRegistry.getReference(srcModelElemTypeUri, containerModelTypeEndpointRef.getModelElemRefs()), true);
				tgtModelElemTypeUri = binaryTypeConfigs[0].getAttribute(BINARYTYPE_ATTR_TARGETTYPEURI);
				containerModelTypeEndpointRef = MIDRegistry.getEndpointReferences(
					((Model) MIDTypeRegistry.<ModelElement>getType(tgtModelElemTypeUri).eContainer()).getUri(),
					newModelRelType.getModelEndpointRefs()
				).get(0);
				((BinaryMappingReference) newMappingTypeRef).addModelElementTypeReference(MIDRegistry.getReference(tgtModelElemTypeUri, containerModelTypeEndpointRef.getModelElemRefs()), false);
			}
			// model element type endpoints
			IConfigurationElement[] modelElemTypeEndpointConfigs = mappingTypeConfig.getChildren(MODELRELS_MAPPINGTYPE_CHILD_MODELELEMTYPEENDPOINT);
			for (IConfigurationElement modelElemTypeEndpointConfig : modelElemTypeEndpointConfigs) {
				extensionType = new ExtensionPointType(modelElemTypeEndpointConfig, typeFactory);
				IConfigurationElement modelElemTypeEndpointSubconfig = modelElemTypeEndpointConfig.getChildren(CHILD_TYPEENDPOINT)[0];
				String targetModelElemTypeUri = modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
				ModelElement modelElemType = MIDTypeRegistry.getType(targetModelElemTypeUri);
				if (modelElemType == null) {
					MMINTException.print(IStatus.WARNING, "Target model element type " + targetModelElemTypeUri + " can't be found, skipping it", null);
					continue;
				}
				//TODO MMINT[MODELENDPOINT] well model elements should *really* be contained in the model endpoint now that they exist
				ModelEndpointReference modelTypeEndpointRef = MIDRegistry.getEndpointReferences(((Model) modelElemType.eContainer()).getUri(), newModelRelType.getModelEndpointRefs()).get(0);
				ModelElementReference newModelElemTypeRef = MIDRegistry.getReference(targetModelElemTypeUri, modelTypeEndpointRef.getModelElemRefs());
				boolean isBinarySrc = (isBinary && srcModelElemTypeUri.equals(targetModelElemTypeUri));
				ModelElementEndpointReference newModelElemTypeEndpointRef = modelRelExtensionType.getFactory().createHeavyModelElementTypeEndpointAndModelElementTypeEndpointReference(
					extensionType,
					newModelElemTypeRef,
					isBinarySrc,
					newMappingTypeRef
				);
				String lowerBoundString = modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND);
				int lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
				String upperBoundString = modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND);
				int upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
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

		ExtensionPointType extensionType = new ExtensionPointType(extensionConfig, typeFactory);
		String modelTypeUri = extensionConfig.getAttribute(EDITORS_ATTR_MODELTYPEURI);
		String editorId = extensionConfig.getAttribute(EDITORS_ATTR_ID);
		String wizardId = extensionConfig.getAttribute(EDITORS_ATTR_WIZARDID);
		String wizardDialogClassName = extensionConfig.getAttribute(EDITORS_ATTR_WIZARDDIALOGCLASS);
		Editor newEditorType = extensionType.getFactory().createHeavyEditorType(
			extensionType,
			modelTypeUri,
			editorId,
			wizardId,
			wizardDialogClassName,
			Boolean.parseBoolean(extensionConfig.getAttribute(EDITORS_ATTR_ISDIAGRAM))
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

		IConfigurationElement[] paramTypeConfigs = extensionConfig.getChildren(OPERATORS_GENINOUT_CHILD_PARAMETER);
		for (int i = 0; i < paramTypeConfigs.length; i++) {
			IConfigurationElement paramTypeConfig = paramTypeConfigs[i];
			ExtensionPointType extensionType = new ExtensionPointType(paramTypeConfig, typeFactory);
			IConfigurationElement modelTypeEndpointSubconfig = paramTypeConfig.getChildren(CHILD_TYPEENDPOINT)[0];
			String targetModelTypeUri = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
			Model targetModelType = MIDTypeRegistry.getType(targetModelTypeUri);
			if (targetModelType == null) {
				throw new MMINTException("Target model type " + targetModelTypeUri + " can't be found");
			}
			ModelEndpoint newModelTypeEndpoint = extensionType.getFactory().createHeavyModelTypeEndpoint(
				extensionType,
				targetModelType,
				containerOperatorType,
				containerFeatureName
			);
			String lowerBoundString = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND);
			int lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
			String upperBoundString = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND);
			int upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
			if (upperBound > 1 && i != paramTypeConfigs.length-1) {
				MMINTException.print(IStatus.WARNING, "Only the last input parameter can have an upper bound > 1, setting it to 1", null);
				upperBound = 1;
			}
			MIDTypeFactory.addTypeEndpointCardinality(
				newModelTypeEndpoint,
				lowerBound,
				upperBound
			);
			IConfigurationElement[] endpointConstraintConfigs = paramTypeConfig.getChildren(CHILD_ENDPOINTCONSTRAINT);
			if (endpointConstraintConfigs.length != 0 && targetModelType instanceof ModelRel) {
				OperatorConstraint constraint = (OperatorConstraint) containerOperatorType.getConstraint();
				if (constraint == null) { // create empty constraint first
					constraint = (OperatorConstraint) typeFactory.createHeavyTypeConstraint("JAVA", "", containerOperatorType);
				}
				OperatorConstraintRule constraintRule = typeFactory.createHeavyOperatorTypeConstraintRule(constraint, newModelTypeEndpoint);
				for (IConfigurationElement endpointConstraintConfig : endpointConstraintConfigs) {
					String parameterName = endpointConstraintConfig.getAttribute(ENDPOINTCONSTRAINT_ATTR_PARAMETERNAME);
					String endpointIndex = endpointConstraintConfig.getAttribute(ENDPOINTCONSTRAINT_ATTR_ENDPOINTINDEX);
					ModelEndpoint ruleModelTypeEndpoint;
					int ruleEndpointIndex;
					try {
						ruleModelTypeEndpoint = Stream.concat(containerOperatorType.getInputs().stream(), containerOperatorType.getOutputs().stream())
							.filter(inputModelTypeEndpoint -> inputModelTypeEndpoint.getName().equals(parameterName))
							.findFirst()
							.get();
						ruleEndpointIndex = (endpointIndex == null) ? -1 : Integer.valueOf(endpointIndex);
					}
					catch (Exception e) {
						throw new MMINTException("Bad operator constraint format", e);
					}
					typeFactory.createHeavyOperatorTypeConstraintRuleEndpoint(
						constraintRule,
						ruleModelTypeEndpoint,
						ruleEndpointIndex,
						OperatorPackage.eINSTANCE.getOperatorConstraintRule_EndpointModels().getName());
				}
			}
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

		IConfigurationElement[] paramTypeConfigs = extensionConfig.getChildren(OPERATORS_GENINOUT_CHILD_PARAMETER);
		for (IConfigurationElement paramTypeConfig : paramTypeConfigs) {
			ExtensionPointType extensionType = new ExtensionPointType(paramTypeConfig, typeFactory);
			IConfigurationElement genericTypeEndpointSubconfig = paramTypeConfig.getChildren(CHILD_TYPEENDPOINT)[0];
			String targetGenericTypeUri = genericTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
			GenericElement targetGenericType = MIDTypeRegistry.getType(targetGenericTypeUri);
			if (targetGenericType == null) {
				throw new MMINTException("Target generic type " + targetGenericTypeUri + " can't be found");
			}
			GenericEndpoint newGenericTypeEndpoint = extensionType.getFactory().createHeavyGenericTypeEndpoint(
				extensionType,
				targetGenericType,
				containerOperatorType
			);
			String lowerBoundString = genericTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND);
			int lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
			String upperBoundString = genericTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND);
			int upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
			MIDTypeFactory.addTypeEndpointCardinality(
				newGenericTypeEndpoint,
				lowerBound,
				upperBound
			);
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

		ExtensionPointType extensionType = new ExtensionPointType(extensionConfig, typeFactory);
		if (extensionType.getUri() == null) {
			throw new MMINTException("Operator type " + extensionType.getName() + " must have a uri");
		}
		Operator newOperatorType = extensionType.getFactory().createHeavyOperatorType(extensionType);
		MMINT.createTypeConstraint(extensionConfig, newOperatorType, extensionType.getFactory());
		IConfigurationElement[] genericsParamTypeConfigs = extensionConfig.getChildren(OPERATORS_CHILD_GENERICS);
		if (genericsParamTypeConfigs.length > 0) {
			MMINT.createOperatorTypeGenerics(genericsParamTypeConfigs[0], newOperatorType);
		}
		IConfigurationElement[] inputsParamTypeConfigs = extensionConfig.getChildren(OPERATORS_CHILD_INPUTS);
		if (inputsParamTypeConfigs.length > 0) {
			MMINT.createOperatorTypeParameters(inputsParamTypeConfigs[0], newOperatorType, OperatorPackage.eINSTANCE.getOperator_Inputs().getName());
		}
		IConfigurationElement[] outputsParamTypeConfigs = extensionConfig.getChildren(OPERATORS_CHILD_OUTPUTS);
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
		String subtypeUri = subtype.getUri();
		ExtendibleElement supertype = type.getSupertype();
		if (supertype != null) {
			String supertypeUri = supertype.getUri();
			Set<String> subtypes = subtypeTable.get(supertypeUri);
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
			Model conversionType = conversionOperatorType.getOutputs().get(0).getTarget();
			Set<List<String>> conversionPaths = conversionsTo.get(conversionType.getUri()); // handles multiple paths
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

		createTypeHierarchy(cachedTypeMID, subtypes, conversions);
	}

	/**
	 * Creates the necessary structures to support the type hierarchy of the Type MID.
	 * 
	 * @param typeMID
	 *            The Type MID.
	 */
	public static void createTypeHierarchy(MID typeMID) {

		if (typeMID == cachedTypeMID) {
			createTypeHierarchy();
		}
		else {
			createTypeHierarchy(typeMID, subtypesMID, conversionsMID);
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
	private ExtendibleElement createDynamicType(ExtendibleElement dynamicType) {

		ExtendibleElement type = MIDTypeRegistry.getType(dynamicType.getSupertype().getUri());
		if (type == null && dynamicType.getSupertype().isDynamic()) {
			type = createDynamicType(dynamicType.getSupertype());
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
				newType = ((Operator) type).createSubtype(dynamicType.getName(), ((WorkflowOperator) dynamicType).getMidUri());
			}
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Dynamic type " + dynamicType.getName() + " can't be recreated", e);
		}

		return newType;
	}

	/**
	 * Creates and adds types to the repository from all the dynamic ("light") types created at runtime before the last
	 * shutdown.
	 */
	private void createDynamicTypes() {

		MID typeMID;
		try {
			typeMID = (MID) FileUtils.readModelFileInState(TYPEMID_FILENAME);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "No previous Type MID found, skipping dynamic types", e);
			return;
		}

		// do model types first
		//TODO MMINT[MISC] this probably explains the todo in type hierarchy (are type and type ref iterators really needed, or are the lists already ordered by construction?)
		typeMID.getModels().stream()
			.filter(modelType -> !(modelType instanceof ModelRel))
			.filter(modelType -> modelType.isDynamic())
			.filter(modelType -> MIDTypeRegistry.getType(modelType.getUri()) == null)
			.forEach(dynamicModelType -> this.createDynamicType(dynamicModelType));
		typeMID.getModelRels().stream()
			.filter(modelRelType -> modelRelType.isDynamic())
			.filter(modelRelType -> MIDTypeRegistry.getType(modelRelType.getUri()) == null)
			.forEach(dynamicModelRelType -> this.createDynamicType(dynamicModelRelType));
		typeMID.getOperators().stream()
			.filter(operatorType -> operatorType.isDynamic())
			.filter(operatorType -> MIDTypeRegistry.getType(operatorType.getUri()) == null)
			.forEach(dynamicOperatorType -> this.createDynamicType(dynamicOperatorType));
	}

	public static IReasoningEngine createReasoner(IConfigurationElement extensionConfig) throws CoreException {

		String reasonerName = extensionConfig.getAttribute(REASONERS_REASONER_ATTR_NAME);
		IReasoningEngine reasoner = (IReasoningEngine) extensionConfig.createExecutableExtension(REASONERS_REASONER_ATTR_CLASS);
		IConfigurationElement[] languageConfigs = extensionConfig.getChildren(REASONERS_REASONER_CHILD_LANGUAGE);
		for (IConfigurationElement languageConfig : languageConfigs) {
			String languageId = languageConfig.getAttribute(REASONERS_REASONER_LANGUAGE_ATTR_ID).toUpperCase();
			Map<String, IReasoningEngine> reasoners = languageReasoners.get(languageId);
			if (reasoners == null) {
				reasoners = new HashMap<String, IReasoningEngine>();
				languageReasoners.put(languageId, reasoners);
			}
			reasoners.put(reasonerName, reasoner);
		}

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

		cachedTypeMID = MIDFactory.eINSTANCE.createMID();
		cachedTypeMID.setLevel(MIDLevel.TYPES);
		bundleTable = new HashMap<>();
		multipleInheritanceTable = new HashMap<>();
		typeFactory = new MIDHeavyTypeFactory();
		languageReasoners = new HashMap<>();
		activeInstanceMIDFile = null;
		IConfigurationElement[] configs;
		Iterator<IConfigurationElement> extensionsIter;
		IConfigurationElement config;

		// model types
		configs = registry.getConfigurationElementsFor(MODELS_EXT_POINT);
		extensionsIter = MIDTypeHierarchy.getExtensionHierarchyIterator(configs, null, ROOT_MODEL_URI);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			try {
				Model modelType = createModelType(config);
				bundleTable.put(modelType.getUri(), config.getContributor().getName());
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.ERROR, "Model type can't be created in " + config.getContributor().getName(), e);
			}
		}
		// model relationship types
		configs = registry.getConfigurationElementsFor(MODELRELS_EXT_POINT);
		extensionsIter = MIDTypeHierarchy.getExtensionHierarchyIterator(configs, MODELS_CHILD_MODELTYPE, ROOT_MODELREL_URI);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			try {
				ModelRel modelRelType = createModelRelType(config);
				bundleTable.put(modelRelType.getUri(), config.getContributor().getName());
			}
			catch (Exception e) {
				MMINTException.print(IStatus.ERROR, "Model relationship type can't be created in " + config.getContributor().getName(), e);
			}
		}
		// editor types
		configs = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		extensionsIter = MIDTypeHierarchy.getExtensionHierarchyIterator(configs, null, ROOT_EDITOR_URI);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			try {
				Editor editorType = createEditorType(config);
				bundleTable.put(editorType.getUri(), config.getContributor().getName());
				MIDHeavyTypeFactory.addHeavyModelTypeEditor(editorType, editorType.getModelUri());
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.ERROR, "Editor type can't be created in " + config.getContributor().getName(), e);
			}
		}
		// operator types
		configs = registry.getConfigurationElementsFor(OPERATORS_EXT_POINT);
		extensionsIter = MIDTypeHierarchy.getExtensionHierarchyIterator(configs, null, null);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			try {
				Operator operatorType = createOperatorType(config);
				bundleTable.put(operatorType.getUri(), config.getContributor().getName());
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.ERROR, "Operator type can't be created in " + config.getContributor().getName(), e);
			}
		}
		// dynamic types from last shutdown
		createDynamicTypes();
		// reasoners
		configs = registry.getConfigurationElementsFor(REASONERS_EXT_POINT);
		for (int i = 0; i < configs.length; i++) {
			config = configs[i];
			try {
				createReasoner(config);
			}
			catch (CoreException e) {
				MMINTException.print(IStatus.ERROR, "Reasoner can't be created in " + config.getContributor().getName(), e);
			}
		}

		// type hierarchy
		subtypes = new HashMap<>();
		conversions = new HashMap<>();
		subtypesMID = new HashMap<>();
		conversionsMID = new HashMap<>();
		cachedRuntimeTypes = new HashMap<>();
		storeTypeMID();
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
	public static void storeTypeMID() {

		createTypeHierarchy();
		copySubtypeTable(subtypes, subtypesMID);
		copyConversionTable(conversions, conversionsMID);
		try {
			FileUtils.writeModelFileInState(cachedTypeMID, TYPEMID_FILENAME);
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
		cachedTypeMID = MIDEcoreUtil.copy(typeMID);
		copySubtypeTable(subtypesMID, subtypes);
		copyConversionTable(conversionsMID, conversions);
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

		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(MMINTActivator.PLUGIN_ID);
		initPreference(preferences, PREFERENCE_MENU_ICONS_ENABLED, "true", false);
		initPreference(preferences, PREFERENCE_MENU_MODELRELS_ENABLED, "true", false);
		initPreference(preferences, PREFERENCE_MENU_MODELRELENDPOINTS_ENABLED, "true", false);
		initPreference(preferences, PREFERENCE_MENU_OPERATORS_ENABLED, "true", false);
		initPreference(preferences, PREFERENCE_MENU_OPERATORENDPOINTS_ENABLED, "true", false);
		initPreference(preferences, PREFERENCE_MENU_OPENMODELEDITORS_ENABLED, "true", false);
		initPreference(preferences, PREFERENCE_MENU_POLYMORPHISM_ENABLED, "true", false);
		initPreference(preferences, PREFERENCE_MENU_DELETEMODELFILE_ENABLED, "true", false);
		initPreference(preferences, PREFERENCE_TESTS_ENABLED, "false", true);
		for (String languageId : languageReasoners.keySet()) {
			String reasonerName = preferences.get(PREFERENCE_MENU_LANGUAGE_REASONER + languageId, null);
			if (reasonerName != null) {
				IReasoningEngine reasoner = languageReasoners.get(languageId).get(reasonerName);
				if (reasoner != null) {
					continue;
				}
			}
			reasonerName = languageReasoners.get(languageId).keySet().iterator().next();
			initPreference(preferences, PREFERENCE_MENU_LANGUAGE_REASONER + languageId, reasonerName, true);
		}
	}

	/**
	 * Gets a preference.
	 * 
	 * @param preferenceName
	 *            The preference name.
	 * @return The preference value, null if the preference name could not be
	 *         found.
	 */
	public static String getPreference(String preferenceName) {

		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(MMINTActivator.PLUGIN_ID);

		return preferences.get(preferenceName, null);
	}

	/**
	 * Sets a preference.
	 * 
	 * @param preferenceName
	 *            The preference name.
	 * @param preferenceValue
	 *            The new preference value.
	 * @return True if the preference was set, false if the preference name
	 *         could not be found.
	 */
	public static boolean setPreference(String preferenceName, String preferenceValue) {

		IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode(MMINTActivator.PLUGIN_ID);
		if (preferences.get(preferenceName, null) == null) {
			return false;
		}
		preferences.put(preferenceName, preferenceValue);
		try {
			preferences.flush();
			return true;
		}
		catch (BackingStoreException e) {
			return false;
		}
	}

	public static Map<String, IReasoningEngine> getLanguageReasoners(String languageId) {

		return languageReasoners.get(languageId.toUpperCase());
	}

	public static Set<String> getReasonerLanguages() {

		return languageReasoners.keySet();
	}

	public static boolean isInitialized() {

		return INSTANCE != null;
	}

	public static @Nullable IFile getActiveInstanceMIDFile() {

		return activeInstanceMIDFile;
	}

	public static void storeActiveInstanceMIDFile() {

		try {
			IFile instanceMIDFile = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
			activeInstanceMIDFile = instanceMIDFile;
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "An instance MID is not active and can't be stored", e);
			activeInstanceMIDFile = null;
		}
	}

	/**
	 * Constructor: initializes the settings, initializes the repository and
	 * registers listeners for dynamic installation/unistallation of extensions.
	 */
	private MMINT() {

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry != null) {
			initTypeMID(registry);
			registry.addListener(new ModelExtensionPointListener(), MODELS_EXT_POINT);
			registry.addListener(new ModelRelExtensionPointListener(), MODELRELS_EXT_POINT);
			registry.addListener(new EditorExtensionPointListener(), EDITORS_EXT_POINT);
			registry.addListener(new OperatorExtensionPointListener(), OPERATORS_EXT_POINT);
		}
		initPreferences();
	}

}
