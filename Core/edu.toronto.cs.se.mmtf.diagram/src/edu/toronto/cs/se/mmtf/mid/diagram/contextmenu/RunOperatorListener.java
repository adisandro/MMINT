/*
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
package edu.toronto.cs.se.mmtf.mid.diagram.contextmenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MMTFException.Type;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperatorExecutable;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;

public class RunOperatorListener extends SelectionAdapter {

	Operator operator;
	EList<Model> actualParameters;
	Map<Integer, List<ConversionOperator>> conversionMap;

	public RunOperatorListener(Operator operator, EList<Model> actualParameters, Map<Integer, List<ConversionOperator>> conversionMap) {

		this.operator = operator;
		this.actualParameters = actualParameters;
		this.conversionMap = conversionMap;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		IFile diagramFile = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
		if (diagramFile != null) {
			IFile modelFile = diagramFile.getParent().getFile(new Path(diagramFile.getName().substring(0, diagramFile.getName().length() - MMTF.MID_DIAGRAM_SUFFIX.length())));
			files.add(diagramFile);
			files.add(modelFile);
		}
		AbstractTransactionalCommand operatorCommand = new RunOperatorCommand(
			TransactionUtil.getEditingDomain(actualParameters.get(0)),
			"Run operator",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(operatorCommand, null, null);
		}
		catch (ExecutionException ex) {
			MMTFException.print(Type.WARNING, "Operator " + operator.getName() + " history execution error", ex);
		}
	}

	protected class RunOperatorCommand extends AbstractTransactionalCommand {

		public RunOperatorCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			try {
				//TODO MMTF: is conversionMap ordered?? I don't think so
				// run all conversion operators
				if (!conversionMap.isEmpty()) {
					for (Entry<Integer, List<ConversionOperator>> entry : conversionMap.entrySet()) {
						int i = entry.getKey();
						List<ConversionOperator> conversionList = entry.getValue();
						Model newActualParameter = actualParameters.get(i);
						for (ConversionOperator operator : conversionList) {
							EList<Model> operatorParameters = new BasicEList<Model>();
							operatorParameters.add(newActualParameter);
							newActualParameter = operator.getExecutable().execute(operatorParameters).get(0);
						}
						actualParameters.set(i, newActualParameter);
					}
				}
				// run operator
				operator.getExecutable().execute(actualParameters);
				// cleanup all conversion operators
				if (!conversionMap.isEmpty()) {
					for (Entry<Integer, List<ConversionOperator>> entry : conversionMap.entrySet()) {
						for (ConversionOperator operator : entry.getValue()) {
							((ConversionOperatorExecutable) operator.getExecutable()).cleanup();
						}
					}
				}

				return CommandResult.newOKCommandResult();
			}
			catch (Exception e) {
				MMTFException.print(Type.WARNING, "Operator " + operator.getName() + " execution error", e);
				return CommandResult.newErrorCommandResult("Operator " + operator.getName() + " execution error");
			}
		}

	}

}
