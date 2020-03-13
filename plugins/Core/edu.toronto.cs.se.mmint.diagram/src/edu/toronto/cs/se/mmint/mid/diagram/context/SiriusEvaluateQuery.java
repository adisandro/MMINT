/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class SiriusEvaluateQuery extends AbstractExternalJavaAction {

  private static String prettyPrint(Object result) {
    if (result instanceof EObject) {
      try {
        var name = FileUtils.getModelObjectFeature((EObject) result, "name");
        if (name != null) {
          result = name;
        }
      }
      catch (MMINTException e) {}
    }
    return result.toString();
  }

  public static void runUI(EObject context, List<? extends ExtendibleElement> queryArgs) throws MIDDialogCancellation {
    var queryFilePath = MIDDialogs.selectQueryFileToEvaluate();
    var queryName = MIDDialogs.getStringInput("Evaluate query", "Insert query name to run", null);
    var queryResults = MIDConstraintChecker.evaluateQuery(queryFilePath, queryName, context, queryArgs);
    //TODO MMINT[QUERY] Display results in a better way (ui?)
    var printResults = new ArrayList<String>();
    for (var result : queryResults) {
      var printResult = (result instanceof Collection) ?
        ((Collection) result).stream().map(o -> prettyPrint(o)).collect(Collectors.toList()).toString() :
        prettyPrint(result);
      printResults.add(printResult);
    }
    Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    MessageDialog.openInformation(shell, "Query Results", String.join("\n", printResults));
  }

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    try {
      var modelObjs = arg0.stream()
        .map(obj -> ((DSemanticDecorator) obj).getTarget())
        .collect(Collectors.toList());
      var modelPath = MIDRegistry.getModelUri(modelObjs.get(0));
      var instanceMID = MIDDiagramUtils.getInstanceMIDsInWorkspace().keySet().stream()
        .filter(mid -> mid.getExtendibleElement(modelPath) != null)
        .findFirst()
        .orElseThrow(() -> new MIDDialogCancellation());
      var model = instanceMID.<Model>getExtendibleElement(modelPath);
      var modelElems = model.getModelElems().stream()
        .collect(Collectors.toMap(e -> MIDRegistry.getModelObjectUri(e), e -> e));
      var queryArgs = modelObjs.stream()
        .map(obj -> modelElems.get(MIDRegistry.getModelElementUri(obj)))
        .filter(elem -> elem != null)
        .collect(Collectors.toList());
      runUI(instanceMID, queryArgs);
    }
    catch (MIDDialogCancellation e) {
      // do nothing
    }
  }

}
