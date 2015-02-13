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
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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

public class ModelSlicer extends OperatorImpl {

	@NonNull private static final String PROPERTY_IN_SLICEIDS = "sliceIds";
	@NonNull private static final String PROPERTY_IN_IDATTRIBUTE = "idAttribute";
	@NonNull private static final String PROPERTY_IN_INCLUDEREFERENCES = "includeReferences";
	private static final boolean PROPERTY_IN_INCLUDEREFERENCES_DEFAULT = false;

	@NonNull private static final String SLICE_MODEL_SUFFIX = "_slice";

	private String[] sliceIds;
	private String idAttribute;

	private Set<EObject> sliceModelObjs;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		sliceIds = MultiModelOperatorUtils.getStringProperties(inputProperties, PROPERTY_IN_SLICEIDS);
		idAttribute = MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_IDATTRIBUTE);
	}

	@Override
	public void init() {

		sliceModelObjs = new HashSet<>();
	}

	private void reachableObjectsRecursive(EObject sliceModelObj) {

		
	}

	private void reachableObjects(EObject sliceRootModelObj) {

		sliceRootModelObj.eAllContents().forEachRemaining(sliceModelObj -> {
			EStructuralFeature feature = sliceModelObj.eClass().getEStructuralFeature(idAttribute);
			if (feature != null) {
				if (sliceModelObj.eGet(feature) != null) {//TODO contained in sliceIds
					reachableObjectsRecursive(sliceModelObj);
				}
			}
		});
	}

	private boolean isInSlice(EObject modelObj) {

		/*TODO Is in slice if:
		 * 1) is reachable from one of the sliceIds (references containment and non)
		 * 2) is within the boundary (one or more boundaries are coupled with a sliceId [sliceId.boundaries=..])
		 * 3) we need the model objects that correspond to the sliceIds, so it's better to compute the bag of reachable model objects from there instead of this isinslice
		 */
		return false;
	}

	private EObject slice(EObject rootModelObj) {

		EObject sliceRootModelObj = EcoreUtil.copy(rootModelObj);
		List<EObject> modelObjsToBeDeleted = new ArrayList<>();
		sliceRootModelObj.eAllContents().forEachRemaining(modelObj -> {
			if (!isInSlice(modelObj)) {
				modelObjsToBeDeleted.add(modelObj);
			}
		});
		modelObjsToBeDeleted.forEach(modelObj -> EcoreUtil.delete(modelObj, true));

		return sliceRootModelObj;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model model = actualParameters.get(0);

		MultiModel instanceMID = MultiModelRegistry.getMultiModel(model);
		String sliceModelUri = MultiModelUtils.addFileNameSuffixInUri(model.getUri(), SLICE_MODEL_SUFFIX);
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
