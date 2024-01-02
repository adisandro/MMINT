/*
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.BinaryMappingReference2ItemSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.BinaryMappingReferenceSuperSemanticEditPolicy;

/**
 * @generated
 */
public class BinaryMappingReference2EditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4004;

	/**
	* @generated
	*/
	public BinaryMappingReference2EditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE,
				new BinaryMappingReference2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BinaryMappingReferenceSuperSemanticEditPolicy());
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel21EditPart) {
			((WrappingLabel21EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureBinaryMappingReferenceSuperLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel22EditPart) {
			((WrappingLabel22EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureCustomBinaryMappingReferenceSuperLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel23EditPart) {
			((WrappingLabel23EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureBinaryMappingReferenceSuperSourceModelElementEndpointReferenceLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel24EditPart) {
			((WrappingLabel24EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureBinaryMappingReferenceSuperTargetModelElementEndpointReferenceLabelFigure());
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
		if (childEditPart instanceof WrappingLabel21EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel22EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel23EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel24EditPart) {
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
		return new BinaryMappingReferenceSuperFigure();
	}

	/**
	* @generated
	*/
	public BinaryMappingReferenceSuperFigure getPrimaryShape() {
		return (BinaryMappingReferenceSuperFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class BinaryMappingReferenceSuperFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryMappingReferenceSuperLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryMappingReferenceSuperSourceModelElementEndpointReferenceLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryMappingReferenceSuperTargetModelElementEndpointReferenceLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureCustomBinaryMappingReferenceSuperLabelFigure;

		/**
		 * @generated
		 */
		public BinaryMappingReferenceSuperFigure() {
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

			fFigureCustomBinaryMappingReferenceSuperLabelFigure = new WrappingLabel();

			fFigureCustomBinaryMappingReferenceSuperLabelFigure.setText("");

			this.add(fFigureCustomBinaryMappingReferenceSuperLabelFigure);

			fFigureBinaryMappingReferenceSuperLabelFigure = new WrappingLabel();

			fFigureBinaryMappingReferenceSuperLabelFigure.setText("");

			this.add(fFigureBinaryMappingReferenceSuperLabelFigure);

			fFigureBinaryMappingReferenceSuperSourceModelElementEndpointReferenceLabelFigure = new WrappingLabel();

			fFigureBinaryMappingReferenceSuperSourceModelElementEndpointReferenceLabelFigure.setText("");

			this.add(fFigureBinaryMappingReferenceSuperSourceModelElementEndpointReferenceLabelFigure);

			fFigureBinaryMappingReferenceSuperTargetModelElementEndpointReferenceLabelFigure = new WrappingLabel();

			fFigureBinaryMappingReferenceSuperTargetModelElementEndpointReferenceLabelFigure.setText("");

			this.add(fFigureBinaryMappingReferenceSuperTargetModelElementEndpointReferenceLabelFigure);

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
		public WrappingLabel getFigureBinaryMappingReferenceSuperLabelFigure() {
			return fFigureBinaryMappingReferenceSuperLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryMappingReferenceSuperSourceModelElementEndpointReferenceLabelFigure() {
			return fFigureBinaryMappingReferenceSuperSourceModelElementEndpointReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryMappingReferenceSuperTargetModelElementEndpointReferenceLabelFigure() {
			return fFigureBinaryMappingReferenceSuperTargetModelElementEndpointReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCustomBinaryMappingReferenceSuperLabelFigure() {
			return fFigureCustomBinaryMappingReferenceSuperLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 44, 109, 163);

}
