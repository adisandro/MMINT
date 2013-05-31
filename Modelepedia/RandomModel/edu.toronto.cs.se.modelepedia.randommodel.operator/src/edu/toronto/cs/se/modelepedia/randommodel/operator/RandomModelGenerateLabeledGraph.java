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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.MMTF;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmtf.mavo.MAVOElement;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.ModelOrigin;
import edu.toronto.cs.se.mmtf.mid.MultiModel;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.mid.operator.impl.RandomOperatorExecutableImpl;
import edu.toronto.cs.se.modelepedia.randommodel.Edge;
import edu.toronto.cs.se.modelepedia.randommodel.Node;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModel;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelFactory;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;

public class RandomModelGenerateLabeledGraph extends RandomOperatorExecutableImpl {

	/** Min number of model objects in the random model. */
	private static final String PROPERTY_IN_MINMODELOBJS = "minModelObjs";
	/** Max number of model objects in the random model. */
	private static final String PROPERTY_IN_MAXMODELOBJS = "maxModelObjs";
	//TODO MMTF: to be generic here we need a list a model elements and a ratio formula
	private static final String PROPERTY_IN_EDGESTONODESRATIO = "edges.toNodesRatio";
	/** % of annotated objects in the random model. */
	private static final String PROPERTY_IN_PERCANNOTATIONS = "percAnnotations";
	/** % of may objects among the annotated elements. */
	private static final String PROPERTY_IN_PERCMAY = "percMay";
	/** % of set objects among the annotated elements. */
	private static final String PROPERTY_IN_PERCSET = "percSet";
	/** % of var objects among the annotated elements. */
	private static final String PROPERTY_IN_PERCVAR = "percVar";
	private static final String RANDOM_SUFFIX = "_random";

	private int minModelObjs;
	private int maxModelObjs;
	private double edgesToNodesRatio;
	private double percAnnotations;
	private double percMay;
	private double percSet;
	private double percVar;
	private List<MAVOElement> mavoModelObjs;
	private EList<Node> randommodelNodes;

	public enum MAVOAnnotation {
		M, S, V
	}

