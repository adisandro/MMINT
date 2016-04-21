/**
 * Copyright (c) 2012-2016 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.uml.constraint;

import edu.toronto.cs.se.mmint.mid.Model;

public class UMLClassDiagramModelConstraint extends UMLModelConstraint {

	@Override
	public boolean validate(Model model) {

		return super.validate(model, UMLModelConstraint.UML_CLASSDIAGRAM_TYPE);
	}

}
