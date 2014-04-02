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
package edu.toronto.cs.se.mmint.mid.constraint;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Stereotype;
import org.osgi.framework.FrameworkUtil;

import com.parctechnologies.eclipse.CompoundTerm;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeFactory;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraintLanguage;
import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.library.PrimitiveEObjectWrapper;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryLinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.reasoning.EcoreMAVOToSMTLIB;
import edu.toronto.cs.se.mmint.reasoning.Z3SMTSolver;
import edu.toronto.cs.se.mmint.reasoning.Z3SMTUtils;
import edu.toronto.cs.se.mmint.reasoning.Z3SMTSolver.CLibrary;
import edu.toronto.cs.se.mmint.reasoning.Z3SMTSolver.CLibrary.Z3IncResult;
import edu.toronto.cs.se.mmint.reasoning.Z3SMTUtils.MAVOTruthValue;
import fr.inria.atlanmod.emftocsp.ICspSolver;
import fr.inria.atlanmod.emftocsp.IModelProperty;
import fr.inria.atlanmod.emftocsp.IModelReader;
import fr.inria.atlanmod.emftocsp.IModelToCspSolver;
import fr.inria.atlanmod.emftocsp.IModelToCspSolverFactory;
import fr.inria.atlanmod.emftocsp.eclipsecs.EclipseSolver;
import fr.inria.atlanmod.emftocsp.emf.impl.EAssociation;
import fr.inria.atlanmod.emftocsp.emf.impl.EmfModelToCspSolverFactory;
import fr.inria.atlanmod.emftocsp.emftoecl.EmfToEclCodeGenerator;
import fr.inria.atlanmod.emftocsp.impl.StrongSatisfiabilityModelProperty;
import fr.inria.atlanmod.emftocsp.ui.main.Activator;

/**
 * The constraint checker for multimodels.
 * 
 * @author Alessio Di Sandro
 *
 */
public class MultiModelConstraintChecker {

	private final static String OCL_MODELENDPOINT_VARIABLE = "$ENDPOINT_";
	private final static char OCL_VARIABLE_SEPARATOR = '.';
	private final static String ECOREMAVOTOSMTLIB_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EcoreMAVOToSMTLIB";
	private final static String ECORE_PIVOT_CONSISTENCYCONSTRAINT = "consistencyConstraint";
	private final static String EMFTOCSP_PREFERENCE_ECLIPSEPATH = "EclipsePath";
	private final static String EMFTOCSP_PREFERENCE_GRAPHVIZPATH = "GraphvizPath";
	private final static String EMFTOCSP_BUNDLE = "fr.inria.atlanmod.emftocsp";
	private final static String EMFTOCSP_TEMPPROJECT = "edu.toronto.cs.se.mmint.emftocsp";
	private final static String EMFTOCSP_TEMPFOLDER = "consistency";

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

	public static List<String> getAllowedModelRelTypes(Model targetSrcModel, Model targetTgtModel) {

		List<String> modelRelTypeUris = new ArrayList<String>();
		for (ModelRel modelRelType : MultiModelTypeRegistry.getModelRelTypes()) {
			boolean isAllowed = true, isAllowedSrc = false, isAllowedTgt = false;
			HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
			//TODO MMINT: consider direction for binary?
			if (targetSrcModel != null) {
				for (ModelEndpointReference modelTypeEndpointRef : modelRelType.getModelEndpointRefs()) {
					if (MultiModelConstraintChecker.isAllowedModelEndpoint(modelTypeEndpointRef, targetSrcModel, cardinalityTable)) {
						MultiModelRegistry.initEndpointCardinalities(modelTypeEndpointRef.getUri(), cardinalityTable);
						isAllowedSrc = true;
						break;
					}
				}
				isAllowed = isAllowed && isAllowedSrc;
			}
			if (targetTgtModel != null) {
				for (ModelEndpointReference modelTypeEndpointRef : modelRelType.getModelEndpointRefs()) {
					if (MultiModelConstraintChecker.isAllowedModelEndpoint(modelTypeEndpointRef, targetTgtModel, cardinalityTable)) {
						MultiModelRegistry.initEndpointCardinalities(modelTypeEndpointRef.getUri(), cardinalityTable);
						isAllowedTgt = true;
						break;
					}
				}
				isAllowed = isAllowed && isAllowedTgt;
			}
			if (isAllowed) {
				modelRelTypeUris.add(modelRelType.getUri());
			}
		}
		// check for overrides
		for (String modelRelTypeUri : modelRelTypeUris) {
			//TODO MMINT[OVERRIDE] if one model rel type points to another one in this list through its override pointer, then delete it
		}

		return modelRelTypeUris;
	}

