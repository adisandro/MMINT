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
package edu.toronto.cs.se.modelepedia.operator.mid;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class Map extends OperatorImpl {

	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model mid = actualParameters.get(0);
		Operator operatorType = (Operator) getGenerics().get(0);
		/* TODO
		 * 1) Copy into an output mid first
		 * 2) Apply operatorType to the mid
		 * 2a) find all possible combinations of the input of operatorType 
		 *     (== matches, list of lists of actual parameters List<EList<Model>>)
		 *     use some heuristics to have groups of actual parameters, then invoke getExecutables() to check
		 * 2b) execute the operatorType on the matches and store the output mid
		 * 3) Make it recursive and add option for shallow/deep
		 * 4) Traceability: create Map<OperatorType>, but what about the individual applications of OperatorType?
		 * 5) Think about the alternative invocation, with a mid for every parameter of operatorType (no need to find matches?)
		 */

		return actualParameters;
	}

}
