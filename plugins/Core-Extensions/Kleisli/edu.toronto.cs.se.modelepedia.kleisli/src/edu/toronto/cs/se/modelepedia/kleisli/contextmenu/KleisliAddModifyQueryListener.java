/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.kleisli.contextmenu;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.AddModifyConstraintListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.modelepedia.kleisli.reasoning.KleisliReasoner;

public class KleisliAddModifyQueryListener extends AddModifyConstraintListener {

	public KleisliAddModifyQueryListener(String menuLabel, ExtendibleElement element) {

		super(menuLabel, element);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		KleisliAddModifyQueryCommand command = new KleisliAddModifyQueryCommand(
			TransactionUtil.getEditingDomain(this.element),
			this.menuLabel,
			MIDDiagramUtils.getActiveInstanceMIDFiles()
		);
		runListenerCommand(command);
	}

	protected class KleisliAddModifyQueryCommand extends AddModifyConstraintCommand {

		public KleisliAddModifyQueryCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			var result = super.doExecuteWithResult(monitor, info);
			if (result.getStatus().getSeverity() == IStatus.OK) {
			  var reasonerName = new KleisliReasoner().getName();
				if (!KleisliAddModifyQueryListener.this.element.getConstraint().getLanguage().equals(reasonerName)) {
					MMINTException.print(IStatus.ERROR, "The reasoner name is not '" + reasonerName + "'", null);
					result = CommandResult.newErrorCommandResult("No kleisli query added");
				}
			}

			return result;
		}

	}

}
