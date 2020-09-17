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

import java.util.List;
import java.util.Map;

import edu.toronto.cs.se.mmint.MIDTypeRegistry;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.GenericElement;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.operator.GenericEndpoint;
import edu.toronto.cs.se.mmint.mid.operator.Operator;
import edu.toronto.cs.se.mmint.mid.operator.OperatorInput;
import edu.toronto.cs.se.mmint.mid.reasoning.IModelConstraintTrait;
import edu.toronto.cs.se.mmint.mid.reasoning.IOperatorConstraintTrait;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

/**
 * A reasoner implementation to check model and operator constraints written in Java.
 *
 * A model constraint class should extend the {@link edu.toronto.cs.se.mmint.java.reasoning.IJavaModelConstraint}
 * interface, while an operator constraint class should extend the
 * {@link edu.toronto.cs.se.mmint.java.reasoning.IJavaOperatorConstraint} interface.
 *
 * @author Alessio Di Sandro
 */
public class JavaReasoner implements IModelConstraintTrait, IOperatorConstraintTrait {

	private Object getJavaConstraint(String javaClassName, String typeUri) throws Exception {
		Object javaConstraint = MIDTypeRegistry.getTypeBundle(typeUri)
		  .loadClass(javaClassName).getConstructor().newInstance();

		return javaConstraint;
	}

	@Override
	public boolean checkModelConstraint(Model model, ExtendibleElementConstraint constraint, MIDLevel constraintLevel)
	                                   throws Exception {
		var javaClassName = constraint.getImplementation();
		var modelTypeUri = (constraintLevel == MIDLevel.INSTANCES) ?
			((Model) constraint.eContainer()).getMetatypeUri() :
			((Model) constraint.eContainer()).getUri();
		var javaConstraint = (IJavaModelConstraint) this.getJavaConstraint(javaClassName, modelTypeUri);

		return javaConstraint.check(model);
	}

	private IJavaOperatorConstraint getOperatorConstraint(ExtendibleElementConstraint constraint) throws Exception {
		var javaClassName = constraint.getImplementation();
		var operatorTypeUri = ((Operator) constraint.eContainer()).getUri();
		var javaConstraint = (IJavaOperatorConstraint) this.getJavaConstraint(javaClassName, operatorTypeUri);

		return javaConstraint;
	}

	@Override
	public boolean checkOperatorGenericConstraint(ExtendibleElementConstraint constraint,
	                                              GenericEndpoint genericTypeEndpoint,
	                                              GenericElement genericType, List<OperatorInput> inputs)
	                                             throws Exception {
		var javaConstraint = this.getOperatorConstraint(constraint);

		return javaConstraint.checkGeneric(genericTypeEndpoint, genericType, inputs);
	}

	@Override
	public boolean checkOperatorInputConstraint(ExtendibleElementConstraint constraint, Map<String, Model> inputsByName)
	                                           throws Exception {
			var javaConstraint = this.getOperatorConstraint(constraint);

			return javaConstraint.checkInputs(inputsByName);
	}

	@Override
	public Map<ModelRel, List<Model>> getOperatorOutputConstraints(ExtendibleElementConstraint constraint,
	                                                               Map<String, GenericElement> genericsByName,
	                                                               Map<String, Model> inputsByName,
	                                                               Map<String, Model> outputsByName) throws Exception {
			var javaConstraint = this.getOperatorConstraint(constraint);

			return javaConstraint.getOutputModelRelEndpoints(genericsByName, inputsByName, outputsByName);
	}

}
