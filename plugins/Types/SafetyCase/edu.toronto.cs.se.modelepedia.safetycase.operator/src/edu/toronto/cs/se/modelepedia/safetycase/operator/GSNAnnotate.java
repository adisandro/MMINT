/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Nick Fung.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Nick Fung - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.safetycase.ASILDecompositionStrategy;
import edu.toronto.cs.se.modelepedia.safetycase.ASILfulElement;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.CoreElement;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactType;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCaseFactory;
import edu.toronto.cs.se.modelepedia.safetycase.StatefulElement;
import edu.toronto.cs.se.modelepedia.safetycase.SupportConnector;
import edu.toronto.cs.se.modelepedia.safetycase.Supportable;
import edu.toronto.cs.se.modelepedia.safetycase.SupportedBy;

public class GSNAnnotate extends OperatorImpl {
  protected Input input;
  protected Output output;

  protected static class Input {
    private final static @NonNull String IN_REVISE = "revise";
    private final static @NonNull String IN_RECHECK_CONTENT = "recheck_content";
    private final static @NonNull String IN_RECHECK_STATE = "recheck_state";
    private ModelRel reviseRel;
    private ModelRel recheckContentRel;
    private ModelRel recheckStateRel;
    private Model scModel;

    public Input(Map<String, Model> inputsByName) {
      try {
        MID revise = (MID) inputsByName.get(Input.IN_REVISE).getEMFInstanceRoot();
        this.reviseRel = revise.getModelRels().get(0);
        MID recheckContent = (MID) inputsByName.get(Input.IN_RECHECK_CONTENT).getEMFInstanceRoot();
        this.recheckContentRel = recheckContent.getModelRels().get(0);
        MID recheckState = (MID) inputsByName.get(Input.IN_RECHECK_STATE).getEMFInstanceRoot();
        this.recheckStateRel = recheckState.getModelRels().get(0);
      }
      catch (Exception e) {
        throw new IllegalArgumentException();
      }
      this.scModel = this.reviseRel.getModelEndpoints().get(0).getTarget();
      Model sameSCModelContent = this.recheckContentRel.getModelEndpoints().get(0).getTarget();
      Model sameSCModelState = this.recheckStateRel.getModelEndpoints().get(0).getTarget();
      if (!this.scModel.getUri().equals(sameSCModelContent.getUri()) ||
          !this.scModel.getUri().equals(sameSCModelState.getUri())) {
        throw new IllegalArgumentException();
      }
    }
  }

  protected static class Output {
    private final static @NonNull String OUT_GSN = "annotated";
    private final static @NonNull String OUT_SUFFIX = "_annotated";
    private Model annotSCModel;
    private MID mid;

    public Output(@NonNull Map<String, MID> outputMIDsByName) {
      this.mid = outputMIDsByName.get(Output.OUT_GSN);
    }

    public @NonNull Map<String, Model> packed() {
      Map<String, Model> outputsByName = new HashMap<>();
      outputsByName.put(Output.OUT_GSN, this.annotSCModel);
      return outputsByName;
    }
  }

  public static class Constraint implements IJavaOperatorConstraint {
    @Override
    public boolean isAllowedInput(@NonNull Map<String, Model> inputsByName) {
      try {
        new Input(inputsByName);
        return true;
      }
      catch (IllegalArgumentException e) {
        return false;
      }
    }
  }

