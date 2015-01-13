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

import java.util.ArrayList;
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

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;

public class MAVODecisionTreeRefinementMenuListener extends MIDContextMenuListener {

	private Object[] objects;
	private Model model;

	public MAVODecisionTreeRefinementMenuListener(String menuLabel, Object[] objects){

		super(menuLabel);
		this.objects = objects;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		//TODO MMINT[MU-MMINT] Unify with highlighting
		String modelUri = MultiModelRegistry.getModelAndModelElementUris((LogicElement) objects[0], MIDLevel.INSTANCES)[0];
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
			MMINTException.print(Type.ERROR, "The instance MID that contains this model must be open for the refinement to work", null);
			return;
		}

		this.model = model;
		AbstractTransactionalCommand command = new RefineModelCommand(
			TransactionUtil.getEditingDomain(model),
			menuLabel,
			files
		);
		runListenerCommand(command);
	}

	protected class RefineModelCommand extends AbstractTransactionalCommand {

		public RefineModelCommand(TransactionalEditingDomain domain, String label, List affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			ArrayList<LogicElement> selectedElements = new ArrayList<LogicElement>();
			for (Object object: objects) {
				//skip useless elements
				if (object instanceof MAVOModel || object instanceof MayDecision) {
					continue;
				}
				//TODO MMINT[MU-MMINT] use for mavo elements too with command from diagram MAVO context menu
				if (object instanceof LogicElement){
					selectedElements.add((LogicElement) object);
				}
			}

			MAVOMultiModelConstraintChecker.refineByDecision(model, (MAVOAlternative) selectedElements.get(0));

			return CommandResult.newOKCommandResult();
		}

	}

}
