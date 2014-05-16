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
package edu.toronto.cs.se.modelepedia.graph_mavo.operator;

import java.util.Properties;

import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class TOSEM12 extends OperatorImpl {

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model randomGraphModel = actualParameters.get(0);

		return null;
	}

}
