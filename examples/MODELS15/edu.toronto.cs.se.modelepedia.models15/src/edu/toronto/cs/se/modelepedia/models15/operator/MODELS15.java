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
package edu.toronto.cs.se.modelepedia.models15.operator;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDFactory;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.MIDPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.RandomOperator;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
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
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		numClassDiagrams = MultiModelOperatorUtils.getIntProperty(inputProperties, PROPERTY_IN_NUMCLASSDIAGRAMS);
		numClassesPerClassDiagram = MultiModelOperatorUtils.getIntProperty(
			inputProperties, PROPERTY_IN_NUMCLASSESPERCLASSDIAGRAM);
		numClassNames = MultiModelOperatorUtils.getIntProperty(inputProperties, PROPERTY_IN_NUMCLASSNAMES);
	}

	private @NonNull MultiModel createClassDiagrams(String instanceMIDUri) {

		MultiModel cdMID = MIDFactory.eINSTANCE.createMultiModel();
		Model cdModelType = MultiModelTypeRegistry.getType(ClassDiagramPackage.eNS_URI);
		Random random = ((RandomOperator) getMetatype()).getState();
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
			String cdModelUri = MultiModelUtils.replaceLastSegmentInUri(
				instanceMIDUri, CD_MODEL_NAME + i + MMINT.MODEL_FILEEXTENSION_SEPARATOR + cdModelType.getFileExtension());
			try {
				MultiModelUtils.createModelFile(classDiagram, cdModelUri, true);
				cdModelType.createInstance(cdModelUri, ModelOrigin.CREATED, cdMID);
			}
			catch (Exception e) {
				MMINTException.print(IStatus.WARNING, "Can't generate class diagram number " + i + " , skipping it", e);
			}
		}

		return cdMID;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		MultiModel instanceMID = outputMIDsByName.get(OUT_MID);

		// create random class diagrams in a mid
		String instanceMIDUri = MultiModelRegistry.getModelAndModelElementUris(instanceMID, MIDLevel.INSTANCES)[0];
		MultiModel cdMID = createClassDiagrams(instanceMIDUri);

		// output
		String cdMIDModelUri = MultiModelUtils.replaceFileNameInUri(instanceMIDUri, OUT_MID_NAME);
		MultiModelUtils.createModelFile(cdMID, cdMIDModelUri, true);
		Model midModelType = MultiModelTypeRegistry.getType(MIDPackage.eNS_URI);
		Model cdMIDModel = midModelType.createInstanceAndEditor(cdMIDModelUri, ModelOrigin.CREATED, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MID, cdMIDModel);

		return outputsByName;

	}

}
