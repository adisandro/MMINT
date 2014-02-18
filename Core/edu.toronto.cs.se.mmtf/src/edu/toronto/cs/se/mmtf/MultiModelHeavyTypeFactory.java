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

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.toronto.cs.se.mmtf.mid.EMFInfo;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
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
import edu.toronto.cs.se.mmtf.repository.ExtensionType;

/**
 * The factory to create/modify/remove "heavy" types, i.e. types from
 * extensions.
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
	protected static <T extends ExtendibleElement> T getSupertype(T newType, String newTypeUri, String typeUri) {

		T type = null;
		String rootUri = MultiModelTypeHierarchy.getRootTypeUri(newType);
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
	protected static void addHeavyType(ExtendibleElement newType, ExtendibleElement type, String newTypeUri, String newTypeName) throws MMTFException {

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
	 * @param isAbstract
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
	protected static void addHeavyModelType(Model newModelType, String newModelTypeUri, String modelTypeUri, String newModelTypeName, boolean isAbstract, String constraintLanguage, String constraintImplementation) throws MMTFException {

		EPackage modelPackage = EPackage.Registry.INSTANCE.getEPackage(newModelTypeUri);
		if (modelPackage == null) {
			throw new MMTFException("EPackage for URI " + newModelTypeUri + " is not registered");
		}
		Model modelType = getSupertype(newModelType, newModelTypeUri, modelTypeUri);
		addHeavyType(newModelType, modelType, newModelTypeUri, newModelTypeName);
		addModelType(newModelType, isAbstract, constraintLanguage, constraintImplementation, MMTF.repository);
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
	 * Adds a "heavy" model relationship type to the repository.
	 * 
	 * @param newModelRelType
	 *            The new model relationship type to be added.
	 * @param newModelRelTypeUri
	 *            The uri of the new model relationship type.
	 * @param modelRelTypeUri
	 *            The uri of the supertype of the new model relationship type,
	 *            null if the root model relationship type should be used as
	 *            supertype.
	 * @param newModelRelTypeName
	 *            The name of the new model relationship type.
	 * @param isAbstract
	 *            True if the new model relationship type is abstract, false
	 *            otherwise.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model relationship type, null if no constraint is
	 *            associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model relationship type, null if no constraint is
	 *            associated.
	 * @throws MMTFException
	 *             If the package of the new model relationship type is not
	 *             registered through a org.eclipse.emf.ecore.generated_package
	 *             extension, or if the uri of the new model relationship type
	 *             is already registered in the repository.
	 */
	protected void addHeavyModelRelType(ModelRel newModelRelType, String newModelRelTypeUri, String modelRelTypeUri, String newModelRelTypeName, boolean isAbstract, String constraintLanguage, String constraintImplementation) throws MMTFException {

		if (MMTF.ROOT_MODEL_URI.equals(modelRelTypeUri)) { // root ModelRel's supertype
			addHeavyModelType(newModelRelType, newModelRelTypeUri, modelRelTypeUri, newModelRelTypeName, isAbstract, constraintLanguage, constraintImplementation);
		}
		else {
			ModelRel modelRelType = getSupertype(newModelRelType, newModelRelTypeUri, modelRelTypeUri);
			addHeavyModelType(newModelRelType, newModelRelTypeUri, modelRelTypeUri, newModelRelTypeName, isAbstract, constraintLanguage, constraintImplementation);
			addModelRelType(newModelRelType, modelRelType);
		}
	}

	/**
	 * Adds a "heavy" model type endpoint and a reference to it to the
	 * repository.
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
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the new model type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model type endpoint is already
	 *             registered in the repository.
	 */
	protected ModelEndpointReference addHeavyModelTypeEndpointAndModelTypeEndpointReference(ModelEndpoint newModelTypeEndpoint, String newModelTypeEndpointUri, String modelTypeEndpointUri, String newModelTypeEndpointName, Model newModelType, ModelRel containerModelRelType) throws MMTFException {

		ModelEndpoint modelTypeEndpoint = getSupertype(newModelTypeEndpoint, newModelTypeEndpointUri, modelTypeEndpointUri);
		addHeavyType(newModelTypeEndpoint, modelTypeEndpoint, newModelTypeEndpointUri, newModelTypeEndpointName);
		addModelTypeEndpoint(newModelTypeEndpoint, newModelType, false, containerModelRelType);
		ModelEndpointReference modelTypeEndpointRef = (modelTypeEndpoint == null) ? // may be root
			null :
			MultiModelTypeHierarchy.getReference(modelTypeEndpoint.getUri(), containerModelRelType.getModelEndpointRefs());
		ModelEndpointReference newModelTypeEndpointRef = newModelTypeEndpoint.createTypeReference(modelTypeEndpointRef, true, false, containerModelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * Creates and adds a "heavy" model type to the repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new model type.
	 * @param isAbstract
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
	public Model createHeavyModelType(ExtensionType extensionType, boolean isAbstract, String constraintLanguage, String constraintImplementation) throws MMTFException {

		Model newModelType = (extensionType.getNewType() == null) ?
			MidFactory.eINSTANCE.createModel() :
			(Model) extensionType.getNewType();
		addHeavyModelType(newModelType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), isAbstract, constraintLanguage, constraintImplementation);

		return newModelType;
	}

	/**
	 * Creates and adds a "heavy" model element type to the repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new model element type.
	 * @param eInfo
	 *            The EMF info of the new model element type.
	 * @param modelType
	 *            The model type that will contain the new model element type.
	 * @return The created model element type.
	 * @throws MMTFException
	 *             If the uri of the new model element type is already
	 *             registered in the repository.
	 */
	public ModelElement createHeavyModelElementType(ExtensionType extensionType, EMFInfo eInfo, Model modelType) throws MMTFException {

		ModelElement newModelElemType = (extensionType.getNewType() == null) ?
			MidFactory.eINSTANCE.createModelElement() :
			(ModelElement) extensionType.getNewType();
		ModelElement modelElemType = getSupertype(newModelElemType, extensionType.getUri(), extensionType.getSupertypeUri());
		addHeavyType(newModelElemType, modelElemType, extensionType.getUri(), extensionType.getName());
		addModelElementType(newModelElemType, eInfo, modelType);

		return newModelElemType;
	}

	/**
	 * Creates and adds a "heavy" model relationship type to the repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new model relationship type.
	 * @param isAbstract
	 *            True if the new model relationship type is abstract, false
	 *            otherwise.
	 * @param isBinary
	 *            True if the new model relationship type is binary, false
	 *            otherwise.
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
	public ModelRel createHeavyModelRelType(ExtensionType extensionType, boolean isAbstract, boolean isBinary, String constraintLanguage, String constraintImplementation) throws MMTFException {

		ModelRel newModelRelType;
		if (extensionType.getNewType() == null) {
			newModelRelType = (isBinary) ?
				RelationshipFactory.eINSTANCE.createBinaryModelRel() :
				RelationshipFactory.eINSTANCE.createModelRel();
		}
		else {
			newModelRelType = (ModelRel) extensionType.getNewType();
		}
		addHeavyModelRelType(newModelRelType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), isAbstract, constraintLanguage, constraintImplementation);

		return newModelRelType;
	}

	/**
	 * Creates and adds a "heavy" model type endpoint and a reference to it to
	 * the repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new model type endpoint.
	 * @param targetModelType
	 *            The model type that is the target of the new model type
	 *            endpoint.
	 * @param modelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the new model type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model type endpoint is already
	 *             registered in the repository.
	 */
	public ModelEndpointReference createHeavyModelTypeEndpointAndModelTypeEndpointReference(ExtensionType extensionType, Model targetModelType, ModelRel modelRelType) throws MMTFException {

		ModelEndpoint newModelTypeEndpoint = (extensionType.getNewType() == null) ?
			MidFactory.eINSTANCE.createModelEndpoint() :
			(ModelEndpoint) extensionType.getNewType();
		ModelEndpointReference newModelTypeEndpointRef = addHeavyModelTypeEndpointAndModelTypeEndpointReference(newModelTypeEndpoint, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), targetModelType, modelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * Creates and adds a "heavy" link type and a reference to it to the
	 * repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new link type.
	 * @param isBinary
	 *            True if the new link type is binary, false otherwise.
	 * @param modelRelType
	 *            The model relationship type that will contain the new link
	 *            type.
	 * @return The created reference to the new link type.
	 * @throws MMTFException
	 *             If the uri of the new link type is already registered in the
	 *             repository.
	 */
	public LinkReference createHeavyLinkTypeAndLinkTypeReference(ExtensionType extensionType, boolean isBinary, ModelRel modelRelType) throws MMTFException {

		Link newLinkType;
		if (extensionType.getNewType() == null) {
			newLinkType = (isBinary) ?
				RelationshipFactory.eINSTANCE.createBinaryLink() :
				RelationshipFactory.eINSTANCE.createLink();
		}
		else {
			newLinkType = (Link) extensionType.getNewType();
		}
		Link linkType = getSupertype(newLinkType, extensionType.getUri(), extensionType.getSupertypeUri());
		addHeavyType(newLinkType, linkType, extensionType.getUri(), extensionType.getName());
		addLinkType(newLinkType, linkType, modelRelType);
		LinkReference linkTypeRef = MultiModelTypeHierarchy.getReference(extensionType.getSupertypeUri(), modelRelType.getLinkRefs());
		LinkReference newLinkTypeRef = newLinkType.createTypeReference(linkTypeRef, true, modelRelType);

		return newLinkTypeRef;
	}

	/**
	 * Creates and adds a "heavy" model element type endpoint and a reference to
	 * it to the repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new model element type endpoint.
	 * @param newModelElemTypeRef
	 *            The new reference to the new model element type that is the
	 *            target of the new model element type endpoint.
	 * @param containerLinkTypeRef
	 *            The reference to the link type that will contain the new model
	 *            element type endpoint.
	 * @return The created reference to the new model element type endpoint.
	 * @throws MMTFException
	 *             If the uri of the new model element type endpoint is already
	 *             registered in the repository.
	 */
	public ModelElementEndpointReference createHeavyModelElementTypeEndpointAndModelElementTypeEndpointReference(ExtensionType extensionType, ModelElementReference newModelElemTypeRef, LinkReference containerLinkTypeRef) throws MMTFException {

		ModelElementEndpoint newModelElemTypeEndpoint = (extensionType.getNewType() == null) ?
			RelationshipFactory.eINSTANCE.createModelElementEndpoint() :
			(ModelElementEndpoint) extensionType.getNewType();
		Link containerLinkType = containerLinkTypeRef.getObject();
		newModelElemTypeEndpoint.setTarget(newModelElemTypeRef.getObject()); // needed to get the right root uri
		ModelElementEndpoint modelElemTypeEndpoint = getSupertype(newModelElemTypeEndpoint, extensionType.getUri(), extensionType.getSupertypeUri());
		addHeavyType(newModelElemTypeEndpoint, modelElemTypeEndpoint, extensionType.getUri(), extensionType.getName());
		addModelElementTypeEndpoint(newModelElemTypeEndpoint, newModelElemTypeRef.getObject(), false, containerLinkType);
		ModelElementEndpointReference modelElemTypeEndpointRef = null;
		if (modelElemTypeEndpoint != null) { // may be root
			LinkReference newLinkTypeRefSuper = MultiModelTypeHierarchy.getReference(((Link) modelElemTypeEndpoint.eContainer()).getUri(), ((ModelRel) containerLinkTypeRef.eContainer()).getLinkRefs());
			if (newLinkTypeRefSuper != null) {
				modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpoint.getUri(), newLinkTypeRefSuper.getModelElemEndpointRefs());
			}
		}
		ModelElementEndpointReference newModelElemTypeEndpointRef = newModelElemTypeEndpoint.createTypeReference(modelElemTypeEndpointRef, newModelElemTypeRef, true, false, containerLinkTypeRef);
		addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, containerLinkType);
		// copy from supertype
		Link linkTypeSuper = containerLinkType.getSupertype();
		if (linkTypeSuper != null && !MultiModelTypeHierarchy.isRootType(linkTypeSuper)) {
			for (ModelElementEndpointReference modelElemTypeEndpointRefSuper : linkTypeSuper.getModelElemEndpointRefs()) {
				addModelElementTypeEndpointReference(modelElemTypeEndpointRefSuper, containerLinkType);
			}
		}

		return newModelElemTypeEndpointRef;
	}

	/**
	 * Creates and adds a "heavy" editor type to the repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new editor type.
	 * @param modelTypeUri
	 *            The uri of the model type handled by the new editor type.
	 * @param editorId
	 *            The id of the corresponding Eclipse editor.
	 * @param wizardId
	 *            The wizard id of the corresponding Eclipse editor.
	 * @param wizardDialogClassName
	 *            The fully qualified name of a Java class that handles the
	 *            creation of the model type through the new editor type.
	 * @param isDiagram
	 *            True if the new editor type is a diagram, false otherwise.
	 * @return The created editor type.
	 * @throws MMTFException
	 *             If the uri of the new editor type is already registered in
	 *             the repository.
	 */
	public Editor createHeavyEditorType(ExtensionType extensionType, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName, boolean isDiagram) throws MMTFException {

		Editor newEditorType;
		if (extensionType.getNewType() == null) {
			newEditorType = (isDiagram) ?
				EditorFactory.eINSTANCE.createDiagram() :
				EditorFactory.eINSTANCE.createEditor();
		}
		else {
			newEditorType = (Editor) extensionType.getNewType();
		}
		Editor editorType = getSupertype(newEditorType, extensionType.getUri(), extensionType.getSupertypeUri());
		addHeavyType(newEditorType, editorType, extensionType.getUri(), extensionType.getName());
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

	/**
	 * Adds a "heavy" editor type for a model type.
	 * 
	 * @param editorType
	 *            The editor type.
	 * @param modelTypeUri
	 *            The uri of the model type handled by the editor type.
	 */
	public static void addHeavyModelTypeEditor(Editor editorType, String modelTypeUri) {

		Model modelType = MultiModelTypeRegistry.getType(modelTypeUri);
		if (modelType != null) {
			addModelTypeEditor(editorType, modelType);
			editorType.getFileExtensions().add(modelType.getFileExtension());
		}
	}

	/**
	 * Adds all registered "heavy" editor types for a model type.
	 * 
	 * @param modelType
	 *            The model type handled by the editor types.
	 */
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
	 * @param extensionType
	 *            The extension info for the new operator type.
	 * @param executable
	 *            The implementation of the new operator type.
	 * @param newOperatorTypeClass
	 *            The class of the new operator type.
	 * @return The created operator type.
	 * @throws MMTFException
	 *             If the uri of the new operator type is already registered in
	 *             the repository.
	 */
	public Operator createHeavyOperatorType(ExtensionType extensionType, OperatorExecutable executable, EClass newOperatorTypeClass) throws MMTFException {

		Operator newOperatorType = (Operator) OperatorFactory.eINSTANCE.create(newOperatorTypeClass);
		Operator operatorType = getSupertype(newOperatorType, extensionType.getUri(), extensionType.getSupertypeUri());
		addHeavyType(newOperatorType, operatorType, extensionType.getUri(), extensionType.getName());
		addOperatorType(newOperatorType, executable, MMTF.repository);

		return newOperatorType;
	}

	/**
	 * Creates and adds a "heavy" parameter type (i.e. a formal parameter) to
	 * the repository.
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
