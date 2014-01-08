/*
 * 
 */
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramElementTypes;

/**
 * @generated
 */
public class ClassNestedInItemSemanticEditPolicy extends
		ClassDiagramBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassNestedInItemSemanticEditPolicy() {
		super(ClassDiagramElementTypes.ClassNestedIn_4003);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
