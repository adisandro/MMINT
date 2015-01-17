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

import edu.toronto.cs.se.mavo.DecisionElement;
import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class RemoveListener extends MIDContextMenuListener {

	private DecisionElement decisionElemToRemove;

	public RemoveListener(String menuLabel, MAVODecision mavoDecision) {

		super(menuLabel);
		decisionElemToRemove = mavoDecision;
	}

	public RemoveListener(String menuLabel, MAVOAlternative mavoSet) {

		super(menuLabel);
		decisionElemToRemove = mavoSet;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new RemoveCommand(
			TransactionUtil.getEditingDomain(decisionElemToRemove),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class RemoveCommand extends AbstractTransactionalCommand {

		public RemoveCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		private void collectMAVOModelObjects (@NonNull DecisionElement decisionElem, @NonNull Set<MAVOElement> mavoModelObjs) {

			if (decisionElem instanceof MayDecision) {
				for (MAVOAlternative mavoAlternative : ((MayDecision) decisionElem).getAlternatives()) {
					collectMAVOModelObjects(mavoAlternative, mavoModelObjs);
				}
			}
			else if (decisionElem instanceof VarDecision) {
				collectMAVOModelObjects(((VarDecision) decisionElem).getDomain(), mavoModelObjs);
			}
			else if (decisionElem instanceof MAVOAlternative) {
				mavoModelObjs.addAll(((MAVOAlternative) decisionElem).getMavoElements());
			}
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			Set<MAVOElement> mavoModelObjs = new HashSet<MAVOElement>();
			collectMAVOModelObjects(decisionElemToRemove, mavoModelObjs);
			EClass eclass;
			EStructuralFeature feature;
			if (decisionElemToRemove instanceof MayDecision || decisionElemToRemove.eContainer() instanceof MayDecision) {
				eclass = MAVOPackage.eINSTANCE.getMayDecision();
				feature = MAVOPackage.eINSTANCE.getMAVOElement_May();
			}
			else if (decisionElemToRemove instanceof VarDecision || decisionElemToRemove.eContainer() instanceof VarDecision) {
				eclass = MAVOPackage.eINSTANCE.getVarDecision();
				feature = MAVOPackage.eINSTANCE.getMAVOElement_Var();
			}
			else {
				eclass = null;
				feature = null;
			}
			EcoreUtil.delete(decisionElemToRemove, true);
			mavoModelObjs.stream()
				.filter(mavoModelObj -> mavoModelObj.getAlternatives().stream()
					.allMatch(mavoSet -> !eclass.isInstance(mavoSet.eContainer()))
				)
				.forEach(mavoModelObj -> mavoModelObj.eSet(feature, false));
//			else if ((container instanceof MAVOAlternative)
//					&& (decisionElemToRemove instanceof MAVOElement)) {
//				MAVOAlternative alternative = (MAVOAlternative) container;
//				MAVOElement mavoElement = (MAVOElement) decisionElemToRemove;
//				alternative.getMavoElements().remove(decisionElemToRemove);
//				if (mavoElement.getAlternatives().isEmpty()) {
//					mavoElement.setMay(false);
//				}
//			}

			return CommandResult.newOKCommandResult();
		}

	}

}
