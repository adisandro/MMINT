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
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.safetycase.AndSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.MofNSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.OrSupporter;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;
import edu.toronto.cs.se.modelepedia.safetycase.XorSupporter;

// Contains useful functions for slicing safety cases.
public class GSNSlice extends Slice {
	
	// Returns all child core elements of the input decomposable core element.
	public Set<CoreElement> getChildCoreElements(DecomposableCoreElement inputElem) {
		Set<CoreElement> children = new HashSet<>();
		
		Set<Supportable> supportablesCur = new HashSet<>();
		Set<Supportable> supportablesAll = new HashSet<>();
		Set<Supportable> supportablesNext = new HashSet<>();
		
		supportablesCur.add(inputElem);
		while (!supportablesCur.isEmpty()) {
			for (Supportable elem: supportablesCur) {
				for (SupportedBy rel : elem.getSupportedBy()) {
					Supporter s = rel.getTarget();
					
					if (s instanceof CoreElement) {
						children.add((CoreElement) s);
						
					} else if (s instanceof SupportConnector) {
						supportablesNext.add((SupportConnector) s);
					}						
				}				
			}
			
			supportablesCur.clear();
			for (Supportable s: supportablesNext) {
				if (!supportablesAll.contains(s)) {
					supportablesAll.add(s);
					supportablesCur.add(s);
				}
			}
			
			supportablesNext.clear();
		}

		return children;
	}
	
	// Returns all parents of support connectors that are impacted.
	public Set<Supportable> getConnectorDependants(Set<SupportConnector> connectors, Set<EObject> alreadyImpacted) {
		Set<Supportable> supportablesCur = new HashSet<>();
		Set<Supportable> supportablesNext = new HashSet<>();
		Set<Supportable> supportablesAll = new HashSet<>();
		
		supportablesCur.addAll(connectors);
		supportablesAll.addAll(connectors);
        while (!supportablesCur.isEmpty()) {
    		Set<EObject> impactedAll = new HashSet<>();
    		impactedAll.addAll(alreadyImpacted);
    		impactedAll.addAll(supportablesAll);
        	
        	for (Supportable elem: supportablesCur) {
        		// Add parents to impacted set if necessary.
        		if (isImpactPropagatedUp(elem, impactedAll)) {
    				for (SupportedBy rel: elem.getSupports()) {
    					supportablesNext.add(rel.getSource());
    				}        			
        		}
        	}
        	
        	// Iterate through impacted elements, adding:
        	// 1) New support connectors to the next iteration.
        	supportablesCur.clear();
        	for (Supportable elem: supportablesNext) {
        		if (!supportablesAll.contains(elem)) {
        			supportablesAll.add(elem);
        				
        			if (elem instanceof SupportConnector) {
        				supportablesCur.add(elem);
        			}
        		}
        	}
        	
        	supportablesNext.clear();
        }
        
        return supportablesAll;
	}
	
	// Returns all ancestor goals of the input core element, stopping when one is already impacted.
	public Set<Goal> getAncestorGoals(CoreElement elem, Set<EObject> alreadyImpacted) {
		Set<Supportable> ancestorsCur = new HashSet<>();
		Set<Supportable> ancestorsNext = new HashSet<>();
		Set<Supportable> ancestorsAll = new HashSet<>();
		Set<Goal> goalAncestors = new HashSet<>();

		// Iterate through the current set of newly added ancestors
		// to identify the next generation of ancestors.
		for (SupportedBy rel : elem.getSupports()) {
			ancestorsNext.add(rel.getSource());
			if (rel.getSource() instanceof Goal) {
				goalAncestors.add((Goal) rel.getSource());
			}
		}

		ancestorsCur.addAll(ancestorsNext);
		ancestorsAll.addAll(ancestorsNext);
		ancestorsNext.clear();

		while (!ancestorsCur.isEmpty()) {
			Set<EObject> impactedAll = new HashSet<>();
			impactedAll.addAll(alreadyImpacted);
			impactedAll.addAll(ancestorsAll);
			
			for (Supportable curElem : ancestorsCur) {
				if (isImpactPropagatedUp(curElem, impactedAll)) {
					for (SupportedBy rel : curElem.getSupports()) {
						ancestorsNext.add(rel.getSource());
					}
				}
			}

			ancestorsCur.clear();
			for (Supportable newElem : ancestorsNext) {
				if (!ancestorsAll.contains(newElem)) {
					ancestorsAll.add(newElem);
					ancestorsCur.add(newElem);
				}
				
				if (newElem instanceof Goal) {
					goalAncestors.add((Goal) newElem);
				}
			}

			ancestorsNext.clear();
		}
				
		return goalAncestors;
	}
	
	// Determines whether a change impact is propagated up or not given the 
	// source impacted element and a set of other impacted elements.
	public boolean isImpactPropagatedUp(Supportable elem, Set<EObject> alreadyImpacted) {
		boolean isImpactPropagated = false;
		
		// Count the number of children impacted.
		int impactCount = 0;
		int totalCount = 0;
		
		for (SupportedBy rel: elem.getSupportedBy()) {
			totalCount += 1;
			
			if (alreadyImpacted.contains(rel.getTarget())) {
				impactCount += 1;
				continue;
				
			} else if (rel.getTarget() instanceof SupportConnector) {
				if (isImpactPropagatedUp((SupportConnector) rel.getTarget(), alreadyImpacted)) {
					impactCount += 1;
					continue;					
				}
			}
		}
		
		// If a core element is impacted, then its parents are also impacted.
		if (elem instanceof CoreElement) {
			isImpactPropagated = true;
		
		// If an AND-connector is impacted, then its parents are 
		// impacted if any of its children are impacted.
		} else if (elem instanceof AndSupporter) {
			if (impactCount >= 1) {
				isImpactPropagated = true;
			}
		
		// If an OR-connector is impacted, then its parents are 
		// impacted if all its children are impacted.
		} else if (elem instanceof OrSupporter) {
			if (impactCount == totalCount) {
				isImpactPropagated = true;
			}
		
		// If an XOR-connector is impacted, then its parents are 
		// impacted if any of its children are impacted.        		
		} else if (elem instanceof XorSupporter) {
			if (impactCount >= 1) {
				isImpactPropagated = true;
			}
		
		// If an M-of-N connector is impacted, then its parents are 
		// impacted if more than (N-M) children are impacted.
		} else if (elem instanceof MofNSupporter) {
			long target = ((MofNSupporter) elem).getTarget();
			
			if (impactCount > totalCount - target) {
				isImpactPropagated = true;
			}
		}
		
		return isImpactPropagated;
	}

}
