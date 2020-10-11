/*
* Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
* Rick Salay.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
* 
* Contributors:
*    Alessio Di Sandro - Implementation.
*/
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;

/**
 * @generated
 */
public class ClassDiagram_MAVONavigatorLinkHelper implements ILinkHelper {

	/**
	* @generated
	*/
	private static IEditorInput getEditorInput(Diagram diagram) {
		Resource diagramResource = diagram.eResource();
		for (EObject nextEObject : diagramResource.getContents()) {
			if (nextEObject == diagram) {
				return new FileEditorInput(WorkspaceSynchronizer.getFile(diagramResource));
			}
			if (nextEObject instanceof Diagram) {
				break;
			}
		}
		URI uri = EcoreUtil.getURI(diagram);
		String editorName = uri.lastSegment() + '#' + diagram.eResource().getContents().indexOf(diagram);
		IEditorInput editorInput = new URIEditorInput(uri, editorName);
		return editorInput;
	}

	/**
	* @generated
	*/
	public IStructuredSelection findSelection(IEditorInput anInput) {
		IDiagramDocument document = edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.part.ClassDiagram_MAVODiagramEditorPlugin
				.getInstance().getDocumentProvider().getDiagramDocument(anInput);
		if (document == null) {
			return StructuredSelection.EMPTY;
		}
		Diagram diagram = document.getDiagram();
		if (diagram == null || diagram.eResource() == null) {
			return StructuredSelection.EMPTY;
		}
		IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
		if (file != null) {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem item = new edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem(
					diagram, file, false);
			return new StructuredSelection(item);
		}
		return StructuredSelection.EMPTY;
	}

	/**
	* @generated
	*/
	public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
		if (aSelection == null || aSelection.isEmpty()) {
			return;
		}
		if (false == aSelection
				.getFirstElement() instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVOAbstractNavigatorItem) {
			return;
		}

		edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVOAbstractNavigatorItem abstractNavigatorItem = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVOAbstractNavigatorItem) aSelection
				.getFirstElement();
		View navigatorView = null;
		if (abstractNavigatorItem instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem) {
			navigatorView = ((edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem) abstractNavigatorItem)
					.getView();
		} else
			if (abstractNavigatorItem instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorGroup) {
			edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorGroup navigatorGroup = (edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorGroup) abstractNavigatorItem;
			if (navigatorGroup
					.getParent() instanceof edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem) {
				navigatorView = ((edu.toronto.cs.se.modelepedia.classdiagram_mavo.diagram.navigator.ClassDiagram_MAVONavigatorItem) navigatorGroup
						.getParent()).getView();
			} else if (navigatorGroup.getParent() instanceof IAdaptable) {
				navigatorView = (View) ((IAdaptable) navigatorGroup.getParent()).getAdapter(View.class);
			}
		}
		if (navigatorView == null) {
			return;
		}
		IEditorInput editorInput = getEditorInput(navigatorView.getDiagram());
		IEditorPart editor = aPage.findEditor(editorInput);
		if (editor == null) {
			return;
		}
		aPage.bringToTop(editor);
		if (editor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) editor;
			ResourceSet diagramEditorResourceSet = diagramEditor.getEditingDomain().getResourceSet();
			EObject selectedView = diagramEditorResourceSet.getEObject(EcoreUtil.getURI(navigatorView), true);
			if (selectedView == null) {
				return;
			}
			GraphicalViewer graphicalViewer = (GraphicalViewer) diagramEditor.getAdapter(GraphicalViewer.class);
			EditPart selectedEditPart = (EditPart) graphicalViewer.getEditPartRegistry().get(selectedView);
			if (selectedEditPart != null) {
				graphicalViewer.select(selectedEditPart);
			}
		}
	}

}
