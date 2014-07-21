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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

//TODO MMINT[MU-MMINT] change name to reflect removal from alternative as well.
public class MAVOAddToAlternativeListener extends SelectionAdapter {

	List<MAVOElement> mavoElements;
	MAVOAlternative mavoAlternative;
	boolean add;

	public MAVOAddToAlternativeListener(List<MAVOElement> mavoElements, MAVOAlternative mavoAlternative, boolean add) {

		this.mavoElements = mavoElements;
		this.mavoAlternative = mavoAlternative;
		this.add = add;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		IFile diagramFile = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
		if (diagramFile != null) {
			IFile modelFile = diagramFile.getParent().getFile(new Path(diagramFile.getName().substring(0, diagramFile.getName().length() - GMFDiagramUtils.DIAGRAM_SUFFIX.length())));
			files.add(diagramFile);
			files.add(modelFile);
		}
		AbstractTransactionalCommand operatorCommand;
		String label;
		if (add){
			label = "Add to Alternative";
		}
		else{
			label = "Remove from Alternative";
		}
		operatorCommand = new AddToAlternativeCommand(
				TransactionUtil.getEditingDomain(mavoElements.get(0)),
				label,
				files
			);
		try {
			OperationHistoryFactory.getOperationHistory().execute(operatorCommand, null, null);
		}
		catch (ExecutionException ex) {
			MMINTException.print(Type.ERROR, "Add to Alternative history execution error", ex);
		}
	}

	//TODO MMINT[MU-MMINT] change name to reflect removal from alternative as well.
	protected class AddToAlternativeCommand extends AbstractTransactionalCommand {

		public AddToAlternativeCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			if (add){
				mavoAlternative.getMavoElements().addAll(mavoElements);
				for (MAVOElement mavoElement : mavoElements) {
					MAVOUtils.setMay(mavoElement, true);
				}
			}
			else{
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
