/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;

/**
 * The factory to create/modify/remove all types.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeFactory {

	public final static String ECORE_PIVOT_URI = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
	public final static String ECORE_INVOCATION_DELEGATE = "invocationDelegates";
	public final static String ECORE_SETTING_DELEGATE = "settingDelegates";
	public final static String ECORE_VALIDATION_DELEGATE = "validationDelegates";
	public final static String ECORE_REFLECTIVE_FILE_EXTENSION = "xmi";

	/**
	 * Adds a type to a multimodel.
	 * 
	 * @param newType
	 *            The new type to be added.
	 * @param type
	 *            The supertype of the new type, null only for root types.
	 * @param newTypeUri
	 *            The uri of the new type.
	 * @param newTypeName
	 *            The name of the new type.
	 * @param multiModel
	 *            The multimodel that will contain the new type.
	 * @throws MMTFException
	 *             If the uri of the new type is already registered in the
	 *             multimodel.
	 */
	public static void addType(ExtendibleElement newType, ExtendibleElement type, String newTypeUri, String newTypeName, MultiModel multiModel) throws MMTFException {

		if (multiModel.getExtendibleTable().containsKey(newTypeUri)) {
			throw new MMTFException("Type with uri " + newTypeUri + " is already registered");
		}

		newType.setUri(newTypeUri);
		newType.setName(newTypeName);
		newType.setLevel(MidLevel.TYPES);
		newType.setSupertype(type);
		multiModel.getExtendibleTable().put(newTypeUri, newType);
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
	public static void addTypeEndpointCardinality(ExtendibleElementEndpoint typeEndpoint, int lowerBound, int upperBound) {

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

	/**
	 * Adds a model type to a multimodel.
	 * 
	 * @param newModelType
	 *            The new model type to be added.
	 * @param newModelTypeAbstract
	 *            True if the new model type is abstract, false otherwise.
	 * @param constraintLanguage
	 *            The constraint language of the constraint associated with the
	 *            new model type, null if no constraint is associated.
	 * @param constraintImplementation
	 *            The constraint implementation of the constraint associated
	 *            with the new model type, null if no constraint is associated.
	 * @param multiModel
	 *            The multimodel that will contain the new model type.
	 */
	public static void addModelType(Model newModelType, boolean newModelTypeAbstract, String constraintLanguage, String constraintImplementation, MultiModel multiModel) {

		newModelType.setAbstract(newModelTypeAbstract);
		ExtendibleElementConstraint modelConstraint = null;
		if (constraintLanguage != null) {
			modelConstraint = MidFactory.eINSTANCE.createExtendibleElementConstraint();
			modelConstraint.setLanguage(ExtendibleElementConstraintLanguage.valueOf(constraintLanguage));
			modelConstraint.setImplementation(constraintImplementation);
		}
		newModelType.setConstraint(modelConstraint);

		multiModel.getModels().add(newModelType);
	}

	/**
	 * Adds a model element type to a model type.
	 * 
	 * @param newModelElemType
	 *            The new model element type being added.
	 * @param classLiteral
	 *            The class name of the new model element type.
	 * @param modelType
	 *            The model type that will contain the new model element type.
	 */
	public static void addModelElementType(ModelElement newModelElemType, String classLiteral, Model modelType) {

		newModelElemType.setClassLiteral(classLiteral);

		modelType.getModelElems().add(newModelElemType);
	}

	/**
	 * Adds additional info for a model relationship type.
	 * 
	 * @param newModelRelType
	 *            The new model relationship type being added.
	 * @param modelRelType
	 *            The supertype of the new model relationship type.
	 * @throws MMTFException 
	 */
	public static void addModelRelType(ModelRel newModelRelType, ModelRel modelRelType) throws MMTFException {

		List<LinkReference> skipLinkRefs = new ArrayList<LinkReference>();
		// copy model type references
		Iterator<ModelEndpointReference> modelTypeEndpointRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(modelRelType.getModelEndpointRefs());
		while (modelTypeEndpointRefIter.hasNext()) {
			ModelEndpointReference modelTypeEndpointRefSuper = modelTypeEndpointRefIter.next();
			if (MultiModelTypeHierarchy.isRootType(modelTypeEndpointRefSuper.getObject().getTarget())) { // don't copy model type endpoints to the root model type
				for (ModelElementReference modelElemTypeRefSuper : modelTypeEndpointRefSuper.getModelElemRefs()) {
					for (ModelElementEndpointReference modelElemTypeEndpointRefSuper : modelElemTypeRefSuper.getModelElemEndpointRefs()) {
						skipLinkRefs.add((LinkReference) modelElemTypeEndpointRefSuper.eContainer());
					}
				}
				continue;
			}
			ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpointRefSuper.getSupertypeRef(), newModelRelType.getModelEndpointRefs());
			ModelEndpointReference newModelTypeEndpointRef = modelTypeEndpointRefSuper.getObject().createTypeReference(modelTypeEndpointRef, false, false, newModelRelType);
			// copy model element type references
			Iterator<ModelElementReference> modelElemTypeRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(modelTypeEndpointRefSuper.getModelElemRefs());
			while (modelElemTypeRefIter.hasNext()) {
				ModelElementReference modelElemTypeRefSuper = modelElemTypeRefIter.next();
				ModelElementReference modelElemTypeRef = MultiModelTypeHierarchy.getReference(modelElemTypeRefSuper.getSupertypeRef(), newModelTypeEndpointRef.getModelElemRefs());
				modelElemTypeRefSuper.getObject().createTypeReference(modelElemTypeRef, false, newModelTypeEndpointRef);
			}
		}
		// copy link type references
		Iterator<LinkReference> linkTypeRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(modelRelType.getLinkRefs());
		while (linkTypeRefIter.hasNext()) {
			LinkReference linkTypeRefSuper = linkTypeRefIter.next();
			if (skipLinkRefs.contains(linkTypeRefSuper)) { // don't copy link types using model element types from the root model type
				continue;
			}
			LinkReference linkTypeRef = MultiModelTypeHierarchy.getReference(linkTypeRefSuper.getSupertypeRef(), newModelRelType.getLinkRefs());
			LinkReference newLinkTypeRef = linkTypeRefSuper.getObject().createTypeReference(linkTypeRef, false, newModelRelType);
			// connect it to model element type references (takes care of binary too)
			Iterator<ModelElementEndpointReference> modelElemTypeEndpointRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(linkTypeRefSuper.getModelElemEndpointRefs());
			while (modelElemTypeEndpointRefIter.hasNext()) {
				ModelElementEndpointReference modelElemTypeEndpointRefSuper = modelElemTypeEndpointRefIter.next();
				ModelElementEndpointReference modelElemTypeEndpointRef = null;
				ModelElementEndpointReference modelElemTypeEndpointRefSuper2 = modelElemTypeEndpointRefSuper.getSupertypeRef();
				if (modelElemTypeEndpointRefSuper2 != null) {
					LinkReference linkTypeRefSuper2 = (LinkReference) modelElemTypeEndpointRefSuper2.eContainer();
					LinkReference linkTypeRef2 = MultiModelTypeHierarchy.getReference(linkTypeRefSuper2, newModelRelType.getLinkRefs());
					modelElemTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpointRefSuper2, linkTypeRef2.getModelElemEndpointRefs());
				}
				ModelElementReference modelElemTypeRefSuper = modelElemTypeEndpointRefSuper.getModelElemRef();
				ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference((ModelEndpointReference) modelElemTypeRefSuper.eContainer(), newModelRelType.getModelEndpointRefs());
				ModelElementReference newModelElemTypeRef = MultiModelTypeHierarchy.getReference(modelElemTypeRefSuper, modelTypeEndpointRef.getModelElemRefs());
				createModelElementTypeEndpointReference(modelElemTypeEndpointRefSuper.getObject(), modelElemTypeEndpointRef, newModelElemTypeRef, false, false, newLinkTypeRef);
			}
		}
	}

	/**
	 * Adds a model type endpoint to a model relationship type.
	 * 
	 * @param newModelTypeEndpoint
	 *            The new model type endpoint to be added.
	 * @param newModelType
	 *            The new model type that is the target of the new model type
	 *            endpoint.
	 * @param isBinarySrc
	 *            True if the model type endpoint is the source in the binary
	 *            model relationship type container, false otherwise.
	 * @param modelRelType
	 *            The model relationship type that will contain the new model
	 *            type endpoint.
	 */
	public static void addModelTypeEndpoint(ModelEndpoint newModelTypeEndpoint, Model newModelType, boolean isBinarySrc, ModelRel modelRelType) {

		addTypeEndpoint(newModelTypeEndpoint, newModelType);
		if (isBinarySrc) {
			modelRelType.getModelEndpoints().add(0, newModelTypeEndpoint);
		}
		else {
			modelRelType.getModelEndpoints().add(newModelTypeEndpoint);
		}
	}

	/**
	 * Adds a link type to a model relationship type.
	 * 
	 * @param newLinkType
	 *            The new link type to be added.
	 * @param linkType
	 *            The supertype of the new link type.
	 * @param modelRelType
	 *            The model relationship type that will contain the new link
	 *            type.
	 */
	public static void addLinkType(Link newLinkType, Link linkType, ModelRel modelRelType) {

		// keep track of inherited model elements, but not root ones
		if (linkType != null && !linkType.getUri().equals(MMTF.ROOT_LINK_URI)) {
			for (ModelElementEndpointReference modelElemTypeEndpointRef : linkType.getModelElemEndpointRefs()) {
				newLinkType.getModelElemEndpointRefs().add(modelElemTypeEndpointRef);
			}
		}
		modelRelType.getLinks().add(newLinkType);
	}

	/**
	 * Adds a model element type endpoint to a link type.
	 * 
	 * @param newModelElemTypeEndpoint
	 *            The new model element type endpoint to be added.
	 * @param newModelElemType
	 *            The new model element type that is the target of the new model
	 *            element type endpoint.
	 * @param isBinarySrc
	 *            True if the model element type endpoint is the source in the
	 *            binary link type container, false otherwise.
	 * @param linkType
	 *            The link type that will contain the new model element type
	 *            endpoint.
	 */
	protected static void addModelElementTypeEndpoint(ModelElementEndpoint newModelElemTypeEndpoint, ModelElement newModelElemType, boolean isBinarySrc, Link linkType) {

		addTypeEndpoint(newModelElemTypeEndpoint, newModelElemType);
		if (isBinarySrc) {
			linkType.getModelElemEndpoints().add(0, newModelElemTypeEndpoint);
		}
		else {
			linkType.getModelElemEndpoints().add(newModelElemTypeEndpoint);
		}
	}

	/**
	 * Adds additional info for a reference to a model element type endpoint.
	 * 
	 * @param newModelElemTypeEndpointRef
	 *            The new reference to the new model element type endpoint being
	 *            added.
	 * @param linkType
	 *            The link type that contains the referenced model element type
	 *            endpoint.
	 */
	protected static void addModelElementTypeEndpointReference(ModelElementEndpointReference newModelElemTypeEndpointRef, Link linkType) {

		linkType.getModelElemEndpointRefs().add(newModelElemTypeEndpointRef);
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
	 * @param multiModel
	 *            The multimodel that will contain the new editor type.
	 */
	public static void addEditorType(Editor newEditorType, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName, MultiModel multiModel) {

		newEditorType.setModelUri(modelTypeUri);
		newEditorType.setId(editorId);
		newEditorType.setWizardId(wizardId);
		newEditorType.setWizardDialogClass(wizardDialogClassName);

		multiModel.getEditors().add(newEditorType);
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
	 * Adds an operator type to a multimodel.
	 * 
	 * @param newOperatorType
	 *            The new operator type to be added.
	 * @param executable
	 *            The implementation of the new operator type.
	 * @param multiModel
	 *            The multimodel that will contain the new operator type.
	 */
	protected static void addOperatorType(Operator newOperatorType, OperatorExecutable executable, MultiModel multiModel) {

		newOperatorType.setExecutable(executable);
		multiModel.getOperators().add(newOperatorType);
	}

	/**
	 * Adds a parameter type (i.e. a formal parameter) to an operator type.
	 * 
	 * @param newParamType
	 *            The new parameter type to be added.
	 * @param newParamTypeName
	 *            The name of the new parameter type.
	 * @param modelType
	 *            The model type that is the target of the new parameter type.
	 * @param isVararg
	 *            True if the new parameter type represents a variable number of
	 *            parameter types of the same kind, false otherwise.
	 * @param paramTypes
	 *            The list of parameter types that will contain the new
	 *            parameter type.
	 * @param operatorType
	 *            The operator type that will contain the new parameter type.
	 */
	protected static void addOperatorTypeParameter(Parameter newParamType, String newParamTypeName, Model modelType, boolean isVararg, EList<Parameter> paramTypes, Operator operatorType) {

		newParamType.setModel(modelType);
		newParamType.setName(newParamTypeName);
		newParamType.setVararg(isVararg);
		paramTypes.add(newParamType);
		operatorType.getSignatureTable().put(newParamTypeName, newParamType);
	}

	/**
	 * Creates and adds a model element type endpoint reference to a link type
	 * reference.
	 * 
	 * @param newModelElemTypeEndpoint
	 *            The new model element type endpoint for which the reference
	 *            has to be created.
	 * @param modelElemTypeEndpointRef
	 *            The reference to the supertype of the new model element type
	 *            endpoint, null if such reference doesn't exist in the link
	 *            type reference container.
	 * @param newModelElemTypeRef
	 *            The new reference to the model element type that is the target
	 *            of the new model element type endpoint.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced model element type endpoint, false otherwise.
	 * @param isBinarySrc
	 *            True if the referenced model element type endpoint is the
	 *            source in the binary link type reference container, false
	 *            otherwise.
	 * @param linkTypeRef
	 *            The reference to the link type that will contain the new
	 *            reference to the model element type endpoint.
	 * @return The created reference to the new model element type endpoint.
	 */
	public static ModelElementEndpointReference createModelElementTypeEndpointReference(ModelElementEndpoint newModelElemTypeEndpoint, ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementReference newModelElemTypeRef, boolean isModifiable, boolean isBinarySrc, LinkReference linkTypeRef) {

		ModelElementEndpointReference newModelElemTypeEndpointRef = RelationshipFactory.eINSTANCE.createModelElementEndpointReference();
		addTypeReference(newModelElemTypeEndpointRef, newModelElemTypeEndpoint, modelElemTypeEndpointRef, isModifiable, false);
		newModelElemTypeEndpointRef.setModelElemRef(newModelElemTypeRef);

		if (isBinarySrc) {
			linkTypeRef.getModelElemEndpointRefs().add(0, newModelElemTypeEndpointRef);
		}
		else {
			linkTypeRef.getModelElemEndpointRefs().add(newModelElemTypeEndpointRef);
		}

		return newModelElemTypeEndpointRef;
	}

	/**
	 * Adds additional info for a conversion operator type.
	 * 
	 * @param operatorType
	 *            The conversion operator type being added.
	 */
	public static void createOperatorTypeConversion(ConversionOperator operatorType) {

		operatorType.getInputs().get(0).getModel().getConversionOperators().add(operatorType);
	}

	/**
	 * Removes a type from a multimodel.
	 * 
	 * @param typeUri
	 *            The uri of the type to be removed.
	 * @param multiModel
	 *            The multimodel that contains the type.
	 * @return The removed type, null if the uri was not registered in the
	 *         multimodel.
	 */
	public static ExtendibleElement removeType(String typeUri, MultiModel multiModel) {

		return multiModel.getExtendibleTable().removeKey(typeUri);
	}

	/**
	 * Removes a model element type endpoint from the multimodel that contains
	 * it.
	 * 
	 * @param modelElemTypeEndpoint
	 *            The model element type endpoint to be removed.
	 * @param isFullRemove
	 *            True if the model element type endpoint is going to be fully
	 *            removed, false if it is going to be replaced later.
	 */
	public static void removeModelElementTypeEndpoint(ModelElementEndpoint modelElemTypeEndpoint, boolean isFullRemove) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelElemTypeEndpoint);
		removeType(modelElemTypeEndpoint.getUri(), multiModel);
		if (isFullRemove) {
			Link linkType = (Link) modelElemTypeEndpoint.eContainer();
			linkType.getModelElemEndpoints().remove(modelElemTypeEndpoint);
		}
	}

	/**
	 * Removes additional info for a reference to a model element type endpoint.
	 * 
	 * @param modelElemTypeEndpointRef
	 *            The reference to be removed to the model element type
	 *            endpoint.
	 * @param isFullRemove
	 *            True if the reference to the model element type endpoint is
	 *            going to be fully removed, false if it is going to be replaced
	 *            later.
	 * @param linkType
	 *            The link type that contains the model element type endpoint.
	 */
	private static void removeModelElementTypeEndpointReference(ModelElementEndpointReference modelElemTypeEndpointRef, boolean isFullRemove, Link linkType) {

		if (isFullRemove) {
			linkType.getModelElemEndpointRefs().remove(modelElemTypeEndpointRef);
		}
	}

	/**
	 * Removes a reference to a model element type endpoint from the multimodel
	 * that contains it.
	 * 
	 * @param modelElemTypeEndpointRef
	 *            The reference to be removed to the model element type
	 *            endpoint.
	 * @param isFullRemove
	 *            True if the reference to the model element type endpoint is
	 *            going to be fully removed, false if it is going to be replaced
	 *            later.
	 */
	private static void removeModelElementTypeEndpointReference(ModelElementEndpointReference modelElemTypeEndpointRef, boolean isFullRemove) {

		if (isFullRemove) {
			modelElemTypeEndpointRef.setModelElemRef(null);
			LinkReference linkTypeRef = (LinkReference) modelElemTypeEndpointRef.eContainer();
			linkTypeRef.getModelElemEndpointRefs().remove(modelElemTypeEndpointRef);
		}
	}

	/**
	 * Removes a model element type endpoint, its subtypes and all references to
	 * them from the multimodel that contains them.
	 * 
	 * @param modelElemTypeEndpointRef
	 *            The "first" reference to the model element type endpoint to be
	 *            removed (contained in the same model relationship as the model
	 *            element type endpoint).
	 * @param isFullRemove
	 *            True if the model element type endpoint is going to be fully
	 *            removed, false if it is going to be replaced later.
	 */
	public static void removeModelElementTypeEndpointAndModelElementTypeEndpointReference(ModelElementEndpointReference modelElemTypeEndpointRef, boolean isFullRemove) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelElemTypeEndpointRef);
		LinkReference linkTypeRef = (LinkReference) modelElemTypeEndpointRef.eContainer();
		ModelRel modelRelType = (ModelRel) linkTypeRef.eContainer();
		// delete the "thing" and the corresponding reference
		removeModelElementTypeEndpoint(modelElemTypeEndpointRef.getObject(), isFullRemove);
		removeModelElementTypeEndpointReference(modelElemTypeEndpointRef, isFullRemove, linkTypeRef.getObject());
		removeModelElementTypeEndpointReference(modelElemTypeEndpointRef, isFullRemove);
		// delete references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel)) {
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpointRef, linkSubtypeRef.getModelElemEndpointRefs());
			removeModelElementTypeEndpointReference(modelElemSubtypeEndpointRef, isFullRemove);
		}
		// delete references of the "thing" in subtypes of the container
		for (Link linkSubtype : MultiModelTypeHierarchy.getSubtypes(linkTypeRef.getObject(), multiModel)) {
			removeModelElementTypeEndpointReference(modelElemTypeEndpointRef, isFullRemove, linkSubtype);
		}
	}

}