/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.ReferenceChange;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
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
import edu.toronto.cs.se.modelepedia.operator.match.EMFModelNameMatch;

public class EMFModelDifference extends OperatorImpl {

	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelNameMatch";
	private final static String MODELREL_NAME = "diff";
	private final static String DELETED_ELEMENT_LINK_NAME = "del";
	private final static String ADDED_ELEMENT_LINK_NAME = "add";

	private void createLinkReference(Link rootLinkType, ModelElementEndpoint rootModelElemTypeEndpoint, ModelRel diffModelRel, ModelEndpointReference diffModelEndpointRef, EObject modelObj, String linksName) throws MMINTException {

		// create unary link
		LinkReference diffLinkRef = rootLinkType.createInstanceAndReference(false, diffModelRel);
		diffLinkRef.getObject().setName(linksName);
		// create model element
		ModelElementReference diffModelElemRef = ModelElementImpl.createMAVOInstanceAndReference(modelObj, null, diffModelEndpointRef);
		// create model element endpoint
		rootModelElemTypeEndpoint.createInstanceAndReference(diffModelElemRef, false, diffLinkRef);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		ModelRel matchRel = (ModelRel) actualParameters.get(1);

		// create diff model relationship
		MultiModel multiModel = MultiModelRegistry.getMultiModel(matchRel);
		ModelRel rootModelRelType = MultiModelTypeHierarchy.getRootModelRelType();
		ModelRel diffModelRel = rootModelRelType.createInstance(null, true, ModelOrigin.CREATED, multiModel);
		diffModelRel.setName(MODELREL_NAME);

		// create model endpoints
		ModelEndpoint rootModelTypeEndpoint = MultiModelTypeHierarchy.getRootModelTypeEndpoint();
		ModelEndpointReference srcModelEndpointRef = rootModelTypeEndpoint.createInstanceAndReference(matchRel.getModelEndpoints().get(0).getTarget(), false, diffModelRel);
		ModelEndpointReference tgtModelEndpointRef = rootModelTypeEndpoint.createInstanceAndReference(matchRel.getModelEndpoints().get(1).getTarget(), false, diffModelRel);

		// get output from previous operator
		EMFModelNameMatch previousOperator = (getPreviousOperator() == null) ?
			(EMFModelNameMatch) MultiModelTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR_URI) :
			(EMFModelNameMatch) getPreviousOperator();
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

		EList<Model> result = new BasicEList<Model>();
		result.add(diffModelRel);
		return result;
	}

}
