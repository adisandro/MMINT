/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Naama Ben-David.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 *    Naama Ben-David - Concretization highlighting.
 */
package edu.toronto.cs.se.modelepedia.z3.reasoning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mavo.LogicElement;
import edu.toronto.cs.se.mavo.MAVOCollection;
import edu.toronto.cs.se.mavo.MAVODecision;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOReasoningEngine;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.editor.Diagram;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.ui.MIDDialogs;
import edu.toronto.cs.se.mmint.mid.utils.MIDRegistry;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;
import edu.toronto.cs.se.modelepedia.z3.mavo.MAVOConcretizationHighlighter;
import edu.toronto.cs.se.modelepedia.z3.mavo.MAVORefiner;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOModelParser;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOUtils;

//TODO MMINT[Z3] Support refinement and highlighting for the complex full-MAVO encoding
public class Z3ReasoningEngine implements IMAVOReasoningEngine {

	public enum MAVOCheckStrategy {

		DOUBLE_CHECK, SINGLE_CHECK_IF_FALSE, SINGLE_CHECK
	}

	public final static @NonNull String ECOREMAVOTOSMTLIB_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EcoreMAVOToSMTLIB";

	private Z3Model z3ConstraintModel;
	private Z3Model z3NotConstraintModel;

	public @NonNull Z3MAVOModelParser generateSMTLIBEncoding(@NonNull Model model) throws Exception {

		if (!(model.getEMFInstanceRoot() instanceof MAVORoot)) {
			//TODO MMINT[Z3] Support non-mavo models (create acceleo transformation, check constraint once)
			throw new MMINTException("Model " + model.getName() + " is not a MAVO model");
		}
		EcoreMAVOToSMTLIB ecore2smt = (EcoreMAVOToSMTLIB) MIDTypeRegistry.<Operator>getType(ECOREMAVOTOSMTLIB_OPERATOR_URI);
		if (ecore2smt == null) {
			throw new MMINTException("Can't find " + ECOREMAVOTOSMTLIB_OPERATOR_URI + " operator type");
		}
		EcoreMAVOToSMTLIB encoder = ecore2smt;
		EList<Model> inputModels = new BasicEList<>();
		inputModels.add(model);
		EList<OperatorInput> inputs = null;
		for (EcoreMAVOToSMTLIB ecore2smtCustom : MIDTypeHierarchy.getSubtypes(ecore2smt)) { // check for custom encoders
			//TODO MMINT[Z3] Sort by subtype level to allow most specific to run
			inputs = ecore2smtCustom.checkAllowedInputs(inputModels);
			if (inputs != null) {
				encoder = ecore2smtCustom;
				break;
			}
		}
		if (inputs == null) { // use default encoder
			inputs = ecore2smt.checkAllowedInputs(inputModels);
		}
		encoder = (EcoreMAVOToSMTLIB) encoder.startInstance(inputs, null, new BasicEList<>(), new HashMap<>(), null);
		encoder.cleanup();

		return encoder.getZ3MAVOModelParser();
	}

	public @NonNull MAVOTruthValue checkMAVOConstraintWithSolver(@NonNull Z3IncrementalSolver z3IncSolver, @NonNull String smtMacros, @NonNull String smtConstraint, MAVOCheckStrategy checkStrategy) {

		Z3Model z3Model = z3IncSolver.checkSatAndGetModel(smtMacros + " " + Z3Utils.assertion(smtConstraint), Z3IncrementalBehavior.POP);
		boolean constraintTruthValue = z3Model.getZ3Result().isSAT();
		z3ConstraintModel = (constraintTruthValue) ? z3Model : null;
		switch (checkStrategy) {
			case SINGLE_CHECK: // skips the next check because the model has no mavo annotation
				z3NotConstraintModel = null;
				return MAVOTruthValue.toMAVOTruthValue(constraintTruthValue);
			case SINGLE_CHECK_IF_FALSE: // skips the next check because we don't care about losing a possible MAVOTruthValue.ERROR status
				if (!constraintTruthValue) {
					z3NotConstraintModel = null;
					return MAVOTruthValue.toMAVOTruthValue(constraintTruthValue);
				}
			case DOUBLE_CHECK:
				// just continue
		}
		z3Model = z3IncSolver.checkSatAndGetModel(smtMacros + " " + Z3Utils.assertion(Z3Utils.not(smtConstraint)), Z3IncrementalBehavior.POP);
		boolean notConstraintTruthValue = z3Model.getZ3Result().isSAT();
		z3NotConstraintModel = (notConstraintTruthValue) ? z3Model : null;

		return MAVOTruthValue.toMAVOTruthValue(constraintTruthValue, notConstraintTruthValue);
	}

