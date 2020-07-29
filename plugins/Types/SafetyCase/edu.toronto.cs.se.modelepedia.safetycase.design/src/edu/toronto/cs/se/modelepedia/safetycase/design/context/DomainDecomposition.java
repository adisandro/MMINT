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
        var factory = SafetyCaseFactory.eINSTANCE;
        // domain decomposition strategy
        var strategy = factory.createBasicStrategy();
        strategy.setId("S-" + this.decomposed.getId());
        strategy.setDescription(this.decomposed.getDescription());
        gsnRootModelObj.getStrategies().add(strategy);
        var support = factory.createSupportedBy();
        support.setSource(this.decomposed);
        support.setTarget(strategy);
        // justification
        var justification = factory.createJustification();
        justification.setId("J-" + this.decomposed.getId());
        justification.setDescription(this.decomposed.getDescription());
        gsnRootModelObj.getJustifications().add(justification);
        var context = factory.createInContextOf();
        context.setContextOf(this.decomposed);
        context.setContext(justification);
        // domain subgoals
        for (var i = 0; i < numDomains; i++) {
          var subgoal = factory.createBasicGoal();
          subgoal.setId(this.decomposed.getId() + "-" + i);
          subgoal.setDescription(this.decomposed.getDescription());
          gsnRootModelObj.getGoals().add(subgoal);
          support = factory.createSupportedBy();
          support.setSource(strategy);
          support.setTarget(subgoal);
        }
        // completeness goal
        var completeness = factory.createBasicGoal();
        completeness.setId(this.decomposed.getId() + "-C");
        completeness.setDescription(this.decomposed.getDescription());
        gsnRootModelObj.getGoals().add(completeness);
        support = factory.createSupportedBy();
        support.setSource(strategy);
        support.setTarget(completeness);
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
    }
  }
}
