/**
 * Copyright (c) 2012-2020 Marsha Chechik, Alessio Di Sandro, Michalis Famelis,
 * Rick Salay.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alessio Di Sandro - Implementation.
 */
package edu.toronto.cs.se.modelepedia.safetycase.operator;

import edu.toronto.cs.se.mmint.mid.operator.impl.WorkflowOperatorImpl;
import edu.toronto.cs.se.mmint.operator.slice.SafetySlice.Constraint;

/**
 * Defaults to using GSNSlice.mid as the implementation.
 */
public class GSNSlice extends WorkflowOperatorImpl {
  public static class SafetySliceConstraint extends Constraint {
    // necessary because we can't inherit from SafetySlice too
  }
}
