/**
 * Copyright (c) 2012-2024 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 *   Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.gsn.operator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.operator.slice.AnnotateSlice;
import edu.toronto.cs.se.mmint.operator.slice.Slice.SliceType;
import edu.toronto.cs.se.modelepedia.gsn.ASILfulElement;
import edu.toronto.cs.se.modelepedia.gsn.ArgumentElement;
import edu.toronto.cs.se.modelepedia.gsn.GSNFactory;
import edu.toronto.cs.se.modelepedia.gsn.Goal;
import edu.toronto.cs.se.modelepedia.gsn.ImpactType;
import edu.toronto.cs.se.modelepedia.gsn.RelationshipDecorator;
import edu.toronto.cs.se.modelepedia.gsn.SafetyCase;
import edu.toronto.cs.se.modelepedia.gsn.Supportable;
import edu.toronto.cs.se.modelepedia.gsn.SupportedBy;
import edu.toronto.cs.se.modelepedia.gsn.Supporter;
import edu.toronto.cs.se.modelepedia.gsn.operator.GSNSlice.GSNSliceType;

public class GSNAnnotateSlice extends AnnotateSlice {

  protected static class GSNOutput extends Output {
    public SafetyCase gsnRoot;

    public GSNOutput(Input input, Map<String, MID> outputMIDsByName) {
      super(input, outputMIDsByName);
      this.annotatedPath = FileUtils.addFileNameSuffixInPath(input.model.getUri(), "_" + Output.OUT_MODEL);
      this.annotatedModelType = input.model.getMetatype();
    }

    @Override
    public Map<String, Model> packed() throws MMINTException, IOException {
      var annotatedModel = this.annotatedModelType.createInstanceAndEditor(this.gsnRoot, this.annotatedPath, this.mid);

      return Map.of(Output.OUT_MODEL, annotatedModel);
    }
  }

  @Override
  protected void init(Map<String, Model> inputsByName, Map<String, MID> outputMIDsByName) {
    this.input = new Input(inputsByName);
    this.output = new GSNOutput(this.input, outputMIDsByName);
  }

  private void annotateModelElem(ArgumentElement gsnModelObj, @Nullable String cause, String annotationId) {
    var annotation = GSNFactory.eINSTANCE.createImpactAnnotation();
    annotation.setSource(cause);
    var impactType = switch (annotationId) {
      case SliceType.DEL, SliceType.REVISE -> ImpactType.REVISE;
      case SliceType.MOD, SliceType.RECHECK, GSNSliceType.RECHECK_CONTENT -> ImpactType.RECHECK;
      case GSNSliceType.RECHECK_STATE -> ImpactType.RECHECK;
      case SliceType.ADD -> ImpactType.REUSE; //TODO MMINT[SLICE] Not supported yet
      default -> ImpactType.REUSE;
    };
    annotation.setType(impactType);
    gsnModelObj.setStatus(annotation);
  }

  private void annotateSliceTypes(ModelRel rel) {
    var alreadyAnnotated = new HashSet<String>();
    for (var mappingRef : rel.getMappingRefs()) {
      var annotationId = mappingRef.getObject().getMetatypeUri();
      for (var modelElemEndpointRef : mappingRef.getModelElemEndpointRefs()) {
        var modelElemRef = modelElemEndpointRef.getModelElemRef();
        var modelElem = modelElemRef.getObject();
        // annotate each model element once, extracting all mappings attached as causes
        if (alreadyAnnotated.contains(modelElem.getUri())) {
          continue;
        }
        var gsnModelObj = modelElem.getEMFInstanceObject();
        if (!(gsnModelObj instanceof ArgumentElement)) {
          continue;
        }
        var cause = modelElemRef.getModelElemEndpointRefs().stream()
          .map(meer -> ((MappingReference) meer.eContainer()).getObject())
          .filter(m -> m.getMetatypeUri().equals(annotationId)) // discard lower priority causes
          .map(Mapping::getName)
          .collect(Collectors.joining(", "));
        annotateModelElem((ArgumentElement) gsnModelObj, cause, annotationId);
        alreadyAnnotated.add(modelElem.getUri());
      }
    }
  }

  @Override
  protected void annotate() throws Exception {
    // annotate sliced elements first..
    ((GSNOutput) this.output).gsnRoot = (SafetyCase) this.input.model.getEMFInstanceRoot();
    annotateSliceTypes(this.input.sliceRel);
    // ..then iterate through each argument element and annotate with REUSE
    Iterator<EObject> gsnIter = ((GSNOutput) this.output).gsnRoot.eAllContents();
    while (gsnIter.hasNext()) {
      var gsnModelObj = gsnIter.next();
      if (!(gsnModelObj instanceof ArgumentElement)) {
        continue;
      }
      if (((ArgumentElement) gsnModelObj).getStatus() == null) {
        var annotation = GSNFactory.eINSTANCE.createImpactAnnotation();
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
          var annotation = GSNFactory.eINSTANCE.createImpactAnnotation();
          annotation.setType(ImpactType.REUSE);
          annotation.setSource("Not applicable.");
          ((ASILfulElement) gsnModelObj).getAsil().setStatus(annotation);
          if (((ArgumentElement) gsnModelObj).getStatus().getType() == ImpactType.REVISE) {
            // Find the parent decomposable core elements.
            var supportableCur = new HashSet<Supportable>();
            var supportableNext = new HashSet<Supportable>();
            var supportableAll = new HashSet<Supportable>();
            for (SupportedBy rel : ((Goal) gsnModelObj).getSupports()) {
              supportableCur.add(rel.getSource());
              supportableAll.add(rel.getSource());
            }
            while (!supportableCur.isEmpty()) {
              for (Supportable curElem : supportableCur) {
                if (curElem instanceof RelationshipDecorator) {
                  for (SupportedBy rel : ((Supporter) curElem.eContainer()).getSupports()) {
                    supportableNext.add(rel.getSource());
                  }
                }
              }
              supportableCur.clear();
              for (Supportable nextElem : supportableNext) {
                if (!supportableAll.contains(nextElem)) {
                  supportableAll.add(nextElem);
                  supportableCur.add(nextElem);
                }
              }
              supportableNext.clear();
            }
          }
        }
      }
    }
  }
}
