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
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.policies.ClassClassOwnedOperationsCompartmentCanonicalEditPolicy;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.policies.ClassClassOwnedOperationsCompartmentItemSemanticEditPolicy;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.ClassDiagramVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.part.Messages;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramElementTypes;

/**
 * @generated
 */
public class ClassClassOwnedOperationsCompartmentEditPart extends ListCompartmentEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 7002;

	/**
	* @generated
	*/
	public ClassClassOwnedOperationsCompartmentEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected boolean hasModelChildrenChanged(Notification evt) {
		return false;
	}

	/**
	* @generated
	*/
	public String getCompartmentName() {
		return Messages.ClassClassOwnedOperationsCompartmentEditPart_title;
	}

	/**
	* @generated
	*/
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableCompartmentEditPolicy());
		installEditPolicy(
			EditPolicyRoles.SEMANTIC_ROLE,
			new ClassClassOwnedOperationsCompartmentItemSemanticEditPolicy());
		installEditPolicy(
			EditPolicyRoles.CREATION_ROLE,
			new CreationEditPolicyWithCustomReparent(ClassDiagramVisualIDRegistry.TYPED_INSTANCE));
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(
			EditPolicyRoles.CANONICAL_ROLE,
			new ClassClassOwnedOperationsCompartmentCanonicalEditPolicy());
	}

	/**
	* @generated
	*/
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

	/**
	* @generated
	*/
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
				.getViewAndElementDescriptor()
				.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == ClassDiagramElementTypes.Operation_3002) {
				return this;
			}
			return getParent().getTargetEditPart(request);
		}
		if (request instanceof CreateUnspecifiedTypeConnectionRequest) {
			return getParent().getTargetEditPart(request);
		}
		return super.getTargetEditPart(request);
	}

}
