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
import org.eclipse.gmf.runtime.notation.View;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.part.Messages;

/**
 * The command to open a model editor.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class ModelOpenEditorCommand extends AbstractTransactionalCommand {

	/** The hint about the editor to open. */
	private final HintedDiagramLinkStyle editorFacet;

	/**
	 * Constructor: initialises the superclass and the editor hint.
	 * 
	 * @param linkStyle
	 *            The hint about the editor to open.
	 */
	public ModelOpenEditorCommand(HintedDiagramLinkStyle linkStyle) {

		super(TransactionUtil.getEditingDomain(linkStyle), Messages.CommandName_OpenDiagram, null);
		editorFacet = linkStyle;
	}

	protected void doExecuteTypesLevel(Model modelType) throws Exception {

		modelType.openType();
	}

	protected void doExecuteInstancesLevel(Model model) throws Exception {

		model.openInstance();
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
			Model model = (Model) ((View) editorFacet.eContainer()).getElement();
			switch (model.getLevel()) {
				case TYPES:
					this.doExecuteTypesLevel(model);
					break;
				case INSTANCES:
					this.doExecuteInstancesLevel(model);
					break;
				case WORKFLOWS:
					// do nothing
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
