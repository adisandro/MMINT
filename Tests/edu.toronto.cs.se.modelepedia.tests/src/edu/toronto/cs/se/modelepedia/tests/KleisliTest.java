/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelEndpoint;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class KleisliTest {

	private final static String KLEISLI_MODELREL_URI = "http://se.cs.toronto.edu/modelepedia/KleisliModelRel";

	@Test
	public void test() throws Exception {

		//TODO MMTF[TESTS] MMTF has to run before this, with dynamic types from previous run discarded
		Model rootModelType = MultiModelTypeRegistry.getType(MMTF.ROOT_MODEL_URI);
		Model bankModelType = rootModelType.createSubtype("Bank", null, null, true);
		//TODO MMTF[TESTS] copy Bank.ecore metamodel from model folder
		Model libraryModelType = rootModelType.createSubtype("Library", null, null, true);
		//TODO MMTF[TESTS] copy Library.ecore metamodel from model folder
		ModelRel kRootModelRelType = MultiModelTypeRegistry.getType(KLEISLI_MODELREL_URI);
		ModelRel kModelRelType = kRootModelRelType.createSubtype("Bank-->Library", false, null, null);
		ModelEndpoint kRootModelTypeEndpoint = kRootModelRelType.getModelEndpoints().get(0);
		//TODO MMTF[TESTS] copy Bank-Bank.ecore metamodel from model folder
		kRootModelTypeEndpoint.createSubtypeAndReference(null, "Bank", bankModelType, false, kModelRelType);
		//TODO MMTF[TESTS] here we need MMTF.isInitialized() to return false
		kRootModelTypeEndpoint.createSubtypeAndReference(null, "Library", libraryModelType, false, kModelRelType);
		//TODO MMTF[TESTS] create model element types, ocl queries and link types
		MultiModel instanceMID = MidFactory.eINSTANCE.createMultiModel();
		//TODO MMTF[TESTS] should try to mimic things in gmf command or this is all?
		bankModelType.createInstanceAndEditor("test/bank.xmi", ModelOrigin.CREATED, instanceMID);
		//TODO MMTF[TESTS] create other instances
		fail("TODO");
	}

}
