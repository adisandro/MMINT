package edu.toronto.cs.se.modelepedia.safetycase.design.context;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCaseFactory;

public class DomainDecomposition extends AbstractExternalJavaAction {

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    if (arg0.size() != 1) {
      return false;
    }
    var modelObj = ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    if (modelObj instanceof Goal) {
      return true;
    }
    return false;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    var goal = (Goal) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
    var sSession = SessionManager.INSTANCE.getSession(goal);
    var sDomain = sSession.getTransactionalEditingDomain();
    sDomain.getCommandStack().execute(new DomainDecompositionCommand(sDomain, goal));
  }

  private class DomainDecompositionCommand extends RecordingCommand {
    private Goal decomposed;

    public DomainDecompositionCommand(TransactionalEditingDomain domain, Goal decomposed) {
      super(domain);
      this.decomposed = decomposed;
    }

    @Override
    protected void doExecute() {
      try {
        var gsnRootModelObj = (SafetyCase) this.decomposed.eContainer();
        var strDomains = MIDDialogs.getStringInput("Domain Decomposition", "Insert the number of domains", null);
        var numDomains = Integer.parseInt(strDomains);
        for (var i = 0; i < numDomains; i++) {
          var subgoal = SafetyCaseFactory.eINSTANCE.createBasicGoal();
          var support = SafetyCaseFactory.eINSTANCE.createSupportedBy();
          subgoal.setDescription(this.decomposed.getDescription());
          subgoal.setId(this.decomposed.getId() + "-" + i);
          subgoal.getSupports().add(support);
          this.decomposed.getSupportedBy().add(support);
          gsnRootModelObj.getGoals().add(subgoal);
        }
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
    }
  }
}
