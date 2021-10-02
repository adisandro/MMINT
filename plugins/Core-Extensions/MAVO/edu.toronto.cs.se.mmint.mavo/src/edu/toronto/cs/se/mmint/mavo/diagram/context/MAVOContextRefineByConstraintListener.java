/**
 * Copyright (c) 2012-2021 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Naama Ben-David - Implementation.
 */
package edu.toronto.cs.se.mmint.mavo.diagram.context;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOTrait;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;

public class MAVOContextRefineByConstraintListener extends MIDContextMenuListener {

	private Model model;

	public MAVOContextRefineByConstraintListener(String menuLabel, Model model) {

		super(menuLabel);
		this.model = model;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MIDContextRefineByConstraintCommand(
			TransactionUtil.getEditingDomain(this.model),
			this.menuLabel,
			MIDDiagramUtils.getActiveInstanceMIDFiles()
		);
		runListenerCommand(command);
	}

	protected class MIDContextRefineByConstraintCommand extends AbstractTransactionalCommand {

		public MIDContextRefineByConstraintCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		  try {
        var reasoner = MIDDialogs.selectReasoner(IMAVOTrait.class, "MAVO refinement", null);
        reasoner.refineModelByConstraint(MAVOContextRefineByConstraintListener.this.model);
        return CommandResult.newOKCommandResult();
      }
		  catch (MIDDialogCancellation e) {
		    return CommandResult.newCancelledCommandResult();
		  }
      catch (MMINTException e) {
        return CommandResult.newErrorCommandResult(e);
      }
		}

	}
}
