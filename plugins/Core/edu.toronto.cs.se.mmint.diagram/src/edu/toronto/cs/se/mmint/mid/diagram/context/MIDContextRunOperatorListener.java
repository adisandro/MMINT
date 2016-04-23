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
package edu.toronto.cs.se.mmint.mid.diagram.context;

import java.util.List;
import java.util.Map;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.library.MIDOperatorUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;

public class MIDContextRunOperatorListener extends MIDContextMenuListener {

	private Operator operatorType;
	private EList<OperatorInput> operatorInputs;
	private MID instanceMID;

	public MIDContextRunOperatorListener(@NonNull String menuLabel, @NonNull Operator operatorType, @NonNull EList<OperatorInput> operatorInputs, @NonNull MID instanceMID) {

		super(menuLabel);
		this.operatorType = operatorType;
		this.operatorInputs = operatorInputs;
		this.instanceMID = instanceMID;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MIDContextRunOperatorCommand(
			TransactionUtil.getEditingDomain(instanceMID),
			menuLabel,
			MIDDiagramUtils.getActiveInstanceMIDFiles()
		);
		runListenerCommand(command);
	}

	protected class MIDContextRunOperatorCommand extends AbstractTransactionalCommand {

		public MIDContextRunOperatorCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			try {
				EList<OperatorGeneric> operatorGenerics = operatorType.selectAllowedGenerics(operatorInputs);
				Map<String, MID> outputMIDsByName = MIDOperatorUtils.createSimpleOutputMIDsByName(operatorType, instanceMID);
				operatorType.start(operatorInputs, null, operatorGenerics, outputMIDsByName, instanceMID);
				WorkspaceSynchronizer.getFile(instanceMID.eResource()).getParent().refreshLocal(IResource.DEPTH_ONE, monitor);
				return CommandResult.newOKCommandResult();
			}
			catch (MIDDialogCancellation e) {
				return CommandResult.newCancelledCommandResult();
			}
			catch (Exception e) {
				MMINTException.print(IStatus.ERROR, "Operator " + operatorType.getName() + " execution error", e);
				return CommandResult.newErrorCommandResult("Operator " + operatorType.getName() + " execution error");
			}
		}

	}

}
