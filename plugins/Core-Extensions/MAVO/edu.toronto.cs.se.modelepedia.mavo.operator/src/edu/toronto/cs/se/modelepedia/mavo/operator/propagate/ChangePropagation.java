/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorInputConstraint;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMapping;
import edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOMappingReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.BinaryMAVOModelRel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOMapping;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModel;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElement;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.constraint.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.library.MIDRegistry;
import edu.toronto.cs.se.mmint.mid.library.MIDTypeIntrospection;
import edu.toronto.cs.se.mmint.mid.library.MIDUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;

public class ChangePropagation extends OperatorImpl {

	public static class InputConstraint implements IJavaOperatorInputConstraint {

		@Override
		public boolean isAllowedInput(Map<String, Model> inputsByName) {

			//TODO MMINT[OPERATOR] Check that refinement and trace share a model, and that all models involved are mavo models
			return true;
		}
	}

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
		MID instanceMID = modelElemRef.getMIDContainer();
		instanceMID.getExtendibleTable().removeKey(modelElemRef.getUri());
		modelElemRef.deleteInstanceReference();
		ModelElement modelElem = modelElemRef.getObject();
		((Model) modelElem.eContainer()).getModelElems().remove(modelElem);
		//TODO MMINT[OO] should remove from all model rels too?
	}

	private String getModelEObjectUri(String modelElemUri) {

		return modelElemUri.substring(0, modelElemUri.indexOf(MMINT.ROLE_SEPARATOR));
	}

	private ModelElementReference getModelElementReference(String modelElemRefUri, EList<ModelElementReference> modelElemRefs) {

		if (modelElemRefUri == null) {
			return null;
		}

		modelElemRefUri = getModelEObjectUri(modelElemRefUri);
		for (ModelElementReference modelElemRef : modelElemRefs) {
			if (modelElemRefUri.equals(getModelEObjectUri(modelElemRef.getUri()))) {
				return modelElemRef;
			}
		}

		return null;
	}

	private ModelElementReference getModelElementReference(ModelElementReference correspondingModelElemRef, EList<ModelElementReference> modelElemRefs) {

		if (correspondingModelElemRef == null) {
			return null;
		}

		return getModelElementReference(correspondingModelElemRef.getUri(), modelElemRefs);
	}

	private List<BinaryMAVOMappingReference> propagateTraceMappingsFromRefinements(MappingReference refinementMappingRef, BinaryMAVOModelRel traceRel, MAVOModel newPropModel, BinaryMAVOModelRel newPropTraceRel) throws Exception {

		ModelEndpointReference origModelEndpointRef_traceRel = traceRel.getModelEndpointRefs().get(0);
		String origModelUri = origModelEndpointRef_traceRel.getTargetUri();

		// get model element refs in trace rel that got refined
		List<ModelElementReference> refinedModelElemRefs_refinementRel = new ArrayList<ModelElementReference>();
		List<ModelElementReference> origModelElemRefs_traceRel = new ArrayList<ModelElementReference>();
		for (ModelElementEndpointReference refinementModelElemEndpointRef : refinementMappingRef.getModelElemEndpointRefs()) {
			ModelElementReference refinementModelElemRef = refinementModelElemEndpointRef.getModelElemRef();
			if (((ModelEndpointReference) refinementModelElemRef.eContainer()).getTargetUri().equals(origModelUri)) { // orig model element ref in trace rel
				ModelElementReference origModelElemRef_traceRel = getModelElementReference(refinementModelElemRef.getUri(), origModelEndpointRef_traceRel.getModelElemRefs());
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
		List<BinaryMAVOMappingReference> newPropTraceMappingRefs = new ArrayList<>();
		if (origModelElemRefs_traceRel.isEmpty()) {
			if (refinementMappingRef.getModelElemEndpointRefs().size() == 1) {
				for (ModelElementReference refinedModelElemRef_refinementRel : refinedModelElemRefs_refinementRel) {
					BinaryMAVOMappingReference newPropTraceMappingRef = createDanglingTraceMapping(refinedModelElemRef_refinementRel, newPropTraceRel, 0, 1);
					if (newPropTraceMappingRef != null) {
						newPropTraceMappingRefs.add(newPropTraceMappingRef);
					}
				}
			}
			return newPropTraceMappingRefs;
		}

		// propagate trace links
		List<ModelElementReference> newRefinedModelElemRefs_propTraceRel = new ArrayList<ModelElementReference>();
		ModelEndpointReference refinedModelEndpointRef_propTraceRel = newPropTraceRel.getModelEndpointRefs().get(0);
		for (ModelElementReference refinedModelElemRef_refinementRel : refinedModelElemRefs_refinementRel) {
			// create refined model elem ref in propagated trace rel
			ModelElementReference newRefinedModelElemRef_propTraceRel = refinedModelEndpointRef_propTraceRel.createModelElementInstanceAndReference(refinedModelElemRef_refinementRel.getObject().getEMFInstanceObject(), refinedModelElemRef_refinementRel.getObject().getName());
			newRefinedModelElemRefs_propTraceRel.add(newRefinedModelElemRef_propTraceRel);
		}
		ModelEndpointReference propModelEndpointRef_propTraceRel = newPropTraceRel.getModelEndpointRefs().get(1);
		for (ModelElementReference origModelElemRef_traceRel : origModelElemRefs_traceRel) {
			for (ModelElementEndpointReference traceModelElemEndpointRef : origModelElemRef_traceRel.getModelElemEndpointRefs()) {
				BinaryMAVOMappingReference traceMappingRef = (BinaryMAVOMappingReference) traceModelElemEndpointRef.eContainer();
				BinaryMAVOMapping traceMapping = traceMappingRef.getObject();
				ModelElementReference relatedModelElemRef_traceRel = traceMappingRef.getTargetModelElemRef();
				String propModelObjUri =
					newPropModel.getUri() +
					getModelEObjectUri(relatedModelElemRef_traceRel.getUri()).substring(relatedModelElemRef_traceRel.getUri().lastIndexOf(MMINT.MODEL_URI_SEPARATOR));
				EObject propModelObj = MIDTypeIntrospection.getPointer(propModelObjUri);
				// create propagated model elem ref in propagated trace rel
				ModelElementReference newPropModelElemRef_propTraceRel = propModelEndpointRef_propTraceRel.createModelElementInstanceAndReference(propModelObj, relatedModelElemRef_traceRel.getObject().getName());
				// create new propagated trace links
				for (ModelElementReference newRefinedModelElemRef_propTraceRel : newRefinedModelElemRefs_propTraceRel) {
					BinaryMAVOMappingReference newPropTraceMappingRef = (BinaryMAVOMappingReference) traceMapping.getMetatype().createInstanceAndReference(true, newPropTraceRel);
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

	private BinaryMAVOMappingReference createDanglingTraceMapping(ModelElementReference traceModelElemRefA, BinaryMAVOModelRel traceRel, int indexA, int indexB) throws MMINTException {

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

		BinaryMAVOMappingReference newTraceMappingRef = null;
		for (MappingReference traceMappingTypeRef : MIDTypeRegistry.getMappingTypeReferences(traceRel.getMetatype())) {
			if (!(traceMappingTypeRef instanceof BinaryMappingReference)) { // a trace rel type is meant to have two model types
				continue;
			}
			ModelElementReference traceModelElemTypeRefA = traceMappingTypeRef.getModelElemEndpointRefs().get(indexA).getModelElemRef();
			if (!traceModelElemTypeRefA.getUri().equals(traceModelElemTypeA.getUri())) {
				continue;
			}
			ModelElementEndpointReference traceModelElemTypeEndpointRefB = traceMappingTypeRef.getModelElemEndpointRefs().get(indexB);
			if (traceModelElemTypeEndpointRefB.getObject().getLowerBound() < 1) {
				continue;
			}
			// create new dangling trace link
			ModelElementReference newTraceModelElemRefA = traceRel.getModelEndpointRefs().get(indexA).createModelElementInstanceAndReference(traceModelElemRefA.getObject().getEMFInstanceObject(), traceModelElemRefA.getObject().getName());
			newTraceMappingRef = (BinaryMAVOMappingReference) traceMappingTypeRef.getObject().createInstanceAndReference(true, traceRel);
			newTraceMappingRef.getObject().setVar(true);
			newTraceMappingRef.getObject().setName(PROPTRACE_RULE4_LINK_NAME);
			traceMappingTypeRef.getModelElemEndpointRefs().get(indexA).getObject().createInstanceAndReference(newTraceModelElemRefA, newTraceMappingRef);
			// if more than one link type with same model element type A exist, they all get created (the user will merge unnecessary ones)
			//TODO MMINT[MAVO] should I also mark them as M, because I want them to be mutually exclusive?
			//TODO MMINT[MAVO] (prop rule that forces the removal of M if the endpoints are E sounds wrong in this case, mostly because mutual exclusion has not been formalized)
		}

		return newTraceMappingRef;
	}

	private List<BinaryMAVOMappingReference> reduceTraceMappingUncertainty(EObject modelRootB, List<BinaryMAVOMappingReference> propTraceMappingRefs, int indexA, int indexB) throws Exception {

		int n = 0;
		HashSet<String> uniqueModelElemUrisB = new HashSet<String>();
		for (BinaryMappingReference traceMappingRef : propTraceMappingRefs) {
			if (traceMappingRef.getModelElemEndpointRefs().size() == 1) { // dangling link
				continue;
			}
			ModelElementReference traceModelElemRefB = traceMappingRef.getModelElemEndpointRefs().get(indexB).getModelElemRef();
			if (!uniqueModelElemUrisB.contains(traceModelElemRefB.getUri())) {
				n++;
				uniqueModelElemUrisB.add(traceModelElemRefB.getUri());
			}
		}

		boolean again = false;
		MappingReference unifiedMappingRef = null;
traceLinks:
		for (BinaryMAVOMappingReference traceMappingRef : propTraceMappingRefs) {
			ModelElementEndpointReference traceModelElemEndpointRefA = traceMappingRef.getModelElemEndpointRefs().get(indexA);
			MAVOModelElementReference modelElemRefA = (MAVOModelElementReference) traceModelElemEndpointRefA.getModelElemRef();
			MAVOModelElement modelElemA = modelElemRefA.getObject();

			// rule 4, 2nd half
			if (n == 0) {
				completeDanglingTraceMapping(modelRootB, traceMappingRef, modelElemA.getName(), indexB);
				again = true;
				continue;
			}

			ModelElementEndpointReference traceModelElemEndpointRefB = traceMappingRef.getModelElemEndpointRefs().get(indexB);
			MAVOModelElementReference modelElemRefB = (MAVOModelElementReference) traceModelElemEndpointRefB.getModelElemRef();
			MAVOModelElement modelElemB = modelElemRefB.getObject();
			BinaryMAVOMapping traceMapping = traceMappingRef.getObject();
			boolean Ma = modelElemA.isMay(), Sa = modelElemA.isSet(), Va = modelElemA.isVar();
			boolean Mab = traceMapping.isMay(), Sab = traceMapping.isSet(), Vab = traceMapping.isVar();
			boolean Mb = modelElemB.isMay(), Sb = modelElemB.isSet(), Vb = modelElemB.isVar();
			int Ua = traceModelElemEndpointRefA.getObject().getMetatype().getUpperBound();
			int Lb = traceModelElemEndpointRefB.getObject().getMetatype().getLowerBound(), Ub = traceModelElemEndpointRefB.getObject().getMetatype().getUpperBound();
			EObject modelObjB = MIDTypeIntrospection.getPointer(
				modelRootB.eResource(),
				getModelEObjectUri(modelElemB.getUri())
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
					for (BinaryMAVOMappingReference traceMappingRef2 : propTraceMappingRefs) {
						if (traceMappingRef2 == traceMappingRef) {
							continue;
						}
						boolean Mac = traceMappingRef2.getObject().isMay();
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

		EMap<String, ExtendibleElement> extendibleTable = modelElemRef.getMIDContainer().getExtendibleTable();
		String unifiedModelElemUri = getModelEObjectUri(unifiedModelElemRef.getUri());
		String modelElemUri = getModelEObjectUri(modelElemRef.getUri());
		ModelEndpointReference modelEndpointRef = (ModelEndpointReference) modelElemRef.eContainer();
		String unifiedModelElemUriBase = unifiedModelElemUri.substring(0, unifiedModelElemUri.lastIndexOf('.')+1);
		int unifiedModelElemUriIndex = Integer.parseInt(unifiedModelElemUri.substring(unifiedModelElemUri.lastIndexOf('.')+1));

		List<ModelElement> otherModelElems = new ArrayList<ModelElement>();
		// first pass, modify model element uris
		for (ModelElement otherModelElem : modelEndpointRef.getObject().getTarget().getModelElems()) {
			String otherModelElemUri = getModelEObjectUri(otherModelElem.getUri());
			// other model element to be affected by unification of model elements
			if (otherModelElemUri.contains(unifiedModelElemUriBase)) {
				String otherModelElemUriExtra = otherModelElemUri.substring(otherModelElemUri.lastIndexOf(unifiedModelElemUriBase) + unifiedModelElemUriBase.length());
				int otherModelElemUriIndex = (otherModelElemUriExtra.indexOf(MMINT.URI_SEPARATOR) == -1) ?
					Integer.parseInt(otherModelElemUriExtra) :
					Integer.parseInt(otherModelElemUriExtra.substring(0, otherModelElemUriExtra.indexOf(MMINT.URI_SEPARATOR)));
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

		ModelElementReference varModelElemRef = varTraceMappingRef.getModelElemEndpointRefs().get(indexB).getModelElemRef();
		ModelElementReference modelElemRef = traceMappingRef.getModelElemEndpointRefs().get(indexB).getModelElemRef();
		// get var object and other object from same resource
		EObject varModelObj = MIDTypeIntrospection.getPointer(modelRootB.eResource(), getModelEObjectUri(varModelElemRef.getUri()));
		EObject modelObj = MIDTypeIntrospection.getPointer(modelRootB.eResource(), getModelEObjectUri(modelElemRef.getUri()));
		// unify contents
		for (EObject varModelObjContent : varModelObj.eContents()) {
			EStructuralFeature varModelObjContainingFeature = varModelObjContent.eContainingFeature();
			Object value = modelObj.eGet(varModelObjContainingFeature);
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
			EObject currentContainerCopy = EcoreUtil.copy(currentContainer);
			EClass containedEClass = (EClass) containment.getEType();
			EObject contained = modelTypeFactory.create(containedEClass);
			if (contained instanceof MAVOElement) {
				((MAVOElement) contained).setVar(true);
			}
			EStructuralFeature feature = containedEClass.getEStructuralFeature(NAME_FEATURE);
			if (feature != null && feature instanceof EAttribute && ((EAttribute) feature).getEType().getName().equals("EString")) {
				contained.eSet(feature, modelElemName);
			}
			Object value = currentContainerCopy.eGet(containment);
			if (value instanceof EList) {
				((EList<EObject>) value).add(contained);
			}
			else {
				currentContainerCopy.eSet(containment, contained);
			}

			// model element created
			if (modelElemTypeUri.equals(containedEClass.getName())) {
				EObject rootContainer = EcoreUtil.getRootContainer(currentContainerCopy);
				if (rootContainer == null) {
					rootContainer = currentContainerCopy;
				}
				return new EObject[] {rootContainer, contained};
			}

			// continue recursion
			EObject[] result = navigateIncompleteModel(contained, modelTypeFactory, modelElemTypeUri, modelElemName);
			if (result != null) {
				return result;
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private void completeDanglingTraceMapping(EObject modelRootB, MappingReference traceMappingRef, String modelElemName, int indexB) throws Exception {

		ModelEndpointReference modelEndpointRef = ((BinaryModelRel) traceMappingRef.eContainer()).getModelEndpointRefs().get(indexB);
		Model model = modelEndpointRef.getObject().getTarget();
		EFactory modelTypeFactory = model.getMetatype().getEMFTypeRoot().getEFactoryInstance();
		ModelElementEndpointReference modelElemTypeEndpointRef = traceMappingRef.getObject().getMetatype().getModelElemEndpointRefs().get(indexB);
		ModelElement modelElemType = modelElemTypeEndpointRef.getModelElemRef().getObject();
		String modelElemTypeUri = MIDRegistry.getModelAndModelElementUris(modelElemType.getEMFTypeObject(), MIDLevel.TYPES)[1];

		EObject[] result = null;
		for (EReference containment : modelRootB.eClass().getEAllContainments()) {
			EClass containedEClass = (EClass) containment.getEType();
			EObject contained = modelTypeFactory.create(containedEClass);
			if (contained instanceof MAVOElement) {
				((MAVOElement) contained).setVar(true);
			}
			EStructuralFeature feature = containedEClass.getEStructuralFeature(NAME_FEATURE);
			if (feature != null && feature instanceof EAttribute && ((EAttribute) feature).getEType().getName().equals("EString")) {
				contained.eSet(feature, modelElemName);
			}
			result = navigateIncompleteModel(contained, modelTypeFactory, modelElemTypeUri, modelElemName);
			if (result != null) {
				Object value = modelRootB.eGet(containment);
				if (value instanceof EList) {
					((EList<EObject>) value).add(result[0]);
				}
				else {
					modelRootB.eSet(containment, result[0]);
				}
				break;
			}
		}

		ModelElementReference newModelElemRef = modelEndpointRef.createModelElementInstanceAndReference(result[1], null);
		modelElemTypeEndpointRef.getObject().createInstanceAndReference(newModelElemRef, traceMappingRef);
	}

	private void propagateRefinementMappings(BinaryMappingReference propTraceMappingRef, BinaryModelRel refinementRel, Model relatedModel, BinaryModelRel traceRel, BinaryModelRel newPropRefinementRel) throws MMINTException {

		ModelElementReference propModelElemRef_propTraceRel = propTraceMappingRef.getTargetModelElemRef();
		ModelEndpointReference propModelEndpointRef_propRefinementRel = newPropRefinementRel.getModelEndpointRefs().get(1);
		// create new propagated model element refs in propagated refinement rel
		boolean duplicateRefinement1 = true;
		ModelElementReference newPropModelElemRef = getModelElementReference(propModelElemRef_propTraceRel, propModelEndpointRef_propRefinementRel.getModelElemRefs());
		if (newPropModelElemRef == null) {
			duplicateRefinement1 = false;
			newPropModelElemRef = propModelEndpointRef_propRefinementRel.createModelElementInstanceAndReference(propModelElemRef_propTraceRel.getObject().getEMFInstanceObject(), propModelElemRef_propTraceRel.getObject().getName());
		}

		ModelElementReference refinedModelElemRef_propTraceRel = propTraceMappingRef.getSourceModelElemRef();
		ModelEndpointReference relatedModelEndpointRef_propRefinementRel = newPropRefinementRel.getModelEndpointRefs().get(0);
		ModelEndpointReference refinedModelEndpointRef_refinementRel = refinementRel.getModelEndpointRefs().get(1);
		String refinedModelUri = refinedModelEndpointRef_refinementRel.getTargetUri();
		ModelElementReference refinedModelElemRef_refinementRel = getModelElementReference(refinedModelElemRef_propTraceRel, refinedModelEndpointRef_refinementRel.getModelElemRefs());
		ModelElementEndpointReference refinementModelElemEndpointRef = refinedModelElemRef_refinementRel.getModelElemEndpointRefs().get(0); // many to one here has to be mapped through an nary link
		MappingReference refinementMappingRef = (MappingReference) refinementModelElemEndpointRef.eContainer();
		Mapping refinementMappingType = refinementMappingRef.getObject().getMetatype();
		// create new propagated refinement link
		MappingReference newPropRefinementMappingRef = refinementMappingType.createInstanceAndReference(false, newPropRefinementRel);
		newPropRefinementMappingRef.getObject().setName(refinementMappingRef.getObject().getName());
		refinementMappingType.getModelElemEndpoints().get(0).createInstanceAndReference(newPropModelElemRef, newPropRefinementMappingRef);

		boolean duplicateRefinement2 = true;
		for (ModelElementEndpointReference refinementModelElemEndpointRef2 : refinementMappingRef.getModelElemEndpointRefs()) {
			ModelElementReference origModelElemRef_refinementRel = refinementModelElemEndpointRef2.getModelElemRef();
			if (((ModelEndpointReference) origModelElemRef_refinementRel.eContainer()).getTargetUri().equals(refinedModelUri)) {
				continue;
			}
			ModelEndpointReference origModelEndpointRef_traceRel = traceRel.getModelEndpointRefs().get(0);
			ModelElementReference origModelElemRef_traceRel = getModelElementReference(origModelElemRef_refinementRel, origModelEndpointRef_traceRel.getModelElemRefs());
			for (ModelElementEndpointReference traceModelElementEndpoint : origModelElemRef_traceRel.getModelElemEndpointRefs()) {
				BinaryMappingReference traceMappingRef = (BinaryMappingReference) traceModelElementEndpoint.eContainer();
				ModelElementReference relatedModelElemRef_traceRel = traceMappingRef.getTargetModelElemRef();
				// skip uncorrect refinements due to multiple traces for the same orig model element
				if (!propModelElemRef_propTraceRel.getObject().getMetatypeUri().equals(relatedModelElemRef_traceRel.getObject().getMetatypeUri())) {
					continue;
				}
				// create new related model element refs in propagated refinement rel
				ModelElementReference newRelatedModelElemRef = getModelElementReference(relatedModelElemRef_traceRel, relatedModelEndpointRef_propRefinementRel.getModelElemRefs());
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

		BinaryMAVOModelRel refinementRel = (BinaryMAVOModelRel) inputsByName.get(IN_MODELREL1);
		MAVOModel origModel = (MAVOModel) refinementRel.getSourceModel();
		MAVOModel refinedModel = (MAVOModel) refinementRel.getTargetModel();
		BinaryMAVOModelRel traceRel = (BinaryMAVOModelRel) inputsByName.get(IN_MODELREL2);
		MAVOModel relatedModel = (MAVOModel) traceRel.getTargetModel();

		// create output model and model relationships
		MAVOModel newPropModel = (MAVOModel) relatedModel.getMetatype().copyInstanceAndEditor(relatedModel, relatedModel.getName() + PROP_MODEL_SUFFIX, false, outputMIDsByName.get(OUT_MODEL));
		BinaryMAVOModelRel newPropRefinementRel = (BinaryMAVOModelRel) refinementRel.getMetatype().createBinaryInstance(null, outputMIDsByName.get(OUT_MODELREL1));
		newPropRefinementRel.setName(OUT_MODELREL1);
		refinementRel.getModelEndpoints().get(0).getMetatype().createInstance(relatedModel, newPropRefinementRel);
		refinementRel.getModelEndpoints().get(1).getMetatype().createInstance(newPropModel, newPropRefinementRel);
		BinaryMAVOModelRel newPropTraceRel = (BinaryMAVOModelRel) traceRel.getMetatype().createBinaryInstance(null, outputMIDsByName.get(OUT_MODELREL2));
		newPropTraceRel.setName(OUT_MODELREL2);
		traceRel.getModelEndpoints().get(0).getMetatype().createInstance(refinedModel, newPropTraceRel);
		traceRel.getModelEndpoints().get(1).getMetatype().createInstance(newPropModel, newPropTraceRel);

		// change propagation algorithm
		List<List<BinaryMAVOMappingReference>> propTraceMappingRefsList = new ArrayList<>();
		for (MappingReference refinementMappingRef : refinementRel.getMappingRefs()) {
			List<BinaryMAVOMappingReference> propTraceMappingRefs = propagateTraceMappingsFromRefinements(refinementMappingRef, traceRel, newPropModel, newPropTraceRel);
			propTraceMappingRefsList.add(propTraceMappingRefs);
		}
		EObject newPropModelRoot = newPropModel.getEMFInstanceRoot();
		for (List<BinaryMAVOMappingReference> propTraceMappingRefs : propTraceMappingRefsList) {
			reduceTraceMappingUncertainty(newPropModelRoot, propTraceMappingRefs, 0, 1);
		}
		MIDUtils.writeModelFile(newPropModelRoot, newPropModel.getUri(), true);
		for (List<BinaryMAVOMappingReference> propTraceMappingRefs : propTraceMappingRefsList) {
			for (BinaryMappingReference propTraceMappingRef : propTraceMappingRefs) {
				propagateRefinementMappings(propTraceMappingRef, refinementRel, relatedModel, traceRel, newPropRefinementRel);
			}
		}
		//TODO MMINT[MAVO] reason about how to concretely use indexA and indexB, when the refineUncertainty becomes an independent operator

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, newPropModel);
		outputsByName.put(OUT_MODELREL1, newPropRefinementRel);
		outputsByName.put(OUT_MODELREL2, newPropTraceRel);

		return outputsByName;
	}

}
