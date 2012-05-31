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
package edu.toronto.cs.se.mmtf.mid.diagram.menu;

import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;

public class RunOperatorListener extends SelectionAdapter {

	Operator operator;
	EList<Model> actualParameters;

	public RunOperatorListener(Operator operator, EList<Model> actualParameters) {

		this.operator = operator;
		this.actualParameters = actualParameters;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		//operator.getExecutable().execute(actualParameters);
		//TODO MMTF: refresh diagram
	}

}
