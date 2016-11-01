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
package edu.toronto.cs.se.modelepedia.operator.merge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorInputConstraint;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.mid.EMFInfo;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

//TODO MMINT[OPERATOR] Review this whole operator to find examples on how to make apis easier to use
// e.g. direct access through ext table is useful, but there's that _AS_ thing to be fixed first
// e.g. there is no direct link from a model to all its connected model rels
public class ModelMerge extends OperatorImpl {

	public static class InputConstraint implements IJavaOperatorInputConstraint {

		@Override
		public boolean isAllowedInput(Map<String, Model> inputsByName) {

			ModelRel matchRel = (ModelRel) inputsByName.get(IN_MODELREL);
			if (matchRel.getModelEndpoints().size() != 2) {
				return false;
			}
			Model model1 = matchRel.getModelEndpoints().get(0).getTarget();
			Model model2 = matchRel.getModelEndpoints().get(1).getTarget();
			if (model1.getMetatype() != model2.getMetatype()) {
				return false;
			}

			return true;
		}
	}

	// input-output
	private final static @NonNull String IN_MODELREL = "match";
	private final static @NonNull String OUT_MODEL = "merged";
	private final static @NonNull String OUT_MODELREL1 = "trace1";
	private final static @NonNull String OUT_MODELREL2 = "trace2";
	// constants
	private static final @NonNull String MERGED_MODELOBJECT_ATTRIBUTE = "name";
	private static final @NonNull String MERGED_SEPARATOR = "+";

	// TODO MMINT[OPERATOR] Make this an api
	private @NonNull Set<ModelElementReference> getConnected(@NonNull ModelElementReference modelElemRef) {

		Set<ModelElementReference> connModelElemRefs = new HashSet<>();
		for (ModelElementEndpointReference modelElemEndpointRef : modelElemRef.getModelElemEndpointRefs()) {
			for (ModelElementEndpointReference connModelElemEndpointRef : ((MappingReference) modelElemEndpointRef
					.eContainer()).getModelElemEndpointRefs()) {
				if (connModelElemEndpointRef == modelElemEndpointRef) {
					continue;
				}
				connModelElemRefs.add(connModelElemEndpointRef.getModelElemRef());
			}
		}

		return connModelElemRefs;
	}

