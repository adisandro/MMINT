package edu.toronto.cs.se.modelepedia.operator.slice;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class Slice extends OperatorImpl {

	protected final static @NonNull String IN_MODELREL = "criterion";
	protected final static @NonNull String OUT_MODELREL = "slice";

	protected ModelRel slice(ModelRel critRel, MID outputMID) throws MMINTException {

		Model model = critRel.getModelEndpoints().get(0).getTarget();
		ModelRel sliceRel = critRel.getMetatype().createInstanceAndEndpoints(null, OUT_MODELREL, ECollections.newBasicEList(model), outputMID);
		//TODO MMINT[MODELS17] The following is just an example of how to create a model element reference
		EObject modelRootObj = model.getEMFInstanceRoot();
		sliceRel.getModelEndpointRefs().get(0).createModelElementInstanceAndReference(modelRootObj, null);

		return sliceRel;
	}

	@Override
	public Map<String, Model> run(Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		ModelRel critRel = (ModelRel) inputsByName.get(IN_MODELREL);
		MID outputMID = outputMIDsByName.get(OUT_MODELREL);

		// create the slice from the initial criterion and the rules
		ModelRel sliceRel = this.slice(critRel, outputMID);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODELREL, sliceRel);

		return outputsByName;
	}

}
