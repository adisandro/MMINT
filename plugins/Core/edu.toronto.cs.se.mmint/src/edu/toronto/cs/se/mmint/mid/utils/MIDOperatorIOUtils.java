/**
 * Copyright (c) 2012-2023 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.nio.file.Path;
import java.text.MessageFormat;
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
	public static final String PROP_OUTENABLED_SUFFIX = ".enabled";

//	public void writeOutputPropertiesFile(Properties properties) throws Exception {
//
//		String propertiesUri =  getPropertiesUri(MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX);
//		properties.store(new FileOutputStream(propertiesUri), null);
//	}

	private static String getPropertiesUri(Operator operator, Model anyOperatorParameter, String subdirName, boolean readonly) {

		var projectUri = anyOperatorParameter.getUri().substring(0, anyOperatorParameter.getUri().lastIndexOf(IPath.SEPARATOR)+1);
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

		var inputPropertiesFile =
			getPropertiesUri(operator, anyOperatorParameter, subdirName, true) +
			suffix +
			MIDOperatorIOUtils.PROPERTIES_SUFFIX;
		Properties inputProperties = new Properties();
		inputProperties.load(new FileInputStream(inputPropertiesFile));

		return inputProperties;
	}

	public static void writePropertiesFile(Properties outputProperties, Operator operator, Model anyOperatorParameter, String subdirName, String suffix) throws Exception {

		var outputPropertiesFile =
			getPropertiesUri(operator, anyOperatorParameter, subdirName, false) +
			suffix +
			MIDOperatorIOUtils.PROPERTIES_SUFFIX;
		outputProperties.store(new FileOutputStream(outputPropertiesFile), null);
	}

	public static void writeOutputProperties(Operator operator, Properties outProps) throws Exception {
	  var outPropsPath = Path.of(operator.getWorkingPath(),
	                             MessageFormat.format("{0}{1}{2}", operator.getName(), MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX,
	                                                  MIDOperatorIOUtils.PROPERTIES_SUFFIX));
	  outProps.store(new FileOutputStream(FileUtils.prependWorkspacePath(outPropsPath.toString())), null);
	}

	//TODO MMINT[OPERATOR] Remove
	@Deprecated
	public static void writeTextFile(Operator operator, Model anyOperatorParameter, String subdirName, String suffix, StringBuilder fileContent) throws IOException {

		var outputTextFile = getPropertiesUri(operator, anyOperatorParameter, subdirName, false) + suffix;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputTextFile))) {
			writer.append(fileContent);
		}
		catch (IOException e) {
			throw e;
		}
	}

	public static @NonNull String getStringProperty(@NonNull Properties properties, @NonNull String propertyName) throws MMINTException {

		var property = properties.getProperty(propertyName);
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

		var property = Enum.valueOf(enumClass, getStringProperty(properties, propertyName));

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

		var property = Boolean.parseBoolean(getStringProperty(properties, propertyName));

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

		var property = Integer.parseInt(getStringProperty(properties, propertyName));
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

		var property = Double.parseDouble(getStringProperty(properties, propertyName));
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

		return List.of(getStringProperty(properties, propertyName).split(MIDOperatorIOUtils.PROPERTY_SEPARATOR));
	}

	public static @NonNull Set<String> getStringPropertySet(@NonNull Properties properties, @NonNull String propertyName) throws MMINTException {

	    return Set.of(getStringProperty(properties, propertyName).split(MIDOperatorIOUtils.PROPERTY_SEPARATOR));
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

	public static <T> List<T> getVarargs(Map<String, T> varargsByName, String varargName) {
		var varargs = new ArrayList<T>();
		var i = 0;
		T elem;
		while ((elem = varargsByName.get(varargName + i)) != null) {
			varargs.add(elem);
			i++;
		}

		return varargs;
	}

	public static Map<String, Model> setVarargs(List<Model> models, String varargName) {
		var modelsByName = new HashMap<String, Model>();
		for (var i = 0; i < models.size(); i++) {
			modelsByName.put(varargName + i, models.get(i));
		}

		return modelsByName;
	}

	public static Map<String, MID> getVarargOutputMIDsByOtherName(Map<String, MID> outputMIDsByName, String varargName,
	                                                              List<? extends ExtendibleElement> nameElements) {
		Map<String, MID> outputMIDsByOtherName = new HashMap<>();
		if (outputMIDsByName.containsKey(varargName)) {
			var outputMID = outputMIDsByName.get(varargName);
			outputMIDsByOtherName = nameElements.stream()
				.collect(Collectors.toMap(
					nameElement -> nameElement.getName(),
					nameElement -> outputMID));
		}
		else {
			List<MID> instanceMIDs = MIDOperatorIOUtils.getVarargs(outputMIDsByName, varargName);
			for (var i = 0; i < nameElements.size(); i++) {
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
			var outputMID = assignedOutputMIDsByName.getOrDefault(outputModelTypeEndpoint.getName(), defaultOutputMID);
			outputMIDsByName.put(outputModelTypeEndpoint.getName(), outputMID);
		}

		return outputMIDsByName;
	}

}
