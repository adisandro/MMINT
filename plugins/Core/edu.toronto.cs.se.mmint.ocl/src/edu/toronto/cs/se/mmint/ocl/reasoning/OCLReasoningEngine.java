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
package edu.toronto.cs.se.mmint.ocl.reasoning;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.OCLHelper;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.ocl.pivot.values.SetValue;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MIDLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.reasoning.IReasoningEngine;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;

public class OCLReasoningEngine implements IReasoningEngine {

	protected final static String OCL_MODELENDPOINT_VARIABLE = "$ENDPOINT_";
	protected final static char OCL_VARIABLE_SEPARATOR = '.';

	protected EObject getConstraintContext(Model model, String oclConstraint, MIDLevel constraintLevel) throws MMINTException {

		//TODO MMINT[CONSTRAINT] find language to express more complex contraints on model rels
		boolean isInstancesLevel = model.isInstancesLevel();
		EObject modelObj = null;
		if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
			String modelEndpointConstraintName = oclConstraint.substring(OCL_MODELENDPOINT_VARIABLE.length(), oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR));
			for (ModelEndpointReference modelEndpointRef : ((ModelRel) model).getModelEndpointRefs()) {
				//TODO MMINT[ENDPOINT] consider overridden endpoints here
				String modelEndpointName = (isInstancesLevel && constraintLevel != MIDLevel.INSTANCES) ?
					modelEndpointRef.getObject().getMetatype().getName() :
					modelEndpointRef.getObject().getName();
				if (modelEndpointConstraintName.equals(modelEndpointName)) {
					modelObj = (isInstancesLevel) ?
						modelEndpointRef.getObject().getTarget().getEMFInstanceRoot() :
						modelEndpointRef.getObject().getTarget().getEMFTypeRoot();
					break;
				}
			}
			if (modelObj == null) {
				throw new MMINTException("Can't find model endpoint " + modelEndpointConstraintName + " used in model relationship constraint");
			}
		}
		else {
			modelObj = (isInstancesLevel) ?
				model.getEMFInstanceRoot() :
				model.getEMFTypeRoot();
		}

		return modelObj;
	}

	@Override
	public boolean checkModelConstraint(@NonNull Model model, @NonNull ExtendibleElementConstraint constraint, @NonNull MIDLevel constraintLevel) {

		String oclConstraint = constraint.getImplementation();
		try {
			EObject modelObj = getConstraintContext(model, oclConstraint, constraintLevel);
			if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
				oclConstraint = oclConstraint.substring(oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR) + 1, oclConstraint.length());
			}
			return checkConstraint(modelObj, oclConstraint);
		}
		catch (MMINTException e) {
			MMINTException.print(IStatus.ERROR, "Can't get context for OCL constraint \"" + constraint + "\" applied to model " + model + " , evaluating to false", e);
			return false;
		}
	}

	public boolean checkConstraint(EObject modelObj, String oclConstraint) {

		OCL ocl = OCL.newInstance();

		try {
			OCLHelper helper = ocl.createOCLHelper(modelObj.eClass());
			ExpressionInOCL expression = helper.createInvariant(oclConstraint);
			return ocl.check(modelObj, expression);
		}
		catch (Exception e) {
			MMINTException.print(IStatus.WARNING, "Error in OCL constraint \"" + oclConstraint + "\" applied to model object " + modelObj + ", evaluating to false", e);
			return false;
		}
		finally {
			ocl.dispose();
		}
	}

	@Override
	public @Nullable Object evaluateQuery(EObject context, String oclQuery) {

		OCL ocl = OCL.newInstance();

		try {
			OCLHelper helper = ocl.createOCLHelper(context.eClass());
			ExpressionInOCL expression = helper.createQuery(oclQuery);
			Object evaluation = ocl.evaluate(context, expression);
			if (evaluation instanceof CollectionValue.Accumulator) {
				evaluation = ((CollectionValue.Accumulator) evaluation).getElements();
			}
			if (evaluation instanceof SetValue) {
				evaluation = ((SetValue) evaluation).getElements();
			}
			if (evaluation instanceof OrderedSetValue) {
				evaluation = ((OrderedSetValue) evaluation).getElements();
			}
			return evaluation;
		}
		catch (Exception e) {
			MMINTException.print(IStatus.ERROR, "OCL query error: " + oclQuery, e);
			return null;
		}
	}

}
