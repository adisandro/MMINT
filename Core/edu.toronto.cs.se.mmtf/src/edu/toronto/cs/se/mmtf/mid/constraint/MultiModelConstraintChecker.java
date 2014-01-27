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
package edu.toronto.cs.se.mmtf.mid.constraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.PrimitiveEObjectWrapper;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
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
import edu.toronto.cs.se.mmtf.reasoning.EcoreMAVOToSMTLIB;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTSolver;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTSolver.CLibrary;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTSolver.CLibrary.Z3IncResult;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils.MAVOTruthValue;

/**
 * The constraint checker for multimodels.
 * 
 * @author Alessio Di Sandro
 *
 */
public class MultiModelConstraintChecker {

	private final static String WILDCARD_CLASSIFIER_NAME = "ModelElementWildcard";
	private final static String OCL_MODELENDPOINT_VARIABLE = "$ENDPOINT_";
	private final static char OCL_VARIABLE_SEPARATOR = '.';
	private final static String ECOREMAVOTOSMTLIB_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EcoreMAVOToSMTLIB";

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

	public static boolean isAllowedModelType(ModelRel modelRelType) {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
		List<ModelRel> modelRelSubtypes = MultiModelTypeHierarchy.getSubtypes(modelRelType, multiModel);

		return (modelRelSubtypes.isEmpty()) ? true : false;
	}	

	public static boolean isAllowedModelTypeEndpoint(BinaryModelRel modelRelType, Model newSrcModelType, Model newTgtModelType) {

		if (newSrcModelType == null && newTgtModelType == null) { // model type not added yet
			return true;
		}

		ModelRel modelRelTypeSuper = (ModelRel) modelRelType.getSupertype();
		// checks that the new model type is the same of the super model rel type or is overriding it
		if (!MultiModelTypeHierarchy.isRootType(modelRelTypeSuper)) {
			MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRelType);
			if (newSrcModelType != null) {
				String srcUri = modelRelTypeSuper.getModelEndpoints().get(0).getTargetUri();
				String newSrcUri = newSrcModelType.getUri();
				if (!newSrcUri.equals(srcUri) && !MultiModelTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, multiModel)) {
					return false;
				}
			}
			if (newTgtModelType != null) {
				String tgtUri = modelRelTypeSuper.getModelEndpoints().get(1).getTargetUri();
				String newTgtUri = newTgtModelType.getUri();
				if (!newTgtUri.equals(tgtUri) && !MultiModelTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, multiModel)) {
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
		if (!MultiModelTypeHierarchy.isRootType(linkTypeSuper)) {
			MultiModel multiModel = MultiModelRegistry.getMultiModel(linkTypeRef);
			if (newSrcModelElemTypeRef != null) {
				String srcUri = linkTypeSuper.getModelElemEndpoints().get(0).getTargetUri();
				String newSrcUri = newSrcModelElemTypeRef.getUri();
				if (!newSrcUri.equals(srcUri) && !MultiModelTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, multiModel)) {
					return false;
				}
			}
			if (newTgtModelElemTypeRef != null) {
				String tgtUri = linkTypeSuper.getModelElemEndpoints().get(1).getTargetUri();
				String newTgtUri = newTgtModelElemTypeRef.getUri();
				if (!newTgtUri.equals(tgtUri) && !MultiModelTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, multiModel)) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isAllowedModelEndpoint(ModelEndpointReference modelTypeEndpointRef, Model newModel, HashMap<String, Integer> cardinalityTable) {

		//TODO MMTF: consider static (like now) or runtime types?
		String newModelTypeUri = newModel.getMetatypeUri();
		// check if the type is allowed
		if (modelTypeEndpointRef.getTargetUri().equals(newModelTypeUri) || MultiModelTypeHierarchy.isSubtypeOf(newModelTypeUri, modelTypeEndpointRef.getTargetUri())) {
			// check if the cardinality is allowed
			if (MultiModelRegistry.checkNewEndpointUpperCardinality(modelTypeEndpointRef.getObject(), cardinalityTable)) {
				return true;
			}
		}

		return false;
	}

	public static List<String> getAllowedModelEndpoints(ModelRel modelRel, Model newModel) {

		if (newModel == null) { // model not added yet
			return new ArrayList<String>();
		}

		List<String> modelTypeEndpointUris = null;
		// count existing instances
		HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
		for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
			MultiModelRegistry.initEndpointCardinalities(modelEndpoint.getMetatypeUri(), cardinalityTable);
		}
		// check allowance
		for (ModelEndpointReference modelTypeEndpointRef : modelRel.getMetatype().getModelEndpointRefs()) {
			if (isAllowedModelEndpoint(modelTypeEndpointRef, newModel, cardinalityTable)) {
				if (modelTypeEndpointUris == null) {
					modelTypeEndpointUris = new ArrayList<String>();
				}
				modelTypeEndpointUris.add(modelTypeEndpointRef.getUri());
			}
		}

		return modelTypeEndpointUris;
	}

