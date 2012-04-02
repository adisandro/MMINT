package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.mapping.BinaryMappingReference;

public class MappingReferenceChangeModelCommand extends MappingReferenceModelsReorientCommand {

	public MappingReferenceChangeModelCommand(ReorientReferenceRelationshipRequest request) {

		super(request);
	}

	protected boolean canReorientSource() {

		if (getNewSource() instanceof BinaryMappingReference) {
			return false;
		}

		return super.canReorientSource();
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
