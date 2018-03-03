package edu.toronto.cs.se.modelepedia.safetycase.design;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.Solution;
import edu.toronto.cs.se.modelepedia.safetycase.Strategy;

/**
 * The services class used by VSM.
 */
public class Services {
    
    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }
    
    // Compute the statistics for the goals in the safety case.
    public String getGoalStatistics(SafetyCase sc) {
        Set<Goal> revise = new HashSet<>();
        Set<Goal> recheck = new HashSet<>();
        Set<Goal> reuse = new HashSet<>();

        for (Goal g: sc.getGoals()) {
            switch (g.getStatus()) {
                case REVISE:
                    revise.add(g);
                    break;

                case RECHECK:
                    recheck.add(g);
                    break;

                case REUSE:
                    reuse.add(g);
                    break;
            }
        }

        int totalCount = sc.getGoals().size();
        int reviseCount = revise.size();
        int recheckCount = recheck.size();
        int reuseCount = reuse.size();
        
        int revisePercent = Math.round(100 * reviseCount / totalCount);
        int recheckPercent = Math.round(100 * recheckCount / totalCount);
        int reusePercent = Math.round(100 * reuseCount / totalCount);

        return "Total: " + totalCount + "\n" +
                "Revise: " + reviseCount + " (" + revisePercent + "%)" + "\n" + 
                "Recheck: " + recheckCount + " (" + recheckPercent + "%)" + "\n" +
                "Reuse: " + reuseCount + " (" + reusePercent + "%)";
    }
    
    // Compute the statistics for the strategies in the safety case.
    public String getStrategyStatistics(SafetyCase sc) {
        Set<Strategy> revise = new HashSet<>();
        Set<Strategy> recheck = new HashSet<>();
        Set<Strategy> reuse = new HashSet<>();

        for (Strategy s: sc.getStrategies()) {
            switch (s.getStatus()) {
                case REVISE:
                    revise.add(s);
                    break;

                case RECHECK:
                    recheck.add(s);
                    break;

                case REUSE:
                    reuse.add(s);
                    break;
            }
        }

        int totalCount = sc.getStrategies().size();
        int reviseCount = revise.size();
        int recheckCount = recheck.size();
        int reuseCount = reuse.size();
        
        int revisePercent = Math.round(100 * reviseCount / totalCount);
        int recheckPercent = Math.round(100 * recheckCount / totalCount);
        int reusePercent = Math.round(100 * reuseCount / totalCount);

        return "Total: " + totalCount + "\n" +
                "Revise: " + reviseCount + " (" + revisePercent + "%)" + "\n" + 
                "Recheck: " + recheckCount + " (" + recheckPercent + "%)" + "\n" +
                "Reuse: " + reuseCount + " (" + reusePercent + "%)";
    }
    
    // Compute the statistics for the solutions in the safety case.
    public String getSolutionStatistics(SafetyCase sc) {
        Set<Solution> revise = new HashSet<>();
        Set<Solution> recheck = new HashSet<>();
        Set<Solution> reuse = new HashSet<>();

        for (Solution s: sc.getSolutions()) {
            switch (s.getStatus()) {
                case REVISE:
                    revise.add(s);
                    break;

                case RECHECK:
                    recheck.add(s);
                    break;

                case REUSE:
                    reuse.add(s);
                    break;
            }
        }

        int totalCount = sc.getSolutions().size();
        int reviseCount = revise.size();
        int recheckCount = recheck.size();
        int reuseCount = reuse.size();
        
        int revisePercent = Math.round(100 * reviseCount / totalCount);
        int recheckPercent = Math.round(100 * recheckCount / totalCount);
        int reusePercent = Math.round(100 * reuseCount / totalCount);

        return "Total: " + totalCount + "\n" +
                "Revise: " + reviseCount + " (" + revisePercent + "%)" + "\n" + 
                "Recheck: " + recheckCount + " (" + recheckPercent + "%)" + "\n" +
                "Reuse: " + reuseCount + " (" + reusePercent + "%)";
    }
    
}
