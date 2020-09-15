/**
 * Copyright (c) 2012-2020 Alessio Di Sandro, Marsha Chechik.
 * All rights reserved. This program and the accompanying materials are made available under the terms
 * of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Alessio Di Sandro - Implementation
 */
package edu.toronto.cs.se.mmint.java.reasoning;

import java.util.HashMap;
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
   * Checks this operator constraint.
   * @param genericTypeEndpoint
   * @param genericType
   * @param inputs
   * @return True if the generic type is allowed, false otherwise.
   */
	default boolean isAllowedGeneric(GenericEndpoint genericTypeEndpoint, GenericElement genericType,
	                                 List<OperatorInput> inputs) {
		return true;
	}

	default boolean isAllowedInput(Map<String, Model> inputsByName) {
		return true;
	}

	//TODO MMINT[CONSTRAINT] Create a default method that just matches parameter names, which is what usually happens
	default Map<ModelRel, List<Model>> getAllowedOutputModelRelEndpoints(Map<String, GenericElement> genericsByName,
	                                                                     Map<String, Model> inputsByName,
	                                                                     Map<String, Model> outputsByName) {
		return new HashMap<>();
	}

}
