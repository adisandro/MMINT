/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.core.runtime.Platform;
import org.junit.Test;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.modelepedia.z3.reasoning.Z3ReasoningEngine;

public class Z3Test {

	@Test
	public void test() throws Exception {

		/**
		 * TODO:
		 * 1) Refactor common code in a better way
		 * 2) Come up with interesting mavo input model(s)
		 * 3) Prepare all material for the brainstorm day (test model, test model encoding, benchmark procedure)
		 * 4) Consider an intermediate test with the encoding and a property as input
		 */
		Bundle testBundle = Platform.getBundle(TestUtils.TESTS_BUNDLE_NAME);
		MultiModel instanceMID = TestUtils.createInstanceMID();
		Model model = TestUtils.addInputModel(instanceMID, testBundle, "model/z3", "mavo.something");
		Z3ReasoningEngine z3Reasoner = (Z3ReasoningEngine) MAVOMultiModelConstraintChecker.getMAVOReasoner("SMTLIB");
		int numSolutions = z3Reasoner.allSAT(model);
		assertEquals(3, numSolutions);
	}

}
