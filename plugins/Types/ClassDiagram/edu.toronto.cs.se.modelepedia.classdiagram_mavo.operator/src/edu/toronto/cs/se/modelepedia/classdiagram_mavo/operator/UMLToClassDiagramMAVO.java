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
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.operator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.ConversionOperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOPackage;

public class UMLToClassDiagramMAVO extends ConversionOperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "uml";
	private final static @NonNull String OUT_MODEL = "mavo";

	private Model newCdModel;

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model umlModel = inputsByName.get(IN_MODEL);
		MID instanceMID = outputMIDsByName.get(OUT_MODEL);

		// transform using atl
		String newCdModelPath = FileUtils.replaceFileExtensionInPath(umlModel.getUri(), ClassDiagram_MAVOPackage.eNAME);
		UMLToClassDiagramMAVO_M2M atl = new UMLToClassDiagramMAVO_M2M();
		atl.loadModels(umlModel.getUri());
		atl.doUMLToClassDiagramMAVO_M2M(new NullProgressMonitor());
		atl.saveModels(newCdModelPath);

		// output
		Model cdModelType = MIDTypeRegistry.getType(ClassDiagram_MAVOPackage.eNS_URI);
		newCdModel = cdModelType.createInstanceAndEditor(null, newCdModelPath, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, newCdModel);

		return outputsByName;
	}

	@Override
	public void cleanup() throws Exception {

		if (newCdModel != null) {
			newCdModel.deleteInstanceAndFile();
			newCdModel = null;
		}
	}

}
