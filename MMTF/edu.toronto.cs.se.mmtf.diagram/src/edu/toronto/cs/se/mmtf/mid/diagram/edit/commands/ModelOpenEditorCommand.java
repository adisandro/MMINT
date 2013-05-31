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

import java.net.URL;
import java.util.Enumeration;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.diagram.part.Messages;
import edu.toronto.cs.se.mmtf.mid.editor.Editor;

/**
 * The command to open a model editor.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelOpenEditorCommand extends AbstractTransactionalCommand {

	private static final String ECORE_METAMODEL_PATTERN = "*.ecore";
	private static final String ECORE_EDITORID = "org.eclipse.emf.ecore.presentation.EcoreEditorID";

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

	protected void doExecuteInstancesLevel(Model model) throws Exception {

		Editor editor = model.getEditors().get(0);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
			new URIEditorInput(
				URI.createPlatformResourceURI(editor.getUri(), true)
			),
			editor.getId()
		);
	}

	protected void doExecuteTypesLevel(Model modelType) throws Exception {

		// climb up light types
		while (modelType.isDynamic() != false) {
			modelType = modelType.getSupertype();
		}
		// get metamodel files from bundle
		Bundle bundle = MultiModelTypeRegistry.getTypeBundle(modelType.getUri());
		Enumeration<URL> metamodels = bundle.findEntries("/", ECORE_METAMODEL_PATTERN, true);
		while (metamodels.hasMoreElements()) {
			//TODO MMTF: FileLocator here works for sure because it finds my source code directories, don't know what happens in a pure installation
			URI uri = URI.createURI(FileLocator.toFileURL(metamodels.nextElement()).toURI().toString());
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
				new URIEditorInput(uri),
				ECORE_EDITORID
			);
		}
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

		//TODO MMTF: add multiple editor choice support
		try {
			Model model = (Model) ((Node) editorFacet.eContainer()).getElement();
			if (MultiModelConstraintChecker.isInstancesLevel(model)) {
				doExecuteInstancesLevel(model);
			}
			else {
				doExecuteTypesLevel(model);
			}
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No editor associated", e);
			return CommandResult.newErrorCommandResult("No editor associated");
		}

		return CommandResult.newOKCommandResult();
	}
}