	public @NonNull MAVOTruthValue checkMAVOConstraint(@NonNull String smtEncoding, @NonNull String smtMacros, @NonNull String smtConstraint, MAVOCheckStrategy checkStrategy) {

		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		z3IncSolver.firstCheckSatAndGetModel(smtEncoding);

		return checkMAVOConstraintWithSolver(z3IncSolver, smtMacros, smtConstraint, checkStrategy);
	}

	@Override
	public @NonNull MAVOTruthValue checkMAVOModelConstraint(@NonNull Model model, ExtendibleElementConstraint constraint, @NonNull MIDLevel constraintLevel) {

		Z3MAVOModelParser z3ModelParser;
		try {
			z3ModelParser = generateSMTLIBEncoding(model);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't generate SMTLIB encoding, evaluating to false", e);
			return MAVOTruthValue.FALSE;
		}
		MAVOCheckStrategy checkStrategy = (z3ModelParser.isAnnotated()) ? MAVOCheckStrategy.DOUBLE_CHECK : MAVOCheckStrategy.SINGLE_CHECK;
		MAVOTruthValue constraintTruthValue = checkMAVOConstraint(z3ModelParser.getSMTLIBEncoding(), z3ModelParser.getSMTLIBMacros(), constraint.getImplementation(), checkStrategy);

		// show example if: maybe, has a diagram, user accepts
		if (constraintTruthValue != MAVOTruthValue.MAYBE) {
			return constraintTruthValue;
		}
		Diagram modelDiagram = MIDRegistry.getModelDiagram(model);
		if (modelDiagram == null) {
			return constraintTruthValue;
		}
		//TODO MMINT[MAVO] This needs to be skipped when in a cycle (e.g. looking for all valid super/sub types)
		if (!MIDDialogs.getBooleanInput(
			"Concretization highlighter",
			"The result is MAYBE, do you want to see a concretization that violates the constraint?"
		)) {
			return constraintTruthValue;
		}

		// show example
		MAVOConcretizationHighlighter highlighter;
		try {
			highlighter = new MAVOConcretizationHighlighter();
			highlighter.highlightMAVOCounterExample(modelDiagram, z3ModelParser.getZ3MAVOModelObjects(z3NotConstraintModel));
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't highlight concretization, skipping it", e);
		}

		return constraintTruthValue;
	}

	@Override
	public boolean checkModelConstraint(@NonNull Model model, ExtendibleElementConstraint constraint, @NonNull MIDLevel constraintLevel) {

		return checkMAVOModelConstraint(model, constraint, constraintLevel).toBoolean();
	}

	@Override
	public boolean checkOperatorInputConstraint(@NonNull Map<String, Model> inputsByName, @NonNull ExtendibleElementConstraint constraint) {

		return true;
	}

	@Override
	public Map<ModelRel, List<Model>> getOperatorOutputConstraints(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, Model> outputsByName, @NonNull ExtendibleElementConstraint constraint) {

		return new HashMap<>();
	}

	@Override
	public boolean checkModelConstraintConsistency(@NonNull Model modelType, String constraint) {

		return true;
	}

