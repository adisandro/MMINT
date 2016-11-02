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

import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.diagram.library.MIDDiagramUtils;
import edu.toronto.cs.se.mmint.mid.operator.OperatorGeneric;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.operator.impl.NestingOperatorImpl;
import edu.toronto.cs.se.mmint.mid.ui.GMFUtils;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.mmint.mid.utils.MIDOperatorIOUtils;
import edu.toronto.cs.se.modelepedia.primitive.boolean_.Boolean;

public abstract class ConditionalOperator extends NestingOperatorImpl {

	// input-output
	protected final static @NonNull String GENERIC_OPERATORTYPE = "CONDITION";
	protected final static @NonNull String IN_MODEL = "conditionModel";

	protected boolean evaluateCondition(@NonNull Model conditionModel, @NonNull BooleanExpression conditionExpression) throws Exception {

		// create shortcut to condition model
		//TODO MMINT[SCRIPTING] Add option to detect when the intermediate MID is enabled (WorkflowOperator too)
		//TODO MMINT[SCRIPTING] Make an operator input being selectable twice + find a way to highlight conditionModel
		//TODO MMINT[SCRIPTING] NestingOperator's deleteInstance should delete models of the nested MID
		MID instanceMID = this.getNestedInstanceMID();
		String instanceMIDPath = null, instanceMIDDiagramPath = null;
		View instanceMIDDiagramRoot = null;
		if (instanceMID != null) {
			instanceMIDPath = this.getNestedMIDPath();
			instanceMIDDiagramPath = instanceMIDPath + GMFUtils.DIAGRAM_SUFFIX;
			instanceMIDDiagramRoot = (View) FileUtils.readModelFile(instanceMIDDiagramPath, true);
			MIDDiagramUtils.createModelShortcut(conditionModel, instanceMIDDiagramRoot);
		}

		EList<Model> inputModels = new BasicEList<>();
		inputModels.add(conditionModel);
		EList<OperatorInput> expressionInputs = conditionExpression.checkAllowedInputs(inputModels);
		EList<OperatorGeneric> expressionGenerics = conditionExpression.selectAllowedGenerics(expressionInputs);
		Map<String, MID> expressionOutputMIDsByName = MIDOperatorIOUtils.createSimpleOutputMIDsByName(
			conditionExpression,
			instanceMID);
		Map<String, Model> expressionOutputsByName = conditionExpression.startInstance(
				expressionInputs,
				null,
				expressionGenerics,
				expressionOutputMIDsByName,
				instanceMID)
			.getOutputsByName();
		Model booleanModel = expressionOutputsByName.get(BooleanExpression.OUT_BOOLEAN);
		Boolean boolModelObj = (Boolean) booleanModel.getEMFInstanceRoot();

		if (instanceMID != null) {
			FileUtils.writeModelFile(instanceMID, instanceMIDPath, true);
			FileUtils.writeModelFile(instanceMIDDiagramRoot, instanceMIDDiagramPath, true);
		}

		return boolModelObj.isValue();
	}

}
