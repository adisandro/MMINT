package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.MIDCreateShortcutDecorationsCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingReferenceEditPart;

public class MappingDiagramOutlineDragDropEditPolicy extends DiagramDragDropEditPolicy {

	private MappingReferenceEditPart editPart;

	public MappingDiagramOutlineDragDropEditPolicy(MappingReferenceEditPart editPart) {

		this.editPart = editPart;
	}

	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		ArrayList<CreateViewRequest.ViewDescriptor> viewDescriptors = new ArrayList<CreateViewRequest.ViewDescriptor>();
		for (Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {
			Object nextObject = it.next();
			if (false == nextObject instanceof EObject) {
				continue;
			}
			viewDescriptors.add(new CreateViewRequest.ViewDescriptor(
					new EObjectAdapter((EObject) nextObject), Node.class, null,
					editPart.getDiagramPreferencesHint()));
		}
		return createShortcutsCommand(dropRequest, viewDescriptors);
	}

	private Command createShortcutsCommand(DropObjectsRequest dropRequest,
			List<CreateViewRequest.ViewDescriptor> viewDescriptors) {
		Command command = createViewsAndArrangeCommand(dropRequest,
				viewDescriptors);
		if (command != null) {
			return command.chain(new ICommandProxy(
					new MIDCreateShortcutDecorationsCommand(editPart.getEditingDomain(),
							(View) editPart.getModel(), viewDescriptors)));
		}
		return null;
	}

}
