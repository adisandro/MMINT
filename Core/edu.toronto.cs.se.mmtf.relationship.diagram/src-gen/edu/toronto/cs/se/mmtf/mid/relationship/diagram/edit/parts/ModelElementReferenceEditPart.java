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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
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

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.ModelElementReferenceHighlightEditPolicy;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.ModelElementReferenceItemSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.ModelElementReferenceSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.part.MidVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.providers.MidElementTypes;

/**
 * @generated
 */
public class ModelElementReferenceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3005;

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
	public ModelElementReferenceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ModelElementReferenceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new ModelElementReferenceHighlightEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ModelElementReferenceSemanticEditPolicy());
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
		return primaryShape = new ModelElementReferenceFigure();
	}

	/**
	 * @generated
	 */
	public ModelElementReferenceFigure getPrimaryShape() {
		return (ModelElementReferenceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel5EditPart) {
			((WrappingLabel5EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureModelElementReferenceLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel20EditPart) {
			((WrappingLabel20EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMAVOModelElementReferenceLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel5EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel20EditPart) {
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
				.getType(WrappingLabel5EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		types.add(MidElementTypes.BinaryLinkReference_4012);
		types.add(MidElementTypes.BinaryLinkReference_4013);
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
		if (targetEditPart instanceof LinkReference2EditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelEndpointReference2EditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart) {
			types.add(MidElementTypes.BinaryLinkReference_4012);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MidElementTypes.BinaryLinkReference_4012);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MidElementTypes.BinaryLinkReference_4012);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts.ModelElementReferenceEditPart) {
			types.add(MidElementTypes.BinaryLinkReference_4013);
		}
		if (targetEditPart instanceof ModelElementReference2EditPart) {
			types.add(MidElementTypes.BinaryLinkReference_4013);
		}
		if (targetEditPart instanceof ModelElementReference3EditPart) {
			types.add(MidElementTypes.BinaryLinkReference_4013);
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
		} else if (relationshipType == MidElementTypes.BinaryLinkReference_4012) {
			types.add(MidElementTypes.ModelElementReference_3005);
			types.add(MidElementTypes.ModelElementReference_3006);
			types.add(MidElementTypes.ModelElementReference_3007);
		} else if (relationshipType == MidElementTypes.BinaryLinkReference_4013) {
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
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		types.add(MidElementTypes.ExtendibleElementReferenceSupertypeRef_4010);
		types.add(MidElementTypes.ModelElementEndpointReference_4011);
		types.add(MidElementTypes.BinaryLinkReference_4012);
		types.add(MidElementTypes.BinaryLinkReference_4013);
		types.add(MidElementTypes.ModelElementEndpointReference_4014);
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
		} else if (relationshipType == MidElementTypes.ModelElementEndpointReference_4011) {
			types.add(MidElementTypes.LinkReference_2008);
			types.add(MidElementTypes.LinkReference_2009);
		} else if (relationshipType == MidElementTypes.BinaryLinkReference_4012) {
			types.add(MidElementTypes.ModelElementReference_3005);
			types.add(MidElementTypes.ModelElementReference_3006);
			types.add(MidElementTypes.ModelElementReference_3007);
		} else if (relationshipType == MidElementTypes.BinaryLinkReference_4013) {
			types.add(MidElementTypes.ModelElementReference_3005);
			types.add(MidElementTypes.ModelElementReference_3006);
			types.add(MidElementTypes.ModelElementReference_3007);
		} else if (relationshipType == MidElementTypes.ModelElementEndpointReference_4014) {
			types.add(MidElementTypes.LinkReference_2008);
			types.add(MidElementTypes.LinkReference_2009);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class ModelElementReferenceFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureModelElementReferenceLabelFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMAVOModelElementReferenceLabelFigure;

		/**
		 * @generated
		 */
		public ModelElementReferenceFigure() {

			FlowLayout layoutThis = new FlowLayout();
			layoutThis.setStretchMinorAxis(false);
			layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

			layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
			layoutThis.setMajorSpacing(5);
			layoutThis.setMinorSpacing(5);
			layoutThis.setHorizontal(true);

			this.setLayoutManager(layoutThis);

			this.setForegroundColor(THIS_FORE);
			this.setBackgroundColor(THIS_BACK);
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(7),
					getMapMode().DPtoLP(7), getMapMode().DPtoLP(7),
					getMapMode().DPtoLP(7)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureMAVOModelElementReferenceLabelFigure = new WrappingLabel();

			fFigureMAVOModelElementReferenceLabelFigure.setText("");
			fFigureMAVOModelElementReferenceLabelFigure
					.setForegroundColor(ColorConstants.darkGray);

			this.add(fFigureMAVOModelElementReferenceLabelFigure);

			fFigureModelElementReferenceLabelFigure = new WrappingLabel();

			fFigureModelElementReferenceLabelFigure.setText("");
			fFigureModelElementReferenceLabelFigure
					.setForegroundColor(ColorConstants.darkGray);

			this.add(fFigureModelElementReferenceLabelFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureModelElementReferenceLabelFigure() {
			return fFigureModelElementReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMAVOModelElementReferenceLabelFigure() {
			return fFigureMAVOModelElementReferenceLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 248, 249, 212);

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 243, 169, 25);

}