	public static List<String> getAllowedLinkTypeReferences(ModelRel modelRelType, ModelElementReference targetSrcModelElemRef, ModelElementReference targetTgtModelElemRef) {

		List<String> linkTypeUris = new ArrayList<String>();
		for (LinkReference linkTypeRef : modelRelType.getLinkRefs()) {
			boolean isAllowed = true, isAllowedSrc = false, isAllowedTgt = false;
			HashMap<String, Integer> cardinalityTable = new HashMap<String, Integer>();
			//TODO MMINT: consider direction for binary?
			if (targetSrcModelElemRef != null) {
				for (ModelElementEndpointReference modelElemTypeEndpointRef : linkTypeRef.getObject().getModelElemEndpointRefs()) {
					if (MultiModelConstraintChecker.isAllowedModelElementEndpointReference(modelElemTypeEndpointRef.getObject(), targetSrcModelElemRef, cardinalityTable)) {
						MultiModelRegistry.initEndpointCardinalities(modelElemTypeEndpointRef.getUri(), cardinalityTable);
						isAllowedSrc = true;
						break;
					}
				}
				isAllowed = isAllowed && isAllowedSrc;
			}
			if (targetTgtModelElemRef != null) {
				for (ModelElementEndpointReference modelElemTypeEndpointRef : linkTypeRef.getObject().getModelElemEndpointRefs()) {
					if (MultiModelConstraintChecker.isAllowedModelElementEndpointReference(modelElemTypeEndpointRef.getObject(), targetTgtModelElemRef, cardinalityTable)) {
						MultiModelRegistry.initEndpointCardinalities(modelElemTypeEndpointRef.getUri(), cardinalityTable);
						isAllowedTgt = true;
						break;
					}
				}
				isAllowed = isAllowed && isAllowedTgt;
			}
			if (isAllowed) {
				linkTypeUris.add(linkTypeRef.getUri());
			}
		}
		// check for overrides
		for (String linkTypeUri : linkTypeUris) {
			//TODO MMINT[OVERRIDE] if one link type points to another one in this list through its override pointer, then delete it
		}

		return linkTypeUris;
	}

	public static boolean isAllowedModelEndpoint(ModelEndpointReference modelTypeEndpointRef, Model targetModel, Map<String, Integer> cardinalityTable) {

		//TODO MMINT[INTROSPECTION] consider static (like now) or runtime types?
		String targetModelTypeUri = targetModel.getMetatypeUri();
		// check if the type is allowed
		if (modelTypeEndpointRef.getTargetUri().equals(targetModelTypeUri) || MultiModelTypeHierarchy.isSubtypeOf(targetModelTypeUri, modelTypeEndpointRef.getTargetUri())) {
			// check if the cardinality is allowed
			if (MultiModelRegistry.checkNewEndpointUpperCardinality(modelTypeEndpointRef.getObject(), cardinalityTable)) {
				return true;
			}
		}

		return false;
	}

