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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.rcp.EMFCompareRCPPlugin;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.resource.ResourceSet;

import edu.toronto.cs.se.mmint.MultiModelTypeRegistry;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.ModelOrigin;
import edu.toronto.cs.se.mmint.mid.MultiModel;
import edu.toronto.cs.se.mmint.mid.library.MultiModelRegistry;
import edu.toronto.cs.se.mmint.mid.library.MultiModelUtils;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.modelepedia.operator.match.EMFModelMatch;

public class EMFModelMerge extends OperatorImpl {

	private static final String PREVIOUS_OPERATOR_URI = "http://se.cs.toronto.edu/modelepedia/Operator_EMFModelNameMatch";
	private static final String MERGED_MODEL_NAME_SEPARATOR = "+";
	private final static String SRC_MODELREL_NAME = "srcMatch";
	private final static String TGT_MODELREL_NAME = "tgtMatch";

	@Override
	public EList<Model> execute(EList<Model> actualParameters) throws Exception {

		Model srcModel = actualParameters.get(0);
		Model tgtModel = actualParameters.get(2);
		MultiModel multiModel = MultiModelRegistry.getMultiModel(srcModel);

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
		String mergedModelUri = MultiModelUtils.replaceFileNameInUri(srcModel.getUri(), srcModel.getName() + MERGED_MODEL_NAME_SEPARATOR + tgtModel.getName());
		MultiModelUtils.createModelFile(((ResourceSet) scope.getRight()).getResources().get(0).getContents().get(0), mergedModelUri, true);
		Model mergedModel = (isUpdateMID()) ?
			srcModel.getMetatype().createMAVOInstanceAndEditor(mergedModelUri, ModelOrigin.CREATED, multiModel) :
			srcModel.getMetatype().createMAVOInstance(mergedModelUri, ModelOrigin.CREATED, null);

		// run name match to create src and tgt match relationships
		EList<Model> result = new BasicEList<Model>();
		result.add(mergedModel);
		EList<Model> matchInput = new BasicEList<Model>();
		matchInput.add(srcModel);
		matchInput.add(mergedModel);
		EList<Model> matchOutput = previousOperator.execute(matchInput);
		matchOutput.get(0).setName(SRC_MODELREL_NAME);
		result.add(matchOutput.get(0));
		matchInput.set(0, tgtModel);
		matchOutput = previousOperator.execute(matchInput);
		matchOutput.get(0).setName(TGT_MODELREL_NAME);
		result.add(matchOutput.get(0));

		return result;
	}

}