	public Set<String> allSATWithSolver(@NonNull Z3IncrementalSolver z3IncSolver, @NonNull Z3MAVOModelParser z3ModelParser, @NonNull Z3Model z3Model, @NonNull Set<MAVOElement> mavoModelObjs, MAVORoot rootMavoModelObj) {

		Set<String> smtConcretizations = new HashSet<>();
		do {
			String smtConcretization = "";
			Map<String, Set<String>> z3ModelObjs = z3ModelParser.getZ3MAVOModelObjects(z3Model);
			for (MAVOElement mavoModelObj : mavoModelObjs) {
				String formulaVar = mavoModelObj.getFormulaVariable();
				int counterMS = 0;
				Set<String> mergedV = null;
				for (Set<String> formulaVars : z3ModelObjs.values()) {
					//TODO MMINT[Z3] Understand why we don't break here, is it only to increase counterMS in the S case?
					if (formulaVars.contains(formulaVar)) {
						counterMS++;
						mergedV = formulaVars;
					}
				}
				try {
					boolean isNegation;
					if (mavoModelObj.isMay()) {
						isNegation = (counterMS == 0);
						smtConcretization += Z3MAVOUtils.getSMTLIBMayModelObjectConstraint(mavoModelObj, z3ModelParser.isMayOnly(), isNegation);
					}
					if (mavoModelObj.isSet() && counterMS > 0) {
						isNegation = (counterMS > 1);
						smtConcretization += Z3MAVOUtils.getSMTLIBSetModelObjectConstraint(mavoModelObj, isNegation);
					}
					if (mavoModelObj.isVar() && counterMS > 0) {
						isNegation = (mergedV.size() > 1);
						if (!isNegation) {
							mergedV = MAVOUtils.getMergeableFormulaVars(rootMavoModelObj, mavoModelObj);
							if (mergedV.size() == 0) {
								continue;
							}
						}
						smtConcretization += Z3MAVOUtils.getSMTLIBVarModelObjectConstraint(mavoModelObj, mergedV, isNegation);
					}
				}
				catch (MMINTException e) {
					MMINTException.print(IStatus.WARNING, "Can't generate SMTLIB encoding for may model object " + formulaVar + ", skipping it", e);
					continue;
				}
			}
			smtConcretization = Z3Utils.and(smtConcretization);
			smtConcretizations.add(smtConcretization);
			z3Model = z3IncSolver.checkSatAndGetModel(Z3Utils.assertion(Z3Utils.not(smtConcretization)), Z3IncrementalBehavior.NORMAL);
		}
		while (z3Model.getZ3Result().isSAT());

		return smtConcretizations;
	}

	public Set<String> allSAT(@NonNull String smtEncoding, @NonNull Z3MAVOModelParser z3ModelParser, @NonNull Set<MAVOElement> mavoModelObjs, @NonNull MAVORoot rootMavoModelObj) {

		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		Z3Model z3Model = z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
		if (!z3Model.getZ3Result().isSAT()) {
			return new HashSet<>();
		}

		return allSATWithSolver(z3IncSolver, z3ModelParser, z3Model, mavoModelObjs, rootMavoModelObj);
	}

	public Set<String> allSAT(@NonNull Model model) {

		try {
			Z3MAVOModelParser z3ModelParser = generateSMTLIBEncoding(model);
			MAVORoot rootMavoModelObj = (MAVORoot) model.getEMFInstanceRoot();
			return allSAT(z3ModelParser.getSMTLIBEncoding(), z3ModelParser, new HashSet<>(MAVOUtils.getAnnotatedMAVOModelObjects(rootMavoModelObj).values()), rootMavoModelObj);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't generate SMTLIB encoding, returning 0 concretizations", e);
			return new HashSet<>();
		}
	}

	private void optimizeMayBackbone(@NonNull Z3MAVOModelParser z3ModelParser, @NonNull Z3Model z3Model, @NonNull Set<MAVOElement> mayModelObjs, @NonNull Set<String> baselineFormulaVars, @NonNull Map<String, MAVOTruthValue> backboneTruthValues) {

		Set<String> currentFormulaVars = z3ModelParser.getZ3MAVOModelObjects(z3Model).values().stream()
			.flatMap(Set::stream)
			.collect(Collectors.toSet());
		mayModelObjs.stream()
			.filter(mayModelObj -> !backboneTruthValues.containsKey(mayModelObj.getFormulaVariable()))
			.filter(mayModelObj -> baselineFormulaVars.contains(mayModelObj.getFormulaVariable()) != currentFormulaVars.contains(mayModelObj.getFormulaVariable()))
			.forEach(mayModelObj -> backboneTruthValues.put(mayModelObj.getFormulaVariable(), MAVOTruthValue.MAYBE));
	}