	public static List<String> getAllowedModelEndpoints(ModelRel modelRel, Model targetModel) {

		if (targetModel == null) { // model not added yet
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
			if (isAllowedModelEndpoint(modelTypeEndpointRef, targetModel, cardinalityTable)) {
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
			//TODO MMINT: order of visit might affect the result, should be from the most specific to the less
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

		//TODO MMINT: consider static (like now) or runtime types?
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
			//TODO MMINT: order of visit might affect the result, should be from the most specific to the less
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

	public static boolean instanceofEMFClass(EObject modelObj, String eClassName) {

		if (eClassName.equals(modelObj.eClass().getName())) {
			return true;
		}
		for (EClass modelTypeObjSuper : modelObj.eClass().getEAllSuperTypes()) {
			if (eClassName.equals(modelTypeObjSuper.getName())) {
				return true;
			}
		}

		return false;
	}

	private static boolean isAllowedModelElement(ModelEndpointReference modelTypeEndpointRef, EObject modelObj, ModelElement modelElemType) {

		// check root
		if (MultiModelTypeHierarchy.isRootType(modelElemType)) {
			return true;
		}
		// check model element compliance
		EMFInfo modelObjEInfo = MultiModelRegistry.getModelElementEMFInfo(modelObj, MidLevel.INSTANCES), modelElemTypeEInfo = modelElemType.getEInfo();
		if (modelObjEInfo.isAttribute()) {
			// attribute compliance + class compliance
			if (
				modelElemTypeEInfo.isAttribute() &&
				modelObjEInfo.getFeatureName().equals(modelElemTypeEInfo.getFeatureName()) &&
				instanceofEMFClass(((PrimitiveEObjectWrapper) modelObj).getOwner(), modelElemTypeEInfo.getClassName())
			) {
				return true;
			}
		}
		else {
			// class compliance + containment compliance
			if (
				modelElemTypeEInfo.getFeatureName() == null &&
				instanceofEMFClass(modelObj, modelElemTypeEInfo.getClassName())
			) {
				if (modelObjEInfo.getRelatedClassName() == null) { // root
					return true;
				}
				boolean isAllowed = true; // default is to allow if no containment model element type is present
				for (ModelElementReference modelElemTypeRef : modelTypeEndpointRef.getModelElemRefs()) {
					if (modelElemTypeRef.getUri().equals(modelElemType.getUri())) { // same model element type under test
						continue;
					}
					EMFInfo modelElemTypeContainmentEInfo = modelElemTypeRef.getObject().getEInfo();
					if ( // not the right containment model element type
						modelElemTypeContainmentEInfo.getFeatureName() == null ||
						modelElemTypeContainmentEInfo.isAttribute() ||
						!instanceofEMFClass(modelObj, modelElemTypeContainmentEInfo.getRelatedClassName())
					) {
						continue;
					}
					if (
						modelElemTypeContainmentEInfo.getFeatureName().equals(modelObjEInfo.getFeatureName()) &&
						instanceofEMFClass(modelObj.eContainer(), modelElemTypeContainmentEInfo.getClassName())
					) {
						isAllowed = true;
						break;
					}
					else { // found unallowed containment, default no longer applies
						isAllowed = false;
						continue;
					}
				}
				if (isAllowed) {
					return true;
				}
			}
		}
		// look for UML stereotypes
		//TODO MMINT[MODELELEMENT] review
		if (modelObj instanceof NamedElement) {
			for (Stereotype stereotype : ((NamedElement) modelObj).getApplicableStereotypes()) {
				if (
					modelElemTypeEInfo.getClassName().equals(stereotype.getName()) ||
					stereotype.getName().equals(MAVOUtils.MAVO_UML_STEREOTYPE_EQUIVALENCE.get(modelElemTypeEInfo.getClassName()))
				) {
					return true;
				}
			}
		}

		return false;
	}

	public static ModelElement getAllowedModelElementType(ModelEndpointReference modelEndpointRef, EObject modelObj) {

		ModelRel modelRelType = ((ModelRel) modelEndpointRef.eContainer()).getMetatype();
		ModelEndpointReference modelTypeEndpointRef = MultiModelTypeHierarchy.getReference(modelEndpointRef.getObject().getMetatypeUri(), modelRelType.getModelEndpointRefs());
		Iterator<ModelElementReference> modelElemTypeRefIter = MultiModelTypeHierarchy.getInverseTypeRefHierarchyIterator(modelTypeEndpointRef.getModelElemRefs());
		while (modelElemTypeRefIter.hasNext()) {
			ModelElementReference modelElemTypeRef = modelElemTypeRefIter.next();
			if (isAllowedModelElement(modelTypeEndpointRef, modelObj, modelElemTypeRef.getObject())) {
				return modelElemTypeRef.getObject();
			}
		}
		//TODO MMINT[MODELELEMENT] what about dropped supertypes now, since they can be in a different model type ref?

		return null;
	}

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

	private static EObject getOCLConstraintContext(Model model, String oclConstraint, boolean isInstanceConstraint) throws MMINTException {

		//TODO MMINT[CONSTRAINT] find language to express more complex contraints on model rels
		boolean isInstancesLevel = isInstancesLevel(model);
		EObject modelObj = null;
		if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
			String modelEndpointConstraintName = oclConstraint.substring(OCL_MODELENDPOINT_VARIABLE.length(), oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR));
			for (ModelEndpointReference modelEndpointRef : ((ModelRel) model).getModelEndpointRefs()) {
				//TODO MMINT[ENDPOINT] consider overridden endpoints here
				String modelEndpointName = (isInstancesLevel && !isInstanceConstraint) ?
					modelEndpointRef.getObject().getMetatype().getName() :
					modelEndpointRef.getObject().getName();
				if (modelEndpointConstraintName.equals(modelEndpointName)) {
					modelObj = (isInstancesLevel) ?
						modelEndpointRef.getObject().getTarget().getEMFInstanceRoot() :
						modelEndpointRef.getObject().getTarget().getEMFTypeRoot();
					break;
				}
			}
			if (modelObj == null) {
				throw new MMINTException("Can't find model endpoint " + modelEndpointConstraintName + " used in model relationship constraint");
			}
		}
		else {
			modelObj = (isInstancesLevel) ?
				model.getEMFInstanceRoot() :
				model.getEMFTypeRoot();
		}

		return modelObj;
	}

	private static void initOCL(OCLHelper helper, EObject modelObj) {

		//TODO MMINT: workaround for bug #375485
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
			MMINTException.print(MMINTException.Type.WARNING, "OCL constraint error: " + oclConstraint, e);
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
			MMINTException.print(MMINTException.Type.WARNING, "OCL constraint error: " + oclConstraint, e);
			return MAVOTruthValue.FALSE;
		}
	}

