/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.policies.BinaryMappingReferenceItemSemanticEditPolicy;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.policies.MappingReferenceOpenDiagramEditPolicy;

/**
 * @generated
 */
public class BinaryMappingReferenceEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4004;

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
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new BinaryMappingReferenceItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new MappingReferenceOpenDiagramEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof BinaryMappingReferenceNameEditPart) {
			((BinaryMappingReferenceNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureBinaryMappingReferenceNameFigure());
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
		if (childEditPart instanceof BinaryMappingReferenceNameEditPart) {
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
		return new BinaryMappingReferenceModelsFigure();
	}

	/**
	 * @generated
	 */
	public BinaryMappingReferenceModelsFigure getPrimaryShape() {
		return (BinaryMappingReferenceModelsFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class BinaryMappingReferenceModelsFigure extends
			PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureBinaryMappingReferenceNameFigure;

		/**
		 * @generated
		 */
		public BinaryMappingReferenceModelsFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureBinaryMappingReferenceNameFigure = new WrappingLabel();
			fFigureBinaryMappingReferenceNameFigure.setText("<...>");

			this.add(fFigureBinaryMappingReferenceNameFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBinaryMappingReferenceNameFigure() {
			return fFigureBinaryMappingReferenceNameFigure;
		}

	}

}
