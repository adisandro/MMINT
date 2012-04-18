/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.ModelElementReferenceDropCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.providers.MIDElementTypes;

/**
 * The drag and drop edit policy for the Mapping diagram (i.e. a mapping
 * reference), for objects dragged from the outline view.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MappingDiagramOutlineDragDropEditPolicy extends DiagramDragDropEditPolicy {

	/**
	 * Gets the command to handle objects dropped into the Mapping diagram.
	 * 
	 * @param dropRequest
	 *            The drop request.
	 * @return The executable command.
	 */
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {

		MappingReferenceEditPart editPart = (MappingReferenceEditPart) getHost();
		MappingReference root = (MappingReference) ((View) editPart.getModel()).getElement();
		CompoundCommand command = new CompoundCommand("Add model element references");
		IElementType elementType = MIDElementTypes.getElementType(ModelElementReferenceEditPart.VISUAL_ID);

		for (Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {
			Object nextObject = it.next();
			if (!(nextObject instanceof EObject)) {
				continue;
			}
			EObject droppedElement = (EObject) nextObject;
			String modelUri = EcoreUtil.getURI(droppedElement).toPlatformString(true);

containers:
			for (ModelContainer container : root.getContainers()) {
				if (modelUri.equals(container.getModel().getUri())) {
					for (ModelElementReference element : container.getElements()) { // avoid duplicates
						if (element.getPointer() == droppedElement) {
							continue containers;
						}
					}
					EReference containment = (EReference) container.eClass().getEStructuralFeature(MappingPackage.MODEL_CONTAINER__ELEMENTS);
					CreateElementRequest createReq = new CreateElementRequest(editPart.getEditingDomain(), container, elementType, containment);
					command.add(
						new ICommandProxy( // convert GMF command to GEF command
							new ModelElementReferenceDropCommand(createReq, droppedElement)
						)
					);
				}
			}
		}

		return command;
	}

}
