/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
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

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.library.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.modelepedia.operator.match.EMFModelNameMatch;

public class EMFModelDifference extends OperatorExecutableImpl {

	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelNameMatch";
	private final static String MODELREL_NAME = "diff";
	private final static String DELETED_ELEMENT_LINK_NAME = "del";
	private final static String ADDED_ELEMENT_LINK_NAME = "add";

	private void createLinkReference(ModelRel diffModelRel, ModelEndpointReference diffModelEndpointRef, EObject modelObj, String linksName) throws MMTFException {

		// create unary link
		LinkReference diffLinkRef = MultiModelInstanceFactory.createLinkAndLinkReference(
			null,
			diffModelRel,
			RelationshipPackage.eINSTANCE.getLink(),
			RelationshipPackage.eINSTANCE.getLinkReference()
		);
		diffLinkRef.getObject().setName(linksName);
		// create model element
		ModelElementReference diffModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
			diffModelEndpointRef,
			null,
			modelObj
		);
		// create model element endpoint
		MultiModelInstanceFactory.createModelElementEndpointAndModelElementEndpointReference(
			null,
			diffLinkRef,
			diffModelElemRef,
			false
		);
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		ModelRel matchRel = (ModelRel) actualParameters.get(1);

		// create diff model relationship
		MultiModel multiModel = MultiModelRegistry.getMultiModel(matchRel);
		ModelRel diffModelRel = MultiModelInstanceFactory.createModelRel(
			null,
			null,
			ModelOrigin.CREATED,
			RelationshipPackage.eINSTANCE.getBinaryModelRel(),
			multiModel
		);
		diffModelRel.setName(MODELREL_NAME);

		// create model endpoints
		ModelEndpointReference srcModelEndpointRef = MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
			null,
			diffModelRel,
			matchRel.getModelEndpoints().get(0).getTarget(),
			false
		);
		ModelEndpointReference tgtModelEndpointRef = MultiModelInstanceFactory.createModelEndpointAndModelEndpointReference(
			null,
			diffModelRel,
			matchRel.getModelEndpoints().get(1).getTarget(),
			false
		);

		// get output from previous operator
		EMFModelNameMatch previousOperator = (previousExecutable == null) ?
			(EMFModelNameMatch) MultiModelTypeRegistry.<Operator>getExtendibleElementType(PREVIOUS_OPERATOR_URI).getExecutable() :
			(EMFModelNameMatch) previousExecutable;
		Comparison comparison = previousOperator.getComparison();
		for (Diff diff : comparison.getDifferences()) {
			if (!(diff instanceof ReferenceChange)) {
				continue;
			}
			switch (diff.getKind()) {
				case ADD:
					createLinkReference(diffModelRel, srcModelEndpointRef, ((ReferenceChange) diff).getValue(), DELETED_ELEMENT_LINK_NAME);
					break;
				case DELETE:
					createLinkReference(diffModelRel, tgtModelEndpointRef, ((ReferenceChange) diff).getValue(), ADDED_ELEMENT_LINK_NAME);
					break;
				default:
					break;
			}
		}

		EList<Model> result = new BasicEList<Model>();
		result.add(diffModelRel);
		return result;
	}

}
