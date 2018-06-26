/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * The factory to create/modify/remove all types.
 *
 * @author Alessio Di Sandro
 *
 */
public class MIDTypeFactory {

	public final static String ECORE_PIVOT_URI = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
	public final static String ECORE_INVOCATION_DELEGATE = "invocationDelegates";
	public final static String ECORE_SETTING_DELEGATE = "settingDelegates";
	public final static String ECORE_VALIDATION_DELEGATE = "validationDelegates";
	public final static String ECORE_VALIDATION_CONSTRAINTS = "constraints";
	public final static String ECORE_REFLECTIVE_FILE_EXTENSION = "xmi";

	/**
	 * Adds a type to the Type MID.
	 *
	 * @param newType
	 *            The new type to be added.
	 * @param type
	 *            The supertype of the new type, null only for root types.
	 * @param newTypeUri
	 *            The uri of the new type.
	 * @param newTypeName
	 *            The name of the new type.
	 * @param typeMID
	 *            The Type MID.
	 * @throws MMINTException
	 *             If the uri of the new type is already registered in the Type MID.
	 */
	public static void addType(@NonNull ExtendibleElement newType, @Nullable ExtendibleElement type, @NonNull String newTypeUri, @NonNull String newTypeName, @NonNull MID typeMID) throws MMINTException {

		if (typeMID.getExtendibleTable().containsKey(newTypeUri)) {
			throw new MMINTException("Type with uri " + newTypeUri + " is already registered");
		}

		newType.setUri(newTypeUri);
		newType.setName(newTypeName);
		newType.setLevel(MIDLevel.TYPES);
		newType.setSupertype(type);
		typeMID.getExtendibleTable().put(newTypeUri, newType);
	}

	/**
	 * Adds the cardinality to a type endpoint.
	 *
	 * @param typeEndpoint
	 *            The type endpoint.
	 * @param lowerBound
	 *            The lower cardinality.
	 * @param upperBound
	 *            The upper cardinality, -1 for infinite.
	 */
	public static void addTypeEndpointCardinality(@NonNull ExtendibleElementEndpoint typeEndpoint, int lowerBound, int upperBound) {

		typeEndpoint.setLowerBound(lowerBound);
		typeEndpoint.setUpperBound(upperBound);
	}

	/**
	 * Adds the target to a new type endpoint.
	 *
	 * @param newTypeEndpoint
	 *            The new type endpoint.
	 * @param newType
	 *            The new type that is the target of the new type endpoint.
	 */
	protected static void addTypeEndpoint(ExtendibleElementEndpoint newTypeEndpoint, ExtendibleElement newType) {

		newTypeEndpoint.setTarget(newType);
		addTypeEndpointCardinality(newTypeEndpoint, 1, 1);
	}

	/**
	 * Adds additional info for a reference to a type.
	 *
	 * @param newTypeRef
	 *            The new reference being added.
	 * @param newType
	 *            The new type for which the reference was created.
	 * @param typeRef
	 *            The reference to the supertype of the new type, null if such
	 *            reference doesn't exist.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced type, false otherwise.
	 * @param isContainer
	 *            True if the new reference is also the actual container of the
	 *            new type and not just a pointer to it, false otherwise.
	 */
	public static void addTypeReference(ExtendibleElementReference newTypeRef, ExtendibleElement newType, ExtendibleElementReference typeRef, boolean isModifiable, boolean isContainer) {

		if (isContainer) {
			newTypeRef.setContainedObject(newType);
		}
		else {
			newTypeRef.setReferencedObject(newType);
		}
		newTypeRef.setModifiable(isModifiable);
		newTypeRef.setSupertypeRef(typeRef);
	}

	public static void addTypeConstraint(@NonNull ExtendibleElementConstraint newTypeConstraint, @NonNull String language, @NonNull String implementation, @NonNull ExtendibleElement constrainedType) {

		newTypeConstraint.setLanguage(language);
		newTypeConstraint.setImplementation(implementation);
		constrainedType.setConstraint(newTypeConstraint);
	}

