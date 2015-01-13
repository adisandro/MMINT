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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.operator;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;

public class UMLToClassDiagramMAVO extends ConversionOperatorImpl {

	private Model newCdModel;

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model umlModel = actualParameters.get(0);
		String newCdModelUri = MultiModelUtils.replaceFileExtensionInUri(umlModel.getUri(), ClassDiagram_MAVOPackage.eNAME);
		UMLToClassDiagramMAVO_M2M atl = new UMLToClassDiagramMAVO_M2M();
		atl.loadModels(umlModel.getUri());
		atl.doUMLToClassDiagramMAVO_M2M(new NullProgressMonitor());
		atl.saveModels(newCdModelUri);

		MultiModel multiModel = MultiModelRegistry.getMultiModel(umlModel);
		Model cdModelType = MultiModelTypeRegistry.getType(ClassDiagram_MAVOPackage.eNS_URI);
		newCdModel = cdModelType.createMAVOInstanceAndEditor(newCdModelUri, ModelOrigin.CREATED, multiModel);
		EList<Model> result = new BasicEList<Model>();
		result.add(newCdModel);

		return result;
	}

	@Override
	public void cleanup() throws Exception {

		if (newCdModel != null) {
			MultiModelUtils.deleteModelFile(newCdModel);
			newCdModel = null;
		}
	}

}
