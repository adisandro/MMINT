package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.BinaryMappingChangeElementCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.BinaryMappingCreateMappingCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.MappingElementsCreateCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.BinaryMappingEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.providers.MIDElementTypes;

public class ModelElementReferenceSemanticEditPolicy extends ModelElementReferenceItemSemanticEditPolicy {

	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.MappingElements_4002 == req.getElementType()) {
			return null;
		}
		if (MIDElementTypes.BinaryMapping_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryMappingCreateMappingCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.MappingElements_4002 == req.getElementType()) {
			return getGEFWrapper(new MappingElementsCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (MIDElementTypes.BinaryMapping_4003 == req.getElementType()) {
			return getGEFWrapper(new BinaryMappingCreateMappingCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	protected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {

		switch (getVisualID(req)) {
			case BinaryMappingEditPart.VISUAL_ID:
				return getGEFWrapper(new BinaryMappingChangeElementCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
