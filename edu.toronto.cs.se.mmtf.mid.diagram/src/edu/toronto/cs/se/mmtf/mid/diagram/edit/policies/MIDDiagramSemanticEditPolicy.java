package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceCreateMappingCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelReferenceCreateModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.ModelReferenceImportModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDElementTypes;

public class MIDDiagramSemanticEditPolicy extends MultiModelItemSemanticEditPolicy {

	protected Command getCreateCommand(CreateElementRequest req) {

		if (MIDElementTypes.MappingReference_2004 == req.getElementType()) {
			return getGEFWrapper(new MappingReferenceCreateMappingCommand(req));
		}
		if (MIDElementTypes.ModelReference_2002 == req.getElementType()) {
			return getGEFWrapper(new ModelReferenceImportModelCommand(req));
		}
		if (MIDElementTypes.ModelReference_2003 == req.getElementType()) {
			return getGEFWrapper(new ModelReferenceCreateModelCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
