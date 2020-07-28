package edu.toronto.cs.se.modelepedia.safetycase.design.context;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;

import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
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
    try {
      var goal = (Goal) ((DSemanticDecorator) arg0.iterator().next()).getTarget();
      var gsnRootModelObj = (SafetyCase) goal.eContainer();
      var gsnModelPath = MIDRegistry.getModelUri(goal);
      var strDomains = MIDDialogs.getStringInput("Domain Decomposition", "Insert the number of domains", null);
      var numDomains = Integer.parseInt(strDomains);
      for (var i = 0; i < numDomains; i++) {
        var subgoal = SafetyCaseFactory.eINSTANCE.createBasicGoal();
        var support = SafetyCaseFactory.eINSTANCE.createSupportedBy();
        subgoal.setDescription(goal.getDescription());
        subgoal.setId(goal.getId() + "-" + i);
        subgoal.getSupports().add(support);
        goal.getSupportedBy().add(support);
        gsnRootModelObj.getGoals().add(subgoal);
      }
      FileUtils.writeModelFile(gsnRootModelObj, gsnModelPath, true);
    }
    catch (MIDDialogCancellation e) {
      // do nothing
    }
    catch (Exception e) {
      // do nothing
    }
  }

}
