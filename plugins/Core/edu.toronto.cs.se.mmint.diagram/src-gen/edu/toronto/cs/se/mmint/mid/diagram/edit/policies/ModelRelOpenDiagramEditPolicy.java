
/*
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.edit.policies;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditorPlugin;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditorUtil;
import edu.toronto.cs.se.mmint.mid.diagram.part.Messages;
import edu.toronto.cs.se.mmint.mid.diagram.providers.MIDDiagramViewProvider;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

/**
 * @generated
 */
public class ModelRelOpenDiagramEditPolicy extends OpenEditPolicy {

	/**
	 * @generated
	 */
	protected Command getOpenCommandGen(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);
		if (false == targetEditPart.getModel() instanceof View) {
			return null;
		}
		View view = (View) targetEditPart.getModel();
		Style link = view.getStyle(NotationPackage.eINSTANCE.getHintedDiagramLinkStyle());
		if (false == link instanceof HintedDiagramLinkStyle) {
			return null;
		}
		return new ICommandProxy(new OpenDiagramCommand((HintedDiagramLinkStyle) link));
	}

	/**
	 * @generated NOT
	 */
	protected Command getOpenCommand(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);
		if (false == targetEditPart.getModel() instanceof View) {
			return null;
		}
		View view = (View) targetEditPart.getModel();
		Style link = view.getStyle(NotationPackage.eINSTANCE.getHintedDiagramLinkStyle());
		if (false == link instanceof HintedDiagramLinkStyle) {
			return null;
		}
		return new ICommandProxy(new ModelRelOpenEditorCommand((HintedDiagramLinkStyle) link));
	}

	/**
	 * @generated
	 */
	private static class OpenDiagramCommand extends AbstractTransactionalCommand {

		/**
		 * @generated NOT
		 */
		protected HintedDiagramLinkStyle diagramFacet;

		/**
		 * @generated
		 */
		OpenDiagramCommand(HintedDiagramLinkStyle linkStyle) {
			// editing domain is taken for original diagram, 
			// if we open diagram from another file, we should use another editing domain
			super(TransactionUtil.getEditingDomain(linkStyle), Messages.CommandName_OpenDiagram, null);
			diagramFacet = linkStyle;
		}

		// FIXME canExecute if  !(readOnly && getDiagramToOpen == null), i.e. open works on ro diagrams only when there's associated diagram already

		/**
		 * @generated
		 */
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {
			try {
				Diagram diagram = getDiagramToOpen();
				if (diagram == null) {
					diagram = intializeNewDiagram();
				}
				URI uri = EcoreUtil.getURI(diagram);
				String editorName = uri.lastSegment() + '#' + diagram.eResource().getContents().indexOf(diagram);
				IEditorInput editorInput = new URIEditorInput(uri, editorName);
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				page.openEditor(editorInput, getEditorID());
				return CommandResult.newOKCommandResult();
			}
			catch (Exception ex) {
				throw new ExecutionException("Can't open diagram", ex);
			}
		}

		/**
		 * @generated
		 */
		protected Diagram getDiagramToOpen() {
			return diagramFacet.getDiagramLink();
		}

		/**
		 * @generated
		 */
		protected Diagram intializeNewDiagram() throws ExecutionException {
			Diagram d = ViewService.createDiagram(getDiagramDomainElement(), getDiagramKind(), getPreferencesHint());
			if (d == null) {
				throw new ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind");
			}
			diagramFacet.setDiagramLink(d);
			assert diagramFacet.eResource() != null;
			diagramFacet.eResource().getContents().add(d);
			EObject container = diagramFacet.eContainer();
			while (container instanceof View) {
				((View) container).persist();
				container = container.eContainer();
			}
			try {
				new WorkspaceModifyOperation() {
					protected void execute(IProgressMonitor monitor)
							throws CoreException, InvocationTargetException, InterruptedException {
						try {
							for (Iterator it = diagramFacet.eResource().getResourceSet().getResources().iterator(); it
								.hasNext();) {
								Resource nextResource = (Resource) it.next();
								if (nextResource.isLoaded() && !getEditingDomain().isReadOnly(nextResource)) {
									nextResource.save(MIDDiagramEditorUtil.getSaveOptions());
								}
							}
						}
						catch (IOException ex) {
							throw new InvocationTargetException(ex, "Save operation failed");
						}
					}
				}.run(null);
			}
			catch (InvocationTargetException e) {
				throw new ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind", e);
			}
			catch (InterruptedException e) {
				throw new ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind", e);
			}
			return d;
		}

		/**
		 * @generated
		 */
		protected EObject getDiagramDomainElement() {
			// use same element as associated with EP
			return ((View) diagramFacet.eContainer()).getElement();
		}

		/**
		 * @generated
		 */
		protected PreferencesHint getPreferencesHint() {
			// XXX prefhint from target diagram's editor?
			return MIDDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
		}

		/**
		 * @generated
		 */
		protected String getDiagramKind() {
			return "Relationship";
		}

		/**
		 * @generated
		 */
		protected String getEditorID() {
			return "edu.toronto.cs.se.mmint.mid.relationship.diagram.part.RelationshipDiagramEditorID";
		}
	}

	/**
	 * @generated NOT
	 */
	private static class ModelRelOpenEditorCommand extends OpenDiagramCommand {

		/**
		 * @generated NOT
		 */
		ModelRelOpenEditorCommand(HintedDiagramLinkStyle linkStyle) {

			super(linkStyle);
		}

		/**
		 * @generated NOT
		 */
		private void openDiagram(Diagram diagram, ModelRel modelRel) throws Exception {

			//TODO MMINT[EDITOR] Can this be moved into ModelRelImpl?
			URI uri = EcoreUtil.getURI(diagram);
			String editorName = modelRel.getName() + ".relationshipdiag";
			IEditorInput editorInput = new URIEditorInput(uri, editorName);
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			page.openEditor(editorInput, getEditorID());
		}

		/**
		 * @generated NOT
		 */
		protected void doExecuteInstancesLevel(Diagram diagram, ModelRel modelRel) throws Exception {

			modelRel.openInstance();
			this.openDiagram(diagram, modelRel);
		}

		/**
		 * @generated NOT
		 */
		protected void doExecuteTypesLevel(Diagram diagram, ModelRel modelRelType) throws Exception {

			modelRelType.openType();
			this.openDiagram(diagram, modelRelType);
		}

		/**
		 * @generated NOT
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
				throws ExecutionException {

			try {
				View view = (View) super.diagramFacet.eContainer();
				ModelRel modelRel = (ModelRel) view.getElement();
				if (modelRel instanceof BinaryModelRel && !view.getEAnnotations().isEmpty()) { // shortcut to binary rel
					String modelRelUri = MIDRegistry.getModelElementUri(modelRel);
					String instanceMIDPath = MIDRegistry.getModelUri(modelRel);
					Diagram instanceMIDDiagramRoot = (Diagram) FileUtils.readModelFile(instanceMIDPath + GMFUtils.DIAGRAM_SUFFIX, true);
					Edge shortcutEdge = null;
					for (Object gmfEdge : instanceMIDDiagramRoot.getEdges()) {
						String gmfEdgeUri = MIDRegistry.getModelElementUri(((Edge) gmfEdge).getElement());
						if (gmfEdgeUri.equals(modelRelUri)) {
							shortcutEdge = (Edge) gmfEdge;
							break;
						}
					}
					if (shortcutEdge == null) {
						String srcModelPath = ((BinaryModelRel) modelRel).getSourceModel().getUri();
						String tgtModelPath = ((BinaryModelRel) modelRel).getTargetModel().getUri();
						Node gmfSrcNode = null, gmfTgtNode = null;
						for (Object node : instanceMIDDiagramRoot.getChildren()) {
							Node gmfNode = (Node) node;
							EObject element = gmfNode.getElement();
							if (!(element instanceof Model)) {
								continue;
							}
							String modelPath = ((Model) element).getUri();
							if (modelPath.equals(srcModelPath)) {
								gmfSrcNode = gmfNode;
							}
							if (modelPath.equals(tgtModelPath)) {
								gmfTgtNode = gmfNode;
							}
							if (gmfSrcNode != null && gmfTgtNode != null) {
								break;
							}
						}
						String midDiagramPluginId = MIDTypeRegistry.getTypeBundle(MIDTypeRegistry.getMIDDiagramType().getUri()).getSymbolicName();
						shortcutEdge = GMFUtils.createGMFEdge(
							modelRel,
							gmfSrcNode,
							gmfTgtNode,
							instanceMIDDiagramRoot,
							midDiagramPluginId,
							new MIDDiagramViewProvider());
					}
					for (Object gmfStyle : shortcutEdge.getStyles()) {
						if (gmfStyle instanceof HintedDiagramLinkStyle) {
							super.diagramFacet = (HintedDiagramLinkStyle) gmfStyle;
							break;
						}
					}
				}
				Diagram diagram = getDiagramToOpen();
				if (diagram == null) {
					diagram = intializeNewDiagram();
				}
				modelRel = (ModelRel) diagram.getElement();
				switch (modelRel.getLevel()) {
					case TYPES:
						this.doExecuteTypesLevel(diagram, modelRel);
						break;
					case INSTANCES:
						this.doExecuteInstancesLevel(diagram, modelRel);
						break;
					case WORKFLOWS:
						// do nothing
						break;
					default:
						throw new MMINTException("The MID level is missing");
				}

				return CommandResult.newOKCommandResult();
			}
			catch (Exception e) {
				throw new ExecutionException("No editor opened", e);
			}
		}

	}

}
