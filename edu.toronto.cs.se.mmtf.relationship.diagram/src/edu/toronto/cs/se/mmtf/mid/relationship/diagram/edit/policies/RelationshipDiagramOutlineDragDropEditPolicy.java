/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
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

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelElementReferenceDropCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;

/**
 * The drag and drop edit policy for the Mapping diagram (i.e. a mapping
 * reference), for objects dragged from the outline view.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class RelationshipDiagramOutlineDragDropEditPolicy extends DiagramDragDropEditPolicy {

	private final static String METAMODEL_FRAGMENT_SEPARATOR = "#//";

	/**
	 * Gets the command to handle objects dropped into the Mapping diagram.
	 * 
	 * @param dropRequest
	 *            The drop request.
	 * @return The executable command.
	 */
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {

		ModelRelEditPart editPart = (ModelRelEditPart) getHost();
		ModelRel root = (ModelRel) ((View) editPart.getModel()).getElement();
		CompoundCommand command = new CompoundCommand("Add model element references");
		IElementType elementType = MidElementTypes.getElementType(ModelElementReferenceEditPart.VISUAL_ID);

		for (Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {
			Object nextObject = it.next();
			if (!(nextObject instanceof EObject)) {
				continue;
			}
			EObject droppedElement = (EObject) nextObject;
			URI uri = EcoreUtil.getURI(droppedElement);
			String modelUri, modelElemUri;
			if (MultiModelConstraintChecker.isInstancesLevel(root)) {
				modelUri = uri.toPlatformString(true);
				modelElemUri = uri.toString().substring(18); // strip "platform:/resource"
			}
			else {
				String[] pieces = uri.toString().split(METAMODEL_FRAGMENT_SEPARATOR);
				modelUri = pieces[0];
				modelElemUri = pieces[1];
			}

references:
			for (ModelReference modelRef : root.getModelRefs()) {
				if (modelUri.equals(((Model) modelRef.getObject()).getUri())) {
					for (ModelElementReference elementRef : modelRef.getElementRefs()) { // avoid duplicates
						if (MultiModelConstraintChecker.isInstancesLevel(root)) {
							if (((ModelElement) elementRef.getObject()).getUri().equals(modelElemUri)) {
								continue references;
							}
						}
						else {
							if (EcoreUtil.equals(((ModelElement) elementRef.getObject()).getPointer(), droppedElement)) {
								continue references;
							}
						}
					}
					EReference containment = (EReference) modelRef.eClass().getEStructuralFeature(RelationshipPackage.MODEL_REFERENCE__ELEMENT_REFS);
					CreateElementRequest createReq = new CreateElementRequest(editPart.getEditingDomain(), modelRef, elementType, containment);
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
