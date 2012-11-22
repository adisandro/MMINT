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
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.acceleo.common.preference.AcceleoPreferences;
import org.eclipse.acceleo.engine.event.AcceleoTextGenerationEvent;
import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.RandomOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.modelepedia.randommodel.Edge;
import edu.toronto.cs.se.modelepedia.randommodel.NamedElement;
import edu.toronto.cs.se.modelepedia.randommodel.Node;

public class RandomModelToSMTLIB extends RandomOperatorExecutableImpl {

	public class RandomModelToSMTLIB_M2TWithListeners extends RandomModelToSMTLIB_M2T {

		public class RandomModelToSMTLIBListener implements IAcceleoTextGenerationListener {

			private StringBuilder textGeneration;
			private boolean isListening;

			public RandomModelToSMTLIBListener() {
				textGeneration = new StringBuilder();
				isListening = true;
			}

			@Override
			public void textGenerated(AcceleoTextGenerationEvent event) {

				if (!isListening) {
					return;
				}

				String text = event.getText();
				if (text.startsWith(SMTLIB_CONCRETIZATION_MARKER1)) {
					smtlibEncoding = textGeneration.toString();
				}
				if (text.startsWith(SMTLIB_CONCRETIZATION_MARKER2)) {
					smtlibMavoEncoding = textGeneration.toString();
					isListening = false;
				}
				textGeneration.append(event.getText());
			}

			@Override
			public void filePathComputed(AcceleoTextGenerationEvent event) {
			}

			@Override
			public void fileGenerated(AcceleoTextGenerationEvent event) {
			}

			@Override
			public void generationEnd(AcceleoTextGenerationEvent event) {
			}

			@Override
			public boolean listensToGenerationEnd() {
				return false;
			}
			
		}

		public RandomModelToSMTLIB_M2TWithListeners(EObject model, File targetFolder, List<? extends Object> arguments) throws IOException {

			super(model, targetFolder, arguments);
	    }

		@Override
	    public List<IAcceleoTextGenerationListener> getGenerationListeners() {

			List<IAcceleoTextGenerationListener> listeners = new ArrayList<IAcceleoTextGenerationListener>();
			listeners.add(new RandomModelToSMTLIBListener());

			return listeners;
		}
	}

	private static final String PROPERTY_IN_NUMCONCRETIZATIONS = "numConcretizations";
	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_RandomModelGenerateLabeledGraph";
	private static final String SMTLIB_CONCRETIZATION_MARKER1 = ";Concretizations-START";
	private static final String SMTLIB_CONCRETIZATION_MARKER2 = ";Concretizations-END";
	private static final String SMTLIB_CONCRETIZATION_PREAMBLE = "(assert (or\n";
	private static final String SMTLIB_CONCRETIZATION_POSTAMBLE = "))";

	private int numConcretizations;
	private String smtlibMavoEncoding;
	private String smtlibEncoding;
	private HashSet<String> smtlibConcretizations;

	private void readProperties(Properties properties) throws Exception {

		numConcretizations = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_NUMCONCRETIZATIONS);
	}

	private String getNamedElementSMTEncoding(NamedElement namedElement) {

		return namedElement.getType() + " " + namedElement.getName();
	}

	private void generateConcretization(HashSet<String> concretizations, List<MAVOElement> mayModelObjs) {

		StringBuilder concretization;
		Map<String, Boolean> wellFormednessConstraints = new HashMap<String, Boolean>();
		do {
			String mayModelObjSMTEncoding;
			concretization = new StringBuilder("(and ");
			for (int j = 0; j < mayModelObjs.size(); j++) {
				// analyze well formedness rules
				NamedElement mayModelObj = (NamedElement) mayModelObjs.get(j);
				mayModelObjSMTEncoding = getNamedElementSMTEncoding(mayModelObj);
				Boolean constraint = wellFormednessConstraints.get(mayModelObjSMTEncoding);
				boolean exists;
				if (constraint == null) {
					exists = state.nextBoolean();
					if (mayModelObj instanceof Node) {
						if (!exists) {
							for (Edge edgeAsSrc : ((Node) mayModelObj).getEdgesAsSrc()) {
								wellFormednessConstraints.put(getNamedElementSMTEncoding(edgeAsSrc), new Boolean(false));
							}
							for (Edge edgeAsTgt : ((Node) mayModelObj).getEdgesAsTgt()) {
								wellFormednessConstraints.put(getNamedElementSMTEncoding(edgeAsTgt), new Boolean(false));
							}
						}
					}
					else { // mayModelObj instanceof Edge
						if (exists) {
							wellFormednessConstraints.put(getNamedElementSMTEncoding(((Edge) mayModelObj).getSrc()), new Boolean(true));
							wellFormednessConstraints.put(getNamedElementSMTEncoding(((Edge) mayModelObj).getTgt()), new Boolean(true));
						}
					}
				}
				else {
					exists = constraint;
					wellFormednessConstraints.remove(mayModelObjSMTEncoding);
				}
				// create encoding
				if (!exists) {
					concretization.append("(not ");
				}
				concretization.append('(');
				concretization.append(mayModelObjSMTEncoding);
				concretization.append(')');
				if (!exists) {
					concretization.append(')');
				}
			}
			concretization.append(')');
		}
		while (concretizations.contains(concretization.toString()));
		concretizations.add(concretization.toString());
	}

	public String getSMTLIBEncoding() {

		return smtlibEncoding;
	}

	public String getSMTLIBMAVOEncoding() {

		return smtlibMavoEncoding;
	}

	public HashSet<String> getSMTLIBConcretizations() {

		return smtlibConcretizations;
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

		// get output from previous operator
		List<MAVOElement> mayModelObjs = ((RandomModelGenerateLabeledGraph) MultiModelTypeRegistry.getOperatorType(PREVIOUS_OPERATOR_URI).getExecutable()).getMAVOModelObjects();
		long maxConcretizations = Math.round(Math.pow(2, mayModelObjs.size()));
		if (numConcretizations > maxConcretizations) {
			throw new MMTFException("numConcretizations (" + numConcretizations + ") > maxConcretizations (" + maxConcretizations + ")");
		}

		// generate smt concretizations
		smtlibConcretizations = new HashSet<String>();
		String concretizations = "";
		if (maxConcretizations > 1) {
			//TODO MMTF: add heuristics to detect too large number of concretizations (when it's more efficient to generate them all and then cut some)
			for (int i = 0; i < numConcretizations; i++) {
				generateConcretization(smtlibConcretizations, mayModelObjs);
			}
			StringBuilder concretizationsBuilder = new StringBuilder(SMTLIB_CONCRETIZATION_PREAMBLE);
			Iterator<String> iter = smtlibConcretizations.iterator();
			while (iter.hasNext()) {
				concretizationsBuilder.append(iter.next());
				concretizationsBuilder.append('\n');
			}
			concretizationsBuilder.append(SMTLIB_CONCRETIZATION_POSTAMBLE);
			concretizations = concretizationsBuilder.toString();
		}

		// generate smt-lib representation of the random model
		List<Object> m2tArgs = new ArrayList<Object>();
		m2tArgs.add(SMTLIB_CONCRETIZATION_MARKER1);
		m2tArgs.add(SMTLIB_CONCRETIZATION_MARKER2);
		m2tArgs.add(concretizations);
		String workspaceUri = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		File folder = (new File(workspaceUri + randommodelModel.getUri())).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		RandomModelToSMTLIB_M2T m2t = new RandomModelToSMTLIB_M2TWithListeners(MultiModelTypeIntrospection.getRoot(randommodelModel), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return actualParameters;
	}

}
