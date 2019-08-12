/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.AndSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.Assumption;
import edu.toronto.cs.se.modelepedia.safetycase.Context;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.InContextOf;
import edu.toronto.cs.se.modelepedia.safetycase.IndependenceGoal;
import edu.toronto.cs.se.modelepedia.safetycase.Justification;
import edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.OrSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;
import edu.toronto.cs.se.modelepedia.safetycase.XorSupporter;
import edu.toronto.cs.se.mmint.operator.slice.Slice;

public class GSNSliceRevise2Content extends GSNSlice {

    // Get all model elements in a safety case that needs to be re-checked for 
	// content validity given the input element that requires revision.
    @Override
    protected Map<EObject, Set<EObject>> getAllImpactedElements(EObject critModelObj, Set<EObject> alreadyImpacted) {

        Map<EObject, Set<EObject>> impacted = new HashMap<>();
        alreadyImpacted.add(critModelObj);

        // Identify all elements (including supported-by connectors) that are 
        // dependent on the revised element.
        Set<EObject> impactedModelObjs = getDirectlyImpactedElements(critModelObj, alreadyImpacted);
        alreadyImpacted.addAll(impactedModelObjs);
        
        // Iterate through newly impacted supported-by connectors and check 
        // whether their sources are impacted as well. Repeat the process 
        // until a fixed point is reached.
        Set<SupportConnector> connectors = new HashSet<>();
        for (EObject elem: alreadyImpacted) {
        	if (elem instanceof SupportConnector) {
        		connectors.add((SupportConnector) elem);
        	}
        }
        
        Set<Supportable> connectorDependants = new HashSet<>(); 
        for (Supportable dependant: getConnectorDependants(connectors, alreadyImpacted)) {
        	if (dependant instanceof CoreElement) {
        		connectorDependants.add(dependant);
        	}
        }
        
        impactedModelObjs.addAll(connectorDependants);  
        
        // If an ASIL decomposition strategy is impacted, then its independence 
        // goal is also impacted.
        Set<IndependenceGoal> independenceGoals = new HashSet<>();
        for (EObject elem: impactedModelObjs) {
        	if (elem instanceof ASILDecompositionStrategy) {
        		for (CoreElement child: getChildCoreElements((ASILDecompositionStrategy) elem)) {
        			if (child instanceof IndependenceGoal) {
        				independenceGoals.add((IndependenceGoal) child);
        			}
        		}
        	}
        }
        
        impactedModelObjs.addAll(independenceGoals);
        
        // Remove supported-by connectors from the impacted elements.
        impactedModelObjs.removeIf(elem -> elem instanceof SupportConnector);
        
        // Return the impacted elements (excluding supported-by connectors).
        impactedModelObjs.add(critModelObj);
        impacted.put(critModelObj, impactedModelObjs);

        return impacted;
    }
	
	// Get impacted model elements directly reachable from the input element.
	@Override
	protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {

	    Set<EObject> impacted = new HashSet<>();

		// If input is a goal, then the following are potentially impacted:
		// 1) Any parent supportable (including supported-by connectors)
		// 2) Any child core element (i.e. goal, strategy or solution).
		if (modelObj instanceof Goal) {
			Goal g = (Goal) modelObj;
			Set<CoreElement> children = getChildCoreElements(g);
			
			Set<Supportable> parents = new HashSet<>();
			for (SupportedBy rel: g.getSupports()) {
				parents.add(rel.getSource());
			}
			
			impacted.addAll(children);
			impacted.addAll(parents);

		// If input is a strategy, then the content validity should be rechecked for:
		// 2) Any child core element.
		// 3) Any contexts and justifications connected to it.
		} else if (modelObj instanceof Strategy) {
			Strategy s = (Strategy) modelObj;
			Set<CoreElement> children = getChildCoreElements(s);
			
			Set<ContextualElement> contexts = new HashSet<>();			
			for (InContextOf rel : s.getInContextOf()) {
				contexts.add(rel.getContext());
			}
			
			impacted.addAll(children);
			impacted.addAll(contexts);

		// If input is a solution, then the content validity should be rechecked for:
		// 1) Any parent supportable.
		} else if (modelObj instanceof Solution) {
			Solution s = (Solution) modelObj;

			Set<Supportable> parents = new HashSet<>();
			for (SupportedBy rel : s.getSupports()) {
				parents.add(rel.getSource());
			}
			
			impacted.addAll(parents);

		// If input is a context, then the content validity should be rechecked for:
		// 1) All argument elements that uses or inherits input context.
		} else if (modelObj instanceof Context) {
			Context c = (Context) modelObj;

			Set<ArgumentElement> inheritors = new HashSet<>();
			for (InContextOf rel : c.getContextOf()) {
				inheritors.addAll(getContextInheritors(rel.getContextOf()));
			}
			
			impacted.addAll(inheritors);

		// If input is a justification, then nothing else requires rechecking.
		} else if (modelObj instanceof Justification) {

		// If input is an assumption, then the following are impacted: 
		// 1) All argument elements that uses or inherits input assumption.
		} else if (modelObj instanceof Assumption) {
			Assumption a = (Assumption) modelObj;
			Set<ArgumentElement> inheritors = new HashSet<>();
			for (InContextOf rel : a.getContextOf()) {
				inheritors.addAll(getContextInheritors(rel.getContextOf()));
			}
			
			impacted.addAll(inheritors);
		}

		impacted.removeAll(alreadyImpacted);

		return impacted;
	}

	// Returns all the descendant argument elements (core and contextual 
	// elements) of the input decomposable core element.
	public Set<ArgumentElement> getContextInheritors(DecomposableCoreElement elem) {
		Set<ArgumentElement> descendantsAll = new HashSet<>();
		Set<ArgumentElement> descendantsCur = new HashSet<>();
		Set<ArgumentElement> descendantsNext = new HashSet<>();

		// Iterate through the current set of newly added descendants
		// to identify the next generation of descendants.
		descendantsAll.add(elem);
		descendantsCur.add(elem);
		while (!descendantsCur.isEmpty()) {
			for (ArgumentElement curElem : descendantsCur) {
				if (curElem instanceof DecomposableCoreElement) {
					DecomposableCoreElement d = (DecomposableCoreElement) curElem;
					if (d.getSupportedBy() != null) {
						descendantsNext.addAll(getChildCoreElements(d));
					}

					if (d.getInContextOf() != null) {
						for (InContextOf rel: d.getInContextOf()) {
							descendantsNext.add(rel.getContext());
						}
					}
				}
			}

			descendantsCur.clear();
			for (ArgumentElement newElem : descendantsNext) {
				if (!descendantsAll.contains(newElem)) {
					descendantsAll.add(newElem);
					descendantsCur.add(newElem);
				}
			}

			descendantsNext.clear();
		}

		return descendantsAll;
	}

}