	/**
	 * Adds a model type to the Type MID.
	 *
	 * @param newModelType
	 *            The new model type to be added.
	 * @param typeMID
	 *            The Type MID.
	 */
	public static void addModelType(@NonNull Model newModelType, @NonNull MID typeMID) {

		typeMID.getModels().add(newModelType);
	}

	/**
	 * Adds a model element type to a model type.
	 *
	 * @param newModelElemType
	 *            The new model element type being added.
	 * @param eInfo
	 *            The EMF info of the new model element type.
	 * @param modelType
	 *            The model type that will contain the new model element type.
	 */
	public static void addModelElementType(ModelElement newModelElemType, EMFInfo eInfo, Model modelType) {

		newModelElemType.setEInfo(eInfo);

		modelType.getModelElems().add(newModelElemType);
	}

	/**
	 * Adds additional info for a model relationship type.
	 *
	 * @param newModelRelType
	 *            The new model relationship type being added.
	 * @param modelRelType
	 *            The supertype of the new model relationship type.
	 * @throws MMINTException
	 */
	public static void addModelRelType(ModelRel newModelRelType, ModelRel modelRelType) throws MMINTException {

	    List<MappingReference> skipMappingRefs = new ArrayList<>();
		// copy model type references
		Iterator<ModelEndpointReference> modelTypeEndpointRefIter = MIDTypeHierarchy.getTypeRefHierarchyIterator(modelRelType.getModelEndpointRefs());
		while (modelTypeEndpointRefIter.hasNext()) {
			ModelEndpointReference modelTypeEndpointRefSuper = modelTypeEndpointRefIter.next();
			if (MIDTypeHierarchy.isRootType(modelTypeEndpointRefSuper.getObject().getTarget())) { // don't copy model type endpoints to the root model type
				for (ModelElementReference modelElemTypeRefSuper : modelTypeEndpointRefSuper.getModelElemRefs()) {
					for (ModelElementEndpointReference modelElemTypeEndpointRefSuper : modelElemTypeRefSuper.getModelElemEndpointRefs()) {
						skipMappingRefs.add((MappingReference) modelElemTypeEndpointRefSuper.eContainer());
					}
				}
				continue;
			}
			ModelEndpointReference newModelTypeEndpointRef = modelTypeEndpointRefSuper.getObject().createTypeReference(false, newModelRelType);
			// copy model element type references
			Iterator<ModelElementReference> modelElemTypeRefIter = MIDTypeHierarchy.getTypeRefHierarchyIterator(modelTypeEndpointRefSuper.getModelElemRefs());
			while (modelElemTypeRefIter.hasNext()) {
				ModelElementReference modelElemTypeRefSuper = modelElemTypeRefIter.next();
				ModelElementReference modelElemTypeRef = MIDRegistry.getReference(modelElemTypeRefSuper.getSupertypeRef(), newModelTypeEndpointRef.getModelElemRefs());
				modelElemTypeRefSuper.getObject().createTypeReference(modelElemTypeRef, false, newModelTypeEndpointRef);
			}
		}
		// copy link type references
		Iterator<MappingReference> mappingTypeRefIter = MIDTypeHierarchy.getTypeRefHierarchyIterator(modelRelType.getMappingRefs());
		while (mappingTypeRefIter.hasNext()) {
			MappingReference mappingTypeRefSuper = mappingTypeRefIter.next();
			if (skipMappingRefs.contains(mappingTypeRefSuper)) { // don't copy link types using model element types from the root model type
				continue;
			}
			MappingReference mappingTypeRef = MIDRegistry.getReference(mappingTypeRefSuper.getSupertypeRef(), newModelRelType.getMappingRefs());
			MappingReference newMappingTypeRef = mappingTypeRefSuper.getObject().createTypeReference(mappingTypeRef, false, newModelRelType);
			// connect it to model element type references (takes care of binary too)
			Iterator<ModelElementEndpointReference> modelElemTypeEndpointRefIter = MIDTypeHierarchy.getTypeRefHierarchyIterator(mappingTypeRefSuper.getModelElemEndpointRefs());
			while (modelElemTypeEndpointRefIter.hasNext()) {
				ModelElementEndpointReference modelElemTypeEndpointRefSuper = modelElemTypeEndpointRefIter.next();
				ModelElementEndpointReference modelElemTypeEndpointRef = null;
				ModelElementEndpointReference modelElemTypeEndpointRefSuper2 = modelElemTypeEndpointRefSuper.getSupertypeRef();
				if (modelElemTypeEndpointRefSuper2 != null) {
					MappingReference mappingTypeRefSuper2 = (MappingReference) modelElemTypeEndpointRefSuper2.eContainer();
					MappingReference mappingTypeRef2 = MIDRegistry.getReference(mappingTypeRefSuper2, newModelRelType.getMappingRefs());
					modelElemTypeEndpointRef = MIDRegistry.getReference(modelElemTypeEndpointRefSuper2, mappingTypeRef2.getModelElemEndpointRefs());
				}
				ModelElementReference modelElemTypeRefSuper = modelElemTypeEndpointRefSuper.getModelElemRef();
				ModelEndpointReference modelTypeEndpointRef = MIDRegistry.getReference((ModelEndpointReference) modelElemTypeRefSuper.eContainer(), newModelRelType.getModelEndpointRefs());
				ModelElementReference newModelElemTypeRef = MIDRegistry.getReference(modelElemTypeRefSuper, modelTypeEndpointRef.getModelElemRefs());
				modelElemTypeEndpointRefSuper.getObject().createTypeReference(modelElemTypeEndpointRef, newModelElemTypeRef, false, false, newMappingTypeRef);
			}
		}
	}

