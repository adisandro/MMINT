/*
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
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelConstraint;
import edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
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
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelHierarchyUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;

/**
 * The factory for modifications to the type multimodel.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeFactory {

	protected static void addExtendibileElementType(ExtendibleElement newType, ExtendibleElement type, String newTypeUri, String newTypeName, MultiModel multiModel) throws MMTFException {

		if (multiModel.getExtendibleTable().containsKey(newTypeUri)) {
			throw new MMTFException("Extendible type with uri " + newTypeUri + " is already in the type MID");
		}

		newType.setUri(newTypeUri);
		newType.setName(newTypeName);
		newType.setLevel(MidLevel.TYPES);
		newType.setSupertype(type);
		multiModel.getExtendibleTable().put(newTypeUri, newType);
	}

	public static void addExtendibleElementTypeEndpointCardinality(ExtendibleElementEndpoint elementTypeEndpoint, int lowerBound, int upperBound) {

		elementTypeEndpoint.setLowerBound(lowerBound);
		elementTypeEndpoint.setUpperBound(upperBound);
	}

	protected static void addExtendibleElementTypeEndpoint(ExtendibleElementEndpoint newElementTypeEndpoint, ExtendibleElement newElementType) {

		newElementTypeEndpoint.setTarget(newElementType);
		addExtendibleElementTypeEndpointCardinality(newElementTypeEndpoint, 1, 1);
	}

	protected static void addExtendibleElementTypeReference(ExtendibleElementReference newElementTypeRef, ExtendibleElementReference elementTypeRef, ExtendibleElement newElementType, boolean isModifiable, boolean isContainer) {

		if (isContainer) {
			newElementTypeRef.setContainedObject(newElementType);
		}
		else {
			newElementTypeRef.setReferencedObject(newElementType);
		}
		newElementTypeRef.setModifiable(isModifiable);
		newElementTypeRef.setSupertypeRef(elementTypeRef);
	}

	protected static void addModelType(Model newModelType, String constraint, MultiModel multiModel) {

		ModelConstraint modelConstraint = MidFactory.eINSTANCE.createModelConstraint();
		modelConstraint.setBody(constraint);
		modelConstraint.setEngine(ModelConstraintEngine.OCL);
		newModelType.setConstraint(modelConstraint);

		multiModel.getModels().add(newModelType);
	}

	protected static void addModelElementType(Model modelType, ModelElement newModelElemType, ModelElementCategory category, String classLiteral) {

		newModelElemType.setCategory(category);
		newModelElemType.setClassLiteral(classLiteral);

		modelType.getElements().add(newModelElemType);
	}

	protected static void addModelRelType(ModelRel newModelRelType, ModelRel modelRelType) {

		if (MultiModelConstraintChecker.isRootType(modelRelType)) {
			return;
		}

		// copy model type references
		Iterator<ModelEndpointReference> modelTypeEndpointRefIter = MultiModelHierarchyUtils.getTypeRefHierarchyIterator(modelRelType.getModelEndpointRefs());
		while (modelTypeEndpointRefIter.hasNext()) {
			ModelEndpointReference modelTypeEndpointRefSuper = modelTypeEndpointRefIter.next();
			ModelEndpointReference modelTypeEndpointRef = MultiModelHierarchyUtils.getReference(modelTypeEndpointRefSuper.getSupertypeRef(), newModelRelType.getModelEndpointRefs());
			ModelEndpointReference newModelTypeEndpointRef = createModelTypeEndpointReference(
				newModelRelType,
				modelTypeEndpointRef,
				modelTypeEndpointRefSuper.getObject(),
				false,
				false
			);
			// copy model element type references
			Iterator<ModelElementReference> modelElemTypeRefIter = MultiModelHierarchyUtils.getTypeRefHierarchyIterator(modelTypeEndpointRefSuper.getModelElemRefs());
			while (modelElemTypeRefIter.hasNext()) {
				ModelElementReference modelElemTypeRefSuper = modelElemTypeRefIter.next();
				ModelElementReference modelElemTypeRef = MultiModelHierarchyUtils.getReference(modelElemTypeRefSuper.getSupertypeRef(), newModelTypeEndpointRef.getModelElemRefs());
				createModelElementTypeReference(
					newModelTypeEndpointRef,
					modelElemTypeRef,
					modelElemTypeRefSuper.getObject(),
					false
				);
			}
		}
		// copy link type references
		Iterator<LinkReference> linkTypeRefIter = MultiModelHierarchyUtils.getTypeRefHierarchyIterator(modelRelType.getLinkRefs());
		while (linkTypeRefIter.hasNext()) {
			LinkReference linkTypeRefSuper = linkTypeRefIter.next();
			LinkReference linkTypeRef = MultiModelHierarchyUtils.getReference(linkTypeRefSuper.getSupertypeRef(), newModelRelType.getLinkRefs());
			LinkReference newLinkTypeRef = createLinkTypeReference(
				newModelRelType,
				linkTypeRef,
				linkTypeRefSuper.getObject(),
				linkTypeRefSuper.eClass(),
				false
			);
			// connect it to model element type references (takes care of binary too)
			Iterator<ModelElementEndpointReference> modelElemTypeEndpointRefIter = MultiModelHierarchyUtils.getTypeRefHierarchyIterator(linkTypeRefSuper.getModelElemEndpointRefs());
			while (modelElemTypeEndpointRefIter.hasNext()) {
				ModelElementEndpointReference modelElemTypeEndpointRefSuper = modelElemTypeEndpointRefIter.next();
				ModelElementEndpointReference modelElemTypeEndpointRef = null;
				ModelElementEndpointReference modelElemTypeEndpointRefSuper2 = modelElemTypeEndpointRefSuper.getSupertypeRef();
				if (modelElemTypeEndpointRefSuper2 != null) {
					LinkReference linkTypeRefSuper2 = (LinkReference) modelElemTypeEndpointRefSuper2.eContainer();
					LinkReference linkTypeRef2 = MultiModelHierarchyUtils.getReference(linkTypeRefSuper2, newModelRelType.getLinkRefs());
					modelElemTypeEndpointRef = MultiModelHierarchyUtils.getReference(modelElemTypeEndpointRefSuper2, linkTypeRef2.getModelElemEndpointRefs());
				}
				ModelElementReference modelElemTypeRefSuper = modelElemTypeEndpointRefSuper.getModelElemRef();
				ModelEndpointReference modelTypeEndpointRef = MultiModelHierarchyUtils.getReference((ModelEndpointReference) modelElemTypeRefSuper.eContainer(), newModelRelType.getModelEndpointRefs());
				ModelElementReference newModelElemTypeRef = MultiModelHierarchyUtils.getReference(modelElemTypeRefSuper, modelTypeEndpointRef.getModelElemRefs());
				createModelElementTypeEndpointReference(newLinkTypeRef, modelElemTypeEndpointRef, modelElemTypeEndpointRefSuper.getObject(), newModelElemTypeRef, false, false);
			}
		}
	}

	protected static void addModelTypeEndpoint(ModelRel modelRelType, ModelEndpoint newModelTypeEndpoint, Model newModelType, boolean isBinarySrc) {

		addExtendibleElementTypeEndpoint(newModelTypeEndpoint, newModelType);
		if (isBinarySrc) {
			modelRelType.getModelEndpoints().add(0, newModelTypeEndpoint);
		}
		else {
			modelRelType.getModelEndpoints().add(newModelTypeEndpoint);
		}
	}

	protected static void addLinkType(ModelRel modelRelType, Link newLinkType, Link linkType) {

		// keep track of inherited model elements, but not root ones
		if (linkType != null && !linkType.getUri().equals(MMTF.ROOT_MODELREL_LINK_URI)) {
			for (ModelElementEndpointReference modelElemTypeEndpointRef : linkType.getModelElemEndpointRefs()) {
				newLinkType.getModelElemEndpointRefs().add(modelElemTypeEndpointRef);
			}
		}

		modelRelType.getLinks().add(newLinkType);
	}

	protected static void addModelElementTypeEndpoint(Link linkType, ModelElementEndpoint newModelElemTypeEndpoint, ModelElement newModelElemType, boolean isBinarySrc) {

		addExtendibleElementTypeEndpoint(newModelElemTypeEndpoint, newModelElemType);
		if (isBinarySrc) {
			linkType.getModelElemEndpoints().add(0, newModelElemTypeEndpoint);
		}
		else {
			linkType.getModelElemEndpoints().add(newModelElemTypeEndpoint);
		}
	}

	protected static void addModelElementTypeEndpointReference(Link linkType, ModelElementEndpointReference newModelElemTypeEndpointRef) {

		linkType.getModelElemEndpointRefs().add(newModelElemTypeEndpointRef);
	}

	protected static void addEditorType(Editor newEditorType, String modelTypeUri, String editorId, String wizardId, MultiModel multiModel) {

		newEditorType.setModelUri(modelTypeUri);
		newEditorType.setId(editorId);
		newEditorType.setWizardId(wizardId);

		multiModel.getEditors().add(newEditorType);
	}

	protected static void addModelTypeEditor(Editor editorType, Model modelType) {

		modelType.getEditors().add(editorType);
	}

	protected static void addOperatorType(Operator newOperatorType, OperatorExecutable executable, MultiModel multiModel) {

		newOperatorType.setExecutable(executable);
		multiModel.getOperators().add(newOperatorType);
	}

	protected static void addOperatorTypeParameter(Parameter newParamType, Operator operatorType, EList<Parameter> paramTypes, Model modelType, String newParamTypeName, boolean isVararg) {

		newParamType.setModel(modelType);
		newParamType.setName(newParamTypeName);
		newParamType.setVararg(isVararg);
		paramTypes.add(newParamType);
		operatorType.getSignatureTable().put(newParamTypeName, newParamType);
	}

	public static ModelEndpointReference createModelTypeEndpointReference(ModelRel modelRelType, ModelEndpointReference modelTypeEndpointRef, ModelEndpoint newModelTypeEndpoint, boolean isModifiable, boolean isBinarySrc) {

		ModelEndpointReference newModelTypeEndpointRef = RelationshipFactory.eINSTANCE.createModelEndpointReference();
		addExtendibleElementTypeReference(newModelTypeEndpointRef, modelTypeEndpointRef, newModelTypeEndpoint, isModifiable, false);

		if (isBinarySrc) {
			modelRelType.getModelEndpointRefs().add(0, newModelTypeEndpointRef);
		}
		else {
			modelRelType.getModelEndpointRefs().add(newModelTypeEndpointRef);
		}

		return newModelTypeEndpointRef;
	}

	public static LinkReference createLinkTypeReference(ModelRel modelRelType, LinkReference linkTypeRef, Link newLinkType, EClass newLinkTypeRefClass, boolean isModifiable) {

		LinkReference newLinkTypeRef = (LinkReference) RelationshipFactory.eINSTANCE.create(newLinkTypeRefClass);
		addExtendibleElementTypeReference(newLinkTypeRef, linkTypeRef, newLinkType, isModifiable, false);
		modelRelType.getLinkRefs().add(newLinkTypeRef);

		return newLinkTypeRef;
	}

	public static ModelElementEndpointReference createModelElementTypeEndpointReference(LinkReference linkTypeRef, ModelElementEndpointReference modelElemTypeEndpointRef, ModelElementEndpoint newModelElemTypeEndpoint, ModelElementReference newModelElemTypeRef, boolean isModifiable, boolean isBinarySrc) {

		ModelElementEndpointReference newModelElemTypeEndpointRef = RelationshipFactory.eINSTANCE.createModelElementEndpointReference();
		addExtendibleElementTypeReference(newModelElemTypeEndpointRef, modelElemTypeEndpointRef, newModelElemTypeEndpoint, isModifiable, false);
		newModelElemTypeEndpointRef.setModelElemRef(newModelElemTypeRef);

		if (isBinarySrc) {
			linkTypeRef.getModelElemEndpointRefs().add(0, newModelElemTypeEndpointRef);
		}
		else {
			linkTypeRef.getModelElemEndpointRefs().add(newModelElemTypeEndpointRef);
		}

		return newModelElemTypeEndpointRef;
	}

	public static ModelElementReference createModelElementTypeReference(ModelEndpointReference modelTypeEndpointRef, ModelElementReference modelElemTypeRef, ModelElement newModelElemType, boolean isModifiable) {

		ModelElementReference newModelElemTypeRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		addExtendibleElementTypeReference(newModelElemTypeRef, modelElemTypeRef, newModelElemType, isModifiable, false);
		modelTypeEndpointRef.getModelElemRefs().add(newModelElemTypeRef);

		return newModelElemTypeRef;
	}

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
		ArrayList<String> delOperatorTypeUris = new ArrayList<String>();

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
			Operator operatorType = MultiModelTypeRegistry.getOperatorType(multiModel, operatorTypeUri);
			removeOperatorType(operatorType);
		}
		// remove model relationship types and endpoints that use this model type
		ArrayList<ModelRel> delModelRelTypes = new ArrayList<ModelRel>();
		ArrayList<ModelEndpoint> delModelTypeEndpoints = new ArrayList<ModelEndpoint>();
		for (ModelRel modelRelType : MultiModelTypeRegistry.getModelRelTypes(multiModel)) {
			for (ModelEndpoint modelTypeEndpoint : modelRelType.getModelEndpoints()) {
				if (modelTypeEndpoint.getTargetUri().equals(modelType.getUri())) {
					if (modelRelType instanceof BinaryModelRel && !delModelRelTypes.contains(modelRelType)) {
						delModelRelTypes.add(modelRelType);
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
		for (String modelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelType)) {
			Model modelSubtype = MultiModelRegistry.getModel(multiModel, modelSubtypeUri);
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
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelRegistry.getModelRel(multiModel, modelRelSubtypeUri);
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
		Model modelType = MultiModelRegistry.getModel(multiModel, editorType.getModelUri());
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
		for (String editorSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, editorType)) {
			Editor editorSubtype = MultiModelRegistry.getEditorType(multiModel, editorSubtypeUri);
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
		for (String operatorSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, operatorType)) {
			removeOperatorType(multiModel, operatorSubtypeUri);
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
		ModelEndpointReference modelTypeEndpointRef = MultiModelHierarchyUtils.getReference(modelTypeEndpoint.getUri(), modelRelType.getModelEndpointRefs());
		removeModelTypeEndpointReference(modelTypeEndpointRef, isFullRemove);
		// delete references of the "thing" in subtypes of the container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelRegistry.getModelRel(multiModel, modelRelSubtypeUri);
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelHierarchyUtils.getReference(modelTypeEndpoint.getUri(), modelRelSubtype.getModelEndpointRefs());
			removeModelTypeEndpointReference(modelSubtypeEndpointRef, isFullRemove);
		}
	}

	private static void removeLinkType(ModelRel modelRelType, Link linkType) {

		modelRelType.getLinks().remove(linkType);
	}

	private static void removeLinkTypeReference(ModelRel modelRelType, LinkReference linkTypeRef) {

		modelRelType.getLinkRefs().remove(linkTypeRef);
		for (ModelElementEndpointReference modelElemTypeEndpointRef : linkTypeRef.getModelElemEndpointRefs()) {
			modelElemTypeEndpointRef.setModelElemRef(null);
		}
	}

	private static void removeLinkTypeAndLinkTypeReference(ModelRel modelRelType, LinkReference linkTypeRef) {

		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		Link linkType = (Link) removeExtendibleElementType(multiModel, linkTypeRef.getUri());
		removeLinkType(modelRelType, linkType);
		removeLinkTypeReference(modelRelType, linkTypeRef);
		// delete references of the "thing" in subtypes of the container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelRegistry.getModelRel(multiModel, modelRelSubtypeUri);
			LinkReference linkSubtypeRef = MultiModelHierarchyUtils.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			removeLinkTypeReference(modelRelSubtype, linkSubtypeRef);
		}
	}

	public static void removeLinkTypeAndLinkTypeReference(LinkReference linkTypeRef) {

		ModelRel modelRelType = (ModelRel) linkTypeRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		// delete the "thing" and the corresponding reference
		removeLinkTypeAndLinkTypeReference(modelRelType, linkTypeRef);
		// delete the subtypes of the "thing"
		for (String linkSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, linkTypeRef.getObject())) {
			Link linkSubtype = MultiModelTypeRegistry.getLinkType(multiModel, linkSubtypeUri);
			ModelRel modelRelTypeOrSubtype = (ModelRel) linkSubtype.eContainer();
			LinkReference linkSubtypeRef = MultiModelHierarchyUtils.getReference(linkSubtype.getUri(), modelRelTypeOrSubtype.getLinkRefs());
			removeLinkTypeAndLinkTypeReference(modelRelTypeOrSubtype, linkSubtypeRef);
		}
	}

	private static void removeModelElementTypeReference(ModelEndpointReference modelTypeEndpointRef, ModelElementReference modelElemTypeRef) {

		modelTypeEndpointRef.getModelElemRefs().remove(modelElemTypeRef);
	}

	private static void removeModelElementTypeReference(ModelRel modelRelType, ModelElementReference modelElemTypeRef) {

		ModelEndpointReference modelTypeEndpointRef = (ModelEndpointReference) modelElemTypeRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		EList<BinaryLinkReference> linkTypeRefsToDelete = new BasicEList<BinaryLinkReference>();
		for (ModelElementEndpointReference modelElemTypeEndpointRef : modelElemTypeRef.getModelElemEndpointRefs()) {
			LinkReference linkTypeRef = (LinkReference) modelElemTypeEndpointRef.eContainer();
			if (linkTypeRef instanceof BinaryLinkReference) {
				// avoid iterating over the list
				linkTypeRefsToDelete.add((BinaryLinkReference) linkTypeRef);
			}
			else {
				removeModelElementTypeEndpointAndModelElementTypeEndpointReference(modelElemTypeEndpointRef, true);
			}
		}
		for (BinaryLinkReference linkTypeRef : linkTypeRefsToDelete) {
			removeLinkTypeAndLinkTypeReference(linkTypeRef);
		}
		removeModelElementTypeReference(modelTypeEndpointRef, modelElemTypeRef);
		// delete references of the "thing" in subtypes of the container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelRegistry.getModelRel(multiModel, modelRelSubtypeUri);
			ModelEndpointReference modelSubtypeEndpointRef = MultiModelHierarchyUtils.getReference(modelTypeEndpointRef, modelRelSubtype.getModelEndpointRefs());
			ModelElementReference modelElemSubtypeRef = MultiModelHierarchyUtils.getReference(modelElemTypeRef, modelSubtypeEndpointRef.getModelElemRefs());
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

	private static void removeModelElementTypeEndpoint(ModelElementEndpointReference modelElemTypeEndpointRef, boolean isFullRemove) {

		ModelElementEndpoint modelElemTypeEndpoint = modelElemTypeEndpointRef.getObject();
		Link linkType = (Link) modelElemTypeEndpoint.eContainer();
		MultiModel multiModel = (MultiModel) linkType.eContainer().eContainer();
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
		removeModelElementTypeEndpoint(modelElemTypeEndpointRef, isFullRemove);
		removeModelElementTypeEndpointReference(linkTypeRef.getObject(), modelElemTypeEndpointRef, isFullRemove);
		removeModelElementTypeEndpointReference(modelElemTypeEndpointRef, isFullRemove);
		// delete references of the "thing" in subtypes of the container's container
		for (String modelRelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, modelRelType)) {
			ModelRel modelRelSubtype = MultiModelRegistry.getModelRel(multiModel, modelRelSubtypeUri);
			LinkReference linkSubtypeRef = MultiModelHierarchyUtils.getReference(linkTypeRef, modelRelSubtype.getLinkRefs());
			ModelElementEndpointReference modelElemSubtypeEndpointRef = MultiModelHierarchyUtils.getReference(modelElemTypeEndpointRef, linkSubtypeRef.getModelElemEndpointRefs());
			removeModelElementTypeEndpointReference(modelElemSubtypeEndpointRef, isFullRemove);
		}
		// delete references of the "thing" in subtypes of the container
		for (String linkSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(multiModel, linkTypeRef.getObject())) {
			Link linkSubtype = MultiModelTypeRegistry.getLinkType(multiModel, linkSubtypeUri);
			removeModelElementTypeEndpointReference(linkSubtype, modelElemTypeEndpointRef, isFullRemove);
		}
	}

}