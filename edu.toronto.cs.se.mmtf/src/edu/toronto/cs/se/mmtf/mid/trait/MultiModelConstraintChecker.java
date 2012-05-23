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
import edu.toronto.cs.se.mmtf.mid.MultiModel;

/**
 * The constraint checker for multimodels.
 * 
 * @author alessio
 *
 */
public class MultiModelConstraintChecker {

	public static boolean canExecute(MultiModel multimodel) {

		if (multimodel.getLevel() == MidLevel.TYPES) {
			return false;
		}
		return true;
	}

}
