/**
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
package edu.toronto.cs.se.mmint.mid.diagram.library;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;

import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;

public class BinaryModelRelTargetModelEndpointLabelParser extends ExtendibleElementEndpointLabelParser {

	protected IAdaptable getTargetModelEndpointAdaptable(IAdaptable element) {

		BinaryModelRel modelRel = (BinaryModelRel) element.getAdapter(EObject.class);
		ModelEndpoint modelEndpoint = modelRel.getModelEndpointRefs().get(1).getObject();

		return new ParserHintAdapter(modelEndpoint, "");
	}

	@Override
	public String getEditString(IAdaptable element, int flags) {

		return super.getEditString(getTargetModelEndpointAdaptable(element), flags);
	}

	@Override
	public ICommand getParseCommand(IAdaptable element, final String newLabel, int flags) {

		return super.getParseCommand(getTargetModelEndpointAdaptable(element), newLabel, flags);
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		return super.getPrintString(getTargetModelEndpointAdaptable(element), flags);
	}

}
