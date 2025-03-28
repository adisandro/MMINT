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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.commands.MIDCreateShortcutDecorationsCommand;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.ModelRelCanonicalEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.ModelRelItemSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.RelationshipDiagramCanonicalEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.RelationshipDiagramOutlineDragDropEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.RelationshipDiagramSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDVisualIDRegistry;

/**
 * @generated
 */
public class ModelRelEditPart extends DiagramEditPart {

	/**
	* @generated
	*/
	public final static String MODEL_ID = "Relationship"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 1000;

	/**
	* @generated
	*/
	public ModelRelEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE,
				new ModelRelItemSemanticEditPolicy());
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE,
				new ModelRelCanonicalEditPolicy());
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(MIDVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.DRAG_DROP_ROLE,
				new DiagramDragDropEditPolicy() {
					public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
						ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
						for (Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {
							Object nextObject = it.next();
							if (false == nextObject instanceof EObject) {
								continue;
							}
							viewDescriptors
									.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter((EObject) nextObject),
											Node.class, null, getDiagramPreferencesHint()));
						}
						return createShortcutsCommand(dropRequest, viewDescriptors);
					}

					private Command createShortcutsCommand(DropObjectsRequest dropRequest,
							List<CreateViewRequest.ViewDescriptor> viewDescriptors) {
						Command command = createViewsAndArrangeCommand(dropRequest, viewDescriptors);
						if (command != null) {
							return command
									.chain(new ICommandProxy(new MIDCreateShortcutDecorationsCommand(getEditingDomain(),
											(View) getModel(), viewDescriptors)));
						}
						return null;
					}
				});
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new RelationshipDiagramOutlineDragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new RelationshipDiagramCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new RelationshipDiagramSemanticEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

}
