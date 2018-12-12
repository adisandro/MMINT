/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.Node;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.diagram.part.Messages;
import edu.toronto.cs.se.mmint.mid.operator.Operator;

/**
 * The command to open an operator editor.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class OperatorOpenEditorCommand extends AbstractTransactionalCommand {

	/** The hint about the editor to open. */
	private final HintedDiagramLinkStyle editorFacet;

	/**
	 * Constructor: initialises the superclass and the editor hint.
	 * 
	 * @param linkStyle
	 *            The hint about the editor to open.
	 */
	public OperatorOpenEditorCommand(HintedDiagramLinkStyle linkStyle) {

		super(TransactionUtil.getEditingDomain(linkStyle), Messages.CommandName_OpenDiagram, null);
		editorFacet = linkStyle;
	}

	protected void doExecuteTypesLevel(Operator operatorType) throws Exception {

		// only the operators in the type registry have their implementation attached
		Operator operatorTypeImpl = MIDTypeRegistry.getType(operatorType.getUri());
		if (operatorTypeImpl != null) {
			operatorTypeImpl.openType();
		}
	}

	protected void doExecuteInstancesLevel(Operator operator) throws Exception {

		operator.openInstance();
	}

	protected void doExecuteWorkflowsLevel(Operator operator) throws Exception {

		operator.openWorkflowInstance();
	}

	/**
	 * Opens the editor associated with a model.
	 * 
	 * @param monitor
	 *            The progress monitor.
	 * @param info
	 *            Additional parameter, not used.
	 * @return The ok result, or the error result if the editor could not be
	 *         opened.
	 * @throws ExecutionException
	 *             Never thrown.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		try {
			Operator operator = (Operator) ((Node) editorFacet.eContainer()).getElement();
			switch (operator.getLevel()) {
				case TYPES:
					this.doExecuteTypesLevel(operator);
					break;
				case INSTANCES:
					this.doExecuteInstancesLevel(operator);
					break;
				case WORKFLOWS:
					this.doExecuteWorkflowsLevel(operator);
					break;
				default:
					throw new MMINTException("The MID level is missing");
			}

			return CommandResult.newOKCommandResult();
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "No editor associated", e);
			return CommandResult.newErrorCommandResult("No editor associated");
		}
	}

}
