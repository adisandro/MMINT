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
package edu.toronto.cs.se.nlsfung.gsn.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.nlsfung.gsn.ArgumentElement;
import edu.toronto.cs.se.nlsfung.gsn.Goal;
import edu.toronto.cs.se.nlsfung.gsn.SafetyCase;
import edu.toronto.cs.se.nlsfung.gsn.Status;

public class GSNAnnotate extends OperatorImpl {
	
	// input-output
	private final static @NonNull String IN_REVISE = "revise";
	private final static @NonNull String IN_RECHECK = "recheck";
	private final static @NonNull String OUT_GSN = "annotate";

	@Override
    public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
            Map<String, MID> outputMIDsByName) throws Exception {
		
		// Extract the model relationships that point to GSN elements requiring revision or rechecking.
		Model inRel1 = inputsByName.get(IN_REVISE);
		MID revise = (MID) inRel1.getEMFInstanceRoot();
		ModelRel reviseRel = revise.getModelRels().get(0);
		
		Model inRel2 = inputsByName.get(IN_RECHECK);		
		MID recheck = (MID) inRel2.getEMFInstanceRoot();
		ModelRel recheckRel = recheck.getModelRels().get(0);
		
		// Extract the safety case referred to by the model relationships.
		ModelEndpointReference reviseEndpointRef = reviseRel.getModelEndpointRefs().get(0);
		ModelEndpointReference recheckEndpointRef = recheckRel.getModelEndpointRefs().get(0);
		Model scModel = reviseEndpointRef.getObject().getTarget();
		SafetyCase sc = (SafetyCase) scModel.getEMFInstanceRoot();
		Resource scResource = sc.eResource();
		
		// Extract all argument elements from the safety case.
		Set<ArgumentElement> scElemSet = new HashSet();
		EObject curElem;
		Iterator<EObject> scElemIt = sc.eAllContents();
		while (scElemIt.hasNext()) {
			curElem = scElemIt.next();
			if (curElem instanceof ArgumentElement) {
				System.out.println(curElem);
				scElemSet.add((ArgumentElement) curElem);
			}
		}
		
		// Extract all argument elements that requires revision.
		Set<ArgumentElement> scReviseSet = new HashSet();
		for (ModelElementReference elemRef: reviseEndpointRef.getModelElemRefs()) {
			curElem = elemRef.getObject().getEMFInstanceObject(scResource);
			if (curElem instanceof ArgumentElement) {
				System.out.println(curElem);
				scReviseSet.add((ArgumentElement) curElem);
			}
		}		
		
		// Extract all argument elements that requires rechecking.
		Set<ArgumentElement> scRecheckSet = new HashSet();
		for (ModelElementReference elemRef: recheckEndpointRef.getModelElemRefs()) {
			curElem = elemRef.getObject().getEMFInstanceObject(scResource);
			if (curElem instanceof ArgumentElement) {
				if (!scReviseSet.contains(curElem)) {
					System.out.println(curElem);
					scRecheckSet.add((ArgumentElement) curElem);
				}
			}
		}
		
		// Iterate through each argument element and update its status.
		for (ArgumentElement elem: scElemSet) {
			System.out.print(elem);
			if (scReviseSet.contains(elem)) {
				elem.setStatus(Status.REVISE);
			} else if (scRecheckSet.contains(elem)) {
				elem.setStatus(Status.RECHECK);
			} else {
				elem.setStatus(Status.REUSE);
			}
		}
		
		// output		
		String outUri = FileUtils.addFileNameSuffixInPath(scModel.getUri(), "_annotated");
		FileUtils.writeModelFile(sc, outUri, true);
		Model out = scModel.getMetatype().createInstanceAndEditor(null, outUri, outputMIDsByName.get(OUT_GSN));

		Map<String, Model> outputs = new HashMap<>();
		outputs.put(OUT_GSN, out);
		
        return outputs;
    }

}