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
package edu.toronto.cs.se.mmint.mavo.diagram.outline.context;

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
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;

public class MAVODiagramOutlineContextRefineListener extends MIDContextMenuListener {

	private LogicElement mavoElemToRefine;
	private Model model;

	public MAVODiagramOutlineContextRefineListener(String menuLabel, MAVOCollection mayAlternative) {

		super(menuLabel);
		mavoElemToRefine = mayAlternative;
		model = null;
	}

	public MAVODiagramOutlineContextRefineListener(String menuLabel, MAVOElement mavoModelObj) {

		super(menuLabel);
		mavoElemToRefine = mavoModelObj;
		model = null;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		String modelUri = MultiModelRegistry.getModelAndModelElementUris(mavoElemToRefine, MIDLevel.INSTANCES)[0];
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
			MMINTException.print(Type.ERROR, "The instance MID that contains this model must be open for the refinement to work", null);
			return;
		}

		AbstractTransactionalCommand command = new MAVODiagramOutlineContextRefineCommand(
			TransactionUtil.getEditingDomain(model),
			menuLabel,
			files
		);
		runListenerCommand(command);
	}

	protected class MAVODiagramOutlineContextRefineCommand extends AbstractTransactionalCommand {

		public MAVODiagramOutlineContextRefineCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			if (mavoElemToRefine instanceof MAVOCollection) {
				MAVOMultiModelConstraintChecker.refineByMayAlternative(model, (MAVOCollection) mavoElemToRefine);
			}
			else if (mavoElemToRefine instanceof MAVOElement) {
				MAVOMultiModelConstraintChecker.refineByMayModelObject(model, (MAVOElement) mavoElemToRefine);
			}

			return CommandResult.newOKCommandResult();
		}

	}

}