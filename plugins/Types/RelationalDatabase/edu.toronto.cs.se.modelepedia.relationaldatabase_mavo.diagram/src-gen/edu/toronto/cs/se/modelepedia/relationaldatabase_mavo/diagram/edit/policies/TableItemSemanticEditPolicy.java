/*
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
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TableItemSemanticEditPolicy extends
		edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.policies.RelationalDatabase_MAVOBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public TableItemSemanticEditPolicy() {
		super(edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.providers.RelationalDatabase_MAVOElementTypes.Table_2001);
	}

	/**
	* @generated
	*/
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
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
			switch (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
					.getVisualID(node)) {
			case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableColumnsCompartmentEditPart.VISUAL_ID:
				for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
							.getVisualID(cnode)) {
					case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ColumnEditPart.VISUAL_ID:
						for (Iterator<?> it = cnode.getTargetEdges().iterator(); it.hasNext();) {
							Edge incomingLink = (Edge) it.next();
							if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
									.getVisualID(
											incomingLink) == edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(incomingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
								continue;
							}
							if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
									.getVisualID(
											incomingLink) == edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID) {
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
			case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableTableForeignKeysCompartmentEditPart.VISUAL_ID:
				for (Iterator<?> cit = node.getChildren().iterator(); cit.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
							.getVisualID(cnode)) {
					case edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignKeyEditPart.VISUAL_ID:
						for (Iterator<?> it = cnode.getSourceEdges().iterator(); it.hasNext();) {
							Edge outgoingLink = (Edge) it.next();
							if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
									.getVisualID(
											outgoingLink) == edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.TableColumnReferenceEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
								continue;
							}
							if (edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.part.RelationalDatabase_MAVOVisualIDRegistry
									.getVisualID(
											outgoingLink) == edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.ForeignColumnReferenceEditPart.VISUAL_ID) {
								DestroyElementRequest r = new DestroyElementRequest(outgoingLink.getElement(), false);
								cmd.add(new DestroyElementCommand(r));
								cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
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

}
