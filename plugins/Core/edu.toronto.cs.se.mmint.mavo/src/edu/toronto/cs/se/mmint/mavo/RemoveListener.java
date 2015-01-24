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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class RemoveListener extends MIDContextMenuListener {

	private LogicElement mavoElemToRemove;
	private MAVOCollection mavoCollectionWhenRemovingMavoModelObj;

	public RemoveListener(@NonNull String menuLabel, @NonNull MAVODecision mavoDecision) {

		super(menuLabel);
		mavoElemToRemove = mavoDecision;
		mavoCollectionWhenRemovingMavoModelObj = null;
	}

	public RemoveListener(@NonNull String menuLabel, @NonNull MAVOCollection mavoCollection) {

		super(menuLabel);
		mavoElemToRemove = mavoCollection;
		mavoCollectionWhenRemovingMavoModelObj = null;
	}

	public RemoveListener(@NonNull String menuLabel, @NonNull MAVOCollection mavoCollection, @NonNull MAVOElement mavoModelObj) {

		super(menuLabel);
		mavoElemToRemove = mavoModelObj;
		mavoCollectionWhenRemovingMavoModelObj = mavoCollection;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new RemoveCommand(
			TransactionUtil.getEditingDomain(mavoElemToRemove),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class RemoveCommand extends AbstractTransactionalCommand {

		public RemoveCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
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
			collectMAVOModelObjects(mavoElemToRemove, mavoModelObjs);
			EClass eclass;
			EStructuralFeature feature;
			if (
				mavoElemToRemove instanceof MayDecision ||
				mavoElemToRemove.eContainer() instanceof MayDecision ||
				(
					mavoCollectionWhenRemovingMavoModelObj != null &&
					mavoCollectionWhenRemovingMavoModelObj.eContainer() instanceof MayDecision
				)
			) {
				eclass = MAVOPackage.eINSTANCE.getMayDecision();
				feature = MAVOPackage.eINSTANCE.getMAVOElement_May();
			}
			else if (
				mavoElemToRemove instanceof VarDecision ||
				mavoElemToRemove.eContainer() instanceof VarDecision ||
				(
					mavoCollectionWhenRemovingMavoModelObj != null &&
					mavoCollectionWhenRemovingMavoModelObj.eContainer() instanceof VarDecision
				)
			) {
				eclass = MAVOPackage.eINSTANCE.getVarDecision();
				feature = MAVOPackage.eINSTANCE.getMAVOElement_Var();
			}
			else {
				eclass = null;
				feature = null;
			}

			// remove
			if (mavoCollectionWhenRemovingMavoModelObj == null) {
				EcoreUtil.delete(mavoElemToRemove, true);
			}
			else {
				mavoCollectionWhenRemovingMavoModelObj.getMavoElements().remove(mavoElemToRemove);
			}
			// depending on the removal performed, set May or Var to false for each collected MAVO model object
			// that is now not used by any May alternatives or Var domains
			mavoModelObjs.stream()
				.filter(mavoModelObj -> mavoModelObj.getCollections().stream()
					.allMatch(mavoCollection -> !eclass.isInstance(mavoCollection.eContainer()))
				)
				.forEach(mavoModelObj -> mavoModelObj.eSet(feature, false));

			return CommandResult.newOKCommandResult();
		}

	}

}
