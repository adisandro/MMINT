

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

import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram.Class;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;
import edu.toronto.cs.se.modelepedia.operator.slice.Slice;

public class CDSlice extends Slice {

	private static final java.lang.Class<Class> CLASS = Class.class;
	private static final java.lang.Class<Attribute> ATTRIBUTE = Attribute.class;
	private static final java.lang.Class<Operation> OPERATION = Operation.class;
	private static final java.lang.Class<Association> ASSOCIATION = Association.class;
	private static final java.lang.Class<Dependency> DEPENDENCY = Dependency.class;

	// Checks whether the first input model element is potentially
	// impacted by the second second input model element.
	@Override
	public void addImpactedModelElems(EObject elem, Set<EObject> impacted) {

		if (elem instanceof Class) {
			Class c = (Class) elem;

			// If obj2 is a class, obj1 is potentially impacted by obj2 if:
			// 1) obj1 is equivalent to obj2 or one of its nested or sub-classes.
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

			// 2) obj1 is equivalent to an attribute or operation owned by obj2.
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

			// 3) If obj1 is an attribute/operation, its type is equivalent to obj2.
			ClassDiagram cd = (ClassDiagram) c.eContainer();
			for (Class c2 : cd.getClasses()) {
				if (impacted.contains(c2)) {
					continue;
				}

				for (Attribute a : c2.getOwnedAttributes()) {
					if (impacted.contains(a) || a.getType() != c2) {
						continue;
					}
					impacted.add(a);
					addImpactedModelElems(a, impacted);
				}

				for (Operation o : c2.getOwnedOperations()) {
					if (impacted.contains(o) || o.getType() != c2)	{
						continue;
					}
					impacted.add(o);
					addImpactedModelElems(o, impacted);
				}
			}

			// 4) If obj1 is an association, its source is equivalent to obj2.
			for (Association a : c.getAssociationsAsSource()) {
				if (impacted.contains(a)) {
					continue;
				}
				impacted.add(a);
				addImpactedModelElems(a, impacted);
			}


			// 5) If obj1 is a dependency, its depender is equivalent to obj2.
			for (Dependency d : c.getDependenciesAsDepender()) {
				if (impacted.contains(d)) {
					continue;
				}
				impacted.add(d);
				addImpactedModelElems(d, impacted);
			}

		} else if (ATTRIBUTE.isInstance(elem)) {
			// If obj2 is an attribute, obj1 is potentially impacted by obj2 if
			// obj1 is equivalent to obj2.

		} else if (OPERATION.isInstance(elem)) {
			// If obj2 is an attribute, obj1 is potentially impacted by obj2 if
			// obj1 is equivalent to obj2.


		} else if (ASSOCIATION.isInstance(elem)) {
			// If obj2 is an attribute, obj1 is potentially impacted by obj2 if
			// obj1 is equivalent to obj2.

		} else if (DEPENDENCY.isInstance(elem)) {
			// If obj2 is an attribute, obj1 is potentially impacted by obj2 if
			// obj1 is equivalent to obj2.

		}

		return;
	}
}

