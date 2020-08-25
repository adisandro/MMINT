package edu.toronto.cs.se.modelepedia.safetycase.design.context;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.DomainGoal;
import edu.toronto.cs.se.modelepedia.safetycase.GSNFactory;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.Justification;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;

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
    private SafetyCase gsnRootModelObj;
    private GSNFactory factory;

    public DomainDecompositionCommand(TransactionalEditingDomain domain, Goal decomposed) {
      super(domain);
      this.decomposed = decomposed;
      this.gsnRootModelObj = (SafetyCase) this.decomposed.eContainer();
      this.factory = GSNFactory.eINSTANCE;
    }

    private void addArgumentElement(ArgumentElement argument, String id, String description) {
      argument.setId(id);
      argument.setDescription(description);
    }

    private void addSupporter(Supportable supportable, Supporter supporter) {
      var support = this.factory.createSupportedBy();
      support.setSource(supportable);
      support.setTarget(supporter);
    }

    private void addContext(DecomposableCoreElement decomposable, ContextualElement contextual) {
      var context = this.factory.createInContextOf();
      context.setContextOf(decomposable);
      context.setContext(contextual);
    }

    private Strategy createStrategy(Supportable supportable, String id, String description) {
      var strategy = this.factory.createBasicStrategy();
      addArgumentElement(strategy, id, description);
      addSupporter(supportable, strategy);
      this.gsnRootModelObj.getStrategies().add(strategy);

      return strategy;
    }

    private DomainGoal createDomainGoal(Supportable supportable, String id, String description, String domain) {
      var goal = this.factory.createDomainGoal();
      addArgumentElement(goal, id, description);
      addSupporter(supportable, goal);
      goal.setDomain(domain);
      this.gsnRootModelObj.getGoals().add(goal);

      return goal;
    }

    private Justification createJustification(String id, String description) {
      var justification = this.factory.createJustification();
      addArgumentElement(justification, id, description);
      addContext(this.decomposed, justification);
      this.gsnRootModelObj.getJustifications().add(justification);

      return justification;
    }

    private void parseNumericDomain(String domain) throws MMINTException {
      /* range a_b:
       *  1) a < b
       *  2) two tokens only, separated by _
       *  3) parsable number tokens, stripped of spaces
       */
    }

    private Set<String> parseEnumDomain(String domain) throws MMINTException {
      var entries = domain.split(",");
      if (entries.length == 1) {
        throw new MMINTException("Bad enumeration domain format");
      }
      var enumDomain = new HashSet<String>();
      for (var entry : entries) {
        if (entry.isBlank()) {
          continue;
        }
        enumDomain.add(entry.strip());
      }

      return enumDomain;
    }

    private boolean checkDomainDecomposition() {
      /* range a_b:
       *  order all domains, then check for absence of holes or overlap
       * enumeration a,b,c:
       *  check that all exist
       */
      return true;
    }

    @Override
    protected void doExecute() {
      try {
        /**
         * 1) ask domain
         * 2) check domain syntax
         * 3) ask or derive number of subdomains
         * 4) ask each subdomain
         * 5a) check subdomains consistence with domain
         * 5b) allow subdomain check outside of construction
         * 6a) add all relevant items and text
         * 6b) add manual creation tool for DomainGoal in sirius diagram
         */
        var title = "Domain Decomposition";
        var example = "(e.g. integer range -40_50; real range 35.5_40.5; enumeration a,b,c)";
        var message = "Insert the domain, using '_' for ranges and ',' for enumerations\n" + example;
        var domain = MIDDialogs.getStringInput(title, message, null).strip();
        int numDomains;
        if (domain.contains("_")) {
          message = "Insert the number of domains";
          numDomains = Integer.parseInt(MIDDialogs.getStringInput(title, message, null));
        }
        else if (domain.contains(",")) {
          var enumDomain = parseEnumDomain(domain);
          numDomains = enumDomain.size();
        }
        else {
          throw new MMINTException("Bad domain format");
        }
        // domain decomposition strategy + justification + domain subgoals + completeness goal
        var description = this.decomposed.getDescription();
        var id = this.decomposed.getId();
        var strategy = createStrategy(this.decomposed, "S-" + id, "Decomposition over domain " + domain);
        createJustification("J-" + id, "Every scenario has a corresponding value in the domain " + domain);
        for (var i = 0; i < numDomains; i++) {
          message = "Insert the sub-domain #" + (i+1);
          var subDomain = MIDDialogs.getStringInput(title, message, null).strip();
          createDomainGoal(strategy, id + "-" + i, description, subDomain);
        }
        createDomainGoal(strategy, id + "-C", description, domain);
        if (!checkDomainDecomposition()) {
          throw new MMINTException("Invalid domain");
        }
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
      catch (MMINTException e) {
        MMINTException.print(IStatus.ERROR, "Domain decomposition error", e);
      }
    }
  }
}