    protected void annotate() throws Exception {

        SafetyCase scRoot = (SafetyCase) this.input.scModel.getEMFInstanceRoot();
        Resource scResource = scRoot.eResource();

        // Extract all argument elements that requires revision and prepare to extract their causes.
        Set<ArgumentElement> scReviseObjs = new HashSet<>();
        Map<ArgumentElement, String> scRevise2impactSrcs = new HashMap<>();
        for (ModelElementReference scReviseElemRef : this.input.reviseRel.getModelEndpointRefs().get(0).getModelElemRefs()) {
            EObject reviseObj;
            try {
                reviseObj = scReviseElemRef.getObject().getEMFInstanceObject(scResource);
            }
            catch (MMINTException e) {
                MMINTException.print(IStatus.WARNING, "Skipping element to revise " +
                                                      scReviseElemRef.getObject().getName(), e);
                continue;
            }
            if (reviseObj instanceof ArgumentElement) {
                scReviseObjs.add((ArgumentElement) reviseObj);
                scRevise2impactSrcs.put((ArgumentElement) reviseObj, "");
            }
        }

        // Extract the cause(s) of the required revisions.
        // Note: It is assumed that there may be a many-to-many mapping between
        // the safety case elements to be revised and the causes of those revisions.
        for (Mapping srcMapping : this.input.reviseRel.getMappings()) {
          String impactSrc = srcMapping.getName().replace("+", ", ");
          for (ModelElementEndpoint elemEndpoint : srcMapping.getModelElemEndpoints()) {
            EObject reviseObj;
            try {
              reviseObj = elemEndpoint.getTarget().getEMFInstanceObject(scResource);
            } catch (MMINTException e){
                    MMINTException.print(IStatus.WARNING, "Skipping element to revise " +
                            elemEndpoint.getTarget().getName(), e);
                    continue;
            }


            if (reviseObj instanceof ArgumentElement) {
              if (scRevise2impactSrcs.get(reviseObj).equals("")) {
                scRevise2impactSrcs.put((ArgumentElement) reviseObj, impactSrc);
              } else {
                  String srcString = scRevise2impactSrcs.get(reviseObj).concat(", " + impactSrc);
                  scRevise2impactSrcs.put((ArgumentElement) reviseObj, srcString);
              }
            }
          }
        }

        // Extract all argument elements whose content requires rechecking and prepare to extract their causes.
        Set<ArgumentElement> scRecheckContentObjs = new HashSet<>();
        Map<ArgumentElement, String> scRecheckContent2impactSrcs = new HashMap<>();
        for (ModelElementReference scRecheckElemRef: this.input.recheckContentRel.getModelEndpointRefs().get(0).getModelElemRefs()) {
            EObject recheckObj;
            try {
                recheckObj = scRecheckElemRef.getObject().getEMFInstanceObject(scResource);
            }
            catch (MMINTException e) {
                MMINTException.print(IStatus.WARNING, "Skipping element to recheck " +
                                                      scRecheckElemRef.getObject().getName(), e);
                continue;
            }
            if (recheckObj instanceof ArgumentElement && !scReviseObjs.contains(recheckObj)) {
                scRecheckContentObjs.add((ArgumentElement) recheckObj);
                scRecheckContent2impactSrcs.put((ArgumentElement) recheckObj, "");
            }
        }

        // Extract the cause(s) of the required rechecks.
        // Note: It is assumed that there may be a many-to-many mapping between
        // the safety case elements to be rechecked and the causes of those rechecks.
        for (Mapping srcMapping : this.input.recheckContentRel.getMappings()) {
          String impactSrc = srcMapping.getName().replace("+", ", ");
          for (ModelElementEndpoint elemEndpoint : srcMapping.getModelElemEndpoints()) {
            EObject recheckObj;
            try {
              recheckObj = elemEndpoint.getTarget().getEMFInstanceObject(scResource);
            } catch (MMINTException e){
                    MMINTException.print(IStatus.WARNING, "Skipping element to revise " +
                            elemEndpoint.getTarget().getName(), e);
                    continue;
            }


            if (recheckObj instanceof ArgumentElement) {
              if (scRecheckContent2impactSrcs.containsKey(recheckObj)) {
                if (scRecheckContent2impactSrcs.get(recheckObj).equals("")) {
                  scRecheckContent2impactSrcs.put((ArgumentElement) recheckObj, impactSrc);
                } else {
                  String srcString = scRecheckContent2impactSrcs.get(recheckObj).concat(", " + impactSrc);
                  scRecheckContent2impactSrcs.put((ArgumentElement) recheckObj, srcString);
                }
              }
            }
          }
        }

        // Extract all argument elements whose state requires rechecking and prepare to extract their causes.
        Set<StatefulElement> scRecheckStateObjs = new HashSet<>();
        Map<StatefulElement, String> scRecheckState2impactSrcs = new HashMap<>();
        for (ModelElementReference scRecheckElemRef: this.input.recheckStateRel.getModelEndpointRefs().get(0).getModelElemRefs()) {
            EObject recheckObj;
            try {
                recheckObj = scRecheckElemRef.getObject().getEMFInstanceObject(scResource);
            }
            catch (MMINTException e) {
                MMINTException.print(IStatus.WARNING, "Skipping element to recheck " +
                                                      scRecheckElemRef.getObject().getName(), e);
                continue;
            }
            if (recheckObj instanceof StatefulElement) {
                scRecheckStateObjs.add((StatefulElement) recheckObj);
                scRecheckState2impactSrcs.put((StatefulElement) recheckObj, "");
            }
        }

        // Extract the cause(s) of the required rechecks.
        // Note: It is assumed that there may be a many-to-many mapping between
        // the safety case elements to be rechecked and the causes of those rechecks.
        for (Mapping srcMapping : this.input.recheckStateRel.getMappings()) {
          String impactSrc = srcMapping.getName().replace("+", ", ");
          for (ModelElementEndpoint elemEndpoint : srcMapping.getModelElemEndpoints()) {
            EObject recheckObj;
            try {
              recheckObj = elemEndpoint.getTarget().getEMFInstanceObject(scResource);
            } catch (MMINTException e){
                    MMINTException.print(IStatus.WARNING, "Skipping element to revise " +
                            elemEndpoint.getTarget().getName(), e);
                    continue;
            }


            if (recheckObj instanceof StatefulElement) {
              if (scRecheckState2impactSrcs.containsKey(recheckObj)) {
                if (scRecheckState2impactSrcs.get(recheckObj).equals("")) {
                  scRecheckState2impactSrcs.put((StatefulElement) recheckObj, impactSrc);
                } else {
                  String srcString = scRecheckState2impactSrcs.get(recheckObj).concat(", " + impactSrc);
                  scRecheckState2impactSrcs.put((StatefulElement) recheckObj, srcString);
                }
              }
            }
          }
        }

        // Iterate through each argument element and update its status.
        Iterator<EObject> scIter = scRoot.eAllContents();
        while (scIter.hasNext()) {
            EObject scObj = scIter.next();

            if (scObj instanceof ArgumentElement) {
              ImpactAnnotation annotation = SafetyCaseFactory.eINSTANCE.createImpactAnnotation();

                if (scReviseObjs.contains(scObj)) {
                  annotation.setType(ImpactType.REVISE);
                  annotation.setSource(scRevise2impactSrcs.get(scObj));
                    ((ArgumentElement) scObj).setStatus(annotation);

                } else if (scRecheckContentObjs.contains(scObj)) {
                  annotation.setType(ImpactType.RECHECK_CONTENT);
                  annotation.setSource(scRecheckContent2impactSrcs.get(scObj));
                    ((ArgumentElement) scObj).setStatus(annotation);

                } else if (scRecheckStateObjs.contains(scObj)) {
                    annotation.setType(ImpactType.RECHECK_STATE);
                    annotation.setSource(scRecheckState2impactSrcs.get(scObj));
                    ((ArgumentElement) scObj).setStatus(annotation);

                } else {
                  annotation.setType(ImpactType.REUSE);
                  annotation.setSource("Not applicable.");
                    ((ArgumentElement) scObj).setStatus(annotation);
                }

            }

            // Annotate the ASILs of the ASILful elements (i.e. goals).
            // An ASIL should be annotated as revised if the associated goal supports
            // an ASIL decomposition strategy and requires revision. Otherwise, the
            // ASIL can be reused.
            if (scObj instanceof ASILfulElement) {
              CoreElement elem = (CoreElement) scObj;

              if (((ASILfulElement) scObj).getAsil() != null) {
                ImpactAnnotation annotation = SafetyCaseFactory.eINSTANCE.createImpactAnnotation();

                annotation.setType(ImpactType.REUSE);
                annotation.setSource("Not applicable.");
                ((ASILfulElement) scObj).getAsil().setStatus(annotation);

                if (scReviseObjs.contains(scObj)) {
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
                    annotation.setSource(scRevise2impactSrcs.get(scObj));
                  }
                }
              }
            }
        }

        // Create output
        String annotSCModelPath = FileUtils.addFileNameSuffixInPath(this.input.scModel.getUri(), Output.OUT_SUFFIX);
        this.output.annotSCModel = this.input.scModel.getMetatype().createInstanceAndEditor(scRoot, annotSCModelPath, this.output.mid);
    }

  protected void init(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, MID> outputMIDsByName) {
    this.input = new Input(inputsByName);
    this.output = new Output(outputMIDsByName);
  }

  @Override
  public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                Map<String, MID> outputMIDsByName) throws Exception {
    //TODO change to use model rels as input
    // Extract the model relationships that point to GSN elements requiring revision or rechecking.
    init(inputsByName, outputMIDsByName);
    // annotate elements to be revised/rechecked/reused in the safety case model
    annotate();
    return this.output.packed();
  }
}
