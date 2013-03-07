/*
 * 
 */
package edu.toronto.cs.se.modelepedia.classdiagram.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

import edu.toronto.cs.se.modelepedia.classdiagram.diagram.providers.ClassDiagramElementTypes;

/**
 * @generated
 */
public class DependencyItemSemanticEditPolicy extends
		ClassDiagramBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DependencyItemSemanticEditPolicy() {
		super(ClassDiagramElementTypes.Dependency_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}
