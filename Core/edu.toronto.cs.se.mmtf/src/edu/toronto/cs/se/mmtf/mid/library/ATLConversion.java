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
package edu.toronto.cs.se.mmtf.mid.library;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.operator.impl.ConversionOperatorImpl;

public abstract class ATLConversion extends ConversionOperatorImpl {

	protected Model inputModel;
	protected Model convertedModel;
	protected String convertedModelUri;

	protected void init(EList<Model> actualParameters, String convertedModelFileExtension) {

		inputModel = actualParameters.get(0);
		String modelName = inputModel.getName();
		int i = modelName.lastIndexOf(MMTF.MODEL_FILENAMESUFFIX_SEPARATOR);
		if (i != -1) {
			try {
				Long.parseLong(modelName.substring(i+1));
				modelName = modelName.substring(0, i);
			}
			catch (NumberFormatException e) {
				// modelName is ok
			}
		}
		convertedModelUri = MultiModelUtils.replaceLastSegmentInUri(inputModel.getUri(), modelName + MMTF.MODEL_FILENAMESUFFIX_SEPARATOR + System.currentTimeMillis() + MMTF.MODEL_FILEEXTENSION_SEPARATOR + convertedModelFileExtension);
	}

	protected EList<Model> createConvertedModel(String convertedModelTypeUri) throws MMTFException {

		MultiModel multiModel = MultiModelRegistry.getMultiModel(inputModel);
		Model convertedModelType = MultiModelTypeRegistry.getType(convertedModelTypeUri);
		convertedModel = convertedModelType.createMAVOInstanceAndEditor(convertedModelUri, ModelOrigin.CREATED, multiModel);
		EList<Model> result = new BasicEList<Model>();
		result.add(convertedModel);

		return result;
	}

	@Override
	public void cleanup() throws Exception {

		inputModel = null;
		if (convertedModel != null) {
			MultiModelUtils.deleteModelFile(convertedModel);
			convertedModel = null;
		}
	}

}
