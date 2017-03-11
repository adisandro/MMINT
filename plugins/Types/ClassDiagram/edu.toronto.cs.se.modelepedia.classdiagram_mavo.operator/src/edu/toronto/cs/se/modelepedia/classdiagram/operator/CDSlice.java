

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
package edu.toronto.cs.se.modelepedia.classdiagram.operator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.modelepedia.classdiagram.Class;
import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
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
	
	// Checks whether the two input model elements are equivalent. 
	@Override
	public boolean isModelElemEqual(EObject obj1, EObject obj2) {
		if (CLASS.isInstance(obj1) && CLASS.isInstance(obj2)) {
			// Classes are considered equivalent if they have the same name.
			Class c1 = CLASS.cast(obj1);
			Class c2 = CLASS.cast(obj2);
			
			return c1.getName().equals(c2.getName());
			
		} else if (ATTRIBUTE.isInstance(obj1) && ATTRIBUTE.isInstance(obj2)) {
			// Attributes are equivalent if they share the same names and their 
			// owner classes are also equivalent.
			Attribute a1 = ATTRIBUTE.cast(obj1);
			Class c1 = a1.getOwner();

			Attribute a2 = ATTRIBUTE.cast(obj2);
			Class c2 = a2.getOwner();
			
			return a1.getName().equals(a2.getName()) && isModelElemEqual(c1, c2);
			
		} else if (OPERATION.isInstance(obj1) && OPERATION.isInstance(obj2)) {
			// Operations are equivalent if they share the same names and their 
			// owner classes are also equivalent.
			Operation o1 = OPERATION.cast(obj1);
			Class c1 = o1.getOwner();
			
			Operation o2 = OPERATION.cast(obj2);
			Class c2 = o2.getOwner();
			
			return o1.getName().equals(o2.getName()) && isModelElemEqual(c1, c2);

		} else if (ASSOCIATION.isInstance(obj1) && ASSOCIATION.isInstance(obj2)) {
			// Associations are equivalent if they share the same names and their 
			// source classes and their target classes are equivalent.
			Association a1 = ASSOCIATION.cast(obj1);
			Class s1 = a1.getSource();
			Class t1 = a1.getTarget();
						
			Association a2 = ASSOCIATION.cast(obj2);
			Class s2 = a2.getSource();
			Class t2 = a2.getTarget();
			
			return a1.getName().equals(a2.getName()) && 
					isModelElemEqual(s1, s2) &&
					isModelElemEqual(t1, t2);
			
		} else if (DEPENDENCY.isInstance(obj1) && DEPENDENCY.isInstance(obj2)) {
			// Dependencies are equivalent if they have the same names and their
			// depender and dependee classes are equivalent.
			Dependency d1 = DEPENDENCY.cast(obj1);
			Class s1 = d1.getDepender();
			Class t1 = d1.getDependee();
						
			Dependency d2 = DEPENDENCY.cast(obj2);
			Class s2 = d2.getDepender();
			Class t2 = d2.getDependee();
			
			return d1.getName().equals(d2.getName()) && 
					isModelElemEqual(s1, s2) &&
					isModelElemEqual(t1, t2);		
			
		} else {
			return false;
		}
	}
	
	// Checks whether the first input model element is potentially
	// impacted by the second second input model element.
	@Override
	public boolean isModelElemImpactedBy(EObject obj1, EObject obj2) {
		boolean impactFlag = false;
		
		if (CLASS.isInstance(obj2)) {
			Class obj2Class = CLASS.cast(obj2);
			
			// If obj2 is a class, obj1 is potentially impacted by obj2 if:
			// 1) obj1 is equivalent to obj2 or one of its nested or sub-classes.
			for (Class c : getDescendants(obj2Class)) {
				impactFlag = impactFlag || isModelElemEqual(c, obj1);
			}
			
			// 2) obj1 is equivalent to an attribute or operation owned by obj2.
			for (Attribute a : obj2Class.getOwnedAttributes()) {
				impactFlag = impactFlag || isModelElemEqual(a, obj1);
			}
			
			for (Operation o : obj2Class.getOwnedOperations()) {
				impactFlag = impactFlag || isModelElemEqual(o, obj1);
			}
			
			// 3) If obj1 is an attribute/operation, its type is equivalent to obj2.
			if (ATTRIBUTE.isInstance(obj1)) {
				impactFlag = impactFlag || 
						isModelElemEqual(ATTRIBUTE.cast(obj1).getType(), obj2);
			}
			
			if (OPERATION.isInstance(obj1)) {
				impactFlag = impactFlag || 
						isModelElemEqual(OPERATION.cast(obj1).getType(), obj2);
			}
			
			// 4) If obj1 is an association, its source is equivalent to obj2.
			if (ASSOCIATION.isInstance(obj1)) {
				impactFlag = impactFlag || 
						isModelElemEqual(ASSOCIATION.cast(obj1).getSource(), obj2);
			}
			
			// 5) If obj1 is a dependency, its depender is equivalent to obj2.
			if (DEPENDENCY.isInstance(obj1)) {
				impactFlag = impactFlag || 
						isModelElemEqual(DEPENDENCY.cast(obj1).getDepender(), obj2);
			}
			
		} else if (ATTRIBUTE.isInstance(obj2)) {
			// If obj2 is an attribute, obj1 is potentially impacted by obj2 if
			// obj1 is equivalent to obj2.
			impactFlag = impactFlag || isModelElemEqual(obj1, obj2);
			
		} else if (OPERATION.isInstance(obj2)) {
			// If obj2 is an attribute, obj1 is potentially impacted by obj2 if
			// obj1 is equivalent to obj2.
			impactFlag = impactFlag || isModelElemEqual(obj1, obj2);

			
		} else if (ASSOCIATION.isInstance(obj2)) {
			// If obj2 is an attribute, obj1 is potentially impacted by obj2 if
			// obj1 is equivalent to obj2.
			impactFlag = impactFlag || isModelElemEqual(obj1, obj2);

			
		} else if (DEPENDENCY.isInstance(obj2)) {
			// If obj2 is an attribute, obj1 is potentially impacted by obj2 if
			// obj1 is equivalent to obj2.
			impactFlag = impactFlag || isModelElemEqual(obj1, obj2);
			
		}
		
		return impactFlag;
	}
	
	// Extracts the descendant classes (i.e. sub-classes and nested classes) 
	// of the input class, including itself.
	// Note: It is not assumed that the classes follow a strict hierarchy.
	public List<Class> getDescendants(Class c) {
		List<Class> uncheckedList = new ArrayList<Class>();
		List<Class> checkedList = new ArrayList<Class>();
		
		uncheckedList.add(c);
		Iterator<Class> iter = uncheckedList.iterator();
		while (iter.hasNext()) {
			Class curC = iter.next();
			iter.remove();
			
			if (checkedList.contains(curC)) {
				continue;
				
			} else {
				checkedList.add(curC);
				
				if (!curC.getSubclasses().isEmpty()) {
					uncheckedList.addAll(curC.getSubclasses());
					iter = uncheckedList.iterator();
				}
				
				if (!curC.getNested().isEmpty()) {
					uncheckedList.addAll(curC.getNested());
					iter = uncheckedList.iterator();
				}
			}
		}
		
		return checkedList;
	}

}

