/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;

/**
 * The factory for creating "heavy" types, i.e. types created from extensions.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelHeavyTypeFactory extends MultiModelTypeFactory {

	/**
	 * Gets the supertype of a new type from the repository.
	 * 
	 * @param newType
	 *            The new type for which the supertype has to be got.
	 * @param newTypeUri
	 *            The uri of the new type.
	 * @param typeUri
	 *            The uri of the supertype of the new type, null if the root uri
	 *            should be used instead.
	 * @return The supertype of the new type, null if the new type is the root
	 *         type.
	 */
	private static <T extends ExtendibleElement> T getSupertype(T newType, String newTypeUri, String typeUri) {

		T type = null;
		String rootUri = MultiModelTypeRegistry.getRootTypeUri(newType);
		if (typeUri == null && !newTypeUri.equals(rootUri)) {
			typeUri = rootUri;
		}
		if (typeUri != null) {
			type = MultiModelTypeRegistry.getType(typeUri);
		}

		return type;
	}

	/**
	 * Adds a "heavy" type to the repository.
	 * 
	 * @param newType
	 *            The new type to be added.
	 * @param type
	 *            The supertype of the new type.
	 * @param newTypeUri
	 *            The uri of the new type.
	 * @param newTypeName
	 *            The name of the new type.
	 * @throws MMTFException
	 *             If the uri of the new type is already registered in the
	 *             repository.
	 */
	private static void addHeavyType(ExtendibleElement newType, ExtendibleElement type, String newTypeUri, String newTypeName) throws MMTFException {

		addType(newType, type, newTypeUri, newTypeName, MMTF.repository);
		newType.setDynamic(false);
	}

	/**
	 * Adds a "heavy" model type to the repository.
	 * 
	 * @param newModelType
	 *            The new model type to be added.
	 * @param newModelTypeUri
	 *            The uri of the new model type.
	 * @param modelTypeUri
	 *            The uri of the supertype of the new model type, null if the
	 *            root model type should be used as supertype instead.
	 * @param newModelTypeName
	 *            The name of the new model type.
	 * @param newModelTypeAbstract
	 *            True if the new model type is abstract, false otherwise.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model type, null if no constraint is associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model type, null if no constraint is associated.
	 * @throws MMTFException
	 *             If the package of the new model type is not registered
	 *             through a org.eclipse.emf.ecore.generated_package extension,
	 *             or if the uri of the new model type is already registered in
	 *             the repository.
	 */
	private static void addHeavyModelType(Model newModelType, String newModelTypeUri, String modelTypeUri, String newModelTypeName, boolean newModelTypeAbstract, String constraintLanguage, String constraintImplementation) throws MMTFException {

		EPackage modelPackage = EPackage.Registry.INSTANCE.getEPackage(newModelTypeUri);
		if (modelPackage == null) {
			throw new MMTFException("EPackage for URI " + newModelTypeUri + " is not registered");
		}
		Model modelType = getSupertype(newModelType, newModelTypeUri, modelTypeUri);
		addHeavyType(newModelType, modelType, newModelTypeUri, newModelTypeName);
		addModelType(newModelType, newModelTypeAbstract, constraintLanguage, constraintImplementation, MMTF.repository);
		newModelType.setOrigin(ModelOrigin.IMPORTED);

		String modelPackageName = modelPackage.getName();
		newModelType.setFileExtension(modelPackageName);
		// possibly register file extension to load resources
		Map<String, Object> resourceMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if (!resourceMap.containsKey(modelPackageName)) {
			resourceMap.put(modelPackageName, new XMIResourceFactoryImpl());
		}
	}

	/**
	 * Creates and adds a "heavy" model type to the repository.
	 * 
	 * @param newModelTypeUri
	 *            The uri of the new model type.
	 * @param modelTypeUri
	 *            The uri of the supertype of the new model type, null if the
	 *            root model type should be used as supertype.
	 * @param newModelTypeName
	 *            The name of the new model type.
	 * @param newModelTypeAbstract
	 *            True if the new model type is abstract, false otherwise.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model type, null if no constraint is associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model type, null if no constraint is associated.
	 * @return The created model type.
	 * @throws MMTFException
	 *             If the package of the new model type is not registered
	 *             through a org.eclipse.emf.ecore.generated_package extension,
	 *             or if the uri of the new model type is already registered in
	 *             the repository.
	 */
	public static Model createHeavyModelType(String newModelTypeUri, String modelTypeUri, String newModelTypeName, boolean newModelTypeAbstract, String constraintLanguage, String constraintImplementation) throws MMTFException {

		Model newModelType = MidFactory.eINSTANCE.createModel();
		addHeavyModelType(newModelType, newModelTypeUri, modelTypeUri, newModelTypeName, newModelTypeAbstract, constraintLanguage, constraintImplementation);

		return newModelType;
	}

	/**
	 * Creates and adds a "heavy" model element type to a model type.
	 * 
	 * @param newModelElemTypeUri
	 *            The uri of the new model element type.
	 * @param modelElemTypeUri
	 *            The uri of the supertype of the new model element type, null
	 *            if the root model element type should be used as supertype.
	 * @param newModelElemTypeName
	 *            The name of the new model element type.
	 * @param category
	 *            The category of the new model element type.
	 * @param classLiteral
	 *            The class name of the new model element type.
	 * @param modelType
	 *            The model type that will contain the new model element type.
	 * @return The created model element type.
	 * @throws MMTFException
	 *             if the uri of the new model element type is already
	 *             registered in the repository.
	 */
	public static ModelElement createHeavyModelElementType(String newModelElemTypeUri, String modelElemTypeUri, String newModelElemTypeName, ModelElementCategory category, String classLiteral, Model modelType) throws MMTFException {

		ModelElement newModelElemType = MidFactory.eINSTANCE.createModelElement();
		newModelElemType.setCategory(category); // needed to get the right root uri
		ModelElement modelElemType = getSupertype(newModelElemType, newModelElemTypeUri, modelElemTypeUri);
		addHeavyType(newModelElemType, modelElemType, newModelElemTypeUri, newModelElemTypeName);
		addModelElementType(newModelElemType, category, classLiteral, modelType);

		return newModelElemType;
	}

	/**
	 * Creates and adds a "heavy" model relationship type to the repository.
	 * 
	 * @param newModelRelTypeUri
	 *            The uri of the new model relationship type.
	 * @param modelRelTypeUri
	 *            The uri of the supertype of the new model relationship type,
	 *            null if the root model relationship type should be used as
	 *            supertype.
	 * @param newModelRelTypeName
	 *            The name of the new model relationship type.
	 * @param newModelRelTypeAbstract
	 *            True if the new model relationship type is abstract, false
	 *            otherwise.
	 * @param newModelRelTypeClass
	 *            The class of the new model relationship type.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model relationship type, null if no constraint is
	 *            associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model relationship type, null if no constraint is
	 *            associated.
	 * @return The created model relationship type.
	 * @throws MMTFException
	 *             If the package of the new model relationship type is not
	 *             registered through a org.eclipse.emf.ecore.generated_package
	 *             extension, or if the uri of the new model relationship type
	 *             is already registered in the repository.
	 */
	public static ModelRel createHeavyModelRelType(String newModelRelTypeUri, String modelRelTypeUri, String newModelRelTypeName, boolean newModelRelTypeAbstract, EClass newModelRelTypeClass, String constraintLanguage, String constraintImplementation) throws MMTFException {

		ModelRel newModelRelType = (ModelRel) RelationshipFactory.eINSTANCE.create(newModelRelTypeClass);
		if (MMTF.ROOT_MODEL_URI.equals(modelRelTypeUri)) { // root ModelRel's supertype
			addHeavyModelType(newModelRelType, newModelRelTypeUri, modelRelTypeUri, newModelRelTypeName, newModelRelTypeAbstract, constraintLanguage, constraintImplementation);
		}
		else {
			ModelRel modelRelType = getSupertype(newModelRelType, newModelRelTypeUri, modelRelTypeUri);
			addHeavyModelType(newModelRelType, newModelRelTypeUri, modelRelTypeUri, newModelRelTypeName, newModelRelTypeAbstract, constraintLanguage, constraintImplementation);
			addModelRelType(newModelRelType, modelRelType);
		}

		return newModelRelType;
	}

	/**
	 * Creates and adds a "heavy" model type endpoint and a reference to it to a
	 * model relationship type.
	 * 
	 * @param newModelTypeEndpointUri
	 *            The uri of the new model type endpoint.
	 * @param modelTypeEndpointUri
	 *            The uri of the supertype of the new model type endpoint, null
	 *            if the root model type endpoint should be used as supertype.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param modelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the new model type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model type endpoint is already
	 *             registered in the repository.
	 */
	public static ModelEndpointReference createHeavyModelTypeEndpointAndModelTypeEndpointReference(String newModelTypeEndpointUri, String modelTypeEndpointUri, String newModelTypeEndpointName, Model newModelType, ModelRel modelRelType) throws MMTFException {

		ModelEndpoint newModelTypeEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		ModelEndpoint modelTypeEndpoint = getSupertype(newModelTypeEndpoint, newModelTypeEndpointUri, modelTypeEndpointUri);
		addHeavyType(newModelTypeEndpoint, modelTypeEndpoint, newModelTypeEndpointUri, newModelTypeEndpointName);
		addModelTypeEndpoint(newModelTypeEndpoint, newModelType, false, modelRelType);
		//TODO MMTF: review when functions to detect overriding endpoints are ready
		ModelEndpointReference modelTypeEndpointRef = null;
		ModelEndpointReference newModelTypeEndpointRef = createModelTypeEndpointReference(newModelTypeEndpoint, modelTypeEndpointRef, true, false, modelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * Creates and adds a "heavy" link type and a reference to it to a model
	 * relationship type.
	 * 
	 * @param newLinkTypeUri
	 *            The uri of the new link type.
	 * @param linkTypeUri
	 *            The uri of the supertype of the new link type, null if the
	 *            root link type should be used as supertype.
	 * @param newLinkTypeName
	 *            The name of the new link type.
	 * @param newLinkTypeClass
	 *            The class of the new link type.
	 * @param newLinkTypeRefClass
	 *            The class of the new reference to the new link type.
	 * @param modelRelType
	 *            The model relationship type that will contain the new link
	 *            type.
	 * @return The created reference to the new link type.
	 * @throws MMTFException
	 *             If the uri of the new link type is already registered in the
	 *             repository.
	 */
	public static LinkReference createHeavyLinkTypeAndLinkTypeReference(String newLinkTypeUri, String linkTypeUri, String newLinkTypeName, EClass newLinkTypeClass, EClass newLinkTypeRefClass, ModelRel modelRelType) throws MMTFException {

		Link newLinkType = (Link) RelationshipFactory.eINSTANCE.create(newLinkTypeClass);
		Link linkType = getSupertype(newLinkType, newLinkTypeUri, linkTypeUri);
		addHeavyType(newLinkType, linkType, newLinkTypeUri, newLinkTypeName);
		addLinkType(newLinkType, linkType, modelRelType);
		LinkReference linkTypeRef = MultiModelTypeHierarchy.getReference(linkTypeUri, modelRelType.getLinkRefs());
		LinkReference newLinkTypeRef = createLinkTypeReference(newLinkType, linkTypeRef, newLinkTypeRefClass, true, modelRelType);

		return newLinkTypeRef;
	}

	/**
	 * Creates and adds a "heavy" model element type endpoint and a reference to
	 * it to a link type and its reference.
	 * 
	 * @param newModelElemTypeEndpointUri
	 *            The uri of the new model element type endpoint.
	 * @param modelElemTypeEndpointUri
	 *            The uri of the supertype of the new model element type
	 *            endpoint, null if the root model element type endpoint should
	 *            be used as supertype.
	 * @param newModelElemTypeEndpointName
	 *            The name of the new model element type endpoint.
	 * @param newModelElemTypeRef
	 *            The new reference to the new model element type that is the
	 *            target of the new model element type endpoint.
	 * @param linkTypeRef
	 *            The reference to the link type that will contain the new model
	 *            element type endpoint.
	 * @return The created reference to the new model element type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model element type endpoint is already
	 *             registered in the repository.
	 */
	public static ModelElementEndpointReference createHeavyModelElementTypeEndpointAndModelElementTypeEndpointReference(String newModelElemTypeEndpointUri, String modelElemTypeEndpointUri, String newModelElemTypeEndpointName, ModelElementReference newModelElemTypeRef, LinkReference linkTypeRef) throws MMTFException {

		Link linkType = linkTypeRef.getObject();
		ModelElementEndpoint newModelElemTypeEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		newModelElemTypeEndpoint.setTarget(newModelElemTypeRef.getObject()); // needed to get the right root uri
		ModelElementEndpoint modelElemTypeEndpoint = getSupertype(newModelElemTypeEndpoint, newModelElemTypeEndpointUri, modelElemTypeEndpointUri);
		addHeavyType(newModelElemTypeEndpoint, modelElemTypeEndpoint, newModelElemTypeEndpointUri, newModelElemTypeEndpointName);
		addModelElementTypeEndpoint(newModelElemTypeEndpoint, newModelElemTypeRef.getObject(), false, linkType);
		//TODO MMTF: review when functions to detect overriding endpoints are ready
		ModelElementEndpointReference modelTypeEndpointRef = null;
		ModelElementEndpointReference newModelElemTypeEndpointRef = createModelElementTypeEndpointReference(newModelElemTypeEndpoint, modelTypeEndpointRef, newModelElemTypeRef, true, false, linkTypeRef);
		addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, linkType);
		// copy from supertype
		Link linkTypeSuper = linkType.getSupertype();
		if (linkTypeSuper != null && !MultiModelConstraintChecker.isRootType(linkTypeSuper)) {
			for (ModelElementEndpointReference modelElemTypeEndpointRefSuper : linkTypeSuper.getModelElemEndpointRefs()) {
				addModelElementTypeEndpointReference(modelElemTypeEndpointRefSuper, linkType);
			}
		}

		return newModelElemTypeEndpointRef;
	}

	/**
	 * Creates and adds a "heavy" editor type to the repository.
	 * 
	 * @param newEditorTypeUri
	 *            The uri of the new editor type.
	 * @param editorTypeUri
	 *            The uri of the supertype of the new editor type, null if the
	 *            root editor type should be used as supertype.
	 * @param newEditorTypeName
	 *            The name of the new editor type.
	 * @param modelTypeUri
	 *            The uri of the model type handled by the new editor type.
	 * @param editorId
	 *            The id of the corresponding Eclipse editor.
	 * @param wizardId
	 *            The wizard id of the corresponding Eclipse editor.
	 * @param wizardDialogClassName
	 *            The fully qualified name of a Java class that handles the
	 *            creation of the model type through the new editor type.
	 * @param newEditorTypeClass
	 *            The class of the new editor type.
	 * @return The created editor type.
	 * @throws MMTFException
	 *             If the uri of the new editor type is already registered in
	 *             the repository.
	 */
	public static Editor createHeavyEditorType(String newEditorTypeUri, String editorTypeUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName, EClass newEditorTypeClass) throws MMTFException {

		Editor newEditorType = (Editor) EditorFactory.eINSTANCE.create(newEditorTypeClass);
		Editor editorType = getSupertype(newEditorType, newEditorTypeUri, editorTypeUri);
		addHeavyType(newEditorType, editorType, newEditorTypeUri, newEditorTypeName);
		addEditorType(newEditorType, modelTypeUri, editorId, wizardId, wizardDialogClassName, MMTF.repository);

		//TODO MMTF: this can be optimized to run once instead of for each editor, if needed
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry != null) {
			IConfigurationElement[] config = registry.getConfigurationElementsFor(MMTF.ECLIPSE_EDITORS_EXT_POINT);
			for (IConfigurationElement elem : config) {
				if (elem.getAttribute(MMTF.ECLIPSE_EDITORS_ATTR_ID).equals(editorId)) {
					String fileExtensions = elem.getAttribute(MMTF.ECLIPSE_EDITORS_ATTR_EXTENSIONS);
					if (fileExtensions != null) {
						for (String fileExtension : fileExtensions.split(",")) {
							newEditorType.getFileExtensions().add(fileExtension);
						}
					}
					break;
				}
			}
		}

		return newEditorType;
	}

	public static void createHeavyModelTypeEditor(Editor editorType, String modelTypeUri) {

		Model modelType = MultiModelTypeRegistry.getType(modelTypeUri);
		if (modelType != null) {
			addModelTypeEditor(editorType, modelType);
			editorType.getFileExtensions().add(modelType.getFileExtension());
		}
	}

	public static void createHeavyModelTypeEditors(Model modelType) {

		for (Editor editorType : MultiModelTypeRegistry.getEditorTypes()) {
			if (editorType.getModelUri().equals(modelType.getUri())) {
				addModelTypeEditor(editorType, modelType);
				editorType.getFileExtensions().add(modelType.getFileExtension());
			}
		}
	}

	/**
	 * Creates and adds a "heavy" operator type to the repository.
	 * 
	 * @param newOperatorTypeUri
	 *            The uri of the new operator type.
	 * @param operatorTypeUri
	 *            The uri of the supertype of the new operator type, null if the
	 *            root operator type should be used as supertype.
	 * @param newOperatorTypeName
	 *            The name of the new operator type.
	 * @param executable
	 *            The implementation of the new operator type.
	 * @param newOperatorTypeClass
	 *            The class of the new operator type.
	 * @return The created operator type.
	 * @throws MMTFException
	 *             If the uri of the new operator type is already registered in
	 *             the repository.
	 */
	public static Operator createHeavyOperatorType(String newOperatorTypeUri, String operatorTypeUri, String newOperatorTypeName, OperatorExecutable executable, EClass newOperatorTypeClass) throws MMTFException {

		Operator newOperatorType = (Operator) OperatorFactory.eINSTANCE.create(newOperatorTypeClass);
		Operator operatorType = getSupertype(newOperatorType, newOperatorTypeUri, operatorTypeUri);
		addHeavyType(newOperatorType, operatorType, newOperatorTypeUri, newOperatorTypeName);
		addOperatorType(newOperatorType, executable, MMTF.repository);

		return newOperatorType;
	}

	/**
	 * Creates and adds a "heavy" parameter type (i.e. a formal parameter) to an
	 * operator type.
	 * 
	 * @param newParamTypeName
	 *            The name of the new parameter type.
	 * @param modelTypeUri
	 *            The uri of the model type that is the target of the new
	 *            parameter type.
	 * @param isVararg
	 *            True if the new parameter type represents a variable number of
	 *            parameter types of the same kind, false otherwise.
	 * @param paramTypes
	 *            The list of parameter types that will contain the new
	 *            parameter type.
	 * @param operatorType
	 *            The operator type that will contain the new parameter type.
	 * @throws MMTFException
	 *             If the target model type is not registered in the repository.
	 */
	public static void createHeavyOperatorTypeParameter(String newParamTypeName, String modelTypeUri, boolean isVararg, EList<Parameter> paramTypes, Operator operatorType) throws MMTFException {

		Parameter newParamType = OperatorFactory.eINSTANCE.createParameter();
		Model modelType = MultiModelTypeRegistry.getType(modelTypeUri);
		if (modelType == null) {
			throw new MMTFException("Model type " + modelTypeUri + " is not registered");
		}
		addOperatorTypeParameter(newParamType, newParamTypeName, modelType, isVararg, paramTypes, operatorType);
	}

}
