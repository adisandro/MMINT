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
import org.eclipse.emf.common.util.BasicEList;
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
				textGeneration.append(text);
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
	private static final String PROPERTY_IN_PROPERTY = "property";
	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_RandomModelGenerateLabeledGraph";
	private static final String SMTLIB_CONCRETIZATION_MARKER1 = ";Concretizations-START";
	private static final String SMTLIB_CONCRETIZATION_MARKER2 = ";Concretizations-END";
	private static final String SMTLIB_CONCRETIZATION_PREAMBLE = Z3SMTSolver.SMTLIB_ASSERT + Z3SMTSolver.SMTLIB_OR + '\n';
	private static final String SMTLIB_CONCRETIZATION_POSTAMBLE = Z3SMTSolver.SMTLIB_PREDICATE_END + Z3SMTSolver.SMTLIB_PREDICATE_END;

	private int numConcretizations;
	private int property;
	private List<MAVOElement> mayModelObjs;
	private String smtlibMavoEncoding;
	private String smtlibEncoding;
	private HashSet<String> smtlibConcretizations;
	private String groundedProperty;

	private void readProperties(Properties properties) throws Exception {

		numConcretizations = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_NUMCONCRETIZATIONS);
		property = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_PROPERTY);
	}

	public String getNamedElementSMTLIBEncoding(NamedElement namedElement) {

		return Z3SMTSolver.SMTLIB_PREDICATE_START + namedElement.getType() + ' ' + namedElement.getName() + Z3SMTSolver.SMTLIB_PREDICATE_END;
	}

	private void generateSMTLIBConcretization() {

		StringBuilder concretization;
		Map<String, Boolean> wellFormednessConstraints = new HashMap<String, Boolean>();
		do {
			String mayModelObjSMTEncoding;
			concretization = new StringBuilder(Z3SMTSolver.SMTLIB_AND);
			for (int j = 0; j < mayModelObjs.size(); j++) {
				// analyze well formedness rules
				NamedElement mayModelObj = (NamedElement) mayModelObjs.get(j);
				mayModelObjSMTEncoding = getNamedElementSMTLIBEncoding(mayModelObj);
				Boolean constraint = wellFormednessConstraints.get(mayModelObjSMTEncoding);
				boolean exists;
				if (constraint == null) {
					exists = state.nextBoolean();
					if (mayModelObj instanceof Node) {
						if (!exists) {
							for (Edge edgeAsSrc : ((Node) mayModelObj).getEdgesAsSrc()) {
								wellFormednessConstraints.put(getNamedElementSMTLIBEncoding(edgeAsSrc), new Boolean(false));
							}
							for (Edge edgeAsTgt : ((Node) mayModelObj).getEdgesAsTgt()) {
								wellFormednessConstraints.put(getNamedElementSMTLIBEncoding(edgeAsTgt), new Boolean(false));
							}
						}
					}
					else { // mayModelObj instanceof Edge
						if (exists) {
							wellFormednessConstraints.put(getNamedElementSMTLIBEncoding(((Edge) mayModelObj).getSrc()), new Boolean(true));
							wellFormednessConstraints.put(getNamedElementSMTLIBEncoding(((Edge) mayModelObj).getTgt()), new Boolean(true));
						}
					}
				}
				else {
					exists = constraint;
					wellFormednessConstraints.remove(mayModelObjSMTEncoding);
				}
				// create encoding
				if (!exists) {
					concretization.append(Z3SMTSolver.SMTLIB_NOT);
				}
				concretization.append(mayModelObjSMTEncoding);
				if (!exists) {
					concretization.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
				}
			}
			concretization.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
		}
		while (smtlibConcretizations.contains(concretization.toString()));
		smtlibConcretizations.add(concretization.toString());
	}

	//TODO MMTF: this would remove unnecessary logic
