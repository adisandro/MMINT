package edu.toronto.cs.se.mmtf.mid.diagram.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.diagram.part.Messages;
import edu.toronto.cs.se.mmtf.repository.Editor;

public class ModelReferenceOpenDiagramCommand extends AbstractTransactionalCommand {

	private final HintedDiagramLinkStyle diagramFacet;

	ModelReferenceOpenDiagramCommand(HintedDiagramLinkStyle linkStyle) {

		super(DiagramEditingDomainFactory.getInstance().createEditingDomain(), Messages.CommandName_OpenDiagram, null);
		diagramFacet = linkStyle;
	}

	@Override
	//TODO aggiustare alla luce del nuovo repository
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		ModelReference model = (ModelReference) ((Shape) diagramFacet.eContainer()).getElement();
		String metamodelUri = model.getRoot().eClass().getEPackage().getNsURI();
		String modelUri = model.getUri();
		EList<Editor> registeredEditors = MMTF.getEditorsForMetamodel(metamodelUri);

		try {
			if (registeredEditors.size() == 0) {
				throw new MMTFException("No editor registered with metamodel " + metamodelUri);
			}
			if (registeredEditors.size() == 1) {
				// the diagram is supposed to be in the same directory as the model
				// otherwise every time we should ask where it is
				//TODO implement FileDialog as a fallback
				Editor editor = registeredEditors.get(0);
				URI diagramUri = URI.createPlatformResourceURI(
					modelUri.substring(0, modelUri.lastIndexOf('.')+1) + editor.getFileExtensions().get(0),
					true
				);
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
					new URIEditorInput(diagramUri),
					editor.getEditorId()
				);
			}
			else {
				//TODO figure out how to choose a single diagram
			}
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No editor associated", e);
			return CommandResult.newErrorCommandResult("No editor associated");
		}

		return CommandResult.newOKCommandResult();
	}
}
