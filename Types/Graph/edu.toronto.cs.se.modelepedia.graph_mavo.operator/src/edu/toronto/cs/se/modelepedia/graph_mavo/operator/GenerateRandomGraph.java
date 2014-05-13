/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mavo.MavoPackage;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.modelepedia.graph_mavo.Edge;
import edu.toronto.cs.se.modelepedia.graph_mavo.Graph;
import edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOFactory;
import edu.toronto.cs.se.modelepedia.graph_mavo.Graph_MAVOPackage;
import edu.toronto.cs.se.modelepedia.graph_mavo.Node;

public class GenerateRandomGraph extends RandomOperatorImpl {

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
	private static final String RANDOM_MODEL_NAME = "random";

	private int minModelObjs;
	private int maxModelObjs;
	private double edgesToNodesRatio;
	private double percMavo;
	private double percMay;
	private double percSet;
	private double percVar;
	private List<MAVOElement> mavoModelObjs;
	private EList<Node> randomGraphNodes;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		maxModelObjs = MultiModelOperatorUtils.getIntProperty(inputProperties, PROPERTY_IN_MAXMODELOBJS);
		minModelObjs = MultiModelOperatorUtils.getOptionalIntProperty(inputProperties, PROPERTY_IN_MINMODELOBJS, maxModelObjs);
		edgesToNodesRatio = MultiModelOperatorUtils.getDoubleProperty(inputProperties, PROPERTY_IN_EDGESTONODESRATIO);
		percMavo = MultiModelOperatorUtils.getDoubleProperty(inputProperties, PROPERTY_IN_PERCMAVO);
		percMay = MultiModelOperatorUtils.getDoubleProperty(inputProperties, PROPERTY_IN_PERCMAY);
		percSet = MultiModelOperatorUtils.getDoubleProperty(inputProperties, PROPERTY_IN_PERCSET);
		percVar = MultiModelOperatorUtils.getDoubleProperty(inputProperties, PROPERTY_IN_PERCVAR);
	}

	private void init() {

		mavoModelObjs = new ArrayList<MAVOElement>();
		randomGraphNodes = null;
	}

	private int addMayEdges(Node mayNode, List<MAVOElement> mavoAnnotatableModelObjs) {

		int i = 0;
		for (Edge edgeAsSrc : mayNode.getEdgesAsSource()) {
			if (!edgeAsSrc.isMay()) {
				mavoAnnotatableModelObjs.remove(edgeAsSrc);
				edgeAsSrc.setMay(true);
				mavoModelObjs.add(edgeAsSrc);
				i++;
			}
		}
		for (Edge edgeAsTgt : mayNode.getEdgesAsTarget()) {
			if (!edgeAsTgt.isMay()) {
				mavoAnnotatableModelObjs.remove(edgeAsTgt);
				edgeAsTgt.setMay(true);
				mavoModelObjs.add(edgeAsTgt);
				i++;
			}
		}

		return i;
	}

	private void addMAVOElements(List<MAVOElement> mavoableModelObjs, EStructuralFeature mavoFeature, double mavoPerc) {

		List<MAVOElement> mavoAnnotatableModelObjs = new ArrayList<MAVOElement>(mavoableModelObjs);
		MAVOElement mavoModelObj;
		int numMavo = (int) Math.round(mavoPerc * mavoableModelObjs.size());
		for (int i = 0; i < numMavo; i++) {
			mavoModelObj = mavoAnnotatableModelObjs.remove(state.nextInt(mavoAnnotatableModelObjs.size()));
			mavoModelObj.eSet(mavoFeature, true);
			if (mavoFeature == MavoPackage.eINSTANCE.getMAVOElement_May() && mavoModelObj instanceof Node) {
				i += addMayEdges((Node) mavoModelObj, mavoAnnotatableModelObjs);
			}
			mavoModelObjs.add(mavoModelObj);
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
		List<MAVOElement> randomModelObjs = new ArrayList<MAVOElement>();
		Graph randomGraph = Graph_MAVOFactory.eINSTANCE.createGraph();
		randomGraphNodes = randomGraph.getNodes();
		Node node;
		for (int i = 0; i < numModelObjs[0]; i++) {
			node = Graph_MAVOFactory.eINSTANCE.createNode();
			node.setName(String.valueOf(i+1));
			randomGraphNodes.add(node);
			randomModelObjs.add(node);
		}
		EList<Edge> randomGraphEdges = randomGraph.getEdges();
		Edge edge;
		for (int i = 0; i < numModelObjs[1]; i++) {
			edge = Graph_MAVOFactory.eINSTANCE.createEdge();
			edge.setName(String.valueOf(i+1));
			edge.setSource(randomGraphNodes.get(state.nextInt(numModelObjs[0])));
			edge.setTarget(randomGraphNodes.get(state.nextInt(numModelObjs[0])));
			randomGraphEdges.add(edge);
			randomModelObjs.add(edge);
		}

		// add mavo annotations
		List<MAVOElement> mavoableModelObjs = new ArrayList<MAVOElement>();
		int numMavo = (int) Math.round(percMavo * randomModelObjs.size());
		for (int i = 0; i < numMavo; i++) {
			mavoableModelObjs.add(randomModelObjs.remove(state.nextInt(randomModelObjs.size())));
		}
		addMAVOElements(mavoableModelObjs, MavoPackage.eINSTANCE.getMAVOElement_May(), percMay);
		addMAVOElements(mavoableModelObjs, MavoPackage.eINSTANCE.getMAVOElement_Set(), percSet);
		addMAVOElements(mavoableModelObjs, MavoPackage.eINSTANCE.getMAVOElement_Var(), percVar);

		return randomGraph;
	}

	public List<MAVOElement> getMAVOModelObjects() {

		return mavoModelObjs;
	}

	public EList<Node> getRandomGraphNodes() {

		return randomGraphNodes;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		if (minModelObjs > maxModelObjs) {
			throw new MMINTException("minModelElems (" + minModelObjs + ") > maxModelElems (" + maxModelObjs + ")");
		}

		init();
		Graph randomGraph = generateRandomGraph();
		String lastSegmentUri = RANDOM_MODEL_NAME + (new Date()).getTime() + MMINT.MODEL_FILEEXTENSION_SEPARATOR + Graph_MAVOPackage.eNAME;
		String subdir = MultiModelOperatorUtils.getSubdir(getInputProperties());
		if (subdir != null) {
			lastSegmentUri = subdir + MMINT.URI_SEPARATOR + lastSegmentUri;
		}
		MultiModel instanceMid = MultiModelOperatorUtils.getInstanceMIDFromOperatorWithNoParameters();
		String randomGraphModelUri = MultiModelUtils.replaceLastSegmentInUri(EcoreUtil.getURI(instanceMid).toPlatformString(true), lastSegmentUri);
		MultiModelUtils.createModelFile(randomGraph, randomGraphModelUri, true);
		Model graphModelType = MultiModelTypeRegistry.getType(Graph_MAVOPackage.eINSTANCE.getNsURI());
		Model randomGraphModel;
		randomGraphModel = (MultiModelOperatorUtils.isUpdatingMID(getInputProperties())) ?
			graphModelType.createInstanceAndEditor(randomGraphModelUri, ModelOrigin.CREATED, instanceMid) :
			graphModelType.createInstance(randomGraphModelUri, ModelOrigin.CREATED, null);

		EList<Model> result = new BasicEList<Model>();
		result.add(randomGraphModel);
		return result;
	}

}
