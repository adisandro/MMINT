/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.merge;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class ModelMerge extends OperatorExecutableImpl {

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		ModelRel matchRel = (ModelRel) actualParameters.get(actualParameters.size()-1);
		for (int i = 0; i < (actualParameters.size()-1); i++) {
			Model model = actualParameters.get(i);
		}

		EList<Model> result = new BasicEList<Model>();
		return result;
	}

}
