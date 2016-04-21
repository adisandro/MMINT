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
package edu.toronto.cs.se.modelepedia.models15.operator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.modelepedia.primitive.file.FilePackage;

public class Java2File extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "java";
	private final static @NonNull String OUT_FILE = "file";
	// constants
	private final static @NonNull String JAVA_FILE_SUFFIX = "java";

	private @NonNull Model print(@NonNull Model javaModel, @NonNull MID instanceMID) throws Exception {

		// run acceleo
		String fileModelUri = MultiModelUtils.getUniqueUri(
			MultiModelUtils.replaceFileExtensionInUri(javaModel.getUri(), JAVA_FILE_SUFFIX),
			true,
			false);
		List<Object> m2tArgs = new ArrayList<>();
		m2tArgs.add(MultiModelUtils.getFileNameFromUri(fileModelUri));
		File folder = (new File(MultiModelUtils.prependWorkspaceToUri(javaModel.getUri()))).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		Java2File_M2T m2t = new Java2File_M2T(javaModel.getEMFInstanceRoot(), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		// create file model
		Model fileModelType = MultiModelTypeRegistry.getType(FilePackage.eNS_URI);
		Model fileModel = fileModelType.createInstance(fileModelUri, instanceMID);

		return fileModel;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model javaModel = inputsByName.get(IN_MODEL);
		MID instanceMID = outputMIDsByName.get(OUT_FILE);

		// print to file
		Model fileModel = print(javaModel, instanceMID);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_FILE, fileModel);

		return outputsByName;
	}

}
