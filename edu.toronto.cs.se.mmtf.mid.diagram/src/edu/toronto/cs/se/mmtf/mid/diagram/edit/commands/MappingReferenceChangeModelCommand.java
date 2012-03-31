package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

public class MappingReferenceChangeModelCommand extends MappingReferenceModelsReorientCommand {

	public MappingReferenceChangeModelCommand(ReorientReferenceRelationshipRequest request) {

		super(request);
	}

	protected CommandResult reorientSource() throws ExecutionException {

		MultiModelCommandsTrait.removeMappingReferenceModel(getOldSource(), getOldTarget());
		MultiModelCommandsTrait.addMappingReferenceModel(getNewSource(), getOldTarget());

		return super.reorientSource();
	}

	protected CommandResult reorientTarget() throws ExecutionException {

		MultiModelCommandsTrait.removeMappingReferenceModel(getOldSource(), getOldTarget());
		MultiModelCommandsTrait.addMappingReferenceModel(getOldSource(), getNewTarget());

		return super.reorientTarget();
	}

}
