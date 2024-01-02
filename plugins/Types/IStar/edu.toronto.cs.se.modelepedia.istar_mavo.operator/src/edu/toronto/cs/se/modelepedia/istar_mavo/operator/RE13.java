/**
 * Copyright (c) 2012-2024 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.istar_mavo.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;

import com.microsoft.z3.FuncDecl;
import com.microsoft.z3.FuncInterp.Entry;
import com.microsoft.z3.Z3Exception;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.modelepedia.istar_mavo.Actor;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar;
import edu.toronto.cs.se.modelepedia.istar_mavo.IStar_MAVOPackage;
import edu.toronto.cs.se.modelepedia.istar_mavo.Intention;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Result;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOModelParser;

public class RE13 extends OperatorImpl {

	protected enum SMTLIBLabel {

		fs(IStar_MAVOPackage.eINSTANCE.getIntention_FullySatisfied()),
		ps(IStar_MAVOPackage.eINSTANCE.getIntention_PartiallySatisfied()),
		un(IStar_MAVOPackage.eINSTANCE.getIntention_Unknown()),
		co(IStar_MAVOPackage.eINSTANCE.getIntention_Conflict()),
		pd(IStar_MAVOPackage.eINSTANCE.getIntention_PartiallyDenied()),
		fd(IStar_MAVOPackage.eINSTANCE.getIntention_FullyDenied()),
		no(IStar_MAVOPackage.eINSTANCE.getIntention_NoLabel());

		private final EStructuralFeature modelFeature;

		SMTLIBLabel(EStructuralFeature modelFeature) {
			this.modelFeature = modelFeature;
		}

		EStructuralFeature getModelFeature() {
			return this.modelFeature;
		}
	}

	// input-output
	protected final static @NonNull String IN_MODEL = "istar";
	private static final String PROPERTY_IN_TARGETSPROPERTY = "targetsProperty";
	private static final String PROPERTY_IN_TARGETSPROPERTY_DEFAULT = "";
	private static final String PROPERTY_OUT_TIMEMODEL = "timeModel";
	protected static final String PROPERTY_OUT_TIMEANALYSIS = "timeAnalysis";
	private static final String PROPERTY_OUT_TIMETARGETS = "timeTargets";
	private static final String PROPERTY_OUT_LABELS_SUFFIX = ".labels";
	private static final String PROPERTY_OUT_TARGETS = "targets";
	// constants
	protected static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_IStarMAVOToSMTLIB";
	protected static final String SMTLIB_CONCRETIZATION = " c ";
	private static final Set<String> Z3_MODEL_NODETYPES = new HashSet<>();
	static {
		RE13.Z3_MODEL_NODETYPES.add("Task");
		RE13.Z3_MODEL_NODETYPES.add("Goal");
		RE13.Z3_MODEL_NODETYPES.add("SoftGoal");
		RE13.Z3_MODEL_NODETYPES.add("Resource");
	}

	// input
	private boolean timeModelEnabled;
	protected boolean timeTargetsEnabled;
	private String targetsProperty;
	// state
	protected IStar istar;
	protected Map<String, Intention> intentions;
	protected Set<String> initialIntentions;
	protected Z3MAVOModelParser z3ModelParser;
	protected String smtEncoding;
	// output
	private long timeModel;
	private long timeAnalysis;
	protected long timeTargets;
	protected Z3Result targets;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		this.timeModelEnabled = MIDOperatorIOUtils.getBoolProperty(inputProperties, RE13.PROPERTY_OUT_TIMEMODEL+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX);
		this.timeTargetsEnabled = MIDOperatorIOUtils.getBoolProperty(inputProperties, RE13.PROPERTY_OUT_TIMETARGETS+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX);
		this.targetsProperty = MIDOperatorIOUtils.getOptionalStringProperty(inputProperties, RE13.PROPERTY_IN_TARGETSPROPERTY, RE13.PROPERTY_IN_TARGETSPROPERTY_DEFAULT);
	}

	protected void init() {

		// state
		this.istar = null;
		this.intentions = new HashMap<>();
		this.initialIntentions = new HashSet<>();
//		IStarMAVOToSMTLIB previousOperator = (getPreviousOperator() == null) ?
//			(IStarMAVOToSMTLIB) MIDTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR_URI) :
//			(IStarMAVOToSMTLIB) getPreviousOperator();
		var previousOperator = (IStarMAVOToSMTLIB) MIDTypeRegistry.<Operator>getType(RE13.PREVIOUS_OPERATOR_URI);
		this.z3ModelParser = previousOperator.getZ3MAVOModelParser();
		this.smtEncoding = this.z3ModelParser.getSMTLIBEncoding();
		// output
		this.timeModel = -1;
		this.timeAnalysis = -1;
		this.timeTargets = -1;
		this.targets = Z3Result.UNKNOWN;
	}

	protected String writeIntentionLabels(Intention intention) {

		var labels = "";
		for (SMTLIBLabel label : SMTLIBLabel.values()) {
			if ((boolean) intention.eGet(label.getModelFeature())) {
				labels += label.name() + ",";
			}
		}
		if (!labels.equals("")) {
			labels = labels.substring(0, labels.length()-1);
		}

		return labels;
	}

	protected void writeProperties(Properties properties) {

		properties.setProperty(RE13.PROPERTY_OUT_TIMEMODEL, String.valueOf(this.timeModel));
		properties.setProperty(RE13.PROPERTY_OUT_TIMEANALYSIS, String.valueOf(this.timeAnalysis));
		properties.setProperty(RE13.PROPERTY_OUT_TIMETARGETS, String.valueOf(this.timeTargets));
		properties.setProperty(RE13.PROPERTY_OUT_TARGETS, this.targets.toString());
		for (Map.Entry<String, Intention> entry : this.intentions.entrySet()) {
			properties.setProperty(entry.getKey()+RE13.PROPERTY_OUT_LABELS_SUFFIX, writeIntentionLabels(entry.getValue()));
		}
	}

	private void getConcretizationAnalysisLabel(Map<String, Intention> intentions, Map<String, Set<String>> z3ModelNodes, Set<String> z3LabelNodeIds, SMTLIBLabel label, String nodeType, boolean elseValue) {

		var labelFeature = label.getModelFeature();
		if (elseValue) {
			for (Map.Entry<String, Set<String>> z3ModelNode : z3ModelNodes.entrySet()) {
				var z3NodeId = z3ModelNode.getKey();
				if (!z3NodeId.startsWith(nodeType)) {
					continue;
				}
				if (z3LabelNodeIds.contains(z3NodeId)) {
					continue;
				}
				z3ModelNode.getValue().forEach(formulaVar -> intentions.get(formulaVar).eSet(labelFeature, true));
			}
		}
		else {
			for (String z3LabelNodeId : z3LabelNodeIds) {
				var formulaVars = z3ModelNodes.get(z3LabelNodeId);
				if (formulaVars == null) {
					continue;
				}
				formulaVars.forEach(formulaVar -> intentions.get(formulaVar).eSet(labelFeature, true));
			}
		}
	}

	protected void getConcretizationAnalysisLabels(Map<String, Intention> intentions, Z3Model z3Model) {

		try {
			Map<String, Set<String>> z3ModelNodes = this.z3ModelParser.getZ3MAVOModelNodes(z3Model);
			var z3InternalModel = z3Model.getZ3InternalModel();
			for (SMTLIBLabel label : SMTLIBLabel.values()) {
				for (FuncDecl decl : z3InternalModel.getFuncDecls()) {
					if (!(decl.getName().toString().equals(label.name()) || decl.getName().toString().contains(label.name()+Z3Utils.Z3_MODEL_SEPARATOR))) {
						continue;
					}
					var nodeType = decl.getDomain()[0].getName().toString();
					if (!RE13.Z3_MODEL_NODETYPES.contains(nodeType)) { // edge function
						continue;
					}
					var interp = z3InternalModel.getFuncInterp(decl);
					if (interp.getEntries().length == 0) {// function that calls another function
						continue;
					}
					Set<String> z3LabelNodeUniverses = new HashSet<>();
					for (Entry entry : interp.getEntries()) {
						z3LabelNodeUniverses.add(entry.getArgs()[0].toString());
					}
					getConcretizationAnalysisLabel(intentions, z3ModelNodes, z3LabelNodeUniverses, label, nodeType, Boolean.parseBoolean(interp.getElse().toString()));
				}
			}
		}
		catch (Z3Exception e) {
			MMINTException.print(IStatus.INFO, "Can't optimize analysis, skipping it", e);
		}
	}

	protected void doAnalysis(Z3IncrementalSolver z3IncSolver) {

		var startTime = System.nanoTime();

		z3IncSolver.firstCheckSatAndGetModel(this.smtEncoding);
		if (this.timeModelEnabled) {
			this.timeModel = System.nanoTime() - startTime;
		}
		String intentionProperty, labelProperty;
		for (Map.Entry<String, Intention> entry : this.intentions.entrySet()) {
			var intentionFormulaVar = entry.getKey();
			var intention = entry.getValue();
			if (this.initialIntentions.contains(intentionFormulaVar)) { // skip intentions with initial label
				continue;
			}
			intentionProperty = Z3Utils.SMTLIB_ASSERT;
			if (intention.isMay()) {
				intentionProperty +=
					Z3Utils.SMTLIB_AND +
					Z3Utils.exists(
						Z3Utils.emptyPredicate(RE13.SMTLIB_CONCRETIZATION + intention.eClass().getName()),
						Z3Utils.predicate(Z3Utils.SMTLIB_NODE_FUNCTION, intentionFormulaVar + RE13.SMTLIB_CONCRETIZATION)
					)
				;
			}
			intentionProperty +=
				Z3Utils.SMTLIB_FORALL +
				Z3Utils.SMTLIB_PREDICATE_START +
				Z3Utils.emptyPredicate(RE13.SMTLIB_CONCRETIZATION + intention.eClass().getName()) +
				Z3Utils.SMTLIB_PREDICATE_END +
				Z3Utils.SMTLIB_IMPLICATION +
				Z3Utils.predicate(Z3Utils.SMTLIB_NODE_FUNCTION, intentionFormulaVar + RE13.SMTLIB_CONCRETIZATION)
			;
			for (SMTLIBLabel label : SMTLIBLabel.values()) {
				if ((boolean) intention.eGet(label.getModelFeature())) { // skip already checked
					continue;
				}
				labelProperty = intentionProperty + Z3Utils.predicate(Z3Utils.SMTLIB_PREDICATE_START + label.name(), RE13.SMTLIB_CONCRETIZATION) + Z3Utils.SMTLIB_PREDICATE_END + Z3Utils.SMTLIB_PREDICATE_END;
				if (intention.isMay()) {
					labelProperty += Z3Utils.SMTLIB_PREDICATE_END;
				}
				labelProperty += Z3Utils.SMTLIB_PREDICATE_END;
				Z3Model z3Model = z3IncSolver.checkSatAndGetModel(labelProperty, Z3IncrementalBehavior.POP);
				if (z3Model.getZ3Result() == Z3Result.SAT) {
					intention.eSet(label.getModelFeature(), true);
					getConcretizationAnalysisLabels(this.intentions, z3Model);
				}
			}
		}

		this.timeAnalysis = System.nanoTime() - startTime;
	}

	protected Z3Model doTargets(Z3IncrementalSolver z3IncSolver) {

		var startTime = System.nanoTime();

		Z3Model z3Model = z3IncSolver.checkSatAndGetModel(Z3Utils.assertion(this.targetsProperty), Z3IncrementalBehavior.NORMAL);
		this.targets = z3Model.getZ3Result();

		this.timeTargets = System.nanoTime() - startTime;

		return z3Model;
	}

	protected Map<String, Intention> collectIntentions(IStar istar) {

		Map<String, Intention> intentions = new HashMap<>();
		for (Actor actor : istar.getActors()) {
			for (Intention intention : actor.getIntentions()) {
				intentions.put(intention.getFormulaVariable(), intention);
			}
		}
		for (Intention intention : istar.getDependums()) {
			intentions.put(intention.getFormulaVariable(), intention);
		}

		return intentions;
	}

	protected void collectAnalysisModelObjects(Model istarModel) throws MMINTException {

		this.istar = (IStar) istarModel.getEMFInstanceRoot();
		this.intentions = collectIntentions(this.istar);
		for (Map.Entry<String, Intention> entry : this.intentions.entrySet()) {
			var intention = entry.getValue();
			if (
				intention.isFullySatisfied() ||
				intention.isPartiallySatisfied() ||
				intention.isUnknown() ||
				intention.isConflict() ||
				intention.isPartiallyDenied() ||
				intention.isFullyDenied() ||
				intention.isNoLabel()
			) {
				this.initialIntentions.add(entry.getKey());
			}
		}
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		var istarModel = inputsByName.get(RE13.IN_MODEL);
		this.init();

		// run solver
		collectAnalysisModelObjects(istarModel);
		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		doAnalysis(z3IncSolver);
		if (this.timeTargetsEnabled) {
			doTargets(z3IncSolver);
		}

		// output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MIDOperatorIOUtils.writeOutputProperties(this, outputProperties);

		return new HashMap<>();
	}

}
