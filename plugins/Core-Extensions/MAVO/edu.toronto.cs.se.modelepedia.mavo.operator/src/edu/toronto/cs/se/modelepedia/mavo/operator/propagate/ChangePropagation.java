/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.mavo.operator.propagate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOBinaryMappingReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOBinaryModelRel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ChangePropagation extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELREL1 = "refinement";
	private final static @NonNull String IN_MODELREL2 = "trace";
	private final static @NonNull String OUT_MODEL = "propagated";
	private final static @NonNull String OUT_MODELREL1 = "propagatedRefinement";
	private final static @NonNull String OUT_MODELREL2 = "propagatedTrace";
	// constants
	private final static String PROP_MODEL_SUFFIX = "_propagated";
	private final static String PROPTRACE_RULE4_LINK_NAME = "rule4Trace";
	private final static String NAME_FEATURE = "name";

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean checkInputs(Map<String, Model> inputsByName) {

			//TODO MMINT[OPERATOR] Check that refinement and trace share a model, and that all models involved are mavo models
			return true;
		}

		@Override
		public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName, Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

			//TODO MMINT[CONSTRAINT] Implement
			return new HashMap<>();
		}
	}

	/**
	 * Removes a model element and the reference to it from the Instance MID
	 * that contains them.
	 *
	 * @param modelElemRef
	 *            The reference to be removed to the model element to be
	 *            removed.
	 */
	private void removeModelElementAndModelElementReference(ModelElementReference modelElemRef) throws MMINTException {

		//TODO MMINT[OO] does this have a meaning somewhere else?
		var instanceMID = modelElemRef.getMIDContainer();
		instanceMID.getExtendibleTable().removeKey(modelElemRef.getUri());
		modelElemRef.deleteInstanceReference();
		var modelElem = modelElemRef.getObject();
		((Model) modelElem.eContainer()).getModelElems().remove(modelElem);
		//TODO MMINT[OO] should remove from all model rels too?
	}

	private ModelElementReference getModelElementReference(ModelElementReference correspondingModelElemRef, EList<ModelElementReference> modelElemRefs) {

		if (correspondingModelElemRef == null) {
			return null;
		}

        String correspondingModelElemRefUri = MIDRegistry.getModelObjectUri(correspondingModelElemRef.getObject());
        for (ModelElementReference modelElemRef : modelElemRefs) {
            if (correspondingModelElemRefUri.equals(MIDRegistry.getModelObjectUri(modelElemRef.getObject()))) {
                return modelElemRef;
            }
        }

        return null;
	}

	private List<MAVOBinaryMappingReference> propagateTraceMappingsFromRefinements(MappingReference refinementMappingRef, MAVOBinaryModelRel traceRel, MAVOModel newPropModel, MAVOBinaryModelRel newPropTraceRel) throws Exception {

		var origModelEndpointRef_traceRel = traceRel.getModelEndpointRefs().get(0);
		var origModelUri = origModelEndpointRef_traceRel.getTargetUri();

		// get model element refs in trace rel that got refined
		List<ModelElementReference> refinedModelElemRefs_refinementRel = new ArrayList<>();
		List<ModelElementReference> origModelElemRefs_traceRel = new ArrayList<>();
		for (ModelElementEndpointReference refinementModelElemEndpointRef : refinementMappingRef.getModelElemEndpointRefs()) {
			var refinementModelElemRef = refinementModelElemEndpointRef.getModelElemRef();
			if (((ModelEndpointReference) refinementModelElemRef.eContainer()).getTargetUri().equals(origModelUri)) { // orig model element ref in trace rel
				var origModelElemRef_traceRel = getModelElementReference(refinementModelElemRef, origModelEndpointRef_traceRel.getModelElemRefs());
				if (origModelElemRef_traceRel == null) { // no trace for this model element
					continue;
				}
				origModelElemRefs_traceRel.add(origModelElemRef_traceRel);
			}
			else { // refined model element ref in refinement rel
				refinedModelElemRefs_refinementRel.add(refinementModelElemRef);
			}
		}

		// no propagation or rule 4 propagation
		List<MAVOBinaryMappingReference> newPropTraceMappingRefs = new ArrayList<>();
		if (origModelElemRefs_traceRel.isEmpty()) {
			if (refinementMappingRef.getModelElemEndpointRefs().size() == 1) {
				for (ModelElementReference refinedModelElemRef_refinementRel : refinedModelElemRefs_refinementRel) {
					var newPropTraceMappingRef = createDanglingTraceMapping(refinedModelElemRef_refinementRel, newPropTraceRel, 0, 1);
					if (newPropTraceMappingRef != null) {
						newPropTraceMappingRefs.add(newPropTraceMappingRef);
					}
				}
			}
			return newPropTraceMappingRefs;
		}

		// propagate trace links
		List<ModelElementReference> newRefinedModelElemRefs_propTraceRel = new ArrayList<>();
		var refinedModelEndpointRef_propTraceRel = newPropTraceRel.getModelEndpointRefs().get(0);
		for (ModelElementReference refinedModelElemRef_refinementRel : refinedModelElemRefs_refinementRel) {
			// create refined model elem ref in propagated trace rel
			var newRefinedModelElemRef_propTraceRel = refinedModelEndpointRef_propTraceRel.createModelElementInstanceAndReference(refinedModelElemRef_refinementRel.getObject().getEMFInstanceObject(), refinedModelElemRef_refinementRel.getObject().getName());
			newRefinedModelElemRefs_propTraceRel.add(newRefinedModelElemRef_propTraceRel);
		}
		var propModelEndpointRef_propTraceRel = newPropTraceRel.getModelEndpointRefs().get(1);
		for (ModelElementReference origModelElemRef_traceRel : origModelElemRefs_traceRel) {
			for (ModelElementEndpointReference traceModelElemEndpointRef : origModelElemRef_traceRel.getModelElemEndpointRefs()) {
				var traceMappingRef = (MAVOBinaryMappingReference) traceModelElemEndpointRef.eContainer();
				var traceMapping = traceMappingRef.getObject();
				var relatedModelElemRef_traceRel = traceMappingRef.getTargetModelElemRef();
				var propModelObjUri =
					newPropModel.getUri() +
					MIDRegistry.getModelObjectUri(relatedModelElemRef_traceRel.getObject()).substring(relatedModelElemRef_traceRel.getUri().lastIndexOf(MMINTConstants.MODEL_URI_SEPARATOR));
				EObject propModelObj = FileUtils.readModelObject(propModelObjUri, null);
				// create propagated model elem ref in propagated trace rel
				var newPropModelElemRef_propTraceRel = propModelEndpointRef_propTraceRel.createModelElementInstanceAndReference(propModelObj, relatedModelElemRef_traceRel.getObject().getName());
				// create new propagated trace links
				for (ModelElementReference newRefinedModelElemRef_propTraceRel : newRefinedModelElemRefs_propTraceRel) {
					var newPropTraceMappingRef = (MAVOBinaryMappingReference) traceMapping.getMetatype().createInstanceAndReference(true, newPropTraceRel);
					traceMapping.getModelElemEndpoints().get(0).getMetatype().createInstanceAndReference(newRefinedModelElemRef_propTraceRel, newPropTraceMappingRef);
					traceMapping.getModelElemEndpoints().get(1).getMetatype().createInstanceAndReference(newPropModelElemRef_propTraceRel, newPropTraceMappingRef);
					MAVOMapping newPropTraceMapping = newPropTraceMappingRef.getObject();
					newPropTraceMapping.setName(traceMapping.getName());
					newPropTraceMapping.setMay(traceMapping.isMay());
					newPropTraceMapping.setSet(traceMapping.isSet());
					newPropTraceMapping.setVar(traceMapping.isVar());
					newPropTraceMappingRefs.add(newPropTraceMappingRef);
				}
			}
		}

		return newPropTraceMappingRefs;
	}

	private MAVOBinaryMappingReference createDanglingTraceMapping(ModelElementReference traceModelElemRefA, MAVOBinaryModelRel traceRel, int indexA, int indexB) throws MMINTException {

		// rule 4, 1st half
		if (!((MAVOModelEndpoint) traceRel.getModelEndpoints().get(indexB)).getTarget().isInc()) {
			return null;
		}
		ModelElement traceModelElemTypeA = MIDConstraintChecker.getAllowedModelElementType(
			traceRel.getModelEndpointRefs().get(indexA),
			traceModelElemRefA.getObject().getEMFInstanceObject()
		);
		if (traceModelElemTypeA == null) {
			return null;
		}

		MAVOBinaryMappingReference newTraceMappingRef = null;
		for (MappingReference traceMappingTypeRef : traceRel.getMetatype().getMappingRefs()) {
			if (!(traceMappingTypeRef instanceof BinaryMappingReference)) { // a trace rel type is meant to have two model types
				continue;
			}
			var traceModelElemTypeRefA = traceMappingTypeRef.getModelElemEndpointRefs().get(indexA).getModelElemRef();
			if (!traceModelElemTypeRefA.getUri().equals(traceModelElemTypeA.getUri())) {
				continue;
			}
			var traceModelElemTypeEndpointRefB = traceMappingTypeRef.getModelElemEndpointRefs().get(indexB);
			if (traceModelElemTypeEndpointRefB.getObject().getLowerBound() < 1) {
				continue;
			}
			// create new dangling trace link
			var newTraceModelElemRefA = traceRel.getModelEndpointRefs().get(indexA).createModelElementInstanceAndReference(traceModelElemRefA.getObject().getEMFInstanceObject(), traceModelElemRefA.getObject().getName());
			newTraceMappingRef = (MAVOBinaryMappingReference) traceMappingTypeRef.getObject().createInstanceAndReference(true, traceRel);
			newTraceMappingRef.getObject().setVar(true);
			newTraceMappingRef.getObject().setName(ChangePropagation.PROPTRACE_RULE4_LINK_NAME);
			traceMappingTypeRef.getModelElemEndpointRefs().get(indexA).getObject().createInstanceAndReference(newTraceModelElemRefA, newTraceMappingRef);
			// if more than one link type with same model element type A exist, they all get created (the user will merge unnecessary ones)
			//TODO MMINT[MAVO] should I also mark them as M, because I want them to be mutually exclusive?
			//TODO MMINT[MAVO] (prop rule that forces the removal of M if the endpoints are E sounds wrong in this case, mostly because mutual exclusion has not been formalized)
		}

		return newTraceMappingRef;
	}

	private List<MAVOBinaryMappingReference> reduceTraceMappingUncertainty(EObject modelRootB, List<MAVOBinaryMappingReference> propTraceMappingRefs, int indexA, int indexB) throws Exception {

		var n = 0;
		HashSet<String> uniqueModelElemUrisB = new HashSet<>();
		for (BinaryMappingReference traceMappingRef : propTraceMappingRefs) {
			if (traceMappingRef.getModelElemEndpointRefs().size() == 1) { // dangling link
				continue;
			}
			var traceModelElemRefB = traceMappingRef.getModelElemEndpointRefs().get(indexB).getModelElemRef();
			if (!uniqueModelElemUrisB.contains(traceModelElemRefB.getUri())) {
				n++;
				uniqueModelElemUrisB.add(traceModelElemRefB.getUri());
			}
		}

		var again = false;
		MappingReference unifiedMappingRef = null;
traceLinks:
		for (MAVOBinaryMappingReference traceMappingRef : propTraceMappingRefs) {
			var traceModelElemEndpointRefA = traceMappingRef.getModelElemEndpointRefs().get(indexA);
			var modelElemRefA = (MAVOModelElementReference) traceModelElemEndpointRefA.getModelElemRef();
			var modelElemA = modelElemRefA.getObject();

			// rule 4, 2nd half
			if (n == 0) {
				completeDanglingTraceMapping(modelRootB, traceMappingRef, modelElemA.getName(), indexB);
				again = true;
				continue;
			}

			var traceModelElemEndpointRefB = traceMappingRef.getModelElemEndpointRefs().get(indexB);
			var modelElemRefB = (MAVOModelElementReference) traceModelElemEndpointRefB.getModelElemRef();
			var modelElemB = modelElemRefB.getObject();
			var traceMapping = traceMappingRef.getObject();
			boolean Ma = modelElemA.isMay(), Sa = modelElemA.isSet(), Va = modelElemA.isVar();
			boolean Mab = traceMapping.isMay(), Sab = traceMapping.isSet(), Vab = traceMapping.isVar();
			boolean Mb = modelElemB.isMay(), Sb = modelElemB.isSet(), Vb = modelElemB.isVar();
			var Ua = traceModelElemEndpointRefA.getObject().getMetatype().getUpperBound();
			int Lb = traceModelElemEndpointRefB.getObject().getMetatype().getLowerBound(), Ub = traceModelElemEndpointRefB.getObject().getMetatype().getUpperBound();
			EObject modelObjB = FileUtils.readModelObject(
				MIDRegistry.getModelObjectUri(modelElemB),
				modelRootB.eResource()
			);

			// rule 1
			if (Mb && !Mab) {
				Mb = false;
				modelElemB.setMay(Mb);
				MAVOUtils.setMay(modelObjB, Mb);
				again = true;
			}
			// rule 2
			if (Sab && !Sa && !Sb) {
				Sab = false;
				traceMapping.setSet(Sab);
				again = true;
			}
			// rule 3
			if (Vab && !Va && !Vb) {
				Vab = false;
				traceMapping.setVar(Vab);
				again = true;
			}
			if (Lb == 1 && n == 1) {
				// rule 5
				if (Mab && !Ma) {
					Mab = false;
					traceMapping.setMay(Mab);
					again = true;
				}
			}
			if (Ub == 1) {
				if (Ua == -1) {
					// rule 6
					if (Sb && !Sa && !Mab) {
						Sb = false;
						modelElemB.setSet(Sb);
						MAVOUtils.setSet(modelObjB, Sb);
						again = true;
					}
				}
				// rule 7
				if (Vab && Vb && !Mab) {
					for (MAVOBinaryMappingReference traceMappingRef2 : propTraceMappingRefs) {
						if (traceMappingRef2 == traceMappingRef) {
							continue;
						}
						var Mac = traceMappingRef2.getObject().isMay();
						if (!Mac) {
							unifyVarTraceMapping(modelRootB, traceMappingRef, traceMappingRef2, indexA, indexB);
							unifiedMappingRef = traceMappingRef;
							again = true;
							break traceLinks;
						}
					}
				}
			}
		}
		// rule 7
		if (unifiedMappingRef != null) {
			propTraceMappingRefs.remove(unifiedMappingRef);
			unifiedMappingRef = null;
		}

		// keep reducing uncertainty
		if (again) {
			reduceTraceMappingUncertainty(modelRootB, propTraceMappingRefs, indexA, indexB);
		}

		return propTraceMappingRefs;
	}

	private void unifyModelElementUris(ModelElementReference unifiedModelElemRef, ModelElementReference modelElemRef) {

		var extendibleTable = modelElemRef.getMIDContainer().getExtendibleTable();
		String unifiedModelElemUri = MIDRegistry.getModelObjectUri(unifiedModelElemRef.getObject());
		String modelElemUri = MIDRegistry.getModelObjectUri(modelElemRef.getObject());
		var modelEndpointRef = (ModelEndpointReference) modelElemRef.eContainer();
		var unifiedModelElemUriBase = unifiedModelElemUri.substring(0, unifiedModelElemUri.lastIndexOf('.')+1);
		var unifiedModelElemUriIndex = Integer.parseInt(unifiedModelElemUri.substring(unifiedModelElemUri.lastIndexOf('.')+1));

		List<ModelElement> otherModelElems = new ArrayList<>();
		// first pass, modify model element uris
		for (ModelElement otherModelElem : modelEndpointRef.getObject().getTarget().getModelElems()) {
			String otherModelElemUri = MIDRegistry.getModelObjectUri(otherModelElem);
			// other model element to be affected by unification of model elements
			if (otherModelElemUri.contains(unifiedModelElemUriBase)) {
				var otherModelElemUriExtra = otherModelElemUri.substring(otherModelElemUri.lastIndexOf(unifiedModelElemUriBase) + unifiedModelElemUriBase.length());
				var otherModelElemUriIndex = (otherModelElemUriExtra.indexOf(MMINTConstants.URI_SEPARATOR) == -1) ?
					Integer.parseInt(otherModelElemUriExtra) :
					Integer.parseInt(otherModelElemUriExtra.substring(0, otherModelElemUriExtra.indexOf(MMINTConstants.URI_SEPARATOR)));
				String newOtherModelElemUri = null;
				if (otherModelElemUriIndex == unifiedModelElemUriIndex) { // uri to be fully replaced
					newOtherModelElemUri = otherModelElem.getUri().replace(unifiedModelElemUri, modelElemUri);
				}
				else if (otherModelElemUriIndex > unifiedModelElemUriIndex) { // uri to be shifted
					newOtherModelElemUri = otherModelElem.getUri().replace(unifiedModelElemUriBase + otherModelElemUriIndex, unifiedModelElemUriBase + --otherModelElemUriIndex);
				}
				if (newOtherModelElemUri != null) {
					extendibleTable.removeKey(otherModelElem.getUri());
					otherModelElem.setUri(newOtherModelElemUri);
					otherModelElems.add(otherModelElem);
				}
			}
		}
		// second pass, update extendible table
		for (ModelElement otherModelElem : otherModelElems) {
			extendibleTable.put(otherModelElem.getUri(), otherModelElem);
		}
	}

	@SuppressWarnings("unchecked")
	private void unifyVarTraceMapping(EObject modelRootB, BinaryMappingReference varTraceMappingRef, BinaryMappingReference traceMappingRef, int indexA, int indexB) throws Exception {

		var varModelElemRef = varTraceMappingRef.getModelElemEndpointRefs().get(indexB).getModelElemRef();
		var modelElemRef = traceMappingRef.getModelElemEndpointRefs().get(indexB).getModelElemRef();
		// get var object and other object from same resource
		EObject varModelObj = FileUtils.readModelObject(MIDRegistry.getModelObjectUri(varModelElemRef.getObject()), modelRootB.eResource());
		EObject modelObj = FileUtils.readModelObject(MIDRegistry.getModelObjectUri(modelElemRef.getObject()), modelRootB.eResource());
		// unify contents
		for (EObject varModelObjContent : varModelObj.eContents()) {
			var varModelObjContainingFeature = varModelObjContent.eContainingFeature();
			var value = modelObj.eGet(varModelObjContainingFeature);
			if (value instanceof EList) {
				((EList<EObject>) value).add(varModelObjContent);
			}
		}

		// remove var object
		 EcoreUtil.delete(varModelObj);
		//TODO MMINT[MISC] should we try to preserve references to it, maybe using EcoreUtil.CrossReferencer?
		// remove unified links and model elements
		removeModelElementAndModelElementReference(varModelElemRef);
		// update uris due to model element unification
		unifyModelElementUris(varModelElemRef, modelElemRef);
	}

	@SuppressWarnings("unchecked")
	private EObject[] navigateIncompleteModel(EObject currentContainer, EFactory modelTypeFactory, String modelElemTypeUri, String modelElemName) {

		for (EReference containment : currentContainer.eClass().getEAllContainments()) {
			var currentContainerCopy = EcoreUtil.copy(currentContainer);
			var containedEClass = (EClass) containment.getEType();
			var contained = modelTypeFactory.create(containedEClass);
			if (contained instanceof MAVOElement) {
				((MAVOElement) contained).setVar(true);
			}
			var feature = containedEClass.getEStructuralFeature(ChangePropagation.NAME_FEATURE);
			if (feature != null && feature instanceof EAttribute && ((EAttribute) feature).getEType().getName().equals("EString")) {
				contained.eSet(feature, modelElemName);
			}
			var value = currentContainerCopy.eGet(containment);
			if (value instanceof EList) {
				((EList<EObject>) value).add(contained);
			}
			else {
				currentContainerCopy.eSet(containment, contained);
			}

			// model element created
			if (modelElemTypeUri.equals(containedEClass.getName())) {
				var rootContainer = EcoreUtil.getRootContainer(currentContainerCopy);
				if (rootContainer == null) {
					rootContainer = currentContainerCopy;
				}
				return new EObject[] {rootContainer, contained};
			}

			// continue recursion
			var result = navigateIncompleteModel(contained, modelTypeFactory, modelElemTypeUri, modelElemName);
			if (result != null) {
				return result;
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private void completeDanglingTraceMapping(EObject modelRootB, MappingReference traceMappingRef, String modelElemName, int indexB) throws Exception {

		var modelEndpointRef = ((BinaryModelRel) traceMappingRef.eContainer()).getModelEndpointRefs().get(indexB);
		var model = modelEndpointRef.getObject().getTarget();
		var modelTypeFactory = model.getMetatype().getEMFTypeRoot().getEFactoryInstance();
		var modelElemTypeEndpointRef = traceMappingRef.getObject().getMetatype().getModelElemEndpointRefs().get(indexB);
		var modelElemType = modelElemTypeEndpointRef.getModelElemRef().getObject();
		String modelElemTypeUri = MIDRegistry.getModelElementUri(modelElemType.getEMFTypeObject());

		EObject[] result = null;
		for (EReference containment : modelRootB.eClass().getEAllContainments()) {
			var containedEClass = (EClass) containment.getEType();
			var contained = modelTypeFactory.create(containedEClass);
			if (contained instanceof MAVOElement) {
				((MAVOElement) contained).setVar(true);
			}
			var feature = containedEClass.getEStructuralFeature(ChangePropagation.NAME_FEATURE);
			if (feature != null && feature instanceof EAttribute && ((EAttribute) feature).getEType().getName().equals("EString")) {
				contained.eSet(feature, modelElemName);
			}
			result = navigateIncompleteModel(contained, modelTypeFactory, modelElemTypeUri, modelElemName);
			if (result != null) {
				var value = modelRootB.eGet(containment);
				if (value instanceof EList) {
					((EList<EObject>) value).add(result[0]);
				}
				else {
					modelRootB.eSet(containment, result[0]);
				}
				break;
			}
		}

		var newModelElemRef = modelEndpointRef.createModelElementInstanceAndReference(result[1], null);
		modelElemTypeEndpointRef.getObject().createInstanceAndReference(newModelElemRef, traceMappingRef);
	}

	private void propagateRefinementMappings(BinaryMappingReference propTraceMappingRef, BinaryModelRel refinementRel, Model relatedModel, BinaryModelRel traceRel, BinaryModelRel newPropRefinementRel) throws MMINTException {

		var propModelElemRef_propTraceRel = propTraceMappingRef.getTargetModelElemRef();
		var propModelEndpointRef_propRefinementRel = newPropRefinementRel.getModelEndpointRefs().get(1);
		// create new propagated model element refs in propagated refinement rel
		var duplicateRefinement1 = true;
		var newPropModelElemRef = getModelElementReference(propModelElemRef_propTraceRel, propModelEndpointRef_propRefinementRel.getModelElemRefs());
		if (newPropModelElemRef == null) {
			duplicateRefinement1 = false;
			newPropModelElemRef = propModelEndpointRef_propRefinementRel.createModelElementInstanceAndReference(propModelElemRef_propTraceRel.getObject().getEMFInstanceObject(), propModelElemRef_propTraceRel.getObject().getName());
		}

		var refinedModelElemRef_propTraceRel = propTraceMappingRef.getSourceModelElemRef();
		var relatedModelEndpointRef_propRefinementRel = newPropRefinementRel.getModelEndpointRefs().get(0);
		var refinedModelEndpointRef_refinementRel = refinementRel.getModelEndpointRefs().get(1);
		var refinedModelUri = refinedModelEndpointRef_refinementRel.getTargetUri();
		var refinedModelElemRef_refinementRel = getModelElementReference(refinedModelElemRef_propTraceRel, refinedModelEndpointRef_refinementRel.getModelElemRefs());
		var refinementModelElemEndpointRef = refinedModelElemRef_refinementRel.getModelElemEndpointRefs().get(0); // many to one here has to be mapped through an nary link
		var refinementMappingRef = (MappingReference) refinementModelElemEndpointRef.eContainer();
		var refinementMappingType = refinementMappingRef.getObject().getMetatype();
		// create new propagated refinement link
		var newPropRefinementMappingRef = refinementMappingType.createInstanceAndReference(false, newPropRefinementRel);
		newPropRefinementMappingRef.getObject().setName(refinementMappingRef.getObject().getName());
		refinementMappingType.getModelElemEndpoints().get(0).createInstanceAndReference(newPropModelElemRef, newPropRefinementMappingRef);

		var duplicateRefinement2 = true;
		for (ModelElementEndpointReference refinementModelElemEndpointRef2 : refinementMappingRef.getModelElemEndpointRefs()) {
			var origModelElemRef_refinementRel = refinementModelElemEndpointRef2.getModelElemRef();
			if (((ModelEndpointReference) origModelElemRef_refinementRel.eContainer()).getTargetUri().equals(refinedModelUri)) {
				continue;
			}
			var origModelEndpointRef_traceRel = traceRel.getModelEndpointRefs().get(0);
			var origModelElemRef_traceRel = getModelElementReference(origModelElemRef_refinementRel, origModelEndpointRef_traceRel.getModelElemRefs());
			for (ModelElementEndpointReference traceModelElementEndpoint : origModelElemRef_traceRel.getModelElemEndpointRefs()) {
				var traceMappingRef = (BinaryMappingReference) traceModelElementEndpoint.eContainer();
				var relatedModelElemRef_traceRel = traceMappingRef.getTargetModelElemRef();
				// skip uncorrect refinements due to multiple traces for the same orig model element
				if (!propModelElemRef_propTraceRel.getObject().getMetatypeUri().equals(relatedModelElemRef_traceRel.getObject().getMetatypeUri())) {
					continue;
				}
				// create new related model element refs in propagated refinement rel
				var newRelatedModelElemRef = getModelElementReference(relatedModelElemRef_traceRel, relatedModelEndpointRef_propRefinementRel.getModelElemRefs());
				if (newRelatedModelElemRef == null) {
					duplicateRefinement2 = false;
					newRelatedModelElemRef = relatedModelEndpointRef_propRefinementRel.createModelElementInstanceAndReference(relatedModelElemRef_traceRel.getObject().getEMFInstanceObject(), relatedModelElemRef_traceRel.getObject().getName());
				}
				refinementMappingType.getModelElemEndpoints().get(0).createInstanceAndReference(newRelatedModelElemRef, newPropRefinementMappingRef);
			}
		}

		// remove duplicate
		if (duplicateRefinement1 && duplicateRefinement2) {
			newPropRefinementMappingRef.deleteInstanceAndReference();
		}
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		var refinementRel = (MAVOBinaryModelRel) inputsByName.get(ChangePropagation.IN_MODELREL1);
		var origModel = (MAVOModel) refinementRel.getSourceModel();
		var refinedModel = (MAVOModel) refinementRel.getTargetModel();
		var traceRel = (MAVOBinaryModelRel) inputsByName.get(ChangePropagation.IN_MODELREL2);
		var relatedModel = (MAVOModel) traceRel.getTargetModel();

		// create output model and model relationships
		var newPropModel = (MAVOModel) relatedModel.getMetatype().copyInstanceAndEditor(relatedModel, relatedModel.getName() + ChangePropagation.PROP_MODEL_SUFFIX, false, outputMIDsByName.get(ChangePropagation.OUT_MODEL));
		var newPropRefinementRel = (MAVOBinaryModelRel) refinementRel.getMetatype().createBinaryInstance(
			null,
			ChangePropagation.OUT_MODELREL1,
			outputMIDsByName.get(ChangePropagation.OUT_MODELREL1));
		refinementRel.getModelEndpoints().get(0).getMetatype().createInstance(relatedModel, newPropRefinementRel);
		refinementRel.getModelEndpoints().get(1).getMetatype().createInstance(newPropModel, newPropRefinementRel);
		var newPropTraceRel = (MAVOBinaryModelRel) traceRel.getMetatype().createBinaryInstance(
			null,
			ChangePropagation.OUT_MODELREL2,
			outputMIDsByName.get(ChangePropagation.OUT_MODELREL2));
		traceRel.getModelEndpoints().get(0).getMetatype().createInstance(refinedModel, newPropTraceRel);
		traceRel.getModelEndpoints().get(1).getMetatype().createInstance(newPropModel, newPropTraceRel);

		// change propagation algorithm
		List<List<MAVOBinaryMappingReference>> propTraceMappingRefsList = new ArrayList<>();
		for (MappingReference refinementMappingRef : refinementRel.getMappingRefs()) {
			var propTraceMappingRefs = propagateTraceMappingsFromRefinements(refinementMappingRef, traceRel, newPropModel, newPropTraceRel);
			propTraceMappingRefsList.add(propTraceMappingRefs);
		}
		var newPropModelRoot = newPropModel.getEMFInstanceRoot();
		for (List<MAVOBinaryMappingReference> propTraceMappingRefs : propTraceMappingRefsList) {
			reduceTraceMappingUncertainty(newPropModelRoot, propTraceMappingRefs, 0, 1);
		}
		FileUtils.writeModelFile(newPropModelRoot, newPropModel.getUri(), null, true);
		for (List<MAVOBinaryMappingReference> propTraceMappingRefs : propTraceMappingRefsList) {
			for (BinaryMappingReference propTraceMappingRef : propTraceMappingRefs) {
				propagateRefinementMappings(propTraceMappingRef, refinementRel, relatedModel, traceRel, newPropRefinementRel);
			}
		}
		//TODO MMINT[MAVO] reason about how to concretely use indexA and indexB, when the refineUncertainty becomes an independent operator

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(ChangePropagation.OUT_MODEL, newPropModel);
		outputsByName.put(ChangePropagation.OUT_MODELREL1, newPropRefinementRel);
		outputsByName.put(ChangePropagation.OUT_MODELREL2, newPropTraceRel);

		return outputsByName;
	}

}
