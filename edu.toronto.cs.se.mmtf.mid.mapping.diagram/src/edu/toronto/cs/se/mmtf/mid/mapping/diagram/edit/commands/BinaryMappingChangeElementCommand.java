package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

public class BinaryMappingChangeElementCommand extends BinaryMappingReorientCommand {

	public BinaryMappingChangeElementCommand(ReorientRelationshipRequest request) {

		super(request);
	}

	protected CommandResult reorientSource() throws ExecutionException {

		getLink().getElements().set(0, getNewSource());

		return super.reorientSource();
	}

	protected CommandResult reorientTarget() throws ExecutionException {

		getLink().getElements().set(1, getNewTarget());

		return super.reorientTarget();
	}

}
