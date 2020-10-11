/*
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ForeignColumnReferenceEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	* @generated
	*/
	public static final int VISUAL_ID = 4002;

	/**
	* @generated
	*/
	public ForeignColumnReferenceEditPart(View view) {
		super(view);
	}

	/**
	* @generated
	*/
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.policies.ForeignColumnReferenceItemSemanticEditPolicy());
	}

	/**
	* @generated
	*/
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel5EditPart) {
			((edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel5EditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureMAVOForeignColumnReferenceLabelFigure());
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
		if (childEditPart instanceof edu.toronto.cs.se.modelepedia.relationaldatabase_mavo.diagram.edit.parts.WrappingLabel5EditPart) {
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
		return new ForeignColumnReferenceFigure();
	}

	/**
	* @generated
	*/
	public ForeignColumnReferenceFigure getPrimaryShape() {
		return (ForeignColumnReferenceFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ForeignColumnReferenceFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureMAVOForeignColumnReferenceLabelFigure;

		/**
		 * @generated
		 */
		public ForeignColumnReferenceFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureMAVOForeignColumnReferenceLabelFigure = new WrappingLabel();

			fFigureMAVOForeignColumnReferenceLabelFigure.setText("");
			fFigureMAVOForeignColumnReferenceLabelFigure
					.setMaximumSize(new Dimension(getMapMode().DPtoLP(10000), getMapMode().DPtoLP(50)));

			this.add(fFigureMAVOForeignColumnReferenceLabelFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureMAVOForeignColumnReferenceLabelFigure() {
			return fFigureMAVOForeignColumnReferenceLabelFigure;
		}

	}

}
