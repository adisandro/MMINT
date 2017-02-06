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
package edu.toronto.cs.se.modelepedia.operator.slice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Slice extends OperatorImpl {

	protected final static @NonNull String IN_MODELREL = "criterion";
	protected final static @NonNull String OUT_MODELREL = "slice";

	// Get all impacted elements of the class diagram from the input.
	// These elements are assumed to be identified by strings of the 
	// form "[classes->] Class Name of Class", where "Name of Class" 
	// is unique for each element and is therefore the actual string 
	// of interest.
	public List<String> getCriterionElements(ModelRel criterion){
		List<String> criterionList = new ArrayList<>();
 
		List<ModelElementReference> merList = 
				criterion.getModelEndpointRefs().get(0).getModelElemRefs();

		String elemName;
		for (ModelElementReference mer : merList) {
			elemName = mer.getObject().getName().split(" ", 3)[2];
			criterionList.add(elemName);
			System.out.println("Getting input elements: " + elemName);
		}
		return criterionList;
	}

	public List<EObject> getAllModelElements(Model in, EObject root) throws MMINTException{
		List<EObject> unchecked = new ArrayList<EObject>();
		return unchecked;
	}

	// Iterate through the unchecked list of class diagram elements to
	// identify all those which are included in the input criterion.
	public List<EObject> matchCriterionToModelElements(List<EObject> unchecked, List<String> criterionList)
	{
		List<EObject> unprocessed = new ArrayList<EObject>();
		return unprocessed;
	}

	public List<EObject> getImpactedElements(List<EObject> unprocessed, List<EObject> unchecked){
		List<EObject> changed = new ArrayList<EObject>();
		return changed;
	}

	protected ModelRel slice(ModelRel critRel, MID outputMID) throws MMINTException {

		Model model = critRel.getModelEndpoints().get(0).getTarget();
		ModelRel sliceRel = critRel.getMetatype().createInstanceAndEndpoints(null, OUT_MODELREL, ECollections.newBasicEList(model), outputMID);

		List<String> criterionList = new ArrayList<>();
		List<EObject> changed = new ArrayList<EObject>();
		List<EObject> unprocessed = new ArrayList<EObject>();
		List<EObject> unchecked = new ArrayList<EObject>();

		// Get the input class diagram.
		EObject root = model.getEMFInstanceRoot();
		//ClassDiagram root = (ClassDiagram) in.getEMFInstanceRoot(); 

		// Add all elements in the class diagram to the unchecked list.
		unchecked = getAllModelElements(model, root);

		criterionList = getCriterionElements(critRel);

		// Iterate through the unchecked list of class diagram elements to
		// identify all those which are included in the input criterion.
		unprocessed = matchCriterionToModelElements(unchecked, criterionList);
		
		// Iterate through the unprocessed list of impacted elements
		// to identify all dependent elements that are also impacted.
		changed = getImpactedElements(unprocessed, unchecked);

		for (EObject element : changed){
			sliceRel.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(element, null);
		}
		
		return sliceRel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {
		
		// input
		ModelRel critRel = (ModelRel) inputsByName.get(IN_MODELREL);
		MID outputMID = outputMIDsByName.get(OUT_MODELREL);

		// create the slice from the initial criterion and the rules
		ModelRel sliceRel = this.slice(critRel, outputMID);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, sliceRel);

		return outputsByName;
	}

}
