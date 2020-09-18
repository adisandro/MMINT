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
package edu.toronto.cs.se.mmint.mavo.diagram.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOTrait;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class MAVODiagramContextRefineListener extends MIDContextMenuListener {

	private List<? extends LogicElement> mavoElemsToRefine;
	private MAVOElement mergedModelObj;
	private List<MAVOElement> varModelObjs;
	private Model model;

	public MAVODiagramContextRefineListener(@NonNull String menuLabel, @NonNull MAVOCollection mayAlternative) {

		super(menuLabel);
		List<MAVOCollection> mavoElemsToRefine = new ArrayList<>();
		mavoElemsToRefine.add(mayAlternative);
		this.mavoElemsToRefine = mavoElemsToRefine;
		this.mergedModelObj = null;
		this.varModelObjs = null;
		this.model = null;
	}

	public MAVODiagramContextRefineListener(@NonNull String menuLabel, @NonNull List<MAVOElement> mavoModelObjs) {

		super(menuLabel);
		this.mavoElemsToRefine = mavoModelObjs;
		this.mergedModelObj = null;
		this.varModelObjs = null;
		this.model = null;
	}

	public MAVODiagramContextRefineListener(@NonNull String menuLabel, @NonNull MAVOCollection varDomain, @NonNull MAVOElement mergedModelObj, @NonNull List<MAVOElement> varModelObjs) {

		super(menuLabel);
		List<MAVOCollection> mavoElemsToRefine = new ArrayList<>();
		mavoElemsToRefine.add(varDomain);
		this.mavoElemsToRefine = mavoElemsToRefine;
		this.mergedModelObj = mergedModelObj;
		this.varModelObjs = varModelObjs;
		this.model = null;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		String modelUri = MIDRegistry.getModelUri(this.mavoElemsToRefine.get(0));
		Map<MID, List<IFile>> instanceMIDs = MIDDiagramUtils.getInstanceMIDsInWorkspace();
		List<IFile> files = null;
		for (Entry<MID, List<IFile>> instanceMID : instanceMIDs.entrySet()) {
			this.model = instanceMID.getKey().getExtendibleElement(modelUri);
			if (this.model != null) {
				files = instanceMID.getValue();
				break;
			}
		}
		if (this.model == null) {
			MMINTException.print(IStatus.ERROR, "The instance MID that contains this model must be open for the refinement to work", null);
			return;
		}

		AbstractTransactionalCommand command = new MAVODiagramContextRefineCommand(
			TransactionUtil.getEditingDomain(this.model),
			this.menuLabel,
			files
		);
		runListenerCommand(command);
	}

	protected class MAVODiagramContextRefineCommand extends AbstractTransactionalCommand {

		public MAVODiagramContextRefineCommand(@NonNull TransactionalEditingDomain domain, @NonNull String label, @NonNull List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

      try {
        var reasoner = MIDDialogs.selectReasoner(IMAVOTrait.class, "mavo refinement");
        var mavoFirstElemToRefine = MAVODiagramContextRefineListener.this.mavoElemsToRefine.get(0);
        if (mavoFirstElemToRefine instanceof MAVOCollection) {
          if (mavoFirstElemToRefine.eContainer() instanceof MayDecision) {
            reasoner.refineModelByMayAlternative(MAVODiagramContextRefineListener.this.model, (MAVOCollection) mavoFirstElemToRefine);
          }
          if (mavoFirstElemToRefine.eContainer() instanceof VarDecision) {
            reasoner.refineModelByVarDomain(MAVODiagramContextRefineListener.this.model, (MAVOCollection) mavoFirstElemToRefine, MAVODiagramContextRefineListener.this.mergedModelObj, MAVODiagramContextRefineListener.this.varModelObjs);
          }
        }
        else if (mavoFirstElemToRefine instanceof MAVOElement) {
          reasoner.refineModelByMayModelObjects(MAVODiagramContextRefineListener.this.model, (List<MAVOElement>) MAVODiagramContextRefineListener.this.mavoElemsToRefine);
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
