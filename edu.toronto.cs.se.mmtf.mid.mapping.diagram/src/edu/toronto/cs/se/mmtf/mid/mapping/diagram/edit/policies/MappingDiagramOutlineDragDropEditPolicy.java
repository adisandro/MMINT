package edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.mapping.MappingPackage;
import edu.toronto.cs.se.mmtf.mid.mapping.MappingReference;
import edu.toronto.cs.se.mmtf.mid.mapping.ModelContainer;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.commands.ModelElementReferenceDropCommand;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.MappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.edit.parts.ModelElementReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.mapping.diagram.providers.MIDElementTypes;

public class MappingDiagramOutlineDragDropEditPolicy extends DiagramDragDropEditPolicy {

	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {

		MappingReferenceEditPart editPart = (MappingReferenceEditPart) getHost();
		MappingReference root = (MappingReference) ((View) editPart.getModel()).getElement();
		CompoundCommand command = new CompoundCommand("Add model element references");
		IElementType elementType = MIDElementTypes.getElementType(ModelElementReferenceEditPart.VISUAL_ID);

		for (Iterator<?> it = dropRequest.getObjects().iterator(); it.hasNext();) {
			Object nextObject = it.next();
			if (!(nextObject instanceof EObject)) {
				continue;
			}
			EObject droppedElement = (EObject) nextObject;
			String modelUri = EcoreUtil.getURI(droppedElement).toPlatformString(true);

			for (ModelContainer container : root.getContainers()) {
				if (modelUri.equals(container.getModel().getUri())) {
					EReference containment = (EReference) container.eClass().getEStructuralFeature(MappingPackage.MODEL_CONTAINER__ELEMENTS);
					CreateElementRequest createReq = new CreateElementRequest(editPart.getEditingDomain(), container, elementType, containment);
					command.add(
						new ICommandProxy( // convert GMF command to GEF command
							new ModelElementReferenceDropCommand(createReq, droppedElement)
						)
					);
				}
			}
		}

		return command;
	}

}
