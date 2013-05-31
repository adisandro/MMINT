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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.commands.ModelElementReferenceDropCommand;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelRelEditPart;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

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
		ModelRel modelRel = (ModelRel) ((View) modelRelEditPart.getModel()).getElement();
		MultiModel multiModel = MultiModelRegistry.getMultiModel(modelRel);
		boolean isInstancesLevel = MultiModelConstraintChecker.isInstancesLevel(modelRel);
		CompoundCommand command = new CompoundCommand("Add model element references");
		IElementType elementType = MidElementTypes.getElementType(ModelElementReferenceEditPart.VISUAL_ID);

		for (Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {
			Object nextObject = it.next();
			if (!(nextObject instanceof EObject) || nextObject instanceof DynamicEObjectImpl) {
				continue;
			}
			EObject droppedEObject = (EObject) nextObject;
			String[] uris = MultiModelRegistry.getModelAndModelElementUris(droppedEObject, isInstancesLevel);
			String modelUri = uris[0], modelElemUri = uris[1];

modelEndpointRef:
			for (ModelEndpointReference modelEndpointRef : modelRel.getModelEndpointRefs()) {
				if (
					modelUri.equals(modelEndpointRef.getTargetUri()) || (
						!isInstancesLevel &&
						MultiModelTypeHierarchy.isSubtypeOf(multiModel, modelEndpointRef.getTargetUri(), modelUri) // for light types
					)
				) {
					for (ModelElementReference elementRef : modelEndpointRef.getModelElemRefs()) { // avoid duplicates
						if (isInstancesLevel) {
							if (elementRef.getUri().equals(modelElemUri)) {
								continue modelEndpointRef;
							}
						}
						else {
							//TODO MMTF: why? check this, looks wrong
							if (EcoreUtil.equals(MultiModelTypeIntrospection.getPointer(elementRef.getObject()), droppedEObject)) {
								continue modelEndpointRef;
							}
						}
					}
					EReference containment = (EReference) modelEndpointRef.eClass().getEStructuralFeature(RelationshipPackage.MODEL_ENDPOINT_REFERENCE__MODEL_ELEM_REFS);
					CreateElementRequest createReq = new CreateElementRequest(modelRelEditPart.getEditingDomain(), modelEndpointRef, elementType, containment);
					command.add(
						new ICommandProxy( // convert GMF command to GEF command
							new ModelElementReferenceDropCommand(createReq, modelUri, modelElemUri, droppedEObject)
						)
					);
				}
			}
		}

		return command;
	}

}
