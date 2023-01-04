/*******************************************************************************
 * Copyright (c) 2022, 2023 Alessio Di Sandro.
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
package edu.toronto.cs.se.modelepedia.gsn.design.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.LabelProvider;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogCancellation;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.ui.MIDTreeSelectionDialog;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.PropertyGoal;
import edu.toronto.cs.se.modelepedia.gsn.Strategy;
import edu.toronto.cs.se.modelepedia.gsn.design.Activator;
import edu.toronto.cs.se.modelepedia.gsn.reasoning.IGSNLeanEncoder.PropertyTemplate;

public class DecompositionUtils {

  public static Strategy moveOneStrategyUp(Goal goal) throws MMINTException {
    if (goal.getSupports().size() > 1) {
      throw new MMINTException("Goal '" + goal.getId() + "' should not support more than one GSN element");
    }
    var supported = goal.getSupports().get(0).getSource();
    if (!(supported instanceof Strategy parentStrategy)) {
      throw new MMINTException("Goal '" + goal.getId() + "' should support a strategy");
    }

    return parentStrategy;
  }

  public static Goal moveOneDecompositionUp(Goal goal) throws MMINTException {
    var strategy = moveOneStrategyUp(goal);
    if (strategy.getSupports().size() > 1) {
      throw new MMINTException("Strategy '" + strategy.getId() + "' should not support more than one GSN element");
    }
    var supported = strategy.getSupports().get(0).getSource();
    if (!(supported instanceof Goal parentGoal)) {
      throw new MMINTException("Strategy '" + strategy.getId() + "' should support a goal");
    }

    return parentGoal;
  }

  public static Optional<Model> getRelatedModel(Goal decomposed) throws MMINTException {
    // detect if this is a decomposition chain
    var relatedGoal = decomposed;
    if (relatedGoal instanceof PropertyGoal) {
      try {
        while (relatedGoal instanceof PropertyGoal) {
          relatedGoal = moveOneDecompositionUp(relatedGoal);
        }
        relatedGoal = moveOneDecompositionUp(relatedGoal); // formal argument level
      }
      catch (MMINTException e) {
        MMINTException.print(IStatus.WARNING, "Bad structure for assisted decomposition", e);
        return Optional.empty();
      }
    }
    // find the goals in connected rels
    var gsnModel = MIDDiagramUtils.getInstanceMIDModelFromModelEditor(relatedGoal);
    var modelRels = MIDRegistry.getConnectedModelRels(gsnModel, gsnModel.getMIDContainer());
    var decomposedUri = MIDRegistry.getModelElementUri(relatedGoal);
    //TODO MMINT[GSN]: Ask if there are multiple matches instead of getting the first
    for (var modelRel : modelRels) {
      if (modelRel.getModelEndpoints().size() != 2) { // exclude non-binary
        continue;
      }
      for (var mapping : modelRel.getMappings()) {
        var endpoints = mapping.getModelElemEndpoints();
        if (endpoints.size() != 2) { // exclude non-binary
          continue;
        }
        ModelElement relatedModelElem;
        var uri0 = MIDRegistry.getModelObjectUri(endpoints.get(0).getTarget());
        var uri1 = MIDRegistry.getModelObjectUri(endpoints.get(1).getTarget());
        if (decomposedUri.equals(uri0)) {
          return Optional.of((Model) endpoints.get(1).getTarget().eContainer());
        }
        else if (decomposedUri.equals(uri1)) {
          return Optional.of((Model) endpoints.get(0).getTarget().eContainer());
        }
      }
    }

    return Optional.empty();
  }

  public static Map<EClass, List<EObject>> categorizeModelObjects(Model model,
                                                            Map<String, List<PropertyTemplate>> templates) {
    var validClasses = templates.values().stream()
      .flatMap(l -> l.stream())
      .flatMap(t -> t.variables.stream())
      .flatMap(v -> v.validTypes.stream())
      .collect(Collectors.toSet());
    if (validClasses.isEmpty()) {
      return new HashMap<>();
    }
    var modelObjs = new HashMap<EClass, List<EObject>>();
    for (var iter = model.getEMFInstanceRoot().eAllContents(); iter.hasNext();) {
      var modelObj = iter.next();
      var modelObjClass = modelObj.eClass();
      if (validClasses.contains(modelObjClass)) {
        modelObjs.computeIfAbsent(modelObjClass, k -> new ArrayList<>()).add(modelObj);
      }
      for (var modelObjSuperclass : modelObjClass.getEAllSuperTypes()) {
        if (validClasses.contains(modelObjSuperclass)) {
          modelObjs.computeIfAbsent(modelObjSuperclass, k -> new ArrayList<>()).add(modelObj);
        }
      }
    }

    return modelObjs;
  }

  public static PropertyTemplate selectTemplate(String title, String message,
                                                Map<String, List<PropertyTemplate>> templates)
                                                  throws MIDDialogCancellation {
    if (templates.isEmpty()) {
      return PropertyTemplate.CUSTOM;
    }
    var labelProvider = LabelProvider.createTextProvider(t -> {
      return (t instanceof PropertyTemplate) ? ((PropertyTemplate) t).informal : (String) t;
    });
    var contentProvider = new TemplatePropertyContentProvider(templates);
    var dialog = new MIDTreeSelectionDialog(labelProvider, contentProvider, templates);
    dialog.setValidator(selection -> (Arrays.stream(selection).anyMatch(s -> s instanceof String)) ?
                                       new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Property not selected") :
                                       new Status(IStatus.OK, Activator.PLUGIN_ID, ""));

    return (PropertyTemplate) MIDDialogs.openTreeDialogWithDefault(dialog, title, message);
  }
}
