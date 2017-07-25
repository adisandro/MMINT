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
package edu.toronto.cs.se.modelepedia.classdiagram.operator;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram.Class;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;
import edu.toronto.cs.se.modelepedia.operator.slice.WellFormedSlice;

// CDWellFormedSlice is a specialisation of the slice operator for performing a 
// slice on a single class diagram such that the resulting slice satisfies the
// well-formed conditions of the class diagram meta-model.
public class CDWellFormedSlice extends WellFormedSlice {

	@Override
	// Get all model elements that are potentially impacted by the input set.
	public Set<EObject> getAllImpactedElements(Set<EObject> elemSet) {
		Set<EObject> impactedAll = new HashSet<>();
		Set<EObject> impactedCur = new HashSet<>();
		Set<EObject> impactedNext = new HashSet<>();
		
		// Iterate through the current set of newly added model elements 
		// to identify all others that may be potentially impacted. 
		impactedAll.addAll(elemSet);
		impactedCur.addAll(elemSet);
		while (!impactedCur.isEmpty()) {
			for (EObject elem : impactedCur) {
				// Get all model elements directly impacted by the current 
				// one in consideration and remove duplicates.
				for (EObject newElem : getDirectlyImpactedElements(elem)) {
					if (!impactedAll.contains(newElem)) {
						impactedAll.add(newElem);
						impactedNext.add(newElem);
					}
				}
			}
			
			// Prepare for next iteration.
			impactedCur.clear();
			impactedCur.addAll(impactedNext);
			impactedNext.clear();
		}
		
		return impactedAll;
	}
	
	// Get impacted model elements directly reachable from the input element.
	@Override
	public Set<EObject> getDirectlyImpactedElements(EObject elem) {
		Set<EObject> impacted = new HashSet<>();

		// The input element itself is always impacted.
		impacted.add(elem);

		// If input is a class diagram, then nothing else is impacted. 
		if (elem instanceof ClassDiagram) {

		// If input is a class, then the class diagram is also impacted.
		} else if (elem instanceof Class) {
			Class c = (Class) elem;
			impacted.add(c.eContainer());
		
		// If input is an attribute, then its class is also impacted.
		} else if (elem instanceof Attribute) {
			Attribute a = (Attribute) elem;
			impacted.add(a.getOwner());

		// If input is an operation, then its class is also impacted.
		} else if (elem instanceof Operation) {
			Operation o = (Operation) elem;
			impacted.add(o.getOwner());

		// If input is an association, then the class diagram as well as its 
		// source and target class are also impacted.
		} else if (elem instanceof Association) {
			Association a = (Association) elem;
			impacted.add(a.getSource());
			impacted.add(a.getTarget());
			impacted.add(a.eContainer());

		// If input is a dependency, then the class diagram as well as its
		// dependee and depender class are also impacted.
		} else if (elem instanceof Dependency) {
			Dependency d = (Dependency) elem;
			impacted.add(d.getDepender());
			impacted.add(d.getDependee());
			impacted.add(d.eContainer());
		}

		// Remove possible null element from impacted set.
		impacted.remove(null);
		
		return impacted;
	}
}