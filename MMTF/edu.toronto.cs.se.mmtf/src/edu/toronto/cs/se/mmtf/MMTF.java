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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorPackage;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
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
import edu.toronto.cs.se.mmtf.repository.MMTFConstants;
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
public class MMTF implements MMTFConstants {

	/** The singleton instance. */
	static final MMTF INSTANCE = new MMTF();

	/** The repository of registered extensions. */
	static MultiModel repository;

	/**	The table for model type hierarchy. */
	static Map<String, Set<String>> subtypeTable;

	/**	The table for model type conversion. */
	static Map<String, Map<String, List<String>>> conversionTable;

	/**	The table for model type hierarchy in the type MID. */
	static Map<String, Set<String>> subtypeTableMID;

	/**	The table for model type conversion in the type MID. */
	static Map<String, Map<String, List<String>>> conversionTableMID;

	/** The table to map element type uris to their bundle name. */
	static Map<String, String> bundleTable;

	public static final String TYPE_MID_FILENAME = "types.mid";

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
	public static Model createModelType(IConfigurationElement extensionConfig) {

		try {
			boolean newModelTypeAbstract = Boolean.parseBoolean(extensionConfig.getAttribute(MODELS_MODELTYPE_ATTR_ABSTRACT));
			IConfigurationElement typeConfig = extensionConfig.getChildren(CHILD_EXTENDIBLETYPE)[0];
			String newModelTypeUri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
			String modelTypeUri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_SUPERTYPEURI);
			String newModelTypeName = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_NAME);
			IConfigurationElement[] constraintConfig = extensionConfig.getChildren(MODELS_MODELTYPE_CHILD_CONSTRAINT);
			String constraintLanguage = (constraintConfig.length == 0) ?
				null :
				constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_LANGUAGE);
			String constraintImplementation = (constraintConfig.length == 0) ?
				null :
				constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_IMPLEMENTATION);
			Model newModelType = MultiModelHeavyTypeFactory.createHeavyModelType(
				newModelTypeUri,
				modelTypeUri,
				newModelTypeName,
				newModelTypeAbstract,
				constraintLanguage,
				constraintImplementation
			);

			return newModelType;
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Model type can't be registered", e);
			return null;
		}
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
	public static ModelRel createModelRelType(IConfigurationElement extensionConfig) {

		try {
			IConfigurationElement modelTypeConfig = extensionConfig.getChildren(MODELS_CHILD_MODELTYPE)[0];
			boolean newModelRelTypeAbstract = Boolean.parseBoolean(modelTypeConfig.getAttribute(MODELS_MODELTYPE_ATTR_ABSTRACT));
			IConfigurationElement typeConfig = modelTypeConfig.getChildren(CHILD_EXTENDIBLETYPE)[0];
			String newModelRelTypeUri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
			String modelRelTypeUri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_SUPERTYPEURI);
			String newModelRelTypeName = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_NAME);
			IConfigurationElement[] modelTypeEndpointConfigs = extensionConfig.getChildren(MODELRELS_CHILD_MODELTYPEENDPOINT);
			EClass newModelRelTypeClass = (modelTypeEndpointConfigs.length == 2) ?
				RelationshipPackage.eINSTANCE.getBinaryModelRel() :
				RelationshipPackage.eINSTANCE.getModelRel();
			IConfigurationElement[] constraintConfig = modelTypeConfig.getChildren(MODELS_MODELTYPE_CHILD_CONSTRAINT);
			String constraintLanguage = (constraintConfig.length == 0) ?
				null :
				constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_LANGUAGE);
			String constraintImplementation = (constraintConfig.length == 0) ?
				null :
				constraintConfig[0].getAttribute(MODELS_MODELTYPE_CONSTRAINT_ATTR_IMPLEMENTATION);
			ModelRel newModelRelType = MultiModelHeavyTypeFactory.createHeavyModelRelType(
				newModelRelTypeUri,
				modelRelTypeUri,
				newModelRelTypeName,
				newModelRelTypeAbstract,
				constraintLanguage,
				constraintImplementation,
				newModelRelTypeClass
			);
			// model type endpoints
			for (IConfigurationElement modelTypeEndpointConfig : modelTypeEndpointConfigs) {
				IConfigurationElement modelTypeEndpointSubconfig = modelTypeEndpointConfig.getChildren(CHILD_EXTENDIBLETYPE)[0];
				String newModelTypeEndpointUri = modelTypeEndpointSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
				String modelTypeEndpointUri = modelTypeEndpointSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_SUPERTYPEURI);
				String newModelTypeEndpointName = modelTypeEndpointSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_NAME);
				modelTypeEndpointSubconfig = modelTypeEndpointConfig.getChildren(CHILD_TYPEENDPOINT)[0];
				String newModelTypeUri = modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
				Model newModelType = MultiModelTypeRegistry.getExtendibleElementType(newModelTypeUri);
				if (newModelType == null) {
					continue;
				}
				ModelEndpointReference newModelTypeEndpointRef = MultiModelHeavyTypeFactory.createHeavyModelTypeEndpointAndModelTypeEndpointReference(
					newModelRelType,
					newModelTypeEndpointUri,
					modelTypeEndpointUri,
					newModelType,
					newModelTypeEndpointName
				);
				int lowerBound = Integer.parseInt(modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND));
				int upperBound = Integer.parseInt(modelTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND));
				MultiModelTypeFactory.addExtendibleElementTypeEndpointCardinality(
					newModelTypeEndpointRef.getObject(),
					lowerBound,
					upperBound
				);
				// model element types
				IConfigurationElement[] modelElemTypeConfigs = modelTypeEndpointConfig.getChildren(MODELRELS_MODELTYPEENDPOINT_CHILD_MODELELEMTYPE);
				for (IConfigurationElement modelElemTypeConfig : modelElemTypeConfigs) {
					IConfigurationElement modelElemTypeSubconfig = modelElemTypeConfig.getChildren(CHILD_EXTENDIBLETYPE)[0];
					String newModelElemTypeUri = modelElemTypeSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
					String modelElemTypeUri = modelElemTypeSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_SUPERTYPEURI);
					String newModelElemTypeName = modelElemTypeSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_NAME);
					ModelElement newModelElemType = MultiModelTypeRegistry.getExtendibleElementType(newModelElemTypeUri);
					if (newModelElemType == null) { // create new model element type
						ModelElementCategory category = ModelElementCategory.get(modelElemTypeConfig.getAttribute(MODELRELS_MODELTYPEENDPOINT_MODELELEMTYPE_ATTR_CATEGORY));
						String classLiteral = modelElemTypeConfig.getAttribute(MODELRELS_MODELTYPEENDPOINT_MODELELEMTYPE_ATTR_CLASSLITERAL);
						try {
							newModelElemType = MultiModelHeavyTypeFactory.createHeavyModelElementType(
								newModelType,
								newModelElemTypeUri,
								modelElemTypeUri,
								newModelElemTypeName,
								category,
								classLiteral
							);
						}
						catch (Exception e) {
							MMTFException.print(Type.WARNING, "Model element type can't be registered", e);
							continue;
						}
					}
					ModelElementReference modelElemTypeRef = (modelElemTypeUri == null) ?
						null :
						MultiModelTypeHierarchy.getReference(modelElemTypeUri, newModelTypeEndpointRef.getModelElemRefs());
					MultiModelTypeFactory.createModelElementTypeReference(
						newModelTypeEndpointRef,
						modelElemTypeRef,
						newModelElemType,
						true
					);
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
				IConfigurationElement linkTypeSubconfig = linkTypeConfig.getChildren(CHILD_EXTENDIBLETYPE)[0];
				String newLinkTypeUri = linkTypeSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
				String linkTypeUri = linkTypeSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_SUPERTYPEURI);
				String newLinkTypeName = linkTypeSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_NAME);
				LinkReference newLinkTypeRef;
				try {
					newLinkTypeRef = MultiModelHeavyTypeFactory.createHeavyLinkTypeAndLinkTypeReference(
						newModelRelType,
						newLinkTypeUri,
						linkTypeUri,
						newLinkTypeName,
						newLinkTypeClass,
						newLinkTypeRefClass
					);
				}
				catch (Exception e) {
					MMTFException.print(Type.WARNING, "Link type can't be registered", e);
					continue;
				}
				for (IConfigurationElement modelElemTypeEndpointConfig : modelElemTypeEndpointConfigs) {
					IConfigurationElement modelElemTypeEndpointSubconfig = modelElemTypeEndpointConfig.getChildren(CHILD_EXTENDIBLETYPE)[0];
					String newModelElemTypeEndpointUri = modelElemTypeEndpointSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
					String modelElemTypeEndpointUri = modelElemTypeEndpointSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_SUPERTYPEURI);
					String newModelElemTypeEndpointName = modelElemTypeEndpointSubconfig.getAttribute(EXTENDIBLETYPE_ATTR_NAME);
					modelElemTypeEndpointSubconfig = modelElemTypeEndpointConfig.getChildren(CHILD_TYPEENDPOINT)[0];
					String newModelElemTypeUri = modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_TARGETTYPEURI);
					ModelElement modelElemType = MultiModelTypeRegistry.getExtendibleElementType(newModelElemTypeUri);
					if (modelElemType == null) {
						continue;
					}
					//TODO MMTF: well model elements should *really* be contained in the model endpoint now that they exist
					ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getEndpointReferences(((Model) modelElemType.eContainer()).getUri(), newModelRelType.getModelEndpointRefs()).get(0);
					ModelElementReference newModelElemTypeRef = MultiModelTypeHierarchy.getReference(newModelElemTypeUri, modelTypeEndpointRef.getModelElemRefs());
					ModelElementEndpointReference newModelElemTypeEndpointRef = MultiModelHeavyTypeFactory.createHeavyModelElementTypeEndpointAndModelElementTypeEndpointReference(
						newLinkTypeRef,
						newModelElemTypeEndpointUri,
						modelElemTypeEndpointUri,
						newModelElemTypeRef,
						newModelElemTypeEndpointName
					);
					int lowerBound = Integer.parseInt(modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_LOWERBOUND));
					int upperBound = Integer.parseInt(modelElemTypeEndpointSubconfig.getAttribute(TYPEENDPOINT_ATTR_UPPERBOUND));
					MultiModelTypeFactory.addExtendibleElementTypeEndpointCardinality(
						newModelElemTypeEndpointRef.getObject(),
						lowerBound,
						upperBound
					);
				}
			}

			return newModelRelType;
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Model relationship type can't be registered", e);
			return null;
		}
	}

	/**
	 * Creates and adds an editor type to the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created editor type.
	 */
	public static Editor createEditorType(IConfigurationElement extensionConfig) {

		try {
			IConfigurationElement typeConfig = extensionConfig.getChildren(CHILD_EXTENDIBLETYPE)[0];
			String newEditorTypeUri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
			String editorTypeUri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_SUPERTYPEURI);
			String newEditorTypeName = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_NAME);
			String modelTypeUri = extensionConfig.getAttribute(EDITORS_ATTR_MODELTYPEURI);
			String editorId = extensionConfig.getAttribute(EDITORS_ATTR_ID);
			String wizardId = extensionConfig.getAttribute(EDITORS_ATTR_WIZARDID);
			String wizardDialogClassName = extensionConfig.getAttribute(EDITORS_ATTR_WIZARDDIALOGCLASS);
			EClass newEditorTypeClass = (Boolean.parseBoolean(extensionConfig.getAttribute(EDITORS_ATTR_ISDIAGRAM))) ?
				EditorPackage.eINSTANCE.getDiagram() :
				EditorPackage.eINSTANCE.getEditor();
			Editor newEditorType = MultiModelHeavyTypeFactory.createHeavyEditorType(newEditorTypeUri, editorTypeUri, newEditorTypeName, modelTypeUri, editorId, wizardId, wizardDialogClassName, newEditorTypeClass);

			return newEditorType;
		}
		catch (MMTFException e) {
			MMTFException.print(Type.WARNING, "Editor type can't be registered", e);
			return null;
		}
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
	private static void createOperatorParameters(Operator operatorType, EList<Parameter> paramTypes, IConfigurationElement paramTypeConfig) throws MMTFException {

		int i = 0;
		IConfigurationElement[] paramTypeConfigElems = paramTypeConfig.getChildren(OPERATORS_INPUTOUTPUT_CHILD_PARAMETER);
		for (IConfigurationElement paramTypeConfigElem : paramTypeConfigElems) {
			String newParamTypeName = paramTypeConfigElem.getAttribute(OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_NAME);
			boolean isVararg = Boolean.parseBoolean(paramTypeConfigElem.getAttribute(OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_ISVARARG));
			if (isVararg && i != (paramTypeConfigElems.length-1)) {
				throw new MMTFException("Only last parameter can be a vararg parameter");
			}
			String modelTypeUri = paramTypeConfigElem.getAttribute(OPERATORS_INPUTOUTPUT_PARAMETER_ATTR_MODELTYPEURI);
			MultiModelHeavyTypeFactory.createHeavyOperatorTypeParameter(operatorType, modelTypeUri, paramTypes, newParamTypeName, isVararg);
			i++;
		}
	}

	public static void createOperatorTypeParameters(Operator operatorType, IConfigurationElement extensionConfig) {

		try {
			IConfigurationElement inputParamTypeConfig = extensionConfig.getChildren(OPERATORS_CHILD_INPUT)[0];
			createOperatorParameters(operatorType, operatorType.getInputs(), inputParamTypeConfig);
			IConfigurationElement outputParamTypeConfig = extensionConfig.getChildren(OPERATORS_CHILD_OUTPUT)[0];
			createOperatorParameters(operatorType, operatorType.getOutputs(), outputParamTypeConfig);
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Operator type parameters can't be registered", e);
		}
	}

	/**
	 * Creates and adds an operator to the repository.
	 * 
	 * @param extensionConfig
	 *            The extension configuration.
	 * @return The created operator.
	 */
	public static Operator createOperatorType(IConfigurationElement extensionConfig) {

		try {
			IConfigurationElement typeConfig = extensionConfig.getChildren(CHILD_EXTENDIBLETYPE)[0];
			String newOperatorTypeUri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_URI);
			String operatorTypeUri = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_SUPERTYPEURI);
			String newOperatorTypeName = typeConfig.getAttribute(EXTENDIBLETYPE_ATTR_NAME);
			EClass newOperatorTypeClass = (Boolean.parseBoolean(extensionConfig.getAttribute(OPERATORS_ATTR_ISCONVERSION))) ?
				OperatorPackage.eINSTANCE.getConversionOperator() :
				OperatorPackage.eINSTANCE.getOperator();
			OperatorExecutable executable = (OperatorExecutable) extensionConfig.createExecutableExtension(OPERATORS_ATTR_CLASS);
			if (executable instanceof RandomOperatorExecutableImpl) {
				((RandomOperatorExecutableImpl) executable).setState(new Random());
			}
			Operator newOperatorType = MultiModelHeavyTypeFactory.createHeavyOperatorType(newOperatorTypeUri, operatorTypeUri, newOperatorTypeName, executable, newOperatorTypeClass);

			return newOperatorType;
		}
		catch (Exception e) {
			MMTFException.print(Type.WARNING, "Operator type can't be registered", e);
			return null;
		}
	}

	//TODO MMTF: evaluate if this optimization was really needed
