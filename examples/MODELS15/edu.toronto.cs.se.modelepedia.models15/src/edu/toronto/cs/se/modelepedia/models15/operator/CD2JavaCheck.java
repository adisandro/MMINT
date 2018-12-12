/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.models15.operator;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;
import edu.toronto.cs.se.modelepedia.primitive.int_.Int;
import edu.toronto.cs.se.modelepedia.primitive.int_.IntFactory;
import edu.toronto.cs.se.modelepedia.primitive.int_.IntPackage;
import edu.toronto.cs.se.modelepedia.models15_java.Package;

public class CD2JavaCheck extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELREL = "cd2java";
	private final static @NonNull String OUT_INT = "check";
	// constants
	private final static @NonNull String CHECK_INT_SUFFIX = "_check";

	private @NonNull Int check(ModelRel modelRel) throws MMINTException {

		int cdIndex, javaIndex;
		Model modelType = modelRel.getModelEndpoints().get(0).getTarget().getMetatype();
		if (modelType == MIDTypeRegistry.getType(ClassDiagramPackage.eNS_URI)) {
			cdIndex = 0;
			javaIndex = 1;
		}
		else {
			cdIndex = 1;
			javaIndex = 0;
		}
		Model cdModel = modelRel.getModelEndpoints().get(cdIndex).getTarget();
		Model javaModel = modelRel.getModelEndpoints().get(javaIndex).getTarget();
		Int check = IntFactory.eINSTANCE.createInt();
		ClassDiagram cd = (ClassDiagram) cdModel.getEMFInstanceRoot();
		Package p = (Package) javaModel.getEMFInstanceRoot();
		check.setValue(cd.getClasses().size() - p.getClasses().size());

		return check;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		ModelRel modelRel = (ModelRel) inputsByName.get(IN_MODELREL);
		MID instanceMID = outputMIDsByName.get(OUT_INT);

		// check classes connected by the rel
		Int check = check(modelRel);

		// output
		Model intModelType = MIDTypeRegistry.getType(IntPackage.eNS_URI);
		String checkModelPath = FileUtils.replaceLastSegmentInPath(
			MIDRegistry.getModelUri(modelRel),
			modelRel.getName() + CHECK_INT_SUFFIX + MMINT.MODEL_FILEEXTENSION_SEPARATOR
					+ intModelType.getFileExtension());
		Model checkModel = intModelType.createInstanceAndEditor(check, checkModelPath, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_INT, checkModel);

		return outputsByName;
	}

}