	/**
	 * Adds a model type endpoint to a model relationship type.
	 *
	 * @param newModelTypeEndpoint
	 *            The new model type endpoint to be added.
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
	 * @throws MMINTException
	 *             If the container model relationship is a model relationship
	 *             instance.
	 */
	public static void addModelTypeEndpoint(@NonNull ModelEndpoint newModelTypeEndpoint, @NonNull Model targetModelType, boolean isBinarySrc, @NonNull ModelRel containerModelRelType) throws MMINTException {

		addTypeEndpoint(newModelTypeEndpoint, targetModelType);
		containerModelRelType.getModelEndpoints().add(newModelTypeEndpoint);
		if (containerModelRelType instanceof BinaryModelRel) {
			((BinaryModelRel) containerModelRelType).addModelType(targetModelType, isBinarySrc);
		}
	}

	/**
	 * Adds a model type endpoint to an operator type.
	 *
	 * @param newModelTypeEndpoint
	 *            The new model type endpoint to be added.
	 * @param targetModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param containerOperatorType
	 *            The operator type that will contain the new model type
	 *            endpoint.
	 * @param containerFeatureName
	 *            The name of the feature in the operator type that will contain
	 *            the new model type endpoint.
	 * @throws MMINTException
	 *             If the feature name is not found in the container operator
	 *             type.
	 */
	public static void addModelTypeEndpoint(@NonNull ModelEndpoint newModelTypeEndpoint, @NonNull Model targetModelType, @NonNull Operator containerOperatorType, @NonNull String containerFeatureName) throws MMINTException {

		addTypeEndpoint(newModelTypeEndpoint, targetModelType);
		FileUtils.setModelObjectFeature(containerOperatorType, containerFeatureName, newModelTypeEndpoint);
	}

