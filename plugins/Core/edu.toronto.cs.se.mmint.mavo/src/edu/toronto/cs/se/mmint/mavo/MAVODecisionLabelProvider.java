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
 */
package edu.toronto.cs.se.mmint.mavo;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOModel;

public class MAVODecisionLabelProvider extends AdapterFactoryLabelProvider {

	public MAVODecisionLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}
	
	@Override
	public String getText(Object object){
		String label;
		if (object instanceof MAVOModel){
			MAVOModel model = (MAVOModel) object;
			label = model.eResource().getURI().toString();
		}
		else if (object instanceof LogicElement){
			LogicElement element = (LogicElement) object;
			label = element.getFormulaVariable();
		}
		else {
			label = super.getText(object);
		}
		
		return label;
	}

}
