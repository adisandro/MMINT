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

import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.slice.AnnotateSlice;
import edu.toronto.cs.se.mmint.operator.slice.Slice.SliceType;
import edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.Goal;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactType;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCaseFactory;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNAnnotateSlice extends AnnotateSlice {

  private void annotateModelElem(ArgumentElement gsnModelObj, @Nullable String cause, SliceType sliceType) {
    var annotation = SafetyCaseFactory.eINSTANCE.createImpactAnnotation();
    annotation.setSource(cause);
    ImpactType impactType = switch (sliceType) {
      case DEL, REVISE -> ImpactType.REVISE;
      case MOD, RECHECK_CONTENT -> ImpactType.RECHECK_CONTENT;
      case RECHECK_STATE -> ImpactType.RECHECK_STATE;
      case ADD -> ImpactType.REUSE; //TODO MMINT[SLICE] Not supported yet
    };
    annotation.setType(impactType);
    gsnModelObj.setStatus(annotation);
  }

  private void annotateSliceTypes(Resource gsnResource, ModelRel rel) {
    var alreadyAnnotated = new HashSet<String>();
    for (var mappingRef : rel.getMappingRefs()) {
      var sliceType = SliceType.fromMapping(mappingRef.getObject());
      for (var modelElemEndpointRef : mappingRef.getModelElemEndpointRefs()) {
        var modelElemRef = modelElemEndpointRef.getModelElemRef();
        var modelElem = modelElemRef.getObject();
        // annotate each model element once, extracting all mappings attached as causes
        if (alreadyAnnotated.contains(modelElem.getUri())) {
          continue;
        }
        try {
          var gsnModelObj = modelElem.getEMFInstanceObject(gsnResource);
          if (!(gsnModelObj instanceof ArgumentElement)) {
            continue;
          }
          var cause = modelElemRef.getModelElemEndpointRefs().stream()
            .map(meer -> ((MappingReference) meer.eContainer()).getObject())
            .filter(m -> m.getMetatypeUri().equals(sliceType.id)) // discard lower priority causes
            .map(Mapping::getName)
            .collect(Collectors.joining(", "));
          annotateModelElem((ArgumentElement) gsnModelObj, cause, sliceType);
          alreadyAnnotated.add(modelElem.getUri());
        }
        catch (MMINTException e) {
          MMINTException.print(IStatus.WARNING, "Skipping annotated element " + modelElem.getName(), e);
        }
      }
    }
  }

  @Override
  protected void annotate() throws Exception {
    var gsnRoot = (SafetyCase) this.input.model.getEMFInstanceRoot();
    var gsnResource = gsnRoot.eResource();

    // annotate sliced elements first..
    annotateSliceTypes(gsnResource, this.input.sliceRel);
    // ..then iterate through each argument element and annotate with REUSE
    Iterator<EObject> gsnIter = gsnRoot.eAllContents();
    while (gsnIter.hasNext()) {
      var gsnModelObj = gsnIter.next();
      if (!(gsnModelObj instanceof ArgumentElement)) {
        continue;
      }
      if (((ArgumentElement) gsnModelObj).getStatus() != null) {
        var annotation = SafetyCaseFactory.eINSTANCE.createImpactAnnotation();
        annotation.setType(ImpactType.REUSE);
        annotation.setSource("Not applicable");
        ((ArgumentElement) gsnModelObj).setStatus(annotation);
      }

      //TODO MMINT[GSN] Move this to the slicer, it belongs there
      // Annotate the ASILs of the ASILful elements (i.e. goals).
      // An ASIL should be annotated as revised if the associated goal supports
      // an ASIL decomposition strategy and requires revision. Otherwise, the
      // ASIL can be reused.
      if (gsnModelObj instanceof ASILfulElement) {
        if (((ASILfulElement) gsnModelObj).getAsil() != null) {
          var annotation = SafetyCaseFactory.eINSTANCE.createImpactAnnotation();
          annotation.setType(ImpactType.REUSE);
          annotation.setSource("Not applicable.");
          ((ASILfulElement) gsnModelObj).getAsil().setStatus(annotation);
          if (((ArgumentElement) gsnModelObj).getStatus().getType() == ImpactType.REVISE) {
            // Find the parent decomposable core elements.
            var supportableCur = new HashSet<Supportable>();
            var supportableNext = new HashSet<Supportable>();
            var supportableAll = new HashSet<Supportable>();
            for (SupportedBy rel: ((Goal) gsnModelObj).getSupports()) {
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
              annotation.setSource(((ArgumentElement) gsnModelObj).getStatus().getSource());
            }
          }
        }
      }
    }

    String annotatedPath = FileUtils.addFileNameSuffixInPath(this.input.model.getUri(), "_" + Output.OUT_MODEL);
    this.output.annotatedModel = this.input.model.getMetatype().createInstanceAndEditor(gsnRoot, annotatedPath,
                                                                                        this.output.mid);
  }
}
