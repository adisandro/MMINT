/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;

public class MIDContextRunOperatorListener extends MIDContextMenuListener {

	private Operator operatorType;
	private EList<OperatorInput> operatorInputs;
	private MID mid;

	public MIDContextRunOperatorListener(@NonNull String menuLabel, @NonNull Operator operatorType, @NonNull EList<OperatorInput> operatorInputs, @NonNull MID mid) {

		super(menuLabel);
		this.operatorType = operatorType;
		this.operatorInputs = operatorInputs;
		this.mid = mid;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MIDContextRunOperatorCommand(
			TransactionUtil.getEditingDomain(mid),
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
				Map<String, MID> outputMIDsByName = MIDOperatorIOUtils.createSameOutputMIDsByName(operatorType, mid);
				switch (mid.getLevel()) {
					case TYPES:
						throw new MMINTException("The TYPES level is not allowed");
					case INSTANCES:
					    String multipleDispatchPreference = null;
					    if (!(operatorType instanceof WorkflowOperator)) {
	                        // run with multiple dispatch disabled in case the operator is polymorphic on generics
	                        multipleDispatchPreference = MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_MULTIPLEDISPATCH_ENABLED);
	                        MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_MULTIPLEDISPATCH_ENABLED, "false");
					    }
						operatorType.startInstance(operatorInputs, null, operatorGenerics, outputMIDsByName, mid);
						WorkspaceSynchronizer.getFile(mid.eResource()).getParent().refreshLocal(IResource.DEPTH_ONE, monitor);
                        if (multipleDispatchPreference != null) {
                            // restore multiple dispatch preference
                            MMINT.setPreference(MMINTConstants.PREFERENCE_MENU_POLYMORPHISM_MULTIPLEDISPATCH_ENABLED, multipleDispatchPreference);
                        }
						break;
					case WORKFLOWS:
						operatorType.startWorkflowInstance(operatorInputs, operatorGenerics, mid);
						break;
					default:
						throw new MMINTException("The MID level is missing");
				}
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
