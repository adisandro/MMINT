package edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part;

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
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.MAVODecisionTreeMenuListener.CreateNewObjectCommand;
import edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.MAVODecisionTreeMenuListener.RemoveOldObjectCommand;

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

		public HighlightAlternativeCommand(TransactionalEditingDomain domain,
				String label, List affectedFiles) {
			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			for (MAVOElement mavoElement: alternative.getMavoElements()){
				
			}
			return CommandResult.newOKCommandResult();
		}
		
	}

}