	/**
	 * Adds a mapping type to a model relationship type.
	 *
	 * @param newMappingType
	 *            The new mapping type to be added.
	 * @param mappingType
	 *            The supertype of the new mapping type.
	 * @param modelRelType
	 *            The model relationship type that will contain the new mapping
	 *            type.
	 */
	public static void addMappingType(Mapping newMappingType, Mapping mappingType, ModelRel modelRelType) {

		// keep track of inherited model elements, but not root ones
		if (mappingType != null && !mappingType.getUri().equals(MMINT.ROOT_MAPPING_URI)) {
			for (ModelElementEndpointReference modelElemTypeEndpointRef : mappingType.getModelElemEndpointRefs()) {
				newMappingType.getModelElemEndpointRefs().add(modelElemTypeEndpointRef);
			}
		}
		modelRelType.getMappings().add(newMappingType);
	}

	/**
	 * Adds a model element type endpoint to a mapping type.
	 *
	 * @param newModelElemTypeEndpoint
	 *            The new model element type endpoint to be added.
	 * @param targetModelElemType
	 *            The new model element type that is the target of the new model
	 *            element type endpoint.
	 * @param containerMappingType
	 *            The mapping type that will contain the new model element type
	 *            endpoint.
	 */
	public static void addModelElementTypeEndpoint(ModelElementEndpoint newModelElemTypeEndpoint, ModelElement targetModelElemType, Mapping containerMappingType) {

		addTypeEndpoint(newModelElemTypeEndpoint, targetModelElemType);
		containerMappingType.getModelElemEndpoints().add(newModelElemTypeEndpoint);
	}

	/**
	 * Adds additional info for a reference to a model element type endpoint.
	 *
	 * @param newModelElemTypeEndpointRef
	 *            The new reference to the new model element type endpoint being
	 *            added.
	 * @param mappingType
	 *            The mapping type that contains the referenced model element type
	 *            endpoint.
	 */
	public static void addModelElementTypeEndpointReference(ModelElementEndpointReference newModelElemTypeEndpointRef, Mapping mappingType) {

		mappingType.getModelElemEndpointRefs().add(newModelElemTypeEndpointRef);
	}

	/**
	 * Adds an editor type to a multimodel.
	 *
	 * @param newEditorType
	 *            The new editor type to be added.
	 * @param modelTypeUri
	 *            The uri of the model type handled by the new editor type.
	 * @param editorId
	 *            The id of the corresponding Eclipse editor.
	 * @param wizardId
	 *            The wizard id of the corresponding Eclipse editor.
	 * @param wizardDialogClassName
	 *            The fully qualified name of a Java class that handles the
	 *            creation of the model type through the new editor type.
	 * @param mid
	 *            The MID that will contain the new editor type.
	 */
	public static void addEditorType(Editor newEditorType, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName, MID mid) {

		newEditorType.setModelUri(modelTypeUri);
		newEditorType.setId(editorId);
		newEditorType.setWizardId(wizardId);
		newEditorType.setWizardDialogClass(wizardDialogClassName);

		mid.getEditors().add(newEditorType);
	}

	/**
	 * Adds a editor type to a model type.
	 *
	 * @param editorType
	 *            The editor type.
	 * @param modelType
	 *            The model type handled by the editor type.
	 */
	public static void addModelTypeEditor(Editor editorType, Model modelType) {

		modelType.getEditors().add(editorType);
	}

	/**
	 * Adds an operator type to the Type MID.
	 *
	 * @param newOperatorType
	 *            The new operator type to be added.
	 * @param typeMID
	 *            The Type MID.
	 */
	public static void addOperatorType(Operator newOperatorType, MID typeMID) {

		newOperatorType.setCommutative(false);
		typeMID.getOperators().add(newOperatorType);
	}

	/**
	 * Adds additional info for a conversion operator type.
	 *
	 * @param operatorType
	 *            The conversion operator type being added.
	 */
	public static void addOperatorTypeConversion(ConversionOperator operatorType) {

		operatorType.getInputs().get(0).getTarget().getConversionOperators().add(operatorType);
	}

}