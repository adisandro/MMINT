/*
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.ModelElementEndpointReferenceItemSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.relationship.diagram.edit.policies.ModelElementEndpointReferenceSemanticEditPolicy;

/**
 * @generated
 */
public class ModelElementEndpointReferenceEditPart extends
		ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4011;

	/**
	 * @generated
	 */
	public ModelElementEndpointReferenceEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ModelElementEndpointReferenceItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ModelElementEndpointReferenceSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel8EditPart) {
			((WrappingLabel8EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureLinkReferenceModelElemEndpointRefsLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel23EditPart) {
			((WrappingLabel23EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureMAVOModelElementEndpointReferenceLabelFigure());
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
		if (childEditPart instanceof WrappingLabel8EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel23EditPart) {
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
		return new ModelElementEndpointReferenceFigure();
	}

	/**
	 * @generated
	 */
	public ModelElementEndpointReferenceFigure getPrimaryShape() {
		return (ModelElementEndpointReferenceFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ModelElementEndpointReferenceFigure extends
			PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLinkReferenceModelElemEndpointRefsLabelFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMAVOModelElementEndpointReferenceLabelFigure;

		/**
		 * @generated
		 */
		public ModelElementEndpointReferenceFigure() {
			this.setLineWidth(3);
			this.setForegroundColor(THIS_FORE);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureMAVOModelElementEndpointReferenceLabelFigure = new WrappingLabel();

			fFigureMAVOModelElementEndpointReferenceLabelFigure.setText("");

			this.add(fFigureMAVOModelElementEndpointReferenceLabelFigure);

			fFigureLinkReferenceModelElemEndpointRefsLabelFigure = new WrappingLabel();

			fFigureLinkReferenceModelElemEndpointRefsLabelFigure.setText("");

			this.add(fFigureLinkReferenceModelElemEndpointRefsLabelFigure);

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
		public WrappingLabel getFigureLinkReferenceModelElemEndpointRefsLabelFigure() {
			return fFigureLinkReferenceModelElemEndpointRefsLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMAVOModelElementEndpointReferenceLabelFigure() {
			return fFigureMAVOModelElementEndpointReferenceLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 44, 109, 163);

}
