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

	// Get impacted model elements directly reachable from the input element.
	@Override
	protected Set<EObject> getDirectlyImpactedElements(EObject modelObj, Set<EObject> alreadyImpacted) {

	    Set<EObject> impacted = new HashSet<>();
		// If input is a class diagram, then the following are also impacted:
		// 1) Owned classes, associations and dependencies.
		if (modelObj instanceof ClassDiagram) {
			ClassDiagram cd = (ClassDiagram) modelObj;
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
		if (modelObj instanceof Class) {
			Class c = (Class) modelObj;
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
			for (Class c2 : cd.getClasses()) {
				for (Attribute a : c2.getOwnedAttributes()) {
					if (a.getType() == c) {
						impacted.add(a);
					}
				}
				for (Operation o : c2.getOwnedOperations()) {
					if (o.getType() == c) {
						impacted.add(o);
					}
				}
			}
		}

		// If input is an attribute, then its class is also impacted.
		else if (modelObj instanceof Attribute) {
			Attribute a = (Attribute) modelObj;
			impacted.add(a.getOwner());
		}

		// If input is an operation, then its class is also impacted.
		else if (modelObj instanceof Operation) {
			Operation o = (Operation) modelObj;
			impacted.add(o.getOwner());
		}

		// If input is an association, then its source class is also impacted.
		else if (modelObj instanceof Association) {
			Association a = (Association) modelObj;
			impacted.add(a.getSource());
		}

		// If input is a dependency, then its depender class is also impacted.
		else if (modelObj instanceof Dependency) {
			Dependency d = (Dependency) modelObj;
			impacted.add(d.getDepender());
		}
		impacted.removeAll(alreadyImpacted);
		impacted.remove(null);

		return impacted;
	}
}