	private static MAVOTruthValue checkOCLConstraint(Model model, String oclConstraint, boolean isInstanceConstraint) {

		try {
			EObject modelObj = getOCLConstraintContext(model, oclConstraint, isInstanceConstraint);
			if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
				oclConstraint = oclConstraint.substring(oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR) + 1, oclConstraint.length());
			}
			return checkOCLConstraint(modelObj, oclConstraint);
		}
		catch (MMINTException e) {
			MMINTException.print(MMINTException.Type.WARNING, "Can't get context for OCL constraint", e);
			return MAVOTruthValue.FALSE;
		}
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
			MMINTException.print(MMINTException.Type.WARNING, "Java constraint error: " + javaClassName, e);
			return MAVOTruthValue.FALSE;
		}
	}

	private static MAVOTruthValue checkSMTLIBConstraint(Model model, String smtProperty) {

		if (!MAVOUtils.isMAVOModel(model)) {
			return MAVOTruthValue.FALSE;
		}

		EcoreMAVOToSMTLIB ecore2smt = (EcoreMAVOToSMTLIB) MultiModelTypeRegistry.<Operator>getType(ECOREMAVOTOSMTLIB_OPERATOR_URI);
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

		if (!(element instanceof Model)) {
			return MAVOTruthValue.TRUE;
		}
		if (constraint == null || constraint.getImplementation() == null || constraint.getImplementation().equals("")) {
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

	private static void flattenEPackage(EPackage flatPackage) {

		Map<String, EClass> flatClasses = new HashMap<String, EClass>();
		// first pass: pre-populate classes in the package
		for (EClassifier flatClassifier : flatPackage.getEClassifiers()) {
			if (!(flatClassifier instanceof EClass)) {
				continue;
			}
			flatClasses.put(flatClassifier.getName(), (EClass) flatClassifier);
		}
		// second pass: flatten
		for (EClassifier flatClassifier : flatPackage.getEClassifiers()) {
			if (!(flatClassifier instanceof EClass)) {
				continue;
			}
			flattenEClass((EClass) flatClassifier, flatPackage, flatClasses);
		}
		flatPackage.getEClassifiers().addAll(flatClasses.values());
	}

	private static void flattenEClass(EClass flatClass, EPackage flatPackage, Map<String, EClass> flatClasses) {

		// first pass: flatten superclasses
		for (EClass superClass : flatClass.getEAllSuperTypes()) {
			for (EStructuralFeature flatFeature : superClass.getEStructuralFeatures()) {
				flatClass.getEStructuralFeatures().add(EcoreUtil.copy(flatFeature));
			}
			checkAndReflatten(superClass, flatPackage, flatClasses);
		}
		flatClass.getESuperTypes().clear();
		// second pass: flatten types
		for (EStructuralFeature flatFeature : flatClass.getEStructuralFeatures()) {
			if (!(flatFeature instanceof EReference)) {
				continue;
			}
			EClassifier flatFeatureClassifier = flatFeature.getEType();
			if (!(flatFeatureClassifier instanceof EClass)) {
				continue;
			}
			EClass flatFeatureClass = checkAndReflatten((EClass) flatFeatureClassifier, flatPackage, flatClasses);
			flatFeature.setEType(flatFeatureClass);
		}
	}

	private static EClass checkAndReflatten(EClass checkedClass, EPackage flatPackage, Map<String, EClass> flatClasses) {

		if (checkedClass.getEPackage() != flatPackage && !flatClasses.containsKey(checkedClass.getName())) { // not in same package (assuming package == file)
			EClass flatClass = EcoreUtil.copy(checkedClass);
			flatClasses.put(flatClass.getName(), flatClass);
			flattenEClass(flatClass, flatPackage, flatClasses);

			return flatClass;
		}

		return flatClasses.get(checkedClass.getName());
	}

	private static void cleanupCheckOCLConstraintConsistency(IProject tempProject) {

		try {
			if (tempProject != null) {
				tempProject.delete(true, true, null);
			}
		}
		catch (CoreException e) {
			MMINTException.print(MMINTException.Type.WARNING, "Can't delete EMFtoCSP temporary project", e);
		}
	}

	public static boolean checkOCLConstraintConsistency(Model modelType, String oclConstraint) {

		// detect EMFtoCSP
		if (Platform.getBundle(EMFTOCSP_BUNDLE) == null) {
			MMINTException.print(MMINTException.Type.WARNING, "Can't find EMFtoCSP installation, skipping consistency check", null);
			return true;
		}

		EPackage modelTypeObj;
		try {
			modelTypeObj = (EPackage) getOCLConstraintContext(modelType, oclConstraint, false);
		}
		catch (MMINTException e) {
			MMINTException.print(MMINTException.Type.WARNING, "Can't get context for OCL constraint", e);
			return false;
		}
		String modelTypeName = modelType.getName();
		//TODO MMINT[CONSTRAINT] find language to express more complex contraints on model rels
		// create and-ed global constraint
		//TODO MMINT[CONSTRAINT] when invoked from add/remove don't consider the constraint on itself
		String oclConsistencyConstraint = (modelType instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) ?
			oclConstraint.substring(oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR) + 1, oclConstraint.length()) :
			oclConstraint;
		while (!MultiModelTypeHierarchy.isRootType(modelType)) {
			ExtendibleElementConstraint constraint = modelType.getConstraint();
			if (constraint != null && constraint.getLanguage() == ExtendibleElementConstraintLanguage.OCL && constraint.getImplementation() != null && !constraint.getImplementation().equals("")) {
				oclConsistencyConstraint += " and ";
				oclConsistencyConstraint += (modelType instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) ?
					constraint.getImplementation().substring(constraint.getImplementation().indexOf(OCL_VARIABLE_SEPARATOR) + 1, constraint.getImplementation().length()) :
					constraint.getImplementation();
			}
			modelType = modelType.getSupertype();
		}
		// a constraint on model rel must be consistent with endpoints
		if (modelType instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
			return checkOCLConstraintConsistency(MultiModelTypeRegistry.<Model>getType(modelTypeObj.getNsURI()), oclConsistencyConstraint);
		}
		// flatten hierarchy and add constraint as annotation into the metamodel
		ResourceSet flatResourceSet = new ResourceSetImpl();
		String flatUri = EMFTOCSP_TEMPPROJECT + IPath.SEPARATOR + EMFTOCSP_TEMPFOLDER + IPath.SEPARATOR + modelTypeName + MMINT.MODEL_FILEEXTENSION_SEPARATOR + EcorePackage.eNAME;
		Resource flatResource = flatResourceSet.createResource(URI.createPlatformResourceURI(flatUri, true));
		EPackage flatModelTypeObj = EcoreUtil.copy(modelTypeObj);
		flatResource.getContents().add(flatModelTypeObj);
		flattenEPackage(flatModelTypeObj);
		EAnnotation newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		newEAnnotation.setSource(EcorePackage.eNS_URI);
		EMap<String, String> newEAnnotationDetails = newEAnnotation.getDetails();
		newEAnnotationDetails.put(MultiModelTypeFactory.ECORE_VALIDATION_DELEGATE, MultiModelTypeFactory.ECORE_PIVOT_URI);
		flatModelTypeObj.getEAnnotations().add(newEAnnotation);
		EClass modelTypeRootObj = (EClass) flatModelTypeObj.getEClassifiers().get(0);
		newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		newEAnnotation.setSource(EcorePackage.eNS_URI);
		newEAnnotationDetails = newEAnnotation.getDetails();
		newEAnnotationDetails.put(MultiModelTypeFactory.ECORE_VALIDATION_CONSTRAINTS, ECORE_PIVOT_CONSISTENCYCONSTRAINT);
		modelTypeRootObj.getEAnnotations().add(newEAnnotation);
		newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		newEAnnotation.setSource(MultiModelTypeFactory.ECORE_PIVOT_URI);
		newEAnnotationDetails = newEAnnotation.getDetails();
		newEAnnotationDetails.put(ECORE_PIVOT_CONSISTENCYCONSTRAINT, oclConsistencyConstraint);
		modelTypeRootObj.getEAnnotations().add(newEAnnotation);
		// use EMFtoCSP to check strong satisfiability
		EPackage modelTypeObjToRestore = EPackage.Registry.INSTANCE.getEPackage(flatModelTypeObj.getNsURI()); // EMFtoCSP will mess this up, save it to restore later
		// EMFtoCSP ui screen 4 (preview)
		IProject tempProject = ResourcesPlugin.getWorkspace().getRoot().getProject(EMFTOCSP_TEMPPROJECT);
		IFolder resultLocation;
		try {
			if (!tempProject.exists()) {
				tempProject.create(null);
			}
			if (!tempProject.isOpen()) {
				tempProject.open(null);
			}
			resultLocation = tempProject.getFolder(EMFTOCSP_TEMPFOLDER);
			if (!resultLocation.exists()) {
				resultLocation.create(true, true, null);
			}
			MultiModelUtils.createModelFile(flatModelTypeObj, flatUri, true);
		}
		catch (Exception e) {
			MMINTException.print(MMINTException.Type.WARNING, "Can't create EMFtoCSP temporary project, skipping consistency check", e);
			cleanupCheckOCLConstraintConsistency(tempProject);
			return true;
		}
		// EMFtoCSP init
		String eclipsePath = Activator.getDefault().getPreferenceStore().getString(EMFTOCSP_PREFERENCE_ECLIPSEPATH);
		String graphvizPath = Activator.getDefault().getPreferenceStore().getString(EMFTOCSP_PREFERENCE_GRAPHVIZPATH);
		ICspSolver<?> solver = new EclipseSolver(eclipsePath, graphvizPath);
		IModelToCspSolverFactory<Resource, CompoundTerm> modelSolverFactory = new EmfModelToCspSolverFactory();
		IModelToCspSolver<Resource, CompoundTerm> modelSolver = modelSolverFactory.getModelToCspSolver();
		modelSolver.setModelFileName(modelTypeName);
		modelSolver.setModel(flatModelTypeObj.eResource());
		modelSolver.setSolver(solver);
		modelSolver.setCspCodeGenerator(new EmfToEclCodeGenerator(modelSolver));
		modelSolver.getBuilder();
		// EMFtoCSP ui screen 1
		IFile oclFile = null;
		modelSolver.setConstraintsDocument(oclFile);
		// EMFtoCSP ui screen 2
		Map<String, String> modelElementsDomain = new HashMap<String, String>();
		modelSolver.setModelElementsDomain(modelElementsDomain);
		@SuppressWarnings("unchecked")
		IModelReader<Resource, EPackage, EClass, EAssociation, EAttribute, EOperation> modelReader = (IModelReader<Resource, EPackage, EClass, EAssociation, EAttribute, EOperation>) modelSolver.getModelReader();    
		for (EClass c : modelReader.getClasses()) {
			modelElementsDomain.put(c.getEPackage().getName() + "." + c.getName(), "0..5");
			for (EAttribute at : modelReader.getClassAttributes(c)) { 
				if (at.getEAttributeType().getName().equalsIgnoreCase("boolean") || at.getEAttributeType().getName().equalsIgnoreCase("boolean")) {
					modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName(), "0..1");
				}
				else if (at.getEAttributeType().getName().equalsIgnoreCase("string") || at.getEAttributeType().getName().equalsIgnoreCase("estring") ) {
					modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName() + ".length", "0..10");
					modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName() + ".domain", "");
				}
				else {
					modelElementsDomain.put(at.getEContainingClass().getName() + "." + at.getName(), "[1,10,20]");
				}
			}
		}
		for (String asName : modelReader.getAssociationsNames()) {
			modelElementsDomain.put(asName, "0..10");
		}
		// EMFtoCSP ui screen 3
		List<IModelProperty> modelProperties = new ArrayList<IModelProperty>();
		modelProperties.add(new StrongSatisfiabilityModelProperty());
		modelSolver.setModelProperties(modelProperties);
		// EMFtoCSP ui screen 4 (reprise)
		modelSolver.setResultLocation(resultLocation);
		// EMFtoCSP performFinish()
		File importsFolder;
		try {
			importsFolder = new File(FileLocator.toFileURL(FrameworkUtil.getBundle(fr.inria.atlanmod.emftocsp.eclipsecs.EclipseSolver.class).getEntry("/libs")).getFile());
		}
		catch (Exception e) {
			MMINTException.print(MMINTException.Type.WARNING, "Can't find EMFtoCSP libs, skipping consistency check", e);
			cleanupCheckOCLConstraintConsistency(tempProject);
			return true;
		}
		File[] libs = importsFolder.listFiles(
			new FilenameFilter() {
				public boolean accept(File dir, String name) {    
					return name.matches(".*\\.ecl$");
				}
			}
		);
		ArrayList<File> libList = new ArrayList<File>();
		for(int i = 0; i < libs.length; i++) {
			libList.add(libs[i]);
		}
		boolean isConsistent = modelSolver.solveModel(libList);
		EPackage.Registry.INSTANCE.put(flatModelTypeObj.getNsURI(), modelTypeObjToRestore); // EMFtoCSP messed this up, restore it
		cleanupCheckOCLConstraintConsistency(tempProject);

		return isConsistent;
	}

	public static boolean checkConstraintConsistency(ExtendibleElement type, String constraintLanguage, String constraintImplementation) {

		if (!(type instanceof Model) || constraintImplementation.equals("")) {
			return true;
		}

		switch (ExtendibleElementConstraintLanguage.valueOf(constraintLanguage)) {
			case OCL:
				return checkOCLConstraintConsistency((Model) type, constraintImplementation);
			case JAVA:
				return true;
			case SMTLIB:
				return true;
			default:
				return false;
		}
	}

}
