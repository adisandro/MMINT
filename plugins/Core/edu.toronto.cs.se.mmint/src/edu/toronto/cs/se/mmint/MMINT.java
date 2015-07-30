/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.osgi.service.prefs.BackingStoreException;

import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.operator.RandomOperator;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.reasoning.IReasoningEngine;
import edu.toronto.cs.se.mmint.repository.EditorsExtensionListener;
import edu.toronto.cs.se.mmint.repository.ExtensionType;
import edu.toronto.cs.se.mmint.repository.MMINTConstants;
import edu.toronto.cs.se.mmint.repository.ModelsExtensionListener;
import edu.toronto.cs.se.mmint.repository.OperatorsExtensionListener;
import edu.toronto.cs.se.mmint.repository.RelationshipsExtensionListener;

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
	static MultiModelHeavyTypeFactory typeFactory;
	/** The Type MID in memory. */
	static MultiModel cachedTypeMID;
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
	/**
	 * The table to have some very poor sort of multiple inheritance,
	 * i.e. to have UML_MAVO properly recognized.
	 * TODO MMINT[MID] redo when needed!
	 */
	static Map<String, Set<String>> multipleInheritanceTable;
	/** The type MID filename. */
	public static final String TYPEMID_FILENAME = "types" + MMINT.MODEL_FILEEXTENSION_SEPARATOR + MIDPackage.eNAME;

	/* TODO MMINT[USABILITY]
	 * - Default deletion to remove model file as well
	 * - Change uris into ids
	 * - Simplify the type system of model rels
	 * - Handle optional uris/ids for subelements of model/modelrel/operator
	 * - Use defaults in extension points as much as possible
	 * - Rename link to mapping
	 * - Decouple from MAVO framework: use a kleisli-like mechanism MAVOModel->Model with overridden apis, where the current MAVOModel becomes a simple MAVORoot
	 * - Rethink mid link icons with/without MAVO
	 * - Move modelepedia types/operators into the examples directory together with papers + create appropriate features
	 * - Transform various labels into toString() functions (also helps debug)
	 * - Turn updateMID into global option and use it directly into apis
	 * - Address the issue of not inheriting Editor and Diagram types; this will fix a model type without editor, which is still able to use the reflective ecore
	 * - Unify createInstance/Subtype() for Model and ModelRel, removing origin and isBinary
	 * - Add createBinaryInstance/Subtype() to ModelRel
	 * - Review and unify all multimodel apis (e.g. add possibility to pass name)
	 * - Review stuff done in megamodel operators and create more helper apis (e.g. createInstance() + createModelFile())
	 * - Separate file apis from MultiModelUtils to MultiModelFileUtils
	 * - Rename all multimodels (vars and api names) to MID
	 * - Add documentation ->
	 *   a) Prerequisite: review apis for mid construction and destruction
	 *   b) Take every api function
	 *   c) Check usage and delete if unnecessary
	 *   d) Add @NonNull/@Nullable annotations + javadoc
	 *   e) Make a proper user guide online
	 */
	/* TODO MMINT[MATURITY]
	 * - Address todos
	 * - Resource change listeners to track changes in model elements
	 * - Operator workflows
	 * - Formalize override semantics
	 * - Formalize type introspection
	 * - Introduce intermediate level between model element and model element reference, contained in model endpoints
	 * - Support standalone model rels (in their own file)
	 * - Can operators detect input/output by code inspection rather than plugin.xml?
	 * - Replace Pivot constraints and derivation in mid.ecore with java
	 * - Refactor functions in mid.ecore like getMetatype() using generics
	 */

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

		ExtensionType extensionType = new ExtensionType(extensionConfig, multipleInheritanceTable, typeFactory);
		if (extensionType.getUri() == null) {
			throw new MMINTException("Model type " + extensionType.getName() + " must have a uri");
		}
		IConfigurationElement[] constraintConfig = extensionConfig.getChildren(MODELS_MODELTYPE_CHILD_CONSTRAINT);
		String constraintLanguage = (constraintConfig.length == 0) ?
			null :
			constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_LANGUAGE);
		String constraintImplementation = (constraintConfig.length == 0) ?
			null :
			constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_IMPLEMENTATION);
		Model newModelType = extensionType.getFactory().createHeavyModelType(
			extensionType,
			constraintLanguage,
			constraintImplementation
		);

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
		ExtensionType extensionType = new ExtensionType(modelTypeConfig, typeFactory);
		if (extensionType.getUri() == null) {
			throw new MMINTException("Model relationship type " + extensionType.getName() + " must have a uri");
		}
		IConfigurationElement[] binaryTypeConfigs = extensionConfig.getChildren(CHILD_BINARYTYPE);
		boolean isBinary = (binaryTypeConfigs.length == 0) ? false : true;
		IConfigurationElement[] constraintConfig = modelTypeConfig.getChildren(MODELS_MODELTYPE_CHILD_CONSTRAINT);
		String constraintLanguage = (constraintConfig.length == 0) ?
			null :
			constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_LANGUAGE);
		String constraintImplementation = (constraintConfig.length == 0) ?
			null :
			constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_IMPLEMENTATION);
		ModelRel newModelRelType = extensionType.getFactory().createHeavyModelRelType(
			extensionType,
			isBinary,
			constraintLanguage,
			constraintImplementation
		);
		// binary model rel type
		String srcModelTypeUri = null, tgtModelTypeUri = null;
		if (isBinary) {
			srcModelTypeUri = binaryTypeConfigs[0].getAttribute(BINARYTYPE_ATTR_SOURCETYPEURI);
			((BinaryModelRel) newModelRelType).addModelType(MultiModelTypeRegistry.<Model>getType(srcModelTypeUri), true);
			tgtModelTypeUri = binaryTypeConfigs[0].getAttribute(BINARYTYPE_ATTR_TARGETTYPEURI);
			((BinaryModelRel) newModelRelType).addModelType(MultiModelTypeRegistry.<Model>getType(tgtModelTypeUri), false);
		}
		// model type endpoints
		IConfigurationElement[] modelTypeEndpointConfigs = extensionConfig.getChildren(MODELRELS_CHILD_MODELTYPEENDPOINT);
		for (IConfigurationElement modelTypeEndpointConfig : modelTypeEndpointConfigs) {
			extensionType = new ExtensionType(modelTypeEndpointConfig, typeFactory);
			IConfigurationElement modelTypeEndpointSubconfig = modelTypeEndpointConfig.getChildren(CHILD_TYPEENDPOINT)[0];
			String targetModelTypeUri = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
			Model targetModelType = MultiModelTypeRegistry.getType(targetModelTypeUri);
			if (targetModelType == null) {
				MMINTException.print(IStatus.WARNING, "Target model type " + targetModelTypeUri + " can't be found, skipping it", null);
				continue;
			}
			boolean isBinarySrc = (isBinary && srcModelTypeUri.equals(targetModelTypeUri));
			ModelEndpointReference newModelTypeEndpointRef = extensionType.getFactory().createHeavyModelTypeEndpointAndModelTypeEndpointReference(
				extensionType,
				targetModelType,
				isBinarySrc,
				newModelRelType
			);
			String lowerBoundString = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND);
			int lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
			String upperBoundString = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND);
			int upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
			MultiModelTypeFactory.addTypeEndpointCardinality(
				newModelTypeEndpointRef.getObject(),
				lowerBound,
				upperBound
			);
			EPackage rootModelTypeObj = newModelTypeEndpointRef.getObject().getTarget().getEMFTypeRoot();
			// model element types
			IConfigurationElement[] modelElemTypeConfigs = modelTypeEndpointConfig.getChildren(MODELRELS_MODELTYPEENDPOINT_CHILD_MODELELEMTYPE);
			for (IConfigurationElement modelElemTypeConfig : modelElemTypeConfigs) {
				extensionType = new ExtensionType(modelElemTypeConfig, typeFactory);
				ModelElement newModelElemType = MultiModelTypeRegistry.getType(extensionType.getUri());
				if (newModelElemType == null) { // create new model element type
					EObject modelElemTypeObj = MultiModelTypeIntrospection.getPointer(rootModelTypeObj.eResource(), extensionType.getUri());
					EMFInfo eInfo = MultiModelRegistry.getModelElementEMFInfo(modelElemTypeObj, MIDLevel.TYPES);
					try {
						newModelElemType = extensionType.getFactory().createHeavyModelElementType(
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
					MultiModelTypeHierarchy.getReference(extensionType.getSupertypeUri(), newModelTypeEndpointRef.getModelElemRefs());
				newModelElemType.createTypeReference(modelElemTypeRef, true, newModelTypeEndpointRef);
			}
		}
		// link types
		IConfigurationElement[] linkTypeConfigs = extensionConfig.getChildren(MODELRELS_CHILD_LINKTYPE);
		for (IConfigurationElement linkTypeConfig : linkTypeConfigs) {
			binaryTypeConfigs = linkTypeConfig.getChildren(CHILD_BINARYTYPE);
			isBinary = (binaryTypeConfigs.length == 0) ? false : true;
			extensionType = new ExtensionType(linkTypeConfig, typeFactory);
			LinkReference newLinkTypeRef;
			try {
				newLinkTypeRef = extensionType.getFactory().createHeavyLinkTypeAndLinkTypeReference(
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
				ModelEndpointReference containerModelTypeEndpointRef = MultiModelTypeHierarchy.getEndpointReferences(
					((Model) MultiModelTypeRegistry.<ModelElement>getType(srcModelElemTypeUri).eContainer()).getUri(),
					newModelRelType.getModelEndpointRefs()
				).get(0);
				((BinaryLinkReference) newLinkTypeRef).addModelElementTypeReference(MultiModelTypeHierarchy.getReference(srcModelElemTypeUri, containerModelTypeEndpointRef.getModelElemRefs()), true);
				tgtModelElemTypeUri = binaryTypeConfigs[0].getAttribute(BINARYTYPE_ATTR_TARGETTYPEURI);
				containerModelTypeEndpointRef = MultiModelTypeHierarchy.getEndpointReferences(
					((Model) MultiModelTypeRegistry.<ModelElement>getType(tgtModelElemTypeUri).eContainer()).getUri(),
					newModelRelType.getModelEndpointRefs()
				).get(0);
				((BinaryLinkReference) newLinkTypeRef).addModelElementTypeReference(MultiModelTypeHierarchy.getReference(tgtModelElemTypeUri, containerModelTypeEndpointRef.getModelElemRefs()), false);
			}
			// model element type endpoints
			IConfigurationElement[] modelElemTypeEndpointConfigs = linkTypeConfig.getChildren(MODELRELS_LINKTYPE_CHILD_MODELELEMTYPEENDPOINT);
			for (IConfigurationElement modelElemTypeEndpointConfig : modelElemTypeEndpointConfigs) {
				extensionType = new ExtensionType(modelElemTypeEndpointConfig, typeFactory);
				IConfigurationElement modelElemTypeEndpointSubconfig = modelElemTypeEndpointConfig.getChildren(CHILD_TYPEENDPOINT)[0];
				String targetModelElemTypeUri = modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
				ModelElement modelElemType = MultiModelTypeRegistry.getType(targetModelElemTypeUri);
				if (modelElemType == null) {
					MMINTException.print(IStatus.WARNING, "Target model element type " + targetModelElemTypeUri + " can't be found, skipping it", null);
					continue;
				}
				//TODO MMINT[MODELENDPOINT] well model elements should *really* be contained in the model endpoint now that they exist
				ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getEndpointReferences(((Model) modelElemType.eContainer()).getUri(), newModelRelType.getModelEndpointRefs()).get(0);
				ModelElementReference newModelElemTypeRef = MultiModelTypeHierarchy.getReference(targetModelElemTypeUri, modelTypeEndpointRef.getModelElemRefs());
				boolean isBinarySrc = (isBinary && srcModelElemTypeUri.equals(targetModelElemTypeUri));
				ModelElementEndpointReference newModelElemTypeEndpointRef = extensionType.getFactory().createHeavyModelElementTypeEndpointAndModelElementTypeEndpointReference(
					extensionType,
					newModelElemTypeRef,
					isBinarySrc,
					newLinkTypeRef
				);
				String lowerBoundString = modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND);
				int lowerBound = (lowerBoundString == null) ? 1 : Integer.parseInt(lowerBoundString);
				String upperBoundString = modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND);
				int upperBound = (upperBoundString == null) ? 1 : Integer.parseInt(upperBoundString);
				MultiModelTypeFactory.addTypeEndpointCardinality(
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

		ExtensionType extensionType = new ExtensionType(extensionConfig, typeFactory);
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
			ExtensionType extensionType = new ExtensionType(paramTypeConfig, typeFactory);
			IConfigurationElement modelTypeEndpointSubconfig = paramTypeConfig.getChildren(CHILD_TYPEENDPOINT)[0];
			String targetModelTypeUri = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
			Model targetModelType = MultiModelTypeRegistry.getType(targetModelTypeUri);
			if (targetModelType == null) {
				MMINTException.print(IStatus.WARNING, "Target model type " + targetModelTypeUri + " can't be found, skipping it", null);
				continue;
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
			MultiModelTypeFactory.addTypeEndpointCardinality(
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

		IConfigurationElement[] paramTypeConfigs = extensionConfig.getChildren(OPERATORS_GENINOUT_CHILD_PARAMETER);
		for (IConfigurationElement paramTypeConfig : paramTypeConfigs) {
			ExtensionType extensionType = new ExtensionType(paramTypeConfig, typeFactory);
			IConfigurationElement genericTypeEndpointSubconfig = paramTypeConfig.getChildren(CHILD_TYPEENDPOINT)[0];
			String targetGenericTypeUri = genericTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
			GenericElement targetGenericType = MultiModelTypeRegistry.getType(targetGenericTypeUri);
			if (targetGenericType == null) {
				MMINTException.print(IStatus.WARNING, "Target generic type " + targetGenericTypeUri + " can't be found, skipping it", null);
				continue;
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
			MultiModelTypeFactory.addTypeEndpointCardinality(
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

		ExtensionType extensionType = new ExtensionType(extensionConfig, typeFactory);
		if (extensionType.getUri() == null) {
			throw new MMINTException("Operator type " + extensionType.getName() + " must have a uri");
		}
		Operator newOperatorType = extensionType.getFactory().createHeavyOperatorType(extensionType);
		IConfigurationElement[] genericsParamTypeConfigs = extensionConfig.getChildren(OPERATORS_CHILD_GENERICS);
		if (genericsParamTypeConfigs.length > 0) {
			createOperatorTypeGenerics(genericsParamTypeConfigs[0], newOperatorType);
		}
		IConfigurationElement[] inputsParamTypeConfigs = extensionConfig.getChildren(OPERATORS_CHILD_INPUTS);
		if (inputsParamTypeConfigs.length > 0) {
			createOperatorTypeParameters(inputsParamTypeConfigs[0], newOperatorType, OperatorPackage.eINSTANCE.getOperator_Inputs().getName());
		}
		IConfigurationElement[] outputsParamTypeConfigs = extensionConfig.getChildren(OPERATORS_CHILD_OUTPUTS);
		if (outputsParamTypeConfigs.length > 0) {
			createOperatorTypeParameters(outputsParamTypeConfigs[0], newOperatorType, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
		}
		if (newOperatorType instanceof RandomOperator) {
			MultiModelTypeFactory.addOperatorTypeRandom((RandomOperator) newOperatorType);
		}
		if (newOperatorType instanceof ConversionOperator) {
			MultiModelTypeFactory.addOperatorTypeConversion((ConversionOperator) newOperatorType);
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
	 * Creates the necessary structures to support the type hierarchy for a
	 * multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel from which to extract the type hierarchy.
	 * @param subtypeTable
	 *            The table for subtyping in the multimodel.
	 * @param conversionTable
	 *            The table for model type conversion in the multimodel.
	 */
	private static void createTypeHierarchy(MultiModel multiModel, Map<String, Set<String>> subtypeTable, Map<String, Map<String, Set<List<String>>>> conversionTable) {

		//TODO MMINT[OO] this should be called directly by the various createSubtype(), when the mechanism will be less expensive
		subtypeTable.clear();
		conversionTable.clear();
		for (ExtendibleElement type : multiModel.getExtendibleTable().values()) {
			subtypeTable.put(type.getUri(), new HashSet<>());
			if (!(type instanceof Model)) {
				continue;
			}
			conversionTable.put(type.getUri(), new HashMap<>());
		}
		for (ExtendibleElement type : multiModel.getExtendibleTable().values()) {
			createSubtypeHierarchy(type, type, subtypeTable);
		}
		for (Model modelType : MultiModelRegistry.getModels(multiModel)) {
			createConversionHierarchy(modelType, new ArrayList<String>(), conversionTable.get(modelType.getUri()));
			for (Model modelSubtype : MultiModelTypeHierarchy.getSubtypes(modelType, multiModel)) {
				createConversionHierarchy(modelType, new ArrayList<String>(), conversionTable.get(modelSubtype.getUri()));
			}
		}
	}

	/**
	 * Creates the necessary structures to support the type hierarchy for the
	 * repository.
	 */
	public static void createTypeHierarchy() {

		createTypeHierarchy(cachedTypeMID, subtypes, conversions);
	}

	/**
	 * Creates the necessary structures to support the type hierarchy for the
	 * Type MID.
	 * 
	 * @param typeMID
	 *            The multimodel root of the Type MID.
	 */
	public static void createTypeHierarchy(MultiModel typeMID) {

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
	 * @param dynamicModelType
	 *            The dynamic model type from the last shutdown.
	 * @return The created model type, null if the model type can't be created.
	 */
	private Model createDynamicModelType(Model dynamicModelType) {

		Model modelType = MultiModelTypeRegistry.getType(dynamicModelType.getSupertype().getUri());
		if (modelType == null && dynamicModelType.getSupertype().isDynamic()) {
			modelType = createDynamicModelType(dynamicModelType.getSupertype());
		}
		if (modelType == null) {
			return null;
		}

		Model newModelType = null;
		try {
			if (dynamicModelType instanceof ModelRel) {
				newModelType = ((ModelRel) modelType).copySubtype((ModelRel) dynamicModelType);
			}
			else {
				newModelType = modelType.createSubtype(
					dynamicModelType.getName(),
					dynamicModelType.getConstraint().getLanguage(),
					dynamicModelType.getConstraint().getImplementation(),
					(MultiModelTypeRegistry.getExtendedMetamodelUri(dynamicModelType) != null)
				);
			}
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Dynamic type " + dynamicModelType.getName() + " can't be recreated", e);
		}

		return newModelType;
	}

	/**
	 * Creates and adds model types to the repository from all the dynamic
	 * ("light") model types created at runtime before the last shutdown.
	 */
	private void createDynamicModelTypes() {

		MultiModel multiModel;
		try {
			multiModel = (MultiModel) MultiModelUtils.getModelFileInState(TYPEMID_FILENAME);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "No previous Type MID found, skipping dynamic types", e);
			return;
		}

		// do model types first
		//TODO MMINT[MISC] this probably explains the todo in type hierarchy (are type and type ref iterators really needed, or are the lists already ordered by construction?)
		for (Model dynamicModelType : MultiModelRegistry.getModels(multiModel)) {
			if (
				!(dynamicModelType instanceof ModelRel) &&
				dynamicModelType.isDynamic() &&
				MultiModelTypeRegistry.getType(dynamicModelType.getUri()) == null
			) {
				createDynamicModelType(dynamicModelType);
			}
		}
		for (ModelRel dynamicModelRelType : MultiModelRegistry.getModelRels(multiModel)) {
			if (
				dynamicModelRelType.isDynamic() &&
				MultiModelTypeRegistry.getType(dynamicModelRelType.getUri()) == null
			) {
				createDynamicModelType(dynamicModelRelType);
			}
		}
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
	 * Initializes the repository from the registered extensions and the dynamic
	 * types created at runtime before the last shutdown, then stores it in the
	 * type MID file.
	 * 
	 * @param registry
	 *            The Eclipse extension registry.
	 */
	private void initRepository(IExtensionRegistry registry) {

		cachedTypeMID = MIDFactory.eINSTANCE.createMultiModel();
		cachedTypeMID.setLevel(MIDLevel.TYPES);
		bundleTable = new HashMap<>();
		multipleInheritanceTable = new HashMap<>();
		typeFactory = new MultiModelHeavyTypeFactory();
		languageReasoners = new HashMap<>();
		IConfigurationElement[] configs;
		Iterator<IConfigurationElement> extensionsIter;
		IConfigurationElement config;

		// model types
		configs = registry.getConfigurationElementsFor(MODELS_EXT_POINT);
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, null, ROOT_MODEL_URI);
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
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, MODELS_CHILD_MODELTYPE, ROOT_MODELREL_URI);
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
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, null, ROOT_EDITOR_URI);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			try {
				Editor editorType = createEditorType(config);
				bundleTable.put(editorType.getUri(), config.getContributor().getName());
				MultiModelHeavyTypeFactory.addHeavyModelTypeEditor(editorType, editorType.getModelUri());
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.ERROR, "Editor type can't be created in " + config.getContributor().getName(), e);
			}
		}
		// operator types
		configs = registry.getConfigurationElementsFor(OPERATORS_EXT_POINT);
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, null, null);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			try {
				createOperatorType(config);
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.ERROR, "Operator type can't be created in " + config.getContributor().getName(), e);
			}
		}
		// dynamic types from last shutdown
		createDynamicModelTypes();
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
		storeRepository();
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
			Set<String> newValue = new HashSet<String>(entry.getValue());
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
			Map<String, Set<List<String>>> newValue = new HashMap<String, Set<List<String>>>();
			tgtTable.put(entry.getKey(), newValue);
			for (Map.Entry<String, Set<List<String>>> nestedEntry : entry.getValue().entrySet()) {
				Set<List<String>> newNestedValue = new HashSet<List<String>>();
				newValue.put(nestedEntry.getKey(), newNestedValue);
				for (List<String> nestedNestedValue : nestedEntry.getValue()) {
					List<String> newNestedNestedValue = new ArrayList<String>(nestedNestedValue);
					newNestedValue.add(newNestedNestedValue);
				}
			}
		}
	}

	/**
	 * Stores the repository into the Type MID file (repository -> Type MID).
	 */
	public static void storeRepository() {

		createTypeHierarchy();
		copySubtypeTable(subtypes, subtypesMID);
		copyConversionTable(conversions, conversionsMID);
		try {
			MultiModelUtils.createModelFileInState(cachedTypeMID, TYPEMID_FILENAME);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Error creating Type MID file", e);
		}
	}

	/**
	 * Syncs the Type MID with the repository (TypeMID -> Repository).
	 * 
	 * @param multiModel
	 *            The multimodel root of the Type MID.
	 */
	public static void syncRepository(MultiModel multiModel) {

		//TODO MMINT[OO] to store operators' custom code in the mid, we would need them to be ecore-generated, but that's a burden for users
		//TODO MMINT[OO] review the copy-on-sync mechanism and find an alternative
		cachedTypeMID = MMINTEcoreUtil.copy(multiModel);
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

	/**
	 * Constructor: initializes the settings, initializes the repository and
	 * registers listeners for dynamic installation/unistallation of extensions.
	 */
	private MMINT() {

		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry != null) {
			initRepository(registry);
			registry.addListener(new ModelsExtensionListener(), MODELS_EXT_POINT);
			registry.addListener(new RelationshipsExtensionListener(), MODELRELS_EXT_POINT);
			registry.addListener(new EditorsExtensionListener(), EDITORS_EXT_POINT);
			registry.addListener(new OperatorsExtensionListener(), OPERATORS_EXT_POINT);
		}
		initPreferences();
	}

}
