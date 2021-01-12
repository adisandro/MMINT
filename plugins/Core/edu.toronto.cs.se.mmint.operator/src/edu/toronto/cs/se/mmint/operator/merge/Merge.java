/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.merge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

//TODO MMINT[OPERATOR] Review this whole operator to find examples on how to make apis easier to use
// e.g. direct access through ext table is useful, but there's that _AS_ thing to be fixed first
// e.g. there is no direct link from a model to all its connected model rels
public class Merge extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELREL = "overlap";
	private final static @NonNull String OUT_MODEL = "merged";
	private final static @NonNull String OUT_MODELREL1 = "trace1";
	private final static @NonNull String OUT_MODELREL2 = "trace2";
	// constants
	private static final @NonNull String MERGED_MODELOBJECT_ATTRIBUTE = "name";
	private static final @NonNull String MERGE_SEPARATOR = "+";

    private static class Input {

        private ModelRel overlapRel;
        private Model model1;
        private Model model2;

        public Input(Map<String, Model> inputsByName) {

            this.overlapRel = (ModelRel) inputsByName.get(Merge.IN_MODELREL);
            if (this.overlapRel.getModelEndpoints().size() != 2) {
                throw new IllegalArgumentException();
            }
            this.model1 = this.overlapRel.getModelEndpoints().get(0).getTarget();
            this.model2 = this.overlapRel.getModelEndpoints().get(1).getTarget();
            if (this.model1.getMetatype() != this.model2.getMetatype()) {
                throw new IllegalArgumentException();
            }
        }
    }

	public static class Constraint implements IJavaOperatorConstraint {

		@Override
		public boolean checkInputs(Map<String, Model> inputsByName) {

		    try {
    		    new Input(inputsByName);
    			return true;
		    }
		    catch (IllegalArgumentException e) {
		        return false;
		    }
		}

		@Override
		public Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName, Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

			Input input = new Input(inputsByName);
			Model mergedModel = outputsByName.get(Merge.OUT_MODEL);
			var traceRel1 = (ModelRel) outputsByName.get(Merge.OUT_MODELREL1);
			var traceRel2 = (ModelRel) outputsByName.get(Merge.OUT_MODELREL2);
			Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
			List<Model> endpointModels1 = new ArrayList<>();
			endpointModels1.add(input.model1);
			endpointModels1.add(mergedModel);
			validOutputs.put(traceRel1, endpointModels1);
			List<Model> endpointModels2 = new ArrayList<>();
			endpointModels2.add(input.model2);
			endpointModels2.add(mergedModel);
			validOutputs.put(traceRel2, endpointModels2);

			return validOutputs;
		}
	}

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
			@NonNull Model model1, @NonNull Model model2, @NonNull ModelRel overlapRel, @NonNull Model mergedModel,
			@NonNull ModelRel traceRel1, @NonNull ModelRel traceRel2) throws MMINTException {

		// create merged root
		var rootModelObj1 = model1.getEMFInstanceRoot();
		var mergedModelFactory = rootModelObj1.eClass().getEPackage().getEFactoryInstance();
		var rootMergedModelObj = mergedModelFactory.create(rootModelObj1.eClass());
		Map<String, ModelElement> matchModelElems1 = new HashMap<>();
		for (ModelElementReference modelElemRef1 : overlapRel.getModelEndpointRefs().get(0).getModelElemRefs()) {
			ModelElementReference modelElemRef2 = this.getConnected(modelElemRef1).stream().findFirst().get();
			matchModelElems1.put(
				modelElemRef1.getUri().substring(0, modelElemRef1.getUri().indexOf(MMINTConstants.ROLE_SEPARATOR)),
				modelElemRef2.getObject());
		}
		Map<String, EObject> mergedModelObjs = new HashMap<>();
		Map<EObject, EObject> allModelObjs = new HashMap<>();

		// copy elements from model1
		for (EObject modelObj1 : rootModelObj1.eContents()) {
			var mergedModelObj = EcoreUtil.copy(modelObj1);
			allModelObjs.put(modelObj1, mergedModelObj);
			String modelElemUri1 = MIDRegistry.getModelElementUri(modelObj1);
			if (matchModelElems1.keySet().contains(modelElemUri1)) {
				ModelElement modelElem2 = matchModelElems1.get(modelElemUri1);
				var modelObj2 = modelElem2.getEMFInstanceObject();
				mergedModelObjs.put(
					modelElem2.getUri().substring(0, modelElem2.getUri().indexOf(MMINTConstants.ROLE_SEPARATOR)),
					mergedModelObj);
				try { // change merged attribute
					Object modelObjAttr1 = FileUtils.getModelObjectFeature(modelObj1, Merge.MERGED_MODELOBJECT_ATTRIBUTE);
					Object modelObjAttr2 = FileUtils.getModelObjectFeature(modelObj2, Merge.MERGED_MODELOBJECT_ATTRIBUTE);
					if (!modelObjAttr1.equals(modelObjAttr2)) {
						FileUtils.setModelObjectFeature(
							mergedModelObj,
							Merge.MERGED_MODELOBJECT_ATTRIBUTE,
							modelObjAttr1 + Merge.MERGE_SEPARATOR + modelObjAttr2);
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
			var newModelElemUri = mergedModel.getUri() + MIDRegistry.getModelElementUri(mergedModelObj);
			var eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
			var newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
			traceModelElemRefs1.add( // merged model element is not serialized yet
				MIDTypeHierarchy.getRootModelElementType().createInstanceAndReference(
					newModelElemUri,
					newModelElemName,
					eInfo,
					traceRel1.getModelEndpointRefs().get(1)));
			var newMappingRef = MIDTypeHierarchy.getRootMappingType()
			    .createInstanceAndReferenceAndEndpointsAndReferences(true, traceModelElemRefs1);
            newMappingRef.getObject().setName(
                FileUtils.getModelObjectFeature(mergedModelObj, Merge.MERGED_MODELOBJECT_ATTRIBUTE).toString());
		}

		// copy elements from model2
		var rootModelObj2 = model2.getEMFInstanceRoot();
		for (EObject modelObj2 : rootModelObj2.eContents()) {
			EObject mergedModelObj;
			String modelElemUri2 = MIDRegistry.getModelElementUri(modelObj2);
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
			var newModelElemUri = mergedModel.getUri() + MIDRegistry.getModelElementUri(mergedModelObj);
			var eInfo = MIDRegistry.getModelElementEMFInfo(mergedModelObj, MIDLevel.INSTANCES);
			var newModelElemName = MIDRegistry.getModelElementName(eInfo, mergedModelObj, MIDLevel.INSTANCES);
			traceModelElemRefs2.add( // merged model element is not serialized yet
				MIDTypeHierarchy.getRootModelElementType().createInstanceAndReference(
					newModelElemUri,
					newModelElemName,
					eInfo,
					traceRel2.getModelEndpointRefs().get(1)));
			var newMappingRef = MIDTypeHierarchy.getRootMappingType()
			    .createInstanceAndReferenceAndEndpointsAndReferences(true, traceModelElemRefs2);
			newMappingRef.getObject().setName(
                FileUtils.getModelObjectFeature(mergedModelObj, Merge.MERGED_MODELOBJECT_ATTRIBUTE).toString());
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

		// input
		//TODO MMINT[MERGE] Support more complex cases than just first-level objects
		Input input = new Input(inputsByName);

		// create merged model and trace relationships as placeholders
		MID mergedModelMID = outputMIDsByName.get(Merge.OUT_MODEL);
		String mergedModelPath = FileUtils.replaceLastSegmentInPath(
			MIDRegistry.getModelUri(mergedModelMID),
			input.model1.getName() + Merge.MERGE_SEPARATOR + input.model2.getName() + MMINTConstants.MODEL_FILEEXTENSION_SEPARATOR
					+ input.model1.getFileExtension());
		var mergedModel = input.model1.getMetatype().createInstance(null, mergedModelPath, mergedModelMID);
		var traceRel1 = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
			null,
			Merge.OUT_MODELREL1,
			input.model1,
			mergedModel,
			outputMIDsByName.get(Merge.OUT_MODELREL1));
		var traceRel2 = MIDTypeHierarchy.getRootModelRelType().createBinaryInstanceAndEndpoints(
			null,
			Merge.OUT_MODELREL2,
			input.model2,
			mergedModel,
			outputMIDsByName.get(Merge.OUT_MODELREL2));
		// merge the models
		EObject rootMergedModelObj = this.merge(input.model1, input.model2, input.overlapRel, mergedModel, traceRel1, traceRel2);
		FileUtils.writeModelFile(rootMergedModelObj, mergedModelPath, true);
		mergedModel.createInstanceEditor(true); // opens the new model editor as side effect

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(Merge.OUT_MODEL, mergedModel);
		outputsByName.put(Merge.OUT_MODELREL1, traceRel1);
		outputsByName.put(Merge.OUT_MODELREL2, traceRel2);

		return outputsByName;
	}

}
