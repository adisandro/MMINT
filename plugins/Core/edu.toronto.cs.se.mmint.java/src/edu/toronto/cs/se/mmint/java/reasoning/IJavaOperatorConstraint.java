/**
 * Copyright (c) 2012-2021 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.java.reasoning;

import java.util.List;
import java.util.Map;

import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * The specification of an operator constraint written in Java.
 *
 * @author Alessio Di Sandro
 */
public interface IJavaOperatorConstraint {

  /**
   * Checks if this operator constraint allows a generic type.
   *
   * @param genericTypeEndpoint
   *          The generic type endpoint.
   * @param genericType
   *          The generic type.
   * @param inputs
   *          The list of inputs.
   * @return True if the generic type is allowed, false otherwise.
   */
	default boolean checkGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType,
	                             List<OperatorInput> inputs) {
		return true;
	}

  /**
   * Checks if this operator constraint allows a set of inputs.
   *
   * @param inputsByName
   *          The input model instances, identified by their formal parameter name.
   * @return True if the input models are allowed, false otherwise.
   */
	default boolean checkInputs(Map<String, Model> inputsByName) {
		return true;
	}

  /**
   * Gets the models that are constrained to be the endpoints of each output model relationships of an operator.
   *
   * @param genericsByName
   *          The generics, identified by their formal name.
   * @param inputsByName
   *          The input model instances, identified by their formal parameter name or workflow variable name.
   * @param outputsByName
   *          The output model instances, identified by their formal parameter name or workflow id.
   * @return A map of output model relationships and their endpoint models.
   */
	default Map<ModelRel, List<Model>> getOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
	                                                              Map<String, Model> inputsByName,
	                                                              Map<String, Model> outputsByName) {
	  //TODO MMINT[CONSTRAINT] Create a default method that just matches parameter names, which is what usually happens
		return Map.of();
	}

}
