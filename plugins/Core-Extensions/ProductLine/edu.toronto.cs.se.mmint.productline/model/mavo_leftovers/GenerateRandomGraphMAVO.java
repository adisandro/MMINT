/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.graph_mavo.operator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVOPackage;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.modelepedia.graph_mavo.Edge;
import edu.toronto.cs.se.modelepedia.graph_mavo.Graph;
import edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOFactory;
import edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage;
import edu.toronto.cs.se.modelepedia.graph_mavo.Node;

public class GenerateRandomGraphMAVO extends RandomOperatorImpl {

	// input-output
	private final static @NonNull String OUT_MODEL = "random";
	/** Min number of model objects in the random graph. */
	private static final String PROPERTY_IN_MINMODELOBJS = "minModelObjs";
	/** Max number of model objects in the random graph. */
	private static final String PROPERTY_IN_MAXMODELOBJS = "maxModelObjs";
	private static final String PROPERTY_IN_EDGESTONODESRATIO = "edges.toNodesRatio";
	/** % of MAVO model objects in the random model. */
	private static final String PROPERTY_IN_PERCMAVO = "percMavo";
	/** % of may model objects among the MAVO ones. */
	private static final String PROPERTY_IN_PERCMAY = "percMay";
	/** % of set model objects among the MAVO ones. */
	private static final String PROPERTY_IN_PERCSET = "percSet";
	/** % of var model objects among the MAVO ones. */
	private static final String PROPERTY_IN_PERCVAR = "percVar";
	private static final String NODE_NAME_PREFIX = "n";
	private static final String EDGE_NAME_PREFIX = "e";
	private static final String RANDOM_MODEL_NAME = "random";

