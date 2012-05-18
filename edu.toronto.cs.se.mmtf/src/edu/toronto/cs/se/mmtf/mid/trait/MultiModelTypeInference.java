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

import edu.toronto.cs.se.mmtf.MMTF.MMTFRegistry;
import edu.toronto.cs.se.mmtf.mid.MidLevel;
import edu.toronto.cs.se.mmtf.mid.TypedElement;
import edu.toronto.cs.se.mmtf.mid.relationship.ModelRel;
import edu.toronto.cs.se.mmtf.repository.MMTFExtensionPoints;

/**
 * The type inference engine for multimodels.
 * 
 * @author Alessio Di Sandro
 * 
 */
public class MultiModelTypeInference implements MMTFExtensionPoints {

	public static TypedElement inferType(TypedElement element) {

		if (element.getLevel() == MidLevel.TYPES) {
			return null;
		}

		// TODO MMTF: implement repository traversal before fallback to root types
		if (element instanceof ModelRel) {
			return MMTFRegistry.getExtendibleElement(ROOT_RELATIONSHIP_URI);
		}
		// base case instanceof Model
		return MMTFRegistry.getExtendibleElement(ROOT_MODEL_URI);
	}

}
