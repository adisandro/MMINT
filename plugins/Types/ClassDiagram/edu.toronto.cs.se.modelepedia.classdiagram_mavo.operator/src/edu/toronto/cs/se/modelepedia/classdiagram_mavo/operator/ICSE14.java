/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.classdiagram_mavo.operator;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.operator.experiment.ExperimentRunner;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOFactory;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.operator.henshin.ProductLineHenshinTransformation;

public class ICSE14 extends ProductLineHenshinTransformation {

	// input-output
	private final static @NonNull String IN_MODEL = "cd";
	private static final String PROPERTY_IN_FEATUREMODELNAME = "featureModelName";
	private static final String PROPERTY_IN_NUMRULEELEMENTS = "numRuleElements";
	private static final String PROPERTY_IN_NUMRULEELEMENTS_SEPARATOR = "-";
	private static final String PROPERTY_IN_MODELSIZE = "modelSize";
	private static final String PROPERTY_IN_MAXCHAINS = "maxChains";
	private static final String PROPERTY_IN_NUMITERATIONS = "numIterations";
	private static final String PROPERTY_IN_NACMATCHPERC = "nacMatchPerc";
	private static final double PROPERTY_IN_NACMATCHPERC_DEFAULT = 0.5;
	private static final String PROPERTY_IN_ALWAYSPRESENTPERC = "alwaysPresentPerc";
	private static final double PROPERTY_IN_ALWAYSPRESENTPERC_DEFAULT = 0.5;
	// constants
	private static final String FEATURE_MODELS_SUBDIR = "featuremodels";

	private String featureModelName;
	private int numRuleElementsN;
	private int numRuleElementsC;
	private int numRuleElementsA;
	private int modelSize;
	private int maxChains;
	private int numIterations;
	private double nacMatchPerc;
	private double alwaysPresentPerc;

