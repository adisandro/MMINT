/**
 * Copyright (c) 2012-2026 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicMonitor;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.AcceleoLauncher;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.primitive.file.FilePackage;

public class Java2File extends OperatorImpl {

	// input-output
	private final static String IN_MODEL = "java";
	private final static String OUT_FILE = "file";
	// constants
	private final static String JAVA_FILE_SUFFIX = "java";

	private Model print(Model javaModel, MID instanceMID) throws Exception {

		// run acceleo
		String fileModelPath = FileUtils.getUniquePath(
			FileUtils.replaceFileExtensionInPath(javaModel.getUri(), Java2File.JAVA_FILE_SUFFIX),
			true,
			false);
		var folder = FileUtils.prependWorkspacePath(FileUtils.getAllButLastSegmentFromPath(javaModel.getUri()));
		var acceleo = new AcceleoLauncher(List.of(javaModel.getUri()), folder, new LinkedHashMap<>(),
                                      "edu::toronto::cs::se::modelepedia::models15::operator::Java2FileAcceleo",
                                      this.getClass().getClassLoader());
		acceleo.generate(new BasicMonitor());

		// create file model
		Model fileModelType = MIDTypeRegistry.getType(FilePackage.eNS_URI);
		var fileModel = fileModelType.createInstance(null, fileModelPath, instanceMID);

		return fileModel;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model javaModel = inputsByName.get(Java2File.IN_MODEL);
		MID instanceMID = outputMIDsByName.get(Java2File.OUT_FILE);

		// print to file
		Model fileModel = print(javaModel, instanceMID);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(Java2File.OUT_FILE, fileModel);

		return outputsByName;
	}

}
