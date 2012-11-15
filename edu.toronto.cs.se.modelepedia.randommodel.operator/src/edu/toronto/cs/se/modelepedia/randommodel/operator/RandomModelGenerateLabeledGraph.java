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
import edu.toronto.cs.se.mmtf.mid.operator.impl.RandomOperatorExecutableImpl;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelInstanceFactory;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelRegistry;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.modelepedia.randommodel.Edge;
import edu.toronto.cs.se.modelepedia.randommodel.NamedElement;
import edu.toronto.cs.se.modelepedia.randommodel.Node;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModel;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelFactory;
import edu.toronto.cs.se.modelepedia.randommodel.RandomModelPackage;

public class RandomModelGenerateLabeledGraph extends RandomOperatorExecutableImpl {

	/** Min number of model elements in the random model. */
	private static final String PROPERTY_IN_MINMODELELEMS = "minModelElems";
	/** Max number of model elements in the random model. */
	private static final String PROPERTY_IN_MAXMODELELEMS = "maxModelElems";
	/** % of annotated elements in the random model. */
	private static final String PROPERTY_IN_PERCANNOTATIONS = "percAnnotations";
	/** % of may elements among the annotated elements. */
	private static final String PROPERTY_IN_PERCMAY = "percMay";
	/** % of set elements among the annotated elements. */
	private static final String PROPERTY_IN_PERCSET = "percSet";
	/** % of var elements among the annotated elements. */
	private static final String PROPERTY_IN_PERCVAR = "percVar";
	/** The list of may annotated model elements. */
	private static final String PROPERTY_OUT_MAYMODELELEMS = "mayModelElems";
	/** The list of set annotated model elements. */
	private static final String PROPERTY_OUT_SETMODELELEMS = "setModelElems";
	/** The list of var annotated model elements. */
	private static final String PROPERTY_OUT_VARMODELELEMS = "varModelElems";
	private static final String RANDOM_SUFFIX = "_random";

	private int minModelElems;
	private int maxModelElems;
	private double percAnnotations;
	private double percMay;
	private double percSet;
	private double percVar;

