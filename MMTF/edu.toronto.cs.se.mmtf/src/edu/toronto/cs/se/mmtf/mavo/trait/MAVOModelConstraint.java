/**
 * Copyright (c) 2013 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay, Vivien Suen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.mmtf.mavo.trait;

import org.eclipse.emf.ecore.EObject;

import edu.toronto.cs.se.mmtf.mavo.MAVOModel;
import edu.toronto.cs.se.mmtf.mid.Model;
import edu.toronto.cs.se.mmtf.mid.trait.MultiModelTypeIntrospection;
import edu.toronto.cs.se.mmtf.repository.JavaModelConstraint;

public class MAVOModelConstraint extends JavaModelConstraint {

	public MAVOModelConstraint(Model model) {

		super(model);
	}

	@Override
	public boolean validate() {

		EObject rootModelObj = MultiModelTypeIntrospection.getRoot(model);
		if (
			rootModelObj instanceof MAVOModel || (
				rootModelObj instanceof org.eclipse.uml2.uml.Model &&
				((org.eclipse.uml2.uml.Model) rootModelObj).getAppliedStereotype(MAVOUtils.UML_MAVOMODEL_STEREOTYPE) != null
			)
		) {
			return true;
		}

		return false;
	}

}
