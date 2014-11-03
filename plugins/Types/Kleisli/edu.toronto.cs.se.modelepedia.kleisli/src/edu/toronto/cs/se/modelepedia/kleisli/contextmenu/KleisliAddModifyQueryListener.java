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
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.AddModifyConstraintListener;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.modelepedia.kleisli.reasoning.KleisliReasoningEngine;

public class KleisliAddModifyQueryListener extends AddModifyConstraintListener {

	public KleisliAddModifyQueryListener(String menuLabel, ExtendibleElement element) {

		super(menuLabel, element, false);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		KleisliAddModifyQueryCommand command = new KleisliAddModifyQueryCommand(
			TransactionUtil.getEditingDomain(element),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class KleisliAddModifyQueryCommand extends AddModifyConstraintCommand {

		public KleisliAddModifyQueryCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			CommandResult result = super.doExecuteWithResult(monitor, info);
			if (result.getStatus().getSeverity() == IStatus.OK) {
				if (!element.getConstraint().getLanguage().equals(KleisliReasoningEngine.LANGUAGE_ID)) {
					MMINTException.print(Type.ERROR, "The query language is not " + KleisliReasoningEngine.LANGUAGE_ID, null);
					result = CommandResult.newErrorCommandResult("No kleisli query added");
				}
			}

			return result;
		}

	}

}
