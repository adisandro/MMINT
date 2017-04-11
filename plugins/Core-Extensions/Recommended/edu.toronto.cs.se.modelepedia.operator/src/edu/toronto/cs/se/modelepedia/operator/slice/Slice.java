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
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

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


	// Extract all model elements from the input slicing criterion. 
	public List<EObject> getCriterionElements(ModelRel criterion) 
			throws MMINTException {
		List<EObject> criterionList = new ArrayList<EObject>();
 
		List<ModelElementReference> merList = 
				criterion.getModelEndpointRefs().get(0).getModelElemRefs();

		EObject elem;
		for (ModelElementReference mer : merList) {
			elem = mer.getObject().getEMFInstanceObject();
			criterionList.add(elem);
			System.out.println("Getting input elements: " + elem);
		}
		return criterionList;
	}
	
	// Extract all model elements from the model to be sliced.
	public List<EObject> getAllModelElements(Model in, EObject root) 
			throws MMINTException {
		List<EObject> unchecked = new ArrayList<EObject>();
				
		Iterator<EObject> iter = root.eAllContents();
		while (iter.hasNext()) {
			unchecked.add(iter.next());
		}
		
		return unchecked;
	}

	// Iterate through the unchecked list of model elements to identify 
	// all those which are included in the input criterion.
	// Note: It is assumed that there may be a many-to-many correspondence
	// between elements in the unchecked list and the criterion list.
	public List<EObject> matchCriterionToModelElements(
			List<EObject> unchecked, List<EObject> criterionList) {
		List<EObject> unprocessed = new ArrayList<EObject>();

		Iterator<EObject> uncheckedIter = unchecked.iterator();
		while (uncheckedIter.hasNext()) {
			EObject elem = uncheckedIter.next();
			for (EObject critElem : criterionList) {
				if (isModelElemEqual(elem, critElem)) {
					unprocessed.add(elem);
					System.out.println("Criterion Added: " + elem);
					uncheckedIter.remove();
				}
			}
		}
		
		return unprocessed;
	}
	
	// Checks whether the two input model elements are equivalent. 
	// This is necessary as even for the same model elements, different 
	// calls to getEMFInstanceObject() will return different EMF instances.
	public boolean isModelElemEqual(EObject obj1, EObject obj2) {
		return true;
	}
	
	// Checks whether the elements in the two input lists are equivalent.
	// Note: It is assumed that there must be a one-to-one mapping between
	// each element in the two input lists.
	public boolean isElemListEqual(List<? extends EObject> list1, 
			List<? extends EObject> list2) {
		boolean equalFlag = true; 

		for (EObject obj1 : list1) {
			boolean curEqualFlag = false;
			Iterator<? extends EObject> iter2 = list2.iterator();
			
			while (iter2.hasNext()) {
				if (isModelElemEqual(obj1, iter2.next())) {
					iter2.remove();
					curEqualFlag = true;
					break;						
				}
			}
			
			equalFlag = equalFlag && curEqualFlag;
		}
		
		
		if (!list2.isEmpty()) {
			equalFlag = false;
		}
		
		return equalFlag;
		
				
	}

	// Returns the complete list of model elements that may be impacted
	// by the model elements included in the original slicing criterion.
	// By default, all model elements are assumed to be impacted by the slice.
	public List<EObject> getImpactedElements(
			List<EObject> unprocessed, List<EObject> unchecked) {
		
		List<EObject> changed = new ArrayList<EObject>();
		Iterator<EObject> unprocessedIter = unprocessed.iterator();
		
		while (unprocessedIter.hasNext()) {
			System.out.println("Elements to be processed: " + 
					+ unprocessed.size());
			EObject obj = unprocessedIter.next();

			if (changed.contains(obj)){
				// This element has already been checked for dependencies.
				unprocessed.remove(obj);

			} else {
				unprocessed.remove(obj);
				changed.add(obj);
				System.out.println("Current element: " + obj);
				
				// Get all model elements affected by the impacted model element.
				EObject uncheckedObj;
				Iterator<EObject> uncheckedIter = unchecked.iterator();
				while (uncheckedIter.hasNext()) {
					uncheckedObj = uncheckedIter.next();
					if (isModelElemImpactedBy(uncheckedObj, obj)) {
						unprocessed.add(uncheckedObj);
						uncheckedIter.remove();
					}
				}
			}
			
			unprocessedIter = unprocessed.iterator();
		}
		
		return changed;
	}
	
	// Checks whether the first input model element is potentially
	// impacted by the second second input model element.
	public boolean isModelElemImpactedBy(EObject obj1, EObject obj2) {
		return true;
	}

	protected ModelRel slice(ModelRel critRel, Model model, MID outputMID) throws MMINTException {
		ModelRel sliceRel = critRel.getMetatype().createInstanceAndEndpoints(null, OUT_MODELREL, ECollections.newBasicEList(model), outputMID);

		List<EObject> criterionList = new ArrayList<>();
		List<EObject> changed = new ArrayList<EObject>();
		List<EObject> unprocessed = new ArrayList<EObject>();
		List<EObject> unchecked = new ArrayList<EObject>();

		// Get the input class diagram.
		EObject root = model.getEMFInstanceRoot();
		
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
