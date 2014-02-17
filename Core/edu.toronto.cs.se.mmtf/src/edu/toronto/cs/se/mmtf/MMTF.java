/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.core.commands.Command;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.RegistryToggleState;

import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.EMFInfo;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.operator.impl.RandomOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.repository.EditorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.ExtensionType;
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;
import edu.toronto.cs.se.mmtf.repository.ModelsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.OperatorsExtensionListener;
import edu.toronto.cs.se.mmtf.repository.RelationshipsExtensionListener;

/**
 * Model Management is the management of collections of related models. It
 * provides tools and techniques for dealing with large collections of models
 * (mega-modeling), defining relationships among models, automatically
 * manipulating models and relationships using operators (i.e.,
 * transformations).
 * 
 * The Model Management Tool Framework (MMTF) is an Eclipse-based framework for
 * rapidly developing model management tools emphasizing graphical, interactive
 * model management with strong typing.
 * 
 * MMTF facilitates interactive model management both at the type and instance
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
public class MMTF implements MMTFConstants {

	/** The singleton instance. */
	static final MMTF INSTANCE = new MMTF();
	/** The default "heavy" type factory. */
	static MultiModelHeavyTypeFactory typeFactory;
	/** The repository of types. */
	static MultiModel repository;
	/**	The table for subtyping in the repository. */
	static Map<String, Set<String>> subtypeTable;
	/**	The table for model type conversion in the repository. */
	static Map<String, Map<String, List<String>>> conversionTable;
	/**	The table for subtyping in the Type MID. */
	static Map<String, Set<String>> subtypeTableMID;
	/**	The table for model type conversion in the Type MID. */
	static Map<String, Map<String, List<String>>> conversionTableMID;
	/** The table to map type uris to their bundle name. */
	static Map<String, String> bundleTable;
	/** The settings table. */
	static Map<String, Object> settings;
	/**
	 * The table to have some very poor sort of multiple inheritance,
	 * i.e. to have UML_MAVO properly recognized.
	 * TODO MMTF: redo when needed!
	 */
	static Map<String, Set<String>> multipleInheritanceTable;
	/** The type MID filename. */
	public static final String TYPE_MID_FILENAME = "types.mid";
	/** The MID diagram suffix. */
	public static final String MID_DIAGRAM_SUFFIX = "diag";

	/**
	 * Creates and adds a model type to the repository from a registered
	 * edu.toronto.cs.se.mmtf.models extension. Requires the model type package
	 * to be registered through a org.eclipse.emf.ecore.generated_package
	 * extension.
	 * 
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmtf.models extension configuration.
	 * @return The created model type, null if the model type can't be created.
	 */
	public static Model createModelType(IConfigurationElement extensionConfig) {

		try {
			boolean newModelTypeAbstract = Boolean.parseBoolean(extensionConfig.getAttribute(MODELS_MODELTYPE_ATTR_ABSTRACT));
			ExtensionType newType = new ExtensionType(extensionConfig, multipleInheritanceTable);
			IConfigurationElement[] constraintConfig = extensionConfig.getChildren(MODELS_MODELTYPE_CHILD_CONSTRAINT);
			String constraintLanguage = (constraintConfig.length == 0) ?
				null :
				constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_LANGUAGE);
			String constraintImplementation = (constraintConfig.length == 0) ?
				null :
				constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_IMPLEMENTATION);
			Model newModelType = MultiModelHeavyTypeFactory.createHeavyModelType(
				newType.getUri(),
				newType.getSupertypeUri(),
				newType.getName(),
				newModelTypeAbstract,
				constraintLanguage,
				constraintImplementation
			);

			return newModelType;
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Model type can't be created", e);
			return null;
		}
	}

	/**
	 * Creates and adds a model relationship type to the repository from a
	 * registered edu.toronto.cs.se.mmtf.relationships extension. Requires the
	 * model relationship type package to be registered through a
	 * org.eclipse.emf.ecore.generated_package extension.
	 * 
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmtf.relationships extension
	 *            configuration.
	 * @return The created model relationship type, null if the model
	 *         relationship type can't be created.
	 */
	public static ModelRel createModelRelType(IConfigurationElement extensionConfig) {

		try {
			IConfigurationElement modelTypeConfig = extensionConfig.getChildren(MODELS_CHILD_MODELTYPE)[0];
			boolean isAbstract = Boolean.parseBoolean(modelTypeConfig.getAttribute(MODELS_MODELTYPE_ATTR_ABSTRACT));
			String factoryClass = modelTypeConfig.getAttribute(MODELS_MODELTYPE_ATTR_FACTORYCLASS);
			MultiModelHeavyTypeFactory factory = (factoryClass == null) ?
				typeFactory :
				(MultiModelHeavyTypeFactory) Platform.getBundle(extensionConfig.getContributor().getName()).loadClass(factoryClass).getConstructor().newInstance();
			ExtensionType newType = new ExtensionType(modelTypeConfig);
			IConfigurationElement[] modelTypeEndpointConfigs = extensionConfig.getChildren(MODELRELS_CHILD_MODELTYPEENDPOINT);
			boolean isBinary = (modelTypeEndpointConfigs.length == 2);
			IConfigurationElement[] constraintConfig = modelTypeConfig.getChildren(MODELS_MODELTYPE_CHILD_CONSTRAINT);
			String constraintLanguage = (constraintConfig.length == 0) ?
				null :
				constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_LANGUAGE);
			String constraintImplementation = (constraintConfig.length == 0) ?
				null :
				constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_IMPLEMENTATION);
			ModelRel newModelRelType = factory.createHeavyModelRelType(
				newType.getUri(),
				newType.getSupertypeUri(),
				newType.getName(),
				isAbstract,
				isBinary,
				constraintLanguage,
				constraintImplementation
			);
			// model type endpoints
			for (IConfigurationElement modelTypeEndpointConfig : modelTypeEndpointConfigs) {
				newType = new ExtensionType(modelTypeEndpointConfig);
				IConfigurationElement modelTypeEndpointSubconfig = modelTypeEndpointConfig.getChildren(CHILD_TYPEENDPOINT)[0];
				String newModelTypeUri = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
				Model newModelType = MultiModelTypeRegistry.getType(newModelTypeUri);
				if (newModelType == null) {
					continue;
				}
				ModelEndpointReference newModelTypeEndpointRef = factory.createHeavyModelTypeEndpointAndModelTypeEndpointReference(
					newType.getUri(),
					newType.getSupertypeUri(),
					newType.getName(),
					newModelType,
					newModelRelType
				);
				int lowerBound = Integer.parseInt(modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND));
				int upperBound = Integer.parseInt(modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND));
				MultiModelTypeFactory.addTypeEndpointCardinality(
					newModelTypeEndpointRef.getObject(),
					lowerBound,
					upperBound
				);
				EPackage rootModelTypeObj = newModelTypeEndpointRef.getObject().getTarget().getEMFTypeRoot();
				// model element types
				IConfigurationElement[] modelElemTypeConfigs = modelTypeEndpointConfig.getChildren(MODELRELS_MODELTYPEENDPOINT_CHILD_MODELELEMTYPE);
				for (IConfigurationElement modelElemTypeConfig : modelElemTypeConfigs) {
					newType = new ExtensionType(modelElemTypeConfig);
					ModelElement newModelElemType = MultiModelTypeRegistry.getType(newType.getUri());
					if (newModelElemType == null) { // create new model element type
						EObject modelElemTypeObj = MultiModelTypeIntrospection.getPointer(rootModelTypeObj.eResource(), newType.getUri());
						EMFInfo eInfo = MultiModelRegistry.getModelElementEMFInfo(modelElemTypeObj, MidLevel.TYPES);
						try {
							newModelElemType = MultiModelHeavyTypeFactory.createHeavyModelElementType(
								newType.getUri(),
								newType.getSupertypeUri(),
								newType.getName(),
								eInfo,
								newModelType
							);
						}
						catch (Exception e) {
							MMTFException.print(Type.WARNING, "Model element type can't be created", e);
							continue;
						}
					}
					ModelElementReference modelElemTypeRef = (newType.getSupertypeUri() == null) ?
						null :
						MultiModelTypeHierarchy.getReference(newType.getSupertypeUri(), newModelTypeEndpointRef.getModelElemRefs());
					newModelElemType.createTypeReference(modelElemTypeRef, true, newModelTypeEndpointRef);
				}
			}
			// link types
			IConfigurationElement[] linkTypeConfigs = extensionConfig.getChildren(MODELRELS_CHILD_LINKTYPE);
			for (IConfigurationElement linkTypeConfig : linkTypeConfigs) {
				IConfigurationElement[] modelElemTypeEndpointConfigs = linkTypeConfig.getChildren(MODELRELS_LINKTYPE_CHILD_MODELELEMTYPEENDPOINT);
				EClass newLinkTypeClass = (modelElemTypeEndpointConfigs.length == 2) ?
					RelationshipPackage.eINSTANCE.getBinaryLink() :
					RelationshipPackage.eINSTANCE.getLink();
				EClass newLinkTypeRefClass = (modelElemTypeEndpointConfigs.length == 2) ?
					RelationshipPackage.eINSTANCE.getBinaryLinkReference() :
					RelationshipPackage.eINSTANCE.getLinkReference();
				newType = new ExtensionType(linkTypeConfig);
				LinkReference newLinkTypeRef;
				try {
					newLinkTypeRef = MultiModelHeavyTypeFactory.createHeavyLinkTypeAndLinkTypeReference(
						newType.getUri(),
						newType.getSupertypeUri(),
						newType.getName(),
						newLinkTypeClass,
						newLinkTypeRefClass,
						newModelRelType
					);
				}
				catch (Exception e) {
					MMTFException.print(Type.WARNING, "Link type can't be created", e);
					continue;
				}
				for (IConfigurationElement modelElemTypeEndpointConfig : modelElemTypeEndpointConfigs) {
					newType = new ExtensionType(modelElemTypeEndpointConfig);
					IConfigurationElement modelElemTypeEndpointSubconfig = modelElemTypeEndpointConfig.getChildren(CHILD_TYPEENDPOINT)[0];
					String newModelElemTypeUri = modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
					ModelElement modelElemType = MultiModelTypeRegistry.getType(newModelElemTypeUri);
					if (modelElemType == null) {
						continue;
					}
					//TODO MMTF[MODELENDPOINT] well model elements should *really* be contained in the model endpoint now that they exist
					ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getEndpointReferences(((Model) modelElemType.eContainer()).getUri(), newModelRelType.getModelEndpointRefs()).get(0);
					ModelElementReference newModelElemTypeRef = MultiModelTypeHierarchy.getReference(newModelElemTypeUri, modelTypeEndpointRef.getModelElemRefs());
					ModelElementEndpointReference newModelElemTypeEndpointRef = MultiModelHeavyTypeFactory.createHeavyModelElementTypeEndpointAndModelElementTypeEndpointReference(
						newType.getUri(),
						newType.getSupertypeUri(),
						newType.getName(),
						newModelElemTypeRef,
						newLinkTypeRef
					);
					int lowerBound = Integer.parseInt(modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND));
					int upperBound = Integer.parseInt(modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND));
					MultiModelTypeFactory.addTypeEndpointCardinality(
						newModelElemTypeEndpointRef.getObject(),
						lowerBound,
						upperBound
					);
				}
			}

			return newModelRelType;
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Model relationship type can't be created", e);
			return null;
		}
	}

	/**
	 * Creates and adds an editor type to the repository from a registered
	 * edu.toronto.cs.se.mmtf.editors extension. Requires the corresponding
	 * Eclipse editor to be registered through a org.eclipse.ui.editors
	 * extension.
	 * 
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmtf.editors extension configuration.
	 * @return The created editor type, null if the editor type can't be
	 *         created.
	 */
	public static Editor createEditorType(IConfigurationElement extensionConfig) {

		try {
			ExtensionType newType = new ExtensionType(extensionConfig);
			String modelTypeUri = extensionConfig.getAttribute(EDITORS_ATTR_MODELTYPEURI);
			String editorId = extensionConfig.getAttribute(EDITORS_ATTR_ID);
			String wizardId = extensionConfig.getAttribute(EDITORS_ATTR_WIZARDID);
			String wizardDialogClassName = extensionConfig.getAttribute(EDITORS_ATTR_WIZARDDIALOGCLASS);
			EClass newEditorTypeClass = (Boolean.parseBoolean(extensionConfig.getAttribute(EDITORS_ATTR_ISDIAGRAM))) ?
				EditorPackage.eINSTANCE.getDiagram() :
				EditorPackage.eINSTANCE.getEditor();
			Editor newEditorType = MultiModelHeavyTypeFactory.createHeavyEditorType(
				newType.getUri(),
				newType.getSupertypeUri(),
				newType.getName(),
				modelTypeUri,
				editorId,
				wizardId,
				wizardDialogClassName,
				newEditorTypeClass
			);

			return newEditorType;
		}
		catch (MMTFException e) {
			MMTFException.print(Type.WARNING, "Editor type can't be created", e);
			return null;
		}
	}

	/**
	 * Creates and adds a class of parameter types to an operator type.
	 * 
	 * @param paramTypeConfig
	 *            The edu.toronto.cs.se.mmtf.operators extension
	 *            subconfiguration for the class of parameter types.
	 * @param paramTypes
	 *            The list of parameter types that will contain the new
	 *            parameter types.
	 * @param operatorType
	 *            The operator type that will contain the new parameter types.
	 * @throws MMTFException
	 *             If there exists a vararg parameter type which is not the last
	 *             parameter type.
	 */
	private static void createOperatorParameters(IConfigurationElement paramTypeConfig, EList<Parameter> paramTypes, Operator operatorType) throws MMTFException {

		int i = 0;
		IConfigurationElement[] paramTypeConfigElems = paramTypeConfig.getChildren(OPERATORS_INPUTOUTPUT_CHILD_PARAMETER);
		for (IConfigurationElement paramTypeConfigElem : paramTypeConfigElems) {
			String newParamTypeName = paramTypeConfigElem.getAttribute(OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_NAME);
			boolean isVararg = Boolean.parseBoolean(paramTypeConfigElem.getAttribute(OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_ISVARARG));
			if (isVararg && i != (paramTypeConfigElems.length-1)) {
				throw new MMTFException("Only the last parameter can be vararg");
			}
			String modelTypeUri = paramTypeConfigElem.getAttribute(OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_MODELTYPEURI);
			MultiModelHeavyTypeFactory.createHeavyOperatorTypeParameter(newParamTypeName, modelTypeUri, isVararg, paramTypes, operatorType);
			i++;
		}
	}

	/**
	 * Creates and adds input/output parameter types to an operator type.
	 * 
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmtf.operators extension configuration.
	 * @param operatorType
	 *            The operator type that will contain the new parameter types.
	 */
	public static void createOperatorTypeParameters(IConfigurationElement extensionConfig, Operator operatorType) {

		try {
			IConfigurationElement inputParamTypeConfig = extensionConfig.getChildren(OPERATORS_CHILD_INPUT)[0];
			createOperatorParameters(inputParamTypeConfig, operatorType.getInputs(), operatorType);
			IConfigurationElement outputParamTypeConfig = extensionConfig.getChildren(OPERATORS_CHILD_OUTPUT)[0];
			createOperatorParameters(outputParamTypeConfig, operatorType.getOutputs(), operatorType);
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Operator type parameters can't be created", e);
		}
	}

	/**
	 * Creates and adds an editor type to the repository from a registered
	 * edu.toronto.cs.se.mmtf.operators extension.
	 * 
	 * @param extensionConfig
	 *            The edu.toronto.cs.se.mmtf.operators extension configuration.
	 * @return The created operator type, null if the operator type can't be
	 *         created.
	 */
	public static Operator createOperatorType(IConfigurationElement extensionConfig) {

		try {
			ExtensionType newType = new ExtensionType(extensionConfig);
			EClass newOperatorTypeClass = (Boolean.parseBoolean(extensionConfig.getAttribute(OPERATORS_ATTR_ISCONVERSION))) ?
				OperatorPackage.eINSTANCE.getConversionOperator() :
				OperatorPackage.eINSTANCE.getOperator();
			OperatorExecutable executable = (OperatorExecutable) extensionConfig.createExecutableExtension(OPERATORS_ATTR_CLASS);
			if (executable instanceof RandomOperatorExecutableImpl) {
				((RandomOperatorExecutableImpl) executable).setState(new Random());
			}
			Operator newOperatorType = MultiModelHeavyTypeFactory.createHeavyOperatorType(
				newType.getUri(),
				newType.getSupertypeUri(),
				newType.getName(),
				executable,
				newOperatorTypeClass
			);

			return newOperatorType;
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Operator type can't be created", e);
			return null;
		}
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
	private static void createConversionHierarchy(ExtendibleElement type, Map<String, List<String>> conversionTypes) {

		// previous conversions
		List<String> previousConversions = conversionTypes.get(type.getUri());

		// add conversions
		for (ConversionOperator operatorType : ((Model) type).getConversionOperators()) {
			Model conversionType = operatorType.getOutputs().get(0).getModel();
			String conversionTypeUri = conversionType.getUri();
			if (!conversionTypes.containsKey(conversionTypeUri)) { // coherence of multiple paths is assumed
				// keep track of conversion operators used
				List<String> conversions = (previousConversions == null) ?
					new ArrayList<String>() :
					new ArrayList<String>(previousConversions);
				conversions.add(operatorType.getUri()); // add new operator to be used
				conversionTypes.put(conversionTypeUri, conversions);
				// recursion
				createConversionHierarchy(conversionType, conversionTypes);
			}
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
	private static void createTypeHierarchy(MultiModel multiModel, Map<String, Set<String>> subtypeTable, Map<String, Map<String, List<String>>> conversionTable) {

		subtypeTable.clear();
		conversionTable.clear();
		for (ExtendibleElement type : multiModel.getExtendibleTable().values()) {
			subtypeTable.put(type.getUri(), new HashSet<String>());
			conversionTable.put(type.getUri(), new HashMap<String, List<String>>());
		}
		for (ExtendibleElement type : multiModel.getExtendibleTable().values()) {
			createSubtypeHierarchy(type, type, subtypeTable);
		}
		for (Model modelType : MultiModelRegistry.getModels(multiModel)) {
			createConversionHierarchy(modelType, conversionTable.get(modelType.getUri()));
			for (Model modelSubtype : MultiModelTypeHierarchy.getSubtypes(modelType, multiModel)) {
				createConversionHierarchy(modelType, conversionTable.get(modelSubtype.getUri()));
			}
		}
	}

	/**
	 * Creates the necessary structures to support the type hierarchy for the
	 * repository.
	 */
	public static void createTypeHierarchy() {

		createTypeHierarchy(repository, subtypeTable, conversionTable);
	}

	/**
	 * Creates the necessary structures to support the type hierarchy for the
	 * Type MID.
	 * 
	 * @param multiModel
	 *            The multimodel root of the Type MID.
	 */
	public static void createTypeHierarchy(MultiModel multiModel) {

		createTypeHierarchy(multiModel, subtypeTableMID, conversionTableMID);
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
					dynamicModelType.getConstraint().getLanguage().getLiteral(),
					dynamicModelType.getConstraint().getImplementation(),
					(MultiModelTypeRegistry.getExtendedMetamodelUri(dynamicModelType) != null)
				);
			}
		}
		catch (MMTFException e) {
			MMTFException.print(MMTFException.Type.WARNING, "Dynamic type " + dynamicModelType.getName() + " can't be recreated", e);
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
			multiModel = (MultiModel) MultiModelUtils.getModelFileInState(TYPE_MID_FILENAME);
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "No previous Type MID found, skipping dynamic types", e);
			return;
		}

		// do model types first
		//TODO MMTF: this probably explains the todo in type hierarchy (are type and type ref iterators really needed, or are the lists already ordered by construction?)
		for (Model dynamicModelType : MultiModelRegistry.getModels(multiModel)) {
			if (!(dynamicModelType instanceof ModelRel) &&
				dynamicModelType.isDynamic() &&
				MultiModelTypeRegistry.getType(dynamicModelType.getUri()) == null
			) {
				createDynamicModelType(dynamicModelType);
			}
		}
		for (ModelRel dynamicModelRelType : MultiModelRegistry.getModelRels(multiModel)) {
			if (dynamicModelRelType.isDynamic() &&
				MultiModelTypeRegistry.getType(dynamicModelRelType.getUri()) == null
			) {
				createDynamicModelType(dynamicModelRelType);
			}
		}
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

		repository = MidFactory.eINSTANCE.createMultiModel();
		repository.setLevel(MidLevel.TYPES);
		bundleTable = new HashMap<String, String>();
		multipleInheritanceTable = new HashMap<String, Set<String>>();
		typeFactory = new MultiModelHeavyTypeFactory();
		IConfigurationElement[] configs;
		Iterator<IConfigurationElement> extensionsIter;
		IConfigurationElement config;
		ExtendibleElement type;

		// model types
		configs = registry.getConfigurationElementsFor(MODELS_EXT_POINT);
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, null, ROOT_MODEL_URI);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			type = createModelType(config);
			bundleTable.put(type.getUri(), config.getContributor().getName());
		}
		// model relationship types
		configs = registry.getConfigurationElementsFor(MODELRELS_EXT_POINT);
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, MODELS_CHILD_MODELTYPE, ROOT_MODELREL_URI);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			type = createModelRelType(config);
			bundleTable.put(type.getUri(), config.getContributor().getName());
		}
		// editor types
		configs = registry.getConfigurationElementsFor(EDITORS_EXT_POINT);
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, null, ROOT_EDITOR_URI);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			Editor editorType = createEditorType(config);
			bundleTable.put(editorType.getUri(), config.getContributor().getName());
			MultiModelHeavyTypeFactory.addHeavyModelTypeEditor(editorType, editorType.getModelUri());
		}
		// operator types
		configs = registry.getConfigurationElementsFor(OPERATORS_EXT_POINT);
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, null, null);
		while (extensionsIter.hasNext()) {
			IConfigurationElement extensionConfig = extensionsIter.next();
			Operator newOperatorType = createOperatorType(extensionConfig);
			createOperatorTypeParameters(extensionConfig, newOperatorType);
			if (newOperatorType instanceof ConversionOperator) {
				MultiModelTypeFactory.createOperatorTypeConversion((ConversionOperator) newOperatorType);
			}
		}
		// dynamic types from last shutdown
		createDynamicModelTypes();

		// type hierarchy
		subtypeTable = new HashMap<String, Set<String>>();
		conversionTable = new HashMap<String, Map<String, List<String>>>();
		subtypeTableMID = new HashMap<String, Set<String>>();
		conversionTableMID = new HashMap<String, Map<String, List<String>>>();
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
	private static void copyConversionTable(Map<String, Map<String, List<String>>> srcTable, Map<String, Map<String, List<String>>> tgtTable) {

		for (Map.Entry<String, Map<String, List<String>>> entry : srcTable.entrySet()) {
			Map<String, List<String>> newValue = new HashMap<String, List<String>>();
			for (Map.Entry<String, List<String>> nestedEntry : entry.getValue().entrySet()) {
				List<String> newNestedValue = new ArrayList<String>(nestedEntry.getValue());
				newValue.put(nestedEntry.getKey(), newNestedValue);
			}
			tgtTable.put(entry.getKey(), newValue);
		}
	}

	/**
	 * Stores the repository into the Type MID file (repository -> Type MID).
	 */
	public static void storeRepository() {

		createTypeHierarchy();
		copySubtypeTable(subtypeTable, subtypeTableMID);
		copyConversionTable(conversionTable, conversionTableMID);
		try {
			MultiModelUtils.createModelFileInState(repository, TYPE_MID_FILENAME);
		}
		catch (Exception e) {
			MMTFException.print(Type.ERROR, "Error creating Type MID file", e);
		}
	}

	/**
	 * Syncs the Type MID with the repository (TypeMID -> Repository).
	 * 
	 * @param multiModel
	 *            The multimodel root of the Type MID.
	 */
	public static void syncRepository(MultiModel multiModel) {

		List<OperatorExecutable> executables = new ArrayList<OperatorExecutable>();
		for (Operator operator : repository.getOperators()) {
			executables.add(operator.getExecutable());
		}
		repository = EcoreUtil.copy(multiModel);
		for (int i = 0; i < repository.getOperators().size(); i++) {
			Operator operator = repository.getOperators().get(i);
			operator.setExecutable(executables.get(i));
		}
		copySubtypeTable(subtypeTableMID, subtypeTable);
		copyConversionTable(conversionTableMID, conversionTable);
	}

	/**
	 * Initializes the settings.
	 */
	private void initSettings() {

		settings = new HashMap<String, Object>();
		ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getService(ICommandService.class);
		Command command = commandService.getCommand(SETTING_MENU_ICONS_ENABLED);
		boolean isEnabled = (boolean) command.getState(RegistryToggleState.STATE_ID).getValue();
		settings.put(SETTING_MENU_ICONS_ENABLED, new Boolean(isEnabled));
		command = commandService.getCommand(SETTING_MENU_ENDPOINTS_ENABLED);
		isEnabled = (boolean) command.getState(RegistryToggleState.STATE_ID).getValue();
		settings.put(SETTING_MENU_ENDPOINTS_ENABLED, new Boolean(isEnabled));
		command = commandService.getCommand(SETTING_MENU_MODELRELS_ENABLED);
		isEnabled = (boolean) command.getState(RegistryToggleState.STATE_ID).getValue();
		settings.put(SETTING_MENU_MODELRELS_ENABLED, new Boolean(isEnabled));
		command = commandService.getCommand(SETTING_MENU_LINKS_ENABLED);
		isEnabled = (boolean) command.getState(RegistryToggleState.STATE_ID).getValue();
		settings.put(SETTING_MENU_LINKS_ENABLED, new Boolean(isEnabled));
		command = commandService.getCommand(SETTING_MENU_DIAGRAMS_CREATION_ENABLED);
		isEnabled = (boolean) command.getState(RegistryToggleState.STATE_ID).getValue();
		settings.put(SETTING_MENU_DIAGRAMS_CREATION_ENABLED, new Boolean(isEnabled));
		command = commandService.getCommand(SETTING_MENU_ALTERNATIVE_MODEL_TREE_ENABLED);
		isEnabled = (boolean) command.getState(RegistryToggleState.STATE_ID).getValue();
		settings.put(SETTING_MENU_ALTERNATIVE_MODEL_TREE_ENABLED, new Boolean(isEnabled));
	}

	/**
	 * Gets a setting.
	 * 
	 * @param settingName
	 *            The setting name.
	 * @return The setting, null if the setting name could not be found.
	 */
	public static Object getSetting(String settingName) {

		return settings.get(settingName);
	}

	/**
	 * Sets a setting.
	 * 
	 * @param settingName
	 *            The setting name.
	 * @param setting
	 *            The new setting.
	 * @return True if the setting was set, false if the setting name could not
	 *         be found.
	 */
	public static boolean setSetting(String settingName, Object setting) {

		if (!settings.containsKey(settingName)) {
			return false;
		}
		settings.put(settingName, setting);

		return true;
	}

	public static boolean isInitialized() {

		return INSTANCE != null;
	}

	/**
	 * Constructor: initializes the settings, initializes the repository and
	 * registers listeners for dynamic installation/unistallation of extensions.
	 */
	private MMTF() {

		initSettings();
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
