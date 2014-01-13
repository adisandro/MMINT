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
package edu.toronto.cs.se.mmtf.mid.library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.operator.Operator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorExecutable;

public class MultiModelOperatorUtils {

	public static final String INPUT_PROPERTIES_SUFFIX = "In";
	public static final String OUTPUT_PROPERTIES_SUFFIX = "Out";
	public static final String PROPERTIES_SUFFIX = ".properties";
	/** The separator for multiple properties with the same key. */
	private static final String PROPERTY_SEPARATOR = ",";
	public static final String PROPERTY_IN_UPDATEMID = "updateMid";
	public static final String PROPERTY_IN_SUBDIR = "subdir";
	public static final String PROPERTY_IN_OUTPUTENABLED_SUFFIX = ".enabled";

	private static String getPropertiesUri(OperatorExecutable operator, Model anyOperatorParameter, String subdirName, boolean readonly) {

		String projectUri = anyOperatorParameter.getUri().substring(0, anyOperatorParameter.getUri().lastIndexOf(IPath.SEPARATOR)+1);
		String operatorName = ((Operator) operator.eContainer()).getName();
		String propertiesUri = MultiModelUtils.prependWorkspaceToUri(projectUri);
		if (subdirName != null) {
			File dir = new File(propertiesUri + subdirName);
			if (!readonly && !dir.exists()) {
				dir.mkdir();
			}
			propertiesUri += subdirName + IPath.SEPARATOR;
		}
		propertiesUri += operatorName;

		return propertiesUri;
	}

	public static Properties getPropertiesFile(OperatorExecutable operator, Model anyOperatorParameter, String subdirName, String suffix) throws Exception {

		String inputPropertiesFile =
			getPropertiesUri(operator, anyOperatorParameter, subdirName, true) +
			suffix +
			PROPERTIES_SUFFIX;
		Properties inputProperties = new Properties();
		inputProperties.load(new FileInputStream(inputPropertiesFile));

		return inputProperties;
	}

	public static void writePropertiesFile(Properties outputProperties, OperatorExecutable operator, Model anyOperatorParameter, String subdirName, String suffix) throws Exception {

		String outputPropertiesFile =
			getPropertiesUri(operator, anyOperatorParameter, subdirName, false) +
			suffix +
			PROPERTIES_SUFFIX;
		outputProperties.store(new FileOutputStream(outputPropertiesFile), null);
	}

	public static void writeTextFile(OperatorExecutable operator, Model anyOperatorParameter, String subdirName, String suffix, StringBuilder fileContent) throws IOException {

		String outputTextFile = getPropertiesUri(operator, anyOperatorParameter, subdirName, false) + suffix;
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(outputTextFile));
			writer.append(fileContent);
		}
		catch (IOException e) {
			throw e;
		}
		finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public static String getStringProperty(Properties properties, String propertyName) throws MMTFException {

		String property = properties.getProperty(propertyName);
		if (property == null) {
			throw new MMTFException("Missing property " + propertyName);
		}

		return property;
	}

	public static String getOptionalStringProperty(Properties properties, String propertyName, String defaultValue) {

		try {
			return getStringProperty(properties, propertyName);
		}
		catch (MMTFException e) {
			return defaultValue;
		}
	}

	public static boolean getBoolProperty(Properties properties, String propertyName) throws MMTFException {

		boolean property = Boolean.parseBoolean(getStringProperty(properties, propertyName));

		return property;
	}

	public static boolean getOptionalBoolProperty(Properties properties, String propertyName, boolean defaultValue) throws MMTFException {

		try {
			return getBoolProperty(properties, propertyName);
		}
		catch (MMTFException e) {
			return defaultValue;
		}
	}

	public static int getIntProperty(Properties properties, String propertyName) throws MMTFException {

		int property = Integer.parseInt(getStringProperty(properties, propertyName));
		if (property == -1) {
			property = Integer.MAX_VALUE;
		}

		return property;
	}

	public static int getOptionalIntProperty(Properties properties, String propertyName, int defaultValue) {

		try {
			return getIntProperty(properties, propertyName);
		}
		catch (MMTFException e) {
			return defaultValue;
		}
	}

	public static double getDoubleProperty(Properties properties, String propertyName) throws MMTFException {

		double property = Double.parseDouble(getStringProperty(properties, propertyName));
		if (property == -1) {
			property = Double.MAX_VALUE;
		}

		return property;
	}

	public static double getOptionalDoubleProperty(Properties properties, String propertyName, double defaultValue) {

		try {
			return getDoubleProperty(properties, propertyName);
		}
		catch (MMTFException e) {
			return defaultValue;
		}
	}

	public static String[] getStringProperties(Properties properties, String propertyName) throws MMTFException {

		return getStringProperty(properties, propertyName).split(PROPERTY_SEPARATOR);
	}

	public static String[] getOptionalStringProperties(Properties properties, String propertyName, String[] defaultValue) {

		try {
			return getStringProperties(properties, propertyName);
		}
		catch (MMTFException e) {
			return defaultValue;
		}
	}

	public static boolean isUpdatingMid(Properties properties) {

		try {
			return Boolean.parseBoolean(getStringProperty(properties, PROPERTY_IN_UPDATEMID));
		}
		catch (MMTFException e) {
			return true;
		}
	}

	public static String getSubdir(Properties properties) {

		try {
			return getStringProperty(properties, PROPERTY_IN_SUBDIR);
		}
		catch (MMTFException e) {
			return null;
		}
	}

}
