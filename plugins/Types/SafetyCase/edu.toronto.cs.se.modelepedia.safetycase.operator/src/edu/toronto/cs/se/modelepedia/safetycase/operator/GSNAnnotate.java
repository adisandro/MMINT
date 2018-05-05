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
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.safetycase.ArgumentElement;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactAnnotation;
import edu.toronto.cs.se.modelepedia.safetycase.ImpactType;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCase;
import edu.toronto.cs.se.modelepedia.safetycase.SafetyCaseFactory;

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

        // Extract all argument elements that requires revision and prepare to extract their causes.
        Set<ArgumentElement> scReviseObjs = new HashSet<>();
        Map<ArgumentElement, String> scRevise2impactSrcs = new HashMap<>();
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
                scRevise2impactSrcs.put((ArgumentElement) reviseObj, "");
            }
        }
        
        // Extract the cause(s) of the required revisions.
        // Note: It is assumed that there may be a many-to-many mapping between
        // the safety case elements to be revised and the causes of those revisions.      
        for (Mapping srcMapping : reviseRel.getMappings()) {
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

        // Extract all argument elements that requires rechecking and prepare to extract their causes.
        Set<ArgumentElement> scRecheckObjs = new HashSet<>();
        Map<ArgumentElement, String> scRecheck2impactSrcs = new HashMap<>();
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
                scRecheck2impactSrcs.put((ArgumentElement) recheckObj, "");
            }
        }
        
        // Extract the cause(s) of the required rechecks.
        // Note: It is assumed that there may be a many-to-many mapping between
        // the safety case elements to be rechecked and the causes of those rechecks.      
        for (Mapping srcMapping : recheckRel.getMappings()) {
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
        			if (scRecheck2impactSrcs.containsKey(recheckObj)) {
        				if (scRecheck2impactSrcs.get(recheckObj).equals("")) {
        					scRecheck2impactSrcs.put((ArgumentElement) recheckObj, impactSrc);
        				} else {
        					String srcString = scRecheck2impactSrcs.get(recheckObj).concat(", " + impactSrc);
        					scRecheck2impactSrcs.put((ArgumentElement) recheckObj, srcString);        				
        				}
        			}
        		}
        	}
        }

        // Iterate through each argument element and update its status.
        Iterator<EObject> scIter = scRoot.eAllContents();
        while (scIter.hasNext()) {
            EObject scObj = scIter.next();
            if (!(scObj instanceof ArgumentElement)) {
                continue;
            }
            
            ImpactAnnotation annotation = SafetyCaseFactory.eINSTANCE.createImpactAnnotation();
            if (scReviseObjs.contains(scObj)) {
            	annotation.setType(ImpactType.REVISE);
            	annotation.setSource(scRevise2impactSrcs.get(scObj));
                ((ArgumentElement) scObj).setStatus(annotation);
            }
            else if (scRecheckObjs.contains(scObj)) {
            	annotation.setType(ImpactType.RECHECK); 
            	annotation.setSource(scRecheck2impactSrcs.get(scObj));
                ((ArgumentElement) scObj).setStatus(annotation);
            }
            else {
            	annotation.setType(ImpactType.REUSE);
            	annotation.setSource("Not applicable.");
                ((ArgumentElement) scObj).setStatus(annotation);
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
