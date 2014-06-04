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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.AddModifyConstraintListener;
import edu.toronto.cs.se.modelepedia.kleisli.reasoning.KleisliReasoningEngine;

public class KleisliAddModifyQueryListener extends AddModifyConstraintListener {

	public KleisliAddModifyQueryListener(ExtendibleElement element) {

		super(element);
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		IFile diagramFile = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
		if (diagramFile != null) {
			IFile modelFile = diagramFile.getParent().getFile(new Path(diagramFile.getName().substring(0, diagramFile.getName().length() - MMINT.MID_DIAGRAM_SUFFIX.length())));
			files.add(diagramFile);
			files.add(modelFile);
		}
		KleisliAddModifyQueryCommand command = new KleisliAddModifyQueryCommand(
			TransactionUtil.getEditingDomain(element),
			"Constraint",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, null, null);
		}
		catch (ExecutionException ex) {
			MMINTException.print(Type.ERROR, "Add/modify kleisli query history execution error", ex);
		}
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
