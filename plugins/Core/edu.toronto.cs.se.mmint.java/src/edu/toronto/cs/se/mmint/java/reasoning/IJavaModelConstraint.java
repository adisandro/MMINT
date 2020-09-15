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

import edu.toronto.cs.se.mmint.mid.Model;

/**
 * The specification of a model constraint written in Java.
 *
 * @author Alessio Di Sandro
 */
public interface IJavaModelConstraint {

  /**
   * Checks this model constraint.
   *
   * @param model
   *          The model to check against.
   * @return True if the constraint is satisfied, false otherwise.
   */
	boolean check(Model model);
}
