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
package edu.toronto.cs.se.mmtf.xt.graph.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import org.eclipse.ui.part.FileEditorInput;

import edu.toronto.cs.se.mmtf.xt.graph.diagram.edit.parts.GraphEditPart;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphDiagramEditor;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphDiagramEditorPlugin;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.part.GraphVisualIDRegistry;
import edu.toronto.cs.se.mmtf.xt.graph.diagram.part.Messages;

/**
 * @generated
 */
public class GraphNavigatorActionProvider extends CommonActionProvider {

	/**
	 * @generated
	 */
	private boolean myContribute;

	/**
	 * @generated
	 */
	private OpenDiagramAction myOpenDiagramAction;

	/**
	 * @generated
	 */
	public void init(ICommonActionExtensionSite aSite) {
		super.init(aSite);
		if (aSite.getViewSite() instanceof ICommonViewerWorkbenchSite) {
			myContribute = true;
			makeActions((ICommonViewerWorkbenchSite) aSite.getViewSite());
		} else {
			myContribute = false;
		}
	}

	/**
	 * @generated
	 */
	private void makeActions(ICommonViewerWorkbenchSite viewerSite) {
		myOpenDiagramAction = new OpenDiagramAction(viewerSite);
	}

	/**
	 * @generated
	 */
	public void fillActionBars(IActionBars actionBars) {
		if (!myContribute) {
			return;
		}
		IStructuredSelection selection = (IStructuredSelection) getContext()
				.getSelection();
		myOpenDiagramAction.selectionChanged(selection);
		if (myOpenDiagramAction.isEnabled()) {
			actionBars.setGlobalActionHandler(ICommonActionConstants.OPEN,
					myOpenDiagramAction);
		}
	}

	/**
	 * @generated
	 */
	public void fillContextMenu(IMenuManager menu) {
	}

	/**
	 * @generated
	 */
	private static class OpenDiagramAction extends Action {

		/**
		 * @generated
		 */
		private Diagram myDiagram;

		/**
		 * @generated
		 */
		private ICommonViewerWorkbenchSite myViewerSite;

		/**
		 * @generated
		 */
		public OpenDiagramAction(ICommonViewerWorkbenchSite viewerSite) {
			super(Messages.NavigatorActionProvider_OpenDiagramActionName);
			myViewerSite = viewerSite;
		}

		/**
		 * @generated
		 */
		public final void selectionChanged(IStructuredSelection selection) {
			myDiagram = null;
			if (selection.size() == 1) {
				Object selectedElement = selection.getFirstElement();
				if (selectedElement instanceof GraphNavigatorItem) {
					selectedElement = ((GraphNavigatorItem) selectedElement)
							.getView();
				} else if (selectedElement instanceof IAdaptable) {
					selectedElement = ((IAdaptable) selectedElement)
							.getAdapter(View.class);
				}
				if (selectedElement instanceof Diagram) {
					Diagram diagram = (Diagram) selectedElement;
					if (GraphEditPart.MODEL_ID.equals(GraphVisualIDRegistry
							.getModelID(diagram))) {
						myDiagram = diagram;
					}
				}
			}
			setEnabled(myDiagram != null);
		}

		/**
		 * @generated
		 */
		public void run() {
			if (myDiagram == null || myDiagram.eResource() == null) {
				return;
			}

			IEditorInput editorInput = getEditorInput(myDiagram);
			IWorkbenchPage page = myViewerSite.getPage();
			try {
				page.openEditor(editorInput, GraphDiagramEditor.ID);
			} catch (PartInitException e) {
				GraphDiagramEditorPlugin.getInstance().logError(
						"Exception while openning diagram", e); //$NON-NLS-1$
			}
		}

		/**
		 * @generated
		 */
		private static IEditorInput getEditorInput(Diagram diagram) {
			Resource diagramResource = diagram.eResource();
			for (EObject nextEObject : diagramResource.getContents()) {
				if (nextEObject == diagram) {
					return new FileEditorInput(
							WorkspaceSynchronizer.getFile(diagramResource));
				}
				if (nextEObject instanceof Diagram) {
					break;
				}
			}
			URI uri = EcoreUtil.getURI(diagram);
			String editorName = uri.lastSegment() + '#'
					+ diagram.eResource().getContents().indexOf(diagram);
			IEditorInput editorInput = new URIEditorInput(uri, editorName);
			return editorInput;
		}

	}

}
