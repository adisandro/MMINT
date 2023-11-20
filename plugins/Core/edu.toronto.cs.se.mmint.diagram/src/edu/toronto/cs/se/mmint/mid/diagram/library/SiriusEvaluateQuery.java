/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.diagram.library;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sirius.business.api.action.AbstractExternalJavaAction;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.library.SiriusHighlighter.Color;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IQueryTrait.QuerySpec;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.SiriusUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class SiriusEvaluateQuery extends AbstractExternalJavaAction {

  public static QuerySpec selectQuery(EObject context) throws Exception {
    var allReasoners = MMINT.getReasonersForTrait(IQueryTrait.class, context);
    if (allReasoners.isEmpty()) {
      throw new MMINTException("There are no reasoners installed that implement querying");
    }
    var fileExtToReasoners = new HashMap<String, Set<IQueryTrait>>();
    for (var reasoner : allReasoners) {
      reasoner.getQueryFileExtensions().forEach(fe -> {
        fileExtToReasoners.computeIfAbsent(fe, k -> new HashSet<>()).add(reasoner);
      });
    }
//    var queryFilePath = selectQueryFileToEvaluate(fileExtToReasoners.keySet());
    var queryFilePath = MIDDialogs.selectFile("Evaluate query", "Select query file",
                                               "There are no query files in the workspace",
                                               fileExtToReasoners.keySet());
    var fileExtension = FileUtils.getFileExtensionFromPath(queryFilePath);
    var reasoners = fileExtToReasoners.get(fileExtension);
    var queryReasoner = MIDDialogs.selectReasoner(reasoners, fileExtension + " queries");
    var query = queryReasoner.selectQuery(queryFilePath);

    return new QuerySpec(queryReasoner, queryFilePath, query);
  }

  private static String queryResultToString(Object result) {
    if (result instanceof EObject resultObj) {
      try {
        var name = FileUtils.getModelObjectFeature(resultObj, "name");
        if (name != null) {
          result = name;
        }
      }
      catch (MMINTException e) {}
    }
    return result.toString();
  }

  public static void displayQueryResults(EObject context, List<Object> results, String queryName) {
    var window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    var shell = window.getShell();
    if (results.isEmpty()) {
      MessageDialog.openInformation(shell, "Query Results", "No Results");
      return;
    }

    // collect results
    var numResults = results.size();
    String[] buttonsDone, buttonsDoneNext, buttonsDoneSame;
    if (context instanceof MID) {
      buttonsDone = new String[] {"Done + Store Results", "Done"};
      buttonsDoneNext = new String[] {"Done + Store Results", "Next Result", "Done"};
      buttonsDoneSame = new String[] {"Done + Store Results", "Same Result, Next Model", "Done"};
    }
    else {
      buttonsDone = new String[] {"Done"};
      buttonsDoneNext = new String[] {"Done", "Next Result"};
      buttonsDoneSame = new String[] {"Done", "Same Result, Next Model"};
    }
    var buttons = buttonsDone;
    var buttonPressed = 0;
results:
    for (var i = 0; i < numResults; i++) {
      var result = results.get(i);
      String message;
      var highlightUris = new HashSet<String>();
      var models = new HashSet<Model>();
      if (result instanceof Collection multiResult) {
        message = "";
        for (var innerResult : multiResult) {
          if (message.length() > 1) {
            message += "\n";
          }
          message += queryResultToString(innerResult);
          if (innerResult instanceof EObject innerObj) {
            highlightUris.add(MIDRegistry.getModelElementUri(innerObj));
            var modelUri = MIDRegistry.getModelUri(innerObj);
            if (models.stream().noneMatch(m -> m.getUri().equals(modelUri))) {
              try {
                var model = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(innerObj);
                if (SiriusUtils.hasSiriusDiagram(model)) {
                  models.add(model);
                }
              }
              catch (MMINTException e) {
              }
            }
          }
        }
      }
      else {
        message = queryResultToString(result);
        if (result instanceof EObject resultObj) {
          highlightUris.add(MIDRegistry.getModelElementUri(resultObj));
          try {
            var model = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(resultObj);
            if (SiriusUtils.hasSiriusDiagram(model)) {
              models.add(model);
            }
          }
          catch (MMINTException e) {
          }
        }
      }

      // display results
      var title = "Query Results (" + (i+1) + " out of " + numResults + ")";
      if (models.isEmpty()) {
        buttons = ((i+1) == numResults) ? buttonsDone : buttonsDoneNext;
        buttonPressed = MessageDialog.open(MessageDialog.INFORMATION, shell, title, message, SWT.NONE, buttons);
        if (buttons[buttonPressed].startsWith("Done")) {
          break;
        }
      }
      else {
        var highlighted = new HashSet<IEditorPart>();
        var j = 1;
        for (var model : models) {
          try {
            highlighted.add(SiriusHighlighter.highlight(model, highlightUris, Color.RED));
          }
          catch (Exception e) {
            MMINTException.print(IStatus.INFO, "Query result highlighting failed", e);
          }
          buttons = ((i+1) == numResults && j == models.size()) ?
            buttonsDone : ((j < models.size()) ?
              buttonsDoneSame : buttonsDoneNext);
          buttonPressed = MessageDialog.open(MessageDialog.INFORMATION, shell, title, message, SWT.NONE, buttons);
          if (buttons[buttonPressed].startsWith("Done")) {
            SiriusUtils.closeRepresentations(window, highlighted);
            break results;
          }
          j++;
        }
        SiriusUtils.closeRepresentations(window, highlighted);
      }
    }

    // store results
    if (buttons[buttonPressed].endsWith("Store Results")) {
      storeQueryResults((MID) context, results, queryName);
    }
  }

  private static void storeQueryResults(MID instanceMID, List<Object> results, String queryName) {
    var rels = new HashMap<String, ModelRel>();
    var relType = MIDTypeHierarchy.getRootModelRelType();
    for (var result : results) {
      //TODO MMINT[QUERY] Handle tuples/collections as results
      if (!(result instanceof EObject resultObj)) {
        continue;
      }
      var modelPath = MIDRegistry.getModelUri(resultObj);
      var rel = rels.get(modelPath);
      try {
        if (rel == null) {
          var model = instanceMID.<Model>getExtendibleElement(modelPath);
          if (model == null) {
            continue;
          }
          rel = relType.createInstanceAndEndpoints(null, "query_" + queryName, ECollections.asEList(model),
                                                   instanceMID);
          rels.put(modelPath, rel);
        }
        rel.getModelEndpointRefs().get(0).createModelElementInstanceAndReference((EObject) result, null);
      }
      catch (MMINTException e) {
        MMINTException.print(IStatus.INFO, "Failed to store query result " + result + " for model " +
                             modelPath, e);
        continue;
      }
    }
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
      var model = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(modelObjs.get(0));
      //TODO MMINT[QUERY] in case of exception the context should simply be the sirius model
      var instanceMID = model.getMIDContainer();
      var modelElems = model.getModelElems().stream()
        .collect(Collectors.toMap(e -> MIDRegistry.getModelObjectUri(e), e -> e));
      /**TODO MMINT[QUERY]
       * Filtering by model elements was done to convert modelObjs into modelElems
       * (no longer necessary now with connectedEMFObjects library query)
       * Except it won't work anyway: queryArgs are from the Sirius editing domain,
       * while the instanceMID context has its own editing domain
       */
      var queryArgs = modelObjs.stream()
        .map(obj -> modelElems.get(MIDRegistry.getModelElementUri(obj)))
        .filter(elem -> elem != null)
        .collect(Collectors.toList());
      var querySpec = selectQuery(instanceMID);
      var queryResults = querySpec.evaluateQuery(instanceMID, queryArgs);
      displayQueryResults(instanceMID, queryResults, querySpec.query().toString());
    }
    catch (Exception e) {
      MMINTException.print(IStatus.ERROR, "Query error", e);
    }
  }

}
