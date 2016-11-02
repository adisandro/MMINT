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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.MIDTypeHierarchy;
import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.MMINT;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MID;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.impl.OperatorImpl;
import edu.toronto.cs.se.mmint.mid.reasoning.MIDConstraintChecker;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.mid.utils.FileUtils;
import edu.toronto.cs.se.modelepedia.primitive.boolean_.Boolean;
import edu.toronto.cs.se.modelepedia.primitive.boolean_.BooleanFactory;

//TODO MMINT[SCRIPTING] Add and/or/not and chainers
public class BooleanExpression extends OperatorImpl {

	// input-output
	private final static @NonNull String GENERIC_MODELTYPE = "TYPE";
	private final static @NonNull String IN_MODEL = "model";
	public final static @NonNull String OUT_BOOLEAN = "boolean";
	// constants
	private final static @NonNull String BOOLEAN_MODELTYPE = "http://se.cs.toronto.edu/modelepedia/Boolean";
	private final static @NonNull String EXPRESSION_SEPARATOR = "_is_a_";
	private final static @NonNull String EXPRESSION_SUFFIX = "?";

	private @NonNull Boolean evaluate(@NonNull Model inputModel, @NonNull Model modelType) {

		boolean evaluation = false;
		// check constraint only if types match (Model and Model, or ModelRel and ModelRel)
		if ((inputModel instanceof ModelRel) == (modelType instanceof ModelRel)) {
			// check constraint
			if (
				MIDTypeHierarchy.instanceOf(inputModel, modelType.getUri(), false) &&
				MIDConstraintChecker.checkModelConstraint(inputModel, modelType.getConstraint())
			) {
				evaluation = true;
			}
		}
		Boolean boolModelObj = BooleanFactory.eINSTANCE.createBoolean();
		boolModelObj.setValue(evaluation);

		return boolModelObj;
	}

	@Override
	public Map<String, Model> run(
			Map<String, Model> inputsByName, Map<String, GenericElement> genericsByName,
			Map<String, MID> outputMIDsByName) throws Exception {

		// input
		Model inputModel = inputsByName.get(IN_MODEL);
		Model modelType = (Model) genericsByName.get(GENERIC_MODELTYPE);

		// evaluate boolean expression
		Boolean boolModelObj = this.evaluate(inputModel, modelType);

		// output
		Model boolModelType = MIDTypeRegistry.<Model>getType(BOOLEAN_MODELTYPE);
		String boolModelPath = FileUtils.replaceLastSegmentInPath(
			inputModel.getUri(),
			inputModel.getName() + EXPRESSION_SEPARATOR + modelType.getName() + MMINT.MODEL_FILEEXTENSION_SEPARATOR + boolModelType.getFileExtension());
		Model boolModel = boolModelType.createInstanceAndEditor(boolModelObj, boolModelPath, outputMIDsByName.get(OUT_BOOLEAN));
		boolModel.setName(boolModel.getName() + EXPRESSION_SUFFIX);
		Map<String, Model> outputsByName = new HashMap<>();
		outputsByName.put(OUT_BOOLEAN, boolModel);

		return outputsByName;
	}

}
