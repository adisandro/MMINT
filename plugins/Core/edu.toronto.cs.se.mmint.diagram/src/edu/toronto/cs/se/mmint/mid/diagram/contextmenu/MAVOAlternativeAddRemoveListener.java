/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.contextmenu;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MAVOAlternativeAddRemoveListener extends MIDContextMenuListener {

	List<MAVOElement> mavoModelObjs;
	MAVOCollection mavoAlternative;
	boolean add;

	public MAVOAlternativeAddRemoveListener(String menuLabel, List<MAVOElement> mavoElements, MAVOCollection mavoAlternative, boolean add) {

		super(menuLabel);
		this.mavoModelObjs = mavoElements;
		this.mavoAlternative = mavoAlternative;
		this.add = add;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MAVOAlternativeAddRemoveCommand(
			TransactionUtil.getEditingDomain(mavoModelObjs.get(0)),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class MAVOAlternativeAddRemoveCommand extends AbstractTransactionalCommand {

		public MAVOAlternativeAddRemoveCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			if (add) {
				mavoAlternative.getMavoElements().addAll(mavoModelObjs);
				for (MAVOElement mavoElement : mavoModelObjs) {
					MAVOUtils.setMay(mavoElement, true);
				}
			}
			else {
				mavoAlternative.getMavoElements().removeAll(mavoModelObjs);
				for (MAVOElement mavoElement : mavoModelObjs) {
					if (mavoElement.getCollections().isEmpty()) {
						MAVOUtils.setMay(mavoElement, false);
					}
				}
			}

			return CommandResult.newOKCommandResult();
		}

	}

}
