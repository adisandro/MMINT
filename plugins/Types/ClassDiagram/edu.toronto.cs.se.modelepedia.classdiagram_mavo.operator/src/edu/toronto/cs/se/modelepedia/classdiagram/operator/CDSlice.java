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

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.operator.slice.Slice;
import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram.Class;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;

public class CDSlice extends Slice {

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

		// If input is a class diagram, then the following are also impacted:
		// 1) Owned classes, associations and dependencies.
		if (elem instanceof ClassDiagram) {
			ClassDiagram cd = (ClassDiagram) elem;
			impacted.addAll(cd.getClasses());
			impacted.addAll(cd.getAssociations());
			impacted.addAll(cd.getDependencies());
		}

		// If input is a class, then the following are also impacted:
		// 1) Owned attributes and operations.
		// 2) All associations and dependencies connected to it.
		// 3) Attributes and operations whose type is the input.
		// 4) Classes directly nested in or extending from the input.
		// 5) The class that the input is nested in (if any).
		if (elem instanceof Class) {
			Class c = (Class) elem;
			impacted.addAll(c.getOwnedAttributes());
			impacted.addAll(c.getOwnedOperations());
			impacted.addAll(c.getAssociationsAsSource());
			impacted.addAll(c.getAssociationsAsTarget());
			impacted.addAll(c.getDependenciesAsDependee());
			impacted.addAll(c.getDependenciesAsDepender());
			impacted.addAll(c.getNested());
			impacted.addAll(c.getSubclasses());
			impacted.add(c.getNestedIn());
			
			// Get all attributes and operations from the class diagram
			// for checking their type.
			ClassDiagram cd = (ClassDiagram) c.eContainer();
			if (cd.getClasses() != null) {
				for (Class c2 : cd.getClasses()) {
					if (c2.getOwnedAttributes() != null) {
						for (Attribute a : c2.getOwnedAttributes()) {
							if (a.getType() == c) {
								impacted.add(a);
							}
						}
					}

					if (c2.getOwnedOperations() != null) {
						for (Operation o : c2.getOwnedOperations()) {
							if (o.getType() == c) {
								impacted.add(o);
							}
						}
					}
				}
			}
		}

		// If input is an attribute, then its class is also impacted.
		else if (elem instanceof Attribute) {
			Attribute a = (Attribute) elem;
			impacted.add(a.getOwner());
		}

		// If input is an operation, then its class is also impacted.
		else if (elem instanceof Operation) {
			Operation o = (Operation) elem;
			impacted.add(o.getOwner());
		}

		// If input is an association, then its source class is also impacted.
		else if (elem instanceof Association) {
			Association a = (Association) elem;
			impacted.add(a.getSource());
		}

		// If input is a dependency, then its depender class is also impacted.
		else if (elem instanceof Dependency) {
			Dependency d = (Dependency) elem;
			impacted.add(d.getDepender());
		}

		// Remove possible null element from impacted set.
		impacted.remove(null);
		
		return impacted;
	}
}