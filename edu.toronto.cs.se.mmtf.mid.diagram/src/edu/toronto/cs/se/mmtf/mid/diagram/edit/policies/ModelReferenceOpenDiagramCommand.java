package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.Shape;

import edu.toronto.cs.se.mmtf.ExtensionRepository;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.diagram.part.Messages;

public class ModelReferenceOpenDiagramCommand extends AbstractTransactionalCommand {

	private final HintedDiagramLinkStyle diagramFacet;

	ModelReferenceOpenDiagramCommand(HintedDiagramLinkStyle linkStyle) {

		super(DiagramEditingDomainFactory.getInstance().createEditingDomain(), Messages.CommandName_OpenDiagram, null);
		diagramFacet = linkStyle;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		ModelReference model = (ModelReference) ((Shape) diagramFacet.eContainer()).getElement();
		String metamodelUri = model.getRoot().eClass().getEPackage().getNsURI();
		String modelUri = model.getUri();
		//TODO ricreare URI, togliere suffisso e aggiungere uno per uno i filenames (try catch)
		//TODO quindi aprire il diagram (cazzo ma l'editing domain? no devo inventarmi una conf per la priorità dei diagrammi)
		ExtensionRepository.getModelReferenceDiagramFilenames(metamodelUri);

		return CommandResult.newOKCommandResult();
	}
}
