/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Implementation.
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import edu.toronto.cs.se.mavo.DecisionElement;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;

public class MAVODecisionLabelProvider extends AdapterFactoryLabelProvider {

	public MAVODecisionLabelProvider(AdapterFactory adapterFactory) {

		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {

		String label;
		if (object instanceof MAVOModel) {
			MAVOModel rootModelObj = (MAVOModel) object;
			label = rootModelObj.eResource().getURI().toString();
		}
		else if (object instanceof DecisionElement) {
			DecisionElement decisionObj = (DecisionElement) object;
			label = decisionObj.getFormulaVariable();
			if (decisionObj.getDescription() != null) {
				label += " (" + decisionObj.getDescription() + ")";
			}
		}
		else if (object instanceof MAVOElement) {
			MAVOElement modelObj = (MAVOElement) object;
			label = modelObj.getFormulaVariable();
		}
		else {
			label = super.getText(object);
		}

		return label;
	}

}