	public @NonNull Map<String, MAVOTruthValue> mayBackboneWithSolver(@NonNull Z3IncrementalSolver z3IncSolver, @Nullable Z3MAVOModelParser z3ModelParser, @Nullable Z3Model z3Model, @NonNull Set<MAVOElement> mayModelObjs) {

		Set<String> baselineFormulaVars = (z3ModelParser == null) ?
			null :
			z3ModelParser.getZ3MAVOModelObjects(z3Model).values().stream()
				.flatMap(Set::stream)
				.collect(Collectors.toSet());
		Map<String, MAVOTruthValue> backboneTruthValues = new HashMap<>();
		// for each may element, assert it and its negation
		for (MAVOElement mayModelObj : mayModelObjs) {
			String formulaVar = mayModelObj.getFormulaVariable();
			if (backboneTruthValues.containsKey(formulaVar)) { // optimized
				continue;
			}
			String smtConstraint;
			try {
				smtConstraint = Z3MAVOUtils.getSMTLIBMayModelObjectConstraint(mayModelObj, true, false);
			}
			catch (MMINTException e) {
				MMINTException.print(IStatus.WARNING, "Can't generate SMTLIB encoding for may model object " + formulaVar + ", skipping it", e);
				continue;
			}
			MAVOTruthValue backboneTruthValue = this.checkMAVOConstraintWithSolver(z3IncSolver, "", smtConstraint, MAVOCheckStrategy.SINGLE_CHECK_IF_FALSE);
			backboneTruthValues.put(formulaVar, backboneTruthValue);
			if (backboneTruthValue != MAVOTruthValue.FALSE && z3ModelParser != null) { // optimize
				optimizeMayBackbone(z3ModelParser, z3ConstraintModel, mayModelObjs, baselineFormulaVars, backboneTruthValues);
				if (backboneTruthValue == MAVOTruthValue.MAYBE) {
					optimizeMayBackbone(z3ModelParser, z3NotConstraintModel, mayModelObjs, baselineFormulaVars, backboneTruthValues);
				}
			}
		}

		return backboneTruthValues;
	}

	public @NonNull Map<String, MAVOTruthValue> mayBackbone(@NonNull String smtEncoding, @Nullable Z3MAVOModelParser z3ModelParser, @NonNull Set<MAVOElement> mayModelObjs) {

		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		Z3Model z3Model = z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
		if (!z3Model.getZ3Result().isSAT()) {
			return new HashMap<>();
		}

		return mayBackboneWithSolver(z3IncSolver, z3ModelParser, z3Model, mayModelObjs);
	}

	public @NonNull Map<String, MAVOTruthValue> mayBackbone(@NonNull Model model) {

		try {
			Z3MAVOModelParser z3ModelParser = generateSMTLIBEncoding(model);
			if (!z3ModelParser.isMayOnly()) {
				throw new MMINTException("The backbone is for may models only");
			}
			MAVORoot rootMavoModelObj = (MAVORoot) model.getEMFInstanceRoot();
			return mayBackbone(z3ModelParser.getSMTLIBEncoding(), z3ModelParser, new HashSet<>(MAVOUtils.getAnnotatedMAVOModelObjects(rootMavoModelObj).values()));
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't generate SMTLIB encoding, returning 0 backbone elements", e);
			return new HashMap<>();
		}
	}

	@Override
	public @Nullable Model refineModelByConstraint(@NonNull Model model) {

		Z3MAVOModelParser z3ModelParser;
		try {
			z3ModelParser = generateSMTLIBEncoding(model);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't generate SMTLIB encoding, aborting refinement", e);
			return null;
		}
		MAVOCheckStrategy checkStrategy = (z3ModelParser.isAnnotated()) ? MAVOCheckStrategy.DOUBLE_CHECK : MAVOCheckStrategy.SINGLE_CHECK;
		MAVOTruthValue constraintTruthValue = checkMAVOConstraint(z3ModelParser.getSMTLIBEncoding(), z3ModelParser.getSMTLIBMacros(), model.getConstraint().getImplementation(), checkStrategy);

		// refine if: maybe
		if (constraintTruthValue != MAVOTruthValue.MAYBE) {
			MMINTException.print(IStatus.ERROR, "The constraint is not MAYBE, aborting refinement", null);
			return null;
		}

		// refine
		Diagram modelDiagram = MIDRegistry.getModelDiagram(model);
		String smtEncoding = z3ModelParser.getSMTLIBEncoding() + Z3Utils.assertion(model.getConstraint().getImplementation());
		MAVORefiner refiner = new MAVORefiner(this);
		try {
			return refiner.refine(model, modelDiagram, null, smtEncoding, z3ModelParser);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't refine the model by constraint, aborting (some incomplete result could appear in your instance MID)", e);
			return null;
		}
	}

