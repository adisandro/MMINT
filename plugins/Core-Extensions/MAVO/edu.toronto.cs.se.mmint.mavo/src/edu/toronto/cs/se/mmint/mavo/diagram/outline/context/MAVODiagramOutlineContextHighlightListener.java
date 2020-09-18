/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
package edu.toronto.cs.se.mmint.mavo.diagram.outline.context;

import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOTrait;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class MAVODiagramOutlineContextHighlightListener extends MIDContextMenuListener {

	private LogicElement mavoElemToHighlight;
	private Model model;

	public MAVODiagramOutlineContextHighlightListener(@NonNull String menuLabel, @NonNull MAVODecision mavoDecision) {

		super(menuLabel);
		this.mavoElemToHighlight = mavoDecision;
		this.model = null;
	}

	public MAVODiagramOutlineContextHighlightListener(@NonNull String menuLabel, @NonNull MAVOCollection mavoCollection) {

		super(menuLabel);
		this.mavoElemToHighlight = mavoCollection;
		this.model = null;
	}

	public MAVODiagramOutlineContextHighlightListener(@NonNull String menuLabel, @NonNull MAVOElement mavoModelObj) {

		super(menuLabel);
		this.mavoElemToHighlight = mavoModelObj;
		this.model = null;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		String modelUri = MIDRegistry.getModelUri(this.mavoElemToHighlight);
		Map<MID, List<IFile>> instanceMIDs = MIDDiagramUtils.getInstanceMIDsInWorkspace();
		for (MID instanceMID : instanceMIDs.keySet()) {
			this.model = instanceMID.getExtendibleElement(modelUri);
			if (this.model != null) {
				break;
			}
		}
		if (this.model == null) {
			MMINTException.print(IStatus.ERROR, "The instance MID that contains this model must be open for the highlighting to work", null);
			return;
		}

		AbstractTransactionalCommand command;
		command = new MAVODiagramOutlineContextHighlightCommand(
			TransactionUtil.getEditingDomain(this.mavoElemToHighlight),
			this.menuLabel,
			MIDDiagramUtils.getActiveInstanceMIDFiles()
		);
		runListenerCommand(command);
	}

	protected class MAVODiagramOutlineContextHighlightCommand extends AbstractTransactionalCommand {

		public MAVODiagramOutlineContextHighlightCommand(@NonNull TransactionalEditingDomain domain, @NonNull String label, @NonNull List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

      try {
        var reasoner = MIDDialogs.selectReasoner(IMAVOTrait.class, "MAVO highlighting");
        Diagram modelDiagram = MIDRegistry.getModelDiagram(MAVODiagramOutlineContextHighlightListener.this.model);
        if (MAVODiagramOutlineContextHighlightListener.this.mavoElemToHighlight instanceof MAVODecision) {
          reasoner.highlightMAVODecision(modelDiagram, (MAVODecision) MAVODiagramOutlineContextHighlightListener.this.mavoElemToHighlight);
        }
        else if (MAVODiagramOutlineContextHighlightListener.this.mavoElemToHighlight instanceof MAVOCollection) {
          reasoner.highlightMAVOCollection(modelDiagram, (MAVOCollection) MAVODiagramOutlineContextHighlightListener.this.mavoElemToHighlight);
        }
        else if (MAVODiagramOutlineContextHighlightListener.this.mavoElemToHighlight instanceof MAVOElement) {
          reasoner.highlightMAVOElement(modelDiagram, (MAVOElement) MAVODiagramOutlineContextHighlightListener.this.mavoElemToHighlight);
        }
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
