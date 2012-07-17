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
package edu.toronto.cs.se.modelepedia.operator.statistics;

import java.io.FileInputStream;
import java.util.Properties;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.impl.OperatorExecutableImpl;
import edu.toronto.cs.se.modelepedia.operator.statistics.ExperimentSamples.DistributionType;

public class ExperimentDriver extends OperatorExecutableImpl {

	public static final String PROPERTIES_FILE = "experiment.properties";
	/** Min number of iterations (i.e. samples to generate). */
	public static final String PROPERTY_MINSAMPLES = "minSamples";
	/** Max number of iterations (i.e. samples to generate). */
	public static final String PROPERTY_MAXSAMPLES = "maxSamples";
	/** Min value a sample can take. */
	public static final String PROPERTY_MINSAMPLEVALUE = "minSampleValue";
	/** Max value a sample can take, -1 for unlimited. */
	public static final String PROPERTY_MAXSAMPLEVALUE = "maxSampleValue";
	/** The distribution type to be used when evaluating the confidence. */
	public static final String PROPERTY_DISTRIBUTIONTYPE = "distributionType";
	/** The requested range of confidence interval (% with respect to average value), after which the experiment can be stopped. */
	public static final String PROPERTY_REQUESTEDCONFIDENCE = "requestedConfidence";

	private String getProperty(Properties properties, String propertyName) throws MMTFException {

		String property = properties.getProperty(PROPERTY_MINSAMPLES);
		if (property == null) {
			throw new MMTFException("Missing property " + propertyName);
		}

		return property;
	}

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		// get experiment properties
		Model model = actualParameters.get(0);
		String workspaceUri = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		String baseUri = model.getUri().substring(0, model.getUri().lastIndexOf(IPath.SEPARATOR)+1);
		String propertiesFile =
			workspaceUri +
			baseUri +
			PROPERTIES_FILE;
		Properties properties = new Properties();
		properties.load(new FileInputStream(propertiesFile));

		//TODO MMTF: properties ->
		//OUTER
		// -annotated, -may, -var, -set
		// min instances in model
		// max instances in model
		// maybe min e max instances in model element
		// initial seed
		// output file/format
		//INNER
		int minSamples = Integer.parseInt(getProperty(properties, PROPERTY_MINSAMPLES));
		int maxSamples = Integer.parseInt(getProperty(properties, PROPERTY_MAXSAMPLES));
		double min = Double.parseDouble(getProperty(properties, PROPERTY_MINSAMPLEVALUE));
		double max = Double.parseDouble(getProperty(properties, PROPERTY_MAXSAMPLEVALUE));
		if (max == -1) {
			max = Double.MAX_VALUE;
		}
		DistributionType distribution = DistributionType.valueOf(getProperty(properties, PROPERTY_DISTRIBUTIONTYPE));
		double requestedConfidence = Double.parseDouble(getProperty(properties, PROPERTY_REQUESTEDCONFIDENCE));

		//TODO MMTF: outer cycle -> variate experiment setup
		//TODO MMTF: inner cycle-> setup is constant, create sample by running X, evaluate confidence interval
		ExperimentSamples experiment = new ExperimentSamples(maxSamples, distribution, min, max, requestedConfidence);
		for (int i = 0; i < maxSamples; i++) {
			double sample = 0;//TODO MMTF: run right operator
			boolean confidenceOk = experiment.addSample(sample);
			if (confidenceOk && i >= minSamples) {
				break;
			}
		}

		//TODO MMTF: save results somewhere
		experiment.getLowerConfidence();
		experiment.getAverage();
		experiment.getUpperConfidence();

		return null;
	}

}
