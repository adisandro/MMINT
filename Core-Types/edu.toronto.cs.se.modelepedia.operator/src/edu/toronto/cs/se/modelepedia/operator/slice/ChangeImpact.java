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
package edu.toronto.cs.se.modelepedia.operator.slice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeHierarchy;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mavo.library.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;

public class ChangeImpact extends OperatorExecutableImpl {

	private final static String MODELREL_NAME = "impact";
	private final static String LINKREF_NAME = "impact";
	private final static String SRC_MODELELEMENDPOINT_NAME = "diff";
	private final static String TGT_MODELELEMENDPOINT_NAME = "impacted";

	private void createOrigVarTables(ModelEndpointReference modelEndpointRef, HashMap<String, List<ModelElementReference>> unifyTable, HashMap<String, List<ModelElementReference>> typeTable) {

		// O(n) + O(m i log i), O(n) best case when m=n and i=1, O(n log n) worst case when m=1 and i=n
		// type table
		for (ModelElementReference modelElemRef : modelEndpointRef.getModelElemRefs()) { // O(n)
			String modelElemTypeUri = modelElemRef.getObject().getMetatypeUri();
			List<ModelElementReference> unifiablesFromSameType = typeTable.get(modelElemTypeUri);
			if (unifiablesFromSameType == null) {
				unifiablesFromSameType = new ArrayList<ModelElementReference>();
				typeTable.put(modelElemTypeUri, unifiablesFromSameType);
			}
			unifiablesFromSameType.add(modelElemRef);
		}
		// merge table
		for (List<ModelElementReference> unifiablesFromSameType : typeTable.values()) { // + O(m), m<=n
			for (ModelElementReference modelElemRef : unifiablesFromSameType) {
				List<ModelElementReference> unifiables = new ArrayList<ModelElementReference>();
				unifyTable.put(modelElemRef.getUri(), unifiables);
				unifiables.add(modelElemRef);
			}
			for (int i = 0; i < unifiablesFromSameType.size(); i++) { // * O(i), i<=n, SUM(i_k)=n for k=0..m
				ModelElementReference modelElemRef = unifiablesFromSameType.get(i);
				List<ModelElementReference> unifiables = unifyTable.get(modelElemRef.getUri());
				for (int j = i+1; j < unifiablesFromSameType.size(); j++) { // * O(log i)
					ModelElementReference modelElemRef2 = unifiablesFromSameType.get(j);
					List<ModelElementReference> unifiables2 = unifyTable.get(modelElemRef2.getUri());
					if (modelElemRef.getObject().isVar() || modelElemRef2.getObject().isVar()) {
						unifiables.add(modelElemRef2);
						unifiables2.add(modelElemRef);
					}
				}
			}
		}
		//TODO smart check to reduce average complexity, if in same container in src model
	}

