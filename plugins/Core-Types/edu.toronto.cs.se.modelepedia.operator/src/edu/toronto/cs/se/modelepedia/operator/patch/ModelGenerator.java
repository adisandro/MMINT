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
package edu.toronto.cs.se.modelepedia.operator.patch;

import java.util.Properties;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

//TODO MMINT[OPERATOR] Create a separate feature for these generic operators
public class ModelGenerator extends OperatorImpl {

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		/**
		 * TODO:
		 * 1) Make model match parametric on the attribute to match
		 * 2) When merging, add option to modify idAttribute of all the elements but the boundaries
		 * 3) Create ModelGenerator script (not a generic operator)
		 * 3a) do 2) just in the script maybe, together with the csv
		 */
		Model model = actualParameters.get(0);
		return null;
	}

}
