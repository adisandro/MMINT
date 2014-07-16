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
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOFactory;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;

public class MAVODecisionTreeMenuListener extends SelectionAdapter {

	Object container;
	Object element;
	Boolean createNew;

	public MAVODecisionTreeMenuListener(Object container) {
		this.container = container;
		this.createNew = true;
	}

	public MAVODecisionTreeMenuListener(Object container, Object element) {
		this.container = container;
		this.createNew = false;
		this.element = element;
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
		if (createNew) {
			operatorCommand = new CreateNewObjectCommand(
					TransactionUtil.getEditingDomain(container),
					"Add new object to container", files);
		} else {
			operatorCommand = new RemoveOldObjectCommand(
					TransactionUtil.getEditingDomain(container),
					"Remove object from container", files);
		}
		try {
			OperationHistoryFactory.getOperationHistory().execute(
					operatorCommand, null, null);
		} catch (ExecutionException ex) {
			MMINTException.print(Type.ERROR,
					"MAVODecisionTree menu history execution error", ex);
		}
	}

	protected class CreateNewObjectCommand extends AbstractTransactionalCommand {

		public CreateNewObjectCommand(TransactionalEditingDomain domain,
				String label, List affectedFiles) {
			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {

			if (container instanceof MAVOModel) {
				MAVOModel model = (MAVOModel) container;
				int decisionNum = model.getDecisions().size() + 1;
				MayDecision decision = MAVOFactory.eINSTANCE
						.createMayDecision();
				decision.setFormulaVariable("D" + decisionNum);
				model.getDecisions().add(decision);
			} else if (container instanceof MayDecision) {
				MayDecision decision = (MayDecision) container;
				int alternativeNum = decision.getAlternatives().size() + 1;
				MAVOAlternative alternative = MAVOFactory.eINSTANCE
						.createMAVOAlternative();
				alternative.setFormulaVariable(decision.getFormulaVariable()
						+ "A" + alternativeNum);
				decision.getAlternatives().add(alternative);
			}
			return CommandResult.newOKCommandResult();
		}

	}

	protected class RemoveOldObjectCommand extends AbstractTransactionalCommand {

		public RemoveOldObjectCommand(TransactionalEditingDomain domain,
				String label, List affectedFiles) {
			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			if (element == null) {
				return CommandResult.newCancelledCommandResult();
			}

			if ((container instanceof MAVOModel)
					&& (element instanceof MayDecision)) {
				MAVOModel model = (MAVOModel) container;
				model.getDecisions().remove(element);
			} else if ((container instanceof MayDecision)
					&& (element instanceof MAVOAlternative)) {
				MayDecision decision = (MayDecision) container;
				MAVOAlternative alternative = (MAVOAlternative) element;
				alternative.getMavoElements().clear();
				decision.getAlternatives().remove(element);
			} else if ((container instanceof MAVOAlternative)
					&& (element instanceof MAVOElement)) {
				MAVOAlternative alternative = (MAVOAlternative) container;
				MAVOElement mavoElement = (MAVOElement) element;
				alternative.getMavoElements().remove(element);
				if (mavoElement.getAlternatives().isEmpty()) {
					mavoElement.setMay(false);
				}
			}

			return CommandResult.newOKCommandResult();
		}

	}

}
