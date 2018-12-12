/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;

public class MIDOperatorIOUtils {

	public static final String INPUT_PROPERTIES_SUFFIX = "In";
	public static final String OUTPUT_PROPERTIES_SUFFIX = "Out";
	public static final String PROPERTIES_SUFFIX = ".properties";
	/** The separator for multiple properties with the same key. */
	private static final String PROPERTY_SEPARATOR = ",";
	public static final String PROPERTY_IN_UPDATEMID = "updateMID";
	public static final String PROPERTY_IN_SUBDIR = "subdir";
	public static final String PROPERTY_IN_OUTPUTENABLED_SUFFIX = ".enabled";

//	public void writeOutputPropertiesFile(Properties properties) throws Exception {
//
//		String propertiesUri =  getPropertiesUri(MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX);
//		properties.store(new FileOutputStream(propertiesUri), null);
//	}

	private static String getPropertiesUri(Operator operator, Model anyOperatorParameter, String subdirName, boolean readonly) {

		String projectUri = anyOperatorParameter.getUri().substring(0, anyOperatorParameter.getUri().lastIndexOf(IPath.SEPARATOR)+1);
		String propertiesUri = FileUtils.prependWorkspacePath(projectUri);
		if (subdirName != null) {
			File dir = new File(propertiesUri + subdirName);
			if (!readonly && !dir.exists()) {
				dir.mkdir();
			}
			propertiesUri += subdirName + IPath.SEPARATOR;
		}
		propertiesUri += operator.getName();

		return propertiesUri;
	}

	public static Properties getPropertiesFile(Operator operator, Model anyOperatorParameter, String subdirName, String suffix) throws Exception {

		String inputPropertiesFile =
			getPropertiesUri(operator, anyOperatorParameter, subdirName, true) +
			suffix +
			PROPERTIES_SUFFIX;
		Properties inputProperties = new Properties();
		inputProperties.load(new FileInputStream(inputPropertiesFile));

		return inputProperties;
	}

	public static void writePropertiesFile(Properties outputProperties, Operator operator, Model anyOperatorParameter, String subdirName, String suffix) throws Exception {

		String outputPropertiesFile =
			getPropertiesUri(operator, anyOperatorParameter, subdirName, false) +
			suffix +
			PROPERTIES_SUFFIX;
		outputProperties.store(new FileOutputStream(outputPropertiesFile), null);
	}

