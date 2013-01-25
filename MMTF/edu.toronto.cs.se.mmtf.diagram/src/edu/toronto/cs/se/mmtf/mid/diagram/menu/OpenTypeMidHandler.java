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
package edu.toronto.cs.se.mmtf.mid.diagram.menu;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFActivator;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidDiagramEditor;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidDiagramEditorPlugin;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidDiagramEditorUtil;

public class OpenTypeMidHandler extends AbstractHandler {

	private static final String DIAGRAM_SUFFIX = "diag";
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		String pluginPath = MMTFActivator.getDefault().getStateLocation().toOSString();
		String midFileName = pluginPath + IPath.SEPARATOR + MMTF.TYPE_MID_FILENAME;
		String middiagFileName = midFileName + DIAGRAM_SUFFIX;
		File middiag = new File(middiagFileName);
		if (!middiag.exists()) {
			generateDiagram();
		}

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
				new URIEditorInput(
					URI.createFileURI(middiagFileName)
				),
				MidDiagramEditor.ID
			);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No Type MID editor associated", e);
		}

		return null;
	}

	
	public static void generateDiagram() {

		try {
			String pluginPath = MMTFActivator.getDefault().getStateLocation().toOSString();
			String midFileName = pluginPath + IPath.SEPARATOR + MMTF.TYPE_MID_FILENAME;
			String middiagFileName = midFileName + DIAGRAM_SUFFIX;

			// load the domain model resource
			ResourceSet domainResourceSet = new ResourceSetImpl();
			URI domainFileURI = URI.createFileURI(midFileName);
			Resource domainResource = domainResourceSet.getResource(domainFileURI, true);

			// create the diagram model resource
			ResourceSet diagramResourceSet = new ResourceSetImpl();
			URI diagramFileURI = URI.createFileURI(middiagFileName);
			Resource diagramResource =	diagramResourceSet.createResource(diagramFileURI);

			// create the diagram and save it to the file
			EObject domainRoot = (EObject) domainResource.getContents().get(0);
			Diagram diagram = ViewService.createDiagram(
				domainRoot,
				MultiModelEditPart.MODEL_ID,
				MidDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT
			);
			diagramResource.getContents().add(diagram);
			diagramResource.save(MidDiagramEditorUtil.getSaveOptions());
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "Error creating type MID diagram", e);
		}
	}
}
