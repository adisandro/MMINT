package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.ExtensionRepository;
import edu.toronto.cs.se.mmtf.ExtensionRepository.DiagramID;
import edu.toronto.cs.se.mmtf.MMTFException;
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
		ArrayList<DiagramID> registeredDiagrams = ExtensionRepository.getDiagramIds(metamodelUri);

		try {
			if (registeredDiagrams.size() == 0) {
				throw new MMTFException("No diagram registered with metamodel " + metamodelUri);
			}
			if (registeredDiagrams.size() == 1) {
				// the diagram is supposed to be in the same directory as the model
				// otherwise every time we should ask where it is
				//TODO implement FileDialog as a fallback
				DiagramID diagram = registeredDiagrams.get(0);
				URI diagramUri = URI.createPlatformResourceURI(
					modelUri.substring(0, modelUri.lastIndexOf('.')+1) + diagram.getFileExtension(),
					true
				);
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
					new URIEditorInput(diagramUri),
					diagram.getEditorId()
				);
			}
			else {
				//TODO figure out how to choose a single diagram
			}
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No diagram associated", e);
			return CommandResult.newErrorCommandResult("No diagram associated");
		}

		return CommandResult.newOKCommandResult();
	}
}
