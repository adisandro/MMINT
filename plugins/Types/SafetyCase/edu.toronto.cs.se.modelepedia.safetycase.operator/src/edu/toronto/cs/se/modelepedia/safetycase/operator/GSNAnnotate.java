/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Alessio Di Sandro - Implementation.
 *  Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.slice.Annotate;
import edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactType;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCaseFactory;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNAnnotate extends Annotate {

  // Extract all argument elements that require an annotation and extract their causes.
  // Note: It is assumed that there may be a many-to-many mapping between
  // the safety case elements to be revised and the causes of those revisions.
  private Map<ArgumentElement, String> annotateRel(Resource gsnResource, ModelRel rel) {
    var annotatedObjs = new HashMap<ArgumentElement, String>();
    for (var modelElemRef : rel.getModelEndpointRefs().get(0).getModelElemRefs()) {
      var modelElem = modelElemRef.getObject();
      try {
        var annotatedObj = modelElem.getEMFInstanceObject(gsnResource);
        if (!(annotatedObj instanceof ArgumentElement)) {
          continue;
        }
        var cause = modelElemRef.getModelElemEndpointRefs().stream()
          .map(meer -> ((MappingReference) meer.eContainer()).getObject().getName())
          .collect(Collectors.joining(", "));
        annotatedObjs.put((ArgumentElement) annotatedObj, cause);
      }
      catch (MMINTException e) {
        MMINTException.print(IStatus.WARNING, "Skipping annotated element " + modelElem.getName(), e);
      }
    }

    return annotatedObjs;
  }

  @Override
  protected void annotate() throws Exception {
    var gsnRoot = (SafetyCase) this.input.model.getEMFInstanceRoot();
    var gsnResource = gsnRoot.eResource();
    var reviseObjs = annotateRel(gsnResource, this.input.reviseRel);
    var recheckContentObjs = annotateRel(gsnResource, this.input.recheckContentRel);
    var recheckStateObjs = annotateRel(gsnResource, this.input.recheckStateRel);

    // Iterate through each argument element and update its status.
    Iterator<EObject> scIter = gsnRoot.eAllContents();
    while (scIter.hasNext()) {
      EObject gsnObj = scIter.next();
      if (!(gsnObj instanceof ArgumentElement)) {
        continue;
      }
      var annotation = SafetyCaseFactory.eINSTANCE.createImpactAnnotation();
      if (reviseObjs.containsKey(gsnObj)) {
        annotation.setType(ImpactType.REVISE);
        annotation.setSource(reviseObjs.get(gsnObj));
        ((ArgumentElement) gsnObj).setStatus(annotation);
      }
      else if (recheckContentObjs.containsKey(gsnObj)) {
        annotation.setType(ImpactType.RECHECK_CONTENT);
        annotation.setSource(recheckContentObjs.get(gsnObj));
        ((ArgumentElement) gsnObj).setStatus(annotation);
      }
      else if (recheckStateObjs.containsKey(gsnObj)) {
        annotation.setType(ImpactType.RECHECK_STATE);
        annotation.setSource(recheckStateObjs.get(gsnObj));
        ((ArgumentElement) gsnObj).setStatus(annotation);
      }
      else {
        annotation.setType(ImpactType.REUSE);
        annotation.setSource("Not applicable");
        ((ArgumentElement) gsnObj).setStatus(annotation);
      }

        // Annotate the ASILs of the ASILful elements (i.e. goals).
      // An ASIL should be annotated as revised if the associated goal supports
      // an ASIL decomposition strategy and requires revision. Otherwise, the
      // ASIL can be reused.
      if (gsnObj instanceof ASILfulElement) {
        CoreElement elem = (CoreElement) gsnObj;

        if (((ASILfulElement) gsnObj).getAsil() != null) {
          annotation = SafetyCaseFactory.eINSTANCE.createImpactAnnotation();

          annotation.setType(ImpactType.REUSE);
          annotation.setSource("Not applicable.");
          ((ASILfulElement) gsnObj).getAsil().setStatus(annotation);

          if (reviseObjs.containsKey(gsnObj)) {
            // Find the parent decomposable core elements.
            Set<Supportable> supportableCur = new HashSet<>();
            Set<Supportable> supportableNext = new HashSet<>();
            Set<Supportable> supportableAll = new HashSet<>();

            for (SupportedBy rel: elem.getSupports()) {
            supportableCur.add(rel.getSource());
            supportableAll.add(rel.getSource());
            }

            while (!supportableCur.isEmpty()) {
              for (Supportable curElem: supportableCur) {
                if (curElem instanceof SupportConnector) {
                  for (SupportedBy rel: curElem.getSupports()) {
                    supportableNext.add(rel.getSource());
                  }
                }
              }

              supportableCur.clear();
              for (Supportable nextElem: supportableNext) {
                if (!supportableAll.contains(nextElem)) {
                  supportableAll.add(nextElem);
                  supportableCur.add(nextElem);
                }
              }

              supportableNext.clear();
            }

            // Check if any parent is an ASIL decomposition strategy.
            boolean supportsAsilDecomp = false;
            for (Supportable curElem: supportableAll) {
              if  (curElem instanceof ASILDecompositionStrategy) {
                supportsAsilDecomp = true;
              }
            }

            if (supportsAsilDecomp) {
              annotation.setType(ImpactType.RECHECK_CONTENT);
              annotation.setSource(reviseObjs.get(gsnObj));
            }
          }
        }
      }
    }

    // Create output
    String annotatedPath = FileUtils.addFileNameSuffixInPath(this.input.model.getUri(), "_" + Output.OUT_MODEL);
    this.output.annotatedModel = this.input.model.getMetatype().createInstanceAndEditor(gsnRoot, annotatedPath,
                                                                                        this.output.mid);
  }
}
