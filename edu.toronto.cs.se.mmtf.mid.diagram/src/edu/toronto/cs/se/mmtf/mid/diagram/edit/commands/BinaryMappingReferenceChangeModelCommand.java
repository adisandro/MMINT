package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

public class BinaryMappingReferenceChangeModelCommand extends BinaryMappingReferenceReorientCommand {

	public BinaryMappingReferenceChangeModelCommand(ReorientRelationshipRequest request) {

		super(request);
	}

	protected CommandResult reorientSource() throws ExecutionException {

		MultiModelCommandsTrait.removeMappingReferenceModel(getLink(), getOldSource());
		MultiModelCommandsTrait.addMappingReferenceModel(getLink(), getNewSource());
		getLink().getModels().set(0, getNewSource());

		return super.reorientSource();
	}

	protected CommandResult reorientTarget() throws ExecutionException {

		MultiModelCommandsTrait.removeMappingReferenceModel(getLink(), getOldTarget());
		MultiModelCommandsTrait.addMappingReferenceModel(getLink(), getNewTarget());
		getLink().getModels().set(1, getNewTarget());

		return super.reorientTarget();
	}

}
