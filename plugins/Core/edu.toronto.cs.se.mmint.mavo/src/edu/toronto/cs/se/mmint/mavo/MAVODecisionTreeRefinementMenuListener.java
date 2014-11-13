package edu.toronto.cs.se.mmint.mavo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOAlternative;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOModel;
import edu.toronto.cs.se.mavo.MayDecision;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MMINTException.Type;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;

public class MAVODecisionTreeRefinementMenuListener extends SelectionAdapter {

	Object[] objects;
	MultiModel instanceMid;
	Model model;
	
	public MAVODecisionTreeRefinementMenuListener(Object[] objects){
		this.objects = objects;

	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {

		String uri = MultiModelRegistry.getModelAndModelElementUris((LogicElement) objects[0], MIDLevel.INSTANCES)[0];
		Map<MultiModel, List<IFile>> midDiagrams = MIDDiagramUtils.getMIDsInWorkspace();
		Model model = null;
		List<IFile> files = null;
		for (Entry<MultiModel, List<IFile>> entry: midDiagrams.entrySet()){
			model = MultiModelRegistry.getExtendibleElement(uri, entry.getKey());
			if (model != null){
				files = entry.getValue();
				break;
			}
		}
		
		this.model = model;
		AbstractTransactionalCommand operatorCommand;
		operatorCommand = new RefineModelCommand(
				TransactionUtil.getEditingDomain(model),
				"Refine model from decision tree", files);

		try {
			OperationHistoryFactory.getOperationHistory().execute(
					operatorCommand, null, null);
		} catch (ExecutionException ex) {
			MMINTException.print(Type.ERROR,
					"MAVODecisionTree menu history execution error", ex);
		}
	}
	
	
	protected class RefineModelCommand extends AbstractTransactionalCommand {

		public RefineModelCommand(TransactionalEditingDomain domain,
				String label, List affectedFiles) {
			super(domain, label, affectedFiles);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			ArrayList<LogicElement> selectedElements = new ArrayList<LogicElement>();
			for (Object object: objects){
				//skip useless elements
				if (object instanceof MAVOModel || object instanceof MayDecision){
					continue;
				}
				if (object instanceof MAVOAlternative || object instanceof MAVOElement){
					selectedElements.add((LogicElement) object);
				}
					
			}
			String property = calculateProperty(selectedElements);
			

			
			ExtendibleElementConstraint constraint = model.getConstraint();
			String current = constraint.getImplementation();
			String newConstraint = "(and "+current+" "+property+")";
			constraint.setImplementation(newConstraint);
			
			MultiModelConstraintChecker.refineByConstraint(model);
			
			return CommandResult.newOKCommandResult();
		}

		private String calculateProperty(
				ArrayList<LogicElement> selectedElements) {
			String property = "(and ";
			if (selectedElements.size() == 1){
				return selectedElements.get(0).getFormulaVariable();
			}
			for (LogicElement element: selectedElements){
				property += element.getFormulaVariable()+" ";
			}
			property += ")";
			return property;
		}

	}
}
