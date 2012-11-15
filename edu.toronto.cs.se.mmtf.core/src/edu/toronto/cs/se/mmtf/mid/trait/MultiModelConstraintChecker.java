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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelElementCategory;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
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

/**
 * The constraint checker for multimodels.
 * 
 * @author Alessio Di Sandro
 *
 */
public class MultiModelConstraintChecker {

	private final static String ENTITY_WILDCARD_CLASSIFIER_NAME = "ModelElementEntityWildcard";
	private final static String RELATIONSHIP_WILDCARD_FEATURE_NAME = "modelElementRelationshipWildcard";
	private final static String OCL_MODELENDPOINT_VAR = "$ENDPOINT_";
	private final static char OCL_VAR_SEPARATOR = '.';

	/**
	 * Checks if an extendible element is a TYPES element or an INSTANCES
	 * element.
	 * 
	 * @param element
	 *            The extendible element to be checked.
	 * @return True for INSTANCES level, false for TYPES level.
	 */
	public static boolean isInstancesLevel(ExtendibleElement element) {

		if (element.getLevel() == MidLevel.TYPES) {
			return false;
		}
		return true;
	}

	public static boolean isInstancesLevel(ExtendibleElementReference elementRef) {

		return isInstancesLevel(elementRef.getObject());
	}

	/**
	 * Checks if a multimodel (the root of a MID diagram) is a TYPES multimodel
	 * or an INSTANCES multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel to be checked.
	 * @return True for INSTANCES level, false for TYPES level.
	 */
	public static boolean isInstancesLevel(MultiModel multiModel) {

		if (multiModel.getLevel() == MidLevel.TYPES) {
			return false;
		}
		return true;
	}

	public static boolean isRootType(ExtendibleElement type) {

		if (type == null) {
			return false;
		}
		if (type.getUri().equals(MultiModelTypeRegistry.getRootTypeUri(type))) {
			return true;
		}
		return false;
	}

	public static boolean isRootType(ExtendibleElementReference typeRef) {

		if (typeRef == null) {
			return false;
		}

		return isRootType(typeRef.getObject());
	}

	public static boolean isAllowedModelType(ModelRel modelRelType) {

		for (ModelRel subModelRelType : MultiModelTypeRegistry.getModelRelTypes()) {
			if (MultiModelTypeRegistry.isSubtypeOf(subModelRelType.getUri(), modelRelType.getUri())) {
				return false;
			}
		}

		return true;
	}	

