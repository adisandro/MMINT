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
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.AssociationCreateCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.AssociationReorientCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.ClassNestedInCreateCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.ClassNestedInReorientCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.ClassSuperclassCreateCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.ClassSuperclassReorientCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.DependencyCreateCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.DependencyReorientCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AssociationEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.AttributeEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassClassOwnedAttributesCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassClassOwnedOperationsCompartmentEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassNestedInEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.ClassSuperclassEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.DependencyEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts.OperationEditPart;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramElementTypes;

/**
 * @generated
 */
public class ClassItemSemanticEditPolicy extends ClassDiagramBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public ClassItemSemanticEditPolicy() {
		super(ClassDiagramElementTypes.Class_2001);
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
			if (ClassDiagramVisualIDRegistry.getVisualID(incomingLink) == AssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ClassDiagramVisualIDRegistry.getVisualID(incomingLink) == DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ClassDiagramVisualIDRegistry.getVisualID(incomingLink) == ClassNestedInEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
					incomingLink.getSource().getElement(),
					null,
					incomingLink.getTarget().getElement(),
					false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (ClassDiagramVisualIDRegistry.getVisualID(incomingLink) == ClassSuperclassEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
					incomingLink.getSource().getElement(),
					null,
					incomingLink.getTarget().getElement(),
					false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (ClassDiagramVisualIDRegistry.getVisualID(outgoingLink) == AssociationEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ClassDiagramVisualIDRegistry.getVisualID(outgoingLink) == DependencyEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ClassDiagramVisualIDRegistry.getVisualID(outgoingLink) == ClassNestedInEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
					outgoingLink.getSource().getElement(),
					null,
					outgoingLink.getTarget().getElement(),
					false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (ClassDiagramVisualIDRegistry.getVisualID(outgoingLink) == ClassSuperclassEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
					outgoingLink.getSource().getElement(),
					null,
					outgoingLink.getTarget().getElement(),
					false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
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
		}
		else {
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
			switch (ClassDiagramVisualIDRegistry.getVisualID(node)) {
				case ClassClassOwnedAttributesCompartmentEditPart.VISUAL_ID:
					for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
						Node cnode = (Node) cit.next();
						switch (ClassDiagramVisualIDRegistry.getVisualID(cnode)) {
							case AttributeEditPart.VISUAL_ID:
								cmd.add(
									new DestroyElementCommand(
										new DestroyElementRequest(getEditingDomain(), cnode.getElement(), false))); // directlyOwned: true
								// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
								// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
								break;
						}
					}
					break;
				case ClassClassOwnedOperationsCompartmentEditPart.VISUAL_ID:
					for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
						Node cnode = (Node) cit.next();
						switch (ClassDiagramVisualIDRegistry.getVisualID(cnode)) {
							case OperationEditPart.VISUAL_ID:
								cmd.add(
									new DestroyElementCommand(
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
		if (ClassDiagramElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ClassDiagramElementTypes.Dependency_4002 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ClassDiagramElementTypes.ClassNestedIn_4003 == req.getElementType()) {
			return getGEFWrapper(new ClassNestedInCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ClassDiagramElementTypes.ClassSuperclass_4004 == req.getElementType()) {
			return getGEFWrapper(new ClassSuperclassCreateCommand(req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (ClassDiagramElementTypes.Association_4001 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ClassDiagramElementTypes.Dependency_4002 == req.getElementType()) {
			return getGEFWrapper(new DependencyCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ClassDiagramElementTypes.ClassNestedIn_4003 == req.getElementType()) {
			return getGEFWrapper(new ClassNestedInCreateCommand(req, req.getSource(), req.getTarget()));
		}
		if (ClassDiagramElementTypes.ClassSuperclass_4004 == req.getElementType()) {
			return getGEFWrapper(new ClassSuperclassCreateCommand(req, req.getSource(), req.getTarget()));
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
			case AssociationEditPart.VISUAL_ID:
				return getGEFWrapper(new AssociationReorientCommand(req));
			case DependencyEditPart.VISUAL_ID:
				return getGEFWrapper(new DependencyReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
			case ClassNestedInEditPart.VISUAL_ID:
				return getGEFWrapper(new ClassNestedInReorientCommand(req));
			case ClassSuperclassEditPart.VISUAL_ID:
				return getGEFWrapper(new ClassSuperclassReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