	private @NonNull EObject merge(
			@NonNull Model model1, @NonNull Model model2, @NonNull ModelRel matchRel, @NonNull Model mergedModel,
			@NonNull ModelRel traceRel1, @NonNull ModelRel traceRel2) throws MMINTException {

		// create merged root
		EObject rootModelObj1 = model1.getEMFInstanceRoot();
		EFactory mergedModelFactory = rootModelObj1.eClass().getEPackage().getEFactoryInstance();
		EObject rootMergedModelObj = mergedModelFactory.create(rootModelObj1.eClass());
		Map<String, ModelElement> matchModelElems1 = new HashMap<>();
		for (ModelElementReference modelElemRef1 : matchRel.getModelEndpointRefs().get(0).getModelElemRefs()) {
			ModelElementReference modelElemRef2 = getConnected(modelElemRef1).stream().findFirst().get();
			matchModelElems1.put(
				modelElemRef1.getUri().substring(0, modelElemRef1.getUri().indexOf(MMINT.ROLE_SEPARATOR)),
				modelElemRef2.getObject());
		}
		Map<String, EObject> mergedModelObjs = new HashMap<>();
		Map<EObject, EObject> allModelObjs = new HashMap<>();

		// copy elements from model1
		for (EObject modelObj1 : rootModelObj1.eContents()) {
			EObject mergedModelObj = EcoreUtil.copy(modelObj1);
			allModelObjs.put(modelObj1, mergedModelObj);
			String modelElemUri1 = MIDRegistry.getModelAndModelElementUris(modelObj1, MIDLevel.INSTANCES)[1];
			if (matchModelElems1.keySet().contains(modelElemUri1)) {
				ModelElement modelElem2 = matchModelElems1.get(modelElemUri1);
				EObject modelObj2 = modelElem2.getEMFInstanceObject();
				mergedModelObjs.put(
					modelElem2.getUri().substring(0, modelElem2.getUri().indexOf(MMINT.ROLE_SEPARATOR)),
					mergedModelObj);
				try { // change merged attribute
					Object modelObjAttr1 = FileUtils.getModelObjectFeature(modelObj1, MERGED_MODELOBJECT_ATTRIBUTE);
					Object modelObjAttr2 = FileUtils.getModelObjectFeature(modelObj2, MERGED_MODELOBJECT_ATTRIBUTE);
					if (!modelObjAttr1.equals(modelObjAttr2)) {
						FileUtils.setModelObjectFeature(
							mergedModelObj,
							MERGED_MODELOBJECT_ATTRIBUTE,
							modelObjAttr1 + MERGED_SEPARATOR + modelObjAttr2);
					}
				}
				catch (MMINTException e) {
					// no attribute to be merged
				}
			}
			FileUtils.setModelObjectFeature(
				rootMergedModelObj,
				modelObj1.eContainingFeature().getName(),
				mergedModelObj);
			EList<ModelElementReference> traceModelElemRefs1 = new BasicEList<>();
			traceModelElemRefs1.add(traceRel1.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(
				modelObj1,
				null));
			String newModelElemUri = mergedModel.getUri()
					+ MIDRegistry.getModelAndModelElementUris(mergedModelObj, MIDLevel.INSTANCES)[1];
			EMFInfo eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
			String newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
			traceModelElemRefs1.add( // merged model element is not serialized yet
				MIDTypeHierarchy.getRootModelElementType().createInstanceAndReference(
					newModelElemUri,
					newModelElemName,
					eInfo,
					traceRel1.getModelEndpointRefs().get(1)));
			MIDTypeHierarchy.getRootMappingType().createInstanceAndReferenceAndEndpointsAndReferences(
				true,
				traceModelElemRefs1);
		}

		// copy elements from model2
		EObject rootModelObj2 = model2.getEMFInstanceRoot();
		for (EObject modelObj2 : rootModelObj2.eContents()) {
			EObject mergedModelObj;
			String modelElemUri2 = MIDRegistry.getModelAndModelElementUris(modelObj2, MIDLevel.INSTANCES)[1];
			if (mergedModelObjs.keySet().contains(modelElemUri2)) {
				// already copied
				mergedModelObj = mergedModelObjs.get(modelElemUri2);
			}
			else {
				mergedModelObj = EcoreUtil.copy(modelObj2);
				FileUtils.setModelObjectFeature(
					rootMergedModelObj,
					modelObj2.eContainingFeature().getName(),
					mergedModelObj);
			}
			allModelObjs.put(modelObj2, mergedModelObj);
			EList<ModelElementReference> traceModelElemRefs2 = new BasicEList<>();
			traceModelElemRefs2.add(traceRel2.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(
				modelObj2,
				null));
			String newModelElemUri = mergedModel.getUri()
					+ MIDRegistry.getModelAndModelElementUris(mergedModelObj, MIDLevel.INSTANCES)[1];
			EMFInfo eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
			String newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
			traceModelElemRefs2.add( // merged model element is not serialized yet
				MIDTypeHierarchy.getRootModelElementType().createInstanceAndReference(
					newModelElemUri,
					newModelElemName,
					eInfo,
					traceRel2.getModelEndpointRefs().get(1)));
			MIDTypeHierarchy.getRootMappingType().createInstanceAndReferenceAndEndpointsAndReferences(
				true,
				traceModelElemRefs2);
		}

		// populate references
		for (Entry<EObject, EObject> entry : allModelObjs.entrySet()) {
			EObject modelObj = entry.getKey();
			EObject mergedModelObj = entry.getValue();
			for (EReference modelObjReference : modelObj.eClass().getEAllReferences()) {
				if (modelObjReference.isContainment()) {
					continue;
				}
				Object modelObjReferenceValue = FileUtils.getModelObjectFeature(modelObj, modelObjReference.getName());
				if (modelObjReferenceValue == null || modelObjReferenceValue instanceof EObjectWithInverseResolvingEList<?>) {
					continue;
				}
				EList<EObject> modelObjValues;
				if (modelObjReferenceValue instanceof EList<?>) {
					modelObjValues = (EList<EObject>) modelObjReferenceValue;
				}
				else {
					modelObjValues = new BasicEList<>();
					modelObjValues.add((EObject) modelObjReferenceValue);
				}
				for (EObject modelObjValue : modelObjValues) {
					FileUtils.setModelObjectFeature(mergedModelObj, modelObjReference.getName(), allModelObjs.get(modelObjValue));
				}
			}
		}

		return rootMergedModelObj;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// TODO MMINT[MERGE] Support more complex cases than just first-level objects
		ModelRel matchRel = (ModelRel) inputsByName.get(IN_MODELREL);
		Model model1 = matchRel.getModelEndpoints().get(0).getTarget();
		Model model2 = matchRel.getModelEndpoints().get(1).getTarget();

		// create merged model and trace relationships as placeholders
		MID mergedModelMID = outputMIDsByName.get(OUT_MODEL);
		String mergedModelPath = FileUtils.replaceLastSegmentInPath(
			MIDRegistry.getModelAndModelElementUris(mergedModelMID, MIDLevel.INSTANCES)[0],
			model1.getName() + MERGED_SEPARATOR + model2.getName() + MMINT.MODEL_FILEEXTENSION_SEPARATOR
					+ model1.getFileExtension());
		Model mergedModel = model1.getMetatype().createInstance(null, mergedModelPath, mergedModelMID);
		BinaryModelRel traceRel1 = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
			null,
			OUT_MODELREL1,
			model1,
			mergedModel,
			outputMIDsByName.get(OUT_MODELREL1));
		BinaryModelRel traceRel2 = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
			null,
			OUT_MODELREL2,
			model2,
			mergedModel,
			outputMIDsByName.get(OUT_MODELREL2));
		// merge the models
		EObject rootMergedModelObj = merge(model1, model2, matchRel, mergedModel, traceRel1, traceRel2);
		FileUtils.writeModelFile(rootMergedModelObj, mergedModelPath, true);
		mergedModel.createInstanceEditor(); // opens the new model editor as side effect

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, mergedModel);
		outputsByName.put(OUT_MODELREL1, traceRel1);
		outputsByName.put(OUT_MODELREL2, traceRel2);

		return outputsByName;
	}

}