	public static boolean isAllowedModelTypeEndpoint(BinaryModelRel modelRelType, Model newSrcModelType, Model newTgtModelType) {

		if (newSrcModelType == null && newTgtModelType == null) { // model type not added yet
			return true;
		}

		ModelRel modelRelTypeSuper = (ModelRel) modelRelType.getSupertype();
		// checks that the new model type is the same of the super model rel type or is overriding it
		if (!isRootType(modelRelTypeSuper)) {
			MultiModel multiModel = (MultiModel) modelRelType.eContainer();
			if (newSrcModelType != null) {
				String srcUri = modelRelTypeSuper.getModelEndpoints().get(0).getTargetUri();
				String newSrcUri = newSrcModelType.getUri();
				if (!newSrcUri.equals(srcUri) && !MultiModelTypeRegistry.isSubtypeOf(multiModel, newSrcUri, srcUri)) {
					return false;
				}
			}
			if (newTgtModelType != null) {
				String tgtUri = modelRelTypeSuper.getModelEndpoints().get(1).getTargetUri();
				String newTgtUri = newTgtModelType.getUri();
				if (!newTgtUri.equals(tgtUri) && !MultiModelTypeRegistry.isSubtypeOf(multiModel, newTgtUri, tgtUri)) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isAllowedModelElementTypeEndpointReference(BinaryLinkReference linkTypeRef, ModelElementReference newSrcModelElemTypeRef, ModelElementReference newTgtModelElemTypeRef) {

		if (newSrcModelElemTypeRef == null && newTgtModelElemTypeRef == null) { // model element type reference not added yet
			return true;
		}

		Link linkTypeSuper = linkTypeRef.getObject().getSupertype();
		// checks that the new model element type is the same of the super link type or is overriding it
		if (!isRootType(linkTypeSuper)) {
			MultiModel multiModel = (MultiModel) linkTypeRef.eContainer().eContainer();
			if (newSrcModelElemTypeRef != null) {
				String srcUri = linkTypeSuper.getModelElemEndpoints().get(0).getTargetUri();
				String newSrcUri = newSrcModelElemTypeRef.getUri();
				if (!newSrcUri.equals(srcUri) && !MultiModelTypeRegistry.isSubtypeOf(multiModel, newSrcUri, srcUri)) {
					return false;
				}
			}
			if (newTgtModelElemTypeRef != null) {
				String tgtUri = linkTypeSuper.getModelElemEndpoints().get(1).getTargetUri();
				String newTgtUri = newTgtModelElemTypeRef.getUri();
				if (!newTgtUri.equals(tgtUri) && !MultiModelTypeRegistry.isSubtypeOf(multiModel, newTgtUri, tgtUri)) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isAllowedModelEndpoint(ModelEndpointReference modelTypeEndpointRef, Model newModel, HashMap<String, Integer> cardinalityTable) {

		String newModelTypeUri = newModel.getMetatypeUri();
		// check if the type is allowed
		if (modelTypeEndpointRef.getTargetUri().equals(newModelTypeUri) || MultiModelTypeRegistry.isSubtypeOf(newModelTypeUri, modelTypeEndpointRef.getTargetUri())) {
			// check if the cardinality is allowed
			if (MultiModelRegistry.checkNewEndpointUpperCardinality(modelTypeEndpointRef.getObject(), cardinalityTable)) {
				return true;
			}
		}

		return false;
	}

	public static EList<String> getAllowedModelEndpoints(ModelRel modelRel, Model newModel) {

		if (newModel == null) { // model not added yet
			return new BasicEList<String>();
		}

		EList<String> modelTypeEndpointUris = null;
		// count existing instances
		HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
		for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
			MultiModelRegistry.initEndpointCardinalities(modelEndpoint.getMetatypeUri(), cardinalityTable);
		}
		// check allowance
		for (ModelEndpointReference modelTypeEndpointRef : modelRel.getMetatype().getModelEndpointRefs()) {
			if (isAllowedModelEndpoint(modelTypeEndpointRef, newModel, cardinalityTable)) {
				if (modelTypeEndpointUris == null) {
					modelTypeEndpointUris = new BasicEList<String>();
				}
				modelTypeEndpointUris.add(modelTypeEndpointRef.getUri());
			}
		}

		return modelTypeEndpointUris;
	}

	public static boolean isAllowedModelElementEndpointReference(ModelElementEndpoint modelElemTypeEndpoint, ModelElementReference newModelElemRef, HashMap<String, Integer> cardinalityTable) {

		String newModelElemTypeUri = newModelElemRef.getObject().getMetatypeUri();
		// check if the type is allowed
		if (modelElemTypeEndpoint.getTargetUri().equals(newModelElemTypeUri) || MultiModelTypeRegistry.isSubtypeOf(newModelElemTypeUri, modelElemTypeEndpoint.getTargetUri())) {
			// check if the cardinality is allowed
			if (MultiModelRegistry.checkNewEndpointUpperCardinality(modelElemTypeEndpoint, cardinalityTable)) {
				return true;
			}
		}

		return false;
	}

	public static EList<String> getAllowedModelElementEndpointReferences(LinkReference linkRef, ModelElementReference newModelElemRef) {

		if (newModelElemRef == null) { // model element reference not added yet
			return new BasicEList<String>();
		}

		EList<String> modelElemTypeEndpointUris = null;
		// count existing instances
		HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
		for (ModelElementEndpointReference modelElemEndpointRef : linkRef.getModelElemEndpointRefs()) {
			MultiModelRegistry.initEndpointCardinalities(modelElemEndpointRef.getObject().getMetatypeUri(), cardinalityTable);
		}
		// check allowance
		for (ModelElementEndpoint modelElemTypeEndpoint : linkRef.getObject().getMetatype().getModelElemEndpoints()) {
			if (isAllowedModelElementEndpointReference(modelElemTypeEndpoint, newModelElemRef, cardinalityTable)) {
				if (modelElemTypeEndpointUris == null) {
					modelElemTypeEndpointUris = new BasicEList<String>();
				}
				modelElemTypeEndpointUris.add(modelElemTypeEndpoint.getUri());
			}
		}

		return modelElemTypeEndpointUris;
	}

	private static boolean isAllowedModelElement(ModelElement modelElemType, EObject newEObject) {

		// entity-relationship differences
		String metaName;
		if (newEObject instanceof EReference) {
			if (modelElemType.getCategory() != ModelElementCategory.RELATIONSHIP) {
				return false;
			}
			EStructuralFeature feature = (EStructuralFeature) modelElemType.getPointer();
			metaName = feature.getName();
			if (metaName.equals(RELATIONSHIP_WILDCARD_FEATURE_NAME)) {
				return true;
			}
		}
		else {
			if (modelElemType.getCategory() != ModelElementCategory.ENTITY) {
				return false;
			}
			EClassifier classifier = (EClassifier) modelElemType.getPointer();
			metaName = classifier.getName();
			if (metaName.equals(ENTITY_WILDCARD_CLASSIFIER_NAME)) {
				return true;
			}
		}

		// check dropped element compliance
		String droppedClassLiteral = MultiModelRegistry.getEObjectClassLiteral(newEObject, true);
		if (modelElemType.getClassLiteral().equals(droppedClassLiteral)) {
			return true;
		}
		// look for metamodel supertypes
		//TODO MMTF: looks like there is no way to drop an EReference instance
		for (EClass droppedEObject : newEObject.eClass().getEAllSuperTypes()) {
			droppedClassLiteral = MultiModelRegistry.getEObjectClassLiteral(droppedEObject, false);
			if (modelElemType.getClassLiteral().equals(droppedClassLiteral)) {
				return true;
			}
		}

		return false;
	}

	//TODO MMTF: this should be moved, is type introspection for model elements
	public static ModelElement getAllowedModelElementType(ModelEndpointReference modelEndpointRef, EObject newEObject) {

		ModelRel modelRelType = ((ModelRel) modelEndpointRef.eContainer()).getMetatype();
		ModelEndpointReference modelTypeEndpointRef = MultiModelHierarchyUtils.getReference(modelEndpointRef.getObject().getMetatypeUri(), modelRelType.getModelEndpointRefs());
		//TODO MMTF: fix here needed for root model rel
		Iterator<ModelElementReference> modelElemTypeRefIter = MultiModelHierarchyUtils.getInverseTypeRefHierarchyIterator(modelTypeEndpointRef.getModelElemRefs());
		while (modelElemTypeRefIter.hasNext()) {
			ModelElementReference modelElemTypeRef = modelElemTypeRefIter.next();
			if (isAllowedModelElement(modelElemTypeRef.getObject(), newEObject)) {
				return modelElemTypeRef.getObject();
			}
		}
		//TODO MMTF: what about dropped supertypes now, since they can be in a different model type ref?

		return null;
	}

	//TODO MMTF: this should be moved, is type introspection for links
	public static Link getAllowedLinkType(Link link) {

		ModelRel modelRelType = ((ModelRel) link.eContainer()).getMetatype();
linkTypes:
		for (Link linkType : modelRelType.getLinks()) {
			HashSet<String> allowedModelElemTypes = new HashSet<String>();
			for (ModelElementEndpoint modelElemTypeEndpoint : linkType.getModelElemEndpoints()) {
				allowedModelElemTypes.add(modelElemTypeEndpoint.getTargetUri());
			}
			for (ModelElementEndpoint modelElemEndpoint : link.getModelElemEndpoints()) {				
				if (!allowedModelElemTypes.contains(modelElemEndpoint.getTarget().getMetatypeUri())) {
					continue linkTypes;
				}
			}
			return linkType;
		}

		return null;
	}

	/**
	 * Checks if an OCL constraint is satisfied on a model.
	 * 
	 * @param model
	 *            The model.
	 * @param oclConstraint
	 *            The OCL constraint.
	 * @return True if the OCL constraint is satisfied, false otherwise.
	 */
	public static boolean checkOCLConstraint(Model model, String oclConstraint) {

		if (oclConstraint.equals("")) { // empty constraint
			return true;
		}

		EObject root = null;
		if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VAR)) {
			String modelTypeEndpointName = oclConstraint.substring(OCL_MODELENDPOINT_VAR.length(), oclConstraint.indexOf(OCL_VAR_SEPARATOR));
			for (ModelEndpointReference modelEndpointRef : ((ModelRel) model).getModelEndpointRefs()) {
				if (modelTypeEndpointName.equals(modelEndpointRef.getObject().getMetatype().getName())) {
					root = MultiModelTypeIntrospection.getRoot(modelEndpointRef.getObject().getTarget());
					break;
				}
			}
			oclConstraint = oclConstraint.substring(oclConstraint.indexOf(OCL_VAR_SEPARATOR) + 1, oclConstraint.length());
		}
		else {
			root = MultiModelTypeIntrospection.getRoot(model);
		}

		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper();
		//TODO MMTF: workaround for bug #375485
		//helper.setInstanceContext(root);
		MetaModelManager metaModelManager = helper.getOCL().getMetaModelManager();
		EClass eClass = root.eClass();
		Type pivotType = metaModelManager.getPivotType(eClass.getName());
		if (pivotType == null) {
			Resource resource = eClass.eResource();
			Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(resource, metaModelManager);
			pivotType = ecore2Pivot.getCreated(Type.class, eClass);
		}
		helper.setContext(pivotType);

		try {
			ExpressionInOCL constraint = helper.createInvariant(oclConstraint);
			return ocl.check(root, constraint);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "Constraint error: " + oclConstraint, e);
			return false;
		}
	}

}
