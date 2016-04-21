/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.library;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl;

public abstract class ATLConversion extends ConversionOperatorImpl {

	protected Model inputModel;
	protected Model convertedModel;
	protected String convertedModelUri;

	protected void init(String convertedModelFileExtension) {

		String modelName = inputModel.getName();
		int i = modelName.lastIndexOf(MMINT.MODEL_FILENAMESUFFIX_SEPARATOR);
		if (i != -1) {
			try {
				Long.parseLong(modelName.substring(i+1));
				modelName = modelName.substring(0, i);
			}
			catch (NumberFormatException e) {
				// modelName is ok
			}
		}
		convertedModelUri = MultiModelUtils.replaceLastSegmentInUri(inputModel.getUri(), modelName + MMINT.MODEL_FILENAMESUFFIX_SEPARATOR + System.currentTimeMillis() + MMINT.MODEL_FILEEXTENSION_SEPARATOR + convertedModelFileExtension);
	}

	protected void createConvertedModel(String convertedModelTypeUri, MID instanceMID) throws MMINTException {

		Model convertedModelType = MultiModelTypeRegistry.getType(convertedModelTypeUri);
		convertedModel = convertedModelType.createInstanceAndEditor(convertedModelUri, instanceMID);
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
