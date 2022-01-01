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
package edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ClassItemSemanticEditPolicy extends
		edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.policies.ICSE15_SequenceDiagram_MAVOBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ClassItemSemanticEditPolicy() {
		super(edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.Class_2002);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getVisualID(
							incomingLink) == edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	* @generated
	*/
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
					.getVisualID(node)) {
			case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassClassOperationsCompartmentEditPart.VISUAL_ID:
				for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
							.getVisualID(cnode)) {
					case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationEditPart.VISUAL_ID:
						for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge) it.next();
							if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.part.ICSE15_SequenceDiagram_MAVOVisualIDRegistry
									.getVisualID(
											incomingLink) == edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.OperationReferenceEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
						}
						cmd.add(new DestroyElementCommand(
								new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.ClassReference_4001 == req
				.getElementType()) {
			return null;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.providers.ICSE15_SequenceDiagram_MAVOElementTypes.ClassReference_4001 == req
				.getElementType()) {
			return getGEFWrapper(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.commands.ClassReferenceCreateCommand(
							req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.parts.ClassReferenceEditPart.VISUAL_ID:
			return getGEFWrapper(
					new edu.toronto.cs.se.modelepedia.icse15_sequencediagram_mavo.diagram.edit.commands.ClassReferenceReorientCommand(
							req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
