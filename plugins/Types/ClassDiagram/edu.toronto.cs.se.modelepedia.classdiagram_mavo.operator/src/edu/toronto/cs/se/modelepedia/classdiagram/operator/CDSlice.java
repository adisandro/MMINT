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

	// Adds impacted model elements reachable from a single model element
	@Override
	public void addImpactedModelElems(EObject elem, Set<EObject> impacted) {

		if (elem instanceof Class) {
			Class c = (Class) elem;
			// Impacted:
			// 1) nested classes and subclasses
			for (Class sub: c.getSubclasses()) {
				if (impacted.contains(sub)) {
					continue;
				}
				impacted.add(sub);
				addImpactedModelElems(sub, impacted);
			}
			for (Class nested: c.getNested()) {
				if (impacted.contains(nested)) {
					continue;
				}
				impacted.add(nested);
				addImpactedModelElems(nested, impacted);
			}
			// 2) owned attributes and operations
			for (Attribute a : c.getOwnedAttributes()) {
				if (impacted.contains(a)) {
					continue;
				}
				impacted.add(a);
				addImpactedModelElems(a, impacted);
			}
			for (Operation o : c.getOwnedOperations()) {
				if (impacted.contains(o)) {
					continue;
				}
				impacted.add(o);
				addImpactedModelElems(o, impacted);
			}
			// 3) other attributes and operation whose type is c
			ClassDiagram cd = (ClassDiagram) c.eContainer();
			for (Class c2 : cd.getClasses()) {
				if (impacted.contains(c2)) {
					continue;
				}
				for (Attribute a : c2.getOwnedAttributes()) {
					if (impacted.contains(a) || a.getType() != c) {
						continue;
					}
					impacted.add(a);
					addImpactedModelElems(a, impacted);
				}
				for (Operation o : c2.getOwnedOperations()) {
					if (impacted.contains(o) || o.getType() != c)	{
						continue;
					}
					impacted.add(o);
					addImpactedModelElems(o, impacted);
				}
			}
			// 4) associations that have c as source
			for (Association a : c.getAssociationsAsSource()) {
				if (impacted.contains(a)) {
					continue;
				}
				impacted.add(a);
				addImpactedModelElems(a, impacted);
			}
			// 5) dependencies that have c as depender
			for (Dependency d : c.getDependenciesAsDepender()) {
				if (impacted.contains(d)) {
					continue;
				}
				impacted.add(d);
				addImpactedModelElems(d, impacted);
			}
		}
		else if (elem instanceof Attribute) {
		    // no impacted elements
		}
		else if (elem instanceof Operation) {
            // no impacted elements
		}
		else if (elem instanceof Association) {
            // no impacted elements
		}
		else if (elem instanceof Dependency) {
            // no impacted elements
		}
	}

}
