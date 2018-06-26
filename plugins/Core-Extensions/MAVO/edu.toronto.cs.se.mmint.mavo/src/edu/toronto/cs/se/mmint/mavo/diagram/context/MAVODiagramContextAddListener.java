/**
 * Copyright (c) 2012-2018 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOFactory;
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.SetDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.mavo.diagram.MAVODiagramEditor;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;

public class MAVODiagramContextAddListener extends MIDContextMenuListener {

	private static final String MAVO_DECISION_FORMULA_PREFIX = "d";
	private static final String MAY_ALTERNATIVE_FORMULA_PREFIX = "a";
	private static final String VAR_DOMAIN_FORMULA_PREFIX = "d";
	private static final String SET_ENTITY_FORMULA_PREFIX = "e";

	private EObject mavoContainer;
	private EClass mavoDecisionType;
	private List<MAVOElement> mavoModelObjs;

	public MAVODiagramContextAddListener(@NonNull String menuLabel, @NonNull MAVORoot mavoRootModelObj, @NonNull EClass mavoDecisionType) {

		super(menuLabel);
		mavoContainer = mavoRootModelObj;
		this.mavoDecisionType = mavoDecisionType;
		mavoModelObjs = null;
	}

	public MAVODiagramContextAddListener(@NonNull String menuLabel, @NonNull MAVODecision mavoDecision) {

		super(menuLabel);
		mavoContainer = mavoDecision;
		mavoDecisionType = null;
		mavoModelObjs = null;
	}

	public MAVODiagramContextAddListener(@NonNull String menuLabel, @NonNull MAVOCollection mavoCollection, @NonNull List<MAVOElement> mavoModelObjs) {

		super(menuLabel);
		mavoContainer = mavoCollection;
		mavoDecisionType = null;
		this.mavoModelObjs = mavoModelObjs;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MAVODiagramContextAddCommand(
			TransactionUtil.getEditingDomain(mavoContainer),
			menuLabel,
			MIDDiagramUtils.getActiveInstanceMIDFiles()
		);
		runListenerCommand(command);
	}

	protected class MAVODiagramContextAddCommand extends AbstractTransactionalCommand {

		public MAVODiagramContextAddCommand(@NonNull TransactionalEditingDomain domain, @NonNull String label, @NonNull List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			IStatus status = super.doUndo(monitor, info);
			// refresh
			MAVODiagramEditor mavoDiagram = (MAVODiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			mavoDiagram.getOutlinePage().refresh();

			return status;
		}

		@Override
		protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			IStatus status = super.doRedo(monitor, info);
			// refresh
			MAVODiagramEditor mavoDiagram = (MAVODiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			mavoDiagram.getOutlinePage().refresh();

			return status;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			if (mavoContainer instanceof MAVORoot) {
				MAVORoot mavoRootModelObj = (MAVORoot) mavoContainer;
				MAVODecision mavoDecision = (MAVODecision) MAVOFactory.eINSTANCE.create(mavoDecisionType);
				mavoRootModelObj.getDecisions().add(mavoDecision);
				mavoDecision.setFormulaVariable(MAVO_DECISION_FORMULA_PREFIX + mavoRootModelObj.getDecisions().size());
			}
			else if (mavoContainer instanceof MAVODecision) {
				MAVODecision mavoDecision = (MAVODecision) mavoContainer;
				MAVOCollection mavoCollection = MAVOFactory.eINSTANCE.createMAVOCollection();
				String suffix = "";
				if (mavoContainer instanceof MayDecision) {
					MayDecision mayDecision = (MayDecision) mavoDecision;
					mayDecision.getAlternatives().add(mavoCollection);
					suffix = MAY_ALTERNATIVE_FORMULA_PREFIX + mayDecision.getAlternatives().size();
				}
				else if (mavoContainer instanceof VarDecision) {
					VarDecision varDecision = (VarDecision) mavoDecision;
					varDecision.setDomain(mavoCollection);
					suffix = VAR_DOMAIN_FORMULA_PREFIX;
				}
				else if (mavoContainer instanceof SetDecision) {
					SetDecision setDecision = (SetDecision) mavoDecision;
					setDecision.setEntity(mavoCollection);
					suffix = SET_ENTITY_FORMULA_PREFIX;
				}
				mavoCollection.setFormulaVariable(mavoDecision.getFormulaVariable() + suffix);
			}
			else if (mavoContainer instanceof MAVOCollection) {
				((MAVOCollection) mavoContainer).getMavoElements().addAll(mavoModelObjs);
				if (mavoContainer.eContainer() instanceof MayDecision) {
					mavoModelObjs.forEach(mavoModelObj -> MAVOUtils.setMay(mavoModelObj, true));
				}
				else if (mavoContainer.eContainer() instanceof VarDecision) {
					mavoModelObjs.forEach(mavoModelObj -> MAVOUtils.setVar(mavoModelObj, true));
				}
				else if (mavoContainer.eContainer() instanceof SetDecision) {
					mavoModelObjs.forEach(mavoModelObj -> MAVOUtils.setSet(mavoModelObj, true));
				}
			}

			// refresh
			MAVODiagramEditor mavoDiagram = (MAVODiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			mavoDiagram.getOutlinePage().refresh();

			return CommandResult.newOKCommandResult();
		}

	}

}
