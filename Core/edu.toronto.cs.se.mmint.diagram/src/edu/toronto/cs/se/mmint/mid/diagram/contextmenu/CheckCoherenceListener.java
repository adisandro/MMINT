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
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.ConversionOperator;

public class CheckCoherenceListener extends SelectionAdapter {

	Model model;
	Set<List<ConversionOperator>> conversionPaths;

	public CheckCoherenceListener(Model model, Set<List<ConversionOperator>> conversionPaths) {

		this.model = model;
		this.conversionPaths = conversionPaths;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		IFile diagramFile = (IFile) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getEditorInput().getAdapter(IFile.class);
		if (diagramFile != null) {
			IFile modelFile = diagramFile.getParent().getFile(new Path(diagramFile.getName().substring(0, diagramFile.getName().length() - MMINT.MID_DIAGRAM_SUFFIX.length())));
			files.add(diagramFile);
			files.add(modelFile);
		}
		AbstractTransactionalCommand operatorCommand = new CheckCoherenceCommand(
			TransactionUtil.getEditingDomain(model),
			"Check Coherence",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(operatorCommand, null, null);
		}
		catch (ExecutionException ex) {
			MMINTException.print(Type.WARNING, "Check coherence history execution error", ex);
		}
	}

	protected class CheckCoherenceCommand extends AbstractTransactionalCommand {

		public CheckCoherenceCommand(TransactionalEditingDomain domain, String label, List<IFile> affectedFiles) {

			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

			try {
				// create results for each conversion path
				List<Model> coherentModels = new ArrayList<Model>(), coherentModels2 = new ArrayList<Model>();
				for (List<ConversionOperator> conversionPath : conversionPaths) {
					Model newActualParameter = model;
					for (ConversionOperator conversionOperatorType : conversionPath) {
						EList<Model> actualParameters = new BasicEList<Model>();
						actualParameters.add(newActualParameter);
						newActualParameter = conversionOperatorType.execute(actualParameters).get(0);
					}
					coherentModels.add(newActualParameter);
					coherentModels2.add(newActualParameter);
				}
				// do model compare
coherence:
				for (int i = 0; i < coherentModels.size(); i++) {
					for (int j = i + 1; j < coherentModels2.size(); j++) {
						ResourceSet resourceSet = new ResourceSetImpl();
						resourceSet.getResource(URI.createPlatformResourceURI(coherentModels.get(i).getUri(), true), true);
						ResourceSet resourceSet2 = new ResourceSetImpl();
						resourceSet2.getResource(URI.createPlatformResourceURI(coherentModels2.get(j).getUri(), true), true);
						IComparisonScope scope = EMFCompare.createDefaultScope(resourceSet, resourceSet2);
						Comparison comparison = EMFCompare.builder().build().compare(scope);
						if (!comparison.getDifferences().isEmpty()) {
							MMINTException.print(Type.ERROR, "Your type system is not coherent", new MMINTException("The following conversion paths yield different results: " + conversionPaths));
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
				MMINTException.print(Type.WARNING, "Coherence check execution error", e);
				return CommandResult.newErrorCommandResult("Coherence check execution error");
			}
		}

	}

}