	private void readProperties(Properties properties) throws Exception {

		maxModelObjs = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MAXMODELOBJS);
		minModelObjs = MultiModelOperatorUtils.getOptionalIntProperty(properties, PROPERTY_IN_MINMODELOBJS, maxModelObjs);
		edgesToNodesRatio = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_EDGESTONODESRATIO);
		percAnnotations = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_PERCANNOTATIONS);
		percMay = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_PERCMAY);
		percSet = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_PERCSET);
		percVar = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_PERCVAR);
	}

	private int increaseEdgesMayUncertainty(Model newRandommodelModel, Node mayAnnotatedNode, List<MAVOElement> mavoAnnotatableModelObjs) {

		int i = 0;
		for (Edge edgeAsSrc : mayAnnotatedNode.getEdgesAsSrc()) {
			if (!edgeAsSrc.isMay()) {
				mavoAnnotatableModelObjs.remove(edgeAsSrc);
				edgeAsSrc.setMay(true);
				mavoModelObjs.add(edgeAsSrc);
				i++;
			}
		}
		for (Edge edgeAsTgt : mayAnnotatedNode.getEdgesAsTgt()) {
			if (!edgeAsTgt.isMay()) {
				mavoAnnotatableModelObjs.remove(edgeAsTgt);
				edgeAsTgt.setMay(true);
				mavoModelObjs.add(edgeAsTgt);
				i++;
			}
		}

		return i;
	}

	private void annotateMAVOElements(Model newRandommodelModel, List<MAVOElement> annotatableModelObjs, MAVOAnnotation mavoAnnotation, double mavoPerc) {

		List<MAVOElement> mavoAnnotatableModelObjs = new ArrayList<MAVOElement>(annotatableModelObjs);
		MAVOElement mavoModelObj;
		int numMavo = (int) Math.round(mavoPerc * annotatableModelObjs.size());
		for (int i = 0; i < numMavo; i++) {
			mavoModelObj = mavoAnnotatableModelObjs.remove(state.nextInt(mavoAnnotatableModelObjs.size()));
			switch (mavoAnnotation) {
				case M:
					mavoModelObj.setMay(true);
					if (mavoModelObj instanceof Node) {
						i += increaseEdgesMayUncertainty(newRandommodelModel, (Node) mavoModelObj, mavoAnnotatableModelObjs);
					}
					break;
				case S:
					mavoModelObj.setSet(true);
					break;
				case V:
					mavoModelObj.setVar(true);
					break;
			}
			mavoModelObjs.add(mavoModelObj);
		}
	}

	private RandomModel generateRandomMAVOModel(Model labeledGraphModel, Model newRandommodelModel) throws Exception {

		int totModelObjs = state.nextInt(maxModelObjs - minModelObjs + 1) + minModelObjs;
		int[] numModelObjs = new int[2];
		numModelObjs[0] = Math.max(
			1,
			(int) Math.round(totModelObjs / (1 + edgesToNodesRatio))
		);
		numModelObjs[1] = totModelObjs - numModelObjs[0];

		List<MAVOElement> randomModelObjs = new ArrayList<MAVOElement>();
		RandomModel randomRoot = RandomModelFactory.eINSTANCE.createRandomModel();
		randommodelNodes = randomRoot.getNodes();
		Node node;
		String nodeType = RandomModelPackage.eINSTANCE.getNode().getName().toLowerCase();
		for (int i = 0; i < numModelObjs[0]; i++) {
			node = RandomModelFactory.eINSTANCE.createNode();
			node.setName(String.valueOf(i+1));
			node.setType(nodeType);
			randommodelNodes.add(node);
			randomModelObjs.add(node);
		}
		EList<Edge> randommodelEdges = randomRoot.getEdges();
		Edge edge;
		String edgeType = RandomModelPackage.eINSTANCE.getEdge().getName().toLowerCase();
		for (int i = 0; i < numModelObjs[1]; i++) {
			edge = RandomModelFactory.eINSTANCE.createEdge();
			edge.setName(String.valueOf(i+1));
			edge.setType(edgeType);
			edge.setSrc(randommodelNodes.get(state.nextInt(numModelObjs[0])));
			edge.setTgt(randommodelNodes.get(state.nextInt(numModelObjs[0])));
			randommodelEdges.add(edge);
			randomModelObjs.add(edge);
		}

		// all annotated elements
		List<MAVOElement> annotatableModelObjs = new ArrayList<MAVOElement>();
		int numAnnotations = (int) Math.round(percAnnotations * randomModelObjs.size());
		for (int i = 0; i < numAnnotations; i++) {
			annotatableModelObjs.add(randomModelObjs.remove(state.nextInt(randomModelObjs.size())));
		}
		annotateMAVOElements(newRandommodelModel, annotatableModelObjs, MAVOAnnotation.M, percMay);
		annotateMAVOElements(newRandommodelModel, annotatableModelObjs, MAVOAnnotation.S, percSet);
		annotateMAVOElements(newRandommodelModel, annotatableModelObjs, MAVOAnnotation.V, percVar);

		return randomRoot;
	}

	public List<MAVOElement> getMAVOModelObjects() {

		return mavoModelObjs;
	}

	public EList<Node> getRandommodelNodes() {

		return randommodelNodes;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		//TODO MMTF: fix this inputSubdir thing
		Model labeledGraphModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			labeledGraphModel,
			inputSubdir,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);
		if (minModelObjs > maxModelObjs) {
			throw new MMTFException("minModelElems (" + minModelObjs + ") > maxModelElems (" + maxModelObjs + ")");
		}
		mavoModelObjs = new ArrayList<MAVOElement>();

		// create model first in order to contain mavo model elements
		String modelTypeName = labeledGraphModel.getMetatype().getName();
		String newLastSegmentUri = modelTypeName + RANDOM_SUFFIX + (new Date()).getTime() + MultiModelRegistry.ECORE_MODEL_FILEEXTENSION_SEPARATOR + RandomModelPackage.eNAME;
		String subdir = MultiModelOperatorUtils.getSubdir(inputProperties);
		if (subdir != null) {
			newLastSegmentUri = subdir + MMTF.URI_SEPARATOR + newLastSegmentUri;
		}
		String newRandommodelModelUri = MultiModelRegistry.replaceLastSegmentInUri(labeledGraphModel.getUri(), newLastSegmentUri);
		EList<Model> result = new BasicEList<Model>();
		boolean updateMid = MultiModelOperatorUtils.isUpdatingMid(inputProperties);
		MultiModel multiModel = (updateMid) ?
			MultiModelRegistry.getMultiModel(labeledGraphModel) :
			null;
		Model modelType = MultiModelTypeRegistry.getExtendibleElementType(RandomModelPackage.eINSTANCE.getNsURI());
		Model newRandommodelModel = (updateMid) ?
			MultiModelInstanceFactory.createModelAndEditor(modelType, newRandommodelModelUri, ModelOrigin.CREATED, multiModel) :
			MultiModelInstanceFactory.createModel(modelType, newRandommodelModelUri, ModelOrigin.CREATED, null);
		result.add(newRandommodelModel);

		// create random instance
		RandomModel randomRoot = generateRandomMAVOModel(labeledGraphModel, newRandommodelModel);
		randomRoot.setName(MultiModelRegistry.getFileNameFromUri(newRandommodelModelUri));
		randomRoot.setType(modelTypeName);
		MultiModelTypeIntrospection.writeRoot(randomRoot, newRandommodelModelUri, true);

		return result;
	}

}
