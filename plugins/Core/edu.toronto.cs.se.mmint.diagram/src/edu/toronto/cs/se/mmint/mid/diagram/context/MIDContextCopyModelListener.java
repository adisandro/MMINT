/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.context;

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
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MultiModelDiagramUtils;

public class MIDContextCopyModelListener extends MIDContextMenuListener {

	private Model oldModel;

	public MIDContextCopyModelListener(String menuLabel, Model oldModel) {

		super(menuLabel);
		this.oldModel = oldModel;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MIDContextCopyCommand(
			TransactionUtil.getEditingDomain(oldModel),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class MIDContextCopyCommand extends AbstractTransactionalCommand {

		public MIDContextCopyCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			try {
				String newModelName = MultiModelDiagramUtils.getStringInput(menuLabel, "Insert new model name", oldModel.getName());
				MultiModel multiModel = MultiModelRegistry.getMultiModel(oldModel);
				Model newModel = oldModel.getMetatype().copyMAVOInstanceAndEditor(oldModel, newModelName, true, multiModel);
	
				return CommandResult.newOKCommandResult(newModel);
			}
			catch (Exception e) {
				MMINTException.print(Type.ERROR, "No model copied", e);
				return CommandResult.newErrorCommandResult("No model copied");
			}
		}

	}

}
