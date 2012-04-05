package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

public class ModelElementReferenceHighlightEditPolicy extends NonResizableEditPolicy {

	public boolean isDragAllowed() {

		return false;
	}

}
