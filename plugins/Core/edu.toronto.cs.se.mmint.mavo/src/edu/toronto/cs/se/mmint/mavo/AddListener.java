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
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOFactory;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mavo.VarDecision;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class AddListener extends MIDContextMenuListener {

	private static final String MAVO_DECISION_FORMULA_PREFIX = "d";
	private static final String MAVO_ALTERNATIVE_FORMULA_PREFIX = "a";
	private static final String MAVO_DOMAIN_FORMULA_PREFIX = "d";

	private EObject decisionElemContainer;
	private EClass mavoDecisionType;

	public AddListener(String menuLabel, MAVOModel mavoRootModelObj, EClass mavoDecisionType) {

		super(menuLabel);
		decisionElemContainer = mavoRootModelObj;
		this.mavoDecisionType = mavoDecisionType;
	}

	public AddListener(String menuLabel, MAVODecision mavoDecision) {

		super(menuLabel);
		decisionElemContainer = mavoDecision;
		mavoDecisionType = null;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new AddCommand(
			TransactionUtil.getEditingDomain(decisionElemContainer),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class AddCommand extends AbstractTransactionalCommand {

		public AddCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			if (decisionElemContainer instanceof MAVOModel) {
				MAVOModel mavoRootModelObj = (MAVOModel) decisionElemContainer;
				MAVODecision mavoDecision = (MAVODecision) MAVOFactory.eINSTANCE.create(mavoDecisionType);
				mavoRootModelObj.getDecisions().add(mavoDecision);
				mavoDecision.setFormulaVariable(MAVO_DECISION_FORMULA_PREFIX + mavoRootModelObj.getDecisions().size());
			}
			else if (decisionElemContainer instanceof MAVODecision) {
				MAVODecision mavoDecision = (MAVODecision) decisionElemContainer;
				MAVOAlternative mavoSet = MAVOFactory.eINSTANCE.createMAVOAlternative();
				String suffix = "";
				if (decisionElemContainer instanceof MayDecision) {
					MayDecision mayDecision = (MayDecision) mavoDecision;
					mayDecision.getAlternatives().add(mavoSet);
					suffix = MAVO_ALTERNATIVE_FORMULA_PREFIX + mayDecision.getAlternatives().size();
				}
				else if (decisionElemContainer instanceof VarDecision) {
					VarDecision varDecision = (VarDecision) mavoDecision;
					varDecision.setDomain(mavoSet);
					suffix = MAVO_DOMAIN_FORMULA_PREFIX;
				}
				mavoSet.setFormulaVariable(mavoDecision.getFormulaVariable() + suffix);
			}

			return CommandResult.newOKCommandResult();
		}

	}

}