	private void readProperties(Properties properties) throws Exception {

		minModelElems = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MINMODELELEMS);
		maxModelElems = MultiModelOperatorUtils.getIntProperty(properties, PROPERTY_IN_MAXMODELELEMS);
		percAnnotations = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_PERCANNOTATIONS);
		percMay = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_PERCMAY);
		percSet = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_PERCSET);
		percVar = MultiModelOperatorUtils.getDoubleProperty(properties, PROPERTY_IN_PERCVAR);
	}

	private void writeProperties(Properties properties, String mayModelElems, String setModelElems, String varModelElems) {

		properties.setProperty(PROPERTY_OUT_MAYMODELELEMS, mayModelElems);
		properties.setProperty(PROPERTY_OUT_SETMODELELEMS, setModelElems);
		properties.setProperty(PROPERTY_OUT_VARMODELELEMS, varModelElems);
	}

	private RandomModel generateRandomMAVOModel(Model labeledGraphModel, Properties inputProperties) throws Exception {

		int totModelElems = state.nextInt(maxModelElems - minModelElems + 1) + minModelElems;
		double[] percModelElems = new double[2];
		int[] numModelElems = new int[2];
		double sumPercModelElems = 0;
		for (int i = 0; i < percModelElems.length; i++) {
			percModelElems[i] = state.nextDouble();
			sumPercModelElems += percModelElems[i];
		}
		for (int i = 0; i < numModelElems.length; i++) {
			numModelElems[i] = (int) Math.round(percModelElems[i] / sumPercModelElems * totModelElems);
		}

		List<MAVOElement> randomModelElems = new ArrayList<MAVOElement>();
		RandomModel randomRoot = RandomModelFactory.eINSTANCE.createRandomModel();
		EList<Node> randomNodes = randomRoot.getNodes();
		Node node;
		for (int i = 0; i < numModelElems[0]; i++) {
			node = RandomModelFactory.eINSTANCE.createNode();
			node.setName(String.valueOf(i));
			randomNodes.add(node);
			randomModelElems.add(node);
		}
		EList<Edge> randomEdges = randomRoot.getEdges();
		Edge edge;
		for (int i = 0; i < numModelElems[1]; i++) {
			edge = RandomModelFactory.eINSTANCE.createEdge();
			edge.setName(String.valueOf(i));
			edge.setSrc(randomNodes.get(state.nextInt(numModelElems[0])));
			edge.setTgt(randomNodes.get(state.nextInt(numModelElems[0])));
			randomEdges.add(edge);
			randomModelElems.add(edge);
		}

		// all annotated elements
		List<MAVOElement> annotatedModelElems = new ArrayList<MAVOElement>();
		int numAnnotations = (int) Math.round(percAnnotations * randomModelElems.size());
		for (int i = 0; i < numAnnotations; i++) {
			annotatedModelElems.add(randomModelElems.remove(state.nextInt(randomModelElems.size())));
		}
		// may
		List<MAVOElement> mavoAnnotatedModelElems = new ArrayList<MAVOElement>(annotatedModelElems);
		MAVOElement mavoAnnotatedModelElem;
		StringBuilder mavoString = new StringBuilder();
		int numMay = (int) Math.round(percMay * annotatedModelElems.size());
		for (int i = 0; i < numMay; i++) {
			mavoAnnotatedModelElem = mavoAnnotatedModelElems.remove(state.nextInt(mavoAnnotatedModelElems.size()));
			mavoAnnotatedModelElem.setMay(true);
			mavoString.append(((NamedElement) mavoAnnotatedModelElem).getName());
			mavoString.append(',');
		}
		if (mavoString.length() > 0) {
			mavoString.deleteCharAt(mavoString.length() - 1);
		}
		String mayModelElems = mavoString.toString();
		// set
		mavoAnnotatedModelElems = new ArrayList<MAVOElement>(annotatedModelElems);
		mavoString = new StringBuilder();
		int numSet = (int) Math.round(percSet * annotatedModelElems.size());
		for (int i = 0; i < numSet; i++) {
			mavoAnnotatedModelElem = mavoAnnotatedModelElems.remove(state.nextInt(mavoAnnotatedModelElems.size()));
			mavoAnnotatedModelElem.setSet(true);
			mavoString.append(((NamedElement) mavoAnnotatedModelElem).getName());
			mavoString.append(',');
		}
		if (mavoString.length() > 0) {
			mavoString.deleteCharAt(mavoString.length() - 1);
		}
		String setModelElems = mavoString.toString();
		// var
		mavoAnnotatedModelElems = new ArrayList<MAVOElement>(annotatedModelElems);
		mavoString = new StringBuilder();
		int numVar = (int) Math.round(percVar * annotatedModelElems.size());
		for (int i = 0; i < numVar; i++) {
			mavoAnnotatedModelElem = mavoAnnotatedModelElems.remove(state.nextInt(mavoAnnotatedModelElems.size()));
			mavoAnnotatedModelElem.setVar(true);
			mavoString.append(((NamedElement) mavoAnnotatedModelElem).getName());
			mavoString.append(',');
		}
		if (mavoString.length() > 0) {
			mavoString.deleteCharAt(mavoString.length() - 1);
		}
		String varModelElems = mavoString.toString();
		// output properties
		Properties outputProperties = new Properties();
		writeProperties(outputProperties, mayModelElems, setModelElems, varModelElems);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			labeledGraphModel,
			MultiModelOperatorUtils.getSubdir(inputProperties),
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return randomRoot;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model labeledGraphModel = actualParameters.get(0);
		Properties inputProperties = MultiModelOperatorUtils.getPropertiesFile(
			this,
			labeledGraphModel,
			null,
			MultiModelOperatorUtils.INPUT_PROPERTIES_SUFFIX
		);
		readProperties(inputProperties);
		if (minModelElems > maxModelElems) {
			throw new MMTFException("minModelElems (" + minModelElems + ") > maxModelElems (" + maxModelElems + ")");
		}

		// create random instance
		String modelTypeName = labeledGraphModel.getMetatype().getName();
		String newLastSegmentUri = modelTypeName + RANDOM_SUFFIX + (new Date()).getTime() + MultiModelRegistry.ECORE_MODEL_FILEEXTENSION_SEPARATOR + RandomModelPackage.eNAME;
		String subdir = MultiModelOperatorUtils.getCreateSubdir(labeledGraphModel, inputProperties);
		if (subdir != null) {
			newLastSegmentUri = subdir + MMTF.URI_SEPARATOR + newLastSegmentUri;
		}
		String newRandommodelModelUri = MultiModelRegistry.replaceLastSegmentInUri(labeledGraphModel.getUri(), newLastSegmentUri);
		RandomModel randomRoot = generateRandomMAVOModel(labeledGraphModel, inputProperties);
		MultiModelTypeIntrospection.writeRoot(randomRoot, newRandommodelModelUri, true);

		// create model
		EList<Model> result = new BasicEList<Model>();
		boolean updateMid = MultiModelOperatorUtils.isUpdatingMid(inputProperties);
		MultiModel multiModel = (updateMid) ?
			MultiModelRegistry.getMultiModel(labeledGraphModel) :
			null;
		Model modelType = MultiModelTypeRegistry.getModelType(RandomModelPackage.eINSTANCE.getNsURI());
		Model newRandommodelModel = (updateMid) ?
			MultiModelInstanceFactory.createModelAndEditor(modelType, newRandommodelModelUri, ModelOrigin.CREATED, multiModel) :
			MultiModelInstanceFactory.createModel(modelType, newRandommodelModelUri, ModelOrigin.CREATED, null);
		result.add(newRandommodelModel);

		return result;
	}

}
