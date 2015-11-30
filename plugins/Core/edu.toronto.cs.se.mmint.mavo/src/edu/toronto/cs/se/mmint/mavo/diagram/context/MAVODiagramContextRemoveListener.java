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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.SetDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.mavo.diagram.MAVODiagramEditor;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;

public class MAVODiagramContextRemoveListener extends MIDContextMenuListener {

	private List<? extends LogicElement> mavoElemsToRemove;
	private MAVOCollection mavoCollectionWhenRemovingMavoModelObjs;

	public MAVODiagramContextRemoveListener(@NonNull String menuLabel, @NonNull MAVODecision mavoDecision) {

		super(menuLabel);
		List<MAVODecision> mavoElemsToRemove = new ArrayList<MAVODecision>();
		mavoElemsToRemove.add(mavoDecision);
		this.mavoElemsToRemove = mavoElemsToRemove;
		mavoCollectionWhenRemovingMavoModelObjs = null;
	}

	public MAVODiagramContextRemoveListener(@NonNull String menuLabel, @NonNull MAVOCollection mavoCollection) {

		super(menuLabel);
		List<MAVOCollection> mavoElemsToRemove = new ArrayList<MAVOCollection>();
		mavoElemsToRemove.add(mavoCollection);
		this.mavoElemsToRemove = mavoElemsToRemove;
		mavoCollectionWhenRemovingMavoModelObjs = null;
	}

	public MAVODiagramContextRemoveListener(@NonNull String menuLabel, @NonNull MAVOCollection mavoCollection, @NonNull List<MAVOElement> mavoModelObjs) {

		super(menuLabel);
		mavoElemsToRemove = mavoModelObjs;
		mavoCollectionWhenRemovingMavoModelObjs = mavoCollection;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MAVODiagramContextRemoveCommand(
			TransactionUtil.getEditingDomain(mavoElemsToRemove.get(0)),
			menuLabel,
			MIDDiagramUtils.getActiveInstanceMIDFiles()
		);
		runListenerCommand(command);
	}

	protected class MAVODiagramContextRemoveCommand extends AbstractTransactionalCommand {

		public MAVODiagramContextRemoveCommand(@NonNull TransactionalEditingDomain domain, @NonNull String label, @NonNull List<IFile> affectedFiles) {

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

		private void collectMAVOModelObjects (@NonNull LogicElement mavoElemToRemove, @NonNull Set<MAVOElement> mavoModelObjs) {

			if (mavoElemToRemove instanceof MayDecision) {
				for (MAVOCollection mayAlternative : ((MayDecision) mavoElemToRemove).getAlternatives()) {
					collectMAVOModelObjects(mayAlternative, mavoModelObjs);
				}
			}
			else if (mavoElemToRemove instanceof VarDecision) {
				collectMAVOModelObjects(((VarDecision) mavoElemToRemove).getDomain(), mavoModelObjs);
			}
			else if (mavoElemToRemove instanceof SetDecision) {
				collectMAVOModelObjects(((SetDecision) mavoElemToRemove).getEntity(), mavoModelObjs);
			}
			else if (mavoElemToRemove instanceof MAVOCollection) {
				mavoModelObjs.addAll(((MAVOCollection) mavoElemToRemove).getMavoElements());
			}
			else if (mavoElemToRemove instanceof MAVOElement) {
				mavoModelObjs.add((MAVOElement) mavoElemToRemove);
			}
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			// collect info
			Set<MAVOElement> mavoModelObjs = new HashSet<MAVOElement>();
			mavoElemsToRemove.forEach(mavoElemToRemove -> collectMAVOModelObjects(mavoElemToRemove, mavoModelObjs));
			LogicElement mavoFirstElemToRemove = mavoElemsToRemove.get(0);
			EClass eclass;
			EStructuralFeature feature;
			if (
				mavoFirstElemToRemove instanceof MayDecision ||
				mavoFirstElemToRemove.eContainer() instanceof MayDecision ||
				(
					mavoCollectionWhenRemovingMavoModelObjs != null &&
					mavoCollectionWhenRemovingMavoModelObjs.eContainer() instanceof MayDecision
				)
			) {
				eclass = MAVOPackage.eINSTANCE.getMayDecision();
				feature = MAVOPackage.eINSTANCE.getMAVOElement_May();
			}
			else if (
				mavoFirstElemToRemove instanceof VarDecision ||
				mavoFirstElemToRemove.eContainer() instanceof VarDecision ||
				(
					mavoCollectionWhenRemovingMavoModelObjs != null &&
					mavoCollectionWhenRemovingMavoModelObjs.eContainer() instanceof VarDecision
				)
			) {
				eclass = MAVOPackage.eINSTANCE.getVarDecision();
				feature = MAVOPackage.eINSTANCE.getMAVOElement_Var();
			}
			else if (
					mavoFirstElemToRemove instanceof SetDecision ||
					mavoFirstElemToRemove.eContainer() instanceof SetDecision ||
					(
						mavoCollectionWhenRemovingMavoModelObjs != null &&
						mavoCollectionWhenRemovingMavoModelObjs.eContainer() instanceof SetDecision
					)
				) {
					eclass = MAVOPackage.eINSTANCE.getSetDecision();
					feature = MAVOPackage.eINSTANCE.getMAVOElement_Set();
				}
			else {
				eclass = null;
				feature = null;
			}

			// remove
			if (mavoCollectionWhenRemovingMavoModelObjs == null) {
				EcoreUtil.delete(mavoFirstElemToRemove, true);
			}
			else {
				mavoCollectionWhenRemovingMavoModelObjs.getMavoElements().removeAll(mavoElemsToRemove);
			}
			// depending on the removal performed, set May/Var/Set to false for each collected MAVO model object
			// that is now not used by any May alternatives or Var domains or Set entities
			mavoModelObjs.stream()
				.filter(mavoModelObj -> mavoModelObj.getCollections().stream()
					.allMatch(mavoCollection -> !eclass.isInstance(mavoCollection.eContainer()))
				)
				.forEach(mavoModelObj -> mavoModelObj.eSet(feature, false));

			// refresh
			MAVODiagramEditor mavoDiagram = (MAVODiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			mavoDiagram.getOutlinePage().refresh();

			return CommandResult.newOKCommandResult();
		}

	}

}
