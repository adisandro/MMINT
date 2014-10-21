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
package edu.toronto.cs.se.mmint.mid.diagram.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDialogCancellation;

public class AddModifyConstraintListener extends SelectionAdapter {

	protected ExtendibleElement element;
	private boolean isDecision;

	public AddModifyConstraintListener(ExtendibleElement element, boolean isDecision) {

		//TODO MMINT[MU-MMINT] Review the need for isDecision
		this.element = element;
		this.isDecision = isDecision;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		IFile diagramFile = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
		if (diagramFile != null) {
			IFile modelFile = diagramFile.getParent().getFile(new Path(diagramFile.getName().substring(0, diagramFile.getName().length() - GMFDiagramUtils.DIAGRAM_SUFFIX.length())));
			files.add(diagramFile);
			files.add(modelFile);
		}
		AbstractTransactionalCommand command = new AddModifyConstraintCommand(
			TransactionUtil.getEditingDomain(element),
			"Constraint",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, null, null);
		}
		catch (ExecutionException ex) {
			MMINTException.print(Type.ERROR, "Add/modify constraint history execution error", ex);
		}
	}

	protected class AddModifyConstraintCommand extends AbstractTransactionalCommand {

		public AddModifyConstraintCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			try {
				Set<String> languages = MMINT.getReasonerLanguages();
				if (languages.isEmpty()) {
					throw new MMINTException("No language installed to express constraints");
				}
				ExtendibleElementConstraint constraint = element.getConstraint();
				if (constraint == null) {
					constraint = MIDFactory.eINSTANCE.createExtendibleElementConstraint();
					constraint.setLanguage(languages.iterator().next());
					constraint.setImplementation("");
				}
				//TODO MMINT[MU-MMINT] if isDecision flag is set, check whether the constraint is in the 'decision' format. If not, show empty constraint?
				String[] newConstraint = MultiModelDiagramUtils.getConstraintInput("Add/Modify Constraint", constraint.getLanguage() + MultiModelDiagramUtils.CONSTRAINT_LANGUAGE_SEPARATOR + "\n" + constraint.getImplementation());
				if (!MultiModelConstraintChecker.isInstancesLevel(element)) {
					if (!MultiModelConstraintChecker.checkConstraintConsistency(element, newConstraint[0], newConstraint[1])) {
						throw new MMINTException("The combined constraint (this type + supertypes) is inconsistent");
					}
				}
				constraint.setLanguage(newConstraint[0]);
				constraint.setImplementation(newConstraint[1]);
				if (element.getConstraint() == null) {
					element.setConstraint(constraint);
				}

				return CommandResult.newOKCommandResult(constraint);
			}
			catch (MultiModelDialogCancellation e) {
				return CommandResult.newCancelledCommandResult();
			}
			catch (MMINTException e) {
				MMINTException.print(Type.ERROR, "No constraint added", e);
				return CommandResult.newErrorCommandResult("No constraint added");
			}
		}

	}

}