	private void createImpactedVarTables(ModelEndpointReference modelEndpointRef, HashMap<String, List<EObject>> unifyTable, HashMap<String, List<EObject>> typeTable) throws MMTFException {

		// type table
		Model model = modelEndpointRef.getObject().getTarget();
		for (ModelElement modelElemType : model.getMetatype().getModelElems()) {
			List<EObject> unifiablesFromSameType = new ArrayList<EObject>();
			typeTable.put(modelElemType.getUri(), unifiablesFromSameType);
		}
		TreeIterator<EObject> iterator = model.getEMFRoot().eAllContents();
		while (iterator.hasNext()) {
			EObject modelEObject = iterator.next();
			if (!(modelEObject instanceof MAVOElement)) {
				continue;
			}
			ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelEObject);
			if (modelElemType == null) {
				continue;
			}
			List<EObject> unifiablesFromSameType = typeTable.get(modelElemType.getUri());
			unifiablesFromSameType.add(modelEObject);
		}
		// merge table
		for (List<EObject> unifiablesFromSameType : typeTable.values()) {
			for (EObject modelEObject : unifiablesFromSameType) {
				List<EObject> unifiables = new ArrayList<EObject>();
				String modelEObjectUri = MultiModelRegistry.getModelAndModelElementUris(modelEObject, true)[1];
				unifyTable.put(modelEObjectUri, unifiables);
				unifiables.add(modelEObject);
			}
			for (int i = 0; i < unifiablesFromSameType.size(); i++) {
				EObject modelEObject = unifiablesFromSameType.get(i);
				String modelEObjectUri = MultiModelRegistry.getModelAndModelElementUris(modelEObject, true)[1];
				List<EObject> unifiables = unifyTable.get(modelEObjectUri);
				for (int j = i+1; j < unifiablesFromSameType.size(); j++) {
					EObject modelEObject2 = unifiablesFromSameType.get(j);
					String modelEObjectUri2 = MultiModelRegistry.getModelAndModelElementUris(modelEObject2, true)[1];
					List<EObject> unifiables2 = unifyTable.get(modelEObjectUri2);
					if ((((MAVOElement) modelEObject).isVar() || ((MAVOElement) modelEObject2).isVar())) {
						unifiables.add(modelEObject2);
						unifiables2.add(modelEObject);
					}
				}
			}
		}
		//TODO smart check to reduce average complexity, if in same container in src model
	}

	private void addImpactedModelElementReferences(ModelElementReference origModelElemRef, ModelEndpointReference impactedModelEndpointRef, LinkReference impactLinkRef, HashMap<String, List<EObject>> impactedUnifyTable) throws MMTFException {

		if (origModelElemRef.getModelElemEndpointRefs().isEmpty()) {
			return;
		}

		String origModelUri = ((ModelEndpointReference) origModelElemRef.eContainer()).getTargetUri();
		ModelElementEndpoint rootModelElemTypeEndpoint = MultiModelTypeHierarchy.getRootModelElementTypeEndpoint();
		for (ModelElementEndpointReference origModelElemEndpointRef : origModelElemRef.getModelElemEndpointRefs()) {
			LinkReference traceLinkRef = (LinkReference) origModelElemEndpointRef.eContainer();
			for (ModelElementEndpointReference traceModelElemEndpointRef : traceLinkRef.getModelElemEndpointRefs()) {
				String impactedModelUri = ((ModelEndpointReference) traceModelElemEndpointRef.getModelElemRef().eContainer()).getTargetUri();
				if (origModelUri.equals(impactedModelUri)) { // target in source model
					continue;
				}
				ModelElementReference impactedModelElemRef = traceModelElemEndpointRef.getModelElemRef();
				// navigate tgt mergeability
				List<EObject> impactedUnifiables = impactedUnifyTable.get(impactedModelElemRef.getUri());
				for (EObject impactedUnifiable : impactedUnifiables) {
					String impactedModelElemUri = MultiModelRegistry.getModelAndModelElementUris(impactedUnifiable, true)[1];
					// create or get impacted model element ref
					ModelElementReference newImpactedModelElemRef = MultiModelTypeHierarchy.getReference(impactedModelElemUri, impactedModelEndpointRef.getModelElemRefs());
					if (newImpactedModelElemRef == null) {
						newImpactedModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
							impactedModelEndpointRef,
							null,
							impactedUnifiable
						);
					}
					// add impacted model element endpoint to impact link
					ModelElementEndpointReference newImpactModelElemEndpointRef = rootModelElemTypeEndpoint.createInstanceAndReference(newImpactedModelElemRef, false, impactLinkRef);
					newImpactModelElemEndpointRef.getObject().setName(TGT_MODELELEMENDPOINT_NAME);
				}
			}
		}
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		//Model origModel = actualParameters.get(0);
		BinaryModelRel diffRel = (BinaryModelRel) actualParameters.get(1);
		//Model modModel = actualParameters.get(2);
		BinaryModelRel traceRel = (BinaryModelRel) actualParameters.get(3);
		Model impactedModel = actualParameters.get(4);

		HashMap<String, List<ModelElementReference>> origUnifyTable = new HashMap<String, List<ModelElementReference>>();
		HashMap<String, List<ModelElementReference>> origTypeTable = new HashMap<String, List<ModelElementReference>>();
		HashMap<String, List<EObject>> impactedUnifyTable = new HashMap<String, List<EObject>>();
		HashMap<String, List<EObject>> impactedTypeTable = new HashMap<String, List<EObject>>();
		//TODO MMTF: be careful when overriding is implemented
		createOrigVarTables(traceRel.getModelEndpointRefs().get(0), origUnifyTable, origTypeTable); // O(n log n)
		createImpactedVarTables(traceRel.getModelEndpointRefs().get(1), impactedUnifyTable, impactedTypeTable); // O(n log n)

		// create output model relationship
		ModelRel rootModelRelType = MultiModelTypeHierarchy.getRootModelRelType();
		EList<Model> targetModels = new BasicEList<Model>();
		targetModels.add(diffRel);
		targetModels.add(impactedModel);
		ModelRel newImpactModelRel = rootModelRelType.createInstanceAndEndpointsAndReferences(null, true, ModelOrigin.CREATED, targetModels);
		newImpactModelRel.setName(MODELREL_NAME);
		ModelEndpointReference newDiffModelEndpointRef = newImpactModelRel.getModelEndpointRefs().get(0);
		ModelEndpointReference newImpactedModelEndpointRef = newImpactModelRel.getModelEndpointRefs().get(1);

		// loop through diff
		Link rootLinkType = MultiModelTypeHierarchy.getRootLinkType();
		for (Link diffLink : diffRel.getLinks()) {
			ModelElement diffModelElem = diffLink.getModelElemEndpoints().get(0).getTarget();
			// create diff model element ref
			ModelElementReference newDiffModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
				newDiffModelEndpointRef,
				diffModelElem.getName(),
				diffModelElem
			);
			// create impact link, add diff model element endpoint to it
			EList<ModelElementReference> targetModelElemRefs = new BasicEList<ModelElementReference>();
			targetModelElemRefs.add(newDiffModelElemRef);
			LinkReference newImpactLinkRef = rootLinkType.createInstanceAndReferenceAndEndpointsAndReferences(false, targetModelElemRefs);
			newImpactLinkRef.getObject().setName(LINKREF_NAME);
			ModelElementEndpointReference newDiffModelElemEndpointRef = newImpactLinkRef.getModelElemEndpointRefs().get(0);
			newDiffModelElemEndpointRef.getObject().setName(SRC_MODELELEMENDPOINT_NAME);

			// change impact algorithm
			List<ModelElementReference> origUnifiables = origUnifyTable.get(diffModelElem.getUri());
			if (origUnifiables == null) { // not in the trace rel
				// get the type it would have if it was in the trace rel
				ModelElement diffModelElemType = MultiModelConstraintChecker.getAllowedModelElementType(traceRel.getModelEndpointRefs().get(0), diffModelElem.getEMFObject());
				if (diffModelElemType != null) {
					List<ModelElementReference> origUnifiablesFromSameType = origTypeTable.get(diffModelElemType.getUri());
					for (ModelElementReference origUnifiable : origUnifiablesFromSameType) {
						if (origUnifiable.getObject().isVar()) {
							addImpactedModelElementReferences(origUnifiable, newImpactedModelEndpointRef, newImpactLinkRef, impactedUnifyTable);
						}
					}
				}
			}
			else {
				for (ModelElementReference origUnifiable : origUnifiables) {
					addImpactedModelElementReferences(origUnifiable, newImpactedModelEndpointRef, newImpactLinkRef, impactedUnifyTable);
				}
			}
		}

		EList<Model> result = new BasicEList<Model>();
		result.add(newImpactModelRel);
		return result;
	}

}