	public static boolean areAllowedModelEndpoints(ModelRel modelRel, ModelRel newModelRelType) {

		HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
		for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
			boolean isAllowed = false;
			//TODO MMTF: order of visit might affect the result, should be from the most specific to the less
			for (ModelEndpointReference modelTypeEndpointRef : newModelRelType.getModelEndpointRefs()) {
				if (isAllowed = isAllowedModelEndpoint(modelTypeEndpointRef, modelEndpoint.getTarget(), cardinalityTable)) {
					MultiModelRegistry.initEndpointCardinalities(modelTypeEndpointRef.getUri(), cardinalityTable);
					break;
				}
			}
			if (!isAllowed) {
				return false;
			}
		}

		return true;
	}

	public static boolean isAllowedModelElementEndpointReference(ModelElementEndpoint modelElemTypeEndpoint, ModelElementReference newModelElemRef, HashMap<String, Integer> cardinalityTable) {

		//TODO MMTF: consider static (like now) or runtime types?
		String newModelElemTypeUri = newModelElemRef.getObject().getMetatypeUri();
		// check if the type is allowed
		if (modelElemTypeEndpoint.getTargetUri().equals(newModelElemTypeUri) || MultiModelTypeHierarchy.isSubtypeOf(newModelElemTypeUri, modelElemTypeEndpoint.getTargetUri())) {
			// check if the cardinality is allowed
			if (MultiModelRegistry.checkNewEndpointUpperCardinality(modelElemTypeEndpoint, cardinalityTable)) {
				return true;
			}
		}

		return false;
	}

	public static List<String> getAllowedModelElementEndpointReferences(LinkReference linkRef, ModelElementReference newModelElemRef) {

		if (newModelElemRef == null) { // model element reference not added yet
			return new ArrayList<String>();
		}

		List<String> modelElemTypeEndpointUris = null;
		// count existing instances
		HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
		for (ModelElementEndpointReference modelElemEndpointRef : linkRef.getModelElemEndpointRefs()) {
			MultiModelRegistry.initEndpointCardinalities(modelElemEndpointRef.getObject().getMetatypeUri(), cardinalityTable);
		}
		// check allowance
		for (ModelElementEndpoint modelElemTypeEndpoint : linkRef.getObject().getMetatype().getModelElemEndpoints()) {
			if (isAllowedModelElementEndpointReference(modelElemTypeEndpoint, newModelElemRef, cardinalityTable)) {
				if (modelElemTypeEndpointUris == null) {
					modelElemTypeEndpointUris = new ArrayList<String>();
				}
				modelElemTypeEndpointUris.add(modelElemTypeEndpoint.getUri());
			}
		}

		return modelElemTypeEndpointUris;
	}

	public static boolean areAllowedModelElementEndpointReferences(Link link, Link newLinkType) {

		HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
		for (ModelElementEndpointReference modelElemEndpointRef : link.getModelElemEndpointRefs()) {
			boolean isAllowed = false;
			//TODO MMTF: order of visit might affect the result, should be from the most specific to the less
			for (ModelElementEndpointReference modelElemTypeEndpointRef : newLinkType.getModelElemEndpointRefs()) {
				if (isAllowed = isAllowedModelElementEndpointReference(modelElemTypeEndpointRef.getObject(), modelElemEndpointRef.getModelElemRef(), cardinalityTable)) {
					MultiModelRegistry.initEndpointCardinalities(modelElemTypeEndpointRef.getUri(), cardinalityTable);
					break;
				}
			}
			if (!isAllowed) {
				return false;
			}
		}

		return true;
	}

	private static boolean isAllowedModelElement(ModelElement modelElemType, EObject modelObj) {

		EObject modelElemTypeObj;
		try {
			modelElemTypeObj = modelElemType.getEMFTypeObject();
		}
		catch (MMTFException e) {
			MMTFException.print(MMTFException.Type.WARNING, "Can't get model object, skipping allowance evaluation", e);
			return false;
		}
		// check wildcard
		if (modelElemTypeObj instanceof EClassifier && ((EClassifier) modelElemTypeObj).getName().equals(WILDCARD_CLASSIFIER_NAME)) {
			return true;
		}
		//TODO MMTF[MODELELEMENT] is class literal really needed or obtainable from the uri?
		// check model element compliance
		String modelObjClassLiteral = MultiModelRegistry.getModelElementClassLiteral(modelObj, true);
		if (modelElemType.getClassLiteral().equals(modelObjClassLiteral)) {
			return true;
		}

		// look for metamodel supertypes
		if (modelObj instanceof PrimitiveEObjectWrapper) {
			modelObjClassLiteral = MultiModelRegistry.getModelElementClassLiteral(((PrimitiveEObjectWrapper) modelObj).getFeature(), false);
			if (modelElemType.getClassLiteral().equals(modelObjClassLiteral)) {
				return true;
			}
		}
		else {
			for (EClass modelObjSuper : modelObj.eClass().getEAllSuperTypes()) {
				modelObjClassLiteral = MultiModelRegistry.getModelElementClassLiteral(modelObjSuper, false);
				if (modelElemType.getClassLiteral().equals(modelObjClassLiteral)) {
					return true;
				}
			}
		}
		// look for UML stereotypes
		if (modelObj instanceof NamedElement) {
			for (Stereotype stereotype : ((NamedElement) modelObj).getApplicableStereotypes()) {
				if (
					modelElemType.getClassLiteral().equals(stereotype.getName()) ||
					stereotype.getName().equals(MAVOUtils.MAVO_UML_STEREOTYPE_EQUIVALENCE.get(modelElemType.getClassLiteral()))
				) {
					return true;
				}
			}
		}

		return false;
	}

	//TODO MMTF[INTROSPECTION] this should be moved, is type introspection for model elements
	public static ModelElement getAllowedModelElementType(ModelEndpointReference modelEndpointRef, EObject modelObj) {

		ModelRel modelRelType = ((ModelRel) modelEndpointRef.eContainer()).getMetatype();
		ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelEndpointRef.getObject().getMetatypeUri(), modelRelType.getModelEndpointRefs());
		Iterator<ModelElementReference> modelElemTypeRefIter = MultiModelTypeHierarchy.getInverseTypeRefHierarchyIterator(modelTypeEndpointRef.getModelElemRefs());
		while (modelElemTypeRefIter.hasNext()) {
			ModelElementReference modelElemTypeRef = modelElemTypeRefIter.next();
			if (isAllowedModelElement(modelElemTypeRef.getObject(), modelObj)) {
				return modelElemTypeRef.getObject();
			}
		}
		//TODO MMTF[MODELELEMENT] what about dropped supertypes now, since they can be in a different model type ref?

		return null;
	}

	//TODO MMTF[INTROSPECTION] this should be moved, is type introspection for links
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

	private static void initOCL(OCLHelper helper, EObject modelObj) {

		//TODO MMTF: workaround for bug #375485
//		helper.setInstanceContext(modelObj);
		MetaModelManager metaModelManager = helper.getOCL().getMetaModelManager();
		EClass modelObjClass = modelObj.eClass();
		Resource resource = modelObjClass.eResource();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(resource, metaModelManager);
		Type pivotType = ecore2Pivot.getCreated(Type.class, modelObjClass);
		helper.setContext(pivotType);
	}

	public static Object deriveOCLConstraint(EObject modelObj, String oclConstraint) {

		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper();
		initOCL(helper, modelObj);

		try {
			ExpressionInOCL expression = helper.createQuery(oclConstraint);
			return ocl.evaluate(modelObj, expression);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "OCL constraint error: " + oclConstraint, e);
			return null;
		}
	}

	public static MAVOTruthValue checkOCLConstraint(EObject modelObj, String oclConstraint) {

		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper();
		initOCL(helper, modelObj);

		try {
			ExpressionInOCL expression = helper.createInvariant(oclConstraint);
			return (ocl.check(modelObj, expression)) ? MAVOTruthValue.TRUE : MAVOTruthValue.FALSE;
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "OCL constraint error: " + oclConstraint, e);
			return MAVOTruthValue.FALSE;
		}
	}

	private static MAVOTruthValue checkOCLConstraint(Model model, String oclConstraint, boolean isInstanceConstraint) {

		if (oclConstraint.equals("")) { // empty constraint
			return MAVOTruthValue.TRUE;
		}

		EObject root = null;
		try {
			if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
				String modelEndpointConstraintName = oclConstraint.substring(OCL_MODELENDPOINT_VARIABLE.length(), oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR));
				for (ModelEndpointReference modelEndpointRef : ((ModelRel) model).getModelEndpointRefs()) {
					String modelEndpointName = (isInstanceConstraint) ?
						modelEndpointRef.getObject().getName() :
						modelEndpointRef.getObject().getMetatype().getName();
					if (modelEndpointConstraintName.equals(modelEndpointName)) {
						root = modelEndpointRef.getObject().getTarget().getEMFRoot();
						break;
					}
				}
				oclConstraint = oclConstraint.substring(oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR) + 1, oclConstraint.length());
			}
			else {
				root = model.getEMFRoot();
			}
		}
		catch (MMTFException e) {
			MMTFException.print(MMTFException.Type.WARNING, "Can't get model root, skipping constraint evaluation", e);
			return MAVOTruthValue.FALSE;
		}

		return checkOCLConstraint(root, oclConstraint);
	}

	private static MAVOTruthValue checkJAVAConstraint(Model model, String modelTypeUri, String javaClassName) {

		try {
			JavaModelConstraint javaConstraint = (JavaModelConstraint)
				MultiModelTypeRegistry.getTypeBundle(modelTypeUri).
				loadClass(javaClassName).
				getConstructor(Model.class).
				newInstance(model);
			return javaConstraint.validate();
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "Java constraint error: " + javaClassName, e);
			return MAVOTruthValue.FALSE;
		}
	}

	private static MAVOTruthValue checkSMTLIBConstraint(Model model, String smtProperty) {

		if (!MAVOUtils.isMAVOModel(model)) {
			return MAVOTruthValue.FALSE;
		}

		EcoreMAVOToSMTLIB ecore2smt = (EcoreMAVOToSMTLIB) MultiModelTypeRegistry.<Operator>getType(ECOREMAVOTOSMTLIB_OPERATOR_URI).getExecutable();
		EList<Model> actualParameters = new BasicEList<Model>();
		actualParameters.add(model);
		try {
			ecore2smt.execute(actualParameters);
		}
		catch (Exception e) {
			return MAVOTruthValue.FALSE;
		}
		ecore2smt.cleanup();

		// tri-state logic
		Z3IncResult z3Result = CLibrary.OPERATOR_INSTANCE.firstCheckSatAndGetModelIncremental(ecore2smt.getListener().getSMTEncoding());
		CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3Result, Z3SMTUtils.assertion(smtProperty), 1, 0);
		boolean propertyTruthValue = z3Result.flag == Z3SMTSolver.Z3_SAT;
		CLibrary.OPERATOR_INSTANCE.checkSatAndGetModelIncremental(z3Result, Z3SMTUtils.assertion(Z3SMTUtils.not(smtProperty)), 1, 0);
		boolean notPropertyTruthValue = z3Result.flag == Z3SMTSolver.Z3_SAT;
		CLibrary.OPERATOR_INSTANCE.freeResultIncremental(z3Result);

		return MAVOTruthValue.toMAVOTruthValue(propertyTruthValue, notPropertyTruthValue);
	}

	/**
	 * Checks if a constraint is satisfied on an extendible element (only models
	 * are currently evaluated).
	 * 
	 * @param element
	 *            The extendible element.
	 * @param constraint
	 *            The constraint.
	 * @return True if the constraint is satisfied, false otherwise.
	 */
	public static MAVOTruthValue checkConstraint(ExtendibleElement element, ExtendibleElementConstraint constraint) {

		//TODO MMTF: support all extendible elements?
		if (!(element instanceof Model)) {
			return MAVOTruthValue.TRUE;
		}
		if (constraint == null || constraint.getImplementation() == null) {
			return MAVOTruthValue.TRUE;
		}

		boolean isInstanceConstraint = element.getUri().equals(((Model) constraint.eContainer()).getUri());
		switch (constraint.getLanguage()) {
			case OCL:
				return checkOCLConstraint((Model) element, constraint.getImplementation(), isInstanceConstraint);
			case JAVA:
				String modelTypeUri = (isInstanceConstraint) ?
					((Model) constraint.eContainer()).getMetatypeUri() :
					((Model) constraint.eContainer()).getUri();
				return checkJAVAConstraint((Model) element, modelTypeUri, constraint.getImplementation());
			case SMTLIB:
				return checkSMTLIBConstraint((Model) element, constraint.getImplementation());
			default:
				return MAVOTruthValue.FALSE;
		}
	}

}
