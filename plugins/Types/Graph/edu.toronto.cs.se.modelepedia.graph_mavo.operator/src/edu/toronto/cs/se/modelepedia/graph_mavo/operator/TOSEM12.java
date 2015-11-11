/**
 * Copyright (c) 2012-2015 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.graph_mavo.operator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mavo.constraint.MAVOMultiModelConstraintChecker;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.library.MultiModelOperatorUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.modelepedia.graph_mavo.Edge;
import edu.toronto.cs.se.modelepedia.graph_mavo.Graph;
import edu.toronto.cs.se.modelepedia.graph_mavo.Node;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Result;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOModelParser;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOUtils;
import edu.toronto.cs.se.modelepedia.z3.reasoning.Z3ReasoningEngine;

public class TOSEM12 extends RandomOperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "random";
	private static final String PROPERTY_IN_NUMCONCRETIZATIONS = "numConcretizations";
	private static final String PROPERTY_IN_PROPERTYID = "propertyId";
	private static final String PROPERTY_OUT_TIMEMAVO = "timeMAVO";
	private static final String PROPERTY_OUT_TIMECLASSICAL = "timeClassical";
	private static final String PROPERTY_OUT_TIMEMAVOBACKBONE = "timeMAVOBackbone";
	private static final String PROPERTY_OUT_TIMEMAVOALLSAT = "timeMAVOAllsat";
	private static final String PROPERTY_OUT_SPEEDUPCLASSICALMAVO = "speedupClassicalMAVO";
	private static final String PROPERTY_OUT_SPEEDUPMAVOALLSATMAVOBACKBONE = "speedupMAVOAllsatMAVOBackbone";
	// constants
	private static final String Z3_LANGUAGE = "SMTLIB";
	private static final String Z3_NAME = "Z3 Solver";
	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EcoreMAVOToSMTLIB";
	private static final String PREVIOUS_OPERATOR2_URI = "http://se.cs.toronto.edu/modelepedia/Operator_GenerateRandomGraphMAVO";

	// input
	private int numConcretizations;
	private int propertyId;
	private boolean timeClassicalEnabled;
	private boolean timeMAVOBackboneEnabled;
	private boolean timeMAVOAllsatEnabled;
	// state
	private MAVOTruthValue resultMAVO;
	private Map<String, MAVOElement> mayModelObjs;
	private String smtEncoding;
	private String smtConcretizationsConstraint;
	private Set<String> smtConcretizations;
	private String smtProperty;
	Z3MAVOModelParser z3ModelParser;
	// output
	private long timeMAVO;
	private long timeClassical;
	private long timeMAVOBackbone;
	private long timeMAVOAllsat;
	private double speedupClassicalMAVO;
	private double speedupMAVOAllsatMAVOBackbone;

	@Override
	public void readInputProperties(Properties inputProperties) throws MMINTException {

		super.readInputProperties(inputProperties);
		numConcretizations = MultiModelOperatorUtils.getIntProperty(inputProperties, PROPERTY_IN_NUMCONCRETIZATIONS);
		propertyId = MultiModelOperatorUtils.getIntProperty(inputProperties, PROPERTY_IN_PROPERTYID);
		timeClassicalEnabled = MultiModelOperatorUtils.getBoolProperty(inputProperties, PROPERTY_OUT_TIMECLASSICAL+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		timeMAVOBackboneEnabled = MultiModelOperatorUtils.getBoolProperty(inputProperties, PROPERTY_OUT_TIMEMAVOBACKBONE+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
		timeMAVOAllsatEnabled = MultiModelOperatorUtils.getBoolProperty(inputProperties, PROPERTY_OUT_TIMEMAVOALLSAT+MultiModelOperatorUtils.PROPERTY_IN_OUTPUTENABLED_SUFFIX);
	}

	@Override
	public void init() throws MMINTException {

		// state
		EcoreMAVOToSMTLIB previousOperator = (getPreviousOperator() == null) ?
			(EcoreMAVOToSMTLIB) MultiModelTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR_URI) :
			(EcoreMAVOToSMTLIB) getPreviousOperator();
		GenerateRandomGraphMAVO previousOperator2 = (GenerateRandomGraphMAVO) MultiModelTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR2_URI);
		resultMAVO = MAVOTruthValue.ERROR;
		mayModelObjs = previousOperator2.getMAVOModelObjects();
		z3ModelParser = previousOperator.getZ3MAVOModelParser();
		smtEncoding = z3ModelParser.getSMTLIBEncoding();
		smtConcretizationsConstraint = "";
		smtConcretizations = new HashSet<String>();
		smtProperty = "";

		// output
		timeMAVO = -1;
		timeClassical = -1;
		timeMAVOBackbone = -1;
		timeMAVOAllsat = -1;
		speedupClassicalMAVO = -1;
		speedupMAVOAllsatMAVOBackbone = -1;
	}

	private void writeProperties(Properties properties) {

		properties.setProperty(PROPERTY_OUT_TIMEMAVO, String.valueOf(timeMAVO));
		properties.setProperty(PROPERTY_OUT_TIMECLASSICAL, String.valueOf(timeClassical));
		properties.setProperty(PROPERTY_OUT_TIMEMAVOBACKBONE, String.valueOf(timeMAVOBackbone));
		properties.setProperty(PROPERTY_OUT_TIMEMAVOALLSAT, String.valueOf(timeMAVOAllsat));
		properties.setProperty(PROPERTY_OUT_SPEEDUPCLASSICALMAVO, String.valueOf(speedupClassicalMAVO));
		properties.setProperty(PROPERTY_OUT_SPEEDUPMAVOALLSATMAVOBACKBONE, String.valueOf(speedupMAVOAllsatMAVOBackbone));
	}

	private String generateSMTLIBConcretization() {

		String smtConcretization = "";
		Map<String, Boolean> wellFormedModelObjs = new HashMap<String, Boolean>();
		for (MAVOElement mayModelObj : mayModelObjs.values()) {
			String mayModelObjSmtEncoding = (mayModelObj instanceof Node) ?
				Z3Utils.predicate(Z3Utils.SMTLIB_NODE_FUNCTION, mayModelObj.getFormulaVariable()) :
				Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, mayModelObj.getFormulaVariable());
			Boolean exists = wellFormedModelObjs.get(mayModelObjSmtEncoding);
			if (exists == null) {
				exists = state.nextBoolean();
				if (mayModelObj instanceof Node) {
					if (!exists) { // enforce future well-formedness
						for (Edge edgeAsSrc : ((Node) mayModelObj).getEdgesAsSource()) {
							wellFormedModelObjs.put(
								Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, edgeAsSrc.getFormulaVariable()),
								new Boolean(false)
							);
						}
						for (Edge edgeAsTgt : ((Node) mayModelObj).getEdgesAsTarget()) {
							wellFormedModelObjs.put(
								Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, edgeAsTgt.getFormulaVariable()),
								new Boolean(false)
							);
						}
					}
				}
				else {
					if (exists) { // enforce future well-formedness
						wellFormedModelObjs.put(
							Z3Utils.predicate(Z3Utils.SMTLIB_NODE_FUNCTION, ((Edge) mayModelObj).getSource().getFormulaVariable()),
							new Boolean(true)
						);
						wellFormedModelObjs.put(
							Z3Utils.predicate(Z3Utils.SMTLIB_NODE_FUNCTION, ((Edge) mayModelObj).getTarget().getFormulaVariable()),
							new Boolean(true)
						);
					}
				}
			}
			else { // well-formedness enforced
				wellFormedModelObjs.remove(mayModelObjSmtEncoding);
			}
			smtConcretization += (exists) ? mayModelObjSmtEncoding: Z3Utils.not(mayModelObjSmtEncoding);
		}
		smtConcretization = Z3Utils.and(smtConcretization);

		return smtConcretization;
	}

	private void generateSMTLIBConcretizations() throws MMINTException {

		long maxConcretizations = Math.round(Math.pow(2, mayModelObjs.size()));
		if (numConcretizations > maxConcretizations) {
			throw new MMINTException("numConcretizations (" + numConcretizations + ") > maxConcretizations (" + maxConcretizations + ")");
		}
		if (maxConcretizations <= 1) {
			return;
		}

		//TODO MMINT[TOSEM] add heuristics to detect large number of concretizations (when it's more efficient to generate them all and then cut some)
		for (int i = 0; i < numConcretizations; i++) {
			String smtConcretization = generateSMTLIBConcretization();
			if (smtConcretizations.contains(smtConcretization)) { // duplicate
				i--;
				continue;
			}
			else {
				smtConcretizations.add(smtConcretization);
				smtConcretizationsConstraint += smtConcretization + '\n';
			}
		}
		smtConcretizationsConstraint = Z3Utils.or(smtConcretizationsConstraint);
	}

	private void groundProperty5(Node node) {

		// property 5: at most one outgoing edge per node
		// true by construction
		if (node.getEdgesAsSource().size() <= 1) {
			smtProperty += Z3Utils.SMTLIB_TRUE;
			return;
		}
		smtProperty += Z3Utils.SMTLIB_OR;
		// no edges
		smtProperty += Z3Utils.SMTLIB_AND;
		for (Edge outEdge : node.getEdgesAsSource()) {
			smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdge.getFormulaVariable()));
		}
		smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
		// one edge only
		for (Edge outEdgeI : node.getEdgesAsSource()) {
			smtProperty += Z3Utils.SMTLIB_AND + Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdgeI.getFormulaVariable());
			for (Edge outEdgeJ : node.getEdgesAsSource()) {
				if (outEdgeI == outEdgeJ) {
					continue;
				}
				smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdgeJ.getFormulaVariable()));
			}
			smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
		}
		smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
	}

	private void groundProperty6(Node node) {

		// property 6: not more than one edge from a node to another
		// true by construction
		if (node.getEdgesAsSource().size() <= 1) {
			smtProperty += Z3Utils.SMTLIB_TRUE;
			return;
		}
		smtProperty += Z3Utils.SMTLIB_AND;
		// construct map of target nodes
		Map<Node, List<Edge>> tgtNode2EdgesMap = new HashMap<Node, List<Edge>>();
		for (Edge outEdge : node.getEdgesAsSource()) {
			List<Edge> tgtNode2Edges = tgtNode2EdgesMap.get(outEdge.getTarget());
			if (tgtNode2Edges == null) {
				tgtNode2Edges = new ArrayList<Edge>();
				tgtNode2Edges.add(outEdge);
				tgtNode2EdgesMap.put(outEdge.getTarget(), tgtNode2Edges);
			}
			else {
				tgtNode2Edges.add(outEdge);
			}
		}
		// use map of target nodes
		for (List<Edge> tgtNode2Edges : tgtNode2EdgesMap.values()) {
			// true by construction
			if (tgtNode2Edges.size() <= 1) {
				smtProperty += Z3Utils.SMTLIB_TRUE;
				continue;
			}
			smtProperty += Z3Utils.SMTLIB_OR;
			// no edges
			smtProperty += Z3Utils.SMTLIB_AND;
			for (Edge outEdge : tgtNode2Edges) {
				smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdge.getFormulaVariable()));
			}
			smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
			// one edge only
			for (Edge outEdgeI : tgtNode2Edges) {
				smtProperty += Z3Utils.SMTLIB_AND + Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdgeI.getFormulaVariable());
				for (Edge outEdgeJ : tgtNode2Edges) {
					if (outEdgeI == outEdgeJ) {
						continue;
					}
					smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdgeJ.getFormulaVariable()));
				}
				smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
			}
			smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
		}
		smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
	}

	private void groundProperty8(Node node) {

		// property 8: no edges from a node to the same node
		boolean noSelfLoops = true;
		for (Edge outEdge : node.getEdgesAsSource()) {
			// same src and tgt
			if (outEdge.getTarget() == node) {
				smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdge.getFormulaVariable()));
				noSelfLoops = false;
			}
		}
		// true by construction
		if (noSelfLoops) {
			smtProperty += Z3Utils.SMTLIB_TRUE;
		}
	}

	private void groundProperty10(Node node) {

		// property 10: at least one incoming or outgoing edge per node
		// false by construction
		if ((node.getEdgesAsSource().size() + node.getEdgesAsTarget().size()) < 1) {
			smtProperty += Z3Utils.SMTLIB_FALSE;
			return;
		}
		// at least one edge
		smtProperty += Z3Utils.SMTLIB_OR;
		for (Edge outEdge : node.getEdgesAsSource()) {
			smtProperty += Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdge.getFormulaVariable());
		}
		for (Edge inEdge : node.getEdgesAsTarget()) {
			smtProperty += Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, inEdge.getFormulaVariable());
		}
		smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
	}

	private void generateSMTLIBGroundedProperty(Graph graph) {

		EList<Node> nodes = graph.getNodes();
		if (nodes.isEmpty()) {
			return;
		}

		smtProperty += Z3Utils.SMTLIB_AND;
		for (Node node : nodes) {
			smtProperty += '\n';
			switch (propertyId) {
				case 5:
					groundProperty5(node);
					break;
				case 6:
					groundProperty6(node);
					break;
				case 8:
					groundProperty8(node);
					break;
				case 10:
					groundProperty10(node);
					break;
			}
		}
		smtProperty += '\n' + Z3Utils.SMTLIB_PREDICATE_END;
	}

	private void doMAVOPropertyCheck() {

		long startTime = System.nanoTime();
		Z3ReasoningEngine z3 = (Z3ReasoningEngine) MMINT.getLanguageReasoners(Z3_LANGUAGE).get(Z3_NAME);
		resultMAVO = z3.checkMAVOConstraint(smtEncoding + Z3Utils.assertion(smtConcretizationsConstraint), smtProperty);
		long endTime = System.nanoTime();

		timeMAVO = endTime - startTime;
	}

	private void doClassicalPropertyCheck() {

		long startTime = System.nanoTime();
		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		Z3Result firstZ3Bool = null;
		z3IncSolver.firstCheckSatAndGetModel(smtEncoding);
		for (String smtConcretization : smtConcretizations) {
			Z3Model z3Model = z3IncSolver.checkSatAndGetModel(Z3Utils.assertion(smtConcretization) + Z3Utils.assertion(smtProperty), Z3IncrementalBehavior.POP);
			Z3Result z3Bool = z3Model.getZ3Result();
			if (firstZ3Bool == null) { // first run only
				firstZ3Bool = z3Bool;
			}
			if (z3Bool == Z3Result.UNKNOWN || z3Bool != firstZ3Bool) { // == result never changes
				break;
			}
		}
		long endTime = System.nanoTime();

		timeClassical = endTime - startTime;
	}

	private boolean optimizeBackboneCondition(Set<String> initialZ3ModelElemFormulaVars, Set<String> currentZ3ModelElemFormulaVars, String mayModelObjFormulaVar) {

		if (initialZ3ModelElemFormulaVars.contains(mayModelObjFormulaVar) != currentZ3ModelElemFormulaVars.contains(mayModelObjFormulaVar)) {
			return true;
		}
		return false;
	}

	private void optimizeBackbone(Set<String> initialZ3ModelElemFormulaVars, Set<String> currentZ3ModelElemFormulaVars, Set<String> outOfBackboneFormulaVars) {

		for (String mayModelObjFormulaVar : mayModelObjs.keySet()) {
			if (optimizeBackboneCondition(initialZ3ModelElemFormulaVars, currentZ3ModelElemFormulaVars, mayModelObjFormulaVar)) {
				outOfBackboneFormulaVars.add(mayModelObjFormulaVar);
			}
		}
	}

	private void doMAVOBackbonePropertyCheck() throws MMINTException {

		long startTime = System.nanoTime();
		Z3IncrementalSolver z3IncSolver = new Z3IncrementalSolver();
		Z3Model z3Model = z3IncSolver.firstCheckSatAndGetModel(smtEncoding + Z3Utils.assertion(smtConcretizationsConstraint) + Z3Utils.assertion(smtProperty));
		if (z3Model.getZ3Result() != Z3Result.SAT) {
			throw new MMINTException("MAVO Property checking was SAT but now backbone baseline is not.");
		}
		Set<String> initialZ3ModelElemFormulaVars = z3ModelParser.getZ3MAVOModelObjects(z3Model).values().stream()
			.flatMap(formulaVars -> formulaVars.stream())
			.collect(Collectors.toSet());
		Set<String> currentZ3ModelElemFormulaVars;
		Set<String> outOfBackboneFormulaVars = new HashSet<String>();
		for (MAVOElement mayModelObj : mayModelObjs.values()) {
			String mayModelObjFormulaVar = mayModelObj.getFormulaVariable();
			if (outOfBackboneFormulaVars.contains(mayModelObjFormulaVar)) { // optimization
				continue;
			}
			String mayModelObjFormula = Z3MAVOUtils.getSMTLIBMayModelObjectConstraint(mayModelObj, true, false);
			z3Model = z3IncSolver.checkSatAndGetModel(Z3Utils.assertion(mayModelObjFormula), Z3IncrementalBehavior.POP);
			if (z3Model.getZ3Result() != Z3Result.SAT) {
				continue;
			}
			currentZ3ModelElemFormulaVars = z3ModelParser.getZ3MAVOModelObjects(z3Model).values().stream()
				.flatMap(formulaVars -> formulaVars.stream())
				.collect(Collectors.toSet());
			optimizeBackbone(initialZ3ModelElemFormulaVars, currentZ3ModelElemFormulaVars, outOfBackboneFormulaVars);
			if (optimizeBackboneCondition(initialZ3ModelElemFormulaVars, currentZ3ModelElemFormulaVars, mayModelObjFormulaVar)) {
				continue;
			}
			z3Model = z3IncSolver.checkSatAndGetModel(Z3Utils.assertion(Z3Utils.not(mayModelObjFormula)), Z3IncrementalBehavior.POP);
			if (z3Model.getZ3Result() != Z3Result.SAT) {
				continue;
			}
			currentZ3ModelElemFormulaVars = z3ModelParser.getZ3MAVOModelObjects(z3Model).values().stream()
				.flatMap(formulaVars -> formulaVars.stream())
				.collect(Collectors.toSet());
			optimizeBackbone(initialZ3ModelElemFormulaVars, currentZ3ModelElemFormulaVars, outOfBackboneFormulaVars);
		}
		long endTime = System.nanoTime();

		timeMAVOBackbone = endTime - startTime;
	}

	private void doMAVOAllsatPropertyCheck(Graph rootMayModelObj) {

		Z3ReasoningEngine z3Reasoner;
		try {
			z3Reasoner = (Z3ReasoningEngine) MAVOMultiModelConstraintChecker.getMAVOReasoner("SMTLIB");
			long startTime = System.nanoTime();
			z3Reasoner.allSAT(
				smtEncoding + Z3Utils.assertion(smtConcretizationsConstraint) + Z3Utils.assertion(smtProperty),
				z3ModelParser,
				mayModelObjs,
				rootMayModelObj);
			timeMAVOAllsat = System.nanoTime() - startTime;
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.WARNING, "Can't find or run Z3 reasoner, skipping allsat", e);
			return;
		}
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		Model randomGraphModel = inputsByName.get(IN_MODEL);
		Graph rootMayModelObj = (Graph) randomGraphModel.getEMFInstanceRoot();

		// run
		generateSMTLIBConcretizations();
		generateSMTLIBGroundedProperty(rootMayModelObj);
		doMAVOPropertyCheck();
		if (timeClassicalEnabled) {
			doClassicalPropertyCheck();
			speedupClassicalMAVO = ((double) timeClassical) / timeMAVO;
		}
		if (resultMAVO == MAVOTruthValue.MAYBE) {
			if (timeMAVOBackboneEnabled) {
				doMAVOBackbonePropertyCheck();
			}
			if (timeMAVOAllsatEnabled) {
				doMAVOAllsatPropertyCheck(rootMayModelObj);
			}
			if (timeMAVOBackboneEnabled && timeMAVOAllsatEnabled) {
				speedupMAVOAllsatMAVOBackbone = ((double) timeMAVOAllsat) / timeMAVOBackbone;
			}
		}

		// output
		Properties outputProperties = new Properties();
		writeProperties(outputProperties);
		MultiModelOperatorUtils.writePropertiesFile(
			outputProperties,
			this,
			randomGraphModel,
			getInputSubdir(),
			MultiModelOperatorUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return new HashMap<>();
	}

}
