/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.operator.flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.WorkflowOperator;
import edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl;
import edu.toronto.cs.se.modelepedia.primitive.boolean_.Boolean;

public abstract class ConditionalOperator extends NestingOperatorImpl {

	// input-output
	protected final static @NonNull String GENERIC_OPERATORTYPE = "CONDITION";
	protected final static @NonNull String IN_MODEL = "conditionModel";
	protected final static @NonNull String IN_MODELS = "blockInModels";
	protected final static @NonNull String OUT_MODELS = "blockOutModels";

	protected boolean evaluateCondition(@NonNull Model conditionModel, @NonNull BooleanExpression condition) throws Exception {

		EList<Model> inputModels = new BasicEList<>();
		inputModels.add(conditionModel);
		EList<OperatorInput> inputs = condition.checkAllowedInputs(inputModels);
		EList<OperatorGeneric> generics = condition.selectAllowedGenerics(inputs);
		Map<String, Model> conditionOutputsByName = super.startNestedInstance(condition, inputs, null, generics, null).getOutputsByName();
		Model booleanModel = conditionOutputsByName.get(BooleanExpression.OUT_BOOLEAN);
		Boolean boolModelObj = (Boolean) booleanModel.getEMFInstanceRoot();

		return boolModelObj.isValue();
	}

	protected List<Model> runBlock(List<Model> blockInputModels, WorkflowOperator block) throws Exception {

		EList<Model> inputModels = new BasicEList<>(blockInputModels);
		EList<OperatorInput> inputs = block.checkAllowedInputs(inputModels);
		EList<OperatorGeneric> generics = block.selectAllowedGenerics(inputs);
		Map<String, MID> outputMIDsByName = null; //TODO bring the outputs back into the main MID
		Map<String, Model> blockOutputsByName = super.startNestedInstance(block, inputs, null, generics, outputMIDsByName).getOutputsByName();
		/*TODO:
		 * 1) Check that the block workflow operator is compatible with the blockInputModels at creation time
		 * 3) Refactor plugin.xml signatures
		 * 4) Allow creation of block workflow on the fly
		 * 5) Create empty workflow for an empty else clause
		 */

		return new ArrayList<>(blockOutputsByName.values());
	}

}
