/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Implementation.
 *    Alessio Di Sandro - Generalization to all metamodels.
 */
package edu.toronto.cs.se.mmint.mavo;

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

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MAVOAlternativeHighlightMenuListener extends MIDContextMenuListener {

	private MAVOAlternative alternative;
	private Model model;

	public MAVOAlternativeHighlightMenuListener(String menuLabel, MAVOAlternative alternative) {

		super(menuLabel);
		this.alternative = alternative;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		//TODO MMINT[MU-MMINT] Unify with refinement
		String modelUri = MultiModelRegistry.getModelAndModelElementUris(alternative, MIDLevel.INSTANCES)[0];
		Map<MultiModel, List<IFile>> midDiagrams = MIDDiagramUtils.getMIDsInWorkspace();
		Model model = null;
		List<IFile> files = null;
		for (Entry<MultiModel, List<IFile>> entry: midDiagrams.entrySet()) {
			model = MultiModelRegistry.getExtendibleElement(modelUri, entry.getKey());
			if (model != null) {
				files = entry.getValue();
				break;
			}
		}
		if (model == null) {
			MMINTException.print(Type.ERROR, "The instance MID that contains this model must be open for the highlighting to work", null);
			return;
		}

		this.model = model;
		AbstractTransactionalCommand command;
		command = new HighlightAlternativeCommand(
			TransactionUtil.getEditingDomain(alternative),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class HighlightAlternativeCommand extends AbstractTransactionalCommand {

		public HighlightAlternativeCommand(TransactionalEditingDomain domain,
				String label, List affectedFiles) {
			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {

			Diagram modelDiagram = MultiModelRegistry.getModelDiagram(model);
			MAVOMultiModelConstraintChecker.highlightAlternative(modelDiagram, alternative);

			return CommandResult.newOKCommandResult();
		}

	}

}
