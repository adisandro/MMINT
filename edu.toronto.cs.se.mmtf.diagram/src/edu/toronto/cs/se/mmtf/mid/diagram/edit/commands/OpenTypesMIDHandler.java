package edu.toronto.cs.se.mmtf.mid.diagram.edit.commands;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTFActivator;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.diagram.edit.parts.MultiModelEditPart;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidDiagramEditorPlugin;
import edu.toronto.cs.se.mmtf.mid.diagram.part.MidDiagramEditorUtil;

public class OpenTypesMIDHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String path = MMTFActivator.getDefault().getStateLocation().toOSString();
		String middiagFile = path + "/types.middiag";
		
		File middiag = new File(middiagFile);
		
		if (!middiag.exists()) {
			generateDiagram(path+"/types.mid");
		}
		
		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(
				new URIEditorInput(
					URI.createFileURI(middiagFile)
				),
				"edu.toronto.cs.se.mmtf.mid.diagram.part.MidDiagramEditorID"
			);
		}
		catch (Exception e) {
			MMTFException.print(MMTFException.Type.WARNING, "No editor associated", e);
		}
		return null;
	}

	
	private void generateDiagram(String domainModelFileName) {
		String diagramModelFileName = domainModelFileName + "diag";
		EObject domainRoot = null;
		
		try {
			//load the domain model resource
			ResourceSet domainResourceSet = new ResourceSetImpl();
			domainResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
					Resource.Factory.Registry.DEFAULT_EXTENSION, 
					new XMIResourceFactoryImpl());
			URI domainFileURI = URI.createFileURI(new File(domainModelFileName).getAbsolutePath());
			Resource domainResource = domainResourceSet.getResource(domainFileURI, true);
	
			//create the diagram model resource
			ResourceSet diagramResourceSet = new ResourceSetImpl();
			diagramResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
					Resource.Factory.Registry.DEFAULT_EXTENSION, 
					new XMIResourceFactoryImpl());
			URI diagramFileURI = URI.createFileURI(new File(diagramModelFileName).getAbsolutePath());
			Resource diagramResource =	diagramResourceSet.createResource(diagramFileURI);
	
			//create the diagram and save it to the file
			domainRoot = (EObject) domainResource.getContents().get(0);
			Diagram diagram = ViewService.createDiagram(domainRoot, MultiModelEditPart.MODEL_ID,MidDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			diagramResource.getContents().add(diagram);
			diagramResource.save(MidDiagramEditorUtil.getSaveOptions());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		//if (domainRoot == null) {
		//	MessageDialog.openError(getShell(),
		//			fct.ample.annotatedUC.annotateduc.diagram.part.Messages.AnnotatedUCInitDiagramFileAction_InitDiagramFileResourceErrorDialogTitle,
		//			fct.ample.annotatedUC.annotateduc.diagram. part.Messages.AnnotatedUCInitDiagramFileAction_InitDiagramFileResourceErrorDialogMessage);
		//	return;
		//}
	}
}
