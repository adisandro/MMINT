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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorPackage;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.mmint.repository.MMINTConstants;

public class MIDContextRunOperatorListener extends MIDContextMenuListener {

	private MultiModel instanceMID;
	private Operator operator;
	private EList<Model> inputModels;
	private Map<Integer, EList<ConversionOperator>> conversions;

	public MIDContextRunOperatorListener(@NonNull String menuLabel, @NonNull MultiModel instanceMID, @NonNull Operator operator, @NonNull EList<Model> inputModels, @NonNull Map<Integer, EList<ConversionOperator>> conversions) {

		super(menuLabel);
		this.instanceMID = instanceMID;
		this.operator = operator;
		this.inputModels = inputModels;
		this.conversions = conversions;
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
				//TODO MMINT[OPERATOR] is conversions ordered?? I don't think so
				// run all conversion operators
				if (!conversions.isEmpty()) {
					for (Entry<Integer, EList<ConversionOperator>> entry : conversions.entrySet()) {
						int i = entry.getKey();
						List<ConversionOperator> conversionList = entry.getValue();
						Model newActualParameter = inputModels.get(i);
						for (ConversionOperator operator : conversionList) {
							EList<Model> operatorParameters = new BasicEList<Model>();
							operatorParameters.add(newActualParameter);
							Properties inputProperties = operator.getInputProperties();
							operator.readInputProperties(inputProperties);
							operator.init();
							newActualParameter = operator.execute(operatorParameters).get(0);
						}
						inputModels.set(i, newActualParameter);
					}
				}
				// run operator
				Properties inputProperties = operator.getInputProperties();
				operator.readInputProperties(inputProperties);
				operator.init();
				EList<Model> outputModels = operator.execute(inputModels);
				if (Boolean.parseBoolean(MMINT.getPreference(MMINTConstants.PREFERENCE_MENU_OPERATORS_ENABLED))) {
					//TODO MMINT[OPERATOR] Remove if when operator instances are always created
					if (!operator.getGenerics().isEmpty()) {
						Operator operatorType = operator.getMetatype();
						for (int i = 0; i < operatorType.getOutputs().size(); i++) {
							ModelEndpoint outputModelTypeEndpoint = operatorType.getOutputs().get(i);
							outputModelTypeEndpoint.createInstance(outputModels.get(i), operator, OperatorPackage.eINSTANCE.getOperator_Outputs().getName());
						}
					}
					instanceMID.getOperators().add(operator);
				}
				// cleanup all conversion operators
				if (!conversions.isEmpty()) {
					for (Entry<Integer, EList<ConversionOperator>> entry : conversions.entrySet()) {
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
