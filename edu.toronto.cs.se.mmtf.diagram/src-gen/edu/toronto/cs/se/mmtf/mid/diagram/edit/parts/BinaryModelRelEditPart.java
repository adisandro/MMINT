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
import edu.toronto.cs.se.mmtf.mid.diagram.edit.policies.BinaryModelRelItemSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.policies.BinaryModelRelSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.policies.ModelRelOpenDiagramEditPolicy;

/**
 * @generated
 */
public class BinaryModelRelEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4015;

	/**
	 * @generated
	 */
	public BinaryModelRelEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new BinaryModelRelItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new BinaryModelRelSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new ModelRelOpenDiagramEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabel7EditPart) {
			((WrappingLabel7EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureBinaryModelRelLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel8EditPart) {
			((WrappingLabel8EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureBinaryModelRelSourceModelEndpointLabelFigure());
			return true;
		}
		if (childEditPart instanceof WrappingLabel9EditPart) {
			((WrappingLabel9EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureBinaryModelRelTargetModelEndpointLabelFigure());
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
		if (childEditPart instanceof WrappingLabel7EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel8EditPart) {
			return true;
		}
		if (childEditPart instanceof WrappingLabel9EditPart) {
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
		return new BinaryModelRelFigure();
	}

	/**
	 * @generated
	 */
	public BinaryModelRelFigure getPrimaryShape() {
		return (BinaryModelRelFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class BinaryModelRelFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryModelRelLabelFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryModelRelSourceModelEndpointLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryModelRelTargetModelEndpointLabelFigure;

		/**
		 * @generated
		 */
		public BinaryModelRelFigure() {
			this.setLineWidth(3);
			this.setForegroundColor(THIS_FORE);

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureBinaryModelRelLabelFigure = new WrappingLabel();

			fFigureBinaryModelRelLabelFigure.setText("<...>");

			this.add(fFigureBinaryModelRelLabelFigure);

			fFigureBinaryModelRelSourceModelEndpointLabelFigure = new WrappingLabel();

			fFigureBinaryModelRelSourceModelEndpointLabelFigure
					.setText("<...>");

			this.add(fFigureBinaryModelRelSourceModelEndpointLabelFigure);

			fFigureBinaryModelRelTargetModelEndpointLabelFigure = new WrappingLabel();

			fFigureBinaryModelRelTargetModelEndpointLabelFigure
					.setText("<...>");

			this.add(fFigureBinaryModelRelTargetModelEndpointLabelFigure);

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
		public WrappingLabel getFigureBinaryModelRelLabelFigure() {
			return fFigureBinaryModelRelLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryModelRelSourceModelEndpointLabelFigure() {
			return fFigureBinaryModelRelSourceModelEndpointLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryModelRelTargetModelEndpointLabelFigure() {
			return fFigureBinaryModelRelTargetModelEndpointLabelFigure;
		}

	}

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 44, 109, 163);

}
