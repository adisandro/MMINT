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
package edu.toronto.cs.se.modelepedia.sequencediagram_mavo.operator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SequenceDiagram;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.SourceLifelineReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.TargetLifelineReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Lifeline;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Class;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.ClassReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Attribute;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.AttributeReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Operation;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.OperationReference;
import edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.Message;

import edu.toronto.cs.se.modelepedia.operator.slice.Slice;

public class SDSlice extends Slice {

	private static final java.lang.Class<Lifeline> LIFELINE = Lifeline.class;
	private static final java.lang.Class<Class> CLASS = Class.class;
	private static final java.lang.Class<Attribute> ATTRIBUTE = Attribute.class;
	private static final java.lang.Class<Operation> OPERATION = Operation.class;
	private static final java.lang.Class<Message> MESSAGE = Message.class;
	
	// Checks whether the two input model elements are equivalent. 
	@Override
	public boolean isModelElemEqual(EObject obj1, EObject obj2) {
		if (LIFELINE.isInstance(obj1) && LIFELINE.isInstance(obj2)) {
			// Lifelines are considered equivalent if they have the same name
			// and are connected to the same classes.
			Lifeline l1 = LIFELINE.cast(obj1);
			List<Class> cList1 = new ArrayList<Class>();
			for (ClassReference cRef : l1.getClass_()) {
				cList1.add(cRef.getTarget());
			}
			
			Lifeline l2 = LIFELINE.cast(obj2);
			List<Class> cList2 = new ArrayList<Class>();
			for (ClassReference cRef : l2.getClass_()) {
				cList2.add(cRef.getTarget());
			}
			
			return l1.getName().equals(l2.getName()) && 
					isElemListEqual(cList1, cList2);
			
		} else if (CLASS.isInstance(obj1) && CLASS.isInstance(obj2)) {
			// Classes are considered equivalent if they have the same name.
			Class c1 = CLASS.cast(obj1);
			Class c2 = CLASS.cast(obj2);
			
			return c1.getName().equals(c2.getName());
			
		} else if (ATTRIBUTE.isInstance(obj1) && ATTRIBUTE.isInstance(obj2)) {
			// Attributes are equivalent if they share the same names and 
			// are used in the same messages.
			Attribute a1 = ATTRIBUTE.cast(obj1);
			List<AttributeReference> mRef1 = a1.getMessages();

			Attribute a2 = ATTRIBUTE.cast(obj2);
			List<AttributeReference> mRef2 = a2.getMessages();
			
			return a1.getName().equals(a2.getName()) && 
					mRef1.containsAll(mRef2) &&
					mRef2.containsAll(mRef1); isModelElemEqual(c1, c2);
			
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
	
//	private static final String LIFELINE = 
//		"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.LifelineImpl";
//	public static final String CLASS = 
//		"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.ClassImpl";
//	private static final String ATTRIBUTE = 
//		"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.AttributeImpl";
//	private static final String OPERATION = 
//		"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.OperationImpl";
//	private static final String MESSAGE = 
//		"edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.impl.MessageImpl";
//
//	@Override
//	public List<EObject> getAllModelElements(Model in, EObject root) throws MMINTException{
//		SequenceDiagram root2 = (SequenceDiagram) root; 
//		List<EObject> unchecked = new ArrayList<EObject>();
//		List<Class> classes = root2.getClasses();
//		for (Class elem : classes) {
//			unchecked.add(elem);
//			unchecked.addAll(elem.getAttributes());
//			unchecked.addAll(elem.getOperations());
//		}
//		unchecked.addAll(root2.getLifelines());
//		unchecked.addAll(root2.getMessages());
//		
//		return unchecked;
//	}
//
//	// Iterate through the unchecked list of class diagram elements to
//	// identify all those which are included in the input criterion.
//	@Override
//	public List<EObject> matchCriterionToModelElements(List<EObject> unchecked, List<String> criterionList)
//	{
//		List<EObject> unprocessed = new ArrayList<EObject>();
//
//		Iterator<EObject> uncheckedIter = unchecked.iterator();
//		while (uncheckedIter.hasNext()) {
//			EObject elem = uncheckedIter.next();
//
//			switch (elem.getClass().getName()) {
//				case LIFELINE:
//					Lifeline l = (Lifeline) elem;
//	    				if (criterionList.contains(l.getName())) {
//						unprocessed.add(l);
//						System.out.println("Criterion Added: " + l.getName());
//						uncheckedIter.remove();
//					}
//					break;
//
//				case CLASS:
//					Class c = (Class) elem;
//	    				if (criterionList.contains(c.getName())) {
//						unprocessed.add(c);
//						System.out.println("Criterion Added: " + c.getName());
//						uncheckedIter.remove();
//					}
//					break;
//
//				case ATTRIBUTE:
//					Attribute a = (Attribute) elem;
//	    				if (criterionList.contains(a.getName())) {
//						unprocessed.add(a);
//						System.out.println("Criterion Added: " + a.getName());
//						uncheckedIter.remove();
//					}
//					break;	
//
//				case OPERATION:
//					Operation o = (Operation) elem;
//	    				if (criterionList.contains(o.getName())) {
//						unprocessed.add(o);
//						System.out.println("Criterion Added: " + o.getName());
//						uncheckedIter.remove();
//					}
//					break;	
//
//				case MESSAGE:
//					Message m = (Message) elem;
//	    				if (criterionList.contains(m.getName())) {
//						unprocessed.add(m);
//						System.out.println("Criterion Added: " + m.getName());
//						uncheckedIter.remove();
//					}
//					break;
//			}
//		}
//		return unprocessed;
//	}
//
//	@Override
//	public List<EObject> getImpactedElements(List<EObject> unprocessed, List<EObject> unchecked){
//		List<EObject> changed = new ArrayList<EObject>();
//		Iterator<EObject> unprocessedIter = unprocessed.iterator();
//		while (unprocessedIter.hasNext()) {
//			System.out.println("Elements to be processed: " + 
//				+ unprocessed.size());
//			EObject obj = unprocessedIter.next();
//
//			if (changed.contains(obj)){
//				// This element has already been checked for dependencies.
//				unprocessed.remove(obj);
//
//			} else {
//				unprocessed.remove(obj);
//				changed.add(obj);
//
//				switch (obj.getClass().getName()) {
//					case LIFELINE:
//						Lifeline refL = (Lifeline) obj;
//						System.out.println("Current element: Lifeline " 
//							+ refL.getName());
//
//						// Get all elements affected by the impacted lifeline.
//						// According to rule SD5, these elements are:
//						// - Arrows connected to the lifeline (not applicable)
//						// - Messages on arrows connected to the lifeline
//						List<SourceLifelineReference> srcRefList = 
//							refL.getMessagesAsSource();
//						List<TargetLifelineReference> tarRefList = 
//							refL.getMessagesAsTarget();
//
//						List<Message> msgListL = new ArrayList<Message>();
//						for (SourceLifelineReference srcRef : srcRefList) {
//							msgListL.add(srcRef.getSource());
//						}
//						for (TargetLifelineReference tarRef : tarRefList) {
//							msgListL.add(tarRef.getSource());
//						}
//
//						unprocessed.addAll(msgListL);
//						unchecked.removeAll(msgListL);
//
//						break;
//	
//					case CLASS:
//						// Get all elements affected by the impacted class.
//						// TODO Double-check what the rule is for classes.
//						Class refC = (Class) obj;
//						System.out.println("Current element: Class " + refC.getName());
//						break;
//
//					case ATTRIBUTE:
//						Attribute refAt = (Attribute) obj;
//						System.out.println("Current element: Attr " + refAt.getName());
//						
//						// Get all elements affected by the impacted lifeline.
//						// From rule SD1, if the component being assessed is a 
//						// "term" (taken to mean an attribute or operation), 
//						// then the associated "expression" is potentially impacted,
//						// which is not applicable in MMINT. However, according to
//						// rule SD2, if an expression is impacted, then the associated
//						// message will also be impacted.
//						List<AttributeReference> atRefList = refAt.getMessages();
//
//						List<Message> msgListA = new ArrayList<Message>();
//						for (AttributeReference atRef : atRefList) {
//							msgListA.add(atRef.getSource());
//						}
//
//						unprocessed.addAll(msgListA);
//						unchecked.removeAll(msgListA);
//						
//						break;	
//	
//					case OPERATION:
//						Operation refOp = (Operation) obj;
//						System.out.println("Current element: Op " + refOp.getName());
//						List<OperationReference> opRefList = refOp.getMessages();
//
//						List<Message> msgListO = new ArrayList<Message>();
//						for (OperationReference opRef : opRefList) {
//							msgListO.add(opRef.getSource());
//						}
//
//						unprocessed.addAll(msgListO);
//						unchecked.removeAll(msgListO);
//						
//						break;	
//						
//					case MESSAGE:
//						// Get all elements affected by the impacted message.
//						// According to rule SD3, the only affected element is
//						// the associated arrow, which is not applicable in MMINT.
//						// Note: Since arrows are not modelled explicitly in MMINT,
//						// rule SD4 is also not applicable.
//						Message refM = (Message) obj;
//						System.out.println("Current element: Message " + refM.getName());
//						break;
//				}
//			}
//
//			unprocessedIter = unprocessed.iterator();
//		}
//		return changed;
//	}
}
