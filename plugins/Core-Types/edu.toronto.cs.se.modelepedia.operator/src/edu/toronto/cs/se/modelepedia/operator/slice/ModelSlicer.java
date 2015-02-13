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
import java.util.List;
import java.util.Properties;

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

public class ModelSlicer extends OperatorImpl {

	@NonNull private static final String PROPERTY_IN_SLICEIDS = "sliceIds";
	@NonNull private static final String PROPERTY_IN_IDATTRIBUTE = "idAttribute";
	@NonNull private static final String PROPERTY_IN_INCLUDEREFERENCES = "includeReferences";
	private static final boolean PROPERTY_IN_INCLUDEREFERENCES_DEFAULT = false;

	private String[] sliceIds;
	private String idAttribute;
	private boolean includeReferences;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		sliceIds = MultiModelOperatorUtils.getStringProperties(inputProperties, PROPERTY_IN_SLICEIDS);
		idAttribute = MultiModelOperatorUtils.getStringProperty(inputProperties, PROPERTY_IN_IDATTRIBUTE);
		includeReferences = MultiModelOperatorUtils.getOptionalBoolProperty(inputProperties, PROPERTY_IN_INCLUDEREFERENCES, PROPERTY_IN_INCLUDEREFERENCES_DEFAULT);
	}

	private boolean isInSlice(EObject modelObj) {

		return false;
	}

	private EObject slice(EObject rootModelObj) {

		EObject slicedRootModelObj = EcoreUtil.copy(rootModelObj);
		List<EObject> modelObjsToBeDeleted = new ArrayList<>();
		slicedRootModelObj.eAllContents().forEachRemaining(modelObj -> {
			if (!isInSlice(modelObj)) {
				modelObjsToBeDeleted.add(modelObj);
			}
		});
		modelObjsToBeDeleted.forEach(modelObj -> EcoreUtil.delete(modelObj, true));

		return slicedRootModelObj;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model model = actualParameters.get(0);

		MultiModel instanceMID = MultiModelRegistry.getMultiModel(model);
		EObject slicedRootModelObj = slice(model.getEMFInstanceRoot());
		String slicedModelUri = "";
		MultiModelUtils.createModelFile(slicedRootModelObj, slicedModelUri, true);
		Model slicedModel = (isUpdateMID()) ?
			model.getMetatype().createInstanceAndEditor(slicedModelUri, ModelOrigin.CREATED, instanceMID) :
			model.getMetatype().createInstance(slicedModelUri, ModelOrigin.CREATED, null);
		EList<Model> result = new BasicEList<Model>();
		result.add(slicedModel);

		return result;
	}

}
