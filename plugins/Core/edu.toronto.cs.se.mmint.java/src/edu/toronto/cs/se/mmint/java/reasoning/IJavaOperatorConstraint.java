/**
 * Copyright (c) 2012-2017 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.java.reasoning;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.annotation.NonNull;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public interface IJavaOperatorConstraint {

	/**
	 * Checks if a generic type is allowed for this operator type. Must be overridden if there are cases when formal
	 * generic parameter compliance alone
	 * ({@link edu.toronto.cs.se.mmint.mid.operator.Operator#selectAllowedGenerics(EList)}) is not enough.
	 * 
	 * @param genericTypeEndpoint
	 *            The generic type endpoint.
	 * @param genericType
	 *            The generic type.
	 * @param inputs
	 *            The list of inputs.
	 * @return True if the generic is allowed, false otherwise.
	 */
	public boolean isAllowedGeneric(@NonNull GenericEndpoint genericTypeEndpoint, @NonNull GenericElement genericType, @NonNull List<OperatorInput> inputs);

	/**
	 * Checks if the input models, already individually validated as actual parameters, are allowed by an operator type.
	 * This is meant to check that the input models as a whole are valid, if there are cases when formal parameter
	 * compliance alone ({@link edu.toronto.cs.se.mmint.mid.operator.Operator#checkAllowedInputs(EList)}) is not enough.
	 * 
	 * @param inputsByName
	 *            The input model instances, identified by their formal parameter name.
	 * @return True if the input models are allowed, false otherwise.
	 */
	public boolean isAllowedInput(@NonNull Map<String, Model> inputsByName);

	/**
	 * Gets the models that should be the endpoints for each output model relationship of an operator instance. This is
	 * used to create the model endpoints of model relationship outputs when creating a workflow, or to validate that
	 * the model relationship outputs of an operator instance are valid after running it.
	 * 
	 * @param inputsByName
	 *            The input model instances, identified by their formal parameter name or workflow variable name.
	 * @param outputsByName
	 *            The output model instances, identified by their formal parameter name or workflow id.
	 * @return A map of output model relationships and their endpoint models.
	 */
	//TODO MMINT[CONSTRAINT] Create a default method that just matches parameter names, which is what usually happens
	public @NonNull Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(@NonNull Map<String, Model> inputsByName, @NonNull Map<String, Model> outputsByName);

}
