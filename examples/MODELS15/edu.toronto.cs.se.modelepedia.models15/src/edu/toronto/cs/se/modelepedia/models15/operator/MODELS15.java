/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Properties;
import java.util.Random;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.classdiagram.Class;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagram;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramFactory;
import edu.toronto.cs.se.modelepedia.classdiagram.ClassDiagramPackage;

public class MODELS15 extends RandomOperatorImpl {

	// input-output
	private final static @NonNull String OUT_MID = "mid";
	private final static @NonNull String PROPERTY_IN_NUMCLASSDIAGRAMS = "numClassDiagrams";
	private final static @NonNull String PROPERTY_IN_NUMCLASSESPERCLASSDIAGRAM = "numClassesPerClassDiagram";
	private final static @NonNull String PROPERTY_IN_NUMCLASSNAMES = "numClassNames";
	// constants
	private final static @NonNull String CD_MODEL_NAME = "cd";
	private final static @NonNull String OUT_MID_NAME = "classDiagrams";

	// input
	private int numClassDiagrams;
	private int numClassesPerClassDiagram;
	private int numClassNames;

	@Override
	public void readInputProperties(Properties inputProperties, Map<String, Model> inputsByName) throws MMINTException {

		numClassDiagrams = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_NUMCLASSDIAGRAMS);
		numClassesPerClassDiagram = MIDOperatorIOUtils.getIntProperty(
			inputProperties, PROPERTY_IN_NUMCLASSESPERCLASSDIAGRAM);
		numClassNames = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_NUMCLASSNAMES);
	}

	private @NonNull MID createClassDiagrams(String instanceMIDUri) {

		MID cdMID = MIDFactory.eINSTANCE.createMID();
		Model cdModelType = MIDTypeRegistry.getType(ClassDiagramPackage.eNS_URI);
		Random random = this.getState();
		for (int i = 0; i < numClassDiagrams; i++) {
			// create and populate class diagram
			ClassDiagram classDiagram = ClassDiagramFactory.eINSTANCE.createClassDiagram();
			Map<String, Class> cdClasses = new HashMap<>();
			for (int j = 0; j < numClassesPerClassDiagram; j++) {
				String className = "Class" + random.nextInt(numClassNames);
				if (cdClasses.get(className) != null) {
					// prevent same class names in a class diagram
					j--;
					continue;
				}
				Class clazz = ClassDiagramFactory.eINSTANCE.createClass();
				clazz.setName(className);
				classDiagram.getClasses().add(clazz);
				cdClasses.put(className, clazz);
			}
			// write class diagram to file and create model
			String cdModelPath = FileUtils.replaceLastSegmentInPath(
				instanceMIDUri, CD_MODEL_NAME + i + MMINT.MODEL_FILEEXTENSION_SEPARATOR + cdModelType.getFileExtension());
			try {
				cdModelType.createInstance(classDiagram, cdModelPath, cdMID);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.INFO, "Can't generate class diagram number " + i + " , skipping it", e);
			}
		}

		return cdMID;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		MID instanceMID = outputMIDsByName.get(OUT_MID);
		// check constraints
		if (numClassesPerClassDiagram > numClassNames) {
			throw new MMINTException("numClassNames must be >= numClassesPerClassDiagram");
		}

		// create random class diagrams in a mid
		String instanceMIDUri = MIDRegistry.getModelUri(instanceMID);
		MID cdMID = createClassDiagrams(instanceMIDUri);

		// output
		String cdMIDModelPath = FileUtils.replaceFileNameInPath(instanceMIDUri, OUT_MID_NAME);
		Model cdMIDModel = MIDTypeRegistry.getMIDModelType().createInstanceAndEditor(cdMID, cdMIDModelPath, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MID, cdMIDModel);

		return outputsByName;

	}

}