//	/**
//	 * Adds file extensions to all initial editor types at once. Requires the
//	 * editor types to be registered too through the org.eclipse.ui.editors
//	 * extension point.
//	 * 
//	 * @param registry
//	 *            The Eclipse extension registry.
//	 */
//	private void addEditorTypesFileExtensions(IExtensionRegistry registry) {
//
//		// create temp editor table using ids
//		HashMap<String, Editor> tempEditorTable = new HashMap<String, Editor>();
//		for (Editor editorType : repository.getEditors()) {
//			tempEditorTable.put(editorType.getId(), editorType);
//		}
//
//		// loop through eclipse editors
//		IConfigurationElement[] config = registry.getConfigurationElementsFor(ECLIPSE_EDITORS_EXT_POINT);
//		Editor editorType;
//		for (IConfigurationElement elem : config) {
//			editorType = tempEditorTable.get(elem.getAttribute(ECLIPSE_EDITORS_ATTR_ID));
//			if (editorType != null) {
//				String extensions = elem.getAttribute(ECLIPSE_EDITORS_ATTR_EXTENSIONS);
//				if (extensions == null) {
//					Model modelType = MultiModelTypeRegistry.getModelType(editorType.getModelUri());
//					extensions = (modelType != null) ?
//						modelType.getFileExtension() :
//						"";
//				}
//				for (String fileExtension : extensions.split(",")) {
//					editorType.getFileExtensions().add(fileExtension);
//				}
//			}
//		}
//	}

	private static void addTypeHierarchy(ExtendibleElement currentType, ExtendibleElement subtype, Map<String, Set<String>> subtypeTable) {

		// add subtype to supertypes
		String subtypeUri = subtype.getUri();
		ExtendibleElement supertype = currentType.getSupertype();
		if (supertype != null) {
			String supertypeUri = supertype.getUri();
			Set<String> subtypes = subtypeTable.get(supertypeUri);
			if (!subtypes.contains(subtypeUri)) {
				subtypes.add(subtypeUri);
				// recursion
				addTypeHierarchy(supertype, subtype, subtypeTable);
			}
		}
	}

	private static void addConversionHierarchy(ExtendibleElement currentType, Map<String, List<String>> conversionTypes) {

		// previous conversions
		List<String> previousConversions = conversionTypes.get(currentType.getUri());

		// add convertions
		for (ConversionOperator operatorType : ((Model) currentType).getConversionOperators()) {
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
				addConversionHierarchy(conversionType, conversionTypes);
			}
		}
	}

	private static void initTypeHierarchy(MultiModel multiModel, Map<String, Set<String>> subtypeTable, Map<String, Map<String, List<String>>> conversionTable) {

		subtypeTable.clear();
		conversionTable.clear();
		for (ExtendibleElement type : multiModel.getExtendibleTable().values()) {
			subtypeTable.put(type.getUri(), new HashSet<String>());
			conversionTable.put(type.getUri(), new HashMap<String, List<String>>());
		}
		for (ExtendibleElement type : multiModel.getExtendibleTable().values()) {
			addTypeHierarchy(type, type, subtypeTable);
		}
		for (Model modelType : MultiModelTypeRegistry.getModelTypes(multiModel)) {
			addConversionHierarchy(modelType, conversionTable.get(modelType.getUri()));
			for (Model modelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelType)) {
				addConversionHierarchy(modelType, conversionTable.get(modelSubtype.getUri()));
			}
		}
	}

	public static void initTypeHierarchy() {

		initTypeHierarchy(repository, subtypeTable, conversionTable);
	}

	public static void initTypeHierarchy(MultiModel multiModel) {

		initTypeHierarchy(multiModel, subtypeTableMID, conversionTableMID);
	}
	
	private Model addDynamicType(Model dynamicModelType) {

		Model modelType = MultiModelTypeRegistry.getExtendibleElementType(dynamicModelType.getSupertype().getUri());
		if (modelType == null && dynamicModelType.getSupertype().isDynamic()) {
			modelType = addDynamicType(dynamicModelType.getSupertype());
		}
		if (modelType == null) {
			return null;
		}

		Model newModelType = null;
		if (dynamicModelType instanceof ModelRel) {
			try {
				newModelType = MultiModelLightTypeFactory.createLightModelRelType(
					(ModelRel) modelType,
					dynamicModelType.getName(),
					dynamicModelType.getConstraint().getImplementation(),
					dynamicModelType.eClass()
				);
				MultiModelLightTypeFactory.copyLightModelRelType((ModelRel) dynamicModelType, (ModelRel) newModelType);
			}
			catch (MMTFException e) {
				MMTFException.print(MMTFException.Type.WARNING, "Dynamic model rel type " + dynamicModelType.getName() + " could not be recreated", e);
			}
		}
		else {
			try {
				newModelType = MultiModelLightTypeFactory.createLightModelType(
					modelType, 
					dynamicModelType.getName(),
					dynamicModelType.getConstraint().getImplementation()
				);
			}
			catch (MMTFException e) {
				MMTFException.print(MMTFException.Type.WARNING, "Dynamic model type " + dynamicModelType.getName() + " could not be recreated", e);
			}
		}

		return newModelType;
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
		//TODO MMTF: this probably explains the todo in type hierarchy (are type and type ref iterators really needed, or are the lists already ordered by construction?)
		for (Model modelType : MultiModelTypeRegistry.getModelTypes(multiModel)) {
			if (!(modelType instanceof ModelRel) &&
				modelType.isDynamic() &&
				MultiModelTypeRegistry.getExtendibleElementType(modelType.getUri()) == null
			) {
				addDynamicType(modelType);
			}
		}
		for (ModelRel modelRelType : MultiModelTypeRegistry.getModelRelTypes(multiModel)) {
			if (modelRelType.isDynamic() &&
				MultiModelTypeRegistry.getExtendibleElementType(modelRelType.getUri()) == null
			) {
				addDynamicType(modelRelType);
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
		bundleTable = new HashMap<String, String>();
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
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, null, null);
		while (extensionsIter.hasNext()) {
			config = extensionsIter.next();
			Editor editorType = createEditorType(config);
			bundleTable.put(editorType.getUri(), config.getContributor().getName());
			MultiModelHeavyTypeFactory.createHeavyModelTypeEditor(editorType, editorType.getModelUri());
		}

		// operator types
		configs = registry.getConfigurationElementsFor(OPERATORS_EXT_POINT);
		extensionsIter = MultiModelTypeHierarchy.getExtensionHierarchyIterator(configs, null, null);
		while (extensionsIter.hasNext()) {
			IConfigurationElement extensionConfig = extensionsIter.next();
			Operator newOperatorType = createOperatorType(extensionConfig);
			createOperatorTypeParameters(newOperatorType, extensionConfig);
			if (newOperatorType instanceof ConversionOperator) {
				MultiModelTypeFactory.createOperatorTypeConversion((ConversionOperator) newOperatorType);
			}
		}
		// dynamic types from last shutdown
		initDynamicTypes();

		// type hierarchy
		subtypeTable = new HashMap<String, Set<String>>();
		conversionTable = new HashMap<String, Map<String, List<String>>>();
		subtypeTableMID = new HashMap<String, Set<String>>();
		conversionTableMID = new HashMap<String, Map<String, List<String>>>();
		storeRepository();
	}

	private static void copySubtypeTable(Map<String, Set<String>> srcTable, Map<String, Set<String>> tgtTable) {

		for (Map.Entry<String, Set<String>> entry : srcTable.entrySet()) {
			Set<String> newValue = new HashSet<String>(entry.getValue());
			tgtTable.put(entry.getKey(), newValue);
		}
	}

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

	public static void storeRepository() {

		initTypeHierarchy();
		copySubtypeTable(subtypeTable, subtypeTableMID);
		copyConversionTable(conversionTable, conversionTableMID);
		String path = MMTFActivator.getDefault().getStateLocation().toOSString();
		String uri = path + IPath.SEPARATOR + TYPE_MID_FILENAME;
		try {
			MultiModelTypeIntrospection.writeRoot(repository, uri, false);
		}
		catch (Exception e) {
			MMTFException.print(Type.ERROR, "Error creating type MID", e);
		}
	}

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
