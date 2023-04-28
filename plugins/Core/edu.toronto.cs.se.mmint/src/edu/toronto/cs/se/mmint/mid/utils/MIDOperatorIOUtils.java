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

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

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

	public static void writeOutputProperties(Operator operator, Properties outProps) throws Exception {
	  var path = operator.getWorkingPath() + File.separator + operator.getName() +
	             MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX + MIDOperatorIOUtils.PROPERTIES_SUFFIX;
	  path = FileUtils.getUniquePath(path, true, false);
	  outProps.store(new FileOutputStream(FileUtils.prependWorkspacePath(path)), null);
	}

	public static String getStringProperty(Properties properties, String propertyName) throws MMINTException {

		var property = properties.getProperty(propertyName);
		if (property == null) {
			throw new MMINTException("Missing property " + propertyName);
		}

		return property;
	}

	public static @Nullable String getOptionalStringProperty(Properties properties, String propertyName, @Nullable String defaultValue) {

		try {
			return getStringProperty(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static <E extends Enum<E>> E getEnumProperty(Properties properties, String propertyName, Class<E> enumClass) throws MMINTException {

		var property = Enum.valueOf(enumClass, getStringProperty(properties, propertyName));

		return property;
	}

	public static <E extends Enum<E>> E getOptionalEnumProperty(Properties properties, String propertyName, E defaultValue, Class<E> enumClass) {

		try {
			return getEnumProperty(properties, propertyName, enumClass);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static boolean getBoolProperty(Properties properties, String propertyName) throws MMINTException {

		var property = Boolean.parseBoolean(getStringProperty(properties, propertyName));

		return property;
	}

	//TODO MMINT[OPERATOR] Make version to read x.enabled with default to false
	public static @Nullable Boolean getOptionalBoolProperty(Properties properties, String propertyName, @Nullable Boolean defaultValue) {

		try {
			return getBoolProperty(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static int getIntProperty(Properties properties, String propertyName) throws MMINTException {

		var property = Integer.parseInt(getStringProperty(properties, propertyName));
		if (property == -1) {
			property = Integer.MAX_VALUE;
		}

		return property;
	}

	public static int getOptionalIntProperty(Properties properties, String propertyName, int defaultValue) {

		try {
			return getIntProperty(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static double getDoubleProperty(Properties properties, String propertyName) throws MMINTException {

		var property = Double.parseDouble(getStringProperty(properties, propertyName));
		if (property == -1) {
			property = Double.MAX_VALUE;
		}

		return property;
	}

	public static double getOptionalDoubleProperty(Properties properties, String propertyName, double defaultValue) {

		try {
			return getDoubleProperty(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static List<String> getStringPropertyList(Properties properties, String propertyName) throws MMINTException {

		return List.of(getStringProperty(properties, propertyName).split(MIDOperatorIOUtils.PROPERTY_SEPARATOR));
	}

	public static Set<String> getStringPropertySet(Properties properties, String propertyName) throws MMINTException {

	    return Set.of(getStringProperty(properties, propertyName).split(MIDOperatorIOUtils.PROPERTY_SEPARATOR));
	}

	public static List<String> getOptionalStringPropertyList(Properties properties, String propertyName, List<String> defaultValue) {

		try {
			return getStringPropertyList(properties, propertyName);
		}
		catch (MMINTException e) {
			return defaultValue;
		}
	}

	public static Set<String> getOptionalStringPropertySet(Properties properties, String propertyName, Set<String> defaultValue) {

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

	public static Map<String, MID> createSameOutputMIDsByName(Operator operatorType, @Nullable MID outputMID) {

		Map<String, MID> outputMIDsByName = new HashMap<>();
		for (ModelEndpoint outputModelTypeEndpoint : operatorType.getOutputs()) {
			outputMIDsByName.put(outputModelTypeEndpoint.getName(), outputMID);
		}

		return outputMIDsByName;
	}

	public static Map<String, MID> mixOutputMIDsByName(Operator operatorType, @Nullable MID defaultOutputMID, Map<String, MID> assignedOutputMIDsByName) {

		Map<String, MID> outputMIDsByName = new HashMap<>();
		for (ModelEndpoint outputModelTypeEndpoint : operatorType.getOutputs()) {
			var outputMID = assignedOutputMIDsByName.getOrDefault(outputModelTypeEndpoint.getName(), defaultOutputMID);
			outputMIDsByName.put(outputModelTypeEndpoint.getName(), outputMID);
		}

		return outputMIDsByName;
	}

}
