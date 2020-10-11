/*
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.library;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;

public class MAVOElementReferenceLabelParser extends MAVOElementLabelParser {

	protected IAdaptable getMAVOElementAdaptable(IAdaptable element) {

		EObject modelObj = (EObject) element.getAdapter(EObject.class);
		MAVOElement mavoElement = (MAVOElement) ((ExtendibleElementReference) modelObj).getObject();

		return new ParserHintAdapter(mavoElement, "");
	}

	@Override
	public String getEditString(IAdaptable element, int flags) {

		return super.getEditString(getMAVOElementAdaptable(element), flags);
	}

	@Override
	public ICommand getParseCommand(IAdaptable element, final String newLabel, int flags) {

		return super.getParseCommand(getMAVOElementAdaptable(element), newLabel, flags);
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		return super.getPrintString(getMAVOElementAdaptable(element), flags);
	}

}
