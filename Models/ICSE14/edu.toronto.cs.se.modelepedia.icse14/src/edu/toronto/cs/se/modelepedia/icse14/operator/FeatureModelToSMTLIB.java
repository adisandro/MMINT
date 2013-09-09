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

import splar.core.constraints.CNFClause;
import splar.core.constraints.CNFFormula;
import splar.core.constraints.CNFLiteral;
import splar.core.fm.FeatureModel;
import splar.core.fm.FeatureModelException;
import splar.core.fm.XMLFeatureModel;

public class FeatureModelToSMTLIB {

	public static void main(String[] args) {

		String featureModelPath = args[0];
		FeatureModel featureModel = new XMLFeatureModel(featureModelPath, XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
		try {
			featureModel.loadModel();
		}
		catch (FeatureModelException e) {
			e.printStackTrace();
		}
		CNFFormula cnf = featureModel.FM2CNF();

		StringBuilder cnfFormula = new StringBuilder("(and ");
		StringBuilder cnfVariables = new StringBuilder();
		boolean needSpace = false;
		for (CNFClause cnfClause : cnf.getClauses()) {
			if (cnfClause.countLiterals() > 1) {
				cnfFormula.append("(or ");
				needSpace = false;
			}
			for (CNFLiteral cnfLiteral : cnfClause.getLiterals()) {
				if (!cnfLiteral.isPositive()) {
					cnfFormula.append("(not ");
					needSpace = false;
				}
				if (needSpace) {
					cnfFormula.append(" ");
				}
				cnfFormula.append(cnfLiteral.getVariable().getID());
				cnfVariables.append(cnfLiteral.getVariable().getID());
				cnfVariables.append(",");
				if (cnfLiteral.isPositive()) {
					needSpace = true;
				}
				else {
					cnfFormula.append(")");
				}
			}
			if (cnfClause.countLiterals() > 1) {
				cnfFormula.append(")");
			}
		}
		cnfFormula.append(")");
		cnfVariables.deleteCharAt(cnfVariables.length()-1);

		System.out.println(cnfFormula);
		System.out.println(cnfVariables);
	}

}
