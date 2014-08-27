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
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.modelepedia.z3.reasoning.MAVORefinement;

public class RefinementListener extends SelectionAdapter{

	Model model;
	GraphicalEditPart editPart;
	boolean makeRefinement;
	
	public RefinementListener(Model model, GraphicalEditPart graphicalEditPart,
			boolean makeRefinement) {
		this.model = model;
		this.editPart = graphicalEditPart;
		/*TODO MMINT[MU-MMINT] makeRefinement originally intended to differentiate between a call to "preview" 
		 * and a call to "make refinement". However, I think "preview" should get its own listener that just
		 * highlights, possibly keeping a list of elements to be removed if a call to "make refinement" follows.
		 */
		this.makeRefinement = makeRefinement;
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
		AbstractTransactionalCommand operatorCommand = new RefinementCommand(
			TransactionUtil.getEditingDomain(model),
			"Refine",
			files
		);
		try {
			OperationHistoryFactory.getOperationHistory().execute(operatorCommand, null, null);
		}
		catch (ExecutionException ex) {
			MMINTException.print(Type.ERROR, "Refine history execution error", ex);
		}
	}
	
	protected class RefinementCommand extends AbstractTransactionalCommand {

		public RefinementCommand(TransactionalEditingDomain domain,
				String label, List<IFile> affectedFiles) {
			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			MAVORefinement refiner = new MAVORefinement(model);
			try {
				refiner.refine();
			} catch (Exception e) {
				e.printStackTrace();
				return CommandResult.newCancelledCommandResult();
			}
			return CommandResult.newOKCommandResult();
		}
		
	}

}
