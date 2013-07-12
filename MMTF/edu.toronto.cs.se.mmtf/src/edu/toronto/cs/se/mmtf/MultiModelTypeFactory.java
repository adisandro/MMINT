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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelConstraint;
import edu.toronto.cs.se.mmtf.mid.ModelConstraintLanguage;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
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
 * The factory for creating all types.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeFactory {

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
	protected static void addType(ExtendibleElement newType, ExtendibleElement type, String newTypeUri, String newTypeName, MultiModel multiModel) throws MMTFException {

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
	 * Adds the target to a type endpoint.
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
	protected static void addTypeReference(ExtendibleElementReference newTypeRef, ExtendibleElement newType, ExtendibleElementReference typeRef, boolean isModifiable, boolean isContainer) {

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
	protected static void addModelType(Model newModelType, boolean newModelTypeAbstract, String constraintLanguage, String constraintImplementation, MultiModel multiModel) {

		newModelType.setAbstract(newModelTypeAbstract);
		ModelConstraint modelConstraint = null;
		if (constraintLanguage != null) {
			modelConstraint = MidFactory.eINSTANCE.createModelConstraint();
			modelConstraint.setLanguage(ModelConstraintLanguage.valueOf(constraintLanguage));
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
	 * @param category
	 *            The category of the new model element type.
	 * @param classLiteral
	 *            The class name of the new model element type.
	 * @param modelType
	 *            The model type that will contain the new model element type.
	 */
	protected static void addModelElementType(ModelElement newModelElemType, ModelElementCategory category, String classLiteral, Model modelType) {

		newModelElemType.setCategory(category);
		newModelElemType.setClassLiteral(classLiteral);

		modelType.getElements().add(newModelElemType);
	}

	/**
	 * Adds additional info for a model relationship type.
	 * 
	 * @param newModelRelType
	 *            The new model relationship type being added.
	 * @param modelRelType
	 *            The supertype of the new model relationship type.
	 */
	protected static void addModelRelType(ModelRel newModelRelType, ModelRel modelRelType) {

		if (MultiModelConstraintChecker.isRootType(modelRelType)) {
			return;
		}

		// copy model type references
		Iterator<ModelEndpointReference> modelTypeEndpointRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(modelRelType.getModelEndpointRefs());
		while (modelTypeEndpointRefIter.hasNext()) {
			ModelEndpointReference modelTypeEndpointRefSuper = modelTypeEndpointRefIter.next();
			ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpointRefSuper.getSupertypeRef(), newModelRelType.getModelEndpointRefs());
			ModelEndpointReference newModelTypeEndpointRef = createModelTypeEndpointReference(
				modelTypeEndpointRefSuper.getObject(),
				modelTypeEndpointRef,
				false,
				false,
				newModelRelType
			);
			// copy model element type references
			Iterator<ModelElementReference> modelElemTypeRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(modelTypeEndpointRefSuper.getModelElemRefs());
			while (modelElemTypeRefIter.hasNext()) {
				ModelElementReference modelElemTypeRefSuper = modelElemTypeRefIter.next();
				ModelElementReference modelElemTypeRef = MultiModelTypeHierarchy.getReference(modelElemTypeRefSuper.getSupertypeRef(), newModelTypeEndpointRef.getModelElemRefs());
				createModelElementTypeReference(
					modelElemTypeRefSuper.getObject(),
					modelElemTypeRef,
					false,
					newModelTypeEndpointRef
				);
			}
		}
		// copy link type references
		Iterator<LinkReference> linkTypeRefIter = MultiModelTypeHierarchy.getTypeRefHierarchyIterator(modelRelType.getLinkRefs());
		while (linkTypeRefIter.hasNext()) {
			LinkReference linkTypeRefSuper = linkTypeRefIter.next();
			LinkReference linkTypeRef = MultiModelTypeHierarchy.getReference(linkTypeRefSuper.getSupertypeRef(), newModelRelType.getLinkRefs());
			LinkReference newLinkTypeRef = createLinkTypeReference(
				linkTypeRefSuper.getObject(),
				linkTypeRef,
				linkTypeRefSuper.eClass(),
				false,
				newModelRelType
			);
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
	protected static void addModelTypeEndpoint(ModelEndpoint newModelTypeEndpoint, Model newModelType, boolean isBinarySrc, ModelRel modelRelType) {

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
	protected static void addLinkType(Link newLinkType, Link linkType, ModelRel modelRelType) {

		// keep track of inherited model elements, but not root ones
		if (linkType != null && !linkType.getUri().equals(MMTF.ROOT_MODELREL_LINK_URI)) {
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
	protected static void addEditorType(Editor newEditorType, String modelTypeUri, String editorId, String wizardId, String wizardDialogClassName, MultiModel multiModel) {

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
	protected static void addModelTypeEditor(Editor editorType, Model modelType) {

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
	 * Creates and adds a model type endpoint reference to a model relationship
	 * type.
	 * 
	 * @param newModelTypeEndpoint
	 *            The new model type endpoint for which the reference has to be
	 *            created.
	 * @param modelTypeEndpointRef
	 *            The reference to the supertype of the new model type endpoint,
	 *            null if such reference doesn't exist in the model relationship
	 *            type container.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced model type endpoint, false otherwise.
	 * @param isBinarySrc
	 *            True if the referenced model type endpoint is the source in
	 *            the binary model relationship container, false otherwise.
	 * @param modelRelType
	 *            The model relationship type that will contain the new
	 *            reference to the model type endpoint.
	 * @return The created reference to the new model type endpoint.
	 */
	public static ModelEndpointReference createModelTypeEndpointReference(ModelEndpoint newModelTypeEndpoint, ModelEndpointReference modelTypeEndpointRef, boolean isModifiable, boolean isBinarySrc, ModelRel modelRelType) {

		ModelEndpointReference newModelTypeEndpointRef = RelationshipFactory.eINSTANCE.createModelEndpointReference();
		addTypeReference(newModelTypeEndpointRef, newModelTypeEndpoint, modelTypeEndpointRef, isModifiable, false);

		if (isBinarySrc) {
			modelRelType.getModelEndpointRefs().add(0, newModelTypeEndpointRef);
		}
		else {
			modelRelType.getModelEndpointRefs().add(newModelTypeEndpointRef);
		}

		return newModelTypeEndpointRef;
	}

	/**
	 * Creates and adds a link type reference to a model relationship type.
	 * 
	 * @param newLinkType
	 *            The new link type for which the reference has to be created.
	 * @param linkTypeRef
	 *            The reference to the supertype of the new link type, null if
	 *            such reference doesn't exist in the model relationship type
	 *            container.
	 * @param newLinkTypeRefClass
	 *            The class of the new reference to the link type.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced link type, false otherwise.
	 * @param modelRelType
	 *            The model relationship type that will contain the new
	 *            reference to the link type.
	 * @return The created reference to the new link type.
	 */
	public static LinkReference createLinkTypeReference(Link newLinkType, LinkReference linkTypeRef, EClass newLinkTypeRefClass, boolean isModifiable, ModelRel modelRelType) {

		LinkReference newLinkTypeRef = (LinkReference) RelationshipFactory.eINSTANCE.create(newLinkTypeRefClass);
		addTypeReference(newLinkTypeRef, newLinkType, linkTypeRef, isModifiable, false);
		modelRelType.getLinkRefs().add(newLinkTypeRef);

		return newLinkTypeRef;
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
	 * Creates and adds a model element type reference to a model type endpoint
	 * reference.
	 * 
	 * @param newModelElemType
	 *            The new model element type for which the reference has to be
	 *            created.
	 * @param modelElemTypeRef
	 *            The reference to the supertype of the new model element type,
	 *            null if such reference doesn't exist in the model type
	 *            endpoint reference container.
	 * @param isModifiable
	 *            True if the new reference will allow modifications of the
	 *            referenced model element type, false otherwise.
	 * @param modelTypeEndpointRef
	 *            The reference to the model type endpoint that will contain the
	 *            new reference to the model element type.
	 * @return The created reference to the new model element type.
	 */
	public static ModelElementReference createModelElementTypeReference(ModelElement newModelElemType, ModelElementReference modelElemTypeRef, boolean isModifiable, ModelEndpointReference modelTypeEndpointRef) {

		ModelElementReference newModelElemTypeRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		addTypeReference(newModelElemTypeRef, newModelElemType, modelElemTypeRef, isModifiable, false);
		modelTypeEndpointRef.getModelElemRefs().add(newModelElemTypeRef);

		return newModelElemTypeRef;
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

	private static ExtendibleElement removeExtendibleElementType(MultiModel multiModel, String typeUri) {

		return multiModel.getExtendibleTable().removeKey(typeUri);
	}

	/**
	 * Removes a model type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param modelTypeUri
	 *            The model type's uri.
	 */
	private static void removeModelType(MultiModel multiModel, Model modelType) {

		removeExtendibleElementType(multiModel, modelType.getUri());
		multiModel.getModels().remove(modelType);
		List<String> delOperatorTypeUris = new ArrayList<String>();

		// remove model element types
		for (ModelElement modelElementType : modelType.getElements()) {
			removeExtendibleElementType(multiModel, modelElementType.getUri());
		}
		// remove operator types that use this model type
		for (Operator operatorType : multiModel.getOperators()) {
			for (Parameter par : operatorType.getInputs()) {
				if (par.getModel().getUri().equals(modelType.getUri()) && !delOperatorTypeUris.contains(operatorType.getUri())) {
					delOperatorTypeUris.add(operatorType.getUri());
				}
			}
			for (Parameter par : operatorType.getOutputs()) {
				if (par.getModel().getUri().equals(modelType.getUri()) && !delOperatorTypeUris.contains(operatorType.getUri())) {
					delOperatorTypeUris.add(operatorType.getUri());
				}
			}
		}
		for (String operatorTypeUri : delOperatorTypeUris) {
			Operator operatorType = MultiModelRegistry.getExtendibleElement(operatorTypeUri, multiModel);
			removeOperatorType(operatorType);
		}
		// remove model relationship types and endpoints that use this model type
		List<ModelRel> delModelRelTypes = new ArrayList<ModelRel>();
		List<ModelEndpoint> delModelTypeEndpoints = new ArrayList<ModelEndpoint>();
		for (ModelRel modelRelType : MultiModelRegistry.getModelRels(multiModel)) {
			for (ModelEndpoint modelTypeEndpoint : modelRelType.getModelEndpoints()) {
				if (modelTypeEndpoint.getTargetUri().equals(modelType.getUri())) {
					if (modelRelType instanceof BinaryModelRel) {
						if (!delModelRelTypes.contains(modelRelType)) {
							delModelRelTypes.add(modelRelType);
						}
					}
					else {
						delModelTypeEndpoints.add(modelTypeEndpoint);
					}
				}
			}
		}
		for (ModelEndpoint modelTypeEndpoint : delModelTypeEndpoints) {
			removeModelTypeEndpointAndModelTypeEndpointReference(modelTypeEndpoint, true);
		}
		for (ModelRel modelRelType : delModelRelTypes) {
			removeModelRelType(modelRelType);
		}
	}

	/**
	 * Removes a model type and its subtypes from its multimodel.
	 * 
	 * @param modelType
	 *            The model type.
	 */
	public static void removeModelType(Model modelType) {

		MultiModel multiModel = (MultiModel) modelType.eContainer();
		// delete the "thing"
		removeModelType(multiModel, modelType);
		// delete the subtypes of the "thing"
		for (Model modelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelType)) {
			removeModelType(multiModel, modelSubtype);
		}
	}

	private static void removeModelRelType(MultiModel multiModel, ModelRel modelRelType) {

		removeModelType(multiModel, modelRelType);

		// remove model type endpoints
		for (ModelEndpoint modelTypeEndpoint : modelRelType.getModelEndpoints()) {
			removeExtendibleElementType(multiModel, modelTypeEndpoint.getUri());
		}
		// remove link types
		for (Link linkType : modelRelType.getLinks()) {
			removeExtendibleElementType(multiModel, linkType.getUri());
			// remove model element type endpoints
			for (ModelElementEndpoint modelElemTypeEndpoint : linkType.getModelElemEndpoints()) {
				removeExtendibleElementType(multiModel, modelElemTypeEndpoint.getUri());
			}
		}
	}

	public static void removeModelRelType(ModelRel modelRelType) {

		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		// delete the "thing"
		removeModelRelType(multiModel, modelRelType);
		// delete the subtypes of the "thing"
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
			removeModelRelType(multiModel, modelRelSubtype);
		}
	}

	/**
	 * Removes an editor type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param edito
	 *            The editor type's uri.
	 */
	private static Editor removeEditorType(MultiModel multiModel, Editor editorType) {

		removeExtendibleElementType(multiModel, editorType.getUri());
		multiModel.getEditors().remove(editorType);
		Model modelType = MultiModelRegistry.getExtendibleElement(editorType.getModelUri(), multiModel);
		if (modelType != null) {
			modelType.getEditors().remove(editorType);
		}

		return editorType;
	}

	/**
	 * Removes an editor type and its subtypes from its multimodel.
	 * 
	 * @param editorType
	 *            The editor type.
	 */
	public static void removeEditorType(Editor editorType) {

		MultiModel multiModel = (MultiModel) editorType.eContainer();
		removeEditorType(multiModel, editorType);
		for (Editor editorSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, editorType)) {
			removeEditorType(multiModel, editorSubtype);
		}
	}

	/**
	 * Removes an operator type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param uri
	 *            The operator type's uri.
	 */
	private static Operator removeOperatorType(MultiModel multiModel, String uri) {

		Operator operatorType = (Operator) multiModel.getExtendibleTable().removeKey(uri);
		multiModel.getOperators().remove(operatorType);
		// conversion operator
		if (operatorType instanceof ConversionOperator) {
			operatorType.getInputs().get(0).getModel().getConversionOperators().remove(operatorType);
		}

		return operatorType;
	}

	/**
	 * Removes an operator type and its subtypes from its multimodel.
	 * 
	 * @param operatorType
	 *            The operator type.
	 */
	public static void removeOperatorType(Operator operatorType) {

		MultiModel multiModel = (MultiModel) operatorType.eContainer();
		removeOperatorType(multiModel, operatorType.getUri());
		for (Operator operatorSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, operatorType)) {
			removeOperatorType(multiModel, operatorSubtype.getUri());
		}
	}

	private static void removeModelTypeEndpoint(ModelEndpoint modelTypeEndpoint, boolean isFullRemove) {

		ModelRel modelRelType = (ModelRel) modelTypeEndpoint.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		removeExtendibleElementType(multiModel, modelTypeEndpoint.getUri());
		if (isFullRemove) {
			modelRelType.getModelEndpoints().remove(modelTypeEndpoint);
		}
	}

	private static void removeModelTypeEndpointReference(ModelEndpointReference modelTypeEndpointRef, boolean isFullRemove) {

		ModelRel modelRelType = (ModelRel) modelTypeEndpointRef.eContainer();
		// avoid iterating over the list
		while (modelTypeEndpointRef.getModelElemRefs().size() > 0) {
			removeModelElementTypeReference(modelTypeEndpointRef.getModelElemRefs().get(0));
		}
		if (isFullRemove) {
			modelRelType.getModelEndpointRefs().remove(modelTypeEndpointRef);
		}
	}

	public static void removeModelTypeEndpointAndModelTypeEndpointReference(ModelEndpoint modelTypeEndpoint, boolean isFullRemove) {

		ModelRel modelRelType = (ModelRel) modelTypeEndpoint.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		// delete the "thing" and the corresponding reference
		removeModelTypeEndpoint(modelTypeEndpoint, isFullRemove);
		ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpoint.getUri(), modelRelType.getModelEndpointRefs());
		removeModelTypeEndpointReference(modelTypeEndpointRef, isFullRemove);
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpoint.getUri(), modelRelSubtype.getModelEndpointRefs());
			removeModelTypeEndpointReference(modelSubtypeEndpointRef, isFullRemove);
		}
	}

	private static void removeLinkType(ModelRel modelRelType, Link linkType) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		removeExtendibleElementType(multiModel, linkType.getUri());
		for (ModelElementEndpoint modelElemTypeEndpoint : linkType.getModelElemEndpoints()) {
			removeModelElementTypeEndpoint(modelElemTypeEndpoint, false);
		}
		modelRelType.getLinks().remove(linkType);
	}

	private static void removeLinkTypeReference(ModelRel modelRelType, LinkReference linkTypeRef) {

		modelRelType.getLinkRefs().remove(linkTypeRef);
		for (ModelElementEndpointReference modelElemTypeEndpointRef : linkTypeRef.getModelElemEndpointRefs()) {
			modelElemTypeEndpointRef.setModelElemRef(null);
		}
	}

	private static void removeLinkTypeAndLinkTypeReference(ModelRel modelRelType, LinkReference linkTypeRef) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		removeLinkType(modelRelType, linkTypeRef.getObject());
		removeLinkTypeReference(modelRelType, linkTypeRef);
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			removeLinkTypeReference(modelRelSubtype, linkSubtypeRef);
		}
	}

	public static void removeLinkTypeAndLinkTypeReference(LinkReference linkTypeRef) {

		ModelRel modelRelType = (ModelRel) linkTypeRef.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		// delete the "thing" and the corresponding reference
		removeLinkTypeAndLinkTypeReference(modelRelType, linkTypeRef);
		// delete the subtypes of the "thing"
		for (Link linkSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, linkTypeRef.getObject())) {
			ModelRel modelRelTypeOrSubtype = (ModelRel) linkSubtype.eContainer();
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(linkSubtype.getUri(), modelRelTypeOrSubtype.getLinkRefs());
			removeLinkTypeAndLinkTypeReference(modelRelTypeOrSubtype, linkSubtypeRef);
		}
	}

	private static void removeModelElementTypeReference(ModelEndpointReference modelTypeEndpointRef, ModelElementReference modelElemTypeRef) {

		modelTypeEndpointRef.getModelElemRefs().remove(modelElemTypeRef);
	}

	private static void removeModelElementTypeReference(ModelRel modelRelType, ModelElementReference modelElemTypeRef) {

		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) modelElemTypeRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		List<BinaryLinkReference> delLinkTypeRefs = new ArrayList<BinaryLinkReference>();
		List<ModelElementEndpointReference> delModelElemTypeEndpointRefs = new ArrayList<ModelElementEndpointReference>();
		for (ModelElementEndpointReference modelElemTypeEndpointRef : modelElemTypeRef.getModelElemEndpointRefs()) {
			LinkReference linkTypeRef = (LinkReference) modelElemTypeEndpointRef.eContainer();
			// avoid iterating over the list
			if (linkTypeRef instanceof BinaryLinkReference) {
				if (!delLinkTypeRefs.contains(linkTypeRef)) {
					delLinkTypeRefs.add((BinaryLinkReference) linkTypeRef);
				}
			}
			else {
				if (!delModelElemTypeEndpointRefs.contains(modelElemTypeEndpointRef)) {
					delModelElemTypeEndpointRefs.add(modelElemTypeEndpointRef);
				}
			}
		}
		for (BinaryLinkReference linkTypeRef : delLinkTypeRefs) {
			removeLinkTypeAndLinkTypeReference(linkTypeRef);
		}
		for (ModelElementEndpointReference modelElemTypeEndpointRef : delModelElemTypeEndpointRefs) {
			removeModelElementTypeEndpointAndModelElementTypeEndpointReference(modelElemTypeEndpointRef, true);
		}
		removeModelElementTypeReference(modelTypeEndpointRef, modelElemTypeRef);
		// delete references of the "thing" in subtypes of the container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference modelElemSubtypeRef = MultiModelTypeHierarchy.getReference(modelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
			if (modelElemSubtypeRef.getModelElemEndpointRefs().size() == 0) {
				removeModelElementTypeReference(modelSubtypeEndpointRef, modelElemSubtypeRef);
			}
			else {
				boolean newModifiable = true;
				for (ModelElementEndpointReference modelElemTypeEndpointRef : modelElemSubtypeRef.getModelElemEndpointRefs()) {
					LinkReference linkSubtypeRef = (LinkReference) modelElemTypeEndpointRef.eContainer();
					if (!linkSubtypeRef.isModifiable()) {
						newModifiable = false;
						break;
					}
				}
				modelElemSubtypeRef.setModifiable(newModifiable);
			}
		}
	}

	public static void removeModelElementTypeReference(ModelElementReference modelElemTypeRef) {

		ModelRel modelRelType = (ModelRel) modelElemTypeRef.eContainer().eContainer();
		// delete the corresponding reference
		removeModelElementTypeReference(modelRelType, modelElemTypeRef);
		// don't delete the subtypes of the "thing", the model element is not deleted from its metamodel
	}

	private static void removeModelElementTypeEndpoint(ModelElementEndpoint modelElemTypeEndpoint, boolean isFullRemove) {

		Link linkType = (Link) modelElemTypeEndpoint.eContainer();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(linkType);
		removeExtendibleElementType(multiModel, modelElemTypeEndpoint.getUri());
		if (isFullRemove) {
			linkType.getModelElemEndpoints().remove(modelElemTypeEndpoint);
		}
	}

	private static void removeModelElementTypeEndpointReference(Link linkType, ModelElementEndpointReference modelElemTypeEndpointRef, boolean isFullRemove) {

		if (isFullRemove) {
			linkType.getModelElemEndpointRefs().remove(modelElemTypeEndpointRef);
		}
	}

	private static void removeModelElementTypeEndpointReference(ModelElementEndpointReference modelElemTypeEndpointRef, boolean isFullRemove) {

		LinkReference linkTypeRef = (LinkReference) modelElemTypeEndpointRef.eContainer();
		if (isFullRemove) {
			modelElemTypeEndpointRef.setModelElemRef(null);
			linkTypeRef.getModelElemEndpointRefs().remove(modelElemTypeEndpointRef);
		}
	}

	public static void removeModelElementTypeEndpointAndModelElementTypeEndpointReference(ModelElementEndpointReference modelElemTypeEndpointRef, boolean isFullRemove) {

		LinkReference linkTypeRef = (LinkReference) modelElemTypeEndpointRef.eContainer();
		ModelRel modelRelType = (ModelRel) linkTypeRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		// delete the "thing" and the corresponding reference
		removeModelElementTypeEndpoint(modelElemTypeEndpointRef.getObject(), isFullRemove);
		removeModelElementTypeEndpointReference(linkTypeRef.getObject(), modelElemTypeEndpointRef, isFullRemove);
		removeModelElementTypeEndpointReference(modelElemTypeEndpointRef, isFullRemove);
		// delete references of the "thing" in subtypes of the container's container
		for (ModelRel modelRelSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, modelRelType)) {
			LinkReference linkSubtypeRef = MultiModelTypeHierarchy.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = MultiModelTypeHierarchy.getReference(modelElemTypeEndpointRef, linkSubtypeRef.getModelElemEndpointRefs());
			removeModelElementTypeEndpointReference(modelElemSubtypeEndpointRef, isFullRemove);
		}
		// delete references of the "thing" in subtypes of the container
		for (Link linkSubtype : MultiModelTypeHierarchy.getSubtypes(multiModel, linkTypeRef.getObject())) {
			removeModelElementTypeEndpointReference(linkSubtype, modelElemTypeEndpointRef, isFullRemove);
		}
	}

}