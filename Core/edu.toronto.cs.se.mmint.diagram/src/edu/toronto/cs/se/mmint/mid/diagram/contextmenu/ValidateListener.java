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
package edu.toronto.cs.se.mmint.mid.diagram.contextmenu;

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
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.part.ValidateAction;

public class ValidateListener extends SelectionAdapter {

	Model model;
	GraphicalEditPart editPart;

	public ValidateListener(Model model, GraphicalEditPart editPart) {

		this.model = model;
		this.editPart = editPart;
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
		AbstractTransactionalCommand operatorCommand = new ValidateCommand(
			TransactionUtil.getEditingDomain(model),
			"Validate",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(operatorCommand, null, null);
		}
		catch (ExecutionException ex) {
			MMINTException.print(Type.ERROR, "Validate history execution error", ex);
		}
	}

	protected class ValidateCommand extends AbstractTransactionalCommand {

		public ValidateCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			ValidateAction.runValidation((View) editPart.getModel());

			return CommandResult.newOKCommandResult();
		}

	}

}
