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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.ui.FileExtensionsDialogFilter;
import edu.toronto.cs.se.mmint.mid.ui.FilesOnlyDialogSelectionValidator;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDTreeSelectionDialog;
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

  private static String selectQueryFileToEvaluate(Set<String> fileExtensions) throws MIDDialogCancellation {
    var dialog = new MIDTreeSelectionDialog(new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider(),
                                            ResourcesPlugin.getWorkspace().getRoot());
    dialog.addFilter(new FileExtensionsDialogFilter(fileExtensions));
    dialog.setValidator(new FilesOnlyDialogSelectionValidator());
    var title = "Evaluate query";
    var message = "Select query file";
    var queryFile = (IFile) MIDDialogs.openSelectionDialog(dialog, title, message);

    return queryFile.getFullPath().toString();
  }

  public static void runUI(EObject context, List<? extends EObject> queryArgs) throws Exception {
    var reasoners = MMINT.getReasonersForTrait(IQueryTrait.class);
    if (reasoners.isEmpty()) {
      throw new MMINTException("There are no reasoners installed that implement querying");
    }
    var fileExtToReasoner = new HashMap<String, IQueryTrait>();
    for (var reasoner : reasoners) {
      reasoner.getQueryFileExtensions().forEach(fe -> fileExtToReasoner.put(fe, reasoner));
    }
    var queryFilePath = selectQueryFileToEvaluate(fileExtToReasoner.keySet());
    var queryReasoner = fileExtToReasoner.get(FileUtils.getFileExtensionFromPath(queryFilePath));
    var queryName = MIDDialogs.getStringInput("Evaluate query", "Insert query name to run", null);
    var queryResults = queryReasoner.evaluateQuery(queryFilePath, queryName, context, queryArgs);
    //TODO MMINT[QUERY] Display results in a better way (ui?)
    var printResults = new ArrayList<String>();
    for (var result : queryResults) {
      var printResult = (result instanceof Collection) ?
        ((Collection) result).stream().map(o -> prettyPrint(o)).collect(Collectors.toList()).toString() :
        prettyPrint(result);
      printResults.add(printResult);
    }
    var shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
    MessageDialog.openInformation(shell, "Query Results", String.join("\n", printResults));
  }

  @Override
  public boolean canExecute(Collection<? extends EObject> arg0) {
    return true;
  }

  @Override
  public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
    /** TODO PLAN:
     *  3) Check that the output of CI_1M and CI_2M correspond
     *  4) When evaluating queries, if context is a MID, when showing results ask to store them in rels
     *  5) Store query results in rel with query name and timestamp
     */
    try {
      var modelObjs = arg0.stream()
        .map(obj -> ((DSemanticDecorator) obj).getTarget())
        .collect(Collectors.toList());
      var modelPath = MIDRegistry.getModelUri(modelObjs.get(0));
      var instanceMID = MIDDiagramUtils.getInstanceMIDsInWorkspace().keySet().stream()
        .filter(mid -> mid.getExtendibleElement(modelPath) != null)
        .findFirst()
        //TODO MMINT[QUERY] orElse the context should simply be the sirius model
        .orElseThrow(() -> new MMINTException("The MID editor containing this model must be among the open tabs"));
      var model = instanceMID.<Model>getExtendibleElement(modelPath);
      var modelElems = model.getModelElems().stream()
        .collect(Collectors.toMap(e -> MIDRegistry.getModelObjectUri(e), e -> e));
      /**TODO MMINT[QUERY]
       * Filtering by model elements was done to convert modelObjs into modelElems
       * (no longer necessary now with connectedEMFObjects library query)
       * Except if won't work anyway: queryArgs are from the Sirius editing domain,
       * while the instanceMID context has its own editing domain
       */
      var queryArgs = modelObjs.stream()
        .map(obj -> modelElems.get(MIDRegistry.getModelElementUri(obj)))
        .filter(elem -> elem != null)
        .collect(Collectors.toList());
      runUI(instanceMID, queryArgs);
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR, "Query error", e);
    }
  }

}
