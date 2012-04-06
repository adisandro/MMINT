package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.MappingCreateCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.ModelContainerAddModelCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.providers.MIDElementTypes;

public class MappingDiagramSemanticEditPolicy extends MappingReferenceItemSemanticEditPolicy {

	protected Command getCreateCommand(CreateElementRequest req) {

		if (MIDElementTypes.ModelContainer_2005 == req.getElementType()) {
			return getGEFWrapper(new ModelContainerAddModelCommand(req));
		}
		if (MIDElementTypes.Mapping_2004 == req.getElementType()) {
			return getGEFWrapper(new MappingCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
