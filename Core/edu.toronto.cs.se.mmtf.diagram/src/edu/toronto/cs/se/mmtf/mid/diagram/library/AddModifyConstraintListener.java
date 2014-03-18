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
package edu.toronto.cs.se.mmtf.mid.diagram.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElement;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmtf.mid.ExtendibleElementConstraintLanguage;
import edu.toronto.cs.se.mmtf.mid.MidFactory;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.relationship.ExtendibleElementReference;

public class AddModifyConstraintListener extends SelectionAdapter {

	ExtendibleElement element;

	public AddModifyConstraintListener(ExtendibleElement element) {

		this.element = element;
	}

	public AddModifyConstraintListener(ExtendibleElementReference elementRef) {

		element = elementRef.getObject();
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		IFile diagramFile = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
		if (diagramFile != null) {
			IFile modelFile = diagramFile.getParent().getFile(new Path(diagramFile.getName().substring(0, diagramFile.getName().length() - MMTF.MID_DIAGRAM_SUFFIX.length())));
			files.add(diagramFile);
			files.add(modelFile);
		}
		AbstractTransactionalCommand copyCommand = new AddModifyConstraintCommand(
			TransactionUtil.getEditingDomain(element),
			"Constraint",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(copyCommand, null, null);
		}
		catch (ExecutionException ex) {
			MMTFException.print(Type.WARNING, "Add/modify property history execution error", ex);
		}
	}

	protected class AddModifyConstraintCommand extends AbstractTransactionalCommand {

		public AddModifyConstraintCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			try {
				ExtendibleElementConstraint constraint = element.getConstraint();
				if (constraint == null) {
					constraint = MidFactory.eINSTANCE.createExtendibleElementConstraint();
					element.setConstraint(constraint);
				}
				String implementation = constraint.getImplementation();
				if (implementation == null) {
					implementation = "";
				}
				String[] newConstraint = MidDiagramUtils.getConstraintInput("Add/Modify Constraint", constraint.getLanguage().getLiteral() + MidDiagramUtils.CONSTRAINT_LANGUAGE_SEPARATOR + implementation);
				if (!MultiModelConstraintChecker.isInstancesLevel(element)) {
					if (!MultiModelConstraintChecker.checkConstraintConsistency(element.getSupertype(), newConstraint[0], newConstraint[1])) {
						throw new MMTFException("The combined constraint (this type + supertypes) is inconsistent");
					}
				}
				constraint.setLanguage(ExtendibleElementConstraintLanguage.get(newConstraint[0]));
				constraint.setImplementation(newConstraint[1]);

				return CommandResult.newOKCommandResult(constraint);
			}
			catch (MMTFException e) {
				MMTFException.print(MMTFException.Type.WARNING, "No constraint added", e);
				return CommandResult.newErrorCommandResult("No constraint added");
			}
		}

	}

}
