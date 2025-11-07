/**
 * Copyright (c) 2012-2025 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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
import java.util.Optional;
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
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;

public class MIDOperatorIOUtils {

	public static final String IN_PROPS_SUFFIX = "In";
	public static final String OUT_PROPS_SUFFIX = "Out";
	public static final String PROPS_SUFFIX = ".properties";
	/** The separator for multiple properties with the same key. */
	private static final String PROP_SEP = ",";
	public static final String PROP_OUTENABLED_SUFFIX = ".enabled";

	public static void writeOutputProperties(Operator operator, Properties outProps) throws Exception {
	  var path = operator.getWorkingPath() + File.separator + operator.getName() +
	             MIDOperatorIOUtils.OUT_PROPS_SUFFIX + MIDOperatorIOUtils.PROPS_SUFFIX;
	  path = FileUtils.getUniquePath(path, true, false);
	  outProps.store(new FileOutputStream(FileUtils.prependWorkspacePath(path)), null);
	}

  public static Optional<String> getOptStringProp(Properties props, String propName) {
    return Optional.ofNullable(props.getProperty(propName));
  }

  public static String getStringProp(Properties props, String propName, Optional<String> defaultValue)
                                    throws MMINTException {
    return getOptStringProp(props, propName).orElse(
      defaultValue.orElse(
        MIDDialogs.getStringInput("Insert " + propName, "Insert property " + propName, null)));
  }

  public static <E extends Enum<E>> Optional<E> getOptEnumProp(Properties props, String propName, Class<E> enumClass) {
    return getOptStringProp(props, propName).map(p -> Enum.valueOf(enumClass, p));
  }

	public static <E extends Enum<E>> E getEnumProp(Properties props, String propName, Optional<E> defaultValue,
	                                                Class<E> enumClass) throws MMINTException {
	  return Enum.valueOf(enumClass, getStringProp(props, propName, defaultValue.map(String::valueOf)));
	}

  //TODO MMINT[OPERATOR] Make version to read x.enabled with default to false
  public static Optional<Boolean> getOptBoolProp(Properties props, String propName) {
    return getOptStringProp(props, propName).map(Boolean::parseBoolean);
  }

	public static boolean getBoolProp(Properties props, String propName, Optional<Boolean> defaultValue)
	                                 throws MMINTException {
		return Boolean.parseBoolean(getStringProp(props, propName, defaultValue.map(String::valueOf)));
	}

  public static Optional<Integer> getOptIntProp(Properties props, String propName) {
    return getOptStringProp(props, propName).map(Integer::parseInt);
  }

	public static int getIntProp(Properties props, String propName, Optional<Integer> defaultValue)
	                            throws MMINTException {
    return Integer.parseInt(getStringProp(props, propName, defaultValue.map(String::valueOf)));
	}

  public static Optional<Double> getOptDoubleProp(Properties props, String propName) {
    return getOptStringProp(props, propName).map(Double::parseDouble);
  }

	public static double getDoubleProp(Properties props, String propName, Optional<Double> defaultValue)
	                                  throws MMINTException {
	  return Double.parseDouble(getStringProp(props, propName, defaultValue.map(String::valueOf)));
	}

  public static Optional<List<String>> getOptStringPropList(Properties props, String propName) {
    return getOptStringProp(props, propName).map(p -> List.of(p.split(MIDOperatorIOUtils.PROP_SEP)));
  }

	public static List<String> getStringPropList(Properties props, String propName, Optional<List<String>> defaultValue)
	                                            throws MMINTException {
    return List.of(
      getStringProp(props, propName, defaultValue.map(l -> String.join(MIDOperatorIOUtils.PROP_SEP, l)))
        .split(MIDOperatorIOUtils.PROP_SEP));
	}

  public static Optional<Set<String>> getOptStringPropSet(Properties props, String propName) {
    return getOptStringProp(props, propName).map(p -> Set.of(p.split(MIDOperatorIOUtils.PROP_SEP)));
  }

	public static Set<String> getStringPropSet(Properties props, String propName, Optional<Set<String>> defaultValue)
	                                          throws MMINTException {
    return Set.of(
      getStringProp(props, propName, defaultValue.map(s -> String.join(MIDOperatorIOUtils.PROP_SEP, s)))
        .split(MIDOperatorIOUtils.PROP_SEP));
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
					ExtendibleElement::getName,
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
