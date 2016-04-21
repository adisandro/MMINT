/*
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
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

import edu.toronto.cs.se.modelepedia.istar.diagram.edit.policies.ResourceItemSemanticEditPolicy;
import edu.toronto.cs.se.modelepedia.istar.diagram.part.IStarVisualIDRegistry;
import edu.toronto.cs.se.modelepedia.istar.diagram.providers.IStarElementTypes;

/**
 * @generated
 */
public class ResourceEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2003;

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
	public ResourceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ResourceItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
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
		return primaryShape = new ResourceFigure();
	}

	/**
	 * @generated
	 */
	public ResourceFigure getPrimaryShape() {
		return (ResourceFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ResourceNameEditPart) {
			((ResourceNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureResourceLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ResourceNameEditPart) {
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
		return getChildBySemanticHint(IStarVisualIDRegistry
				.getType(ResourceNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSource() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		types.add(IStarElementTypes.MeansEnd_4001);
		types.add(IStarElementTypes.Decomposition_4002);
		types.add(IStarElementTypes.Contribution_4003);
		types.add(IStarElementTypes.DependerLink_4004);
		types.add(IStarElementTypes.DependeeLink_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof SoftGoalEditPart) {
			types.add(IStarElementTypes.MeansEnd_4001);
		}
		if (targetEditPart instanceof TaskEditPart) {
			types.add(IStarElementTypes.MeansEnd_4001);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceEditPart) {
			types.add(IStarElementTypes.MeansEnd_4001);
		}
		if (targetEditPart instanceof GoalEditPart) {
			types.add(IStarElementTypes.MeansEnd_4001);
		}
		if (targetEditPart instanceof SoftGoal2EditPart) {
			types.add(IStarElementTypes.MeansEnd_4001);
		}
		if (targetEditPart instanceof Task2EditPart) {
			types.add(IStarElementTypes.MeansEnd_4001);
		}
		if (targetEditPart instanceof Resource2EditPart) {
			types.add(IStarElementTypes.MeansEnd_4001);
		}
		if (targetEditPart instanceof Goal2EditPart) {
			types.add(IStarElementTypes.MeansEnd_4001);
		}
		if (targetEditPart instanceof SoftGoalEditPart) {
			types.add(IStarElementTypes.Decomposition_4002);
		}
		if (targetEditPart instanceof TaskEditPart) {
			types.add(IStarElementTypes.Decomposition_4002);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceEditPart) {
			types.add(IStarElementTypes.Decomposition_4002);
		}
		if (targetEditPart instanceof GoalEditPart) {
			types.add(IStarElementTypes.Decomposition_4002);
		}
		if (targetEditPart instanceof SoftGoal2EditPart) {
			types.add(IStarElementTypes.Decomposition_4002);
		}
		if (targetEditPart instanceof Task2EditPart) {
			types.add(IStarElementTypes.Decomposition_4002);
		}
		if (targetEditPart instanceof Resource2EditPart) {
			types.add(IStarElementTypes.Decomposition_4002);
		}
		if (targetEditPart instanceof Goal2EditPart) {
			types.add(IStarElementTypes.Decomposition_4002);
		}
		if (targetEditPart instanceof SoftGoalEditPart) {
			types.add(IStarElementTypes.Contribution_4003);
		}
		if (targetEditPart instanceof TaskEditPart) {
			types.add(IStarElementTypes.Contribution_4003);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceEditPart) {
			types.add(IStarElementTypes.Contribution_4003);
		}
		if (targetEditPart instanceof GoalEditPart) {
			types.add(IStarElementTypes.Contribution_4003);
		}
		if (targetEditPart instanceof SoftGoal2EditPart) {
			types.add(IStarElementTypes.Contribution_4003);
		}
		if (targetEditPart instanceof Task2EditPart) {
			types.add(IStarElementTypes.Contribution_4003);
		}
		if (targetEditPart instanceof Resource2EditPart) {
			types.add(IStarElementTypes.Contribution_4003);
		}
		if (targetEditPart instanceof Goal2EditPart) {
			types.add(IStarElementTypes.Contribution_4003);
		}
		if (targetEditPart instanceof SoftGoalEditPart) {
			types.add(IStarElementTypes.DependerLink_4004);
		}
		if (targetEditPart instanceof TaskEditPart) {
			types.add(IStarElementTypes.DependerLink_4004);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceEditPart) {
			types.add(IStarElementTypes.DependerLink_4004);
		}
		if (targetEditPart instanceof GoalEditPart) {
			types.add(IStarElementTypes.DependerLink_4004);
		}
		if (targetEditPart instanceof SoftGoal2EditPart) {
			types.add(IStarElementTypes.DependerLink_4004);
		}
		if (targetEditPart instanceof Task2EditPart) {
			types.add(IStarElementTypes.DependerLink_4004);
		}
		if (targetEditPart instanceof Resource2EditPart) {
			types.add(IStarElementTypes.DependerLink_4004);
		}
		if (targetEditPart instanceof Goal2EditPart) {
			types.add(IStarElementTypes.DependerLink_4004);
		}
		if (targetEditPart instanceof SoftGoalEditPart) {
			types.add(IStarElementTypes.DependeeLink_4005);
		}
		if (targetEditPart instanceof TaskEditPart) {
			types.add(IStarElementTypes.DependeeLink_4005);
		}
		if (targetEditPart instanceof edu.toronto.cs.se.modelepedia.istar.diagram.edit.parts.ResourceEditPart) {
			types.add(IStarElementTypes.DependeeLink_4005);
		}
		if (targetEditPart instanceof GoalEditPart) {
			types.add(IStarElementTypes.DependeeLink_4005);
		}
		if (targetEditPart instanceof ActorEditPart) {
			types.add(IStarElementTypes.DependeeLink_4005);
		}
		if (targetEditPart instanceof SoftGoal2EditPart) {
			types.add(IStarElementTypes.DependeeLink_4005);
		}
		if (targetEditPart instanceof Task2EditPart) {
			types.add(IStarElementTypes.DependeeLink_4005);
		}
		if (targetEditPart instanceof Resource2EditPart) {
			types.add(IStarElementTypes.DependeeLink_4005);
		}
		if (targetEditPart instanceof Goal2EditPart) {
			types.add(IStarElementTypes.DependeeLink_4005);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForTarget(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == IStarElementTypes.MeansEnd_4001) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
		} else if (relationshipType == IStarElementTypes.Decomposition_4002) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
		} else if (relationshipType == IStarElementTypes.Contribution_4003) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
		} else if (relationshipType == IStarElementTypes.DependerLink_4004) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
		} else if (relationshipType == IStarElementTypes.DependeeLink_4005) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.Actor_2005);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMARelTypesOnTarget() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		types.add(IStarElementTypes.MeansEnd_4001);
		types.add(IStarElementTypes.Decomposition_4002);
		types.add(IStarElementTypes.Contribution_4003);
		types.add(IStarElementTypes.DependerLink_4004);
		types.add(IStarElementTypes.DependeeLink_4005);
		return types;
	}

	/**
	 * @generated
	 */
	public List<IElementType> getMATypesForSource(IElementType relationshipType) {
		LinkedList<IElementType> types = new LinkedList<IElementType>();
		if (relationshipType == IStarElementTypes.MeansEnd_4001) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
		} else if (relationshipType == IStarElementTypes.Decomposition_4002) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
		} else if (relationshipType == IStarElementTypes.Contribution_4003) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
		} else if (relationshipType == IStarElementTypes.DependerLink_4004) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.Actor_2005);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
		} else if (relationshipType == IStarElementTypes.DependeeLink_4005) {
			types.add(IStarElementTypes.SoftGoal_2001);
			types.add(IStarElementTypes.Task_2002);
			types.add(IStarElementTypes.Resource_2003);
			types.add(IStarElementTypes.Goal_2004);
			types.add(IStarElementTypes.SoftGoal_3001);
			types.add(IStarElementTypes.Task_3002);
			types.add(IStarElementTypes.Resource_3003);
			types.add(IStarElementTypes.Goal_3004);
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
	public class ResourceFigure extends RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureResourceLabelFigure;

		/**
		 * @generated
		 */
		public ResourceFigure() {
			this.setLineWidth(5);
			this.setBorder(new MarginBorder(getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5), getMapMode().DPtoLP(5),
					getMapMode().DPtoLP(5)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureResourceLabelFigure = new WrappingLabel();

			fFigureResourceLabelFigure.setText("Resource");

			this.add(fFigureResourceLabelFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureResourceLabelFigure() {
			return fFigureResourceLabelFigure;
		}

	}

}
