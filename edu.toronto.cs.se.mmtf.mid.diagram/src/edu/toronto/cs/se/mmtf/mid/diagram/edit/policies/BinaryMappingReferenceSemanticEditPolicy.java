package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryMappingReferenceChangeModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryMappingReferenceCreateMappingCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceAddModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceChangeModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDElementTypes;

public class BinaryMappingReferenceSemanticEditPolicy extends BinaryMappingReferenceItemSemanticEditPolicy {

	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.MappingReferenceModels_4003 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceAddModelCommand(req,
				req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryMappingReference_4004 == req.getElementType()) {
			return getGEFWrapper(new BinaryMappingReferenceCreateMappingCommand(
				req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.MappingReferenceModels_4003 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceAddModelCommand(req,
				req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryMappingReference_4004 == req.getElementType()) {
			return getGEFWrapper(new BinaryMappingReferenceCreateMappingCommand(
				req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		switch (getVisualID(req)) {
			case BinaryMappingReferenceEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryMappingReferenceChangeModelCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

	protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {

		switch (getVisualID(req)) {
			case MappingReferenceModelsEditPart.VISUAL_ID:
				return getGEFWrapper(new MappingReferenceChangeModelCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
