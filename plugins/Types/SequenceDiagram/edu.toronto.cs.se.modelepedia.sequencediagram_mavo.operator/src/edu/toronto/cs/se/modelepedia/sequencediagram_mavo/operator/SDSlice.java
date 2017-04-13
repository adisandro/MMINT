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
package edu.toronto.cs.se.modelepedia.sequencediagram_mavo.operator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

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
			List<Message> mList1 = new ArrayList<Message>();
			for (AttributeReference aRef : a1.getMessages()) {
				mList1.add(aRef.getSource());
			}
			
			Attribute a2 = ATTRIBUTE.cast(obj2);
			List<Message> mList2 = new ArrayList<Message>();
			for (AttributeReference aRef : a2.getMessages()) {
				mList2.add(aRef.getSource());
			}
			
			return a1.getName().equals(a2.getName()) && 
					isElemListEqual(mList1, mList2);
			
		} else if (OPERATION.isInstance(obj1) && OPERATION.isInstance(obj2)) {
			// Operations are equivalent if they share the same names and 
			// are used in the same messages.
			Operation o1 = OPERATION.cast(obj1);
			List<Message> mList1 = new ArrayList<Message>();
			for (OperationReference oRef : o1.getMessages()) {
				mList1.add(oRef.getSource());
			}
			
			Operation o2 = OPERATION.cast(obj2);
			List<Message> mList2 = new ArrayList<Message>();
			for (OperationReference oRef : o2.getMessages()) {
				mList2.add(oRef.getSource());
			}
			
			return o1.getName().equals(o2.getName()) && 
					isElemListEqual(mList1, mList2);

		} else if (MESSAGE.isInstance(obj1) && MESSAGE.isInstance(obj2)) {
			// Messages are considered equivalent if they have the same name.
			Message m1 = MESSAGE.cast(obj1);
			Message m2 = MESSAGE.cast(obj2);
			
			return m1.getName().equals(m2.getName());
			
		} else {
			return false;
		}
	}
	
	// Checks whether the first input model element is potentially
	// impacted by the second second input model element.
	// Note: It is assumed that if the two input elements are equivalent,
	// then the function should return true.
	@Override
	public boolean isModelElemImpactedBy(EObject obj1, EObject obj2) {
		boolean impactFlag = isModelElemEqual(obj1, obj2);
		
		if (LIFELINE.isInstance(obj2)) {
			// If obj2 is a lifeline, then obj1 is potentially impacted if it 
			// is a message connected to obj2.
			Lifeline l = LIFELINE.cast(obj2);			
			for (SourceLifelineReference srcRef : l.getMessagesAsSource()) {
				impactFlag = impactFlag || 
						isModelElemEqual(obj1, srcRef.getSource());
			}
			
			for (TargetLifelineReference tarRef : l.getMessagesAsTarget()) {
				impactFlag = impactFlag || 
						isModelElemEqual(obj1, tarRef.getSource());
			}
			
		} else if (CLASS.isInstance(obj2)) {
			// It is assumed that if obj2 is a class, then obj1 is potentially 
			// impacted only if it is equivalent to obj2.
			
		} else if (ATTRIBUTE.isInstance(obj2)) {
			// If obj2 is an attribute, then obj1 is potentially impacted if 
			// obj1 is a message that refers to obj2.
			Attribute a = ATTRIBUTE.cast(obj2);
			for (AttributeReference aRef : a.getMessages()) {
				impactFlag = impactFlag ||
						isModelElemEqual(obj1, aRef.getSource());
			}
			
		} else if (OPERATION.isInstance(obj2)) {
			// If obj2 is an operation, then obj1 is potentially impacted if 
			// obj1 is a message that refers to obj2.
			Operation o = OPERATION.cast(obj2);
			for (OperationReference oRef : o.getMessages()) {
				impactFlag = impactFlag ||
						isModelElemEqual(obj1, oRef.getSource());
			}
			
		} else if (MESSAGE.isInstance(obj2)) {
			// If obj2 is a message, then obj1 is potentially impacted 
			// only if it is equivalent to obj2.
		}
		
		return impactFlag;
	}
}
