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
package edu.toronto.cs.se.nlsfung.gsn.operator;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.operator.slice.Slice;
import edu.toronto.cs.se.nlsfung.gsn.Context;
import edu.toronto.cs.se.nlsfung.gsn.ContextualElement;
import edu.toronto.cs.se.nlsfung.gsn.CoreElement;
import edu.toronto.cs.se.nlsfung.gsn.Goal;
import edu.toronto.cs.se.nlsfung.gsn.GoalSupporter;
import edu.toronto.cs.se.nlsfung.gsn.Solution;
import edu.toronto.cs.se.nlsfung.gsn.Strategy;
import edu.toronto.cs.se.nlsfung.gsn.StrategySupporter;

public class GSNSliceRevise extends Slice {

	// Adds impacted model elements reachable from a single model element
	@Override
	public void addImpactedModelElems(EObject elem, Set<EObject> impacted) {

		if (elem instanceof Goal) {
			Goal g = (Goal) elem;
			
			// Impacted: 
			// 1) All strategies the goal supports or is supported by. 
			// 2) All solutions the goal is supported by.
			impacted.add(g.getSupportedBy());
			impacted.add(g.getSupports());
			
		} else if (elem instanceof Strategy) {
		    Strategy s = (Strategy) elem;
		    
		    // Impacted: All goals the strategy supports or is supported by.
			impacted.add(s.getSupports());
			impacted.addAll(s.getSupportedBy());
		    
		} else if (elem instanceof Solution) {
			Solution s = (Solution) elem;
			
            // Impacted: Goals supported by the solution.
			impacted.addAll(s.getSupports());
		}
		else if (elem instanceof Context) {
			Context c = (Context) elem;
			
            // Impacted:
			// 1) All goals, strategies and solutions that are in this context.
			// 2) All goals, strategies and solutions that inherit this context.			
			Set<CoreElement> descendants = new HashSet<>();
			for (CoreElement coreElem : c.getContextOf()) {
				addDescendants(coreElem, descendants);
			}
			impacted.addAll(descendants);
			impacted.addAll(c.getContextOf());
		}
		
		// Remove any null pointers from the impacted set.
		impacted.remove(null);
	}
	
	
	// Adds all the descendants of the input core element to the input result set.
	public void addDescendants(CoreElement elem, Set<CoreElement> result) {
		if (elem instanceof Goal) {
			Goal g = (Goal) elem;
			CoreElement descendant = g.getSupportedBy();
			if (!result.contains(descendant) && descendant != null) {
				result.add(descendant);
				addDescendants(descendant, result);
			}
			
		} else if (elem instanceof Strategy) {
			Strategy s = (Strategy) elem;
			if (s.getSupportedBy() != null) {
				for (CoreElement descendant : s.getSupportedBy()) {
					if (!result.contains(descendant) && descendant != null) {
						result.add(descendant);
						addDescendants(descendant, result);
					}
				}
			}
			
		} else if (elem instanceof Solution) {
			return;
		}
	}
}
