/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.powerwindow.operator;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.IOperator;
import edu.toronto.cs.se.modelepedia.petrinet.PetriNet;
import edu.toronto.cs.se.modelepedia.petrinet.PetrinetFactory;

public class PWControlRelToPetriNet implements IOperator {

	@Override
	public EObject[] invoke(EObject[] parameters) throws Exception {

		if (parameters.length != 1 || !(parameters[0] instanceof ModelRel)) {
			throw new MMTFException("Bad operator parameters");
		}

		PetriNet petriNet = PetrinetFactory.eINSTANCE.createPetriNet();
		//TODO MMTF: serialize and use the uri like if we import such model
		//Model petriNetModel = MultiModelFactoryUtils.createModel(origin, multiModel, modelUri);

		return new EObject[] {petriNet};
	}

}
