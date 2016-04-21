/**
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
package edu.toronto.cs.se.mmint.mid.diagram.library;

import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDialogCancellation;

public class AddModifyConstraintListener extends MIDContextMenuListener {

	protected ExtendibleElement element;

	public AddModifyConstraintListener(String menuLabel, ExtendibleElement element) {

		super(menuLabel);
		this.element = element;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new AddModifyConstraintCommand(
			TransactionUtil.getEditingDomain(element),
			menuLabel,
			MIDDiagramUtils.getActiveInstanceMIDFiles()
		);
		runListenerCommand(command);
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
				String[] newConstraint = MultiModelDiagramUtils.getConstraintInput(menuLabel, constraint.getLanguage() + MultiModelDiagramUtils.CONSTRAINT_LANGUAGE_SEPARATOR + "\n" + constraint.getImplementation());
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
				MMINTException.print(IStatus.ERROR, "No constraint added", e);
				return CommandResult.newErrorCommandResult("No constraint added");
			}
		}

	}

}
