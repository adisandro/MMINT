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
package edu.toronto.cs.se.modelepedia.operator.merge;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.modelepedia.operator.match.EMFModelMatch;

public class EMFModelMerge extends OperatorImpl {

	// input-output
	private final static @NonNull String IN_MODELREL = "match";
	private final static @NonNull String OUT_MODEL = "merged";
	private final static @NonNull String OUT_MODELREL1 = "trace1";
	private final static @NonNull String OUT_MODELREL2 = "trace2";
	// constants
	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelMatch";
	private static final String MERGED_MODEL_NAME_SEPARATOR = "+";

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MultiModel> outputMIDsByName) throws Exception {

		// input
		ModelRel matchRel = (ModelRel) inputsByName.get(IN_MODELREL);
		Model model1 = matchRel.getModelEndpoints().get(0).getTarget();
		Model model2 = matchRel.getModelEndpoints().get(1).getTarget();

		// get output from previous operator
		EMFModelMatch previousOperator = (getPreviousOperator() == null) ?
			(EMFModelMatch) MultiModelTypeRegistry.<Operator>getType(PREVIOUS_OPERATOR_URI) :
			(EMFModelMatch) getPreviousOperator();
		IComparisonScope scope = previousOperator.getScope();
		Comparison comparison = previousOperator.getComparison();

		// create mergedModel
		IMerger.Registry registry = EMFCompareRCPPlugin.getDefault().getMergerRegistry();
		for (Diff diff : comparison.getDifferences()) {
			if (diff.getKind() == DifferenceKind.ADD) {
				registry.getHighestRankingMerger(diff).copyLeftToRight(diff, new BasicMonitor());
			}
		}
		String mergedModelUri = MultiModelUtils.replaceFileNameInUri(model1.getUri(), model1.getName() + MERGED_MODEL_NAME_SEPARATOR + model2.getName());
		MultiModelUtils.createModelFile(((ResourceSet) scope.getRight()).getResources().get(0).getContents().get(0), mergedModelUri, true);
		Model mergedModel = (isUpdateMID()) ?
			model1.getMetatype().createMAVOInstanceAndEditor(mergedModelUri, ModelOrigin.CREATED, outputMIDsByName.get(OUT_MODEL)) :
			model1.getMetatype().createMAVOInstance(mergedModelUri, ModelOrigin.CREATED, null);

		// run name match to create src and tgt match relationships
		Map<String, Model> matchInputsByName1 = new HashMap<>();
		matchInputsByName1.put(EMFModelMatch.IN_MODEL1, model1);
		matchInputsByName1.put(EMFModelMatch.IN_MODEL2, mergedModel);
		Map<String, MultiModel> matchOutputMIDsByName1 = new HashMap<>();
		matchOutputMIDsByName1.put(EMFModelMatch.OUT_MODELREL, outputMIDsByName.get(OUT_MODELREL1));
		Map<String, Model> matchOutputsByName1 = previousOperator.run(matchInputsByName1, new HashMap<>(), matchOutputMIDsByName1);
		matchOutputsByName1.get(EMFModelMatch.OUT_MODELREL).setName(OUT_MODELREL1);
		Map<String, Model> matchInputsByName2 = new HashMap<>();
		matchInputsByName2.put(EMFModelMatch.IN_MODEL1, model1);
		matchInputsByName2.put(EMFModelMatch.IN_MODEL2, mergedModel);
		Map<String, MultiModel> matchOutputMIDsByName2 = new HashMap<>();
		matchOutputMIDsByName2.put(EMFModelMatch.OUT_MODELREL, outputMIDsByName.get(OUT_MODELREL1));
		Map<String, Model> matchOutputsByName2 = previousOperator.run(matchInputsByName2, new HashMap<>(), matchOutputMIDsByName2);
		matchOutputsByName2.get(EMFModelMatch.OUT_MODELREL).setName(OUT_MODELREL2);

		// output
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_MODEL, mergedModel);
		outputsByName.put(OUT_MODELREL1, matchOutputsByName1.get(EMFModelMatch.OUT_MODELREL));
		outputsByName.put(OUT_MODELREL2, matchOutputsByName2.get(EMFModelMatch.OUT_MODELREL));

		return outputsByName;
	}

}
