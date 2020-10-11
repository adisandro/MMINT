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
package edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;
import org.eclipse.swt.graphics.Color;

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.ModelEndpointReferenceComponentEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.ModelEndpointReferenceItemSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.ModelEndpointReferenceSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.providers.MIDElementTypes;

/**
 * @generated
 */
public class ModelEndpointReferenceEditPart extends ShapeNodeEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 2001;

	/**
	* @generated
	*/
	protected IFigure contentPane;

	/**
	* @generated
	*/
	protected IFigure primaryShape;

	/**
	* @generated
	*/
	public ModelEndpointReferenceEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicyWithCustomReparent(MIDVisualIDRegistry.TYPED_INSTANCE));
		super.createDefaultEditPolicies();
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE,
				new ModelEndpointReferenceItemSemanticEditPolicy());
		installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ModelEndpointReferenceComponentEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ModelEndpointReferenceSemanticEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	* @generated
	*/
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected org.eclipse.gef.EditPolicy createChildEditPolicy(EditPart child) {
				org.eclipse.gef.EditPolicy result = child.getEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	* @generated
	*/
	protected IFigure createNodeShape() {
		return primaryShape = new ModelEndpointReferenceFigure();
	}

	/**
	* @generated
	*/
	public ModelEndpointReferenceFigure getPrimaryShape() {
		return (ModelEndpointReferenceFigure) primaryShape;
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabelEditPart) {
			((WrappingLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureModelEndpointReferenceLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel2EditPart) {
			((WrappingLabel2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureCustomModelEndpointReferenceLabelFigure());
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabelEditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel2EditPart) {
			return true;
		}
		return false;
	}

	/**
	* @generated
	*/
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	* @generated
	*/
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	* @generated
	*/
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		return getContentPane();
	}

	/**
	* @generated
	*/
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
		return result;
	}

	/**
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	* @generated
	*/
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	* Default implementation treats passed figure as content pane.
	* Respects layout one may have set for generated figure.
	* @param nodeShape instance of generated figure class
	* @generated
	*/
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	* @generated
	*/
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	* @generated
	*/
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	* @generated
	*/
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	* @generated
	*/
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	* @generated
	*/
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(MIDVisualIDRegistry.getType(WrappingLabelEditPart.VISUAL_ID));
	}

	/**
	* @generated
	*/
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request).getViewAndElementDescriptor()
					.getCreateElementRequestAdapter();
			IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
			if (type == MIDElementTypes.ModelElementReference_3001) {
				return getChildBySemanticHint(MIDVisualIDRegistry
						.getType(ModelEndpointReferenceModelEndpointReferenceCompartmentEditPart.VISUAL_ID));
			}
		}
		return super.getTargetEditPart(request);
	}

	/**
	* @generated
	*/
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() == getModel()
				&& EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}

	/**
	 * @generated
	 */
	public class ModelEndpointReferenceFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureModelEndpointReferenceLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureCustomModelEndpointReferenceLabelFigure;

		/**
		 * @generated
		 */
		public ModelEndpointReferenceFigure() {
			this.setLineWidth(3);
			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(300), getMapMode().DPtoLP(400)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(7), getMapMode().DPtoLP(7), getMapMode().DPtoLP(7),
					getMapMode().DPtoLP(7)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureCustomModelEndpointReferenceLabelFigure = new WrappingLabel();

			fFigureCustomModelEndpointReferenceLabelFigure.setText("");
			fFigureCustomModelEndpointReferenceLabelFigure.setForegroundColor(ColorConstants.darkGray);

			this.add(fFigureCustomModelEndpointReferenceLabelFigure);

			fFigureModelEndpointReferenceLabelFigure = new WrappingLabel();

			fFigureModelEndpointReferenceLabelFigure.setText("");
			fFigureModelEndpointReferenceLabelFigure.setForegroundColor(ColorConstants.darkGray);

			this.add(fFigureModelEndpointReferenceLabelFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureModelEndpointReferenceLabelFigure() {
			return fFigureModelEndpointReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCustomModelEndpointReferenceLabelFigure() {
			return fFigureCustomModelEndpointReferenceLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 243, 169, 25);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 248, 249, 212);

}
