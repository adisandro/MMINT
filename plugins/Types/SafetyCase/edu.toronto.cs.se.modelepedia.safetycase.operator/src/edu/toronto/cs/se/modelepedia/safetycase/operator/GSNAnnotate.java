/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.Status;

public class GSNAnnotate extends OperatorImpl {

    // input-output
    private final static @NonNull String IN_REVISE = "revise";
    private final static @NonNull String IN_RECHECK = "recheck";
    private final static @NonNull String OUT_GSN = "annotated";
    // constants
    private final static @NonNull String OUT_SUFFIX = "_annotated";

    private static class Input {

        private ModelRel reviseRel;
        private ModelRel recheckRel;
        private Model scModel;

        public Input(Map<String, Model> inputsByName) {

            try {
                MID revise = (MID) inputsByName.get(IN_REVISE).getEMFInstanceRoot();
                this.reviseRel = revise.getModelRels().get(0);
                MID recheck = (MID) inputsByName.get(IN_RECHECK).getEMFInstanceRoot();
                this.recheckRel = recheck.getModelRels().get(0);
            }
            catch (MMINTException e) {
                throw new IllegalArgumentException();
            }
            this.scModel = this.reviseRel.getModelEndpoints().get(0).getTarget();
            Model sameSCModel = this.recheckRel.getModelEndpoints().get(0).getTarget();
            if (!this.scModel.getUri().equals(sameSCModel.getUri())) {
                throw new IllegalArgumentException();
            }
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

    private Model annotate(@NonNull Model scModel, @NonNull ModelRel reviseRel, @NonNull ModelRel recheckRel,
                           @Nullable MID outputMID) throws Exception {

        SafetyCase scRoot = (SafetyCase) scModel.getEMFInstanceRoot();
        Resource scResource = scRoot.eResource();

        // Extract all argument elements that requires revision.
        Set<ArgumentElement> scReviseObjs = new HashSet<>();
        for (ModelElementReference scReviseElemRef : reviseRel.getModelEndpointRefs().get(0).getModelElemRefs()) {
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
            }
        }

        // Extract all argument elements that requires rechecking.
        Set<ArgumentElement> scRecheckObjs = new HashSet<>();
        for (ModelElementReference scRecheckElemRef: recheckRel.getModelEndpointRefs().get(0).getModelElemRefs()) {
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
                scRecheckObjs.add((ArgumentElement) recheckObj);
            }
        }

        // Iterate through each argument element and update its status.
        Iterator<EObject> scIter = scRoot.eAllContents();
        while (scIter.hasNext()) {
            EObject scObj = scIter.next();
            if (!(scObj instanceof ArgumentElement)) {
                continue;
            }
            if (scReviseObjs.contains(scObj)) {
                ((ArgumentElement) scObj).setStatus(Status.REVISE);
            }
            else if (scRecheckObjs.contains(scObj)) {
                ((ArgumentElement) scObj).setStatus(Status.RECHECK);
            }
            else {
                ((ArgumentElement) scObj).setStatus(Status.REUSE);
            }
        }

        // Create output
        String annotSCModelPath = FileUtils.addFileNameSuffixInPath(scModel.getUri(), OUT_SUFFIX);

        return scModel.getMetatype().createInstanceAndEditor(scRoot, annotSCModelPath, outputMID);
    }

    @Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
                                  Map<String, MID> outputMIDsByName) throws Exception {

        //TODO change to use model rels as input
        // Extract the model relationships that point to GSN elements requiring revision or rechecking.
        Input input = new Input(inputsByName);
        MID outputMID = outputMIDsByName.get(OUT_GSN);

        // annotate elements to be revised/rechecked/reused in the safety case model
        Model annotSCModel = annotate(input.scModel, input.reviseRel, input.recheckRel, outputMID);

        // output
        Map<String, Model> outputsByName = new HashMap<>();
        outputsByName.put(OUT_GSN, annotSCModel);

        return outputsByName;
    }

}