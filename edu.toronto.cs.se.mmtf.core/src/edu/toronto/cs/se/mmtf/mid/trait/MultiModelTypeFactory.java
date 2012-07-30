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
package edu.toronto.cs.se.mmtf.mid.trait;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelConstraint;
import edu.toronto.cs.se.mmtf.mid.ModelConstraintEngine;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;
import edu.toronto.cs.se.mmtf.mid.editor.EditorFactory;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.Parameter;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryLink;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipFactory;

/**
 * The factory for modifications to the type multimodel.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeFactory {

	private static void addLightExtendibleType(ExtendibleElement newType, ExtendibleElement type, String newTypeUriFragment, String newTypeName, MultiModel multiModel) throws MMTFException {

		// uri
		String uri = (type == null) ?
			MultiModelTypeRegistry.getRootTypeUri(newType) :
			type.getUri();
		String newUri = uri + "/" + newTypeUriFragment;
		if (multiModel.getExtendibleTable().containsKey(newUri)) {
			throw new MMTFException("Extendible type's URI " + newUri + " is already registered");
		}
		newType.setUri(newUri);

		// basic attributes
		newType.setName(newTypeName);
		newType.setLevel(MidLevel.TYPES);
		newType.setDynamic(true);

		// supertype
		newType.setSupertype(type);

		multiModel.getExtendibleTable().put(newUri, newType);
	}

	private static void addLightModelType(Model newModelType, Model modelType, String newModelTypeName, String constraint) throws MMTFException {

		// create
		MultiModel multiModel = (MultiModel) modelType.eContainer();
		addLightExtendibleType(newModelType, modelType, newModelTypeName, newModelTypeName, multiModel);

		// set specific attributes
		newModelType.setOrigin(ModelOrigin.CREATED);
		ModelConstraint modelConstraint = MidFactory.eINSTANCE.createModelConstraint();
		modelConstraint.setBody(constraint);
		modelConstraint.setEngine(ModelConstraintEngine.OCL);
		newModelType.setConstraint(modelConstraint);

		// copy attributes from supertype
		newModelType.setFileExtension(modelType.getFileExtension());

		// create new editors
		for (Editor editorType : modelType.getEditors()) {
			Editor newEditorType = (Editor) EditorFactory.eINSTANCE.create(editorType.eClass());
			try {
				addLightExtendibleType(newEditorType, editorType, newModelTypeName, editorType.getName(), multiModel);
			}
			catch (MMTFException e) {
				// unfortunately models created through this editor will have the supermodel as static type
				newModelType.getEditors().add(editorType);
				continue;
			}
			newEditorType.setModelUri(newModelType.getUri());
			newEditorType.setId(editorType.getId());
			newEditorType.setWizardId(editorType.getWizardId());
			multiModel.getEditors().add(newEditorType);
			newModelType.getEditors().add(newEditorType);
			newEditorType.getFileExtensions().addAll(editorType.getFileExtensions());
		}

		// register light model type
		multiModel.getModels().add(newModelType);
	}

	public static Model createLightModelType(Model modelType, String newModelTypeName, String constraint) throws MMTFException {

		Model newModelType = MidFactory.eINSTANCE.createModel();
		addLightModelType(newModelType, modelType, newModelTypeName, constraint);

		return newModelType;
	}

	public static ModelReference createLightModelTypeRef(ModelRel modelRelType, Model modelType) {

		ModelReference newModelTypeRef = RelationshipFactory.eINSTANCE.createModelReference();
		newModelTypeRef.setReferencedObject(modelType);
		modelRelType.getModelRefs().add(newModelTypeRef);

		return newModelTypeRef;
	}

	public static ModelRel createLightModelRelType(ModelRel modelRelType, Model srcModelType, Model tgtModelType, String newModelRelTypeName, String constraint, EClass modelRelTypeClass) throws MMTFException {

		ModelRel newModelRelType = (ModelRel) RelationshipFactory.eINSTANCE.create(modelRelTypeClass);
		addLightModelType(newModelRelType, modelRelType, newModelRelTypeName, constraint);
		//TODO MMTF: how to make the user choose unbounded?
		newModelRelType.setUnbounded(modelRelType.isUnbounded());

		//TODO MMTF: decide what to do when inheriting here
		// models and containers
		if (srcModelType != null && tgtModelType != null) { // binary model relationship type
			newModelRelType.getModels().add(srcModelType);
			ModelReference newSrcModelTypeRef = createLightModelTypeRef(newModelRelType, srcModelType);
//				for (ModelReference modelTypeRef : modelRelType.getModelRefs()) {
//					if (isSubtypeOf(srcModelType.getUri(), ((Model) modelTypeRef.getObject()).getUri())) {
//						for (ModelElementReference modelElemTypeRef : modelTypeRef.getElementRefs()) {
//							ModelElement modelElemType = (ModelElement) modelElemTypeRef.getObject();
//							createLightModelElementType(newSrcModelTypeRef, "Src" + modelElemType.getName(), modelElemType.getPointer());
//						}
//						break;
//					}
//				}
			newModelRelType.getModels().add(tgtModelType);
			ModelReference newTgtModelTypeRef = createLightModelTypeRef(newModelRelType, tgtModelType);
//				for (ModelReference modelTypeRef : modelRelType.getModelRefs()) {
//					if (isSubtypeOf(tgtModelType.getUri(), ((Model) modelTypeRef.getObject()).getUri())) {
//						for (ModelElementReference modelElemTypeRef : modelTypeRef.getElementRefs()) {
//							ModelElement modelElemType = (ModelElement) modelElemTypeRef.getObject();
//							createLightModelElementType(newTgtModelTypeRef, "Tgt" + modelElemType.getName(), modelElemType.getPointer());
//						}
//						break;
//					}
//				}
		}
		else {
			for (ModelReference modelTypeRef : modelRelType.getModelRefs()) {
				Model modelType = (Model) modelTypeRef.getObject();
				newModelRelType.getModels().add(modelType);
				ModelReference newModelTypeRef = createLightModelTypeRef(newModelRelType, modelType);
				// model elements
//					for (ModelElementReference modelElemTypeRef : modelTypeRef.getElementRefs()) {
//						ModelElement modelElemType = (ModelElement) modelElemTypeRef.getObject();
//						createLightModelElementType(newModelTypeRef, modelElemType.getName(), modelElemType.getPointer());
//					}
			}
		}

		// links
//			for (Link linkType : modelRelType.getLinks()) {
//				Link newLinkType = createLightLinkType(newModelRelType, null, null, linkType.getName(), linkType.eClass());
//				newLinkType.setUnbounded(linkType.isUnbounded());
//				// link elements
//				for (ModelElementReference modelElemTypeRef : linkType.getElementRefs()) {
//					for (ModelReference newModelTypeRef : newModelRelType.getModelRefs()) {
//						for (ModelElementReference newModelElemTypeRef : newModelTypeRef.getElementRefs()) {
//							if (
//								newModelElemTypeRef.getName().equals(modelElemTypeRef.getName()) || (
//									(srcModelType != null && tgtModelType != null) && (
//										newModelElemTypeRef.getName().equals("Src" + modelElemTypeRef.getName()) ||
//										newModelElemTypeRef.getName().equals("Tgt" + modelElemTypeRef.getName())
//									)
//								)
//							) {
//								newLinkType.getElementRefs().add(newModelElemTypeRef);
//							}
//						}
//					}
//				}
//			}

		return newModelRelType;
	}

	public static ModelElementReference createLightModelElementType(ModelReference modelTypeRef, String newModelElemTypeName, EObject droppedElement) throws MMTFException {

		ModelRel modelRelType = (ModelRel) modelTypeRef.eContainer();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		Model modelType = (Model) modelTypeRef.getObject();

		// always create model element, it is specific of the model relationship type even if another one uses the same dropped element
		ModelElement newModelElemType = MidFactory.eINSTANCE.createModelElement();
		ModelElementCategory category = (droppedElement instanceof EReference) ?
			ModelElementCategory.RELATIONSHIP :
			ModelElementCategory.ENTITY;
		String classLiteral = MultiModelTypeRegistry.getDroppedElementClassLiteral(MidLevel.TYPES, droppedElement);
		newModelElemType.setCategory(category);
		newModelElemType.setClassLiteral(classLiteral);
		//TODO MMTF: think about next assignment
		newModelElemTypeName = classLiteral;
		addLightExtendibleType(newModelElemType, null, modelRelType.getName() + "/" + newModelElemTypeName, newModelElemTypeName, multiModel);
		modelType.getElements().add(newModelElemType);

		// create model element reference
		ModelElementReference newModelElemTypeRef = RelationshipFactory.eINSTANCE.createModelElementReference();
		newModelElemTypeRef.setReferencedObject(newModelElemType); // standalone model relationship here don't exist
		modelTypeRef.getElementRefs().add(newModelElemTypeRef);

		return newModelElemTypeRef;
	}

	public static Link createLightLinkType(ModelRel modelRelType, ModelElementReference srcModelElemTypeRef, ModelElementReference tgtModelElemTypeRef, String newLinkTypeName, EClass newLinkTypeClass) throws MMTFException {

		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		Link newLinkType = (Link) RelationshipFactory.eINSTANCE.create(newLinkTypeClass);
		addLightExtendibleType(newLinkType, null, modelRelType.getName() + "/" + newLinkTypeName, newLinkTypeName, multiModel);
		//TODO MMTF: how to make the user choose unbounded?
		newLinkType.setUnbounded(true);
		modelRelType.getLinks().add(newLinkType);

		// binary link type
		if (srcModelElemTypeRef != null && tgtModelElemTypeRef != null) {
			newLinkType.getElementRefs().add(srcModelElemTypeRef);
			newLinkType.getElementRefs().add(tgtModelElemTypeRef);
		}

		return newLinkType;
	}

	/**
	 * Removes a model type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param uri
	 *            The model type's uri.
	 */
	private static ExtendibleElement removeModelType(MultiModel multiModel, String uri) {

		ExtendibleElement removedType = multiModel.getExtendibleTable().removeKey(uri);
		if (removedType != null && removedType instanceof Model) {

			ArrayList<String> delOperatorTypeUris = new ArrayList<String>();
			ArrayList<String> delModelRelTypeUris = new ArrayList<String>();
			ArrayList<String> delModelRelTypeModelUris = new ArrayList<String>();
			Model modelType = (Model) removedType;
			multiModel.getModels().remove(modelType);

			// remove model element types
			for (ModelElement modelElementType : modelType.getElements()) {
				multiModel.getExtendibleTable().removeKey(modelElementType.getUri());
			}

			// remove model relationship type specific structures
			if (modelType instanceof ModelRel) {
				for (Link linkType : ((ModelRel) modelType).getLinks()) {
					multiModel.getExtendibleTable().removeKey(linkType.getUri());
				}
			}

			// remove operator types that use the model type
			for (Operator operatorType : multiModel.getOperators()) {
				for (Parameter par : operatorType.getInputs()) {
					if (par.getModel().getUri().equals(uri) && !delOperatorTypeUris.contains(operatorType.getUri())) {
						delOperatorTypeUris.add(operatorType.getUri());
					}
				}
				for (Parameter par : operatorType.getOutputs()) {
					if (par.getModel().getUri().equals(uri) && !delOperatorTypeUris.contains(operatorType.getUri())) {
						delOperatorTypeUris.add(operatorType.getUri());
					}
				}
			}
			for (String operatorTypeUri : delOperatorTypeUris) {
				Operator operatorType = MultiModelTypeRegistry.getOperatorType(multiModel, operatorTypeUri);
				removeOperatorType(operatorType);
			}

			// remove model relationship types that use this model type
			for (Model modelRelType : multiModel.getModels()) {
				if (modelRelType instanceof ModelRel) {
					if (((ModelRel) modelRelType).getModels().contains(modelType)) {
						if (modelRelType instanceof BinaryModelRel) {
							delModelRelTypeUris.add(modelRelType.getUri());
						}
						else {
							delModelRelTypeModelUris.add(modelRelType.getUri());
						}
					}
				}
			}
			for (String modelRelTypeUri : delModelRelTypeModelUris) {
				ModelRel modelRelType = MultiModelTypeRegistry.getModelRelType(multiModel, modelRelTypeUri);
				if (modelRelType != null) {
					removeLightModelTypeRef(modelRelType, modelType);
					modelRelType.getModels().remove(modelType);
				}
			}
			for (String modelRelTypeUri : delModelRelTypeUris) {
				ModelRel modelRelType = MultiModelTypeRegistry.getModelRelType(multiModel, modelRelTypeUri);
				if (modelRelType != null) {
					removeModelType(modelRelType);
				}
			}
		}

		return removedType;
	}

	/**
	 * Removes a model type and its subtypes from its multimodel.
	 * 
	 * @param modelType
	 *            The model type.
	 */
	public static void removeModelType(Model modelType) {

		MultiModel multiModel = (MultiModel) modelType.eContainer();
		ExtendibleElement removedModelType = removeModelType(multiModel, modelType.getUri());
		if (removedModelType != null) {
			for (String modelSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(removedModelType)) {
				removeModelType(multiModel, modelSubtypeUri);
			}
		}
	}

	/**
	 * Removes an editor type from a multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel.
	 * @param uri
	 *            The editor type's uri.
	 */
	private static ExtendibleElement removeEditorType(MultiModel multiModel, String uri) {

		ExtendibleElement removedType = multiModel.getExtendibleTable().removeKey(uri);
		if (removedType != null && removedType instanceof Editor) {
			Editor editorType = (Editor) removedType;
			multiModel.getEditors().remove(editorType);
			Model modelType = MultiModelTypeRegistry.getModelType(multiModel, editorType.getModelUri());
			if (modelType != null) {
				modelType.getEditors().remove(editorType);
			}
		}

		return removedType;
	}

	/**
	 * Removes an editor type and its subtypes from its multimodel.
	 * 
	 * @param editorType
	 *            The editor type.
	 */
	public static void removeEditorType(Editor editorType) {

		MultiModel multiModel = (MultiModel) editorType.eContainer();
		ExtendibleElement removedEditorType = removeEditorType(multiModel, editorType.getUri());
		if (removedEditorType != null) {
			for (String editorSubtypeUri : MultiModelTypeRegistry.getSubtypeUris(removedEditorType)) {
				removeEditorType(multiModel, editorSubtypeUri);
			}
		}
	}

	/**
	 * Removes an operator type from the multimodel.
	 * 
	 * @param uri
	 *            The operator type to be removed.
	 */
	public static Operator removeOperatorType(Operator operator) {

		String uri = operator.getUri();
		MultiModel multiModel = (MultiModel) operator.eContainer();
		
		ExtendibleElement elementType = multiModel.getExtendibleTable().removeKey(uri);
		Operator operatorType = null;

		if (elementType != null && elementType instanceof Operator) {
			operatorType = (Operator) elementType;
			multiModel.getOperators().remove(operatorType);
			// conversion operator
			if (operatorType instanceof ConversionOperator) {
				operatorType.getInputs().get(0).getModel().getConversionOperators().remove(operatorType);
			}
		}

		return operatorType;
	}

	public static void removeLightModelTypeRef(ModelRel modelRelType, Model modelType) {
		ArrayList<ModelReference> delModelRefs = new ArrayList<ModelReference>();
		MultiModel multiModel = (MultiModel) modelRelType.eContainer();
		//TODO MMTF: if I enable binary rels to self how can I distinguish the right model ref to delete (every ref must be bidirectional)
		for (ModelReference modelTypeRef : modelRelType.getModelRefs()) {
			if (modelTypeRef.getObject() == modelType) {
				delModelRefs.add(modelTypeRef);
				ArrayList<Link> delLinkTypes = new ArrayList<Link>();
				for (ModelElementReference modelElemTypeRef : modelTypeRef.getElementRefs()) {
					modelType.getElements().remove(modelElemTypeRef.getObject());
					multiModel.getExtendibleTable().removeKey(((ModelElement) modelElemTypeRef.getObject()).getUri());
					for (Link linkType : modelElemTypeRef.getLinks()) {
						// binary link types have no longer sense, delete them later to avoid concurrent modification problems
						if (linkType instanceof BinaryLink) {
							delLinkTypes.add(linkType);
						}
					}
					modelElemTypeRef.getLinks().clear();
				}
				for (Link delLinkType : delLinkTypes) {
					delLinkType.getElementRefs().clear();
					modelRelType.getLinks().remove(delLinkType);
					multiModel.getExtendibleTable().removeKey(delLinkType.getUri());
				}
				break;
			}
		}
		for (ModelReference modelTypeRef : delModelRefs) {
			modelRelType.getModelRefs().remove(modelTypeRef);
		}
	}

	public static void removeLightLinkType(Link linkType) {

		MultiModel multiModel = (MultiModel) linkType.eContainer().eContainer();
		multiModel.getExtendibleTable().removeKey(linkType.getUri());
	}

	public static void removeLightModelElementTypeRef(ModelElementReference modelElemTypeRef) {

		MultiModel multiModel = (MultiModel) modelElemTypeRef.eContainer().eContainer().eContainer();
		ModelElement modelElemType = (ModelElement) modelElemTypeRef.getObject();
		((Model) modelElemType.eContainer()).getElements().remove(modelElemType);
		multiModel.getExtendibleTable().removeKey(modelElemType.getUri());
		for (Link linkType : modelElemTypeRef.getLinks()) {
			// binary link types have no longer sense, delete them
			if (linkType instanceof BinaryLink) {
				linkType.getElementRefs().clear();
				((ModelRel) linkType.eContainer()).getLinks().remove(linkType);
				multiModel.getExtendibleTable().removeKey(linkType.getUri());
			}
		}
	}

}