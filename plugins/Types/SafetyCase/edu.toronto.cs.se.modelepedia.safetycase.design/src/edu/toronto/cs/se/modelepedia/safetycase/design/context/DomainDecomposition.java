package edu.toronto.cs.se.modelepedia.safetycase.design.context;

import java.util.Collection;
import java.util.Map;

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
import edu.toronto.cs.se.modelepedia.safetycase.BasicGoal;
import edu.toronto.cs.se.modelepedia.safetycase.ContextualElement;
import edu.toronto.cs.se.modelepedia.safetycase.DecomposableCoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.Domain;
import edu.toronto.cs.se.modelepedia.safetycase.DomainGoal;
import edu.toronto.cs.se.modelepedia.safetycase.DomainStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.EnumDomain;
import edu.toronto.cs.se.modelepedia.safetycase.GSNFactory;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.IntDomain;
import edu.toronto.cs.se.modelepedia.safetycase.Justification;
import edu.toronto.cs.se.modelepedia.safetycase.RealDomain;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
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

    private DomainStrategy createDomainStrategy(Supportable supportable, String id, String description, Domain domain) {
      var strategy = this.factory.createDomainStrategy();
      addArgumentElement(strategy, id, description);
      addSupporter(supportable, strategy);
      strategy.setDomain(domain);
      this.gsnRootModelObj.getStrategies().add(strategy);

      return strategy;
    }

    private void addGoal(Goal goal, Supportable supportable, String id, String description) {
      addArgumentElement(goal, id, description);
      addSupporter(supportable, goal);
      this.gsnRootModelObj.getGoals().add(goal);
    }

    private BasicGoal createCompletenessGoal(Supportable supportable, String id, String description) {
      var goal = this.factory.createBasicGoal();
      addGoal(goal, supportable, id, description);

      return goal;
    }

    private DomainGoal createDomainGoal(Supportable supportable, String id, String description, Domain domain) {
      var goal = this.factory.createDomainGoal();
      addGoal(goal, supportable, id, description);
      goal.setDomain(domain);

      return goal;
    }

    private Justification createJustification(String id, String description) {
      var justification = this.factory.createJustification();
      addArgumentElement(justification, id, description);
      addContext(this.decomposed, justification);
      this.gsnRootModelObj.getJustifications().add(justification);

      return justification;
    }

    private Domain parseDomainString(String domainStr) throws MMINTException {
      Domain domain;
      if (domainStr.contains("_")) {
        /* range a_b:
         *  1) a < b
         *  2) two tokens only, separated by _
         *  3) parsable number tokens, stripped of spaces
         */
        domain = this.factory.createIntDomain();
      }
      else if (domainStr.contains(",")) {
        var entries = domainStr.split(",");
        if (entries.length == 1) {
          throw new MMINTException("Bad enumeration domain format");
        }
        domain = this.factory.createEnumDomain();
        var enumValues = ((EnumDomain) domain).getValues();
        for (var entry : entries) {
          if (entry.isBlank()) {
            continue;
          }
          enumValues.add(entry.strip());
        }
      }
      else {
        throw new MMINTException("Bad domain format");
      }

      return domain;
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
        var domainStr = MIDDialogs.getStringInput(title, message, null).strip();
        int numDomains;
        var domain = parseDomainString(domainStr);
        if (domain instanceof IntDomain || domain instanceof RealDomain) {
          message = "Insert the number of domains";
          numDomains = Integer.parseInt(MIDDialogs.getStringInput(title, message, null));
        }
        else {
          numDomains = ((EnumDomain) domain).getValues().size();
        }
        // domain decomposition strategy + justification + domain subgoals + completeness goal
        var description = this.decomposed.getDescription();
        var id = this.decomposed.getId();
        var strategy = createDomainStrategy(this.decomposed, "S-" + id, "Decomposition over domain " + domainStr, domain);
        createJustification("J-" + id, "Every scenario has a corresponding value in the domain " + domainStr);
        for (var i = 0; i < numDomains; i++) {
          message = "Insert the sub-domain #" + (i+1);
          var subDomainStr = MIDDialogs.getStringInput(title, message, null).strip();
          var subDomain = parseDomainString(subDomainStr);
          createDomainGoal(strategy, id + "-" + i, description, subDomain);
        }
        createCompletenessGoal(strategy, id + "-C", description);
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
