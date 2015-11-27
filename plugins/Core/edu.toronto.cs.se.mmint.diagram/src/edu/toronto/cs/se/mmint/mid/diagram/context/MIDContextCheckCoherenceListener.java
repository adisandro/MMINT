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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDContextMenuListener;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;

public class MIDContextCheckCoherenceListener extends MIDContextMenuListener {

	private Model model;
	private Set<List<ConversionOperator>> conversionPaths;

	public MIDContextCheckCoherenceListener(String menuLabel, Model model, Set<List<ConversionOperator>> conversionPaths) {

		super(menuLabel);
		this.model = model;
		this.conversionPaths = conversionPaths;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		AbstractTransactionalCommand command = new MIDContextCheckCoherenceCommand(
			TransactionUtil.getEditingDomain(model),
			menuLabel,
			MIDDiagramUtils.getTransactionalCommandAffectedFiles()
		);
		runListenerCommand(command);
	}

	protected class MIDContextCheckCoherenceCommand extends AbstractTransactionalCommand {

		public MIDContextCheckCoherenceCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			try {
				// create results for each conversion path
				MultiModel instanceMID = MultiModelRegistry.getMultiModel(model);
				List<Model> coherentModels = new ArrayList<Model>(), coherentModels2 = new ArrayList<Model>();
				for (List<ConversionOperator> conversionPath : conversionPaths) {
					Model inputModel = model;
					for (ConversionOperator convOperatorType : conversionPath) {
						EList<Model> inputModels = new BasicEList<>();
						inputModels.add(inputModel);
						EList<OperatorInput> inputs = convOperatorType.checkAllowedInputs(inputModels);
						EList<OperatorGeneric> generics = convOperatorType.selectAllowedGenerics(inputs);
						Map<String, MultiModel> outputMIDsByName = new HashMap<>();
						String convOutputName = convOperatorType.getOutputs().get(0).getName();
						outputMIDsByName.put(convOutputName, instanceMID);
						Map<String, Model> outputsByName = convOperatorType.start(inputs, null, generics, outputMIDsByName, null).getOutputsByName();
						inputModel = outputsByName.get(convOutputName);
					}
					coherentModels.add(inputModel);
					coherentModels2.add(inputModel);
				}
				// do model compare
coherence:
				for (int i = 0; i < coherentModels.size(); i++) {
					for (int j = i + 1; j < coherentModels2.size(); j++) {
						ResourceSet resourceSet = new ResourceSetImpl();
						resourceSet.getResource(URI.createPlatformResourceURI(coherentModels.get(i).getUri(), true), true);
						ResourceSet resourceSet2 = new ResourceSetImpl();
						resourceSet2.getResource(URI.createPlatformResourceURI(coherentModels2.get(j).getUri(), true), true);
						IComparisonScope scope = new DefaultComparisonScope(resourceSet, resourceSet2, null);
						Comparison comparison = EMFCompare.builder().build().compare(scope);
						if (!comparison.getDifferences().isEmpty()) {
							MMINTException.print(IStatus.ERROR, "The type system is not coherent", new MMINTException("The following conversion paths yield different results: " + conversionPaths));
							break coherence;
						}
					}
				}
				// cleanup
				for (List<ConversionOperator> conversionPath : conversionPaths) {
					for (ConversionOperator conversionOperatorType : conversionPath) {
						conversionOperatorType.cleanup();
					}
				}

				return CommandResult.newOKCommandResult();
			}
			catch (Exception e) {
				MMINTException.print(IStatus.ERROR, "Coherence check execution error", e);
				return CommandResult.newErrorCommandResult("Coherence check execution error");
			}
		}

	}

}
