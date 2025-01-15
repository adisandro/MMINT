/*
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;

public class MIDDiagramCustomLabelParser extends MIDDiagramLabelParser {

	@Override
	protected IStatus updateValues(ExtendibleElement midElement, String newLabel) {

		midElement.updateMIDCustomLabel(newLabel);

		return Status.OK_STATUS;
	}

	@Override
	public String getEditString(IAdaptable element, int flags) {

		ExtendibleElement midElement = (ExtendibleElement) element.getAdapter(EObject.class);

		return midElement.toMIDCustomEditLabel();
	}

	@Override
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {

		return ParserEditStatus.EDITABLE_STATUS;
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		ExtendibleElement midElement = (ExtendibleElement) element.getAdapter(EObject.class);

		return midElement.toMIDCustomPrintLabel();
	}

}
