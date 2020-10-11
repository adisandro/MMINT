/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.mavo.operator.slice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint;
import edu.toronto.cs.se.mmint.mavo.mavomid.MAVOModelElementReference;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelElement;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmint.mid.relationship.Mapping;
import edu.toronto.cs.se.mmint.mid.relationship.MappingReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpoint;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelElementReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;

public class ChangeImpact extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELREL1 = "diff";
	private final static @NonNull String IN_MODELREL2 = "trace";
	private final static @NonNull String OUT_MODELREL = "impact";
	// constants
	private final static String SRC_MODELELEMENDPOINT_NAME = "diff";
	private final static String TGT_MODELELEMENDPOINT_NAME = "impacted";

	public static class OperatorConstraint implements IJavaOperatorConstraint {

		@Override
		public boolean isAllowedInput(Map<String, Model> inputsByName) {

			//TODO MMINT[CONSTRAINT] Check that diff and trace share a model
			return true;
		}

		@Override
		public Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, GenericElement> genericsByName, Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

			//TODO MMINT[CONSTRAINT] Implement
			return new HashMap<>();
		}
	}

	private void createOrigVarTables(ModelEndpointReference modelEndpointRef, Map<String, List<ModelElementReference>> unifyTable, Map<String, List<MAVOModelElementReference>> typeTable) {

		// O(n) + O(m i log i), O(n) best case when m=n and i=1, O(n log n) worst case when m=1 and i=n
		// type table
		for (ModelElementReference modelElemRef : modelEndpointRef.getModelElemRefs()) { // O(n)
			String modelElemTypeUri = modelElemRef.getObject().getMetatypeUri();
			List<MAVOModelElementReference> unifiablesFromSameType = typeTable.get(modelElemTypeUri);
			if (unifiablesFromSameType == null) {
				unifiablesFromSameType = new ArrayList<>();
				typeTable.put(modelElemTypeUri, unifiablesFromSameType);
			}
			unifiablesFromSameType.add((MAVOModelElementReference) modelElemRef);
		}
		// merge table
		for (List<MAVOModelElementReference> unifiablesFromSameType : typeTable.values()) { // + O(m), m<=n
			for (ModelElementReference modelElemRef : unifiablesFromSameType) {
				List<ModelElementReference> unifiables = new ArrayList<>();
				unifyTable.put(modelElemRef.getUri(), unifiables);
				unifiables.add(modelElemRef);
			}
			for (int i = 0; i < unifiablesFromSameType.size(); i++) { // * O(i), i<=n, SUM(i_k)=n for k=0..m
				MAVOModelElementReference modelElemRef = unifiablesFromSameType.get(i);
				List<ModelElementReference> unifiables = unifyTable.get(modelElemRef.getUri());
				for (int j = i+1; j < unifiablesFromSameType.size(); j++) { // * O(log i)
					MAVOModelElementReference modelElemRef2 = unifiablesFromSameType.get(j);
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

	private void createImpactedVarTables(ModelEndpointReference modelEndpointRef, Map<String, List<EObject>> unifyTable, Map<String, List<EObject>> typeTable) throws MMINTException {

		// type table
		Model model = modelEndpointRef.getObject().getTarget();
		for (ModelElement modelElemType : model.getMetatype().getModelElems()) {
			List<EObject> unifiablesFromSameType = new ArrayList<>();
			typeTable.put(modelElemType.getUri(), unifiablesFromSameType);
		}
		TreeIterator<EObject> iterator = model.getEMFInstanceRoot().eAllContents();
		while (iterator.hasNext()) {
			EObject modelEObject = iterator.next();
			if (!(modelEObject instanceof MAVOElement)) {
				continue;
			}
			ModelElement modelElemType = MIDConstraintChecker.getAllowedModelElementType(modelEndpointRef, modelEObject);
			if (modelElemType == null) {
				continue;
			}
			List<EObject> unifiablesFromSameType = typeTable.get(modelElemType.getUri());
			unifiablesFromSameType.add(modelEObject);
		}
		// merge table
		for (List<EObject> unifiablesFromSameType : typeTable.values()) {
			for (EObject modelObj : unifiablesFromSameType) {
				List<EObject> unifiables = new ArrayList<>();
				String modelObjUri = MIDRegistry.getModelElementUri(modelObj);
				unifyTable.put(modelObjUri, unifiables);
				unifiables.add(modelObj);
			}
			for (int i = 0; i < unifiablesFromSameType.size(); i++) {
				EObject modelObj = unifiablesFromSameType.get(i);
				String modelObjUri = MIDRegistry.getModelElementUri(modelObj);
				List<EObject> unifiables = unifyTable.get(modelObjUri);
				for (int j = i+1; j < unifiablesFromSameType.size(); j++) {
					EObject modelObj2 = unifiablesFromSameType.get(j);
					String modelObjUri2 = MIDRegistry.getModelElementUri(modelObj2);
					List<EObject> unifiables2 = unifyTable.get(modelObjUri2);
					if ((((MAVOElement) modelObj).isVar() || ((MAVOElement) modelObj2).isVar())) {
						unifiables.add(modelObj2);
						unifiables2.add(modelObj);
					}
				}
			}
		}
		//TODO smart check to reduce average complexity, if in same container in src model
	}

	private void addImpactedModelElementReferences(ModelElementReference origModelElemRef, ModelEndpointReference impactedModelEndpointRef, MappingReference impactMappingRef, Map<String, List<EObject>> impactedUnifyTable) throws MMINTException {

		if (origModelElemRef.getModelElemEndpointRefs().isEmpty()) {
			return;
		}

		String origModelUri = ((ModelEndpointReference) origModelElemRef.eContainer()).getTargetUri();
		ModelElementEndpoint rootModelElemTypeEndpoint = MIDTypeHierarchy.getRootModelElementTypeEndpoint();
		for (ModelElementEndpointReference origModelElemEndpointRef : origModelElemRef.getModelElemEndpointRefs()) {
			MappingReference traceMappingRef = (MappingReference) origModelElemEndpointRef.eContainer();
			for (ModelElementEndpointReference traceModelElemEndpointRef : traceMappingRef.getModelElemEndpointRefs()) {
				String impactedModelUri = ((ModelEndpointReference) traceModelElemEndpointRef.getModelElemRef().eContainer()).getTargetUri();
				if (origModelUri.equals(impactedModelUri)) { // target in source model
					continue;
				}
				ModelElementReference impactedModelElemRef = traceModelElemEndpointRef.getModelElemRef();
				// navigate tgt mergeability
				List<EObject> impactedUnifiables = impactedUnifyTable.get(impactedModelElemRef.getUri());
				for (EObject impactedUnifiable : impactedUnifiables) {
					String impactedModelElemUri = MIDRegistry.getModelElementUri(impactedUnifiable);
					// create or get impacted model element ref
					ModelElementReference newImpactedModelElemRef = MIDRegistry.getReference(impactedModelElemUri, impactedModelEndpointRef.getModelElemRefs());
					if (newImpactedModelElemRef == null) {
						newImpactedModelElemRef = impactedModelEndpointRef.createModelElementInstanceAndReference(impactedUnifiable, null);
					}
					// add impacted model element endpoint to impact link
					ModelElementEndpointReference newImpactModelElemEndpointRef = rootModelElemTypeEndpoint.createInstanceAndReference(newImpactedModelElemRef, impactMappingRef);
					newImpactModelElemEndpointRef.getObject().setName(ChangeImpact.TGT_MODELELEMENDPOINT_NAME);
				}
			}
		}
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		BinaryModelRel diffRel = (BinaryModelRel) inputsByName.get(ChangeImpact.IN_MODELREL1);
		BinaryModelRel traceRel = (BinaryModelRel) inputsByName.get(ChangeImpact.IN_MODELREL2);
		Model impactedModel = traceRel.getTargetModel();

		Map<String, List<ModelElementReference>> origUnifyTable = new HashMap<>();
		Map<String, List<MAVOModelElementReference>> origTypeTable = new HashMap<>();
		Map<String, List<EObject>> impactedUnifyTable = new HashMap<>();
		Map<String, List<EObject>> impactedTypeTable = new HashMap<>();
		//TODO MMINT[OVERRIDE] be careful when overriding is implemented
		createOrigVarTables(traceRel.getModelEndpointRefs().get(0), origUnifyTable, origTypeTable); // O(n log n)
		createImpactedVarTables(traceRel.getModelEndpointRefs().get(1), impactedUnifyTable, impactedTypeTable); // O(n log n)

		// create output model relationship
		ModelRel rootModelRelType = MIDTypeHierarchy.getRootModelRelType();
		ModelRel newImpactModelRel = rootModelRelType.createBinaryInstanceAndEndpoints(
			null,
			ChangeImpact.OUT_MODELREL,
			diffRel,
			impactedModel,
			outputMIDsByName.get(ChangeImpact.OUT_MODELREL));
		ModelEndpointReference newDiffModelEndpointRef = newImpactModelRel.getModelEndpointRefs().get(0);
		ModelEndpointReference newImpactedModelEndpointRef = newImpactModelRel.getModelEndpointRefs().get(1);

		// loop through diff
		Mapping rootMappingType = MIDTypeHierarchy.getRootMappingType();
		for (Mapping diffMapping : diffRel.getMappings()) {
			ModelElement diffModelElem = diffMapping.getModelElemEndpoints().get(0).getTarget();
			// create diff model element ref
			ModelElementReference newDiffModelElemRef = newDiffModelEndpointRef.createModelElementInstanceAndReference(diffModelElem, diffModelElem.getName());
			// create impact link, add diff model element endpoint to it
			EList<ModelElementReference> targetModelElemRefs = new BasicEList<>();
			targetModelElemRefs.add(newDiffModelElemRef);
			MappingReference newImpactMappingRef = rootMappingType.createInstanceAndReferenceAndEndpointsAndReferences(false, targetModelElemRefs);
			newImpactMappingRef.getObject().setName(ChangeImpact.OUT_MODELREL);
			ModelElementEndpointReference newDiffModelElemEndpointRef = newImpactMappingRef.getModelElemEndpointRefs().get(0);
			newDiffModelElemEndpointRef.getObject().setName(ChangeImpact.SRC_MODELELEMENDPOINT_NAME);

			// change impact algorithm
			List<ModelElementReference> origUnifiables = origUnifyTable.get(diffModelElem.getUri());
			if (origUnifiables == null) { // not in the trace rel
				// get the type it would have if it was in the trace rel
				ModelElement diffModelElemType = MIDConstraintChecker.getAllowedModelElementType(traceRel.getModelEndpointRefs().get(0), diffModelElem.getEMFInstanceObject());
				if (diffModelElemType != null) {
					List<MAVOModelElementReference> origUnifiablesFromSameType = origTypeTable.get(diffModelElemType.getUri());
					for (MAVOModelElementReference origUnifiable : origUnifiablesFromSameType) {
						if (origUnifiable.getObject().isVar()) {
							addImpactedModelElementReferences(origUnifiable, newImpactedModelEndpointRef, newImpactMappingRef, impactedUnifyTable);
						}
					}
				}
			}
			else {
				for (ModelElementReference origUnifiable : origUnifiables) {
					addImpactedModelElementReferences(origUnifiable, newImpactedModelEndpointRef, newImpactMappingRef, impactedUnifyTable);
				}
			}
		}

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(ChangeImpact.OUT_MODELREL, newImpactModelRel);

		return outputsByName;
	}

}
