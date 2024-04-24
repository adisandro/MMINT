/*******************************************************************************
 * Copyright (c) 2024, 2024 Alessio Di Sandro.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Alessio Di Sandro - Implementation
 *******************************************************************************/
package fm24;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.productline.ProductLine;
import edu.toronto.cs.se.mmint.types.gsn.productline.GSNPLAnalyticTemplate;
import edu.toronto.cs.se.mmint.types.gsn.productline.reasoning.IGSNPLAnalysis;
import edu.toronto.cs.se.modelepedia.statemachine.StateMachinePackage;

public class FTS4VMCAnalysis implements IGSNPLAnalysis {

  private String convertPC(String pc) {
    return pc.replace("&", "and").replace("|", "or").replace("~", "not ").replace("$true", "True");
  }

  private String convertModel(Model plModel) {
    var productLine = (ProductLine) plModel.getEMFInstanceRoot();
    var types = StateMachinePackage.eINSTANCE;
    var out = "digraph " + plModel.getName() + "{";
    out += "\n  name=\"" + plModel.getName() + "\"";
    var fm = convertPC(productLine.getFeaturesConstraint());
    out += "\n  FM=\"" + fm + "\"";
    for (var s : productLine.getClasses()) {
      if (s.instanceOf(types.getInitialState())) {
        out += "\n  " + s.getAttribute(types.getAbstractState_Name()).get(0) + "[initial=True]";
        break;
      }
    }
    for (var t : productLine.getClasses()) {
      if (!t.instanceOf(types.getTransition())) {
        continue;
      }
      for (var src : t.getReference(types.getTransition_Source())) {
        var srcName = src.getAttribute(types.getAbstractState_Name()).get(0);
        for (var tgt : t.getReference(types.getTransition_Target())) {
          var tgtName = tgt.getAttribute(types.getAbstractState_Name()).get(0);
          out += "\n  " + srcName + " -> " + tgtName + "[label=\"" + tgtName + " | " +
                 convertPC(t.getPresenceCondition()) + "\"];";
        }
      }
    }
    out += "\n}";

    return out;
  }

  @Override
  public void instantiate(GSNPLAnalyticTemplate plTemplate) throws Exception {
    var plMID = (MID) FileUtils.readModelFile("/FM24/model/example.mid", null, true);
    var plModel = (Model) plMID.getExtendibleElement("/FM24/model/R1.productline");
    var out = convertModel(plModel);
    var outPath = FileUtils.replaceFileExtensionInPath(plModel.getUri(), "dot");
    FileUtils.createTextFile(outPath, out, true);
  }
}
