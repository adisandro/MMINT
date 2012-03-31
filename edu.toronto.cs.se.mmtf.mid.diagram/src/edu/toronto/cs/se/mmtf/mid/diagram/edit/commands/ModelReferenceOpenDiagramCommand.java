package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

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

import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.ModelReference;
import edu.toronto.cs.se.mmtf.mid.diagram.part.Messages;
import edu.toronto.cs.se.mmtf.repository.Diagram;
import edu.toronto.cs.se.mmtf.repository.Editor;

public class ModelReferenceOpenDiagramCommand extends AbstractTransactionalCommand {

	private final HintedDiagramLinkStyle diagramFacet;

	public ModelReferenceOpenDiagramCommand(HintedDiagramLinkStyle linkStyle) {

		super(DiagramEditingDomainFactory.getInstance().createEditingDomain(), Messages.CommandName_OpenDiagram, null);
		diagramFacet = linkStyle;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		ModelReference model = (ModelReference) ((Shape) diagramFacet.eContainer()).getElement();
		String metamodelUri = model.getRoot().eClass().getEPackage().getNsURI();
		String modelUri = model.getUri();
		EList<Editor> registeredEditors = MMTFRegistry.getEditorsForMetamodel(metamodelUri);

		// the diagram file is supposed to be in the same directory as the model
		// otherwise every time we should ask where it is
		//TODO implement fallbacks when the model files are deleted from file system?
		try {
			if (registeredEditors.size() == 0) {
				throw new MMTFException("No editor registered for metamodel " + metamodelUri);
			}
			else {
				//TODO needs to be fixed with views support
				for (Editor editor : registeredEditors) {
					if (editor instanceof Diagram) {
						URI editorUri = URI.createPlatformResourceURI(
							modelUri.substring(0, modelUri.lastIndexOf('.')+1) + editor.getFileExtensions().get(0),
							true
						);
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
							new URIEditorInput(editorUri),
							editor.getEditorId()
						);
						break;
					}
				}
			}
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No editor associated", e);
			return CommandResult.newErrorCommandResult("No editor associated");
		}

		return CommandResult.newOKCommandResult();
	}
}