	//TODO MMINT[OPERATOR] Remove
	@Deprecated
	public static void writeTextFile(Operator operator, Model anyOperatorParameter, String subdirName, String suffix, StringBuilder fileContent) throws IOException {

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

	public static @NonNull String getStringProperty(@NonNull Properties properties, @NonNull String propertyName) throws MMINTException {

		String property = properties.getProperty(propertyName);
		if (property == null) {
			throw new MMINTException("Missing property " + propertyName);
		}

		return property;
	}

	public static @Nullable String getOptionalStringProperty(@NonNull Properties properties, @NonNull String propertyName, @Nullable String defaultValue) {

		try {
			return getStringProperty(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static @NonNull <E extends Enum<E>> E getEnumProperty(@NonNull Properties properties, @NonNull String propertyName, @NonNull Class<E> enumClass) throws MMINTException {

		E property = Enum.valueOf(enumClass, getStringProperty(properties, propertyName));

		return property;
	}

	public static @NonNull <E extends Enum<E>> E getOptionalEnumProperty(@NonNull Properties properties, @NonNull String propertyName, @NonNull E defaultValue, @NonNull Class<E> enumClass) {

		try {
			return getEnumProperty(properties, propertyName, enumClass);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static boolean getBoolProperty(@NonNull Properties properties, @NonNull String propertyName) throws MMINTException {

		boolean property = Boolean.parseBoolean(getStringProperty(properties, propertyName));

		return property;
	}

	//TODO MMINT[OPERATOR] Make version to read x.enabled with default to false
	public static @Nullable Boolean getOptionalBoolProperty(@NonNull Properties properties, @NonNull String propertyName, @Nullable Boolean defaultValue) {

		try {
			return getBoolProperty(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static int getIntProperty(@NonNull Properties properties, @NonNull String propertyName) throws MMINTException {

		int property = Integer.parseInt(getStringProperty(properties, propertyName));
		if (property == -1) {
			property = Integer.MAX_VALUE;
		}

		return property;
	}

	public static int getOptionalIntProperty(@NonNull Properties properties, @NonNull String propertyName, int defaultValue) {

		try {
			return getIntProperty(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static double getDoubleProperty(@NonNull Properties properties, @NonNull String propertyName) throws MMINTException {

		double property = Double.parseDouble(getStringProperty(properties, propertyName));
		if (property == -1) {
			property = Double.MAX_VALUE;
		}

		return property;
	}

	public static double getOptionalDoubleProperty(@NonNull Properties properties, @NonNull String propertyName, double defaultValue) {

		try {
			return getDoubleProperty(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static @NonNull List<String> getStringPropertyList(@NonNull Properties properties, @NonNull String propertyName) throws MMINTException {

		return List.of(getStringProperty(properties, propertyName).split(PROPERTY_SEPARATOR));
	}

	public static @NonNull Set<String> getStringPropertySet(@NonNull Properties properties, @NonNull String propertyName) throws MMINTException {

	    return Set.of(getStringProperty(properties, propertyName).split(PROPERTY_SEPARATOR));
	}

	public static @NonNull List<String> getOptionalStringPropertyList(@NonNull Properties properties, @NonNull String propertyName, @NonNull List<String> defaultValue) {

		try {
			return getStringPropertyList(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static @NonNull Set<String> getOptionalStringPropertySet(@NonNull Properties properties, @NonNull String propertyName, @NonNull Set<String> defaultValue) {

		try {
			return getStringPropertySet(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static @NonNull <T> List<T> getVarargs(@NonNull Map<String, T> varargsByName, @NonNull String varargName) {

		List<T> varargs = new ArrayList<>();
		int i = 0;
		T elem;
		while ((elem = varargsByName.get(varargName + i)) != null) {
			varargs.add(elem);
			i++;
		}

		return varargs;
	}

	public static @NonNull Map<String, Model> setVarargs(@NonNull List<Model> models, @NonNull String varargName) {

		Map<String, Model> modelsByName = new HashMap<>();
		for (int i = 0; i < models.size(); i++) {
			modelsByName.put(varargName + i, models.get(i));
		}

		return modelsByName;
	}

	public static @NonNull Map<String, MID> getVarargOutputMIDsByOtherName(@NonNull Map<String, MID> outputMIDsByName, @NonNull String varargName, @NonNull List<? extends ExtendibleElement> nameElements) {

		Map<String, MID> outputMIDsByOtherName = new HashMap<>();
		if (outputMIDsByName.containsKey(varargName)) {
			MID outputMID = outputMIDsByName.get(varargName);
			outputMIDsByOtherName = nameElements.stream()
				.collect(Collectors.<ExtendibleElement, String, MID>toMap( // TODO MMINT[SCRIPTING] Fix explicit types when java9 is out
					nameElement -> nameElement.getName(),
					nameElement -> outputMID));
		}
		else {
			List<MID> instanceMIDs = MIDOperatorIOUtils.getVarargs(outputMIDsByName, varargName);
			for (int i = 0; i < nameElements.size(); i++) {
				outputMIDsByOtherName.put(nameElements.get(i).getName(), instanceMIDs.get(i));
			}
		}

		return outputMIDsByOtherName;
	}

	public static @NonNull Map<String, MID> createSameOutputMIDsByName(@NonNull Operator operatorType, @Nullable MID outputMID) {

		Map<String, MID> outputMIDsByName = new HashMap<>();
		for (ModelEndpoint outputModelTypeEndpoint : operatorType.getOutputs()) {
			outputMIDsByName.put(outputModelTypeEndpoint.getName(), outputMID);
		}

		return outputMIDsByName;
	}

	public static @NonNull Map<String, MID> mixOutputMIDsByName(@NonNull Operator operatorType, @Nullable MID defaultOutputMID, @NonNull Map<String, MID> assignedOutputMIDsByName) {

		Map<String, MID> outputMIDsByName = new HashMap<>();
		for (ModelEndpoint outputModelTypeEndpoint : operatorType.getOutputs()) {
			MID outputMID = assignedOutputMIDsByName.getOrDefault(outputModelTypeEndpoint.getName(), defaultOutputMID);
			outputMIDsByName.put(outputModelTypeEndpoint.getName(), outputMID);
		}

		return outputMIDsByName;
	}

}
