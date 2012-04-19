package edu.toronto.cs.se.mmtf.xt.graph.operator;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.MMTFException;
import edu.toronto.cs.se.mmtf.repository.IOperator;
import edu.toronto.cs.se.mmtf.xt.graph.Graph;
import edu.toronto.cs.se.mmtf.xt.graph.Node;

public class NodeNameMatch implements IOperator {

	@Override
	public EObject[] invoke(EObject[] parameters) throws MMTFException {

		Graph graph;
		HashMap<String, ArrayList<Node>> nodeNames = new HashMap<String, ArrayList<Node>>();
		ArrayList<Node> nodes;

		for (EObject param : parameters) {

			if (!(param instanceof Graph)) {
				throw new MMTFException("Operator parameter is not a graph");
			}
			graph = (Graph) param;

			for (Node node : graph.getNodes()) {
				nodes = nodeNames.get(node.getName());
				if (nodes == null) {
					nodes = new ArrayList<Node>();
					nodeNames.put(node.getName(), nodes);
				}
				nodes.add(node);
			}
		}

		//TODO MMTF: scorrere la hashmap, quando il vettore è più lungo di 1 allora devo creare un mapping da ritornare

		return null;
	}

}
