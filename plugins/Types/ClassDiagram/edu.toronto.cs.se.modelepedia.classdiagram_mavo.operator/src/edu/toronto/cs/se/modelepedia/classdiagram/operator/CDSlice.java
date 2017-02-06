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
import edu.toronto.cs.se.modelepedia.classdiagram.Association;
import edu.toronto.cs.se.modelepedia.classdiagram.Attribute;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.Dependency;
import edu.toronto.cs.se.modelepedia.classdiagram.Operation;
import edu.toronto.cs.se.modelepedia.operator.slice.Slice;

public class CDSlice extends Slice {
	
	private static final String CLASS = 
			"edu.toronto.cs.se.modelepedia.classdiagram.impl.ClassImpl";
	private static final String ATTRIBUTE = 
			"edu.toronto.cs.se.modelepedia.classdiagram.impl.AttributeImpl";	
	private static final String OPERATION = 
			"edu.toronto.cs.se.modelepedia.classdiagram.impl.OperationImpl";	
	private static final String ASSOCIATION = 
			"edu.toronto.cs.se.modelepedia.classdiagram.impl.AssociationImpl";
	private static final String DEPENDENCY = 
			"edu.toronto.cs.se.modelepedia.classdiagram.impl.DependencyImpl";
	
	@Override
	public List<EObject> getAllModelElements(Model in, EObject root) throws MMINTException{
		ClassDiagram root2 = (ClassDiagram) root; 
		List<EObject> unchecked = new ArrayList<EObject>();
		List<edu.toronto.cs.se.modelepedia.classdiagram.Class> classes = root2.getClasses();
		for (edu.toronto.cs.se.modelepedia.classdiagram.Class elem : classes) {
			unchecked.add(elem);
			unchecked.addAll(elem.getOwnedAttributes());
			unchecked.addAll(elem.getOwnedOperations());
			unchecked.addAll(elem.getAssociationsAsSource());
			unchecked.addAll(elem.getDependenciesAsDepender());
		}
		return unchecked;
	}

	// Iterate through the unchecked list of class diagram elements to
	// identify all those which are included in the input criterion.
	@Override
	public List<EObject> matchCriterionToModelElements(List<EObject> unchecked, List<String> criterionList)
	{
		List<EObject> unprocessed = new ArrayList<EObject>();

		Iterator<EObject> uncheckedIter = unchecked.iterator();
		while (uncheckedIter.hasNext()) {
			EObject elem = uncheckedIter.next();

			switch (elem.getClass().getName()) {
			case CLASS:
				edu.toronto.cs.se.modelepedia.classdiagram.Class c = (edu.toronto.cs.se.modelepedia.classdiagram.Class) elem;
				if (criterionList.contains(c.getName())) {
					unprocessed.add(c);
					System.out.println("Criterion Added: " + c.getName());
					uncheckedIter.remove();
				}
				break;

			case ATTRIBUTE:
				Attribute at = (Attribute) elem;
				if (criterionList.contains(at.getName())) {
					unprocessed.add(at);
					System.out.println("Criterion Added: " + at.getName());
					uncheckedIter.remove();
				}
				break;	

			case OPERATION:
				Operation o = (Operation) elem;
				if (criterionList.contains(o.getName())) {
					unprocessed.add(o);
					System.out.println("Criterion Added: " + o.getName());
					uncheckedIter.remove();
				}
				break;	

			case ASSOCIATION:
				Association as = (Association) elem;
				if (criterionList.contains(as.getName())) {
					unprocessed.add(as);
					System.out.println("Criterion Added: " + as.getName());
					uncheckedIter.remove();
				}
				break;	

			case DEPENDENCY:
				Dependency d = (Dependency) elem;
				if (criterionList.contains(d.getName())) {
					unprocessed.add(d);
					System.out.println("Criterion Added: " + d.getName());
					uncheckedIter.remove();
				}
				break;	
			}
		}
		return unprocessed;
	}

	@Override
	public List<EObject> getImpactedElements(List<EObject> unprocessed, List<EObject> unchecked){
		List<EObject> changed = new ArrayList<EObject>();
		Iterator<EObject> unprocessedIter = unprocessed.iterator();
		while (unprocessedIter.hasNext()) {
			System.out.println("Elements to be processed: " + 
					+ unprocessed.size());
			EObject obj = unprocessedIter.next();

			if (changed.contains(obj)){
				// This element has already been checked for dependencies.
				unprocessed.remove(obj);

			} else {
				unprocessed.remove(obj);
				changed.add(obj);

				Iterator<EObject> uncheckedIter;
				switch (obj.getClass().getName()) {
				case CLASS:
					edu.toronto.cs.se.modelepedia.classdiagram.Class refC = (edu.toronto.cs.se.modelepedia.classdiagram.Class) obj;
					System.out.println("Current element: Class " + refC.getName());

					// Get all elements affected by the impacted class.
					uncheckedIter = unchecked.iterator();
					while (uncheckedIter.hasNext()) {
						EObject uncheckedObj = uncheckedIter.next();
						switch (uncheckedObj.getClass().getName()) {
						case CLASS:
							edu.toronto.cs.se.modelepedia.classdiagram.Class c = (edu.toronto.cs.se.modelepedia.classdiagram.Class) uncheckedObj;
							if (c.getNestedIn() == refC || 
									c.getSuperclass() == refC) {
								unprocessed.add(c);
								uncheckedIter.remove();
							}
							break;

						case ATTRIBUTE:
							Attribute at = (Attribute) uncheckedObj;
							if (at.getOwner() == refC || at.getType() == refC) {
								unprocessed.add(at);
								uncheckedIter.remove();
							}
							break;

						case OPERATION:
							Operation op = (Operation) uncheckedObj;
							if (op.getOwner() == refC || op.getType() == refC) {
								unprocessed.add(op);
								uncheckedIter.remove();
							}
							break;

						case ASSOCIATION:
							Association as = (Association) uncheckedObj;
							if (as.getSource() == refC) {
								unprocessed.add(as);
								uncheckedIter.remove();
							}
							break;

						case DEPENDENCY:
							Dependency dp = (Dependency) uncheckedObj;
							if (dp.getDepender() == refC) {
								unprocessed.add(dp);
								uncheckedIter.remove();
							}
							break;
						}
					}
					break;

				case ATTRIBUTE:
					Attribute refAt = (Attribute) obj;
					System.out.println("Current element: Attr " + refAt.getName());
					break;	

				case OPERATION:
					Operation refOp = (Operation) obj;
					System.out.println("Current element: Op " + refOp.getName());
					break;	

				case ASSOCIATION:
					Association refAs = (Association) obj;
					System.out.println("Current element: Asc " + refAs.getName());
					break;	

				case DEPENDENCY:
					Dependency refDp = (Dependency) obj;
					System.out.println("Current element: Dep " + refDp.getName());
					break;	
				}
			}

			unprocessedIter = unprocessed.iterator();
		}
		return changed;
	}

}
