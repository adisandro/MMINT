/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
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
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.diagram.part.Messages;
import edu.toronto.cs.se.mmtf.mid.editor.Diagram;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;

/**
 * The command to open a model editor.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelOpenEditorCommand extends AbstractTransactionalCommand {

	/** The hint about the editor to open. */
	private final HintedDiagramLinkStyle editorFacet;

	/**
	 * Constructor: initialises the superclass and the editor hint.
	 * 
	 * @param linkStyle
	 *            The hint about the editor to open.
	 */
	public ModelOpenEditorCommand(HintedDiagramLinkStyle linkStyle) {

		super(DiagramEditingDomainFactory.getInstance().createEditingDomain(), Messages.CommandName_OpenDiagram, null);
		editorFacet = linkStyle;
	}

	/**
	 * Opens the editor associated with a model.
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

		Model model = (Model) ((Shape) editorFacet.eContainer()).getElement();
		String modelTypeUri = model.getRoot().eClass().getEPackage().getNsURI();
		String modelUri = model.getUri();
		EList<Editor> registeredEditors = MMTFRegistry.getEditorsForModelType(modelTypeUri);

		// the editor file is supposed to be in the same directory as the model
		// otherwise every time we should ask where it is
		//TODO MMTF: implement fallbacks when the model files are deleted from file system?
		try {
			if (registeredEditors.size() == 0) {
				throw new MMTFException("No editor registered for model type " + modelTypeUri);
			}
			else {
				//TODO MMTF: needs to be fixed with multiple editor support
				for (Editor editor : registeredEditors) {
					if (editor instanceof Diagram) {
						URI editorUri = URI.createPlatformResourceURI(
							modelUri.substring(0, modelUri.lastIndexOf('.')+1) + editor.getFileExtensions().get(0),
							true
						);
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
							new URIEditorInput(editorUri),
							editor.getId()
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
