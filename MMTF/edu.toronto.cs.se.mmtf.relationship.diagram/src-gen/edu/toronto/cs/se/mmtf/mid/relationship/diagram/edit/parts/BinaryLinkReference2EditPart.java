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
package edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
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

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.BinaryLinkReference2ItemSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.BinaryLinkReferenceSuperSemanticEditPolicy;

/**
 * @generated
 */
public class BinaryLinkReference2EditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4013;

	/**
	 * @generated
	 */
	public BinaryLinkReference2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new BinaryLinkReference2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new BinaryLinkReferenceSuperSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel12EditPart) {
			((WrappingLabel12EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureBinaryLinkReferenceSuperLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel13EditPart) {
			((WrappingLabel13EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMAVOBinaryLinkReferenceSuperLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel14EditPart) {
			((WrappingLabel14EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureBinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel25EditPart) {
			((WrappingLabel25EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureBinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelFigure());
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
		if (childEditPart instanceof WrappingLabel12EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel13EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel14EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel25EditPart) {
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
		return new BinaryLinkReferenceSuperFigure();
	}

	/**
	 * @generated
	 */
	public BinaryLinkReferenceSuperFigure getPrimaryShape() {
		return (BinaryLinkReferenceSuperFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class BinaryLinkReferenceSuperFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryLinkReferenceSuperLabelFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMAVOBinaryLinkReferenceSuperLabelFigure;

		/**
		 * @generated
		 */
		public BinaryLinkReferenceSuperFigure() {
			this.setLineWidth(3);
			this.setLineStyle(Graphics.LINE_DASH);
			this.setForegroundColor(THIS_FORE);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureMAVOBinaryLinkReferenceSuperLabelFigure = new WrappingLabel();

			fFigureMAVOBinaryLinkReferenceSuperLabelFigure.setText("");

			this.add(fFigureMAVOBinaryLinkReferenceSuperLabelFigure);

			fFigureBinaryLinkReferenceSuperLabelFigure = new WrappingLabel();

			fFigureBinaryLinkReferenceSuperLabelFigure.setText("");

			this.add(fFigureBinaryLinkReferenceSuperLabelFigure);

			fFigureBinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelFigure = new WrappingLabel();

			fFigureBinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelFigure
					.setText("");

			this.add(fFigureBinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelFigure);

			fFigureBinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelFigure = new WrappingLabel();

			fFigureBinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelFigure
					.setText("");

			this.add(fFigureBinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelFigure);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			df.setLineWidth(3);
			df.setLineStyle(Graphics.LINE_DASH);
			return df;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryLinkReferenceSuperLabelFigure() {
			return fFigureBinaryLinkReferenceSuperLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelFigure() {
			return fFigureBinaryLinkReferenceSuperSourceModelElementEndpointReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelFigure() {
			return fFigureBinaryLinkReferenceSuperTargetModelElementEndpointReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMAVOBinaryLinkReferenceSuperLabelFigure() {
			return fFigureMAVOBinaryLinkReferenceSuperLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 44, 109, 163);

}
