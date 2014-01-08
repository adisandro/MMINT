/*
 * 
 */
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.OperationCreateCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramElementTypes;

/**
 * @generated
 */
public class ClassClassOwnedOperationsCompartmentItemSemanticEditPolicy extends
		ClassDiagramBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassClassOwnedOperationsCompartmentItemSemanticEditPolicy() {
		super(ClassDiagramElementTypes.Class_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ClassDiagramElementTypes.Operation_3002 == req.getElementType()) {
			return getGEFWrapper(new OperationCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
