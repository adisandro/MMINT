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

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTConstants;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.mmint.operator.experiment.ExperimentRunner;
import edu.toronto.cs.se.modelepedia.classdiagram_mavo.ClassDiagram_MAVOFactory;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.operator.henshin.LiftingHenshinTransformation;
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

		this.featureModelName = MIDOperatorIOUtils.getStringProperty(inputProperties, ICSE14.PROPERTY_IN_FEATUREMODELNAME);
		Properties constraintProperties = new Properties();
		String constraintPropertiesFile = FileUtils.prependWorkspacePath(
			FileUtils.replaceLastSegmentInPath(
				this.inputModel.getUri(),
				ICSE14.FEATURE_MODELS_SUBDIR + MMINTConstants.URI_SEPARATOR + this.featureModelName + MIDOperatorIOUtils.PROPERTIES_SUFFIX
			)
		);
		try {
			constraintProperties.load(new FileInputStream(constraintPropertiesFile));
		}
		catch (Exception e) {
		}
		this.constraint = MIDOperatorIOUtils.getStringProperty(constraintProperties, LiftingHenshinTransformation.PROPERTY_IN_CONSTRAINT);
		this.constraintVariables = MIDOperatorIOUtils.getStringPropertyList(constraintProperties, LiftingHenshinTransformation.PROPERTY_IN_CONSTRAINTVARIABLES);
		var numRuleElements = MIDOperatorIOUtils.getStringProperty(inputProperties, ICSE14.PROPERTY_IN_NUMRULEELEMENTS).split(ICSE14.PROPERTY_IN_NUMRULEELEMENTS_SEPARATOR);
		this.numRuleElementsN = Integer.parseInt(numRuleElements[0]);
		this.numRuleElementsC = Integer.parseInt(numRuleElements[1]);
		this.numRuleElementsA = Integer.parseInt(numRuleElements[2]);
		this.modelSize = MIDOperatorIOUtils.getIntProperty(inputProperties, ICSE14.PROPERTY_IN_MODELSIZE);
		this.maxChains = MIDOperatorIOUtils.getIntProperty(inputProperties, ICSE14.PROPERTY_IN_MAXCHAINS);
		this.numIterations = MIDOperatorIOUtils.getIntProperty(inputProperties, ICSE14.PROPERTY_IN_NUMITERATIONS);
		this.nacMatchPerc = MIDOperatorIOUtils.getOptionalDoubleProperty(inputProperties, ICSE14.PROPERTY_IN_NACMATCHPERC, ICSE14.PROPERTY_IN_NACMATCHPERC_DEFAULT);
		this.alwaysPresentPerc = MIDOperatorIOUtils.getOptionalDoubleProperty(inputProperties, ICSE14.PROPERTY_IN_ALWAYSPRESENTPERC, ICSE14.PROPERTY_IN_ALWAYSPRESENTPERC_DEFAULT);
	}

	@Override
  protected void writeProperties(Properties properties) {

		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_TIMELIFTING, String.valueOf(this.timeLifting));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_SATCOUNTLIFTING, String.valueOf(this.satCountLifting));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_UNSATCOUNTLIFTING, String.valueOf(this.unsatCountLifting));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_SMTENCODINGLENGTH, String.valueOf(this.smtEncoding.length()));
		properties.setProperty(LiftingHenshinTransformation.PROPERTY_OUT_SMTENCODINGVARIABLES, String.valueOf(this.smtEncodingVariables.size()));
	}

	@Override
	protected void init() {

		super.init();

		// state
		this.modelObjsBucketA = new ArrayList<>();
		this.modelObjsChainsA = new ArrayList<>();
	}

	private void transformMatch() {

		this.modelSize += this.numRuleElementsA;
		for (var i = 0; i < this.numRuleElementsA; i++) {
			MAVOElement modelObjA = ClassDiagram_MAVOFactory.eINSTANCE.createClass();
			modelObjA.setFormulaVariable(LiftingHenshinTransformation.SMTLIB_APPLICABILITY_FUN_APPLY + (this.ruleApplicationsLifting+1) + Z3Utils.SMTLIB_PREDICATE_END);
			this.modelObjsBucketA.add(modelObjA);
			this.modelObjsChainsA.add(Integer.valueOf(this.maxChains));
		}
	}

	private boolean checkApplicabilityConditions(Z3IncrementalSolver z3IncSolver) {

		this.modelObjsNBar.clear();
		this.modelObjsC.clear();
		this.modelObjsD.clear();
		Set<MAVOElement> modelObjsN = new HashSet<>();
		this.modelObjsNBar.add(modelObjsN);
		double modelObjAMatchPerc = this.modelObjsChainsA.size() / this.modelSize;
		var nacMatched = (this.state.nextDouble() < this.nacMatchPerc);
		for (var i = 0; i < (this.numRuleElementsN+this.numRuleElementsC); i++) {
			MAVOElement modelObj = null;
			var modelObjAMatched = (this.state.nextDouble() < modelObjAMatchPerc);
			if (modelObjAMatched) { // previously (A)dded element matched
				var indexA = this.state.nextInt(this.modelObjsChainsA.size());
				int chains = this.modelObjsChainsA.get(indexA);
				if (chains > 0) { // still able to chain
					chains--;
					if (chains == 0) {
						modelObj = this.modelObjsBucketA.remove(indexA);
						this.modelObjsChainsA.remove(indexA);
					}
					else {
						modelObj = this.modelObjsBucketA.get(indexA);
						this.modelObjsChainsA.add(indexA, Integer.valueOf(chains));
					}
				}
			}
			else {
				modelObj = ClassDiagram_MAVOFactory.eINSTANCE.createClass();
				var formulaId = (this.state.nextDouble() < this.alwaysPresentPerc) ?
					Z3Utils.SMTLIB_TRUE :
					this.constraintVariables.get(this.state.nextInt(this.constraintVariables.size()));
				modelObj.setFormulaVariable(formulaId);
			}
			if (i < this.numRuleElementsC) { // (C)ontext element matched
				this.modelObjsC.add(modelObj);
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

		return checkZ3ApplicabilityFormula(z3IncSolver, this.smtEncoding.length());
	}

	private void doSimulatedLifting(Z3IncrementalSolver z3IncSolver) throws MMINTException {

		var startTime = System.nanoTime();
		while (this.ruleApplicationsLifting < this.numIterations) {
			checkApplicabilityConditions(z3IncSolver);
			this.modelObjsA.clear();
			transformMatch();
			this.ruleApplicationsLifting++;
		}

		this.timeLifting = System.nanoTime() - startTime;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		this.inputModel = inputsByName.get(ICSE14.IN_MODEL);
		this.init();
		super.initSMTEncoding(ProductLineHenshinTransformation.SMTLIB_APPLICABILITY_PREAMBLE, ProductLineHenshinTransformation.SMTLIB_APPLICABILITY_POSTAMBLE);

		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		z3IncSolver.firstCheckSatAndGetModel(this.smtEncoding.toString());
		doSimulatedLifting(z3IncSolver);

		// output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MIDOperatorIOUtils.writeOutputProperties(this, outputProperties);

		return new HashMap<>();
	}

	private static class DatLine implements Comparable<DatLine> {
		public static final Map<String, Integer> TIMELIFTING_NUMRULEELEMENTS_INDEXES = new HashMap<>();
		static {
			DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("1-2-1", Integer.valueOf(0));
			DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("7-2-7", Integer.valueOf(1));
			DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("3-2-3", Integer.valueOf(2));
			DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("30-9-24", Integer.valueOf(3));
			DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("1-12-1", Integer.valueOf(4));
			DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("6-19-6", Integer.valueOf(5));
			DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.put("16-21-16", Integer.valueOf(6));
		}
		public double smtEncodingVariables;
		public double[] timeLifting_numRuleElements;
		public DatLine() {
			this.timeLifting_numRuleElements = new double[DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.size()];
		}
		@Override
		public int compareTo(DatLine other) {
			if (this.smtEncodingVariables < other.smtEncodingVariables) {
				return -1;
			}
			else if (this.smtEncodingVariables > other.smtEncodingVariables) {
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
		String featureModelName = MIDOperatorIOUtils.getStringProperty(outputProperties, ICSE14.PROPERTY_IN_FEATUREMODELNAME);
		var smtEncodingVariables = MIDOperatorIOUtils.getDoubleProperty(outputProperties, LiftingHenshinTransformation.PROPERTY_OUT_SMTENCODINGVARIABLES+ExperimentRunner.PROP_OUT_AVG_SUFFIX);
		String numRuleElements = MIDOperatorIOUtils.getStringProperty(outputProperties, ICSE14.PROPERTY_IN_NUMRULEELEMENTS);
		var timeLifting = MIDOperatorIOUtils.getDoubleProperty(outputProperties, LiftingHenshinTransformation.PROPERTY_OUT_TIMELIFTING+ExperimentRunner.PROP_OUT_AVG_SUFFIX);
//		double timeLifting = MultiModelOperatorUtils.getDoubleProperty(outputProperties, PROPERTY_OUT_UNSATCOUNTLIFTING+ExperimentDriver.PROPERTY_OUT_RESULTAVG_SUFFIX);
		var datLine = ICSE14.datLinesMap.get(featureModelName);
		if (datLine == null) {
			datLine = new DatLine();
			ICSE14.datLinesMap.put(featureModelName, datLine);
		}
		datLine.smtEncodingVariables = smtEncodingVariables;
		datLine.timeLifting_numRuleElements[DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.get(numRuleElements)] = timeLifting;
	}

	private static void createGnuplotFile(Path outputDirectory, List<DatLine> datLines) {

		var outputFile = outputDirectory.resolve(ICSE14.GNUPLOT_OUTPUT_FILE);
		try (var writer = Files.newBufferedWriter(outputFile, Charset.forName("UTF-8"))) {
			var prevSmtEncodingVariables = datLines.get(0).smtEncodingVariables;
			var prevTotals = new double[DatLine.TIMELIFTING_NUMRULEELEMENTS_INDEXES.size()];
			for (var i = 0; i < prevTotals.length; i++) {
				prevTotals[i] = 0;
			}
			var prevCount = 0;
			for (DatLine datLine : datLines) {
				if (prevSmtEncodingVariables == datLine.smtEncodingVariables) {
					for (var i = 0; i < prevTotals.length; i++) {
						prevTotals[i] += datLine.timeLifting_numRuleElements[i];
					}
					prevCount++;
				}
				else {
					writer.write(Double.toString(prevSmtEncodingVariables));
					writer.write(" ");
					for (var i = 0; i < prevTotals.length; i++) {
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
			for (var i = 0; i < prevTotals.length; i++) {
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

		var inputPath = args[0];
		var path = Paths.get(inputPath);
		if (!Files.isDirectory(path)) {
			return;
		}
		ICSE14.datLinesMap = new HashMap<>();
		FileVisitor<Path> visitor = new SimpleFileVisitor<>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
				if (!file.getFileName().toString().equals(ICSE14.EXPERIMENT_OUTPUT_FILE)) {
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
			List<DatLine> datLines = new ArrayList<>(ICSE14.datLinesMap.values());
			Collections.sort(datLines);
			createGnuplotFile(path, datLines);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
