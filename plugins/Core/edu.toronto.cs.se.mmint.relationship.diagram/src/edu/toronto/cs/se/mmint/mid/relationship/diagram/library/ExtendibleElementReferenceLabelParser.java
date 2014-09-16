/*
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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.library;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;

import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.ExtendibleElementLabelParser;
import edu.toronto.cs.se.mmint.mid.relationship.ExtendibleElementReference;

public class ExtendibleElementReferenceLabelParser extends ExtendibleElementLabelParser {

	protected IAdaptable getExtendibleElementAdaptable(IAdaptable element) {

		EObject modelObj = (EObject) element.getAdapter(EObject.class);
		ExtendibleElement referencedElement = ((ExtendibleElementReference) modelObj).getObject();

		return new ParserHintAdapter(referencedElement, "");
	}

	@Override
	public String getEditString(IAdaptable element, int flags) {

		return super.getEditString(getExtendibleElementAdaptable(element), flags);
	}

	@Override
	public ICommand getParseCommand(IAdaptable element, final String newLabel, int flags) {

		return super.getParseCommand(getExtendibleElementAdaptable(element), newLabel, flags);
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		return super.getPrintString(getExtendibleElementAdaptable(element), flags);
	}

}
