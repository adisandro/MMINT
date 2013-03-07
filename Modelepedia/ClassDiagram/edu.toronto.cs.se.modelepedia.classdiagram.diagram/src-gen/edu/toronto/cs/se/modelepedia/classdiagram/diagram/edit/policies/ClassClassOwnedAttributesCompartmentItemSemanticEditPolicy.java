/*
 * 
 */
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.commands.AttributeCreateCommand;
import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramElementTypes;

/**
 * @generated
 */
public class ClassClassOwnedAttributesCompartmentItemSemanticEditPolicy extends
		ClassDiagramBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ClassClassOwnedAttributesCompartmentItemSemanticEditPolicy() {
		super(ClassDiagramElementTypes.Class_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ClassDiagramElementTypes.Attribute_3001 == req.getElementType()) {
			return getGEFWrapper(new AttributeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
