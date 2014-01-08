/*
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.LinkReference2ItemSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.LinkReferenceSuperComponentEditPolicy;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.LinkReferenceSuperSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

/**
 * @generated
 */
public class LinkReference2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2009;

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
	public LinkReference2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new LinkReference2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new LinkReferenceSuperSemanticEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new LinkReferenceSuperComponentEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {

		FlowLayoutEditPolicy lep = new FlowLayoutEditPolicy() {

			protected Command createAddCommand(EditPart child, EditPart after) {
				return null;
			}

			protected Command createMoveChildCommand(EditPart child,
					EditPart after) {
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
		return primaryShape = new LinkReferenceSuperFigure();
	}

	/**
	 * @generated
	 */
	public LinkReferenceSuperFigure getPrimaryShape() {
		return (LinkReferenceSuperFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel3EditPart) {
			((WrappingLabel3EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureLinkReferenceSuperLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel18EditPart) {
			((WrappingLabel18EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMAVOLinkReferenceSuperLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel3EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel18EditPart) {
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
		return getChildBySemanticHint(MidVisualIDRegistry
				.getType(WrappingLabel3EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		types.add(MidElementTypes.ModelElementEndpointReference_4011);
		types.add(MidElementTypes.ModelElementEndpointReference_4014);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ModelEndpointReferenceEditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof LinkReferenceEditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.LinkReference2EditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelEndpointReference2EditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReferenceEditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReferenceEditPart) {
			types.add(MidElementTypes.ModelElementEndpointReference_4011);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MidElementTypes.ModelElementEndpointReference_4011);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MidElementTypes.ModelElementEndpointReference_4011);
		}
		if (targetEditPart instanceof ModelElementReferenceEditPart) {
			types.add(MidElementTypes.ModelElementEndpointReference_4014);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MidElementTypes.ModelElementEndpointReference_4014);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MidElementTypes.ModelElementEndpointReference_4014);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010) {
			types.add(MidElementTypes.ModelEndpointReference_2007);
			types.add(MidElementTypes.LinkReference_2008);
			types.add(MidElementTypes.LinkReference_2009);
			types.add(MidElementTypes.ModelEndpointReference_2010);
			types.add(MidElementTypes.ModelElementReference_3005);
			types.add(MidElementTypes.ModelElementReference_3006);
			types.add(MidElementTypes.ModelElementReference_3007);
		} else if (relationshipType == MidElementTypes.ModelElementEndpointReference_4011) {
			types.add(MidElementTypes.ModelElementReference_3005);
			types.add(MidElementTypes.ModelElementReference_3006);
			types.add(MidElementTypes.ModelElementReference_3007);
		} else if (relationshipType == MidElementTypes.ModelElementEndpointReference_4014) {
			types.add(MidElementTypes.ModelElementReference_3005);
			types.add(MidElementTypes.ModelElementReference_3006);
			types.add(MidElementTypes.ModelElementReference_3007);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(1);
		types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010) {
			types.add(MidElementTypes.ModelEndpointReference_2007);
			types.add(MidElementTypes.LinkReference_2008);
			types.add(MidElementTypes.LinkReference_2009);
			types.add(MidElementTypes.ModelEndpointReference_2010);
			types.add(MidElementTypes.ModelElementReference_3005);
			types.add(MidElementTypes.ModelElementReference_3006);
			types.add(MidElementTypes.ModelElementReference_3007);
		}
		return types;
	}

	/**
	 * @generated
	 */
	protected void handleNotificationEvent(Notification event) {
		if (event.getNotifier() == getModel()
				&& EcorePackage.eINSTANCE.getEModelElement_EAnnotations()
						.equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	}

	/**
	 * @generated
	 */
	public class LinkReferenceSuperFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLinkReferenceSuperLabelFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMAVOLinkReferenceSuperLabelFigure;

		/**
		 * @generated
		 */
		public LinkReferenceSuperFigure() {

			FlowLayout layoutThis = new FlowLayout();
			layoutThis.setStretchMinorAxis(false);
			layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutThis.setMajorSpacing(5);
			layoutThis.setMinorSpacing(5);
			layoutThis.setHorizontal(true);

			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(12),
					getMapMode().DPtoLP(12)));
			this.setLineWidth(3);
			this.setLineStyle(Graphics.LINE_DASH);
			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(60)));
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(7),
					getMapMode().DPtoLP(7), getMapMode().DPtoLP(7),
					getMapMode().DPtoLP(7)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureMAVOLinkReferenceSuperLabelFigure = new WrappingLabel();

			fFigureMAVOLinkReferenceSuperLabelFigure.setText("");
			fFigureMAVOLinkReferenceSuperLabelFigure
					.setForegroundColor(ColorConstants.darkGray);

			this.add(fFigureMAVOLinkReferenceSuperLabelFigure);

			fFigureLinkReferenceSuperLabelFigure = new WrappingLabel();

			fFigureLinkReferenceSuperLabelFigure.setText("");
			fFigureLinkReferenceSuperLabelFigure
					.setForegroundColor(ColorConstants.darkGray);

			this.add(fFigureLinkReferenceSuperLabelFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLinkReferenceSuperLabelFigure() {
			return fFigureLinkReferenceSuperLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMAVOLinkReferenceSuperLabelFigure() {
			return fFigureMAVOLinkReferenceSuperLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 44, 109, 163);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 226, 226, 231);

}
