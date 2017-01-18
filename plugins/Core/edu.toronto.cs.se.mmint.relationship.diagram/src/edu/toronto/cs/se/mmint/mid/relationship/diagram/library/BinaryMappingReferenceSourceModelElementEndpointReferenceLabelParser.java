/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mid.relationship.BinaryMappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;

public class BinaryMappingReferenceSourceModelElementEndpointReferenceLabelParser extends ExtendibleElementEndpointReferenceLabelParser {

	protected IAdaptable getSourceModelElementEndpointReferenceAdaptable(IAdaptable element) {

		EObject modelObj = (EObject) element.getAdapter(EObject.class);
		ModelElementEndpointReference modelElemEndpointRef = ((BinaryMappingReference) modelObj).getObject().getModelElemEndpointRefs().get(0);

		return new ParserHintAdapter(modelElemEndpointRef, "");
	}

	@Override
	public String getEditString(IAdaptable element, int flags) {

		return super.getEditString(getSourceModelElementEndpointReferenceAdaptable(element), flags);
	}

	@Override
	public ICommand getParseCommand(IAdaptable element, final String newLabel, int flags) {

		return super.getParseCommand(getSourceModelElementEndpointReferenceAdaptable(element), newLabel, flags);
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		return super.getPrintString(getSourceModelElementEndpointReferenceAdaptable(element), flags);
	}

}