	private @NonNull String generateMayRefinementSMTLIBEncoding(@NonNull Model model, @NonNull List<? extends LogicElement> mayLogicElems) throws Exception {

		// base encoding
		Z3MAVOModelParser z3ModelParser = generateSMTLIBEncoding(model);
		String smtEncoding = z3ModelParser.getSMTLIBEncoding();

		// constraints
		if (model.getConstraint() != null) {
			smtEncoding += Z3Utils.assertion(model.getConstraint().getImplementation());
		}
		String smtMayLogicElem = "";
		for (LogicElement mayLogicElem : mayLogicElems) {
			if (mayLogicElem instanceof MAVOCollection) {
				smtMayLogicElem = mayLogicElem.getFormulaVariable();
			}
			else if (mayLogicElem instanceof MAVOElement) {
				smtMayLogicElem = Z3MAVOUtils.getSMTLIBMayModelObjectConstraint((MAVOElement) mayLogicElem, z3ModelParser.isMayOnly(), false);
			}
			smtEncoding += Z3Utils.assertion(smtMayLogicElem);
		}

		return smtEncoding;
	}

	@Override
	public @Nullable Model refineModelByMayAlternative(@NonNull Model model, @NonNull MAVOCollection mayAlternative) {

		String smtEncoding;
		try {
			List<MAVOCollection> mayLogicElems = new ArrayList<>();
			mayLogicElems.add(mayAlternative);
			smtEncoding = generateMayRefinementSMTLIBEncoding(model, mayLogicElems);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't generate SMTLIB encoding, aborting refinement", e);
			return null;
		}

		// refine
		Diagram modelDiagram = MIDRegistry.getModelDiagram(model);
		MAVORefiner refiner = new MAVORefiner(this);
		try {
			return refiner.refine(model, modelDiagram, mayAlternative, smtEncoding, null);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't refine the model by may alternative, aborting (some incomplete result could appear in your instance MID)", e);
			return null;
		}
	}

	@Override
	public @Nullable Model refineModelByMayModelObjects(@NonNull Model model, @NonNull List<MAVOElement> mayModelObjs) {

		String smtEncoding;
		try {
			smtEncoding = generateMayRefinementSMTLIBEncoding(model, mayModelObjs);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't generate SMTLIB encoding, aborting refinement", e);
			return null;
		}

		// refine
		Diagram modelDiagram = MIDRegistry.getModelDiagram(model);
		MAVORefiner refiner = new MAVORefiner(this);
		try {
			return refiner.refine(model, modelDiagram, null, smtEncoding, null);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "Can't refine the model by may model objects, aborting (some incomplete result could appear in your instance MID)", e);
			return null;
		}
	}

	@Override
	public @Nullable Model refineModelByVarDomain(@NonNull Model model, @NonNull MAVOCollection varDomain, @NonNull MAVOElement mergedModelObj, @NonNull List<MAVOElement> varModelObjs) {

		//TODO MMINT[VAR-MMINT] Need to come up with a different approach than the may constraint-based: first merge in the model and remove Vs, then run the solver to cascade
		//TODO MMINT[MU-MMINT] Migrate var approach to may too (first remove elements and Ms in the model, then run the solver to cascade)

		return null;
	}

	@Override
	public void highlightMAVODecision(@NonNull Diagram modelDiagram, @NonNull MAVODecision mavoDecision) {

		MAVOConcretizationHighlighter highlighter = new MAVOConcretizationHighlighter();
		try {
			highlighter.highlight(modelDiagram, mavoDecision);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't highlight MAVO decision, skipping it", e);
		}
	}

	@Override
	public void highlightMAVOCollection(@NonNull Diagram modelDiagram, @NonNull MAVOCollection mavoCollection) {

		MAVOConcretizationHighlighter highlighter = new MAVOConcretizationHighlighter();
		try {
			highlighter.highlight(modelDiagram, mavoCollection);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't highlight MAVO collection, skipping it", e);
		}
	}

	@Override
	public void highlightMAVOElement(@NonNull Diagram modelDiagram, @NonNull MAVOElement mavoModelObj) {

		MAVOConcretizationHighlighter highlighter = new MAVOConcretizationHighlighter();
		try {
			highlighter.highlight(modelDiagram, mavoModelObj);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Can't highlight MAVO element, skipping it", e);
		}
	}

}
