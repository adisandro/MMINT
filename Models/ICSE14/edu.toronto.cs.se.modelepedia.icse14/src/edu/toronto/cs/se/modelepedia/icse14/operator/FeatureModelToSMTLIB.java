/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.icse14.operator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import edu.toronto.cs.se.mmtf.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmtf.mid.library.MultiModelUtils;
import edu.toronto.cs.se.modelepedia.operator.patch.LiftingHenshinTransformation;
import edu.toronto.cs.se.modelepedia.operator.reasoning.Z3SMTSolver;
import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.CNFLiteral;
import splar.core.fm.FeatureModel;
import splar.core.fm.XMLFeatureModel;

public class FeatureModelToSMTLIB implements Z3SMTSolver {

	private static final Set<String> Z3_KEYWORDS = new HashSet<String>();
	static {
		Z3_KEYWORDS.add("select");
		Z3_KEYWORDS.add("min");
	}
	private static final String Z3_KEYWORD_SUFFIX = "_KEYWORD";

	private static void getConstraint(String featureModelPath) throws Exception {

		FeatureModel featureModel = new XMLFeatureModel(featureModelPath, XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
		featureModel.loadModel();
		CNFFormula cnf = featureModel.FM2CNF();
		StringBuilder cnfFormula = new StringBuilder(SMTLIB_AND);
		Set<String> cnfVars = new HashSet<String>();
		boolean needSpace = false;
		String variable;
		for (CNFClause cnfClause : cnf.getClauses()) {
			if (cnfClause.countLiterals() > 1) {
				cnfFormula.append(SMTLIB_OR);
				needSpace = false;
			}
			for (CNFLiteral cnfLiteral : cnfClause.getLiterals()) {
				if (!cnfLiteral.isPositive()) {
					cnfFormula.append(SMTLIB_NOT);
					needSpace = false;
				}
				if (needSpace) {
					cnfFormula.append(" ");
				}
				variable = cnfLiteral.getVariable().getID();
				if (Z3_KEYWORDS.contains(variable)) {
					variable += Z3_KEYWORD_SUFFIX;
				}
				cnfFormula.append(variable);
				cnfVars.add(variable);
				if (cnfLiteral.isPositive()) {
					needSpace = true;
				}
				else {
					cnfFormula.append(SMTLIB_PREDICATE_END);
				}
			}
			if (cnfClause.countLiterals() > 1) {
				cnfFormula.append(SMTLIB_PREDICATE_END);
			}
		}
		cnfFormula.append(SMTLIB_PREDICATE_END);

		StringBuilder cnfVariables = new StringBuilder();
		for (String cnfVariable : cnfVars) {
			cnfVariables.append(cnfVariable);
			cnfVariables.append(",");
		}
		cnfVariables.deleteCharAt(cnfVariables.length()-1);

		Properties outputProperties = new Properties();
		outputProperties.setProperty(LiftingHenshinTransformation.PROPERTY_IN_CONSTRAINT, cnfFormula.toString());
		outputProperties.setProperty(LiftingHenshinTransformation.PROPERTY_IN_CONSTRAINTVARIABLES, cnfVariables.toString());
		outputProperties.store(
			new FileOutputStream(
				MultiModelUtils.replaceFileExtensionInUri(featureModelPath, MultiModelOperatorUtils.PROPERTIES_SUFFIX.substring(1))
			), null
		);
	}

	public static void main(String[] args) {

		String inputPath = args[0];
		Path path = Paths.get(inputPath);
		if (Files.isDirectory(path)) {
			FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
					try {
						getConstraint(file.toString());
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					return FileVisitResult.CONTINUE;
				}
			};
			try {
				Files.walkFileTree(path, visitor);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				getConstraint(inputPath);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
