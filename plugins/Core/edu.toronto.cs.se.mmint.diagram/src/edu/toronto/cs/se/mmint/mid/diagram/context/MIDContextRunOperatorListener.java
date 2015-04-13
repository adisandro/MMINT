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
package edu.toronto.cs.se.mmint.mid.diagram.context;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MIDContextRunOperatorListener extends MIDContextMenuListener {

	private MultiModel instanceMID;
	private Operator operator;
	private EList<Model> actualParameters;
	private Map<Integer, EList<ConversionOperator>> conversionMap;

	public MIDContextRunOperatorListener(String menuLabel, MultiModel instanceMid, Operator operator, EList<Model> actualParameters, Map<Integer, EList<ConversionOperator>> conversionMap) {

		super(menuLabel);
		this.instanceMID = instanceMid;
		this.operator = operator;
		this.actualParameters = actualParameters;
		this.conversionMap = conversionMap;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MIDContextRunOperatorCommand(
			TransactionUtil.getEditingDomain(instanceMID),
			menuLabel,
			GMFDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class MIDContextRunOperatorCommand extends AbstractTransactionalCommand {

		public MIDContextRunOperatorCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			try {
				//TODO MMINT[OPERATOR] add the operator instance to the instanceMID, depending on global settings
				//TODO MMINT[OPERATOR] it would be more efficient to create an operator only here, but it's hard
				//TODO MMINT[OPERATOR] is conversionMap ordered?? I don't think so
				// run all conversion operators
				if (!conversionMap.isEmpty()) {
					for (Entry<Integer, EList<ConversionOperator>> entry : conversionMap.entrySet()) {
						int i = entry.getKey();
						List<ConversionOperator> conversionList = entry.getValue();
						Model newActualParameter = actualParameters.get(i);
						for (ConversionOperator operator : conversionList) {
							EList<Model> operatorParameters = new BasicEList<Model>();
							operatorParameters.add(newActualParameter);
							Properties inputProperties = operator.getInputProperties();
							operator.readInputProperties(inputProperties);
							operator.init();
							newActualParameter = operator.execute(operatorParameters).get(0);
						}
						actualParameters.set(i, newActualParameter);
					}
				}
				// run operator
				Properties inputProperties = operator.getInputProperties();
				operator.readInputProperties(inputProperties);
				operator.init();
				operator.execute(actualParameters);
				// cleanup all conversion operators
				if (!conversionMap.isEmpty()) {
					for (Entry<Integer, EList<ConversionOperator>> entry : conversionMap.entrySet()) {
						for (ConversionOperator operator : entry.getValue()) {
							((ConversionOperator) operator).cleanup();
						}
					}
				}

				return CommandResult.newOKCommandResult();
			}
			catch (Exception e) {
				MMINTException.print(IStatus.ERROR, "Operator " + operator.getName() + " execution error", e);
				return CommandResult.newErrorCommandResult("Operator " + operator.getName() + " execution error");
			}
		}

	}

}
