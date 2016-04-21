/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.ModelElementReferenceDropCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.RelationshipDiagramOutlineDropObject;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;

/**
 * The drag and drop edit policy for the Mapping diagram (i.e. a mapping
 * reference), for objects dragged from the outline view.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramOutlineDragDropEditPolicy extends DiagramDragDropEditPolicy {

	/**
	 * Gets the command to handle objects dropped into the Mapping diagram.
	 * 
	 * @param dropRequest
	 *            The drop request.
	 * @return The executable command.
	 */
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {

		ModelRelEditPart modelRelEditPart = (ModelRelEditPart) getHost();
		CompoundCommand command = new CompoundCommand("Add model element references");
		IElementType elementType = MIDElementTypes.getElementType(ModelElementReferenceEditPart.VISUAL_ID);
		EReference containment = RelationshipPackage.Literals.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS;

		Iterator<?> it = dropRequest.getObjects().iterator();
		while (it.hasNext()) {
			RelationshipDiagramOutlineDropObject dropObj = (RelationshipDiagramOutlineDropObject) it.next();
			ModelEndpointReference modelEndpointRef = dropObj.getModelEndpointReference();
			CreateElementRequest createReq = new CreateElementRequest(modelRelEditPart.getEditingDomain(), modelEndpointRef, elementType, containment);
			command.add(
				new ICommandProxy( // convert GMF command to GEF command
					new ModelElementReferenceDropCommand(createReq, dropObj)
				)
			);
		}

		return command;
	}

}