//	private boolean groundProperty6(Node node, StringBuilder propertyBuilder) {
//
//		// property 6: not more than one edge from a node to another
//		// true by construction
//		if (node.getEdgesAsSrc().size() <= 1) {
//			return true;
//		}
//		// construct map of target nodes
//		Map<Node, List<Edge>> tgtNode2EdgesMap = new HashMap<Node, List<Edge>>();
//		for (Edge outEdge : node.getEdgesAsSrc()) {
//			List<Edge> tgtNode2Edges = tgtNode2EdgesMap.get(outEdge.getTgt());
//			if (tgtNode2Edges == null) {
//				tgtNode2Edges = new ArrayList<Edge>();
//				tgtNode2Edges.add(outEdge);
//				tgtNode2EdgesMap.put(outEdge.getTgt(), tgtNode2Edges);
//			}
//			else {
//				tgtNode2Edges.add(outEdge);
//			}
//		}
//		// use map of target nodes
//		boolean allTrueByConstruction = true;
//		for (List<Edge> tgtNode2Edges : tgtNode2EdgesMap.values()) {
//			// true by construction
//			if (tgtNode2Edges.size() <= 1) {
//				continue;
//			}
//			// do this only once, outer AND
//			if (allTrueByConstruction) {
//				propertyBuilder.append('\n');
//				propertyBuilder.append(Z3SMTSolver.SMTLIB_AND);
//				allTrueByConstruction = false;
//			}
//			propertyBuilder.append(Z3SMTSolver.SMTLIB_OR);
//			// no edges
//			propertyBuilder.append(Z3SMTSolver.SMTLIB_AND);
//			for (Edge outEdge : tgtNode2Edges) {
//				propertyBuilder.append(Z3SMTSolver.SMTLIB_NOT);
//				propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdge));
//				propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
//			}
//			propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
//			// one edge only
//			for (Edge outEdgeI : tgtNode2Edges) {
//				propertyBuilder.append(Z3SMTSolver.SMTLIB_AND);
//				propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdgeI));
//				for (Edge outEdgeJ : tgtNode2Edges) {
//					if (outEdgeI == outEdgeJ) {
//						continue;
//					}
//					propertyBuilder.append(Z3SMTSolver.SMTLIB_NOT);
//					propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdgeJ));
//					propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
//				}
//				propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
//			}
//			propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
//		}
//		if (!allTrueByConstruction) {
//			propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
//		}
//
//		return allTrueByConstruction;
//	}
//
//	private void generateSMTLIBGroundedProperty(EList<Node> randommodelNodes) {
//
//		StringBuilder propertyBuilder = new StringBuilder();
//		boolean allTrueByConstruction = true;
//nodes:
//		for (Node node : randommodelNodes) {
//
//			switch (property) {
//				case 5:
//					groundProperty5(node, propertyBuilder);
//					break;
//				case 6:
//					if (groundProperty6(node, propertyBuilder)) {
//						continue nodes;
//					}
//					break;
//				case 8:
//					groundProperty8(node, propertyBuilder);
//					break;
//				case 10:
//					groundProperty10(node, propertyBuilder);
//					break;
//			}
//			// do this only once, outer AND
//			if (allTrueByConstruction) {
//				propertyBuilder.insert(0, Z3SMTSolver.SMTLIB_AND + '\n');
//				allTrueByConstruction = false;
//			}
//		}
//
//		if (!allTrueByConstruction) {
//			propertyBuilder.append('\n');
//			propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
//		}
//		groundedProperty = propertyBuilder.toString();
//	}

	private void groundProperty5(Node node, StringBuilder propertyBuilder) {

		// property 5: at most one outgoing edge per node
		// true by construction
		if (node.getEdgesAsSrc().size() <= 1) {
			propertyBuilder.append(Z3SMTSolver.SMTLIB_TRUE);
			return;
		}
		propertyBuilder.append(Z3SMTSolver.SMTLIB_OR);
		// no edges
		propertyBuilder.append(Z3SMTSolver.SMTLIB_AND);
		for (Edge outEdge : node.getEdgesAsSrc()) {
			propertyBuilder.append(Z3SMTSolver.SMTLIB_NOT);
			propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdge));
			propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
		}
		propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
		// one edge only
		for (Edge outEdgeI : node.getEdgesAsSrc()) {
			propertyBuilder.append(Z3SMTSolver.SMTLIB_AND);
			propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdgeI));
			for (Edge outEdgeJ : node.getEdgesAsSrc()) {
				if (outEdgeI == outEdgeJ) {
					continue;
				}
				propertyBuilder.append(Z3SMTSolver.SMTLIB_NOT);
				propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdgeJ));
				propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
			}
			propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
		}
		propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
	}

	private void groundProperty6(Node node, StringBuilder propertyBuilder) {

		// property 6: not more than one edge from a node to another
		// true by construction
		if (node.getEdgesAsSrc().size() <= 1) {
			propertyBuilder.append(Z3SMTSolver.SMTLIB_TRUE);
			return;
		}
		propertyBuilder.append(Z3SMTSolver.SMTLIB_AND);
		// construct map of target nodes
		Map<Node, List<Edge>> tgtNode2EdgesMap = new HashMap<Node, List<Edge>>();
		for (Edge outEdge : node.getEdgesAsSrc()) {
			List<Edge> tgtNode2Edges = tgtNode2EdgesMap.get(outEdge.getTgt());
			if (tgtNode2Edges == null) {
				tgtNode2Edges = new ArrayList<Edge>();
				tgtNode2Edges.add(outEdge);
				tgtNode2EdgesMap.put(outEdge.getTgt(), tgtNode2Edges);
			}
			else {
				tgtNode2Edges.add(outEdge);
			}
		}
		// use map of target nodes
		for (List<Edge> tgtNode2Edges : tgtNode2EdgesMap.values()) {
			// true by construction
			if (tgtNode2Edges.size() <= 1) {
				propertyBuilder.append(Z3SMTSolver.SMTLIB_TRUE);
				continue;
			}
			propertyBuilder.append(Z3SMTSolver.SMTLIB_OR);
			// no edges
			propertyBuilder.append(Z3SMTSolver.SMTLIB_AND);
			for (Edge outEdge : tgtNode2Edges) {
				propertyBuilder.append(Z3SMTSolver.SMTLIB_NOT);
				propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdge));
				propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
			}
			propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
			// one edge only
			for (Edge outEdgeI : tgtNode2Edges) {
				propertyBuilder.append(Z3SMTSolver.SMTLIB_AND);
				propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdgeI));
				for (Edge outEdgeJ : tgtNode2Edges) {
					if (outEdgeI == outEdgeJ) {
						continue;
					}
					propertyBuilder.append(Z3SMTSolver.SMTLIB_NOT);
					propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdgeJ));
					propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
				}
				propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
			}
			propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
		}
		propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
	}

	private void groundProperty8(Node node, StringBuilder propertyBuilder) {

		// property 8: no edges from a node to the same node
		boolean noSelfLoops = true;
		for (Edge outEdge : node.getEdgesAsSrc()) {
			// same src and tgt
			if (outEdge.getTgt() == node) {
				propertyBuilder.append(Z3SMTSolver.SMTLIB_NOT);
				propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdge));
				propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
				noSelfLoops = false;
			}
		}
		// true by construction
		if (noSelfLoops) {
			propertyBuilder.append(Z3SMTSolver.SMTLIB_TRUE);
		}
	}

	private void groundProperty10(Node node, StringBuilder propertyBuilder) {

		// property 10: at least one incoming or outgoing edge per node
		// false by construction
		if ((node.getEdgesAsSrc().size() + node.getEdgesAsTgt().size()) < 1) {
			propertyBuilder.append(Z3SMTSolver.SMTLIB_FALSE);
			return;
		}
		// at least one edge
		propertyBuilder.append(Z3SMTSolver.SMTLIB_OR);
		for (Edge outEdge : node.getEdgesAsSrc()) {
			propertyBuilder.append(getNamedElementSMTLIBEncoding(outEdge));
		}
		for (Edge inEdge : node.getEdgesAsTgt()) {
			propertyBuilder.append(getNamedElementSMTLIBEncoding(inEdge));
		}
		propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
	}

	private void generateSMTLIBGroundedProperty(EList<Node> randommodelNodes) {

		if (randommodelNodes.isEmpty()) {
			groundedProperty = "";
			return;
		}

		StringBuilder propertyBuilder = new StringBuilder();
		propertyBuilder.append(Z3SMTSolver.SMTLIB_AND);
		for (Node node : randommodelNodes) {
			propertyBuilder.append('\n');

			switch (property) {
				case 5:
					groundProperty5(node, propertyBuilder);
					break;
				case 6:
					groundProperty6(node, propertyBuilder);
					break;
				case 8:
					groundProperty8(node, propertyBuilder);
					break;
				case 10:
					groundProperty10(node, propertyBuilder);
					break;
			}
		}

		propertyBuilder.append('\n');
		propertyBuilder.append(Z3SMTSolver.SMTLIB_PREDICATE_END);
		groundedProperty = propertyBuilder.toString();
	}

	public List<MAVOElement> getMayModelObjects() {

		return mayModelObjs;
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

	public String getGroundedProperty() {

		return groundedProperty;
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
		RandomModelGenerateLabeledGraph previousOperator = (previousExecutable == null) ?
			(RandomModelGenerateLabeledGraph) MultiModelTypeRegistry.getOperatorType(PREVIOUS_OPERATOR_URI).getExecutable() :
			(RandomModelGenerateLabeledGraph) previousExecutable;
		mayModelObjs = previousOperator.getMAVOModelObjects();
		if (mayModelObjs == null) {
			mayModelObjs = new ArrayList<MAVOElement>();
		}
		long maxConcretizations = Math.round(Math.pow(2, mayModelObjs.size()));
		if (numConcretizations > maxConcretizations) {
			throw new MMTFException("numConcretizations (" + numConcretizations + ") > maxConcretizations (" + maxConcretizations + ")");
		}
		EList<Node> randommodelNodes = previousOperator.getRandommodelNodes();
		if (randommodelNodes == null) {
			randommodelNodes = new BasicEList<Node>();
		}

		// generate smt-lib concretizations
		smtlibConcretizations = new HashSet<String>();
		String concretizations = "";
		if (maxConcretizations > 1) {
			//TODO MMTF: add heuristics to detect too large number of concretizations (when it's more efficient to generate them all and then cut some)
			for (int i = 0; i < numConcretizations; i++) {
				generateSMTLIBConcretization();
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

		// ground property
		generateSMTLIBGroundedProperty(randommodelNodes);

		// generate smt-lib representation of the random model
		List<Object> m2tArgs = new ArrayList<Object>();
		m2tArgs.add(SMTLIB_CONCRETIZATION_MARKER1);
		m2tArgs.add(SMTLIB_CONCRETIZATION_MARKER2);
		m2tArgs.add(concretizations);
		m2tArgs.add(groundedProperty);
		String workspaceUri = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		File folder = (new File(workspaceUri + randommodelModel.getUri())).getParentFile();
		AcceleoPreferences.switchForceDeactivationNotifications(true);
		AcceleoPreferences.switchNotifications(false);
		RandomModelToSMTLIB_M2T m2t = new RandomModelToSMTLIB_M2TWithListeners(MultiModelTypeIntrospection.getRoot(randommodelModel), folder, m2tArgs);
		m2t.doGenerate(new BasicMonitor());

		return actualParameters;
	}

}
