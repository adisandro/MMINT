/**
 * Copyright (c) 2012-2022 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
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

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mavo.MAVORoot;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mavo.library.MAVOUtils;
import edu.toronto.cs.se.mmint.mavo.reasoning.IMAVOTrait.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.RandomOperatorImpl;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.modelepedia.graph_mavo.Edge;
import edu.toronto.cs.se.modelepedia.graph_mavo.Graph;
import edu.toronto.cs.se.modelepedia.graph_mavo.Node;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver;
import edu.toronto.cs.se.modelepedia.z3.Z3IncrementalSolver.Z3IncrementalBehavior;
import edu.toronto.cs.se.modelepedia.z3.Z3Model;
import edu.toronto.cs.se.modelepedia.z3.Z3Model.Z3Result;
import edu.toronto.cs.se.modelepedia.z3.Z3Utils;
import edu.toronto.cs.se.modelepedia.z3.mavo.Z3MAVOModelParser;
import edu.toronto.cs.se.modelepedia.z3.reasoning.Z3Reasoner;
import edu.toronto.cs.se.modelepedia.z3.reasoning.Z3Reasoner.MAVOCheckStrategy;

public class TOSEM12 extends RandomOperatorImpl {

	// input-output
	private final static @NonNull String IN_MODEL = "model";
	private static final String PROPERTY_IN_NUMCONCRETIZATIONS = "numConcretizations";
	private static final String PROPERTY_IN_PROPERTYID = "propertyId";
	private static final String PROPERTY_OUT_TIMEMAVO = "timeMAVO";
	private static final String PROPERTY_OUT_TIMECLASSICAL = "timeClassical";
	private static final String PROPERTY_OUT_TIMEMAVOBACKBONE = "timeMAVOBackbone";
	private static final String PROPERTY_OUT_TIMEMAVOALLSAT = "timeMAVOAllsat";
	private static final String PROPERTY_OUT_SPEEDUPCLASSICALMAVO = "speedupClassicalMAVO";
	private static final String PROPERTY_OUT_SPEEDUPMAVOALLSATMAVOBACKBONE = "speedupMAVOAllsatMAVOBackbone";
	// constants
	private static final String Z3_LANGUAGE = "smt";

	// input
	private int numConcretizations;
	private int propertyId;
	private boolean timeClassicalEnabled;
	private boolean timeMAVOBackboneEnabled;
	private boolean timeMAVOAllsatEnabled;
	// state
	private Map<String, MAVOElement> mayModelObjs;
	private String smtEncoding;
	private String smtConcretizationsConstraint;
	private String smtProperty;
	private String smtEncodingAndConcretizations;
	private Set<String> smtConcretizations;
	Z3Reasoner z3Reasoner;
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
		this.numConcretizations = MIDOperatorIOUtils.getOptionalIntProperty(inputProperties, TOSEM12.PROPERTY_IN_NUMCONCRETIZATIONS, 1);
		this.propertyId = MIDOperatorIOUtils.getOptionalIntProperty(inputProperties, TOSEM12.PROPERTY_IN_PROPERTYID, 0);
		this.timeClassicalEnabled = MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, TOSEM12.PROPERTY_OUT_TIMECLASSICAL+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX, false);
		this.timeMAVOBackboneEnabled = MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, TOSEM12.PROPERTY_OUT_TIMEMAVOBACKBONE+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX, false);
		this.timeMAVOAllsatEnabled = MIDOperatorIOUtils.getOptionalBoolProperty(inputProperties, TOSEM12.PROPERTY_OUT_TIMEMAVOALLSAT+MIDOperatorIOUtils.PROP_OUTENABLED_SUFFIX, false);
	}

	private MAVORoot init(Model mayModel) throws Exception {

		// output
		this.timeMAVO = -1;
		this.timeClassical = -1;
		this.timeMAVOBackbone = -1;
		this.timeMAVOAllsat = -1;
		this.speedupClassicalMAVO = -1;
		this.speedupMAVOAllsatMAVOBackbone = -1;

		// state
    this.z3Reasoner = (Z3Reasoner) MMINT.getReasoner("Z3");
		this.z3ModelParser = this.z3Reasoner.generateSMTLIBEncoding(mayModel);
		this.smtEncoding = this.z3ModelParser.getSMTLIBEncoding();
		var rootMayModelObj = (MAVORoot) mayModel.getEMFInstanceRoot();
//		Operator previousOperator = getPreviousOperator(); // GenerateRandomGraphMAVO
		Operator previousOperator = null;
		if (previousOperator != null) {
			this.mayModelObjs = ((GenerateRandomGraphMAVO) previousOperator).getMAVOModelObjects();
			generateSMTLIBGroundedProperty((Graph) rootMayModelObj);
			generateRandomSMTLIBConcretizations();
			this.smtEncodingAndConcretizations = this.smtEncoding + Z3Utils.assertion(this.smtConcretizationsConstraint);
		}
		else {
			this.timeMAVOAllsatEnabled = true;
			this.mayModelObjs = MAVOUtils.getAnnotatedMAVOModelObjects(mayModel);
			this.smtProperty = mayModel.getConstraint().getImplementation();
			this.smtEncodingAndConcretizations = this.smtEncoding;
			generateAllsatSMTLIBConcretizations(rootMayModelObj);
		}

		return rootMayModelObj;
	}

	private void writeProperties(Properties properties) {

		properties.setProperty(TOSEM12.PROPERTY_OUT_TIMEMAVO, String.valueOf(this.timeMAVO));
		properties.setProperty(TOSEM12.PROPERTY_OUT_TIMECLASSICAL, String.valueOf(this.timeClassical));
		properties.setProperty(TOSEM12.PROPERTY_OUT_TIMEMAVOBACKBONE, String.valueOf(this.timeMAVOBackbone));
		properties.setProperty(TOSEM12.PROPERTY_OUT_TIMEMAVOALLSAT, String.valueOf(this.timeMAVOAllsat));
		properties.setProperty(TOSEM12.PROPERTY_OUT_SPEEDUPCLASSICALMAVO, String.valueOf(this.speedupClassicalMAVO));
		properties.setProperty(TOSEM12.PROPERTY_OUT_SPEEDUPMAVOALLSATMAVOBACKBONE, String.valueOf(this.speedupMAVOAllsatMAVOBackbone));
	}

	private String generateRandomSMTLIBConcretization() {

		var smtConcretization = "";
		Map<String, Boolean> wellFormedModelObjs = new HashMap<>();
		for (MAVOElement mayModelObj : this.mayModelObjs.values()) {
			var mayModelObjSmtEncoding = (mayModelObj instanceof Node) ?
				Z3Utils.predicate(Z3Utils.SMTLIB_NODE_FUNCTION, mayModelObj.getFormulaVariable()) :
				Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, mayModelObj.getFormulaVariable());
			var exists = wellFormedModelObjs.get(mayModelObjSmtEncoding);
			if (exists == null) {
				exists = this.state.nextBoolean();
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

	private void generateRandomSMTLIBConcretizations() throws MMINTException {

		var maxConcretizations = Math.round(Math.pow(2, this.mayModelObjs.size()));
		if (this.numConcretizations > maxConcretizations) {
			throw new MMINTException("numConcretizations (" + this.numConcretizations + ") > maxConcretizations (" + maxConcretizations + ")");
		}
		if (maxConcretizations <= 1) {
			return;
		}

		//TODO MMINT[TOSEM] add heuristics to detect large number of concretizations (when it's more efficient to generate them all and then cut some)
		this.smtConcretizations = new HashSet<>();
		this.smtConcretizationsConstraint = "";
		for (var i = 0; i < this.numConcretizations; i++) {
			var smtConcretization = generateRandomSMTLIBConcretization();
			if (this.smtConcretizations.contains(smtConcretization)) { // duplicate
				i--;
				continue;
			}
			this.smtConcretizations.add(smtConcretization);
			this.smtConcretizationsConstraint += smtConcretization + '\n';
		}
		this.smtConcretizationsConstraint = Z3Utils.or(this.smtConcretizationsConstraint);
	}

	private void generateAllsatSMTLIBConcretizations(MAVORoot rootMayModelObj) {

		this.smtConcretizations = doMAVOAllsat(rootMayModelObj);
		this.smtConcretizationsConstraint = Z3Utils.or(String.join(" ", this.smtConcretizations));
	}

	private void groundProperty5(Node node) {

		// property 5: at most one outgoing edge per node
		// true by construction
		if (node.getEdgesAsSource().size() <= 1) {
			this.smtProperty += Z3Utils.SMTLIB_TRUE;
			return;
		}
		this.smtProperty += Z3Utils.SMTLIB_OR;
		// no edges
		this.smtProperty += Z3Utils.SMTLIB_AND;
		for (Edge outEdge : node.getEdgesAsSource()) {
			this.smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdge.getFormulaVariable()));
		}
		this.smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
		// one edge only
		for (Edge outEdgeI : node.getEdgesAsSource()) {
			this.smtProperty += Z3Utils.SMTLIB_AND + Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdgeI.getFormulaVariable());
			for (Edge outEdgeJ : node.getEdgesAsSource()) {
				if (outEdgeI == outEdgeJ) {
					continue;
				}
				this.smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdgeJ.getFormulaVariable()));
			}
			this.smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
		}
		this.smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
	}

	private void groundProperty6(Node node) {

		// property 6: not more than one edge from a node to another
		// true by construction
		if (node.getEdgesAsSource().size() <= 1) {
			this.smtProperty += Z3Utils.SMTLIB_TRUE;
			return;
		}
		this.smtProperty += Z3Utils.SMTLIB_AND;
		// construct map of target nodes
		Map<Node, List<Edge>> tgtNode2EdgesMap = new HashMap<>();
		for (Edge outEdge : node.getEdgesAsSource()) {
			var tgtNode2Edges = tgtNode2EdgesMap.get(outEdge.getTarget());
			if (tgtNode2Edges == null) {
				tgtNode2Edges = new ArrayList<>();
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
				this.smtProperty += Z3Utils.SMTLIB_TRUE;
				continue;
			}
			this.smtProperty += Z3Utils.SMTLIB_OR;
			// no edges
			this.smtProperty += Z3Utils.SMTLIB_AND;
			for (Edge outEdge : tgtNode2Edges) {
				this.smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdge.getFormulaVariable()));
			}
			this.smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
			// one edge only
			for (Edge outEdgeI : tgtNode2Edges) {
				this.smtProperty += Z3Utils.SMTLIB_AND + Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdgeI.getFormulaVariable());
				for (Edge outEdgeJ : tgtNode2Edges) {
					if (outEdgeI == outEdgeJ) {
						continue;
					}
					this.smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdgeJ.getFormulaVariable()));
				}
				this.smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
			}
			this.smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
		}
		this.smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
	}

	private void groundProperty8(Node node) {

		// property 8: no edges from a node to the same node
		var noSelfLoops = true;
		for (Edge outEdge : node.getEdgesAsSource()) {
			// same src and tgt
			if (outEdge.getTarget() == node) {
				this.smtProperty += Z3Utils.not(Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdge.getFormulaVariable()));
				noSelfLoops = false;
			}
		}
		// true by construction
		if (noSelfLoops) {
			this.smtProperty += Z3Utils.SMTLIB_TRUE;
		}
	}

	private void groundProperty10(Node node) {

		// property 10: at least one incoming or outgoing edge per node
		// false by construction
		if ((node.getEdgesAsSource().size() + node.getEdgesAsTarget().size()) < 1) {
			this.smtProperty += Z3Utils.SMTLIB_FALSE;
			return;
		}
		// at least one edge
		this.smtProperty += Z3Utils.SMTLIB_OR;
		for (Edge outEdge : node.getEdgesAsSource()) {
			this.smtProperty += Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, outEdge.getFormulaVariable());
		}
		for (Edge inEdge : node.getEdgesAsTarget()) {
			this.smtProperty += Z3Utils.predicate(Z3Utils.SMTLIB_EDGE_FUNCTION, inEdge.getFormulaVariable());
		}
		this.smtProperty += Z3Utils.SMTLIB_PREDICATE_END;
	}

	private void generateSMTLIBGroundedProperty(Graph graph) {

		var nodes = graph.getNodes();
		if (nodes.isEmpty()) {
			return;
		}

		this.smtProperty = Z3Utils.SMTLIB_AND;
		for (Node node : nodes) {
			this.smtProperty += '\n';
			switch (this.propertyId) {
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
		this.smtProperty += '\n' + Z3Utils.SMTLIB_PREDICATE_END;
	}

	private MAVOTruthValue doMAVOPropertyCheck() {

		var startTime = System.nanoTime();
		MAVOTruthValue resultMAVO = this.z3Reasoner.checkMAVOConstraint(this.smtEncodingAndConcretizations, "", this.smtProperty, MAVOCheckStrategy.DOUBLE_CHECK);
		this.timeMAVO = System.nanoTime() - startTime;

		return resultMAVO;
	}

	private void doClassicalPropertyCheck() {

		var startTime = System.nanoTime();
		var z3IncSolver = new Z3IncrementalSolver();
		Z3Result firstZ3Bool = null;
		z3IncSolver.firstCheckSatAndGetModel(this.smtEncoding);
		for (String smtConcretization : this.smtConcretizations) {
			Z3Model z3Model = z3IncSolver.checkSatAndGetModel(Z3Utils.assertion(smtConcretization) + Z3Utils.assertion(this.smtProperty), Z3IncrementalBehavior.POP);
			var z3Bool = z3Model.getZ3Result();
			if (firstZ3Bool == null) { // first run only
				firstZ3Bool = z3Bool;
			}
			if (z3Bool == Z3Result.UNKNOWN || z3Bool != firstZ3Bool) { // == result never changes
				break;
			}
		}
		this.timeClassical = System.nanoTime() - startTime;
	}

	private void doMAVOBackbone() throws MMINTException {

		var startTime = System.nanoTime();
		this.z3Reasoner.mayBackbone(
			this.smtEncodingAndConcretizations + Z3Utils.assertion(this.smtProperty),
			this.z3ModelParser,
			new HashSet<>(this.mayModelObjs.values()));
		this.timeMAVOBackbone = System.nanoTime() - startTime;
	}

	private Set<String> doMAVOAllsat(MAVORoot rootMayModelObj) {

		var startTime = System.nanoTime();
		var smtConcretizations = this.z3Reasoner.allSAT(
			this.smtEncodingAndConcretizations + Z3Utils.assertion(this.smtProperty),
			this.z3ModelParser,
			new HashSet<>(this.mayModelObjs.values()),
			rootMayModelObj);
		this.timeMAVOAllsat = System.nanoTime() - startTime;

		return smtConcretizations;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		var mayModel = inputsByName.get(TOSEM12.IN_MODEL);
		var rootMayModelObj = this.init(mayModel);

		// run
		var resultMAVO = doMAVOPropertyCheck();
		if (this.timeClassicalEnabled) {
			doClassicalPropertyCheck();
			this.speedupClassicalMAVO = ((double) this.timeClassical) / this.timeMAVO;
		}
		if (resultMAVO == MAVOTruthValue.MAYBE) {
			if (this.timeMAVOBackboneEnabled) {
				doMAVOBackbone();
			}
			if (this.timeMAVOAllsatEnabled) {
				doMAVOAllsat(rootMayModelObj);
			}
			if (this.timeMAVOBackboneEnabled && this.timeMAVOAllsatEnabled) {
				this.speedupMAVOAllsatMAVOBackbone = ((double) this.timeMAVOAllsat) / this.timeMAVOBackbone;
			}
		}

		// output
		var outputProperties = new Properties();
		writeProperties(outputProperties);
		MIDOperatorIOUtils.writePropertiesFile(
			outputProperties,
			this,
			mayModel,
			getWorkingPath(),
			MIDOperatorIOUtils.OUTPUT_PROPERTIES_SUFFIX
		);

		return new HashMap<>();
	}

}
