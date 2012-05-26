/*
 * Copyright (c) 2012 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mid.trait;

import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.MultiModel;

/**
 * The constraint checker for multimodels.
 * 
 * @author alessio
 *
 */
public class MultiModelConstraintChecker {

	/**
	 * Checks if the multimodel is a TYPES multimodel or an INSTANCES
	 * multimodel.
	 * 
	 * @param multiModel
	 *            The multimodel to be checked.
	 * @return True for INSTANCES level, false for TYPES level.
	 */
	public static boolean isInstanceLevel(MultiModel multiModel) {

		if (multiModel.getLevel() == MidLevel.TYPES) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if an OCL constraint is satisfied on a model.
	 * 
	 * @param model
	 *            The model.
	 * @param oclConstraint
	 *            The OCL constraint.
	 * @return True if the OCL constraint is satisfied, false otherwise.
	 */
	public static boolean checkOCLConstraint(Model model, String oclConstraint) {

		//TODO MMTF: get model root, run ocl engine, return result
		return true;
	}

}
