/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.part.MIDDiagramEditor;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

//TODO MMINT[MU-MMINT] change name to reflect removal from alternative as well.
public class MAVOAddToAlternativeListener extends MIDContextMenuListener {

	List<MAVOElement> mavoElements;
	MAVOAlternative mavoAlternative;
	boolean add;

	public MAVOAddToAlternativeListener(String menuLabel, List<MAVOElement> mavoElements, MAVOAlternative mavoAlternative, boolean add) {

		super(menuLabel);
		this.mavoElements = mavoElements;
		this.mavoAlternative = mavoAlternative;
		this.add = add;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new AddToAlternativeCommand(
			TransactionUtil.getEditingDomain(mavoElements.get(0)),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	//TODO MMINT[MU-MMINT] change name to reflect removal from alternative as well.
	protected class AddToAlternativeCommand extends AbstractTransactionalCommand {

		public AddToAlternativeCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			if (add) {
				mavoAlternative.getMavoElements().addAll(mavoElements);
				for (MAVOElement mavoElement : mavoElements) {
					MAVOUtils.setMay(mavoElement, true);
				}
			}
			else {
				mavoAlternative.getMavoElements().removeAll(mavoElements);
				for (MAVOElement mavoElement : mavoElements) {
					if (mavoElement.getAlternatives().isEmpty()) {
						MAVOUtils.setMay(mavoElement, false);
					}
				}
			}

			return CommandResult.newOKCommandResult();
		}

	}

}