	private Model inputModel;
	private List<MAVOElement> modelObjsBucketA;
	private List<Integer> modelObjsChainsA;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		featureModelName = MIDOperatorIOUtils.getStringProperty(inputProperties, PROPERTY_IN_FEATUREMODELNAME);
		Properties constraintProperties = new Properties();
		String constraintPropertiesFile = FileUtils.prependWorkspacePath(
			FileUtils.replaceLastSegmentInPath(
				inputModel.getUri(),
				FEATURE_MODELS_SUBDIR + MMINT.URI_SEPARATOR + featureModelName + MIDOperatorIOUtils.PROPERTIES_SUFFIX
			)
		);
		try {
			constraintProperties.load(new FileInputStream(constraintPropertiesFile));
		}
		catch (Exception e) {
		}
		constraint = MIDOperatorIOUtils.getStringProperty(constraintProperties, PROPERTY_IN_CONSTRAINT);
		constraintVariables = MIDOperatorIOUtils.getStringPropertyList(constraintProperties, PROPERTY_IN_CONSTRAINTVARIABLES);
		String[] numRuleElements = MIDOperatorIOUtils.getStringProperty(inputProperties, PROPERTY_IN_NUMRULEELEMENTS).split(PROPERTY_IN_NUMRULEELEMENTS_SEPARATOR);
		numRuleElementsN = Integer.parseInt(numRuleElements[0]);
		numRuleElementsC = Integer.parseInt(numRuleElements[1]);
		numRuleElementsA = Integer.parseInt(numRuleElements[2]);
		modelSize = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MODELSIZE);
		maxChains = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_MAXCHAINS);
		numIterations = MIDOperatorIOUtils.getIntProperty(inputProperties, PROPERTY_IN_NUMITERATIONS);
		nacMatchPerc = MIDOperatorIOUtils.getOptionalDoubleProperty(inputProperties, PROPERTY_IN_NACMATCHPERC, PROPERTY_IN_NACMATCHPERC_DEFAULT);
		alwaysPresentPerc = MIDOperatorIOUtils.getOptionalDoubleProperty(inputProperties, PROPERTY_IN_ALWAYSPRESENTPERC, PROPERTY_IN_ALWAYSPRESENTPERC_DEFAULT);
	}

	protected void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMELIFTING, String.valueOf(timeLifting));
		properties.setProperty(PROPERTY_OUT_SATCOUNTLIFTING, String.valueOf(satCountLifting));
		properties.setProperty(PROPERTY_OUT_UNSATCOUNTLIFTING, String.valueOf(unsatCountLifting));
		properties.setProperty(PROPERTY_OUT_SMTENCODINGLENGTH, String.valueOf(smtEncoding.length()));
		properties.setProperty(PROPERTY_OUT_SMTENCODINGVARIABLES, String.valueOf(smtEncodingVariables.size()));
	}

	@Override
	protected void init() {

		super.init();

		// state
		modelObjsBucketA = new ArrayList<>();
		modelObjsChainsA = new ArrayList<>();
	}

	private void transformMatch() {

		modelSize += numRuleElementsA;
		for (int i = 0; i < numRuleElementsA; i++) {
			MAVOElement modelObjA = ClassDiagram_MAVOFactory.eINSTANCE.createClass();
			modelObjA.setFormulaVariable(SMTLIB_APPLICABILITY_FUN_APPLY + (ruleApplicationsLifting+1) + Z3Utils.SMTLIB_PREDICATE_END);
			modelObjsBucketA.add(modelObjA);
			modelObjsChainsA.add(Integer.valueOf(maxChains));
		}
	}

	private boolean checkApplicabilityConditions(Z3IncrementalSolver z3IncSolver) {

		modelObjsNBar.clear();
		modelObjsC.clear();
		modelObjsD.clear();
		Set<MAVOElement> modelObjsN = new HashSet<MAVOElement>();
		modelObjsNBar.add(modelObjsN);
		double modelObjAMatchPerc = modelObjsChainsA.size() / modelSize;
		boolean nacMatched = (state.nextDouble() < nacMatchPerc);
		for (int i = 0; i < (numRuleElementsN+numRuleElementsC); i++) {
			MAVOElement modelObj = null;
			boolean modelObjAMatched = (state.nextDouble() < modelObjAMatchPerc);
			if (modelObjAMatched) { // previously (A)dded element matched
				int indexA = state.nextInt(modelObjsChainsA.size());
				int chains = modelObjsChainsA.get(indexA);
				if (chains > 0) { // still able to chain
					chains--;
					if (chains == 0) {
						modelObj = modelObjsBucketA.remove(indexA);
						modelObjsChainsA.remove(indexA);
					}
					else {
						modelObj = modelObjsBucketA.get(indexA);
						modelObjsChainsA.add(indexA, Integer.valueOf(chains));
					}
				}
			}
			else {
				modelObj = ClassDiagram_MAVOFactory.eINSTANCE.createClass();
				String formulaId = (state.nextDouble() < alwaysPresentPerc) ?
					Z3Utils.SMTLIB_TRUE :
					constraintVariables.get(state.nextInt(constraintVariables.size()));
				modelObj.setFormulaVariable(formulaId);
			}
			if (i < numRuleElementsC) { // (C)ontext element matched
				modelObjsC.add(modelObj);
			}
			else {
				if (nacMatched) { // (N)ac element matched
					modelObjsN.add(modelObj);
				}
				else {
					break;
				}
			}
		}

		return checkZ3ApplicabilityFormula(z3IncSolver, smtEncoding.length());
	}

	private void doSimulatedLifting(Z3IncrementalSolver z3IncSolver) throws MMINTException {

		long startTime = System.nanoTime();
		while (ruleApplicationsLifting < numIterations) {
			checkApplicabilityConditions(z3IncSolver);
			modelObjsA.clear();
			transformMatch();
			ruleApplicationsLifting++;
		}

		timeLifting = System.nanoTime() - startTime;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		inputModel = inputsByName.get(IN_MODEL);
		this.init();
		super.initSMTEncoding(SMTLIB_APPLICABILITY_PREAMBLE, SMTLIB_APPLICABILITY_POSTAMBLE);

		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		z3IncSolver.firstCheckSatAndGetModel(smtEncoding.toString());
		doSimulatedLifting(z3IncSolver);

		// output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MIDOperatorIOUtils.writePropertiesFile(
			outputProperties,
			this,
			inputModel,
			null,
			MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return new HashMap<>();
	}

	private static class DatLine implements Comparable<DatLine> {
		public static final Map<String, Integer> TIMELIFTING_NUMRULEELEMENTS_INDEXES = new HashMap<String, Integer>();
		static {
			TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("1-2-1", Integer.valueOf(0));
			TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("7-2-7", Integer.valueOf(1));
			TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("3-2-3", Integer.valueOf(2));
			TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("30-9-24", Integer.valueOf(3));
			TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("1-12-1", Integer.valueOf(4));
			TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("6-19-6", Integer.valueOf(5));
			TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("16-21-16", Integer.valueOf(6));
		}
		public double smtEncodingVariables;
		public double[] timeLifting_numRuleElements;
		public DatLine() {
			this.timeLifting_numRuleElements = new double[TIMELIFTING_NUMRULEELEMENTS_INDEXES.size()];
		}
		@Override
		public int compareTo(DatLine other) {
			if (smtEncodingVariables < other.smtEncodingVariables) {
				return -1;
			}
			else if (smtEncodingVariables > other.smtEncodingVariables) {
				return 1;
			}
			return 0;
		}
	}

	private static final String EXPERIMENT_OUTPUT_FILE = "ExperimentDriverOut.properties";
	private static final String GNUPLOT_OUTPUT_FILE = "gnuplot.dat";

	private static Map<String, DatLine> datLinesMap;

	private static void getOutput(Path outputPath) throws Exception {
		Properties outputProperties = new Properties();
		outputProperties.load(new FileInputStream(outputPath.toString()));
		String featureModelName = MIDOperatorIOUtils.getStringProperty(outputProperties, PROPERTY_IN_FEATUREMODELNAME);
		double smtEncodingVariables = MIDOperatorIOUtils.getDoubleProperty(outputProperties, PROPERTY_OUT_SMTENCODINGVARIABLES+ExperimentRunner.PROP_OUT_AVG_SUFFIX);
		String numRuleElements = MIDOperatorIOUtils.getStringProperty(outputProperties, PROPERTY_IN_NUMRULEELEMENTS);
		double timeLifting = MIDOperatorIOUtils.getDoubleProperty(outputProperties, PROPERTY_OUT_TIMELIFTING+ExperimentRunner.PROP_OUT_AVG_SUFFIX);
//		double timeLifting = MultiModelOperatorUtils.getDoubleProperty(outputProperties, PROPERTY_OUT_UNSATCOUNTLIFTING+ExperimentDriver.PROPERTY_OUT_RESULTAVG_SUFFIX);
		DatLine datLine = datLinesMap.get(featureModelName);
		if (datLine == null) {
			datLine = new DatLine();
			datLinesMap.put(featureModelName, datLine);
		}
		datLine.smtEncodingVariables = smtEncodingVariables;
		datLine.timeLifting_numRuleElements[DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.get(numRuleElements)] = timeLifting;
	}

	private static void createGnuplotFile(Path outputDirectory, List<DatLine> datLines) {

		Path outputFile = outputDirectory.resolve(GNUPLOT_OUTPUT_FILE);
		try (BufferedWriter writer = Files.newBufferedWriter(outputFile, Charset.forName("UTF-8"))) {
			double prevSmtEncodingVariables = datLines.get(0).smtEncodingVariables;
			double[] prevTotals = new double[DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.size()];
			for (int i = 0; i < prevTotals.length; i++) {
				prevTotals[i] = 0;
			}
			int prevCount = 0;
			for (DatLine datLine : datLines) {
				if (prevSmtEncodingVariables == datLine.smtEncodingVariables) {
					for (int i = 0; i < prevTotals.length; i++) {
						prevTotals[i] += datLine.timeLifting_numRuleElements[i];
					}
					prevCount++;
				}
				else {
					writer.write(Double.toString(prevSmtEncodingVariables));
					writer.write(" ");
					for (int i = 0; i < prevTotals.length; i++) {
						writer.write(Double.toString(prevTotals[i]/prevCount/1000000000));
//						writer.write(Double.toString(prevTotals[i]/prevCount));
						writer.write(" ");
						prevTotals[i] = datLine.timeLifting_numRuleElements[i];
					}
					writer.newLine();
					prevSmtEncodingVariables = datLine.smtEncodingVariables;
					prevCount = 1;
				}
			}
			writer.write(Double.toString(prevSmtEncodingVariables));
			writer.write(" ");
			for (int i = 0; i < prevTotals.length; i++) {
				writer.write(Double.toString(prevTotals[i]/prevCount/1000000000));
//				writer.write(Double.toString(prevTotals[i]/prevCount));
				writer.write(" ");
			}
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		String inputPath = args[0];
		Path path = Paths.get(inputPath);
		if (!Files.isDirectory(path)) {
			return;
		}
		datLinesMap = new HashMap<String, DatLine>();
		FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
				if (!file.getFileName().toString().equals(EXPERIMENT_OUTPUT_FILE)) {
					return FileVisitResult.CONTINUE;
				}
				try {
					getOutput(file);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				return FileVisitResult.CONTINUE;
			}
		};
		try {
			Files.walkFileTree(path, visitor);
			List<DatLine> datLines = new ArrayList<DatLine>(datLinesMap.values());
			Collections.sort(datLines);
			createGnuplotFile(path, datLines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
