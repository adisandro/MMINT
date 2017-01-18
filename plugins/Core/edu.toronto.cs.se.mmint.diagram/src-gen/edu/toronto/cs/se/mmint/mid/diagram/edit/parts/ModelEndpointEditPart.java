/*
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import edu.toronto.cs.se.mmint.mid.diagram.edit.policies.ModelEndpointItemSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.diagram.edit.policies.ModelRelModelEndpointSemanticEditPolicy;

/**
 * @generated
 */
public class ModelEndpointEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4002;

	/**
	 * @generated
	 */
	public ModelEndpointEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ModelEndpointItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ModelRelModelEndpointSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel10EditPart) {
			((WrappingLabel10EditPart) childEditPart)
				.setLabel(getPrimaryShape().getFigureModelRelModelEndpointLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel11EditPart) {
			((WrappingLabel11EditPart) childEditPart)
				.setLabel(getPrimaryShape().getFigureCustomModelRelModelEndpointLabelFigure());
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
		super.addChildVisual(childEditPart, index);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel10EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel11EditPart) {
			return true;
		}
		return false;
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
	* Creates figure for this edit part.
	* 
	* Body of this method does not depend on settings in generation model
	* so you may safely remove <i>generated</i> tag and modify it.
	* 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new ModelRelModelEndpointFigure();
	}

	/**
	 * @generated
	 */
	public ModelRelModelEndpointFigure getPrimaryShape() {
		return (ModelRelModelEndpointFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ModelRelModelEndpointFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureModelRelModelEndpointLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureCustomModelRelModelEndpointLabelFigure;

		/**
		 * @generated
		 */
		public ModelRelModelEndpointFigure() {
			this.setLineWidth(3);
			this.setForegroundColor(THIS_FORE);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureCustomModelRelModelEndpointLabelFigure = new WrappingLabel();

			fFigureCustomModelRelModelEndpointLabelFigure.setText("");

			this.add(fFigureCustomModelRelModelEndpointLabelFigure);

			fFigureModelRelModelEndpointLabelFigure = new WrappingLabel();

			fFigureModelRelModelEndpointLabelFigure.setText("");

			this.add(fFigureModelRelModelEndpointLabelFigure);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			df.setLineWidth(3);
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureModelRelModelEndpointLabelFigure() {
			return fFigureModelRelModelEndpointLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCustomModelRelModelEndpointLabelFigure() {
			return fFigureCustomModelRelModelEndpointLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 44, 109, 163);

}
