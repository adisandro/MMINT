/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.randommodel.operator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.RandomOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;

public class RandomModelToSMTLIB extends RandomOperatorExecutableImpl {

	private static final String PROPERTY_IN_NUMCONCRETIZATIONS = "numConcretizations";
	private static final String PROPERTY_IN_PROPERTY = "property";
	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_RandomModelGenerateLabeledGraph";
	private static final String SMT_CONCRETIZATION_PREAMBLE = "(assert (or\n";
	private static final String SMT_CONCRETIZATION_POSTAMBLE = "))";

	private int numConcretizations;
	private String property;

	private void readProperties(Properties properties) throws Exception {

		numConcretizations = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_NUMCONCRETIZATIONS);
		property = MultiModelOperatorUtils.getStringProperty(properties, PROPERTY_IN_PROPERTY);
	}

	private void generateConcretization(HashSet<String> concretizations, String[] mayModelElems) {

		StringBuilder concretization;
		do {
			concretization = new StringBuilder("(and ");
			for (int j = 0; j < mayModelElems.length; j++) {
				boolean negation = state.nextBoolean();
				if (negation) {
					concretization.append("(not ");
				}
				concretization.append("(");
				concretization.append(mayModelElems[j]);
				concretization.append(")");
				if (negation) {
					concretization.append(")");
				}
			}
			concretization.append(")");
		}
		while (concretizations.contains(concretization.toString()));
		concretizations.add(concretization.toString());
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model randommodelModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			randommodelModel,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);

		// get output properties from previous operator
		Properties mavoProperties = MultiModelOperatorUtils.getPropertiesFile(
			MultiModelTypeRegistry.getOperatorType(PREVIOUS_OPERATOR_URI).getExecutable(),
			randommodelModel,
			null,
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);
		String[] mayModelElems = MultiModelOperatorUtils.getStringProperties(mavoProperties, RandomModelGenerateLabeledGraph.PROPERTY_OUT_MAYMODELELEMS);
		long maxConcretizations = Math.round(Math.pow(2, mayModelElems.length));
		if (numConcretizations > maxConcretizations) {
			throw new MMTFException("numConcretizations (" + numConcretizations + ") > maxConcretizations (" + maxConcretizations + ")");
		}

		// generate smt concretizations
		//TODO MMTF: add heuristics to detect too large number of concretizations (when it's more efficient to generate them all and then cut some)
		HashSet<String> concretizations = new HashSet<String>();
		for (int i = 0; i < numConcretizations; i++) {
			generateConcretization(concretizations, mayModelElems);
		}

		// generate smt-lib representation of the random model
		List<Object> m2tArgs = new ArrayList<Object>();
		StringBuilder smtConcretizations = new StringBuilder(SMT_CONCRETIZATION_PREAMBLE);
		Iterator<String> iter = concretizations.iterator();
		while (iter.hasNext()) {
			smtConcretizations.append(iter.next());
			smtConcretizations.append("\n");
		}
		smtConcretizations.append(SMT_CONCRETIZATION_POSTAMBLE);
		m2tArgs.add(smtConcretizations.toString());
		m2tArgs.add(property);
		String workspaceUri = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		File folder = (new File(workspaceUri + randommodelModel.getUri())).getParentFile();
		RandomModelToSMTLIB_M2T m2t = new RandomModelToSMTLIB_M2T(MultiModelTypeIntrospection.getRoot(randommodelModel), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return actualParameters;
	}

}