	private int minModelObjs;
	private int maxModelObjs;
	private double edgesToNodesRatio;
	private double percMavo;
	private double percMay;
	private double percSet;
	private double percVar;
	private Map<String, MAVOElement> mavoModelObjs;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		maxModelObjs = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MAXMODELOBJS);
		minModelObjs = MIDOperatorIOUtils.getOptionalIntProperty(inputProperties, PROPERTY_IN_MINMODELOBJS, maxModelObjs);
		if (minModelObjs > maxModelObjs) {
			throw new MMINTException("minModelElems (" + minModelObjs + ") > maxModelElems (" + maxModelObjs + ")");
		}
		edgesToNodesRatio = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROPERTY_IN_EDGESTONODESRATIO);
		percMavo = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROPERTY_IN_PERCMAVO);
		percMay = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROPERTY_IN_PERCMAY);
		percSet = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROPERTY_IN_PERCSET);
		percVar = MIDOperatorIOUtils.getDoubleProperty(inputProperties, PROPERTY_IN_PERCVAR);
	}

	private void init() {

		// state
		mavoModelObjs = new HashMap<>();
	}

	private int addMayEdges(Node mayNode, List<MAVOElement> mavoAnnotatableModelObjs) {

		int i = 0;
		for (Edge edgeAsSrc : mayNode.getEdgesAsSource()) {
			if (!edgeAsSrc.isMay()) {
				mavoAnnotatableModelObjs.remove(edgeAsSrc);
				edgeAsSrc.setMay(true);
				mavoModelObjs.put(edgeAsSrc.getFormulaVariable(), edgeAsSrc);
				i++;
			}
		}
		for (Edge edgeAsTgt : mayNode.getEdgesAsTarget()) {
			if (!edgeAsTgt.isMay()) {
				mavoAnnotatableModelObjs.remove(edgeAsTgt);
				edgeAsTgt.setMay(true);
				mavoModelObjs.put(edgeAsTgt.getFormulaVariable(), edgeAsTgt);
				i++;
			}
		}

		return i;
	}

	private void addMAVOElements(List<MAVOElement> mavoableModelObjs, EStructuralFeature mavoFeature, double mavoPerc) {

		List<MAVOElement> mavoAnnotatableModelObjs = new ArrayList<>(mavoableModelObjs);
		MAVOElement mavoModelObj;
		int numMavo = (int) Math.round(mavoPerc * mavoableModelObjs.size());
		for (int i = 0; i < numMavo; i++) {
			mavoModelObj = mavoAnnotatableModelObjs.remove(state.nextInt(mavoAnnotatableModelObjs.size()));
			mavoModelObj.eSet(mavoFeature, true);
			if (mavoFeature == MAVOPackage.eINSTANCE.getMAVOElement_May() && mavoModelObj instanceof Node) {
				i += addMayEdges((Node) mavoModelObj, mavoAnnotatableModelObjs);
			}
			mavoModelObjs.put(mavoModelObj.getFormulaVariable(), mavoModelObj);
		}
	}

	private Graph generateRandomGraph() throws Exception {

		int totModelObjs = state.nextInt(maxModelObjs - minModelObjs + 1) + minModelObjs;
		int[] numModelObjs = new int[2];
		numModelObjs[0] = Math.max(
			1,
			(int) Math.round(totModelObjs / (1 + edgesToNodesRatio))
		);
		numModelObjs[1] = totModelObjs - numModelObjs[0];

		// generate nodes and edges
		List<MAVOElement> randomModelObjs = new ArrayList<>();
		Graph randomGraph = Graph_MAVOFactory.eINSTANCE.createGraph();
		EList<Node> randomGraphNodes = randomGraph.getNodes();
		String name;
		Node node;
		for (int i = 0; i < numModelObjs[0]; i++) {
			node = Graph_MAVOFactory.eINSTANCE.createNode();
			name = NODE_NAME_PREFIX + (i+1);
			node.setName(name);
			node.setFormulaVariable(name);
			randomGraphNodes.add(node);
			randomModelObjs.add(node);
		}
		EList<Edge> randomGraphEdges = randomGraph.getEdges();
		Edge edge;
		for (int i = 0; i < numModelObjs[1]; i++) {
			edge = Graph_MAVOFactory.eINSTANCE.createEdge();
			name = EDGE_NAME_PREFIX + (i+1);
			edge.setName(name);
			edge.setFormulaVariable(name);
			edge.setSource(randomGraphNodes.get(state.nextInt(numModelObjs[0])));
			edge.setTarget(randomGraphNodes.get(state.nextInt(numModelObjs[0])));
			randomGraphEdges.add(edge);
			randomModelObjs.add(edge);
		}

		// add mavo annotations
		List<MAVOElement> mavoableModelObjs = new ArrayList<>();
		int numMavo = (int) Math.round(percMavo * randomModelObjs.size());
		for (int i = 0; i < numMavo; i++) {
			mavoableModelObjs.add(randomModelObjs.remove(state.nextInt(randomModelObjs.size())));
		}
		addMAVOElements(mavoableModelObjs, MAVOPackage.eINSTANCE.getMAVOElement_May(), percMay);
		addMAVOElements(mavoableModelObjs, MAVOPackage.eINSTANCE.getMAVOElement_Set(), percSet);
		addMAVOElements(mavoableModelObjs, MAVOPackage.eINSTANCE.getMAVOElement_Var(), percVar);

		return randomGraph;
	}

	public Map<String, MAVOElement> getMAVOModelObjects() {

		return mavoModelObjs;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		MID instanceMID = outputMIDsByName.get(OUT_MODEL);
		this.init();

		// create random graph
		Graph randomGraph = generateRandomGraph();
		String lastSegmentUri = RANDOM_MODEL_NAME + (new Date()).getTime() + MMINT.MODEL_FILEEXTENSION_SEPARATOR + Graph_MAVOPackage.eNAME;
		String subdir = getWorkingPath();
		if (subdir != null) {
			lastSegmentUri = subdir + MMINT.URI_SEPARATOR + lastSegmentUri;
		}

		// output
		String randomGraphModelPath = FileUtils.replaceLastSegmentInPath(MMINT.getActiveInstanceMIDFile().getFullPath().toString(), lastSegmentUri);
		Model graphModelType = MIDTypeRegistry.getType(Graph_MAVOPackage.eINSTANCE.getNsURI());
		Model randomGraphModel = graphModelType.createInstanceAndEditor(randomGraph, randomGraphModelPath, instanceMID);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, randomGraphModel);

		return outputsByName;
	}

}
