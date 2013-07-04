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
 * The factory for "heavy" types, i.e. types created from extensions.
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
			type = MultiModelTypeRegistry.getExtendibleElementType(typeUri);
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

	public static ModelElement createHeavyModelElementType(Model modelType, String newModelElemTypeUri, String modelElemTypeUri, String newModelElemTypeName, ModelElementCategory category, String classLiteral) throws MMTFException {

		ModelElement newModelElemType = MidFactory.eINSTANCE.createModelElement();
		newModelElemType.setCategory(category); // needed to get the right root uri
		ModelElement modelElemType = getSupertype(newModelElemType, newModelElemTypeUri, modelElemTypeUri);
		addHeavyType(newModelElemType, modelElemType, newModelElemTypeUri, newModelElemTypeName);
		addModelElementType(modelType, newModelElemType, category, classLiteral);

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

	public static ModelEndpointReference createHeavyModelTypeEndpointAndModelTypeEndpointReference(ModelRel modelRelType, String newModelTypeEndpointUri, String modelTypeEndpointUri, Model newModelType, String newModelTypeEndpointName) throws MMTFException {

		ModelEndpoint newModelTypeEndpoint = MidFactory.eINSTANCE.createModelEndpoint();
		ModelEndpoint modelTypeEndpoint = getSupertype(newModelTypeEndpoint, newModelTypeEndpointUri, modelTypeEndpointUri);
		addHeavyType(newModelTypeEndpoint, modelTypeEndpoint, newModelTypeEndpointUri, newModelTypeEndpointName);
		addModelTypeEndpoint(modelRelType, newModelTypeEndpoint, newModelType, false);
		//TODO MMTF: review when functions to detect overriding endpoints are ready
		ModelEndpointReference modelTypeEndpointRef = null;
		ModelEndpointReference newModelTypeEndpointRef = createModelTypeEndpointReference(newModelTypeEndpoint, modelTypeEndpointRef, true, false, modelRelType);

		return newModelTypeEndpointRef;
	}

	public static LinkReference createHeavyLinkTypeAndLinkTypeReference(ModelRel modelRelType, String newLinkTypeUri, String linkTypeUri, String newLinkTypeName, EClass newLinkTypeClass, EClass newLinkTypeRefClass) throws MMTFException {

		Link newLinkType = (Link) RelationshipFactory.eINSTANCE.create(newLinkTypeClass);
		Link linkType = getSupertype(newLinkType, newLinkTypeUri, linkTypeUri);
		addHeavyType(newLinkType, linkType, newLinkTypeUri, newLinkTypeName);
		addLinkType(modelRelType, newLinkType, linkType);
		LinkReference linkTypeRef = MultiModelTypeHierarchy.getReference(linkTypeUri, modelRelType.getLinkRefs());
		LinkReference newLinkTypeRef = createLinkTypeReference(modelRelType, linkTypeRef, newLinkType, newLinkTypeRefClass, true);

		return newLinkTypeRef;
	}

	public static ModelElementEndpointReference createHeavyModelElementTypeEndpointAndModelElementTypeEndpointReference(LinkReference linkTypeRef, String newModelElemTypeEndpointUri, String modelElemTypeEndpointUri, ModelElementReference newModelElemTypeRef, String newModelElemTypeEndpointName) throws MMTFException {

		Link linkType = linkTypeRef.getObject();
		ModelElementEndpoint newModelElemTypeEndpoint = RelationshipFactory.eINSTANCE.createModelElementEndpoint();
		newModelElemTypeEndpoint.setTarget(newModelElemTypeRef.getObject()); // needed to get the right root uri
		ModelElementEndpoint modelElemTypeEndpoint = getSupertype(newModelElemTypeEndpoint, newModelElemTypeEndpointUri, modelElemTypeEndpointUri);
		addHeavyType(newModelElemTypeEndpoint, modelElemTypeEndpoint, newModelElemTypeEndpointUri, newModelElemTypeEndpointName);
		addModelElementTypeEndpoint(linkType, newModelElemTypeEndpoint, newModelElemTypeRef.getObject(), false);
		//TODO MMTF: review when functions to detect overriding endpoints are ready
		ModelElementEndpointReference modelTypeEndpointRef = null;
		ModelElementEndpointReference newModelElemTypeEndpointRef = createModelElementTypeEndpointReference(linkTypeRef, modelTypeEndpointRef, newModelElemTypeEndpoint, newModelElemTypeRef, true, false);
		addModelElementTypeEndpointReference(linkType, newModelElemTypeEndpointRef);
		// copy from supertype
		Link linkTypeSuper = linkType.getSupertype();
		if (linkTypeSuper != null && !MultiModelConstraintChecker.isRootType(linkTypeSuper)) {
			for (ModelElementEndpointReference modelElemTypeEndpointRefSuper : linkTypeSuper.getModelElemEndpointRefs()) {
				addModelElementTypeEndpointReference(linkType, modelElemTypeEndpointRefSuper);
			}
		}

		return newModelElemTypeEndpointRef;
	}

	public static Editor createHeavyEditorType(String newEditorTypeUri, String editorTypeUri, String newEditorTypeName, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName, EClass newEditorTypeClass) throws MMTFException {

		Editor newEditorType = (Editor) EditorFactory.eINSTANCE.create(newEditorTypeClass);
		Editor editorType = getSupertype(newEditorType, newEditorTypeUri, editorTypeUri);
		addHeavyType(newEditorType, editorType, newEditorTypeUri, newEditorTypeName);
		addEditorType(newEditorType, modelTypeUri, editorId, wizardId, wizardDialogClassName, MMTF.repository);

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

		Model modelType = MultiModelTypeRegistry.getExtendibleElementType(modelTypeUri);
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

	public static Operator createHeavyOperatorType(String newOperatorTypeUri, String operatorTypeUri, String newOperatorTypeName, OperatorExecutable executable, EClass newOperatorTypeClass) throws MMTFException {

		Operator newOperatorType = (Operator) OperatorFactory.eINSTANCE.create(newOperatorTypeClass);
		Operator operatorType = getSupertype(newOperatorType, newOperatorTypeUri, operatorTypeUri);
		addHeavyType(newOperatorType, operatorType, newOperatorTypeUri, newOperatorTypeName);
		addOperatorType(newOperatorType, executable, MMTF.repository);

		return newOperatorType;
	}

	public static void createHeavyOperatorTypeParameter(Operator operatorType, String modelTypeUri, EList<Parameter> paramTypes, String newParamTypeName, boolean isVararg) throws MMTFException {

		Parameter newParamType = OperatorFactory.eINSTANCE.createParameter();
		Model modelType = MultiModelTypeRegistry.getExtendibleElementType(modelTypeUri);
		if (modelType == null) {
			throw new MMTFException("Model type " + modelTypeUri + " is not registered");
		}
		addOperatorTypeParameter(newParamType, operatorType, paramTypes, modelType, newParamTypeName, isVararg);
	}

}
