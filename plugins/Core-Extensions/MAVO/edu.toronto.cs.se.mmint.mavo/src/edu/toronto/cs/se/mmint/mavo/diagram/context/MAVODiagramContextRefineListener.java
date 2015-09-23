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
import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;

public class MAVODiagramContextRefineListener extends MIDContextMenuListener {

	private List<? extends LogicElement> mavoElemsToRefine;
	private MAVOElement mergedModelObj;
	private List<MAVOElement> varModelObjs;
	private Model model;

	public MAVODiagramContextRefineListener(@NonNull String menuLabel, @NonNull MAVOCollection mayAlternative) {

		super(menuLabel);
		List<MAVOCollection> mavoElemsToRefine = new ArrayList<MAVOCollection>();
		mavoElemsToRefine.add(mayAlternative);
		this.mavoElemsToRefine = mavoElemsToRefine;
		mergedModelObj = null;
		varModelObjs = null;
		model = null;
	}

	public MAVODiagramContextRefineListener(@NonNull String menuLabel, @NonNull List<MAVOElement> mavoModelObjs) {

		super(menuLabel);
		mavoElemsToRefine = mavoModelObjs;
		mergedModelObj = null;
		varModelObjs = null;
		model = null;
	}

	public MAVODiagramContextRefineListener(@NonNull String menuLabel, @NonNull MAVOCollection varDomain, @NonNull MAVOElement mergedModelObj, @NonNull List<MAVOElement> varModelObjs) {

		super(menuLabel);
		List<MAVOCollection> mavoElemsToRefine = new ArrayList<MAVOCollection>();
		mavoElemsToRefine.add(varDomain);
		this.mavoElemsToRefine = mavoElemsToRefine;
		this.mergedModelObj = mergedModelObj;
		this.varModelObjs = varModelObjs;
		model = null;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		String modelUri = MultiModelRegistry.getModelAndModelElementUris(mavoElemsToRefine.get(0), MIDLevel.INSTANCES)[0];
		Map<MultiModel, List<IFile>> instanceMIDs = MIDDiagramUtils.getMIDsInWorkspace();
		List<IFile> files = null;
		for (Entry<MultiModel, List<IFile>> instanceMID : instanceMIDs.entrySet()) {
			model = MultiModelRegistry.getExtendibleElement(modelUri, instanceMID.getKey());
			if (model != null) {
				files = instanceMID.getValue();
				break;
			}
		}
		if (model == null) {
			MMINTException.print(IStatus.ERROR, "The instance MID that contains this model must be open for the refinement to work", null);
			return;
		}

		AbstractTransactionalCommand command = new MAVODiagramContextRefineCommand(
			TransactionUtil.getEditingDomain(model),
			menuLabel,
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

			LogicElement mavoFirstElemToRefine = mavoElemsToRefine.get(0);
			if (mavoFirstElemToRefine instanceof MAVOCollection) {
				if (mavoFirstElemToRefine.eContainer() instanceof MayDecision) {
					MAVOMultiModelConstraintChecker.refineByMayAlternative(model, (MAVOCollection) mavoFirstElemToRefine);
				}
				if (mavoFirstElemToRefine.eContainer() instanceof VarDecision) {
					MAVOMultiModelConstraintChecker.refineByVarDomain(model, (MAVOCollection) mavoFirstElemToRefine, mergedModelObj, varModelObjs);
				}
			}
			else if (mavoFirstElemToRefine instanceof MAVOElement) {
				MAVOMultiModelConstraintChecker.refineByMayModelObjects(model, (List<MAVOElement>) mavoElemsToRefine);
			}

			return CommandResult.newOKCommandResult();
		}

	}

}
