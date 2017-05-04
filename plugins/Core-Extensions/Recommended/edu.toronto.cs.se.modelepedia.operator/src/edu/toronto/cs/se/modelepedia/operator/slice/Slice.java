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
package edu.toronto.cs.se.modelepedia.operator.slice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;

public class Slice extends OperatorImpl {

	// input-output
	protected final static @NonNull String IN_MODELREL = "criterion";
	protected final static @NonNull String OUT_MODELREL = "slice";

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean isAllowedInput(Map<String, Model> inputsByName) {

			ModelRel critRel = (ModelRel) inputsByName.get(IN_MODELREL);
			if (critRel.getModelEndpoints().size() > 1) {
				return false;
			}

			return true;
		}

		@Override
		public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

			Input input = new Input(inputsByName);
			ModelRel sliceRel = (ModelRel) outputsByName.get(OUT_MODELREL);
			Map<ModelRel, List<Model>> validOutputs = new HashMap<>();
			List<Model> endpointModels = new ArrayList<>();
			endpointModels.add(input.model);
			validOutputs.put(sliceRel, endpointModels);

			return validOutputs;
		}

	}

	private static class Input {

		private ModelRel critRel;
		private Model model;

		public Input(Map<String, Model> inputsByName) {

			this.critRel = (ModelRel) inputsByName.get(IN_MODELREL);
			this.model = critRel.getModelEndpoints().get(0).getTarget();
		}
	}

	// Returns the complete list of model elements that may be impacted
	// by the model elements included in the original slicing criterion.
	public Set<EObject> getImpactedElements(ModelRel criterion) throws MMINTException {

		Set<EObject> impacted = new HashSet<>();
		ModelEndpointReference modelEndpointRef = criterion.getModelEndpointRefs().get(0);
		URI rUri = FileUtils.createEMFUri(modelEndpointRef.getTargetUri(), true);
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(rUri, true);

		EObject elem;
		for (ModelElementReference mer : modelEndpointRef.getModelElemRefs()) {
			elem = mer.getObject().getEMFInstanceObject(r);
			if (impacted.contains(elem)) {
				continue;
			}
			impacted.add(elem);
			// Get all model elements impacted by the element.
			this.addImpactedModelElems(elem, impacted);
		}

		return impacted;
	}

    // Adds impacted model elements reachable from a single model element
    // By default, all contained and connected model elements are assumed to be impacted
	public void addImpactedModelElems(EObject elem, Set<EObject> impacted) {

	    for (EObject reachableElem : elem.eContents()) {
	        if (impacted.contains(reachableElem)) {
	            continue;
	        }
            impacted.add(reachableElem);
            this.addImpactedModelElems(reachableElem, impacted);
	    }
        for (EObject reachableElem : elem.eCrossReferences()) {
            if (impacted.contains(reachableElem)) {
                continue;
            }
            impacted.add(reachableElem);
            this.addImpactedModelElems(reachableElem, impacted);
        }
	}

	protected ModelRel slice(ModelRel critRel, Model model, MID outputMID) throws MMINTException {

	    ModelRel sliceRel = critRel.getMetatype().createInstanceAndEndpoints(null, OUT_MODELREL, ECollections.newBasicEList(model), outputMID);

		// Iterate through the criteria to identify all dependent elements that are also impacted.
		Set<EObject> changed = this.getImpactedElements(critRel);

		for (EObject element : changed){
			sliceRel.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(element, null);
		}

		return sliceRel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Input input = new Input(inputsByName);
		MID outputMID = outputMIDsByName.get(OUT_MODELREL);

		// create the slice from the initial criterion and the rules
		ModelRel sliceRel = this.slice(input.critRel, input.model, outputMID);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, sliceRel);

		return outputsByName;
	}

}
