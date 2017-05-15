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

import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.operator.slice.Slice;
import edu.toronto.cs.se.nlsfung.gsn.Context;
import edu.toronto.cs.se.nlsfung.gsn.Goal;
import edu.toronto.cs.se.nlsfung.gsn.Solution;
import edu.toronto.cs.se.nlsfung.gsn.Strategy;

public class GSNSliceRecheck extends Slice {

	// Adds impacted model elements reachable from a single model element
	@Override
	public void addImpactedModelElems(EObject elem, Set<EObject> impacted) {

		if (elem instanceof Goal) {
			Goal g = (Goal) elem;
			
			// Impacted: conclusion goals linked via the strategy it supports
			Strategy s = (Strategy) g.getSupports();
			if (s != null) {
				Goal gSuper = s.getSupports();
				if (!impacted.contains(gSuper)) {
					impacted.add(gSuper);
					addImpactedModelElems(gSuper, impacted);				
				}				
			}
		}
		
		else if (elem instanceof Strategy) {
		    // no impacted elements
		}
		else if (elem instanceof Solution) {
			Solution s = (Solution) elem;
			
            // Impacted: Goals supported by the solution.
			for (Goal g : s.getSupports()) {
				if (!impacted.contains(g)) {
					impacted.add(g);
					addImpactedModelElems(g, impacted);
				}
			}
		}
		else if (elem instanceof Context) {
            // no impacted elements
		}
		
		// Remove any null pointers from the impacted set.
		impacted.remove(null);
	}

}
