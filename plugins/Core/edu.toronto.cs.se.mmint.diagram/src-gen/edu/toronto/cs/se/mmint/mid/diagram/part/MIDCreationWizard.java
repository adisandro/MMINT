/*
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import edu.toronto.cs.se.mmint.mid.MIDLevel;

/**
 * @generated
 */
public class MIDCreationWizard extends Wizard implements INewWizard {

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
	protected MIDCreationWizardPage diagramModelFilePage;

	/**
	 * @generated
	 */
	protected MIDCreationWizardPage domainModelFilePage;

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
	public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
		this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
	}

	/**
	 * @generated
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(Messages.MIDCreationWizardTitle);
		setDefaultPageImageDescriptor(
			MIDDiagramEditorPlugin.getBundledImageDescriptor("icons/wizban/NewMIDWizard.gif")); //$NON-NLS-1$
		setNeedsProgressMonitor(true);
	}

	/**
	 * @generated
	 */
	public void addPages() {
		diagramModelFilePage = new MIDCreationWizardPage("DiagramModelFile", getSelection(), "middiag"); //$NON-NLS-1$ //$NON-NLS-2$
		diagramModelFilePage.setTitle(Messages.MIDCreationWizard_DiagramModelFilePageTitle);
		diagramModelFilePage.setDescription(Messages.MIDCreationWizard_DiagramModelFilePageDescription);
		addPage(diagramModelFilePage);

		domainModelFilePage = new MIDCreationWizardPage("DomainModelFile", getSelection(), "mid") { //$NON-NLS-1$ //$NON-NLS-2$

			public void setVisible(boolean visible) {
				if (visible) {
					String fileName = diagramModelFilePage.getFileName();
					fileName = fileName.substring(0, fileName.length() - ".middiag".length()); //$NON-NLS-1$
					setFileName(MIDDiagramEditorUtil.getUniqueFileName(getContainerFullPath(), fileName, "mid")); //$NON-NLS-1$
				}
				super.setVisible(visible);
			}
		};
		domainModelFilePage.setTitle(Messages.MIDCreationWizard_DomainModelFilePageTitle);
		domainModelFilePage.setDescription(Messages.MIDCreationWizard_DomainModelFilePageDescription);
		addPage(domainModelFilePage);
	}

	/**
	 * @generated
	 */
	public boolean performFinishGen() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				diagram = MIDDiagramEditorUtil
					.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						MIDDiagramEditorUtil.openDiagram(diagram);
					}
					catch (PartInitException e) {
						ErrorDialog.openError(
							getContainer().getShell(),
							Messages.MIDCreationWizardOpenEditorError,
							null,
							e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		}
		catch (InterruptedException e) {
			return false;
		}
		catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(
					getContainer().getShell(),
					Messages.MIDCreationWizardCreationError,
					null,
					((CoreException) e.getTargetException()).getStatus());
			}
			else {
				MIDDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}

	/**
	 * @generated NOT
	 */
	public boolean performFinish() {

		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {

			protected void execute(IProgressMonitor monitor) throws CoreException, InterruptedException {
				MIDLevel midLevel = MIDLevel.INSTANCES;
				IWizardPage initialPage = diagramModelFilePage.getPreviousPage();
				if (initialPage != null && initialPage.getDescription().contains("workflow")) {
					midLevel = MIDLevel.WORKFLOWS;
				}
				diagram = MIDDiagramEditorUtil
					.createDiagram(diagramModelFilePage.getURI(), domainModelFilePage.getURI(), monitor, midLevel);
				if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
					try {
						MIDDiagramEditorUtil.openDiagram(diagram);
					}
					catch (PartInitException e) {
						ErrorDialog.openError(
							getContainer().getShell(),
							Messages.MIDCreationWizardOpenEditorError,
							null,
							e.getStatus());
					}
				}
			}
		};
		try {
			getContainer().run(false, true, op);
		}
		catch (InterruptedException e) {
			return false;
		}
		catch (InvocationTargetException e) {
			if (e.getTargetException() instanceof CoreException) {
				ErrorDialog.openError(
					getContainer().getShell(),
					Messages.MIDCreationWizardCreationError,
					null,
					((CoreException) e.getTargetException()).getStatus());
			}
			else {
				MIDDiagramEditorPlugin.getInstance().logError("Error creating diagram", e.getTargetException()); //$NON-NLS-1$
			}
			return false;
		}
		return diagram != null;
	}

}
