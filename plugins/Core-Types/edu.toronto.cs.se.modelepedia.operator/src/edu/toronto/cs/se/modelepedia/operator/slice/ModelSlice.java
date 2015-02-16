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
package edu.toronto.cs.se.modelepedia.operator.slice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;

public class ModelSlice extends OperatorImpl {

	@NonNull private static final String PROPERTY_IN_IDATTRIBUTE = "idAttribute";
	@NonNull private static final String PROPERTY_IN_SLICEIDS = "sliceIds";
	@NonNull private static final String PROPERTY_IN_BOUNDARIESIDS_SUFFIX = ".boundariesIds";

	@NonNull private static final String SLICE_MODEL_SUFFIX = "_slice";

	private String idAttribute;
	private Set<String> sliceIds;
	private Map<String, Set<String>> boundariesIds;

	private Set<EObject> sliceModelObjs;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		idAttribute = MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_IDATTRIBUTE);
		sliceIds = MultiModelOperatorUtils.getStringPropertySet(inputProperties, PROPERTY_IN_SLICEIDS);
		boundariesIds = new HashMap<>();
		for (String sliceId : sliceIds) {
			boundariesIds.put(sliceId, MultiModelOperatorUtils.getStringPropertySet(inputProperties, sliceId + PROPERTY_IN_BOUNDARIESIDS_SUFFIX));
		}
	}

	@Override
	public void init() {

		sliceModelObjs = new HashSet<>();
	}

	private void sliceReachableObjects(String sliceId, EObject sliceModelObj) {

		if (sliceModelObjs.contains(sliceModelObj)) {
			return;
		}
		String id = null;
		try {
			id = (String) MultiModelUtils.getModelObjFeature(sliceModelObj, idAttribute);
		}
		catch (MMINTException e) {
			// ignore and continue
		}
		sliceModelObjs.add(sliceModelObj);
		if (id != null && boundariesIds.get(sliceId).contains(id)) {
			return;
		}
		sliceModelObj.eAllContents().forEachRemaining(reachableModelObj ->
			sliceReachableObjects(sliceId, reachableModelObj)
		);
		sliceModelObj.eCrossReferences().forEach(reachableModelObj ->
			sliceReachableObjects(sliceId, reachableModelObj)
		);
	}

	private EObject slice(EObject rootModelObj) {

		// collect slice model objects
		EObject sliceRootModelObj = EcoreUtil.copy(rootModelObj);
		sliceRootModelObj.eAllContents().forEachRemaining(sliceModelObj -> {
			String sliceId = null;
			try {
				sliceId = (String) MultiModelUtils.getModelObjFeature(sliceModelObj, idAttribute);
			}
			catch (Exception e) {
				// ignore and continue
			}
			if (sliceId != null && sliceIds.contains(sliceId)) {
				sliceReachableObjects(sliceId, sliceModelObj);
			}
		});
		// slice proper
		List<EObject> modelObjsToDelete = new ArrayList<>();
		sliceRootModelObj.eAllContents().forEachRemaining(modelObjToDelete -> {
			if (!sliceModelObjs.contains(modelObjToDelete)) {
				modelObjsToDelete.add(modelObjToDelete);
			}
		});
		modelObjsToDelete.forEach(modelObj -> EcoreUtil.delete(modelObj, true));

		return sliceRootModelObj;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model model = actualParameters.get(0);

		MultiModel instanceMID = MultiModelRegistry.getMultiModel(model);
		String sliceModelUri = MultiModelUtils.getUniqueUri(MultiModelUtils.addFileNameSuffixInUri(model.getUri(), SLICE_MODEL_SUFFIX), true, false);
		EObject sliceRootModelObj = slice(model.getEMFInstanceRoot());
		MultiModelUtils.createModelFile(sliceRootModelObj, sliceModelUri, true);
		Model sliceModel = (isUpdateMID()) ?
			model.getMetatype().createInstanceAndEditor(sliceModelUri, ModelOrigin.CREATED, instanceMID) :
			model.getMetatype().createInstance(sliceModelUri, ModelOrigin.CREATED, null);
		EList<Model> result = new BasicEList<Model>();
		result.add(sliceModel);

		return result;
	}

}
