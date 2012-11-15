/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.slice;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelElement;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.Link;
import edu.toronto.cs.se.mmtf.mid.relationship.LinkReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.RelationshipPackage;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelHierarchyUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelMAVOInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

public class ChangeImpact extends OperatorExecutableImpl {

	private final static String MODELREL_NAME = "impact";
	private final static String LINKREF_NAME = "impact";
	private final static String SRC_MODELELEMENDPOINT_NAME = "diff";
	private final static String TGT_MODELELEMENDPOINT_NAME = "impacted";

	private void createOrigVarTables(ModelEndpointReference modelEndpointRef, HashMap<String, EList<ModelElementReference>> unifyTable, HashMap<String, EList<ModelElementReference>> typeTable) {

		// O(n) + O(m i log i), O(n) best case when m=n and i=1, O(n log n) worst case when m=1 and i=n
		// type table
		for (ModelElementReference modelElemRef : modelEndpointRef.getModelElemRefs()) { // O(n)
			String modelElemTypeUri = modelElemRef.getObject().getMetatypeUri();
			EList<ModelElementReference> unifiablesFromSameType = typeTable.get(modelElemTypeUri);
			if (unifiablesFromSameType == null) {
				unifiablesFromSameType = new BasicEList<ModelElementReference>();
				typeTable.put(modelElemTypeUri, unifiablesFromSameType);
			}
			unifiablesFromSameType.add(modelElemRef);
		}
		// merge table
		for (EList<ModelElementReference> unifiablesFromSameType : typeTable.values()) { // + O(m), m<=n
			for (ModelElementReference modelElemRef : unifiablesFromSameType) {
				EList<ModelElementReference> unifiables = new BasicEList<ModelElementReference>();
				unifyTable.put(modelElemRef.getUri(), unifiables);
				unifiables.add(modelElemRef);
			}
			for (int i = 0; i < unifiablesFromSameType.size(); i++) { // * O(i), i<=n, SUM(i_k)=n for k=0..m
				ModelElementReference modelElemRef = unifiablesFromSameType.get(i);
				EList<ModelElementReference> unifiables = unifyTable.get(modelElemRef.getUri());
				for (int j = i+1; j < unifiablesFromSameType.size(); j++) { // * O(log i)
					ModelElementReference modelElemRef2 = unifiablesFromSameType.get(j);
					EList<ModelElementReference> unifiables2 = unifyTable.get(modelElemRef2.getUri());
					if (modelElemRef.getObject().isVar() || modelElemRef2.getObject().isVar()) {
						unifiables.add(modelElemRef2);
						unifiables2.add(modelElemRef);
					}
				}
			}
		}
		//TODO smart check to reduce average complexity, if in same container in src model
	}

