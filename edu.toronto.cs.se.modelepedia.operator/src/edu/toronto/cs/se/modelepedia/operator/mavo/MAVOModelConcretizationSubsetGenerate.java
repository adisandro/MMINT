/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro, Vivien Suen - Implementation.
 */
package edu.toronto.cs.se.modelepedia.operator.mavo;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;

public class MAVOModelConcretizationSubsetGenerate extends OperatorExecutableImpl {

	private static final String PROPERTY_IN_NUMCONCRETIZATIONS = "numConcretizations";
	private static final String OUTPUT_IN_MAYELEMS = "mayElems";
	private static final String PROPERTY_OUT_CONCRETIZATION = "concretization";

	private int numConcretizations;

	private void readProperties(Properties properties) throws Exception {

		numConcretizations = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_NUMCONCRETIZATIONS);
	}

	private void writeProperties(Properties properties, HashSet<String> concretizations) {

		int i = 0;
		Iterator<String> iter = concretizations.iterator();
		while (iter.hasNext()) {
			properties.setProperty(PROPERTY_OUT_CONCRETIZATION + i, iter.next());
			i++;
		}
	}

	private String concretizeElement(String elemName, Random random) {

		return (random.nextBoolean()) ?
			elemName :
			"~" + elemName;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model mavoModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			mavoModel,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);

		//TODO MMTF: create this in ExperimentDriver, seed it
		//TODO MMTF: every operator that uses it has to deserialize/serialize it
		Random random = new Random();
		//TODO MMTF: change when random model generate is in java
		Properties tempProperties = new Properties();
		tempProperties.load(new FileInputStream(ResourcesPlugin.getWorkspace().getRoot().getLocation().toString() + MultiModelRegistry.replaceFileExtensionInUri(mavoModel.getUri(), "mavoelems")));
		String[] mayElems = MultiModelOperatorUtils.getStringProperties(tempProperties, OUTPUT_IN_MAYELEMS);
		HashSet<String> concretizations = new HashSet<String>();
		for (int i = 0; i < numConcretizations; i++) {
			String concretization = "";
			for (int j = 0; j < mayElems.length; j++) {
				concretization += concretizeElement(mayElems[j], random);
			}
			if (concretizations.contains(concretization)) {
				i--;
			}
			else {
				concretizations.add(concretization);
			}
		}

		Properties outputProperties = new Properties();
		writeProperties(outputProperties, concretizations);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			mavoModel,
			MultiModelOperatorUtils.getSubdir(inputProperties),
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return actualParameters;
	}

}
