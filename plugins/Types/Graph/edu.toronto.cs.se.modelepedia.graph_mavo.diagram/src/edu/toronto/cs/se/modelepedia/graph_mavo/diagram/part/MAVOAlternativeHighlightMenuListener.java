/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Naama Ben-David - Implementation.
 */
package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MAVOAlternativeHighlightMenuListener extends SelectionAdapter {

	private MAVOAlternative alternative;
	
	public MAVOAlternativeHighlightMenuListener(MAVOAlternative alternative){
		this.alternative = alternative;
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {

		List<IFile> files = new ArrayList<IFile>();
		IFile diagramFile = (IFile) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor()
				.getEditorInput().getAdapter(IFile.class);
		if (diagramFile != null) {
			IFile modelFile = diagramFile.getParent()
					.getFile(
							new Path(diagramFile.getName().substring(
									0,
									diagramFile.getName().length()
											- GMFDiagramUtils.DIAGRAM_SUFFIX
													.length())));
			files.add(diagramFile);
			files.add(modelFile);
		}
		AbstractTransactionalCommand operatorCommand;
		operatorCommand = new HighlightAlternativeCommand(
				TransactionUtil.getEditingDomain(alternative),
				"Highlight alternative", files);
		try {
			OperationHistoryFactory.getOperationHistory().execute(
					operatorCommand, null, null);
		} catch (ExecutionException ex) {
			MMINTException.print(Type.ERROR,
					"Highlighting alternative history execution error", ex);
		}
	}
	
	protected class HighlightAlternativeCommand extends AbstractTransactionalCommand{
		
		private static final int HIGHLIGHT_COLOR = 0x00FFFF;
		private static final int FONT_HIGHLIGHT_COLOR = 0x000000;
		private static final int GREYOUT_COLOR = 0xF4F4F4;
		private static final int FONT_GREYOUT_COLOR = 0xD0D0D0;
		private static final String EXAMPLE_SUFFIX = "_example";
		private static final String DIAGRAM_ID = "edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorID";
		private String diagramURI;
		private String newDiagramURI;

		public HighlightAlternativeCommand(TransactionalEditingDomain domain,
				String label, List affectedFiles) {
			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			Diagram diag;
			try{
				diag = getDiagram(alternative);
			}
			catch (Exception e){
				return CommandResult.newCancelledCommandResult();
			}
			List<View> diagramElements = new ArrayList<View>();
			diagramElements.addAll(diag.getChildren());
			diagramElements.addAll(diag.getEdges());
			for (View diagElement: diagramElements){
				MAVOElement modelElement = (MAVOElement) diagElement.getElement();
				for (MAVOAlternative alt: modelElement.getAlternatives()){
					if (alt.getFormulaVariable().equals(alternative.getFormulaVariable())){
						try {
							GMFDiagramUtils.colorDiagramElement(diagElement, HIGHLIGHT_COLOR, FONT_HIGHLIGHT_COLOR);
						}
						catch (MMINTException e) {
							MMINTException.print(Type.WARNING, "Skipping highliting of " + modelElement.getFormulaVariable(), e);
						}
						break;
					}
					else {
						if (((MayDecision) alt.eContainer()).getFormulaVariable().equals(((MayDecision) alternative.eContainer()).getFormulaVariable())){
							try {
								GMFDiagramUtils.colorDiagramElement(diagElement, GREYOUT_COLOR, FONT_GREYOUT_COLOR);
							}
							catch (MMINTException e) {
								MMINTException.print(Type.WARNING, "Skipping highliting of " + modelElement.getFormulaVariable(), e);
							}
						}
					}
				}
			}
			
			//Write diagram to file
			try {
				MultiModelUtils.createModelFile(diag, newDiagramURI, true);
				GMFDiagramUtils.openGMFDiagram(newDiagramURI, DIAGRAM_ID, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return CommandResult.newOKCommandResult();
		}
		
		private Diagram getDiagram(MAVOAlternative alternative) throws MMINTException{
			EObject model = alternative;
			while (!(model instanceof MAVOModel)){
				model = model.eContainer();
			}
			MAVOModel graphModel = (MAVOModel) model;
			URI platformURI = graphModel.eResource().getURI();
			String modelURI = platformURI.toPlatformString(false);
			diagramURI = MultiModelUtils.replaceFileExtensionInUri(
					modelURI,
					"graphdiag_mavo"
				);
			
			newDiagramURI = MultiModelUtils.addFileNameSuffixInUri(diagramURI, EXAMPLE_SUFFIX);

			try {
				MultiModelUtils.copyTextFileAndReplaceText(diagramURI, newDiagramURI, "", "", true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			Diagram d;
			try{
				d = (Diagram) MultiModelUtils.getModelFile(newDiagramURI, true);
			} catch (Exception e) {
				throw new MMINTException("There is no diagram!", e);
			}
			return d;
		}
		
	}

}
