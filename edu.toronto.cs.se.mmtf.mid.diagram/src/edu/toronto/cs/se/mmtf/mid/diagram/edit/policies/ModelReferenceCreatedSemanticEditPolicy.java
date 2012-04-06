package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryMappingReferenceChangeModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.BinaryMappingReferenceCreateMappingCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceAddModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceChangeModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.commands.MappingReferenceDelModelCommand;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.BinaryMappingReferenceEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MappingReferenceModelsEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MIDVisualIDRegistry;
import edu.toronto.cs.se.mmtf.mid.diagram.providers.MIDElementTypes;

public class ModelReferenceCreatedSemanticEditPolicy extends ModelReference2ItemSemanticEditPolicy {

	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == MappingReferenceModelsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new MappingReferenceDelModelCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (MIDVisualIDRegistry.getVisualID(incomingLink) == BinaryMappingReferenceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						incomingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (MIDVisualIDRegistry.getVisualID(outgoingLink) == BinaryMappingReferenceEditPart.VISUAL_ID) {
				DestroyElementRequest r = new DestroyElementRequest(
						outgoingLink.getElement(), false);
				cmd.add(new DestroyElementCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {

		if (MIDElementTypes.MappingReferenceModels_4003 == req.getElementType()) {
			return null;
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
