/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Initial implementation.
 *    Alessio Di Sandro - Refactoring and fixes.
 */
package edu.toronto.cs.se.mmint.mavo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class HighlightListener extends MIDContextMenuListener {

	private LogicElement mavoElemToHighlight;
	private Model model;

	public HighlightListener(String menuLabel, MAVODecision mavoDecision) {

		super(menuLabel);
		mavoElemToHighlight = mavoDecision;
	}

	public HighlightListener(String menuLabel, MAVOCollection mavoCollection) {

		super(menuLabel);
		mavoElemToHighlight = mavoCollection;
	}

	public HighlightListener(String menuLabel, MAVOElement mavoModelObj) {

		super(menuLabel);
		mavoElemToHighlight = mavoModelObj;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		//TODO MMINT[MU-MMINT] Unify with refinement
		String modelUri = MultiModelRegistry.getModelAndModelElementUris(mavoElemToHighlight, MIDLevel.INSTANCES)[0];
		Map<MultiModel, List<IFile>> midDiagrams = MIDDiagramUtils.getMIDsInWorkspace();
		Model model = null;
		List<IFile> files = null;
		for (Entry<MultiModel, List<IFile>> entry: midDiagrams.entrySet()) {
			model = MultiModelRegistry.getExtendibleElement(modelUri, entry.getKey());
			if (model != null) {
				files = entry.getValue();
				break;
			}
		}
		if (model == null) {
			MMINTException.print(Type.ERROR, "The instance MID that contains this model must be open for the highlighting to work", null);
			return;
		}

		this.model = model;
		AbstractTransactionalCommand command;
		command = new HighlightCommand(
			TransactionUtil.getEditingDomain(mavoElemToHighlight),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class HighlightCommand extends AbstractTransactionalCommand {

		public HighlightCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			Diagram modelDiagram = MultiModelRegistry.getModelDiagram(model);
			if (mavoElemToHighlight instanceof MAVODecision) {
				MAVOMultiModelConstraintChecker.highlightMAVODecision(modelDiagram, (MAVODecision) mavoElemToHighlight);
			}
			else if (mavoElemToHighlight instanceof MAVOCollection) {
				MAVOMultiModelConstraintChecker.highlightMAVOCollection(modelDiagram, (MAVOCollection) mavoElemToHighlight);
			}
			else if (mavoElemToHighlight instanceof MAVOElement) {
				MAVOMultiModelConstraintChecker.highlightMAVOElement(modelDiagram, (MAVOElement) mavoElemToHighlight);
			}

			return CommandResult.newOKCommandResult();
		}

	}

}
