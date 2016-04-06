/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.BinaryMappingReferenceItemSemanticEditPolicy;
import edu.toronto.cs.se.mmint.mid.relationship.diagram.edit.policies.BinaryMappingReferenceSemanticEditPolicy;

/**
 * @generated
 */
public class BinaryMappingReferenceEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4003;

	/**
	* @generated
	*/
	public BinaryMappingReferenceEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE,
				new BinaryMappingReferenceItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new BinaryMappingReferenceSemanticEditPolicy());
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel17EditPart) {
			((WrappingLabel17EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureBinaryMappingReferenceLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel18EditPart) {
			((WrappingLabel18EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureCustomBinaryMappingReferenceLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel19EditPart) {
			((WrappingLabel19EditPart) childEditPart).setLabel(
					getPrimaryShape().getFigureBinaryMappingReferenceSourceModelElementEndpointReferenceLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel20EditPart) {
			((WrappingLabel20EditPart) childEditPart).setLabel(
					getPrimaryShape().getFigureBinaryMappingReferenceTargetModelElementEndpointReferenceLabelFigure());
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
		if (childEditPart instanceof WrappingLabel17EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel18EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel19EditPart) {
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
		return new BinaryMappingReferenceFigure();
	}

	/**
	* @generated
	*/
	public BinaryMappingReferenceFigure getPrimaryShape() {
		return (BinaryMappingReferenceFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class BinaryMappingReferenceFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryMappingReferenceLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryMappingReferenceSourceModelElementEndpointReferenceLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryMappingReferenceTargetModelElementEndpointReferenceLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureCustomBinaryMappingReferenceLabelFigure;

		/**
		 * @generated
		 */
		public BinaryMappingReferenceFigure() {
			this.setLineWidth(3);
			this.setForegroundColor(THIS_FORE);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureCustomBinaryMappingReferenceLabelFigure = new WrappingLabel();

			fFigureCustomBinaryMappingReferenceLabelFigure.setText("");

			this.add(fFigureCustomBinaryMappingReferenceLabelFigure);

			fFigureBinaryMappingReferenceLabelFigure = new WrappingLabel();

			fFigureBinaryMappingReferenceLabelFigure.setText("");

			this.add(fFigureBinaryMappingReferenceLabelFigure);

			fFigureBinaryMappingReferenceSourceModelElementEndpointReferenceLabelFigure = new WrappingLabel();

			fFigureBinaryMappingReferenceSourceModelElementEndpointReferenceLabelFigure.setText("");

			this.add(fFigureBinaryMappingReferenceSourceModelElementEndpointReferenceLabelFigure);

			fFigureBinaryMappingReferenceTargetModelElementEndpointReferenceLabelFigure = new WrappingLabel();

			fFigureBinaryMappingReferenceTargetModelElementEndpointReferenceLabelFigure.setText("");

			this.add(fFigureBinaryMappingReferenceTargetModelElementEndpointReferenceLabelFigure);

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
		public WrappingLabel getFigureBinaryMappingReferenceLabelFigure() {
			return fFigureBinaryMappingReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryMappingReferenceSourceModelElementEndpointReferenceLabelFigure() {
			return fFigureBinaryMappingReferenceSourceModelElementEndpointReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryMappingReferenceTargetModelElementEndpointReferenceLabelFigure() {
			return fFigureBinaryMappingReferenceTargetModelElementEndpointReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCustomBinaryMappingReferenceLabelFigure() {
			return fFigureCustomBinaryMappingReferenceLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 44, 109, 163);

}
