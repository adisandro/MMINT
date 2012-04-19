/*
 * Copyright (C) 2012 Marsha Chechik, Alessio Di Sandro, Rick Salay
 * 
 * This file is part of MMTF ver. 0.9.0.
 * 
 * MMTF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MMTF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MMTF.  If not, see <http://www.gnu.org/licenses/>.
 */
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

/**
 * The command to open a model reference.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelReferenceOpenDiagramCommand extends AbstractTransactionalCommand {

	/** The hint about the editor to open. */
	private final HintedDiagramLinkStyle editorFacet;

	/**
	 * Constructor: initialises the superclass and the editor hint.
	 * 
	 * @param linkStyle
	 *            The hint about the editor to open.
	 */
	public ModelReferenceOpenDiagramCommand(HintedDiagramLinkStyle linkStyle) {

		super(DiagramEditingDomainFactory.getInstance().createEditingDomain(), Messages.CommandName_OpenDiagram, null);
		editorFacet = linkStyle;
	}

	/**
	 * Opens the editor associated with a model reference.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result, or the error result if the editor could not be
	 *         opened.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		ModelReference model = (ModelReference) ((Shape) editorFacet.eContainer()).getElement();
		String metamodelUri = model.getRoot().eClass().getEPackage().getNsURI();
		String modelUri = model.getUri();
		EList<Editor> registeredEditors = MMTFRegistry.getEditorsForMetamodel(metamodelUri);

		// the diagram file is supposed to be in the same directory as the model
		// otherwise every time we should ask where it is
		//TODO MMTF: implement fallbacks when the model files are deleted from file system?
		try {
			if (registeredEditors.size() == 0) {
				throw new MMTFException("No editor registered for metamodel " + metamodelUri);
			}
			else {
				//TODO MMTF: needs to be fixed with views support
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
