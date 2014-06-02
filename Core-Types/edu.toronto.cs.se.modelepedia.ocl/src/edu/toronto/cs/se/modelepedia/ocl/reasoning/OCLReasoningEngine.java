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
package edu.toronto.cs.se.modelepedia.ocl.reasoning;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.domain.values.CollectionValue;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.OCL;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.ecore.Ecore2Pivot;
import org.eclipse.ocl.examples.pivot.helper.OCLHelper;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

import edu.toronto.cs.se.mmint.MMINTException;
import edu.toronto.cs.se.mmint.mid.ExtendibleElementConstraint;
import edu.toronto.cs.se.mmint.mid.MidLevel;
import edu.toronto.cs.se.mmint.mid.Model;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker;
import edu.toronto.cs.se.mmint.mid.constraint.MultiModelConstraintChecker.MAVOTruthValue;
import edu.toronto.cs.se.mmint.mid.relationship.ModelEndpointReference;
import edu.toronto.cs.se.mmint.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmint.reasoning.IReasoningEngine;

public class OCLReasoningEngine implements IReasoningEngine {

	protected final static String OCL_MODELENDPOINT_VARIABLE = "$ENDPOINT_";
	protected final static char OCL_VARIABLE_SEPARATOR = '.';

	private void initOCL(OCLHelper helper, EObject modelObj) {

		//TODO MMINT: workaround for bug #375485
//		helper.setInstanceContext(modelObj);
		MetaModelManager metaModelManager = helper.getOCL().getMetaModelManager();
		EClass modelObjClass = modelObj.eClass();
		Resource resource = modelObjClass.eResource();
		Ecore2Pivot ecore2Pivot = Ecore2Pivot.getAdapter(resource, metaModelManager);
		Type pivotType = ecore2Pivot.getCreated(Type.class, modelObjClass);
		helper.setContext(pivotType);
	}

	protected EObject getConstraintContext(Model model, String oclConstraint, MidLevel constraintLevel) throws MMINTException {

		//TODO MMINT[CONSTRAINT] find language to express more complex contraints on model rels
		boolean isInstancesLevel = MultiModelConstraintChecker.isInstancesLevel(model);
		EObject modelObj = null;
		if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
			String modelEndpointConstraintName = oclConstraint.substring(OCL_MODELENDPOINT_VARIABLE.length(), oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR));
			for (ModelEndpointReference modelEndpointRef : ((ModelRel) model).getModelEndpointRefs()) {
				//TODO MMINT[ENDPOINT] consider overridden endpoints here
				String modelEndpointName = (isInstancesLevel && constraintLevel != MidLevel.INSTANCES) ?
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
	public MAVOTruthValue checkConstraint(Model model, ExtendibleElementConstraint constraint, MidLevel constraintLevel) {

		String oclConstraint = constraint.getImplementation();
		try {
			EObject modelObj = getConstraintContext(model, oclConstraint, constraintLevel);
			if (model instanceof ModelRel && oclConstraint.startsWith(OCL_MODELENDPOINT_VARIABLE)) {
				oclConstraint = oclConstraint.substring(oclConstraint.indexOf(OCL_VARIABLE_SEPARATOR) + 1, oclConstraint.length());
			}
			return checkConstraint(modelObj, oclConstraint);
		}
		catch (MMINTException e) {
			MMINTException.print(MMINTException.Type.ERROR, "Can't get context for OCL constraint, evaluating to false", e);
			return MAVOTruthValue.FALSE;
		}
	}

	@Override
	public boolean checkConstraintConsistency(Model modelType, String constraint) {

		return true;
	}

	public MAVOTruthValue checkConstraint(EObject modelObj, String oclConstraint) {

		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper();
		initOCL(helper, modelObj);

		try {
			ExpressionInOCL expression = helper.createInvariant(oclConstraint);
			return (ocl.check(modelObj, expression)) ? MAVOTruthValue.TRUE : MAVOTruthValue.FALSE;
		}
		catch (Exception e) {
			MMINTException.print(MMINTException.Type.WARNING, "OCL constraint error, evaluating to false: " + oclConstraint, e);
			return MAVOTruthValue.FALSE;
		}
	}

	public Object evaluateQuery(EObject modelObj, String oclConstraint) {

		OCL ocl = OCL.newInstance();
		OCLHelper helper = ocl.createOCLHelper();
		initOCL(helper, modelObj);

		try {
			ExpressionInOCL expression = helper.createQuery(oclConstraint);
			Object evaluation = ocl.evaluate(modelObj, expression);
			if (evaluation instanceof CollectionValue.Accumulator) {
				evaluation = ((CollectionValue.Accumulator) evaluation).getElements();
			}
			return evaluation;
		}
		catch (Exception e) {
			MMINTException.print(MMINTException.Type.ERROR, "OCL derivation error: " + oclConstraint, e);
			return null;
		}
	}

}
