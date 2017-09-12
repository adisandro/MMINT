/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.extensions.ExtensionPointType;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipFactory;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.MIDTypeFactory;

/**
 * The factory to create/modify/remove "heavy" types, i.e. types from
 * extensions.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MIDHeavyTypeFactory extends MIDTypeFactory {

	/**
	 * Gets the supertype of a new type from the repository.
	 * 
	 * @param newType
	 *            The new type for which the supertype has to be got.
	 * @param newTypeUri
	 *            The uri of the new type.
	 * @param typeUri
	 *            The uri of the supertype of the new type, null if the root uri should be used instead.
	 * @return The supertype of the new type, null if the new type is the root type.
	 */
	protected static @Nullable <T extends ExtendibleElement> T getSupertype(@NonNull T newType, @NonNull String newTypeUri, @Nullable String typeUri) {

		T type = null;
		String rootUri = MIDTypeHierarchy.getRootTypeUri(newType);
		if (typeUri == null && !newTypeUri.equals(rootUri)) {
			typeUri = rootUri;
		}
		if (typeUri != null) {
			type = MIDTypeRegistry.getType(typeUri);
		}

		return type;
	}

	/**
	 * Gets the supertype of a new type from the repository, when there is no root type.
	 * 
	 * @param newType
	 *            The new type for which the supertype has to be got.
	 * @param newTypeUri
	 *            The uri of the new type.
	 * @param typeUri
	 *            The uri of the supertype of the new type, null if the new type has no supertype.
	 * @return The supertype of the new type, null if the new type has no supertype.
	 */
	protected static @Nullable <T extends ExtendibleElement> T getSupertypeWithoutRoot(@NonNull T newType, @NonNull String newTypeUri, @Nullable String typeUri) {

		return (typeUri == null) ?
			null :
			getSupertype(newType, newTypeUri, typeUri);
	}

	/**
	 * Adds a "heavy" type to the repository.
	 * 
	 * @param newType
	 *            The new type to be added.
	 * @param type
	 *            The supertype of the new type, null if the new type has no supertype.
	 * @param newTypeUri
	 *            The uri of the new type.
	 * @param newTypeName
	 *            The name of the new type.
	 * @throws MMINTException
	 *             If the uri of the new type is already registered in the
	 *             repository.
	 */
	protected static void addHeavyType(@NonNull ExtendibleElement newType, @Nullable ExtendibleElement type, @NonNull String newTypeUri, @NonNull String newTypeName) throws MMINTException {

		addType(newType, type, newTypeUri, newTypeName, MMINT.cachedTypeMID);
		newType.setDynamic(false);
	}

	/**
	 * Adds a "heavy" generic type to the repository.
	 * 
	 * @param newType
	 *            The new type to be added.
	 * @param type
	 *            The supertype of the new type, null if the new type has no supertype.
	 * @param newTypeUri
	 *            The uri of the new type.
	 * @param newTypeName
	 *            The name of the new type.
	 * @param isAbstract
	 *            True if the new type is abstract, false otherwise.
	 * @throws MMINTException
	 *             If the uri of the new type is already registered in the repository.
	 */
	protected static void addHeavyGenericType(@NonNull GenericElement newType, @Nullable GenericElement type, @NonNull String newTypeUri, @NonNull String newTypeName, boolean isAbstract) throws MMINTException {

		newType.setAbstract(isAbstract);
		addType(newType, type, newTypeUri, newTypeName, MMINT.cachedTypeMID);
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
	 * @throws MMINTException
	 *             If the package of the new model type is not registered
	 *             through a org.eclipse.emf.ecore.generated_package extension,
	 *             or if the uri of the new model type is already registered in
	 *             the repository.
	 */
	protected void addHeavyModelType(Model newModelType, String newModelTypeUri, String modelTypeUri, String newModelTypeName, boolean isAbstract) throws MMINTException {

		EPackage modelPackage = EPackage.Registry.INSTANCE.getEPackage(newModelTypeUri);
		if (modelPackage == null) {
			throw new MMINTException("EPackage for URI " + newModelTypeUri + " is not registered");
		}
		Model modelType = getSupertype(newModelType, newModelTypeUri, modelTypeUri);
		addHeavyGenericType(newModelType, modelType, newModelTypeUri, newModelTypeName, isAbstract);
		MIDTypeFactory.addModelType(newModelType, MMINT.cachedTypeMID);
		newModelType.setOrigin(ModelOrigin.IMPORTED);

		String modelPackageName = (modelType == null) ?
			MIDTypeFactory.ECORE_REFLECTIVE_FILE_EXTENSION : // root model type
			modelPackage.getName();
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
	 * @throws MMINTException
	 *             If the package of the new model relationship type is not
	 *             registered through a org.eclipse.emf.ecore.generated_package
	 *             extension, or if the uri of the new model relationship type
	 *             is already registered in the repository.
	 */
	protected void addHeavyModelRelType(ModelRel newModelRelType, String newModelRelTypeUri, String modelRelTypeUri, String newModelRelTypeName, boolean isAbstract) throws MMINTException {

		if (MMINT.ROOT_MODEL_URI.equals(modelRelTypeUri)) { // root ModelRel's supertype
			addHeavyModelType(newModelRelType, newModelRelTypeUri, modelRelTypeUri, newModelRelTypeName, isAbstract);
		}
		else {
			ModelRel modelRelType = getSupertype(newModelRelType, newModelRelTypeUri, modelRelTypeUri);
			addHeavyModelType(newModelRelType, newModelRelTypeUri, modelRelTypeUri, newModelRelTypeName, isAbstract);
			addModelRelType(newModelRelType, modelRelType);
		}
	}

	/**
	 * Adds a "heavy" model type endpoint (for an operator type) to the Type MID.
	 * 
	 * @param newModelTypeEndpoint
	 *            The new model type endpoint to be added.
	 * @param newModelTypeEndpointUri
	 *            The uri of the new model type endpoint.
	 * @param modelTypeEndpointUri
	 *            The uri of the supertype of the new model type endpoint, null if the new model type endpoint has no
	 *            supertype.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param targetModelType
	 *            The new model type that is the target of the new model type endpoint.
	 * @param containerOperatorType
	 *            The operator type that will contain the new model type endpoint.
	 * @param containerFeatureName
	 *            The name of the feature in the operator type that will contain the new model type endpoint.
	 * @throws MMINTException
	 *             If the uri of the new model type endpoint is already registered in the Type MID.
	 */
	protected void addHeavyModelTypeEndpoint(@NonNull ModelEndpoint newModelTypeEndpoint, @NonNull String newModelTypeEndpointUri, @Nullable String modelTypeEndpointUri, @NonNull String newModelTypeEndpointName, @NonNull Model targetModelType, @NonNull Operator containerOperatorType, @NonNull String containerFeatureName) throws MMINTException {

		ModelEndpoint modelTypeEndpoint = getSupertypeWithoutRoot(newModelTypeEndpoint, newModelTypeEndpointUri, modelTypeEndpointUri);
		addHeavyType(newModelTypeEndpoint, modelTypeEndpoint, newModelTypeEndpointUri, newModelTypeEndpointName);
		addModelTypeEndpoint(newModelTypeEndpoint, targetModelType, containerOperatorType, containerFeatureName);
	}

	/**
	 * Adds a "heavy" generic type endpoint to the Type MID.
	 * 
	 * @param newGenericTypeEndpoint
	 *            The new generic type endpoint to be added.
	 * @param newGenericTypeEndpointUri
	 *            The uri of the new generic type endpoint.
	 * @param genericTypeEndpointUri
	 *            The uri of the supertype of the new generic type endpoint, null if the new generic type endpoint has
	 *            no supertype.
	 * @param newGenericTypeEndpointName
	 *            The name of the new generic type endpoint.
	 * @param targetGenericType
	 *            The new generic type that is the target of the new generic type endpoint.
	 * @param containerOperatorType
	 *            The operator type that will contain the new generic type endpoint.
	 * @throws MMINTException
	 *             If the uri of the new generic type endpoint is already registered in the Type MID.
	 */
	protected void addHeavyGenericTypeEndpoint(@NonNull GenericEndpoint newGenericTypeEndpoint, @NonNull String newGenericTypeEndpointUri, @Nullable String genericTypeEndpointUri, @NonNull String newGenericTypeEndpointName, @NonNull GenericElement targetGenericType, @NonNull Operator containerOperatorType) throws MMINTException {

		GenericEndpoint modelTypeEndpoint = getSupertypeWithoutRoot(newGenericTypeEndpoint, newGenericTypeEndpointUri, genericTypeEndpointUri);
		addHeavyType(newGenericTypeEndpoint, modelTypeEndpoint, newGenericTypeEndpointUri, newGenericTypeEndpointName);
		addTypeEndpoint(newGenericTypeEndpoint, targetGenericType);
		containerOperatorType.getGenerics().add(newGenericTypeEndpoint);
	}

	/**
	 * Adds a "heavy" model type endpoint and a reference to it to the
	 * repository.
	 * 
	 * @param newModelTypeEndpoint
	 *            The new model type endpoint to be added.
	 * @param newModelTypeEndpointUri
	 *            The uri of the new model type endpoint.
	 * @param modelTypeEndpointUri
	 *            The uri of the supertype of the new model type endpoint, null
	 *            if the root model type endpoint should be used as supertype.
	 * @param newModelTypeEndpointName
	 *            The name of the new model type endpoint.
	 * @param targetModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param isBinarySrc
	 *            (Only for a binary model relationship type container) True if
	 *            the target model type is the source in the binary model
	 *            relationship type container, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 * @return The created reference to the new model type endpoint.
	 * @throws MMINTException
	 *             If the uri of the new model type endpoint is already
	 *             registered in the repository.
	 */
	protected @NonNull ModelEndpointReference addHeavyModelTypeEndpointAndModelTypeEndpointReference(@NonNull ModelEndpoint newModelTypeEndpoint, @NonNull String newModelTypeEndpointUri, @Nullable String modelTypeEndpointUri, @NonNull String newModelTypeEndpointName, @NonNull Model targetModelType, boolean isBinarySrc, @NonNull ModelRel containerModelRelType) throws MMINTException {

		ModelEndpoint modelTypeEndpoint = getSupertype(newModelTypeEndpoint, newModelTypeEndpointUri, modelTypeEndpointUri);
		addHeavyType(newModelTypeEndpoint, modelTypeEndpoint, newModelTypeEndpointUri, newModelTypeEndpointName);
		addModelTypeEndpoint(newModelTypeEndpoint, targetModelType, isBinarySrc, containerModelRelType);
		ModelEndpointReference newModelTypeEndpointRef = newModelTypeEndpoint.createTypeReference(true, containerModelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * Adds a "heavy" mapping type and a reference to it to the repository.
	 * 
	 * @param newMappingType
	 *            The new mapping type to be added.
	 * @param newMappingTypeUri
	 *            The uri of the new mapping type.
	 * @param mappingTypeUri
	 *            The uri of the supertype of the new mapping type, null if the
	 *            root mapping type should be used as supertype.
	 * @param newMappingTypeName
	 *            The name of the new mapping type.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new mapping
	 *            type.
	 * @return The created reference to the new mapping type.
	 * @throws MMINTException
	 *             If the uri of the new mapping type is already registered in
	 *             the repository.
	 */
	protected @NonNull MappingReference addHeavyMappingTypeAndMappingTypeReference(@NonNull Mapping newMappingType, @NonNull String newMappingTypeUri, @Nullable String mappingTypeUri, @NonNull String newMappingTypeName, @NonNull ModelRel containerModelRelType) throws MMINTException {

		Mapping mappingType = getSupertype(newMappingType, newMappingTypeUri, mappingTypeUri);
		addHeavyType(newMappingType, mappingType, newMappingTypeUri, newMappingTypeName);
		addMappingType(newMappingType, mappingType, containerModelRelType);
		MappingReference mappingTypeRef = MIDRegistry.getReference(mappingTypeUri, containerModelRelType.getMappingRefs());
		MappingReference newMappingTypeRef = newMappingType.createTypeReference(mappingTypeRef, true, containerModelRelType);

		return newMappingTypeRef;
	}

	/**
	 * Creates and adds a "heavy" constraint to a type.
	 * @param constraintLanguage
	 *            The language of the constraint.
	 * @param constraintImplementation
	 *            The implementation of the constraint.
	 * @param constrainedType
	 *            The new type to be constrained.
	 */
	public ExtendibleElementConstraint createHeavyTypeConstraint(@NonNull String constraintLanguage, @NonNull String constraintImplementation, @NonNull ExtendibleElement constrainedType) {

		ExtendibleElementConstraint newTypeConstraint = MIDFactory.eINSTANCE.createExtendibleElementConstraint();
		MIDTypeFactory.addTypeConstraint(newTypeConstraint, constraintLanguage, constraintImplementation, constrainedType);

		return newTypeConstraint;
	}

	/**
	 * Creates and adds a "heavy" model type to the repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new model type.
	 * @return The created model type.
	 * @throws MMINTException
	 *             If the package of the new model type is not registered
	 *             through a org.eclipse.emf.ecore.generated_package extension,
	 *             or if the uri of the new model type is already registered in
	 *             the repository.
	 */
	public Model createHeavyModelType(@NonNull ExtensionPointType extensionType) throws MMINTException {

		Model newModelType = (extensionType.getNewType() == null) ?
			MIDFactory.eINSTANCE.createModel() :
			(Model) extensionType.getNewType();
		this.addHeavyModelType(newModelType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), extensionType.isAbstract());

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
	 * @throws MMINTException
	 *             If the uri of the new model element type is already
	 *             registered in the repository.
	 */
	public ModelElement createHeavyModelElementType(ExtensionPointType extensionType, EMFInfo eInfo, Model modelType) throws MMINTException {

		ModelElement newModelElemType = (extensionType.getNewType() == null) ?
			MIDFactory.eINSTANCE.createModelElement() :
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
	 * @param isBinary
	 *            True if the new model relationship type is binary, false
	 *            otherwise.
	 * @return The created model relationship type.
	 * @throws MMINTException
	 *             If the package of the new model relationship type is not
	 *             registered through a org.eclipse.emf.ecore.generated_package
	 *             extension, or if the uri of the new model relationship type
	 *             is already registered in the repository.
	 */
	public @NonNull ModelRel createHeavyModelRelType(@NonNull ExtensionPointType extensionType, boolean isBinary) throws MMINTException {

		ModelRel newModelRelType;
		if (extensionType.getNewType() == null) {
			newModelRelType = (isBinary) ?
				RelationshipFactory.eINSTANCE.createBinaryModelRel() :
				RelationshipFactory.eINSTANCE.createModelRel();
		}
		else {
			newModelRelType = (ModelRel) extensionType.getNewType();
		}
		addHeavyModelRelType(newModelRelType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), extensionType.isAbstract());

		return newModelRelType;
	}

	/**
	 * Creates and adds a "heavy" model type endpoint and a reference to it to the Type MID (variant for model
	 * relationship types).
	 * 
	 * @param extensionType
	 *            The extension info for the new model type endpoint.
	 * @param targetModelType
	 *            The model type that is the target of the new model type endpoint.
	 * @param isBinarySrc
	 *            (Only for a binary model relationship type container) True if the target model type is the source in
	 *            the binary model relationship type container, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new model type endpoint.
	 * @return The created reference to the new model type endpoint.
	 * @throws MMINTException
	 *             If the uri of the new model type endpoint is already registered in the repository.
	 */
	public @NonNull ModelEndpointReference createHeavyModelTypeEndpointAndModelTypeEndpointReference(@NonNull ExtensionPointType extensionType, @NonNull Model targetModelType, boolean isBinarySrc, @NonNull ModelRel containerModelRelType) throws MMINTException {

		ModelEndpoint newModelTypeEndpoint = (extensionType.getNewType() == null) ?
			MIDFactory.eINSTANCE.createModelEndpoint() :
			(ModelEndpoint) extensionType.getNewType();
		ModelEndpointReference newModelTypeEndpointRef = addHeavyModelTypeEndpointAndModelTypeEndpointReference(newModelTypeEndpoint, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), targetModelType, isBinarySrc, containerModelRelType);

		return newModelTypeEndpointRef;
	}

	/**
	 * Creates and adds a "heavy" model type endpoint to the Type MID (variant for operator types).
	 * 
	 * @param extensionType
	 *            The extension info for the new model type endpoint.
	 * @param targetModelType
	 *            The model type that is the target of the new model type endpoint.
	 * @param containerOperatorType
	 *            The operator type that will contain the new model type endpoint.
	 * @param containerFeatureName
	 *            The name of the feature in the operator type that will contain the new model type endpoint.
	 * @return The created model type endpoint.
	 * @throws MMINTException
	 *             If the uri of the new model type endpoint is already registered in the Type MID.
	 */
	public @NonNull ModelEndpoint createHeavyModelTypeEndpoint(@NonNull ExtensionPointType extensionType, @NonNull Model targetModelType, @NonNull Operator containerOperatorType, @NonNull String containerFeatureName) throws MMINTException {

		ModelEndpoint newModelTypeEndpoint = (extensionType.getNewType() == null) ?
			MIDFactory.eINSTANCE.createModelEndpoint() :
			(ModelEndpoint) extensionType.getNewType();
		//TODO MMINT[USABILITY] Put into default uri creator function
		String newModelTypeEndpointUri = (extensionType.getUri() == null) ?
			containerOperatorType.getUri() + MMINT.URI_SEPARATOR + extensionType.getName() :
			extensionType.getUri();
		addHeavyModelTypeEndpoint(newModelTypeEndpoint, newModelTypeEndpointUri, extensionType.getSupertypeUri(), extensionType.getName(), targetModelType, containerOperatorType, containerFeatureName);

		return newModelTypeEndpoint;
	}

	/**
	 * Creates and adds a "heavy" generic type endpoint to the Type MID.
	 * 
	 * @param extensionType
	 *            The extension info for the new generic type endpoint.
	 * @param targetGenericType
	 *            The generic type that is the target of the new generic type endpoint.
	 * @param containerOperatorType
	 *            The operator type that will contain the new generic type endpoint.
	 * @return The created generic type endpoint.
	 * @throws MMINTException
	 *             If the uri of the new generic type endpoint is already registered in the Type MID.
	 */
	public @NonNull GenericEndpoint createHeavyGenericTypeEndpoint(@NonNull ExtensionPointType extensionType, @NonNull GenericElement targetGenericType, @NonNull Operator containerOperatorType) throws MMINTException {

		GenericEndpoint newGenericTypeEndpoint = (extensionType.getNewType() == null) ?
			OperatorFactory.eINSTANCE.createGenericEndpoint() :
			(GenericEndpoint) extensionType.getNewType();
		String newGenericTypeEndpointUri = (extensionType.getUri() == null) ?
			containerOperatorType.getUri() + MMINT.URI_SEPARATOR + extensionType.getName() :
			extensionType.getUri();
		addHeavyGenericTypeEndpoint(newGenericTypeEndpoint, newGenericTypeEndpointUri, extensionType.getSupertypeUri(), extensionType.getName(), targetGenericType, containerOperatorType);

		return newGenericTypeEndpoint;
	}

	/**
	 * Creates and adds a "heavy" mapping type and a reference to it to the
	 * repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new mapping type.
	 * @param isBinary
	 *            True if the new mapping type is binary, false otherwise.
	 * @param containerModelRelType
	 *            The model relationship type that will contain the new mapping
	 *            type.
	 * @return The created reference to the new mapping type.
	 * @throws MMINTException
	 *             If the uri of the new mapping type is already registered in
	 *             the repository.
	 */
	public @NonNull MappingReference createHeavyMappingTypeAndMappingTypeReference(@NonNull ExtensionPointType extensionType, boolean isBinary, @NonNull ModelRel containerModelRelType) throws MMINTException {

		Mapping newMappingType;
		if (extensionType.getNewType() == null) {
			newMappingType = (isBinary) ?
				RelationshipFactory.eINSTANCE.createBinaryMapping() :
				RelationshipFactory.eINSTANCE.createMapping();
		}
		else {
			newMappingType = (Mapping) extensionType.getNewType();
		}
		MappingReference newMappingTypeRef = this.addHeavyMappingTypeAndMappingTypeReference(newMappingType, extensionType.getUri(), extensionType.getSupertypeUri(), extensionType.getName(), containerModelRelType);

		return newMappingTypeRef;
	}

	/**
	 * Creates and adds a "heavy" model element type endpoint and a reference to
	 * it to the repository.
	 * 
	 * @param extensionType
	 *            The extension info for the new model element type endpoint.
	 * @param targetModelElemTypeRef
	 *            The new reference to the new model element type that is the
	 *            target of the new model element type endpoint.
	 * @param isBinarySrc
	 *            (Only for a binary mapping type container) True if the model
	 *            element type endpoint is the source in the binary mapping type
	 *            container, false otherwise.
	 * @param containerMappingTypeRef
	 *            The reference to the mapping type that will contain the new model
	 *            element type endpoint.
	 * @return The created reference to the new model element type endpoint.
	 * @throws MMINTException
	 *             If the uri of the new model element type endpoint is already
	 *             registered in the repository.
	 */
	public ModelElementEndpointReference createHeavyModelElementTypeEndpointAndModelElementTypeEndpointReference(ExtensionPointType extensionType, ModelElementReference targetModelElemTypeRef, boolean isBinarySrc, MappingReference containerMappingTypeRef) throws MMINTException {

		ModelElementEndpoint newModelElemTypeEndpoint = (extensionType.getNewType() == null) ?
			RelationshipFactory.eINSTANCE.createModelElementEndpoint() :
			(ModelElementEndpoint) extensionType.getNewType();
		Mapping containerMappingType = containerMappingTypeRef.getObject();
		newModelElemTypeEndpoint.setTarget(targetModelElemTypeRef.getObject()); // needed to get the right root uri
		ModelElementEndpoint modelElemTypeEndpoint = getSupertype(newModelElemTypeEndpoint, extensionType.getUri(), extensionType.getSupertypeUri());
		addHeavyType(newModelElemTypeEndpoint, modelElemTypeEndpoint, extensionType.getUri(), extensionType.getName());
		addModelElementTypeEndpoint(newModelElemTypeEndpoint, targetModelElemTypeRef.getObject(), containerMappingType);
		ModelElementEndpointReference modelElemTypeEndpointRef = null;
		if (modelElemTypeEndpoint != null) { // may be root
			MappingReference newMappingTypeRefSuper = MIDRegistry.getReference(((Mapping) modelElemTypeEndpoint.eContainer()).getUri(), ((ModelRel) containerMappingTypeRef.eContainer()).getMappingRefs());
			if (newMappingTypeRefSuper != null) {
				modelElemTypeEndpointRef = MIDRegistry.getReference(modelElemTypeEndpoint.getUri(), newMappingTypeRefSuper.getModelElemEndpointRefs());
			}
		}
		ModelElementEndpointReference newModelElemTypeEndpointRef = newModelElemTypeEndpoint.createTypeReference(modelElemTypeEndpointRef, targetModelElemTypeRef, true, isBinarySrc, containerMappingTypeRef);
		addModelElementTypeEndpointReference(newModelElemTypeEndpointRef, containerMappingType);
		// copy from supertype
		Mapping mappingTypeSuper = containerMappingType.getSupertype();
		if (mappingTypeSuper != null && !MIDTypeHierarchy.isRootType(mappingTypeSuper)) {
			for (ModelElementEndpointReference modelElemTypeEndpointRefSuper : mappingTypeSuper.getModelElemEndpointRefs()) {
				addModelElementTypeEndpointReference(modelElemTypeEndpointRefSuper, containerMappingType);
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
	 * @throws MMINTException
	 *             If the uri of the new editor type is already registered in
	 *             the repository.
	 */
	public Editor createHeavyEditorType(ExtensionPointType extensionType, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName, boolean isDiagram) throws MMINTException {

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
		addEditorType(newEditorType, modelTypeUri, editorId, wizardId, wizardDialogClassName, MMINT.cachedTypeMID);

		//TODO MMINT[MISC] this can be optimized to run once instead of for each editor, if needed
		IExtensionRegistry registry = RegistryFactory.getRegistry();
		if (registry != null) {
			IConfigurationElement[] config = registry.getConfigurationElementsFor(MMINT.ECLIPSE_EDITORS_EXT_POINT);
			for (IConfigurationElement elem : config) {
				if (elem.getAttribute(MMINT.ECLIPSE_EDITORS_ATTR_ID).equals(editorId)) {
					String fileExtensions = elem.getAttribute(MMINT.ECLIPSE_EDITORS_ATTR_EXTENSIONS);
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

		Model modelType = MIDTypeRegistry.getType(modelTypeUri);
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

		for (Editor editorType : MIDTypeRegistry.getEditorTypes()) {
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
	 * @return The created operator type.
	 * @throws MMINTException
	 *             If the operator implementation is missing, or if the uri of
	 *             the new operator type is already registered in the
	 *             repository.
	 */
	public @NonNull Operator createHeavyOperatorType(@NonNull ExtensionPointType extensionType) throws MMINTException {

		if (extensionType.getNewType() == null) {
			throw new MMINTException("Missing operator implementation for " + extensionType.getName());
		}

		Operator newOperatorType = (Operator) extensionType.getNewType();
		Operator operatorType = getSupertypeWithoutRoot(newOperatorType, extensionType.getUri(), extensionType.getSupertypeUri());
		addHeavyGenericType(newOperatorType, operatorType, extensionType.getUri(), extensionType.getName(), extensionType.isAbstract());
		addOperatorType(newOperatorType, MMINT.cachedTypeMID);

		return newOperatorType;
	}

}
