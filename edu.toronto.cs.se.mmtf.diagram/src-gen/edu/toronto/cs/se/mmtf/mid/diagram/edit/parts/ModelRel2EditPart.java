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
package edu.toronto.cs.se.mmtf.mid.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.policies.ModelRel2ItemSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.policies.ModelRelImportedSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.policies.ModelRelOpenDiagramEditPolicy;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MidElementTypes;

/**
 * @generated
 */
public class ModelRel2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2004;

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
	public ModelRel2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ModelRel2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new ModelRelOpenDiagramEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ModelRelImportedSemanticEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
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
		return primaryShape = new ModelRelFigure();
	}

	/**
	 * @generated
	 */
	public ModelRelFigure getPrimaryShape() {
		return (ModelRelFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ModelRelNameType2EditPart) {
			((ModelRelNameType2EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureModelRelLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ModelRelNameType2EditPart) {
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
				.getType(ModelRelNameType2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(MidElementTypes.ExtendibleElementSupertype_4001);
		types.add(MidElementTypes.ModelRelModels_4002);
		types.add(MidElementTypes.BinaryModelRel_4003);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ModelEditPart) {
			types.add(MidElementTypes.ExtendibleElementSupertype_4001);
		}
		if (targetEditPart instanceof Model2EditPart) {
			types.add(MidElementTypes.ExtendibleElementSupertype_4001);
		}
		if (targetEditPart instanceof ModelRelEditPart) {
			types.add(MidElementTypes.ExtendibleElementSupertype_4001);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart) {
			types.add(MidElementTypes.ExtendibleElementSupertype_4001);
		}
		if (targetEditPart instanceof ModelEditPart) {
			types.add(MidElementTypes.ModelRelModels_4002);
		}
		if (targetEditPart instanceof Model2EditPart) {
			types.add(MidElementTypes.ModelRelModels_4002);
		}
		if (targetEditPart instanceof ModelRelEditPart) {
			types.add(MidElementTypes.ModelRelModels_4002);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart) {
			types.add(MidElementTypes.ModelRelModels_4002);
		}
		if (targetEditPart instanceof ModelEditPart) {
			types.add(MidElementTypes.BinaryModelRel_4003);
		}
		if (targetEditPart instanceof Model2EditPart) {
			types.add(MidElementTypes.BinaryModelRel_4003);
		}
		if (targetEditPart instanceof ModelRelEditPart) {
			types.add(MidElementTypes.BinaryModelRel_4003);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.ModelRel2EditPart) {
			types.add(MidElementTypes.BinaryModelRel_4003);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == MidElementTypes.ExtendibleElementSupertype_4001) {
			types.add(MidElementTypes.Model_2001);
			types.add(MidElementTypes.Model_2002);
			types.add(MidElementTypes.ModelRel_2003);
			types.add(MidElementTypes.ModelRel_2004);
		} else if (relationshipType == MidElementTypes.ModelRelModels_4002) {
			types.add(MidElementTypes.Model_2001);
			types.add(MidElementTypes.Model_2002);
			types.add(MidElementTypes.ModelRel_2003);
			types.add(MidElementTypes.ModelRel_2004);
		} else if (relationshipType == MidElementTypes.BinaryModelRel_4003) {
			types.add(MidElementTypes.Model_2001);
			types.add(MidElementTypes.Model_2002);
			types.add(MidElementTypes.ModelRel_2003);
			types.add(MidElementTypes.ModelRel_2004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		types.add(MidElementTypes.ExtendibleElementSupertype_4001);
		types.add(MidElementTypes.ModelRelModels_4002);
		types.add(MidElementTypes.BinaryModelRel_4003);
		types.add(MidElementTypes.Parameter_4006);
		types.add(MidElementTypes.Parameter_4007);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == MidElementTypes.ExtendibleElementSupertype_4001) {
			types.add(MidElementTypes.Model_2001);
			types.add(MidElementTypes.Model_2002);
			types.add(MidElementTypes.ModelRel_2003);
			types.add(MidElementTypes.ModelRel_2004);
		} else if (relationshipType == MidElementTypes.ModelRelModels_4002) {
			types.add(MidElementTypes.ModelRel_2003);
			types.add(MidElementTypes.ModelRel_2004);
		} else if (relationshipType == MidElementTypes.BinaryModelRel_4003) {
			types.add(MidElementTypes.Model_2001);
			types.add(MidElementTypes.Model_2002);
			types.add(MidElementTypes.ModelRel_2003);
			types.add(MidElementTypes.ModelRel_2004);
		} else if (relationshipType == MidElementTypes.Parameter_4006) {
			types.add(MidElementTypes.Operator_2005);
		} else if (relationshipType == MidElementTypes.Parameter_4007) {
			types.add(MidElementTypes.Operator_2005);
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
	public class ModelRelFigure extends RoundedRectangle {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureModelRelLabelFigure;

		/**
		 * @generated
		 */
		public ModelRelFigure() {
			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(12),
					getMapMode().DPtoLP(12)));
			this.setForegroundColor(ColorConstants.black);
			this.setBackgroundColor(THIS_BACK);
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureModelRelLabelFigure = new WrappingLabel();
			fFigureModelRelLabelFigure.setText("<...>");

			this.add(fFigureModelRelLabelFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureModelRelLabelFigure() {
			return fFigureModelRelLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 232, 157, 111);

}
