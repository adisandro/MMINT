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
import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class RemoveListener extends MIDContextMenuListener {

	private LogicElement mavoElemToRemove;
	private MAVOAlternative mavoGroupWhenRemovingMavoModelObj;

	public RemoveListener(@NonNull String menuLabel, @NonNull MAVODecision mavoDecision) {

		super(menuLabel);
		mavoElemToRemove = mavoDecision;
		mavoGroupWhenRemovingMavoModelObj = null;
	}

	public RemoveListener(@NonNull String menuLabel, @NonNull MAVOAlternative mavoSet) {

		super(menuLabel);
		mavoElemToRemove = mavoSet;
		mavoGroupWhenRemovingMavoModelObj = null;
	}

	public RemoveListener(@NonNull String menuLabel, @NonNull MAVOAlternative mavoGroup, @NonNull MAVOElement mavoModelObj) {

		super(menuLabel);
		mavoElemToRemove = mavoModelObj;
		mavoGroupWhenRemovingMavoModelObj = mavoGroup;
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
				for (MAVOAlternative mavoAlternative : ((MayDecision) mavoElemToRemove).getAlternatives()) {
					collectMAVOModelObjects(mavoAlternative, mavoModelObjs);
				}
			}
			else if (mavoElemToRemove instanceof VarDecision) {
				collectMAVOModelObjects(((VarDecision) mavoElemToRemove).getDomain(), mavoModelObjs);
			}
			else if (mavoElemToRemove instanceof MAVOAlternative) {
				mavoModelObjs.addAll(((MAVOAlternative) mavoElemToRemove).getMavoElements());
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
					mavoGroupWhenRemovingMavoModelObj != null &&
					mavoGroupWhenRemovingMavoModelObj.eContainer() instanceof MayDecision
				)
			) {
				eclass = MAVOPackage.eINSTANCE.getMayDecision();
				feature = MAVOPackage.eINSTANCE.getMAVOElement_May();
			}
			else if (
				mavoElemToRemove instanceof VarDecision ||
				mavoElemToRemove.eContainer() instanceof VarDecision ||
				(
					mavoGroupWhenRemovingMavoModelObj != null &&
					mavoGroupWhenRemovingMavoModelObj.eContainer() instanceof VarDecision
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
			if (mavoGroupWhenRemovingMavoModelObj == null) {
				EcoreUtil.delete(mavoElemToRemove, true);
			}
			else {
				mavoGroupWhenRemovingMavoModelObj.getMavoElements().remove(mavoElemToRemove);
			}
			mavoModelObjs.stream()
				.filter(mavoModelObj -> mavoModelObj.getAlternatives().stream()
					.allMatch(mavoSet -> !eclass.isInstance(mavoSet.eContainer()))
				)
				.forEach(mavoModelObj -> mavoModelObj.eSet(feature, false));

			return CommandResult.newOKCommandResult();
		}

	}

}
