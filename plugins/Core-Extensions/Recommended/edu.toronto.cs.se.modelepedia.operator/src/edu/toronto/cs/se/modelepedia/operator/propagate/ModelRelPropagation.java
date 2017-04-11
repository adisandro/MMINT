/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.propagate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class ModelRelPropagation extends OperatorImpl {

	private final static @NonNull String IN_MODELREL1 = "original";
	private final static @NonNull String IN_MODELREL2 = "trace";
	private final static @NonNull String OUT_MODELREL = "propagated";

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean isAllowedInput(Map<String, Model> inputsByName) {

			ModelRel modelRel1 = (ModelRel) inputsByName.get(IN_MODELREL1);
			ModelRel modelRel2 = (ModelRel) inputsByName.get(IN_MODELREL2);
			if (modelRel1 == modelRel2) {
			    return false;
			}
			if (modelRel1.getModelEndpoints().size() != 1 || modelRel2.getModelEndpoints().size() != 2) {
				return false;
			}
			String modelPath1 = modelRel1.getModelEndpoints().get(0).getTargetUri();
			String modelPath21 = modelRel2.getModelEndpoints().get(0).getTargetUri();
			String modelPath22 = modelRel2.getModelEndpoints().get(1).getTargetUri();
			if (modelPath1.equals(modelPath21)) {
				return true;
			}
			else if (modelPath1.equals(modelPath22)) {
				return true;
			}

			return false;
		}

		@Override
		public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

			Input input = new Input(inputsByName);
			ModelRel propRel = (ModelRel) outputsByName.get(OUT_MODELREL);
			Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
			List<Model> endpointModels = new ArrayList<>();
			endpointModels.add(input.model2);
			validOutputs.put(propRel, endpointModels);

			return validOutputs;
		}
	}

	private static class Input {

		private ModelRel origRel;
		private ModelRel traceRel;
		private Model model1;
		private Model model2;

		public Input(Map<String, Model> inputsByName) {

			this.origRel = (ModelRel) inputsByName.get(IN_MODELREL1);
			this.traceRel = (ModelRel) inputsByName.get(IN_MODELREL2);
			this.model1 = origRel.getModelEndpoints().get(0).getTarget();
			this.model2 = traceRel.getModelEndpoints().stream()
				.filter(modelEndpoint -> !modelEndpoint.getTargetUri().equals(model1.getUri()))
				.findFirst()
				.get()
				.getTarget();
		}
	}

	private ModelRel propagate(ModelRel origRel, ModelRel traceRel, Model model1, Model model2, MID outputMID) throws MMINTException {

		ModelRel propRel = origRel.getMetatype().createInstanceAndEndpoints(null, OUT_MODELREL, ECollections.newBasicEList(model2), outputMID);
		
		// Retrieve the model elements in the original model relation.
		// Note: traceRel and origRel may refer to different copies of the same 
		// model instance. Therefore, to identify the corresponding elements of
		// each copy, their URIs will be used.
		ModelEndpointReference origRelEndpoint = origRel.getModelEndpointRefs().get(0);
		List<String> origElemList = new ArrayList<String>();
		for (ModelElementReference mer : origRelEndpoint.getModelElemRefs()) {
			String uri = mer.getObject().getUri();
			origElemList.add(uri);
			System.out.println("Retrieving from original model: " + uri);
		}
		
		// Retrieve the mappings from the trace model relation.
		List<Mapping> mappingList = traceRel.getMappings();
		
		// Iterate through the mappings to retrieve each model element in the 
		// second model that corresponds to the model elements retrieved from
		// the original model relation.
		// Note: It is assumed that the mappings may not be binary and that 
		// the mappings may not originate from the original model elements.
		// In fact, it is also assumed that each mapping may contain more
		// than one element from the original model relation.
		List<ModelElement> traceElemList = new ArrayList<ModelElement>();
		for (Mapping m : mappingList) {
			boolean relevantFlag = false;			
			List<ModelElementEndpoint> meeList = m.getModelElemEndpoints();
			
			Iterator<ModelElementEndpoint> iter = meeList.iterator();
			while (iter.hasNext()) {
				String curUri = iter.next().getTarget().getUri();
				if (origElemList.contains(curUri)) {
					relevantFlag = true;
					break;
				}
			}
			
			if (relevantFlag) {
				ModelElement obj;
				for (ModelElementEndpoint mee : meeList) {
					obj = mee.getTarget();
					if (!origElemList.contains(obj.getUri())) {
						traceElemList.add(obj);
						System.out.println("Tracing to: " + obj.getUri());
					}
				}
			}
		}
		
		// Add the traced model elements to the output model relation.
		EObject emfObj;
		ModelEndpointReference propMer = propRel.getModelEndpointRefs().get(0);
		for (ModelElement elem : traceElemList) {
			emfObj = elem.getEMFInstanceObject();
			propMer.createModelElementInstanceAndReference(emfObj, null);
			System.out.println("Adding to relation: " + emfObj);
		}
		
		return propRel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Input input = new Input(inputsByName);
		MID outputMID = outputMIDsByName.get(OUT_MODELREL);

		// propagate the unary original rel through the trace rel
		ModelRel propRel = this.propagate(input.origRel, input.traceRel, input.model1, input.model2, outputMID);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, propRel);

		return outputsByName;
	}

}
