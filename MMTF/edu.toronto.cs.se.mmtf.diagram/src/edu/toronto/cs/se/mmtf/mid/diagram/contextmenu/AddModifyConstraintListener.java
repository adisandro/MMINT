/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.diagram.contextmenu;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelConstraint;
import edu.toronto.cs.se.mmtf.mid.ModelConstraintLanguage;
import edu.toronto.cs.se.mmtf.mid.diagram.library.MidDiagramUtils;

public class AddModifyConstraintListener extends SelectionAdapter {

	Model model;

	public AddModifyConstraintListener(Model model) {

		this.model = model;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		files.add((IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class));
		//TODO MMTF: need domain file too?
		AbstractTransactionalCommand copyCommand = new CopyCommand(
			TransactionUtil.getEditingDomain(model),
			"Copy",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(copyCommand, null, null);
		}
		catch (ExecutionException ex) {
			MMTFException.print(Type.WARNING, "Copy model history execution error", ex);
		}
	}

	protected class CopyCommand extends AbstractTransactionalCommand {

		public CopyCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			try {
				ModelConstraint constraint = model.getConstraint();
				if (constraint == null) {
					constraint = MidFactory.eINSTANCE.createModelConstraint();
					model.setConstraint(constraint);
				}
				String newConstraintImpl = MidDiagramUtils.getBigStringInput("Add/Modify Constraint", "Insert new model constraint", constraint.getImplementation());
				constraint.setLanguage(ModelConstraintLanguage.OCL);
				constraint.setImplementation(newConstraintImpl);

				return CommandResult.newOKCommandResult(constraint);
			}
			catch (Exception e) {
				MMTFException.print(MMTFException.Type.WARNING, "No constraint added", e);
				return CommandResult.newErrorCommandResult("No constraint added");
			}
		}

	}

}
