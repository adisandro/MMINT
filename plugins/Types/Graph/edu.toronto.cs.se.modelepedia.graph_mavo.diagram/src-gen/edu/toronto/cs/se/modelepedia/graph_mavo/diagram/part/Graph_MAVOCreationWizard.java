/*
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @generated
 */
public class Graph_MAVOCreationWizard extends Wizard implements INewWizard {

	/**
	 * @generated
	 */
	private IWorkbench workbench;

	/**
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * @generated
	 */
	protected edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOCreationWizardPage domainModelFilePage;

	/**
	 * @generated
	 */
	protected Resource diagram;

	/**
	 * @generated
	 */
	private boolean openNewlyCreatedDiagramEditor = true;

	/**
	 * @generated
	 */
	public IWorkbench getWorkbench() {
		return workbench;
	}

	/**
	 * @generated
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}

	/**
	 * @generated
	 */
	public final Resource getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public final boolean isOpenNewlyCreatedDiagramEditor() {
		return openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void setOpenNewlyCreatedDiagramEditor(
			boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Messages.Graph_MAVOCreationWizardTitle);
		setDefaultPageImageDescriptor(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin
				.getBundledImageDescriptor("icons/wizban/NewGraph_MAVOWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public void addPages() {
		diagramModelFilePage = new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOCreationWizardPage(
				"DiagramModelFile", getSelection(), "graphdiag_mavo"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage
				.setTitle(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Messages.Graph_MAVOCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage
				.setDescription(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Messages.Graph_MAVOCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVOCreationWizardPage(
				"DomainModelFile", getSelection(), "graph_mavo") { //$NON-NLS-1$ //$NON-NLS-2$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length()
							- ".graphdiag_mavo".length()); //$NON-NLS-1$
					setFileName(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorUtil
							.getUniqueFileName(getContainerFullPath(),
									fileName, "graph_mavo")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage
				.setTitle(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Messages.Graph_MAVOCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage
				.setDescription(edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Messages.Graph_MAVOCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	 * @generated
	 */
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				diagram = edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorUtil
						.createDiagram(diagramModelFilePage.getURI(),
								domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorUtil
								.openDiagram(diagram);
					} catch (PartInitException e) {
						ErrorDialog
								.openError(
										getContainer().getShell(),
										edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Messages.Graph_MAVOCreationWizardOpenEditorError,
										null, e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog
						.openError(
								getContainer().getShell(),
								edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Messages.Graph_MAVOCreationWizardCreationError,
								null, ((CoreException) e.getTargetException())
										.getStatus());
			} else {
				edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorPlugin
						.getInstance()
						.logError(
								"Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}
}