	private void createImpactedVarTables(ModelEndpointReference modelEndpointRef, HashMap<String, EList<EObject>> unifyTable, HashMap<String, EList<EObject>> typeTable) {

		// type table
		Model model = modelEndpointRef.getObject().getTarget();
		for (ModelElement modelElemType : model.getMetatype().getElements()) {
			EList<EObject> unifiablesFromSameType = new BasicEList<EObject>();
			typeTable.put(modelElemType.getUri(), unifiablesFromSameType);
		}
		TreeIterator<EObject> iterator = MultiModelTypeIntrospection.getRoot(model).eAllContents();
		while (iterator.hasNext()) {
			EObject modelEObject = iterator.next();
			if (!(modelEObject instanceof MAVOElement)) {
				continue;
			}
			ModelElement modelElemType = MultiModelConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelEObject);
			if (modelElemType == null) {
				continue;
			}
			EList<EObject> unifiablesFromSameType = typeTable.get(modelElemType.getUri());
			unifiablesFromSameType.add(modelEObject);
		}
		// merge table
		for (EList<EObject> unifiablesFromSameType : typeTable.values()) {
			for (EObject modelEObject : unifiablesFromSameType) {
				EList<EObject> unifiables = new BasicEList<EObject>();
				String modelEObjectUri = MultiModelRegistry.getModelAndModelElementUris(modelEObject, true)[1];
				unifyTable.put(modelEObjectUri, unifiables);
				unifiables.add(modelEObject);
			}
			for (int i = 0; i < unifiablesFromSameType.size(); i++) {
				EObject modelEObject = unifiablesFromSameType.get(i);
				String modelEObjectUri = MultiModelRegistry.getModelAndModelElementUris(modelEObject, true)[1];
				EList<EObject> unifiables = unifyTable.get(modelEObjectUri);
				for (int j = i+1; j < unifiablesFromSameType.size(); j++) {
					EObject modelEObject2 = unifiablesFromSameType.get(j);
					String modelEObjectUri2 = MultiModelRegistry.getModelAndModelElementUris(modelEObject2, true)[1];
					EList<EObject> unifiables2 = unifyTable.get(modelEObjectUri2);
					if ((((MAVOElement) modelEObject).isVar() || ((MAVOElement) modelEObject2).isVar())) {
						unifiables.add(modelEObject2);
						unifiables2.add(modelEObject);
					}
				}
			}
		}
		//TODO smart check to reduce average complexity, if in same container in src model
	}

	private void addImpactedModelElementReferences(ModelElementReference origModelElemRef, ModelEndpointReference impactedModelEndpointRef, LinkReference impactLinkRef, HashMap<String, EList<EObject>> impactedUnifyTable) throws MMTFException {

		if (origModelElemRef.getModelElemEndpointRefs().isEmpty()) {
			return;
		}

		String origModelUri = ((ModelEndpointReference) origModelElemRef.eContainer()).getTargetUri();
		for (ModelElementEndpointReference origModelElemEndpointRef : origModelElemRef.getModelElemEndpointRefs()) {
			LinkReference traceLinkRef = (LinkReference) origModelElemEndpointRef.eContainer();
			for (ModelElementEndpointReference traceModelElemEndpointRef : traceLinkRef.getModelElemEndpointRefs()) {
				String impactedModelUri = ((ModelEndpointReference) traceModelElemEndpointRef.getModelElemRef().eContainer()).getTargetUri();
				if (origModelUri.equals(impactedModelUri)) { // target in source model
					continue;
				}
				ModelElementReference impactedModelElemRef = traceModelElemEndpointRef.getModelElemRef();
				// navigate tgt mergeability
				EList<EObject> impactedUnifiables = impactedUnifyTable.get(impactedModelElemRef.getUri());
				for (EObject impactedUnifiable : impactedUnifiables) {
					String impactedModelElemUri = MultiModelRegistry.getModelAndModelElementUris(impactedUnifiable, true)[1];
					// create or get impacted model element ref
					ModelElementReference newImpactedModelElemRef = MultiModelHierarchyUtils.getReference(impactedModelElemUri, impactedModelEndpointRef.getModelElemRefs());
					if (newImpactedModelElemRef == null) {
						newImpactedModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
							impactedModelEndpointRef,
							null,
							impactedUnifiable
						);
					}
					// add impacted model element endpoint to impact link
					ModelElementEndpointReference newImpactModelElemEndpointRef = MultiModelInstanceFactory.createModelElementEndpointAndModelElementEndpointReference(
						null,
						impactLinkRef,
						newImpactedModelElemRef,
						false
					);
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

		HashMap<String, EList<ModelElementReference>> origUnifyTable = new HashMap<String, EList<ModelElementReference>>();
		HashMap<String, EList<ModelElementReference>> origTypeTable = new HashMap<String, EList<ModelElementReference>>();
		HashMap<String, EList<EObject>> impactedUnifyTable = new HashMap<String, EList<EObject>>();
		HashMap<String, EList<EObject>> impactedTypeTable = new HashMap<String, EList<EObject>>();
		//TODO MMTF: be careful when overriding is implemented
		createOrigVarTables(traceRel.getModelEndpointRefs().get(0), origUnifyTable, origTypeTable); // O(n log n)
		createImpactedVarTables(traceRel.getModelEndpointRefs().get(1), impactedUnifyTable, impactedTypeTable); // O(n log n)

		// create output model relationship
		ModelRel newImpactModelRel = MultiModelInstanceFactory.createModelRelAndModelEndpointsAndModelEndpointReferences(
			null,
			ModelOrigin.CREATED,
			null,
			RelationshipPackage.eINSTANCE.getBinaryModelRel(),
			diffRel,
			impactedModel
		);
		newImpactModelRel.setName(MODELREL_NAME);
		ModelEndpointReference newDiffModelEndpointRef = newImpactModelRel.getModelEndpointRefs().get(0);
		ModelEndpointReference newImpactedModelEndpointRef = newImpactModelRel.getModelEndpointRefs().get(1);

		// loop through diff
		for (Link diffLink : diffRel.getLinks()) {
			ModelElement diffModelElem = diffLink.getModelElemEndpoints().get(0).getTarget();
			// create diff model element ref
			ModelElementReference newDiffModelElemRef = MultiModelMAVOInstanceFactory.createModelElementAndModelElementReference(
				newDiffModelEndpointRef,
				diffModelElem.getName(),
				diffModelElem
			);
			// create impact link, add diff model element endpoint to it
			LinkReference newImpactLinkRef = MultiModelInstanceFactory.createLinkAndLinkReferenceAndModelElementEndpointsAndModelElementEndpointReferences(
				null,
				RelationshipPackage.eINSTANCE.getLink(),
				RelationshipPackage.eINSTANCE.getLinkReference(),
				newDiffModelElemRef
			);
			newImpactLinkRef.getObject().setName(LINKREF_NAME);
			ModelElementEndpointReference newDiffModelElemEndpointRef = newImpactLinkRef.getModelElemEndpointRefs().get(0);
			newDiffModelElemEndpointRef.getObject().setName(SRC_MODELELEMENDPOINT_NAME);

			// change impact algorithm
			EList<ModelElementReference> origUnifiables = origUnifyTable.get(diffModelElem.getUri());
			if (origUnifiables == null) { // not in the trace rel
				// get the type it would have if it was in the trace rel
				ModelElement diffModelElemType = MultiModelConstraintChecker.getAllowedModelElementType(traceRel.getModelEndpointRefs().get(0), diffModelElem.getPointer());
				if (diffModelElemType != null) {
					EList<ModelElementReference> origUnifiablesFromSameType = origTypeTable.get(diffModelElemType.getUri());
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
