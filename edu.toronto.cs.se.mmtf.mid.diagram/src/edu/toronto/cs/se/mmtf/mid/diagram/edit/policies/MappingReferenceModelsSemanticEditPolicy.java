package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceDelModelCommand;

public class MappingReferenceModelsSemanticEditPolicy extends MappingReferenceModelsItemSemanticEditPolicy {

	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {

		return getGEFWrapper(new MappingReferenceDelModelCommand(req));
	}

}
