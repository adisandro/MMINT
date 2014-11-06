/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.edit.commands;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.diagram.part.Messages;
import edu.toronto.cs.se.mmint.mid.editor.Editor;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

/**
 * The command to open a model editor.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelOpenEditorCommand extends AbstractTransactionalCommand {

	//TODO MMINT[ECORE] Move to ecore project
	public static final String ECORE_EDITORID = "org.eclipse.emf.ecore.presentation.EcoreEditorID";
	public static final String ECORE_DIAGRAMID = "org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorID";

	/** The hint about the editor to open. */
	private final HintedDiagramLinkStyle editorFacet;

	/**
	 * Constructor: initialises the superclass and the editor hint.
	 * 
	 * @param linkStyle
	 *            The hint about the editor to open.
	 */
	public ModelOpenEditorCommand(HintedDiagramLinkStyle linkStyle) {

		super(TransactionUtil.getEditingDomain(linkStyle), Messages.CommandName_OpenDiagram, null);
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

		List<URI> metamodelUris = new ArrayList<URI>();
		//TODO MMINT[EDITOR] fix a) references to inherited metamodels not good in runtime eclipse b) open UML
		while (true) {
			if (modelType.isDynamic()) {
				String metamodelUri = MultiModelTypeRegistry.getExtendedMetamodelUri(modelType);
				if (metamodelUri != null) { // get metamodel file from mmint state area
					metamodelUris.add(URI.createFileURI(metamodelUri));
					break;
				}
			}
			else { // get metamodel files from bundle
				Bundle bundle = MultiModelTypeRegistry.getTypeBundle(modelType.getUri());
				Enumeration<URL> metamodels = bundle.findEntries("/", "*." + EcorePackage.eNAME, true);
				while (metamodels.hasMoreElements()) {
					metamodelUris.add(URI.createURI(FileLocator.toFileURL(metamodels.nextElement()).toString()));
				}
				break;
			}
			// climb up light types
			modelType = modelType.getSupertype();
		}

		// open editors
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		for (URI metamodelUri : metamodelUris) {
			String metamodelDiagramUri = metamodelUri.toFileString() + GMFDiagramUtils.DIAGRAM_SUFFIX;
			if (MultiModelUtils.isFileOrDirectory(metamodelDiagramUri, false)) {
				activePage.openEditor(new URIEditorInput(URI.createFileURI(metamodelDiagramUri)), ECORE_DIAGRAMID);
			}
			else {
				activePage.openEditor(new URIEditorInput(metamodelUri), ECORE_EDITORID);
			}
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

		try {
			Model model = (Model) ((Node) editorFacet.eContainer()).getElement();
			if (MultiModelConstraintChecker.isInstancesLevel(model)) {
				doExecuteInstancesLevel(model);
			}
			else {
				doExecuteTypesLevel(model);
			}

			return CommandResult.newOKCommandResult();
		}
		catch (Exception e) {
			MMINTException.print(Type.ERROR, "No editor associated", e);
			return CommandResult.newErrorCommandResult("No editor associated");
		}
	}

}
