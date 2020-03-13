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
package edu.toronto.cs.se.mmint.operator.mid.match;

import edu.toronto.cs.se.mmint.mid.operator.impl.WorkflowOperatorImpl;

/**
 * Defaults to using MIDMatch.mid as the implementation.
 * TODO MMINT[MIDREL] Make MIDRel a subtype of both ModelRel and MID
 * TODO MMINT[MIDREL] Inherit properly from Match
 */
public class MIDMatch extends WorkflowOperatorImpl {

    @Override
    public boolean isCommutative() {

        return true;
    }

}
