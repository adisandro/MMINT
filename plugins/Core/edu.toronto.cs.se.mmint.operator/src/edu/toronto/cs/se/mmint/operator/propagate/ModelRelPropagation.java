/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.propagate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

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

	    // prepare the propagated rel
        ModelRel propRel = origRel.getMetatype().createInstanceAndEndpoints(null, OUT_MODELREL, ECollections.newBasicEList(model2), outputMID);
        ModelEndpointReference propModel2EndpointRef = propRel.getModelEndpointRefs().get(0);
	    String model2Uri = model2.getUri();
        URI model2EMFUri = FileUtils.createEMFUri(model2Uri, true);
        Resource model2EMFResource = new ResourceSetImpl().getResource(model2EMFUri, true);

        // get uris of original model objects
        Set<String> origModelObjUris = origRel.getModelEndpointRefs().get(0).getModelElemRefs().stream()
            .map(origModelElemRef -> MIDRegistry.getModelObjectUri(origModelElemRef.getObject()))
            .collect(Collectors.toSet());
        // loop through traceability mappings (can be n-ary, and not include any original model object)
        for (Mapping traceMapping : traceRel.getMappings()) {
            Set<ModelElement> model2Elems = new HashSet<>();
            boolean propagate = false;
            for (ModelElementEndpoint traceModelElemEndpoint : traceMapping.getModelElemEndpoints()) {
                ModelElement traceModelElem = traceModelElemEndpoint.getTarget();
                if (origModelObjUris.contains(MIDRegistry.getModelObjectUri(traceModelElem))) {
                    // propagate if an original model object is found
                    propagate = true;
                    continue;
                }
                if (model2Uri.equals(((Model) traceModelElem.eContainer()).getUri())) {
                    // collect model objects from model2 only to propagate
                    model2Elems.add(traceModelElem);
                }
            }
            if (!propagate) {
                continue;
            }
            // propagate!
            for (ModelElement model2Elem : model2Elems) {
                EObject model2Obj = model2Elem.getEMFInstanceObject(model2EMFResource);
                propModel2EndpointRef.createModelElementInstanceAndReference(model2Obj, null);
            }
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
