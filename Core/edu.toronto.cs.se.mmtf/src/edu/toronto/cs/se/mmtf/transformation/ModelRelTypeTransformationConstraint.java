/**
 * Copyright (c) 2012-2014 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.transformation;

import java.util.HashMap;

import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.constraint.JavaModelConstraint;
import edu.toronto.cs.se.mmtf.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmtf.mid.operator.ConversionOperator;
import edu.toronto.cs.se.mmtf.mid.operator.OperatorFactory;
import edu.toronto.cs.se.mmtf.mid.relationship.BinaryModelRel;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.reasoning.Z3SMTUtils.MAVOTruthValue;

public class ModelRelTypeTransformationConstraint extends JavaModelConstraint {

	private final static String OPERATOR_NAME = "ModelRelTypeTransformation";

	public ModelRelTypeTransformationConstraint(Model model) {

		super(model);
	}

	@Override
	public MAVOTruthValue validate() {

		ModelRel modelRelType = (ModelRel) model;
		if (modelRelType.getModelEndpointRefs().size() != 2) {
			return MAVOTruthValue.FALSE;
		}

		return MAVOTruthValue.TRUE;
	}

	public ConversionOperator getConversionOperator(Model modelType) {

		ModelRel modelRelType = (ModelRel) model;
		ConversionOperator operator = null;
		boolean ok = MultiModelConstraintChecker.isAllowedModelEndpoint(modelRelType.getModelEndpointRefs().get(0), modelType, new HashMap<String, Integer>());
		if (!(modelRelType instanceof BinaryModelRel)) {
			ok = ok || MultiModelConstraintChecker.isAllowedModelEndpoint(modelRelType.getModelEndpointRefs().get(1), modelType, new HashMap<String, Integer>());
		}
		if (ok) {
			operator = OperatorFactory.eINSTANCE.createConversionOperator();
			operator.setName(OPERATOR_NAME + "(" + modelRelType.getName() + ")");
			operator.setExecutable(new ModelRelTypeTransformation());
		}

		return operator;
	}

}
