package edu.toronto.cs.se.modelepedia.safetycase.design.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.Supporter;
import edu.toronto.cs.se.modelepedia.safetycase.ValueDomain;

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
    private List<ArgumentElement> gsnElements;

    public DomainDecompositionCommand(TransactionalEditingDomain domain, Goal decomposed) {
      super(domain);
      this.decomposed = decomposed;
      this.gsnRootModelObj = (SafetyCase) this.decomposed.eContainer();
      this.factory = GSNFactory.eINSTANCE;
      this.gsnElements = new ArrayList<>();
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
      this.gsnElements.add(strategy);

      return strategy;
    }

    private void addGoal(Goal goal, Supportable supportable, String id, String description) {
      addArgumentElement(goal, id, description);
      addSupporter(supportable, goal);
      this.gsnElements.add(goal);
    }

    private BasicGoal createCompletenessGoal(Strategy strategy, String id, String description) {
      var goal = this.factory.createBasicGoal();
      addGoal(goal, strategy, id, description);

      return goal;
    }

    private DomainGoal createDomainGoal(Strategy strategy, String id, String description, Domain domain) {
      var goal = this.factory.createDomainGoal();
      addGoal(goal, strategy, id, description);
      goal.setDomain(domain);

      return goal;
    }

    private Justification createJustification(Strategy strategy, String id, String description) {
      var justification = this.factory.createJustification();
      addArgumentElement(justification, id, description);
      addContext(strategy, justification);
      this.gsnElements.add(justification);

      return justification;
    }

    private Domain parseDomainInput(String domainInput) throws Exception {
      if (domainInput.isBlank()) {
        throw new MMINTException("Empty domain");
      }

      Domain domain;
      domainInput = domainInput.strip();
      if (domainInput.contains("_")) {
        var entries = domainInput.split("_");
        if (entries.length != 2) {
          throw new MMINTException("Bad numeric domain format");
        }
        try {
          var lower = Integer.parseInt(entries[0].strip());
          var upper = Integer.parseInt(entries[1].strip());
          if (upper <= lower) {
            throw new MMINTException("Upper bound must be > lower bound");
          }
          domain = this.factory.createIntDomain();
          ((IntDomain) domain).setLowerBound(lower);
          ((IntDomain) domain).setUpperBound(upper);
        }
        catch (NumberFormatException e) {
          var lower = Double.parseDouble(entries[0].strip());
          var upper = Double.parseDouble(entries[1].strip());
          if (upper <= lower) {
            throw new MMINTException("Upper bound must be > lower bound");
          }
          domain = this.factory.createRealDomain();
          ((RealDomain) domain).setLowerBound(lower);
          ((RealDomain) domain).setUpperBound(upper);
        }
      }
      else if (domainInput.contains(",")) {
        var entries = domainInput.split(",");
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
        domain = this.factory.createValueDomain();
        ((ValueDomain) domain).setValue(domainInput.strip());
      }

      return domain;
    }

    private boolean checkDomainDecomposition() {
      /* range a_b:
       *  order all domains, then check for absence of holes or overlap
       *  special case: single values
       * enumeration a,b,c:
       *  check that all exist
       *  special case: sub-enumerations
       */
      // TODO: add manual creation tools in sirius diagram
      return true;
    }

    @Override
    protected void doExecute() {
      try {
        // ask for input
        var title = "Domain Decomposition";
        var example = "(e.g. integer range '-40_50'; real range '-40.0_50.0'; enumeration 'x,y,z')";
        var message = "Insert the domain, using '_' for ranges and ',' for enumerations.\n" + example;
        var domainInput = MIDDialogs.getStringInput(title, message, null);
        int numDomains;
        String subExample, subMessage;
        var domain = parseDomainInput(domainInput);
        if (domain instanceof IntDomain || domain instanceof RealDomain) {
          message = "Insert the number of domains";
          numDomains = Integer.parseInt(MIDDialogs.getStringInput(title, message, null));
          subMessage = ", using '_' for ranges.\n";
          subExample = "(e.g. integer range '-40_50'; real range '-40.0_50.0'; single integer value '10')";
        }
        else if (domain instanceof EnumDomain) {
          numDomains = ((EnumDomain) domain).getValues().size();
          subMessage = ", using ',' for enumerations.\n";
          subExample = "(e.g. enumeration 'x,y,z'; single enumeration value 'z')";
        }
        else { // ValueDomain
          throw new MMINTException("Bad domain format");
        }
        // create domain decomposition strategy + justification + domain subgoals + completeness goal
        var id = this.decomposed.getId();
        var desc = this.decomposed.getDescription();
        var strategyId = "S-" + id;
        var justificationId = "J-" + id;
        var subGoalId = id + "-";
        var compGoalId = id + "-C";
        var strategyDesc = "Decomposition over domain " + domainInput;
        var justificationDesc = "Every scenario has a corresponding value in the domain " + domainInput;
        var subGoalDesc = desc + " for sub-domain ";
        var compGoalDesc = "Every possible value in the domain " + domainInput + " is covered by sub-domains ";
        var strategy = createDomainStrategy(this.decomposed, strategyId, strategyDesc, domain);
        createJustification(strategy, justificationId, justificationDesc);
        example = "(e.g. integer range -40_50; real range 35.5_40.5; enumeration value x)";
        var subDomainInputs = new ArrayList<String>();
        for (var i = 0; i < numDomains; i++) {
          message = "Insert the sub-domain #" + (i+1) + subMessage + subExample;
          var subDomainInput = MIDDialogs.getStringInput(title, message, null);
          subDomainInputs.add(subDomainInput);
          var subDomain = parseDomainInput(subDomainInput);
          createDomainGoal(strategy, subGoalId + i, subGoalDesc + subDomainInput, subDomain);
        }
        createCompletenessGoal(strategy, compGoalId, compGoalDesc + String.join(", ", subDomainInputs));
        if (!checkDomainDecomposition()) {
          throw new MMINTException("Invalid domain decomposition");
        }
        // "commit" the changes
        for (var gsnElement : this.gsnElements) {
          if (gsnElement instanceof Strategy) {
            this.gsnRootModelObj.getStrategies().add((Strategy) gsnElement);
          }
          else if (gsnElement instanceof Justification) {
            this.gsnRootModelObj.getJustifications().add((Justification) gsnElement);
          }
          else if (gsnElement instanceof Goal) {
            this.gsnRootModelObj.getGoals().add((Goal) gsnElement);
          }
        }
      }
      catch (MIDDialogCancellation e) {
        // do nothing
      }
      catch (Exception e) {
        MMINTException.print(IStatus.ERROR, "Domain decomposition error", e);
      }
    }
  }
}
