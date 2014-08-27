package edu.toronto.cs.se.modelepedia.z3.reasoning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import edu.toronto.cs.se.mavo.MAVOElement;
import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.ui.GMFDiagramUtils;
import edu.toronto.cs.se.modelepedia.graph_mavo.impl.GraphImpl;
import edu.toronto.cs.se.modelepedia.z3.Z3SMTUtils;
import edu.toronto.cs.se.modelepedia.z3.mavo.EcoreMAVOToSMTLIB;

public class MAVORefinement {

	private static final String DIAGRAM_ID = "edu.toronto.cs.se.modelepedia.graph_mavo.diagram.part.Graph_MAVODiagramEditorID";
	private final static String ECOREMAVOTOSMTLIB_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EcoreMAVOToSMTLIB";

	private String smtProperty;
	private String smtEncoding;
	private String newDiagramURI;
	private Model model;
	private String newModelURI;

	public MAVORefinement(Model model) {
		EcoreMAVOToSMTLIB ecore2smt = (EcoreMAVOToSMTLIB) MultiModelTypeRegistry
				.<Operator> getType(ECOREMAVOTOSMTLIB_OPERATOR_URI);
		EList<Model> actualParameters = new BasicEList<Model>();
		actualParameters.add(model);
		try {
			ecore2smt.execute(actualParameters);
		} catch (Exception e) {
			MMINTException.print(MMINTException.Type.ERROR,
					"Can't generate SMTLIB encoding, evaluating to false", e);
		}
		ecore2smt.cleanup();

		this.smtEncoding = ecore2smt.getListener().getSMTLIBEncoding();
		this.model = model;
	}

	public void refine() throws Exception {
		smtProperty = model.getConstraint().getImplementation();
		MAVOTruthValue resultMAVO = Z3SMTReasoningEngine.checkMAVOProperty(
				smtEncoding, smtProperty);

		if (resultMAVO != MAVOTruthValue.MAYBE) {
			return;
		}
		
		GraphImpl graph = copyAndLoadModel(model);

		Map<String, MAVOTruthValue> refinedElements = runZ3SMTSolver(graph);
		refineModel(graph, refinedElements);

		// Write diagram to file
		MultiModelUtils.createModelFile(graph, newModelURI, true);
		GMFDiagramUtils.createGMFDiagram(newModelURI, newDiagramURI, model.getName(), DIAGRAM_ID);
		GMFDiagramUtils.openGMFDiagram(newDiagramURI, DIAGRAM_ID, true);
	}

	private void refineModel(GraphImpl graph, Map<String, MAVOTruthValue> refinedModel) {
		List<MAVOElement> nodes = new ArrayList<MAVOElement>(graph.getNodes());
		for (MAVOElement node : nodes) {
			MAVOTruthValue truthValue = refinedModel.get(node.getFormulaVariable());
			if (truthValue == MAVOTruthValue.MAYBE) {
				node.setMay(true);
			} else if (truthValue == MAVOTruthValue.TRUE) {
				node.setMay(false);
			} else if (truthValue == MAVOTruthValue.FALSE) {
				graph.getNodes().remove(node);
			}
		}
		List<MAVOElement> edges = new ArrayList<MAVOElement>(graph.getEdges());
		for (MAVOElement edge : edges) {
			MAVOTruthValue truthValue = refinedModel.get(edge.getFormulaVariable());
			if (truthValue == MAVOTruthValue.MAYBE) {
				edge.setMay(true);
			} else if (truthValue == MAVOTruthValue.TRUE) {
				edge.setMay(false);
			} else if (truthValue == MAVOTruthValue.FALSE) {
				graph.getEdges().remove(edge);
			}
		}

	}

	private GraphImpl copyAndLoadModel(Model model)
			throws MMINTException {

		String diagramURI = MultiModelUtils.replaceFileExtensionInUri(
				model.getUri(), "graphdiag_mavo");

		String modelURI = MultiModelUtils.replaceFileExtensionInUri(
				model.getUri(), "graph_mavo");

		String suffix = "_refined";

		newModelURI = MultiModelUtils.addFileNameSuffixInUri(modelURI, suffix);
		newDiagramURI = MultiModelUtils.addFileNameSuffixInUri(diagramURI,
				suffix);

		try {
			MultiModelUtils.copyTextFileAndReplaceText(modelURI, newModelURI, "", "", true);
			/*MultiModelUtils.copyTextFileAndReplaceText(diagramURI,
					newDiagramURI,
					MultiModelUtils.getLastSegmentFromUri(modelURI),
					MultiModelUtils.getLastSegmentFromUri(newModelURI), true);*/
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		GraphImpl graph;
		try {
			graph = (GraphImpl) MultiModelUtils.getModelFile(newModelURI, true);
		} catch (Exception e) {
			throw new MMINTException("There is no model!", e);
		}
		return graph;
	}

	private Map<String, MAVOTruthValue> runZ3SMTSolver(GraphImpl graph) {
		Map<String, MAVOTruthValue> refinedModel = new HashMap<String, MAVOTruthValue>();
		String encodingWithProperty = smtEncoding
				+ Z3SMTUtils.assertion(smtProperty);
		for (MAVOElement node : graph.getNodes()) {
			String elementFormula = Z3SMTUtils.predicate(
					Z3SMTUtils.SMTLIB_NODE_FUNCTION, node.getFormulaVariable());
			MAVOTruthValue newTruthValue = Z3SMTReasoningEngine
					.checkMAVOProperty(encodingWithProperty, elementFormula);
			refinedModel.put(node.getFormulaVariable(), newTruthValue);
		}
		for (MAVOElement edge : graph.getEdges()) {
			String elementFormula = Z3SMTUtils.predicate(
					Z3SMTUtils.SMTLIB_EDGE_FUNCTION, edge.getFormulaVariable());
			MAVOTruthValue newTruthValue = Z3SMTReasoningEngine
					.checkMAVOProperty(encodingWithProperty, elementFormula);
			refinedModel.put(edge.getFormulaVariable(), newTruthValue);
		}
		return refinedModel;
	}

}
