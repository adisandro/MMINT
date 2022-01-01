/*
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINTActivator;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;

public class ExtendibleElementLabelParser extends MIDDiagramLabelParser {

	private final static String EXTELEM_NULLTYPE = "NOTYPE";

	//TODO MMINT[USABILITY] Use toString() for everything and get rid of this function?
	protected String getElementLabel(ExtendibleElement element) {

		if (element instanceof Operator) {
			return element.toString();
		}
		String label = (element.getName() == null) ? "" : element.getName();
		if (!element.isTypesLevel()) {
			ExtendibleElement type = element.getMetatype();
			String typeLabel = (type == null) ? EXTELEM_NULLTYPE : type.getName();
			label += " : " + typeLabel;
		}

		return label;
	}

	protected String editElementLabel(ExtendibleElement element) {

		String name = element.getName();
		if (name == null) {
			name = "";
		}
	
		return name;
	}

	protected String getEndpointLabel(ExtendibleElementEndpoint endpoint) {
	
		String label = this.getElementLabel(endpoint);
	
		int low = endpoint.getLowerBound();
		int up = endpoint.getUpperBound();
		if (low == 0 && up == 1) {
			label += " [?]";
		}
		else if (low == 1 && up == 1) {
			// default
		}
		else if (low == 0 && up == -1) {
			label += " [*]";
		}
		else if (low == 1 && up == -1) {
			label += " [+]";
		}
		else {
			String up2 = (up == -1) ? "*" : Integer.toString(up);
			label += " [" + low + "," + up2 + "]";
		}
	
		return label;
	}

	@Override
	protected IStatus updateValues(ExtendibleElement midElement, String newLabel) {

		if (midElement.isWorkflowsLevel()) {
			try {
				midElement.updateWorkflowInstanceId(newLabel);
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.ERROR, "Error updating the label", e);
				return new Status(IStatus.ERROR, MMINTActivator.PLUGIN_ID, "Error updating the label");
			}
		}
		midElement.setName(newLabel);

		return Status.OK_STATUS;
	}

	@Override
	public String getEditString(IAdaptable element, int flags) {

		ExtendibleElement midElement = (ExtendibleElement) element.getAdapter(EObject.class);

		return this.editElementLabel(midElement);
	}

	@Override
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {

		return ParserEditStatus.EDITABLE_STATUS;
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {

		ExtendibleElement midElement = (ExtendibleElement) element.getAdapter(EObject.class);

		return this.getElementLabel(midElement);
	}

}
