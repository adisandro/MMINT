/**
 * Copyright (c) 2012-2019 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmint.mid.reasoning;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.Nullable;

import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public interface IReasoningEngine {

	public default boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel) {

		return true;
	}

	public default boolean checkOperatorGenericConstraint(ExtendibleElementConstraint constraint, GenericEndpoint genericTypeEndpoint, GenericElement genericType, List<OperatorInput> inputs) {

		return true;
	}

	public default boolean checkOperatorInputConstraint(ExtendibleElementConstraint constraint, Map<String, Model> inputsByName) {

		return true;
	}

	public default Map<ModelRel, List<Model>> getOperatorOutputConstraints(ExtendibleElementConstraint constraint, Map<String, Model> inputsByName, Map<String, Model> outputsByName) {

		return new HashMap<>();
	}

	public default boolean checkModelConstraintConsistency(Model modelType, String constraint) {

		return true;
	}

	//TODO MMINT[REFINE] Is this really for all models? == Can I refine a model based on a false property, to make it true?
	public default @Nullable Model refineModelByConstraint(Model model) {

		return null;
	}

  /**
   * Evaluates a query to find elements within a megamodel.
   *
   * @param queryFilePath
   *          The path to the query file.
   * @param queryName
   *          The name of the query to be evaluated (a query file can contain multiple queries).
   * @param context
   *          The context where the query is executed, i.e. a megamodel, or one of its contained elements.
   * @param queryArgs
   *          The actual arguments to the query.
   * @return A list of megamodel elements that match the query.
   */
  public default List<Object> evaluateQuery(String queryFilePath, String queryName, EObject context,
                                            List<? extends EObject> queryArgs) {
    //TODO MMINT[QUERY] Think about a proper return interface to receive inputs and outputs (because of unbound vars)
    return List.of();
  }

}
