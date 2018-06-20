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
package edu.toronto.cs.se.mmint.mid.reasoning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.utils.PrimitiveEObjectWrapper;

/**
 * The constraint checker for multimodels.
 *
 * @author Alessio Di Sandro
 *
 */
public class MIDConstraintChecker {

	public static boolean isAllowedModelType(ModelRel modelRelType) {

		MID typeMID = modelRelType.getMIDContainer();
		List<ModelRel> modelRelSubtypes = MIDTypeHierarchy.getSubtypes(modelRelType, typeMID);

		return (modelRelSubtypes.isEmpty()) ? true : false;
	}

	public static boolean isAllowedModelTypeEndpoint(BinaryModelRel modelRelType, Model newSrcModelType, Model newTgtModelType) {

		if (newSrcModelType == null && newTgtModelType == null) { // model type not added yet
			return true;
		}

		ModelRel modelRelTypeSuper = (ModelRel) modelRelType.getSupertype();
		// checks that the new model type is the same of the super model rel type or is overriding it
		if (!MIDTypeHierarchy.isRootType(modelRelTypeSuper)) {
			MID typeMID = modelRelType.getMIDContainer();
			if (newSrcModelType != null) {
				String srcUri = modelRelTypeSuper.getModelEndpoints().get(0).getTargetUri();
				String newSrcUri = newSrcModelType.getUri();
				if (!newSrcUri.equals(srcUri) && !MIDTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, typeMID)) {
					return false;
				}
			}
			if (newTgtModelType != null) {
				String tgtUri = modelRelTypeSuper.getModelEndpoints().get(1).getTargetUri();
				String newTgtUri = newTgtModelType.getUri();
				if (!newTgtUri.equals(tgtUri) && !MIDTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, typeMID)) {
					return false;
				}
			}
		}

		return true;
	}

	public static boolean isAllowedModelElementTypeEndpointReference(BinaryMappingReference mappingTypeRef, ModelElementReference newSrcModelElemTypeRef, ModelElementReference newTgtModelElemTypeRef) {

		if (newSrcModelElemTypeRef == null && newTgtModelElemTypeRef == null) { // model element type reference not added yet
			return true;
		}

		Mapping mappingTypeSuper = mappingTypeRef.getObject().getSupertype();
		// checks that the new model element type is the same of the super link type or is overriding it
		if (!MIDTypeHierarchy.isRootType(mappingTypeSuper)) {
			MID typeMID = mappingTypeRef.getMIDContainer();
			if (newSrcModelElemTypeRef != null) {
				String srcUri = mappingTypeSuper.getModelElemEndpoints().get(0).getTargetUri();
				String newSrcUri = newSrcModelElemTypeRef.getUri();
				if (!newSrcUri.equals(srcUri) && !MIDTypeHierarchy.isSubtypeOf(newSrcUri, srcUri, typeMID)) {
					return false;
				}
			}
			if (newTgtModelElemTypeRef != null) {
				String tgtUri = mappingTypeSuper.getModelElemEndpoints().get(1).getTargetUri();
				String newTgtUri = newTgtModelElemTypeRef.getUri();
				if (!newTgtUri.equals(tgtUri) && !MIDTypeHierarchy.isSubtypeOf(newTgtUri, tgtUri, typeMID)) {
					return false;
				}
			}
		}

		return true;
	}

	public static List<String> getAllowedModelRelTypes(Model targetSrcModel, Model targetTgtModel) {

		List<String> modelRelTypeUris = new ArrayList<>();
		for (ModelRel modelRelType : MIDTypeRegistry.getModelRelTypes()) {
			boolean isAllowed = true, isAllowedSrc = false, isAllowedTgt = false;
			HashMap<String, Integer> cardinalityTable = new HashMap<>();
			//TODO MMINT[INTROSPECTION] consider direction for binary?
			if (targetSrcModel != null) {
				for (ModelEndpointReference modelTypeEndpointRef : modelRelType.getModelEndpointRefs()) {
					if (MIDConstraintChecker.isAllowedModelEndpoint(modelTypeEndpointRef, targetSrcModel, cardinalityTable)) {
						MIDRegistry.addEndpointCardinality(modelTypeEndpointRef.getUri(), cardinalityTable);
						isAllowedSrc = true;
						break;
					}
				}
				isAllowed = isAllowed && isAllowedSrc;
			}
			if (targetTgtModel != null) {
				for (ModelEndpointReference modelTypeEndpointRef : modelRelType.getModelEndpointRefs()) {
					if (MIDConstraintChecker.isAllowedModelEndpoint(modelTypeEndpointRef, targetTgtModel, cardinalityTable)) {
						MIDRegistry.addEndpointCardinality(modelTypeEndpointRef.getUri(), cardinalityTable);
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

	public static List<Mapping> getAllowedMappingTypes(ModelRel modelRelType, ModelElementReference targetSrcModelElemRef, ModelElementReference targetTgtModelElemRef) {

		List<Mapping> mappingTypes = new ArrayList<>();
        // shortcut for empty model rel types that just take advantage of types of endpoints
        if (modelRelType.getMappingRefs().isEmpty() && MIDTypeHierarchy.isRootType(modelRelType.getSupertype())) {
            mappingTypes.add(MIDTypeHierarchy.getRootMappingType());
            return mappingTypes;
        }
		for (MappingReference mappingTypeRef : modelRelType.getMappingRefs()) {
			boolean isAllowed = true, isAllowedSrc = false, isAllowedTgt = false;
			HashMap<String, Integer> cardinalityTable = new HashMap<>();
			//TODO MMINT[INTROSPECTION] consider direction for binary?
			if (targetSrcModelElemRef != null) {
				for (ModelElementEndpointReference modelElemTypeEndpointRef : mappingTypeRef.getObject().getModelElemEndpointRefs()) {
					if (MIDConstraintChecker.isAllowedModelElementEndpointReference(modelElemTypeEndpointRef.getObject(), targetSrcModelElemRef, cardinalityTable)) {
						MIDRegistry.addEndpointCardinality(modelElemTypeEndpointRef.getUri(), cardinalityTable);
						isAllowedSrc = true;
						break;
					}
				}
				isAllowed = isAllowed && isAllowedSrc;
			}
			if (targetTgtModelElemRef != null) {
				for (ModelElementEndpointReference modelElemTypeEndpointRef : mappingTypeRef.getObject().getModelElemEndpointRefs()) {
					if (MIDConstraintChecker.isAllowedModelElementEndpointReference(modelElemTypeEndpointRef.getObject(), targetTgtModelElemRef, cardinalityTable)) {
						MIDRegistry.addEndpointCardinality(modelElemTypeEndpointRef.getUri(), cardinalityTable);
						isAllowedTgt = true;
						break;
					}
				}
				isAllowed = isAllowed && isAllowedTgt;
			}
			if (isAllowed) {
				mappingTypes.add(mappingTypeRef.getObject());
			}
		}
		// check for overrides
		for (Mapping mappingType : mappingTypes) {
			//TODO MMINT[OVERRIDE] if one link type points to another one in this list through its override pointer, then delete it
		}

		return mappingTypes;
	}

	public static boolean isAllowedModelEndpoint(ModelEndpointReference modelTypeEndpointRef, Model targetModel, Map<String, Integer> cardinalityTable) {

		//TODO MMINT[INTROSPECTION] consider static (like now) or runtime types?
		String targetModelTypeUri = targetModel.getMetatypeUri();
		// check if the type is allowed
		if (modelTypeEndpointRef.getTargetUri().equals(targetModelTypeUri) || MIDTypeHierarchy.isSubtypeOf(targetModelTypeUri, modelTypeEndpointRef.getTargetUri())) {
			// check if the cardinality is allowed
			if (MIDRegistry.checkNewEndpointUpperCardinality(modelTypeEndpointRef.getObject(), cardinalityTable)) {
				return true;
			}
		}

		return false;
	}

	public static @Nullable List<String> getAllowedModelEndpoints(@NonNull ModelRel modelRel, @Nullable ModelEndpoint oldModelEndpoint, @Nullable Model targetModel) {

		if (targetModel == null) { // model not added yet
			return new ArrayList<>();
		}

		List<String> modelTypeEndpointUris = null;
		// count existing instances
		HashMap<String, Integer> cardinalityTable = new HashMap<>();
		for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
			MIDRegistry.addEndpointCardinality(modelEndpoint.getMetatypeUri(), cardinalityTable);
		}
		// possibly subtract model endpoint to be replaced
		if (oldModelEndpoint != null) {
			try {
				MIDRegistry.subtractEndpointCardinality(oldModelEndpoint.getMetatypeUri(), cardinalityTable);
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.WARNING, "The model endpoint to be replaced can't be found in the model relationship, skipping it", e);
			}
		}
		// check allowance
		for (ModelEndpointReference modelTypeEndpointRef : modelRel.getMetatype().getModelEndpointRefs()) {
			if (isAllowedModelEndpoint(modelTypeEndpointRef, targetModel, cardinalityTable)) {
				if (modelTypeEndpointUris == null) {
					modelTypeEndpointUris = new ArrayList<>();
				}
				modelTypeEndpointUris.add(modelTypeEndpointRef.getUri());
			}
		}

		return modelTypeEndpointUris;
	}

	public static boolean areAllowedModelEndpoints(ModelRel modelRel, ModelRel newModelRelType) {

		HashMap<String, Integer> cardinalityTable = new HashMap<>();
		for (ModelEndpoint modelEndpoint : modelRel.getModelEndpoints()) {
			boolean isAllowed = false;
			//TODO MMINT[INTROSPECTION] order of visit might affect the result, should be from the most specific to the less
			for (ModelEndpointReference modelTypeEndpointRef : newModelRelType.getModelEndpointRefs()) {
				if (isAllowed = isAllowedModelEndpoint(modelTypeEndpointRef, modelEndpoint.getTarget(), cardinalityTable)) {
					MIDRegistry.addEndpointCardinality(modelTypeEndpointRef.getUri(), cardinalityTable);
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

		//TODO MMINT[INTROSPECTION] consider static (like now) or runtime types?
		String newModelElemTypeUri = newModelElemRef.getObject().getMetatypeUri();
		// check if the type is allowed
		if (modelElemTypeEndpoint.getTargetUri().equals(newModelElemTypeUri) || MIDTypeHierarchy.isSubtypeOf(newModelElemTypeUri, modelElemTypeEndpoint.getTargetUri())) {
			// check if the cardinality is allowed
			if (MIDRegistry.checkNewEndpointUpperCardinality(modelElemTypeEndpoint, cardinalityTable)) {
				return true;
			}
		}

		return false;
	}

	public static List<String> getAllowedModelElementEndpointReferences(MappingReference mappingRef, ModelElementEndpointReference oldModelElemEndpointRef, ModelElementReference newModelElemRef) {

		if (newModelElemRef == null) { // model element reference not added yet
			return new ArrayList<>();
		}

		List<String> modelElemTypeEndpointUris = null;
		// count existing instances
		HashMap<String, Integer> cardinalityTable = new HashMap<>();
		for (ModelElementEndpointReference modelElemEndpointRef : mappingRef.getModelElemEndpointRefs()) {
			MIDRegistry.addEndpointCardinality(modelElemEndpointRef.getObject().getMetatypeUri(), cardinalityTable);
		}
		// possibly subtract model element endpoint to be replaced
		if (oldModelElemEndpointRef != null) {
			try {
				MIDRegistry.subtractEndpointCardinality(oldModelElemEndpointRef.getObject().getMetatypeUri(), cardinalityTable);
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.WARNING, "The model element endpoint to be replaced can't be found in the link, skipping it", e);
			}
		}
		// check allowance
		for (ModelElementEndpoint modelElemTypeEndpoint : mappingRef.getObject().getMetatype().getModelElemEndpoints()) {
			if (isAllowedModelElementEndpointReference(modelElemTypeEndpoint, newModelElemRef, cardinalityTable)) {
				if (modelElemTypeEndpointUris == null) {
					modelElemTypeEndpointUris = new ArrayList<>();
				}
				modelElemTypeEndpointUris.add(modelElemTypeEndpoint.getUri());
			}
		}

		return modelElemTypeEndpointUris;
	}

	public static boolean areAllowedModelElementEndpointReferences(Mapping mapping, Mapping newMappingType) {

		HashMap<String, Integer> cardinalityTable = new HashMap<>();
		for (ModelElementEndpointReference modelElemEndpointRef : mapping.getModelElemEndpointRefs()) {
			boolean isAllowed = false;
			//TODO MMINT[INTROSPECTION] order of visit might affect the result, should be from the most specific to the less
			for (ModelElementEndpointReference modelElemTypeEndpointRef : newMappingType.getModelElemEndpointRefs()) {
				if (isAllowed = isAllowedModelElementEndpointReference(modelElemTypeEndpointRef.getObject(), modelElemEndpointRef.getModelElemRef(), cardinalityTable)) {
					MIDRegistry.addEndpointCardinality(modelElemTypeEndpointRef.getUri(), cardinalityTable);
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
		if (MIDTypeHierarchy.isRootType(modelElemType)) {
			return true;
		}
		// check model element compliance
		EMFInfo modelObjEInfo = MIDRegistry.getModelElementEMFInfo(modelObj, MIDLevel.INSTANCES), modelElemTypeEInfo = modelElemType.getEInfo();
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
		//TODO MMINT[UML] review
//		if (modelObj instanceof NamedElement) {
//			for (Stereotype stereotype : ((NamedElement) modelObj).getApplicableStereotypes()) {
//				if (
//					modelElemTypeEInfo.getClassName().equals(stereotype.getName()) ||
//					stereotype.getName().equals(MAVOUtils.MAVO_UML_STEREOTYPE_EQUIVALENCE.get(modelElemTypeEInfo.getClassName()))
//				) {
//					return true;
//				}
//			}
//		}

		return false;
	}

	public static ModelElement getAllowedModelElementType(ModelEndpointReference modelEndpointRef, EObject modelObj) {

		ModelRel modelRelType = ((ModelRel) modelEndpointRef.eContainer()).getMetatype();
		ModelEndpointReference modelTypeEndpointRef = MIDRegistry.getReference(modelEndpointRef.getObject().getMetatypeUri(), modelRelType.getModelEndpointRefs());
        // shortcut for empty model rel types that just take advantage of types of endpoints
		if (modelTypeEndpointRef.getModelElemRefs().isEmpty() && MIDTypeHierarchy.isRootType(modelRelType.getSupertype())) {
		    return MIDTypeHierarchy.getRootModelElementType();
		}
		// search for an allowed model element type
		Iterator<ModelElementReference> modelElemTypeRefIter = MIDTypeHierarchy.getInverseTypeRefHierarchyIterator(modelTypeEndpointRef.getModelElemRefs());
		while (modelElemTypeRefIter.hasNext()) {
			ModelElementReference modelElemTypeRef = modelElemTypeRefIter.next();
			if (isAllowedModelElement(modelTypeEndpointRef, modelObj, modelElemTypeRef.getObject())) {
				return modelElemTypeRef.getObject();
			}
		}
		//TODO MMINT[MODELELEMENT] what about dropped supertypes now, since they can be in a different model type ref?

		return null;
	}

	public static Mapping getAllowedMappingType(Mapping mapping) {

		ModelRel modelRelType = ((ModelRel) mapping.eContainer()).getMetatype();
mappingTypes:
		for (Mapping mappingType : modelRelType.getMappings()) {
			HashSet<String> allowedModelElemTypes = new HashSet<>();
			for (ModelElementEndpoint modelElemTypeEndpoint : mappingType.getModelElemEndpoints()) {
				allowedModelElemTypes.add(modelElemTypeEndpoint.getTargetUri());
			}
			for (ModelElementEndpoint modelElemEndpoint : mapping.getModelElemEndpoints()) {
				if (!allowedModelElemTypes.contains(modelElemEndpoint.getTarget().getMetatypeUri())) {
					continue mappingTypes;
				}
			}
			return mappingType;
		}

		return null;
	}

	public static @NonNull IReasoningEngine getReasoner(@NonNull String constraintLanguage) throws MMINTException {

		Map<String, IReasoningEngine> reasoners = MMINT.getLanguageReasoners(constraintLanguage);
		if (reasoners == null || reasoners.isEmpty()) {
			throw new MMINTException("Can't find a reasoner for language " + constraintLanguage);
		}
		String reasonerName = MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_LANGUAGE_REASONER + constraintLanguage);
		IReasoningEngine reasoner = reasoners.get(reasonerName);
		if (reasoner == null) {
			throw new MMINTException("Can't find reasoner " + reasonerName);
		}

		return reasoner;
	}

	/**
	 * Checks if a constraint is satisfied on a model.
	 *
	 * @param model
	 *            The model.
	 * @param constraint
	 *            The constraint.
	 * @return True if the constraint is satisfied, false otherwise.
	 */
	public static boolean checkModelConstraint(@NonNull Model model, @Nullable ExtendibleElementConstraint constraint) {

		if (constraint == null || constraint.getImplementation() == null || constraint.getImplementation().equals("")) {
			return true;
		}
		IReasoningEngine reasoner;
		try {
			reasoner = getReasoner(constraint.getLanguage());
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping model constraint check", e);
			return false;
		}
		MIDLevel constraintLevel;
		if (!model.getUri().equals(((ExtendibleElement) constraint.eContainer()).getUri())) {
			constraintLevel = MIDLevel.TYPES;
		}
		else {
			constraintLevel = MIDLevel.INSTANCES;
		}

		return reasoner.checkModelConstraint(model, constraint, constraintLevel);
	}

	public static boolean checkOperatorGenericConstraint(@Nullable ExtendibleElementConstraint constraint, @NonNull GenericEndpoint genericTypeEndpoint, @NonNull GenericElement genericType, @NonNull List<OperatorInput> inputs) {

		if (constraint == null || constraint.getImplementation() == null || constraint.getImplementation().equals("")) {
			return true;
		}
		IReasoningEngine reasoner;
		try {
			reasoner = MIDConstraintChecker.getReasoner(constraint.getLanguage());
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping operator generic constraint check", e);
			return false;
		}

		return reasoner.checkOperatorGenericConstraint(constraint, genericTypeEndpoint, genericType, inputs);
	}

	public static boolean checkOperatorInputConstraint(@Nullable ExtendibleElementConstraint constraint, @NonNull Map<String, Model> inputsByName) {

		if (constraint == null || constraint.getImplementation() == null || constraint.getImplementation().equals("")) {
			return true;
		}
		IReasoningEngine reasoner;
		try {
			reasoner = MIDConstraintChecker.getReasoner(constraint.getLanguage());
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping operator input constraint check", e);
			return false;
		}

		return reasoner.checkOperatorInputConstraint(constraint, inputsByName);
	}

	public static Map<ModelRel, List<Model>> getOperatorOutputConstraints(@Nullable ExtendibleElementConstraint constraint, @NonNull Map<String, Model> inputsByName, @NonNull Map<String, Model> outputsByName) {

		if (constraint == null || constraint.getImplementation() == null || constraint.getImplementation().equals("")) {
			return new HashMap<>();
		}
		IReasoningEngine reasoner;
		try {
			reasoner = MIDConstraintChecker.getReasoner(constraint.getLanguage());
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping operator output constraints", e);
			return new HashMap<>();
		}

		return reasoner.getOperatorOutputConstraints(constraint, inputsByName, outputsByName);
	}

	public static boolean checkModelConstraintConsistency(ExtendibleElement type, String constraintLanguage, String constraintImplementation) {

		if (!(type instanceof Model) || constraintImplementation.equals("")) {
			return true;
		}
		IReasoningEngine reasoner;
		try {
			reasoner = getReasoner(constraintLanguage);
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping constraint consistency check", e);
			return true;
		}

		return reasoner.checkModelConstraintConsistency((Model) type, constraintImplementation);
	}

	//TODO MMINT[REFINE] Should really throw an exception with errors instead of returning null
	public static @Nullable Model refineModelByConstraint(@NonNull Model model) {

		if (model.getConstraint() == null) {
			return null;
		}

		IReasoningEngine reasoner;
		try {
			reasoner = getReasoner(model.getConstraint().getLanguage());
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Skipping constraint-based refinement", e);
			return null;
		}

		//TODO MMINT[MU-MMINT] Should copy the model constraint to the new model? option to do it or not?
		return reasoner.refineModelByConstraint(model);
	}

}
