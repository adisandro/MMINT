/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.diff;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.impl.ModelElementImpl;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.Link;
import edu.toronto.cs.se.mmint.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.operator.match.EMFModelMatch;

public class EMFModelDifference extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELREL = "match";
	private final static @NonNull String OUT_MODELREL = "diff";
	// constants
	private final static @NonNull String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelMatch";
	private final static @NonNull String MODELREL_NAME = "diff";
	private final static @NonNull String DELETED_ELEMENT_LINK_NAME = "del";
	private final static @NonNull String ADDED_ELEMENT_LINK_NAME = "add";

	private void createLinkReference(Link rootLinkType, ModelElementEndpoint rootModelElemTypeEndpoint, ModelRel diffModelRel, ModelEndpointReference diffModelEndpointRef, EObject modelObj, String linksName) throws MMINTException {

		// create unary link
		LinkReference diffLinkRef = rootLinkType.createInstanceAndReference(false, diffModelRel);
		diffLinkRef.getObject().setName(linksName);
		// create model element
		ModelElementReference diffModelElemRef = ModelElementImpl.createMAVOInstanceAndReference(modelObj, null, diffModelEndpointRef);
		// create model element endpoint
		rootModelElemTypeEndpoint.createInstanceAndReference(diffModelElemRef, diffLinkRef);
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		ModelRel matchRel = (ModelRel) inputsByName.get(IN_MODELREL);

		// create diff model relationship
		MultiModel instanceMID = outputMIDsByName.get(OUT_MODELREL);
		ModelRel rootModelRelType = MultiModelTypeHierarchy.getRootModelRelType();
		ModelRel diffModelRel = rootModelRelType.createInstance(null, true, ModelOrigin.CREATED, instanceMID);
		diffModelRel.setName(MODELREL_NAME);
		// create model endpoints
		ModelEndpoint rootModelTypeEndpoint = MultiModelTypeHierarchy.getRootModelTypeEndpoint();
		ModelEndpointReference srcModelEndpointRef = rootModelTypeEndpoint.createInstanceAndReference(matchRel.getModelEndpoints().get(0).getTarget(), diffModelRel);
		ModelEndpointReference tgtModelEndpointRef = rootModelTypeEndpoint.createInstanceAndReference(matchRel.getModelEndpoints().get(1).getTarget(), diffModelRel);
		// get output from previous operator
		EMFModelMatch previousOperator = (getPreviousOperator() == null) ?
			(EMFModelMatch) MultiModelTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR_URI) :
			(EMFModelMatch) getPreviousOperator();
		Comparison comparison = previousOperator.getComparison();
		Link rootLinkType = MultiModelTypeHierarchy.getRootLinkType();
		ModelElementEndpoint rootModelElemTypeEndpoint = MultiModelTypeHierarchy.getRootModelElementTypeEndpoint();
nextDiff:
		for (Diff diff : comparison.getDifferences()) {
			if (!(diff instanceof ReferenceChange)) {
				continue;
			}
			EObject modelObj = ((ReferenceChange) diff).getValue();
			ModelEndpointReference modelEndpointRef = null;
			String linkName = null; 
			switch (diff.getKind()) {
				case ADD:
					modelEndpointRef = srcModelEndpointRef;
					linkName = DELETED_ELEMENT_LINK_NAME;
					break;
				case DELETE:
					modelEndpointRef = tgtModelEndpointRef;
					linkName = ADDED_ELEMENT_LINK_NAME;
					break;
				default:
					continue nextDiff;
			}
			ModelElementReference modelElemRef = MultiModelRegistry.getModelElementReference(matchRel.getModelEndpointRefs().get(0), modelObj);
			if (modelElemRef != null && !modelElemRef.getModelElemEndpointRefs().isEmpty()) { // is matched
				continue;
			}
			modelElemRef = MultiModelRegistry.getModelElementReference(modelEndpointRef, modelObj);
			if (modelElemRef != null && !modelElemRef.getModelElemEndpointRefs().isEmpty()) { // is already in diff
				continue;
			}
			createLinkReference(rootLinkType, rootModelElemTypeEndpoint, diffModelRel, modelEndpointRef, modelObj, linkName);
		}

		// output
		Map<String, Model> outputs = new HashMap<>();
		outputs.put(OUT_MODELREL, diffModelRel);

		return outputs;
	}

}
